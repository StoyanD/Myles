package com.hack.twenty.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack.twenty.databinding.FragmentItemBinding;

/**
 * Created by stoyan on 10/24/15.
 */
public class ItemFragment extends Fragment {
    /**
     * TAG for logging
     */
    private static final String TAG = "ItemFragment";
    /**
     * The layout binding for this fragment
     */
    private FragmentItemBinding mBinding;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        mBinding =  FragmentItemBinding.inflate(inflater, container, false);
        mBinding.setItemFrag(this);
        return mBinding.getRoot();
    }
}
