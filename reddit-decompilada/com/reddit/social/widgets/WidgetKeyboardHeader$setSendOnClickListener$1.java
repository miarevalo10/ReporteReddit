package com.reddit.social.widgets;

import android.view.View;
import android.widget.EditText;
import com.reddit.frontpage.C1761R;
import com.reddit.social.widgets.WidgetKeyboard.SendListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: WidgetKeyboardHeader.kt */
final class WidgetKeyboardHeader$setSendOnClickListener$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ WidgetKeyboardHeader f37603a;
    final /* synthetic */ SendListener f37604b;

    WidgetKeyboardHeader$setSendOnClickListener$1(WidgetKeyboardHeader widgetKeyboardHeader, SendListener sendListener) {
        this.f37603a = widgetKeyboardHeader;
        this.f37604b = sendListener;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = this.f37604b;
        Object obj2 = (EditText) this.f37603a.m24800a(C1761R.id.chatMessage);
        Intrinsics.m26843a(obj2, "chatMessage");
        obj2 = obj2.getText();
        Intrinsics.m26843a(obj2, "chatMessage.text");
        obj.mo5200a(obj2);
        return Unit.f25273a;
    }
}
