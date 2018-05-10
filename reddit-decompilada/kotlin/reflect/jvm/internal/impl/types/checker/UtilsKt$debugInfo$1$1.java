package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringBuilderJVMKt;

/* compiled from: utils.kt */
final class UtilsKt$debugInfo$1$1 extends Lambda implements Function1<String, StringBuilder> {
    final /* synthetic */ StringBuilder f38945a;

    UtilsKt$debugInfo$1$1(StringBuilder stringBuilder) {
        this.f38945a = stringBuilder;
        super(1);
    }

    public final StringBuilder m38707a(String str) {
        Intrinsics.m26847b(str, "$receiver");
        StringBuilder stringBuilder = this.f38945a;
        stringBuilder.append(str);
        return StringsKt__StringBuilderJVMKt.m36469a(stringBuilder);
    }
}
