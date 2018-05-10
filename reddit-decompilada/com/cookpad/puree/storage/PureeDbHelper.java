package com.cookpad.puree.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.json.JSONObject;

public class PureeDbHelper extends SQLiteOpenHelper implements PureeStorage {
    private SQLiteDatabase f12676a = getWritableDatabase();

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public PureeDbHelper(Context context) {
        super(context, "puree.db", null, 1);
    }

    public final void mo1039a(String str, JSONObject jSONObject) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", str);
        contentValues.put("log", jSONObject.toString());
        this.f12676a.insert("logs", null, contentValues);
    }

    public final Records mo1036a(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM logs WHERE type = ? ORDER BY id ASC LIMIT ");
        stringBuilder.append(i);
        i = stringBuilder.toString();
        Cursor rawQuery = this.f12676a.rawQuery(i, new String[]{str});
        try {
            i = m11749a(rawQuery);
            return i;
        } finally {
            rawQuery.close();
        }
    }

    private static com.cookpad.puree.storage.Records m11749a(android.database.Cursor r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = new com.cookpad.puree.storage.Records;
        r0.<init>();
    L_0x0005:
        r1 = r2.moveToNext();
        if (r1 == 0) goto L_0x0014;
    L_0x000b:
        r1 = new com.cookpad.puree.storage.Record;	 Catch:{ JSONException -> 0x0005 }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x0005 }
        r0.add(r1);	 Catch:{ JSONException -> 0x0005 }
        goto L_0x0005;
    L_0x0014:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cookpad.puree.storage.PureeDbHelper.a(android.database.Cursor):com.cookpad.puree.storage.Records");
    }

    public final void mo1038a(Records records) {
        StringBuilder stringBuilder = new StringBuilder("DELETE FROM logs WHERE id IN (");
        stringBuilder.append(records.m3275a());
        stringBuilder.append(")");
        this.f12676a.execSQL(stringBuilder.toString());
    }

    public final void mo1037a() {
        this.f12676a.execSQL("DELETE FROM logs");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS logs (id INTEGER PRIMARY KEY AUTOINCREMENT,type TEXT,log TEXT)");
    }
}
