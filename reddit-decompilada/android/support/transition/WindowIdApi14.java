package android.support.transition;

import android.os.IBinder;
import android.support.annotation.RequiresApi;

@RequiresApi(14)
class WindowIdApi14 implements WindowIdImpl {
    private final IBinder f11246a;

    WindowIdApi14(IBinder iBinder) {
        this.f11246a = iBinder;
    }

    public boolean equals(Object obj) {
        return (!(obj instanceof WindowIdApi14) || ((WindowIdApi14) obj).f11246a.equals(this.f11246a) == null) ? null : true;
    }

    public int hashCode() {
        return this.f11246a.hashCode();
    }
}
