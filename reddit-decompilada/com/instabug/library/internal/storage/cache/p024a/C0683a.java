package com.instabug.library.internal.storage.cache.p024a;

import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DatabaseManager */
public class C0683a {
    private static C0683a f9617a;
    private static C0685c f9618b;

    public static synchronized void m8191a(SQLiteOpenHelper sQLiteOpenHelper) {
        synchronized (C0683a.class) {
            if (f9617a == null) {
                f9617a = new C0683a();
                f9618b = new C0685c(sQLiteOpenHelper);
            }
        }
    }

    public static synchronized C0683a m8190a() {
        C0683a c0683a;
        synchronized (C0683a.class) {
            if (f9617a == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(C0683a.class.getSimpleName());
                stringBuilder.append(" is not initialized, call init(..) method first.");
                throw new IllegalStateException(stringBuilder.toString());
            }
            c0683a = f9617a;
        }
        return c0683a;
    }

    public static C0685c m8192b() {
        f9618b.m8196a();
        return f9618b;
    }
}
