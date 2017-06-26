package com.danielvilha.infra.model;

/**
 * Created by danielvilha.
 */

public abstract class AbstractModel {

    protected Exception exception;
    protected Enum commandType;
    protected Object payload;
    protected ReturnModelHeader returnModelHeader;

    /**
     * @return the commandType
     */
    public Enum getCommandType() {
        return commandType;
    }
    /**
     * @param commandType the commandType to set
     */
    public void setCommandType(Enum commandType) {
        this.commandType = commandType;
    }
    /**
     * @return the payload
     */
    public abstract Object getPayload();

    /**
     * @param payload the payload to set
     */
    public abstract void setPayload(Object payload);
    /**
     * @return the exception
     */
    public Exception getException() {
        return exception;
    }
    /**
     * @param exception the exception to set
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }

    public ReturnModelHeader getReturnModelHeader() {
        return returnModelHeader;
    }

    public void setReturnModelHeader(ReturnModelHeader returnModelHeader) {
        this.returnModelHeader = returnModelHeader;
    }
}
