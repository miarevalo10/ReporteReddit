package com.reddit.frontpage.presentation.modtools.modlist.add;

import com.reddit.datalibrary.frontpage.data.model.ModToolsPostResponse;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsPostResponse;", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: AddModeratorPresenter.kt */
final class AddModeratorPresenter$inviteModerator$1<T> implements Consumer<ModToolsPostResponse> {
    final /* synthetic */ AddModeratorPresenter f28625a;
    final /* synthetic */ String f28626b;

    AddModeratorPresenter$inviteModerator$1(AddModeratorPresenter addModeratorPresenter, String str) {
        this.f28625a = addModeratorPresenter;
        this.f28626b = str;
    }

    public final /* synthetic */ void accept(Object obj) {
        ModToolsPostResponse modToolsPostResponse = (ModToolsPostResponse) obj;
        Intrinsics.m26847b(modToolsPostResponse, "response");
        if (modToolsPostResponse.getFirstErrorMessage() != null) {
            this.f28625a.f34074a.mo7241c(String.valueOf(modToolsPostResponse.getFirstErrorMessage()));
        } else {
            this.f28625a.f34074a.mo7393a(this.f28626b);
        }
    }
}
