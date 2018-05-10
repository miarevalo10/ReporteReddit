package com.reddit.social.widgets;

import android.view.View;
import com.reddit.social.widgets.WidgetKeyboard.Medium;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: WidgetKeyboardHeader.kt */
final class WidgetKeyboardHeader$addMedium$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ WidgetKeyboardHeader f37600a;
    final /* synthetic */ Medium f37601b;
    final /* synthetic */ int f37602c;

    public WidgetKeyboardHeader$addMedium$1(WidgetKeyboardHeader widgetKeyboardHeader, Medium medium, int i) {
        this.f37600a = widgetKeyboardHeader;
        this.f37601b = medium;
        this.f37602c = i;
        super(1);
    }

    public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
        this.f37600a.f22512a = this.f37601b;
        this.f37600a.m24801a();
        WidgetKeyboardHeader.m24798a(this.f37600a, this.f37602c);
        return Unit.f25273a;
    }
}
