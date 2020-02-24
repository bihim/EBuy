package com.bihim.ebuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import ir.apend.slider.model.Slide;
import ir.apend.slider.ui.Slider;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.slider_main)
    Slider slider;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final List<Slide> sliderList = new ArrayList<>();

        sliderList.add(new Slide(0, "https://images.pexels.com/photos/1124465/pexels-photo-1124465.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260", getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        sliderList.add(new Slide(1, "https://images.pexels.com/photos/1619652/pexels-photo-1619652.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940", getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        sliderList.add(new Slide(2, "https://images.pexels.com/photos/4957/person-woman-hand-smartphone.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940", getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        sliderList.add(new Slide(3, "https://images.pexels.com/photos/2520829/pexels-photo-2520829.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940", getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));

        slider.setItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                Slide slide = sliderList.get(position);

                Toasty.normal(MainActivity.this, String.valueOf(slide.getId()),Toasty.LENGTH_SHORT).show();
            }
        });

        slider.addSlides(sliderList);



    }
}
