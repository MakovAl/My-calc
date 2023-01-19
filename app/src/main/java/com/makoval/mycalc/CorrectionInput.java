package com.makoval.mycalc;

/**
 * Класс отвечающий за то, чтобы строка имела правильный вид.
 */
public class CorrectionInput {

    String operation;
    String operationsWithMinus;

    public CorrectionInput(String operation, String operationsWithMinus) {
        this.operation = operation;
        this.operationsWithMinus = operationsWithMinus;
    }

    /**
     * Метод позоваляет производит корректировку строки для отображения в правильном виде
     *
     * @param curTextScreen строка котрую пользователь ввел ранне
     * @param symbol текущий символ введенный пользователем
     * @return строка с введеным пользователем символом
     */
    public String correct(String curTextScreen, String symbol) {
        String lastSymbol = getLastSymbol(curTextScreen);
        if (operation.contains(lastSymbol) && !symbol.equals("-")) {
            curTextScreen = curTextScreen.substring(0, curTextScreen.length() - 1);
            String lastSymbolMinus = getLastSymbol(curTextScreen);
            if (operation.contains(lastSymbolMinus)) {
                curTextScreen = curTextScreen.substring(0, curTextScreen.length() - 1);
            }
        } else if (symbol.equals("-") && !operationsWithMinus.contains(lastSymbol)) {
            curTextScreen = curTextScreen.substring(0, curTextScreen.length() - 1);
        }
        return curTextScreen + symbol;
    }

    private String getLastSymbol(String curTextScreen) {
        if (!curTextScreen.equals("")) {
            return curTextScreen.substring(curTextScreen.length() - 1);
        } else {
            return curTextScreen;
        }
    }

}
