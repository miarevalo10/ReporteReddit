package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditNameInfo;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SubredditNameInfo;", "kotlin.jvm.PlatformType", "", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$searchSubredditNames$3<T> implements Consumer<List<SubredditNameInfo>> {
    public static final RemoteRedditApiDataSource$searchSubredditNames$3 f15985a = new RemoteRedditApiDataSource$searchSubredditNames$3();

    RemoteRedditApiDataSource$searchSubredditNames$3() {
    }

    public final /* synthetic */ void accept(Object obj) {
        Timber.b("RRADS Success: 42 searchSubredditNames", new Object[0]);
    }
}
