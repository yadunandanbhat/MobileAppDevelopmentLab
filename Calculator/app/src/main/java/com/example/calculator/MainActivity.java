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

    // This binding function helps us to refer to the widgets directly instead of finding them by findViewById()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private double valueOne;
    private double valueTwo;

    // This is used to format the output to 3 decimal points
    private static DecimalFormat REAL_FORMATTER = new DecimalFormat("0.###");

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    // Addition function
    public void add(View view) {
        CURRENT_ACTION = ADDITION;
        computeCalculation();
        return;
    }

    // Subtraction function
    public void sub(View view) {
        CURRENT_ACTION = SUBTRACTION;
        computeCalculation();
        return;
    }

    // Multiplication function
    public void mul(View view) {
        CURRENT_ACTION = MULTIPLICATION;
        computeCalculation();
        return;
    }

    // Divison function
    public void div(View view) {
        CURRENT_ACTION = DIVISION;
        computeCalculation();
        return;
    }

    // This compute function is used to calculate the output and print the output
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