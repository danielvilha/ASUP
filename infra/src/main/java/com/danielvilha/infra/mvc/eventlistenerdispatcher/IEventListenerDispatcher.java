package com.danielvilha.infra.mvc.eventlistenerdispatcher;

import com.danielvilha.infra.mvc.base.BaseEventData;

/**
 * Created by danielvilha.
 */

public interface IEventListenerDispatcher <T> {

    public void addEvent(AbstractEventListener<T> event);

    public void removeEvent(AbstractEventListener<T> event);

    public void dispatchEvent(BaseEventData<T> eventData);
}
