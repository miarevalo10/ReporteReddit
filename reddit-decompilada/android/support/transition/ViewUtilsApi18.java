package android.support.transition;

import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(18)
class ViewUtilsApi18 extends ViewUtilsApi14 {
    ViewUtilsApi18() {
    }

    public final ViewOverlayImpl mo178a(View view) {
        return new ViewOverlayApi18(view);
    }

    public final WindowIdImpl mo182b(View view) {
        return new WindowIdApi18(view);
    }
}
