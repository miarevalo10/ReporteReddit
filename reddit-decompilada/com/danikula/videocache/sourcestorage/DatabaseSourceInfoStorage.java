package com.danikula.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.danikula.videocache.Preconditions;
import com.danikula.videocache.SourceInfo;
import net.hockeyapp.android.UpdateFragment;

class DatabaseSourceInfoStorage extends SQLiteOpenHelper implements SourceInfoStorage {
    private static final String[] f12691a = new String[]{"_id", UpdateFragment.FRAGMENT_URL, "length", "mime"};

    DatabaseSourceInfoStorage(Context context) {
        super(context, "AndroidVideoCache.db", null, 1);
        Preconditions.m3330a((Object) context);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Preconditions.m3330a((Object) sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    public final SourceInfo mo1105a(String str) {
        Throwable th;
        Preconditions.m3330a((Object) str);
        SourceInfo sourceInfo = null;
        try {
            str = getReadableDatabase().query("SourceInfo", f12691a, "url=?", new String[]{str}, null, null, null);
            if (str != null) {
                try {
                    if (str.moveToFirst()) {
                        sourceInfo = new SourceInfo(str.getString(str.getColumnIndexOrThrow(UpdateFragment.FRAGMENT_URL)), str.getLong(str.getColumnIndexOrThrow("length")), str.getString(str.getColumnIndexOrThrow("mime")));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (str != null) {
                        str.close();
                    }
                    throw th;
                }
            }
            if (str != null) {
                str.close();
            }
            return sourceInfo;
        } catch (String str2) {
            th = str2;
            str2 = null;
            if (str2 != null) {
                str2.close();
            }
            throw th;
        }
    }

    public final void mo1106a(String str, SourceInfo sourceInfo) {
        Preconditions.m3334a(str, sourceInfo);
        int i = mo1105a(str) != null ? 1 : 0;
        ContentValues contentValues = new ContentValues();
        contentValues.put(UpdateFragment.FRAGMENT_URL, sourceInfo.f3771a);
        contentValues.put("length", Long.valueOf(sourceInfo.f3772b));
        contentValues.put("mime", sourceInfo.f3773c);
        if (i != 0) {
            getWritableDatabase().update("SourceInfo", contentValues, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, contentValues);
        }
    }
}
