package com.reddit.social.presentation.chatrequests.view;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.reddit.social.util.NotifyingList;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R7\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/view/MembersAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/social/presentation/chatrequests/view/MemberViewHolder;", "memberClick", "Lio/reactivex/subjects/PublishSubject;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "(Lio/reactivex/subjects/PublishSubject;)V", "<set-?>", "", "members", "getMembers", "()Ljava/util/List;", "setMembers", "(Ljava/util/List;)V", "members$delegate", "Lcom/reddit/social/util/NotifyingList;", "changeMemberBlockedStatus", "", "userId", "", "blocked", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MembersAdapter.kt */
public final class MembersAdapter extends Adapter<MemberViewHolder> {
    static final /* synthetic */ KProperty[] f29690a = new KProperty[]{Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(MembersAdapter.class), "members", "getMembers()Ljava/util/List;"))};
    private final NotifyingList f29691b = new NotifyingList(CollectionsKt__CollectionsKt.m26790a(), MembersAdapter$members$2.f37515a);
    private final PublishSubject<UserData> f29692c;

    private List<UserData> m30707b() {
        return this.f29691b.m30901a(this, f29690a[0]);
    }

    public final void m30712a(List<UserData> list) {
        Intrinsics.m26847b(list, "<set-?>");
        this.f29691b.m30902a(this, f29690a[0], list);
    }

    public final /* synthetic */ ViewHolder m30709a(ViewGroup viewGroup, int i) {
        Intrinsics.m26847b(viewGroup, "parent");
        Object context = viewGroup.getContext();
        Intrinsics.m26843a(context, "parent.context");
        return MemberViewHolderKt.m24560a(context);
    }

    public final /* synthetic */ void m30710a(ViewHolder viewHolder, int i) {
        MemberViewHolder memberViewHolder = (MemberViewHolder) viewHolder;
        Intrinsics.m26847b(memberViewHolder, "holder");
        MemberViewHolderKt.m24561a(memberViewHolder, (UserData) m30707b().get(i), this.f29692c);
    }

    public MembersAdapter(PublishSubject<UserData> publishSubject) {
        Intrinsics.m26847b(publishSubject, "memberClick");
        this.f29692c = publishSubject;
    }

    public final void m30711a(String str) {
        Intrinsics.m26847b(str, "userId");
        int i = 0;
        for (UserData userData : m30707b()) {
            if (Intrinsics.m26845a(userData.f22464a, (Object) str)) {
                break;
            }
            i++;
        }
        i = -1;
        if (i >= 0) {
            ((UserData) m30707b().get(i)).f22469f = Boolean.valueOf(true);
            d(i);
        }
    }

    public final int m30708a() {
        return m30707b().size();
    }
}
