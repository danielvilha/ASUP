package com.danielvilha.asup.common.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by scopus-dev on 05/07/17.
 */
@Entity
public class Alternatives {

    @Id(autoincrement = true)
    private Long id;

    private Long questionId;

    private String alternative;

    @Generated(hash = 24446696)
    public Alternatives(Long id, Long questionId, String alternative) {
        this.id = id;
        this.questionId = questionId;
        this.alternative = alternative;
    }

    @Generated(hash = 995496085)
    public Alternatives() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAlternative() {
        return this.alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }
}
