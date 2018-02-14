package com.example.eatitapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import info.hoang8f.widget.FButton;
import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {
    FancyButton btnSignin, btnSignup;
    TextView txtSlogan;
    private ImageView imageView;
    long animationDuration = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        handleAnimation(imageView);
        btnSignin = (FancyButton) findViewById(R.id.btnSignin);
        btnSignup = (FancyButton) findViewById(R.id.btnSignup);
        txtSlogan = (TextView)findViewById(R.id.textSlogn1);
        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/Fonty.ttf");
        txtSlogan.setTypeface(face);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent SignUp = new Intent(MainActivity.this, SignUp.class);
                handleAnimation(imageView);
                startActivity(SignUp);
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(MainActivity.this, signin.class);
                handleAnimation(imageView);
                startActivity(signIn);
            }
        });
    }

    public void handleAnimation(View view){
        ObjectAnimator rotateAnimation = ObjectAnimator.ofFloat(imageView,"rotation",0f,360f);
        rotateAnimation.setDuration(animationDuration);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(rotateAnimation);
        animatorSet.start();
    }
}
