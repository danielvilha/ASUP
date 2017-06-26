package com.danielvilha.asup.context.environmental.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielvilha.asup.R;
import com.danielvilha.asup.context.environmental.helper.EnvironmentalViewHelper;
import com.danielvilha.asup.context.environmental.model.EnvironmentalModel;
import com.danielvilha.asup.context.home.fragment.HomeFragment;
import com.danielvilha.asup.context.home.helper.HomeViewHelper;
import com.danielvilha.asup.context.home.model.HomeModel;
import com.danielvilha.infra.mvc.annotations.FragmentModel;
import com.danielvilha.infra.mvc.base.BaseFragment;
import com.danielvilha.infra.mvc.base.helper.IViewHelper;

import java.util.Observable;

/**
 * Created by scopus-dev on 26/06/17.
 */
@FragmentModel(path="com.danielvilha.asup.context.environmental.model.EnvironmentalModel")
public class EnvironmentalFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.rootLayout = inflater.inflate(R.layout.fragment_environmental, container, false);
        return super.rootLayout;
    }

    @Override
    public void initializeView() {
        super.viewHelper = new EnvironmentalViewHelper(EnvironmentalFragment.this);
    }

    @Override
    public void executeFirstLoad(Bundle savedInstanceState) {

    }

    @Override
    public void reloadView() {
        super.viewHelper = new EnvironmentalViewHelper(EnvironmentalFragment.this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public EnvironmentalViewHelper getViewHelper() {
        if(super.viewHelper == null){
            super.viewHelper = new EnvironmentalViewHelper(this);
        }
        return (EnvironmentalViewHelper) super.viewHelper;
    }

    public EnvironmentalModel getModel() {
        return (EnvironmentalModel) this.getFragmentModel();
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
