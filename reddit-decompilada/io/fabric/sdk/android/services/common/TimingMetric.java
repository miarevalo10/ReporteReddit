package io.fabric.sdk.android.services.common;

import android.os.SystemClock;
import android.util.Log;

public class TimingMetric {
    private final String f24785a;
    private final String f24786b;
    private final boolean f24787c;
    private long f24788d;
    private long f24789e;

    public TimingMetric(String str, String str2) {
        this.f24785a = str;
        this.f24786b = str2;
        this.f24787c = Log.isLoggable(str2, 2) ^ 1;
    }

    public final synchronized void m26363a() {
        if (!this.f24787c) {
            this.f24788d = SystemClock.elapsedRealtime();
            this.f24789e = 0;
        }
    }

    public final synchronized void m26364b() {
        if (!this.f24787c) {
            if (this.f24789e == 0) {
                this.f24789e = SystemClock.elapsedRealtime() - this.f24788d;
                String str = this.f24786b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.f24785a);
                stringBuilder.append(": ");
                stringBuilder.append(this.f24789e);
                stringBuilder.append("ms");
                Log.v(str, stringBuilder.toString());
            }
        }
    }
}
