package com.example.foodlist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    public static final int TEXT_REQUEST = 1;
    private TextView textViewFoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Inside the onCreate  method");

        textViewFoodList = findViewById(R.id.textView_food_list);
        Log.d(TAG, "end of the onCreate  method");
    }

    public void LaunchFoodChooserList(View view) {
        Log.d(TAG, "Inside the LaunchFoodChooserList  method");

        Intent intentFoocChooser = new Intent(this, FoodChooserActivity.class);
        startActivityForResult(intentFoocChooser,TEXT_REQUEST);


        Log.d(TAG, "end of the LaunchFoodChooserList  method");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == TEXT_REQUEST){
            String foodChoosen = data.getStringExtra(FoodChooserActivity.KEY_FOOD_CHOICE);
            if(textViewFoodList.getText().equals(getString(R.string.no_food_choosen_yet))){

                textViewFoodList.setText(foodChoosen +"\n");

            }else {
                textViewFoodList.append(foodChoosen +"\n");
            }
        }else {
            Log.d(TAG,"there is a problem");
        }
    }
}