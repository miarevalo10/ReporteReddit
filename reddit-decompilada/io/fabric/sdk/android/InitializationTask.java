package io.fabric.sdk.android;

import io.fabric.sdk.android.services.common.TimingMetric;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityAsyncTask;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

class InitializationTask<Result> extends PriorityAsyncTask<Void, Void, Result> {
    final Kit<Result> f34675a;

    public InitializationTask(Kit<Result> kit) {
        this.f34675a = kit;
    }

    protected final void mo6589a() {
        super.mo6589a();
        TimingMetric a = m35588a("onPreExecute");
        try {
            boolean onPreExecute = this.f34675a.onPreExecute();
            a.m26364b();
            if (!onPreExecute) {
                m26376d();
            }
        } catch (UnmetDependencyException e) {
            throw e;
        } catch (Throwable e2) {
            Fabric.m26243b().mo5568c("Fabric", "Failure onPreExecute()", e2);
            a.m26364b();
            m26376d();
        } catch (Throwable th) {
            a.m26364b();
            m26376d();
        }
    }

    protected final void mo6590a(Result result) {
        this.f34675a.onPostExecute(result);
        this.f34675a.initializationCallback.mo5573a();
    }

    protected final void mo6592b(Result result) {
        this.f34675a.onCancelled(result);
        result = new StringBuilder();
        result.append(this.f34675a.getIdentifier());
        result.append(" Initialization was cancelled");
        this.f34675a.initializationCallback.mo5574a(new InitializationException(result.toString()));
    }

    public Priority getPriority() {
        return Priority.HIGH;
    }

    private TimingMetric m35588a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f34675a.getIdentifier());
        stringBuilder.append(".");
        stringBuilder.append(str);
        TimingMetric timingMetric = new TimingMetric(stringBuilder.toString(), "KitInitialization");
        timingMetric.m26363a();
        return timingMetric;
    }

    protected final /* synthetic */ Object mo6591b() {
        TimingMetric a = m35588a("doInBackground");
        Object doInBackground = !this.f24816g.get() ? this.f34675a.doInBackground() : null;
        a.m26364b();
        return doInBackground;
    }
}
