package rx.internal.util.unsafe;

/* compiled from: MpmcArrayQueue */
abstract class MpmcArrayQueueConsumerField<E> extends MpmcArrayQueueL2Pad<E> {
    static final long f42068e = UnsafeAccess.m43483a(MpmcArrayQueueConsumerField.class, "consumerIndex");
    volatile long consumerIndex;

    public MpmcArrayQueueConsumerField(int i) {
        super(i);
    }
}
