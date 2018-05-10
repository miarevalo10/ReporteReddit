package com.instabug.crash.models;

import android.content.Context;
import android.net.Uri;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.Attachment.Type;
import com.instabug.library.model.State;
import com.instabug.library.model.State.Builder;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.visualusersteps.VisualUserStepsHelper;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import rx.functions.Action1;

public class Crash implements Cacheable {
    public String f15422a;
    public String f15423b;
    public String f15424c;
    public ArrayList<Attachment> f15425d;
    public State f15426e;
    public CrashState f15427f;
    public boolean f15428g;

    public enum CrashState {
        READY_TO_BE_SENT,
        LOGS_READY_TO_BE_UPLOADED,
        ATTACHMENTS_READY_TO_BE_UPLOADED,
        NOT_AVAILABLE,
        WAITING_FOR_SCREEN_RECORDING_TO_BE_TRIMMED
    }

    public static class C0586a {
        public final Crash m8008a(Context context) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis());
            final Crash crash = new Crash(stringBuilder.toString(), new Builder(context).build(true));
            if (InstabugCore.getFeatureState(Feature.REPRO_STEPS) == Feature.State.ENABLED && InstabugCore.isReproStepsScreenshotEnabled()) {
                VisualUserStepsHelper.getVisualUserStepsFileObservable(context, crash.f15422a).a(new Action1<Uri>(this) {
                    final /* synthetic */ C0586a f15421b;

                    public final /* synthetic */ void m15329a(Object obj) {
                        crash.m15331a((Uri) obj, Type.VISUAL_USER_STEPS);
                    }
                });
            }
            return crash;
        }
    }

    public Crash() {
        this.f15427f = CrashState.NOT_AVAILABLE;
    }

    public Crash(String str, State state) {
        this();
        this.f15422a = str;
        this.f15426e = state;
        this.f15425d = new ArrayList(6);
    }

    public final Crash m15330a(Uri uri) {
        return m15331a(uri, Type.ATTACHMENT_FILE);
    }

    public final Crash m15331a(Uri uri, Type type) {
        if (uri == null) {
            InstabugSDKLogger.m8361w(this, "Adding attachment with a null Uri, ignored.");
            return this;
        }
        Attachment attachment = new Attachment();
        attachment.setName(uri.getLastPathSegment());
        attachment.setLocalPath(uri.getPath());
        attachment.setType(type);
        this.f15425d.add(attachment);
        return this;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f15422a).put("temporary_server_token", this.f15423b).put("crash_message", this.f15424c).put("crash_state", this.f15427f.toString()).put("state", this.f15426e.toJson()).put("attachments", Attachment.toJson(this.f15425d)).put("handled", this.f15428g);
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id") != null) {
            this.f15422a = jSONObject.getString("id");
        }
        if (jSONObject.has("temporary_server_token") != null) {
            this.f15423b = jSONObject.getString("temporary_server_token");
        }
        if (jSONObject.has("crash_message") != null) {
            this.f15424c = jSONObject.getString("crash_message");
        }
        if (jSONObject.has("crash_state") != null) {
            this.f15427f = CrashState.valueOf(jSONObject.getString("crash_state"));
        }
        if (jSONObject.has("state") != null) {
            str = new State();
            str.fromJson(jSONObject.getString("state"));
            this.f15426e = str;
        }
        if (jSONObject.has("attachments") != null) {
            this.f15425d = Attachment.fromJson(jSONObject.getJSONArray("attachments"));
        }
        if (jSONObject.has("handled") != null) {
            this.f15428g = jSONObject.getBoolean("handled");
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Internal Id: ");
        stringBuilder.append(this.f15422a);
        stringBuilder.append(", TemporaryServerToken:");
        stringBuilder.append(this.f15423b);
        stringBuilder.append(", crashMessage:");
        stringBuilder.append(this.f15424c);
        stringBuilder.append(", handled:");
        stringBuilder.append(this.f15428g);
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Crash)) {
            return false;
        }
        Crash crash = (Crash) obj;
        if (!String.valueOf(crash.f15422a).equals(String.valueOf(this.f15422a)) || !String.valueOf(crash.f15424c).equals(String.valueOf(this.f15424c)) || !String.valueOf(crash.f15423b).equals(String.valueOf(this.f15423b)) || crash.f15427f != this.f15427f || !crash.f15426e.equals(this.f15426e) || crash.f15428g != this.f15428g || crash.f15425d == null || crash.f15425d.size() != this.f15425d.size()) {
            return false;
        }
        for (int i = 0; i < crash.f15425d.size(); i++) {
            if (!((Attachment) crash.f15425d.get(i)).equals(this.f15425d.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f15422a != null ? this.f15422a.hashCode() : -1;
    }
}
