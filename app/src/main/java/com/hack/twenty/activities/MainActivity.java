package com.hack.twenty.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.hack.twenty.R;

/**
 * Created by stoyan on 10/24/15.
 */
public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

//        mLoginFragment = (AbstractFragment) getFragmentManager().findFragmentById(R.id.fragment_login);
    }
}
