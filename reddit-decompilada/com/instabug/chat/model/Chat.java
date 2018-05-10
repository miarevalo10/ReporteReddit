package com.instabug.chat.model;

import android.content.Context;
import com.instabug.chat.model.Message.C0546a;
import com.instabug.chat.model.Message.MessageState;
import com.instabug.library.C0593R;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.model.BaseReport;
import com.instabug.library.model.State;
import com.instabug.library.model.State.Builder;
import com.instabug.library.util.InstabugAppData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class Chat extends BaseReport implements Cacheable {
    public ArrayList<Message> f15373a;
    public ChatState f15374b;
    private String f15375c;
    private State f15376d;

    public enum ChatState {
        WAITING_ATTACHMENT_MESSAGE,
        READY_TO_BE_SENT,
        LOGS_READY_TO_BE_UPLOADED,
        SENT,
        NOT_AVAILABLE
    }

    public static class C0544a implements Serializable, Comparator<Chat> {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return new Date(((Chat) obj).m15275d()).compareTo(new Date(((Chat) obj2).m15275d()));
        }
    }

    public static class C0545b {
        public static Chat m7926a(Context context) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis());
            return new Chat(stringBuilder.toString(), new Builder(context).build(true), ChatState.READY_TO_BE_SENT);
        }
    }

    public /* synthetic */ BaseReport setId(String str) {
        return m15271a(str);
    }

    public Chat(String str, State state, ChatState chatState) {
        this.f15375c = str;
        this.f15376d = state;
        this.f15374b = chatState;
        this.f15373a = new ArrayList();
    }

    public Chat(String str) {
        this.f15375c = str;
        this.f15373a = new ArrayList();
        this.f15374b = ChatState.SENT;
    }

    public Chat() {
        this.f15374b = ChatState.NOT_AVAILABLE;
        this.f15373a = new ArrayList();
    }

    public String getId() {
        return this.f15375c;
    }

    public final Chat m15271a(String str) {
        this.f15375c = str;
        m15269g();
        return this;
    }

    private Chat m15267a(ArrayList<Message> arrayList) {
        this.f15373a = arrayList;
        m15269g();
        return this;
    }

    public State getState() {
        return this.f15376d;
    }

    public final int m15270a() {
        Iterator it = this.f15373a.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!((Message) it.next()).f15383g) {
                i++;
            }
        }
        return i;
    }

    public final String m15273b() {
        Message f = m15268f();
        return f != null ? f.f15381e : null;
    }

    public final String m15274c() {
        Message f = m15268f();
        if (f != null) {
            return f.f15380d;
        }
        return this.f15373a.size() != 0 ? ((Message) this.f15373a.get(this.f15373a.size() - 1)).f15380d : "";
    }

    public final long m15275d() {
        return m15276e() != null ? m15276e().f15382f : 0;
    }

    public final Message m15276e() {
        if (this.f15373a.size() == 0) {
            return null;
        }
        Collections.sort(this.f15373a, new C0546a(2));
        return (Message) this.f15373a.get(this.f15373a.size() - 1);
    }

    public final String m15272a(Context context) {
        String c = m15274c();
        if (c != null && !c.equals("") && !c.equals(" ") && !c.equals("null") && m15276e() != null && !m15276e().m15281a()) {
            return c;
        }
        return String.format(context.getString(C0593R.string.instabug_str_notification_title), new Object[]{new InstabugAppData(context).getAppName()});
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", getId()).put("messages", Message.m15278a(this.f15373a)).put("chat_state", this.f15374b.toString());
        if (getState() != null) {
            jSONObject.put("state", getState().toJson());
        }
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id") != null) {
            m15271a(jSONObject.getString("id"));
        }
        if (jSONObject.has("messages") != null) {
            m15267a(Message.m15277a(jSONObject.getJSONArray("messages")));
        }
        if (jSONObject.has("chat_state") != null) {
            this.f15374b = ChatState.valueOf(jSONObject.getString("chat_state"));
        }
        if (jSONObject.has("state") != null) {
            str = new State();
            str.fromJson(jSONObject.getString("state"));
            this.f15376d = str;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Chat:[");
        stringBuilder.append(this.f15375c);
        stringBuilder.append(" chatState: ");
        stringBuilder.append(this.f15374b);
        stringBuilder.append(", ");
        stringBuilder.append(this.f15373a);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Chat)) {
            return false;
        }
        Chat chat = (Chat) obj;
        if (!String.valueOf(chat.getId()).equals(getId()) || chat.f15374b != this.f15374b || ((chat.getState() != null || getState() != null) && !chat.getState().equals(getState()))) {
            return false;
        }
        for (int i = 0; i < chat.f15373a.size(); i++) {
            if (!((Message) chat.f15373a.get(i)).equals(this.f15373a.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return getId() != null ? getId().hashCode() : -1;
    }

    private Message m15268f() {
        Message message;
        for (int size = this.f15373a.size() - 1; size >= 0; size--) {
            if (((Message) this.f15373a.get(size)).f15386j == MessageState.SYNCED) {
                message = (Message) this.f15373a.get(size);
                break;
            }
        }
        message = null;
        if (message == null || !message.m15281a()) {
            return message;
        }
        Iterator it = this.f15373a.iterator();
        while (it.hasNext()) {
            Message message2 = (Message) it.next();
            if (!message2.m15281a()) {
                return message2;
            }
        }
        return null;
    }

    private void m15269g() {
        for (int i = 0; i < this.f15373a.size(); i++) {
            ((Message) this.f15373a.get(i)).f15378b = this.f15375c;
        }
    }

    public /* synthetic */ BaseReport setState(State state) {
        this.f15376d = state;
        return this;
    }
}
