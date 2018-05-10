package com.instabug.survey.network;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.survey.p027a.C1413c;
import com.instabug.survey.p028b.C0791c;
import java.util.List;
import org.json.JSONArray;

/* compiled from: SurveysFetcher */
public class C0800a {
    private C0798a f9965a;

    /* compiled from: SurveysFetcher */
    public interface C0798a {
        void mo2623a(Throwable th);

        void mo2624a(List<C1413c> list);
    }

    /* compiled from: SurveysFetcher */
    class C14171 implements Callbacks<JSONArray, Throwable> {
        final /* synthetic */ C0800a f15588a;

        public C14171(C0800a c0800a) {
            this.f15588a = c0800a;
        }

        public /* synthetic */ void onFailed(Object obj) {
            this.f15588a.f9965a.mo2623a((Throwable) obj);
        }

        public /* synthetic */ void onSucceeded(Object obj) {
            JSONArray jSONArray = (JSONArray) obj;
            try {
                C0791c.m8399a(System.currentTimeMillis());
                this.f15588a.f9965a.mo2624a(C1413c.m15476a(jSONArray));
            } catch (Throwable e) {
                this.f15588a.f9965a.mo2623a(e);
            }
        }
    }

    public C0800a(C0798a c0798a) {
        this.f9965a = c0798a;
    }

    public static boolean m8427a() {
        return InstabugCore.isFeaturesFetchedBefore();
    }
}
