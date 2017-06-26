package com.danielvilha.asup.context.home.helper;

import com.danielvilha.asup.context.home.fragment.HomeFragment;
import com.danielvilha.infra.mvc.base.helper.IViewHelper;

/**
 * Created by scopus-dev on 26/06/17.
 */

public class HomeViewHelper implements IViewHelper {

    private HomeFragment fragment;

    public HomeViewHelper(HomeFragment fragment) {
        this.fragment = fragment;

        findViewsById();
        setListeners();
    }

    @Override
    public void findViewsById() {

    }

    @Override
    public void setListeners() {

    }
}
