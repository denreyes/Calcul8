package io.denreyes.calcul8.calculator;

/**
 * Created by Dj on 7/4/2016.
 */
public interface ICalculatorView {

    public void updateSummary(String summary);
    public void displayResult(String result);
    public void clearInput();
    public void clearAll();
}
