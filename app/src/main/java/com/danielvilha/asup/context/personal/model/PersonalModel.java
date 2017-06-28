package com.danielvilha.asup.context.personal.model;

import com.danielvilha.asup.common.entity.Personal;
import com.danielvilha.infra.mvc.base.BaseFragmentModel;

/**
 * Created by Daniel Vilha 28/06/17.
 */

public class PersonalModel extends BaseFragmentModel {

    private Personal personal;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}
