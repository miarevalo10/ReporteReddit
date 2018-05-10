package com.cookpad.puree;

import android.util.Log;
import com.cookpad.puree.exceptions.PureeNotInitializedException;
import com.cookpad.puree.outputs.PureeOutput;
import com.cookpad.puree.storage.PureeDbHelper;
import com.cookpad.puree.storage.PureeStorage;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Puree {
    private static final String f3678a = "Puree";
    private static boolean f3679b = false;
    private static Gson f3680c;
    private static PureeStorage f3681d;
    private static Map<Key, List<PureeOutput>> f3682e = new HashMap();

    public static synchronized void m3254a(PureeConfiguration pureeConfiguration) {
        synchronized (Puree.class) {
            if (f3679b) {
                Log.w(f3678a, "Puree has already initialized");
                return;
            }
            f3680c = pureeConfiguration.f3687b;
            f3681d = new PureeDbHelper(pureeConfiguration.f3686a);
            pureeConfiguration = pureeConfiguration.f3688c;
            f3682e = pureeConfiguration;
            for (Key key : pureeConfiguration.keySet()) {
                for (PureeOutput a : (List) f3682e.get(key)) {
                    a.mo1033a(f3681d);
                }
            }
            f3679b = true;
        }
    }

    public static void m3253a(JsonConvertible jsonConvertible) {
        m3256c();
        for (PureeOutput a : (List) f3682e.get(Key.m3251a(jsonConvertible.getClass()))) {
            a.mo1034a(jsonConvertible.m3250a(f3680c));
        }
    }

    public static void m3252a() {
        m3256c();
        for (Key key : f3682e.keySet()) {
            for (PureeOutput a : (List) f3682e.get(key)) {
                a.mo1032a();
            }
        }
    }

    public static void m3255b() {
        m3256c();
        f3681d.mo1037a();
    }

    private static synchronized void m3256c() {
        synchronized (Puree.class) {
            if (f3679b) {
            } else {
                throw new PureeNotInitializedException();
            }
        }
    }
}
