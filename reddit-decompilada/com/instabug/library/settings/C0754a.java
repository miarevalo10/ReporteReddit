package com.instabug.library.settings;

import android.net.Uri;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.OnSdkDismissedCallback;
import com.instabug.library.OnSdkInvokedCallback;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;

/* compiled from: PerSessionSettings */
public class C0754a {
    private static C0754a f9855u;
    Locale f9856a = null;
    ArrayList<String> f9857b = new ArrayList();
    InstabugCustomTextPlaceHolder f9858c;
    public int f9859d;
    int f9860e;
    LinkedHashMap<Uri, String> f9861f = new LinkedHashMap(10);
    long f9862g;
    Runnable f9863h;
    Runnable f9864i;
    boolean f9865j;
    OnSdkDismissedCallback f9866k;
    OnSdkInvokedCallback f9867l;
    boolean f9868m = false;
    int f9869n = -2;
    boolean f9870o = false;
    boolean f9871p = false;
    boolean f9872q = false;
    boolean f9873r = false;
    int f9874s = 30000;
    boolean f9875t = true;

    private C0754a() {
    }

    public static void m8315a() {
        f9855u = new C0754a();
    }

    public static C0754a m8316b() {
        return f9855u;
    }

    public final void m8317a(Uri uri, String str) {
        if (this.f9861f.size() == 10 && !this.f9861f.containsKey(uri)) {
            this.f9861f.remove((Uri) this.f9861f.keySet().iterator().next());
        }
        this.f9861f.put(uri, str);
    }
}
