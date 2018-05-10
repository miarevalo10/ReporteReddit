package com.reddit.frontpage.debug;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.Map;

public class AnimationTracer {
    private static Choreographer f20106a;
    private static Map<String, TraceLog> f20107b;

    public static class TraceLog {
        private static final TraceLog f20100d = new TraceLog();
        public int f20101a;
        public long f20102b;
        public String f20103c;
        private FrameCallback f20104e;
        private long f20105f;

        private TraceLog() {
        }

        private TraceLog(final Choreographer choreographer, String str) {
            this.f20103c = str;
            this.f20105f = System.currentTimeMillis();
            this.f20104e = new FrameCallback(this) {
                final /* synthetic */ TraceLog f20099b;

                public void doFrame(long j) {
                    choreographer.postFrameCallback(this);
                    j = this.f20099b;
                    j.f20101a++;
                }
            };
            choreographer.postFrameCallback(this.f20104e);
        }

        public String toString() {
            if (this.f20104e == null) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder(21);
            stringBuilder.append("Trace [");
            stringBuilder.append(this.f20103c);
            stringBuilder.append("]: ");
            stringBuilder.append((int) (((float) this.f20101a) / (((float) this.f20102b) / 1000.0f)));
            stringBuilder.append("fps in ");
            stringBuilder.append(this.f20102b);
            stringBuilder.append("ms");
            return stringBuilder.toString();
        }
    }

    public static void m21976a(String str) {
        if (f20106a != null) {
            f20107b.put(str, new TraceLog(f20106a, str));
        }
    }

    public static TraceLog m21977b(String str) {
        if (f20106a == null) {
            return TraceLog.f20100d;
        }
        TraceLog traceLog = (TraceLog) f20107b.get(str);
        if (traceLog == null) {
            return TraceLog.f20100d;
        }
        traceLog.f20102b = System.currentTimeMillis() - traceLog.f20105f;
        f20106a.removeFrameCallback(traceLog.f20104e);
        f20107b.remove(str);
        return traceLog;
    }
}
