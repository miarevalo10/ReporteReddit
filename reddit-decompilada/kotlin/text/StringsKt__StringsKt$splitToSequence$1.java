package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: Strings.kt */
final class StringsKt__StringsKt$splitToSequence$1 extends Lambda implements Function1<IntRange, String> {
    final /* synthetic */ CharSequence f38977a;

    StringsKt__StringsKt$splitToSequence$1(CharSequence charSequence) {
        this.f38977a = charSequence;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        IntRange intRange = (IntRange) obj;
        Intrinsics.m26847b(intRange, "it");
        return StringsKt__StringsKt.m42444a(this.f38977a, intRange);
    }
}
