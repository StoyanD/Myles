package com.hack.twenty.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.hack.twenty.R;
import com.hack.twenty.animation.TransitionAnimation;

/**
 * Created by stoyan on 10/24/15.
 */
public abstract class AbstractActivity extends Activity {
    /**
     * Tag for logging this class
     */
    private static final String TAG = "MainActivity";

    /**
     * Reference to the currently displaying fragment
     */
    protected Fragment mCurrentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();


    }
    protected abstract void initLayout();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mCurrentFragment = getCurrentFrag();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCurrentFragment = getVisibleFrag();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void showMoneyFragment(Fragment fragment, Fragment old) {
        FragmentManager fm = getFragmentManager();
//        FragmentTransaction transaction = fm.beginTransaction();
//        transaction.addToBackStack(fragment.getClass().toString());
        TransitionAnimation transitionAnimation = TransitionAnimation.FRAGMENT_TRANSITION_BOTTOM_STAY;
//        transaction.setCustomAnimations(transitionAnimation.getAnimationEnter(), transitionAnimation.getAnimationExit(), transitionAnimation.getAnimationPopEnter(), transitionAnimation.getAnimationPopExit());
//        if (old != null) {
//            transaction.hide(old);
//        }
//        transaction.add(R.id.content_frame_container, fragment, fragment.getClass().toString());
//        transaction.show(fragment);
//        transaction.commit();

        fm.beginTransaction().addToBackStack(fragment.getClass().toString()).hide(old)
                .setCustomAnimations(transitionAnimation.getAnimationEnter(), transitionAnimation.getAnimationExit(), transitionAnimation.getAnimationPopEnter(), transitionAnimation.getAnimationPopExit())
                .add(R.id.content_frame_container, fragment).commit();
    }


    /**
     * Shows the fragment in the content_frame of the main layout. Shows fragment
     * by using {@link android.support.v4.app.FragmentTransaction#replace(int, android.support.v4.app.Fragment)}
     *
     * @param frag                The fragment to show
     * @param addToBackStack      Whether the backstack should hold this new fragment
     * @param animate             Whether the transaction should be animated
     * @param transitionAnimation The {@link TransitionAnimation} to animate the Fragment transition. Uses {@link TransitionAnimation#FRAGMENT_TRANSITION_BOTTOM_STAY} by default if null.
     */
    public void showFragment(Fragment frag, boolean addToBackStack, boolean animate, TransitionAnimation transitionAnimation) {

        Fragment visibleFragment = getVisibleFrag();
        if (visibleFragment != null && mCurrentFragment != null && ((Object) visibleFragment).getClass() == ((Object) frag).getClass()) {
            return;
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        if (addToBackStack) {
            transaction.addToBackStack(frag.getClass().toString());
        }

        if (animate) {
            if (transitionAnimation != null) {
                transaction.setCustomAnimations(transitionAnimation.getAnimationEnter(), transitionAnimation.getAnimationExit(), transitionAnimation.getAnimationPopEnter(), transitionAnimation.getAnimationPopExit());
            } else {
                transitionAnimation = TransitionAnimation.FRAGMENT_TRANSITION_BOTTOM_STAY;
                transaction.setCustomAnimations(transitionAnimation.getAnimationEnter(), transitionAnimation.getAnimationExit(), transitionAnimation.getAnimationPopEnter(), transitionAnimation.getAnimationPopExit());
            }
            if (visibleFragment != null) {
                transaction.hide(visibleFragment);
            }
            if (!isFragmentInStack(frag.getClass())) {
                transaction.add(R.id.content_frame_container, frag, frag.getClass().toString());
            }
            if (!frag.isAdded()) {
                transaction.show(frag);
            }
        } else {
            transaction.replace(R.id.content_frame_container, frag, frag.getClass().toString());
        }
        mCurrentFragment = frag;
        transaction.commit();
    }

    /**
     * Shows the fragment in the content_frame of the main layout. Shows fragment
     * by using {@link android.support.v4.app.FragmentTransaction#replace(int, android.support.v4.app.Fragment)}.
     * Uses {@link TransitionAnimation#FRAGMENT_TRANSITION_BOTTOM_STAY} as the default custom animation for Fragment transition.
     *
     * @param frag           The fragment to show
     * @param addToBackStack Whether the backstack should hold this new fragment
     * @param animate        Whether the transaction should be animated
     */
    public void showFragment(Fragment frag, boolean addToBackStack, boolean animate) {
        showFragment(frag, addToBackStack, animate, TransitionAnimation.FRAGMENT_TRANSITION_BOTTOM_STAY);
    }

    /**
     * Calls {@link #showFragment(android.app.Fragment, boolean, boolean)} with
     * animate set to true
     *
     * @param frag           The fragment to show
     * @param addToBackStack Whether the backstack should hold this new fragment
     */
    protected void showFragment(Fragment frag, boolean addToBackStack) {
        showFragment(frag, addToBackStack, true);
    }

    /**
     * Method searches through the fragments in the {@link android.support.v4.app.FragmentManager}
     * for the fragment that is currently visible and returns that fragment
     *
     * @return The fragment that is currently visible
     */
    public Fragment getCurrentFrag() {
        //If it has already been set, but is not yet visible
        if (mCurrentFragment != null) {
            return mCurrentFragment;
        }

        return getVisibleFrag();
    }

    protected Fragment getVisibleFrag() {
        FragmentManager fragmentManager = getFragmentManager();
        for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
            String tag = fragmentManager.getBackStackEntryAt(i).getName();
            Fragment fragment = fragmentManager.findFragmentByTag(tag);
            if (fragment.isVisible()) {
                return fragment;
            }
        }
        return null;
    }

    /**
     * Allows to check if a fragment is present in the back stack or not
     *
     * @param fragmentClass The {@link java.lang.Class} of the fragment we want to check for
     * @return True if present in the back stack, false otherwise
     */
    public boolean isFragmentInStack(Class fragmentClass) {
        FragmentManager fragmentManager = getFragmentManager();
        for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
            String tag = fragmentManager.getBackStackEntryAt(i).getName();
            Fragment fragment = fragmentManager.findFragmentByTag(tag);
            if (fragment != null && fragment.getClass() == fragmentClass) {
                return true;
            }
        }
        return false;
    }

}
