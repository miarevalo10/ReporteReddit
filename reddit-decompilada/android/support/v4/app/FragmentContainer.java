package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract class FragmentContainer {
    public abstract View mo209a(int i);

    public abstract boolean mo210a();

    public Fragment mo208a(Context context, String str, Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }
}
