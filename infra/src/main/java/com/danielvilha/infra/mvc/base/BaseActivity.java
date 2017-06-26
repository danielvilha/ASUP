package com.danielvilha.infra.mvc.base;

import android.support.v4.app.FragmentActivity;

import com.danielvilha.infra.mvc.util.FragmentContainerManager;

/**
 * Created by danielvilha.
 */

public class BaseActivity extends FragmentActivity {

	/*private long back_pressed;
	private Toast toast;*/

    @Override
    public void onBackPressed() {
		/*if (this.toast == null){
			this.toast = Toast.makeText(this, "Para sair pressione voltar 2 vezes!", Toast.LENGTH_SHORT);
		}*/
        if (FragmentContainerManager.getInstance().getCount() < 2){
            this.finish();
			/*if (back_pressed + 500 > System.currentTimeMillis()){
				this.toast.cancel();
				this.finish();
			} else {
				this.toast.show();
				back_pressed = System.currentTimeMillis();
			}*/
        } else {
            super.onBackPressed();
        }
    }
}
