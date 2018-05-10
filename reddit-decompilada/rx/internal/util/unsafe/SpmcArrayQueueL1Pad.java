package rx.internal.util.unsafe;

/* compiled from: SpmcArrayQueue */
abstract class SpmcArrayQueueL1Pad<E> extends ConcurrentCircularArrayQueue<E> {
    public SpmcArrayQueueL1Pad(int i) {
        super(i);
    }
}
