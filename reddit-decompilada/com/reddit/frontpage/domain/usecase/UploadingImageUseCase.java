package com.reddit.frontpage.domain.usecase;

import android.net.Uri;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v2.FileUploadLease;
import com.reddit.frontpage.domain.repository.AccountRepository;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/UploadingImageUseCase;", "", "accountRepository", "Lcom/reddit/frontpage/domain/repository/AccountRepository;", "remoteRedditApiDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteRedditApiDataSource;", "(Lcom/reddit/frontpage/domain/repository/AccountRepository;Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteRedditApiDataSource;)V", "getTempImageUrl", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/service/api/FileUploadResponse;", "lease", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/FileUploadLease;", "uri", "Landroid/net/Uri;", "fileName", "", "uploadImage", "userSubredditDisplayName", "file", "Ljava/io/File;", "imageType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UploadingImageUseCase.kt */
public final class UploadingImageUseCase {
    public final AccountRepository f20296a;
    private final RemoteRedditApiDataSource f20297b;

    @Inject
    public UploadingImageUseCase(AccountRepository accountRepository, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        Intrinsics.m26847b(accountRepository, "accountRepository");
        Intrinsics.m26847b(remoteRedditApiDataSource, "remoteRedditApiDataSource");
        this.f20296a = accountRepository;
        this.f20297b = remoteRedditApiDataSource;
    }

    public static final /* synthetic */ Single m22530a(UploadingImageUseCase uploadingImageUseCase, FileUploadLease fileUploadLease, Uri uri, String str) {
        StringBuilder stringBuilder = new StringBuilder("https:");
        stringBuilder.append(fileUploadLease.m21637a());
        Object fromCallable = Single.fromCallable(new UploadingImageUseCase$getTempImageUrl$1(uploadingImageUseCase, uri, stringBuilder.toString(), str, fileUploadLease));
        Intrinsics.m26843a(fromCallable, "Single.fromCallable {\n  …   response\n      }\n    }");
        return fromCallable;
    }
}
