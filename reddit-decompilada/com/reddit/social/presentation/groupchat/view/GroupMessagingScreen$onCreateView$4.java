package com.reddit.social.presentation.groupchat.view;

import android.text.Editable;
import com.reddit.social.presentation.groupchat.ChatContract.Presenter;
import com.reddit.social.widgets.WidgetKeyboard.SendListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/reddit/social/presentation/groupchat/view/GroupMessagingScreen$onCreateView$4", "Lcom/reddit/social/widgets/WidgetKeyboard$SendListener;", "(Lcom/reddit/social/presentation/groupchat/view/GroupMessagingScreen;)V", "onClick", "", "text", "Landroid/text/Editable;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GroupMessagingScreen.kt */
public final class GroupMessagingScreen$onCreateView$4 implements SendListener {
    final /* synthetic */ GroupMessagingScreen f29855a;

    GroupMessagingScreen$onCreateView$4(GroupMessagingScreen groupMessagingScreen) {
        this.f29855a = groupMessagingScreen;
    }

    public final void mo5200a(Editable editable) {
        Intrinsics.m26847b(editable, "text");
        Presenter w = this.f29855a.m41332w();
        editable = editable.toString();
        if (editable == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        w.mo5172b(StringsKt__StringsKt.m42456b((CharSequence) editable).toString());
    }
}
