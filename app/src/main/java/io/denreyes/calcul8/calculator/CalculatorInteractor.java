package io.denreyes.calcul8.calculator;

import android.util.Log;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

/**
 * Created by Dj on 7/4/2016.
 */
public class CalculatorInteractor {
    private static final String TAG = "CalculatorInteractor";

    protected String concatEquation(String numsAndOps, String num, String op){
        return numsAndOps+num+op;
    }

    public String compute(String equation) {
        String result = "";
        try {
            Calculable calc = new ExpressionBuilder(equation).build();
            result = Math.round(calc.calculate()) + "";
        } catch(UnparsableExpressionException e){
            Log.e(TAG, "UnparsableExpressionException", e);
        } catch (UnknownFunctionException e) {
            Log.e(TAG, "UnknownFunctionException", e);
        }finally {
            return result;
        }
    }

    public String removeLastOperation(String equation) {
        return equation.substring(0, equation.length() - 1);
    }
}
