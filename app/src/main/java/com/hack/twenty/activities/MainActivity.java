package com.hack.twenty.activities;

import com.hack.twenty.fragments.LandingFragment;

/**
 * Created by stoyan on 10/24/15.
 */
public class MainActivity extends AbstractActivity {


    @Override
    protected void initLayout() {
        showFragment(new LandingFragment(), false);
    }
}
