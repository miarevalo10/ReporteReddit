package com.reddit.frontpage.presentation.modtools.modlist.all;

import com.reddit.datalibrary.frontpage.data.model.ModToolsPostResponse;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsPostResponse;", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: AllModeratorsPresenter.kt */
final class AllModeratorsPresenter$acceptModInvite$1<T> implements Consumer<ModToolsPostResponse> {
    final /* synthetic */ AllModeratorsPresenter f28652a;

    AllModeratorsPresenter$acceptModInvite$1(AllModeratorsPresenter allModeratorsPresenter) {
        this.f28652a = allModeratorsPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        ModToolsPostResponse modToolsPostResponse = (ModToolsPostResponse) obj;
        Intrinsics.m26847b(modToolsPostResponse, "response");
        if (modToolsPostResponse.getFirstErrorMessage() != null) {
            this.f28652a.f36982a.b_(String.valueOf(modToolsPostResponse.getFirstErrorMessage()));
        }
    }
}
