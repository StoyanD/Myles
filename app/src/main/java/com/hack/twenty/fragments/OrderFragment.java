package com.hack.twenty.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack.twenty.databinding.FragmentOrderBinding;

/**
 * Created by stoyan on 10/24/15.
 */
public class OrderFragment extends Fragment {
    /**
     * TAG for logging
     */
    private static final String TAG = "ItemFragment";
    /**
     * The layout binding for this fragment
     */
    private FragmentOrderBinding mBinding;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        mBinding =  FragmentOrderBinding.inflate(inflater, container, false);
        mBinding.setOrderFrag(this);
        return mBinding.getRoot();
    }
}
