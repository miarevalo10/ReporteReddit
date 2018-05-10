package com.reddit.frontpage.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.evernote.android.state.State;
import com.livefront.bridge.Bridge;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.MessageEvent;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.provider.BaseOtherProvider;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent.ScreenViewPayload;
import com.reddit.frontpage.commons.ui.BaseFragment;
import com.reddit.frontpage.util.kotlin.InvalidatableManager;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import timber.log.Timber;

public abstract class BaseFrontpageFragment extends BaseFragment {
    private boolean f37146a;
    private boolean f37147b;
    private Unbinder f37148c;
    private final List<BaseOtherProvider> f37149d = new ArrayList();
    protected View f37150e;
    @State
    protected String eventRequestId;
    public final InvalidatableManager f37151f = new InvalidatableManager();

    public abstract int mo7160h();

    public boolean mo7172k() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f37150e = layoutInflater.inflate(mo7160h(), viewGroup, false);
        this.f37148c = ButterKnife.a(this, this.f37150e);
        this.f37147b = true;
        if (bundle == null) {
            this.eventRequestId = UUID.randomUUID().toString();
            Timber.b("Event Request ID created: %s", new Object[]{this.eventRequestId});
        } else {
            Bridge.a(this, bundle);
            Timber.b("Event Request ID restored: %s", new Object[]{this.eventRequestId});
        }
        return this.f37150e;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f37148c.a();
        this.f37151f.m24081a();
        this.f37147b = false;
    }

    public void onStart() {
        super.onStart();
        EventBus.getDefault().registerSticky(this);
    }

    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    public List<BaseOtherProvider> mo7224l() {
        return Collections.emptyList();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!this.f37146a) {
            Collection l = mo7224l();
            if (l != null) {
                this.f37149d.addAll(l);
            }
            this.f37146a = true;
        }
        if (bundle != null) {
            for (BaseOtherProvider restoreInstanceState : this.f37149d) {
                restoreInstanceState.restoreInstanceState(bundle);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        for (BaseOtherProvider saveInstanceState : this.f37149d) {
            saveInstanceState.saveInstanceState(bundle);
        }
        Bridge.b(this, bundle);
    }

    public void startActivity(Intent intent) {
        getActivity().startActivity(intent);
    }

    public void onEvent(MessageEvent messageEvent) {
        StringBuilder stringBuilder = new StringBuilder("Message event: ");
        stringBuilder.append(messageEvent.a);
        Timber.b(stringBuilder.toString(), new Object[0]);
        Snackbar.a(getView(), messageEvent.a, messageEvent.b).a();
    }

    public void mo7249a(ErrorEvent errorEvent) {
        Snackbar.a(getView(), getString(C1761R.string.error_fallback_message), -1).a();
        Timber.c(errorEvent.exception, "Unexpected error. Showing fallback error message", new Object[0]);
    }

    public void onEvent(ErrorEvent errorEvent) {
        mo7249a(errorEvent);
    }

    public ScreenViewEvent createV1ScreenViewEvent() {
        ScreenViewEvent createV1ScreenViewEvent = super.createV1ScreenViewEvent();
        ((ScreenViewPayload) createV1ScreenViewEvent.payload).compact_view = FrontpageSettings.a().c();
        ((ScreenViewPayload) createV1ScreenViewEvent.payload).nightmode = FrontpageSettings.a().d();
        return createV1ScreenViewEvent;
    }

    protected final void m37509b(CharSequence charSequence) {
        Snackbar.a(getView(), charSequence, 0).a();
    }

    public void onDestroy() {
        for (BaseOtherProvider finish : this.f37149d) {
            finish.finish();
        }
        this.f37149d.clear();
        super.onDestroy();
    }
}
