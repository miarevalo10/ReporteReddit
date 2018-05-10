package com.reddit.datalibrary.frontpage.data.feature.subreddit.repo;

import com.nytimes.android.external.store3.base.Persister;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.Thread;
import com.reddit.datalibrary.frontpage.data.common.SubredditLoaderUtils;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local.LocalSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.remote.RemoteSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.model.PathKey;
import com.reddit.frontpage.domain.model.Multireddit;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository.SubredditAction;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u00014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0013H\u0016J\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u000b0\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010#\u001a\u00020\u0016H\u0016J8\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00132\u0006\u0010%\u001a\u00020\u00162\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160'2\u0006\u0010(\u001a\u00020\u0014H\u0016J\u001c\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0016H\u0016J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0010\u0010/\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0016H\u0016J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u00101\u001a\u00020\fH\u0016J&\u00100\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u00102\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R-\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u00065"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/repo/RedditSubredditRepository;", "Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/remote/RemoteSubredditDataSource;", "local", "Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/local/LocalSubredditDataSource;", "(Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/remote/RemoteSubredditDataSource;Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/local/LocalSubredditDataSource;)V", "subredditListingStore", "Lcom/nytimes/android/external/store3/base/impl/Store;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "Lcom/reddit/datalibrary/frontpage/data/model/PathKey;", "getSubredditListingStore", "()Lcom/nytimes/android/external/store3/base/impl/Store;", "subredditListingStore$delegate", "Lkotlin/Lazy;", "addOrUpdateRecentSubreddit", "Lio/reactivex/Single;", "", "username", "", "subreddit", "deleteRecentSubreddit", "Lio/reactivex/Completable;", "kindWithId", "getDefaultSubreddits", "getFavoriteSubreddits", "getFollowingSubreddits", "getModeratedSubreddits", "getMultireddits", "Lcom/reddit/frontpage/domain/model/Multireddit;", "getRecentSubreddits", "getSubreddit", "subredditName", "getSubredditListing", "path", "parameters", "", "refresh", "getSubscribedSubreddits", "subscribe", "syncDefaultSubreddits", "syncModeratedSubreddits", "syncMultireddits", "syncSubscribedSubreddits", "unsubscribe", "updateFavoriteState", "favoriteSubreddit", "subredditId", "favorite", "SubredditListingPersister", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditSubredditRepository.kt */
public final class RedditSubredditRepository implements SubredditRepository {
    static final /* synthetic */ KProperty[] f16211a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(RedditSubredditRepository.class), "subredditListingStore", "getSubredditListingStore()Lcom/nytimes/android/external/store3/base/impl/Store;"))};
    private final Lazy f16212b = LazyKt.a((Function0) new RedditSubredditRepository$subredditListingStore$2(this));
    private final BackgroundThread f16213c;
    private final RemoteSubredditDataSource f16214d;
    private final LocalSubredditDataSource f16215e;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001Bx\u0012B\u0010\u0005\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0006\u0012-\u0010\u000e\u001a)\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R5\u0010\u000e\u001a)\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000RJ\u0010\u0005\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/repo/RedditSubredditRepository$SubredditListingPersister;", "Lcom/nytimes/android/external/store3/base/Persister;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "Lcom/reddit/datalibrary/frontpage/data/model/PathKey;", "persist", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "subreddits", "", "key", "Lio/reactivex/Single;", "", "fetch", "Lkotlin/Function1;", "Lio/reactivex/Maybe;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "read", "write", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditSubredditRepository.kt */
    private static final class SubredditListingPersister implements Persister<List<? extends Subreddit>, PathKey> {
        private final Function2<List<Subreddit>, String, Single<Boolean>> f18716a;
        private final Function1<String, Maybe<List<Subreddit>>> f18717b;

        public SubredditListingPersister(Function2<? super List<Subreddit>, ? super String, ? extends Single<Boolean>> function2, Function1<? super String, ? extends Maybe<List<Subreddit>>> function1) {
            Intrinsics.b(function2, "persist");
            Intrinsics.b(function1, "fetch");
            this.f18716a = function2;
            this.f18717b = function1;
        }

        public final /* synthetic */ Maybe mo2708a(Object obj) {
            PathKey pathKey = (PathKey) obj;
            Intrinsics.b(pathKey, "key");
            return (Maybe) this.f18717b.a(pathKey.toString());
        }

        public final /* synthetic */ Single mo2709a(Object obj, Object obj2) {
            PathKey pathKey = (PathKey) obj;
            List list = (List) obj2;
            Intrinsics.b(pathKey, "key");
            Intrinsics.b(list, "subreddits");
            return (Single) this.f18716a.a(list, pathKey.toString());
        }
    }

    public RedditSubredditRepository(BackgroundThread backgroundThread, RemoteSubredditDataSource remoteSubredditDataSource, LocalSubredditDataSource localSubredditDataSource) {
        Intrinsics.b(backgroundThread, "backgroundThread");
        Intrinsics.b(remoteSubredditDataSource, "remote");
        Intrinsics.b(localSubredditDataSource, "local");
        this.f16213c = backgroundThread;
        this.f16214d = remoteSubredditDataSource;
        this.f16215e = localSubredditDataSource;
    }

    public final Single<Subreddit> m16173a(String str) {
        Intrinsics.b(str, "subredditName");
        str = this.f16215e.mo2982a(str).switchIfEmpty(this.f16214d.getSubreddit(str).flatMap(new RedditSubredditRepository$getSubreddit$remoteSubreddit$1(this)));
        Intrinsics.a(str, "localSubreddit.switchIfEmpty(remoteSubreddit)");
        return SinglesKt.a(str, this.f16213c);
    }

    public final Single<Boolean> m16172a() {
        Single flatMap = this.f16214d.getMultireddits().flatMap(new RedditSubredditRepository$syncMultireddits$1(this));
        Intrinsics.a(flatMap, "remote.getMultireddits()…al.saveMultireddits(it) }");
        return SinglesKt.a(flatMap, this.f16213c);
    }

    public final Single<Boolean> m16177b() {
        SubredditLoaderUtils subredditLoaderUtils = SubredditLoaderUtils.f10303a;
        Single flatMap = SubredditLoaderUtils.m8758a(null, new RedditSubredditRepository$syncDefaultSubreddits$1(this.f16214d)).flatMap(new RedditSubredditRepository$syncDefaultSubreddits$2(this));
        Intrinsics.a(flatMap, "SubredditLoaderUtils.get…ocal.saveSubreddits(it) }");
        return SinglesKt.a(flatMap, this.f16213c);
    }

    public final Single<Boolean> m16179c() {
        SubredditLoaderUtils subredditLoaderUtils = SubredditLoaderUtils.f10303a;
        Single flatMap = SubredditLoaderUtils.m8758a(null, new RedditSubredditRepository$syncSubscribedSubreddits$1(this.f16214d)).flatMap(new RedditSubredditRepository$syncSubscribedSubreddits$2(this));
        Intrinsics.a(flatMap, "SubredditLoaderUtils.get…ocal.saveSubreddits(it) }");
        return SinglesKt.a(flatMap, this.f16213c);
    }

    public final Single<Boolean> m16181d() {
        SubredditLoaderUtils subredditLoaderUtils = SubredditLoaderUtils.f10303a;
        Single flatMap = SubredditLoaderUtils.m8758a(null, new RedditSubredditRepository$syncModeratedSubreddits$1(this.f16214d)).flatMap(new RedditSubredditRepository$syncModeratedSubreddits$2(this));
        Intrinsics.a(flatMap, "SubredditLoaderUtils.get…ocal.saveSubreddits(it) }");
        return SinglesKt.a(flatMap, this.f16213c);
    }

    public final Single<List<Multireddit>> m16178b(String str) {
        Intrinsics.b(str, "username");
        str = this.f16215e.mo2988b().concatWith(this.f16214d.getMultireddits().flatMap(new RedditSubredditRepository$getMultireddits$remoteData$1(this))).filter(RedditSubredditRepository$getMultireddits$1.f16190a).onErrorReturn(RedditSubredditRepository$getMultireddits$2.f16191a).first(CollectionsKt.a());
        Intrinsics.a(str, "localData.concatWith(rem…      .first(emptyList())");
        return SinglesKt.a(str, this.f16213c);
    }

    public final Single<List<Subreddit>> m16183e() {
        Single a = this.f16215e.mo2983a();
        SubredditLoaderUtils subredditLoaderUtils = SubredditLoaderUtils.f10303a;
        a = a.concatWith(SubredditLoaderUtils.m8758a(null, new RedditSubredditRepository$getDefaultSubreddits$remoteData$1(this.f16214d)).flatMap(new RedditSubredditRepository$getDefaultSubreddits$remoteData$2(this))).filter(RedditSubredditRepository$getDefaultSubreddits$1.f16181a).doOnError(RedditSubredditRepository$getDefaultSubreddits$2.f16182a).onErrorReturn(RedditSubredditRepository$getDefaultSubreddits$3.f16183a).first(CollectionsKt.a());
        Intrinsics.a(a, "localData.concatWith(rem…      .first(emptyList())");
        return SinglesKt.a(a, this.f16213c);
    }

    public final Single<List<Subreddit>> m16180c(String str) {
        Intrinsics.b(str, "username");
        str = this.f16215e.mo2995e();
        SubredditLoaderUtils subredditLoaderUtils = SubredditLoaderUtils.f10303a;
        str = str.concatWith(SubredditLoaderUtils.m8758a(null, new RedditSubredditRepository$getSubscribedSubreddits$remoteData$1(this.f16214d)).flatMap(new RedditSubredditRepository$getSubscribedSubreddits$remoteData$2(this)).map(RedditSubredditRepository$getSubscribedSubreddits$remoteData$3.f16201a)).filter(RedditSubredditRepository$getSubscribedSubreddits$1.f16196a).doOnError(RedditSubredditRepository$getSubscribedSubreddits$2.f16197a).onErrorReturn(RedditSubredditRepository$getSubscribedSubreddits$3.f16198a).first(CollectionsKt.a());
        Intrinsics.a(str, "localData.concatWith(rem…      .first(emptyList())");
        return SinglesKt.a(str, this.f16213c);
    }

    public final Single<List<Subreddit>> m16182d(String str) {
        Intrinsics.b(str, "username");
        str = this.f16215e.mo2997f();
        SubredditLoaderUtils subredditLoaderUtils = SubredditLoaderUtils.f10303a;
        str = str.concatWith(SubredditLoaderUtils.m8758a(null, new RedditSubredditRepository$getModeratedSubreddits$remoteData$1(this.f16214d)).flatMap(new RedditSubredditRepository$getModeratedSubreddits$remoteData$2(this))).filter(RedditSubredditRepository$getModeratedSubreddits$1.f16186a).onErrorReturn(RedditSubredditRepository$getModeratedSubreddits$2.f16187a).first(CollectionsKt.a());
        Intrinsics.a(str, "localData.concatWith(rem…      .first(emptyList())");
        return SinglesKt.a(str, this.f16213c);
    }

    public final Single<List<Subreddit>> m16184e(String str) {
        Intrinsics.b(str, "username");
        return SinglesKt.a(this.f16215e.mo2991c(), this.f16213c);
    }

    public final Single<List<Subreddit>> m16185f(String str) {
        Intrinsics.b(str, "username");
        return SinglesKt.a(this.f16215e.mo2994d(), this.f16213c);
    }

    public final Single<Boolean> m16175a(String str, String str2, boolean z) {
        Intrinsics.b(str, "subredditId");
        Intrinsics.b(str2, "subredditName");
        str = this.f16214d.postFavorites(z, str2).toSingleDefault(Boolean.valueOf(true)).onErrorReturnItem(Boolean.valueOf(false)).zipWith(this.f16215e.mo2985a(str, z), (BiFunction) RedditSubredditRepository$updateFavoriteState$1.f16210a);
        Intrinsics.a(str, "remoteSave.zipWith(local…        remote\n        })");
        return SinglesKt.a(str, (Thread) this.f16213c);
    }

    public final Completable m16186g(String str) {
        Intrinsics.b(str, "subredditName");
        str = this.f16214d.setSubscriptionState(str, SubredditAction.a).andThen(this.f16215e.mo2989b(str).flatMapCompletable(new RedditSubredditRepository$subscribe$1(this, str)));
        Intrinsics.a(str, "remoteSubscribe.andThen(…        }\n        }\n    )");
        return CompletablesKt.a(str, this.f16213c);
    }

    public final Completable m16187h(String str) {
        Intrinsics.b(str, "subredditName");
        str = this.f16214d.setSubscriptionState(str, SubredditAction.b).andThen(this.f16215e.mo2992c(str)).toCompletable();
        Intrinsics.a(str, "unsubscribeSubreddit.and…\n        .toCompletable()");
        return CompletablesKt.a(str, this.f16213c);
    }

    public final Single<List<Subreddit>> m16176a(String str, Map<String, String> map) {
        Intrinsics.b(str, "path");
        Intrinsics.b(map, "parameters");
        str = new RedditSubredditRepository$getSubredditListing$1(this, new PathKey(str, map)).m20655a();
        Intrinsics.a(str, "retrieve()");
        return SinglesKt.a(str, (Thread) this.f16213c);
    }

    public final Single<Boolean> m16174a(String str, Subreddit subreddit) {
        Intrinsics.b(str, "username");
        Intrinsics.b(subreddit, "subreddit");
        return SinglesKt.a(this.f16215e.mo2984a(str, subreddit), (Thread) this.f16213c);
    }

    public final Single<List<Subreddit>> m16188i(String str) {
        Intrinsics.b(str, "username");
        return SinglesKt.a(this.f16215e.mo2996e(str), this.f16213c);
    }

    public final Completable m16171a(String str, String str2) {
        Intrinsics.b(str, "username");
        Intrinsics.b(str2, "kindWithId");
        return CompletablesKt.a(this.f16215e.mo2981a(str, str2), (Thread) this.f16213c);
    }
}
