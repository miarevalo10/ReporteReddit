package com.reddit.datalibrary.social.data.session;

import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Account;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatConnectionManager.kt */
final class ChatConnectionManager$userDataForConnect$1<V> implements Callable<T> {
    final /* synthetic */ Session f19853a;

    ChatConnectionManager$userDataForConnect$1(Session session) {
        this.f19853a = session;
    }

    public final /* synthetic */ Object call() {
        return AccountStorage.b.a(this.f19853a);
    }
}
