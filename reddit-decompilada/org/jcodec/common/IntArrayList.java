package org.jcodec.common;

import java.util.Arrays;

public class IntArrayList {
    private static final int DEFAULT_GROW_AMOUNT = 128;
    private int growAmount;
    private int size;
    private int[] storage;

    public IntArrayList() {
        this(DEFAULT_GROW_AMOUNT);
    }

    public IntArrayList(int i) {
        this.growAmount = i;
        this.storage = new int[i];
    }

    public int[] toArray() {
        Object obj = new int[this.size];
        System.arraycopy(this.storage, 0, obj, 0, this.size);
        return obj;
    }

    public void add(int i) {
        if (this.size >= this.storage.length) {
            Object obj = new int[(this.storage.length + this.growAmount)];
            System.arraycopy(this.storage, 0, obj, 0, this.storage.length);
            this.storage = obj;
        }
        int[] iArr = this.storage;
        int i2 = this.size;
        this.size = i2 + 1;
        iArr[i2] = i;
    }

    public void push(int i) {
        add(i);
    }

    public void pop() {
        if (this.size != 0) {
            this.size--;
        }
    }

    public void set(int i, int i2) {
        this.storage[i] = i2;
    }

    public int get(int i) {
        return this.storage[i];
    }

    public void fill(int i, int i2, int i3) {
        if (i2 > this.storage.length) {
            Object obj = new int[(this.growAmount + i2)];
            System.arraycopy(this.storage, 0, obj, 0, this.storage.length);
            this.storage = obj;
        }
        Arrays.fill(this.storage, i, i2, i3);
        this.size = Math.max(this.size, i2);
    }

    public int size() {
        return this.size;
    }

    public void addAll(int[] iArr) {
        if (this.size + iArr.length >= this.storage.length) {
            Object obj = new int[((this.size + this.growAmount) + iArr.length)];
            System.arraycopy(this.storage, 0, obj, 0, this.size);
            this.storage = obj;
        }
        System.arraycopy(iArr, 0, this.storage, this.size, iArr.length);
        this.size += iArr.length;
    }

    public void clear() {
        this.size = 0;
    }

    public boolean contains(int i) {
        for (int i2 = 0; i2 < this.size; i2++) {
            if (this.storage[i2] == i) {
                return true;
            }
        }
        return false;
    }
}
