package com.danielvilha.asup.context.environmental.helper;

import com.danielvilha.asup.context.environmental.fragment.EnvironmentalFragment;
import com.danielvilha.infra.mvc.base.helper.IViewHelper;

/**
 * Created by scopus-dev on 26/06/17.
 */

public class EnvironmentalViewHelper implements IViewHelper {

    private EnvironmentalFragment fragment;

    public EnvironmentalViewHelper(EnvironmentalFragment fragment) {
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
