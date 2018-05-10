package com.reddit.datalibrary.frontpage.data.common.converter;

import com.reddit.frontpage.domain.model.Subreddit;
import com.squareup.moshi.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/reddit/frontpage/domain/model/Subreddit;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: DiscoveryUnitListingDataModelJsonAdapter.kt */
final class DiscoveryUnitListingDataModelJsonAdapter$subredditAdapter$2 extends Lambda implements Function0<JsonAdapter<Subreddit>> {
    public static final DiscoveryUnitListingDataModelJsonAdapter$subredditAdapter$2 INSTANCE = new DiscoveryUnitListingDataModelJsonAdapter$subredditAdapter$2();

    DiscoveryUnitListingDataModelJsonAdapter$subredditAdapter$2() {
        super(0);
    }

    public final JsonAdapter<Subreddit> invoke() {
        return DiscoveryUnitListingDataModelJsonAdapter.moshi.a(Subreddit.class);
    }
}