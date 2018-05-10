package com.reddit.datalibrary.frontpage.data.provider;

import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import de.greenrobot.event.EventBus;

public abstract class AccountProvider extends BaseOtherProvider {
    @State
    Account mAccount;

    public static class AccountEvent extends BaseEvent {
    }

    public static class AccountErrorEvent extends ErrorEvent {
        AccountErrorEvent(Exception exception) {
            super(exception);
        }
    }

    public void onError(Exception exception) {
        super.onError(exception);
        EventBus.getDefault().post(new AccountErrorEvent(exception));
    }

    public void finish() {
        super.finish();
        EventBus.getDefault().removeStickyEvent(AccountEvent.class);
    }
}
