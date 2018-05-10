package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import com.sendbird.android.Member;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "members", "", "Lcom/sendbird/android/Member;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$createNewMessageObservable$4 extends Lambda implements Function1<List<? extends Member>, Unit> {
    final /* synthetic */ GroupMessagingPresenter f37527a;

    GroupMessagingPresenter$createNewMessageObservable$4(GroupMessagingPresenter groupMessagingPresenter) {
        this.f37527a = groupMessagingPresenter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = (List) obj;
        Intrinsics.m26843a(obj, "members");
        Iterable<Member> iterable = (Iterable) obj;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Member e : iterable) {
            arrayList.add(e.m25022e());
        }
        obj = ((List) arrayList).toArray(new String[null]);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Object[] objArr = (Object[]) ((String[]) obj);
        switch (objArr.length) {
            case 0:
                obj = null;
                break;
            case 1:
                obj = Util.m23960a((int) C1761R.string.fmt_user_is_typing, Arrays.copyOf(objArr, objArr.length));
                break;
            case 2:
                obj = Util.m23960a((int) C1761R.string.fmt_two_users_are_typing, Arrays.copyOf(objArr, objArr.length));
                break;
            default:
                obj = Util.m24027f((int) C1761R.string.people_are_typing);
                break;
        }
        GroupMessagingPresenter.m30774a(this.f37527a).mo7564d(obj);
        return Unit.f25273a;
    }
}
