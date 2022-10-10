package com.makoval.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String calc(String textCalcScreen) {
        String[] operands;
        String stringResult = null;
        if (textCalcScreen.contains("*")) {
            operands = textCalcScreen.split("\\*");
            int result = Integer.parseInt(operands[0]) * Integer.parseInt(operands[1]);
            stringResult = String.valueOf(result);
            
        }
        if (textCalcScreen.contains("/")) {
            operands = textCalcScreen.split("/");
            double result = Double.parseDouble(operands[0]) / Double.parseDouble(operands[1]);
            stringResult = String.valueOf(result);
        }
        if (textCalcScreen.contains("+")) {
            operands = textCalcScreen.split("\\+");
            int result = Integer.parseInt(operands[0]) + Integer.parseInt(operands[1]);
            stringResult = String.valueOf(result);
        }
        if (textCalcScreen.contains("-")) {
            operands = textCalcScreen.split("-");
            int result = Integer.parseInt(operands[0]) - Integer.parseInt(operands[1]);
            stringResult = String.valueOf(result);
        }
        return stringResult;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView calcScreen = (TextView) findViewById(R.id.calc_screen);
        Button buttonOne = (Button) findViewById(R.id.button_one);
        Button buttonTwo = (Button) findViewById(R.id.button_two);
        Button buttonThree = (Button) findViewById(R.id.button_three);
        Button buttonFour = (Button) findViewById(R.id.button_four);
        Button buttonFive = (Button) findViewById(R.id.button_five);
        Button buttonSix = (Button) findViewById(R.id.button_six);
        Button buttonSeven = (Button) findViewById(R.id.button_seven);
        Button buttonEight = (Button) findViewById(R.id.button_eight);
        Button buttonNine = (Button) findViewById(R.id.button_nine);
        Button buttonZero = (Button) findViewById(R.id.button_zero);
        Button buttonPlus = (Button) findViewById(R.id.button_plus);
        Button buttonMinus = (Button) findViewById(R.id.button_minus);
        Button buttonMul = (Button) findViewById(R.id.button_mul);
        Button buttonDiv = (Button) findViewById(R.id.button_div);
        Button buttonDelete = (Button) findViewById(R.id.button_delete);
        Button buttonEqual = (Button) findViewById(R.id.button_equal);

        buttonOne.setOnClickListener(view -> calcScreen.setText(calcScreen.getText() + "1"));
        buttonTwo.setOnClickListener(view -> calcScreen.setText(calcScreen.getText() + "2"));
        buttonThree.setOnClickListener(view -> calcScreen.setText(calcScreen.getText() + "3"));
        buttonFour.setOnClickListener(view -> calcScreen.setText(calcScreen.getText() + "4"));
        buttonFive.setOnClickListener(view -> calcScreen.setText(calcScreen.getText() + "5"));
        buttonSix.setOnClickListener(view -> calcScreen.setText(calcScreen.getText() + "6"));
        buttonSeven.setOnClickListener(view -> calcScreen.setText(calcScreen.getText() + "7"));
        buttonEight.setOnClickListener(view -> calcScreen.setText(calcScreen.getText() + "8"));
        buttonNine.setOnClickListener(view -> calcScreen.setText(calcScreen.getText() + "9"));
        buttonZero.setOnClickListener(view -> calcScreen.setText(calcScreen.getText() + "0"));
        buttonPlus.setOnClickListener(view -> calcScreen.setText(calcScreen.getText() + "+"));
        buttonMinus.setOnClickListener(view -> calcScreen.setText(calcScreen.getText() + "-"));
        buttonMul.setOnClickListener(view -> calcScreen.setText(calcScreen.getText() + "*"));
        buttonDiv.setOnClickListener(view -> calcScreen.setText(calcScreen.getText() + "/"));
        buttonDelete.setOnClickListener(view -> {
            String textScreen = calcScreen.getText().toString();
            calcScreen.setText(textScreen.substring(0, textScreen.length() - 1));
        });
        buttonEqual.setOnClickListener(view -> {
            String textScreen = calcScreen.getText().toString();
            calcScreen.setText(calc(textScreen));
        });


    }
}