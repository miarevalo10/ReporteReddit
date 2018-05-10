package com.reddit.datalibrary.frontpage.data.common.converter;

import com.reddit.datalibrary.frontpage.data.model.Envelope;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.data.model.ListingEnvelope;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.frontpage.domain.model.ILink;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.LiveUpdateEvent;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonAdapter.Factory;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Moshi.Builder;
import com.squareup.moshi.Types;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016R2\u0010\u0004\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000RJ\u0010\u0007\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0006*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b0\b \u0006*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0006*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b0\b\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\n0\n \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\n0\n\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/FrontpageLinkListingResponseAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "", "()V", "linkAdapter", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "linkListAdapter", "Lcom/reddit/datalibrary/frontpage/data/model/ListingEnvelope;", "liveUpdateEventAdapter", "Lcom/reddit/frontpage/domain/model/LiveUpdateEvent;", "moshi", "Lcom/squareup/moshi/Moshi;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FrontpageLinkListingResponseAdapter.kt */
public final class FrontpageLinkListingResponseAdapter extends JsonAdapter<Object> {
    public static final Companion Companion = new Companion();
    private static final Factory FACTORY = FrontpageLinkListingResponseAdapter$Companion$FACTORY$1.INSTANCE;
    private final JsonAdapter<Link> linkAdapter;
    private final JsonAdapter<ListingEnvelope<Object>> linkListAdapter;
    private final JsonAdapter<LiveUpdateEvent> liveUpdateEventAdapter;
    private final Moshi moshi;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/FrontpageLinkListingResponseAdapter$Companion;", "", "()V", "FACTORY", "Lcom/squareup/moshi/JsonAdapter$Factory;", "getFACTORY", "()Lcom/squareup/moshi/JsonAdapter$Factory;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: FrontpageLinkListingResponseAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Factory getFACTORY() {
            return FrontpageLinkListingResponseAdapter.FACTORY;
        }
    }

    public final void toJson(JsonWriter jsonWriter, Object obj) {
    }

    private FrontpageLinkListingResponseAdapter() {
        this.moshi = new Builder().a(StringConversionErrorHandlerAdapter.INSTANCE).a();
        this.linkListAdapter = this.moshi.a(Types.a(ListingEnvelope.class, new Type[]{Object.class}));
        this.liveUpdateEventAdapter = this.moshi.a(LiveUpdateEvent.class);
        this.linkAdapter = this.moshi.a(Link.class);
    }

    public final Object fromJson(JsonReader jsonReader) {
        Intrinsics.b(jsonReader, "reader");
        jsonReader = this.linkListAdapter.fromJson(jsonReader);
        if (jsonReader == null) {
            Intrinsics.a();
        }
        jsonReader = ((ListingEnvelope) jsonReader).getData();
        Iterable<Envelope> children = jsonReader.getChildren();
        Collection arrayList = new ArrayList(CollectionsKt.b(children));
        for (Envelope envelope : children) {
            String kind = envelope.getKind();
            if (kind != null) {
                Object fromJsonValue;
                int hashCode = kind.hashCode();
                if (hashCode != -1973124443) {
                    if (hashCode == 3647) {
                        if (kind.equals(Kind.LINK)) {
                            fromJsonValue = this.linkAdapter.fromJsonValue(envelope.getData());
                            if (fromJsonValue == null) {
                                Intrinsics.a();
                            }
                            Intrinsics.a(fromJsonValue, "linkAdapter.fromJsonValue(envelope.data)!!");
                            fromJsonValue = (ILink) fromJsonValue;
                        }
                    }
                } else if (kind.equals(Kind.LIVE_UPDATE_EVENT)) {
                    fromJsonValue = this.liveUpdateEventAdapter.fromJsonValue(envelope.getData());
                    if (fromJsonValue == null) {
                        Intrinsics.a();
                    }
                    Intrinsics.a(fromJsonValue, "liveUpdateEventAdapter.f…sonValue(envelope.data)!!");
                    fromJsonValue = (ILink) fromJsonValue;
                }
                arrayList.add(fromJsonValue);
            }
            throw ((Throwable) new RuntimeException("Unsupported link type"));
        }
        return new Listing((List) arrayList, jsonReader.getAfter(), jsonReader.getBefore(), null, 8, null);
    }
}
