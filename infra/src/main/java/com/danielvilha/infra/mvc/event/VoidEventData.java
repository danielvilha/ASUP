package com.danielvilha.infra.mvc.event;

import android.support.v4.app.FragmentActivity;

import com.danielvilha.infra.mvc.base.BaseEventData;

/**
 * Created by danielvilha.
 */

public class VoidEventData extends BaseEventData<Void> {

    /**
     * @param event
     * @param param
     */
    public VoidEventData(Enum<?> event, Void param, FragmentActivity activity) {
        super(event, param, activity);
    }
}
