package com.danielvilha.asup.context.report.helper;

import com.danielvilha.asup.context.report.fragment.ReportFragment;
import com.danielvilha.infra.mvc.base.helper.IViewHelper;

/**
 * Created by Daniel Vilha 28/06/17.
 */

public class ReportViewHelper implements IViewHelper {

    private ReportFragment fragment;

    public ReportViewHelper(ReportFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void findViewsById() {

    }

    @Override
    public void setListeners() {

    }
}
