package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¨\u0006\u0005¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "(Lkotlin/jvm/functions/Function0;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: Sequences.kt */
public final class SlidingWindowKt$windowedSequence$$inlined$Sequence$1 implements Sequence<List<? extends T>> {
    final /* synthetic */ Sequence f32513a;
    final /* synthetic */ int f32514b = 2;
    final /* synthetic */ int f32515c = 1;
    final /* synthetic */ boolean f32516d = false;
    final /* synthetic */ boolean f32517e = false;

    public SlidingWindowKt$windowedSequence$$inlined$Sequence$1(Sequence sequence) {
        this.f32513a = sequence;
    }

    public final Iterator<List<? extends T>> mo5679a() {
        return SlidingWindowKt.m26805a(this.f32513a.mo5679a(), this.f32514b, this.f32515c, this.f32516d, this.f32517e);
    }
}
