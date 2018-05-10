package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.widget.EdgeEffect;

public final class EdgeEffectCompat {
    private static final EdgeEffectBaseImpl f1651a;

    static class EdgeEffectBaseImpl {
        EdgeEffectBaseImpl() {
        }

        public void mo391a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    @RequiresApi(21)
    static class EdgeEffectApi21Impl extends EdgeEffectBaseImpl {
        EdgeEffectApi21Impl() {
        }

        public final void mo391a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1651a = new EdgeEffectApi21Impl();
        } else {
            f1651a = new EdgeEffectBaseImpl();
        }
    }

    public static void m1400a(EdgeEffect edgeEffect, float f, float f2) {
        f1651a.mo391a(edgeEffect, f, f2);
    }
}
