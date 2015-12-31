package com.example.sonntt.cardbook.fragment;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.example.sonntt.cardbook.R;
import com.example.sonntt.cardbook.until.ProgressWheel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * @author SonNTT on 12/29/15.
 */
@EFragment(R.layout.fragment_tab_two)
public class FragmentTabTwo extends Fragment {

    private int progressStatus = 0;
    private Handler mHandler = new Handler();

    @ViewById(R.id.progressBarTwo)
    ProgressWheel mProgressWheel;

    @ViewById(R.id.tvProgress)
    TextView mTvProgress;

    @AfterViews
    void afterView() {
        // HandelSeekBar();
        //  styleRandom(mProgressWheel, getActivity());
        HandelSeekBar();
    }

    public void HandelSeekBar() {

        new Thread(new Runnable() {
            public void run() {

                while (progressStatus < 180) {
                    progressStatus += 1;
                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {

                            mProgressWheel.setProgress(progressStatus * 360 / 200);
                            mProgressWheel.setText(String.valueOf(progressStatus));
                            mTvProgress.setText(String.valueOf(progressStatus));

                        }
                    });
                    try {


                        Thread.sleep(50);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
