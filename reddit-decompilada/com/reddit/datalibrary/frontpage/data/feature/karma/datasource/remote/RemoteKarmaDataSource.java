package com.reddit.datalibrary.frontpage.data.feature.karma.datasource.remote;

import com.reddit.datalibrary.frontpage.data.model.Envelope;
import com.reddit.frontpage.domain.model.Karma;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/karma/datasource/remote/RemoteKarmaDataSource;", "", "getTopKarma", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Envelope;", "", "Lcom/reddit/frontpage/domain/model/Karma;", "username", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteKarmaDataSource.kt */
public interface RemoteKarmaDataSource {
    @GET(a = "user/{username}/top_karma_subreddits")
    Single<Envelope<List<Karma>>> getTopKarma(@Path(a = "username") String str);
}
