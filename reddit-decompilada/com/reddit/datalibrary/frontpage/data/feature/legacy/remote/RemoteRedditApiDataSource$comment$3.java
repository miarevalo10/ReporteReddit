package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.requests.models.v1.CommentReplyResponse;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/CommentReplyResponse;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$comment$3<T> implements Consumer<CommentReplyResponse> {
    public static final RemoteRedditApiDataSource$comment$3 f15883a = new RemoteRedditApiDataSource$comment$3();

    RemoteRedditApiDataSource$comment$3() {
    }

    public final /* synthetic */ void accept(Object obj) {
        Timber.b("RRADS Success: 52 comment", new Object[0]);
    }
}
