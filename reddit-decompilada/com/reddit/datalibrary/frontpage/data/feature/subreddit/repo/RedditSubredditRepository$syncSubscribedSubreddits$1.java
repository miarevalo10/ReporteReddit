package com.reddit.datalibrary.frontpage.data.feature.subreddit.repo;

import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.remote.RemoteSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Subreddit;", "p1", "", "Lkotlin/ParameterName;", "name", "after", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditSubredditRepository.kt */
final class RedditSubredditRepository$syncSubscribedSubreddits$1 extends FunctionReference implements Function1<String, Single<Listing<? extends Subreddit>>> {
    RedditSubredditRepository$syncSubscribedSubreddits$1(RemoteSubredditDataSource remoteSubredditDataSource) {
        super(1, remoteSubredditDataSource);
    }

    public final KDeclarationContainer m20677a() {
        return Reflection.a(RemoteSubredditDataSource.class);
    }

    public final String m20678b() {
        return "getSubscribedSubreddits";
    }

    public final String m20679c() {
        return "getSubscribedSubreddits(Ljava/lang/String;)Lio/reactivex/Single;";
    }

    public final /* synthetic */ Object m20676a(Object obj) {
        return ((RemoteSubredditDataSource) this.b).getSubscribedSubreddits((String) obj);
    }
}
