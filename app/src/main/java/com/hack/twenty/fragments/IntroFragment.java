package com.hack.twenty.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.hack.twenty.R;
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
        mBinding.setIntroFrag(this);
//        mBinding.password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
//                return editorActionPassword(view, actionId, event);
//            }
//        });
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

    private void playFadeIn(){
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

    private void changeText(){
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

    public void onButtonClick(View view){

    }

}
