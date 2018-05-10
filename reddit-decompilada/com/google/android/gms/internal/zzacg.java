package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug.MemoryInfo;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Network;
import com.instabug.library.model.State;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.hockeyapp.android.UpdateFragment;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzv
public final class zzacg {
    private static final SimpleDateFormat f6104a = new SimpleDateFormat("yyyyMMdd", Locale.US);

    public static zzaax m4987a(Context context, zzaat com_google_android_gms_internal_zzaat, String str) {
        String optString;
        String str2;
        zzaat com_google_android_gms_internal_zzaat2 = com_google_android_gms_internal_zzaat;
        try {
            int b;
            int i;
            String str3;
            zzaax com_google_android_gms_internal_zzaax;
            long j;
            JSONArray optJSONArray;
            List list;
            List list2;
            List list3;
            List a;
            long j2;
            String optString2;
            boolean optBoolean;
            JSONObject jSONObject = new JSONObject(str);
            optString = jSONObject.optString("ad_base_url", null);
            Object optString3 = jSONObject.optString("ad_url", null);
            String optString4 = jSONObject.optString("ad_size", null);
            String optString5 = jSONObject.optString("ad_slot_size", optString4);
            boolean z = (com_google_android_gms_internal_zzaat2 == null || com_google_android_gms_internal_zzaat2.f17406m == 0) ? false : true;
            CharSequence optString6 = jSONObject.optString("ad_json", null);
            if (optString6 == null) {
                optString6 = jSONObject.optString("ad_html", null);
            }
            if (optString6 == null) {
                optString6 = jSONObject.optString("body", null);
            }
            if (optString6 == null && jSONObject.has("ads")) {
                optString6 = jSONObject.toString();
            }
            String optString7 = jSONObject.optString("debug_dialog", null);
            String optString8 = jSONObject.optString("debug_signals", null);
            long j3 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString9 = jSONObject.optString(State.KEY_ORIENTATION, null);
            if ("portrait".equals(optString9)) {
                b = zzbs.m4488g().mo1722b();
            } else if ("landscape".equals(optString9)) {
                b = zzbs.m4488g().mo1720a();
            } else {
                i = -1;
                if (TextUtils.isEmpty(optString6) || TextUtils.isEmpty(optString3)) {
                    optString9 = optString;
                    str3 = optString6;
                    com_google_android_gms_internal_zzaax = null;
                    j = -1;
                } else {
                    com_google_android_gms_internal_zzaax = zzacb.m17718a(com_google_android_gms_internal_zzaat2, context, com_google_android_gms_internal_zzaat2.f17404k.f17551a, optString3, null, null, null, null);
                    str2 = com_google_android_gms_internal_zzaax.f17441a;
                    optString9 = com_google_android_gms_internal_zzaax.f17442b;
                    j = com_google_android_gms_internal_zzaax.f17453m;
                    str3 = optString9;
                    optString9 = str2;
                }
                if (str3 == null) {
                    return new zzaax(0);
                }
                optJSONArray = jSONObject.optJSONArray("click_urls");
                list = com_google_android_gms_internal_zzaax != null ? null : com_google_android_gms_internal_zzaax.f17443c;
                if (optJSONArray != null) {
                    list = m4989a(optJSONArray, list);
                }
                optJSONArray = jSONObject.optJSONArray("impression_urls");
                list2 = com_google_android_gms_internal_zzaax != null ? null : com_google_android_gms_internal_zzaax.f17445e;
                if (optJSONArray != null) {
                    list2 = m4989a(optJSONArray, list2);
                }
                optJSONArray = jSONObject.optJSONArray("manual_impression_urls");
                list3 = com_google_android_gms_internal_zzaax != null ? null : com_google_android_gms_internal_zzaax.f17449i;
                a = optJSONArray == null ? m4989a(optJSONArray, list3) : list3;
                if (com_google_android_gms_internal_zzaax != null) {
                    if (com_google_android_gms_internal_zzaax.f17451k != -1) {
                        i = com_google_android_gms_internal_zzaax.f17451k;
                    }
                    if (com_google_android_gms_internal_zzaax.f17446f > 0) {
                        j2 = com_google_android_gms_internal_zzaax.f17446f;
                        optString2 = jSONObject.optString("active_view");
                        optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
                        return new zzaax(com_google_android_gms_internal_zzaat2, optString9, str3, list, list2, j2, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), a, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, optBoolean ? jSONObject.optString("ad_passback_url", null) : null, optString2, jSONObject.optBoolean("custom_render_allowed", false), z, com_google_android_gms_internal_zzaat2.f17409p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")), jSONObject.optBoolean("native_express", false), zzaeq.m17778a(jSONObject.optJSONArray("rewards")), m4989a(jSONObject.optJSONArray("video_start_urls"), null), m4989a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), zzaaz.m17702a(jSONObject.optJSONObject("auto_protection_configuration")), com_google_android_gms_internal_zzaat2.f17374G, jSONObject.optString("set_cookie", ""), m4989a(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optBoolean("render_in_browser", com_google_android_gms_internal_zzaat2.f17378K), optString5, zzaey.m17779a(jSONObject.optJSONObject("safe_browsing")), optString8, jSONObject.optBoolean("content_vertical_opted_out", true), com_google_android_gms_internal_zzaat2.f17388U, jSONObject.optBoolean("custom_close_blocked"));
                    }
                }
                j2 = j3;
                optString2 = jSONObject.optString("active_view");
                optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
                if (optBoolean) {
                }
                return new zzaax(com_google_android_gms_internal_zzaat2, optString9, str3, list, list2, j2, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), a, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, optBoolean ? jSONObject.optString("ad_passback_url", null) : null, optString2, jSONObject.optBoolean("custom_render_allowed", false), z, com_google_android_gms_internal_zzaat2.f17409p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")), jSONObject.optBoolean("native_express", false), zzaeq.m17778a(jSONObject.optJSONArray("rewards")), m4989a(jSONObject.optJSONArray("video_start_urls"), null), m4989a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), zzaaz.m17702a(jSONObject.optJSONObject("auto_protection_configuration")), com_google_android_gms_internal_zzaat2.f17374G, jSONObject.optString("set_cookie", ""), m4989a(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optBoolean("render_in_browser", com_google_android_gms_internal_zzaat2.f17378K), optString5, zzaey.m17779a(jSONObject.optJSONObject("safe_browsing")), optString8, jSONObject.optBoolean("content_vertical_opted_out", true), com_google_android_gms_internal_zzaat2.f17388U, jSONObject.optBoolean("custom_close_blocked"));
            }
            i = b;
            if (TextUtils.isEmpty(optString6)) {
            }
            optString9 = optString;
            str3 = optString6;
            com_google_android_gms_internal_zzaax = null;
            j = -1;
            if (str3 == null) {
                return new zzaax(0);
            }
            optJSONArray = jSONObject.optJSONArray("click_urls");
            if (com_google_android_gms_internal_zzaax != null) {
            }
            if (optJSONArray != null) {
                list = m4989a(optJSONArray, list);
            }
            optJSONArray = jSONObject.optJSONArray("impression_urls");
            if (com_google_android_gms_internal_zzaax != null) {
            }
            if (optJSONArray != null) {
                list2 = m4989a(optJSONArray, list2);
            }
            optJSONArray = jSONObject.optJSONArray("manual_impression_urls");
            if (com_google_android_gms_internal_zzaax != null) {
            }
            if (optJSONArray == null) {
            }
            if (com_google_android_gms_internal_zzaax != null) {
                if (com_google_android_gms_internal_zzaax.f17451k != -1) {
                    i = com_google_android_gms_internal_zzaax.f17451k;
                }
                if (com_google_android_gms_internal_zzaax.f17446f > 0) {
                    j2 = com_google_android_gms_internal_zzaax.f17446f;
                    optString2 = jSONObject.optString("active_view");
                    optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
                    if (optBoolean) {
                    }
                    return new zzaax(com_google_android_gms_internal_zzaat2, optString9, str3, list, list2, j2, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), a, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, optBoolean ? jSONObject.optString("ad_passback_url", null) : null, optString2, jSONObject.optBoolean("custom_render_allowed", false), z, com_google_android_gms_internal_zzaat2.f17409p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")), jSONObject.optBoolean("native_express", false), zzaeq.m17778a(jSONObject.optJSONArray("rewards")), m4989a(jSONObject.optJSONArray("video_start_urls"), null), m4989a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), zzaaz.m17702a(jSONObject.optJSONObject("auto_protection_configuration")), com_google_android_gms_internal_zzaat2.f17374G, jSONObject.optString("set_cookie", ""), m4989a(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optBoolean("render_in_browser", com_google_android_gms_internal_zzaat2.f17378K), optString5, zzaey.m17779a(jSONObject.optJSONObject("safe_browsing")), optString8, jSONObject.optBoolean("content_vertical_opted_out", true), com_google_android_gms_internal_zzaat2.f17388U, jSONObject.optBoolean("custom_close_blocked"));
                }
            }
            j2 = j3;
            optString2 = jSONObject.optString("active_view");
            optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
            }
            return new zzaax(com_google_android_gms_internal_zzaat2, optString9, str3, list, list2, j2, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), a, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, optBoolean ? jSONObject.optString("ad_passback_url", null) : null, optString2, jSONObject.optBoolean("custom_render_allowed", false), z, com_google_android_gms_internal_zzaat2.f17409p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")), jSONObject.optBoolean("native_express", false), zzaeq.m17778a(jSONObject.optJSONArray("rewards")), m4989a(jSONObject.optJSONArray("video_start_urls"), null), m4989a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), zzaaz.m17702a(jSONObject.optJSONObject("auto_protection_configuration")), com_google_android_gms_internal_zzaat2.f17374G, jSONObject.optString("set_cookie", ""), m4989a(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optBoolean("render_in_browser", com_google_android_gms_internal_zzaat2.f17378K), optString5, zzaey.m17779a(jSONObject.optJSONObject("safe_browsing")), optString8, jSONObject.optBoolean("content_vertical_opted_out", true), com_google_android_gms_internal_zzaat2.f17388U, jSONObject.optBoolean("custom_close_blocked"));
        } catch (JSONException e) {
            str2 = "Could not parse the inline ad response: ";
            optString = String.valueOf(e.getMessage());
            zzakb.m5371e(optString.length() != 0 ? str2.concat(optString) : new String(str2));
            return new zzaax(0);
        }
    }

    private static Integer m4988a(boolean z) {
        return Integer.valueOf(z);
    }

    private static List<String> m4989a(JSONArray jSONArray, List<String> list) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new LinkedList();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    private static JSONArray m4990a(List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public static JSONObject m4991a(Context context, zzabz com_google_android_gms_internal_zzabz) {
        zzabz com_google_android_gms_internal_zzabz2 = com_google_android_gms_internal_zzabz;
        zzaat com_google_android_gms_internal_zzaat = com_google_android_gms_internal_zzabz2.f6084i;
        Location location = com_google_android_gms_internal_zzabz2.f6079d;
        zzaco com_google_android_gms_internal_zzaco = com_google_android_gms_internal_zzabz2.f6085j;
        Bundle bundle = com_google_android_gms_internal_zzabz2.f6076a;
        JSONObject jSONObject = com_google_android_gms_internal_zzabz2.f6086k;
        String str;
        String str2;
        try {
            Object obj;
            int i;
            String str3;
            zzaat com_google_android_gms_internal_zzaat2;
            Location location2;
            Bundle bundle2;
            JSONObject jSONObject2;
            zzaco com_google_android_gms_internal_zzaco2;
            String str4;
            Object obj2;
            Object obj3;
            Map hashMap = new HashMap();
            hashMap.put("extra_caps", zzkb.m6350f().m6488a(zznh.bG));
            if (com_google_android_gms_internal_zzabz2.f6078c.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", com_google_android_gms_internal_zzabz2.f6078c));
            }
            if (com_google_android_gms_internal_zzaat.f17395b != null) {
                hashMap.put("ad_pos", com_google_android_gms_internal_zzaat.f17395b);
            }
            zzjj com_google_android_gms_internal_zzjj = com_google_android_gms_internal_zzaat.f17396c;
            String a = zzaga.m5120a();
            if (a != null) {
                hashMap.put("abf", a);
            }
            if (com_google_android_gms_internal_zzjj.f18135b != -1) {
                hashMap.put("cust_age", f6104a.format(new Date(com_google_android_gms_internal_zzjj.f18135b)));
            }
            if (com_google_android_gms_internal_zzjj.f18136c != null) {
                hashMap.put("extras", com_google_android_gms_internal_zzjj.f18136c);
            }
            int i2 = -1;
            if (com_google_android_gms_internal_zzjj.f18137d != -1) {
                hashMap.put("cust_gender", Integer.valueOf(com_google_android_gms_internal_zzjj.f18137d));
            }
            if (com_google_android_gms_internal_zzjj.f18138e != null) {
                hashMap.put("kw", com_google_android_gms_internal_zzjj.f18138e);
            }
            if (com_google_android_gms_internal_zzjj.f18140g != -1) {
                hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(com_google_android_gms_internal_zzjj.f18140g));
            }
            if (com_google_android_gms_internal_zzjj.f18139f) {
                Object valueOf;
                if (((Boolean) zzkb.m6350f().m6488a(zznh.cO)).booleanValue()) {
                    obj = "test_request";
                    valueOf = Boolean.valueOf(true);
                } else {
                    obj = "adtest";
                    valueOf = "on";
                }
                hashMap.put(obj, valueOf);
            }
            if (com_google_android_gms_internal_zzjj.f18134a >= 2) {
                if (com_google_android_gms_internal_zzjj.f18141h) {
                    hashMap.put("d_imp_hdr", Integer.valueOf(1));
                }
                if (!TextUtils.isEmpty(com_google_android_gms_internal_zzjj.f18142i)) {
                    hashMap.put("ppid", com_google_android_gms_internal_zzjj.f18142i);
                }
            }
            if (com_google_android_gms_internal_zzjj.f18134a >= 3 && com_google_android_gms_internal_zzjj.f18145l != null) {
                hashMap.put(UpdateFragment.FRAGMENT_URL, com_google_android_gms_internal_zzjj.f18145l);
            }
            if (com_google_android_gms_internal_zzjj.f18134a >= 5) {
                if (com_google_android_gms_internal_zzjj.f18147n != null) {
                    hashMap.put("custom_targeting", com_google_android_gms_internal_zzjj.f18147n);
                }
                if (com_google_android_gms_internal_zzjj.f18148o != null) {
                    hashMap.put("category_exclusions", com_google_android_gms_internal_zzjj.f18148o);
                }
                if (com_google_android_gms_internal_zzjj.f18149p != null) {
                    hashMap.put("request_agent", com_google_android_gms_internal_zzjj.f18149p);
                }
            }
            if (com_google_android_gms_internal_zzjj.f18134a >= 6 && com_google_android_gms_internal_zzjj.f18150q != null) {
                hashMap.put("request_pkg", com_google_android_gms_internal_zzjj.f18150q);
            }
            if (com_google_android_gms_internal_zzjj.f18134a >= 7) {
                hashMap.put("is_designed_for_families", Boolean.valueOf(com_google_android_gms_internal_zzjj.f18151r));
            }
            if (com_google_android_gms_internal_zzaat.f17397d.f18158g != null) {
                Object obj4 = null;
                Object obj5 = null;
                for (zzjn com_google_android_gms_internal_zzjn : com_google_android_gms_internal_zzaat.f17397d.f18158g) {
                    if (!com_google_android_gms_internal_zzjn.f18160i && r16 == null) {
                        hashMap.put("format", com_google_android_gms_internal_zzjn.f18152a);
                        obj4 = 1;
                    }
                    if (com_google_android_gms_internal_zzjn.f18160i && r17 == null) {
                        hashMap.put("fluid", "height");
                        obj5 = 1;
                    }
                    if (obj4 != null && r17 != null) {
                        break;
                    }
                }
            } else {
                hashMap.put("format", com_google_android_gms_internal_zzaat.f17397d.f18152a);
                if (com_google_android_gms_internal_zzaat.f17397d.f18160i) {
                    hashMap.put("fluid", "height");
                }
            }
            if (com_google_android_gms_internal_zzaat.f17397d.f18156e == -1) {
                hashMap.put("smart_w", "full");
            }
            if (com_google_android_gms_internal_zzaat.f17397d.f18153b == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (com_google_android_gms_internal_zzaat.f17397d.f18158g != null) {
                StringBuilder stringBuilder = new StringBuilder();
                zzjn[] com_google_android_gms_internal_zzjnArr = com_google_android_gms_internal_zzaat.f17397d.f18158g;
                int length = com_google_android_gms_internal_zzjnArr.length;
                int i3 = 0;
                Object obj6 = null;
                while (i3 < length) {
                    zzjn com_google_android_gms_internal_zzjn2 = com_google_android_gms_internal_zzjnArr[i3];
                    if (com_google_android_gms_internal_zzjn2.f18160i) {
                        obj6 = 1;
                    } else {
                        if (stringBuilder.length() != 0) {
                            stringBuilder.append("|");
                        }
                        stringBuilder.append(com_google_android_gms_internal_zzjn2.f18156e == i2 ? (int) (((float) com_google_android_gms_internal_zzjn2.f18157f) / com_google_android_gms_internal_zzaco.f6180s) : com_google_android_gms_internal_zzjn2.f18156e);
                        stringBuilder.append("x");
                        stringBuilder.append(com_google_android_gms_internal_zzjn2.f18153b == -2 ? (int) (((float) com_google_android_gms_internal_zzjn2.f18154c) / com_google_android_gms_internal_zzaco.f6180s) : com_google_android_gms_internal_zzjn2.f18153b);
                    }
                    i3++;
                    i2 = -1;
                }
                if (obj6 != null) {
                    if (stringBuilder.length() != 0) {
                        i = 0;
                        stringBuilder.insert(0, "|");
                    } else {
                        i = 0;
                    }
                    stringBuilder.insert(i, "320x50");
                }
                hashMap.put("sz", stringBuilder);
            }
            if (com_google_android_gms_internal_zzaat.f17406m != 0) {
                hashMap.put("native_version", Integer.valueOf(com_google_android_gms_internal_zzaat.f17406m));
                hashMap.put("native_templates", com_google_android_gms_internal_zzaat.f17407n);
                str3 = "native_image_orientation";
                zzpe com_google_android_gms_internal_zzpe = com_google_android_gms_internal_zzaat.f17418y;
                if (com_google_android_gms_internal_zzpe != null) {
                    switch (com_google_android_gms_internal_zzpe.f18240c) {
                        case 0:
                            break;
                        case 1:
                            obj = "portrait";
                            break;
                        case 2:
                            obj = "landscape";
                            break;
                        default:
                            obj = "not_set";
                            break;
                    }
                }
                obj = "any";
                hashMap.put(str3, obj);
                if (!com_google_android_gms_internal_zzaat.f17419z.isEmpty()) {
                    hashMap.put("native_custom_templates", com_google_android_gms_internal_zzaat.f17419z);
                }
                if (com_google_android_gms_internal_zzaat.f17394a >= 24) {
                    hashMap.put("max_num_ads", Integer.valueOf(com_google_android_gms_internal_zzaat.f17392Y));
                }
                if (!TextUtils.isEmpty(com_google_android_gms_internal_zzaat.f17390W)) {
                    try {
                        hashMap.put("native_advanced_settings", new JSONArray(com_google_android_gms_internal_zzaat.f17390W));
                    } catch (Throwable e) {
                        zzakb.m5369c("Problem creating json from native advanced settings", e);
                    }
                }
            }
            if (com_google_android_gms_internal_zzaat.f17389V != null && com_google_android_gms_internal_zzaat.f17389V.size() > 0) {
                for (Integer num : com_google_android_gms_internal_zzaat.f17389V) {
                    Object valueOf2;
                    if (num.intValue() == 2) {
                        obj = "iba";
                        valueOf2 = Boolean.valueOf(true);
                    } else if (num.intValue() == 1) {
                        obj = "ina";
                        valueOf2 = Boolean.valueOf(true);
                    }
                    hashMap.put(obj, valueOf2);
                }
            }
            if (com_google_android_gms_internal_zzaat.f17397d.f18161j) {
                hashMap.put("ene", Boolean.valueOf(true));
            }
            if (com_google_android_gms_internal_zzaat.f17382O != null) {
                hashMap.put("is_icon_ad", Boolean.valueOf(true));
                hashMap.put("icon_ad_expansion_behavior", Integer.valueOf(com_google_android_gms_internal_zzaat.f17382O.f18164a));
            }
            hashMap.put("slotname", com_google_android_gms_internal_zzaat.f17398e);
            hashMap.put("pn", com_google_android_gms_internal_zzaat.f17399f.packageName);
            if (com_google_android_gms_internal_zzaat.f17400g != null) {
                hashMap.put("vc", Integer.valueOf(com_google_android_gms_internal_zzaat.f17400g.versionCode));
            }
            hashMap.put("ms", com_google_android_gms_internal_zzabz2.f6082g);
            hashMap.put("seq_num", com_google_android_gms_internal_zzaat.f17402i);
            hashMap.put("session_id", com_google_android_gms_internal_zzaat.f17403j);
            hashMap.put("js", com_google_android_gms_internal_zzaat.f17404k.f17551a);
            zzacy com_google_android_gms_internal_zzacy = com_google_android_gms_internal_zzabz2.f6080e;
            Bundle bundle3 = com_google_android_gms_internal_zzaat.f17380M;
            Bundle bundle4 = com_google_android_gms_internal_zzabz2.f6077b;
            hashMap.put("am", Integer.valueOf(com_google_android_gms_internal_zzaco.f6162a));
            hashMap.put("cog", m4988a(com_google_android_gms_internal_zzaco.f6163b));
            hashMap.put("coh", m4988a(com_google_android_gms_internal_zzaco.f6164c));
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzaco.f6165d)) {
                hashMap.put(State.KEY_CARRIER, com_google_android_gms_internal_zzaco.f6165d);
            }
            hashMap.put("gl", com_google_android_gms_internal_zzaco.f6166e);
            if (com_google_android_gms_internal_zzaco.f6167f) {
                hashMap.put("simulator", Integer.valueOf(1));
            }
            if (com_google_android_gms_internal_zzaco.f6168g) {
                hashMap.put("is_sidewinder", Integer.valueOf(1));
            }
            hashMap.put("ma", m4988a(com_google_android_gms_internal_zzaco.f6169h));
            hashMap.put("sp", m4988a(com_google_android_gms_internal_zzaco.f6170i));
            hashMap.put("hl", com_google_android_gms_internal_zzaco.f6171j);
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzaco.f6172k)) {
                hashMap.put("mv", com_google_android_gms_internal_zzaco.f6172k);
            }
            hashMap.put("muv", Integer.valueOf(com_google_android_gms_internal_zzaco.f6174m));
            if (com_google_android_gms_internal_zzaco.f6175n != -2) {
                hashMap.put("cnt", Integer.valueOf(com_google_android_gms_internal_zzaco.f6175n));
            }
            hashMap.put("gnt", Integer.valueOf(com_google_android_gms_internal_zzaco.f6176o));
            hashMap.put("pt", Integer.valueOf(com_google_android_gms_internal_zzaco.f6177p));
            hashMap.put("rm", Integer.valueOf(com_google_android_gms_internal_zzaco.f6178q));
            hashMap.put("riv", Integer.valueOf(com_google_android_gms_internal_zzaco.f6179r));
            Bundle bundle5 = new Bundle();
            bundle5.putString("build_build", com_google_android_gms_internal_zzaco.f6187z);
            bundle5.putString("build_device", com_google_android_gms_internal_zzaco.f6160A);
            Bundle bundle6 = new Bundle();
            bundle6.putBoolean("is_charging", com_google_android_gms_internal_zzaco.f6184w);
            Bundle bundle7 = bundle3;
            bundle6.putDouble(State.KEY_BATTERY_LEVEL, com_google_android_gms_internal_zzaco.f6183v);
            bundle5.putBundle("battery", bundle6);
            Bundle bundle8 = new Bundle();
            bundle8.putInt("active_network_state", com_google_android_gms_internal_zzaco.f6186y);
            bundle8.putBoolean("active_network_metered", com_google_android_gms_internal_zzaco.f6185x);
            if (com_google_android_gms_internal_zzacy != null) {
                bundle3 = new Bundle();
                bundle3.putInt("predicted_latency_micros", com_google_android_gms_internal_zzacy.f6221a);
                bundle3.putLong("predicted_down_throughput_bps", com_google_android_gms_internal_zzacy.f6222b);
                bundle3.putLong("predicted_up_throughput_bps", com_google_android_gms_internal_zzacy.f6223c);
                bundle8.putBundle("predictions", bundle3);
            }
            bundle5.putBundle(Network.TYPE_NETWORK, bundle8);
            Bundle bundle9 = new Bundle();
            bundle9.putBoolean("is_browser_custom_tabs_capable", com_google_android_gms_internal_zzaco.f6161B);
            bundle5.putBundle("browser", bundle9);
            if (bundle7 != null) {
                str3 = "android_mem_info";
                bundle8 = new Bundle();
                com_google_android_gms_internal_zzaat2 = com_google_android_gms_internal_zzaat;
                location2 = location;
                bundle2 = bundle;
                jSONObject2 = jSONObject;
                bundle6 = bundle7;
                bundle8.putString("runtime_free", Long.toString(bundle6.getLong("runtime_free_memory", -1)));
                com_google_android_gms_internal_zzaco2 = com_google_android_gms_internal_zzaco;
                bundle8.putString("runtime_max", Long.toString(bundle6.getLong("runtime_max_memory", -1)));
                bundle8.putString("runtime_total", Long.toString(bundle6.getLong("runtime_total_memory", -1)));
                i = 0;
                bundle8.putString("web_view_count", Integer.toString(bundle6.getInt("web_view_count", 0)));
                MemoryInfo memoryInfo = (MemoryInfo) bundle6.getParcelable("debug_memory_info");
                if (memoryInfo != null) {
                    bundle8.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
                    bundle8.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
                    bundle8.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
                    bundle8.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
                    bundle8.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
                    bundle8.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
                    bundle8.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
                    bundle8.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
                    bundle8.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
                }
                bundle5.putBundle(str3, bundle8);
            } else {
                com_google_android_gms_internal_zzaat2 = com_google_android_gms_internal_zzaat;
                location2 = location;
                com_google_android_gms_internal_zzaco2 = com_google_android_gms_internal_zzaco;
                bundle2 = bundle;
                jSONObject2 = jSONObject;
                i = 0;
            }
            Bundle bundle10 = new Bundle();
            bundle10.putBundle("parental_controls", bundle4);
            zzaco com_google_android_gms_internal_zzaco3 = com_google_android_gms_internal_zzaco2;
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzaco3.f6173l)) {
                bundle10.putString("package_version", com_google_android_gms_internal_zzaco3.f6173l);
            }
            bundle5.putBundle("play_store", bundle10);
            hashMap.put(State.KEY_DEVICE, bundle5);
            bundle10 = new Bundle();
            bundle10.putString("doritos", com_google_android_gms_internal_zzabz2.f6081f);
            if (((Boolean) zzkb.m6350f().m6488a(zznh.ax)).booleanValue()) {
                Object id;
                boolean isLimitAdTrackingEnabled;
                String str5;
                if (com_google_android_gms_internal_zzabz2.f6083h != null) {
                    id = com_google_android_gms_internal_zzabz2.f6083h.getId();
                    isLimitAdTrackingEnabled = com_google_android_gms_internal_zzabz2.f6083h.isLimitAdTrackingEnabled();
                } else {
                    isLimitAdTrackingEnabled = i;
                    id = null;
                }
                if (TextUtils.isEmpty(id)) {
                    zzkb.m6345a();
                    bundle10.putString("pdid", zzajr.m5331b(context));
                    str4 = "pdidtype";
                    str5 = "ssaid";
                } else {
                    bundle10.putString("rdid", id);
                    bundle10.putBoolean("is_lat", isLimitAdTrackingEnabled);
                    str4 = "idtype";
                    str5 = "adid";
                }
                bundle10.putString(str4, str5);
            }
            hashMap.put("pii", bundle10);
            hashMap.put("platform", Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (location2 != null) {
                m4993a((HashMap) hashMap, location2);
                com_google_android_gms_internal_zzaat = com_google_android_gms_internal_zzaat2;
            } else {
                com_google_android_gms_internal_zzaat = com_google_android_gms_internal_zzaat2;
                if (com_google_android_gms_internal_zzaat.f17396c.f18134a >= 2 && com_google_android_gms_internal_zzaat.f17396c.f18144k != null) {
                    m4993a((HashMap) hashMap, com_google_android_gms_internal_zzaat.f17396c.f18144k);
                }
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 2) {
                hashMap.put("quality_signals", com_google_android_gms_internal_zzaat.f17405l);
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 4 && com_google_android_gms_internal_zzaat.f17409p) {
                hashMap.put("forceHttps", Boolean.valueOf(com_google_android_gms_internal_zzaat.f17409p));
            }
            if (bundle2 != null) {
                hashMap.put("content_info", bundle2);
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 5) {
                hashMap.put("u_sd", Float.valueOf(com_google_android_gms_internal_zzaat.f17412s));
                hashMap.put("sh", Integer.valueOf(com_google_android_gms_internal_zzaat.f17411r));
                hashMap.put("sw", Integer.valueOf(com_google_android_gms_internal_zzaat.f17410q));
            } else {
                hashMap.put("u_sd", Float.valueOf(com_google_android_gms_internal_zzaco3.f6180s));
                hashMap.put("sh", Integer.valueOf(com_google_android_gms_internal_zzaco3.f6182u));
                hashMap.put("sw", Integer.valueOf(com_google_android_gms_internal_zzaco3.f6181t));
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 6) {
                if (!TextUtils.isEmpty(com_google_android_gms_internal_zzaat.f17413t)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(com_google_android_gms_internal_zzaat.f17413t));
                    } catch (Throwable e2) {
                        zzakb.m5369c("Problem serializing view hierarchy to JSON", e2);
                    }
                }
                hashMap.put("correlation_id", Long.valueOf(com_google_android_gms_internal_zzaat.f17414u));
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 7) {
                hashMap.put("request_id", com_google_android_gms_internal_zzaat.f17415v);
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 12 && !TextUtils.isEmpty(com_google_android_gms_internal_zzaat.f17369B)) {
                hashMap.put("anchor", com_google_android_gms_internal_zzaat.f17369B);
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 13) {
                hashMap.put("android_app_volume", Float.valueOf(com_google_android_gms_internal_zzaat.f17370C));
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 18) {
                hashMap.put("android_app_muted", Boolean.valueOf(com_google_android_gms_internal_zzaat.f17376I));
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 14 && com_google_android_gms_internal_zzaat.f17371D > 0) {
                hashMap.put("target_api", Integer.valueOf(com_google_android_gms_internal_zzaat.f17371D));
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 15) {
                String str6 = "scroll_index";
                int i4 = -1;
                if (com_google_android_gms_internal_zzaat.f17372E != -1) {
                    i4 = com_google_android_gms_internal_zzaat.f17372E;
                }
                hashMap.put(str6, Integer.valueOf(i4));
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 16) {
                hashMap.put("_activity_context", Boolean.valueOf(com_google_android_gms_internal_zzaat.f17373F));
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 18) {
                if (!TextUtils.isEmpty(com_google_android_gms_internal_zzaat.f17377J)) {
                    try {
                        hashMap.put("app_settings", new JSONObject(com_google_android_gms_internal_zzaat.f17377J));
                    } catch (Throwable e22) {
                        zzakb.m5369c("Problem creating json from app settings", e22);
                    }
                }
                hashMap.put("render_in_browser", Boolean.valueOf(com_google_android_gms_internal_zzaat.f17378K));
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 18) {
                hashMap.put("android_num_video_cache_tasks", Integer.valueOf(com_google_android_gms_internal_zzaat.f17379L));
            }
            zzakd com_google_android_gms_internal_zzakd = com_google_android_gms_internal_zzaat.f17404k;
            boolean z = com_google_android_gms_internal_zzaat.f17393Z;
            boolean z2 = com_google_android_gms_internal_zzabz2.f6087l;
            boolean z3 = com_google_android_gms_internal_zzaat.ab;
            Bundle bundle11 = new Bundle();
            bundle9 = new Bundle();
            bundle9.putString("cl", "179146524");
            bundle9.putString("rapid_rc", "dev");
            bundle9.putString("rapid_rollup", HttpRequest.METHOD_HEAD);
            bundle11.putBundle("build_meta", bundle9);
            bundle11.putString("mf", Boolean.toString(((Boolean) zzkb.m6350f().m6488a(zznh.bI)).booleanValue()));
            bundle11.putBoolean("instant_app", z);
            bundle11.putBoolean("lite", com_google_android_gms_internal_zzakd.f17555e);
            bundle11.putBoolean("local_service", z2);
            bundle11.putBoolean("is_privileged_process", z3);
            hashMap.put("sdk_env", bundle11);
            hashMap.put("cache_state", jSONObject2);
            if (com_google_android_gms_internal_zzaat.f17394a >= 19) {
                hashMap.put("gct", com_google_android_gms_internal_zzaat.f17381N);
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 21 && com_google_android_gms_internal_zzaat.f17383P) {
                hashMap.put("de", "1");
            }
            if (((Boolean) zzkb.m6350f().m6488a(zznh.aF)).booleanValue()) {
                Bundle bundle12;
                boolean z4;
                Bundle bundle13;
                str = com_google_android_gms_internal_zzaat.f17397d.f18152a;
                if (!str.equals("interstitial_mb")) {
                    if (!str.equals("reward_mb")) {
                        z2 = i;
                        bundle12 = com_google_android_gms_internal_zzaat.f17384Q;
                        z4 = bundle12 == null ? true : i;
                        if (z2 && z4) {
                            bundle13 = new Bundle();
                            bundle13.putBundle("interstitial_pool", bundle12);
                            hashMap.put("counters", bundle13);
                        }
                    }
                }
                z2 = true;
                bundle12 = com_google_android_gms_internal_zzaat.f17384Q;
                if (bundle12 == null) {
                }
                bundle13 = new Bundle();
                bundle13.putBundle("interstitial_pool", bundle12);
                hashMap.put("counters", bundle13);
            }
            if (com_google_android_gms_internal_zzaat.f17385R != null) {
                hashMap.put("gmp_app_id", com_google_android_gms_internal_zzaat.f17385R);
            }
            if (com_google_android_gms_internal_zzaat.f17386S == null) {
                obj2 = "fbs_aiid";
                obj3 = "";
            } else if ("TIME_OUT".equals(com_google_android_gms_internal_zzaat.f17386S)) {
                obj2 = "sai_timeout";
                obj3 = zzkb.m6350f().m6488a(zznh.ap);
            } else {
                obj2 = "fbs_aiid";
                obj3 = com_google_android_gms_internal_zzaat.f17386S;
            }
            hashMap.put(obj2, obj3);
            if (com_google_android_gms_internal_zzaat.f17387T != null) {
                hashMap.put("fbs_aeid", com_google_android_gms_internal_zzaat.f17387T);
            }
            if (com_google_android_gms_internal_zzaat.f17394a >= 24) {
                hashMap.put("disable_ml", Boolean.valueOf(com_google_android_gms_internal_zzaat.aa));
            }
            str = (String) zzkb.m6350f().m6488a(zznh.f7865A);
            if (!(str == null || str.isEmpty())) {
                if (VERSION.SDK_INT >= ((Integer) zzkb.m6350f().m6488a(zznh.f7866B)).intValue()) {
                    HashMap hashMap2 = new HashMap();
                    String[] split = str.split(",");
                    int length2 = split.length;
                    while (i < length2) {
                        str4 = split[i];
                        hashMap2.put(str4, zzajp.m5310a(str4));
                        i++;
                    }
                    hashMap.put("video_decoders", hashMap2);
                }
            }
            if (zzakb.m5365a(2)) {
                str2 = "Ad Request JSON: ";
                str = String.valueOf(zzbs.m4486e().m5227a(hashMap).toString(2));
                zzagf.m13278a(str.length() != 0 ? str2.concat(str) : new String(str2));
            }
            return zzbs.m4486e().m5227a(hashMap);
        } catch (JSONException e3) {
            str2 = "Problem serializing ad request to JSON: ";
            str = String.valueOf(e3.getMessage());
            zzakb.m5371e(str.length() != 0 ? str2.concat(str) : new String(str2));
            return null;
        }
    }

    public static JSONObject m4992a(zzaax com_google_android_gms_internal_zzaax) throws JSONException {
        String str;
        Object obj;
        JSONObject jSONObject = new JSONObject();
        if (com_google_android_gms_internal_zzaax.f17441a != null) {
            jSONObject.put("ad_base_url", com_google_android_gms_internal_zzaax.f17441a);
        }
        if (com_google_android_gms_internal_zzaax.f17452l != null) {
            jSONObject.put("ad_size", com_google_android_gms_internal_zzaax.f17452l);
        }
        jSONObject.put("native", com_google_android_gms_internal_zzaax.f17459s);
        jSONObject.put(com_google_android_gms_internal_zzaax.f17459s ? "ad_json" : "ad_html", com_google_android_gms_internal_zzaax.f17442b);
        if (com_google_android_gms_internal_zzaax.f17454n != null) {
            jSONObject.put("debug_dialog", com_google_android_gms_internal_zzaax.f17454n);
        }
        if (com_google_android_gms_internal_zzaax.f17432L != null) {
            jSONObject.put("debug_signals", com_google_android_gms_internal_zzaax.f17432L);
        }
        if (com_google_android_gms_internal_zzaax.f17446f != -1) {
            jSONObject.put("interstitial_timeout", ((double) com_google_android_gms_internal_zzaax.f17446f) / 1000.0d);
        }
        if (com_google_android_gms_internal_zzaax.f17451k == zzbs.m4488g().mo1722b()) {
            str = State.KEY_ORIENTATION;
            obj = "portrait";
        } else {
            if (com_google_android_gms_internal_zzaax.f17451k == zzbs.m4488g().mo1720a()) {
                str = State.KEY_ORIENTATION;
                obj = "landscape";
            }
            if (com_google_android_gms_internal_zzaax.f17443c != null) {
                jSONObject.put("click_urls", m4990a(com_google_android_gms_internal_zzaax.f17443c));
            }
            if (com_google_android_gms_internal_zzaax.f17445e != null) {
                jSONObject.put("impression_urls", m4990a(com_google_android_gms_internal_zzaax.f17445e));
            }
            if (com_google_android_gms_internal_zzaax.f17449i != null) {
                jSONObject.put("manual_impression_urls", m4990a(com_google_android_gms_internal_zzaax.f17449i));
            }
            if (com_google_android_gms_internal_zzaax.f17457q != null) {
                jSONObject.put("active_view", com_google_android_gms_internal_zzaax.f17457q);
            }
            jSONObject.put("ad_is_javascript", com_google_android_gms_internal_zzaax.f17455o);
            if (com_google_android_gms_internal_zzaax.f17456p != null) {
                jSONObject.put("ad_passback_url", com_google_android_gms_internal_zzaax.f17456p);
            }
            jSONObject.put("mediation", com_google_android_gms_internal_zzaax.f17447g);
            jSONObject.put("custom_render_allowed", com_google_android_gms_internal_zzaax.f17458r);
            jSONObject.put("content_url_opted_out", com_google_android_gms_internal_zzaax.f17461u);
            jSONObject.put("content_vertical_opted_out", com_google_android_gms_internal_zzaax.f17433M);
            jSONObject.put("prefetch", com_google_android_gms_internal_zzaax.f17462v);
            if (com_google_android_gms_internal_zzaax.f17450j != -1) {
                jSONObject.put("refresh_interval_milliseconds", com_google_android_gms_internal_zzaax.f17450j);
            }
            if (com_google_android_gms_internal_zzaax.f17448h != -1) {
                jSONObject.put("mediation_config_cache_time_milliseconds", com_google_android_gms_internal_zzaax.f17448h);
            }
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzaax.f17464x)) {
                jSONObject.put("gws_query_id", com_google_android_gms_internal_zzaax.f17464x);
            }
            jSONObject.put("fluid", com_google_android_gms_internal_zzaax.f17465y ? "height" : "");
            jSONObject.put("native_express", com_google_android_gms_internal_zzaax.f17466z);
            if (com_google_android_gms_internal_zzaax.f17422B != null) {
                jSONObject.put("video_start_urls", m4990a(com_google_android_gms_internal_zzaax.f17422B));
            }
            if (com_google_android_gms_internal_zzaax.f17423C != null) {
                jSONObject.put("video_complete_urls", m4990a(com_google_android_gms_internal_zzaax.f17423C));
            }
            if (com_google_android_gms_internal_zzaax.f17421A != null) {
                zzaeq com_google_android_gms_internal_zzaeq = com_google_android_gms_internal_zzaax.f17421A;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("rb_type", com_google_android_gms_internal_zzaeq.f17534a);
                jSONObject2.put("rb_amount", com_google_android_gms_internal_zzaeq.f17535b);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject2);
                jSONObject.put("rewards", jSONArray);
            }
            jSONObject.put("use_displayed_impression", com_google_android_gms_internal_zzaax.f17424D);
            jSONObject.put("auto_protection_configuration", com_google_android_gms_internal_zzaax.f17425E);
            jSONObject.put("render_in_browser", com_google_android_gms_internal_zzaax.f17429I);
            return jSONObject;
        }
        jSONObject.put(str, obj);
        if (com_google_android_gms_internal_zzaax.f17443c != null) {
            jSONObject.put("click_urls", m4990a(com_google_android_gms_internal_zzaax.f17443c));
        }
        if (com_google_android_gms_internal_zzaax.f17445e != null) {
            jSONObject.put("impression_urls", m4990a(com_google_android_gms_internal_zzaax.f17445e));
        }
        if (com_google_android_gms_internal_zzaax.f17449i != null) {
            jSONObject.put("manual_impression_urls", m4990a(com_google_android_gms_internal_zzaax.f17449i));
        }
        if (com_google_android_gms_internal_zzaax.f17457q != null) {
            jSONObject.put("active_view", com_google_android_gms_internal_zzaax.f17457q);
        }
        jSONObject.put("ad_is_javascript", com_google_android_gms_internal_zzaax.f17455o);
        if (com_google_android_gms_internal_zzaax.f17456p != null) {
            jSONObject.put("ad_passback_url", com_google_android_gms_internal_zzaax.f17456p);
        }
        jSONObject.put("mediation", com_google_android_gms_internal_zzaax.f17447g);
        jSONObject.put("custom_render_allowed", com_google_android_gms_internal_zzaax.f17458r);
        jSONObject.put("content_url_opted_out", com_google_android_gms_internal_zzaax.f17461u);
        jSONObject.put("content_vertical_opted_out", com_google_android_gms_internal_zzaax.f17433M);
        jSONObject.put("prefetch", com_google_android_gms_internal_zzaax.f17462v);
        if (com_google_android_gms_internal_zzaax.f17450j != -1) {
            jSONObject.put("refresh_interval_milliseconds", com_google_android_gms_internal_zzaax.f17450j);
        }
        if (com_google_android_gms_internal_zzaax.f17448h != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", com_google_android_gms_internal_zzaax.f17448h);
        }
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzaax.f17464x)) {
            jSONObject.put("gws_query_id", com_google_android_gms_internal_zzaax.f17464x);
        }
        if (com_google_android_gms_internal_zzaax.f17465y) {
        }
        jSONObject.put("fluid", com_google_android_gms_internal_zzaax.f17465y ? "height" : "");
        jSONObject.put("native_express", com_google_android_gms_internal_zzaax.f17466z);
        if (com_google_android_gms_internal_zzaax.f17422B != null) {
            jSONObject.put("video_start_urls", m4990a(com_google_android_gms_internal_zzaax.f17422B));
        }
        if (com_google_android_gms_internal_zzaax.f17423C != null) {
            jSONObject.put("video_complete_urls", m4990a(com_google_android_gms_internal_zzaax.f17423C));
        }
        if (com_google_android_gms_internal_zzaax.f17421A != null) {
            zzaeq com_google_android_gms_internal_zzaeq2 = com_google_android_gms_internal_zzaax.f17421A;
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put("rb_type", com_google_android_gms_internal_zzaeq2.f17534a);
            jSONObject22.put("rb_amount", com_google_android_gms_internal_zzaeq2.f17535b);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject22);
            jSONObject.put("rewards", jSONArray2);
        }
        jSONObject.put("use_displayed_impression", com_google_android_gms_internal_zzaax.f17424D);
        jSONObject.put("auto_protection_configuration", com_google_android_gms_internal_zzaax.f17425E);
        jSONObject.put("render_in_browser", com_google_android_gms_internal_zzaax.f17429I);
        return jSONObject;
    }

    private static void m4993a(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }
}
