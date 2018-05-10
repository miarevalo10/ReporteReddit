package com.instabug.library.analytics.util;

import android.content.ContentValues;
import android.database.Cursor;
import com.instabug.library.analytics.model.Api;
import com.instabug.library.analytics.model.Api.Parameter;
import com.instabug.library.internal.storage.cache.p024a.C0683a;
import com.instabug.library.internal.storage.cache.p024a.C0685c;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: AnalyticsDatabaseHelper */
public class C0600a {
    public static void m8014a() throws JSONException {
        C0683a.m8190a();
        C0685c b = C0683a.m8192b();
        b.m8199b("sdk_event");
        b.m8198b();
    }

    public static ArrayList<Api> m8016b() throws JSONException {
        ArrayList<Api> arrayList = new ArrayList();
        C0683a.m8190a();
        C0685c b = C0683a.m8192b();
        Cursor a = b.m8195a("sdk_api", new String[]{"time_stamp", "api_name", "is_deprecated", "count", "parameters"}, null, null);
        if (a.getCount() > 0) {
            a.moveToFirst();
            do {
                Api api = new Api();
                int columnIndex = a.getColumnIndex("api_name");
                int columnIndex2 = a.getColumnIndex("time_stamp");
                int columnIndex3 = a.getColumnIndex("is_deprecated");
                int columnIndex4 = a.getColumnIndex("count");
                int columnIndex5 = a.getColumnIndex("parameters");
                api.setApiName(a.getString(columnIndex));
                api.setTimeStamp(Long.parseLong(a.getString(columnIndex2)));
                api.setDeprecated(Boolean.parseBoolean(a.getString(columnIndex3)));
                api.setCount(a.getInt(columnIndex4));
                api.setParameters(Parameter.fromJson(new JSONArray(a.getString(columnIndex5))));
                arrayList.add(api);
            } while (a.moveToNext());
        }
        a.close();
        b.m8198b();
        return arrayList;
    }

    public static void m8017c() throws JSONException {
        C0683a.m8190a();
        C0685c b = C0683a.m8192b();
        b.m8199b("sdk_api");
        b.m8198b();
    }

    public static void m8015a(Collection<Api> collection, long j) {
        C0685c c0685c = null;
        try {
            C0683a.m8190a();
            C0685c b = C0683a.m8192b();
            try {
                ContentValues contentValues = new ContentValues();
                for (Api api : collection) {
                    contentValues.put("time_stamp", Long.valueOf(j));
                    contentValues.put("api_name", api.getApiName());
                    contentValues.put("is_deprecated", Boolean.toString(api.isDeprecated()));
                    contentValues.put("count", Integer.valueOf(api.getCount()));
                    if (api.getParameters() != null) {
                        contentValues.put("parameters", Parameter.toJson(api.getParameters()).toString());
                    } else {
                        contentValues.put("parameters", Parameter.toJson(new ArrayList()).toString());
                    }
                    b.m8194a("sdk_api", contentValues);
                    contentValues.clear();
                }
                if (b != null) {
                    b.m8198b();
                }
            } catch (Exception e) {
                collection = e;
                c0685c = b;
                try {
                    InstabugSDKLogger.m8357e(C0600a.class, collection.toString());
                    if (c0685c != null) {
                        c0685c.m8198b();
                    }
                } catch (Throwable th) {
                    collection = th;
                    b = c0685c;
                    if (b != null) {
                        b.m8198b();
                    }
                    throw collection;
                }
            } catch (Throwable th2) {
                collection = th2;
                if (b != null) {
                    b.m8198b();
                }
                throw collection;
            }
        } catch (Exception e2) {
            collection = e2;
            InstabugSDKLogger.m8357e(C0600a.class, collection.toString());
            if (c0685c != null) {
                c0685c.m8198b();
            }
        }
    }
}
