package com.reddit.frontpage.widgets.bottomnav;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout.DefaultBehavior;
import android.support.transition.Fade;
import android.support.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.evernote.android.state.State;
import com.evernote.android.state.StateSaver;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u000234B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010'\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020+H\u0014J\u0016\u0010-\u001a\u00020)2\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020\u0007J\u0019\u0010/\u001a\u00020)2\f\u00100\u001a\b\u0012\u0004\u0012\u00020!01¢\u0006\u0002\u00102R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R*\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00065"}, d2 = {"Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "normalItemTintList", "Landroid/content/res/ColorStateList;", "getNormalItemTintList", "()Landroid/content/res/ColorStateList;", "normalItemTintList$delegate", "Lkotlin/Lazy;", "normalItemViewHolders", "", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavNormalItemViewHolder;", "onItemSelectedListener", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$OnItemSelectedListener;", "getOnItemSelectedListener", "()Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$OnItemSelectedListener;", "setOnItemSelectedListener", "(Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$OnItemSelectedListener;)V", "color", "postButtonColor", "getPostButtonColor", "()Ljava/lang/Integer;", "setPostButtonColor", "(Ljava/lang/Integer;)V", "postItemViewHolder", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavPostItemViewHolder;", "item", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;", "selectedItem", "getSelectedItem", "()Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;", "setSelectedItem", "(Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;)V", "getViewHolderForNormalItem", "onRestoreInstanceState", "", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "setNotificationCount", "count", "showItems", "items", "", "([Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;)V", "Item", "OnItemSelectedListener", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@DefaultBehavior(a = BottomNavBehavior.class)
/* compiled from: BottomNavView.kt */
public final class BottomNavView extends LinearLayout {
    static final /* synthetic */ KProperty[] f21978a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(BottomNavView.class), "normalItemTintList", "getNormalItemTintList()Landroid/content/res/ColorStateList;"))};
    private OnItemSelectedListener f21979b;
    private final Lazy f21980c;
    private final List<BottomNavNormalItemViewHolder> f21981d;
    private BottomNavPostItemViewHolder f21982e;
    @State
    private Item selectedItem;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048'X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;", "", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "titleRes", "getTitleRes", "Home", "Browse", "Post", "Chat", "Inbox", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BottomNavView.kt */
    public enum Item {
        ;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item$Browse;", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "titleRes", "getTitleRes", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: BottomNavView.kt */
        static final class Browse extends Item {
            private final int f29497f;
            private final int f29498g;

            Browse(String str) {
                super(str, 1);
                this.f29497f = C1761R.string.label_browse;
                this.f29498g = C1761R.drawable.ic_icon_communities;
            }

            public final int mo5066a() {
                return this.f29497f;
            }

            public final int mo5067b() {
                return this.f29498g;
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item$Chat;", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "titleRes", "getTitleRes", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: BottomNavView.kt */
        static final class Chat extends Item {
            private final int f29499f;
            private final int f29500g;

            Chat(String str) {
                super(str, 3);
                this.f29499f = C1761R.string.label_chat;
                this.f29500g = C1761R.drawable.ic_icon_chat;
            }

            public final int mo5066a() {
                return this.f29499f;
            }

            public final int mo5067b() {
                return this.f29500g;
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item$Home;", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "titleRes", "getTitleRes", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: BottomNavView.kt */
        static final class Home extends Item {
            private final int f29501f;
            private final int f29502g;

            Home(String str) {
                super(str, 0);
                this.f29501f = C1761R.string.label_home;
                this.f29502g = C1761R.drawable.ic_icon_snoo_home;
            }

            public final int mo5066a() {
                return this.f29501f;
            }

            public final int mo5067b() {
                return this.f29502g;
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item$Inbox;", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "titleRes", "getTitleRes", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: BottomNavView.kt */
        static final class Inbox extends Item {
            private final int f29503f;
            private final int f29504g;

            Inbox(String str) {
                super(str, 4);
                this.f29503f = C1761R.string.label_inbox;
                this.f29504g = C1761R.drawable.ic_icon_message;
            }

            public final int mo5066a() {
                return this.f29503f;
            }

            public final int mo5067b() {
                return this.f29504g;
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item$Post;", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "titleRes", "getTitleRes", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: BottomNavView.kt */
        static final class Post extends Item {
            private final int f29505f;
            private final int f29506g;

            Post(String str) {
                super(str, 2);
                this.f29505f = C1761R.string.action_post;
            }

            public final int mo5066a() {
                return this.f29505f;
            }

            public final int mo5067b() {
                return this.f29506g;
            }
        }

        public abstract int mo5066a();

        public abstract int mo5067b();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$OnItemSelectedListener;", "", "onItemSelected", "", "selectedItem", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;", "lastSelectedItem", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BottomNavView.kt */
    public interface OnItemSelectedListener {
        void mo4942a(Item item, Item item2);
    }

    public BottomNavView(Context context) {
        this(context, null, 0, 6, null);
    }

    public BottomNavView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final ColorStateList getNormalItemTintList() {
        return (ColorStateList) this.f21980c.mo5678b();
    }

    public /* synthetic */ BottomNavView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public BottomNavView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f21980c = LazyKt.m26777a((Function0) new BottomNavView$normalItemTintList$2(context));
        this.f21981d = (List) new ArrayList();
        if (isInEditMode() != null) {
            m24211a(Item.values());
        }
    }

    public final OnItemSelectedListener getOnItemSelectedListener() {
        return this.f21979b;
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f21979b = onItemSelectedListener;
    }

    public final Item getSelectedItem() {
        return this.selectedItem;
    }

    public final void setSelectedItem(Item item) {
        if (Intrinsics.m26845a((Object) item, Item.f21974c)) {
            throw ((Throwable) new IllegalArgumentException("The Post tab can't be selected!"));
        }
        for (BottomNavNormalItemViewHolder bottomNavNormalItemViewHolder : this.f21981d) {
            bottomNavNormalItemViewHolder.f21954a.setSelected(Intrinsics.m26845a(bottomNavNormalItemViewHolder.f21957d, (Object) item));
        }
        this.selectedItem = item;
    }

    public final Integer getPostButtonColor() {
        BottomNavPostItemViewHolder bottomNavPostItemViewHolder = this.f21982e;
        return bottomNavPostItemViewHolder != null ? bottomNavPostItemViewHolder.f21967b : null;
    }

    public final void setPostButtonColor(Integer num) {
        BottomNavPostItemViewHolder bottomNavPostItemViewHolder = this.f21982e;
        if (bottomNavPostItemViewHolder != null) {
            bottomNavPostItemViewHolder.m24205a(num);
        }
    }

    public final void m24211a(Item[] itemArr) {
        Intrinsics.m26847b(itemArr, "items");
        this.f21981d.clear();
        this.f21982e = null;
        removeAllViews();
        for (Object obj : (Object[]) itemArr) {
            View view;
            Object obj2 = (Item) obj2;
            if (Intrinsics.m26845a(obj2, Item.f21974c)) {
                BottomNavPostItemViewHolder bottomNavPostItemViewHolder = new BottomNavPostItemViewHolder(this);
                this.f21982e = bottomNavPostItemViewHolder;
                view = bottomNavPostItemViewHolder.f21966a;
            } else {
                BottomNavNormalItemViewHolder bottomNavNormalItemViewHolder = new BottomNavNormalItemViewHolder(obj2, this, getNormalItemTintList());
                this.f21981d.add(bottomNavNormalItemViewHolder);
                view = bottomNavNormalItemViewHolder.f21954a;
            }
            addView(view);
        }
    }

    public final void m24210a(Item item, int i) {
        Intrinsics.m26847b(item, "item");
        if (Intrinsics.m26845a((Object) item, Item.f21974c)) {
            throw ((Throwable) new IllegalArgumentException("The Post tab can't have notifications!"));
        }
        item = m24209a(item);
        int i2 = item.f21956c > 0 ? 1 : 0;
        int i3 = i > 0 ? 1 : 0;
        if (i3 != i2) {
            TransitionManager.a(item.f21954a, new Fade());
        }
        TextView textView = item.f21955b;
        if (i3 != 0) {
            textView.setText(textView.getResources().getString(C1761R.string.fmt_num, new Object[]{Integer.valueOf(i)}));
            ViewsKt.m24107c(textView);
        } else {
            ViewsKt.m24109d(textView);
        }
        item.f21956c = i;
    }

    private final BottomNavNormalItemViewHolder m24209a(Item item) {
        for (Object next : this.f21981d) {
            if (Intrinsics.m26845a(((BottomNavNormalItemViewHolder) next).f21957d, (Object) item)) {
                break;
            }
        }
        Object next2 = null;
        BottomNavNormalItemViewHolder bottomNavNormalItemViewHolder = (BottomNavNormalItemViewHolder) next2;
        if (bottomNavNormalItemViewHolder != null) {
            return bottomNavNormalItemViewHolder;
        }
        StringBuilder stringBuilder = new StringBuilder("Couldn't find a view for ");
        stringBuilder.append(item);
        stringBuilder.append(". Make sure it's been added.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    protected final Parcelable onSaveInstanceState() {
        Object saveInstanceState = StateSaver.saveInstanceState(this, super.onSaveInstanceState());
        Intrinsics.m26843a(saveInstanceState, "StateSaver.saveInstanceS…er.onSaveInstanceState())");
        return saveInstanceState;
    }

    protected final void onRestoreInstanceState(Parcelable parcelable) {
        Intrinsics.m26847b(parcelable, "state");
        super.onRestoreInstanceState(StateSaver.restoreInstanceState(this, parcelable));
    }
}
