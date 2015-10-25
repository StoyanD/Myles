package com.hack.twenty.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by stoyan on 10/24/15.
 */
public class CategoryList {

    @SerializedName("categories")
    public List<CategoryApi> mCategories;
}
