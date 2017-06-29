package com.danielvilha.asup.context.report.helper;

import android.widget.ExpandableListView;

import com.danielvilha.asup.R;
import com.danielvilha.asup.application.AndroidAdapter;
import com.danielvilha.asup.common.adapter.Adapter;
import com.danielvilha.asup.common.entity.Answer;
import com.danielvilha.asup.common.entity.AnswerDao;
import com.danielvilha.asup.common.entity.DaoSession;
import com.danielvilha.asup.common.entity.Quiz;
import com.danielvilha.asup.common.entity.QuizDao;
import com.danielvilha.asup.context.report.fragment.ReportFragment;
import com.danielvilha.asup.enums.QuizType;
import com.danielvilha.infra.mvc.base.helper.IViewHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Daniel Vilha 28/06/17.
 */

public class ReportViewHelper implements IViewHelper {

    private ReportFragment fragment;
    private ExpandableListView listView;

    private Adapter adapter;

    public ReportViewHelper(ReportFragment fragment) {
        this.fragment = fragment;

        findViewsById();
        setListeners();

        setAdapters();
    }

    @Override
    public void findViewsById() {
        listView = (ExpandableListView) fragment.getRootLayout().findViewById(R.id.listView);
    }

    @Override
    public void setListeners() {

    }

    private void setAdapters() {
        DaoSession daoSession = AndroidAdapter.getDaoSession();
        QuizDao quizDao = daoSession.getQuizDao();
        List<Quiz> quizs = quizDao.loadAll();

//        AnswerDao answerDao = daoSession.getAnswerDao();
//        List<Answer> answer = answerDao.loadAll();

//        List<Quiz> quizsPersonal = new ArrayList<Quiz>();
//        List<Quiz> quizsCooperative = new ArrayList<Quiz>();
//        List<Quiz> quizsCompany = new ArrayList<Quiz>();
//
//        for (Quiz item : quizs) {
//            if (item.getType().equals(QuizType.PERSONAL.toString())) {
//                quizsPersonal.add(item);
//            } else if (item.getType().equals(QuizType.COOPERATIVE.toString())) {
//                quizsCooperative.add(item);
//            } else {
//                quizsCompany.add(item);
//            }
//        }


        HashMap<Quiz, List<Answer>> hasMap = toHasMapAnswer(quizs);

        adapter = new Adapter(fragment, quizs, hasMap);
        listView.setAdapter(adapter);
    }

    private HashMap<Quiz, List<Answer>> toHasMapAnswer(List<Quiz> quizs) {
        HashMap<Quiz, List<Answer>> quizListHashMap = new HashMap<Quiz, List<Answer>>();

        for (Quiz item: quizs) {
            quizListHashMap.put(item, item.getAnswers());
        }

        return quizListHashMap;
    }
}