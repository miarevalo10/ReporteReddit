package kotlin.reflect.jvm.internal.pcollections;

final class IntTreePMap<V> {
    private static final IntTreePMap<Object> f26451b = new IntTreePMap(IntTree.f26445a);
    final IntTree<V> f26452a;

    public static <V> IntTreePMap<V> m28139a() {
        return f26451b;
    }

    IntTreePMap(IntTree<V> intTree) {
        this.f26452a = intTree;
    }
}
