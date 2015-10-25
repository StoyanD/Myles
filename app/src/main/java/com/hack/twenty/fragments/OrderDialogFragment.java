package com.hack.twenty.fragments;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.hack.twenty.Money;
import com.hack.twenty.R;
import com.hack.twenty.api.ItemApi;
import com.hack.twenty.api.OrderApi;
import com.hack.twenty.databinding.FragmentOrderDialogBinding;
import com.hack.twenty.interfaces.NetworkInterface;

/**
 * Created by stoyan on 10/24/15.
 */
public class OrderDialogFragment extends DialogFragment implements NetworkInterface {
    private static final String ORDER_POST_URL = "https://myles.herokuapp.com/api/place_order";
    /**
     * The layout binding for this fragment
     */
    private FragmentOrderDialogBinding mBinding;
    private ItemApi mApi;

    @SuppressLint("CommitTransaction")
    @Override
    public void show(FragmentManager manager, String tag) {
        FragmentTransaction ft = manager != null ? manager.beginTransaction() : null;
        if (ft == null) {
            ft = getFragmentManager() != null ? getFragmentManager().beginTransaction() : null;
        }
        if (ft != null) {
            ft.add(this, tag);
            ft.commitAllowingStateLoss();
        }
    }

    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogFragmentBounceInTopRightAnimationStyle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentOrderDialogBinding.inflate(inflater, container, false);
        mBinding.setOrderFrag(this);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mApi != null) {
            Money.imageLoader.displayImage(mApi.image_url,
                    mBinding.fragmentDialogMealPhotoIv);
        }
    }

    public void clickCancel(View view) {
        this.dismiss();
    }

    public void clickBuy(View view) {
        OrderApi orderApi = new OrderApi();
        orderApi.item_id = mApi.id;
        orderApi.recipient_id = Money.USER_ID;
        Gson gson = new Gson();
        Money.asyncPost(ORDER_POST_URL, gson.toJson(orderApi));
        this.dismiss();
    }

    @Override
    public void onNetworkResponse(String result) {
    }

    public void setApi(ItemApi api) {
        this.mApi = api;
    }
}
