package com.instabug.bug.model;

import android.net.Uri;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.Attachment.Type;
import com.instabug.library.model.BaseReport;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import rx.functions.Action1;

public class Bug extends BaseReport implements Cacheable, Serializable {
    public String f15310a;
    public String f15311b;
    public C0478b f15312c;
    public String f15313d;
    public ArrayList<Attachment> f15314e;
    public BugState f15315f;
    public String f15316g;
    public boolean f15317h;
    public ViewHierarchyInspectionState f15318i;
    public transient List<C0477a> f15319j;
    public ArrayList<String> f15320k;
    private String f15321l;
    private State f15322m;

    public enum BugState {
        IN_PROGRESS,
        WAITING_VIDEO,
        READY_TO_BE_SENT,
        LOGS_READY_TO_BE_UPLOADED,
        ATTACHMENTS_READY_TO_BE_UPLOADED,
        NOT_AVAILABLE
    }

    public enum ViewHierarchyInspectionState {
        IN_PROGRESS,
        FAILED,
        DONE
    }

    public static class C0476a {

        class C12641 implements Action1<Uri> {
            final /* synthetic */ Bug f15308a;
            final /* synthetic */ C0476a f15309b;

            public C12641(C0476a c0476a, Bug bug) {
                this.f15309b = c0476a;
                this.f15308a = bug;
            }

            public final /* synthetic */ void m15212a(Object obj) {
                this.f15308a.m15214a((Uri) obj, Type.VISUAL_USER_STEPS);
            }
        }
    }

    public Bug() {
        this.f15315f = BugState.NOT_AVAILABLE;
        this.f15312c = C0478b.NOT_AVAILABLE;
    }

    public Bug(String str, State state, BugState bugState) {
        this.f15321l = str;
        this.f15322m = state;
        this.f15315f = bugState;
        this.f15312c = C0478b.NOT_AVAILABLE;
        this.f15314e = new ArrayList(6);
        this.f15320k = new ArrayList();
    }

    public String getId() {
        return this.f15321l;
    }

    public final Bug m15214a(Uri uri, Type type) {
        if (uri == null) {
            InstabugSDKLogger.m8361w(this, "Adding attachment with a null Uri, ignored.");
            return this;
        } else if (type == null) {
            InstabugSDKLogger.m8361w(this, "Adding attachment with a null Attachment.Type, ignored.");
            return this;
        } else {
            Attachment attachment = new Attachment();
            attachment.setName(uri.getLastPathSegment());
            attachment.setLocalPath(uri.getPath());
            attachment.setType(type);
            this.f15314e.add(attachment);
            return this;
        }
    }

    public State getState() {
        return this.f15322m;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", getId()).put("temporary_server_token", this.f15311b).put("type", this.f15312c.toString()).put("message", this.f15313d).put("bug_state", this.f15315f.toString()).put("state", getState().toJson()).put("attachments", Attachment.toJson(this.f15314e)).put("view_hierarchy", this.f15316g);
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id") != null) {
            this.f15321l = jSONObject.getString("id");
        }
        if (jSONObject.has("temporary_server_token") != null) {
            this.f15311b = jSONObject.getString("temporary_server_token");
        }
        if (jSONObject.has("type") != null) {
            str = jSONObject.getString("type");
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != -191501435) {
                if (hashCode == 97908) {
                    if (str.equals("bug") != null) {
                        obj = null;
                    }
                }
            } else if (str.equals("feedback") != null) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    str = C0478b.BUG;
                    break;
                case 1:
                    str = C0478b.FEEDBACK;
                    break;
                default:
                    str = C0478b.NOT_AVAILABLE;
                    break;
            }
            this.f15312c = str;
        }
        if (jSONObject.has("message") != null) {
            this.f15313d = jSONObject.getString("message");
        }
        if (jSONObject.has("bug_state") != null) {
            this.f15315f = BugState.valueOf(jSONObject.getString("bug_state"));
        }
        if (jSONObject.has("state") != null) {
            str = new State();
            str.fromJson(jSONObject.getString("state"));
            this.f15322m = str;
        }
        if (jSONObject.has("attachments") != null) {
            this.f15314e = Attachment.fromJson(jSONObject.getJSONArray("attachments"));
        }
        if (jSONObject.has("view_hierarchy") != null) {
            this.f15316g = jSONObject.getString("view_hierarchy");
        }
    }

    public final void m15215a(String str) {
        this.f15320k.add(str);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Internal Id: ");
        stringBuilder.append(this.f15321l);
        stringBuilder.append(", TemporaryServerToken:");
        stringBuilder.append(this.f15311b);
        stringBuilder.append(", Message:");
        stringBuilder.append(this.f15313d);
        stringBuilder.append(", Type:");
        stringBuilder.append(this.f15312c);
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Bug)) {
            return false;
        }
        Bug bug = (Bug) obj;
        if (!String.valueOf(bug.getId()).equals(String.valueOf(getId())) || !String.valueOf(bug.f15313d).equals(String.valueOf(this.f15313d)) || !String.valueOf(bug.f15311b).equals(String.valueOf(this.f15311b)) || bug.f15315f != this.f15315f || !bug.getState().equals(getState()) || bug.f15312c != this.f15312c || bug.f15314e == null || bug.f15314e.size() != this.f15314e.size()) {
            return false;
        }
        for (int i = 0; i < bug.f15314e.size(); i++) {
            if (!((Attachment) bug.f15314e.get(i)).equals(this.f15314e.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return getId() != null ? getId().hashCode() : -1;
    }

    public final int m15213a() {
        Iterator it = this.f15314e.iterator();
        int i = 0;
        while (it.hasNext()) {
            Attachment attachment = (Attachment) it.next();
            if (attachment.getType() == Type.MAIN_SCREENSHOT || attachment.getType() == Type.IMAGE || attachment.getType() == Type.VIDEO || attachment.getType() == Type.AUDIO) {
                i++;
            }
        }
        return i;
    }

    public final boolean m15216b() {
        Iterator it = this.f15314e.iterator();
        while (it.hasNext()) {
            if (((Attachment) it.next()).getType() == Type.MAIN_SCREENSHOT) {
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ BaseReport setState(State state) {
        this.f15322m = state;
        return this;
    }

    public /* synthetic */ BaseReport setId(String str) {
        this.f15321l = str;
        return this;
    }
}
