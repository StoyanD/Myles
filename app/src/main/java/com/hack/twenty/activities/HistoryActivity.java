package com.hack.twenty.activities;

import com.hack.twenty.fragments.HistoryFragment;

/**
 * Created by stoyan on 10/24/15.
 */
public class HistoryActivity extends AbstractActivity {

    @Override
    protected void initLayout() {
        showFragment(new HistoryFragment(), false);
    }
}
