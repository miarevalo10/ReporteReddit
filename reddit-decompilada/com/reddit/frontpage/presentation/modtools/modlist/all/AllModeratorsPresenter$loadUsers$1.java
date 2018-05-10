package com.reddit.frontpage.presentation.modtools.modlist.all;

import com.reddit.datalibrary.frontpage.data.model.ModeratorsResponse;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/reddit/datalibrary/frontpage/data/model/ModeratorsResponse;", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: AllModeratorsPresenter.kt */
final class AllModeratorsPresenter$loadUsers$1<T> implements Consumer<ModeratorsResponse> {
    final /* synthetic */ AllModeratorsPresenter f28656a;

    AllModeratorsPresenter$loadUsers$1(AllModeratorsPresenter allModeratorsPresenter) {
        this.f28656a = allModeratorsPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        ModeratorsResponse moderatorsResponse = (ModeratorsResponse) obj;
        Intrinsics.m26847b(moderatorsResponse, "response");
        this.f28656a.f34071c = moderatorsResponse.getAllUsersLoaded();
        this.f28656a.f34070b = moderatorsResponse.getToken();
        this.f28656a.f34072d = false;
        this.f28656a.f36982a.mo7385a(moderatorsResponse.getModerators());
        if (moderatorsResponse.getInvitePending() != null) {
            this.f28656a.f36982a.mo7674d();
        }
    }
}
