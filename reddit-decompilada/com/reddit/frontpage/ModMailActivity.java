package com.reddit.frontpage;

import android.os.Bundle;
import android.view.View;
import com.reddit.frontpage.ui.detail.web.ModMailFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/ModMailActivity;", "Lcom/reddit/frontpage/BaseActivity;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModMailActivity.kt */
public final class ModMailActivity extends BaseActivity {
    public static final Companion f40821d = new Companion();
    private static final String f40822h = "com.reddit.extra.initial_url";
    private static final String f40823i = "com.reddit.extra.color";
    private HashMap f40824j;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/ModMailActivity$Companion;", "", "()V", "EXTRA_COLOR", "", "getEXTRA_COLOR", "()Ljava/lang/String;", "EXTRA_INITIAL_URL", "getEXTRA_INITIAL_URL", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModMailActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public static String m21779a() {
            return ModMailActivity.f40822h;
        }

        public static String m21780b() {
            return ModMailActivity.f40823i;
        }
    }

    public final View mo7727a(int i) {
        if (this.f40824j == null) {
            this.f40824j = new HashMap();
        }
        View view = (View) this.f40824j.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f40824j.put(Integer.valueOf(i), view);
        return view;
    }

    public final int mo7724d() {
        return C1761R.layout.activity_single_container;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Object stringExtra = getIntent().getStringExtra(Companion.m21779a());
        int intExtra = getIntent().getIntExtra(Companion.m21780b(), 0);
        if (bundle == null) {
            bundle = getSupportFragmentManager().a();
            com.reddit.frontpage.ui.detail.web.ModMailFragment.Companion companion = ModMailFragment.f37247a;
            Intrinsics.m26843a(stringExtra, "initialUrl");
            bundle.a(C1761R.id.container, com.reddit.frontpage.ui.detail.web.ModMailFragment.Companion.m23370a(stringExtra, getString(C1761R.string.mod_tools_mod_mail_beta), intExtra)).c();
        }
    }
}
