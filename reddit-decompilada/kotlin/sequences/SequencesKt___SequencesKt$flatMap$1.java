package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "R", "T", "it", "Lkotlin/sequences/Sequence;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: _Sequences.kt */
final class SequencesKt___SequencesKt$flatMap$1 extends Lambda implements Function1<Sequence<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMap$1 f38974a = new SequencesKt___SequencesKt$flatMap$1();

    SequencesKt___SequencesKt$flatMap$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Sequence sequence = (Sequence) obj;
        Intrinsics.m26847b(sequence, "it");
        return sequence.mo5679a();
    }
}
