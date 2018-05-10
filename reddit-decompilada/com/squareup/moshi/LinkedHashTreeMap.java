package com.squareup.moshi;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean f23679g = true;
    private static final Comparator<Comparable> f23680h = new C20471();
    Comparator<? super K> f23681a;
    Node<K, V>[] f23682b;
    final Node<K, V> f23683c;
    int f23684d;
    int f23685e;
    int f23686f;
    private EntrySet f23687i;
    private KeySet f23688j;

    class C20471 implements Comparator<Comparable> {
        C20471() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    }

    static final class AvlBuilder<K, V> {
        private Node<K, V> f23659a;
        private int f23660b;
        private int f23661c;
        private int f23662d;

        AvlBuilder() {
        }

        final void m25697a(int i) {
            this.f23660b = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.f23662d = 0;
            this.f23661c = 0;
            this.f23659a = 0;
        }

        final void m25698a(Node<K, V> node) {
            node.f23672c = null;
            node.f23670a = null;
            node.f23671b = null;
            node.f23678i = 1;
            if (this.f23660b > 0 && (this.f23662d & 1) == 0) {
                this.f23662d++;
                this.f23660b--;
                this.f23661c++;
            }
            node.f23670a = this.f23659a;
            this.f23659a = node;
            this.f23662d += 1;
            if (this.f23660b > null && (this.f23662d & 1) == null) {
                this.f23662d += 1;
                this.f23660b -= 1;
                this.f23661c += 1;
            }
            node = 4;
            while (true) {
                int i = node - 1;
                if ((this.f23662d & i) == i) {
                    Node node2;
                    Node node3;
                    if (this.f23661c == 0) {
                        node2 = this.f23659a;
                        Node node4 = node2.f23670a;
                        node3 = node4.f23670a;
                        node4.f23670a = node3.f23670a;
                        this.f23659a = node4;
                        node4.f23671b = node3;
                        node4.f23672c = node2;
                        node4.f23678i = node2.f23678i + 1;
                        node3.f23670a = node4;
                        node2.f23670a = node4;
                    } else if (this.f23661c == 1) {
                        node2 = this.f23659a;
                        node3 = node2.f23670a;
                        this.f23659a = node3;
                        node3.f23672c = node2;
                        node3.f23678i = node2.f23678i + 1;
                        node2.f23670a = node3;
                        this.f23661c = 0;
                    } else if (this.f23661c == 2) {
                        this.f23661c = 0;
                    }
                    node *= 2;
                } else {
                    return;
                }
            }
        }

        final Node<K, V> m25696a() {
            Node<K, V> node = this.f23659a;
            if (node.f23670a == null) {
                return node;
            }
            throw new IllegalStateException();
        }
    }

    static class AvlIterator<K, V> {
        private Node<K, V> f23663a;

        AvlIterator() {
        }

        final void m25700a(Node<K, V> node) {
            Node<K, V> node2 = null;
            while (true) {
                Node<K, V> node3 = node2;
                node2 = node;
                node = node3;
                if (node2 != null) {
                    node2.f23670a = node;
                    node = node2.f23671b;
                } else {
                    this.f23663a = node;
                    return;
                }
            }
        }

        public final Node<K, V> m25699a() {
            Node<K, V> node = this.f23663a;
            if (node == null) {
                return null;
            }
            Node node2 = node.f23670a;
            node.f23670a = null;
            Node node3 = node.f23672c;
            while (true) {
                Node node4 = node2;
                node2 = node3;
                node3 = node4;
                if (node2 != null) {
                    node2.f23670a = node3;
                    node3 = node2.f23671b;
                } else {
                    this.f23663a = node3;
                    return node;
                }
            }
        }
    }

    final class EntrySet extends AbstractSet<Entry<K, V>> {
        final /* synthetic */ LinkedHashTreeMap f23664a;

        class C25101 extends LinkedTreeMapIterator<Entry<K, V>> {
            final /* synthetic */ EntrySet f30650a;

            C25101(EntrySet entrySet) {
                this.f30650a = entrySet;
                super(entrySet.f23664a);
            }

            public /* synthetic */ Object next() {
                return m25701a();
            }
        }

        EntrySet(LinkedHashTreeMap linkedHashTreeMap) {
            this.f23664a = linkedHashTreeMap;
        }

        public final int size() {
            return this.f23664a.f23684d;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new C25101(this);
        }

        public final boolean contains(Object obj) {
            return (!(obj instanceof Entry) || this.f23664a.m25710a((Entry) obj) == null) ? null : true;
        }

        public final boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Node a = this.f23664a.m25710a((Entry) obj);
            if (a == null) {
                return false;
            }
            this.f23664a.m25711a(a, true);
            return true;
        }

        public final void clear() {
            this.f23664a.clear();
        }
    }

    final class KeySet extends AbstractSet<K> {
        final /* synthetic */ LinkedHashTreeMap f23665a;

        class C25111 extends LinkedTreeMapIterator<K> {
            final /* synthetic */ KeySet f30651a;

            C25111(KeySet keySet) {
                this.f30651a = keySet;
                super(keySet.f23665a);
            }

            public K next() {
                return m25701a().f23675f;
            }
        }

        KeySet(LinkedHashTreeMap linkedHashTreeMap) {
            this.f23665a = linkedHashTreeMap;
        }

        public final int size() {
            return this.f23665a.f23684d;
        }

        public final Iterator<K> iterator() {
            return new C25111(this);
        }

        public final boolean contains(Object obj) {
            return this.f23665a.containsKey(obj);
        }

        public final boolean remove(Object obj) {
            return this.f23665a.m25709a(obj) != null ? true : null;
        }

        public final void clear() {
            this.f23665a.clear();
        }
    }

    abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        Node<K, V> f23666b = this.f23669e.f23683c.f23673d;
        Node<K, V> f23667c = null;
        int f23668d = this.f23669e.f23685e;
        final /* synthetic */ LinkedHashTreeMap f23669e;

        LinkedTreeMapIterator(LinkedHashTreeMap linkedHashTreeMap) {
            this.f23669e = linkedHashTreeMap;
        }

        public final boolean hasNext() {
            return this.f23666b != this.f23669e.f23683c;
        }

        final Node<K, V> m25701a() {
            Node<K, V> node = this.f23666b;
            if (node == this.f23669e.f23683c) {
                throw new NoSuchElementException();
            } else if (this.f23669e.f23685e != this.f23668d) {
                throw new ConcurrentModificationException();
            } else {
                this.f23666b = node.f23673d;
                this.f23667c = node;
                return node;
            }
        }

        public final void remove() {
            if (this.f23667c == null) {
                throw new IllegalStateException();
            }
            this.f23669e.m25711a(this.f23667c, true);
            this.f23667c = null;
            this.f23668d = this.f23669e.f23685e;
        }
    }

    static final class Node<K, V> implements Entry<K, V> {
        Node<K, V> f23670a;
        Node<K, V> f23671b;
        Node<K, V> f23672c;
        Node<K, V> f23673d;
        Node<K, V> f23674e;
        final K f23675f;
        final int f23676g;
        V f23677h;
        int f23678i;

        Node() {
            this.f23675f = null;
            this.f23676g = -1;
            this.f23674e = this;
            this.f23673d = this;
        }

        Node(Node<K, V> node, K k, int i, Node<K, V> node2, Node<K, V> node3) {
            this.f23670a = node;
            this.f23675f = k;
            this.f23676g = i;
            this.f23678i = 1;
            this.f23673d = node2;
            this.f23674e = node3;
            node3.f23673d = this;
            node2.f23674e = this;
        }

        public final K getKey() {
            return this.f23675f;
        }

        public final V getValue() {
            return this.f23677h;
        }

        public final V setValue(V v) {
            V v2 = this.f23677h;
            this.f23677h = v;
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
            r0 = r3.f23675f;
            if (r0 != 0) goto L_0x0012;
        L_0x000b:
            r0 = r4.getKey();
            if (r0 != 0) goto L_0x0037;
        L_0x0011:
            goto L_0x001e;
        L_0x0012:
            r0 = r3.f23675f;
            r2 = r4.getKey();
            r0 = r0.equals(r2);
            if (r0 == 0) goto L_0x0037;
        L_0x001e:
            r0 = r3.f23677h;
            if (r0 != 0) goto L_0x0029;
        L_0x0022:
            r4 = r4.getValue();
            if (r4 != 0) goto L_0x0037;
        L_0x0028:
            goto L_0x0035;
        L_0x0029:
            r0 = r3.f23677h;
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
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.LinkedHashTreeMap.Node.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = this.f23675f == null ? 0 : this.f23675f.hashCode();
            if (this.f23677h != null) {
                i = this.f23677h.hashCode();
            }
            return hashCode ^ i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f23675f);
            stringBuilder.append(Operation.EQUALS);
            stringBuilder.append(this.f23677h);
            return stringBuilder.toString();
        }
    }

    LinkedHashTreeMap() {
        this((byte) 0);
    }

    private LinkedHashTreeMap(byte b) {
        this.f23684d = 0;
        this.f23685e = 0;
        this.f23681a = f23680h;
        this.f23683c = new Node();
        this.f23682b = new Node[(byte) 16];
        this.f23686f = (this.f23682b.length / 2) + (this.f23682b.length / 4);
    }

    public final int size() {
        return this.f23684d;
    }

    public final V get(Object obj) {
        obj = m25706b(obj);
        return obj != null ? obj.f23677h : null;
    }

    public final boolean containsKey(Object obj) {
        return m25706b(obj) != null ? true : null;
    }

    public final V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        k = m25702a((Object) k, true);
        V v2 = k.f23677h;
        k.f23677h = v;
        return v2;
    }

    public final void clear() {
        Arrays.fill(this.f23682b, null);
        this.f23684d = 0;
        this.f23685e++;
        Node node = this.f23683c;
        Node node2 = node.f23673d;
        while (node2 != node) {
            Node node3 = node2.f23673d;
            node2.f23674e = null;
            node2.f23673d = null;
            node2 = node3;
        }
        node.f23674e = node;
        node.f23673d = node;
    }

    public final V remove(Object obj) {
        obj = m25709a(obj);
        return obj != null ? obj.f23677h : null;
    }

    private Node<K, V> m25702a(K k, boolean z) {
        int compareTo;
        Comparator comparator = this.f23681a;
        Node[] nodeArr = this.f23682b;
        int hashCode = k.hashCode();
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        int i = ((hashCode >>> 7) ^ hashCode) ^ (hashCode >>> 4);
        int length = i & (nodeArr.length - 1);
        Node<K, V> node = nodeArr[length];
        if (node != null) {
            Comparable comparable = comparator == f23680h ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    compareTo = comparable.compareTo(node.f23675f);
                } else {
                    compareTo = comparator.compare(k, node.f23675f);
                }
                if (compareTo != 0) {
                    Node<K, V> node2;
                    if (compareTo < 0) {
                        node2 = node.f23671b;
                    } else {
                        node2 = node.f23672c;
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
        Node<K, V> node3 = node;
        int i2 = compareTo;
        if (!z) {
            return null;
        }
        Node node4 = this.f23683c;
        Node node5;
        if (node3 != null) {
            node5 = new Node(node3, k, i, node4, node4.f23674e);
            if (i2 < 0) {
                node3.f23671b = node5;
            } else {
                node3.f23672c = node5;
            }
            m25708b(node3, true);
        } else if (comparator != f23680h || (k instanceof Comparable)) {
            node5 = new Node(node3, k, i, node4, node4.f23674e);
            nodeArr[length] = node5;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(k.getClass().getName());
            stringBuilder.append(" is not Comparable");
            throw new ClassCastException(stringBuilder.toString());
        }
        k = this.f23684d;
        this.f23684d = k + 1;
        if (k > this.f23686f) {
            this.f23682b = m25705a(this.f23682b);
            this.f23686f = (this.f23682b.length / 2) + (this.f23682b.length / 4);
        }
        this.f23685e += 1;
        return z;
    }

    private com.squareup.moshi.LinkedHashTreeMap.Node<K, V> m25706b(java.lang.Object r3) {
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
        r3 = r2.m25702a(r3, r1);	 Catch:{ ClassCastException -> 0x0009 }
        return r3;
    L_0x0009:
        return r0;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.LinkedHashTreeMap.b(java.lang.Object):com.squareup.moshi.LinkedHashTreeMap$Node<K, V>");
    }

    final Node<K, V> m25710a(Entry<?, ?> entry) {
        Node<K, V> b = m25706b(entry.getKey());
        Object obj = 1;
        if (b != null) {
            Entry<?, ?> entry2 = b.f23677h;
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

    final void m25711a(Node<K, V> node, boolean z) {
        if (z) {
            node.f23674e.f23673d = node.f23673d;
            node.f23673d.f23674e = node.f23674e;
            node.f23674e = null;
            node.f23673d = null;
        }
        Node node2 = node.f23671b;
        Node node3 = node.f23672c;
        Node node4 = node.f23670a;
        int i = 0;
        if (!node2 != false || node3 == null) {
            if (node2 == true) {
                m25704a((Node) node, node2);
                node.f23671b = null;
            } else if (node3 != null) {
                m25704a((Node) node, node3);
                node.f23672c = null;
            } else {
                m25704a((Node) node, null);
            }
            m25708b(node4, false);
            this.f23684d--;
            this.f23685e++;
            return;
        }
        int i2;
        if (node2.f23678i > node3.f23678i) {
            node3 = node2.f23672c;
            while (true) {
                Node node5 = node3;
                node3 = z;
                z = node5;
                if (!z) {
                    break;
                }
                node3 = z.f23672c;
            }
        } else {
            while (true) {
                z = node3.f23671b;
                if (!z) {
                    break;
                }
                node3 = z;
            }
        }
        m25711a(node3, false);
        z = node.f23671b;
        if (z) {
            i2 = z.f23678i;
            node3.f23671b = z;
            z.f23670a = node3;
            node.f23671b = null;
        } else {
            i2 = 0;
        }
        z = node.f23672c;
        if (z) {
            i = z.f23678i;
            node3.f23672c = z;
            z.f23670a = node3;
            node.f23672c = null;
        }
        node3.f23678i = Math.max(i2, i) + 1;
        m25704a((Node) node, node3);
    }

    final Node<K, V> m25709a(Object obj) {
        Node b = m25706b(obj);
        if (b != null) {
            m25711a(b, true);
        }
        return b;
    }

    private void m25704a(Node<K, V> node, Node<K, V> node2) {
        Node node3 = node.f23670a;
        node.f23670a = null;
        if (node2 != null) {
            node2.f23670a = node3;
        }
        if (node3 == null) {
            this.f23682b[node.f23676g & (this.f23682b.length - 1)] = node2;
        } else if (node3.f23671b == node) {
            node3.f23671b = node2;
        } else if (f23679g || node3.f23672c == node) {
            node3.f23672c = node2;
        } else {
            throw new AssertionError();
        }
    }

    private void m25708b(Node<K, V> node, boolean z) {
        Node node2;
        while (node2 != null) {
            Node node3 = node2.f23671b;
            Node node4 = node2.f23672c;
            int i = 0;
            int i2 = node3 != null ? node3.f23678i : 0;
            int i3 = node4 != null ? node4.f23678i : 0;
            int i4 = i2 - i3;
            Node node5;
            if (i4 == -2) {
                node3 = node4.f23671b;
                node5 = node4.f23672c;
                i2 = node5 != null ? node5.f23678i : 0;
                if (node3 != null) {
                    i = node3.f23678i;
                }
                i -= i2;
                if (i != -1) {
                    if (i != 0 || z) {
                        if (f23679g || i == 1) {
                            m25707b(node4);
                            m25703a(node2);
                            if (!z) {
                                break;
                            }
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
                m25703a(node2);
                if (!z) {
                    break;
                }
            } else if (i4 == 2) {
                node4 = node3.f23671b;
                node5 = node3.f23672c;
                i2 = node5 != null ? node5.f23678i : 0;
                if (node4 != null) {
                    i = node4.f23678i;
                }
                i -= i2;
                if (i != 1) {
                    if (i != 0 || z) {
                        if (f23679g || i == -1) {
                            m25703a(node3);
                            m25707b(node2);
                            if (!z) {
                                break;
                            }
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
                m25707b(node2);
                if (!z) {
                    break;
                }
            } else if (i4 == 0) {
                node2.f23678i = i2 + 1;
                if (z) {
                    return;
                }
            } else if (f23679g || i4 == -1 || i4 == 1) {
                node2.f23678i = Math.max(i2, i3) + 1;
                if (!z) {
                    break;
                }
            } else {
                throw new AssertionError();
            }
            node2 = node2.f23670a;
        }
    }

    private void m25703a(Node<K, V> node) {
        Node node2 = node.f23671b;
        Node node3 = node.f23672c;
        Node node4 = node3.f23671b;
        Node node5 = node3.f23672c;
        node.f23672c = node4;
        if (node4 != null) {
            node4.f23670a = node;
        }
        m25704a((Node) node, node3);
        node3.f23671b = node;
        node.f23670a = node3;
        int i = 0;
        node.f23678i = Math.max(node2 != null ? node2.f23678i : 0, node4 != null ? node4.f23678i : 0) + 1;
        node = node.f23678i;
        if (node5 != null) {
            i = node5.f23678i;
        }
        node3.f23678i = Math.max(node, i) + 1;
    }

    private void m25707b(Node<K, V> node) {
        Node node2 = node.f23671b;
        Node node3 = node.f23672c;
        Node node4 = node2.f23671b;
        Node node5 = node2.f23672c;
        node.f23671b = node5;
        if (node5 != null) {
            node5.f23670a = node;
        }
        m25704a((Node) node, node2);
        node2.f23672c = node;
        node.f23670a = node2;
        int i = 0;
        node.f23678i = Math.max(node3 != null ? node3.f23678i : 0, node5 != null ? node5.f23678i : 0) + 1;
        node = node.f23678i;
        if (node4 != null) {
            i = node4.f23678i;
        }
        node2.f23678i = Math.max(node, i) + 1;
    }

    public final Set<Entry<K, V>> entrySet() {
        Set set = this.f23687i;
        if (set != null) {
            return set;
        }
        set = new EntrySet(this);
        this.f23687i = set;
        return set;
    }

    public final Set<K> keySet() {
        Set set = this.f23688j;
        if (set != null) {
            return set;
        }
        set = new KeySet(this);
        this.f23688j = set;
        return set;
    }

    private static <K, V> Node<K, V>[] m25705a(Node<K, V>[] nodeArr) {
        int length = nodeArr.length;
        Node<K, V>[] nodeArr2 = new Node[(length * 2)];
        AvlIterator avlIterator = new AvlIterator();
        AvlBuilder avlBuilder = new AvlBuilder();
        AvlBuilder avlBuilder2 = new AvlBuilder();
        for (int i = 0; i < length; i++) {
            Node node = nodeArr[i];
            if (node != null) {
                avlIterator.m25700a(node);
                int i2 = 0;
                int i3 = i2;
                while (true) {
                    Node a = avlIterator.m25699a();
                    if (a == null) {
                        break;
                    } else if ((a.f23676g & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                avlBuilder.m25697a(i2);
                avlBuilder2.m25697a(i3);
                avlIterator.m25700a(node);
                while (true) {
                    node = avlIterator.m25699a();
                    if (node == null) {
                        break;
                    } else if ((node.f23676g & length) == 0) {
                        avlBuilder.m25698a(node);
                    } else {
                        avlBuilder2.m25698a(node);
                    }
                }
                node = null;
                nodeArr2[i] = i2 > 0 ? avlBuilder.m25696a() : null;
                i2 = i + length;
                if (i3 > 0) {
                    node = avlBuilder2.m25696a();
                }
                nodeArr2[i2] = node;
            }
        }
        return nodeArr2;
    }
}
