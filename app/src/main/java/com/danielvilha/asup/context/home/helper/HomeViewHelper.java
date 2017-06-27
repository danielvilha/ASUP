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
 * Created by scopus-dev on 26/06/17.
 */

public class HomeViewHelper implements IViewHelper {

    private HomeFragment fragment;
    private Button buttonHomeEconomic;
    private Button buttonHomeEnvironmental;
    private Button buttonHomeSocial;


    public HomeViewHelper(HomeFragment fragment) {
        this.fragment = fragment;

        findViewsById();
        setListeners();
    }

    @Override
    public void findViewsById() {
        buttonHomeEconomic = (Button) fragment.getRootLayout().findViewById(R.id.buttonEconomic);
        buttonHomeEnvironmental = (Button) fragment.getRootLayout().findViewById(R.id.buttonEnvironmental);
        buttonHomeSocial = (Button) fragment.getRootLayout().findViewById(R.id.buttonSocial);
    }

    @Override
    public void setListeners() {
        buttonHomeEconomic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VoidEventData event = new VoidEventData(EventsEnum.OPEN_ECONOMIC_FRAGMENT, null, fragment.getActivity());
                EventListenerDispatcher.getInstance().dispatch(event);
            }
        });

        buttonHomeEnvironmental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VoidEventData event = new VoidEventData(EventsEnum.OPEN_ENVIRONMENTAL_FRAGMENT, null, fragment.getActivity());
                EventListenerDispatcher.getInstance().dispatch(event);
            }
        });

        buttonHomeSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VoidEventData event = new VoidEventData(EventsEnum.OPEN_SOCIAL_FRAGMENT, null, fragment.getActivity());
                EventListenerDispatcher.getInstance().dispatch(event);
            }
        });
    }
}
