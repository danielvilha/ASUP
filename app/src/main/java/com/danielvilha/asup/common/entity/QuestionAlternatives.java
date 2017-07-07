package com.danielvilha.asup.common.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Daniel Vilha on 05/07/17.
 */
@Entity
public class QuestionAlternatives {

    @Id(autoincrement = true)
    private Long id;

    private Long questionId;

    private String questionAlternative;

    @Generated(hash = 2100448282)
    public QuestionAlternatives(Long id, Long questionId,
            String questionAlternative) {
        this.id = id;
        this.questionId = questionId;
        this.questionAlternative = questionAlternative;
    }

    @Generated(hash = 1014217753)
    public QuestionAlternatives() {
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

    public String getQuestionAlternative() {
        return this.questionAlternative;
    }

    public void setQuestionAlternative(String questionAlternative) {
        this.questionAlternative = questionAlternative;
    }
}
