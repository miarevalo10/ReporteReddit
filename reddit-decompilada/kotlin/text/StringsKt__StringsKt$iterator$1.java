package kotlin.text;

import kotlin.Metadata;
import kotlin.collections.CharIterator;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"kotlin/text/StringsKt__StringsKt$iterator$1", "Lkotlin/collections/CharIterator;", "(Ljava/lang/CharSequence;)V", "index", "", "hasNext", "", "nextChar", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: Strings.kt */
public final class StringsKt__StringsKt$iterator$1 extends CharIterator {
    final /* synthetic */ CharSequence f36197a;
    private int f36198b;

    StringsKt__StringsKt$iterator$1(CharSequence charSequence) {
        this.f36197a = charSequence;
    }

    public final char mo6745a() {
        CharSequence charSequence = this.f36197a;
        int i = this.f36198b;
        this.f36198b = i + 1;
        return charSequence.charAt(i);
    }

    public final boolean hasNext() {
        return this.f36198b < this.f36197a.length();
    }
}
