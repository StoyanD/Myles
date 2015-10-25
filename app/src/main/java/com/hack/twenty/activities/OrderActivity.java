package com.hack.twenty.activities;

import com.hack.twenty.R;
import com.hack.twenty.fragments.OrderFragment;

/**
 * Created by stoyan on 10/24/15.
 */
public class OrderActivity extends AbstractActivity {


    @Override
    protected void initLayout() {
        mToolbar.setText(getResources().getString(R.string.activity_main_order_tool_bar_text));
        showFragment(new OrderFragment(), false);
    }
}
