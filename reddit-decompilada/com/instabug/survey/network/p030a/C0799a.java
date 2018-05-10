package com.instabug.survey.network.p030a;

import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.model.State;
import com.instabug.library.network.Request;
import com.instabug.survey.p027a.C1412b;
import com.instabug.survey.p027a.C1413c;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SubmittingSurveysUtil */
public class C0799a {
    public static void m8425a(Request request, C1413c c1413c) throws JSONException {
        String str = "responses";
        ArrayList arrayList = c1413c.f15573c;
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C1412b c1412b = (C1412b) it.next();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", c1412b.f15569e);
            jSONObject.put("question_id", c1412b.f15565a);
            jSONArray.put(jSONObject);
        }
        request.addParameter(str, jSONArray);
        request.addParameter("responded_at", Long.valueOf(((C1412b) c1413c.f15573c.get(c1413c.f15573c.size() - 1)).f15570f));
        request.addParameter("name", InstabugCore.getUsername());
        request.addParameter(State.KEY_EMAIL, Instabug.getUserEmail());
    }
}
