package com.danielvilha.asup.application.helper;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.danielvilha.asup.activities.BootstrapActivity;

/**
 * Created by Daniel Vilha 26/06/17.
 */

public class AppUncaughtExceptionHelper {
    /**
     * Exceptions que queve ser tratado
     * @param ex
     * @return
     */
    public static boolean canBeCaught(Context context, Throwable ex){

        if(ex == null){
            return false;
        }

        // causas conhecidas e devem ser tratadas
        if(ex.getCause() != null){
            if(canBeCaughtByCause(ex)){
                return true;
            }
        }else{
            if(canBeCaughtByType(ex)){
                return true;
            }
        }


        return false;
    }

    /**
     * Causas que deve ser tratado
     * @param ex
     * @return
     */
    public static boolean canBeCaughtByCause(Throwable ex){
        if (ex.getCause() instanceof java.lang.InstantiationException||
                ex.getCause() instanceof android.support.v4.app.Fragment.InstantiationException ||
                ex.getCause() instanceof java.lang.OutOfMemoryError){

            return true;
        }

        return false;
    }

    /**
     * Tipos que deve ser tratado
     * @param ex
     * @return
     */
    public static boolean canBeCaughtByType(Throwable ex){
        if (ex instanceof java.lang.InstantiationException||
                ex instanceof android.support.v4.app.Fragment.InstantiationException ||
                ex instanceof java.lang.OutOfMemoryError){

            return true;
        }

        return false;
    }

    /**
     * agenda a abertura da {@link BootstrapActivity} e mata a application atual
     * @param context
     */
    public static void restartApplication(Context context){
        Intent intent = new Intent(context, BootstrapActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        ((AlarmManager) context.getSystemService(Context.ALARM_SERVICE)).set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 100, pendingIntent);

        System.exit(2);
    }
}
