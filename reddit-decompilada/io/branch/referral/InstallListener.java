package io.branch.referral;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.branch.referral.Defines.Jsonkey;
import java.net.URLDecoder;
import java.util.HashMap;

public class InstallListener extends BroadcastReceiver {
    private static String f24640a = "bnc_no_value";
    private static IInstallReferrerEvents f24641b;
    private static boolean f24642c;
    private static boolean f24643d;

    static class C21091 implements Runnable {
        C21091() {
        }

        public final void run() {
            InstallListener.m26150c();
        }
    }

    interface IInstallReferrerEvents {
        void mo5545d();
    }

    public static void m26147a(long j) {
        if (f24643d) {
            m26150c();
            return;
        }
        f24642c = true;
        new Handler().postDelayed(new C21091(), j);
    }

    public void onReceive(Context context, Intent intent) {
        intent = intent.getStringExtra("referrer");
        if (intent != null) {
            try {
                String decode = URLDecoder.decode(intent, "UTF-8");
                HashMap hashMap = new HashMap();
                for (String split : decode.split("&")) {
                    String[] split2 = split.split(Operation.EQUALS);
                    if (split2.length > 1) {
                        hashMap.put(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                    }
                }
                PrefHelper.m26151a(context);
                if (hashMap.containsKey(Jsonkey.LinkClickID.bc) != null) {
                    String str = (String) hashMap.get(Jsonkey.LinkClickID.bc);
                    f24640a = str;
                    PrefHelper.m26156a("bnc_link_click_identifier", str);
                }
                if (!(hashMap.containsKey(Jsonkey.IsFullAppConv.bc) == null || hashMap.containsKey(Jsonkey.ReferringLink.bc) == null)) {
                    PrefHelper.m26163b(Boolean.parseBoolean((String) hashMap.get(Jsonkey.IsFullAppConv.bc)));
                    PrefHelper.m26156a("bnc_app_link", (String) hashMap.get(Jsonkey.ReferringLink.bc));
                }
                if (hashMap.containsKey(Jsonkey.GoogleSearchInstallReferrer.bc) != null) {
                    PrefHelper.m26156a("bnc_google_search_install_identifier", (String) hashMap.get(Jsonkey.GoogleSearchInstallReferrer.bc));
                    PrefHelper.m26156a("bnc_google_play_install_referrer_extras", decode);
                }
                f24643d = true;
                if (f24642c != null) {
                    m26150c();
                }
            } catch (Context context2) {
                context2.printStackTrace();
            } catch (Context context22) {
                context22.printStackTrace();
                Log.w("BranchSDK", "Illegal characters in url encoded string");
            }
        }
    }

    public static String m26146a() {
        return f24640a;
    }

    private static void m26150c() {
        if (f24641b != null) {
            f24641b.mo5545d();
            f24641b = null;
            f24643d = false;
        }
    }

    public static void m26148a(IInstallReferrerEvents iInstallReferrerEvents) {
        f24641b = iInstallReferrerEvents;
    }
}
