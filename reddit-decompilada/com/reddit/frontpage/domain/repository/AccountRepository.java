package com.reddit.frontpage.domain.repository;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.DefaultAvatar;
import com.reddit.datalibrary.frontpage.data.model.ProfileSettings;
import com.reddit.datalibrary.frontpage.requests.models.v2.FileUploadLease;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\n\u001a\u00020\u0006H&J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\u0006\u0010\n\u001a\u00020\u0006H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0006H&J0\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00170\u00032\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH&J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH&J\u001c\u0010\u001b\u001a\u00020\u00152\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH&¨\u0006\u001c"}, d2 = {"Lcom/reddit/frontpage/domain/repository/AccountRepository;", "", "getAccount", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "username", "", "getAccountForced", "getFileUploadLease", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/FileUploadLease;", "userSubredditDisplayName", "params", "", "getMyAccount", "getUserSubredditSettings", "Lokhttp3/ResponseBody;", "isAccountCached", "", "removeAvatar", "Lcom/reddit/datalibrary/frontpage/data/model/DefaultAvatar;", "removeBanner", "Lio/reactivex/Completable;", "updateImage", "Lretrofit2/Response;", "updateShowingActiveCommunities", "profileSettings", "Lcom/reddit/datalibrary/frontpage/data/model/ProfileSettings;", "updateUserSubredditSettings", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountRepository.kt */
public interface AccountRepository {
    Completable m22391a(ProfileSettings profileSettings);

    Completable m22392a(Map<String, String> map);

    Single<Account> m22393a();

    Single<Account> m22394a(String str);

    Single<FileUploadLease> m22395a(String str, Map<String, String> map);

    Single<Account> m22396b(String str);

    Single<Response<ResponseBody>> m22397b(String str, Map<String, String> map);

    Single<Boolean> m22398c(String str);

    Single<ResponseBody> m22399d(String str);

    Single<DefaultAvatar> m22400e(String str);

    Completable m22401f(String str);
}
