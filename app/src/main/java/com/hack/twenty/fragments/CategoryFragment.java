package com.hack.twenty.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack.twenty.databinding.FragmentCategoryBinding;

/**
 * Created by stoyan on 10/24/15.
 */
public class CategoryFragment extends Fragment {
    /**
     * TAG for logging
     */
    private static final String TAG = "CategoryFragment";
    /**
     * The layout binding for this fragment
     */
    private FragmentCategoryBinding mBinding;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        mBinding =  FragmentCategoryBinding.inflate(inflater, container, false);
        mBinding.setCategoryFrag(this);
        return mBinding.getRoot();
    }
}
