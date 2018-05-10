package com.google.android.gms.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.instabug.library.model.State;

final class zzcgr extends SQLiteOpenHelper {
    private /* synthetic */ zzcgo f6828a;

    zzcgr(zzcgo com_google_android_gms_internal_zzcgo, Context context, String str) {
        this.f6828a = com_google_android_gms_internal_zzcgo;
        super(context, str, null, 1);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzcgo.m17980a(this.f6828a.mo1828t(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (VERSION.SDK_INT < 15) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
            try {
                rawQuery.moveToFirst();
            } finally {
                rawQuery.close();
            }
        }
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        zzcgo.m17981a(this.f6828a.mo1828t(), sQLiteDatabase2, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", zzcgo.f17786a);
        zzcgo.m17981a(this.f6828a.mo1828t(), sQLiteDatabase2, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
        zzcgo.m17981a(this.f6828a.mo1828t(), sQLiteDatabase2, State.KEY_USER_ATTRIBUTES, "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", zzcgo.f17787b);
        zzcgo.m17981a(this.f6828a.mo1828t(), sQLiteDatabase2, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zzcgo.f17788c);
        zzcgo.m17981a(this.f6828a.mo1828t(), sQLiteDatabase2, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", zzcgo.f17790e);
        zzcgo.m17981a(this.f6828a.mo1828t(), sQLiteDatabase2, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
        zzcgo.m17981a(this.f6828a.mo1828t(), sQLiteDatabase2, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", zzcgo.f17789d);
        zzcgo.m17981a(this.f6828a.mo1828t(), sQLiteDatabase2, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
        zzcgo.m17981a(this.f6828a.mo1828t(), sQLiteDatabase2, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
        zzcgo.m17981a(this.f6828a.mo1828t(), sQLiteDatabase2, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        zzcgo.m17981a(this.f6828a.mo1828t(), sQLiteDatabase2, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", zzcgo.f17791f);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final android.database.sqlite.SQLiteDatabase getWritableDatabase() {
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
        r7 = this;
        r0 = r7.f6828a;
        r0 = r0.f17793h;
        r1 = r0.f7174b;
        r3 = 0;
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        r2 = 1;
        if (r1 != 0) goto L_0x0010;
    L_0x000f:
        goto L_0x0022;
    L_0x0010:
        r1 = r0.f7173a;
        r5 = r1.mo1633b();
        r0 = r0.f7174b;
        r5 = r5 - r0;
        r0 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r0 < 0) goto L_0x0021;
    L_0x0020:
        goto L_0x0022;
    L_0x0021:
        r2 = 0;
    L_0x0022:
        if (r2 != 0) goto L_0x002c;
    L_0x0024:
        r0 = new android.database.sqlite.SQLiteException;
        r1 = "Database open failed";
        r0.<init>(r1);
        throw r0;
    L_0x002c:
        r0 = super.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0031 }
        return r0;
    L_0x0031:
        r0 = r7.f6828a;
        r0 = r0.f17793h;
        r0.m5805a();
        r0 = r7.f6828a;
        r0 = r0.mo1828t();
        r0 = r0.f17816a;
        r1 = "Opening the database failed, dropping and recreating it";
        r0.m5693a(r1);
        r0 = "google_app_measurement.db";
        r1 = r7.f6828a;
        r1 = r1.mo1820l();
        r1 = r1.getDatabasePath(r0);
        r1 = r1.delete();
        if (r1 != 0) goto L_0x0066;
    L_0x0059:
        r1 = r7.f6828a;
        r1 = r1.mo1828t();
        r1 = r1.f17816a;
        r2 = "Failed to delete corrupted db file";
        r1.m5694a(r2, r0);
    L_0x0066:
        r0 = super.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0073 }
        r1 = r7.f6828a;	 Catch:{ SQLiteException -> 0x0073 }
        r1 = r1.f17793h;	 Catch:{ SQLiteException -> 0x0073 }
        r1.f7174b = r3;	 Catch:{ SQLiteException -> 0x0073 }
        return r0;
    L_0x0073:
        r0 = move-exception;
        r1 = r7.f6828a;
        r1 = r1.mo1828t();
        r1 = r1.f17816a;
        r2 = "Failed to open freshly created database";
        r1.m5694a(r2, r0);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgr.getWritableDatabase():android.database.sqlite.SQLiteDatabase");
    }
}
