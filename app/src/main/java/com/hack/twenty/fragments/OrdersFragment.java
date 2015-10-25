package com.hack.twenty.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack.twenty.databinding.FragmentOrdersBinding;

/**
 * Created by stoyan on 10/24/15.
 */
public class OrdersFragment extends Fragment {
    /**
     * TAG for logging
     */
    private static final String TAG = "OrdersFragment";
    /**
     * The layout binding for this fragment
     */
    private FragmentOrdersBinding mBinding;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        mBinding =  FragmentOrdersBinding.inflate(inflater, container, false);
        mBinding.setOrdersFrag(this);
        return mBinding.getRoot();
    }
}
