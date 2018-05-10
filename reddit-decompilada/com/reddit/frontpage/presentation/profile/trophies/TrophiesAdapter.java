package com.reddit.frontpage.presentation.profile.trophies;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.reddit.config.GlideApp;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Trophy;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/profile/trophies/TrophiesAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/presentation/profile/trophies/TrophiesAdapter$TrophyViewHolder;", "()V", "trophies", "", "Lcom/reddit/frontpage/domain/model/Trophy;", "getTrophies", "()Ljava/util/List;", "setTrophies", "(Ljava/util/List;)V", "getItemCount", "", "getItemId", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "TrophyViewHolder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TrophiesAdapter.kt */
public final class TrophiesAdapter extends Adapter<TrophyViewHolder> {
    public List<Trophy> f28741a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/presentation/profile/trophies/TrophiesAdapter$TrophyViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/reddit/frontpage/presentation/profile/trophies/TrophiesAdapter;Landroid/view/View;)V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "subtitleView", "Landroid/widget/TextView;", "getSubtitleView", "()Landroid/widget/TextView;", "titleView", "getTitleView", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: TrophiesAdapter.kt */
    public final class TrophyViewHolder extends ViewHolder {
        final TextView f28737a;
        final TextView f28738b;
        final ImageView f28739p;
        final /* synthetic */ TrophiesAdapter f28740q;

        public TrophyViewHolder(TrophiesAdapter trophiesAdapter, View view) {
            Intrinsics.m26847b(view, "itemView");
            this.f28740q = trophiesAdapter;
            super(view);
            Object findViewById = view.findViewById(C1761R.id.trophy_title);
            Intrinsics.m26843a(findViewById, "itemView.findViewById(R.id.trophy_title)");
            this.f28737a = (TextView) findViewById;
            findViewById = view.findViewById(C1761R.id.trophy_subtitle);
            Intrinsics.m26843a(findViewById, "itemView.findViewById(R.id.trophy_subtitle)");
            this.f28738b = (TextView) findViewById;
            findViewById = view.findViewById(C1761R.id.trophy_icon);
            Intrinsics.m26843a(findViewById, "itemView.findViewById(R.id.trophy_icon)");
            this.f28739p = (ImageView) findViewById;
        }
    }

    public TrophiesAdapter() {
        a(true);
    }

    public final /* synthetic */ ViewHolder m29852a(ViewGroup viewGroup, int i) {
        Intrinsics.m26847b(viewGroup, "parent");
        return (ViewHolder) new TrophyViewHolder(this, ViewGroupsKt.m24100a(viewGroup, C1761R.layout.trophy_item, false));
    }

    public final /* synthetic */ void m29853a(ViewHolder viewHolder, int i) {
        TrophyViewHolder trophyViewHolder = (TrophyViewHolder) viewHolder;
        Intrinsics.m26847b(trophyViewHolder, "holder");
        List list = this.f28741a;
        if (list == null) {
            Intrinsics.m26842a();
        }
        Trophy trophy = (Trophy) list.get(i);
        trophyViewHolder.f28737a.setText(trophy.getName());
        trophyViewHolder.f28738b.setText(trophy.getDescription());
        GlideApp.a(trophyViewHolder.f28739p.getContext()).b(trophy.getIconUrl()).into(trophyViewHolder.f28739p);
        View view = (View) trophyViewHolder.f28738b;
        CharSequence description = trophy.getDescription();
        if (description != null) {
            if (description.length() != 0) {
                i = 0;
                ViewsKt.m24106b(view, i ^ 1);
            }
        }
        i = 1;
        ViewsKt.m24106b(view, i ^ 1);
    }

    public final long m29851a(int i) {
        List list = this.f28741a;
        if (list == null) {
            Intrinsics.m26842a();
        }
        return (long) ((Trophy) list.get(i)).getName().hashCode();
    }

    public final int m29850a() {
        List list = this.f28741a;
        return list != null ? list.size() : 0;
    }
}
