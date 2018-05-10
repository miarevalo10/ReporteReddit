package android.support.transition;

import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.WindowId;

@RequiresApi(18)
class WindowIdApi18 implements WindowIdImpl {
    private final WindowId f11247a;

    WindowIdApi18(View view) {
        this.f11247a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (!(obj instanceof WindowIdApi18) || ((WindowIdApi18) obj).f11247a.equals(this.f11247a) == null) ? null : true;
    }

    public int hashCode() {
        return this.f11247a.hashCode();
    }
}
