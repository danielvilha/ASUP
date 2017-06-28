package com.danielvilha.asup.context.cooperative.eventlistener;

import android.support.v4.app.FragmentActivity;

import com.danielvilha.asup.R;
import com.danielvilha.asup.context.cooperative.fragment.CooperativeFragment;
import com.danielvilha.asup.enums.EventsEnum;
import com.danielvilha.infra.mvc.base.BaseEventData;
import com.danielvilha.infra.mvc.event.VoidEventData;
import com.danielvilha.infra.mvc.eventlistenerdispatcher.AbstractEventListener;
import com.danielvilha.infra.mvc.util.FragmentContainerManager;

/**
 * Created by Daniel Vilha 28/06/17.
 */

public class OpenCooperativeFragmentEventListener extends AbstractEventListener<VoidEventData> {

    private BaseEventData<VoidEventData> eventData;

    @Override
    public boolean match(BaseEventData<VoidEventData> eventData) {
        if (EventsEnum.OPEN_COOPERATIVE_FRAGMENT.equals(eventData.getEvent())) {
            this.eventData = eventData;
            this.preventDefault();
            return true;
        }
        return false;
    }

    @Override
    public void execute() {
        FragmentActivity activity = eventData.getActivity();
        CooperativeFragment fragment = new CooperativeFragment();
        FragmentContainerManager.getInstance().replace(R.id.fragmentContainer, activity, fragment, Boolean.TRUE);
    }
}
