package com.danielvilha.asup.common.controller;

import android.view.View;
import android.widget.RadioGroup;

import com.danielvilha.asup.common.entity.Answer;
import com.danielvilha.asup.enums.AnswerType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Vilha 28/06/17.
 */

public class EconomicController {

    private RadioGroup rg1;
    private RadioGroup rg2;
    private RadioGroup rg3;
    private RadioGroup rg4;
    private RadioGroup rg5;

    public EconomicController(RadioGroup rg1, RadioGroup rg2, RadioGroup rg3, RadioGroup rg4, RadioGroup rg5) {
        this.rg1 = rg1;
        this.rg2 = rg2;
        this.rg3 = rg3;
        this.rg4 = rg4;
        this.rg5 = rg5;
    }

    public Boolean isValid() {
        int id1 = rg1.getCheckedRadioButtonId();
        int id2 = rg2.getCheckedRadioButtonId();
        int id3 = rg3.getCheckedRadioButtonId();
        int id4 = rg4.getCheckedRadioButtonId();
        int id5 = rg5.getCheckedRadioButtonId();

        if (id1 > -1 && id2 > -1 && id3 > -1 && id4 > -1 && id5 > -1)
            return true;

        return false;
    }

    public List<Answer> getAnsers(Long quizId) {
        List<Answer> answers = new ArrayList<Answer>();

        int id1 = rg1.getCheckedRadioButtonId();
        int id2 = rg2.getCheckedRadioButtonId();
        int id3 = rg3.getCheckedRadioButtonId();
        int id4 = rg4.getCheckedRadioButtonId();
        int id5 = rg5.getCheckedRadioButtonId();
        View rb1 = rg1.findViewById(id1);
        View rb2 = rg2.findViewById(id2);
        View rb3 = rg3.findViewById(id3);
        View rb4 = rg4.findViewById(id4);
        View rb5 = rg5.findViewById(id5);
        int idx1 = rg1.indexOfChild(rb1);
        int idx2 = rg2.indexOfChild(rb2);
        int idx3 = rg3.indexOfChild(rb3);
        int idx4 = rg4.indexOfChild(rb4);
        int idx5 = rg5.indexOfChild(rb5);

        Answer a1 = new Answer();
        Answer a2 = new Answer();
        Answer a3 = new Answer();
        Answer a4 = new Answer();
        Answer a5 = new Answer();

        a1.setAnswer(idx1);
        a1.setQuestionNumber(1);
        a1.setValue((4-idx1)/4);
        a1.setQuizId(quizId);
        a1.setType(AnswerType.ECONOMIC.toString());
        answers.add(a1);

        a2.setAnswer(idx2);
        a2.setQuestionNumber(2);
        a2.setValue((3-idx2)/3);
        a2.setQuizId(quizId);
        a2.setType(AnswerType.ECONOMIC.toString());
        answers.add(a2);

        a3.setAnswer(idx3);
        a3.setQuestionNumber(3);
        a3.setValue((3-idx3)/3);
        a3.setQuizId(quizId);
        a3.setType(AnswerType.ECONOMIC.toString());
        answers.add(a3);

        a4.setAnswer(idx4);
        a4.setQuestionNumber(4);
        a4.setValue((3-idx4)/3);
        a4.setQuizId(quizId);
        a4.setType(AnswerType.ECONOMIC.toString());
        answers.add(a4);

        a5.setAnswer(idx5);
        a5.setQuestionNumber(5);
        a5.setValue((3-idx5)/3);
        a5.setQuizId(quizId);
        a5.setType(AnswerType.ECONOMIC.toString());
        answers.add(a5);

        return answers;
    }
}
