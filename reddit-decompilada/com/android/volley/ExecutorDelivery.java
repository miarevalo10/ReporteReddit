package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

public class ExecutorDelivery implements ResponseDelivery {
    private final Executor f12122a;

    private class ResponseDeliveryRunnable implements Runnable {
        final /* synthetic */ ExecutorDelivery f2767a;
        private final Request f2768b;
        private final Response f2769c;
        private final Runnable f2770d;

        public ResponseDeliveryRunnable(ExecutorDelivery executorDelivery, Request request, Response response, Runnable runnable) {
            this.f2767a = executorDelivery;
            this.f2768b = request;
            this.f2769c = response;
            this.f2770d = runnable;
        }

        public void run() {
            if (this.f2768b.isCanceled()) {
                this.f2768b.finish("canceled-at-delivery");
                return;
            }
            if ((this.f2769c.f2803c == null ? 1 : null) != null) {
                this.f2768b.deliverResponse(this.f2769c.f2801a);
            } else {
                this.f2768b.deliverError(this.f2769c.f2803c);
            }
            if (this.f2769c.f2804d) {
                this.f2768b.addMarker("intermediate-response");
            } else {
                this.f2768b.finish("done");
            }
            if (this.f2770d != null) {
                this.f2770d.run();
            }
        }
    }

    public ExecutorDelivery(final Handler handler) {
        this.f12122a = new Executor(this) {
            final /* synthetic */ ExecutorDelivery f2766b;

            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public void mo774a(Request<?> request, Response<?> response) {
        mo775a(request, response, null);
    }

    public void mo775a(Request<?> request, Response<?> response, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.f12122a.execute(new ResponseDeliveryRunnable(this, request, response, runnable));
    }

    public void mo776a(Request<?> request, VolleyError volleyError) {
        request.addMarker("post-error");
        this.f12122a.execute(new ResponseDeliveryRunnable(this, request, Response.m2444a(volleyError), null));
    }
}
