package com.reddit.frontpage.presentation.modtools.ban;

import com.reddit.datalibrary.frontpage.data.model.BannedUsersResponse;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/reddit/datalibrary/frontpage/data/model/BannedUsersResponse;", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: BannedUsersPresenter.kt */
final class BannedUsersPresenter$searchUser$1<T> implements Consumer<BannedUsersResponse> {
    final /* synthetic */ BannedUsersPresenter f28564a;

    BannedUsersPresenter$searchUser$1(BannedUsersPresenter bannedUsersPresenter) {
        this.f28564a = bannedUsersPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        BannedUsersResponse bannedUsersResponse = (BannedUsersResponse) obj;
        Intrinsics.m26847b(bannedUsersResponse, "response");
        this.f28564a.f36969a.mo7388b(bannedUsersResponse.getBannedUsers());
    }
}
