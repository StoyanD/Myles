package com.hack.twenty.views;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.hack.twenty.R;
import com.hack.twenty.databinding.ViewRippleButtonBinding;

/**
 * Created by stoyan on 10/9/15.
 */
public class RippleButtonView extends RelativeLayout {
    /**
     * TAG for logging
     */
    private static final String TAG = "TrackerFoodMealView";

    /**
     */
    private ViewRippleButtonBinding mBinding;

    public RippleButtonView(Context context) {
        this(context, null);
    }

    public RippleButtonView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RippleButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mBinding = DataBindingUtil.inflate(inflater, R.layout.view_ripple_button, this, true);
            final RippleButtonView me = this;
            mBinding.executePendingBindings();
            mBinding.setListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    me.performClick();
                }
            });
        }
    }

    @BindingAdapter("ripple_button_text")
    public static void setText(RippleButtonView rippleButtonView, String text) {
        rippleButtonView.mBinding.typeface.setText(text);
    }
}
