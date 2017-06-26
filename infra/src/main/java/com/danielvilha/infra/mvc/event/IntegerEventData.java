package com.danielvilha.infra.mvc.event;

import android.support.v4.app.FragmentActivity;

import com.danielvilha.infra.mvc.base.BaseEventData;

/**
 * Created by danielvilha.
 */

public class IntegerEventData extends BaseEventData<Integer> {

    /**
     * @param event
     * @param param
     */
    public IntegerEventData(Enum<?> event, Integer param, FragmentActivity activity) {
        super(event, param, activity);
    }
}
