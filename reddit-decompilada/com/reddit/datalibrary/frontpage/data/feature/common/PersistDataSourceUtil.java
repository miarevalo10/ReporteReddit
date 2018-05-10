package com.reddit.datalibrary.frontpage.data.feature.common;

import com.nytimes.android.external.store3.base.Persister;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.Subreddit;
import com.squareup.moshi.JsonAdapter;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\t\u001a\u0002H\u00072\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u00070\f0\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J[\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0004\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\t\u001a\u0002H\u00072\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u00070\f0\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u000fH\u0000¢\u0006\u0004\b\u0015\u0010\u0011Jc\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u0002H\u00072\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u00070\f0\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000fH\u0000¢\u0006\u0004\b\u001a\u0010\u001bJc\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\t\u001a\u0002H\u00072\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u00070\f0\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u000fH\u0000¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/common/PersistDataSourceUtil;", "", "()V", "readLinks", "Lio/reactivex/Maybe;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "T", "Lcom/reddit/datalibrary/frontpage/data/feature/common/Key;", "key", "persister", "Lkotlin/Lazy;", "Lcom/nytimes/android/external/store3/base/Persister;", "Lokio/BufferedSource;", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "readLinks$app_standardRelease", "(Lcom/reddit/datalibrary/frontpage/data/feature/common/Key;Lkotlin/Lazy;Lcom/squareup/moshi/JsonAdapter;)Lio/reactivex/Maybe;", "readSubreddits", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "readSubreddits$app_standardRelease", "saveLinks", "Lio/reactivex/Single;", "", "links", "saveLinks$app_standardRelease", "(Lcom/reddit/datalibrary/frontpage/data/model/Listing;Lcom/reddit/datalibrary/frontpage/data/feature/common/Key;Lkotlin/Lazy;Lcom/squareup/moshi/JsonAdapter;)Lio/reactivex/Single;", "saveSubreddits", "subreddits", "saveSubreddits$app_standardRelease", "(Ljava/util/List;Lcom/reddit/datalibrary/frontpage/data/feature/common/Key;Lkotlin/Lazy;Lcom/squareup/moshi/JsonAdapter;)Lio/reactivex/Single;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PersistDataSourceUtil.kt */
public final class PersistDataSourceUtil {
    public static final PersistDataSourceUtil f10382a = new PersistDataSourceUtil();

    private PersistDataSourceUtil() {
    }

    public static <T extends Key> Single<Boolean> m8822a(Listing<Link> listing, T t, Lazy<? extends Persister<BufferedSource, T>> lazy, JsonAdapter<Listing<Link>> jsonAdapter) {
        Intrinsics.b(listing, "links");
        Intrinsics.b(t, "key");
        Intrinsics.b(lazy, "persister");
        Intrinsics.b(jsonAdapter, "adapter");
        listing = Single.fromCallable(new PersistDataSourceUtil$saveLinks$1(jsonAdapter, listing)).flatMap((Function) new PersistDataSourceUtil$saveLinks$2(lazy, t)).onErrorReturn((Function) PersistDataSourceUtil$saveLinks$3.f15824a);
        Intrinsics.a(listing, "Single.fromCallable {\n  …s\", it)\n      false\n    }");
        return listing;
    }

    public static <T extends Key> Maybe<Listing<Link>> m8821a(T t, Lazy<? extends Persister<BufferedSource, T>> lazy, JsonAdapter<Listing<Link>> jsonAdapter) {
        Intrinsics.b(t, "key");
        Intrinsics.b(lazy, "persister");
        Intrinsics.b(jsonAdapter, "adapter");
        t = ((Persister) lazy.b()).mo2708a(t).map((Function) new PersistDataSourceUtil$readLinks$1(jsonAdapter)).onErrorComplete();
        Intrinsics.a(t, "persister.value.read(key…!\n    }.onErrorComplete()");
        return t;
    }

    public static <T extends Key> Single<Boolean> m8823a(List<Subreddit> list, T t, Lazy<? extends Persister<BufferedSource, T>> lazy, JsonAdapter<List<Subreddit>> jsonAdapter) {
        Intrinsics.b(list, "subreddits");
        Intrinsics.b(t, "key");
        Intrinsics.b(lazy, "persister");
        Intrinsics.b(jsonAdapter, "adapter");
        list = Single.fromCallable(new PersistDataSourceUtil$saveSubreddits$1(jsonAdapter, list)).flatMap((Function) new PersistDataSourceUtil$saveSubreddits$2(lazy, t)).onErrorReturn((Function) PersistDataSourceUtil$saveSubreddits$3.f15827a);
        Intrinsics.a(list, "Single.fromCallable {\n  …s\", it)\n      false\n    }");
        return list;
    }

    public static <T extends Key> Maybe<List<Subreddit>> m8824b(T t, Lazy<? extends Persister<BufferedSource, T>> lazy, JsonAdapter<List<Subreddit>> jsonAdapter) {
        Intrinsics.b(t, "key");
        Intrinsics.b(lazy, "persister");
        Intrinsics.b(jsonAdapter, "adapter");
        t = ((Persister) lazy.b()).mo2708a(t).map((Function) new PersistDataSourceUtil$readSubreddits$1(jsonAdapter)).onErrorComplete();
        Intrinsics.a(t, "persister.value.read(key…!\n    }.onErrorComplete()");
        return t;
    }
}
