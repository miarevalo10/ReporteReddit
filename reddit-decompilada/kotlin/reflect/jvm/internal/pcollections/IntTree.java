package kotlin.reflect.jvm.internal.pcollections;

final class IntTree<V> {
    static final IntTree<Object> f26445a = new IntTree();
    final long f26446b;
    final V f26447c;
    final IntTree<V> f26448d;
    final IntTree<V> f26449e;
    final int f26450f;

    private IntTree() {
        this.f26450f = 0;
        this.f26446b = 0;
        this.f26447c = null;
        this.f26448d = null;
        this.f26449e = null;
    }

    private IntTree(long j, V v, IntTree<V> intTree, IntTree<V> intTree2) {
        this.f26446b = j;
        this.f26447c = v;
        this.f26448d = intTree;
        this.f26449e = intTree2;
        this.f26450f = (1 + intTree.f26450f) + intTree2.f26450f;
    }

    private IntTree<V> m28136a(long j) {
        if (this.f26450f != 0) {
            if (j != this.f26446b) {
                return new IntTree(j, this.f26447c, this.f26448d, this.f26449e);
            }
        }
        return this;
    }

    final IntTree<V> m28138a(long j, V v) {
        if (this.f26450f == 0) {
            return new IntTree(j, v, this, this);
        }
        if (j < this.f26446b) {
            return m28137a(this.f26448d.m28138a(j - this.f26446b, (Object) v), this.f26449e);
        }
        if (j > this.f26446b) {
            return m28137a(this.f26448d, this.f26449e.m28138a(j - this.f26446b, (Object) v));
        }
        if (v == this.f26447c) {
            return this;
        }
        return new IntTree(j, v, this.f26448d, this.f26449e);
    }

    private IntTree<V> m28137a(IntTree<V> intTree, IntTree<V> intTree2) {
        IntTree<V> intTree3 = intTree;
        IntTree<V> intTree4 = intTree2;
        if (intTree3 == this.f26448d && intTree4 == r0.f26449e) {
            return r0;
        }
        long j = r0.f26446b;
        Object obj = r0.f26447c;
        if (intTree3.f26450f + intTree4.f26450f > 1) {
            IntTree intTree5;
            if (intTree3.f26450f >= intTree4.f26450f * 5) {
                IntTree intTree6 = intTree3.f26448d;
                IntTree intTree7 = intTree3.f26449e;
                if (intTree7.f26450f < 2 * intTree6.f26450f) {
                    return new IntTree(intTree3.f26446b + j, intTree3.f26447c, intTree6, new IntTree(-intTree3.f26446b, obj, intTree7.m28136a(intTree7.f26446b + intTree3.f26446b), intTree4));
                }
                IntTree intTree8 = intTree7.f26448d;
                intTree5 = intTree7.f26449e;
                long j2 = (intTree7.f26446b + intTree3.f26446b) + j;
                Object obj2 = intTree7.f26447c;
                IntTree intTree9 = new IntTree(-intTree7.f26446b, intTree3.f26447c, intTree6, intTree8.m28136a(intTree8.f26446b + intTree7.f26446b));
                j = (-intTree3.f26446b) - intTree7.f26446b;
                IntTree a = intTree5.m28136a((intTree5.f26446b + intTree7.f26446b) + intTree3.f26446b);
                IntTree<V> intTree10 = new IntTree(j2, obj2, intTree9, new IntTree(j, obj, a, intTree4));
                return r22;
            } else if (intTree4.f26450f >= 5 * intTree3.f26450f) {
                intTree5 = intTree4.f26448d;
                IntTree intTree11 = intTree4.f26449e;
                if (intTree5.f26450f < 2 * intTree11.f26450f) {
                    return new IntTree(intTree4.f26446b + j, intTree4.f26447c, new IntTree(-intTree4.f26446b, obj, intTree3, intTree5.m28136a(intTree5.f26446b + intTree4.f26446b)), intTree11);
                }
                IntTree intTree12 = intTree5.f26448d;
                IntTree intTree13 = intTree5.f26449e;
                long j3 = (intTree5.f26446b + intTree4.f26446b) + j;
                Object obj3 = intTree5.f26447c;
                return new IntTree(j3, obj3, new IntTree((-intTree4.f26446b) - intTree5.f26446b, obj, intTree3, intTree12.m28136a((intTree12.f26446b + intTree5.f26446b) + intTree4.f26446b)), new IntTree(-intTree5.f26446b, intTree4.f26447c, intTree13.m28136a(intTree13.f26446b + intTree5.f26446b), intTree11));
            }
        }
        return new IntTree(j, obj, intTree3, intTree4);
    }
}
