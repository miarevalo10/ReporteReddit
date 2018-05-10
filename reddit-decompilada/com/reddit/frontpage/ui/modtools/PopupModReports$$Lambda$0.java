package com.reddit.frontpage.ui.modtools;

import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;

final /* synthetic */ class PopupModReports$$Lambda$0 implements OnModActionCompletedListener {
    private final PopupModReports f29171a;
    private final OnModActionCompletedListener f29172b;

    PopupModReports$$Lambda$0(PopupModReports popupModReports, OnModActionCompletedListener onModActionCompletedListener) {
        this.f29171a = popupModReports;
        this.f29172b = onModActionCompletedListener;
    }

    public final void mo4891a() {
        PopupModReports popupModReports = this.f29171a;
        OnModActionCompletedListener onModActionCompletedListener = this.f29172b;
        popupModReports.m23560a();
        onModActionCompletedListener.mo4891a();
    }
}
