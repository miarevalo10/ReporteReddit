package com.reddit.datalibrary.frontpage.data.common.converter;

import com.reddit.datalibrary.frontpage.data.common.converter.DataWithErrorsResponse.Data;
import com.reddit.datalibrary.frontpage.data.model.Envelope;
import com.reddit.frontpage.domain.model.CreateEditLinkResponse;
import com.reddit.frontpage.domain.model.Link;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi.Builder;
import com.squareup.moshi.ToJson;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/CreateEditLinkResponseAdapter;", "", "()V", "linkAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/reddit/frontpage/domain/model/Link;", "fromJson", "Lcom/reddit/frontpage/domain/model/CreateEditLinkResponse;", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CreateEditLinkResponseAdapter.kt */
public final class CreateEditLinkResponseAdapter {
    public static final CreateEditLinkResponseAdapter INSTANCE = new CreateEditLinkResponseAdapter();
    private static final JsonAdapter<Link> linkAdapter;

    @ToJson
    public final void toJson(JsonWriter jsonWriter, CreateEditLinkResponse createEditLinkResponse) {
        Intrinsics.b(jsonWriter, "writer");
    }

    static {
        JsonAdapter a = new Builder().a().a(Link.class);
        Intrinsics.a(a, "Moshi.Builder()\n      .b…adapter(Link::class.java)");
        linkAdapter = a;
    }

    private CreateEditLinkResponseAdapter() {
    }

    @FromJson
    public final CreateEditLinkResponse fromJson(JsonReader jsonReader) {
        Link link;
        Intrinsics.b(jsonReader, "reader");
        jsonReader = DataWithErrorsResponse.Companion.getAdapter$app_standardRelease().fromJsonValue(jsonReader.o());
        if (jsonReader == null) {
            Intrinsics.a();
        }
        DataWithErrorsResponse dataWithErrorsResponse = (DataWithErrorsResponse) jsonReader;
        Data data = dataWithErrorsResponse.getJson().getData();
        if (data != null) {
            List things = data.getThings();
            if (things != null) {
                Envelope envelope = (Envelope) CollectionsKt.e(things);
                if (envelope != null) {
                    link = (Link) linkAdapter.fromJsonValue(envelope.getData());
                    return new CreateEditLinkResponse(link, dataWithErrorsResponse.getJson().getErrors());
                }
            }
        }
        link = null;
        return new CreateEditLinkResponse(link, dataWithErrorsResponse.getJson().getErrors());
    }
}
