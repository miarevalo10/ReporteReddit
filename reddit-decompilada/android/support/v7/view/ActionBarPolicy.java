package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.appcompat.C0164R;
import org.jcodec.containers.mps.MPSUtils;

public class ActionBarPolicy {
    public Context f1959a;

    public static ActionBarPolicy m1671a(Context context) {
        return new ActionBarPolicy(context);
    }

    private ActionBarPolicy(Context context) {
        this.f1959a = context;
    }

    public final int m1672a() {
        Configuration configuration = this.f1959a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp <= 600 && i <= 600 && (i <= 960 || i2 <= 720)) {
            if (i <= 720 || i2 <= 960) {
                if (i < 500 && (i <= 640 || i2 <= MPSUtils.VIDEO_MIN)) {
                    if (i <= MPSUtils.VIDEO_MIN || i2 <= 640) {
                        return i >= 360 ? 3 : 2;
                    }
                }
                return 4;
            }
        }
        return 5;
    }

    public final boolean m1673b() {
        return this.f1959a.getResources().getBoolean(C0164R.bool.abc_action_bar_embed_tabs);
    }
}
