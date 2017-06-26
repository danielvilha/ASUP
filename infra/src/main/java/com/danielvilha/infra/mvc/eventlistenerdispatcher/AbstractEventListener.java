package com.danielvilha.infra.mvc.eventlistenerdispatcher;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.danielvilha.infra.mvc.base.BaseEventData;

/**
 * Created by danielvilha.
 */

public abstract class AbstractEventListener<T> {

    private boolean preventDefault = Boolean.FALSE;

    /**
     * Seta o estado de preventDefault
     */
    protected void preventDefault(){
        preventDefault = Boolean.TRUE;
    }

    /**
     * Retorna o estado de preventDefault
     * @return preventDefault
     */
    public boolean isPreventDefault(){
        return preventDefault;
    }

    /**
     * Retorna as variáveis ao estado original
     */
    protected void eventReset(){
        this.preventDefault = Boolean.FALSE;
    }

    public abstract boolean match(BaseEventData<T> eventData);

    public abstract void execute();

    public Class<?> getGenericClass(){
        Class<?> result =null;
        Type type = this.getClass().getGenericSuperclass();

        if(type instanceof ParameterizedType){
            ParameterizedType pt =(ParameterizedType) type;
            Type[] fieldArgTypes = pt.getActualTypeArguments();
            result =(Class<?>) fieldArgTypes[0];
        }

        return result;
    }
}
