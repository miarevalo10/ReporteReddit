package android.support.v7.preference;

import android.content.Context;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.preference.PreferenceManager.OnNavigateToScreenListener;
import android.util.AttributeSet;

public final class PreferenceScreen extends PreferenceGroup {
    boolean f16591b = true;

    protected final boolean mo488f() {
        return false;
    }

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, TypedArrayUtils.m776a(context, C0177R.attr.preferenceScreenStyle, 16842891), (byte) 0);
    }

    protected final void mo482b() {
        if (this.f1899r == null && this.f1900s == null) {
            if (mo481a() != 0) {
                OnNavigateToScreenListener onNavigateToScreenListener = this.f1892k.f1927g;
                if (onNavigateToScreenListener != null) {
                    onNavigateToScreenListener.mo3192a();
                }
            }
        }
    }
}
