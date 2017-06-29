package com.danielvilha.asup.application;

import android.app.Application;
import android.content.Context;

import com.danielvilha.asup.common.entity.DaoMaster;
import com.danielvilha.asup.common.entity.DaoSession;
import com.danielvilha.asup.context.company.eventlistener.OpenCompanyFragmentEventListener;
import com.danielvilha.asup.context.cooperative.eventlistener.OpenCooperativeFragmentEventListener;
import com.danielvilha.asup.context.home.eventlistener.OpenHomeFragmentEventListener;
import com.danielvilha.asup.context.personal.eventlistener.OpenPersonalFragmentEventListener;
import com.danielvilha.asup.context.report.eventlistener.OpenReportFragmentEventListener;
import com.danielvilha.infra.mvc.eventlistenerdispatcher.EventListenerDispatcher;
import com.danielvilha.infra.util.PriorityEnum;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Daniel Vilha 26/06/17.
 */

public class AppApplication extends Application {

    private static DaoSession daoSession;
    public static final boolean ENCRYPTED = false;

    public static AppApplication context;
    private Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;

    public AppApplication() {
        defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(unCaughtExceptionHandler);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,ENCRYPTED ? "asup-db-encrypted" : "asup-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("asup-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

        this.addAllEvents();
    }

    /**
     * Tratamento customizado para exceptions
     */
    private Thread.UncaughtExceptionHandler unCaughtExceptionHandler = new Thread.UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(Thread thread, Throwable ex) {
            // acaso seja uma excecao conhecida reinicia a aplicacao
            // if (AppUncaughtExceptionHelper.canBeCaught(context, ex)) {
            //     AppUncaughtExceptionHelper.restartApplication(context);
            // }

            // devolve a excecao para o default QUE para que o S.O trate
            defaultUncaughtExceptionHandler.uncaughtException(thread, ex);
        }
    };

    /**
     * Retorna o contexto da aplicacao
     *
     * @return context
     */
    public static Context getContext(){
        return context;
    }

    /**
     * Retorna o sessão do banco de dados
     *
     * @return daoSession
     */
    public static DaoSession getDaoSession() {
        return daoSession;
    }

    private void addAllEvents() {
        EventListenerDispatcher.getInstance().addEvent(new OpenHomeFragmentEventListener(), PriorityEnum.NORMAL);
        EventListenerDispatcher.getInstance().addEvent(new OpenCompanyFragmentEventListener(), PriorityEnum.NORMAL);
        EventListenerDispatcher.getInstance().addEvent(new OpenCooperativeFragmentEventListener(), PriorityEnum.NORMAL);
        EventListenerDispatcher.getInstance().addEvent(new OpenPersonalFragmentEventListener(), PriorityEnum.NORMAL);
        EventListenerDispatcher.getInstance().addEvent(new OpenReportFragmentEventListener(), PriorityEnum.NORMAL);
    }
}
