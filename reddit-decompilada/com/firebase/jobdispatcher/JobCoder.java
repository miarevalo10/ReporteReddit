package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class JobCoder {
    final boolean f3854a;
    final String f3855b;

    JobCoder(String str, boolean z) {
        this.f3854a = z;
        this.f3855b = str;
    }

    public final Builder m3473a(Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("Unexpected null Bundle provided");
        }
        StringBuilder stringBuilder;
        JobTrigger a;
        StringBuilder stringBuilder2;
        RetryStrategy retryStrategy;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(this.f3855b);
        stringBuilder3.append("recurring");
        boolean z = bundle.getBoolean(stringBuilder3.toString());
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(this.f3855b);
        stringBuilder4.append("replace_current");
        boolean z2 = bundle.getBoolean(stringBuilder4.toString());
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(this.f3855b);
        stringBuilder5.append("persistent");
        int i = bundle.getInt(stringBuilder5.toString());
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append(this.f3855b);
        stringBuilder6.append("constraints");
        int[] a2 = Constraint.m3452a(bundle.getInt(stringBuilder6.toString()));
        StringBuilder stringBuilder7 = new StringBuilder();
        stringBuilder7.append(this.f3855b);
        stringBuilder7.append("trigger_type");
        switch (bundle.getInt(stringBuilder7.toString())) {
            case 1:
                stringBuilder7 = new StringBuilder();
                stringBuilder7.append(this.f3855b);
                stringBuilder7.append("window_start");
                int i2 = bundle.getInt(stringBuilder7.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.f3855b);
                stringBuilder.append("window_end");
                a = Trigger.m3504a(i2, bundle.getInt(stringBuilder.toString()));
                break;
            case 2:
                a = Trigger.f3883a;
                break;
            case 3:
                stringBuilder7 = new StringBuilder();
                stringBuilder7.append(this.f3855b);
                stringBuilder7.append("observed_uris");
                a = Trigger.m3503a(Collections.unmodifiableList(m3472a(bundle.getString(stringBuilder7.toString()))));
                break;
            default:
                if (Log.isLoggable("FJD.ExternalReceiver", 3)) {
                    Log.d("FJD.ExternalReceiver", "Unsupported trigger.");
                }
                a = null;
                break;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.f3855b);
        stringBuilder.append("retry_policy");
        int i3 = bundle.getInt(stringBuilder.toString());
        if (i3 == 1 || i3 == 2) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.f3855b);
            stringBuilder2.append("initial_backoff_seconds");
            int i4 = bundle.getInt(stringBuilder2.toString());
            StringBuilder stringBuilder8 = new StringBuilder();
            stringBuilder8.append(this.f3855b);
            stringBuilder8.append("maximum_backoff_seconds");
            retryStrategy = new RetryStrategy(i3, i4, bundle.getInt(stringBuilder8.toString()));
        } else {
            retryStrategy = RetryStrategy.f3878a;
        }
        StringBuilder stringBuilder9 = new StringBuilder();
        stringBuilder9.append(this.f3855b);
        stringBuilder9.append("tag");
        String string = bundle.getString(stringBuilder9.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.f3855b);
        stringBuilder2.append("service");
        String string2 = bundle.getString(stringBuilder2.toString());
        if (!(string == null || string2 == null || a == null)) {
            if (retryStrategy != null) {
                Builder builder = new Builder();
                builder.f3856a = string;
                builder.f3857b = string2;
                builder.f3858c = a;
                builder.f3863h = retryStrategy;
                builder.f3859d = z;
                builder.f3860e = i;
                builder.f3861f = a2;
                builder.f3864i = z2;
                if (bundle != null) {
                    builder.f3862g.putAll(bundle);
                }
                return builder;
            }
        }
        return null;
    }

    static String m3471a(List<ObservedUri> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (ObservedUri observedUri : list) {
            jSONArray.put(observedUri.f3876b);
            jSONArray2.put(observedUri.f3875a);
        }
        try {
            jSONObject.put("uri_flags", jSONArray);
            jSONObject.put("uris", jSONArray2);
            return jSONObject.toString();
        } catch (List<ObservedUri> list2) {
            throw new RuntimeException(list2);
        }
    }

    private static List<ObservedUri> m3472a(String str) {
        List<ObservedUri> arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.getJSONArray("uri_flags");
            JSONArray jSONArray = jSONObject.getJSONArray("uris");
            int length = str.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(new ObservedUri(Uri.parse(jSONArray.getString(i)), str.getInt(i)));
            }
            return arrayList;
        } catch (String str2) {
            throw new RuntimeException(str2);
        }
    }
}
