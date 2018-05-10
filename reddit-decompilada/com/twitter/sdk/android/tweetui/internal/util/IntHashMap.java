package com.twitter.sdk.android.tweetui.internal.util;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;

public class IntHashMap {
    private Entry[] f24292a;
    private int f24293b;
    private int f24294c;
    private float f24295d;

    private static class Entry {
        public final int f24288a;
        public int f24289b;
        public Object f24290c;
        public Entry f24291d;

        protected Entry(int i, int i2, Object obj, Entry entry) {
            this.f24288a = i;
            this.f24289b = i2;
            this.f24290c = obj;
            this.f24291d = entry;
        }
    }

    public IntHashMap() {
        this((byte) 0);
    }

    private IntHashMap(byte b) {
        this.f24295d = (byte) 0;
        this.f24292a = new Entry[(byte) 20];
        this.f24294c = (byte) 15;
    }

    public final Object m25996a(int i, Object obj) {
        Entry[] entryArr = this.f24292a;
        int i2 = i & RedditJobManager.f10810d;
        int length = i2 % entryArr.length;
        for (Entry entry = entryArr[length]; entry != null; entry = entry.f24291d) {
            if (entry.f24288a == i) {
                i = entry.f24290c;
                entry.f24290c = obj;
                return i;
            }
        }
        if (this.f24293b >= this.f24294c) {
            int length2 = this.f24292a.length;
            Entry[] entryArr2 = this.f24292a;
            int i3 = (length2 * 2) + 1;
            Entry[] entryArr3 = new Entry[i3];
            this.f24294c = (int) (((float) i3) * this.f24295d);
            this.f24292a = entryArr3;
            while (true) {
                int i4 = length2 - 1;
                if (length2 <= 0) {
                    break;
                }
                Entry entry2 = entryArr2[i4];
                while (entry2 != null) {
                    Entry entry3 = entry2.f24291d;
                    int i5 = (entry2.f24288a & RedditJobManager.f10810d) % i3;
                    entry2.f24291d = entryArr3[i5];
                    entryArr3[i5] = entry2;
                    entry2 = entry3;
                }
                length2 = i4;
            }
            entryArr = this.f24292a;
            length = i2 % entryArr.length;
        }
        entryArr[length] = new Entry(i, i, obj, entryArr[length]);
        this.f24293b++;
        return 0;
    }
}
