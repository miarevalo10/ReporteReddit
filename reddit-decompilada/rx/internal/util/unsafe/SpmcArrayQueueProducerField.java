package rx.internal.util.unsafe;

/* compiled from: SpmcArrayQueue */
abstract class SpmcArrayQueueProducerField<E> extends SpmcArrayQueueL1Pad<E> {
    protected static final long f42059e = UnsafeAccess.m43483a(SpmcArrayQueueProducerField.class, "producerIndex");
    volatile long producerIndex;

    protected final void m44214d(long j) {
        UnsafeAccess.f41383a.putOrderedLong(this, f42059e, j);
    }

    public SpmcArrayQueueProducerField(int i) {
        super(i);
    }
}
