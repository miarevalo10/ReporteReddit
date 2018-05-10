package com.reddit.datalibrary.social.data.session;

import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "token", "<anonymous parameter 1>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Account;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatConnectionManager.kt */
final class ChatConnectionManager$userDataForConnect$2<T1, T2, R> implements BiFunction<String, Account, String> {
    public static final ChatConnectionManager$userDataForConnect$2 f27393a = new ChatConnectionManager$userDataForConnect$2();

    ChatConnectionManager$userDataForConnect$2() {
    }

    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        String str = (String) obj;
        Account account = (Account) obj2;
        Intrinsics.m26847b(str, "token");
        Intrinsics.m26847b(account, "<anonymous parameter 1>");
        return str;
    }
}
