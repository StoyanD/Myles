package com.hack.twenty.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hack.twenty.Money;
import com.hack.twenty.R;
import com.hack.twenty.activities.OrderActivity;
import com.hack.twenty.api.CategoryList;
import com.hack.twenty.databinding.FragmentCategoryBinding;
import com.hack.twenty.interfaces.NetworkInterface;


/**
 * Created by stoyan on 10/24/15.
 */
public class CategoryFragment extends Fragment implements NetworkInterface {
    /**
     * TAG for logging
     */
    private static final String TAG = "CategoryFragment";
    private static final String CATEGORIES_URL = "https://myles.herokuapp.com/api/categories";
    private static final int CATEGORY_TAG_KEY = 1234567891;

    /**
     * The layout binding for this fragment
     */
    private FragmentCategoryBinding mBinding;

    public static int categoryId = -1;
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        mBinding = FragmentCategoryBinding.inflate(inflater, container, false);
        mBinding.setCategoryFrag(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Money.getCategories(CATEGORIES_URL, this);
    }

    private void getCategories() {
//        Money.imageLoader.displayImage("http://www.jpl.nasa.gov/spaceimages/images/mediumsize/PIA17011_ip.jpg",
//                mBinding.bedroomImage);
//        Money.imageLoader.displayImage("http://www.jpl.nasa.gov/spaceimages/images/mediumsize/PIA17011_ip.jpg",
//                mBinding.kitchenImage);
//        Money.imageLoader.displayImage("http://www.jpl.nasa.gov/spaceimages/images/mediumsize/PIA17011_ip.jpg",
//                mBinding.bathroomImage);
    }

    @Override
    public void onNetworkResponse(String result) {
        Log.d(TAG, result);
        Gson gson = new Gson();
        CategoryList list = gson.fromJson(result, CategoryList.class);
        if (list != null && list.mCategories != null && list.mCategories.size() == 3) {
            setView(mBinding.bedroomImage, mBinding.bedroomText, list.mCategories.get(0).image_url, list.mCategories.get(0).name);
            setView(mBinding.kitchenImage, mBinding.kitchenText, list.mCategories.get(1).image_url, list.mCategories.get(1).name);
            setView(mBinding.bathroomImage, mBinding.bathroomText, list.mCategories.get(2).image_url, list.mCategories.get(2).name);
            mBinding.categoryOne.setTag(CATEGORY_TAG_KEY, list.mCategories.get(0).id);
            mBinding.categoryTwo.setTag(CATEGORY_TAG_KEY, list.mCategories.get(1).id);
            mBinding.categoryThree.setTag(CATEGORY_TAG_KEY, list.mCategories.get(2).id);
        }
    }

    private void setView(ImageView view, TextView textView, String url, String name) {
        if (view != null) {
            Money.imageLoader.displayImage(url,
                    view);
        }
        if(textView != null){
            textView.setText(name);
        }
    }

    public void onClick(View view){
        Long num = (Long) view.getTag(CATEGORY_TAG_KEY);
        categoryId = num != null ? num.intValue() : categoryId;
        Intent intent = new Intent(getActivity(), OrderActivity.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }
}
