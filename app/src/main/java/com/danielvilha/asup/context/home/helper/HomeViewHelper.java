package com.danielvilha.asup.context.home.helper;

import android.view.View;
import android.widget.Button;

import com.danielvilha.asup.R;
import com.danielvilha.asup.activities.BootstrapActivity;
import com.danielvilha.asup.application.AndroidAdapter;
import com.danielvilha.asup.context.home.fragment.HomeFragment;
import com.danielvilha.asup.enums.EventsEnum;
import com.danielvilha.infra.mvc.base.helper.IViewHelper;
import com.danielvilha.infra.mvc.event.VoidEventData;
import com.danielvilha.infra.mvc.eventlistenerdispatcher.EventListenerDispatcher;

/**
 * Created by Daniel Vilha 26/06/17.
 */

public class HomeViewHelper implements IViewHelper {

    private HomeFragment fragment;
    private Button buttonHomeCompany;
    private Button buttonHomeCooperative;
    private Button buttonHomePersonal;


    public HomeViewHelper(HomeFragment fragment) {
        this.fragment = fragment;

        findViewsById();
        setListeners();
    }

    @Override
    public void findViewsById() {
        buttonHomeCompany = (Button) fragment.getRootLayout().findViewById(R.id.buttonCompany);
        buttonHomeCooperative = (Button) fragment.getRootLayout().findViewById(R.id.buttonCooperative);
        buttonHomePersonal = (Button) fragment.getRootLayout().findViewById(R.id.buttonPersonal);
    }

    @Override
    public void setListeners() {
        buttonHomeCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VoidEventData event = new VoidEventData(EventsEnum.OPEN_COMPANY_FRAGMENT, null, fragment.getActivity());
                EventListenerDispatcher.getInstance().dispatch(event);
            }
        });

        buttonHomeCooperative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VoidEventData event = new VoidEventData(EventsEnum.OPEN_COOPERATIVE_FRAGMENT, null, fragment.getActivity());
                EventListenerDispatcher.getInstance().dispatch(event);
            }
        });

        buttonHomePersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VoidEventData event = new VoidEventData(EventsEnum.OPEN_PERSONAL_FRAGMENT, null, fragment.getActivity());
                EventListenerDispatcher.getInstance().dispatch(event);
            }
        });
    }
}
