package com.instabug.chat.model;

import com.instabug.library.internal.storage.cache.Cacheable;
import java.util.ArrayList;
import net.hockeyapp.android.UpdateFragment;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MessageAction */
public class C1308b implements Cacheable {
    public String f15389a;
    public String f15390b;
    private C0551a f15391c;

    /* compiled from: MessageAction */
    public enum C0551a {
        BUTTON("button"),
        NOT_AVAILABLE("not-available");
        
        private final String f9288c;

        private C0551a(String str) {
            this.f9288c = str;
        }

        public final String toString() {
            return this.f9288c;
        }
    }

    public static ArrayList<C1308b> m15282a(JSONArray jSONArray) throws JSONException {
        ArrayList<C1308b> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            C1308b c1308b = new C1308b();
            c1308b.fromJson(jSONArray.getString(i));
            arrayList.add(c1308b);
        }
        return arrayList;
    }

    public static JSONArray m15283a(ArrayList<C1308b> arrayList) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(((C1308b) arrayList.get(i)).toJson());
        }
        return jSONArray;
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(UpdateFragment.FRAGMENT_URL) != null) {
            this.f15390b = jSONObject.getString(UpdateFragment.FRAGMENT_URL);
        }
        if (jSONObject.has("title") != null) {
            this.f15389a = jSONObject.getString("title");
        }
        if (jSONObject.has("type") != null) {
            str = jSONObject.getString("type");
            Object obj = -1;
            if (str.hashCode() == -1377687758) {
                if (str.equals("button") != null) {
                    obj = null;
                }
            }
            if (obj != null) {
                this.f15391c = C0551a.NOT_AVAILABLE;
            } else {
                this.f15391c = C0551a.BUTTON;
            }
        }
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f15391c.toString());
        jSONObject.put("title", this.f15389a);
        jSONObject.put(UpdateFragment.FRAGMENT_URL, this.f15390b);
        return jSONObject.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Type: ");
        stringBuilder.append(this.f15391c);
        stringBuilder.append(", title: ");
        stringBuilder.append(this.f15389a);
        stringBuilder.append(", url: ");
        stringBuilder.append(this.f15390b);
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C1308b)) {
            return false;
        }
        C1308b c1308b = (C1308b) obj;
        if (String.valueOf(c1308b.f15389a).equals(String.valueOf(this.f15389a)) && String.valueOf(c1308b.f15390b).equals(String.valueOf(this.f15390b)) && c1308b.f15391c == this.f15391c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f15389a == null || this.f15390b == null || this.f15391c == null) {
            return -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(this.f15389a.hashCode()));
        stringBuilder.append(String.valueOf(this.f15390b.hashCode()));
        stringBuilder.append(String.valueOf(this.f15391c.toString().hashCode()));
        return stringBuilder.toString().hashCode();
    }
}
