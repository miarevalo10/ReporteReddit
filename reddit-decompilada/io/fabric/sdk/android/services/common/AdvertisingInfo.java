package io.fabric.sdk.android.services.common;

class AdvertisingInfo {
    public final String f24714a;
    public final boolean f24715b;

    AdvertisingInfo(String str, boolean z) {
        this.f24714a = str;
        this.f24715b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                AdvertisingInfo advertisingInfo = (AdvertisingInfo) obj;
                if (this.f24715b != advertisingInfo.f24715b) {
                    return false;
                }
                if (this.f24714a == null) {
                    return advertisingInfo.f24714a == null;
                } else {
                    if (this.f24714a.equals(advertisingInfo.f24714a) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * (this.f24714a != null ? this.f24714a.hashCode() : 0)) + this.f24715b;
    }
}
