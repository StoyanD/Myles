package com.hack.twenty.animation;


import android.app.Fragment;

import com.hack.twenty.R;

/**
 * Class that allows to define the four animations used by the method {@link android.app.FragmentTransaction#setCustomAnimations(int, int)}.
 * Used by {@link com.hack.twenty.activities.MainActivity#showFragment(Fragment, boolean)}
 * Created by stoyan on 4/22/15.
 */
public class TransitionAnimation {

    public static final TransitionAnimation FRAGMENT_TRANSITION_BOTTOM_STAY = new TransitionAnimation(R.animator.slide_in_bottom, R.animator.stay_in_place, R.animator.stay_in_place, R.animator.slide_out_bottom);
    public static final TransitionAnimation FRAGMENT_TRANSITION_BOTTOM_TOP = new TransitionAnimation(R.animator.slide_in_bottom, R.animator.slide_out_top, R.animator.slide_in_top, R.animator.slide_out_bottom);

    private int mAnimationEnter;
    private int mAnimationExit;
    private int mAnimationPopEnter;
    private int mAnimationPopExit;

    public TransitionAnimation(int animationEnter, int animationExit, int animationPopEnter, int animationPopExit) {
        this.mAnimationEnter = animationEnter;
        this.mAnimationExit = animationExit;
        this.mAnimationPopEnter = animationPopEnter;
        this.mAnimationPopExit = animationPopExit;
    }

    public int getAnimationEnter() {
        return mAnimationEnter;
    }

    public void setAnimationEnter(int animationEnter) {
        this.mAnimationEnter = animationEnter;
    }

    public int getAnimationExit() {
        return mAnimationExit;
    }

    public void setAnimationExit(int animationExit) {
        this.mAnimationExit = animationExit;
    }

    public int getAnimationPopEnter() {
        return mAnimationPopEnter;
    }

    public void setAnimationPopEnter(int animationPopEnter) {
        this.mAnimationPopEnter = animationPopEnter;
    }

    public int getAnimationPopExit() {
        return mAnimationPopExit;
    }

    public void setAnimationPopExit(int animationPopExit) {
        this.mAnimationPopExit = animationPopExit;
    }
}
