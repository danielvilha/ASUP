package com.danielvilha.asup.context.economic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielvilha.asup.R;
import com.danielvilha.asup.context.economic.helper.EconomicViewHelper;
import com.danielvilha.asup.context.economic.model.EconomicModel;
import com.danielvilha.infra.mvc.annotations.FragmentModel;
import com.danielvilha.infra.mvc.base.BaseFragment;
import com.danielvilha.infra.mvc.base.helper.IViewHelper;

import java.util.Observable;

/**
 * Created by scopus-dev on 26/06/17.
 */
@FragmentModel(path="com.danielvilha.asup.context.economic.model.EconomicModel")
public class EconomicFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.rootLayout = inflater.inflate(R.layout.fragment_economic, container, false);
        return super.rootLayout;
    }

    @Override
    public void initializeView() {
        super.viewHelper = new EconomicViewHelper(EconomicFragment.this);
    }

    @Override
    public void executeFirstLoad(Bundle savedInstanceState) {

    }

    @Override
    public void reloadView() {
        super.viewHelper = new EconomicViewHelper(EconomicFragment.this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public EconomicViewHelper getViewHelper() {
        if(super.viewHelper == null){
            super.viewHelper = new EconomicViewHelper(this);
        }
        return (EconomicViewHelper) super.viewHelper;
    }

    public EconomicModel getModel() {
        return (EconomicModel) this.getFragmentModel();
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
