package com.danielvilha.infra.mvc.processor;

/**
 * Created by danielvilha.
 */

public interface IMatchProcessor {

    public boolean match(Object object);

    public Object execute();
}
