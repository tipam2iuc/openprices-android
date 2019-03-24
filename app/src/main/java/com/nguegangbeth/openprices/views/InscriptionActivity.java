package com.nguegangbeth.openprices.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.gson.Gson;
import com.nguegangbeth.openprices.R;
import com.nguegangbeth.openprices.modeles.Role;
import com.nguegangbeth.openprices.modeles.users;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import okhttp3.*;


public class InscriptionActivity extends AppCompatActivity {

    private static final String WS_URL = "http://192.168.137.1/openprice/userINSERT";
    public static final MediaType MEDIA_TYPE = MediaType.parse("application/json");
    private Button button_facebook;
    private ImageButton button_google;
    private static final int RC_SIGN_IN = 0;
    FirebaseAuth.AuthStateListener mAuthListener;
    GoogleApiClient mGoogleApiClient;
    FirebaseAuth mAuth;
    private CheckBox checkBox_motPasse;
    private EditText editText_nom;
    private EditText editText_email;
    private EditText editText_motpsse;
    private EditText editText_confirmmotpasse;
    private Button button_creer_inscription;

    private Button listuser;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if(StartActShow()){
            startActivity(new Intent(InscriptionActivity.this, BottomNavigatorActivity.class));
        }*/
        setContentView(R.layout.activity_inscription);
        button_google = (ImageButton)findViewById(R.id.button_google);
        checkBox_motPasse = (CheckBox)findViewById(R.id.checkbox_affichermotdepase_inscription);
        editText_confirmmotpasse = (EditText)findViewById(R.id.editextView_confirmmotPasse_inscription);
        editText_email = (EditText)findViewById(R.id.editextView_email_inscription);
        editText_motpsse = (EditText)findViewById(R.id.editextView_motPasse_inscription);
        editText_nom = (EditText)findViewById(R.id.editextView_nomutilisateur_inscription);
        button_creer_inscription = (Button)findViewById(R.id.button_creer_inscription);


        listuser = (Button)findViewById(R.id.button_listUser);
        listuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InscriptionActivity.this, UserListActivity.class);
                startActivity(intent);
            }
        });

        button_creer_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date= Calendar.getInstance().getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                users users = new users(editText_nom.getText().toString(), editText_email.getText().toString(), editText_motpsse.getText().toString(),
                        null,sdf.format(date),2);

                try {
                    AddUser(users);
                    Log.i("save","Save done");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.i("error","exception");
                }
            }
        });

        final int value = editText_confirmmotpasse.getInputType();

        checkBox_motPasse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editText_confirmmotpasse.setInputType(8);
                    editText_motpsse.setInputType(8);
                }else {
                    editText_confirmmotpasse.setInputType(value);
                    editText_motpsse.setInputType(value);
                }
            }
        });
        //Init();
        mAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);



        button_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signIn();
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() != null ){
                    startActivity(new Intent(InscriptionActivity.this, BottomNavigatorActivity.class));
                    //SavePreferences();
                    finish();
                }
            }
        };


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        //2EcouteTextViewPasser();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                    }
                } /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

    }

    private boolean StartActShow(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        return sharedPreferences.getBoolean("AlreadyOpenIntro", false);
    }

    private void SavePreferences(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("AlreadyOpenIntro", true);
        editor.apply();
        editor.commit();
    }


    /**

     * Jointure des boutons a mes membres
     */
    // Configure Google Sign In
    /*GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build();*/

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            } else {
                // Google Sign In failed, update UI appropriately
                // ...
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithCredential:failure", task.getException());
                            Toast.makeText(InscriptionActivity.this, "Echec lors de l'Authentification.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }


    public void AddUser(users m) throws IOException {

        final OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        String jsonInString = gson.toJson(m);

        RequestBody body = RequestBody.create(MEDIA_TYPE,
                jsonInString);

        final Request request = new Request.Builder()
                .url(WS_URL)
                .post(body)
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("notsave",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //le retour est effectué dans un thread différent
                final String text = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(InscriptionActivity.this, text, Toast.LENGTH_SHORT).show();

                    }
                });
            }


            public void onFailure(Request request, IOException e) {
                String mMessage = e.getMessage().toString();

                Toast.makeText(InscriptionActivity.this, mMessage, Toast.LENGTH_SHORT).show();


            }


        });


    }



    /*private void Init(){
        button_facebook = (Button)findViewById(R.id.button_facebook);
        button_google = (Button)findViewById(R.id.button_google);
        checkBox_terme = (CheckBox)findViewById(R.id.checkBox_terme);
        textView_passer = (TextView) findViewById(R.id.textView_passer);
    }*/

    /**
     * text permettant de passer l'inscription ou la connexion
     * utiliser par ceux qui ne veulent pas etre connecte
     */
    /*private void EcouteTextViewPasser(){
        textView_passer.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(InscriptionActivity.this, User_no_connectActivity.class);
                startActivity(intent);
            }
        });
    }*/
}
