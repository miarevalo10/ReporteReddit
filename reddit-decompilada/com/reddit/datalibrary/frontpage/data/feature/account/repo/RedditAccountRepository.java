package com.reddit.datalibrary.frontpage.data.feature.account.repo;

import com.nytimes.android.external.store3.base.Persister;
import com.nytimes.android.external.store3.base.RecordProvider;
import com.nytimes.android.external.store3.base.RecordState;
import com.nytimes.android.external.store3.base.impl.Store;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.Thread;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.LocalAccountDataSource;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.remote.RemoteAccountDataSource;
import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.DefaultAvatar;
import com.reddit.datalibrary.frontpage.data.model.ProfileSettings;
import com.reddit.datalibrary.frontpage.requests.models.v2.FileUploadLease;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import com.reddit.frontpage.util.kotlin.MaybesKt;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.ResponseBody;
import retrofit2.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0003)*+B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00122\u0006\u0010\u0017\u001a\u00020\f2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0019H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00122\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00122\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\fH\u0016J0\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0$0\u00122\u0006\u0010\u0017\u001a\u00020\f2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0019H\u0016J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'H\u0016J\u001c\u0010(\u001a\u00020\"2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006,"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/account/repo/RedditAccountRepository;", "Lcom/reddit/frontpage/domain/repository/AccountRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/remote/RemoteAccountDataSource;", "local", "Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/local/LocalAccountDataSource;", "(Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/remote/RemoteAccountDataSource;Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/local/LocalAccountDataSource;)V", "store", "Lcom/nytimes/android/external/store3/base/impl/Store;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "", "getStore", "()Lcom/nytimes/android/external/store3/base/impl/Store;", "store$delegate", "Lkotlin/Lazy;", "getAccount", "Lio/reactivex/Single;", "username", "getAccountForced", "getFileUploadLease", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/FileUploadLease;", "userSubredditDisplayName", "params", "", "getMyAccount", "getUserSubredditSettings", "Lokhttp3/ResponseBody;", "isAccountCached", "", "removeAvatar", "Lcom/reddit/datalibrary/frontpage/data/model/DefaultAvatar;", "removeBanner", "Lio/reactivex/Completable;", "updateImage", "Lretrofit2/Response;", "updateShowingActiveCommunities", "profileSettings", "Lcom/reddit/datalibrary/frontpage/data/model/ProfileSettings;", "updateUserSubredditSettings", "AccountPersister", "Companion", "Duration", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditAccountRepository.kt */
public final class RedditAccountRepository implements AccountRepository {
    static final /* synthetic */ KProperty[] f15754a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(RedditAccountRepository.class), "store", "getStore()Lcom/nytimes/android/external/store3/base/impl/Store;"))};
    public static final Companion f15755b = new Companion();
    private static final Duration f15756g = new Duration(TimeUnit.MINUTES);
    private final Lazy f15757c = LazyKt.a((Function0) new RedditAccountRepository$store$2(this));
    private final BackgroundThread f15758d;
    private final RemoteAccountDataSource f15759e;
    private final LocalAccountDataSource f15760f;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/account/repo/RedditAccountRepository$Companion;", "", "()V", "ONE_MINUTE_DURATION", "Lcom/reddit/datalibrary/frontpage/data/feature/account/repo/RedditAccountRepository$Duration;", "getONE_MINUTE_DURATION", "()Lcom/reddit/datalibrary/frontpage/data/feature/account/repo/RedditAccountRepository$Duration;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditAccountRepository.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/account/repo/RedditAccountRepository$Duration;", "", "duration", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)V", "getDuration", "()J", "getTimeUnit", "()Ljava/util/concurrent/TimeUnit;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditAccountRepository.kt */
    private static final class Duration {
        final long f10312a = 1;
        final TimeUnit f10313b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Duration) {
                Duration duration = (Duration) obj;
                return ((this.f10312a > duration.f10312a ? 1 : (this.f10312a == duration.f10312a ? 0 : -1)) == 0) && Intrinsics.a(this.f10313b, duration.f10313b);
            }
        }

        public final int hashCode() {
            long j = this.f10312a;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            TimeUnit timeUnit = this.f10313b;
            return i + (timeUnit != null ? timeUnit.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Duration(duration=");
            stringBuilder.append(this.f10312a);
            stringBuilder.append(", timeUnit=");
            stringBuilder.append(this.f10313b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Duration(TimeUnit timeUnit) {
            Intrinsics.b(timeUnit, "timeUnit");
            this.f10313b = timeUnit;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00030\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/account/repo/RedditAccountRepository$AccountPersister;", "Lcom/nytimes/android/external/store3/base/Persister;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "", "Lcom/nytimes/android/external/store3/base/RecordProvider;", "local", "Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/local/LocalAccountDataSource;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "(Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/local/LocalAccountDataSource;Lcom/reddit/common/rx/BackgroundThread;)V", "getRecordState", "Lcom/nytimes/android/external/store3/base/RecordState;", "key", "read", "Lio/reactivex/Maybe;", "username", "write", "Lio/reactivex/Single;", "", "account", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditAccountRepository.kt */
    private static final class AccountPersister implements Persister<Account, String>, RecordProvider<String> {
        private final LocalAccountDataSource f18681a;
        private final BackgroundThread f18682b;

        public AccountPersister(LocalAccountDataSource localAccountDataSource, BackgroundThread backgroundThread) {
            Intrinsics.b(localAccountDataSource, "local");
            Intrinsics.b(backgroundThread, "backgroundThread");
            this.f18681a = localAccountDataSource;
            this.f18682b = backgroundThread;
        }

        public final /* synthetic */ Maybe mo2708a(Object obj) {
            String str = (String) obj;
            Intrinsics.b(str, "username");
            obj = Maybe.fromSingle(this.f18681a.mo2914a(str)).map(RedditAccountRepository$AccountPersister$read$1.f15751a);
            Intrinsics.a(obj, "Maybe.fromSingle(local.g…        .map { it.get() }");
            return MaybesKt.a(obj, this.f18682b);
        }

        public final /* synthetic */ Single mo2709a(Object obj, Object obj2) {
            Account account = (Account) obj2;
            Intrinsics.b((String) obj, "key");
            Intrinsics.b(account, "account");
            return SinglesKt.a(this.f18681a.mo2913a(account), (Thread) this.f18682b);
        }

        public final /* bridge */ /* synthetic */ RecordState mo3787b(Object obj) {
            Intrinsics.b((String) obj, "key");
            return RecordState.STALE;
        }
    }

    private final Store<Account, String> m15839c() {
        return (Store) this.f15757c.b();
    }

    public RedditAccountRepository(BackgroundThread backgroundThread, RemoteAccountDataSource remoteAccountDataSource, LocalAccountDataSource localAccountDataSource) {
        Intrinsics.b(backgroundThread, "backgroundThread");
        Intrinsics.b(remoteAccountDataSource, "remote");
        Intrinsics.b(localAccountDataSource, "local");
        this.f15758d = backgroundThread;
        this.f15759e = remoteAccountDataSource;
        this.f15760f = localAccountDataSource;
    }

    public final Single<Account> m15844a(String str) {
        Intrinsics.b(str, "username");
        str = m15839c().mo2713a(str);
        Intrinsics.a(str, "store.get(username)");
        return SinglesKt.a(str, this.f15758d);
    }

    public final Single<Account> m15846b(String str) {
        Intrinsics.b(str, "username");
        str = m15839c().mo2714b(str);
        Intrinsics.a(str, "store.fetch(username)");
        return SinglesKt.a(str, this.f15758d);
    }

    public final Single<Boolean> m15848c(String str) {
        Intrinsics.b(str, "username");
        str = SinglesKt.a(this.f15760f.mo2914a(str), this.f15758d).map(RedditAccountRepository$isAccountCached$1.f15752a);
        Intrinsics.a(str, "local.getByUsername(user…    .map { it.isPresent }");
        return str;
    }

    public final Single<Account> m15843a() {
        return this.f15759e.getMyAccount();
    }

    public final Single<ResponseBody> m15849d(String str) {
        Intrinsics.b(str, "userSubredditDisplayName");
        return SinglesKt.a(this.f15759e.getUserSubredditSettings(str), this.f15758d);
    }

    public final Completable m15842a(Map<String, String> map) {
        Intrinsics.b(map, "params");
        return CompletablesKt.a(this.f15759e.updateUserSubredditSettings(map), this.f15758d);
    }

    public final Completable m15841a(ProfileSettings profileSettings) {
        Intrinsics.b(profileSettings, "profileSettings");
        return CompletablesKt.a(this.f15759e.updateShowingActiveCommunities(profileSettings), this.f15758d);
    }

    public final Single<FileUploadLease> m15845a(String str, Map<String, String> map) {
        Intrinsics.b(str, "userSubredditDisplayName");
        Intrinsics.b(map, "params");
        return SinglesKt.a(this.f15759e.getFileUploadLease(str, map), (Thread) this.f15758d);
    }

    public final Single<Response<ResponseBody>> m15847b(String str, Map<String, String> map) {
        Intrinsics.b(str, "userSubredditDisplayName");
        Intrinsics.b(map, "params");
        return SinglesKt.a(this.f15759e.updateImage(str, map), (Thread) this.f15758d);
    }

    public final Single<DefaultAvatar> m15850e(String str) {
        Intrinsics.b(str, "userSubredditDisplayName");
        return SinglesKt.a(this.f15759e.removeAvatar(str), this.f15758d);
    }

    public final Completable m15851f(String str) {
        Intrinsics.b(str, "userSubredditDisplayName");
        return CompletablesKt.a(this.f15759e.removeBanner(str), this.f15758d);
    }
}
