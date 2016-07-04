package io.denreyes.calcul8.result;

import android.util.Log;

import java.util.Random;

/**
 * Created by Dj on 7/4/2016.
 */
public class ResultInteractor {
    private static final String TAG = "ResultInteractor";

    String[] gifs = {
        "http://assets.itsnicethat.com/system/files/032015/550811275c3e3c03c700506e/images_slice_large/Baiadera-HERO.gif?1437404147",
        "http://laughingsquid.com/wp-content/uploads/2015/04/tumblr_nkx0nzAZSZ1tcuj64o1_400.gif",
        "https://67.media.tumblr.com/300870d74414be74d522f30e0c21f608/tumblr_nvq9ykseXl1ttgvt6o1_500.gif"
    };
    Random mRandom;

    public ResultInteractor(){
        mRandom = new Random();
    }

    public String getRandomImage() {
        String url = gifs[mRandom.nextInt(2)];
        return url;
    }
}
