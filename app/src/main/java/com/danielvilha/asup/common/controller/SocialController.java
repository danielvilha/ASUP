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

public class SocialController {

    private RadioGroup rg1;
    private RadioGroup rg2;
    private RadioGroup rg3;
    private RadioGroup rg4;

    public SocialController(RadioGroup rg1, RadioGroup rg2, RadioGroup rg3, RadioGroup rg4) {
        this.rg1 = rg1;
        this.rg2 = rg2;
        this.rg3 = rg3;
        this.rg4 = rg4;
    }

    public Boolean isValid() {
        int id1 = rg1.getCheckedRadioButtonId();
        int id2 = rg2.getCheckedRadioButtonId();
        int id3 = rg3.getCheckedRadioButtonId();
        int id4 = rg4.getCheckedRadioButtonId();

        if (id1 > -1 && id2 > -1 && id3 > -1 && id4 > -1)
            return true;

        return false;
    }

    public List<Answer> getAnsers(Long quizId) {
        List<Answer> answers = new ArrayList<Answer>();

        int id1 = rg1.getCheckedRadioButtonId();
        int id2 = rg2.getCheckedRadioButtonId();
        int id3 = rg3.getCheckedRadioButtonId();
        int id4 = rg4.getCheckedRadioButtonId();
        View rb1 = rg1.findViewById(id1);
        View rb2 = rg2.findViewById(id2);
        View rb3 = rg3.findViewById(id3);
        View rb4 = rg4.findViewById(id4);
        int idx1 = rg1.indexOfChild(rb1);
        int idx2 = rg2.indexOfChild(rb2);
        int idx3 = rg3.indexOfChild(rb3);
        int idx4 = rg4.indexOfChild(rb4);

        Answer a1 = new Answer();
        Answer a2 = new Answer();
        Answer a3 = new Answer();
        Answer a4 = new Answer();

        a1.setAnswer(idx1);
        a1.setQuestionNumber(1);
        a1.setValue((4-idx1)/4);
        a1.setQuizId(quizId);
        a1.setType(AnswerType.SOCIAL.toString());
        answers.add(a1);

        a2.setAnswer(idx2);
        a2.setQuestionNumber(2);
        a2.setValue((2-idx2)/2);
        a2.setQuizId(quizId);
        a2.setType(AnswerType.SOCIAL.toString());
        answers.add(a2);

        a3.setAnswer(idx3);
        a3.setQuestionNumber(3);
        a3.setValue((4-idx3)/4);
        a3.setQuizId(quizId);
        a3.setType(AnswerType.SOCIAL.toString());
        answers.add(a3);

        a4.setAnswer(idx4);
        a4.setQuestionNumber(4);
        a4.setValue((3-idx4)/3);
        a4.setQuizId(quizId);
        a4.setType(AnswerType.SOCIAL.toString());
        answers.add(a4);

        return answers;
    }
}
