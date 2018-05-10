package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    transient Object[] f8416a;
    transient float f8417b;
    transient int f8418c;
    transient int f8419d;
    private transient int[] f8420e;
    private transient long[] f8421f;
    private transient int f8422g;

    class C04451 implements Iterator<E> {
        int f8412a = this.f8415d.f8418c;
        int f8413b;
        int f8414c;
        final /* synthetic */ CompactHashSet f8415d;

        C04451(CompactHashSet compactHashSet) {
            this.f8415d = compactHashSet;
            this.f8413b = this.f8415d.isEmpty() != null ? -1 : null;
            this.f8414c = -1;
        }

        public boolean hasNext() {
            return this.f8413b >= 0;
        }

        public E next() {
            m7099a();
            if (hasNext()) {
                this.f8414c = this.f8413b;
                E e = this.f8415d.f8416a[this.f8413b];
                int i = this.f8413b + 1;
                if (i >= this.f8415d.f8419d) {
                    i = -1;
                }
                this.f8413b = i;
                return e;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            m7099a();
            CollectPreconditions.m7082a(this.f8414c >= 0);
            this.f8412a++;
            this.f8415d.m7104a(this.f8415d.f8416a[this.f8414c], ((int) (this.f8415d.f8421f[this.f8414c] >>> 32)));
            this.f8413b = CompactHashSet.m7106b(this.f8413b);
            this.f8414c = -1;
        }

        private void m7099a() {
            if (this.f8415d.f8418c != this.f8412a) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private static long m7101a(long j, int i) {
        return (j & -4294967296L) | (((long) i) & 4294967295L);
    }

    static int m7106b(int i) {
        return i - 1;
    }

    public static <E> CompactHashSet<E> m7102a(int i) {
        return new CompactHashSet(i);
    }

    CompactHashSet() {
        m7107c(3);
    }

    private CompactHashSet(int i) {
        m7107c(i);
    }

    private void m7107c(int i) {
        Preconditions.m6914a(i >= 0, (Object) "Initial capacity must be non-negative");
        Preconditions.m6914a(true, (Object) "Illegal load factor");
        int b = Hashing.m7114b(i);
        this.f8420e = m7108d(b);
        this.f8417b = 1.0f;
        this.f8416a = new Object[i];
        i = new long[i];
        Arrays.fill(i, -1);
        this.f8421f = i;
        this.f8422g = Math.max(1, (int) (((float) b) * 1065353216));
    }

    private static int[] m7108d(int i) {
        i = new int[i];
        Arrays.fill(i, -1);
        return i;
    }

    public boolean add(E e) {
        long[] jArr = this.f8421f;
        Object[] objArr = this.f8416a;
        int a = Hashing.m7113a((Object) e);
        int length = (this.f8420e.length - 1) & a;
        E e2 = this.f8419d;
        int i = this.f8420e[length];
        if (i == -1) {
            this.f8420e[length] = e2;
        } else {
            long j;
            while (true) {
                j = jArr[i];
                if (((int) (j >>> 32)) == a && Objects.m14557a(e, objArr[i])) {
                    return null;
                }
                length = (int) j;
                if (length == -1) {
                    break;
                }
                i = length;
            }
            jArr[i] = m7101a(j, (int) e2);
        }
        int i2 = RedditJobManager.f10810d;
        if (e2 == RedditJobManager.f10810d) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i3 = e2 + 1;
        length = this.f8421f.length;
        if (i3 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max >= 0) {
                i2 = max;
            }
            if (i2 != length) {
                this.f8416a = Arrays.copyOf(this.f8416a, i2);
                long[] jArr2 = this.f8421f;
                max = jArr2.length;
                jArr2 = Arrays.copyOf(jArr2, i2);
                if (i2 > max) {
                    Arrays.fill(jArr2, max, i2, -1);
                }
                this.f8421f = jArr2;
            }
        }
        this.f8421f[e2] = (((long) a) << 32) | 4294967295L;
        this.f8416a[e2] = e;
        this.f8419d = i3;
        if (e2 >= this.f8422g) {
            m7109e(2 * this.f8420e.length);
        }
        this.f8418c += 1;
        return true;
    }

    private void m7109e(int i) {
        if (this.f8420e.length >= 1073741824) {
            this.f8422g = RedditJobManager.f10810d;
            return;
        }
        int i2 = ((int) (((float) i) * this.f8417b)) + 1;
        i = m7108d(i);
        long[] jArr = this.f8421f;
        int length = i.length - 1;
        for (int i3 = 0; i3 < this.f8419d; i3++) {
            int i4 = (int) (jArr[i3] >>> 32);
            int i5 = i4 & length;
            int i6 = i[i5];
            i[i5] = i3;
            jArr[i3] = (((long) i4) << 32) | (((long) i6) & 4294967295L);
        }
        this.f8422g = i2;
        this.f8420e = i;
    }

    public boolean contains(Object obj) {
        int a = Hashing.m7113a(obj);
        int i = this.f8420e[(this.f8420e.length - 1) & a];
        while (i != -1) {
            long j = this.f8421f[i];
            if (((int) (j >>> 32)) == a && Objects.m14557a(obj, this.f8416a[i])) {
                return true;
            }
            i = (int) j;
        }
        return null;
    }

    public boolean remove(Object obj) {
        return m7104a(obj, Hashing.m7113a(obj));
    }

    public Iterator<E> iterator() {
        return new C04451(this);
    }

    public int size() {
        return this.f8419d;
    }

    public boolean isEmpty() {
        return this.f8419d == 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(this.f8416a, this.f8419d);
    }

    public <T> T[] toArray(T[] tArr) {
        return ObjectArrays.m7242a(this.f8416a, this.f8419d, (Object[]) tArr);
    }

    public void clear() {
        this.f8418c++;
        Arrays.fill(this.f8416a, 0, this.f8419d, null);
        Arrays.fill(this.f8420e, -1);
        Arrays.fill(this.f8421f, -1);
        this.f8419d = 0;
    }

    private boolean m7104a(Object obj, int i) {
        int length = (this.f8420e.length - 1) & i;
        int i2 = this.f8420e[length];
        if (i2 == -1) {
            return false;
        }
        int i3 = -1;
        while (true) {
            if (((int) (this.f8421f[i2] >>> 32)) == i && Objects.m14557a(obj, this.f8416a[i2])) {
                break;
            }
            i3 = (int) this.f8421f[i2];
            if (i3 == -1) {
                return false;
            }
            int i4 = i3;
            i3 = i2;
            i2 = i4;
        }
        if (i3 == -1) {
            this.f8420e[length] = (int) this.f8421f[i2];
        } else {
            this.f8421f[i3] = m7101a(this.f8421f[i3], (int) this.f8421f[i2]);
        }
        obj = size() - 1;
        if (i2 < obj) {
            this.f8416a[i2] = this.f8416a[obj];
            this.f8416a[obj] = null;
            long j = this.f8421f[obj];
            this.f8421f[i2] = j;
            this.f8421f[obj] = -1;
            i = ((int) (j >>> 32)) & (this.f8420e.length - 1);
            length = this.f8420e[i];
            if (length == obj) {
                this.f8420e[i] = i2;
            } else {
                long j2;
                while (true) {
                    j2 = this.f8421f[length];
                    i = (int) j2;
                    if (i == obj) {
                        break;
                    }
                    length = i;
                }
                this.f8421f[length] = m7101a(j2, i2);
            }
        } else {
            this.f8416a[i2] = null;
            this.f8421f[i2] = -1;
        }
        this.f8419d -= 1;
        this.f8418c += 1;
        return true;
    }
}
