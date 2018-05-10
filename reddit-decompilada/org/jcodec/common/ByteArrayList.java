package org.jcodec.common;

import java.util.Arrays;

public class ByteArrayList {
    private static final int DEFAULT_GROW_AMOUNT = 2048;
    private int growAmount;
    private int size;
    private byte[] storage;

    public ByteArrayList() {
        this(2048);
    }

    public ByteArrayList(int i) {
        this.growAmount = i;
        this.storage = new byte[i];
    }

    public byte[] toArray() {
        Object obj = new byte[this.size];
        System.arraycopy(this.storage, 0, obj, 0, this.size);
        return obj;
    }

    public void add(byte b) {
        if (this.size >= this.storage.length) {
            Object obj = new byte[(this.storage.length + this.growAmount)];
            System.arraycopy(this.storage, 0, obj, 0, this.storage.length);
            this.storage = obj;
        }
        byte[] bArr = this.storage;
        int i = this.size;
        this.size = i + 1;
        bArr[i] = b;
    }

    public void push(byte b) {
        add(b);
    }

    public void pop() {
        if (this.size != 0) {
            this.size--;
        }
    }

    public void set(int i, byte b) {
        this.storage[i] = b;
    }

    public byte get(int i) {
        return this.storage[i];
    }

    public void fill(int i, int i2, byte b) {
        if (i2 > this.storage.length) {
            Object obj = new byte[(this.growAmount + i2)];
            System.arraycopy(this.storage, 0, obj, 0, this.storage.length);
            this.storage = obj;
        }
        Arrays.fill(this.storage, i, i2, b);
        this.size = Math.max(this.size, i2);
    }

    public int size() {
        return this.size;
    }

    public void addAll(byte[] bArr) {
        if (this.size + bArr.length >= this.storage.length) {
            Object obj = new byte[((this.size + this.growAmount) + bArr.length)];
            System.arraycopy(this.storage, 0, obj, 0, this.size);
            this.storage = obj;
        }
        System.arraycopy(bArr, 0, this.storage, this.size, bArr.length);
        this.size += bArr.length;
    }

    public boolean contains(byte b) {
        for (int i = 0; i < this.size; i++) {
            if (this.storage[i] == b) {
                return true;
            }
        }
        return false;
    }
}
