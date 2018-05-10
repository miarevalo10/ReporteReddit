package com.reddit.frontpage.util;

import io.branch.referral.Branch.BranchReferralInitListener;
import io.branch.referral.BranchError;
import org.json.JSONObject;

final /* synthetic */ class BranchUtil$$Lambda$0 implements BranchReferralInitListener {
    private final long f29377a;

    BranchUtil$$Lambda$0(long j) {
        this.f29377a = j;
    }

    public final void mo4560a(JSONObject jSONObject, BranchError branchError) {
        BranchUtil.m23663a(this.f29377a, jSONObject);
    }
}
