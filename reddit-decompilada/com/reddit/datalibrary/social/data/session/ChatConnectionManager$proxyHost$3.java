package com.reddit.datalibrary.social.data.session;

import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdConfig;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SendBirdConfig;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatConnectionManager.kt */
final class ChatConnectionManager$proxyHost$3<T, R> implements Function<T, R> {
    public static final ChatConnectionManager$proxyHost$3 f27388a = new ChatConnectionManager$proxyHost$3();

    ChatConnectionManager$proxyHost$3() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        SendBirdConfig sendBirdConfig = (SendBirdConfig) obj;
        Intrinsics.m26847b(sendBirdConfig, "it");
        return sendBirdConfig.proxy_host;
    }
}
