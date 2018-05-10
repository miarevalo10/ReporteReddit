package com.googlecode.mp4parser.h264;

public class CharCache {
    private char[] cache;
    private int pos;

    public CharCache(int i) {
        this.cache = new char[i];
    }

    public void append(String str) {
        str = str.toCharArray();
        int length = this.cache.length - this.pos;
        if (str.length < length) {
            length = str.length;
        }
        System.arraycopy(str, 0, this.cache, this.pos, length);
        this.pos += length;
    }

    public String toString() {
        return new String(this.cache, 0, this.pos);
    }

    public void clear() {
        this.pos = 0;
    }

    public void append(char c) {
        if (this.pos < this.cache.length - 1) {
            this.cache[this.pos] = c;
            this.pos++;
        }
    }

    public int length() {
        return this.pos;
    }
}
