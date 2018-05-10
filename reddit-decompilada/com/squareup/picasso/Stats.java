package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

class Stats {
    final HandlerThread f23888a = new HandlerThread("Picasso-Stats", 10);
    final Cache f23889b;
    final Handler f23890c;
    long f23891d;
    long f23892e;
    long f23893f;
    long f23894g;
    long f23895h;
    long f23896i;
    long f23897j;
    long f23898k;
    int f23899l;
    int f23900m;
    int f23901n;

    private static class StatsHandler extends Handler {
        private final Stats f23887a;

        public StatsHandler(Looper looper, Stats stats) {
            super(looper);
            this.f23887a = stats;
        }

        public void handleMessage(final Message message) {
            Stats stats;
            long j;
            switch (message.what) {
                case 0:
                    message = this.f23887a;
                    message.f23891d++;
                    return;
                case 1:
                    message = this.f23887a;
                    message.f23892e++;
                    return;
                case 2:
                    stats = this.f23887a;
                    j = (long) message.arg1;
                    stats.f23900m++;
                    stats.f23894g += j;
                    stats.f23897j = Stats.m25801a(stats.f23900m, stats.f23894g);
                    return;
                case 3:
                    stats = this.f23887a;
                    j = (long) message.arg1;
                    stats.f23901n++;
                    stats.f23895h += j;
                    stats.f23898k = Stats.m25801a(stats.f23900m, stats.f23895h);
                    return;
                case 4:
                    stats = this.f23887a;
                    Long l = (Long) message.obj;
                    stats.f23899l++;
                    stats.f23893f += l.longValue();
                    stats.f23896i = Stats.m25801a(stats.f23899l, stats.f23893f);
                    return;
                default:
                    Picasso.f23827a.post(new Runnable(this) {
                        final /* synthetic */ StatsHandler f23886b;

                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder("Unhandled stats message.");
                            stringBuilder.append(message.what);
                            throw new AssertionError(stringBuilder.toString());
                        }
                    });
                    return;
            }
        }
    }

    Stats(Cache cache) {
        this.f23889b = cache;
        this.f23888a.start();
        Utils.m25823a(this.f23888a.getLooper());
        this.f23890c = new StatsHandler(this.f23888a.getLooper(), this);
    }

    final void m25802a() {
        this.f23890c.sendEmptyMessage(0);
    }

    final void m25803a(Bitmap bitmap, int i) {
        this.f23890c.sendMessage(this.f23890c.obtainMessage(i, Utils.m25813a(bitmap), 0));
    }

    static long m25801a(int i, long j) {
        return j / ((long) i);
    }
}
