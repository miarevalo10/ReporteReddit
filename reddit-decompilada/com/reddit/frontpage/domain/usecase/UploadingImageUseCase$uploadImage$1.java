package com.reddit.frontpage.domain.usecase;

import android.net.Uri;
import com.reddit.datalibrary.frontpage.requests.models.v2.FileUploadLease;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/service/api/FileUploadResponse;", "it", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/FileUploadLease;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: UploadingImageUseCase.kt */
final class UploadingImageUseCase$uploadImage$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ UploadingImageUseCase f28025a;
    final /* synthetic */ Uri f28026b;
    final /* synthetic */ String f28027c;

    public UploadingImageUseCase$uploadImage$1(UploadingImageUseCase uploadingImageUseCase, Uri uri, String str) {
        this.f28025a = uploadingImageUseCase;
        this.f28026b = uri;
        this.f28027c = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        FileUploadLease fileUploadLease = (FileUploadLease) obj;
        Intrinsics.m26847b(fileUploadLease, "it");
        UploadingImageUseCase uploadingImageUseCase = this.f28025a;
        Object obj2 = this.f28026b;
        Intrinsics.m26843a(obj2, "uri");
        Object obj3 = this.f28027c;
        Intrinsics.m26843a(obj3, "fileName");
        return UploadingImageUseCase.m22530a(uploadingImageUseCase, fileUploadLease, obj2, obj3);
    }
}
