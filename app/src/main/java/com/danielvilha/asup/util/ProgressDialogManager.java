package com.danielvilha.asup.util;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;

/**
 * Created by Daniel Vilha 26/06/17.
 */

public class ProgressDialogManager {

    private ProgressDialogManager() {
    }

    private static ProgressDialogManager instance;
    private ProgressDialog progressDialog;

    public static ProgressDialogManager getInstance() {
        if (instance == null) {
            instance = new ProgressDialogManager();
        }

        return instance;
    }

    public void showDialog(Fragment fragment, String message) {
        dismiss();
        progressDialog = ProgressDialog.show(fragment.getActivity(), null, message, false);
    }

    public void dismiss() {
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    public static void dispose(){
        instance = null;
    }
}
