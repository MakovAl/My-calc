package com.makoval.mycalc;

import com.makoval.mycalc.operation.Div;
import com.makoval.mycalc.operation.IOperation;
import com.makoval.mycalc.operation.Minus;
import com.makoval.mycalc.operation.Mul;
import com.makoval.mycalc.operation.Sum;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;


public class RPN {

    Map<String, IOperation> operationMap;

    public RPN() {
        this.operationMap = new HashMap<>();
        operationMap.put("+", new Sum());
        operationMap.put("-", new Minus());
        operationMap.put("*", new Mul());
        operationMap.put("/", new Div());
    }

    boolean containOperation(String operation) {
        return operationMap.containsKey(operation);
    }

    private void tokenDistribution(String token, Stack<String> stackOperand, Stack<String> stackOperation) {

        Map<String, Integer> operationWeight = new HashMap<>();

        operationWeight.put("*", 1);
        operationWeight.put("/", 1);
        operationWeight.put("+", 0);
        operationWeight.put("-", 0);

        if (operationWeight.containsKey(token)) {
            if (stackOperation.empty()) {
                stackOperation.push(token);
            } else if (Objects.equals(operationWeight.get(token), operationWeight.get(stackOperation.peek()))) {
                stackOperand.push(stackOperation.pop());
                stackOperation.push(token);
            } else if (operationWeight.get(token) > operationWeight.get(stackOperation.peek())) {
                stackOperation.push(token);
            } else if (operationWeight.get(token) < operationWeight.get(stackOperation.peek())) {
                stackOperand.push(stackOperation.pop());
                stackOperation.push(token);
            }
        } else {
            stackOperand.push(token);
        }
    }

    private String createOPNValidExpression(String expression) {
        Stack<String> stackOperand = new Stack<>();
        Stack<String> stackOperation = new Stack<>();

        String formatExpression = expression.replaceAll("[-+*/()]", " $0 ")
                .replace("  ", " ").trim();

        String prevToken = "";
        for (String token : formatExpression.split("\\s+")) {
            if ((operationMap.containsKey(prevToken) || prevToken.equals("")) && token.equals("-")) {
                stackOperand.push("(");
                stackOperand.push(token);
                stackOperand.push(")");
            } else {
                tokenDistribution(token, stackOperand, stackOperation);
            }
            prevToken = token;
        }
        while (!stackOperation.empty()) {
            stackOperand.push(stackOperation.pop());
        }
        return stackOperand.toString();
    }

    public String calc(String expression) throws
            ArithmeticException,
            EmptyStackException {
        Stack<Double> stack = new Stack<>();

        String validExpression = createOPNValidExpression(expression);

        boolean isNegativeNumber = false;
        String prevToken = "";


        validExpression = validExpression.replaceAll("\\[", "").replaceAll("]", "")
                .replaceAll(",", "");

        for (String token : validExpression.split("\\s+")) {
            if (operationMap.containsKey(token)) {
                if ((prevToken.equals("(") || prevToken.equals("")) && token.equals("-")) {
                    isNegativeNumber = true;
                } else {
                    stack.push(operationMap.get(token).calculation(stack.pop(), stack.pop()));
                }
            } else {
                if (!token.equals("(") && !token.equals(")")) {
                    double number = Double.parseDouble(token);
                    if (isNegativeNumber) {
                        number *= -1;
                        isNegativeNumber = false;
                    }
                    stack.push(number);
                }
            }
            prevToken = token;
        }

        return stack.pop().toString();
    }
}
