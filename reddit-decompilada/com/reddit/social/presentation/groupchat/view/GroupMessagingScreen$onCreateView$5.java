package com.reddit.social.presentation.groupchat.view;

import com.reddit.social.widgets.WidgetKeyboard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingScreen.kt */
final class GroupMessagingScreen$onCreateView$5 implements Runnable {
    final /* synthetic */ GroupMessagingScreen f22353a;

    GroupMessagingScreen$onCreateView$5(GroupMessagingScreen groupMessagingScreen) {
        this.f22353a = groupMessagingScreen;
    }

    public final void run() {
        WidgetKeyboard widgetKeyboard = this.f22353a.widgetKeyboard;
        if (widgetKeyboard == null) {
            Intrinsics.m26844a("widgetKeyboard");
        }
        Object e = this.f22353a.K;
        Intrinsics.m26843a(e, "rootView");
        widgetKeyboard.setCustomKeyboardHeight((int) (((double) e.getHeight()) * 0.35d));
    }
}
