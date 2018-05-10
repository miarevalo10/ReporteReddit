package org.jcodec.common;

import java.lang.reflect.Array;

public class IntObjectMap<T> {
    private static final int GROW_BY = 128;
    private int size;
    private Object[] storage = new Object[GROW_BY];

    public void put(int i, T t) {
        if (this.storage.length <= i) {
            Object obj = new Object[(i + GROW_BY)];
            System.arraycopy(this.storage, 0, obj, 0, this.storage.length);
            this.storage = obj;
        }
        if (this.storage[i] == null) {
            this.size++;
        }
        this.storage[i] = t;
    }

    public T get(int i) {
        return i >= this.storage.length ? null : this.storage[i];
    }

    public int[] keys() {
        int[] iArr = new int[this.size];
        int i = 0;
        int i2 = 0;
        while (i < this.storage.length) {
            if (this.storage[i] != null) {
                int i3 = i2 + 1;
                iArr[i2] = i;
                i2 = i3;
            }
            i++;
        }
        return iArr;
    }

    public void clear() {
        for (int i = 0; i < this.storage.length; i++) {
            this.storage[i] = null;
        }
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void remove(int i) {
        if (this.storage[i] != null) {
            this.size--;
        }
        this.storage[i] = null;
    }

    public T[] values(T[] tArr) {
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.size);
        int i = 0;
        int i2 = 0;
        while (i < this.storage.length) {
            if (this.storage[i] != null) {
                int i3 = i2 + 1;
                objArr[i2] = this.storage[i];
                i2 = i3;
            }
            i++;
        }
        return objArr;
    }
}
