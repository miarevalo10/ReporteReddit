package android.support.customtabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import java.util.ArrayList;

public final class CustomTabsIntent {
    public final Intent f395a;
    public final Bundle f396b;

    public static final class Builder {
        private final Intent f390a;
        private ArrayList<Bundle> f391b;
        private Bundle f392c;
        private ArrayList<Bundle> f393d;
        private boolean f394e;

        public Builder() {
            this((byte) 0);
        }

        private Builder(byte b) {
            this.f390a = new Intent("android.intent.action.VIEW");
            this.f391b = null;
            this.f392c = null;
            this.f393d = null;
            this.f394e = true;
            b = new Bundle();
            BundleCompat.m527b(b, "android.support.customtabs.extra.SESSION");
            this.f390a.putExtras(b);
        }

        public final Builder m145a(int i) {
            this.f390a.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", i);
            return this;
        }

        public final CustomTabsIntent m146a() {
            if (this.f391b != null) {
                this.f390a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", this.f391b);
            }
            if (this.f393d != null) {
                this.f390a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", this.f393d);
            }
            this.f390a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f394e);
            return new CustomTabsIntent(this.f390a, this.f392c);
        }
    }

    private CustomTabsIntent(Intent intent, Bundle bundle) {
        this.f395a = intent;
        this.f396b = bundle;
    }
}
