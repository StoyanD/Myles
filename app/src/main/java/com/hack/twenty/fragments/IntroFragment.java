package com.hack.twenty.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.hack.twenty.R;
import com.hack.twenty.activities.MainActivity;
import com.hack.twenty.databinding.FragmentIntroBinding;

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
    private FragmentIntroBinding mBinding;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        mBinding = FragmentIntroBinding.inflate(inflater, container, false);
        mBinding.setIntroFrag(this);
        return mBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                playFadeIn();
            }
        }, 1000);


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void playFadeIn() {
        Animation fade = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in_expand_x);
        fade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeText();
                    }
                }, 1000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mBinding.fragmentIntroText.startAnimation(fade);
        mBinding.fragmentIntroText.setVisibility(View.VISIBLE);
    }

    private void changeText() {
//        Animation fade = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in_animation);
//        mBinding.fragmentIntroText.setAlpha(0);
        mBinding.fragmentIntroText.setText(getResources().getString(R.string.fragment_intro_myles_referrer_disclosure));

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation fade = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in_animation);
                mBinding.fragIntroButton.setVisibility(View.VISIBLE);
                mBinding.fragIntroButton.startAnimation(fade);
            }
        }, 1000);

//        mBinding.fragmentIntroText.startAnimation(fade);
    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        getActivity().finish();
    }

}
