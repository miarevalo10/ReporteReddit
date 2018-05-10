package com.google.ads;

@Deprecated
public final class AdSize {
    public static final AdSize f3958b = new AdSize(-1, -2);
    public static final AdSize f3959c = new AdSize(320, 50);
    public static final AdSize f3960d = new AdSize(300, 250);
    public static final AdSize f3961e = new AdSize(468, 60);
    public static final AdSize f3962f = new AdSize(728, 90);
    public static final AdSize f3963g = new AdSize(160, 600);
    public final com.google.android.gms.ads.AdSize f3964a;

    private AdSize(int i, int i2) {
        this(new com.google.android.gms.ads.AdSize(i, i2));
    }

    public AdSize(com.google.android.gms.ads.AdSize adSize) {
        this.f3964a = adSize;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AdSize)) {
            return false;
        }
        return this.f3964a.equals(((AdSize) obj).f3964a);
    }

    public final int hashCode() {
        return this.f3964a.hashCode();
    }

    public final String toString() {
        return this.f3964a.toString();
    }
}
