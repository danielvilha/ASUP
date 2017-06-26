package com.danielvilha.asup.context.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielvilha.asup.R;
import com.danielvilha.asup.context.home.helper.HomeViewHelper;
import com.danielvilha.asup.context.home.model.HomeModel;
import com.danielvilha.infra.mvc.annotations.FragmentModel;
import com.danielvilha.infra.mvc.base.BaseFragment;

import java.util.Observable;

/**
 * Created by scopus-dev on 26/06/17.
 */
@FragmentModel(path="com.danielvilha.asup.context.home.model.HomeModel")
public class HomeFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.rootLayout = inflater.inflate(R.layout.fragment_home, container, false);
        return super.rootLayout;
    }

    @Override
    public void initializeView() {
        super.viewHelper = new HomeViewHelper(HomeFragment.this);
    }

    @Override
    public void executeFirstLoad(Bundle savedInstanceState) {

    }

    @Override
    public void reloadView() {
        super.viewHelper = new HomeViewHelper(HomeFragment.this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public HomeViewHelper getViewHelper() {
        if(super.viewHelper == null){
            super.viewHelper = new HomeViewHelper(this);
        }
        return (HomeViewHelper) super.viewHelper;
    }

    public HomeModel getModel() {
        return (HomeModel) this.getFragmentModel();
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
