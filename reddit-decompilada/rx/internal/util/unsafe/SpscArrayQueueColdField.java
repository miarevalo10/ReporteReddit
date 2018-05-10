package rx.internal.util.unsafe;

/* compiled from: SpscArrayQueue */
abstract class SpscArrayQueueColdField<E> extends ConcurrentCircularArrayQueue<E> {
    private static final Integer f42032e = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int f42033d;

    public SpscArrayQueueColdField(int i) {
        super(i);
        this.f42033d = Math.min(i / 4, f42032e.intValue());
    }
}
