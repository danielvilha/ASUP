package com.danielvilha.infra.mvc.eventlistenerdispatcher;

import android.support.v4.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.danielvilha.infra.mvc.base.BaseEventData;
import com.danielvilha.infra.util.PriorityEnum;

/**
 * Created by danielvilha.
 */

public class EventListenerDispatcherHelper {

    /**
     * @param events
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List<Pair<AbstractEventListener, PriorityEnum>> orderPriorityList(BaseEventData eventData, List<Pair<AbstractEventListener, PriorityEnum>> events){
        List<Pair<AbstractEventListener, PriorityEnum>> eventsOrdered = new ArrayList<Pair<AbstractEventListener,PriorityEnum>>();

        for (Pair<AbstractEventListener, PriorityEnum> event : events) {
            if ( (eventData.getParam() == null) ||
                    (event.first.getGenericClass().equals(eventData.getParam().getClass())) ){
                if (event.first.match(eventData)){
                    eventsOrdered.add(event);
                }
            }
        }

        orderEnumList(eventsOrdered);

        return eventsOrdered;
    }

    /**
     * Ordena baseado na prioridade.
     * @param lista
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void orderEnumList(List<Pair<AbstractEventListener, PriorityEnum>> lista){
        Collections.sort(lista, new Comparator() {
            public int compare(Object o1, Object o2) {
                Pair<AbstractEventListener<?>, PriorityEnum> p1 = (Pair<AbstractEventListener<?>, PriorityEnum>) o1;
                Pair<AbstractEventListener<?>, PriorityEnum> p2 = (Pair<AbstractEventListener<?>, PriorityEnum>) o2;
                return p2.second.ordinal() - p1.second.ordinal();
            }
        });
    }
}
