package io.denreyes.calcul8.result;

/**
 * Created by Dj on 7/4/2016.
 */
public class ResultPresenter {
    private static final String TAG = "ResultPresenter";
    IResultView mView;
    ResultInteractor mInteractor;

    public ResultPresenter(IResultView view){
        mView = view;
        mInteractor = new ResultInteractor();
    }

    public void display(String result){
        mView.displayResult(result);
        mView.setBackground(mInteractor.getRandomImage());
    }
}
