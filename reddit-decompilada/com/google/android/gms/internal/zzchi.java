package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.google.android.gms.common.util.zzd;

public final class zzchi extends zzcjl {
    private final zzchj f17811a = new zzchj(this, mo1820l(), "google_app_measurement_local.db");
    private boolean f17812b;

    zzchi(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    public final /* bridge */ /* synthetic */ void mo1809a() {
        super.mo1809a();
    }

    public final /* bridge */ /* synthetic */ void mo1810b() {
        super.mo1810b();
    }

    public final /* bridge */ /* synthetic */ void mo1811c() {
        super.mo1811c();
    }

    public final /* bridge */ /* synthetic */ zzcgd mo1812d() {
        return super.mo1812d();
    }

    public final /* bridge */ /* synthetic */ zzcgk mo1813e() {
        return super.mo1813e();
    }

    public final /* bridge */ /* synthetic */ zzcjn mo1814f() {
        return super.mo1814f();
    }

    public final /* bridge */ /* synthetic */ zzchh mo1815g() {
        return super.mo1815g();
    }

    public final /* bridge */ /* synthetic */ zzcgu mo1816h() {
        return super.mo1816h();
    }

    public final /* bridge */ /* synthetic */ zzckg mo1817i() {
        return super.mo1817i();
    }

    public final /* bridge */ /* synthetic */ zzckc mo1818j() {
        return super.mo1818j();
    }

    public final /* bridge */ /* synthetic */ zzd mo1819k() {
        return super.mo1819k();
    }

    public final /* bridge */ /* synthetic */ Context mo1820l() {
        return super.mo1820l();
    }

    public final /* bridge */ /* synthetic */ zzchi mo1821m() {
        return super.mo1821m();
    }

    public final /* bridge */ /* synthetic */ zzcgo mo1822n() {
        return super.mo1822n();
    }

    public final /* bridge */ /* synthetic */ zzchk mo1823o() {
        return super.mo1823o();
    }

    public final /* bridge */ /* synthetic */ zzclq mo1824p() {
        return super.mo1824p();
    }

    public final /* bridge */ /* synthetic */ zzcig mo1825q() {
        return super.mo1825q();
    }

    public final /* bridge */ /* synthetic */ zzclf mo1826r() {
        return super.mo1826r();
    }

    public final /* bridge */ /* synthetic */ zzcih mo1827s() {
        return super.mo1827s();
    }

    public final /* bridge */ /* synthetic */ zzchm mo1828t() {
        return super.mo1828t();
    }

    public final /* bridge */ /* synthetic */ zzchx mo1829u() {
        return super.mo1829u();
    }

    public final /* bridge */ /* synthetic */ zzcgn mo1830v() {
        return super.mo1830v();
    }

    protected final boolean mo3490w() {
        return false;
    }

    final SQLiteDatabase m18110z() {
        if (this.f17812b) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f17811a.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f17812b = true;
        return null;
    }

    @TargetApi(11)
    final boolean m18086a(int i, byte[] bArr) {
        SQLiteDatabase z;
        Object obj;
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        mo1811c();
        boolean z2 = false;
        if (this.f17812b) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 5;
        int i3 = 0;
        int i4 = 5;
        while (i3 < i2) {
            Cursor cursor;
            Cursor cursor2 = null;
            try {
                z = m18110z();
                if (z == null) {
                    try {
                        r1.f17812b = true;
                        if (z != null) {
                            z.close();
                        }
                        return z2;
                    } catch (SQLiteFullException e) {
                        obj = e;
                    } catch (SQLiteException e2) {
                        obj = e2;
                        cursor = null;
                        sQLiteDatabase = z;
                        try {
                            if (VERSION.SDK_INT >= 11 || !(obj instanceof SQLiteDatabaseLockedException)) {
                                if (sQLiteDatabase != null && sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                                mo1828t().f17816a.m5694a("Error writing entry to local database", obj);
                                r1.f17812b = true;
                            } else {
                                SystemClock.sleep((long) i4);
                                i4 += 20;
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase == null) {
                                sQLiteDatabase.close();
                            }
                            i3++;
                            z2 = false;
                            i2 = 5;
                        } catch (Throwable th2) {
                            th = th2;
                            z = sQLiteDatabase;
                        }
                    }
                } else {
                    z.beginTransaction();
                    long j = 0;
                    cursor = z.rawQuery("select count(1) from messages", null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                j = cursor.getLong(z2);
                            }
                        } catch (SQLiteFullException e3) {
                            obj = e3;
                            cursor2 = cursor;
                        } catch (SQLiteException e22) {
                            SQLiteException sQLiteException = e22;
                            sQLiteDatabase = z;
                            if (VERSION.SDK_INT >= 11) {
                            }
                            sQLiteDatabase.endTransaction();
                            mo1828t().f17816a.m5694a("Error writing entry to local database", obj);
                            r1.f17812b = true;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase == null) {
                                sQLiteDatabase.close();
                            }
                            i3++;
                            z2 = false;
                            i2 = 5;
                        } catch (Throwable th22) {
                            th = th22;
                        }
                    }
                    if (j >= 100000) {
                        mo1828t().f17816a.m5693a("Data loss, local db full");
                        long j2 = (100000 - j) + 1;
                        j = (long) z.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j2)});
                        if (j != j2) {
                            mo1828t().f17816a.m5696a("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(j), Long.valueOf(j2 - j));
                        }
                    }
                    z.insertOrThrow("messages", null, contentValues);
                    z.setTransactionSuccessful();
                    z.endTransaction();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (z != null) {
                        z.close();
                    }
                    return true;
                }
            } catch (SQLiteFullException e32) {
                obj = e32;
                z = null;
                try {
                    mo1828t().f17816a.m5694a("Error writing entry to local database", obj);
                    r1.f17812b = true;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (z != null) {
                        z.close();
                    }
                    i3++;
                    z2 = false;
                    i2 = 5;
                } catch (Throwable th222) {
                    th = th222;
                    cursor = cursor2;
                }
            } catch (SQLiteException e222) {
                obj = e222;
                cursor = null;
                if (VERSION.SDK_INT >= 11) {
                }
                sQLiteDatabase.endTransaction();
                mo1828t().f17816a.m5694a("Error writing entry to local database", obj);
                r1.f17812b = true;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase.close();
                }
                i3++;
                z2 = false;
                i2 = 5;
            } catch (Throwable th2222) {
                th = th2222;
                z = null;
                cursor = z;
            }
        }
        mo1828t().f17818c.m5693a("Failed to write entry to local database");
        return false;
        if (cursor != null) {
            cursor.close();
        }
        if (z != null) {
            z.close();
        }
        throw th;
    }

    @android.annotation.TargetApi(11)
    public final java.util.List<com.google.android.gms.internal.zzbfm> m18109y() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r20 = this;
        r1 = r20;
        r20.mo1811c();
        r2 = r1.f17812b;
        r3 = 0;
        if (r2 == 0) goto L_0x000b;
    L_0x000a:
        return r3;
    L_0x000b:
        r2 = new java.util.ArrayList;
        r2.<init>();
        r4 = r20.mo1820l();
        r5 = "google_app_measurement_local.db";
        r4 = r4.getDatabasePath(r5);
        r4 = r4.exists();
        if (r4 != 0) goto L_0x0021;
    L_0x0020:
        return r2;
    L_0x0021:
        r4 = 5;
        r5 = 0;
        r7 = r4;
        r6 = r5;
    L_0x0025:
        if (r6 >= r4) goto L_0x01ed;
    L_0x0027:
        r8 = 1;
        r15 = r20.m18110z();	 Catch:{ SQLiteFullException -> 0x01bf, SQLiteException -> 0x0187, all -> 0x0182 }
        if (r15 != 0) goto L_0x0045;
    L_0x002e:
        r1.f17812b = r8;	 Catch:{ SQLiteFullException -> 0x0040, SQLiteException -> 0x003b, all -> 0x0036 }
        if (r15 == 0) goto L_0x0035;
    L_0x0032:
        r15.close();
    L_0x0035:
        return r3;
    L_0x0036:
        r0 = move-exception;
        r2 = r0;
        r9 = r3;
        goto L_0x01e1;
    L_0x003b:
        r0 = move-exception;
        r4 = r0;
        r9 = r3;
        goto L_0x018b;
    L_0x0040:
        r0 = move-exception;
        r4 = r0;
        r9 = r3;
        goto L_0x01c3;
    L_0x0045:
        r15.beginTransaction();	 Catch:{ SQLiteFullException -> 0x017d, SQLiteException -> 0x0178, all -> 0x0172 }
        r10 = "messages";	 Catch:{ SQLiteFullException -> 0x017d, SQLiteException -> 0x0178, all -> 0x0172 }
        r9 = "rowid";	 Catch:{ SQLiteFullException -> 0x017d, SQLiteException -> 0x0178, all -> 0x0172 }
        r11 = "type";	 Catch:{ SQLiteFullException -> 0x017d, SQLiteException -> 0x0178, all -> 0x0172 }
        r12 = "entry";	 Catch:{ SQLiteFullException -> 0x017d, SQLiteException -> 0x0178, all -> 0x0172 }
        r11 = new java.lang.String[]{r9, r11, r12};	 Catch:{ SQLiteFullException -> 0x017d, SQLiteException -> 0x0178, all -> 0x0172 }
        r12 = 0;	 Catch:{ SQLiteFullException -> 0x017d, SQLiteException -> 0x0178, all -> 0x0172 }
        r13 = 0;	 Catch:{ SQLiteFullException -> 0x017d, SQLiteException -> 0x0178, all -> 0x0172 }
        r14 = 0;	 Catch:{ SQLiteFullException -> 0x017d, SQLiteException -> 0x0178, all -> 0x0172 }
        r16 = 0;	 Catch:{ SQLiteFullException -> 0x017d, SQLiteException -> 0x0178, all -> 0x0172 }
        r17 = "rowid asc";	 Catch:{ SQLiteFullException -> 0x017d, SQLiteException -> 0x0178, all -> 0x0172 }
        r9 = 100;	 Catch:{ SQLiteFullException -> 0x017d, SQLiteException -> 0x0178, all -> 0x0172 }
        r18 = java.lang.Integer.toString(r9);	 Catch:{ SQLiteFullException -> 0x017d, SQLiteException -> 0x0178, all -> 0x0172 }
        r9 = r15;
        r4 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r9 = r9.query(r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ SQLiteFullException -> 0x016e, SQLiteException -> 0x016a, all -> 0x0168 }
        r10 = -1;
    L_0x006f:
        r12 = r9.moveToNext();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        if (r12 == 0) goto L_0x012e;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x0075:
        r10 = r9.getLong(r5);	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r12 = r9.getInt(r8);	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r13 = 2;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r14 = r9.getBlob(r13);	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        if (r12 != 0) goto L_0x00b6;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x0084:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r13 = r14.length;	 Catch:{ zzbfo -> 0x00a3 }
        r12.unmarshall(r14, r5, r13);	 Catch:{ zzbfo -> 0x00a3 }
        r12.setDataPosition(r5);	 Catch:{ zzbfo -> 0x00a3 }
        r13 = com.google.android.gms.internal.zzcha.CREATOR;	 Catch:{ zzbfo -> 0x00a3 }
        r13 = r13.createFromParcel(r12);	 Catch:{ zzbfo -> 0x00a3 }
        r13 = (com.google.android.gms.internal.zzcha) r13;	 Catch:{ zzbfo -> 0x00a3 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        if (r13 == 0) goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x009c:
        r2.add(r13);	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        goto L_0x006f;
    L_0x00a0:
        r0 = move-exception;
        r10 = r0;
        goto L_0x00b2;
    L_0x00a3:
        r13 = r20.mo1828t();	 Catch:{ all -> 0x00a0 }
        r13 = r13.f17816a;	 Catch:{ all -> 0x00a0 }
        r14 = "Failed to load event from local database";	 Catch:{ all -> 0x00a0 }
        r13.m5693a(r14);	 Catch:{ all -> 0x00a0 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x00b2:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        throw r10;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x00b6:
        if (r12 != r8) goto L_0x00eb;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x00b8:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r13 = r14.length;	 Catch:{ zzbfo -> 0x00d2 }
        r12.unmarshall(r14, r5, r13);	 Catch:{ zzbfo -> 0x00d2 }
        r12.setDataPosition(r5);	 Catch:{ zzbfo -> 0x00d2 }
        r13 = com.google.android.gms.internal.zzcln.CREATOR;	 Catch:{ zzbfo -> 0x00d2 }
        r13 = r13.createFromParcel(r12);	 Catch:{ zzbfo -> 0x00d2 }
        r13 = (com.google.android.gms.internal.zzcln) r13;	 Catch:{ zzbfo -> 0x00d2 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        goto L_0x00e1;
    L_0x00cf:
        r0 = move-exception;
        r10 = r0;
        goto L_0x00e7;
    L_0x00d2:
        r13 = r20.mo1828t();	 Catch:{ all -> 0x00cf }
        r13 = r13.f17816a;	 Catch:{ all -> 0x00cf }
        r14 = "Failed to load user property from local database";	 Catch:{ all -> 0x00cf }
        r13.m5693a(r14);	 Catch:{ all -> 0x00cf }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r13 = r3;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x00e1:
        if (r13 == 0) goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x00e3:
        r2.add(r13);	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x00e7:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        throw r10;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x00eb:
        if (r12 != r13) goto L_0x0121;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x00ed:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r13 = r14.length;	 Catch:{ zzbfo -> 0x0107 }
        r12.unmarshall(r14, r5, r13);	 Catch:{ zzbfo -> 0x0107 }
        r12.setDataPosition(r5);	 Catch:{ zzbfo -> 0x0107 }
        r13 = com.google.android.gms.internal.zzcgl.CREATOR;	 Catch:{ zzbfo -> 0x0107 }
        r13 = r13.createFromParcel(r12);	 Catch:{ zzbfo -> 0x0107 }
        r13 = (com.google.android.gms.internal.zzcgl) r13;	 Catch:{ zzbfo -> 0x0107 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        goto L_0x0116;
    L_0x0104:
        r0 = move-exception;
        r10 = r0;
        goto L_0x011d;
    L_0x0107:
        r13 = r20.mo1828t();	 Catch:{ all -> 0x0104 }
        r13 = r13.f17816a;	 Catch:{ all -> 0x0104 }
        r14 = "Failed to load user property from local database";	 Catch:{ all -> 0x0104 }
        r13.m5693a(r14);	 Catch:{ all -> 0x0104 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r13 = r3;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x0116:
        if (r13 == 0) goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x0118:
        r2.add(r13);	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x011d:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        throw r10;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x0121:
        r12 = r20.mo1828t();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r12 = r12.f17816a;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r13 = "Unknown record type in local database";	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r12.m5693a(r13);	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x012e:
        r12 = "messages";	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r13 = "rowid <= ?";	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r14 = new java.lang.String[r8];	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r10 = java.lang.Long.toString(r10);	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r14[r5] = r10;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r10 = r4.delete(r12, r13, r14);	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r11 = r2.size();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        if (r10 >= r11) goto L_0x014f;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x0144:
        r10 = r20.mo1828t();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r10 = r10.f17816a;	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r11 = "Fewer entries removed from local database than expected";	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r10.m5693a(r11);	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
    L_0x014f:
        r4.setTransactionSuccessful();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        r4.endTransaction();	 Catch:{ SQLiteFullException -> 0x0166, SQLiteException -> 0x0164, all -> 0x0160 }
        if (r9 == 0) goto L_0x015a;
    L_0x0157:
        r9.close();
    L_0x015a:
        if (r4 == 0) goto L_0x015f;
    L_0x015c:
        r4.close();
    L_0x015f:
        return r2;
    L_0x0160:
        r0 = move-exception;
        r2 = r0;
        goto L_0x01e2;
    L_0x0164:
        r0 = move-exception;
        goto L_0x016c;
    L_0x0166:
        r0 = move-exception;
        goto L_0x0170;
    L_0x0168:
        r0 = move-exception;
        goto L_0x0174;
    L_0x016a:
        r0 = move-exception;
        r9 = r3;
    L_0x016c:
        r15 = r4;
        goto L_0x017b;
    L_0x016e:
        r0 = move-exception;
        r9 = r3;
    L_0x0170:
        r15 = r4;
        goto L_0x0180;
    L_0x0172:
        r0 = move-exception;
        r4 = r15;
    L_0x0174:
        r2 = r0;
        r9 = r3;
        goto L_0x01e2;
    L_0x0178:
        r0 = move-exception;
        r4 = r15;
        r9 = r3;
    L_0x017b:
        r4 = r0;
        goto L_0x018b;
    L_0x017d:
        r0 = move-exception;
        r4 = r15;
        r9 = r3;
    L_0x0180:
        r4 = r0;
        goto L_0x01c3;
    L_0x0182:
        r0 = move-exception;
        r2 = r0;
        r4 = r3;
        r9 = r4;
        goto L_0x01e2;
    L_0x0187:
        r0 = move-exception;
        r4 = r0;
        r9 = r3;
        r15 = r9;
    L_0x018b:
        r10 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x01df }
        r11 = 11;	 Catch:{ all -> 0x01df }
        if (r10 < r11) goto L_0x019c;	 Catch:{ all -> 0x01df }
    L_0x0191:
        r10 = r4 instanceof android.database.sqlite.SQLiteDatabaseLockedException;	 Catch:{ all -> 0x01df }
        if (r10 == 0) goto L_0x019c;	 Catch:{ all -> 0x01df }
    L_0x0195:
        r10 = (long) r7;	 Catch:{ all -> 0x01df }
        android.os.SystemClock.sleep(r10);	 Catch:{ all -> 0x01df }
        r7 = r7 + 20;	 Catch:{ all -> 0x01df }
        goto L_0x01b4;	 Catch:{ all -> 0x01df }
    L_0x019c:
        if (r15 == 0) goto L_0x01a7;	 Catch:{ all -> 0x01df }
    L_0x019e:
        r10 = r15.inTransaction();	 Catch:{ all -> 0x01df }
        if (r10 == 0) goto L_0x01a7;	 Catch:{ all -> 0x01df }
    L_0x01a4:
        r15.endTransaction();	 Catch:{ all -> 0x01df }
    L_0x01a7:
        r10 = r20.mo1828t();	 Catch:{ all -> 0x01df }
        r10 = r10.f17816a;	 Catch:{ all -> 0x01df }
        r11 = "Error reading entries from local database";	 Catch:{ all -> 0x01df }
        r10.m5694a(r11, r4);	 Catch:{ all -> 0x01df }
        r1.f17812b = r8;	 Catch:{ all -> 0x01df }
    L_0x01b4:
        if (r9 == 0) goto L_0x01b9;
    L_0x01b6:
        r9.close();
    L_0x01b9:
        if (r15 == 0) goto L_0x01da;
    L_0x01bb:
        r15.close();
        goto L_0x01da;
    L_0x01bf:
        r0 = move-exception;
        r4 = r0;
        r9 = r3;
        r15 = r9;
    L_0x01c3:
        r10 = r20.mo1828t();	 Catch:{ all -> 0x01df }
        r10 = r10.f17816a;	 Catch:{ all -> 0x01df }
        r11 = "Error reading entries from local database";	 Catch:{ all -> 0x01df }
        r10.m5694a(r11, r4);	 Catch:{ all -> 0x01df }
        r1.f17812b = r8;	 Catch:{ all -> 0x01df }
        if (r9 == 0) goto L_0x01d5;
    L_0x01d2:
        r9.close();
    L_0x01d5:
        if (r15 == 0) goto L_0x01da;
    L_0x01d7:
        r15.close();
    L_0x01da:
        r6 = r6 + 1;
        r4 = 5;
        goto L_0x0025;
    L_0x01df:
        r0 = move-exception;
        r2 = r0;
    L_0x01e1:
        r4 = r15;
    L_0x01e2:
        if (r9 == 0) goto L_0x01e7;
    L_0x01e4:
        r9.close();
    L_0x01e7:
        if (r4 == 0) goto L_0x01ec;
    L_0x01e9:
        r4.close();
    L_0x01ec:
        throw r2;
    L_0x01ed:
        r2 = r20.mo1828t();
        r2 = r2.f17818c;
        r4 = "Failed to read events from database in reasonable time";
        r2.m5693a(r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzchi.y():java.util.List<com.google.android.gms.internal.zzbfm>");
    }
}
