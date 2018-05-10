package com.reddit.datalibrary.frontpage.data.common.busevents;

import com.reddit.datalibrary.frontpage.data.common.converter.CommentResponseAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.DataWithErrorsResponse;
import com.reddit.datalibrary.frontpage.data.common.converter.DataWithErrorsResponse.Data;
import com.reddit.datalibrary.frontpage.data.model.Envelope;
import com.reddit.frontpage.domain.model.Comment;
import com.reddit.frontpage.domain.model.CreateEditCommentResponse;
import com.reddit.frontpage.domain.model.IComment;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.ToJson;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/busevents/CreateEditCommentResponseAdapter;", "", "()V", "fromJson", "Lcom/reddit/frontpage/domain/model/CreateEditCommentResponse;", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CreateEditCommentResponseAdapter.kt */
public final class CreateEditCommentResponseAdapter {
    public static final CreateEditCommentResponseAdapter f10304a = new CreateEditCommentResponseAdapter();

    @ToJson
    public final void toJson(JsonWriter jsonWriter, CreateEditCommentResponse createEditCommentResponse) {
        Intrinsics.b(jsonWriter, "writer");
    }

    private CreateEditCommentResponseAdapter() {
    }

    @FromJson
    public final CreateEditCommentResponse fromJson(JsonReader jsonReader) {
        Intrinsics.b(jsonReader, "reader");
        jsonReader = DataWithErrorsResponse.Companion.getAdapter$app_standardRelease().fromJsonValue(jsonReader.o());
        if (jsonReader == null) {
            Intrinsics.a();
        }
        DataWithErrorsResponse dataWithErrorsResponse = (DataWithErrorsResponse) jsonReader;
        Data data = dataWithErrorsResponse.getJson().getData();
        Comment comment = null;
        if (data != null) {
            List things = data.getThings();
            if (things != null) {
                Envelope envelope = (Envelope) CollectionsKt.e(things);
                if (envelope != null) {
                    IComment parseComment$app_standardRelease = CommentResponseAdapter.INSTANCE.parseComment$app_standardRelease(envelope);
                    if (!(parseComment$app_standardRelease instanceof Comment)) {
                        parseComment$app_standardRelease = null;
                    }
                    comment = (Comment) parseComment$app_standardRelease;
                }
            }
        }
        return new CreateEditCommentResponse(comment, dataWithErrorsResponse.getJson().getErrors());
    }
}
