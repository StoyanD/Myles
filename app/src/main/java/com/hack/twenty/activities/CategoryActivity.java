package com.hack.twenty.activities;

import com.hack.twenty.fragments.CategoryFragment;

/**
 * Created by stoyan on 10/24/15.
 */
public class CategoryActivity extends AbstractActivity {


    @Override
    protected void initLayout() {
        showFragment(new CategoryFragment(), false);
    }
}
