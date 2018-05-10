package org.jcodec.common;

import java.util.Arrays;

public class LongArrayList {
    private static final int DEFAULT_GROW_AMOUNT = 128;
    private int growAmount;
    private int size;
    private long[] storage;

    public LongArrayList() {
        this(DEFAULT_GROW_AMOUNT);
    }

    public LongArrayList(int i) {
        this.growAmount = i;
        this.storage = new long[i];
    }

    public long[] toArray() {
        Object obj = new long[this.size];
        System.arraycopy(this.storage, 0, obj, 0, this.size);
        return obj;
    }

    public void add(long j) {
        if (this.size >= this.storage.length) {
            Object obj = new long[(this.storage.length + this.growAmount)];
            System.arraycopy(this.storage, 0, obj, 0, this.storage.length);
            this.storage = obj;
        }
        long[] jArr = this.storage;
        int i = this.size;
        this.size = i + 1;
        jArr[i] = j;
    }

    public void push(long j) {
        add(j);
    }

    public void pop() {
        if (this.size != 0) {
            this.size--;
        }
    }

    public void set(int i, int i2) {
        this.storage[i] = (long) i2;
    }

    public long get(int i) {
        return this.storage[i];
    }

    public void fill(int i, int i2, int i3) {
        if (i2 > this.storage.length) {
            Object obj = new long[(this.growAmount + i2)];
            System.arraycopy(this.storage, 0, obj, 0, this.storage.length);
            this.storage = obj;
        }
        Arrays.fill(this.storage, i, i2, (long) i3);
        this.size = Math.max(this.size, i2);
    }

    public int size() {
        return this.size;
    }

    public void addAll(long[] jArr) {
        if (this.size + jArr.length >= this.storage.length) {
            Object obj = new long[((this.size + this.growAmount) + jArr.length)];
            System.arraycopy(this.storage, 0, obj, 0, this.size);
            this.storage = obj;
        }
        System.arraycopy(jArr, 0, this.storage, this.size, jArr.length);
        this.size += jArr.length;
    }

    public void clear() {
        this.size = 0;
    }

    public boolean contains(long j) {
        for (int i = 0; i < this.size; i++) {
            if (this.storage[i] == j) {
                return 1;
            }
        }
        return false;
    }
}
