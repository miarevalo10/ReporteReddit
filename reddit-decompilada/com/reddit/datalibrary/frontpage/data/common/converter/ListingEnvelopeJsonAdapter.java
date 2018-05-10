package com.reddit.datalibrary.frontpage.data.common.converter;

import com.reddit.datalibrary.frontpage.data.model.ChildrenEnvelope;
import com.reddit.datalibrary.frontpage.data.model.Envelope;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.data.model.ListingEnvelope;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0001¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/ListingEnvelopeJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "", "delegate", "Lcom/reddit/datalibrary/frontpage/data/model/ListingEnvelope;", "(Lcom/squareup/moshi/JsonAdapter;)V", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingEnvelopeJsonAdapter.kt */
public final class ListingEnvelopeJsonAdapter extends JsonAdapter<Object> {
    public static final Companion Companion = new Companion();
    private static final Factory FACTORY = new ListingEnvelopeJsonAdapter$Companion$FACTORY$1();
    private final JsonAdapter<ListingEnvelope<?>> delegate;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/ListingEnvelopeJsonAdapter$Companion;", "", "()V", "FACTORY", "Lcom/squareup/moshi/JsonAdapter$Factory;", "getFACTORY", "()Lcom/squareup/moshi/JsonAdapter$Factory;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ListingEnvelopeJsonAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Factory getFACTORY() {
            return ListingEnvelopeJsonAdapter.FACTORY;
        }
    }

    private ListingEnvelopeJsonAdapter(JsonAdapter<ListingEnvelope<?>> jsonAdapter) {
        this.delegate = jsonAdapter;
    }

    public final Object fromJson(JsonReader jsonReader) {
        Intrinsics.b(jsonReader, "reader");
        jsonReader = this.delegate.fromJson(jsonReader);
        if (jsonReader == null) {
            Intrinsics.a();
        }
        jsonReader = ((ListingEnvelope) jsonReader).getData();
        Iterable<Envelope> children = jsonReader.getChildren();
        Collection arrayList = new ArrayList(CollectionsKt.b(children));
        for (Envelope data : children) {
            arrayList.add(data.getData());
        }
        List list = (List) arrayList;
        String after = jsonReader.getAfter();
        String before = jsonReader.getBefore();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(jsonReader.getAdDistance());
        return new Listing(list, after, before, stringBuilder.toString());
    }

    public final void toJson(JsonWriter jsonWriter, Object obj) {
        Intrinsics.b(jsonWriter, "writer");
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<*>");
        }
        Iterable<Object> iterable = (List) obj;
        Collection collection = (Collection) new ArrayList(CollectionsKt.b(iterable));
        for (Object envelope : iterable) {
            collection.add(new Envelope(envelope, null, 2, null));
        }
        this.delegate.toJson(new ListingEnvelope(new ChildrenEnvelope((List) collection, null, null, null)));
    }
}
