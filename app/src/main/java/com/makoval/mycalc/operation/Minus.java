package com.makoval.mycalc.operation;

public class Minus implements IOperation{
    @Override
    public Double calculation(Double leftOperand, Double rightOperand) {
        return -1 * (leftOperand) + rightOperand;
    }
}
