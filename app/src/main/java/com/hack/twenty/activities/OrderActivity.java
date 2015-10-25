package com.hack.twenty.activities;

import com.hack.twenty.fragments.OrderFragment;

/**
 * Created by stoyan on 10/24/15.
 */
public class OrderActivity extends AbstractActivity {


    @Override
    protected void initLayout() {
        showFragment(new OrderFragment(), false);
    }
}
