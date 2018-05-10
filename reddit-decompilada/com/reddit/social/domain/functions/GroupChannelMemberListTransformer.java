package com.reddit.social.domain.functions;

import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/reddit/social/domain/functions/GroupChannelMemberListTransformer;", "Lio/reactivex/functions/Function;", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "", "currentUserId", "(Ljava/lang/String;)V", "getCurrentUserId", "()Ljava/lang/String;", "apply", "users", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GroupChannelMemberListTransformer.kt */
public final class GroupChannelMemberListTransformer implements Function<List<? extends UserData>, String> {
    private final String f29579a;

    public GroupChannelMemberListTransformer(String str) {
        this.f29579a = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        return m30618a((List) obj);
    }

    public final String m30618a(List<UserData> list) {
        Intrinsics.m26847b(list, "users");
        StringBuilder stringBuilder = new StringBuilder();
        list = list.iterator();
        UserData userData = null;
        while (true) {
            boolean z = false;
            if (!list.hasNext()) {
                break;
            }
            UserData userData2 = (UserData) list.next();
            if (StringsKt__StringsJVMKt.m41946a(userData2.f22464a, this.f29579a, true)) {
                userData = userData2;
            } else {
                if (stringBuilder.length() > 0) {
                    z = true;
                }
                if (z) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(userData2.f22465b);
            }
        }
        if (stringBuilder.length() == null) {
            z = true;
        }
        if (z && userData != null) {
            stringBuilder.append(userData.f22465b);
        }
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "stringBuilder.toString()");
        return stringBuilder2;
    }
}
