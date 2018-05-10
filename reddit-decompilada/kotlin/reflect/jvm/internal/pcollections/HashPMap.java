package kotlin.reflect.jvm.internal.pcollections;

public final class HashPMap<K, V> {
    private static final HashPMap<Object, Object> f26442a = new HashPMap(IntTreePMap.m28139a(), 0);
    private final IntTreePMap<ConsPStack<MapEntry<K, V>>> f26443b;
    private final int f26444c;

    public static <K, V> HashPMap<K, V> m28133a() {
        HashPMap<K, V> hashPMap = f26442a;
        if (hashPMap != null) {
            return hashPMap;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/pcollections/HashPMap", "empty"}));
    }

    private HashPMap(IntTreePMap<ConsPStack<MapEntry<K, V>>> intTreePMap, int i) {
        this.f26443b = intTreePMap;
        this.f26444c = i;
    }

    public final HashPMap<K, V> m28135a(K k, V v) {
        ConsPStack a = m28134a(k.hashCode());
        int i = a.f26441c;
        int i2 = 0;
        ConsPStack consPStack = a;
        while (consPStack != null && consPStack.f26441c > 0) {
            if (((MapEntry) consPStack.f26439a).f26453a.equals(k)) {
                break;
            }
            consPStack = consPStack.f26440b;
            i2++;
        }
        i2 = -1;
        if (i2 != -1) {
            a = a.m28132a(a.m28131a(i2));
        }
        Object consPStack2 = new ConsPStack(new MapEntry(k, v), a);
        IntTreePMap intTreePMap = this.f26443b;
        k = intTreePMap.f26452a.m28138a((long) k.hashCode(), consPStack2);
        if (k != intTreePMap.f26452a) {
            intTreePMap = new IntTreePMap(k);
        }
        return new HashPMap(intTreePMap, (this.f26444c - i) + consPStack2.f26441c);
    }

    public final ConsPStack<MapEntry<K, V>> m28134a(int i) {
        IntTree intTree = this.f26443b.f26452a;
        long j = (long) i;
        while (intTree.f26450f != 0) {
            if (j >= intTree.f26446b) {
                if (j <= intTree.f26446b) {
                    i = intTree.f26447c;
                    break;
                }
                i = intTree.f26449e;
                j -= intTree.f26446b;
            } else {
                i = intTree.f26448d;
                j -= intTree.f26446b;
            }
            intTree = i;
        }
        i = 0;
        ConsPStack consPStack = (ConsPStack) i;
        return consPStack == null ? ConsPStack.m28128a() : consPStack;
    }
}
