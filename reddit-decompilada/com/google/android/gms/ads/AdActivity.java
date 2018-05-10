package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzxe;

public class AdActivity extends Activity {
    private zzxe f5361a;

    private final void m4354a() {
        if (this.f5361a != null) {
            try {
                this.f5361a.mo2289l();
            } catch (Throwable e) {
                zzakb.m5369c("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.f5361a.mo2277a(i, i2, intent);
        } catch (Throwable e) {
            zzakb.m5369c("Could not forward onActivityResult to ad overlay:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.f5361a != null) {
                z = this.f5361a.mo2282e();
            }
        } catch (Throwable e) {
            zzakb.m5369c("Could not forward onBackPressed to ad overlay:", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.f5361a.mo2279a(zzn.m17692a((Object) configuration));
        } catch (Throwable e) {
            zzakb.m5369c("Failed to wrap configuration.", e);
        }
    }

    protected void onDestroy() {
        try {
            if (this.f5361a != null) {
                this.f5361a.mo2288k();
            }
        } catch (Throwable e) {
            zzakb.m5369c("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.f5361a != null) {
                this.f5361a.mo2286i();
            }
        } catch (Throwable e) {
            zzakb.m5369c("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.f5361a != null) {
                this.f5361a.mo2283f();
            }
        } catch (Throwable e) {
            zzakb.m5369c("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.f5361a != null) {
                this.f5361a.mo2285h();
            }
        } catch (Throwable e) {
            zzakb.m5369c("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.f5361a != null) {
                this.f5361a.mo2280b(bundle);
            }
        } catch (Throwable e) {
            zzakb.m5369c("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.f5361a != null) {
                this.f5361a.mo2284g();
            }
        } catch (Throwable e) {
            zzakb.m5369c("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.f5361a != null) {
                this.f5361a.mo2287j();
            }
        } catch (Throwable e) {
            zzakb.m5369c("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        m4354a();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        m4354a();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        m4354a();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzjr b = zzkb.m6346b();
        String str = "com.google.android.gms.ads.internal.overlay.useClientJar";
        Intent intent = getIntent();
        boolean z = false;
        if (intent.hasExtra(str)) {
            z = intent.getBooleanExtra(str, false);
        } else {
            zzakb.m5368c("useClientJar flag not found in activity intent extras.");
        }
        this.f5361a = (zzxe) zzjr.m6338a(this, z, new zzka(b, this));
        if (this.f5361a == null) {
            zzakb.m5371e("Could not create ad overlay.");
        } else {
            try {
                this.f5361a.mo2278a(bundle);
                return;
            } catch (Bundle bundle2) {
                zzakb.m5369c("Could not forward onCreate to ad overlay:", bundle2);
            }
        }
        finish();
    }
}
