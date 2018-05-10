package com.reddit.datalibrary.frontpage.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0002\u0010\u0006R\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/TrophiesEnvelope;", "", "trophies", "", "Lcom/reddit/datalibrary/frontpage/data/model/Envelope;", "Lcom/reddit/datalibrary/frontpage/data/model/TrophyRemoteDataModel;", "(Ljava/util/List;)V", "getTrophies", "()Ljava/util/List;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TrophiesEnvelope.kt */
public final class TrophiesEnvelope {
    private final List<Envelope<TrophyRemoteDataModel>> trophies;

    public TrophiesEnvelope(List<Envelope<TrophyRemoteDataModel>> list) {
        Intrinsics.b(list, "trophies");
        this.trophies = list;
    }

    public final List<Envelope<TrophyRemoteDataModel>> getTrophies() {
        return this.trophies;
    }
}
