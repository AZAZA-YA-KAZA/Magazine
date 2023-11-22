package com.example.lifecicle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lifecicle.databinding.ActivityMainBinding;
import com.example.lifecicle.databinding.ElementsBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ElementsBinding binding;
    protected ArrayList<String> products = new ArrayList<>();
    protected int q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ElementsBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        binding.ET.setVisibility(View.GONE);
        binding.RB1.setVisibility(View.GONE);
        binding.RB2.setVisibility(View.GONE);
        binding.BT.setVisibility(View.GONE);
        binding.TV1.setBackgroundResource(R.drawable.text_border);
        binding.TV1.setText("Магазин молочных продуктов");

        binding.TV2.setText("•_ Какие продукты соберём в корзину? _•");

        binding.CB1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    products.remove("молоко");
                }
                else{
                    products.add("молоко");
                }
                updateProductList();
                nal();
            }
        });

        binding.CB2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    products.remove("кефир");
                }
                else{
                    products.add("кефир");
                }
                updateProductList();
                nal();
            }
        });

        binding.CB3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    products.remove("яйца");
                }
                else{
                    products.add("яйца");
                }
                updateProductList();
                nal();
            }
        });

        binding.CB4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    products.remove("сметана");
                }
                else{
                    products.add("сметана");
                }
                updateProductList();
                nal();
            }
        });

        binding.CB5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    products.remove("сыр");
                }
                else{
                    products.add("сыр");
                }
                updateProductList();
                nal();
            }
        });

/*        Toast.makeText(this, "Create", Toast.LENGTH_SHORT).show();*/
    }
    private void updateProductList() {
        if (!products.isEmpty()) {
            StringBuilder productListText = new StringBuilder("Вы собрали: ");
            for (String product : products) {
                productListText.append(product + " ");
            }
            binding.TV3.setText(productListText.toString());
        }
        else{

            binding.TV3.setText("Корзина пуста(");
        }
    }

    private void nal(){
        if (!products.isEmpty()) {
            binding.TV4.setText("Корзина собрана! Выберите способ доставки");
            binding.RB1.setVisibility(View.VISIBLE);
            binding.RB2.setVisibility(View.VISIBLE);
            binding.RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (R.id.RB1 == checkedId) {
                        q = 1;
                        binding.BT.setVisibility(View.VISIBLE);
                        binding.ET.setVisibility(View.GONE);
                    } else if (R.id.RB2 == checkedId) {
                        q = 2;
                        binding.BT.setVisibility(View.VISIBLE);
                        binding.ET.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
        else{
            binding.TV4.setText("");
            binding.RB1.setChecked(false);
            binding.RB2.setChecked(false);
            binding.RB1.setVisibility(View.GONE);
            binding.RB2.setVisibility(View.GONE);
            binding.BT.setVisibility(View.GONE);
            binding.ET.setVisibility(View.GONE);
        }
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Создайте Intent для запуска CongratulationsActivity
                Intent intent = new Intent(MainActivity.this, Activ.class);
                intent.putExtra("q", q); // передача значения q
                intent.putExtra("products", products);
                startActivity(intent);
            }
        });

    }

/*    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Resume", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destroy", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Restart", Toast.LENGTH_SHORT).show();

    }*/
}
