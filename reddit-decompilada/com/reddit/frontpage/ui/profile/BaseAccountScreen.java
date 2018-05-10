package com.reddit.frontpage.ui.profile;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent.ScreenViewPayload;
import com.reddit.frontpage.domain.model.Trophy;
import com.reddit.frontpage.presentation.common.DateUtil;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.profile.trophies.TrophiesAdapter;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.layout.SmoothScrollingLinearLayoutManager;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.profile.AccountStatsView;
import com.reddit.frontpage.widgets.profile.FancyStat;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0003\"#$B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0014¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010\u001e\u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8DX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006%"}, d2 = {"Lcom/reddit/frontpage/ui/profile/BaseAccountScreen;", "Lcom/reddit/frontpage/ui/BaseScreen;", "()V", "isContributor", "", "()Z", "setContributor", "(Z)V", "profileActionList", "Landroid/support/v7/widget/RecyclerView;", "getProfileActionList", "()Landroid/support/v7/widget/RecyclerView;", "createV1ScreenViewEvent", "Lcom/reddit/frontpage/commons/analytics/events/v1/ScreenViewEvent;", "getLayoutId", "", "getProfileActions", "", "Lcom/reddit/frontpage/ui/profile/BaseAccountScreen$ProfileAction;", "()[Lcom/reddit/frontpage/ui/profile/BaseAccountScreen$ProfileAction;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setAccount", "", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "setTrophies", "trophies", "", "Lcom/reddit/frontpage/domain/model/Trophy;", "ProfileAction", "ProfileActionNavAdapter", "ProfileActionViewHolder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BaseAccountScreen.kt */
public abstract class BaseAccountScreen extends BaseScreen {
    private boolean f39252v;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/ui/profile/BaseAccountScreen$ProfileAction;", "", "actionName", "", "iconResId", "", "runnable", "Ljava/lang/Runnable;", "(Ljava/lang/String;ILjava/lang/Runnable;)V", "getActionName", "()Ljava/lang/String;", "getIconResId", "()I", "getRunnable", "()Ljava/lang/Runnable;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BaseAccountScreen.kt */
    protected static final class ProfileAction {
        final String f21514a;
        final int f21515b;
        final Runnable f21516c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ProfileAction) {
                ProfileAction profileAction = (ProfileAction) obj;
                if (Intrinsics.m26845a(this.f21514a, profileAction.f21514a)) {
                    return (this.f21515b == profileAction.f21515b) && Intrinsics.m26845a(this.f21516c, profileAction.f21516c);
                }
            }
        }

        public final int hashCode() {
            String str = this.f21514a;
            int i = 0;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.f21515b) * 31;
            Runnable runnable = this.f21516c;
            if (runnable != null) {
                i = runnable.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("ProfileAction(actionName=");
            stringBuilder.append(this.f21514a);
            stringBuilder.append(", iconResId=");
            stringBuilder.append(this.f21515b);
            stringBuilder.append(", runnable=");
            stringBuilder.append(this.f21516c);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/ui/profile/BaseAccountScreen$ProfileActionNavAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/ui/profile/BaseAccountScreen$ProfileActionViewHolder;", "profileActions", "", "Lcom/reddit/frontpage/ui/profile/BaseAccountScreen$ProfileAction;", "([Lcom/reddit/frontpage/ui/profile/BaseAccountScreen$ProfileAction;)V", "getProfileActions", "()[Lcom/reddit/frontpage/ui/profile/BaseAccountScreen$ProfileAction;", "[Lcom/reddit/frontpage/ui/profile/BaseAccountScreen$ProfileAction;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BaseAccountScreen.kt */
    private static final class ProfileActionNavAdapter extends Adapter<ProfileActionViewHolder> {
        private final ProfileAction[] f29225a;

        public final /* synthetic */ ViewHolder m30324a(ViewGroup viewGroup, int i) {
            Intrinsics.m26847b(viewGroup, "parent");
            viewGroup = LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.listitem_profile_nav, viewGroup, false);
            if (viewGroup != null) {
                return (ViewHolder) new ProfileActionViewHolder((TextView) viewGroup);
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }

        public final /* synthetic */ void m30325a(ViewHolder viewHolder, int i) {
            ProfileActionViewHolder profileActionViewHolder = (ProfileActionViewHolder) viewHolder;
            Intrinsics.m26847b(profileActionViewHolder, "holder");
            i = this.f29225a[i];
            Intrinsics.m26847b(i, "action");
            Object obj = profileActionViewHolder.c;
            Intrinsics.m26843a(obj, "itemView");
            Context context = obj.getContext();
            Intrinsics.m26843a((Object) context, "itemView.context");
            Drawable e = ResourcesUtil.m22732e(context, i.f21515b);
            View view = profileActionViewHolder.c;
            if (view == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            TextView textView = (TextView) view;
            textView.setText(i.f21514a);
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(e, null, null, null);
            Object obj2 = profileActionViewHolder.c;
            Intrinsics.m26843a(obj2, "itemView");
            obj2.setOnClickListener((OnClickListener) new C1903xba4976b0(new BaseAccountScreen$ProfileActionNavAdapter$onBindViewHolder$1$1$1(i)));
        }

        public ProfileActionNavAdapter(ProfileAction[] profileActionArr) {
            Intrinsics.m26847b(profileActionArr, "profileActions");
            this.f29225a = profileActionArr;
        }

        public final int m30323a() {
            return ((Object[]) this.f29225a).length;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/ui/profile/BaseAccountScreen$ProfileActionViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "bindProfileAction", "", "action", "Lcom/reddit/frontpage/ui/profile/BaseAccountScreen$ProfileAction;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BaseAccountScreen.kt */
    private static final class ProfileActionViewHolder extends ViewHolder {
        public ProfileActionViewHolder(TextView textView) {
            Intrinsics.m26847b(textView, "itemView");
            super(textView);
        }
    }

    public final int mo7141s() {
        return C1761R.layout.profile_account;
    }

    protected final RecyclerView m39366w() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (RecyclerView) obj.findViewById(C1761R.id.nav_list);
        Intrinsics.m26843a(obj, "rootView.nav_list");
        return obj;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        RecyclerView recyclerView = (RecyclerView) obj.findViewById(C1761R.id.nav_list);
        recyclerView.setLayoutManager((LayoutManager) new SmoothScrollingLinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter((Adapter) new ProfileActionNavAdapter(mo7460x()));
        obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        recyclerView = (RecyclerView) obj.findViewById(C1761R.id.trophies_list);
        recyclerView.setLayoutManager((LayoutManager) new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter((Adapter) new TrophiesAdapter());
        obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    public ScreenViewEvent mo7203N() {
        Object N = super.mo7203N();
        ((ScreenViewPayload) N.payload).is_contributor = this.f39252v;
        Intrinsics.m26843a(N, "super.createV1ScreenView…Contributor\n            }");
        return N;
    }

    public final void m39363a(Account account) {
        Intrinsics.m26847b(account, "account");
        View view = this.K;
        if (view != null) {
            int i = 0;
            this.f39252v = account.getSubreddit() != null;
            AccountStatsView accountStatsView = (AccountStatsView) view.findViewById(C1761R.id.user_stats_view);
            Intrinsics.m26847b(account, "account");
            FancyStat fancyStat = (FancyStat) accountStatsView.mo5068a(C1761R.id.karma_stat);
            Object a = Util.m23960a((int) C1761R.string.fmt_num, Integer.valueOf(account.getLinkKarma() + account.getCommentKarma()));
            Intrinsics.m26843a(a, "Util.getString(R.string.… + account.commentKarma))");
            fancyStat.setStatValue(a);
            ((FancyStat) accountStatsView.mo5068a(C1761R.id.account_age_stat)).setStatValue(DateUtil.m22704a(account.getCreatedUtc() * 1000, 2));
            account = account.getSubreddit();
            account = account != null ? account.getPublicDescription() : null;
            Object obj = (TextView) view.findViewById(C1761R.id.description);
            Intrinsics.m26843a(obj, "rootView.description");
            CharSequence charSequence = (CharSequence) account;
            obj.setText(charSequence);
            Object obj2 = (TextView) view.findViewById(C1761R.id.description);
            Intrinsics.m26843a(obj2, "rootView.description");
            view = (View) obj2;
            if (charSequence == null || StringsKt__StringsJVMKt.m41943a(charSequence) != null) {
                i = 1;
            }
            ViewsKt.m24106b(view, i ^ 1);
        }
    }

    public final void m39364a(List<Trophy> list) {
        Intrinsics.m26847b(list, "trophies");
        View view = this.K;
        if (view != null) {
            Object obj = (RecyclerView) view.findViewById(C1761R.id.trophies_list);
            Intrinsics.m26843a(obj, "rootView.trophies_list");
            Adapter adapter = obj.getAdapter();
            if (adapter == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.profile.trophies.TrophiesAdapter");
            }
            TrophiesAdapter trophiesAdapter = (TrophiesAdapter) adapter;
            trophiesAdapter.f28741a = list;
            trophiesAdapter.e();
        }
    }

    protected ProfileAction[] mo7460x() {
        return new ProfileAction[0];
    }
}
