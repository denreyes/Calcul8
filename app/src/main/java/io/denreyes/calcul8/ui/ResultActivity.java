package io.denreyes.calcul8.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.denreyes.calcul8.R;
import io.denreyes.calcul8.result.IResultView;
import io.denreyes.calcul8.result.ResultPresenter;

/**
 * Created by Dj on 7/4/2016.
 */
public class ResultActivity extends AppCompatActivity implements IResultView {
    @BindView(R.id.image_background)
    ImageView mImageBackground;
    @BindView(R.id.text_result)
    TextView mTextResult;

    ResultPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        mPresenter = new ResultPresenter(this);

        mPresenter.display(getIntent().getStringExtra("RESULT"));
    }

    @Override
    public void displayResult(String result) {
        mTextResult.setText(result);
    }

    @Override
    public void setBackground(String url) {
        Glide.with(this)
                .load(url)
                .asGif()
                .centerCrop()
                .crossFade()
                .into(mImageBackground);
    }
}
