package com.reddit.frontpage.presentation.modtools.approvedsubmitters;

import com.reddit.datalibrary.frontpage.data.model.ApprovedSubmittersResponse;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/reddit/datalibrary/frontpage/data/model/ApprovedSubmittersResponse;", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ApprovedSubmittersPresenter.kt */
final class ApprovedSubmittersPresenter$loadUsers$1<T> implements Consumer<ApprovedSubmittersResponse> {
    final /* synthetic */ ApprovedSubmittersPresenter f28548a;

    ApprovedSubmittersPresenter$loadUsers$1(ApprovedSubmittersPresenter approvedSubmittersPresenter) {
        this.f28548a = approvedSubmittersPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        ApprovedSubmittersResponse approvedSubmittersResponse = (ApprovedSubmittersResponse) obj;
        Intrinsics.m26847b(approvedSubmittersResponse, "response");
        this.f28548a.f34071c = approvedSubmittersResponse.getAllUsersLoaded();
        this.f28548a.f34070b = approvedSubmittersResponse.getToken();
        this.f28548a.f34072d = false;
        this.f28548a.f36965a.mo7385a(approvedSubmittersResponse.getApprovedSubmitters());
    }
}
