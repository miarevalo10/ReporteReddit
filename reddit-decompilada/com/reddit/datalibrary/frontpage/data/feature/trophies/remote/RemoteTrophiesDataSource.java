package com.reddit.datalibrary.frontpage.data.feature.trophies.remote;

import com.reddit.datalibrary.frontpage.data.common.converter.TrophiesEnveloped;
import com.reddit.datalibrary.frontpage.data.model.TrophyRemoteDataModel;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'¨\u0006\b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/trophies/remote/RemoteTrophiesDataSource;", "", "getTrophies", "Lio/reactivex/Single;", "", "Lcom/reddit/datalibrary/frontpage/data/model/TrophyRemoteDataModel;", "username", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteTrophiesDataSource.kt */
public interface RemoteTrophiesDataSource {
    @TrophiesEnveloped
    @GET(a = "user/{username}/trophies.json")
    Single<List<TrophyRemoteDataModel>> getTrophies(@Path(a = "username") String str);
}
