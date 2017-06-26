package com.danielvilha.infra.mvc.base;

import android.support.v4.app.FragmentActivity;

/**
 * Created by danielvilha.
 */

public abstract class BaseEventData<T> {

    private Enum<?> event;
    private T param;
    private FragmentActivity activity;

    public BaseEventData(Enum<?> event, T param, FragmentActivity activity) {
        this.event = event;
        this.param = param;
        this.activity = activity;
    }

    /**
     * @return the event
     */
    public Enum getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Enum event) {
        this.event = event;
    }

    /**
     * @return the param
     */
    public T getParam() {
        return param;
    }

    /**
     * @param param the param to set
     */
    public void setParam(T param) {
        this.param = param;
    }

    /**
     * @return the activity
     */
    public FragmentActivity getActivity() {
        return activity;
    }

    /**
     * @param activity the activity to set
     */
    public void setActivity(FragmentActivity activity) {
        this.activity = activity;
    }
}
