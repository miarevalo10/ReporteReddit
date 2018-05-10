package com.reddit.datalibrary.frontpage.data.feature.subreddit.repo;

import com.nytimes.android.external.store3.base.Fetcher;
import com.nytimes.android.external.store3.base.impl.RealStoreBuilder;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local.LocalSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.remote.RemoteSubredditDataSource.DefaultImpls;
import com.reddit.datalibrary.frontpage.data.model.PathKey;
import com.reddit.datalibrary.frontpage.data.model.SubredditListingDataModel;
import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00050\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/nytimes/android/external/store3/base/impl/Store;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "kotlin.jvm.PlatformType", "Lcom/reddit/datalibrary/frontpage/data/model/PathKey;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditSubredditRepository.kt */
final class RedditSubredditRepository$subredditListingStore$2 extends Lambda implements Function0<Store<List<? extends Subreddit>, PathKey>> {
    final /* synthetic */ RedditSubredditRepository f19427a;

    RedditSubredditRepository$subredditListingStore$2(RedditSubredditRepository redditSubredditRepository) {
        this.f19427a = redditSubredditRepository;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        RealStoreBuilder a = StoreBuilder.m8709a();
        a.f10249b = new Fetcher<List<? extends Subreddit>, PathKey>() {

            @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "it", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditListingDataModel;", "apply"}, k = 3, mv = {1, 1, 9})
            /* compiled from: RedditSubredditRepository.kt */
            static final class C15211<T, R> implements Function<T, R> {
                public static final C15211 f16202a = new C15211();

                C15211() {
                }

                public final /* synthetic */ Object apply(Object obj) {
                    SubredditListingDataModel subredditListingDataModel = (SubredditListingDataModel) obj;
                    Intrinsics.b(subredditListingDataModel, "it");
                    return subredditListingDataModel.getResult();
                }
            }

            public final /* synthetic */ Single mo2915a(Object obj) {
                PathKey pathKey = (PathKey) obj;
                Intrinsics.b(pathKey, "request");
                return DefaultImpls.getSubredditListing$default(this.f19427a.f16214d, pathKey.getPath(), pathKey.getParameters(), 0, 4, null).map(C15211.f16202a);
            }
        };
        a.f10248a = new SubredditListingPersister(new Function2<List<? extends Subreddit>, String, Single<Boolean>>(this.f19427a.f16215e) {
            public final KDeclarationContainer m20661a() {
                return Reflection.a(LocalSubredditDataSource.class);
            }

            public final String m20662b() {
                return "saveSubredditListing";
            }

            public final String m20663c() {
                return "saveSubredditListing(Ljava/util/List;Ljava/lang/String;)Lio/reactivex/Single;";
            }

            public final /* synthetic */ Object m20660a(Object obj, Object obj2) {
                List list = (List) obj;
                String str = (String) obj2;
                Intrinsics.b(list, "p1");
                Intrinsics.b(str, "p2");
                return ((LocalSubredditDataSource) this.b).mo2987a(list, str);
            }
        }, new Function1<String, Maybe<List<? extends Subreddit>>>(this.f19427a.f16215e) {
            public final KDeclarationContainer m20665a() {
                return Reflection.a(LocalSubredditDataSource.class);
            }

            public final String m20666b() {
                return "getSubredditListing";
            }

            public final String m20667c() {
                return "getSubredditListing(Ljava/lang/String;)Lio/reactivex/Maybe;";
            }

            public final /* synthetic */ Object m20664a(Object obj) {
                String str = (String) obj;
                Intrinsics.b(str, "p1");
                return ((LocalSubredditDataSource) this.b).mo2993d(str);
            }
        });
        return a.m8705a().m8706b();
    }
}
