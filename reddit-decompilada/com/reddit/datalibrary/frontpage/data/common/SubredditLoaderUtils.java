package com.reddit.datalibrary.frontpage.data.common;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2 \u0010\t\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\u00040\nJP\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\u00042 \u0010\r\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\u00040\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\u0010"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/SubredditLoaderUtils;", "", "()V", "getAllFromFetcher", "Lio/reactivex/Single;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "after", "", "fetcher", "Lkotlin/Function1;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "getSubreddits", "remoteApi", "subs", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditLoaderUtils.kt */
public final class SubredditLoaderUtils {
    public static final SubredditLoaderUtils f10303a = new SubredditLoaderUtils();

    private SubredditLoaderUtils() {
    }

    public static Single<List<Subreddit>> m8758a(String str, Function1<? super String, ? extends Single<Listing<Subreddit>>> function1) {
        Intrinsics.b(function1, "fetcher");
        str = m8761b(function1, new ArrayList(), str).map((Function) SubredditLoaderUtils$getAllFromFetcher$1.f15723a);
        Intrinsics.a(str, "getSubreddits(fetcher, m…fter).map { it.children }");
        return str;
    }

    private static Single<Listing<Subreddit>> m8761b(Function1<? super String, ? extends Single<Listing<Subreddit>>> function1, List<Subreddit> list, String str) {
        function1 = ((Single) function1.a(str)).flatMap(new SubredditLoaderUtils$getSubreddits$1(function1, list));
        Intrinsics.a(function1, "remoteApi(after).flatMap…)\n        }\n      }\n    }");
        return function1;
    }
}
