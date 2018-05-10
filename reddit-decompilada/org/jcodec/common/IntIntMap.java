package org.jcodec.common;

import java.util.Arrays;

public class IntIntMap {
    private static final int GROW_BY = 128;
    private int size;
    private int[] storage = createArray(GROW_BY);

    public IntIntMap() {
        Arrays.fill(this.storage, Integer.MIN_VALUE);
    }

    public void put(int i, int i2) {
        if (i2 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("This implementation can not store -2147483648");
        }
        if (this.storage.length <= i) {
            Object createArray = createArray(i + GROW_BY);
            System.arraycopy(this.storage, 0, createArray, 0, this.storage.length);
            Arrays.fill(createArray, this.storage.length, createArray.length, Integer.MIN_VALUE);
            this.storage = createArray;
        }
        if (this.storage[i] == Integer.MIN_VALUE) {
            this.size++;
        }
        this.storage[i] = i2;
    }

    public int get(int i) {
        return (i >= this.storage.length ? 0 : Integer.valueOf(this.storage[i])).intValue();
    }

    public int[] keys() {
        int[] iArr = new int[this.size];
        int i = 0;
        int i2 = 0;
        while (i < this.storage.length) {
            if (this.storage[i] != Integer.MIN_VALUE) {
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
            this.storage[i] = Integer.MIN_VALUE;
        }
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void remove(int i) {
        if (this.storage[i] != Integer.MIN_VALUE) {
            this.size--;
        }
        this.storage[i] = Integer.MIN_VALUE;
    }

    public int[] values() {
        int[] createArray = createArray(this.size);
        int i = 0;
        int i2 = 0;
        while (i < this.storage.length) {
            if (this.storage[i] != Integer.MIN_VALUE) {
                int i3 = i2 + 1;
                createArray[i2] = this.storage[i];
                i2 = i3;
            }
            i++;
        }
        return createArray;
    }

    private int[] createArray(int i) {
        return new int[i];
    }
}
