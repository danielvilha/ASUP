package com.danielvilha.asup.context.economic.helper;

import com.danielvilha.asup.context.economic.fragment.EconomicFragment;
import com.danielvilha.infra.mvc.base.helper.IViewHelper;

/**
 * Created by scopus-dev on 26/06/17.
 */

public class EconomicViewHelper implements IViewHelper {

    private EconomicFragment fragment;

    public EconomicViewHelper(EconomicFragment fragment) {
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
