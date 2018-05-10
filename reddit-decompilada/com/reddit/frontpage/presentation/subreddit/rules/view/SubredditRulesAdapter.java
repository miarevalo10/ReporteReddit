package com.reddit.frontpage.presentation.subreddit.rules.view;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.data.model.SubredditRule;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.social.util.NotifyingList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F@FX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/subreddit/rules/view/SubredditRulesAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/presentation/subreddit/rules/view/SubredditRulesViewHolder;", "()V", "<set-?>", "", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditRule;", "rules", "getRules", "()Ljava/util/List;", "setRules", "(Ljava/util/List;)V", "rules$delegate", "Lcom/reddit/social/util/NotifyingList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditRulesAdapter.kt */
public final class SubredditRulesAdapter extends Adapter<SubredditRulesViewHolder> {
    static final /* synthetic */ KProperty[] f28798a = new KProperty[]{Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(SubredditRulesAdapter.class), "rules", "getRules()Ljava/util/List;"))};
    final NotifyingList f28799b = new NotifyingList(CollectionsKt__CollectionsKt.m26790a());

    private List<SubredditRule> m29874b() {
        return this.f28799b.m30901a(this, f28798a[0]);
    }

    public final /* synthetic */ ViewHolder m29876a(ViewGroup viewGroup, int i) {
        Intrinsics.m26847b(viewGroup, "parent");
        Object inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.listitem_subreddit_rule, viewGroup, false);
        Intrinsics.m26843a(inflate, "view");
        return (ViewHolder) new SubredditRulesViewHolder(inflate);
    }

    public final /* synthetic */ void m29877a(ViewHolder viewHolder, int i) {
        SubredditRulesViewHolder subredditRulesViewHolder = (SubredditRulesViewHolder) viewHolder;
        Intrinsics.m26847b(subredditRulesViewHolder, "holder");
        SubredditRule subredditRule = (SubredditRule) m29874b().get(i);
        boolean z = true;
        i++;
        Intrinsics.m26847b(subredditRule, "subredditRule");
        TextView textView = (TextView) subredditRulesViewHolder.f28801b.mo5678b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(". ");
        stringBuilder.append(subredditRule.getShortName());
        textView.setText(stringBuilder.toString());
        View v = subredditRulesViewHolder.m29879v();
        if (subredditRule.getDescriptionHtml() == null) {
            z = false;
        }
        ViewsKt.m24106b(v, z);
        i = subredditRule.getDescriptionHtml();
        if (i != 0) {
            subredditRulesViewHolder.m29879v().setHtmlFromString(i);
        }
    }

    public final int m29875a() {
        return m29874b().size();
    }
}
