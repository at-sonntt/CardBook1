package com.example.sonntt.cardbook.CustomTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.sonntt.cardbook.R;

/**
 * @author SonNTT on 12/29/15.
 */
public class TabBarCustom extends LinearLayout {

    private final ImageView mImageOne;
    private final ImageView mImageTwo;
    private final ImageView mImageThree;
    private final ImageView mImageFour;
    private final ImageView mImageFive;

    public TabBarCustom(Context context, AttributeSet attrs) {
        super(context, attrs);

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.tab_custom, this, true);

        mImageOne = (ImageView) findViewById(R.id.imgOne);
        mImageTwo = (ImageView) findViewById(R.id.imgTwo);
        mImageThree = (ImageView) findViewById(R.id.imgThree);
        mImageFour = (ImageView) findViewById(R.id.imgFour);
        mImageFive = (ImageView) findViewById(R.id.imgFive);

    }

    public TabBarCustom(Context context) {
        this(context, null);
    }

    public void setImageTabOne() {

        mImageOne.setVisibility(View.VISIBLE);
        mImageTwo.setVisibility(View.INVISIBLE);
        mImageThree.setVisibility(View.INVISIBLE);
        mImageFour.setVisibility(View.INVISIBLE);
        mImageFive.setVisibility(View.INVISIBLE);
    }

    public void setImageTabTwo() {

        mImageTwo.setVisibility(View.VISIBLE);

        mImageOne.setVisibility(View.INVISIBLE);
        mImageThree.setVisibility(View.INVISIBLE);
        mImageFour.setVisibility(View.INVISIBLE);
        mImageFive.setVisibility(View.INVISIBLE);
    }

    public void setImageTabThree() {

        mImageThree.setVisibility(View.VISIBLE);

        mImageOne.setVisibility(View.INVISIBLE);
        mImageTwo.setVisibility(View.INVISIBLE);
        mImageFive.setVisibility(View.INVISIBLE);
        mImageFour.setVisibility(View.INVISIBLE);
    }

    public void setImageTabFour() {

        mImageFour.setVisibility(View.VISIBLE);

        mImageOne.setVisibility(View.INVISIBLE);
        mImageTwo.setVisibility(View.INVISIBLE);
        mImageThree.setVisibility(View.INVISIBLE);
        mImageFive.setVisibility(View.INVISIBLE);
    }

    public void setImageTabFive() {

        mImageFive.setVisibility(View.VISIBLE);

        mImageOne.setVisibility(View.INVISIBLE);
        mImageTwo.setVisibility(View.INVISIBLE);
        mImageFour.setVisibility(View.INVISIBLE);
        mImageThree.setVisibility(View.INVISIBLE);
    }

    public void setTabDefault() {

        mImageOne.setVisibility(View.VISIBLE);

        mImageFive.setVisibility(View.INVISIBLE);
        mImageTwo.setVisibility(View.INVISIBLE);
        mImageFour.setVisibility(View.INVISIBLE);
        mImageThree.setVisibility(View.INVISIBLE);
    }
}
