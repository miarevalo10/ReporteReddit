package com.reddit.frontpage.ui.modtools;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class PopupModReports$$Lambda$3 implements Consumer {
    private final PopupModReports f29174a;

    PopupModReports$$Lambda$3(PopupModReports popupModReports) {
        this.f29174a = popupModReports;
    }

    public final void accept(Object obj) {
        PopupModReports popupModReports = this.f29174a;
        Timber.c((Throwable) obj, "Error getting post flairs", new Object[0]);
        popupModReports.m23561a(true);
    }
}
