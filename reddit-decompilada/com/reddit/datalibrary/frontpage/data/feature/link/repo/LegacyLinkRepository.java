package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import android.text.TextUtils;
import bolts.Task;
import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallback;
import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallbackContinuation;
import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LocalLinkDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteLinkDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.provider.ListingRequestParams;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.ListingModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Pair;

@Singleton
@Deprecated
public class LegacyLinkRepository {
    final RemoteLinkDataSourceLegacy f10704a;
    final LocalLinkDataSourceLegacy f10705b;

    static final /* synthetic */ Iterable m8985a(List list) throws Exception {
        return list;
    }

    @Inject
    public LegacyLinkRepository(RemoteLinkDataSourceLegacy remoteLinkDataSourceLegacy, LocalLinkDataSourceLegacy localLinkDataSourceLegacy) {
        this.f10704a = remoteLinkDataSourceLegacy;
        this.f10705b = localLinkDataSourceLegacy;
    }

    public final void m8989a(ListingRequestParams listingRequestParams, String str, AsyncCallback<Listing<? extends Listable>> asyncCallback, List<Pair<String, String>> list) {
        Collection arrayList = new ArrayList();
        str = m8983a(new LegacyLinkRepository$$Lambda$0(this, listingRequestParams, list, str));
        arrayList.add(str);
        TextUtils.isEmpty(listingRequestParams.f10791a);
        Task.m2406a(arrayList).m2414a(new LegacyLinkRepository$$Lambda$1(str, asyncCallback), Task.f2715b);
    }

    static final /* synthetic */ Object m8986a(Task task, AsyncCallback asyncCallback, Task task2) throws Exception {
        if (task.m2419d()) {
            asyncCallback.mo3013a(task2.m2421f());
        }
        asyncCallback.mo3014a((Listing) task.m2420e());
        return null;
    }

    static final /* synthetic */ Listing m8984a(List list, Listing listing) throws Exception {
        if (listing instanceof ListingModel) {
            ((ListingModel) listing).setVideoLinks(list);
        }
        return listing;
    }

    public final void m8991a(String str, ListingRequestParams listingRequestParams, List<Pair<String, String>> list, String str2, AsyncCallback<Listing<? extends Listable>> asyncCallback) {
        m8992a(new LegacyLinkRepository$$Lambda$12(this, str, listingRequestParams, list, str2), (AsyncCallback) asyncCallback);
    }

    public final void m8990a(Link link) {
        Task.m2407a(new LegacyLinkRepository$$Lambda$16(this, link));
    }

    public final <T extends Listable> void m8992a(Callable<Listing<? extends T>> callable, AsyncCallback<Listing<? extends T>> asyncCallback) {
        m8983a((Callable) callable).m2414a(AsyncCallbackContinuation.m15917a((AsyncCallback) asyncCallback), Task.f2715b);
    }

    private <T extends Listable> Task<Listing<? extends T>> m8983a(Callable<Listing<? extends T>> callable) {
        return Task.m2407a((Callable) callable).m2413a(new LegacyLinkRepository$$Lambda$19(this));
    }
}
