package com.nguegangbeth.openprices.views;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nguegangbeth.openprices.R;

public class DescriptionActivity extends AppCompatActivity {

    private Button button_retour;
    private Button button_suivant;


    private ViewPager viewPager_slide;
    private LinearLayout dots_layout;

    private TextView[] Dots;
    private int CurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("DescriptionActivity::onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Init();


        Slide_Adapter slide_adapter = new Slide_Adapter(this);
        viewPager_slide.setAdapter(slide_adapter);
        AddDotsIndicator(0);

        viewPager_slide.addOnPageChangeListener(viewListener);

        /**
         * Clic sur les boutons
         */
        button_suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((CurrentPage +1 ) == 3){
                    Intent intent = new Intent(DescriptionActivity.this, ChoixConnexionActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    viewPager_slide.setCurrentItem(CurrentPage + 1);
                }
            }
        });

        button_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager_slide.setCurrentItem(CurrentPage - 1);
            }
        });
    }

    /**
     * Initialisation de mes ...
     */
    private void Init(){
        /*button_continue = (Button)findViewById(R.id.button_continue);
        textView_welcome = (TextView)findViewById(R.id.textView_welcome);*/
        viewPager_slide = (ViewPager)findViewById(R.id.viewPager_slide);
        dots_layout = (LinearLayout) findViewById(R.id.dots_layout);
        button_retour = (Button)findViewById(R.id.button_retour);
        button_suivant = (Button)findViewById(R.id.button_suivant);
    }

    /**
     * Recupere la position de la page actuelle pour pouvoir connaitre la couleur a affecter dans les trois petits bouton
     * de slide
     * @param position
     */
    public void AddDotsIndicator(int position){

        Dots = new TextView[3];
        dots_layout.removeAllViews();
        for(int i = 0; i < Dots.length;i++){
            Dots[i] = new TextView(this);
            Dots[i].setText(Html.fromHtml("&#8226;"));
            Dots[i].setTextSize(35);
            Dots[i].setTextColor(getResources().getColor(R.color.head));

            dots_layout.addView(Dots[i]);
        }

        if(Dots.length > 0){
            Dots[position].setTextColor(getResources().getColor(R.color.violetFonce));
        }
    }

    /**
     * Defini le texte qui sera affiche sur mes boutons en fonction du numero de page
     */
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            AddDotsIndicator(i);
            CurrentPage = i;

            if(i == 0){
                button_suivant.setEnabled(true);
                button_retour.setEnabled(false);
                button_retour.setVisibility(View.INVISIBLE);

                button_suivant.setText("Suivant");
                button_retour.setText("");
            }else if(i == Dots.length - 1){
                button_suivant.setEnabled(true);
                button_retour.setEnabled(true);
                button_retour.setVisibility(View.VISIBLE);

                button_suivant.setText("Terminer");
                button_retour.setText("Retour");
            }else{
                button_suivant.setEnabled(true);
                button_retour.setEnabled(true);
                button_retour.setVisibility(View.VISIBLE);

                button_suivant.setText("Suivant");
                button_retour.setText("Retour");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    @Override
    public void onDestroy() {
        System.out.println("DescriptionActivity::onDestroy");
        super.onDestroy();
    }

    @Override
    public void onStop() {
        System.out.println("DescriptionActivity::onStop");
        super.onStop();
    }

    @Override
    public void onResume() {
        System.out.println("DescriptionActivity::onResume");
        super.onResume();
    }

    @Override
    public void onRestart() {
        System.out.println("DescriptionActivity::onRestart");
        super.onRestart();
    }
}
