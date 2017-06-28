package com.danielvilha.asup.context.cooperative.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielvilha.asup.R;
import com.danielvilha.asup.context.cooperative.helper.CooperativeViewHelper;
import com.danielvilha.asup.context.cooperative.model.CooperativeModel;
import com.danielvilha.infra.mvc.annotations.FragmentModel;
import com.danielvilha.infra.mvc.base.BaseFragment;

import java.util.Observable;

/**
 * Created by Daniel Vilha 28/06/17.
 */
@FragmentModel(path="com.danielvilha.asup.context.cooperative.model.CooperativeModel")
public class CooperativeFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.rootLayout = inflater.inflate(R.layout.fragment_form, container, false);
        return super.rootLayout;

    }

    @Override
    public void initializeView() {
        super.viewHelper = new CooperativeViewHelper(CooperativeFragment.this);
    }

    @Override
    public void executeFirstLoad(Bundle savedInstanceState) {

    }

    @Override
    public void reloadView() {
        super.viewHelper = new CooperativeViewHelper(CooperativeFragment.this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public CooperativeViewHelper getViewHelper() {
        if(super.viewHelper == null){
            super.viewHelper = new CooperativeViewHelper(this);
        }
        return (CooperativeViewHelper) super.viewHelper;
    }

    public CooperativeModel getModel() {
        return (CooperativeModel) this.getFragmentModel();
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
