package kotlin.collections;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"kotlin/collections/RingBuffer$iterator$1", "Lkotlin/collections/AbstractIterator;", "(Lkotlin/collections/RingBuffer;)V", "count", "", "index", "computeNext", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: SlidingWindow.kt */
public final class RingBuffer$iterator$1 extends AbstractIterator<T> {
    final /* synthetic */ RingBuffer f36005c;
    private int f36006d;
    private int f36007e;

    RingBuffer$iterator$1(RingBuffer ringBuffer) {
        this.f36005c = ringBuffer;
        this.f36006d = ringBuffer.size();
        this.f36007e = ringBuffer.f38199c;
    }

    protected final void mo6656a() {
        if (this.f36006d == 0) {
            this.f32498a = State.f25281c;
            return;
        }
        this.f32499b = this.f36005c.f38198b[this.f36007e];
        this.f32498a = State.f25279a;
        this.f36007e = (this.f36007e + 1) % this.f36005c.f38201e;
        this.f36006d--;
    }
}
