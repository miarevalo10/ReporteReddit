package com.google.android.exoplayer2;

public final class RendererConfiguration {
    public static final RendererConfiguration f4058a = new RendererConfiguration(0);
    public final int f4059b;

    public RendererConfiguration(int i) {
        this.f4059b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return this.f4059b == ((RendererConfiguration) obj).f4059b;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4059b;
    }
}
