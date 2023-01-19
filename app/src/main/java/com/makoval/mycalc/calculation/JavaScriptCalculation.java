package com.makoval.mycalc.calculation;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Класс реализующий интерфейс ICalculation и использующий для
 * вычисления JavaScript
 */
public class JavaScriptCalculation implements ICalculation{
    @Override
    public String calc(String expression) {
        String result = "";
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            result = String.valueOf(engine.eval(expression));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }
}
