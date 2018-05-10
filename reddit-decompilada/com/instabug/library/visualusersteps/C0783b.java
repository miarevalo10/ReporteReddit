package com.instabug.library.visualusersteps;

import com.instabug.library.model.State;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VisualUserStep */
public class C0783b implements Serializable {
    String f9929a;
    private String f9930b;
    private String f9931c;
    private String f9932d;
    private String f9933e;
    private long f9934f;
    private String f9935g;
    private String f9936h;

    /* compiled from: VisualUserStep */
    public static final class C0782a {
        public String f9921a;
        public String f9922b;
        public String f9923c;
        public String f9924d;
        long f9925e;
        String f9926f;
        public String f9927g;
        private String f9928h;

        private C0782a(String str) {
            this.f9925e = System.currentTimeMillis();
            this.f9928h = str;
        }

        public final C0783b m8377a() {
            return new C0783b();
        }
    }

    private C0783b(C0782a c0782a) {
        this.f9930b = c0782a.f9921a;
        this.f9931c = c0782a.f9922b;
        this.f9932d = c0782a.f9923c;
        this.f9933e = c0782a.f9924d;
        this.f9929a = c0782a.f9928h;
        this.f9934f = c0782a.f9925e;
        this.f9935g = c0782a.f9926f;
        this.f9936h = c0782a.f9927g;
    }

    public static C0782a m8378a(String str) {
        return new C0782a(str);
    }

    public static ArrayList<C0783b> m8380a(JSONArray jSONArray) throws JSONException {
        ArrayList<C0783b> arrayList = new ArrayList();
        if (jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String str = "unknown";
                if (jSONObject.has("event_type")) {
                    str = jSONObject.getString("event_type");
                }
                String str2 = null;
                String string = jSONObject.has("screen_name") ? jSONObject.getString("screen_name") : null;
                String string2 = jSONObject.has("screen_identifier") ? jSONObject.getString("screen_identifier") : null;
                String string3 = jSONObject.has("screenshot_identifier") ? jSONObject.getString("screenshot_identifier") : null;
                String string4 = jSONObject.has("date") ? jSONObject.getString("date") : null;
                String string5 = jSONObject.has("parent_screen_identifier") ? jSONObject.getString("parent_screen_identifier") : null;
                String string6 = jSONObject.has("view") ? jSONObject.getString("view") : null;
                if (jSONObject.has(State.KEY_ORIENTATION)) {
                    Object obj;
                    String string7 = jSONObject.getString(State.KEY_ORIENTATION);
                    int hashCode = string7.hashCode();
                    if (hashCode == 729267099) {
                        if (string7.equals("portrait")) {
                            obj = 1;
                            switch (obj) {
                                case null:
                                    str2 = "landscape";
                                    break;
                                case 1:
                                    str2 = "portrait";
                                    break;
                                default:
                                    break;
                            }
                        }
                    } else if (hashCode == 1430647483) {
                        if (string7.equals("landscape")) {
                            obj = null;
                            switch (obj) {
                                case null:
                                    str2 = "landscape";
                                    break;
                                case 1:
                                    str2 = "portrait";
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    obj = -1;
                    switch (obj) {
                        case null:
                            str2 = "landscape";
                            break;
                        case 1:
                            str2 = "portrait";
                            break;
                        default:
                            break;
                    }
                }
                C0782a a = C0783b.m8378a(str);
                a.f9922b = string;
                a.f9923c = string3;
                a.f9925e = Long.parseLong(string4);
                a.f9921a = string5;
                a.f9926f = string6;
                a.f9927g = str2;
                a.f9924d = string2;
                arrayList.add(a.m8377a());
            }
        }
        return arrayList;
    }

    public static String m8379a(ArrayList<C0783b> arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && arrayList.size() > 0) {
            arrayList = arrayList.iterator();
            while (arrayList.hasNext()) {
                jSONArray.put(((C0783b) arrayList.next()).m8381a());
            }
        }
        return jSONArray.toString();
    }

    private JSONObject m8381a() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj;
            String str = "parent_screen_identifier";
            if (this.f9930b != null) {
                if (!this.f9930b.equals("null")) {
                    obj = this.f9930b;
                    jSONObject.put(str, obj);
                    str = "screen_name";
                    if (this.f9931c != null) {
                        if (this.f9931c.equals("null")) {
                            obj = this.f9931c;
                            jSONObject.put(str, obj);
                            str = "screenshot_identifier";
                            if (this.f9932d != null) {
                                if (!this.f9932d.equals("null")) {
                                    obj = this.f9932d;
                                    jSONObject.put(str, obj);
                                    str = "screen_identifier";
                                    if (this.f9933e != null) {
                                        if (!this.f9933e.equals("null")) {
                                            obj = this.f9933e;
                                            jSONObject.put(str, obj);
                                            str = "event_type";
                                            if (this.f9929a != null) {
                                                if (!this.f9929a.equals("null")) {
                                                    obj = this.f9929a;
                                                    jSONObject.put(str, obj);
                                                    jSONObject.put("date", this.f9934f);
                                                    str = "view";
                                                    if (this.f9935g != null) {
                                                        if (!this.f9935g.equals("null")) {
                                                            obj = this.f9935g;
                                                            jSONObject.put(str, obj);
                                                            str = State.KEY_ORIENTATION;
                                                            if (this.f9936h != null) {
                                                                if (!this.f9936h.equals("null")) {
                                                                    obj = this.f9936h;
                                                                    jSONObject.put(str, obj);
                                                                    return jSONObject;
                                                                }
                                                            }
                                                            obj = JSONObject.NULL;
                                                            jSONObject.put(str, obj);
                                                            return jSONObject;
                                                        }
                                                    }
                                                    obj = JSONObject.NULL;
                                                    jSONObject.put(str, obj);
                                                    str = State.KEY_ORIENTATION;
                                                    if (this.f9936h != null) {
                                                        if (!this.f9936h.equals("null")) {
                                                            obj = this.f9936h;
                                                            jSONObject.put(str, obj);
                                                            return jSONObject;
                                                        }
                                                    }
                                                    obj = JSONObject.NULL;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            jSONObject.put("date", this.f9934f);
                                            str = "view";
                                            if (this.f9935g != null) {
                                                if (!this.f9935g.equals("null")) {
                                                    obj = this.f9935g;
                                                    jSONObject.put(str, obj);
                                                    str = State.KEY_ORIENTATION;
                                                    if (this.f9936h != null) {
                                                        if (!this.f9936h.equals("null")) {
                                                            obj = this.f9936h;
                                                            jSONObject.put(str, obj);
                                                            return jSONObject;
                                                        }
                                                    }
                                                    obj = JSONObject.NULL;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    str = "event_type";
                                    if (this.f9929a != null) {
                                        if (!this.f9929a.equals("null")) {
                                            obj = this.f9929a;
                                            jSONObject.put(str, obj);
                                            jSONObject.put("date", this.f9934f);
                                            str = "view";
                                            if (this.f9935g != null) {
                                                if (!this.f9935g.equals("null")) {
                                                    obj = this.f9935g;
                                                    jSONObject.put(str, obj);
                                                    str = State.KEY_ORIENTATION;
                                                    if (this.f9936h != null) {
                                                        if (!this.f9936h.equals("null")) {
                                                            obj = this.f9936h;
                                                            jSONObject.put(str, obj);
                                                            return jSONObject;
                                                        }
                                                    }
                                                    obj = JSONObject.NULL;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    jSONObject.put("date", this.f9934f);
                                    str = "view";
                                    if (this.f9935g != null) {
                                        if (!this.f9935g.equals("null")) {
                                            obj = this.f9935g;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            str = "screen_identifier";
                            if (this.f9933e != null) {
                                if (!this.f9933e.equals("null")) {
                                    obj = this.f9933e;
                                    jSONObject.put(str, obj);
                                    str = "event_type";
                                    if (this.f9929a != null) {
                                        if (!this.f9929a.equals("null")) {
                                            obj = this.f9929a;
                                            jSONObject.put(str, obj);
                                            jSONObject.put("date", this.f9934f);
                                            str = "view";
                                            if (this.f9935g != null) {
                                                if (!this.f9935g.equals("null")) {
                                                    obj = this.f9935g;
                                                    jSONObject.put(str, obj);
                                                    str = State.KEY_ORIENTATION;
                                                    if (this.f9936h != null) {
                                                        if (!this.f9936h.equals("null")) {
                                                            obj = this.f9936h;
                                                            jSONObject.put(str, obj);
                                                            return jSONObject;
                                                        }
                                                    }
                                                    obj = JSONObject.NULL;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    jSONObject.put("date", this.f9934f);
                                    str = "view";
                                    if (this.f9935g != null) {
                                        if (!this.f9935g.equals("null")) {
                                            obj = this.f9935g;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            str = "event_type";
                            if (this.f9929a != null) {
                                if (!this.f9929a.equals("null")) {
                                    obj = this.f9929a;
                                    jSONObject.put(str, obj);
                                    jSONObject.put("date", this.f9934f);
                                    str = "view";
                                    if (this.f9935g != null) {
                                        if (!this.f9935g.equals("null")) {
                                            obj = this.f9935g;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            jSONObject.put("date", this.f9934f);
                            str = "view";
                            if (this.f9935g != null) {
                                if (!this.f9935g.equals("null")) {
                                    obj = this.f9935g;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    str = "screenshot_identifier";
                    if (this.f9932d != null) {
                        if (!this.f9932d.equals("null")) {
                            obj = this.f9932d;
                            jSONObject.put(str, obj);
                            str = "screen_identifier";
                            if (this.f9933e != null) {
                                if (!this.f9933e.equals("null")) {
                                    obj = this.f9933e;
                                    jSONObject.put(str, obj);
                                    str = "event_type";
                                    if (this.f9929a != null) {
                                        if (!this.f9929a.equals("null")) {
                                            obj = this.f9929a;
                                            jSONObject.put(str, obj);
                                            jSONObject.put("date", this.f9934f);
                                            str = "view";
                                            if (this.f9935g != null) {
                                                if (!this.f9935g.equals("null")) {
                                                    obj = this.f9935g;
                                                    jSONObject.put(str, obj);
                                                    str = State.KEY_ORIENTATION;
                                                    if (this.f9936h != null) {
                                                        if (!this.f9936h.equals("null")) {
                                                            obj = this.f9936h;
                                                            jSONObject.put(str, obj);
                                                            return jSONObject;
                                                        }
                                                    }
                                                    obj = JSONObject.NULL;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    jSONObject.put("date", this.f9934f);
                                    str = "view";
                                    if (this.f9935g != null) {
                                        if (!this.f9935g.equals("null")) {
                                            obj = this.f9935g;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            str = "event_type";
                            if (this.f9929a != null) {
                                if (!this.f9929a.equals("null")) {
                                    obj = this.f9929a;
                                    jSONObject.put(str, obj);
                                    jSONObject.put("date", this.f9934f);
                                    str = "view";
                                    if (this.f9935g != null) {
                                        if (!this.f9935g.equals("null")) {
                                            obj = this.f9935g;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            jSONObject.put("date", this.f9934f);
                            str = "view";
                            if (this.f9935g != null) {
                                if (!this.f9935g.equals("null")) {
                                    obj = this.f9935g;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    str = "screen_identifier";
                    if (this.f9933e != null) {
                        if (!this.f9933e.equals("null")) {
                            obj = this.f9933e;
                            jSONObject.put(str, obj);
                            str = "event_type";
                            if (this.f9929a != null) {
                                if (!this.f9929a.equals("null")) {
                                    obj = this.f9929a;
                                    jSONObject.put(str, obj);
                                    jSONObject.put("date", this.f9934f);
                                    str = "view";
                                    if (this.f9935g != null) {
                                        if (!this.f9935g.equals("null")) {
                                            obj = this.f9935g;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            jSONObject.put("date", this.f9934f);
                            str = "view";
                            if (this.f9935g != null) {
                                if (!this.f9935g.equals("null")) {
                                    obj = this.f9935g;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    str = "event_type";
                    if (this.f9929a != null) {
                        if (!this.f9929a.equals("null")) {
                            obj = this.f9929a;
                            jSONObject.put(str, obj);
                            jSONObject.put("date", this.f9934f);
                            str = "view";
                            if (this.f9935g != null) {
                                if (!this.f9935g.equals("null")) {
                                    obj = this.f9935g;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    jSONObject.put("date", this.f9934f);
                    str = "view";
                    if (this.f9935g != null) {
                        if (!this.f9935g.equals("null")) {
                            obj = this.f9935g;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    str = State.KEY_ORIENTATION;
                    if (this.f9936h != null) {
                        if (!this.f9936h.equals("null")) {
                            obj = this.f9936h;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    return jSONObject;
                }
            }
            obj = JSONObject.NULL;
            jSONObject.put(str, obj);
            str = "screen_name";
            if (this.f9931c != null) {
                if (this.f9931c.equals("null")) {
                    obj = this.f9931c;
                    jSONObject.put(str, obj);
                    str = "screenshot_identifier";
                    if (this.f9932d != null) {
                        if (!this.f9932d.equals("null")) {
                            obj = this.f9932d;
                            jSONObject.put(str, obj);
                            str = "screen_identifier";
                            if (this.f9933e != null) {
                                if (!this.f9933e.equals("null")) {
                                    obj = this.f9933e;
                                    jSONObject.put(str, obj);
                                    str = "event_type";
                                    if (this.f9929a != null) {
                                        if (!this.f9929a.equals("null")) {
                                            obj = this.f9929a;
                                            jSONObject.put(str, obj);
                                            jSONObject.put("date", this.f9934f);
                                            str = "view";
                                            if (this.f9935g != null) {
                                                if (!this.f9935g.equals("null")) {
                                                    obj = this.f9935g;
                                                    jSONObject.put(str, obj);
                                                    str = State.KEY_ORIENTATION;
                                                    if (this.f9936h != null) {
                                                        if (!this.f9936h.equals("null")) {
                                                            obj = this.f9936h;
                                                            jSONObject.put(str, obj);
                                                            return jSONObject;
                                                        }
                                                    }
                                                    obj = JSONObject.NULL;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    jSONObject.put("date", this.f9934f);
                                    str = "view";
                                    if (this.f9935g != null) {
                                        if (!this.f9935g.equals("null")) {
                                            obj = this.f9935g;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            str = "event_type";
                            if (this.f9929a != null) {
                                if (!this.f9929a.equals("null")) {
                                    obj = this.f9929a;
                                    jSONObject.put(str, obj);
                                    jSONObject.put("date", this.f9934f);
                                    str = "view";
                                    if (this.f9935g != null) {
                                        if (!this.f9935g.equals("null")) {
                                            obj = this.f9935g;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            jSONObject.put("date", this.f9934f);
                            str = "view";
                            if (this.f9935g != null) {
                                if (!this.f9935g.equals("null")) {
                                    obj = this.f9935g;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    str = "screen_identifier";
                    if (this.f9933e != null) {
                        if (!this.f9933e.equals("null")) {
                            obj = this.f9933e;
                            jSONObject.put(str, obj);
                            str = "event_type";
                            if (this.f9929a != null) {
                                if (!this.f9929a.equals("null")) {
                                    obj = this.f9929a;
                                    jSONObject.put(str, obj);
                                    jSONObject.put("date", this.f9934f);
                                    str = "view";
                                    if (this.f9935g != null) {
                                        if (!this.f9935g.equals("null")) {
                                            obj = this.f9935g;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            jSONObject.put("date", this.f9934f);
                            str = "view";
                            if (this.f9935g != null) {
                                if (!this.f9935g.equals("null")) {
                                    obj = this.f9935g;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    str = "event_type";
                    if (this.f9929a != null) {
                        if (!this.f9929a.equals("null")) {
                            obj = this.f9929a;
                            jSONObject.put(str, obj);
                            jSONObject.put("date", this.f9934f);
                            str = "view";
                            if (this.f9935g != null) {
                                if (!this.f9935g.equals("null")) {
                                    obj = this.f9935g;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    jSONObject.put("date", this.f9934f);
                    str = "view";
                    if (this.f9935g != null) {
                        if (!this.f9935g.equals("null")) {
                            obj = this.f9935g;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    str = State.KEY_ORIENTATION;
                    if (this.f9936h != null) {
                        if (!this.f9936h.equals("null")) {
                            obj = this.f9936h;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    return jSONObject;
                }
            }
            obj = JSONObject.NULL;
            jSONObject.put(str, obj);
            str = "screenshot_identifier";
            if (this.f9932d != null) {
                if (!this.f9932d.equals("null")) {
                    obj = this.f9932d;
                    jSONObject.put(str, obj);
                    str = "screen_identifier";
                    if (this.f9933e != null) {
                        if (!this.f9933e.equals("null")) {
                            obj = this.f9933e;
                            jSONObject.put(str, obj);
                            str = "event_type";
                            if (this.f9929a != null) {
                                if (!this.f9929a.equals("null")) {
                                    obj = this.f9929a;
                                    jSONObject.put(str, obj);
                                    jSONObject.put("date", this.f9934f);
                                    str = "view";
                                    if (this.f9935g != null) {
                                        if (!this.f9935g.equals("null")) {
                                            obj = this.f9935g;
                                            jSONObject.put(str, obj);
                                            str = State.KEY_ORIENTATION;
                                            if (this.f9936h != null) {
                                                if (!this.f9936h.equals("null")) {
                                                    obj = this.f9936h;
                                                    jSONObject.put(str, obj);
                                                    return jSONObject;
                                                }
                                            }
                                            obj = JSONObject.NULL;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            jSONObject.put("date", this.f9934f);
                            str = "view";
                            if (this.f9935g != null) {
                                if (!this.f9935g.equals("null")) {
                                    obj = this.f9935g;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    str = "event_type";
                    if (this.f9929a != null) {
                        if (!this.f9929a.equals("null")) {
                            obj = this.f9929a;
                            jSONObject.put(str, obj);
                            jSONObject.put("date", this.f9934f);
                            str = "view";
                            if (this.f9935g != null) {
                                if (!this.f9935g.equals("null")) {
                                    obj = this.f9935g;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    jSONObject.put("date", this.f9934f);
                    str = "view";
                    if (this.f9935g != null) {
                        if (!this.f9935g.equals("null")) {
                            obj = this.f9935g;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    str = State.KEY_ORIENTATION;
                    if (this.f9936h != null) {
                        if (!this.f9936h.equals("null")) {
                            obj = this.f9936h;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    return jSONObject;
                }
            }
            obj = JSONObject.NULL;
            jSONObject.put(str, obj);
            str = "screen_identifier";
            if (this.f9933e != null) {
                if (!this.f9933e.equals("null")) {
                    obj = this.f9933e;
                    jSONObject.put(str, obj);
                    str = "event_type";
                    if (this.f9929a != null) {
                        if (!this.f9929a.equals("null")) {
                            obj = this.f9929a;
                            jSONObject.put(str, obj);
                            jSONObject.put("date", this.f9934f);
                            str = "view";
                            if (this.f9935g != null) {
                                if (!this.f9935g.equals("null")) {
                                    obj = this.f9935g;
                                    jSONObject.put(str, obj);
                                    str = State.KEY_ORIENTATION;
                                    if (this.f9936h != null) {
                                        if (!this.f9936h.equals("null")) {
                                            obj = this.f9936h;
                                            jSONObject.put(str, obj);
                                            return jSONObject;
                                        }
                                    }
                                    obj = JSONObject.NULL;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    jSONObject.put("date", this.f9934f);
                    str = "view";
                    if (this.f9935g != null) {
                        if (!this.f9935g.equals("null")) {
                            obj = this.f9935g;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    str = State.KEY_ORIENTATION;
                    if (this.f9936h != null) {
                        if (!this.f9936h.equals("null")) {
                            obj = this.f9936h;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    return jSONObject;
                }
            }
            obj = JSONObject.NULL;
            jSONObject.put(str, obj);
            str = "event_type";
            if (this.f9929a != null) {
                if (!this.f9929a.equals("null")) {
                    obj = this.f9929a;
                    jSONObject.put(str, obj);
                    jSONObject.put("date", this.f9934f);
                    str = "view";
                    if (this.f9935g != null) {
                        if (!this.f9935g.equals("null")) {
                            obj = this.f9935g;
                            jSONObject.put(str, obj);
                            str = State.KEY_ORIENTATION;
                            if (this.f9936h != null) {
                                if (!this.f9936h.equals("null")) {
                                    obj = this.f9936h;
                                    jSONObject.put(str, obj);
                                    return jSONObject;
                                }
                            }
                            obj = JSONObject.NULL;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    str = State.KEY_ORIENTATION;
                    if (this.f9936h != null) {
                        if (!this.f9936h.equals("null")) {
                            obj = this.f9936h;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    return jSONObject;
                }
            }
            obj = JSONObject.NULL;
            jSONObject.put(str, obj);
            jSONObject.put("date", this.f9934f);
            str = "view";
            if (this.f9935g != null) {
                if (!this.f9935g.equals("null")) {
                    obj = this.f9935g;
                    jSONObject.put(str, obj);
                    str = State.KEY_ORIENTATION;
                    if (this.f9936h != null) {
                        if (!this.f9936h.equals("null")) {
                            obj = this.f9936h;
                            jSONObject.put(str, obj);
                            return jSONObject;
                        }
                    }
                    obj = JSONObject.NULL;
                    jSONObject.put(str, obj);
                    return jSONObject;
                }
            }
            obj = JSONObject.NULL;
            jSONObject.put(str, obj);
            str = State.KEY_ORIENTATION;
            if (this.f9936h != null) {
                if (!this.f9936h.equals("null")) {
                    obj = this.f9936h;
                    jSONObject.put(str, obj);
                    return jSONObject;
                }
            }
            obj = JSONObject.NULL;
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("VisualUserStep{parentScreenId='");
        stringBuilder.append(this.f9930b);
        stringBuilder.append('\'');
        stringBuilder.append(", screenName='");
        stringBuilder.append(this.f9931c);
        stringBuilder.append('\'');
        stringBuilder.append(", screenshotId='");
        stringBuilder.append(this.f9932d);
        stringBuilder.append('\'');
        stringBuilder.append(", screenId='");
        stringBuilder.append(this.f9933e);
        stringBuilder.append('\'');
        stringBuilder.append(", eventType='");
        stringBuilder.append(this.f9929a);
        stringBuilder.append('\'');
        stringBuilder.append(", date=");
        stringBuilder.append(this.f9934f);
        stringBuilder.append(", view='");
        stringBuilder.append(this.f9935g);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
