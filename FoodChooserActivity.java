package com.example.foodlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FoodChooserActivity extends AppCompatActivity {
    public static final String KEY_FOOD_CHOICE ="food_Choice" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_chooser);
    }
}