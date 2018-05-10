package com.reddit.frontpage.ui.modtools;

import io.reactivex.functions.Consumer;
import java.util.List;

final /* synthetic */ class PopupModReports$$Lambda$2 implements Consumer {
    private final PopupModReports f29173a;

    PopupModReports$$Lambda$2(PopupModReports popupModReports) {
        this.f29173a = popupModReports;
    }

    public final void accept(Object obj) {
        this.f29173a.m23561a(((List) obj).isEmpty() ^ 1);
    }
}
