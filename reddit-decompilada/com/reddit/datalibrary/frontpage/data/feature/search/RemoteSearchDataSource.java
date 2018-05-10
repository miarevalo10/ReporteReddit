package com.reddit.datalibrary.frontpage.data.feature.search;

import com.reddit.datalibrary.frontpage.data.model.RemoteSearchResult;
import io.reactivex.Single;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\bH'J.\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0006H'¨\u0006\r"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/search/RemoteSearchDataSource;", "", "getSearchSuggestions", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/RemoteSearchResult;", "query", "", "allowNsfw", "", "includeUsers", "search", "types", "after", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteSearchDataSource.kt */
public interface RemoteSearchDataSource {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: RemoteSearchDataSource.kt */
    public static final class DefaultImpls {
        @GET(a = "api/subreddit_autocomplete_v2")
        public static /* synthetic */ Single getSearchSuggestions$default(RemoteSearchDataSource remoteSearchDataSource, String str, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSearchSuggestions");
            }
            if ((i & 2) != null) {
                z = true;
            }
            if ((i & 4) != 0) {
                z2 = true;
            }
            return remoteSearchDataSource.getSearchSuggestions(str, z, z2);
        }

        @GET(a = "search")
        public static /* synthetic */ Single search$default(RemoteSearchDataSource remoteSearchDataSource, String str, String str2, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: search");
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            return remoteSearchDataSource.search(str, str2, str3);
        }
    }

    @GET(a = "api/subreddit_autocomplete_v2")
    Single<RemoteSearchResult> getSearchSuggestions(@Query(a = "query") String str, @Query(a = "include_over_18") boolean z, @Query(a = "include_users") boolean z2);

    @GET(a = "search")
    Single<RemoteSearchResult> search(@Query(a = "q") String str, @Query(a = "type") String str2, @Query(a = "after") String str3);
}
