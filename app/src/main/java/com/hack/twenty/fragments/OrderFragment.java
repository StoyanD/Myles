package com.hack.twenty.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack.twenty.databinding.FragmentOrderBinding;
import com.nostra13.universalimageloader.core.ImageLoader;

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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getItems();
    }

    private void getItems() {
        ImageLoader imageLoader = ImageLoader.getInstance(); // Get singleton instance
        imageLoader.displayImage("http://www.jpl.nasa.gov/spaceimages/images/mediumsize/PIA17011_ip.jpg", mBinding.image);
    }
}
