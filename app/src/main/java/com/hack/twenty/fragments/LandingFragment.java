package com.hack.twenty.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack.twenty.databinding.FragmentLandingBinding;

/**
 * Created by stoyan on 10/24/15.
 */
public class LandingFragment extends Fragment {
    /**
     * TAG for logging
     */
    private static final String TAG = "LandingFragment";
    /**
     * The layout binding for this fragment
     */
    private FragmentLandingBinding mBinding;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        mBinding =  FragmentLandingBinding.inflate(inflater, container, false);
        mBinding.setLandingFrag(this);
        return mBinding.getRoot();
    }
}
