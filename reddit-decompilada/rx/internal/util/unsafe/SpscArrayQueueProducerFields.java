package rx.internal.util.unsafe;

/* compiled from: SpscArrayQueue */
abstract class SpscArrayQueueProducerFields<E> extends SpscArrayQueueL1Pad<E> {
    protected static final long f42066f = UnsafeAccess.m43483a(SpscArrayQueueProducerFields.class, "producerIndex");
    protected long producerIndex;

    public SpscArrayQueueProducerFields(int i) {
        super(i);
    }
}
