package com.birbit.android.jobqueue.persistentQueue.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.birbit.android.jobqueue.Constraint;
import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.JobHolder;
import com.birbit.android.jobqueue.JobHolder.Builder;
import com.birbit.android.jobqueue.JobQueue;
import com.birbit.android.jobqueue.config.Configuration;
import com.birbit.android.jobqueue.log.JqLog;
import com.birbit.android.jobqueue.persistentQueue.sqlite.SqlHelper.Order;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import okio.Okio;

public class SqliteJobQueue implements JobQueue {
    private DbOpenHelper f12209a;
    private final long f12210b;
    private SQLiteDatabase f12211c;
    private SqlHelper f12212d;
    private JobSerializer f12213e;
    private FileStorage f12214f;
    private final StringBuilder f12215g = new StringBuilder();
    private final WhereQueryCache f12216h;

    static class InvalidJobException extends Exception {
        InvalidJobException(String str) {
            super(str);
        }

        InvalidJobException(String str, Throwable th) {
            super(str, th);
        }
    }

    public interface JobSerializer {
        <T extends Job> T mo826a(byte[] bArr) throws IOException, ClassNotFoundException;

        byte[] mo827a(Object obj) throws IOException;
    }

    public static class JavaSerializer implements JobSerializer {
        public final byte[] mo827a(Object obj) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream;
            if (obj == null) {
                return null;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
                    obj = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return obj;
                } catch (Throwable th) {
                    obj = th;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw obj;
                }
            } catch (Throwable th2) {
                obj = th2;
                byteArrayOutputStream = null;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw obj;
            }
        }

        public final <T extends Job> T mo826a(byte[] bArr) throws IOException, ClassNotFoundException {
            ObjectInputStream objectInputStream = null;
            if (bArr != null) {
                if (bArr.length != 0) {
                    try {
                        ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(bArr));
                        try {
                            Job job = (Job) objectInputStream2.readObject();
                            objectInputStream2.close();
                            return job;
                        } catch (Throwable th) {
                            bArr = th;
                            objectInputStream = objectInputStream2;
                            if (objectInputStream != null) {
                                objectInputStream.close();
                            }
                            throw bArr;
                        }
                    } catch (Throwable th2) {
                        bArr = th2;
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        throw bArr;
                    }
                }
            }
            return null;
        }
    }

    public SqliteJobQueue(Configuration configuration, long j, JobSerializer jobSerializer) {
        String str;
        this.f12210b = j;
        Context context = configuration.f2969f;
        StringBuilder stringBuilder = new StringBuilder("jobs_");
        stringBuilder.append(configuration.f2964a);
        this.f12214f = new FileStorage(context, stringBuilder.toString());
        this.f12216h = new WhereQueryCache(j);
        context = configuration.f2969f;
        if (configuration.f2976m) {
            str = null;
        } else {
            stringBuilder = new StringBuilder("db_");
            stringBuilder.append(configuration.f2964a);
            str = stringBuilder.toString();
        }
        this.f12209a = new DbOpenHelper(context, str);
        this.f12211c = this.f12209a.getWritableDatabase();
        this.f12212d = new SqlHelper(this.f12211c, "job_holder", DbOpenHelper.f3016b.f3038a, "job_holder_tags", j);
        this.f12213e = jobSerializer;
        if (configuration.f2977n != null) {
            configuration = this.f12212d.f3056n;
            j = new StringBuilder("UPDATE job_holder SET ");
            j.append(DbOpenHelper.f3021g.f3038a);
            j.append("=?");
            configuration.execSQL(j.toString(), new Object[]{Long.valueOf(Long.MIN_VALUE)});
        }
        this.f12211c.execSQL(this.f12212d.f3047e);
        m11089c();
    }

    private void m11089c() {
        Cursor rawQuery = this.f12211c.rawQuery(this.f12212d.f3045c, null);
        Set hashSet = new HashSet();
        while (rawQuery.moveToNext()) {
            try {
                hashSet.add(rawQuery.getString(0));
            } finally {
                rawQuery.close();
            }
        }
        this.f12214f.m2579a(hashSet);
    }

    public final boolean mo809a(JobHolder jobHolder) {
        m11091e(jobHolder);
        if (jobHolder.m2519c()) {
            return m11092f(jobHolder);
        }
        SQLiteStatement a = this.f12212d.m2585a();
        a.clearBindings();
        m11086a(a, jobHolder);
        long executeInsert = a.executeInsert();
        jobHolder.m2516a(executeInsert);
        return executeInsert != -1 ? true : null;
    }

    private void m11091e(JobHolder jobHolder) {
        Closeable a;
        try {
            FileStorage fileStorage = this.f12214f;
            String str = jobHolder.f2910b;
            jobHolder = this.f12213e.mo827a(jobHolder.f2921m);
            a = Okio.a(Okio.b(fileStorage.m2581b(str)));
            a.c(jobHolder).flush();
            FileStorage.m2578a(a);
        } catch (JobHolder jobHolder2) {
            throw new RuntimeException("cannot save job to disk", jobHolder2);
        } catch (Throwable th) {
            FileStorage.m2578a(a);
        }
    }

    public final void mo808a(JobHolder jobHolder, JobHolder jobHolder2) {
        this.f12211c.beginTransaction();
        try {
            mo814c(jobHolder2);
            mo809a(jobHolder);
            this.f12211c.setTransactionSuccessful();
        } finally {
            this.f12211c.endTransaction();
        }
    }

    private boolean m11092f(JobHolder jobHolder) {
        SQLiteStatement a = this.f12212d.m2585a();
        SqlHelper sqlHelper = this.f12212d;
        if (sqlHelper.f3048f == null) {
            sqlHelper.f3055m.setLength(0);
            sqlHelper.f3055m.append("INSERT INTO job_holder_tags");
            sqlHelper.f3055m.append(" VALUES (");
            for (int i = 0; i < sqlHelper.f3061s; i++) {
                if (i != 0) {
                    sqlHelper.f3055m.append(",");
                }
                sqlHelper.f3055m.append(Operation.EMPTY_PARAM);
            }
            sqlHelper.f3055m.append(")");
            sqlHelper.f3048f = sqlHelper.f3056n.compileStatement(sqlHelper.f3055m.toString());
        }
        SQLiteStatement sQLiteStatement = sqlHelper.f3048f;
        this.f12211c.beginTransaction();
        try {
            a.clearBindings();
            m11086a(a, jobHolder);
            if (a.executeInsert() != -1) {
                for (String str : jobHolder.m2514a()) {
                    sQLiteStatement.clearBindings();
                    sQLiteStatement.bindString(DbOpenHelper.f3028n.f3040c + 1, jobHolder.f2910b);
                    sQLiteStatement.bindString(DbOpenHelper.f3029o.f3040c + 1, str);
                    sQLiteStatement.executeInsert();
                }
                this.f12211c.setTransactionSuccessful();
                this.f12211c.endTransaction();
                return true;
            }
        } catch (Throwable th) {
            this.f12211c.endTransaction();
        }
        this.f12211c.endTransaction();
        return false;
    }

    private void m11087b(String str) {
        this.f12211c.beginTransaction();
        try {
            SqlHelper sqlHelper = this.f12212d;
            if (sqlHelper.f3050h == null) {
                SQLiteDatabase sQLiteDatabase = sqlHelper.f3056n;
                StringBuilder stringBuilder = new StringBuilder("DELETE FROM ");
                stringBuilder.append(sqlHelper.f3057o);
                stringBuilder.append(" WHERE ");
                stringBuilder.append(sqlHelper.f3058p);
                stringBuilder.append(" = ?");
                sqlHelper.f3050h = sQLiteDatabase.compileStatement(stringBuilder.toString());
            }
            SQLiteStatement sQLiteStatement = sqlHelper.f3050h;
            sQLiteStatement.clearBindings();
            sQLiteStatement.bindString(1, str);
            sQLiteStatement.execute();
            sqlHelper = this.f12212d;
            if (sqlHelper.f3051i == null) {
                SQLiteDatabase sQLiteDatabase2 = sqlHelper.f3056n;
                StringBuilder stringBuilder2 = new StringBuilder("DELETE FROM ");
                stringBuilder2.append(sqlHelper.f3060r);
                stringBuilder2.append(" WHERE ");
                stringBuilder2.append(DbOpenHelper.f3028n.f3038a);
                stringBuilder2.append("= ?");
                sqlHelper.f3051i = sQLiteDatabase2.compileStatement(stringBuilder2.toString());
            }
            sQLiteStatement = sqlHelper.f3051i;
            sQLiteStatement.bindString(1, str);
            sQLiteStatement.execute();
            this.f12211c.setTransactionSuccessful();
            str = this.f12214f.m2581b(str);
            if (str.exists()) {
                str.delete();
            }
            this.f12211c.endTransaction();
        } catch (Throwable th) {
            this.f12211c.endTransaction();
        }
    }

    public final int mo805a() {
        SqlHelper sqlHelper = this.f12212d;
        if (sqlHelper.f3053k == null) {
            SQLiteDatabase sQLiteDatabase = sqlHelper.f3056n;
            StringBuilder stringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
            stringBuilder.append(sqlHelper.f3057o);
            stringBuilder.append(" WHERE ");
            stringBuilder.append(DbOpenHelper.f3022h.f3038a);
            stringBuilder.append(" != ?");
            sqlHelper.f3053k = sQLiteDatabase.compileStatement(stringBuilder.toString());
        }
        SQLiteStatement sQLiteStatement = sqlHelper.f3053k;
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, this.f12210b);
        return (int) sQLiteStatement.simpleQueryForLong();
    }

    public final int mo806a(Constraint constraint) {
        constraint = m11090e(constraint);
        SQLiteDatabase sQLiteDatabase = this.f12211c;
        StringBuilder stringBuilder = this.f12215g;
        if (constraint.f3069d == null) {
            stringBuilder.setLength(0);
            stringBuilder.append("SELECT SUM(case WHEN ");
            stringBuilder.append(DbOpenHelper.f3018d.f3038a);
            stringBuilder.append(" is null then group_cnt else 1 end) from (SELECT count(*) group_cnt, ");
            stringBuilder.append(DbOpenHelper.f3018d.f3038a);
            stringBuilder.append(" FROM job_holder WHERE ");
            stringBuilder.append(constraint.f3067b);
            stringBuilder.append(" GROUP BY ");
            stringBuilder.append(DbOpenHelper.f3018d.f3038a);
            stringBuilder.append(")");
            constraint.f3069d = sQLiteDatabase.compileStatement(stringBuilder.toString());
        } else {
            constraint.f3069d.clearBindings();
        }
        for (int i = 1; i <= constraint.f3068c.length; i++) {
            constraint.f3069d.bindString(i, constraint.f3068c[i - 1]);
        }
        return (int) constraint.f3069d.simpleQueryForLong();
    }

    public final JobHolder mo807a(String str) {
        Cursor rawQuery = this.f12211c.rawQuery(this.f12212d.f3043a, new String[]{str});
        try {
            if (!rawQuery.moveToFirst()) {
                return null;
            }
            JobHolder a = m11085a(rawQuery);
            rawQuery.close();
            return a;
        } catch (Throwable e) {
            JqLog.m2559a(e, "invalid job on findJobById", new Object[0]);
            return null;
        } finally {
            rawQuery.close();
        }
    }

    public final Set<JobHolder> mo815d(Constraint constraint) {
        constraint = m11090e(constraint);
        SqlHelper sqlHelper = this.f12212d;
        if (constraint.f3070e == null) {
            constraint.f3070e = sqlHelper.m2586a(constraint.f3067b, null, new Order[0]);
        }
        Cursor rawQuery = this.f12211c.rawQuery(constraint.f3070e, constraint.f3068c);
        Set<JobHolder> hashSet = new HashSet();
        while (rawQuery.moveToNext()) {
            try {
                hashSet.add(m11085a(rawQuery));
            } catch (Throwable e) {
                JqLog.m2559a(e, "invalid job found by tags.", new Object[0]);
            } catch (Throwable th) {
                rawQuery.close();
            }
        }
        rawQuery.close();
        return hashSet;
    }

    public final void mo816d(JobHolder jobHolder) {
        SqlHelper sqlHelper = this.f12212d;
        if (sqlHelper.f3054l == null) {
            StringBuilder stringBuilder = new StringBuilder("UPDATE ");
            stringBuilder.append(sqlHelper.f3057o);
            stringBuilder.append(" SET ");
            stringBuilder.append(DbOpenHelper.f3026l.f3038a);
            stringBuilder.append(" = 1  WHERE ");
            stringBuilder.append(sqlHelper.f3058p);
            stringBuilder.append(" = ? ");
            sqlHelper.f3054l = sqlHelper.f3056n.compileStatement(stringBuilder.toString());
        }
        SQLiteStatement sQLiteStatement = sqlHelper.f3054l;
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindString(1, jobHolder.f2910b);
        sQLiteStatement.execute();
    }

    public final com.birbit.android.jobqueue.JobHolder mo810b(com.birbit.android.jobqueue.Constraint r12) {
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
        r11 = this;
        r12 = r11.m11090e(r12);
        r0 = r11.f12212d;
        r1 = r12.f3072g;
        r2 = 2;
        r3 = 0;
        r4 = 3;
        r5 = 1;
        if (r1 != 0) goto L_0x003d;
    L_0x000e:
        r1 = r12.f3067b;
        r6 = java.lang.Integer.valueOf(r5);
        r7 = new com.birbit.android.jobqueue.persistentQueue.sqlite.SqlHelper.Order[r4];
        r8 = new com.birbit.android.jobqueue.persistentQueue.sqlite.SqlHelper$Order;
        r9 = com.birbit.android.jobqueue.persistentQueue.sqlite.DbOpenHelper.f3017c;
        r10 = com.birbit.android.jobqueue.persistentQueue.sqlite.SqlHelper.Order.Type.DESC;
        r8.<init>(r9, r10);
        r7[r3] = r8;
        r8 = new com.birbit.android.jobqueue.persistentQueue.sqlite.SqlHelper$Order;
        r9 = com.birbit.android.jobqueue.persistentQueue.sqlite.DbOpenHelper.f3020f;
        r10 = com.birbit.android.jobqueue.persistentQueue.sqlite.SqlHelper.Order.Type.ASC;
        r8.<init>(r9, r10);
        r7[r5] = r8;
        r8 = new com.birbit.android.jobqueue.persistentQueue.sqlite.SqlHelper$Order;
        r9 = com.birbit.android.jobqueue.persistentQueue.sqlite.DbOpenHelper.f3015a;
        r10 = com.birbit.android.jobqueue.persistentQueue.sqlite.SqlHelper.Order.Type.ASC;
        r8.<init>(r9, r10);
        r7[r2] = r8;
        r0 = r0.m2586a(r1, r6, r7);
        r12.f3072g = r0;
    L_0x003d:
        r0 = r12.f3072g;
    L_0x003f:
        r1 = r11.f12211c;
        r6 = r12.f3068c;
        r1 = r1.rawQuery(r0, r6);
        r6 = r1.moveToNext();	 Catch:{ InvalidJobException -> 0x00c2 }
        if (r6 != 0) goto L_0x0052;
    L_0x004d:
        r1.close();
        r12 = 0;
        return r12;
    L_0x0052:
        r6 = r11.m11085a(r1);	 Catch:{ InvalidJobException -> 0x00c2 }
        r7 = r11.f12212d;	 Catch:{ InvalidJobException -> 0x00c2 }
        r8 = r7.f3052j;	 Catch:{ InvalidJobException -> 0x00c2 }
        if (r8 != 0) goto L_0x009b;	 Catch:{ InvalidJobException -> 0x00c2 }
    L_0x005c:
        r8 = new java.lang.StringBuilder;	 Catch:{ InvalidJobException -> 0x00c2 }
        r9 = "UPDATE ";	 Catch:{ InvalidJobException -> 0x00c2 }
        r8.<init>(r9);	 Catch:{ InvalidJobException -> 0x00c2 }
        r9 = r7.f3057o;	 Catch:{ InvalidJobException -> 0x00c2 }
        r8.append(r9);	 Catch:{ InvalidJobException -> 0x00c2 }
        r9 = " SET ";	 Catch:{ InvalidJobException -> 0x00c2 }
        r8.append(r9);	 Catch:{ InvalidJobException -> 0x00c2 }
        r9 = com.birbit.android.jobqueue.persistentQueue.sqlite.DbOpenHelper.f3019e;	 Catch:{ InvalidJobException -> 0x00c2 }
        r9 = r9.f3038a;	 Catch:{ InvalidJobException -> 0x00c2 }
        r8.append(r9);	 Catch:{ InvalidJobException -> 0x00c2 }
        r9 = " = ? , ";	 Catch:{ InvalidJobException -> 0x00c2 }
        r8.append(r9);	 Catch:{ InvalidJobException -> 0x00c2 }
        r9 = com.birbit.android.jobqueue.persistentQueue.sqlite.DbOpenHelper.f3022h;	 Catch:{ InvalidJobException -> 0x00c2 }
        r9 = r9.f3038a;	 Catch:{ InvalidJobException -> 0x00c2 }
        r8.append(r9);	 Catch:{ InvalidJobException -> 0x00c2 }
        r9 = " = ?  WHERE ";	 Catch:{ InvalidJobException -> 0x00c2 }
        r8.append(r9);	 Catch:{ InvalidJobException -> 0x00c2 }
        r9 = r7.f3058p;	 Catch:{ InvalidJobException -> 0x00c2 }
        r8.append(r9);	 Catch:{ InvalidJobException -> 0x00c2 }
        r9 = " = ? ";	 Catch:{ InvalidJobException -> 0x00c2 }
        r8.append(r9);	 Catch:{ InvalidJobException -> 0x00c2 }
        r8 = r8.toString();	 Catch:{ InvalidJobException -> 0x00c2 }
        r9 = r7.f3056n;	 Catch:{ InvalidJobException -> 0x00c2 }
        r8 = r9.compileStatement(r8);	 Catch:{ InvalidJobException -> 0x00c2 }
        r7.f3052j = r8;	 Catch:{ InvalidJobException -> 0x00c2 }
    L_0x009b:
        r7 = r7.f3052j;	 Catch:{ InvalidJobException -> 0x00c2 }
        r8 = r6.f2914f;	 Catch:{ InvalidJobException -> 0x00c2 }
        r8 = r8 + r5;	 Catch:{ InvalidJobException -> 0x00c2 }
        r6.f2914f = r8;	 Catch:{ InvalidJobException -> 0x00c2 }
        r8 = r11.f12210b;	 Catch:{ InvalidJobException -> 0x00c2 }
        r6.f2917i = r8;	 Catch:{ InvalidJobException -> 0x00c2 }
        r7.clearBindings();	 Catch:{ InvalidJobException -> 0x00c2 }
        r8 = r6.f2914f;	 Catch:{ InvalidJobException -> 0x00c2 }
        r8 = (long) r8;	 Catch:{ InvalidJobException -> 0x00c2 }
        r7.bindLong(r5, r8);	 Catch:{ InvalidJobException -> 0x00c2 }
        r8 = r11.f12210b;	 Catch:{ InvalidJobException -> 0x00c2 }
        r7.bindLong(r2, r8);	 Catch:{ InvalidJobException -> 0x00c2 }
        r8 = r6.f2910b;	 Catch:{ InvalidJobException -> 0x00c2 }
        r7.bindString(r4, r8);	 Catch:{ InvalidJobException -> 0x00c2 }
        r7.execute();	 Catch:{ InvalidJobException -> 0x00c2 }
        r1.close();
        return r6;
    L_0x00c0:
        r12 = move-exception;
        goto L_0x00dc;
    L_0x00c2:
        r6 = com.birbit.android.jobqueue.persistentQueue.sqlite.DbOpenHelper.f3016b;	 Catch:{ all -> 0x00c0 }
        r6 = r6.f3040c;	 Catch:{ all -> 0x00c0 }
        r6 = r1.getString(r6);	 Catch:{ all -> 0x00c0 }
        if (r6 != 0) goto L_0x00d4;	 Catch:{ all -> 0x00c0 }
    L_0x00cc:
        r6 = "cannot find job id on a retrieved job";	 Catch:{ all -> 0x00c0 }
        r7 = new java.lang.Object[r3];	 Catch:{ all -> 0x00c0 }
        com.birbit.android.jobqueue.log.JqLog.m2561b(r6, r7);	 Catch:{ all -> 0x00c0 }
        goto L_0x00d7;	 Catch:{ all -> 0x00c0 }
    L_0x00d4:
        r11.m11087b(r6);	 Catch:{ all -> 0x00c0 }
    L_0x00d7:
        r1.close();
        goto L_0x003f;
    L_0x00dc:
        r1.close();
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.birbit.android.jobqueue.persistentQueue.sqlite.SqliteJobQueue.b(com.birbit.android.jobqueue.Constraint):com.birbit.android.jobqueue.JobHolder");
    }

    private Where m11090e(Constraint constraint) {
        int i;
        WhereQueryCache whereQueryCache = this.f12216h;
        StringBuilder stringBuilder = this.f12215g;
        boolean a = WhereQueryCache.m2591a(constraint);
        long b = WhereQueryCache.m2592b(constraint);
        Where where = a ? (Where) whereQueryCache.f3073a.get(Long.valueOf(b)) : null;
        if (where == null) {
            where = WhereQueryCache.m2590a(b, constraint, stringBuilder);
            if (a) {
                whereQueryCache.f3073a.put(Long.valueOf(b), where);
            }
        }
        where.f3068c[0] = Long.toString(constraint.f2855h);
        where.f3068c[1] = Integer.toString(constraint.f2848a);
        int i2 = 2;
        if (constraint.f2854g != null) {
            where.f3068c[2] = Long.toString(constraint.f2854g.longValue());
            i2 = 3;
        }
        if (constraint.f2849b != null) {
            for (String str : constraint.f2850c) {
                int i3 = i2 + 1;
                where.f3068c[i2] = str;
                i2 = i3;
            }
        }
        for (String str2 : constraint.f2851d) {
            i3 = i2 + 1;
            where.f3068c[i2] = str2;
            i2 = i3;
        }
        for (String str22 : constraint.f2852e) {
            i3 = i2 + 1;
            where.f3068c[i2] = str22;
            i2 = i3;
        }
        if (constraint.f2853f != null) {
            i = i2 + 1;
            where.f3068c[i2] = whereQueryCache.f3074b;
        } else {
            i = i2;
        }
        if (i == where.f3068c.length) {
            return where;
        }
        StringBuilder stringBuilder2 = new StringBuilder("something is wrong with where query cache for ");
        stringBuilder2.append(where.f3067b);
        throw new IllegalStateException(stringBuilder2.toString());
    }

    public final java.lang.Long mo813c(com.birbit.android.jobqueue.Constraint r8) {
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
        r7 = this;
        r8 = r7.m11090e(r8);
        r0 = 0;
        r1 = r7.f12211c;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r2 = r7.f12212d;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r3 = r8.f3071f;	 Catch:{ SQLiteDoneException -> 0x0095 }
        if (r3 != 0) goto L_0x0047;	 Catch:{ SQLiteDoneException -> 0x0095 }
    L_0x000d:
        r3 = com.birbit.android.jobqueue.persistentQueue.sqlite.DbOpenHelper.f3024j;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r3 = r3.f3038a;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r4 = r8.f3067b;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r3 = r2.m2587a(r3, r4);	 Catch:{ SQLiteDoneException -> 0x0095 }
        r4 = com.birbit.android.jobqueue.persistentQueue.sqlite.DbOpenHelper.f3021g;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r4 = r4.f3038a;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r5 = r8.f3067b;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r4 = r2.m2587a(r4, r5);	 Catch:{ SQLiteDoneException -> 0x0095 }
        r2 = r2.f3055m;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r5 = 0;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r2.setLength(r5);	 Catch:{ SQLiteDoneException -> 0x0095 }
        r5 = "SELECT * FROM (";	 Catch:{ SQLiteDoneException -> 0x0095 }
        r2.append(r5);	 Catch:{ SQLiteDoneException -> 0x0095 }
        r2.append(r3);	 Catch:{ SQLiteDoneException -> 0x0095 }
        r3 = " ORDER BY 1 ASC LIMIT 1) UNION SELECT * FROM (";	 Catch:{ SQLiteDoneException -> 0x0095 }
        r2.append(r3);	 Catch:{ SQLiteDoneException -> 0x0095 }
        r2.append(r4);	 Catch:{ SQLiteDoneException -> 0x0095 }
        r3 = " ORDER BY 1 ASC LIMIT 1) ORDER BY 1 ASC LIMIT 1";	 Catch:{ SQLiteDoneException -> 0x0095 }
        r2.append(r3);	 Catch:{ SQLiteDoneException -> 0x0095 }
        r2 = r2.toString();	 Catch:{ SQLiteDoneException -> 0x0095 }
        r1 = r1.compileStatement(r2);	 Catch:{ SQLiteDoneException -> 0x0095 }
        r8.f3071f = r1;	 Catch:{ SQLiteDoneException -> 0x0095 }
        goto L_0x004c;	 Catch:{ SQLiteDoneException -> 0x0095 }
    L_0x0047:
        r1 = r8.f3071f;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r1.clearBindings();	 Catch:{ SQLiteDoneException -> 0x0095 }
    L_0x004c:
        r1 = 1;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r2 = r1;	 Catch:{ SQLiteDoneException -> 0x0095 }
    L_0x004e:
        r3 = r8.f3068c;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r3 = r3.length;	 Catch:{ SQLiteDoneException -> 0x0095 }
        if (r2 > r3) goto L_0x006e;	 Catch:{ SQLiteDoneException -> 0x0095 }
    L_0x0053:
        r3 = r8.f3071f;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r4 = r8.f3068c;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r5 = r2 + -1;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r4 = r4[r5];	 Catch:{ SQLiteDoneException -> 0x0095 }
        r3.bindString(r2, r4);	 Catch:{ SQLiteDoneException -> 0x0095 }
        r3 = r8.f3071f;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r4 = r8.f3068c;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r4 = r4.length;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r4 = r4 + r2;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r6 = r8.f3068c;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r5 = r6[r5];	 Catch:{ SQLiteDoneException -> 0x0095 }
        r3.bindString(r4, r5);	 Catch:{ SQLiteDoneException -> 0x0095 }
        r2 = r2 + 1;	 Catch:{ SQLiteDoneException -> 0x0095 }
        goto L_0x004e;	 Catch:{ SQLiteDoneException -> 0x0095 }
    L_0x006e:
        r2 = r8.f3071f;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r3 = com.birbit.android.jobqueue.persistentQueue.sqlite.Where.f3065i;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r2.bindString(r1, r3);	 Catch:{ SQLiteDoneException -> 0x0095 }
        r2 = r8.f3071f;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r3 = r8.f3068c;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r3 = r3.length;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r1 = r1 + r3;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r3 = com.birbit.android.jobqueue.persistentQueue.sqlite.Where.f3064h;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r2.bindString(r1, r3);	 Catch:{ SQLiteDoneException -> 0x0095 }
        r8 = r8.f3071f;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r1 = r8.simpleQueryForLong();	 Catch:{ SQLiteDoneException -> 0x0095 }
        r3 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;	 Catch:{ SQLiteDoneException -> 0x0095 }
        r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ SQLiteDoneException -> 0x0095 }
        if (r8 != 0) goto L_0x0090;	 Catch:{ SQLiteDoneException -> 0x0095 }
    L_0x008f:
        return r0;	 Catch:{ SQLiteDoneException -> 0x0095 }
    L_0x0090:
        r8 = java.lang.Long.valueOf(r1);	 Catch:{ SQLiteDoneException -> 0x0095 }
        return r8;
    L_0x0095:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.birbit.android.jobqueue.persistentQueue.sqlite.SqliteJobQueue.c(com.birbit.android.jobqueue.Constraint):java.lang.Long");
    }

    public final void mo811b() {
        SqlHelper sqlHelper = this.f12212d;
        sqlHelper.f3056n.execSQL("DELETE FROM job_holder");
        sqlHelper.f3056n.execSQL("DELETE FROM job_holder_tags");
        sqlHelper.f3056n.execSQL("VACUUM");
        m11089c();
    }

    private JobHolder m11085a(Cursor cursor) throws InvalidJobException {
        String string = cursor.getString(DbOpenHelper.f3016b.f3040c);
        try {
            Job a = m11084a(this.f12214f.m2580a(string));
            if (a == null) {
                throw new InvalidJobException("null job");
            }
            Set c = m11088c(string);
            Builder builder = new Builder();
            builder.f2895b = Long.valueOf(cursor.getLong(DbOpenHelper.f3015a.f3040c));
            builder = builder.m2502a(cursor.getInt(DbOpenHelper.f3017c.f3040c)).m2506a(cursor.getString(DbOpenHelper.f3018d.f3040c));
            builder.f2894a = cursor.getInt(DbOpenHelper.f3019e.f3040c);
            boolean z = true;
            Builder a2 = builder.m2505a(a).m2512b(string).m2507a(c).m2508a(true);
            long j = cursor.getLong(DbOpenHelper.f3024j.f3040c);
            if (cursor.getInt(DbOpenHelper.f3025k.f3040c) != 1) {
                z = false;
            }
            return a2.m2504a(j, z).m2503a(cursor.getLong(DbOpenHelper.f3020f.f3040c)).m2511b(cursor.getLong(DbOpenHelper.f3021g.f3040c)).m2513c(cursor.getLong(DbOpenHelper.f3022h.f3040c)).m2510b(cursor.getInt(DbOpenHelper.f3023i.f3040c)).m2509a();
        } catch (Cursor cursor2) {
            throw new InvalidJobException("cannot load job from disk", cursor2);
        }
    }

    private Set<String> m11088c(String str) {
        str = this.f12211c.rawQuery(this.f12212d.f3046d, new String[]{str});
        try {
            Set<String> set;
            if (str.getCount() == 0) {
                set = Collections.EMPTY_SET;
                return set;
            }
            set = new HashSet();
            while (str.moveToNext()) {
                set.add(str.getString(0));
            }
            str.close();
            return set;
        } finally {
            str.close();
        }
    }

    private Job m11084a(byte[] bArr) {
        try {
            return this.f12213e.mo826a(bArr);
        } catch (byte[] bArr2) {
            JqLog.m2559a(bArr2, "error while deserializing job", new Object[0]);
            return null;
        }
    }

    private static void m11086a(SQLiteStatement sQLiteStatement, JobHolder jobHolder) {
        if (jobHolder.f2909a != null) {
            sQLiteStatement.bindLong(DbOpenHelper.f3015a.f3040c + 1, jobHolder.f2909a.longValue());
        }
        sQLiteStatement.bindString(DbOpenHelper.f3016b.f3040c + 1, jobHolder.f2910b);
        sQLiteStatement.bindLong(DbOpenHelper.f3017c.f3040c + 1, (long) jobHolder.f2912d);
        if (jobHolder.f2913e != null) {
            sQLiteStatement.bindString(DbOpenHelper.f3018d.f3040c + 1, jobHolder.f2913e);
        }
        sQLiteStatement.bindLong(DbOpenHelper.f3019e.f3040c + 1, (long) jobHolder.f2914f);
        sQLiteStatement.bindLong(DbOpenHelper.f3020f.f3040c + 1, jobHolder.f2916h);
        sQLiteStatement.bindLong(DbOpenHelper.f3021g.f3040c + 1, jobHolder.f2915g);
        sQLiteStatement.bindLong(DbOpenHelper.f3022h.f3040c + 1, jobHolder.f2917i);
        sQLiteStatement.bindLong(DbOpenHelper.f3023i.f3040c + 1, (long) jobHolder.f2918j);
        sQLiteStatement.bindLong(DbOpenHelper.f3024j.f3040c + 1, jobHolder.f2919k);
        long j = 0;
        sQLiteStatement.bindLong(DbOpenHelper.f3025k.f3040c + 1, jobHolder.f2920l ? 1 : 0);
        int i = DbOpenHelper.f3026l.f3040c + 1;
        if (jobHolder.f2923o != null) {
            j = 1;
        }
        sQLiteStatement.bindLong(i, j);
    }

    public final boolean mo812b(JobHolder jobHolder) {
        if (jobHolder.f2909a == null) {
            return mo809a(jobHolder);
        }
        m11091e(jobHolder);
        jobHolder.f2917i = Long.MIN_VALUE;
        SqlHelper sqlHelper = this.f12212d;
        if (sqlHelper.f3049g == null) {
            sqlHelper.f3055m.setLength(0);
            StringBuilder stringBuilder = sqlHelper.f3055m;
            stringBuilder.append("INSERT OR REPLACE INTO ");
            stringBuilder.append(sqlHelper.f3057o);
            sqlHelper.f3055m.append(" VALUES (");
            for (int i = 0; i < sqlHelper.f3059q; i++) {
                if (i != 0) {
                    sqlHelper.f3055m.append(",");
                }
                sqlHelper.f3055m.append(Operation.EMPTY_PARAM);
            }
            sqlHelper.f3055m.append(")");
            sqlHelper.f3049g = sqlHelper.f3056n.compileStatement(sqlHelper.f3055m.toString());
        }
        SQLiteStatement sQLiteStatement = sqlHelper.f3049g;
        sQLiteStatement.clearBindings();
        m11086a(sQLiteStatement, jobHolder);
        JqLog.m2558a("reinsert job result %s", Boolean.valueOf(sQLiteStatement.executeInsert() != -1 ? 1 : null));
        return sQLiteStatement.executeInsert() != -1 ? 1 : null;
    }

    public final void mo814c(JobHolder jobHolder) {
        m11087b(jobHolder.f2910b);
    }
}
