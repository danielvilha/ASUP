package com.danielvilha.infra.mvc.eventlistenerdispatcher;

import android.support.v4.util.Pair;

import java.util.ArrayList;
import java.util.List;

import com.danielvilha.infra.mvc.base.BaseEventData;
import com.danielvilha.infra.util.PriorityEnum;

/**
 * Created by danielvilha.
 */

public class EventListenerDispatcher {

    private static EventListenerDispatcher instance;
    private static List<Pair<AbstractEventListener, PriorityEnum>> events;

    private EventListenerDispatcher(){}

    public static EventListenerDispatcher getInstance(){
        if (instance == null){
            instance = new EventListenerDispatcher();
            events = new ArrayList<Pair<AbstractEventListener, PriorityEnum>>();
        }
        return instance;
    }

    public void addEvent(AbstractEventListener<?> event, PriorityEnum priority){
        if (this.findEventPair(event) == null){
            events.add(new Pair<AbstractEventListener, PriorityEnum>(event, priority));
        }
    }

    public void removeEvent(AbstractEventListener<?> event){
        Pair<AbstractEventListener, PriorityEnum> eventPair = this.findEventPair(event);
        if (eventPair != null){
            events.remove(eventPair);
        }
    }

    /**
     * Efetua o processamento do evento
     */
    public <T> void dispatch(BaseEventData<T> eventData) {
        System.out.println();
        for (Pair<AbstractEventListener, PriorityEnum> event : EventListenerDispatcherHelper.orderPriorityList(eventData, events)) {
            if ( (eventData.getParam() == null) || (event.first.getGenericClass().equals(eventData.getParam().getClass())) ){
                clearExtras(eventData);
                event.first.execute();

                if (event.first.isPreventDefault()){
                    event.first.eventReset();
                    break;
                }
            }
        }
    }

    private void clearExtras(BaseEventData eventData){
        try{
            eventData.getActivity().getIntent().getExtras().clear();
        } catch (Exception e){}
    }

    private Pair<AbstractEventListener, PriorityEnum> findEventPair(AbstractEventListener<?> event){
        for (Pair<AbstractEventListener, PriorityEnum> eventPair : events) {
            if (eventPair.first.equals(event)){
                return eventPair;
            }
        }

        return null;
    }
}
