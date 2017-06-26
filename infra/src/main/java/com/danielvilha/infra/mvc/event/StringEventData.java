package com.danielvilha.infra.mvc.event;

import android.support.v4.app.FragmentActivity;

import com.danielvilha.infra.mvc.base.BaseEventData;

/**
 * Created by danielvilha.
 */

public class StringEventData extends BaseEventData<String> {

    /**
     * @param event
     * @param param
     */
    public StringEventData(Enum<?> event, String param, FragmentActivity activity) {
        super(event, param, activity);
    }
}
