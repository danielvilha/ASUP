package com.danielvilha.asup.common.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Daniel Vilha 28/06/17.
 */
@Entity
public class Answer {

    @Id(autoincrement = true)
    private Long id;

    private int answer;

    private double value;

    private int questionNumber;

    private String type;

    private Long quizId;

    @Generated(hash = 43927468)
    public Answer(Long id, int answer, double value, int questionNumber,
            String type, Long quizId) {
        this.id = id;
        this.answer = answer;
        this.value = value;
        this.questionNumber = questionNumber;
        this.type = type;
        this.quizId = quizId;
    }

    @Generated(hash = 53889439)
    public Answer() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAnswer() {
        return this.answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getQuestionNumber() {
        return this.questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getQuizId() {
        return this.quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }
}
