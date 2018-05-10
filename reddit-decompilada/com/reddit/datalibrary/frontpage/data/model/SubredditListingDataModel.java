package com.reddit.datalibrary.frontpage.data.model;

import com.reddit.frontpage.domain.model.Subreddit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/SubredditListingDataModel;", "", "result", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "(Ljava/util/List;)V", "getResult", "()Ljava/util/List;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditListingDataModel.kt */
public final class SubredditListingDataModel {
    private final List<Subreddit> result;

    public SubredditListingDataModel(List<Subreddit> list) {
        Intrinsics.b(list, "result");
        this.result = list;
    }

    public final List<Subreddit> getResult() {
        return this.result;
    }
}
