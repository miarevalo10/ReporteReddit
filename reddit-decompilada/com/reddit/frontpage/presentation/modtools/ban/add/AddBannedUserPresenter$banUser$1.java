package com.reddit.frontpage.presentation.modtools.ban.add;

import com.reddit.datalibrary.frontpage.data.model.ModToolsPostResponse;
import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.BanInfoModel;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsPostResponse;", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: AddBannedUserPresenter.kt */
final class AddBannedUserPresenter$banUser$1<T> implements Consumer<ModToolsPostResponse> {
    final /* synthetic */ AddBannedUserPresenter f28566a;
    final /* synthetic */ BanInfoModel f28567b;

    AddBannedUserPresenter$banUser$1(AddBannedUserPresenter addBannedUserPresenter, BanInfoModel banInfoModel) {
        this.f28566a = addBannedUserPresenter;
        this.f28567b = banInfoModel;
    }

    public final /* synthetic */ void accept(Object obj) {
        ModToolsPostResponse modToolsPostResponse = (ModToolsPostResponse) obj;
        Intrinsics.m26847b(modToolsPostResponse, "response");
        if (modToolsPostResponse.getFirstErrorMessage() != null) {
            this.f28566a.f34064a.mo7380b(String.valueOf(modToolsPostResponse.getFirstErrorMessage()));
            return;
        }
        this.f28566a.f34064a.mo7377a(this.f28567b.f20891a);
        AddBannedUserPresenter.m34796a(this.f28566a);
    }
}
