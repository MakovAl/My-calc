package com.makoval.mycalc.operation;

public class Div implements IOperation {
    @Override
    public Double calculation(Double leftOperand, Double rightOperand) {
        return rightOperand / leftOperand;
    }
}
