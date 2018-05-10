package com.reddit.social.presentation.chatrequests.view;

import com.reddit.social.presentation.presentationobjects.UserData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "u1", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "u2", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: MembersAdapter.kt */
final class MembersAdapter$members$2 extends Lambda implements Function2<UserData, UserData, Boolean> {
    public static final MembersAdapter$members$2 f37515a = new MembersAdapter$members$2();

    MembersAdapter$members$2() {
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        UserData userData = (UserData) obj;
        UserData userData2 = (UserData) obj2;
        Intrinsics.m26847b(userData, "u1");
        Intrinsics.m26847b(userData2, "u2");
        return Boolean.valueOf(Intrinsics.m26845a(userData.f22464a, userData2.f22464a));
    }
}
