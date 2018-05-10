package com.instabug.library.internal.storage.cache.p024a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SQLiteDatabaseWrapper */
public class C0685c {
    public SQLiteDatabase f9619a;
    private AtomicInteger f9620b = new AtomicInteger();
    private SQLiteOpenHelper f9621c;

    C0685c(SQLiteOpenHelper sQLiteOpenHelper) {
        this.f9621c = sQLiteOpenHelper;
    }

    final synchronized void m8196a() {
        if (this.f9620b.incrementAndGet() == 1) {
            this.f9619a = this.f9621c.getWritableDatabase();
        }
    }

    public final synchronized void m8198b() {
        if (this.f9620b.decrementAndGet() == 0) {
            this.f9619a.close();
        }
    }

    public final long m8194a(String str, ContentValues contentValues) {
        return this.f9619a.insert(str, null, contentValues);
    }

    public final void m8197a(String str) {
        this.f9619a.execSQL(str);
    }

    public final void m8199b(String str) {
        this.f9619a.delete(str, null, null);
    }

    public final Cursor m8195a(String str, String[] strArr, String str2, String[] strArr2) {
        return this.f9619a.query(str, strArr, str2, strArr2, null, null, null);
    }
}
