package com.danielvilha.infra.mvc.util;


import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import com.danielvilha.infra.mvc.base.BaseFragment;

/**
 * Created by danielvilha.
 */

public class FragmentContainerManager {

    private static FragmentContainerManager instance;
    private List<String> fragmentTagList = new ArrayList<String>();

    private FragmentContainerManager(){}

    public static FragmentContainerManager getInstance(){
        if (instance == null){
            instance = new FragmentContainerManager();
        }
        return instance;
    }

    public void addFragmentTag(String tag){
        if (!this.fragmentTagList.contains(tag)){
            this.fragmentTagList.add(tag);
        }
    }

    public void removeFragmentTag(String tag){
        this.fragmentTagList.remove(tag);
    }

    public int getCount(){
        return this.fragmentTagList.size();
    }

    public boolean contains(String tag){
        return this.fragmentTagList.contains(tag);
    }

    public String getTopFragmentTag() {
        if(this.fragmentTagList.size() == 0){
            return null;
        }

        return this.fragmentTagList.get(getCount() - 1);
    }

    public List<String> getFragmentTagListClone(){
        return this.fragmentTagList.subList(0, this.fragmentTagList.size());
    }

    public void replace(final int containerId, final FragmentActivity activity, final BaseFragment fragment, final boolean isRootFragment){
        if(activity == null || activity.isFinishing()){
            return;
        }

        // se root fragment remove toda a pilha de fragments
        if (isRootFragment){
            if (activity.getSupportFragmentManager().getBackStackEntryCount() > 0){
                FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                activity.getSupportFragmentManager().popBackStack(activity.getSupportFragmentManager().getBackStackEntryAt(0).getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
                transaction.commit();
            }

            fragmentTagList.clear();
        }

        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(containerId, fragment, fragment.getUuid());
        transaction.addToBackStack(fragment.getUuid());
        transaction.commit();
    }
}
