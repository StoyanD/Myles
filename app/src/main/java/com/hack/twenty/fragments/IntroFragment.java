package com.hack.twenty.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hack.twenty.databinding.FragIntroBinding;

/**
 * Created by stoyan on 10/24/15.
 */
public class IntroFragment extends Fragment {
    /**
     * TAG for logging
     */
    private static final String TAG = "IntroFragment";
    /**
     * The layout binding for this fragment
     */
    private FragIntroBinding mBinding;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        mBinding =  FragIntroBinding.inflate(inflater, container, false);
//        mBinding.setLoginFrag(this);
//        mBinding.password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
//                return editorActionPassword(view, actionId, event);
//            }
//        });
        return mBinding.getRoot();
    }

}
