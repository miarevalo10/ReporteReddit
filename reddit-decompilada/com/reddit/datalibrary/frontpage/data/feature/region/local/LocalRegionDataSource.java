package com.reddit.datalibrary.frontpage.data.feature.region.local;

import com.reddit.frontpage.domain.model.Region;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¨\u0006\n"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/region/local/LocalRegionDataSource;", "", "get", "Lio/reactivex/Maybe;", "", "Lcom/reddit/frontpage/domain/model/Region;", "save", "Lio/reactivex/Single;", "", "regions", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LocalRegionDataSource.kt */
public interface LocalRegionDataSource {
    Maybe<List<Region>> mo2976a();

    Single<Boolean> mo2977a(List<Region> list);
}
