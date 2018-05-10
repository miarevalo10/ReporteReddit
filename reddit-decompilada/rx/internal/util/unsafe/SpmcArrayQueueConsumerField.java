package rx.internal.util.unsafe;

/* compiled from: SpmcArrayQueue */
abstract class SpmcArrayQueueConsumerField<E> extends SpmcArrayQueueL2Pad<E> {
    protected static final long f42067d = UnsafeAccess.m43483a(SpmcArrayQueueConsumerField.class, "consumerIndex");
    volatile long consumerIndex;

    public SpmcArrayQueueConsumerField(int i) {
        super(i);
    }

    protected final boolean m44246a(long j, long j2) {
        return UnsafeAccess.f41383a.compareAndSwapLong(this, f42067d, j, j2);
    }
}
