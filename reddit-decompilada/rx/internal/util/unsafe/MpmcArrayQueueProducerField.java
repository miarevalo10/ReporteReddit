package rx.internal.util.unsafe;

/* compiled from: MpmcArrayQueue */
abstract class MpmcArrayQueueProducerField<E> extends MpmcArrayQueueL1Pad<E> {
    static final long f42065f = UnsafeAccess.m43483a(MpmcArrayQueueProducerField.class, "producerIndex");
    volatile long producerIndex;

    public MpmcArrayQueueProducerField(int i) {
        super(i);
    }
}
