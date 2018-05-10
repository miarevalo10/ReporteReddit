package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import android.net.Uri;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.WebSocketClient.WebSocketConnection;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveCommentsUpdater;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveThreadUpdater;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.RedirectUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteWebSocketDataSource;", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteWebSocketDataSourceContract;", "()V", "liveCommentsSocket", "Lcom/reddit/datalibrary/frontpage/redditauth/redditclient/WebSocketClient$WebSocketConnection;", "uri", "Landroid/net/Uri;", "updater", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/live/LiveCommentsUpdater;", "liveRedirectsSocket", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/live/RedirectUpdater;", "liveThreadSocket", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/live/LiveThreadUpdater;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteWebSocketDataSource.kt */
public final class RemoteWebSocketDataSource {
    public static WebSocketConnection m8949a(Uri uri, LiveThreadUpdater liveThreadUpdater) {
        Intrinsics.b(uri, "uri");
        Intrinsics.b(liveThreadUpdater, "updater");
        uri = RedditClient.m9217a(SessionManager.m9191b()).m9234a(uri, liveThreadUpdater);
        Intrinsics.a(uri, "redditClient.liveThreadSocket(uri, updater)");
        return uri;
    }

    public static WebSocketConnection m8948a(Uri uri, LiveCommentsUpdater liveCommentsUpdater) {
        Intrinsics.b(uri, "uri");
        Intrinsics.b(liveCommentsUpdater, "updater");
        uri = RedditClient.m9217a(SessionManager.m9191b()).m9233a(uri, liveCommentsUpdater);
        Intrinsics.a(uri, "redditClient.liveCommentsSocket(uri, updater)");
        return uri;
    }

    public static WebSocketConnection m8950a(Uri uri, RedirectUpdater redirectUpdater) {
        Intrinsics.b(uri, "uri");
        Intrinsics.b(redirectUpdater, "updater");
        uri = RedditClient.m9217a(SessionManager.m9191b()).m9235a(uri, redirectUpdater);
        Intrinsics.a(uri, "redditClient.liveRedirectsSocket(uri, updater)");
        return uri;
    }
}
