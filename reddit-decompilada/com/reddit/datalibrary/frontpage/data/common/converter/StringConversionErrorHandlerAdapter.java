package com.reddit.datalibrary.frontpage.data.common.converter;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/StringConversionErrorHandlerAdapter;", "", "()V", "fromJson", "", "reader", "Lcom/squareup/moshi/JsonReader;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: StringConversionErrorHandlerAdapter.kt */
public final class StringConversionErrorHandlerAdapter {
    public static final StringConversionErrorHandlerAdapter INSTANCE = new StringConversionErrorHandlerAdapter();

    private StringConversionErrorHandlerAdapter() {
    }

    @FromJson
    public final String fromJson(JsonReader jsonReader) {
        Intrinsics.b(jsonReader, "reader");
        jsonReader = jsonReader.o();
        if (jsonReader == null) {
            return null;
        }
        if (jsonReader instanceof String) {
            return (String) jsonReader;
        }
        if (jsonReader instanceof Double) {
            return String.valueOf((long) ((Number) jsonReader).doubleValue());
        }
        return jsonReader.toString();
    }
}
