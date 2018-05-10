package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.appcompat.C0164R;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class AppCompatDialog extends Dialog implements AppCompatCallback {
    private AppCompatDelegate f11568a;

    public AppCompatDialog(Context context) {
        this(context, 0);
    }

    public void onCreate(Bundle bundle) {
        m10252b().mo3181i();
        super.onCreate(bundle);
        m10252b().mo3166a(bundle);
    }

    public void setContentView(int i) {
        m10252b().mo3172b(i);
    }

    public void setContentView(View view) {
        m10252b().mo3168a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m10252b().mo3169a(view, layoutParams);
    }

    public <T extends View> T findViewById(int i) {
        return m10252b().mo3164a(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m10252b().mo418a(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        m10252b().mo418a(getContext().getString(i));
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m10252b().mo3173b(view, layoutParams);
    }

    protected void onStop() {
        super.onStop();
        m10252b().mo423e();
    }

    public final boolean x_() {
        return m10252b().mo3176c(1);
    }

    public void invalidateOptionsMenu() {
        m10252b().mo3180g();
    }

    private AppCompatDelegate m10252b() {
        if (this.f11568a == null) {
            this.f11568a = AppCompatDelegate.m1524a((Dialog) this, (AppCompatCallback) this);
        }
        return this.f11568a;
    }

    public AppCompatDialog(Context context, int i) {
        if (i == 0) {
            i = new TypedValue();
            context.getTheme().resolveAttribute(C0164R.attr.dialogTheme, i, true);
            i = i.resourceId;
        }
        super(context, i);
        m10252b().mo3166a((Bundle) 0);
        m10252b().mo425j();
    }
}
