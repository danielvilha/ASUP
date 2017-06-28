package com.danielvilha.asup.context.report.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielvilha.asup.R;
import com.danielvilha.asup.context.report.helper.ReportViewHelper;
import com.danielvilha.asup.context.report.model.ReportModel;
import com.danielvilha.infra.mvc.annotations.FragmentModel;
import com.danielvilha.infra.mvc.base.BaseFragment;

import java.util.Observable;

/**
 * Created by Daniel Vilha 28/06/17.
 */
@FragmentModel(path="com.danielvilha.asup.context.report.model.ReportModel")
public class ReportFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.rootLayout = inflater.inflate(R.layout.fragment_report, container, false);
        return super.rootLayout;

    }

    @Override
    public void initializeView() {
        super.viewHelper = new ReportViewHelper(ReportFragment.this);
    }

    @Override
    public void executeFirstLoad(Bundle savedInstanceState) {

    }

    @Override
    public void reloadView() {
        super.viewHelper = new ReportViewHelper(ReportFragment.this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public ReportViewHelper getViewHelper() {
        if(super.viewHelper == null){
            super.viewHelper = new ReportViewHelper(this);
        }
        return (ReportViewHelper) super.viewHelper;
    }

    public ReportModel getModel() {
        return (ReportModel) this.getFragmentModel();
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
