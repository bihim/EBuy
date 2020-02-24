package com.bihim.ebuy.SplashScreenAndWelcomePage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.bihim.ebuy.MainActivity;
import com.bihim.ebuy.R;
import com.bihim.ebuy.SignInandSignUp.SignActivity;
import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderPage;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends OnboarderActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        OnboarderPage onboarderPageShop = new OnboarderPage("Shop","Select from different shops.\nThe freedom is yours!", R.drawable.ic_shopping_ebuy);
        OnboarderPage onboarderPageCart = new OnboarderPage("Buy","Search among 1 million products.\nThe choice is yours!", R.drawable.ic_shopping_cart_ebuy);
        OnboarderPage onboarderPageTruck = new OnboarderPage("Fast","Super fast delivery.\nRight at your door!", R.drawable.ic_truck_ebuy);

        onboarderPageShop.setBackgroundColor(R.color.splashscreen);
        onboarderPageShop.setTitleColor(R.color.intro_shop);
        onboarderPageShop.setDescriptionColor(R.color.white);

        onboarderPageCart.setBackgroundColor(R.color.splashscreen);
        onboarderPageCart.setTitleColor(R.color.intro_cart);
        onboarderPageCart.setDescriptionColor(R.color.white);

        onboarderPageTruck.setBackgroundColor(R.color.splashscreen);
        onboarderPageTruck.setTitleColor(R.color.intro_truck);
        onboarderPageTruck.setDescriptionColor(R.color.white);

        setSkipButtonTitle("Skip");
        setFinishButtonTitle("Finish");

        List<OnboarderPage> pages = new ArrayList<>();

        pages.add(onboarderPageShop);
        pages.add(onboarderPageCart);
        pages.add(onboarderPageTruck);

        setOnboardPagesReady(pages);


    }

    @Override
    public void onFinishButtonPressed()
    {
       // Toast.makeText(this, "Finished", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, SignActivity.class));
        finish();
    }

    @Override
    protected void onSkipButtonPressed() {
        super.onSkipButtonPressed();
        //Toast.makeText(this, "Pressed skip", Toast.LENGTH_SHORT).show();
    }
}
