package com.birbit.android.jobqueue.persistentQueue.sqlite;

import android.database.sqlite.SQLiteStatement;

public class Where {
    static final String f3064h = Long.toString(Long.MIN_VALUE);
    static final String f3065i = Long.toString(Long.MAX_VALUE);
    public final long f3066a;
    public final String f3067b;
    public final String[] f3068c;
    SQLiteStatement f3069d;
    String f3070e;
    SQLiteStatement f3071f;
    String f3072g;

    public Where(long j, String str, String[] strArr) {
        this.f3066a = j;
        this.f3067b = str;
        this.f3068c = strArr;
    }
}
