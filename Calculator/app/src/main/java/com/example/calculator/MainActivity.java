package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.calculator.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private double valueOne;
    private double valueTwo;

    private static DecimalFormat REAL_FORMATTER = new DecimalFormat("0.###");

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    public void add(View view) {
        CURRENT_ACTION = ADDITION;
        computeCalculation();
        return;
    }

    public void sub(View view) {
        CURRENT_ACTION = SUBTRACTION;
        computeCalculation();
        return;
    }

    public void mul(View view) {
        CURRENT_ACTION = MULTIPLICATION;
        computeCalculation();
        return;
    }

    public void div(View view) {
        CURRENT_ACTION = DIVISION;
        computeCalculation();
        return;
    }

    private void computeCalculation() {
        valueOne = Double.parseDouble(binding.editTextNumberDecimal2.getText().toString());
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.editTextNumberDecimal3.getText().toString());

            if (CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if (CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        } else {
            try {
                valueOne = Double.parseDouble(binding.editTextNumberDecimal3.getText().toString());
            } catch (Exception e) {
            }
        }
        binding.textView.setText(REAL_FORMATTER.format(valueOne));
    }
}