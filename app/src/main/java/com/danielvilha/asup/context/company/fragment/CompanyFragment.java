package com.danielvilha.asup.context.company.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielvilha.asup.R;
import com.danielvilha.asup.context.company.helper.CompanyViewHelper;
import com.danielvilha.asup.context.company.model.CompanyModel;
import com.danielvilha.infra.mvc.annotations.FragmentModel;
import com.danielvilha.infra.mvc.base.BaseFragment;

import java.util.Observable;

/**
 * Created by Daniel Vilha 28/06/17.
 */
@FragmentModel(path="com.danielvilha.asup.context.company.model.CompanyModel")
public class CompanyFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.rootLayout = inflater.inflate(R.layout.fragment_form, container, false);
        return super.rootLayout;

    }

    @Override
    public void initializeView() {
        super.viewHelper = new CompanyViewHelper(CompanyFragment.this);
    }

    @Override
    public void executeFirstLoad(Bundle savedInstanceState) {

    }

    @Override
    public void reloadView() {
        super.viewHelper = new CompanyViewHelper(CompanyFragment.this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public CompanyViewHelper getViewHelper() {
        if(super.viewHelper == null){
            super.viewHelper = new CompanyViewHelper(this);
        }
        return (CompanyViewHelper) super.viewHelper;
    }

    public CompanyModel getModel() {
        return (CompanyModel) this.getFragmentModel();
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
