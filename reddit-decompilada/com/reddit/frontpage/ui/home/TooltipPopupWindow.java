package com.reddit.frontpage.ui.home;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016J&\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/reddit/frontpage/ui/home/TooltipPopupWindow;", "", "context", "Landroid/content/Context;", "screenWidth", "", "(Landroid/content/Context;I)V", "getContext", "()Landroid/content/Context;", "popupWindow", "Landroid/widget/PopupWindow;", "getScreenWidth", "()I", "tail", "Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "offsetFromCenter", "x", "setOnDismissListener", "", "listener", "Lkotlin/Function0;", "showAtLocation", "parent", "Landroid/view/View;", "gravity", "y", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TooltipPopupWindow.kt */
public final class TooltipPopupWindow {
    public static final Companion f21224d = new Companion();
    private static final String f21225g = "TooltipPopupWindow";
    private static final String f21226h;
    public PopupWindow f21227a;
    public ImageView f21228b;
    public final int f21229c;
    private TextView f21230e;
    private final Context f21231f;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/ui/home/TooltipPopupWindow$Companion;", "", "()V", "KEY_GEOPOPULAR_REGION_TOOLTIP", "", "getKEY_GEOPOPULAR_REGION_TOOLTIP", "()Ljava/lang/String;", "TAG", "kotlin.jvm.PlatformType", "getTAG", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: TooltipPopupWindow.kt */
    public static final class Companion {
        private Companion() {
        }

        public static String m23372a() {
            return TooltipPopupWindow.f21226h;
        }
    }

    public TooltipPopupWindow(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        this.f21231f = context;
        this.f21229c = i;
        Object inflate = LayoutInflater.from(this.f21231f).inflate(C1761R.layout.layout_tooltip, null);
        Intrinsics.m26843a(inflate, "view");
        Object obj = (TextView) inflate.findViewById(C1761R.id.tooltip_text);
        Intrinsics.m26843a(obj, "view.tooltip_text");
        this.f21230e = obj;
        obj = (ImageView) inflate.findViewById(C1761R.id.tooltip_tail);
        Intrinsics.m26843a(obj, "view.tooltip_tail");
        this.f21228b = obj;
        this.f21227a = new PopupWindow(inflate, -1, -2, true);
        this.f21227a.setAnimationStyle(16973826);
        this.f21227a.setBackgroundDrawable((Drawable) new ColorDrawable(0));
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f21225g);
        stringBuilder.append(":GeopopularRegionTooltip");
        f21226h = stringBuilder.toString();
    }
}
