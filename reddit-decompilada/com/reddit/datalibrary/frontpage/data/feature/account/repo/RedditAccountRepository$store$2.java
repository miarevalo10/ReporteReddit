package com.reddit.datalibrary.frontpage.data.feature.account.repo;

import com.nytimes.android.external.store3.base.Fetcher;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy.MemoryPolicyBuilder;
import com.nytimes.android.external.store3.base.impl.RealStoreBuilder;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;
import com.reddit.datalibrary.frontpage.data.feature.account.repo.RedditAccountRepository.Companion;
import com.reddit.datalibrary.frontpage.data.model.Account;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/nytimes/android/external/store3/base/impl/Store;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAccountRepository.kt */
final class RedditAccountRepository$store$2 extends Lambda implements Function0<Store<Account, String>> {
    final /* synthetic */ RedditAccountRepository f19339a;

    RedditAccountRepository$store$2(RedditAccountRepository redditAccountRepository) {
        this.f19339a = redditAccountRepository;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        RealStoreBuilder a = StoreBuilder.m8709a();
        a.f10249b = new Fetcher<Account, String>() {
            public final /* synthetic */ Single mo2915a(Object obj) {
                String str = (String) obj;
                Intrinsics.b(str, "username");
                return this.f19339a.f15759e.getAccount(str);
            }
        };
        a.f10248a = new AccountPersister(this.f19339a.f15760f, this.f19339a.f15758d);
        MemoryPolicyBuilder a2 = MemoryPolicy.m8700a();
        Companion companion = RedditAccountRepository.f15755b;
        a2 = a2.m8698a(RedditAccountRepository.f15756g.f10312a);
        companion = RedditAccountRepository.f15755b;
        a2.f10232a = RedditAccountRepository.f15756g.f10313b;
        a.f10250c = a2.m8699a();
        return a.m8705a().m8706b();
    }
}
