package com.danielvilha.asup.context.social.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielvilha.asup.R;
import com.danielvilha.asup.context.social.helper.SocialViewHelper;
import com.danielvilha.asup.context.social.model.SocialModel;
import com.danielvilha.infra.mvc.annotations.FragmentModel;
import com.danielvilha.infra.mvc.base.BaseFragment;
import com.danielvilha.infra.mvc.base.helper.IViewHelper;

import java.util.Observable;

/**
 * Created by scopus-dev on 26/06/17.
 */
@FragmentModel(path="com.danielvilha.asup.context.social.model.SocialModel")
public class SocialFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.rootLayout = inflater.inflate(R.layout.fragment_social, container, false);
        return super.rootLayout;
    }

    @Override
    public void initializeView() {
        super.viewHelper = new SocialViewHelper(SocialFragment.this);
    }

    @Override
    public void executeFirstLoad(Bundle savedInstanceState) {

    }

    @Override
    public void reloadView() {
        super.viewHelper = new SocialViewHelper(SocialFragment.this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public SocialViewHelper getViewHelper() {
        if(super.viewHelper == null){
            super.viewHelper = new SocialViewHelper(this);
        }
        return (SocialViewHelper) super.viewHelper;
    }

    public SocialModel getModel() {
        return (SocialModel) this.getFragmentModel();
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
