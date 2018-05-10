package com.reddit.frontpage.domain.usecase;

import android.net.Uri;
import com.reddit.datalibrary.frontpage.requests.models.v2.FileUploadLease;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/service/api/FileUploadResponse;", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: UploadingImageUseCase.kt */
final class UploadingImageUseCase$getTempImageUrl$1<V> implements Callable<T> {
    final /* synthetic */ UploadingImageUseCase f20291a;
    final /* synthetic */ Uri f20292b;
    final /* synthetic */ String f20293c;
    final /* synthetic */ String f20294d;
    final /* synthetic */ FileUploadLease f20295e;

    UploadingImageUseCase$getTempImageUrl$1(UploadingImageUseCase uploadingImageUseCase, Uri uri, String str, String str2, FileUploadLease fileUploadLease) {
        this.f20291a = uploadingImageUseCase;
        this.f20292b = uri;
        this.f20293c = str;
        this.f20294d = str2;
        this.f20295e = fileUploadLease;
    }

    public final /* synthetic */ Object call() {
        return m22529a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.reddit.datalibrary.frontpage.service.api.FileUploadResponse m22529a() {
        /*
        r7 = this;
        r0 = com.reddit.frontpage.FrontpageApplication.f27402a;
        r1 = "FrontpageApplication.instance";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        r0 = r0.getContentResolver();
        r1 = r7.f20292b;
        r0 = r0.openInputStream(r1);
        r0 = (java.io.Closeable) r0;
        r1 = 0;
        r2 = r0;
        r2 = (java.io.InputStream) r2;	 Catch:{ Throwable -> 0x0045 }
        r3 = new java.io.BufferedInputStream;	 Catch:{ Throwable -> 0x0045 }
        r3.<init>(r2);	 Catch:{ Throwable -> 0x0045 }
        r2 = r7.f20293c;	 Catch:{ Throwable -> 0x0045 }
        r3 = (java.io.InputStream) r3;	 Catch:{ Throwable -> 0x0045 }
        r4 = r7.f20294d;	 Catch:{ Throwable -> 0x0045 }
        r5 = r7.f20295e;	 Catch:{ Throwable -> 0x0045 }
        r5 = r5.m21638b();	 Catch:{ Throwable -> 0x0045 }
        r6 = "lease.fields";
        kotlin.jvm.internal.Intrinsics.m26843a(r5, r6);	 Catch:{ Throwable -> 0x0045 }
        r2 = com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource.a(r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0045 }
        r3 = r2.success;	 Catch:{ Throwable -> 0x0045 }
        if (r3 != 0) goto L_0x003f;
    L_0x0035:
        r2 = new java.lang.Exception;	 Catch:{ Throwable -> 0x0045 }
        r3 = "Image upload failed";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0045 }
        r2 = (java.lang.Throwable) r2;	 Catch:{ Throwable -> 0x0045 }
        throw r2;	 Catch:{ Throwable -> 0x0045 }
    L_0x003f:
        kotlin.io.CloseableKt.m26828a(r0, r1);
        return r2;
    L_0x0043:
        r2 = move-exception;
        goto L_0x0047;
    L_0x0045:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0043 }
    L_0x0047:
        kotlin.io.CloseableKt.m26828a(r0, r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.domain.usecase.UploadingImageUseCase$getTempImageUrl$1.a():com.reddit.datalibrary.frontpage.service.api.FileUploadResponse");
    }
}
