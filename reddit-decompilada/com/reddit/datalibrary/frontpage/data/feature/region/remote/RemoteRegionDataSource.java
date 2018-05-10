package com.reddit.datalibrary.frontpage.data.feature.region.remote;

import com.reddit.datalibrary.frontpage.data.model.RemoteRegionDataModel;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import retrofit2.http.GET;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003H'¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/region/remote/RemoteRegionDataSource;", "", "getRegions", "Lio/reactivex/Single;", "", "", "Lcom/reddit/datalibrary/frontpage/data/model/RemoteRegionDataModel;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteRegionDataSource.kt */
public interface RemoteRegionDataSource {
    @GET(a = "api/geopopular_config")
    Single<Map<String, RemoteRegionDataModel>> getRegions();
}
