package com.bihim.ebuy.SplashScreenAndWelcomePage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bihim.ebuy.MainActivity;
import com.bihim.ebuy.SignInandSignUp.SignActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity
{

    Timer timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run()
            {

                SharedPreferences sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
                boolean firstStart = sharedPreferences.getBoolean("firstStart", true);

                if (firstStart)
                {
                    startActivity(new Intent(SplashScreen.this, WelcomeActivity.class));
                    show();
                    finish();
                }
                else
                {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }

            }
        }, 1000);


    }

    private void show()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }

}
