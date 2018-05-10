package com.instabug.bug.model;

import com.instabug.bug.settings.C0485a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportCategory {
    private static final String CATEGORY_REPORT_A_PROBLEM = "report-a-problem";
    private static final String CATEGORY_SUGGEST_AN_IMPROVEMENT = "suggest-an-improvement";
    private static final String KEY_LABEL = "name";
    private static final String KEY_SLUG = "slug";
    private static final String KEY_SUBS = "subs";
    private int icon;
    private String label;
    private List<ReportCategory> subs;

    private ReportCategory() {
    }

    public static ReportCategory getInstance() {
        return new ReportCategory();
    }

    public ReportCategory withLabel(String str) {
        this.label = str;
        return this;
    }

    public ReportCategory withIcon(int i) {
        this.icon = i;
        return this;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public int getIcon() {
        return this.icon;
    }

    public void setIcon(int i) {
        this.icon = i;
    }

    public List<ReportCategory> getSubs() {
        return this.subs;
    }

    private void setSubs(List<ReportCategory> list) {
        this.subs = list;
    }

    private static ReportCategory fromJsonObject(JSONObject jSONObject) throws JSONException {
        ReportCategory reportCategory = new ReportCategory();
        if (jSONObject.has(KEY_LABEL)) {
            reportCategory.setLabel(jSONObject.getString(KEY_LABEL));
        }
        List arrayList = new ArrayList();
        if (jSONObject.has("subs")) {
            jSONObject = jSONObject.getJSONArray("subs");
            for (int i = 0; i < jSONObject.length(); i++) {
                arrayList.add(fromJsonObject(jSONObject.getJSONObject(i)));
            }
        }
        reportCategory.setSubs(arrayList);
        return reportCategory;
    }

    public static List<ReportCategory> getSubReportCategories(C0478b c0478b) {
        c0478b = getRemoteSubReportCategories(c0478b);
        if (c0478b != null) {
            return c0478b;
        }
        C0485a.m7793a();
        return C0485a.m7804b();
    }

    private static List<ReportCategory> getRemoteSubReportCategories(C0478b c0478b) {
        C0485a.m7793a();
        String c = C0485a.m7808c();
        if (c != null) {
            try {
                JSONArray jSONArray = new JSONArray(c);
                if (c0478b == C0478b.BUG) {
                    c0478b = getSubCategories(jSONArray, CATEGORY_REPORT_A_PROBLEM);
                    if (c0478b != null && c0478b.size() > 0) {
                        return c0478b;
                    }
                } else if (c0478b == C0478b.FEEDBACK) {
                    c0478b = getSubCategories(jSONArray, CATEGORY_SUGGEST_AN_IMPROVEMENT);
                    if (c0478b != null && c0478b.size() > 0) {
                        return c0478b;
                    }
                }
            } catch (C0478b c0478b2) {
                c0478b2.printStackTrace();
            }
        }
        return null;
    }

    private static List<ReportCategory> getSubCategories(JSONArray jSONArray, String str) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            if (str.equals(jSONArray.getJSONObject(i).getString(KEY_SLUG))) {
                return fromJsonObject(jSONArray.getJSONObject(i)).getSubs();
            }
        }
        return null;
    }

    public static boolean hasSubCategories(C0478b c0478b) {
        boolean z;
        List remoteSubReportCategories = getRemoteSubReportCategories(C0478b.BUG);
        List remoteSubReportCategories2 = getRemoteSubReportCategories(C0478b.FEEDBACK);
        if (remoteSubReportCategories == null || remoteSubReportCategories.isEmpty()) {
            z = false;
        } else if (c0478b == C0478b.BUG) {
            return true;
        } else {
            z = true;
        }
        if (!(remoteSubReportCategories2 == null || remoteSubReportCategories2.isEmpty())) {
            if (c0478b == C0478b.FEEDBACK) {
                return true;
            }
            z = true;
        }
        C0485a.m7793a();
        c0478b = C0485a.m7804b();
        return (z || c0478b == null || c0478b.size() <= null) ? false : true;
    }
}
