package com.danielvilha.asup.common.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by Daniel Vilha on 05/07/17.
 */
@Entity
public class Questions {

    @Id(autoincrement = true)
    private Long id;

    private int questionNumber;

    private String question;

    @ToMany(referencedJoinProperty = "questionId")
    private List<QuestionAlternatives> questionAlternatives;

    @ToMany(referencedJoinProperty = "questionId")
    private List<Alternatives> alternatives;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1274639985)
    private transient QuestionsDao myDao;

    @Generated(hash = 1771381680)
    public Questions(Long id, int questionNumber, String question) {
        this.id = id;
        this.questionNumber = questionNumber;
        this.question = question;
    }

    @Generated(hash = 1000657236)
    public Questions() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuestionNumber() {
        return this.questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 247078297)
    public List<QuestionAlternatives> getQuestionAlternatives() {
        if (questionAlternatives == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            QuestionAlternativesDao targetDao = daoSession
                    .getQuestionAlternativesDao();
            List<QuestionAlternatives> questionAlternativesNew = targetDao
                    ._queryQuestions_QuestionAlternatives(id);
            synchronized (this) {
                if (questionAlternatives == null) {
                    questionAlternatives = questionAlternativesNew;
                }
            }
        }
        return questionAlternatives;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1693010552)
    public synchronized void resetQuestionAlternatives() {
        questionAlternatives = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1593861501)
    public List<Alternatives> getAlternatives() {
        if (alternatives == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AlternativesDao targetDao = daoSession.getAlternativesDao();
            List<Alternatives> alternativesNew = targetDao
                    ._queryQuestions_Alternatives(id);
            synchronized (this) {
                if (alternatives == null) {
                    alternatives = alternativesNew;
                }
            }
        }
        return alternatives;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 837130811)
    public synchronized void resetAlternatives() {
        alternatives = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 586107410)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getQuestionsDao() : null;
    }
}
