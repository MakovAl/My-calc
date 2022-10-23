package com.makoval.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Главный класс прложения калькулятор
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Метод получает кнопки с которыми может взаимодействовать пользователь, задает поведение
     * при нажатие на них, в случае нажатия на кнопку с цифрами или оператором к строке выражения
     * добавляется симовл
     * соответсвующий кнопке.
     */
    private void setOnClickListeners() {

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


        buttonOne.setOnClickListener(view -> {
            calcScreen.setText(calcScreen.getText() + "1");
            Log.i("MyCalc", "Пользователь нажал кнопку '1' ");
        });
        buttonTwo.setOnClickListener(view -> {
            calcScreen.setText(calcScreen.getText() + "2");
            Log.i("MyCalc", "Пользователь нажал кнопку '2' ");
        });
        buttonThree.setOnClickListener(view -> {
            calcScreen.setText(calcScreen.getText() + "3");
            Log.i("MyCalc", "Пользователь нажал кнопку '3' ");
        });
        buttonFour.setOnClickListener(view -> {
            calcScreen.setText(calcScreen.getText() + "4");
            Log.i("MyCalc", "Пользователь нажал кнопку '4' ");
        });
        buttonFive.setOnClickListener(view -> {
            calcScreen.setText(calcScreen.getText() + "5");
            Log.i("MyCalc", "Пользователь нажал кнопку '5' ");
        });
        buttonSix.setOnClickListener(view -> {
            calcScreen.setText(calcScreen.getText() + "6");
            Log.i("MyCalc", "Пользователь нажал кнопку '6' ");
        });
        buttonSeven.setOnClickListener(view -> {
            calcScreen.setText(calcScreen.getText() + "7");
            Log.i("MyCalc", "Пользователь нажал кнопку '7' ");
        });
        buttonEight.setOnClickListener(view -> {
            calcScreen.setText(calcScreen.getText() + "8");
            Log.i("MyCalc", "Пользователь нажал кнопку '8' ");
        });
        buttonNine.setOnClickListener(view -> {
            calcScreen.setText(calcScreen.getText() + "9");
            Log.i("MyCalc", "Пользователь нажал кнопку '9' ");
        });
        buttonZero.setOnClickListener(view -> {
            calcScreen.setText(calcScreen.getText() + "0");
            Log.i("MyCalc", "Пользователь нажал кнопку '0' ");
        });
        buttonPlus.setOnClickListener(view -> {
            calcScreen.setText(calcScreen.getText() + "+");
            Log.i("MyCalc", "Пользователь нажал кнопку '+' ");
        });
        buttonMinus.setOnClickListener(view -> {
            calcScreen.setText(calcScreen.getText() + "-");
            Log.i("MyCalc", "Пользователь нажал кнопку '-' ");
        });
        buttonMul.setOnClickListener(view -> {
            calcScreen.setText(calcScreen.getText() + "*");
            Log.i("MyCalc", "Пользователь нажал кнопку '*' ");
        });
        buttonDiv.setOnClickListener(view -> {
            calcScreen.setText(calcScreen.getText() + "/");
            Log.i("MyCalc", "Пользователь нажал кнопку '/' ");
        });
        buttonDelete.setOnClickListener(view -> {
            try {
                Log.i("MyCalc", "Пользователь нажал кнопку '--' ");
                String textScreen = calcScreen.getText().toString();
                calcScreen.setText(textScreen.substring(0, textScreen.length() - 1));
            } catch (StringIndexOutOfBoundsException ex) {
                Log.e("MyCalc", ex.getMessage());
            }
        });
        buttonEqual.setOnClickListener(view -> {
            Log.i("MyCalc", "Пользователь нажал кнопку '=' ");
            String textScreen = calcScreen.getText().toString();
            calcScreen.setText(calc(textScreen));
        });
    }

    /**
     * Метод выполняющий действия:
     * Сложение, вычитание, умножение, деление.
     * <p>
     * Метод получает на вход строку содержащию выражение, в зависимости от находящегося в ней
     * оператора выполняется соотвествущее этому оператору действие.
     *
     * @param textCalcScreen
     * @return Результат вычисления
     */
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
        Log.i("MyCalc", "Результат: " + textCalcScreen + " = " + stringResult);
        return stringResult;
    }


    /**
     * Метод выполняющий действия при запуске приложения.
     * <p>
     * В данном случае установливает активность, которая будет отображаться на экране
     *
     * @param savedInstanceState
     * @see this#calc(String)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MyCalc", "Вызов onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("MyCalc", "Тест Info");
        Log.e("MyCalc", "Тест Error");
        Log.wtf("MyCalc", "Тест wtf");
        Log.d("MyCalc", "Тест Debug");

        setOnClickListeners();

    }

    /**
     * Метод выполняющий действия промежуточного состояния между загрузкой и готовностью
     * взаимодействовать с пользователем
     */
    @Override
    protected void onResume() {
        Log.d("MyCalc", "Вызов onResume");
        super.onResume();
    }

    /**
     * Метод выполняющий действия при восстановлении приложения из состояния Stopped
     */
    @Override
    protected void onRestart() {
        Log.d("MyCalc", "Вызов onRestart");
        super.onRestart();
    }

    /**
     * Метод выполняющий действия перед выходом приложения на передний план
     */
    @Override
    protected void onStart() {
        Log.d("MyCalc", "Вызов onStart");
        super.onStart();
    }

    /**
     * Метод выполняющий действия при завершении приложения
     */
    @Override
    protected void onDestroy() {
        Log.d("MyCalc", "Вызов onDestroy");
        super.onDestroy();
    }

    /**
     * Метод выполняющий действия при остановке приложения (например при сворачивании)
     */
    @Override
    protected void onStop() {
        Log.d("MyCalc", "Вызов onStop");
        super.onStop();
    }
}