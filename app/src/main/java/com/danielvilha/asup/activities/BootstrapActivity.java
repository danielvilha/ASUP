package com.danielvilha.asup.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.danielvilha.asup.R;
import com.danielvilha.asup.enums.EventsEnum;
import com.danielvilha.infra.mvc.event.VoidEventData;
import com.danielvilha.infra.mvc.eventlistenerdispatcher.EventListenerDispatcher;

public class BootstrapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bootstrap);

        init();
    }

    private void init() {
        VoidEventData event = new VoidEventData(EventsEnum.OPEN_HOME_FRAGMENT, null, BootstrapActivity.this);
        EventListenerDispatcher.getInstance().dispatch(event);
    }
}
