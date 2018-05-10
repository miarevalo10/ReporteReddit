package com.reddit.datalibrary.frontpage.data.common.converter;

import com.reddit.datalibrary.frontpage.data.model.Envelope;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonAdapter.Factory;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/reddit/datalibrary/frontpage/data/common/converter/EnvelopeJsonAdapter$Companion$FACTORY$1", "Lcom/squareup/moshi/JsonAdapter$Factory;", "()V", "create", "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: EnvelopeJsonAdapter.kt */
public final class EnvelopeJsonAdapter$Companion$FACTORY$1 implements Factory {
    EnvelopeJsonAdapter$Companion$FACTORY$1() {
    }

    public final JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
        Intrinsics.b(type, "type");
        Intrinsics.b(set, "annotations");
        Intrinsics.b(moshi, "moshi");
        set = Types.a(set, Enveloped.class);
        if (set == null) {
            return null;
        }
        type = moshi.a(this, Types.a(Envelope.class, new Type[]{type}), set);
        Intrinsics.a(type, "delegate");
        return (JsonAdapter) new EnvelopeJsonAdapter(type);
    }
}
