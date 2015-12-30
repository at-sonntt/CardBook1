package com.example.sonntt.cardbook.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.sonntt.cardbook.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.tw_fragment)
public class TwoFragment extends Fragment {

    @AfterViews
    void afterView(){
        setTabOne();
    }

    @Click(R.id.tvTabOne)
    void clickTabOne(){
        setTabOne();
    }

    @Click(R.id.tvTabTwo)
    void clickTabTwo(){
        setTabTwo();
    }

    public void setContainer(Fragment fragment, boolean isAddToBackStack) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    private void setTabOne(){
        FragmentTabOne fragmentSongArtist = new FragmentTabOne_();
        setContainer(fragmentSongArtist, false);
    }

    private void setTabTwo(){
        FragmentTabTwo fragmenttwo= new FragmentTabTwo_();
        setContainer(fragmenttwo, false);
    }
}
