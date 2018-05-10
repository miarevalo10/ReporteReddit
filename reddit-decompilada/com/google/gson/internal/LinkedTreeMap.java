package com.google.gson.internal;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean f8765f = true;
    private static final Comparator<Comparable> f8766g = new C04561();
    Comparator<? super K> f8767a;
    Node<K, V> f8768b;
    int f8769c;
    int f8770d;
    final Node<K, V> f8771e;
    private EntrySet f8772h;
    private KeySet f8773i;

    static class C04561 implements Comparator<Comparable> {
        C04561() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    }

    class EntrySet extends AbstractSet<Entry<K, V>> {
        final /* synthetic */ LinkedTreeMap f8751a;

        class C12291 extends LinkedTreeMapIterator<Entry<K, V>> {
            final /* synthetic */ EntrySet f15031a;

            C12291(EntrySet entrySet) {
                this.f15031a = entrySet;
                super(entrySet.f8751a);
            }

            public /* synthetic */ Object next() {
                return m7539a();
            }
        }

        EntrySet(LinkedTreeMap linkedTreeMap) {
            this.f8751a = linkedTreeMap;
        }

        public int size() {
            return this.f8751a.f8769c;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C12291(this);
        }

        public boolean contains(Object obj) {
            return (!(obj instanceof Entry) || this.f8751a.m7547a((Entry) obj) == null) ? null : true;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Node a = this.f8751a.m7547a((Entry) obj);
            if (a == null) {
                return false;
            }
            this.f8751a.m7548a(a, true);
            return true;
        }

        public void clear() {
            this.f8751a.clear();
        }
    }

    final class KeySet extends AbstractSet<K> {
        final /* synthetic */ LinkedTreeMap f8752a;

        class C12301 extends LinkedTreeMapIterator<K> {
            final /* synthetic */ KeySet f15032a;

            C12301(KeySet keySet) {
                this.f15032a = keySet;
                super(keySet.f8752a);
            }

            public K next() {
                return m7539a().f8762f;
            }
        }

        KeySet(LinkedTreeMap linkedTreeMap) {
            this.f8752a = linkedTreeMap;
        }

        public final int size() {
            return this.f8752a.f8769c;
        }

        public final Iterator<K> iterator() {
            return new C12301(this);
        }

        public final boolean contains(Object obj) {
            return this.f8752a.containsKey(obj);
        }

        public final boolean remove(Object obj) {
            return this.f8752a.m7546a(obj) != null ? true : null;
        }

        public final void clear() {
            this.f8752a.clear();
        }
    }

    private abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        Node<K, V> f8753b = this.f8756e.f8771e.f8760d;
        Node<K, V> f8754c = null;
        int f8755d = this.f8756e.f8770d;
        final /* synthetic */ LinkedTreeMap f8756e;

        LinkedTreeMapIterator(LinkedTreeMap linkedTreeMap) {
            this.f8756e = linkedTreeMap;
        }

        public final boolean hasNext() {
            return this.f8753b != this.f8756e.f8771e;
        }

        final Node<K, V> m7539a() {
            Node<K, V> node = this.f8753b;
            if (node == this.f8756e.f8771e) {
                throw new NoSuchElementException();
            } else if (this.f8756e.f8770d != this.f8755d) {
                throw new ConcurrentModificationException();
            } else {
                this.f8753b = node.f8760d;
                this.f8754c = node;
                return node;
            }
        }

        public final void remove() {
            if (this.f8754c == null) {
                throw new IllegalStateException();
            }
            this.f8756e.m7548a(this.f8754c, true);
            this.f8754c = null;
            this.f8755d = this.f8756e.f8770d;
        }
    }

    static final class Node<K, V> implements Entry<K, V> {
        Node<K, V> f8757a;
        Node<K, V> f8758b;
        Node<K, V> f8759c;
        Node<K, V> f8760d;
        Node<K, V> f8761e;
        final K f8762f;
        V f8763g;
        int f8764h;

        Node() {
            this.f8762f = null;
            this.f8761e = this;
            this.f8760d = this;
        }

        Node(Node<K, V> node, K k, Node<K, V> node2, Node<K, V> node3) {
            this.f8757a = node;
            this.f8762f = k;
            this.f8764h = 1;
            this.f8760d = node2;
            this.f8761e = node3;
            node3.f8760d = this;
            node2.f8761e = this;
        }

        public final K getKey() {
            return this.f8762f;
        }

        public final V getValue() {
            return this.f8763g;
        }

        public final V setValue(V v) {
            V v2 = this.f8763g;
            this.f8763g = v;
            return v2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
            r3 = this;
            r0 = r4 instanceof java.util.Map.Entry;
            r1 = 0;
            if (r0 == 0) goto L_0x0038;
        L_0x0005:
            r4 = (java.util.Map.Entry) r4;
            r0 = r3.f8762f;
            if (r0 != 0) goto L_0x0012;
        L_0x000b:
            r0 = r4.getKey();
            if (r0 != 0) goto L_0x0037;
        L_0x0011:
            goto L_0x001e;
        L_0x0012:
            r0 = r3.f8762f;
            r2 = r4.getKey();
            r0 = r0.equals(r2);
            if (r0 == 0) goto L_0x0037;
        L_0x001e:
            r0 = r3.f8763g;
            if (r0 != 0) goto L_0x0029;
        L_0x0022:
            r4 = r4.getValue();
            if (r4 != 0) goto L_0x0037;
        L_0x0028:
            goto L_0x0035;
        L_0x0029:
            r0 = r3.f8763g;
            r4 = r4.getValue();
            r4 = r0.equals(r4);
            if (r4 == 0) goto L_0x0037;
        L_0x0035:
            r4 = 1;
            return r4;
        L_0x0037:
            return r1;
        L_0x0038:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.Node.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = this.f8762f == null ? 0 : this.f8762f.hashCode();
            if (this.f8763g != null) {
                i = this.f8763g.hashCode();
            }
            return hashCode ^ i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f8762f);
            stringBuilder.append(Operation.EQUALS);
            stringBuilder.append(this.f8763g);
            return stringBuilder.toString();
        }
    }

    public LinkedTreeMap() {
        this(f8766g);
    }

    private LinkedTreeMap(Comparator<? super K> comparator) {
        this.f8769c = 0;
        this.f8770d = 0;
        this.f8771e = new Node();
        if (comparator == null) {
            comparator = f8766g;
        }
        this.f8767a = comparator;
    }

    public final int size() {
        return this.f8769c;
    }

    public final V get(Object obj) {
        obj = m7543b(obj);
        return obj != null ? obj.f8763g : null;
    }

    public final boolean containsKey(Object obj) {
        return m7543b(obj) != null ? true : null;
    }

    public final V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        k = m7540a((Object) k, true);
        V v2 = k.f8763g;
        k.f8763g = v;
        return v2;
    }

    public final void clear() {
        this.f8768b = null;
        this.f8769c = 0;
        this.f8770d++;
        Node node = this.f8771e;
        node.f8761e = node;
        node.f8760d = node;
    }

    public final V remove(Object obj) {
        obj = m7546a(obj);
        return obj != null ? obj.f8763g : null;
    }

    private Node<K, V> m7540a(K k, boolean z) {
        Comparator comparator = this.f8767a;
        Node node = this.f8768b;
        int compareTo;
        if (node != null) {
            Comparable comparable = comparator == f8766g ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    compareTo = comparable.compareTo(node.f8762f);
                } else {
                    compareTo = comparator.compare(k, node.f8762f);
                }
                if (compareTo != 0) {
                    Node node2;
                    if (compareTo < 0) {
                        node2 = node.f8758b;
                    } else {
                        node2 = node.f8759c;
                    }
                    if (node2 == null) {
                        break;
                    }
                    node = node2;
                } else {
                    return node;
                }
            }
        }
        compareTo = 0;
        if (!z) {
            return null;
        }
        Node<K, V> node3;
        z = this.f8771e;
        if (node != null) {
            node3 = new Node(node, k, z, z.f8761e);
            if (compareTo < 0) {
                node.f8758b = node3;
            } else {
                node.f8759c = node3;
            }
            m7545b(node, true);
        } else if (comparator != f8766g || (k instanceof Comparable)) {
            node3 = new Node(node, k, z, z.f8761e);
            this.f8768b = node3;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(k.getClass().getName());
            stringBuilder.append(" is not Comparable");
            throw new ClassCastException(stringBuilder.toString());
        }
        this.f8769c += 1;
        this.f8770d += 1;
        return node3;
    }

    private com.google.gson.internal.LinkedTreeMap.Node<K, V> m7543b(java.lang.Object r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r0 = 0;
        if (r3 == 0) goto L_0x000a;
    L_0x0003:
        r1 = 0;
        r3 = r2.m7540a(r3, r1);	 Catch:{ ClassCastException -> 0x0009 }
        return r3;
    L_0x0009:
        return r0;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.b(java.lang.Object):com.google.gson.internal.LinkedTreeMap$Node<K, V>");
    }

    final Node<K, V> m7547a(Entry<?, ?> entry) {
        Node<K, V> b = m7543b(entry.getKey());
        Object obj = 1;
        if (b != null) {
            Entry<?, ?> entry2 = b.f8763g;
            entry = entry.getValue();
            if (entry2 != entry) {
                if (entry2 == null || entry2.equals(entry) == null) {
                    entry = null;
                    if (entry != null) {
                        return obj != null ? b : null;
                    }
                }
            }
            entry = 1;
            if (entry != null) {
                if (obj != null) {
                }
            }
        }
        obj = null;
        if (obj != null) {
        }
    }

    final void m7548a(Node<K, V> node, boolean z) {
        if (z) {
            node.f8761e.f8760d = node.f8760d;
            node.f8760d.f8761e = node.f8761e;
        }
        Node node2 = node.f8758b;
        Node node3 = node.f8759c;
        Node node4 = node.f8757a;
        int i = 0;
        if (!node2 != false || node3 == null) {
            if (node2 == true) {
                m7542a((Node) node, node2);
                node.f8758b = null;
            } else if (node3 != null) {
                m7542a((Node) node, node3);
                node.f8759c = null;
            } else {
                m7542a((Node) node, null);
            }
            m7545b(node4, false);
            this.f8769c--;
            this.f8770d++;
            return;
        }
        int i2;
        if (node2.f8764h > node3.f8764h) {
            node3 = node2.f8759c;
            while (true) {
                Node node5 = node3;
                node3 = z;
                z = node5;
                if (!z) {
                    break;
                }
                node3 = z.f8759c;
            }
        } else {
            while (true) {
                z = node3.f8758b;
                if (!z) {
                    break;
                }
                node3 = z;
            }
        }
        m7548a(node3, false);
        z = node.f8758b;
        if (z) {
            i2 = z.f8764h;
            node3.f8758b = z;
            z.f8757a = node3;
            node.f8758b = null;
        } else {
            i2 = 0;
        }
        z = node.f8759c;
        if (z) {
            i = z.f8764h;
            node3.f8759c = z;
            z.f8757a = node3;
            node.f8759c = null;
        }
        node3.f8764h = Math.max(i2, i) + 1;
        m7542a((Node) node, node3);
    }

    final Node<K, V> m7546a(Object obj) {
        Node b = m7543b(obj);
        if (b != null) {
            m7548a(b, true);
        }
        return b;
    }

    private void m7542a(Node<K, V> node, Node<K, V> node2) {
        Node node3 = node.f8757a;
        node.f8757a = null;
        if (node2 != null) {
            node2.f8757a = node3;
        }
        if (node3 == null) {
            this.f8768b = node2;
        } else if (node3.f8758b == node) {
            node3.f8758b = node2;
        } else if (f8765f || node3.f8759c == node) {
            node3.f8759c = node2;
        } else {
            throw new AssertionError();
        }
    }

    private void m7545b(Node<K, V> node, boolean z) {
        Node node2;
        while (node2 != null) {
            Node node3 = node2.f8758b;
            Node node4 = node2.f8759c;
            int i = 0;
            int i2 = node3 != null ? node3.f8764h : 0;
            int i3 = node4 != null ? node4.f8764h : 0;
            int i4 = i2 - i3;
            Node node5;
            if (i4 == -2) {
                node3 = node4.f8758b;
                node5 = node4.f8759c;
                i2 = node5 != null ? node5.f8764h : 0;
                if (node3 != null) {
                    i = node3.f8764h;
                }
                i -= i2;
                if (i != -1) {
                    if (i != 0 || z) {
                        if (f8765f || i == 1) {
                            m7544b(node4);
                            m7541a(node2);
                            if (!z) {
                                break;
                            }
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
                m7541a(node2);
                if (!z) {
                    break;
                }
            } else if (i4 == 2) {
                node4 = node3.f8758b;
                node5 = node3.f8759c;
                i2 = node5 != null ? node5.f8764h : 0;
                if (node4 != null) {
                    i = node4.f8764h;
                }
                i -= i2;
                if (i != 1) {
                    if (i != 0 || z) {
                        if (f8765f || i == -1) {
                            m7541a(node3);
                            m7544b(node2);
                            if (!z) {
                                break;
                            }
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
                m7544b(node2);
                if (!z) {
                    break;
                }
            } else if (i4 == 0) {
                node2.f8764h = i2 + 1;
                if (z) {
                    return;
                }
            } else if (f8765f || i4 == -1 || i4 == 1) {
                node2.f8764h = Math.max(i2, i3) + 1;
                if (!z) {
                    break;
                }
            } else {
                throw new AssertionError();
            }
            node2 = node2.f8757a;
        }
    }

    private void m7541a(Node<K, V> node) {
        Node node2 = node.f8758b;
        Node node3 = node.f8759c;
        Node node4 = node3.f8758b;
        Node node5 = node3.f8759c;
        node.f8759c = node4;
        if (node4 != null) {
            node4.f8757a = node;
        }
        m7542a((Node) node, node3);
        node3.f8758b = node;
        node.f8757a = node3;
        int i = 0;
        node.f8764h = Math.max(node2 != null ? node2.f8764h : 0, node4 != null ? node4.f8764h : 0) + 1;
        node = node.f8764h;
        if (node5 != null) {
            i = node5.f8764h;
        }
        node3.f8764h = Math.max(node, i) + 1;
    }

    private void m7544b(Node<K, V> node) {
        Node node2 = node.f8758b;
        Node node3 = node.f8759c;
        Node node4 = node2.f8758b;
        Node node5 = node2.f8759c;
        node.f8758b = node5;
        if (node5 != null) {
            node5.f8757a = node;
        }
        m7542a((Node) node, node2);
        node2.f8759c = node;
        node.f8757a = node2;
        int i = 0;
        node.f8764h = Math.max(node3 != null ? node3.f8764h : 0, node5 != null ? node5.f8764h : 0) + 1;
        node = node.f8764h;
        if (node4 != null) {
            i = node4.f8764h;
        }
        node2.f8764h = Math.max(node, i) + 1;
    }

    public final Set<Entry<K, V>> entrySet() {
        Set set = this.f8772h;
        if (set != null) {
            return set;
        }
        set = new EntrySet(this);
        this.f8772h = set;
        return set;
    }

    public final Set<K> keySet() {
        Set set = this.f8773i;
        if (set != null) {
            return set;
        }
        set = new KeySet(this);
        this.f8773i = set;
        return set;
    }
}
