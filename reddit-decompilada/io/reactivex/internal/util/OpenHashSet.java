package io.reactivex.internal.util;

public final class OpenHashSet<T> {
    final float f25200a;
    public int f25201b;
    public int f25202c;
    int f25203d;
    public T[] f25204e;

    public static int m26714a(int i) {
        i *= -1640531527;
        return i ^ (i >>> 16);
    }

    public OpenHashSet() {
        this(16);
    }

    public OpenHashSet(byte b) {
        this((int) (byte) 2);
    }

    private OpenHashSet(int i) {
        this.f25200a = 0.75f;
        i = Pow2.m26717a(i);
        this.f25201b = i - 1;
        this.f25203d = (int) (0.75f * ((float) i));
        this.f25204e = (Object[]) new Object[i];
    }

    public final boolean m26716a(T t) {
        Object[] objArr = this.f25204e;
        int i = this.f25201b;
        int a = m26714a(t.hashCode()) & i;
        Object obj = objArr[a];
        if (obj != null) {
            if (obj.equals(t)) {
                return false;
            }
            do {
                a = (a + 1) & i;
                obj = objArr[a];
                if (obj != null) {
                }
            } while (!obj.equals(t));
            return false;
        }
        objArr[a] = t;
        t = this.f25202c + 1;
        this.f25202c = t;
        if (t >= this.f25203d) {
            t = this.f25204e;
            int length = t.length;
            i = length << 1;
            a = i - 1;
            Object[] objArr2 = new Object[i];
            int i2 = this.f25202c;
            while (true) {
                int i3 = i2 - 1;
                if (i2 == 0) {
                    break;
                }
                do {
                    length--;
                } while (t[length] == null);
                i2 = m26714a(t[length].hashCode()) & a;
                if (objArr2[i2] != null) {
                    do {
                        i2 = (i2 + 1) & a;
                    } while (objArr2[i2] != null);
                }
                objArr2[i2] = t[length];
                i2 = i3;
            }
            this.f25201b = a;
            this.f25203d = (int) (((float) i) * this.f25200a);
            this.f25204e = objArr2;
        }
        return true;
    }

    public final boolean m26715a(int i, T[] tArr, int i2) {
        this.f25202c--;
        while (true) {
            Object obj;
            int i3 = (i + 1) & i2;
            while (true) {
                obj = tArr[i3];
                if (obj == null) {
                    tArr[i] = 0;
                    return true;
                }
                int a = m26714a(obj.hashCode()) & i2;
                if (i > i3) {
                    if (i >= a) {
                        if (a > i3) {
                            break;
                        }
                    } else {
                        continue;
                    }
                    i3 = (i3 + 1) & i2;
                } else if (i >= a) {
                    break;
                } else if (a > i3) {
                    break;
                } else {
                    i3 = (i3 + 1) & i2;
                }
            }
            tArr[i] = obj;
            i = i3;
        }
    }
}
