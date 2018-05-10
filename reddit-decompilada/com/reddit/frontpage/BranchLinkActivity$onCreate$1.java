package com.reddit.frontpage;

import android.content.Intent;
import io.branch.referral.Branch.BranchReferralInitListener;
import io.branch.referral.BranchError;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "referringParams", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "error", "Lio/branch/referral/BranchError;", "onInitFinished"}, k = 3, mv = {1, 1, 9})
/* compiled from: BranchLinkActivity.kt */
final class BranchLinkActivity$onCreate$1 implements BranchReferralInitListener {
    final /* synthetic */ BranchLinkActivity f27397a;

    BranchLinkActivity$onCreate$1(BranchLinkActivity branchLinkActivity) {
        this.f27397a = branchLinkActivity;
    }

    public final void mo4560a(JSONObject jSONObject, BranchError branchError) {
        BranchLinkActivity branchLinkActivity = this.f27397a;
        jSONObject = BranchLinkActivity.m41951a(branchError, jSONObject);
        if (jSONObject == null) {
            jSONObject = ((Intent) this.f27397a.f40543b.mo5678b());
        }
        branchLinkActivity.startActivity(jSONObject);
        this.f27397a.finish();
    }
}
