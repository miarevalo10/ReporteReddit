package com.reddit.frontpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.crashlytics.android.Crashlytics;
import com.reddit.frontpage.util.BranchUtil;
import com.reddit.frontpage.util.IntentUtil;
import io.branch.referral.Branch;
import io.branch.referral.Branch.BranchReferralInitListener;
import io.branch.referral.BranchError;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/BranchLinkActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "fallbackIntent", "Landroid/content/Intent;", "getFallbackIntent", "()Landroid/content/Intent;", "fallbackIntent$delegate", "Lkotlin/Lazy;", "nextIntent", "error", "Lio/branch/referral/BranchError;", "referringParams", "Lorg/json/JSONObject;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BranchLinkActivity.kt */
public final class BranchLinkActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] f40542a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(BranchLinkActivity.class), "fallbackIntent", "getFallbackIntent()Landroid/content/Intent;"))};
    private final Lazy f40543b = LazyKt.m26777a(new BranchLinkActivity$fallbackIntent$2(this));

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1761R.layout.activity_start);
        bundle = Branch.m31871a();
        BranchReferralInitListener branchLinkActivity$onCreate$1 = new BranchLinkActivity$onCreate$1(this);
        Object intent = getIntent();
        Intrinsics.m26843a(intent, "intent");
        bundle.m31916a(branchLinkActivity$onCreate$1, intent.getData(), (Activity) this);
    }

    public static final /* synthetic */ Intent m41951a(BranchError branchError, JSONObject jSONObject) {
        if (branchError != null) {
            jSONObject = new StringBuilder("Failed to parse Branch link: ");
            jSONObject.append(branchError.m26100a());
            Crashlytics.log(jSONObject.toString());
            Timber.e("Failed to parse Branch link", new Object[null]);
            return null;
        }
        String a = BranchUtil.m23660a(jSONObject);
        if (a != null) {
            return IntentUtil.m23752a(a);
        }
        return null;
    }
}
