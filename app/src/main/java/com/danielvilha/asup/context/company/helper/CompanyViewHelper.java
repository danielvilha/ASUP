package com.danielvilha.asup.context.company.helper;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.danielvilha.asup.R;
import com.danielvilha.asup.application.AndroidAdapter;
import com.danielvilha.asup.common.controller.EconomicController;
import com.danielvilha.asup.common.controller.EnvironmentalController;
import com.danielvilha.asup.common.controller.SocialController;
import com.danielvilha.asup.common.entity.Answer;
import com.danielvilha.asup.common.entity.AnswerDao;
import com.danielvilha.asup.common.entity.DaoSession;
import com.danielvilha.asup.common.entity.Quiz;
import com.danielvilha.asup.common.entity.QuizDao;
import com.danielvilha.asup.context.company.fragment.CompanyFragment;
import com.danielvilha.asup.enums.EventsEnum;
import com.danielvilha.asup.enums.QuizType;
import com.danielvilha.infra.mvc.base.helper.IViewHelper;
import com.danielvilha.infra.mvc.event.VoidEventData;
import com.danielvilha.infra.mvc.eventlistenerdispatcher.EventListenerDispatcher;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Daniel Vilha 28/06/17.
 */

public class CompanyViewHelper implements IViewHelper {

    private CompanyFragment fragment;
    private LinearLayout content;
    private Button buttonSave;

    private RadioGroup rgEn1;
    private RadioGroup rgEn2;
    private RadioGroup rgEn3;
    private RadioGroup rgEn4;
    private RadioGroup rgEn5;
    private RadioGroup rgEc1;
    private RadioGroup rgEc2;
    private RadioGroup rgEc3;
    private RadioGroup rgEc4;
    private RadioGroup rgEc5;
    private RadioGroup rgSo1;
    private RadioGroup rgSo2;
    private RadioGroup rgSo3;
    private RadioGroup rgSo4;

    public CompanyViewHelper(CompanyFragment fragment) {
        this.fragment = fragment;

        findViewsById();
        setListeners();
    }

    @Override
    public void findViewsById() {
        content = (LinearLayout) fragment.getRootLayout().findViewById(R.id.content);
        content.setBackgroundColor(Color.parseColor("#4D80C000"));

        buttonSave = (Button) fragment.getRootLayout().findViewById(R.id.buttonSave);

        rgEn1 = (RadioGroup) fragment.getRootLayout().findViewById(R.id.radioGroupEnvironmentalQuest1);
        rgEn2 = (RadioGroup) fragment.getRootLayout().findViewById(R.id.radioGroupEnvironmentalQuest2);
        rgEn3 = (RadioGroup) fragment.getRootLayout().findViewById(R.id.radioGroupEnvironmentalQuest3);
        rgEn4 = (RadioGroup) fragment.getRootLayout().findViewById(R.id.radioGroupEnvironmentalQuest4);
        rgEn5 = (RadioGroup) fragment.getRootLayout().findViewById(R.id.radioGroupEnvironmentalQuest5);

        rgEc1 = (RadioGroup) fragment.getRootLayout().findViewById(R.id.radioGroupEconomicQuest1);
        rgEc2 = (RadioGroup) fragment.getRootLayout().findViewById(R.id.radioGroupEconomicQuest2);
        rgEc3 = (RadioGroup) fragment.getRootLayout().findViewById(R.id.radioGroupEconomicQuest3);
        rgEc4 = (RadioGroup) fragment.getRootLayout().findViewById(R.id.radioGroupEconomicQuest4);
        rgEc5 = (RadioGroup) fragment.getRootLayout().findViewById(R.id.radioGroupEconomicQuest5);

        rgSo1 = (RadioGroup) fragment.getRootLayout().findViewById(R.id.radioGroupSocialQuest1);
        rgSo2 = (RadioGroup) fragment.getRootLayout().findViewById(R.id.radioGroupSocialQuest2);
        rgSo3 = (RadioGroup) fragment.getRootLayout().findViewById(R.id.radioGroupSocialQuest3);
        rgSo4 = (RadioGroup) fragment.getRootLayout().findViewById(R.id.radioGroupSocialQuest4);
    }

    @Override
    public void setListeners() {
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnvironmentalController enController = new EnvironmentalController(rgEn1, rgEn2, rgEn3, rgEn4, rgEn5);
                EconomicController ecController = new EconomicController(rgEc1, rgEc2, rgEc3, rgEc4, rgEc5);
                SocialController soController = new SocialController(rgSo1, rgSo2, rgSo3, rgSo4);

                if (enController.isValid()) {
                    if (ecController.isValid()) {
                        if (soController.isValid()) {
                            DaoSession daoSession = AndroidAdapter.getDaoSession();

                            Quiz quiz = new Quiz();
                            quiz.setDate(Calendar.getInstance().getTime());
                            quiz.setType(QuizType.COMPANY.toString());

                            QuizDao dao = daoSession.getQuizDao();
                            dao.insert(quiz);

                            List<Answer> answers = new ArrayList<Answer>();
                            answers.addAll(soController.getAnsers(quiz.getId()));
                            answers.addAll(enController.getAnsers(quiz.getId()));
                            answers.addAll(ecController.getAnsers(quiz.getId()));

                            AnswerDao answerDao = daoSession.getAnswerDao();

                            for (Answer item: answers) {
                                answerDao.insert(item);
                            }

                            quiz.getAnswers().addAll(answers);

                            dao.update(quiz);

                            Toast.makeText(AndroidAdapter.getContext(), "Formulário salvo com sucesso.", Toast.LENGTH_SHORT).show();
                            VoidEventData event = new VoidEventData(EventsEnum.OPEN_HOME_FRAGMENT, null, fragment.getActivity());
                            EventListenerDispatcher.getInstance().dispatch(event);
                        } else {
                            Toast.makeText(AndroidAdapter.getContext(), "Preencher todas as questões do questionário SOCIAL.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(AndroidAdapter.getContext(), "Preencher todas as questões do questionário ECONOMIA.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AndroidAdapter.getContext(), "Preencher todas as questões do questionário AMBIENTE.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
