package com.example.sonntt.cardbook.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.sonntt.cardbook.R;
import com.google.zxing.client.android.CaptureActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

/**
 * @author SonNTT on 12/23/15.
 */
@EFragment(R.layout.five_fragment)
public class FiveFragment extends Fragment {

    public static final int REQUEST_CODE = 0;


    @AfterViews
    void afterView() {

    }

    @Click(R.id.bt)
    void click() {

        Intent it = new Intent(getActivity().getBaseContext(), CaptureActivity.class);
        startActivityForResult(it, REQUEST_CODE);
    }

    @SuppressWarnings("AccessStaticViaInstance")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //noinspection AccessStaticViaInstance,AccessStaticViaInstance
        if (REQUEST_CODE == requestCode && getActivity().RESULT_OK == resultCode) {
            Log.d("sss", "RESULTADO: " + data.getStringExtra("SCAN_RESULT") + " (" + data.getStringExtra("SCAN_FORMAT") + ")");
        }
    }
}
