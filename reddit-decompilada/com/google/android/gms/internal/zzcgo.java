package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.zzbq;
import com.instabug.library.model.State;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class zzcgo extends zzcjl {
    private static final String[] f17786a = new String[]{"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};
    private static final String[] f17787b = new String[]{"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] f17788c = new String[]{State.KEY_APP_VERSION, "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;"};
    private static final String[] f17789d = new String[]{"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] f17790e = new String[]{"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;"};
    private static final String[] f17791f = new String[]{"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzcgr f17792g = new zzcgr(this, mo1820l(), "google_app_measurement.db");
    private final zzclk f17793h = new zzclk(mo1819k());

    zzcgo(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    private final boolean m17975O() {
        return mo1820l().getDatabasePath("google_app_measurement.db").exists();
    }

    private static Set<String> m17978a(SQLiteDatabase sQLiteDatabase, String str) {
        Object hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder(22 + String.valueOf(str).length());
        stringBuilder.append("SELECT * FROM ");
        stringBuilder.append(str);
        stringBuilder.append(" LIMIT 0");
        Cursor rawQuery = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    private static void m17979a(ContentValues contentValues, String str, Object obj) {
        zzbq.m4810a(str);
        zzbq.m4808a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public final List<zzcgl> m18009b(String str, String str2, String str3) {
        zzbq.m4810a(str);
        mo1811c();
        m13545L();
        List arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder stringBuilder = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            stringBuilder.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat(Operation.MULTIPLY));
            stringBuilder.append(" and name glob ?");
        }
        return m18010b(stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    protected final boolean mo3490w() {
        return false;
    }

    public final void m18022x() {
        m13545L();
        m17987A().beginTransaction();
    }

    public final void m18023y() {
        m13545L();
        m17987A().setTransactionSuccessful();
    }

    public final void m18024z() {
        m13545L();
        m17987A().endTransaction();
    }

    final long m17992a(String str, String[] strArr) {
        Object e;
        String[] strArr2 = null;
        try {
            strArr = m17987A().rawQuery(str, strArr);
            try {
                if (strArr.moveToFirst()) {
                    long j = strArr.getLong(0);
                    if (strArr != null) {
                        strArr.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e2) {
                e = e2;
                strArr2 = strArr;
                try {
                    mo1828t().f17816a.m5695a("Database error", str, e);
                    throw e;
                } catch (Throwable th) {
                    str = th;
                    strArr = strArr2;
                    if (strArr != null) {
                        strArr.close();
                    }
                    throw str;
                }
            } catch (Throwable th2) {
                str = th2;
                if (strArr != null) {
                    strArr.close();
                }
                throw str;
            }
        } catch (SQLiteException e3) {
            e = e3;
            mo1828t().f17816a.m5695a("Database error", str, e);
            throw e;
        }
    }

    final long m17993a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            strArr = m17987A().rawQuery(str, strArr);
            try {
                if (strArr.moveToFirst()) {
                    j = strArr.getLong(0);
                    if (strArr != null) {
                        strArr.close();
                    }
                    return j;
                }
                if (strArr != null) {
                    strArr.close();
                }
                return j;
            } catch (SQLiteException e) {
                j = e;
                cursor = strArr;
                try {
                    mo1828t().f17816a.m5695a("Database error", str, j);
                    throw j;
                } catch (Throwable th) {
                    str = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw str;
                }
            } catch (Throwable th2) {
                str = th2;
                cursor = strArr;
                if (cursor != null) {
                    cursor.close();
                }
                throw str;
            }
        } catch (SQLiteException e2) {
            j = e2;
            mo1828t().f17816a.m5695a("Database error", str, j);
            throw j;
        }
    }

    final SQLiteDatabase m17987A() {
        mo1811c();
        try {
            return this.f17792g.getWritableDatabase();
        } catch (SQLiteException e) {
            mo1828t().f17818c.m5694a("Error opening database", e);
            throw e;
        }
    }

    public final zzcgw m17995a(String str, String str2) {
        Object obj;
        SQLiteException e;
        Cursor cursor;
        Throwable th;
        Throwable th2;
        String str3 = str2;
        zzbq.m4810a(str);
        zzbq.m4810a(str2);
        mo1811c();
        m13545L();
        try {
            String[] strArr = new String[2];
            strArr[0] = str;
            boolean z = true;
            strArr[1] = str3;
            Cursor query = m17987A().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"}, "app_id=? and name=?", strArr, null, null, null);
            try {
                if (query.moveToFirst()) {
                    Boolean bool;
                    long j = query.getLong(0);
                    long j2 = query.getLong(1);
                    long j3 = query.getLong(2);
                    long j4 = query.isNull(3) ? 0 : query.getLong(3);
                    zzcgw valueOf = query.isNull(4) ? null : Long.valueOf(query.getLong(4));
                    zzcgw valueOf2 = query.isNull(5) ? null : Long.valueOf(query.getLong(5));
                    if (query.isNull(6)) {
                        bool = null;
                    } else {
                        try {
                            if (query.getLong(6) != 1) {
                                z = false;
                            }
                            bool = Boolean.valueOf(z);
                        } catch (SQLiteException e2) {
                            obj = e2;
                            cursor = query;
                            try {
                                mo1828t().f17816a.m5696a("Error querying events. appId", zzchm.m18154a(str), mo1823o().m18128a(str2), obj);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return null;
                            } catch (Throwable th3) {
                                th = th3;
                                th2 = th;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th2;
                        }
                    }
                    zzcgw com_google_android_gms_internal_zzcgw = com_google_android_gms_internal_zzcgw;
                    String str4 = str3;
                    cursor = query;
                    try {
                        com_google_android_gms_internal_zzcgw = new zzcgw(str, str4, j, j2, j3, j4, valueOf, valueOf2, bool);
                        if (cursor.moveToNext()) {
                            mo1828t().f17816a.m5694a("Got multiple records for event aggregates, expected one. appId", zzchm.m18154a(str));
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return com_google_android_gms_internal_zzcgw;
                    } catch (SQLiteException e3) {
                        e2 = e3;
                        obj = e2;
                        mo1828t().f17816a.m5696a("Error querying events. appId", zzchm.m18154a(str), mo1823o().m18128a(str2), obj);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e4) {
                e2 = e4;
                cursor = query;
                obj = e2;
                mo1828t().f17816a.m5696a("Error querying events. appId", zzchm.m18154a(str), mo1823o().m18128a(str2), obj);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th5) {
                th4 = th5;
                cursor = query;
                th2 = th4;
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        } catch (SQLiteException e22) {
            obj = e22;
            cursor = null;
            mo1828t().f17816a.m5696a("Error querying events. appId", zzchm.m18154a(str), mo1823o().m18128a(str2), obj);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th42) {
            th2 = th42;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final void m18001a(zzcgw com_google_android_gms_internal_zzcgw) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgw);
        mo1811c();
        m13545L();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_internal_zzcgw.f6841a);
        contentValues.put("name", com_google_android_gms_internal_zzcgw.f6842b);
        contentValues.put("lifetime_count", Long.valueOf(com_google_android_gms_internal_zzcgw.f6843c));
        contentValues.put("current_bundle_count", Long.valueOf(com_google_android_gms_internal_zzcgw.f6844d));
        contentValues.put("last_fire_timestamp", Long.valueOf(com_google_android_gms_internal_zzcgw.f6845e));
        contentValues.put("last_bundled_timestamp", Long.valueOf(com_google_android_gms_internal_zzcgw.f6846f));
        contentValues.put("last_sampled_complex_event_id", com_google_android_gms_internal_zzcgw.f6847g);
        contentValues.put("last_sampling_rate", com_google_android_gms_internal_zzcgw.f6848h);
        Long valueOf = (com_google_android_gms_internal_zzcgw.f6849i == null || !com_google_android_gms_internal_zzcgw.f6849i.booleanValue()) ? null : Long.valueOf(1);
        contentValues.put("last_exempt_from_sampling", valueOf);
        try {
            if (m17987A().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                mo1828t().f17816a.m5694a("Failed to insert/update event aggregates (got -1). appId", zzchm.m18154a(com_google_android_gms_internal_zzcgw.f6841a));
            }
        } catch (SQLiteException e) {
            mo1828t().f17816a.m5695a("Error storing event aggregates. appId", zzchm.m18154a(com_google_android_gms_internal_zzcgw.f6841a), e);
        }
    }

    public final void m18011b(String str, String str2) {
        zzbq.m4810a(str);
        zzbq.m4810a(str2);
        mo1811c();
        m13545L();
        try {
            mo1828t().f17822g.m5694a("Deleted user attribute rows", Integer.valueOf(m17987A().delete(State.KEY_USER_ATTRIBUTES, "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            mo1828t().f17816a.m5696a("Error deleting user attribute. appId", zzchm.m18154a(str), mo1823o().m18132c(str2), e);
        }
    }

    public final boolean m18006a(zzclp com_google_android_gms_internal_zzclp) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzclp);
        mo1811c();
        m13545L();
        if (m18013c(com_google_android_gms_internal_zzclp.f7175a, com_google_android_gms_internal_zzclp.f7177c) == null) {
            if (zzclq.m18513a(com_google_android_gms_internal_zzclp.f7177c)) {
                if (m17992a("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{com_google_android_gms_internal_zzclp.f7175a}) >= 25) {
                    return false;
                }
            }
            if (m17992a("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{com_google_android_gms_internal_zzclp.f7175a, com_google_android_gms_internal_zzclp.f7176b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_internal_zzclp.f7175a);
        contentValues.put("origin", com_google_android_gms_internal_zzclp.f7176b);
        contentValues.put("name", com_google_android_gms_internal_zzclp.f7177c);
        contentValues.put("set_timestamp", Long.valueOf(com_google_android_gms_internal_zzclp.f7178d));
        m17979a(contentValues, "value", com_google_android_gms_internal_zzclp.f7179e);
        try {
            if (m17987A().insertWithOnConflict(State.KEY_USER_ATTRIBUTES, null, contentValues, 5) == -1) {
                mo1828t().f17816a.m5694a("Failed to insert/update user property (got -1). appId", zzchm.m18154a(com_google_android_gms_internal_zzclp.f7175a));
            }
        } catch (SQLiteException e) {
            mo1828t().f17816a.m5695a("Error storing user property. appId", zzchm.m18154a(com_google_android_gms_internal_zzclp.f7175a), e);
        }
        return true;
    }

    public final zzclp m18013c(String str, String str2) {
        SQLiteException e;
        Object obj;
        Throwable th;
        Throwable th2;
        zzcgo com_google_android_gms_internal_zzcgo;
        String str3 = str2;
        zzbq.m4810a(str);
        zzbq.m4810a(str2);
        mo1811c();
        m13545L();
        Cursor query;
        try {
            query = m17987A().query(State.KEY_USER_ATTRIBUTES, new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str3}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    long j = query.getLong(0);
                    try {
                        String str4 = str;
                        zzclp com_google_android_gms_internal_zzclp = new zzclp(str4, query.getString(2), str3, j, m17977a(query, 1));
                        if (query.moveToNext()) {
                            mo1828t().f17816a.m5694a("Got multiple records for user property, expected one. appId", zzchm.m18154a(str));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return com_google_android_gms_internal_zzclp;
                    } catch (SQLiteException e2) {
                        e = e2;
                        obj = e;
                        try {
                            mo1828t().f17816a.m5696a("Error querying user property. appId", zzchm.m18154a(str), mo1823o().m18132c(str3), obj);
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        } catch (Throwable th3) {
                            th = th3;
                            th2 = th;
                            if (query != null) {
                                query.close();
                            }
                            throw th2;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                com_google_android_gms_internal_zzcgo = this;
                obj = e;
                mo1828t().f17816a.m5696a("Error querying user property. appId", zzchm.m18154a(str), mo1823o().m18132c(str3), obj);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                com_google_android_gms_internal_zzcgo = this;
                th2 = th;
                if (query != null) {
                    query.close();
                }
                throw th2;
            }
        } catch (SQLiteException e4) {
            com_google_android_gms_internal_zzcgo = this;
            obj = e4;
            query = null;
            mo1828t().f17816a.m5696a("Error querying user property. appId", zzchm.m18154a(str), mo1823o().m18132c(str3), obj);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th5) {
            com_google_android_gms_internal_zzcgo = this;
            th2 = th5;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th2;
        }
    }

    public final List<zzclp> m17997a(String str) {
        Cursor query;
        Object e;
        zzbq.m4810a(str);
        mo1811c();
        m13545L();
        List<zzclp> arrayList = new ArrayList();
        try {
            query = m17987A().query(State.KEY_USER_ATTRIBUTES, new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j = query.getLong(2);
                        Object a = m17977a(query, 3);
                        if (a == null) {
                            mo1828t().f17816a.m5694a("Read invalid user property value, ignoring it. appId", zzchm.m18154a(str));
                        } else {
                            arrayList.add(new zzclp(str, str2, string, j, a));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            try {
                mo1828t().f17816a.m5695a("Error querying user properties. appId", zzchm.m18154a(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th) {
                str = th;
                if (query != null) {
                    query.close();
                }
                throw str;
            }
        } catch (Throwable th2) {
            str = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw str;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.zzclp> m17999a(java.lang.String r24, java.lang.String r25, java.lang.String r26) {
        /*
        r23 = this;
        com.google.android.gms.common.internal.zzbq.m4810a(r24);
        r23.mo1811c();
        r23.m13545L();
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = 0;
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0105, all -> 0x0100 }
        r4 = 3;
        r3.<init>(r4);	 Catch:{ SQLiteException -> 0x0105, all -> 0x0100 }
        r12 = r24;
        r3.add(r12);	 Catch:{ SQLiteException -> 0x00fc, all -> 0x0100 }
        r5 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x00fc, all -> 0x0100 }
        r6 = "app_id=?";
        r5.<init>(r6);	 Catch:{ SQLiteException -> 0x00fc, all -> 0x0100 }
        r6 = android.text.TextUtils.isEmpty(r25);	 Catch:{ SQLiteException -> 0x00fc, all -> 0x0100 }
        if (r6 != 0) goto L_0x0037;
    L_0x0027:
        r6 = r25;
        r3.add(r6);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
        r7 = " and origin=?";
        r5.append(r7);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
        goto L_0x0039;
    L_0x0032:
        r0 = move-exception;
        r13 = r23;
        goto L_0x010c;
    L_0x0037:
        r6 = r25;
    L_0x0039:
        r7 = android.text.TextUtils.isEmpty(r26);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
        if (r7 != 0) goto L_0x0051;
    L_0x003f:
        r7 = java.lang.String.valueOf(r26);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
        r8 = "*";
        r7 = r7.concat(r8);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
        r3.add(r7);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
        r7 = " and name glob ?";
        r5.append(r7);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
    L_0x0051:
        r7 = r3.size();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
        r7 = new java.lang.String[r7];	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
        r3 = r3.toArray(r7);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
        r17 = r3;
        r17 = (java.lang.String[]) r17;	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
        r13 = r23.m17987A();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
        r14 = "user_attributes";
        r3 = "name";
        r7 = "set_timestamp";
        r8 = "value";
        r9 = "origin";
        r15 = new java.lang.String[]{r3, r7, r8, r9};	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
        r16 = r5.toString();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
        r18 = 0;
        r19 = 0;
        r20 = "rowid";
        r21 = "1001";
        r3 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0100 }
        r5 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x00f7, all -> 0x00f3 }
        if (r5 != 0) goto L_0x008d;
    L_0x0087:
        if (r3 == 0) goto L_0x008c;
    L_0x0089:
        r3.close();
    L_0x008c:
        return r1;
    L_0x008d:
        r5 = r1.size();	 Catch:{ SQLiteException -> 0x00f7, all -> 0x00f3 }
        r7 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r5 < r7) goto L_0x00a7;
    L_0x0095:
        r4 = r23.mo1828t();	 Catch:{ SQLiteException -> 0x00f7, all -> 0x00f3 }
        r4 = r4.f17816a;	 Catch:{ SQLiteException -> 0x00f7, all -> 0x00f3 }
        r5 = "Read more than the max allowed user properties, ignoring excess";
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ SQLiteException -> 0x00f7, all -> 0x00f3 }
        r4.m5694a(r5, r7);	 Catch:{ SQLiteException -> 0x00f7, all -> 0x00f3 }
        r13 = r23;
        goto L_0x00e8;
    L_0x00a7:
        r5 = 0;
        r8 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x00f7, all -> 0x00f3 }
        r5 = 1;
        r9 = r3.getLong(r5);	 Catch:{ SQLiteException -> 0x00f7, all -> 0x00f3 }
        r5 = 2;
        r13 = r23;
        r11 = r13.m17977a(r3, r5);	 Catch:{ SQLiteException -> 0x00f1 }
        r14 = r3.getString(r4);	 Catch:{ SQLiteException -> 0x00f1 }
        if (r11 != 0) goto L_0x00d4;
    L_0x00be:
        r5 = r23.mo1828t();	 Catch:{ SQLiteException -> 0x00d0 }
        r5 = r5.f17816a;	 Catch:{ SQLiteException -> 0x00d0 }
        r6 = "(2)Read invalid user property value, ignoring it";
        r7 = com.google.android.gms.internal.zzchm.m18154a(r24);	 Catch:{ SQLiteException -> 0x00d0 }
        r15 = r26;
        r5.m5696a(r6, r7, r14, r15);	 Catch:{ SQLiteException -> 0x00d0 }
        goto L_0x00e2;
    L_0x00d0:
        r0 = move-exception;
        r1 = r0;
        r6 = r14;
        goto L_0x010e;
    L_0x00d4:
        r15 = r26;
        r7 = new com.google.android.gms.internal.zzclp;	 Catch:{ SQLiteException -> 0x00d0 }
        r5 = r7;
        r6 = r12;
        r4 = r7;
        r7 = r14;
        r5.<init>(r6, r7, r8, r9, r11);	 Catch:{ SQLiteException -> 0x00d0 }
        r1.add(r4);	 Catch:{ SQLiteException -> 0x00d0 }
    L_0x00e2:
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x00d0 }
        if (r4 != 0) goto L_0x00ee;
    L_0x00e8:
        if (r3 == 0) goto L_0x00ed;
    L_0x00ea:
        r3.close();
    L_0x00ed:
        return r1;
    L_0x00ee:
        r6 = r14;
        r4 = 3;
        goto L_0x008d;
    L_0x00f1:
        r0 = move-exception;
        goto L_0x00fa;
    L_0x00f3:
        r0 = move-exception;
        r13 = r23;
        goto L_0x0124;
    L_0x00f7:
        r0 = move-exception;
        r13 = r23;
    L_0x00fa:
        r1 = r0;
        goto L_0x010e;
    L_0x00fc:
        r0 = move-exception;
        r13 = r23;
        goto L_0x010a;
    L_0x0100:
        r0 = move-exception;
        r13 = r23;
        r1 = r0;
        goto L_0x0126;
    L_0x0105:
        r0 = move-exception;
        r13 = r23;
        r12 = r24;
    L_0x010a:
        r6 = r25;
    L_0x010c:
        r1 = r0;
        r3 = r2;
    L_0x010e:
        r4 = r23.mo1828t();	 Catch:{ all -> 0x0123 }
        r4 = r4.f17816a;	 Catch:{ all -> 0x0123 }
        r5 = "(2)Error querying user properties";
        r7 = com.google.android.gms.internal.zzchm.m18154a(r24);	 Catch:{ all -> 0x0123 }
        r4.m5696a(r5, r7, r6, r1);	 Catch:{ all -> 0x0123 }
        if (r3 == 0) goto L_0x0122;
    L_0x011f:
        r3.close();
    L_0x0122:
        return r2;
    L_0x0123:
        r0 = move-exception;
    L_0x0124:
        r1 = r0;
        r2 = r3;
    L_0x0126:
        if (r2 == 0) goto L_0x012b;
    L_0x0128:
        r2.close();
    L_0x012b:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.a(java.lang.String, java.lang.String, java.lang.String):java.util.List<com.google.android.gms.internal.zzclp>");
    }

    public final boolean m18004a(zzcgl com_google_android_gms_internal_zzcgl) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgl);
        mo1811c();
        m13545L();
        if (m18013c(com_google_android_gms_internal_zzcgl.f17774a, com_google_android_gms_internal_zzcgl.f17776c.f17900a) == null) {
            if (m17992a("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{com_google_android_gms_internal_zzcgl.f17774a}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_internal_zzcgl.f17774a);
        contentValues.put("origin", com_google_android_gms_internal_zzcgl.f17775b);
        contentValues.put("name", com_google_android_gms_internal_zzcgl.f17776c.f17900a);
        m17979a(contentValues, "value", com_google_android_gms_internal_zzcgl.f17776c.m18501a());
        contentValues.put("active", Boolean.valueOf(com_google_android_gms_internal_zzcgl.f17778e));
        contentValues.put("trigger_event_name", com_google_android_gms_internal_zzcgl.f17779f);
        contentValues.put("trigger_timeout", Long.valueOf(com_google_android_gms_internal_zzcgl.f17781h));
        mo1824p();
        contentValues.put("timed_out_event", zzclq.m18516a(com_google_android_gms_internal_zzcgl.f17780g));
        contentValues.put("creation_timestamp", Long.valueOf(com_google_android_gms_internal_zzcgl.f17777d));
        mo1824p();
        contentValues.put("triggered_event", zzclq.m18516a(com_google_android_gms_internal_zzcgl.f17782i));
        contentValues.put("triggered_timestamp", Long.valueOf(com_google_android_gms_internal_zzcgl.f17776c.f17901b));
        contentValues.put("time_to_live", Long.valueOf(com_google_android_gms_internal_zzcgl.f17783j));
        mo1824p();
        contentValues.put("expired_event", zzclq.m18516a(com_google_android_gms_internal_zzcgl.f17784k));
        try {
            if (m17987A().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                mo1828t().f17816a.m5694a("Failed to insert/update conditional user property (got -1)", zzchm.m18154a(com_google_android_gms_internal_zzcgl.f17774a));
            }
        } catch (SQLiteException e) {
            mo1828t().f17816a.m5695a("Error storing conditional user property", zzchm.m18154a(com_google_android_gms_internal_zzcgl.f17774a), e);
        }
        return true;
    }

    public final zzcgl m18014d(String str, String str2) {
        SQLiteException e;
        Object obj;
        Throwable th;
        Throwable th2;
        zzcgo com_google_android_gms_internal_zzcgo;
        String str3 = str2;
        zzbq.m4810a(str);
        zzbq.m4810a(str2);
        mo1811c();
        m13545L();
        Cursor query;
        try {
            query = m17987A().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str3}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(0);
                    try {
                        Object a = m17977a(query, 1);
                        boolean z = query.getInt(2) != 0;
                        String string2 = query.getString(3);
                        long j = query.getLong(4);
                        zzcha com_google_android_gms_internal_zzcha = (zzcha) mo1824p().m18536a(query.getBlob(5), zzcha.CREATOR);
                        String str4 = str;
                        zzcgl com_google_android_gms_internal_zzcgl = new zzcgl(str4, string, new zzcln(str3, query.getLong(8), a, string), query.getLong(6), z, string2, com_google_android_gms_internal_zzcha, j, (zzcha) mo1824p().m18536a(query.getBlob(7), zzcha.CREATOR), query.getLong(9), (zzcha) mo1824p().m18536a(query.getBlob(10), zzcha.CREATOR));
                        if (query.moveToNext()) {
                            mo1828t().f17816a.m5695a("Got multiple records for conditional property, expected one", zzchm.m18154a(str), mo1823o().m18132c(str3));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return com_google_android_gms_internal_zzcgl;
                    } catch (SQLiteException e2) {
                        e = e2;
                        obj = e;
                        try {
                            mo1828t().f17816a.m5696a("Error querying conditional property", zzchm.m18154a(str), mo1823o().m18132c(str3), obj);
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        } catch (Throwable th3) {
                            th = th3;
                            th2 = th;
                            if (query != null) {
                                query.close();
                            }
                            throw th2;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                com_google_android_gms_internal_zzcgo = this;
                obj = e;
                mo1828t().f17816a.m5696a("Error querying conditional property", zzchm.m18154a(str), mo1823o().m18132c(str3), obj);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                com_google_android_gms_internal_zzcgo = this;
                th2 = th;
                if (query != null) {
                    query.close();
                }
                throw th2;
            }
        } catch (SQLiteException e4) {
            com_google_android_gms_internal_zzcgo = this;
            obj = e4;
            query = null;
            mo1828t().f17816a.m5696a("Error querying conditional property", zzchm.m18154a(str), mo1823o().m18132c(str3), obj);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th5) {
            com_google_android_gms_internal_zzcgo = this;
            th2 = th5;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th2;
        }
    }

    public final int m18016e(String str, String str2) {
        zzbq.m4810a(str);
        zzbq.m4810a(str2);
        mo1811c();
        m13545L();
        try {
            return m17987A().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            mo1828t().f17816a.m5696a("Error deleting conditional property", zzchm.m18154a(str), mo1823o().m18132c(str2), e);
            return 0;
        }
    }

    public final List<zzcgl> m18010b(String str, String[] strArr) {
        Cursor query;
        Object obj;
        Throwable th;
        mo1811c();
        m13545L();
        List<zzcgl> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            query = m17987A().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
            try {
                if (query.moveToFirst()) {
                    do {
                        if (arrayList.size() >= 1000) {
                            mo1828t().f17816a.m5694a("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf(1000));
                            break;
                        }
                        boolean z = false;
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object a = m17977a(query, 3);
                        if (query.getInt(4) != 0) {
                            z = true;
                        }
                        String string4 = query.getString(5);
                        long j = query.getLong(6);
                        zzcha com_google_android_gms_internal_zzcha = (zzcha) mo1824p().m18536a(query.getBlob(7), zzcha.CREATOR);
                        long j2 = query.getLong(8);
                        zzcha com_google_android_gms_internal_zzcha2 = (zzcha) mo1824p().m18536a(query.getBlob(9), zzcha.CREATOR);
                        long j3 = query.getLong(10);
                        long j4 = query.getLong(11);
                        zzcha com_google_android_gms_internal_zzcha3 = (zzcha) mo1824p().m18536a(query.getBlob(12), zzcha.CREATOR);
                        zzcln com_google_android_gms_internal_zzcln = new zzcln(string3, j3, a, string2);
                        boolean z2 = z;
                        zzcgl com_google_android_gms_internal_zzcgl = r4;
                        zzcgl com_google_android_gms_internal_zzcgl2 = new zzcgl(string, string2, com_google_android_gms_internal_zzcln, j2, z2, string4, com_google_android_gms_internal_zzcha, j, com_google_android_gms_internal_zzcha2, j4, com_google_android_gms_internal_zzcha3);
                        arrayList.add(com_google_android_gms_internal_zzcgl);
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e) {
                obj = e;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e2) {
            obj = e2;
            try {
                mo1828t().f17816a.m5694a("Error querying conditional user property value", obj);
                arrayList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th22) {
                th = th22;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }

    public final zzcgh m18008b(String str) {
        Cursor query;
        SQLiteException e;
        Cursor cursor;
        Object obj;
        Throwable th;
        Throwable th2;
        zzcgo com_google_android_gms_internal_zzcgo;
        String str2 = str;
        zzbq.m4810a(str);
        mo1811c();
        m13545L();
        try {
            boolean z = true;
            query = m17987A().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", State.KEY_APP_VERSION, "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled"}, "app_id=?", new String[]{str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    try {
                        boolean z2;
                        long j;
                        zzcgh com_google_android_gms_internal_zzcgh = new zzcgh(this.s, str2);
                        com_google_android_gms_internal_zzcgh.m5621a(query.getString(0));
                        com_google_android_gms_internal_zzcgh.m5625b(query.getString(1));
                        com_google_android_gms_internal_zzcgh.m5629c(query.getString(2));
                        com_google_android_gms_internal_zzcgh.m5637f(query.getLong(3));
                        com_google_android_gms_internal_zzcgh.m5620a(query.getLong(4));
                        com_google_android_gms_internal_zzcgh.m5624b(query.getLong(5));
                        com_google_android_gms_internal_zzcgh.m5635e(query.getString(6));
                        com_google_android_gms_internal_zzcgh.m5638f(query.getString(7));
                        com_google_android_gms_internal_zzcgh.m5631d(query.getLong(8));
                        com_google_android_gms_internal_zzcgh.m5634e(query.getLong(9));
                        if (!query.isNull(10)) {
                            if (query.getInt(10) == 0) {
                                z2 = false;
                                com_google_android_gms_internal_zzcgh.m5622a(z2);
                                j = query.getLong(11);
                                com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
                                com_google_android_gms_internal_zzcgh.f6805i |= com_google_android_gms_internal_zzcgh.f6798b == j ? 1 : 0;
                                com_google_android_gms_internal_zzcgh.f6798b = j;
                                j = query.getLong(12);
                                com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
                                com_google_android_gms_internal_zzcgh.f6805i |= com_google_android_gms_internal_zzcgh.f6799c == j ? 1 : 0;
                                com_google_android_gms_internal_zzcgh.f6799c = j;
                                j = query.getLong(13);
                                com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
                                com_google_android_gms_internal_zzcgh.f6805i |= com_google_android_gms_internal_zzcgh.f6800d == j ? 1 : 0;
                                com_google_android_gms_internal_zzcgh.f6800d = j;
                                j = query.getLong(14);
                                com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
                                com_google_android_gms_internal_zzcgh.f6805i |= com_google_android_gms_internal_zzcgh.f6801e == j ? 1 : 0;
                                com_google_android_gms_internal_zzcgh.f6801e = j;
                                com_google_android_gms_internal_zzcgh.m5640g(query.getLong(15));
                                com_google_android_gms_internal_zzcgh.m5643h(query.getLong(16));
                                com_google_android_gms_internal_zzcgh.m5628c(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                                com_google_android_gms_internal_zzcgh.m5632d(query.getString(18));
                                j = query.getLong(19);
                                com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
                                com_google_android_gms_internal_zzcgh.f6805i |= com_google_android_gms_internal_zzcgh.f6802f == j ? 1 : 0;
                                com_google_android_gms_internal_zzcgh.f6802f = j;
                                j = query.getLong(20);
                                com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
                                com_google_android_gms_internal_zzcgh.f6805i |= com_google_android_gms_internal_zzcgh.f6803g == j ? 1 : 0;
                                com_google_android_gms_internal_zzcgh.f6803g = j;
                                com_google_android_gms_internal_zzcgh.m5641g(query.getString(21));
                                com_google_android_gms_internal_zzcgh.m5645i(query.isNull(22) ? 0 : query.getLong(22));
                                if (!query.isNull(23)) {
                                    if (query.getInt(23) != 0) {
                                        z = false;
                                    }
                                }
                                com_google_android_gms_internal_zzcgh.m5626b(z);
                                com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
                                com_google_android_gms_internal_zzcgh.f6805i = false;
                                if (query.moveToNext()) {
                                    mo1828t().f17816a.m5694a("Got multiple records for app, expected one. appId", zzchm.m18154a(str));
                                }
                                if (query != null) {
                                    query.close();
                                }
                                return com_google_android_gms_internal_zzcgh;
                            }
                        }
                        z2 = true;
                        com_google_android_gms_internal_zzcgh.m5622a(z2);
                        j = query.getLong(11);
                        com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
                        if (com_google_android_gms_internal_zzcgh.f6798b == j) {
                        }
                        com_google_android_gms_internal_zzcgh.f6805i |= com_google_android_gms_internal_zzcgh.f6798b == j ? 1 : 0;
                        com_google_android_gms_internal_zzcgh.f6798b = j;
                        j = query.getLong(12);
                        com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
                        if (com_google_android_gms_internal_zzcgh.f6799c == j) {
                        }
                        com_google_android_gms_internal_zzcgh.f6805i |= com_google_android_gms_internal_zzcgh.f6799c == j ? 1 : 0;
                        com_google_android_gms_internal_zzcgh.f6799c = j;
                        j = query.getLong(13);
                        com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
                        if (com_google_android_gms_internal_zzcgh.f6800d == j) {
                        }
                        com_google_android_gms_internal_zzcgh.f6805i |= com_google_android_gms_internal_zzcgh.f6800d == j ? 1 : 0;
                        com_google_android_gms_internal_zzcgh.f6800d = j;
                        j = query.getLong(14);
                        com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
                        if (com_google_android_gms_internal_zzcgh.f6801e == j) {
                        }
                        com_google_android_gms_internal_zzcgh.f6805i |= com_google_android_gms_internal_zzcgh.f6801e == j ? 1 : 0;
                        com_google_android_gms_internal_zzcgh.f6801e = j;
                        com_google_android_gms_internal_zzcgh.m5640g(query.getLong(15));
                        com_google_android_gms_internal_zzcgh.m5643h(query.getLong(16));
                        if (query.isNull(17)) {
                        }
                        com_google_android_gms_internal_zzcgh.m5628c(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                        com_google_android_gms_internal_zzcgh.m5632d(query.getString(18));
                        j = query.getLong(19);
                        com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
                        if (com_google_android_gms_internal_zzcgh.f6802f == j) {
                        }
                        com_google_android_gms_internal_zzcgh.f6805i |= com_google_android_gms_internal_zzcgh.f6802f == j ? 1 : 0;
                        com_google_android_gms_internal_zzcgh.f6802f = j;
                        j = query.getLong(20);
                        com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
                        if (com_google_android_gms_internal_zzcgh.f6803g == j) {
                        }
                        com_google_android_gms_internal_zzcgh.f6805i |= com_google_android_gms_internal_zzcgh.f6803g == j ? 1 : 0;
                        com_google_android_gms_internal_zzcgh.f6803g = j;
                        com_google_android_gms_internal_zzcgh.m5641g(query.getString(21));
                        if (query.isNull(22)) {
                        }
                        com_google_android_gms_internal_zzcgh.m5645i(query.isNull(22) ? 0 : query.getLong(22));
                        if (query.isNull(23)) {
                            if (query.getInt(23) != 0) {
                                z = false;
                            }
                        }
                        com_google_android_gms_internal_zzcgh.m5626b(z);
                        com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
                        com_google_android_gms_internal_zzcgh.f6805i = false;
                        if (query.moveToNext()) {
                            mo1828t().f17816a.m5694a("Got multiple records for app, expected one. appId", zzchm.m18154a(str));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return com_google_android_gms_internal_zzcgh;
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursor = query;
                        obj = e;
                        try {
                            mo1828t().f17816a.m5695a("Error querying app. appId", zzchm.m18154a(str), obj);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        } catch (Throwable th22) {
                            th = th22;
                            query = cursor;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th22 = th3;
                        th = th22;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                com_google_android_gms_internal_zzcgo = this;
                cursor = query;
                obj = e;
                mo1828t().f17816a.m5695a("Error querying app. appId", zzchm.m18154a(str), obj);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th4) {
                th22 = th4;
                com_google_android_gms_internal_zzcgo = this;
                th = th22;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            com_google_android_gms_internal_zzcgo = this;
            obj = e4;
            cursor = null;
            mo1828t().f17816a.m5695a("Error querying app. appId", zzchm.m18154a(str), obj);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th222) {
            com_google_android_gms_internal_zzcgo = this;
            th = th222;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final void m18000a(zzcgh com_google_android_gms_internal_zzcgh) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgh);
        mo1811c();
        m13545L();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_internal_zzcgh.m5619a());
        contentValues.put("app_instance_id", com_google_android_gms_internal_zzcgh.m5623b());
        contentValues.put("gmp_app_id", com_google_android_gms_internal_zzcgh.m5627c());
        contentValues.put("resettable_device_id_hash", com_google_android_gms_internal_zzcgh.m5630d());
        contentValues.put("last_bundle_index", Long.valueOf(com_google_android_gms_internal_zzcgh.m5650n()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(com_google_android_gms_internal_zzcgh.m5636f()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(com_google_android_gms_internal_zzcgh.m5639g()));
        contentValues.put(State.KEY_APP_VERSION, com_google_android_gms_internal_zzcgh.m5642h());
        contentValues.put("app_store", com_google_android_gms_internal_zzcgh.m5646j());
        contentValues.put("gmp_version", Long.valueOf(com_google_android_gms_internal_zzcgh.m5647k()));
        contentValues.put("dev_cert_hash", Long.valueOf(com_google_android_gms_internal_zzcgh.m5648l()));
        contentValues.put("measurement_enabled", Boolean.valueOf(com_google_android_gms_internal_zzcgh.m5649m()));
        com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
        contentValues.put("day", Long.valueOf(com_google_android_gms_internal_zzcgh.f6798b));
        com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
        contentValues.put("daily_public_events_count", Long.valueOf(com_google_android_gms_internal_zzcgh.f6799c));
        com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
        contentValues.put("daily_events_count", Long.valueOf(com_google_android_gms_internal_zzcgh.f6800d));
        com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
        contentValues.put("daily_conversions_count", Long.valueOf(com_google_android_gms_internal_zzcgh.f6801e));
        contentValues.put("config_fetched_time", Long.valueOf(com_google_android_gms_internal_zzcgh.m5651o()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(com_google_android_gms_internal_zzcgh.m5652p()));
        contentValues.put("app_version_int", Long.valueOf(com_google_android_gms_internal_zzcgh.m5644i()));
        contentValues.put("firebase_instance_id", com_google_android_gms_internal_zzcgh.m5633e());
        com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
        contentValues.put("daily_error_events_count", Long.valueOf(com_google_android_gms_internal_zzcgh.f6802f));
        com_google_android_gms_internal_zzcgh.f6797a.m5755f().mo1811c();
        contentValues.put("daily_realtime_events_count", Long.valueOf(com_google_android_gms_internal_zzcgh.f6803g));
        contentValues.put("health_monitor_sample", com_google_android_gms_internal_zzcgh.m5654r());
        contentValues.put("android_id", Long.valueOf(com_google_android_gms_internal_zzcgh.m5655s()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(com_google_android_gms_internal_zzcgh.m5656t()));
        try {
            SQLiteDatabase A = m17987A();
            if (((long) A.update("apps", contentValues, "app_id = ?", new String[]{com_google_android_gms_internal_zzcgh.m5619a()})) == 0 && A.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                mo1828t().f17816a.m5694a("Failed to insert/update app (got -1). appId", zzchm.m18154a(com_google_android_gms_internal_zzcgh.m5619a()));
            }
        } catch (SQLiteException e) {
            mo1828t().f17816a.m5695a("Error storing app. appId", zzchm.m18154a(com_google_android_gms_internal_zzcgh.m5619a()), e);
        }
    }

    public final long m18012c(String str) {
        zzbq.m4810a(str);
        mo1811c();
        m13545L();
        try {
            SQLiteDatabase A = m17987A();
            String valueOf = String.valueOf(Math.max(0, Math.min(1000000, mo1830v().m13491b(str, zzchc.f6884r))));
            return (long) A.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            mo1828t().f17816a.m5695a("Error deleting over the limit events. appId", zzchm.m18154a(str), e);
            return 0;
        }
    }

    public final zzcgp m17994a(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Object obj;
        Throwable th;
        zzbq.m4810a(str);
        mo1811c();
        m13545L();
        String[] strArr = new String[]{str};
        zzcgp com_google_android_gms_internal_zzcgp = new zzcgp();
        Cursor cursor = null;
        try {
            SQLiteDatabase A = m17987A();
            SQLiteDatabase sQLiteDatabase = A;
            Cursor query = sQLiteDatabase.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        com_google_android_gms_internal_zzcgp.f6824b = query.getLong(1);
                        com_google_android_gms_internal_zzcgp.f6823a = query.getLong(2);
                        com_google_android_gms_internal_zzcgp.f6825c = query.getLong(3);
                        com_google_android_gms_internal_zzcgp.f6826d = query.getLong(4);
                        com_google_android_gms_internal_zzcgp.f6827e = query.getLong(5);
                    }
                    if (z) {
                        com_google_android_gms_internal_zzcgp.f6824b++;
                    }
                    if (z2) {
                        com_google_android_gms_internal_zzcgp.f6823a++;
                    }
                    if (z3) {
                        com_google_android_gms_internal_zzcgp.f6825c++;
                    }
                    if (z4) {
                        com_google_android_gms_internal_zzcgp.f6826d++;
                    }
                    if (z5) {
                        com_google_android_gms_internal_zzcgp.f6827e++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(com_google_android_gms_internal_zzcgp.f6823a));
                    contentValues.put("daily_events_count", Long.valueOf(com_google_android_gms_internal_zzcgp.f6824b));
                    contentValues.put("daily_conversions_count", Long.valueOf(com_google_android_gms_internal_zzcgp.f6825c));
                    contentValues.put("daily_error_events_count", Long.valueOf(com_google_android_gms_internal_zzcgp.f6826d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(com_google_android_gms_internal_zzcgp.f6827e));
                    A.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return com_google_android_gms_internal_zzcgp;
                }
                mo1828t().f17818c.m5694a("Not updating daily counts, app is not known. appId", zzchm.m18154a(str));
                if (query != null) {
                    query.close();
                }
                return com_google_android_gms_internal_zzcgp;
            } catch (SQLiteException e) {
                obj = e;
                cursor = query;
                try {
                    mo1828t().f17816a.m5695a("Error updating daily counts. appId", zzchm.m18154a(str), obj);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return com_google_android_gms_internal_zzcgp;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th22) {
                th = th22;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            obj = e2;
            mo1828t().f17816a.m5695a("Error updating daily counts. appId", zzchm.m18154a(str), obj);
            if (cursor != null) {
                cursor.close();
            }
            return com_google_android_gms_internal_zzcgp;
        }
    }

    public final byte[] m18015d(String str) {
        Cursor query;
        Object e;
        zzbq.m4810a(str);
        mo1811c();
        m13545L();
        try {
            query = m17987A().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        mo1828t().f17816a.m5694a("Got multiple records for app config, expected one. appId", zzchm.m18154a(str));
                    }
                    if (query != null) {
                        query.close();
                    }
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo1828t().f17816a.m5695a("Error querying remote config. appId", zzchm.m18154a(str), e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th) {
                    str = th;
                    if (query != null) {
                        query.close();
                    }
                    throw str;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            mo1828t().f17816a.m5695a("Error querying remote config. appId", zzchm.m18154a(str), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            str = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw str;
        }
    }

    public final boolean m18007a(zzcme com_google_android_gms_internal_zzcme, boolean z) {
        mo1811c();
        m13545L();
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcme);
        zzbq.m4810a(com_google_android_gms_internal_zzcme.f17996o);
        zzbq.m4808a(com_google_android_gms_internal_zzcme.f17987f);
        m17989C();
        long a = mo1819k().mo1632a();
        if (com_google_android_gms_internal_zzcme.f17987f.longValue() < a - zzcgn.m13485y() || com_google_android_gms_internal_zzcme.f17987f.longValue() > zzcgn.m13485y() + a) {
            mo1828t().f17818c.m5696a("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzchm.m18154a(com_google_android_gms_internal_zzcme.f17996o), Long.valueOf(a), com_google_android_gms_internal_zzcme.f17987f);
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzcme.m6211e()];
            zzfjk a2 = zzfjk.m6158a(bArr, bArr.length);
            com_google_android_gms_internal_zzcme.mo1928a(a2);
            a2.m6171a();
            bArr = mo1824p().m18548a(bArr);
            mo1828t().f17822g.m5694a("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_zzcme.f17996o);
            contentValues.put("bundle_end_timestamp", com_google_android_gms_internal_zzcme.f17987f);
            contentValues.put("data", bArr);
            contentValues.put("has_realtime", Integer.valueOf(z));
            try {
                if (m17987A().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                mo1828t().f17816a.m5694a("Failed to insert bundle (got -1). appId", zzchm.m18154a(com_google_android_gms_internal_zzcme.f17996o));
                return false;
            } catch (boolean z2) {
                mo1828t().f17816a.m5695a("Error storing bundle. appId", zzchm.m18154a(com_google_android_gms_internal_zzcme.f17996o), z2);
                return false;
            }
        } catch (boolean z22) {
            mo1828t().f17816a.m5695a("Data loss. Failed to serialize bundle. appId", zzchm.m18154a(com_google_android_gms_internal_zzcme.f17996o), z22);
            return false;
        }
    }

    public final String m17988B() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        try {
            rawQuery = m17987A().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    String string = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return string;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo1828t().f17816a.m5694a("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            mo1828t().f17816a.m5694a("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public final List<Pair<zzcme, Long>> m17998a(String str, int i, int i2) {
        mo1811c();
        m13545L();
        zzbq.m4817b(i > 0);
        zzbq.m4817b(i2 > 0);
        zzbq.m4810a(str);
        Cursor cursor = null;
        try {
            i = m17987A().query("queue", new String[]{"rowid", "data"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (i.moveToFirst()) {
                    List<Pair<zzcme, Long>> arrayList = new ArrayList();
                    int i3 = 0;
                    do {
                        long j = i.getLong(0);
                        try {
                            byte[] b = mo1824p().m18554b(i.getBlob(1));
                            if (!arrayList.isEmpty() && b.length + i3 > i2) {
                                break;
                            }
                            zzfjj a = zzfjj.m6130a(b, b.length);
                            zzfjs com_google_android_gms_internal_zzcme = new zzcme();
                            try {
                                com_google_android_gms_internal_zzcme.mo3478a(a);
                                i3 += b.length;
                                arrayList.add(Pair.create(com_google_android_gms_internal_zzcme, Long.valueOf(j)));
                            } catch (IOException e) {
                                mo1828t().f17816a.m5695a("Failed to merge queued bundle. appId", zzchm.m18154a(str), e);
                            }
                            if (!i.moveToNext()) {
                                break;
                            }
                        } catch (IOException e2) {
                            mo1828t().f17816a.m5695a("Failed to unzip queued bundle. appId", zzchm.m18154a(str), e2);
                        }
                    } while (i3 <= i2);
                    if (i != 0) {
                        i.close();
                    }
                    return arrayList;
                }
                i2 = Collections.emptyList();
                if (i != 0) {
                    i.close();
                }
                return i2;
            } catch (SQLiteException e3) {
                i2 = e3;
                cursor = i;
            } catch (Throwable th) {
                str = th;
            }
        } catch (SQLiteException e4) {
            i2 = e4;
            try {
                mo1828t().f17816a.m5695a("Error querying bundles. appId", zzchm.m18154a(str), i2);
                str = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return str;
            } catch (Throwable th2) {
                str = th2;
                i = cursor;
                if (i != 0) {
                    i.close();
                }
                throw str;
            }
        }
    }

    final void m17989C() {
        mo1811c();
        m13545L();
        if (m17975O()) {
            long a = mo1829u().f17833f.m5702a();
            long b = mo1819k().mo1633b();
            if (Math.abs(b - a) > ((Long) zzchc.f6852A.f6893a).longValue()) {
                mo1829u().f17833f.m5703a(b);
                mo1811c();
                m13545L();
                if (m17975O()) {
                    int delete = m17987A().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(mo1819k().mo1632a()), String.valueOf(zzcgn.m13485y())});
                    if (delete > 0) {
                        mo1828t().f17822g.m5694a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    final void m18002a(String str, zzclr[] com_google_android_gms_internal_zzclrArr) {
        m13545L();
        mo1811c();
        zzbq.m4810a(str);
        zzbq.m4808a((Object) com_google_android_gms_internal_zzclrArr);
        SQLiteDatabase A = m17987A();
        A.beginTransaction();
        try {
            m13545L();
            mo1811c();
            zzbq.m4810a(str);
            SQLiteDatabase A2 = m17987A();
            String[] strArr = new String[1];
            int i = 0;
            strArr[0] = str;
            A2.delete("property_filters", "app_id=?", strArr);
            A2.delete("event_filters", "app_id=?", new String[]{str});
            for (Object obj : com_google_android_gms_internal_zzclrArr) {
                m13545L();
                mo1811c();
                zzbq.m4810a(str);
                zzbq.m4808a(obj);
                zzbq.m4808a(obj.f17915c);
                zzbq.m4808a(obj.f17914b);
                if (obj.f17913a == null) {
                    mo1828t().f17818c.m5694a("Audience with no ID. appId", zzchm.m18154a(str));
                } else {
                    int i2;
                    int intValue = obj.f17913a.intValue();
                    for (zzcls com_google_android_gms_internal_zzcls : obj.f17915c) {
                        if (com_google_android_gms_internal_zzcls.f17917a == null) {
                            mo1828t().f17818c.m5695a("Event filter with no ID. Audience definition ignored. appId, audienceId", zzchm.m18154a(str), obj.f17913a);
                            break;
                        }
                    }
                    for (zzclv com_google_android_gms_internal_zzclv : obj.f17914b) {
                        if (com_google_android_gms_internal_zzclv.f17933a == null) {
                            mo1828t().f17818c.m5695a("Property filter with no ID. Audience definition ignored. appId, audienceId", zzchm.m18154a(str), obj.f17913a);
                            break;
                        }
                    }
                    for (zzcls com_google_android_gms_internal_zzcls2 : obj.f17915c) {
                        if (!m17984a(str, intValue, com_google_android_gms_internal_zzcls2)) {
                            i2 = 0;
                            break;
                        }
                    }
                    i2 = 1;
                    if (i2 != 0) {
                        for (zzclv com_google_android_gms_internal_zzclv2 : obj.f17914b) {
                            if (!m17985a(str, intValue, com_google_android_gms_internal_zzclv2)) {
                                i2 = 0;
                                break;
                            }
                        }
                    }
                    if (i2 == 0) {
                        m13545L();
                        mo1811c();
                        zzbq.m4810a(str);
                        SQLiteDatabase A3 = m17987A();
                        A3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                        A3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                    }
                }
            }
            List arrayList = new ArrayList();
            int length = com_google_android_gms_internal_zzclrArr.length;
            while (i < length) {
                arrayList.add(com_google_android_gms_internal_zzclrArr[i].f17913a);
                i++;
            }
            m17986a(str, arrayList);
            A.setTransactionSuccessful();
        } finally {
            A.endTransaction();
        }
    }

    private final boolean m17984a(String str, int i, zzcls com_google_android_gms_internal_zzcls) {
        m13545L();
        mo1811c();
        zzbq.m4810a(str);
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcls);
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzcls.f17918b)) {
            mo1828t().f17818c.m5696a("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzchm.m18154a(str), Integer.valueOf(i), String.valueOf(com_google_android_gms_internal_zzcls.f17917a));
            return false;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzcls.m6211e()];
            zzfjk a = zzfjk.m6158a(bArr, bArr.length);
            com_google_android_gms_internal_zzcls.mo1928a(a);
            a.m6171a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", com_google_android_gms_internal_zzcls.f17917a);
            contentValues.put("event_name", com_google_android_gms_internal_zzcls.f17918b);
            contentValues.put("data", bArr);
            try {
                if (m17987A().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    mo1828t().f17816a.m5694a("Failed to insert event filter (got -1). appId", zzchm.m18154a(str));
                }
                return true;
            } catch (int i2) {
                mo1828t().f17816a.m5695a("Error storing event filter. appId", zzchm.m18154a(str), i2);
                return false;
            }
        } catch (int i22) {
            mo1828t().f17816a.m5695a("Configuration loss. Failed to serialize event filter. appId", zzchm.m18154a(str), i22);
            return false;
        }
    }

    private final boolean m17985a(String str, int i, zzclv com_google_android_gms_internal_zzclv) {
        m13545L();
        mo1811c();
        zzbq.m4810a(str);
        zzbq.m4808a((Object) com_google_android_gms_internal_zzclv);
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzclv.f17934b)) {
            mo1828t().f17818c.m5696a("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzchm.m18154a(str), Integer.valueOf(i), String.valueOf(com_google_android_gms_internal_zzclv.f17933a));
            return false;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzclv.m6211e()];
            zzfjk a = zzfjk.m6158a(bArr, bArr.length);
            com_google_android_gms_internal_zzclv.mo1928a(a);
            a.m6171a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", com_google_android_gms_internal_zzclv.f17933a);
            contentValues.put("property_name", com_google_android_gms_internal_zzclv.f17934b);
            contentValues.put("data", bArr);
            try {
                if (m17987A().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                mo1828t().f17816a.m5694a("Failed to insert property filter (got -1). appId", zzchm.m18154a(str));
                return false;
            } catch (int i2) {
                mo1828t().f17816a.m5695a("Error storing property filter. appId", zzchm.m18154a(str), i2);
                return false;
            }
        } catch (int i22) {
            mo1828t().f17816a.m5695a("Configuration loss. Failed to serialize property filter. appId", zzchm.m18154a(str), i22);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzcls>> m18018f(java.lang.String r13, java.lang.String r14) {
        /*
        r12 = this;
        r12.m13545L();
        r12.mo1811c();
        com.google.android.gms.common.internal.zzbq.m4810a(r13);
        com.google.android.gms.common.internal.zzbq.m4810a(r14);
        r0 = new android.support.v4.util.ArrayMap;
        r0.<init>();
        r1 = r12.m17987A();
        r9 = 0;
        r2 = "event_filters";
        r3 = "audience_id";
        r4 = "data";
        r3 = new java.lang.String[]{r3, r4};	 Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
        r4 = "app_id=? AND event_name=?";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
        r10 = 0;
        r5[r10] = r13;	 Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
        r11 = 1;
        r5[r11] = r14;	 Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r14 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
        r1 = r14.moveToFirst();	 Catch:{ SQLiteException -> 0x008f }
        if (r1 != 0) goto L_0x0042;
    L_0x0038:
        r0 = java.util.Collections.emptyMap();	 Catch:{ SQLiteException -> 0x008f }
        if (r14 == 0) goto L_0x0041;
    L_0x003e:
        r14.close();
    L_0x0041:
        return r0;
    L_0x0042:
        r1 = r14.getBlob(r11);	 Catch:{ SQLiteException -> 0x008f }
        r2 = r1.length;	 Catch:{ SQLiteException -> 0x008f }
        r1 = com.google.android.gms.internal.zzfjj.m6130a(r1, r2);	 Catch:{ SQLiteException -> 0x008f }
        r2 = new com.google.android.gms.internal.zzcls;	 Catch:{ SQLiteException -> 0x008f }
        r2.<init>();	 Catch:{ SQLiteException -> 0x008f }
        r2.mo3478a(r1);	 Catch:{ IOException -> 0x0073 }
        r1 = r14.getInt(r10);	 Catch:{ SQLiteException -> 0x008f }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x008f }
        r3 = r0.get(r3);	 Catch:{ SQLiteException -> 0x008f }
        r3 = (java.util.List) r3;	 Catch:{ SQLiteException -> 0x008f }
        if (r3 != 0) goto L_0x006f;
    L_0x0063:
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x008f }
        r3.<init>();	 Catch:{ SQLiteException -> 0x008f }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x008f }
        r0.put(r1, r3);	 Catch:{ SQLiteException -> 0x008f }
    L_0x006f:
        r3.add(r2);	 Catch:{ SQLiteException -> 0x008f }
        goto L_0x0083;
    L_0x0073:
        r1 = move-exception;
        r2 = r12.mo1828t();	 Catch:{ SQLiteException -> 0x008f }
        r2 = r2.f17816a;	 Catch:{ SQLiteException -> 0x008f }
        r3 = "Failed to merge filter. appId";
        r4 = com.google.android.gms.internal.zzchm.m18154a(r13);	 Catch:{ SQLiteException -> 0x008f }
        r2.m5695a(r3, r4, r1);	 Catch:{ SQLiteException -> 0x008f }
    L_0x0083:
        r1 = r14.moveToNext();	 Catch:{ SQLiteException -> 0x008f }
        if (r1 != 0) goto L_0x0042;
    L_0x0089:
        if (r14 == 0) goto L_0x008e;
    L_0x008b:
        r14.close();
    L_0x008e:
        return r0;
    L_0x008f:
        r0 = move-exception;
        goto L_0x0096;
    L_0x0091:
        r13 = move-exception;
        r14 = r9;
        goto L_0x00ac;
    L_0x0094:
        r0 = move-exception;
        r14 = r9;
    L_0x0096:
        r1 = r12.mo1828t();	 Catch:{ all -> 0x00ab }
        r1 = r1.f17816a;	 Catch:{ all -> 0x00ab }
        r2 = "Database error querying filters. appId";
        r13 = com.google.android.gms.internal.zzchm.m18154a(r13);	 Catch:{ all -> 0x00ab }
        r1.m5695a(r2, r13, r0);	 Catch:{ all -> 0x00ab }
        if (r14 == 0) goto L_0x00aa;
    L_0x00a7:
        r14.close();
    L_0x00aa:
        return r9;
    L_0x00ab:
        r13 = move-exception;
    L_0x00ac:
        if (r14 == 0) goto L_0x00b1;
    L_0x00ae:
        r14.close();
    L_0x00b1:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.f(java.lang.String, java.lang.String):java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzcls>>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzclv>> m18019g(java.lang.String r13, java.lang.String r14) {
        /*
        r12 = this;
        r12.m13545L();
        r12.mo1811c();
        com.google.android.gms.common.internal.zzbq.m4810a(r13);
        com.google.android.gms.common.internal.zzbq.m4810a(r14);
        r0 = new android.support.v4.util.ArrayMap;
        r0.<init>();
        r1 = r12.m17987A();
        r9 = 0;
        r2 = "property_filters";
        r3 = "audience_id";
        r4 = "data";
        r3 = new java.lang.String[]{r3, r4};	 Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
        r4 = "app_id=? AND property_name=?";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
        r10 = 0;
        r5[r10] = r13;	 Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
        r11 = 1;
        r5[r11] = r14;	 Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r14 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
        r1 = r14.moveToFirst();	 Catch:{ SQLiteException -> 0x008f }
        if (r1 != 0) goto L_0x0042;
    L_0x0038:
        r0 = java.util.Collections.emptyMap();	 Catch:{ SQLiteException -> 0x008f }
        if (r14 == 0) goto L_0x0041;
    L_0x003e:
        r14.close();
    L_0x0041:
        return r0;
    L_0x0042:
        r1 = r14.getBlob(r11);	 Catch:{ SQLiteException -> 0x008f }
        r2 = r1.length;	 Catch:{ SQLiteException -> 0x008f }
        r1 = com.google.android.gms.internal.zzfjj.m6130a(r1, r2);	 Catch:{ SQLiteException -> 0x008f }
        r2 = new com.google.android.gms.internal.zzclv;	 Catch:{ SQLiteException -> 0x008f }
        r2.<init>();	 Catch:{ SQLiteException -> 0x008f }
        r2.mo3478a(r1);	 Catch:{ IOException -> 0x0073 }
        r1 = r14.getInt(r10);	 Catch:{ SQLiteException -> 0x008f }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x008f }
        r3 = r0.get(r3);	 Catch:{ SQLiteException -> 0x008f }
        r3 = (java.util.List) r3;	 Catch:{ SQLiteException -> 0x008f }
        if (r3 != 0) goto L_0x006f;
    L_0x0063:
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x008f }
        r3.<init>();	 Catch:{ SQLiteException -> 0x008f }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x008f }
        r0.put(r1, r3);	 Catch:{ SQLiteException -> 0x008f }
    L_0x006f:
        r3.add(r2);	 Catch:{ SQLiteException -> 0x008f }
        goto L_0x0083;
    L_0x0073:
        r1 = move-exception;
        r2 = r12.mo1828t();	 Catch:{ SQLiteException -> 0x008f }
        r2 = r2.f17816a;	 Catch:{ SQLiteException -> 0x008f }
        r3 = "Failed to merge filter";
        r4 = com.google.android.gms.internal.zzchm.m18154a(r13);	 Catch:{ SQLiteException -> 0x008f }
        r2.m5695a(r3, r4, r1);	 Catch:{ SQLiteException -> 0x008f }
    L_0x0083:
        r1 = r14.moveToNext();	 Catch:{ SQLiteException -> 0x008f }
        if (r1 != 0) goto L_0x0042;
    L_0x0089:
        if (r14 == 0) goto L_0x008e;
    L_0x008b:
        r14.close();
    L_0x008e:
        return r0;
    L_0x008f:
        r0 = move-exception;
        goto L_0x0096;
    L_0x0091:
        r13 = move-exception;
        r14 = r9;
        goto L_0x00ac;
    L_0x0094:
        r0 = move-exception;
        r14 = r9;
    L_0x0096:
        r1 = r12.mo1828t();	 Catch:{ all -> 0x00ab }
        r1 = r1.f17816a;	 Catch:{ all -> 0x00ab }
        r2 = "Database error querying filters. appId";
        r13 = com.google.android.gms.internal.zzchm.m18154a(r13);	 Catch:{ all -> 0x00ab }
        r1.m5695a(r2, r13, r0);	 Catch:{ all -> 0x00ab }
        if (r14 == 0) goto L_0x00aa;
    L_0x00a7:
        r14.close();
    L_0x00aa:
        return r9;
    L_0x00ab:
        r13 = move-exception;
    L_0x00ac:
        if (r14 == 0) goto L_0x00b1;
    L_0x00ae:
        r14.close();
    L_0x00b1:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.g(java.lang.String, java.lang.String):java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzclv>>");
    }

    private final boolean m17986a(String str, List<Integer> list) {
        zzbq.m4810a(str);
        m13545L();
        mo1811c();
        SQLiteDatabase A = m17987A();
        try {
            if (m17992a("select count(1) from audience_filter_values where app_id=?", new String[]{str}) <= ((long) Math.max(0, Math.min(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, mo1830v().m13491b(str, zzchc.f6859H))))) {
                return false;
            }
            Iterable arrayList = new ArrayList();
            int i = 0;
            while (i < list.size()) {
                Integer num = (Integer) list.get(i);
                if (num != null) {
                    if (num instanceof Integer) {
                        arrayList.add(Integer.toString(num.intValue()));
                        i++;
                    }
                }
                return false;
            }
            list = TextUtils.join(",", arrayList);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(list).length() + 2);
            stringBuilder.append("(");
            stringBuilder.append(list);
            stringBuilder.append(")");
            list = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder(140 + String.valueOf(list).length());
            stringBuilder2.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            stringBuilder2.append(list);
            stringBuilder2.append(" order by rowid desc limit -1 offset ?)");
            return A.delete("audience_filter_values", stringBuilder2.toString(), new String[]{str, Integer.toString(r2)}) > null;
        } catch (List<Integer> list2) {
            mo1828t().f17816a.m5695a("Database error querying filters. appId", zzchm.m18154a(str), list2);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final java.util.Map<java.lang.Integer, com.google.android.gms.internal.zzcmf> m18017e(java.lang.String r12) {
        /*
        r11 = this;
        r11.m13545L();
        r11.mo1811c();
        com.google.android.gms.common.internal.zzbq.m4810a(r12);
        r0 = r11.m17987A();
        r8 = 0;
        r1 = "audience_filter_values";
        r2 = "audience_id";
        r3 = "current_results";
        r2 = new java.lang.String[]{r2, r3};	 Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
        r3 = "app_id=?";
        r9 = 1;
        r4 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
        r10 = 0;
        r4[r10] = r12;	 Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
        r1 = r0.moveToFirst();	 Catch:{ SQLiteException -> 0x0075 }
        if (r1 != 0) goto L_0x0033;
    L_0x002d:
        if (r0 == 0) goto L_0x0032;
    L_0x002f:
        r0.close();
    L_0x0032:
        return r8;
    L_0x0033:
        r1 = new android.support.v4.util.ArrayMap;	 Catch:{ SQLiteException -> 0x0075 }
        r1.<init>();	 Catch:{ SQLiteException -> 0x0075 }
    L_0x0038:
        r2 = r0.getInt(r10);	 Catch:{ SQLiteException -> 0x0075 }
        r3 = r0.getBlob(r9);	 Catch:{ SQLiteException -> 0x0075 }
        r4 = r3.length;	 Catch:{ SQLiteException -> 0x0075 }
        r3 = com.google.android.gms.internal.zzfjj.m6130a(r3, r4);	 Catch:{ SQLiteException -> 0x0075 }
        r4 = new com.google.android.gms.internal.zzcmf;	 Catch:{ SQLiteException -> 0x0075 }
        r4.<init>();	 Catch:{ SQLiteException -> 0x0075 }
        r4.mo3478a(r3);	 Catch:{ IOException -> 0x0055 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ SQLiteException -> 0x0075 }
        r1.put(r2, r4);	 Catch:{ SQLiteException -> 0x0075 }
        goto L_0x0069;
    L_0x0055:
        r3 = move-exception;
        r4 = r11.mo1828t();	 Catch:{ SQLiteException -> 0x0075 }
        r4 = r4.f17816a;	 Catch:{ SQLiteException -> 0x0075 }
        r5 = "Failed to merge filter results. appId, audienceId, error";
        r6 = com.google.android.gms.internal.zzchm.m18154a(r12);	 Catch:{ SQLiteException -> 0x0075 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ SQLiteException -> 0x0075 }
        r4.m5696a(r5, r6, r2, r3);	 Catch:{ SQLiteException -> 0x0075 }
    L_0x0069:
        r2 = r0.moveToNext();	 Catch:{ SQLiteException -> 0x0075 }
        if (r2 != 0) goto L_0x0038;
    L_0x006f:
        if (r0 == 0) goto L_0x0074;
    L_0x0071:
        r0.close();
    L_0x0074:
        return r1;
    L_0x0075:
        r1 = move-exception;
        goto L_0x007c;
    L_0x0077:
        r12 = move-exception;
        r0 = r8;
        goto L_0x0092;
    L_0x007a:
        r1 = move-exception;
        r0 = r8;
    L_0x007c:
        r2 = r11.mo1828t();	 Catch:{ all -> 0x0091 }
        r2 = r2.f17816a;	 Catch:{ all -> 0x0091 }
        r3 = "Database error querying filter results. appId";
        r12 = com.google.android.gms.internal.zzchm.m18154a(r12);	 Catch:{ all -> 0x0091 }
        r2.m5695a(r3, r12, r1);	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x0090;
    L_0x008d:
        r0.close();
    L_0x0090:
        return r8;
    L_0x0091:
        r12 = move-exception;
    L_0x0092:
        if (r0 == 0) goto L_0x0097;
    L_0x0094:
        r0.close();
    L_0x0097:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.e(java.lang.String):java.util.Map<java.lang.Integer, com.google.android.gms.internal.zzcmf>");
    }

    private final Object m17977a(Cursor cursor, int i) {
        int type = cursor.getType(i);
        switch (type) {
            case 0:
                mo1828t().f17816a.m5693a("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                mo1828t().f17816a.m5693a("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                mo1828t().f17816a.m5694a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
        }
    }

    protected final long m18020h(String str, String str2) {
        Object e;
        zzbq.m4810a(str);
        zzbq.m4810a(str2);
        mo1811c();
        m13545L();
        SQLiteDatabase A = m17987A();
        A.beginTransaction();
        long a;
        try {
            ContentValues contentValues;
            StringBuilder stringBuilder = new StringBuilder(32 + String.valueOf(str2).length());
            stringBuilder.append("select ");
            stringBuilder.append(str2);
            stringBuilder.append(" from app2 where app_id=?");
            a = m17993a(stringBuilder.toString(), new String[]{str}, -1);
            if (a == -1) {
                contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", Integer.valueOf(0));
                contentValues.put("previous_install_count", Integer.valueOf(0));
                if (A.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    mo1828t().f17816a.m5695a("Failed to insert column (got -1). appId", zzchm.m18154a(str), str2);
                    A.endTransaction();
                    return -1;
                }
                a = 0;
            }
            try {
                contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put(str2, Long.valueOf(1 + a));
                if (((long) A.update("app2", contentValues, "app_id = ?", new String[]{str})) == 0) {
                    mo1828t().f17816a.m5695a("Failed to update column (got 0). appId", zzchm.m18154a(str), str2);
                    A.endTransaction();
                    return -1;
                }
                A.setTransactionSuccessful();
                A.endTransaction();
                return a;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo1828t().f17816a.m5696a("Error inserting column. appId", zzchm.m18154a(str), str2, e);
                    return a;
                } finally {
                    A.endTransaction();
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            a = 0;
            mo1828t().f17816a.m5696a("Error inserting column. appId", zzchm.m18154a(str), str2, e);
            return a;
        }
    }

    public final long m17991a(zzcme com_google_android_gms_internal_zzcme) throws IOException {
        mo1811c();
        m13545L();
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcme);
        zzbq.m4810a(com_google_android_gms_internal_zzcme.f17996o);
        try {
            long j;
            Object obj = new byte[com_google_android_gms_internal_zzcme.m6211e()];
            zzfjk a = zzfjk.m6158a((byte[]) obj, obj.length);
            com_google_android_gms_internal_zzcme.mo1928a(a);
            a.m6171a();
            zzcjk p = mo1824p();
            zzbq.m4808a(obj);
            p.mo1811c();
            MessageDigest f = zzclq.m18526f("MD5");
            if (f == null) {
                p.mo1828t().f17816a.m5693a("Failed to get MD5");
                j = 0;
            } else {
                j = zzclq.m18522c(f.digest(obj));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_zzcme.f17996o);
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("metadata", obj);
            try {
                m17987A().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return j;
            } catch (SQLiteException e) {
                mo1828t().f17816a.m5695a("Error storing raw event metadata. appId", zzchm.m18154a(com_google_android_gms_internal_zzcme.f17996o), e);
                throw e;
            }
        } catch (IOException e2) {
            mo1828t().f17816a.m5695a("Data loss. Failed to serialize event metadata. appId", zzchm.m18154a(com_google_android_gms_internal_zzcme.f17996o), e2);
            throw e2;
        }
    }

    public final void m18003a(List<Long> list) {
        zzbq.m4808a((Object) list);
        mo1811c();
        m13545L();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Long) list.get(i)).longValue());
        }
        stringBuilder.append(")");
        int delete = m17987A().delete("raw_events", stringBuilder.toString(), null);
        if (delete != list.size()) {
            mo1828t().f17816a.m5695a("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public final String m17996a(long j) {
        Object e;
        Throwable th;
        mo1811c();
        m13545L();
        try {
            j = m17987A().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (j.moveToFirst()) {
                    String string = j.getString(0);
                    if (j != null) {
                        j.close();
                    }
                    return string;
                }
                mo1828t().f17822g.m5693a("No expired configs for apps with pending events");
                if (j != null) {
                    j.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo1828t().f17816a.m5694a("Error selecting expired configs", e);
                    if (j != null) {
                        j.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (j != null) {
                        j.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            j = 0;
            mo1828t().f17816a.m5694a("Error selecting expired configs", e);
            if (j != null) {
                j.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            j = 0;
            if (j != null) {
                j.close();
            }
            throw th;
        }
    }

    public final long m17990D() {
        Object obj;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor rawQuery = m17987A().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return -1;
            } catch (SQLiteException e) {
                Cursor cursor2 = rawQuery;
                obj = e;
                cursor = cursor2;
                try {
                    mo1828t().f17816a.m5694a("Error querying raw events", obj);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = rawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            obj = e2;
            mo1828t().f17816a.m5694a("Error querying raw events", obj);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        }
    }

    public final boolean m18005a(zzcgv com_google_android_gms_internal_zzcgv, long j, boolean z) {
        mo1811c();
        m13545L();
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgv);
        zzbq.m4810a(com_google_android_gms_internal_zzcgv.f6835a);
        zzfjs com_google_android_gms_internal_zzcmb = new zzcmb();
        com_google_android_gms_internal_zzcmb.f17963d = Long.valueOf(com_google_android_gms_internal_zzcgv.f6839e);
        com_google_android_gms_internal_zzcmb.f17960a = new zzcmc[com_google_android_gms_internal_zzcgv.f6840f.f17797a.size()];
        Iterator it = com_google_android_gms_internal_zzcgv.f6840f.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            zzcmc com_google_android_gms_internal_zzcmc = new zzcmc();
            int i2 = i + 1;
            com_google_android_gms_internal_zzcmb.f17960a[i] = com_google_android_gms_internal_zzcmc;
            com_google_android_gms_internal_zzcmc.f17966a = str;
            mo1824p().m18541a(com_google_android_gms_internal_zzcmc, com_google_android_gms_internal_zzcgv.f6840f.m18053a(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzcmb.m6211e()];
            zzfjk a = zzfjk.m6158a(bArr, bArr.length);
            com_google_android_gms_internal_zzcmb.mo1928a(a);
            a.m6171a();
            mo1828t().f17822g.m5695a("Saving event, name, data size", mo1823o().m18128a(com_google_android_gms_internal_zzcgv.f6836b), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_zzcgv.f6835a);
            contentValues.put("name", com_google_android_gms_internal_zzcgv.f6836b);
            contentValues.put("timestamp", Long.valueOf(com_google_android_gms_internal_zzcgv.f6838d));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z));
            try {
                if (m17987A().insert("raw_events", false, contentValues) != -1) {
                    return true;
                }
                mo1828t().f17816a.m5694a("Failed to insert raw event (got -1). appId", zzchm.m18154a(com_google_android_gms_internal_zzcgv.f6835a));
                return false;
            } catch (long j2) {
                mo1828t().f17816a.m5695a("Error storing raw event. appId", zzchm.m18154a(com_google_android_gms_internal_zzcgv.f6835a), j2);
                return false;
            }
        } catch (long j22) {
            mo1828t().f17816a.m5695a("Data loss. Failed to serialize event params/data. appId", zzchm.m18154a(com_google_android_gms_internal_zzcgv.f6835a), j22);
            return false;
        }
    }

    private static boolean m17983a(zzchm com_google_android_gms_internal_zzchm, SQLiteDatabase sQLiteDatabase, String str) {
        if (com_google_android_gms_internal_zzchm == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            sQLiteDatabase = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            try {
                boolean moveToFirst = sQLiteDatabase.moveToFirst();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return moveToFirst;
            } catch (SQLiteException e) {
                SQLiteException sQLiteException = e;
                cursor = sQLiteDatabase;
                sQLiteDatabase = sQLiteException;
                try {
                    com_google_android_gms_internal_zzchm.f17818c.m5695a("Error querying for table", str, sQLiteDatabase);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                } catch (Throwable th) {
                    com_google_android_gms_internal_zzchm = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw com_google_android_gms_internal_zzchm;
                }
            } catch (Throwable th2) {
                com_google_android_gms_internal_zzchm = th2;
                cursor = sQLiteDatabase;
                if (cursor != null) {
                    cursor.close();
                }
                throw com_google_android_gms_internal_zzchm;
            }
        } catch (SQLiteException e2) {
            sQLiteDatabase = e2;
            com_google_android_gms_internal_zzchm.f17818c.m5695a("Error querying for table", str, sQLiteDatabase);
            if (cursor != null) {
                cursor.close();
            }
            return false;
        }
    }

    private static void m17982a(zzchm com_google_android_gms_internal_zzchm, SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) throws SQLiteException {
        if (com_google_android_gms_internal_zzchm == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Iterable a = m17978a(sQLiteDatabase, str);
        str2 = str2.split(",");
        int i = 0;
        int length = str2.length;
        int i2 = 0;
        while (i2 < length) {
            String str3 = str2[i2];
            if (a.remove(str3)) {
                i2++;
            } else {
                str2 = new StringBuilder((35 + String.valueOf(str).length()) + String.valueOf(str3).length());
                str2.append("Table ");
                str2.append(str);
                str2.append(" is missing required column: ");
                str2.append(str3);
                throw new SQLiteException(str2.toString());
            }
        }
        if (strArr != null) {
            while (i < strArr.length) {
                if (a.remove(strArr[i]) == null) {
                    sQLiteDatabase.execSQL(strArr[i + 1]);
                }
                i += 2;
            }
        }
        if (a.isEmpty() == null) {
            com_google_android_gms_internal_zzchm.f17818c.m5695a("Table has extra columns. table, columns", str, TextUtils.join(", ", a));
        }
    }

    static void m17981a(zzchm com_google_android_gms_internal_zzchm, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        if (com_google_android_gms_internal_zzchm == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!m17983a(com_google_android_gms_internal_zzchm, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            m17982a(com_google_android_gms_internal_zzchm, sQLiteDatabase, str, str3, strArr);
        } catch (SQLiteDatabase sQLiteDatabase2) {
            com_google_android_gms_internal_zzchm.f17816a.m5694a("Failed to verify columns on table that was just created", str);
            throw sQLiteDatabase2;
        }
    }

    static void m17980a(zzchm com_google_android_gms_internal_zzchm, SQLiteDatabase sQLiteDatabase) {
        if (com_google_android_gms_internal_zzchm == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            com_google_android_gms_internal_zzchm.f17818c.m5693a("Failed to turn off database read permission");
        }
        if (file.setWritable(false, false) == null) {
            com_google_android_gms_internal_zzchm.f17818c.m5693a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            com_google_android_gms_internal_zzchm.f17818c.m5693a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true) == null) {
            com_google_android_gms_internal_zzchm.f17818c.m5693a("Failed to turn on database write permission for owner");
        }
    }
}
