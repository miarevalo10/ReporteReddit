package com.reddit.datalibrary.frontpage.data.common.converter;

import com.squareup.moshi.JsonAdapter.Factory;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u001b\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032,\u0010\u0005\u001a(\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\b0\u00062\u000e\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/data/common/converter/CommentListResponseAdapter;", "<anonymous parameter 0>", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "annotations", "", "", "", "<anonymous parameter 2>", "Lcom/squareup/moshi/Moshi;", "create"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommentListResponseAdapter.kt */
final class CommentListResponseAdapter$Companion$FACTORY$1 implements Factory {
    public static final CommentListResponseAdapter$Companion$FACTORY$1 INSTANCE = new CommentListResponseAdapter$Companion$FACTORY$1();

    CommentListResponseAdapter$Companion$FACTORY$1() {
    }

    public final CommentListResponseAdapter create(Type type, Set<? extends Annotation> set, Moshi moshi) {
        if (Types.a(set, CommentsList.class) == null) {
            return null;
        }
        return new CommentListResponseAdapter();
    }
}
