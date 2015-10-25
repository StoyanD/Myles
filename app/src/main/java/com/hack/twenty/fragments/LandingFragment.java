package com.hack.twenty.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack.twenty.R;
import com.hack.twenty.activities.CategoryActivity;
import com.hack.twenty.activities.HistoryActivity;
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

    public void onOrderClick(View view){
//        ((MainActivity)getActivity()).showMoneyFragment(new CategoryFragment(), this);

//        FragmentManager manager = getActivity().getFragmentManager();
        Intent intent = new Intent(getActivity(), CategoryActivity.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void onHistoryClick(View view){
        Intent intent = new Intent(getActivity(), HistoryActivity.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
