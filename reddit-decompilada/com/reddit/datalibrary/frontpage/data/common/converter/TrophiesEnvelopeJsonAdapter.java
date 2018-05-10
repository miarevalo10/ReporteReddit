package com.reddit.datalibrary.frontpage.data.common.converter;

import com.reddit.datalibrary.frontpage.data.model.Envelope;
import com.reddit.datalibrary.frontpage.data.model.TrophiesEnvelope;
import com.reddit.datalibrary.frontpage.data.model.TrophyRemoteDataModel;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonAdapter.Factory;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u001b\b\u0002\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/TrophiesEnvelopeJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "", "delegate", "Lcom/reddit/datalibrary/frontpage/data/model/Envelope;", "Lcom/reddit/datalibrary/frontpage/data/model/TrophiesEnvelope;", "(Lcom/squareup/moshi/JsonAdapter;)V", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TrophiesEnvelopeJsonAdapter.kt */
public final class TrophiesEnvelopeJsonAdapter extends JsonAdapter<Object> {
    public static final Companion Companion = new Companion();
    private static final Factory FACTORY = new TrophiesEnvelopeJsonAdapter$Companion$FACTORY$1();
    private final JsonAdapter<Envelope<TrophiesEnvelope>> delegate;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/TrophiesEnvelopeJsonAdapter$Companion;", "", "()V", "FACTORY", "Lcom/squareup/moshi/JsonAdapter$Factory;", "getFACTORY", "()Lcom/squareup/moshi/JsonAdapter$Factory;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: TrophiesEnvelopeJsonAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Factory getFACTORY() {
            return TrophiesEnvelopeJsonAdapter.FACTORY;
        }
    }

    private TrophiesEnvelopeJsonAdapter(JsonAdapter<Envelope<TrophiesEnvelope>> jsonAdapter) {
        this.delegate = jsonAdapter;
    }

    public final Object fromJson(JsonReader jsonReader) {
        Intrinsics.b(jsonReader, "reader");
        jsonReader = this.delegate.fromJson(jsonReader);
        if (jsonReader == null) {
            Intrinsics.a();
        }
        TrophiesEnvelope trophiesEnvelope = (TrophiesEnvelope) ((Envelope) jsonReader).getData();
        if (trophiesEnvelope == null) {
            Intrinsics.a();
        }
        Iterable<Envelope> trophies = trophiesEnvelope.getTrophies();
        Collection arrayList = new ArrayList(CollectionsKt.b(trophies));
        for (Envelope data : trophies) {
            arrayList.add((TrophyRemoteDataModel) data.getData());
        }
        return (List) arrayList;
    }

    public final void toJson(JsonWriter jsonWriter, Object obj) {
        Intrinsics.b(jsonWriter, "writer");
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<*>");
        }
        Iterable iterable = (List) obj;
        Collection collection = (Collection) new ArrayList(CollectionsKt.b(iterable));
        for (Object next : iterable) {
            if (next == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.data.model.TrophyRemoteDataModel");
            }
            collection.add(new Envelope((TrophyRemoteDataModel) next, null, 2, null));
        }
        this.delegate.toJson(new Envelope(new TrophiesEnvelope((List) collection), null, 2, null));
    }
}
