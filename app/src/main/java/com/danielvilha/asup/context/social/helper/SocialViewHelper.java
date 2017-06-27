package com.danielvilha.asup.context.social.helper;

import android.support.v7.widget.Toolbar;

import com.danielvilha.asup.R;
import com.danielvilha.asup.context.social.fragment.SocialFragment;
import com.danielvilha.infra.mvc.base.helper.IViewHelper;

/**
 * Created by scopus-dev on 26/06/17.
 */

public class SocialViewHelper implements IViewHelper {

    private SocialFragment fragment;

    public SocialViewHelper(SocialFragment fragment) {
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
