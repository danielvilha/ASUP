package com.danielvilha.infra.model;

/**
 * Created by danielvilha.
 */

public class ReturnModel extends AbstractModel {

    /* (non-Javadoc)
     * @see br.com.gvt.infra.model.AbstractModel#getPayload()
     */
    @Override
    public Object getPayload() {
        return this.payload;
    }

    /* (non-Javadoc)
     * @see br.com.gvt.infra.model.AbstractModel#setPayload(java.lang.Object)
     */
    @Override
    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
