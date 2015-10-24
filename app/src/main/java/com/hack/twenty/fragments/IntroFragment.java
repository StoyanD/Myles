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
//        mBinding.setLoginFrag(this);
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
        mBinding.fragmentIntroText.startAnimation(fade);
        mBinding.fragmentIntroText.setVisibility(View.VISIBLE);

    //
//        AnimatorSet set = new AnimatorSet();
//        int height = mBinding.fragmentIntroText.getLayout().getHeight();
        float width = getResources().getDimension(R.dimen.fragment_intro_text_width);
//        //float fromX, float toX, float fromY, float toY
//        ScaleAnimation scaleAnimation = new AnimationUtils.loadAnimation(0,0,height,height);
//        set.playTogether(new ScaleAnimation());
//        set.setDuration(duration);
//        set = addListenersToSet(set);
//        set.start();

//        ObjectAnimator scale = ObjectAnimator.ofFloat(mBinding.fragmentIntroText, "x", width);
//        ObjectAnimator alpha = ObjectAnimator.ofFloat(mBinding.fragmentIntroText, "alpha", 255);
////        scale.setDuration(1000);
//        alpha.setDuration(1000);
//
//        AnimatorSet alphaScale = new AnimatorSet();
//        alphaScale.playTogether(alpha);
//        alphaScale.start();
//        Animation a = new AlphaAnimation(0f, 1.0f);
//        a.setDuration(1000);
//        a.setFillAfter(true);
//        mBinding.fragmentIntroText.startAnimation(a);
    }

}
