package com.reddit.frontpage.ui.profile.profilesettings.presentation;

import com.reddit.datalibrary.frontpage.service.api.FileUploadResponse;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "it", "Lcom/reddit/datalibrary/frontpage/service/api/FileUploadResponse;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsPresenter.kt */
final class ProfileSettingsPresenter$uploadImage$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ ProfileSettingsPresenter f29261a;
    final /* synthetic */ String f29262b;

    ProfileSettingsPresenter$uploadImage$1(ProfileSettingsPresenter profileSettingsPresenter, String str) {
        this.f29261a = profileSettingsPresenter;
        this.f29262b = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        FileUploadResponse fileUploadResponse = (FileUploadResponse) obj;
        Intrinsics.m26847b(fileUploadResponse, "it");
        return this.f29261a.f34418f.m22397b(this.f29261a.f34419g.f21529a, MapsKt__MapsKt.m36120a((Pair) TuplesKt.m26780a(this.f29262b, fileUploadResponse.fileUrl)));
    }
}
