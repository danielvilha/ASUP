package com.danielvilha.infra.mvc.base;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.UUID;

import com.danielvilha.infra.mvc.base.helper.IViewHelper;
import com.danielvilha.infra.mvc.eventlistenerdispatcher.EventListenerDispatcher;
import com.danielvilha.infra.mvc.util.FragmentContainerManager;

/**
 * Created by danielvilha.
 */

public abstract class BaseFragment extends Fragment implements Observer {

    /**
     * View que contem o layout inflado
     */
    protected View rootLayout;

    private final String uuid;

    protected IViewHelper viewHelper;

    /**
     * Handler vinculado a main thread
     */
    protected Handler handler;

    public BaseFragment(){
        uuid = this.getClass().getSimpleName() + UUID.randomUUID().toString();
    }

    public BaseFragmentModel getFragmentModel() {
        try {
            return FragmentModelFactory.getInstance().getFragmentModel(this);
        } catch (ClassNotFoundException e) {
            Log.e("Error", e.getMessage());
        } catch (java.lang.InstantiationException e) {
            Log.e("Error", e.getMessage());
        } catch (IllegalAccessException e) {
            Log.e("Error", e.getMessage());
        }
        return null;
    }

    public void cleanFragmentModel(){
        FragmentModelFactory.getInstance().cleanFragmentModel(this);
    }

    public BaseActivity getBaseActivity(){
        return (BaseActivity) getActivity();
    }

    public void dispatchEvent(BaseEventData<?> eventData) {
        EventListenerDispatcher.getInstance().dispatch(eventData);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (this.getFragmentModel() != null){
            this.getFragmentModel().addObserver(this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (this.getFragmentModel() != null){
            this.getFragmentModel().deleteObserver(this);
        }
    }

    private boolean initializedBefore = Boolean.FALSE;
    public abstract void initializeView();
    public abstract void executeFirstLoad(Bundle savedInstanceState);
    public abstract void reloadView();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(! initializedBefore){
            FragmentModelFactory.getInstance().cleanFragmentModel(this);
        }

        if (this.getFragmentModel() != null){
            this.getFragmentModel().addObserver(this);
        }

        if(handler == null){
            handler = new Handler(Looper.getMainLooper());
        }

        if (initializedBefore){
            initializeView();
            reloadView();
        } else {
            initializedBefore = Boolean.TRUE;
            initializeView();
            executeFirstLoad(getArguments());
        }
    }

    /**
     * Retorna o  layout da {@link Fragment} em questao
     * @return
     */
    public View getRootLayout(){
        return rootLayout;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.cleanFragmentModel();
        FragmentContainerManager.getInstance().removeFragmentTag(uuid);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        FragmentContainerManager.getInstance().addFragmentTag(uuid);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        FragmentContainerManager.getInstance().removeFragmentTag(uuid);
        viewHelper = null;
    }

    /**
     * Caso a fragment nao esteja visivel nao acontece o match processor para os eventos de update da view
     */
    protected boolean canUpdate(Object data){
        // a validacao this.isVisible() causa problema na WelcomeFragment
        if(/*! this.isVisible() || */this.getActivity() == null || data == null){
            return false;
        }

        return true;
    }


    private List<View> getAllChildrenBFS(View v) {
        List<View> visited = new ArrayList<View>();
        List<View> unvisited = new ArrayList<View>();
        unvisited.add(v);

        while (!unvisited.isEmpty()) {
            View child = unvisited.remove(0);
            visited.add(child);
            if (!(child instanceof ViewGroup)) continue;
            ViewGroup group = (ViewGroup) child;
            final int childCount = group.getChildCount();
            for (int i=0; i<childCount; i++) unvisited.add(group.getChildAt(i));
        }

        return visited;
    }

    public String getUuid() {
        return uuid;
    }

    /**
     * Retorna o {@link IViewHelper} da fragment
     * @return
     */
    public abstract IViewHelper getViewHelper();
}
