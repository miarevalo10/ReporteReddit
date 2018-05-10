package com.reddit.datalibrary.frontpage.data.feature.karma.repo;

import com.nytimes.android.external.store3.base.Fetcher;
import com.nytimes.android.external.store3.base.impl.RealStoreBuilder;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;
import com.reddit.datalibrary.frontpage.data.model.Envelope;
import com.reddit.frontpage.domain.model.Karma;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a*\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00050\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/nytimes/android/external/store3/base/impl/Store;", "", "Lcom/reddit/frontpage/domain/model/Karma;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditKarmaRepository.kt */
final class RedditKarmaRepository$store$2 extends Lambda implements Function0<Store<List<? extends Karma>, String>> {
    final /* synthetic */ RedditKarmaRepository f19362a;

    RedditKarmaRepository$store$2(RedditKarmaRepository redditKarmaRepository) {
        this.f19362a = redditKarmaRepository;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        RedditKarmaRepository$store$2$perister$1 redditKarmaRepository$store$2$perister$1 = new RedditKarmaRepository$store$2$perister$1(this);
        RealStoreBuilder a = StoreBuilder.m8709a();
        a.f10249b = new Fetcher<List<? extends Karma>, String>() {

            @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/domain/model/Karma;", "it", "Lcom/reddit/datalibrary/frontpage/data/model/Envelope;", "apply"}, k = 3, mv = {1, 1, 9})
            /* compiled from: RedditKarmaRepository.kt */
            static final class C14971<T, R> implements Function<T, R> {
                public static final C14971 f15850a = new C14971();

                C14971() {
                }

                public final /* synthetic */ Object apply(Object obj) {
                    Envelope envelope = (Envelope) obj;
                    Intrinsics.b(envelope, "it");
                    List list = (List) envelope.getData();
                    return list == null ? CollectionsKt.a() : list;
                }
            }

            public final /* synthetic */ Single mo2915a(Object obj) {
                String str = (String) obj;
                Intrinsics.b(str, "username");
                return this.f19362a.f15855d.getTopKarma(str).map(C14971.f15850a);
            }
        };
        a.f10248a = redditKarmaRepository$store$2$perister$1;
        return a.m8705a().m8706b();
    }
}
