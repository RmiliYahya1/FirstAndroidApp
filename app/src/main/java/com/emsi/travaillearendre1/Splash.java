package com.emsi.travaillearendre1;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.BaseTransientBottomBar;

public class Splash extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.image);

        Thread thread1=new Thread(){
            @Override
            public void run() {
                TranslateAnimation translateAnimation=new TranslateAnimation(-500,0,0,imageView.getHeight());
                translateAnimation.setDuration(1000);
                translateAnimation.setFillAfter(true);
                imageView.startAnimation(translateAnimation);
            }
        };

        Thread thread2=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    RotateAnimation rotateAnimation =new RotateAnimation(0,360, RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                    rotateAnimation.setDuration(5000);
                    imageView.startAnimation(rotateAnimation);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };


       Thread thread = new Thread(){
           @Override
           public void run() {
               try {
                   sleep(5000);
                   Intent intent = new Intent(Splash.this,MainActivity.class);
                   startActivity(intent);
                   finish();
               }catch (Exception e){
       }
    }
};
       thread1.start();
       thread2.start();
       thread.start();
    }
}