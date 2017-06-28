package com.danielvilha.asup.context.personal.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielvilha.asup.R;
import com.danielvilha.asup.context.personal.helper.PersonalViewHelper;
import com.danielvilha.asup.context.personal.model.PersonalModel;
import com.danielvilha.infra.mvc.annotations.FragmentModel;
import com.danielvilha.infra.mvc.base.BaseFragment;

import java.util.Observable;

/**
 * Created by Daniel Vilha 28/06/17.
 */
@FragmentModel(path="com.danielvilha.asup.context.personal.model.PersonalModel")
public class PersonalFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.rootLayout = inflater.inflate(R.layout.fragment_form, container, false);
        return super.rootLayout;

    }

    @Override
    public void initializeView() {
        super.viewHelper = new PersonalViewHelper(PersonalFragment.this);
    }

    @Override
    public void executeFirstLoad(Bundle savedInstanceState) {

    }

    @Override
    public void reloadView() {
        super.viewHelper = new PersonalViewHelper(PersonalFragment.this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public PersonalViewHelper getViewHelper() {
        if(super.viewHelper == null){
            super.viewHelper = new PersonalViewHelper(this);
        }
        return (PersonalViewHelper) super.viewHelper;
    }

    public PersonalModel getModel() {
        return (PersonalModel) this.getFragmentModel();
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
