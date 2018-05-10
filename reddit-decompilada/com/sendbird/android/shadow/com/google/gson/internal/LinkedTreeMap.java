package com.sendbird.android.shadow.com.google.gson.internal;

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
    static final /* synthetic */ boolean f22926f = true;
    private static final Comparator<Comparable> f22927g = new C20311();
    Comparator<? super K> f22928a;
    Node<K, V> f22929b;
    int f22930c;
    int f22931d;
    final Node<K, V> f22932e;
    private EntrySet f22933h;
    private KeySet f22934i;

    static class C20311 implements Comparator<Comparable> {
        C20311() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    }

    class EntrySet extends AbstractSet<Entry<K, V>> {
        final /* synthetic */ LinkedTreeMap f22912a;

        class C24371 extends LinkedTreeMapIterator<Entry<K, V>> {
            final /* synthetic */ EntrySet f30275a;

            C24371(EntrySet entrySet) {
                this.f30275a = entrySet;
                super(entrySet.f22912a);
            }

            public /* synthetic */ Object next() {
                return m25112a();
            }
        }

        EntrySet(LinkedTreeMap linkedTreeMap) {
            this.f22912a = linkedTreeMap;
        }

        public int size() {
            return this.f22912a.f22930c;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C24371(this);
        }

        public boolean contains(Object obj) {
            return (!(obj instanceof Entry) || this.f22912a.m25120a((Entry) obj) == null) ? null : true;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Node a = this.f22912a.m25120a((Entry) obj);
            if (a == null) {
                return false;
            }
            this.f22912a.m25121a(a, true);
            return true;
        }

        public void clear() {
            this.f22912a.clear();
        }
    }

    final class KeySet extends AbstractSet<K> {
        final /* synthetic */ LinkedTreeMap f22913a;

        class C24381 extends LinkedTreeMapIterator<K> {
            final /* synthetic */ KeySet f30276a;

            C24381(KeySet keySet) {
                this.f30276a = keySet;
                super(keySet.f22913a);
            }

            public K next() {
                return m25112a().f22923f;
            }
        }

        KeySet(LinkedTreeMap linkedTreeMap) {
            this.f22913a = linkedTreeMap;
        }

        public final int size() {
            return this.f22913a.f22930c;
        }

        public final Iterator<K> iterator() {
            return new C24381(this);
        }

        public final boolean contains(Object obj) {
            return this.f22913a.containsKey(obj);
        }

        public final boolean remove(Object obj) {
            return this.f22913a.m25119a(obj) != null ? true : null;
        }

        public final void clear() {
            this.f22913a.clear();
        }
    }

    private abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        Node<K, V> f22914b = this.f22917e.f22932e.f22921d;
        Node<K, V> f22915c = null;
        int f22916d = this.f22917e.f22931d;
        final /* synthetic */ LinkedTreeMap f22917e;

        LinkedTreeMapIterator(LinkedTreeMap linkedTreeMap) {
            this.f22917e = linkedTreeMap;
        }

        public final boolean hasNext() {
            return this.f22914b != this.f22917e.f22932e;
        }

        final Node<K, V> m25112a() {
            Node<K, V> node = this.f22914b;
            if (node == this.f22917e.f22932e) {
                throw new NoSuchElementException();
            } else if (this.f22917e.f22931d != this.f22916d) {
                throw new ConcurrentModificationException();
            } else {
                this.f22914b = node.f22921d;
                this.f22915c = node;
                return node;
            }
        }

        public final void remove() {
            if (this.f22915c == null) {
                throw new IllegalStateException();
            }
            this.f22917e.m25121a(this.f22915c, true);
            this.f22915c = null;
            this.f22916d = this.f22917e.f22931d;
        }
    }

    static final class Node<K, V> implements Entry<K, V> {
        Node<K, V> f22918a;
        Node<K, V> f22919b;
        Node<K, V> f22920c;
        Node<K, V> f22921d;
        Node<K, V> f22922e;
        final K f22923f;
        V f22924g;
        int f22925h;

        Node() {
            this.f22923f = null;
            this.f22922e = this;
            this.f22921d = this;
        }

        Node(Node<K, V> node, K k, Node<K, V> node2, Node<K, V> node3) {
            this.f22918a = node;
            this.f22923f = k;
            this.f22925h = 1;
            this.f22921d = node2;
            this.f22922e = node3;
            node3.f22921d = this;
            node2.f22922e = this;
        }

        public final K getKey() {
            return this.f22923f;
        }

        public final V getValue() {
            return this.f22924g;
        }

        public final V setValue(V v) {
            V v2 = this.f22924g;
            this.f22924g = v;
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
            r0 = r3.f22923f;
            if (r0 != 0) goto L_0x0012;
        L_0x000b:
            r0 = r4.getKey();
            if (r0 != 0) goto L_0x0037;
        L_0x0011:
            goto L_0x001e;
        L_0x0012:
            r0 = r3.f22923f;
            r2 = r4.getKey();
            r0 = r0.equals(r2);
            if (r0 == 0) goto L_0x0037;
        L_0x001e:
            r0 = r3.f22924g;
            if (r0 != 0) goto L_0x0029;
        L_0x0022:
            r4 = r4.getValue();
            if (r4 != 0) goto L_0x0037;
        L_0x0028:
            goto L_0x0035;
        L_0x0029:
            r0 = r3.f22924g;
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
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.com.google.gson.internal.LinkedTreeMap.Node.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = this.f22923f == null ? 0 : this.f22923f.hashCode();
            if (this.f22924g != null) {
                i = this.f22924g.hashCode();
            }
            return hashCode ^ i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f22923f);
            stringBuilder.append(Operation.EQUALS);
            stringBuilder.append(this.f22924g);
            return stringBuilder.toString();
        }
    }

    public LinkedTreeMap() {
        this(f22927g);
    }

    private LinkedTreeMap(Comparator<? super K> comparator) {
        this.f22930c = 0;
        this.f22931d = 0;
        this.f22932e = new Node();
        if (comparator == null) {
            comparator = f22927g;
        }
        this.f22928a = comparator;
    }

    public final int size() {
        return this.f22930c;
    }

    public final V get(Object obj) {
        obj = m25116b(obj);
        return obj != null ? obj.f22924g : null;
    }

    public final boolean containsKey(Object obj) {
        return m25116b(obj) != null ? true : null;
    }

    public final V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        k = m25113a((Object) k, true);
        V v2 = k.f22924g;
        k.f22924g = v;
        return v2;
    }

    public final void clear() {
        this.f22929b = null;
        this.f22930c = 0;
        this.f22931d++;
        Node node = this.f22932e;
        node.f22922e = node;
        node.f22921d = node;
    }

    public final V remove(Object obj) {
        obj = m25119a(obj);
        return obj != null ? obj.f22924g : null;
    }

    private Node<K, V> m25113a(K k, boolean z) {
        Comparator comparator = this.f22928a;
        Node node = this.f22929b;
        int compareTo;
        if (node != null) {
            Comparable comparable = comparator == f22927g ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    compareTo = comparable.compareTo(node.f22923f);
                } else {
                    compareTo = comparator.compare(k, node.f22923f);
                }
                if (compareTo != 0) {
                    Node node2;
                    if (compareTo < 0) {
                        node2 = node.f22919b;
                    } else {
                        node2 = node.f22920c;
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
        z = this.f22932e;
        if (node != null) {
            node3 = new Node(node, k, z, z.f22922e);
            if (compareTo < 0) {
                node.f22919b = node3;
            } else {
                node.f22920c = node3;
            }
            m25118b(node, true);
        } else if (comparator != f22927g || (k instanceof Comparable)) {
            node3 = new Node(node, k, z, z.f22922e);
            this.f22929b = node3;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(k.getClass().getName());
            stringBuilder.append(" is not Comparable");
            throw new ClassCastException(stringBuilder.toString());
        }
        this.f22930c += 1;
        this.f22931d += 1;
        return node3;
    }

    private com.sendbird.android.shadow.com.google.gson.internal.LinkedTreeMap.Node<K, V> m25116b(java.lang.Object r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
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
        r3 = r2.m25113a(r3, r1);	 Catch:{ ClassCastException -> 0x0009 }
        return r3;
    L_0x0009:
        return r0;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.com.google.gson.internal.LinkedTreeMap.b(java.lang.Object):com.sendbird.android.shadow.com.google.gson.internal.LinkedTreeMap$Node<K, V>");
    }

    final Node<K, V> m25120a(Entry<?, ?> entry) {
        Node<K, V> b = m25116b(entry.getKey());
        Object obj = 1;
        if (b != null) {
            Entry<?, ?> entry2 = b.f22924g;
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

    final void m25121a(Node<K, V> node, boolean z) {
        if (z) {
            node.f22922e.f22921d = node.f22921d;
            node.f22921d.f22922e = node.f22922e;
        }
        Node node2 = node.f22919b;
        Node node3 = node.f22920c;
        Node node4 = node.f22918a;
        int i = 0;
        if (!node2 != false || node3 == null) {
            if (node2 == true) {
                m25115a((Node) node, node2);
                node.f22919b = null;
            } else if (node3 != null) {
                m25115a((Node) node, node3);
                node.f22920c = null;
            } else {
                m25115a((Node) node, null);
            }
            m25118b(node4, false);
            this.f22930c--;
            this.f22931d++;
            return;
        }
        int i2;
        if (node2.f22925h > node3.f22925h) {
            node3 = node2.f22920c;
            while (true) {
                Node node5 = node3;
                node3 = z;
                z = node5;
                if (!z) {
                    break;
                }
                node3 = z.f22920c;
            }
        } else {
            while (true) {
                z = node3.f22919b;
                if (!z) {
                    break;
                }
                node3 = z;
            }
        }
        m25121a(node3, false);
        z = node.f22919b;
        if (z) {
            i2 = z.f22925h;
            node3.f22919b = z;
            z.f22918a = node3;
            node.f22919b = null;
        } else {
            i2 = 0;
        }
        z = node.f22920c;
        if (z) {
            i = z.f22925h;
            node3.f22920c = z;
            z.f22918a = node3;
            node.f22920c = null;
        }
        node3.f22925h = Math.max(i2, i) + 1;
        m25115a((Node) node, node3);
    }

    final Node<K, V> m25119a(Object obj) {
        Node b = m25116b(obj);
        if (b != null) {
            m25121a(b, true);
        }
        return b;
    }

    private void m25115a(Node<K, V> node, Node<K, V> node2) {
        Node node3 = node.f22918a;
        node.f22918a = null;
        if (node2 != null) {
            node2.f22918a = node3;
        }
        if (node3 == null) {
            this.f22929b = node2;
        } else if (node3.f22919b == node) {
            node3.f22919b = node2;
        } else if (f22926f || node3.f22920c == node) {
            node3.f22920c = node2;
        } else {
            throw new AssertionError();
        }
    }

    private void m25118b(Node<K, V> node, boolean z) {
        Node node2;
        while (node2 != null) {
            Node node3 = node2.f22919b;
            Node node4 = node2.f22920c;
            int i = 0;
            int i2 = node3 != null ? node3.f22925h : 0;
            int i3 = node4 != null ? node4.f22925h : 0;
            int i4 = i2 - i3;
            Node node5;
            if (i4 == -2) {
                node3 = node4.f22919b;
                node5 = node4.f22920c;
                i2 = node5 != null ? node5.f22925h : 0;
                if (node3 != null) {
                    i = node3.f22925h;
                }
                i -= i2;
                if (i != -1) {
                    if (i != 0 || z) {
                        if (f22926f || i == 1) {
                            m25117b(node4);
                            m25114a(node2);
                            if (!z) {
                                break;
                            }
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
                m25114a(node2);
                if (!z) {
                    break;
                }
            } else if (i4 == 2) {
                node4 = node3.f22919b;
                node5 = node3.f22920c;
                i2 = node5 != null ? node5.f22925h : 0;
                if (node4 != null) {
                    i = node4.f22925h;
                }
                i -= i2;
                if (i != 1) {
                    if (i != 0 || z) {
                        if (f22926f || i == -1) {
                            m25114a(node3);
                            m25117b(node2);
                            if (!z) {
                                break;
                            }
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
                m25117b(node2);
                if (!z) {
                    break;
                }
            } else if (i4 == 0) {
                node2.f22925h = i2 + 1;
                if (z) {
                    return;
                }
            } else if (f22926f || i4 == -1 || i4 == 1) {
                node2.f22925h = Math.max(i2, i3) + 1;
                if (!z) {
                    break;
                }
            } else {
                throw new AssertionError();
            }
            node2 = node2.f22918a;
        }
    }

    private void m25114a(Node<K, V> node) {
        Node node2 = node.f22919b;
        Node node3 = node.f22920c;
        Node node4 = node3.f22919b;
        Node node5 = node3.f22920c;
        node.f22920c = node4;
        if (node4 != null) {
            node4.f22918a = node;
        }
        m25115a((Node) node, node3);
        node3.f22919b = node;
        node.f22918a = node3;
        int i = 0;
        node.f22925h = Math.max(node2 != null ? node2.f22925h : 0, node4 != null ? node4.f22925h : 0) + 1;
        node = node.f22925h;
        if (node5 != null) {
            i = node5.f22925h;
        }
        node3.f22925h = Math.max(node, i) + 1;
    }

    private void m25117b(Node<K, V> node) {
        Node node2 = node.f22919b;
        Node node3 = node.f22920c;
        Node node4 = node2.f22919b;
        Node node5 = node2.f22920c;
        node.f22919b = node5;
        if (node5 != null) {
            node5.f22918a = node;
        }
        m25115a((Node) node, node2);
        node2.f22920c = node;
        node.f22918a = node2;
        int i = 0;
        node.f22925h = Math.max(node3 != null ? node3.f22925h : 0, node5 != null ? node5.f22925h : 0) + 1;
        node = node.f22925h;
        if (node4 != null) {
            i = node4.f22925h;
        }
        node2.f22925h = Math.max(node, i) + 1;
    }

    public final Set<Entry<K, V>> entrySet() {
        Set set = this.f22933h;
        if (set != null) {
            return set;
        }
        set = new EntrySet(this);
        this.f22933h = set;
        return set;
    }

    public final Set<K> keySet() {
        Set set = this.f22934i;
        if (set != null) {
            return set;
        }
        set = new KeySet(this);
        this.f22934i = set;
        return set;
    }
}
