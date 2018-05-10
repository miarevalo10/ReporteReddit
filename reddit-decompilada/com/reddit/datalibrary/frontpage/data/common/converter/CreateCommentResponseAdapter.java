package com.reddit.datalibrary.frontpage.data.common.converter;

import com.reddit.datalibrary.frontpage.data.model.Envelope;
import com.reddit.frontpage.domain.model.Comment;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonReader;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/CreateCommentResponseAdapter;", "", "()V", "fromJson", "Lcom/reddit/frontpage/domain/model/Comment;", "reader", "Lcom/squareup/moshi/JsonReader;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CreateCommentResponseAdapter.kt */
public final class CreateCommentResponseAdapter {
    public static final CreateCommentResponseAdapter INSTANCE = new CreateCommentResponseAdapter();

    private CreateCommentResponseAdapter() {
    }

    @FromJson
    public final Comment fromJson(JsonReader jsonReader) {
        Intrinsics.b(jsonReader, "reader");
        jsonReader = DataWithErrorsResponse.Companion.getAdapter$app_standardRelease().fromJsonValue(jsonReader.o());
        if (jsonReader == null) {
            Intrinsics.a();
        }
        DataWithErrorsResponse dataWithErrorsResponse = (DataWithErrorsResponse) jsonReader;
        CommentResponseAdapter commentResponseAdapter = CommentResponseAdapter.INSTANCE;
        jsonReader = dataWithErrorsResponse.getJson().getData();
        if (jsonReader == null) {
            Intrinsics.a();
        }
        jsonReader = commentResponseAdapter.parseComment$app_standardRelease((Envelope) jsonReader.getThings().get(0));
        if (jsonReader != null) {
            return (Comment) jsonReader;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.domain.model.Comment");
    }
}
