package com.reddit.frontpage.presentation.modtools.mute;

import com.reddit.datalibrary.frontpage.data.model.MutedUsersResponse;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/reddit/datalibrary/frontpage/data/model/MutedUsersResponse;", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: MutedUsersPresenter.kt */
final class MutedUsersPresenter$loadUsers$1<T> implements Consumer<MutedUsersResponse> {
    final /* synthetic */ MutedUsersPresenter f28681a;

    MutedUsersPresenter$loadUsers$1(MutedUsersPresenter mutedUsersPresenter) {
        this.f28681a = mutedUsersPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        MutedUsersResponse mutedUsersResponse = (MutedUsersResponse) obj;
        Intrinsics.m26847b(mutedUsersResponse, "response");
        this.f28681a.f34071c = mutedUsersResponse.getAllUsersLoaded();
        this.f28681a.f34070b = mutedUsersResponse.getToken();
        this.f28681a.f34072d = false;
        this.f28681a.f36992a.mo7385a(mutedUsersResponse.getMutedUsers());
    }
}
