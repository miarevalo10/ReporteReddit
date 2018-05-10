package com.google.android.gms.ads.internal.gmsg;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzaog;
import com.google.android.gms.internal.zzaoh;
import com.google.android.gms.internal.zzaou;
import com.google.android.gms.internal.zzaow;
import com.google.android.gms.internal.zzaoy;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzje;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzwr;
import com.google.android.gms.internal.zzzv;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@zzzv
public final class zzab<T extends zzaog & zzaoh & zzaou & zzaow & zzaoy> implements zzt<T> {
    private final Context f13718a;
    private final zzcv f13719b;
    private zzakd f13720c;
    private zzq f13721d;
    private zzje f13722e;
    private zzn f13723f;
    private zzb f13724g;
    private zzw f13725h;
    private zzwr f13726i;
    private zzanh f13727j = null;

    public zzab(Context context, zzakd com_google_android_gms_internal_zzakd, zzcv com_google_android_gms_internal_zzcv, zzq com_google_android_gms_ads_internal_overlay_zzq, zzje com_google_android_gms_internal_zzje, zzb com_google_android_gms_ads_internal_gmsg_zzb, zzn com_google_android_gms_ads_internal_overlay_zzn, zzw com_google_android_gms_ads_internal_zzw, zzwr com_google_android_gms_internal_zzwr) {
        this.f13718a = context;
        this.f13720c = com_google_android_gms_internal_zzakd;
        this.f13719b = com_google_android_gms_internal_zzcv;
        this.f13721d = com_google_android_gms_ads_internal_overlay_zzq;
        this.f13722e = com_google_android_gms_internal_zzje;
        this.f13724g = com_google_android_gms_ads_internal_gmsg_zzb;
        this.f13725h = com_google_android_gms_ads_internal_zzw;
        this.f13726i = com_google_android_gms_internal_zzwr;
        this.f13723f = com_google_android_gms_ads_internal_overlay_zzn;
    }

    private final void m12743a(boolean z) {
        if (this.f13726i != null) {
            this.f13726i.m14428a(z);
        }
    }

    private static boolean m12744a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int m12745b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzbs.m4488g().mo1722b();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzbs.m4488g().mo1720a();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzbs.m4488g().mo4424c();
            }
        }
        return -1;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzaog com_google_android_gms_internal_zzaog = (zzaog) obj;
        String a = zzafi.m5105a((String) map.get("u"), com_google_android_gms_internal_zzaog.getContext());
        String str = (String) map.get("a");
        if (str == null) {
            zzakb.m5371e("Action missing from an open GMSG.");
        } else if (this.f13725h != null && !this.f13725h.m4520a()) {
            this.f13725h.m4519a(a);
        } else if ("expand".equalsIgnoreCase(str)) {
            if (((zzaoh) com_google_android_gms_internal_zzaog).mo3476z()) {
                zzakb.m5371e("Cannot expand WebView that is already expanded.");
                return;
            }
            m12743a(false);
            ((zzaou) com_google_android_gms_internal_zzaog).mo3986a(m12744a(map), m12745b(map));
        } else if ("webapp".equalsIgnoreCase(str)) {
            m12743a(false);
            if (a != null) {
                ((zzaou) com_google_android_gms_internal_zzaog).mo3987a(m12744a(map), m12745b(map), a);
            } else {
                ((zzaou) com_google_android_gms_internal_zzaog).mo3988a(m12744a(map), m12745b(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else {
            boolean z = true;
            Intent intent = null;
            Context context;
            if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
                m12743a(true);
                com_google_android_gms_internal_zzaog.getContext();
                if (TextUtils.isEmpty(a)) {
                    zzakb.m5371e("Destination url cannot be empty.");
                    return;
                }
                context = com_google_android_gms_internal_zzaog.getContext();
                zzcv y = ((zzaow) com_google_android_gms_internal_zzaog).mo3475y();
                zzaoy com_google_android_gms_internal_zzaoy = (zzaoy) com_google_android_gms_internal_zzaog;
                if (com_google_android_gms_internal_zzaoy == null) {
                    throw null;
                }
                zzac com_google_android_gms_ads_internal_gmsg_zzac = new zzac(context, y, (View) com_google_android_gms_internal_zzaoy);
                ActivityManager activityManager = (ActivityManager) com_google_android_gms_ads_internal_gmsg_zzac.f5423a.getSystemService("activity");
                String str2 = (String) map.get("u");
                if (!TextUtils.isEmpty(str2)) {
                    String str3;
                    ArrayList arrayList;
                    Intent a2;
                    ResolveInfo a3;
                    List<RunningAppProcessInfo> runningAppProcesses;
                    ArrayList arrayList2;
                    int size;
                    int i;
                    Object obj2;
                    ResolveInfo resolveInfo;
                    zzbs.m4486e();
                    Uri parse = Uri.parse(zzahn.m5159a(com_google_android_gms_ads_internal_gmsg_zzac.f5423a, com_google_android_gms_ads_internal_gmsg_zzac.f5424b, str2, com_google_android_gms_ads_internal_gmsg_zzac.f5425c, null));
                    boolean parseBoolean = Boolean.parseBoolean((String) map.get("use_first_package"));
                    boolean parseBoolean2 = Boolean.parseBoolean((String) map.get("use_running_process"));
                    if (Boolean.parseBoolean((String) map.get("use_custom_tabs")) == null) {
                        if (((Boolean) zzkb.m6350f().m6488a(zznh.cw)).booleanValue() == null) {
                            z = false;
                        }
                    }
                    if ("http".equalsIgnoreCase(parse.getScheme()) != null) {
                        map = parse.buildUpon();
                        str3 = "https";
                    } else {
                        if ("https".equalsIgnoreCase(parse.getScheme()) != null) {
                            map = parse.buildUpon();
                            str3 = "http";
                        }
                        arrayList = new ArrayList();
                        a2 = zzac.m4418a(parse);
                        intent = zzac.m4418a(r4);
                        if (z) {
                            zzbs.m4486e();
                            zzahn.m5191b(com_google_android_gms_ads_internal_gmsg_zzac.f5423a, a2);
                            zzbs.m4486e();
                            zzahn.m5191b(com_google_android_gms_ads_internal_gmsg_zzac.f5423a, intent);
                        }
                        a3 = com_google_android_gms_ads_internal_gmsg_zzac.m4420a(a2, arrayList);
                        if (a3 == null) {
                            intent = zzac.m4417a(a2, a3);
                        } else {
                            if (intent != null) {
                                a3 = com_google_android_gms_ads_internal_gmsg_zzac.m4419a(intent);
                                if (a3 != null) {
                                    intent = zzac.m4417a(a2, a3);
                                    if (com_google_android_gms_ads_internal_gmsg_zzac.m4419a(intent) != null) {
                                    }
                                }
                            }
                            if (arrayList.size() != 0) {
                                if (parseBoolean2 && activityManager != null) {
                                    runningAppProcesses = activityManager.getRunningAppProcesses();
                                    if (runningAppProcesses != null) {
                                        arrayList2 = arrayList;
                                        size = arrayList2.size();
                                        i = 0;
                                        loop0:
                                        while (i < size) {
                                            obj2 = arrayList2.get(i);
                                            i++;
                                            resolveInfo = (ResolveInfo) obj2;
                                            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                                                if (runningAppProcessInfo.processName.equals(resolveInfo.activityInfo.packageName)) {
                                                    intent = zzac.m4417a(a2, resolveInfo);
                                                    break loop0;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (parseBoolean) {
                                    intent = zzac.m4417a(a2, (ResolveInfo) arrayList.get(0));
                                }
                            }
                            intent = a2;
                        }
                    }
                    Uri build = map.scheme(str3).build();
                    arrayList = new ArrayList();
                    a2 = zzac.m4418a(parse);
                    intent = zzac.m4418a(build);
                    if (z) {
                        zzbs.m4486e();
                        zzahn.m5191b(com_google_android_gms_ads_internal_gmsg_zzac.f5423a, a2);
                        zzbs.m4486e();
                        zzahn.m5191b(com_google_android_gms_ads_internal_gmsg_zzac.f5423a, intent);
                    }
                    a3 = com_google_android_gms_ads_internal_gmsg_zzac.m4420a(a2, arrayList);
                    if (a3 == null) {
                        if (intent != null) {
                            a3 = com_google_android_gms_ads_internal_gmsg_zzac.m4419a(intent);
                            if (a3 != null) {
                                intent = zzac.m4417a(a2, a3);
                                if (com_google_android_gms_ads_internal_gmsg_zzac.m4419a(intent) != null) {
                                }
                            }
                        }
                        if (arrayList.size() != 0) {
                            runningAppProcesses = activityManager.getRunningAppProcesses();
                            if (runningAppProcesses != null) {
                                arrayList2 = arrayList;
                                size = arrayList2.size();
                                i = 0;
                                loop0:
                                while (i < size) {
                                    obj2 = arrayList2.get(i);
                                    i++;
                                    resolveInfo = (ResolveInfo) obj2;
                                    while (r8.hasNext()) {
                                        if (runningAppProcessInfo.processName.equals(resolveInfo.activityInfo.packageName)) {
                                            intent = zzac.m4417a(a2, resolveInfo);
                                            break loop0;
                                        }
                                    }
                                }
                            }
                            if (parseBoolean) {
                                intent = zzac.m4417a(a2, (ResolveInfo) arrayList.get(0));
                            }
                        }
                        intent = a2;
                    } else {
                        intent = zzac.m4417a(a2, a3);
                    }
                }
                try {
                    ((zzaou) com_google_android_gms_internal_zzaog).mo3979a(new zzc(intent));
                    return;
                } catch (Object obj3) {
                    zzakb.m5371e(obj3.getMessage());
                    return;
                }
            }
            Intent parseUri;
            String str4;
            Uri data;
            Context context2;
            zzcv y2;
            zzaoy com_google_android_gms_internal_zzaoy2;
            zzcv y3;
            zzaoy com_google_android_gms_internal_zzaoy3;
            m12743a(true);
            str = (String) map.get("intent_url");
            if (!TextUtils.isEmpty(str)) {
                try {
                    parseUri = Intent.parseUri(str, 0);
                } catch (Throwable e) {
                    str4 = "Error parsing the url: ";
                    str = String.valueOf(str);
                    zzakb.m5367b(str.length() != 0 ? str4.concat(str) : new String(str4), e);
                }
                if (!(parseUri == null || parseUri.getData() == null)) {
                    data = parseUri.getData();
                    str4 = data.toString();
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            zzbs.m4486e();
                            context2 = com_google_android_gms_internal_zzaog.getContext();
                            y2 = ((zzaow) com_google_android_gms_internal_zzaog).mo3475y();
                            com_google_android_gms_internal_zzaoy2 = (zzaoy) com_google_android_gms_internal_zzaog;
                            if (com_google_android_gms_internal_zzaoy2 != null) {
                                throw null;
                            }
                            str4 = zzahn.m5159a(context2, y2, str4, (View) com_google_android_gms_internal_zzaoy2, com_google_android_gms_internal_zzaog.mo3467d());
                            try {
                                data = Uri.parse(str4);
                            } catch (Throwable e2) {
                                String str5 = "Error parsing the uri: ";
                                str4 = String.valueOf(str4);
                                zzakb.m5367b(str4.length() != 0 ? str5.concat(str4) : new String(str5), e2);
                                zzbs.m4490i().m13246a(e2, "OpenGmsgHandler.onGmsg");
                            }
                        } catch (Throwable e22) {
                            zzakb.m5367b("Error occurred while adding signals.", e22);
                            zzbs.m4490i().m13246a(e22, "OpenGmsgHandler.onGmsg");
                        }
                    }
                    parseUri.setData(data);
                }
                if (parseUri == null) {
                    ((zzaou) com_google_android_gms_internal_zzaog).mo3979a(new zzc(parseUri));
                }
                if (!TextUtils.isEmpty(a)) {
                    zzbs.m4486e();
                    context = com_google_android_gms_internal_zzaog.getContext();
                    y3 = ((zzaow) com_google_android_gms_internal_zzaog).mo3475y();
                    com_google_android_gms_internal_zzaoy3 = (zzaoy) com_google_android_gms_internal_zzaog;
                    if (com_google_android_gms_internal_zzaoy3 != null) {
                        throw null;
                    }
                    a = zzahn.m5159a(context, y3, a, (View) com_google_android_gms_internal_zzaoy3, com_google_android_gms_internal_zzaog.mo3467d());
                }
                ((zzaou) com_google_android_gms_internal_zzaog).mo3979a(new zzc((String) map.get("i"), a, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
                return;
            }
            parseUri = null;
            data = parseUri.getData();
            str4 = data.toString();
            if (TextUtils.isEmpty(str4)) {
                zzbs.m4486e();
                context2 = com_google_android_gms_internal_zzaog.getContext();
                y2 = ((zzaow) com_google_android_gms_internal_zzaog).mo3475y();
                com_google_android_gms_internal_zzaoy2 = (zzaoy) com_google_android_gms_internal_zzaog;
                if (com_google_android_gms_internal_zzaoy2 != null) {
                    str4 = zzahn.m5159a(context2, y2, str4, (View) com_google_android_gms_internal_zzaoy2, com_google_android_gms_internal_zzaog.mo3467d());
                    data = Uri.parse(str4);
                } else {
                    throw null;
                }
            }
            parseUri.setData(data);
            if (parseUri == null) {
                if (TextUtils.isEmpty(a)) {
                    zzbs.m4486e();
                    context = com_google_android_gms_internal_zzaog.getContext();
                    y3 = ((zzaow) com_google_android_gms_internal_zzaog).mo3475y();
                    com_google_android_gms_internal_zzaoy3 = (zzaoy) com_google_android_gms_internal_zzaog;
                    if (com_google_android_gms_internal_zzaoy3 != null) {
                        a = zzahn.m5159a(context, y3, a, (View) com_google_android_gms_internal_zzaoy3, com_google_android_gms_internal_zzaog.mo3467d());
                    } else {
                        throw null;
                    }
                }
                ((zzaou) com_google_android_gms_internal_zzaog).mo3979a(new zzc((String) map.get("i"), a, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
                return;
            }
            ((zzaou) com_google_android_gms_internal_zzaog).mo3979a(new zzc(parseUri));
        }
    }
}
