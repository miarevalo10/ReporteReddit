package com.reddit.datalibrary.social.data.repo;

import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.AccountWrapper;
import com.reddit.frontpage.util.SessionUtil;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "account", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/AccountWrapper;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatDataRepository.kt */
final class ChatDataRepository$getUserId$1<T, R> implements Function<T, R> {
    public static final ChatDataRepository$getUserId$1 f27349a = new ChatDataRepository$getUserId$1();

    ChatDataRepository$getUserId$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        AccountWrapper accountWrapper = (AccountWrapper) obj;
        Intrinsics.m26847b(accountWrapper, "account");
        return SessionUtil.m23893a(((Account) accountWrapper.getData()).getId());
    }
}
