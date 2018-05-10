package com.instabug.chat.model;

import com.instabug.library.internal.storage.cache.Cacheable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Message implements Cacheable, Serializable {
    public String f15377a;
    public String f15378b;
    public String f15379c;
    public String f15380d;
    public String f15381e;
    public long f15382f;
    public boolean f15383g;
    public ArrayList<Attachment> f15384h;
    public ArrayList<C1308b> f15385i;
    public MessageState f15386j;
    private long f15387k;
    private C0547b f15388l;

    public enum MessageState {
        STAY_OFFLINE,
        READY_TO_BE_SENT,
        SENT,
        READY_TO_BE_SYNCED,
        SYNCED,
        NOT_AVAILABLE
    }

    public static class C0546a implements Serializable, Comparator<Message> {
        private int f9261a = 2;

        public /* synthetic */ int compare(Object obj, Object obj2) {
            Message message = (Message) obj;
            Message message2 = (Message) obj2;
            switch (this.f9261a) {
                case 1:
                    return message.f15378b.compareTo(message2.f15378b);
                case 2:
                    return new Date(message.f15382f).compareTo(new Date(message2.f15382f));
                default:
                    throw new IllegalStateException("Message comparator wasn't provided comparison messageIssueType");
            }
        }

        public C0546a(int i) {
            this.f9261a = i;
        }
    }

    public enum C0547b {
        INBOUND("inbound"),
        OUTBOUND("outbound"),
        NOT_AVAILABLE("not-available");
        
        private final String f9266d;

        private C0547b(String str) {
            this.f9266d = str;
        }

        public final String toString() {
            return this.f9266d;
        }
    }

    public Message() {
        this(String.valueOf(System.currentTimeMillis()));
    }

    public Message(String str) {
        this.f15377a = str;
        this.f15384h = new ArrayList();
        this.f15385i = new ArrayList();
        this.f15388l = C0547b.NOT_AVAILABLE;
        this.f15386j = MessageState.NOT_AVAILABLE;
    }

    public static JSONArray m15278a(ArrayList<Message> arrayList) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(new JSONObject(((Message) arrayList.get(i)).toJson()));
        }
        return jSONArray;
    }

    public static ArrayList<Message> m15277a(JSONArray jSONArray) throws JSONException {
        ArrayList<Message> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Message message = new Message();
            message.fromJson(jSONArray.getJSONObject(i).toString());
            arrayList.add(message);
        }
        return arrayList;
    }

    public final Message m15279a(long j) {
        this.f15387k = j;
        if (j != 0) {
            this.f15383g = 1;
        }
        return this;
    }

    public final Message m15280a(C0547b c0547b) {
        this.f15388l = c0547b;
        if (c0547b == C0547b.INBOUND) {
            this.f15383g = true;
        }
        return this;
    }

    public final boolean m15281a() {
        return this.f15388l != null && this.f15388l == C0547b.INBOUND;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f15377a).put("chat_id", this.f15378b).put("body", this.f15379c).put("sender_name", this.f15380d).put("sender_avatar_url", this.f15381e).put("messaged_at", this.f15382f).put("read", this.f15383g).put("read_at", this.f15387k).put("messages_state", this.f15386j.toString()).put("direction", this.f15388l.toString()).put("attachments", Attachment.toJson(this.f15384h)).put("actions", C1308b.m15283a(this.f15385i));
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id") != null) {
            this.f15377a = jSONObject.getString("id");
        }
        if (jSONObject.has("chat_id") != null) {
            this.f15378b = jSONObject.getString("chat_id");
        }
        if (jSONObject.has("body") != null) {
            this.f15379c = jSONObject.getString("body");
        }
        if (jSONObject.has("sender_name") != null) {
            this.f15380d = jSONObject.getString("sender_name");
        }
        if (jSONObject.has("sender_avatar_url") != null) {
            this.f15381e = jSONObject.getString("sender_avatar_url");
        }
        if (jSONObject.has("messaged_at") != null) {
            this.f15382f = jSONObject.getLong("messaged_at");
        }
        if (jSONObject.has("read") != null) {
            this.f15383g = jSONObject.getBoolean("read");
        }
        if (jSONObject.has("read_at") != null) {
            m15279a(jSONObject.getLong("read_at"));
        }
        if (jSONObject.has("attachments") != null) {
            this.f15384h = Attachment.fromJson(jSONObject.getJSONArray("attachments"));
        }
        if (jSONObject.has("actions") != null) {
            this.f15385i = C1308b.m15282a(jSONObject.getJSONArray("actions"));
        }
        if (jSONObject.has("direction") != null) {
            C0547b c0547b;
            str = jSONObject.getString("direction");
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != 57076464) {
                if (hashCode == 1941740409) {
                    if (str.equals("inbound") != null) {
                        obj = null;
                    }
                }
            } else if (str.equals("outbound") != null) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    c0547b = C0547b.INBOUND;
                    break;
                case 1:
                    c0547b = C0547b.OUTBOUND;
                    break;
                default:
                    c0547b = C0547b.NOT_AVAILABLE;
                    break;
            }
            m15280a(c0547b);
        }
        if (jSONObject.has("messages_state") != null) {
            this.f15386j = MessageState.valueOf(jSONObject.getString("messages_state"));
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Message:[");
        stringBuilder.append(this.f15377a);
        stringBuilder.append(", ");
        stringBuilder.append(this.f15378b);
        stringBuilder.append(", ");
        stringBuilder.append(this.f15379c);
        stringBuilder.append(", ");
        stringBuilder.append(this.f15382f);
        stringBuilder.append(", ");
        stringBuilder.append(this.f15387k);
        stringBuilder.append(", ");
        stringBuilder.append(this.f15380d);
        stringBuilder.append(", ");
        stringBuilder.append(this.f15381e);
        stringBuilder.append(", ");
        stringBuilder.append(this.f15386j);
        stringBuilder.append(", ");
        stringBuilder.append(this.f15388l);
        stringBuilder.append(", ");
        stringBuilder.append(this.f15383g);
        stringBuilder.append(", ");
        stringBuilder.append(this.f15384h);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        if (!String.valueOf(message.f15377a).equals(String.valueOf(this.f15377a)) || !String.valueOf(message.f15378b).equals(String.valueOf(this.f15378b)) || !String.valueOf(message.f15380d).equals(String.valueOf(this.f15380d)) || !String.valueOf(message.f15381e).equals(String.valueOf(this.f15381e)) || !String.valueOf(message.f15379c).equals(String.valueOf(this.f15379c)) || message.f15382f != this.f15382f || message.f15386j != this.f15386j || message.f15388l != this.f15388l || message.m15281a() != m15281a() || message.f15383g != this.f15383g || message.f15387k != this.f15387k || message.f15384h == null || message.f15384h.size() != this.f15384h.size() || message.f15385i == null || message.f15385i.size() != this.f15385i.size()) {
            return false;
        }
        int i;
        for (i = 0; i < message.f15384h.size(); i++) {
            if (!((Attachment) message.f15384h.get(i)).equals(this.f15384h.get(i))) {
                return false;
            }
        }
        for (i = 0; i < message.f15385i.size(); i++) {
            if (!((C1308b) message.f15385i.get(i)).equals(this.f15385i.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f15377a != null ? this.f15377a.hashCode() : -1;
    }
}
