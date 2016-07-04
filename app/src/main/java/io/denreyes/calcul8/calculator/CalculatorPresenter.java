package io.denreyes.calcul8.calculator;

import android.util.Log;

import java.util.ArrayList;

import io.denreyes.calcul8.ui.CalculatorActivity;

/**
 * Created by Dj on 7/4/2016.
 */
public class CalculatorPresenter {
    private static final String TAG = "CalculatorPresenter";
    private ICalculatorView mView;
    private CalculatorInteractor mInteractor;

    private String equation;

    public CalculatorPresenter(ICalculatorView calculatorView) {
        mView = calculatorView;
        mInteractor = new CalculatorInteractor();
        equation = "";
    }

    public void equate(String num, String op){
        if(!num.isEmpty()) {
            equation = mInteractor.concatEquation(equation, num, op);
            mView.updateSummary(equation);
            mView.clearInput();
        }
    }

    public void compute(String lastNum) {
        if(lastNum.isEmpty()) {
            equation = mInteractor.removeLastOperation(equation);
        } else {
            equation = mInteractor.concatEquation(equation, lastNum, "");
        }

        mView.displayResult(mInteractor.compute(equation));
        mView.clearAll();
        equation = "";
    }
}
