package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;

@TargetApi(11)
final class zzchj extends SQLiteOpenHelper {
    private /* synthetic */ zzchi f6896a;

    zzchj(zzchi com_google_android_gms_internal_zzchi, Context context, String str) {
        this.f6896a = com_google_android_gms_internal_zzchi;
        super(context, str, null, 1);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzcgo.m17980a(this.f6896a.mo1828t(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        if (VERSION.SDK_INT < 15) {
            Cursor cursor = null;
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = rawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        zzcgo.m17981a(this.f6896a.mo1828t(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException e) {
            if (VERSION.SDK_INT < 11 || !(e instanceof SQLiteDatabaseLockedException)) {
                this.f6896a.mo1828t().f17816a.m5693a("Opening the local database failed, dropping and recreating it");
                String str = "google_app_measurement_local.db";
                if (!this.f6896a.mo1820l().getDatabasePath(str).delete()) {
                    this.f6896a.mo1828t().f17816a.m5694a("Failed to delete corrupted local db file", str);
                }
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteException e2) {
                    this.f6896a.mo1828t().f17816a.m5694a("Failed to open local database. Events will bypass local storage", e2);
                    return null;
                }
            }
            throw e2;
        }
    }
}
