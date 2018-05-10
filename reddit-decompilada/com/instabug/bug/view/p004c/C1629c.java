package com.instabug.bug.view.p004c;

import android.support.v4.app.Fragment;
import com.instabug.bug.C0474d;
import com.instabug.bug.extendedbugreport.ExtendedBugReport;
import com.instabug.bug.extendedbugreport.ExtendedBugReport.State;
import com.instabug.bug.model.C0477a;
import com.instabug.bug.settings.C0485a;
import com.instabug.bug.view.p004c.C0511a.C1286a;
import com.instabug.bug.view.p004c.C0511a.C1287b;
import com.instabug.library.core.ui.BasePresenter;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ExtraFieldsPresenter */
class C1629c extends BasePresenter<C1287b> implements C1286a {
    C1629c(C1287b c1287b) {
        super(c1287b);
    }

    public final List<C0477a> m19380a() {
        List<C0477a> list = C0474d.m7762a().f9100a.f15319j;
        if (list != null) {
            return list;
        }
        C0485a.m7793a();
        State q = C0485a.m7826q();
        switch (q) {
            case ENABLED_WITH_OPTIONAL_FIELDS:
            case ENABLED_WITH_REQUIRED_FIELDS:
                C1287b c1287b = (C1287b) this.view.get();
                if (c1287b != null) {
                    list = ExtendedBugReport.m7771a(((Fragment) c1287b.getViewContext()).getContext(), q);
                    break;
                }
                break;
            default:
                C0485a.m7793a();
                list = C0485a.m7825p();
                break;
        }
        C0474d.m7762a().f9100a.f15319j = list;
        return list;
    }

    static void m19378a(List<C0477a> list) {
        Object obj = C0474d.m7762a().f9100a.f15313d;
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", "description");
            jSONObject.put("name", "Description");
            String str = "value";
            if (obj == null) {
                obj = "";
            }
            jSONObject.put(str, obj);
            jSONArray.put(jSONObject);
            for (C0477a c0477a : list) {
                jSONObject = new JSONObject();
                jSONObject.put("id", c0477a.f9104a);
                jSONObject.put("name", c0477a.f9106c);
                str = "value";
                if (c0477a.f9107d != null) {
                    obj = c0477a.f9107d;
                } else {
                    obj = "";
                }
                jSONObject.put(str, obj);
                jSONArray.put(jSONObject);
            }
        } catch (List<C0477a> list2) {
            list2.printStackTrace();
        }
        C0474d.m7762a().f9100a.f15313d = jSONArray.toString();
        C1629c.m19379b();
    }

    static void m19379b() {
        C0485a.m7793a();
        for (C0477a c0477a : C0485a.m7825p()) {
            c0477a.f9107d = null;
        }
    }

    public final boolean m19381c() {
        List list = C0474d.m7762a().f9100a.f15319j;
        C1287b c1287b = (C1287b) this.view.get();
        if (c1287b != null) {
            for (int i = 0; i < list.size(); i++) {
                C0477a c0477a = (C0477a) list.get(i);
                if (c0477a.f9108e) {
                    if (c0477a.f9107d == null) {
                        c1287b.mo4315a(i);
                        return false;
                    } else if (c0477a.f9107d.trim().isEmpty()) {
                        c1287b.mo4315a(i);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
