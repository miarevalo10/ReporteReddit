package com.reddit.datalibrary.frontpage.data.common.converter;

import com.reddit.datalibrary.frontpage.data.model.Envelope;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonAdapter.Factory;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/CommentListResponseAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "", "()V", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommentListResponseAdapter.kt */
public final class CommentListResponseAdapter extends JsonAdapter<Object> {
    public static final Companion Companion = new Companion();
    private static final Factory FACTORY = CommentListResponseAdapter$Companion$FACTORY$1.INSTANCE;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/CommentListResponseAdapter$Companion;", "", "()V", "FACTORY", "Lcom/squareup/moshi/JsonAdapter$Factory;", "getFACTORY", "()Lcom/squareup/moshi/JsonAdapter$Factory;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommentListResponseAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Factory getFACTORY() {
            return CommentListResponseAdapter.FACTORY;
        }
    }

    public final void toJson(JsonWriter jsonWriter, Object obj) {
    }

    private CommentListResponseAdapter() {
    }

    public final Object fromJson(JsonReader jsonReader) {
        Intrinsics.b(jsonReader, "reader");
        jsonReader = DataWithErrorsResponse.Companion.getAdapter$app_standardRelease().fromJsonValue(jsonReader.o());
        if (jsonReader == null) {
            Intrinsics.a();
        }
        jsonReader = ((DataWithErrorsResponse) jsonReader).getJson().getData();
        if (jsonReader == null) {
            Intrinsics.a();
        }
        Iterable<Envelope> things = jsonReader.getThings();
        Collection arrayList = new ArrayList(CollectionsKt.b(things));
        for (Envelope parseComment$app_standardRelease : things) {
            arrayList.add(CommentResponseAdapter.INSTANCE.parseComment$app_standardRelease(parseComment$app_standardRelease));
        }
        return (List) arrayList;
    }
}
