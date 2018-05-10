package com.instabug.library.logging;

import android.content.ContentValues;
import android.database.Cursor;
import com.instabug.library.internal.storage.cache.p024a.C0683a;
import com.instabug.library.internal.storage.cache.p024a.C0685c;
import com.instabug.library.logging.InstabugLog.C0732a;
import com.instabug.library.logging.InstabugLog.C0733b;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

/* compiled from: InstabugLogDbHelper */
class C0735a {
    private static PublishSubject<List<C0733b>> f9798a;
    private static Subscription f9799b;
    private static List<C0733b> f9800c = new ArrayList();

    /* compiled from: InstabugLogDbHelper */
    static class C16541 extends Subscriber<List<C0733b>> {
        public final void m19500b() {
        }

        C16541() {
        }

        public final /* synthetic */ void a_(Object obj) {
            List list = (List) obj;
            C0735a.f9800c.clear();
            C0735a.m8297b(list);
        }

        public final void m19499a(Throwable th) {
            InstabugSDKLogger.m8357e(C0735a.class, "couldn't insert the latest logs");
        }
    }

    C0735a() {
    }

    private static void m8300e() {
        f9799b = Observable.a(new C16541(), f9798a.b(1, TimeUnit.SECONDS).a(Schedulers.d()));
    }

    private static void m8301f() {
        if (f9799b != null && !f9799b.d()) {
            f9799b.c();
        }
    }

    static synchronized void m8294a(C0733b c0733b) {
        synchronized (C0735a.class) {
            if (f9798a == null) {
                f9798a = PublishSubject.d();
                C0735a.m8300e();
            } else if (f9799b.d()) {
                C0735a.m8300e();
            }
            f9800c.add(c0733b);
            f9798a.a_(new ArrayList(f9800c));
        }
    }

    private static synchronized void m8297b(List<C0733b> list) {
        synchronized (C0735a.class) {
            C0683a.m8190a();
            C0685c b = C0683a.m8192b();
            b.f9619a.beginTransaction();
            try {
                for (C0733b c0733b : list) {
                    if (c0733b != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("log_message", c0733b.f9794a);
                        contentValues.put("log_level", c0733b.f9795b.toString());
                        contentValues.put("log_date", String.valueOf(c0733b.f9796c));
                        b.m8194a("instabug_logs", contentValues);
                    }
                }
                b.m8197a("DELETE FROM instabug_logs WHERE log_date IN (SELECT log_date FROM instabug_logs ORDER BY log_date DESC LIMIT -1 OFFSET 1000)");
                b.f9619a.setTransactionSuccessful();
                C0735a.m8301f();
            } finally {
                b.f9619a.endTransaction();
                b.m8198b();
            }
        }
    }

    private static void m8302g() {
        C0735a.m8301f();
        List arrayList = new ArrayList(f9800c);
        f9800c.clear();
        C0735a.m8297b(arrayList);
    }

    static JSONArray m8293a() {
        C0735a.m8302g();
        JSONArray jSONArray = new JSONArray();
        C0683a.m8190a();
        C0685c b = C0683a.m8192b();
        b.f9619a.beginTransaction();
        Cursor rawQuery = b.f9619a.rawQuery("SELECT * FROM instabug_logs ORDER  BY log_date DESC LIMIT 1000", null);
        try {
            if (rawQuery.moveToFirst()) {
                while (true) {
                    String string = rawQuery.getString(rawQuery.getColumnIndex("log_message"));
                    String string2 = rawQuery.getString(rawQuery.getColumnIndex("log_level"));
                    String string3 = rawQuery.getString(rawQuery.getColumnIndex("log_date"));
                    C0733b c0733b = new C0733b();
                    c0733b.f9794a = string;
                    c0733b.f9795b = C0732a.valueOf(string2.toUpperCase(Locale.ENGLISH));
                    if (StringUtility.isNumeric(string3)) {
                        c0733b.f9796c = Long.parseLong(string3);
                    } else {
                        try {
                            c0733b.f9796c = new SimpleDateFormat(InstabugLog.LOG_MESSAGE_DATE_FORMAT, Locale.US).parse(string3).getTime();
                        } catch (ParseException e) {
                            InstabugSDKLogger.m8357e(C0735a.class, e.getMessage());
                        }
                    }
                    jSONArray.put(c0733b.m8287a());
                    if (!rawQuery.moveToNext()) {
                        break;
                    }
                }
            }
            b.f9619a.setTransactionSuccessful();
            b.f9619a.endTransaction();
            if (!(rawQuery == null || rawQuery.isClosed())) {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return jSONArray;
        } finally {
            b.f9619a.endTransaction();
            if (!(rawQuery == null || rawQuery.isClosed())) {
                rawQuery.close();
                b.m8198b();
            }
        }
        return jSONArray;
    }

    static void m8296b() {
        C0735a.m8302g();
        C0683a.m8190a();
        C0685c b = C0683a.m8192b();
        b.f9619a.beginTransaction();
        try {
            b.m8199b("instabug_logs");
            b.f9619a.setTransactionSuccessful();
        } finally {
            b.f9619a.endTransaction();
            b.m8198b();
        }
    }

    static void m8298c() {
        C0735a.m8302g();
        C0683a.m8190a();
        C0685c b = C0683a.m8192b();
        b.f9619a.beginTransaction();
        try {
            b.m8197a("DELETE FROM instabug_logs WHERE log_date NOT IN ( SELECT log_date FROM instabug_logs WHERE log_date ORDER BY log_date DESC LIMIT 1000 )");
            b.f9619a.setTransactionSuccessful();
        } finally {
            b.f9619a.endTransaction();
            b.m8198b();
        }
    }
}
