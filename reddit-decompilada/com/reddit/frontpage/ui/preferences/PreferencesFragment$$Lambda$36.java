package com.reddit.frontpage.ui.preferences;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.reddit.frontpage.util.AppRater;
import java.lang.reflect.Method;
import timber.log.Timber;

final /* synthetic */ class PreferencesFragment$$Lambda$36 implements OnClickListener {
    private final PreferencesFragment f21511a;

    PreferencesFragment$$Lambda$36(PreferencesFragment preferencesFragment) {
        this.f21511a = preferencesFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface = this.f21511a;
        try {
            Method declaredMethod = AppRater.class.getDeclaredMethod("a", new Class[]{View.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[]{dialogInterface.getView()});
        } catch (DialogInterface dialogInterface2) {
            Timber.c(dialogInterface2, dialogInterface2.getMessage(), new Object[0]);
        }
    }
}
