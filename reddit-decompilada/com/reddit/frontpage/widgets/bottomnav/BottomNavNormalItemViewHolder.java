package com.reddit.frontpage.widgets.bottomnav;

import android.content.res.ColorStateList;
import android.support.v7.widget.TooltipCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView.Item;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.Sdk21PropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/reddit/frontpage/widgets/bottomnav/BottomNavNormalItemViewHolder;", "", "item", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;", "bottomNavView", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView;", "tintList", "Landroid/content/res/ColorStateList;", "(Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView;Landroid/content/res/ColorStateList;)V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "getItem", "()Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;", "itemView", "Landroid/view/ViewGroup;", "getItemView", "()Landroid/view/ViewGroup;", "notificationView", "Landroid/widget/TextView;", "getNotificationView", "()Landroid/widget/TextView;", "count", "", "showingNotificationCount", "getShowingNotificationCount", "()I", "setShowingNotificationCount", "(I)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BottomNavNormalItemViewHolder.kt */
public final class BottomNavNormalItemViewHolder {
    final ViewGroup f21954a;
    final TextView f21955b;
    int f21956c;
    final Item f21957d;
    private final ImageView f21958e;
    private final BottomNavView f21959f;
    private final ColorStateList f21960g;

    public BottomNavNormalItemViewHolder(Item item, BottomNavView bottomNavView, ColorStateList colorStateList) {
        Intrinsics.m26847b(item, "item");
        Intrinsics.m26847b(bottomNavView, "bottomNavView");
        Intrinsics.m26847b(colorStateList, "tintList");
        this.f21957d = item;
        this.f21959f = bottomNavView;
        this.f21960g = colorStateList;
        item = ViewGroupsKt.m24100a((ViewGroup) this.f21959f, C1761R.layout.bottom_nav_item_normal, null);
        if (item == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        this.f21954a = (ViewGroup) item;
        Object findViewById = this.f21954a.findViewById(C1761R.id.bottom_nav_item_icon);
        Intrinsics.m26843a(findViewById, "itemView.findViewById(R.id.bottom_nav_item_icon)");
        this.f21958e = (ImageView) findViewById;
        findViewById = this.f21954a.findViewById(C1761R.id.bottom_nav_item_notification);
        Intrinsics.m26843a(findViewById, "itemView.findViewById(R.…om_nav_item_notification)");
        this.f21955b = (TextView) findViewById;
        TooltipCompat.a((View) this.f21954a, this.f21959f.getResources().getString(this.f21957d.mo5066a()));
        ((View) this.f21954a).setOnClickListener((OnClickListener) new C1927x99ce085c((Function1) new Function1<View, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                obj = this.f21959f.getOnItemSelectedListener();
                if (obj != null) {
                    obj.mo4942a(this.f21957d, this.f21959f.getSelectedItem());
                }
                this.f21959f.setSelectedItem(this.f21957d);
                return Unit.f25273a;
            }
        }));
        ImageView imageView = this.f21958e;
        Sdk21PropertiesKt.m28410a(imageView, this.f21957d.mo5067b());
        imageView.setImageTintList(this.f21960g);
    }
}
