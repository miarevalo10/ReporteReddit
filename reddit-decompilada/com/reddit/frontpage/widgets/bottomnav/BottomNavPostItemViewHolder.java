package com.reddit.frontpage.widgets.bottomnav;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.TooltipCompat;
import android.view.View;
import android.widget.ImageView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView.Item;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.DimensionsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@FX\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/widgets/bottomnav/BottomNavPostItemViewHolder;", "", "bottomNavView", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView;", "(Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView;)V", "color", "", "getColor", "()Ljava/lang/Integer;", "setColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "drawableSize", "itemView", "Landroid/widget/ImageView;", "getItemView", "()Landroid/widget/ImageView;", "outlineDrawable", "Landroid/graphics/drawable/GradientDrawable;", "postItem", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BottomNavPostItemViewHolder.kt */
public final class BottomNavPostItemViewHolder {
    public static final Companion f21964c = new Companion();
    private static final boolean f21965h;
    final ImageView f21966a;
    Integer f21967b;
    private final Item f21968d;
    private final int f21969e;
    private final GradientDrawable f21970f;
    private final BottomNavView f21971g;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/widgets/bottomnav/BottomNavPostItemViewHolder$Companion;", "", "()V", "useLayerDrawableGravity", "", "getUseLayerDrawableGravity", "()Z", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BottomNavPostItemViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public BottomNavPostItemViewHolder(BottomNavView bottomNavView) {
        Intrinsics.m26847b(bottomNavView, "bottomNavView");
        this.f21971g = bottomNavView;
        bottomNavView = ViewGroupsKt.m24100a(this.f21971g, C1761R.layout.bottom_nav_item_post, false);
        if (bottomNavView == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
        }
        this.f21966a = (ImageView) bottomNavView;
        this.f21968d = Item.f21974c;
        this.f21969e = DimensionsKt.m28408a(this.f21966a.getContext(), C1761R.dimen.bottom_nav_post_button_size);
        bottomNavView = ContextCompat.a(this.f21966a.getContext(), C1761R.drawable.bottom_nav_post_outline);
        if (bottomNavView == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
        this.f21970f = (GradientDrawable) bottomNavView;
        bottomNavView = DimensionsKt.m28408a(this.f21966a.getContext(), C1761R.dimen.icon_size_medium);
        Object context = this.f21966a.getContext();
        Intrinsics.m26843a(context, "itemView.context");
        Drawable b = ResourcesUtil.m22724b(context, C1761R.drawable.ic_icon_post_edit, C1761R.attr.rdt_action_icon_color);
        if (!f21965h) {
            b = new InsetDrawable(b, (bottomNavView - b.getIntrinsicWidth()) / 2);
        }
        m24205a(null);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{b, this.f21970f});
        if (f21965h) {
            layerDrawable.setLayerSize(0, bottomNavView, bottomNavView);
            layerDrawable.setLayerGravity(0, 17);
        } else {
            layerDrawable.setPaddingMode(1);
            int i = (this.f21969e - bottomNavView) / 2;
            layerDrawable.setLayerInset(0, i, i, i, i);
        }
        bottomNavView = this.f21966a;
        View view = bottomNavView;
        TooltipCompat.a(view, this.f21971g.getResources().getString(this.f21968d.mo5066a()));
        bottomNavView.setImageDrawable(layerDrawable);
        if (f21965h) {
            bottomNavView.setOutlineProvider(new BottomNavPostItemViewHolder$$special$$inlined$apply$lambda$1(this, layerDrawable));
            bottomNavView.setClipToOutline(true);
        }
        view.setOnClickListener(new C1928x99d97043((Function1) new BottomNavPostItemViewHolder$$special$$inlined$apply$lambda$2(this, layerDrawable)));
    }

    public final void m24205a(Integer num) {
        int intValue;
        if (num != null) {
            intValue = num.intValue();
        } else {
            Object context = this.f21966a.getContext();
            Intrinsics.m26843a(context, "itemView.context");
            intValue = ResourcesUtil.m22740i(context, C1761R.attr.rdt_active_color);
        }
        if (VERSION.SDK_INT > 21) {
            this.f21970f.setTint(intValue);
        } else {
            this.f21970f.setColorFilter(intValue, Mode.SRC_IN);
        }
        Drawable background = this.f21966a.getBackground();
        if (!(background instanceof RippleDrawable)) {
            background = null;
        }
        RippleDrawable rippleDrawable = (RippleDrawable) background;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(ColorStateList.valueOf(intValue));
        }
        this.f21967b = num;
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        }
        f21965h = z;
    }
}
