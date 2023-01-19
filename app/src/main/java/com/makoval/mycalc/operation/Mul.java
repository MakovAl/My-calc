package com.makoval.mycalc.operation;

public class Mul implements IOperation {

    @Override
    public Double calculation(Double leftOperand, Double rightOperand) {
        return leftOperand * rightOperand;
    }

}
