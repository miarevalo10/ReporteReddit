package rx.internal.util.unsafe;

public final class Pow2 {
    public static boolean m43482b(int i) {
        return (i & (i + -1)) == 0;
    }

    public static int m43481a(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
