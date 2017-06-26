package com.danielvilha.asup.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by scopus-dev on 26/06/17.
 */

public class AppApplication extends Application {

//    private static DaoSession daoSession;
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

//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,ENCRYPTED ? "exam-db-encrypted" : "exam-db");
//        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("exam-secret") : helper.getWritableDb();
//        daoSession = new DaoMaster(db).newSession();

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
     * @return
     */
    public static Context getContext(){
        return context;
    }

    /**
     * Retorna o sessão do banco de dados
     *
     * @return
     */
//    public static DaoSession getDaoSession() {
//        return daoSession;
//    }

    private void addAllEvents() {
//        EventListenerDispatcher.getInstance().addEvent(new OpenHomeFragmentEventListener(), PriorityEnum.NORMAL);
//        EventListenerDispatcher.getInstance().addEvent(new OpenTeamFragmentEventListener(), PriorityEnum.NORMAL);
//        EventListenerDispatcher.getInstance().addEvent(new OpenAdjustmentsFragmentEventListener(), PriorityEnum.NORMAL);
//        EventListenerDispatcher.getInstance().addEvent(new OpenManeuverabilityFragmentEventListener(), PriorityEnum.NORMAL);
//        EventListenerDispatcher.getInstance().addEvent(new OpenRampFragmentEventListener(), PriorityEnum.NORMAL);
//        EventListenerDispatcher.getInstance().addEvent(new OpenSpeedFragmentEventListener(), PriorityEnum.NORMAL);
//        EventListenerDispatcher.getInstance().addEvent(new OpenTeamDetailFragmentEventListener(), PriorityEnum.NORMAL);
//        EventListenerDispatcher.getInstance().addEvent(new OpenTrackFragmentEventListener(), PriorityEnum.NORMAL);
//        EventListenerDispatcher.getInstance().addEvent(new OpenTractionFragmentEventListener(), PriorityEnum.NORMAL);
    }
}
