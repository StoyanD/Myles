package com.hack.twenty.activities;

import com.hack.twenty.R;
import com.hack.twenty.fragments.HistoryFragment;

/**
 * Created by stoyan on 10/24/15.
 */
public class HistoryActivity extends AbstractActivity {

    @Override
    protected void initLayout() {
        mToolbar.setText(getResources().getString(R.string.activity_main_history_tool_bar_text));
        showFragment(new HistoryFragment(), false);
    }
}
