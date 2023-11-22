package com.example.lifecicle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lifecicle.databinding.ActivityCongratulationsBinding;
import com.example.lifecicle.databinding.ElementsBinding;

import java.util.ArrayList;

public class Activ extends MainActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCongratulationsBinding activityCongratulationsBinding;
        setContentView(R.layout.activity_congratulations);
        activityCongratulationsBinding = ActivityCongratulationsBinding.inflate(getLayoutInflater());
        setContentView(activityCongratulationsBinding.getRoot());
        int q = getIntent().getIntExtra("q", 0);
        ArrayList <String> products = getIntent().getStringArrayListExtra("products");
        if (q == 1){
            StringBuilder w = new StringBuilder("Вы собрали: ");
            for (String product : products) {
                w.append(product).append(" ");
            }
            w.append("\nОжидайте доставку");
            activityCongratulationsBinding.TV5.setText("Товары готовы к выдаче. Ждём вас в нашем магазине!");
        }
        else {
            StringBuilder w = new StringBuilder("Вы собрали: ");
            for (String product : products) {
                w.append(product).append(" ");
            }
            w.append("\nОжидайте доставку");
            activityCongratulationsBinding.TV5.setText(w.toString());
        }
    }
}
