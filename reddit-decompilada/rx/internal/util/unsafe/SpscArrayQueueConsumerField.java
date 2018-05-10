package rx.internal.util.unsafe;

/* compiled from: SpscArrayQueue */
abstract class SpscArrayQueueConsumerField<E> extends SpscArrayQueueL2Pad<E> {
    protected static final long f42069e = UnsafeAccess.m43483a(SpscArrayQueueConsumerField.class, "consumerIndex");
    protected long consumerIndex;

    public SpscArrayQueueConsumerField(int i) {
        super(i);
    }
}
