package com.nguegangbeth.openprices.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nguegangbeth.openprices.R;

public class Slide_Adapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public Slide_Adapter(Context context){
        this.context = context;
    }

    //Array
    public int[] slide_image = {
            R.drawable.logos,
            R.drawable.logos,
            R.drawable.logos
    };

    public String[] slide_heading = {
        "GREETING",
        "OPTION",
        "INFORMATION"
    };

    public String[] slide_desc = {
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                    "\t\ttempor incididunt ut labore et dolore magna aliqua",
            "Des options de l'applet ",
            "Quelques informations de l'application importantes..."
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slide_ImageViews = (ImageView) view.findViewById(R.id.imageView_slide);
        TextView slide_Headings = (TextView) view.findViewById(R.id.textView_slide_heading);
        TextView slide_descriptions = (TextView)view.findViewById(R.id.textView_slide_description);

        slide_ImageViews.setImageResource(slide_image[position]);
        slide_Headings.setText(slide_heading[position]);
        slide_descriptions.setText(slide_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
