package io.denreyes.calcul8.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.denreyes.calcul8.R;
import io.denreyes.calcul8.calculator.CalculatorPresenter;
import io.denreyes.calcul8.calculator.ICalculatorView;

public class CalculatorActivity extends AppCompatActivity implements ICalculatorView {
    private static final String TAG = "CalculatorActivity";
    
    @BindView(R.id.text_summary)
    TextView mTextSummary;
    @BindView(R.id.edit_number)
    EditText mEditNumber;

    CalculatorPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new CalculatorPresenter(this);
    }

    @OnClick(R.id.btn_calc_add)
    public void onAddClick(){
        mPresenter.equate(mEditNumber.getText().toString(), "+");
    }

    @OnClick(R.id.btn_calc_subtract)
    public void onSubtractClick(){
        mPresenter.equate(mEditNumber.getText().toString(), "-");
    }

    @OnClick(R.id.btn_calc_multiply)
    public void onMultiplyClick(){
        mPresenter.equate(mEditNumber.getText().toString(), "*");
    }

    @OnClick(R.id.btn_calc_divide)
    public void onDivideClick(){
        mPresenter.equate(mEditNumber.getText().toString(), "/");
    }

    @OnClick(R.id.btn_calc_equals)
    public void onEqualsClick(){
        mPresenter.compute(mEditNumber.getText().toString());
    }

    @Override
    public void updateSummary(String summary) {
        mTextSummary.setText(summary);
    }

    @Override
    public void displayResult(String result) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("RESULT", result);
        startActivity(intent);
    }

    @Override
    public void clearInput() {
        mEditNumber.setText("");
    }

    @Override
    public void clearAll() {
        mEditNumber.setText("");
        mTextSummary.setText("");
    }
}
