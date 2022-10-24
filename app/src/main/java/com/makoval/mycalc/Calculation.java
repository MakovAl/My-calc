package com.makoval.mycalc;

/**
 * Класс содержащий операции с числами поддерживаемые калькулятором
 */
public class Calculation {


    /**
     * @param operandOne Первый множитель
     * @param operandTwo Второй множитель
     * @return Произведение operandOne и operandTwo
     */
    public double mul(double operandOne, double operandTwo) {
        return operandOne * operandTwo;
    }

    /**
     * @param operandOne Первое слагаемое
     * @param operandTwo Второе слагаемое
     * @return Сумма operandOne и operandTwo
     */
    public double add(double operandOne, double operandTwo) {
        return operandOne + operandTwo;
    }

    /**
     * @param operandOne Уменьшаемое
     * @param operandTwo Вычитаемое
     * @return Разность operandOne и operandTwo
     */
    public double minus(double operandOne, double operandTwo) {
        return operandOne - operandTwo;
    }

    /**
     * @param operandOne Делимое
     * @param operandTwo Делитель
     * @return Частное operandOne и operandTwo
     */
    public double div(double operandOne, double operandTwo) {
        return operandOne / operandTwo;
    }

}
