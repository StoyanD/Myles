package com.hack.twenty.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.hack.twenty.Money;
import com.hack.twenty.R;
import com.hack.twenty.adapters.GridViewAdapter;
import com.hack.twenty.api.ItemApi;
import com.hack.twenty.api.ItemList;
import com.hack.twenty.databinding.FragmentOrderBinding;
import com.hack.twenty.interfaces.NetworkInterface;

/**
 * Created by stoyan on 10/24/15.
 */
public class OrderFragment extends Fragment implements NetworkInterface {
    /**
     * TAG for logging
     */
    private static final String TAG = "ItemFragment";
    private static final String ITEMS_URL = "https://myles.herokuapp.com/api/category?category_id=";
    /**
     * The layout binding for this fragment
     */
    private FragmentOrderBinding mBinding;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        mBinding = FragmentOrderBinding.inflate(inflater, container, false);
        mBinding.setOrderFrag(this);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Money.asyncGet(ITEMS_URL + CategoryFragment.categoryId, this);
    }


    @Override
    public void onNetworkResponse(String result) {
        Log.d(TAG, result);
        Gson gson = new Gson();
        ItemList list = gson.fromJson(result, ItemList.class);
        if (list != null && isAdded()) {
            GridViewAdapter gridAdapter = new GridViewAdapter(getActivity(), R.layout.view_item_cell, list.mItems, this);
            mBinding.gridView.setAdapter(gridAdapter);

            mBinding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    ItemApi item = (ItemApi) parent.getItemAtPosition(position);
                    launchDialogFragment(item);
                }
            });
        }
    }

    private void launchDialogFragment(ItemApi item ) {
        FragmentManager fm = getActivity().getFragmentManager();
        OrderDialogFragment dialogFragment = new OrderDialogFragment();
        dialogFragment.setApi(item);
        dialogFragment.show(fm, dialogFragment.getClass().toString());
    }

    public void onClick(ItemApi item){
        launchDialogFragment(item);
    }
}
