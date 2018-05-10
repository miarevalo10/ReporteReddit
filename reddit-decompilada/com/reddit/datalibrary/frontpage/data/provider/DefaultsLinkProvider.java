package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallback;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.parceler.Parcel;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0003\u0015\u0016\u0017B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012 \b\u0002\u0010\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b0\u00070\u0006¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bH\u0016J0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00130\u0012H\u0014R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/DefaultsLinkProvider;", "Lcom/reddit/datalibrary/frontpage/data/provider/LinkListingProvider;", "ownerId", "", "defaultSub", "queryParameters", "Lkotlin/Function0;", "", "Lkotlin/Pair;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getSpec", "Lcom/reddit/datalibrary/frontpage/data/provider/ProviderSpec;", "makeRequest", "", "requestParams", "Lcom/reddit/datalibrary/frontpage/data/provider/ListingRequestParams;", "correlationId", "callback", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/AsyncCallback;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listing;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Companion", "DefaultType", "DefaultsLinkProviderSpec", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DefaultsLinkProvider.kt */
public final class DefaultsLinkProvider extends LinkListingProvider {
    public static final Companion f19429b = new Companion();
    private final String f19430e;
    private final Function0<List<Pair<String, String>>> f19431f;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/DefaultsLinkProvider$Companion;", "", "()V", "DEFAULT_ALL", "", "DEFAULT_POPULAR", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DefaultsLinkProvider.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0014R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/DefaultsLinkProvider$DefaultsLinkProviderSpec;", "Lcom/reddit/datalibrary/frontpage/data/provider/ProviderSpec;", "Lcom/reddit/datalibrary/frontpage/data/provider/DefaultsLinkProvider;", "ownerId", "", "subreddit", "(Ljava/lang/String;Ljava/lang/String;)V", "createProvider", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    @Parcel
    /* compiled from: DefaultsLinkProvider.kt */
    public static final class DefaultsLinkProviderSpec extends ProviderSpec<DefaultsLinkProvider> {
        public final String subreddit;

        public DefaultsLinkProviderSpec(String str, String str2) {
            Intrinsics.b(str2, "subreddit");
            super(str);
            this.subreddit = str2;
        }

        protected final DefaultsLinkProvider createProvider() {
            String str = this.ownerId;
            Intrinsics.a(str, "ownerId");
            return new DefaultsLinkProvider(str, this.subreddit);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 1, 9})
    /* compiled from: DefaultsLinkProvider.kt */
    static final class C17261 extends Lambda implements Function0<List<? extends Pair<? extends String, ? extends String>>> {
        public static final C17261 f19428a = new C17261();

        C17261() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            return CollectionsKt.a();
        }
    }

    public DefaultsLinkProvider(String str, String str2, Function0<? extends List<Pair<String, String>>> function0) {
        Intrinsics.b(str, "ownerId");
        Intrinsics.b(str2, "defaultSub");
        Intrinsics.b(function0, "queryParameters");
        super(str);
        this.f19430e = str2;
        this.f19431f = function0;
    }

    public final ProviderSpec<DefaultsLinkProvider> mo4201a() {
        return new DefaultsLinkProviderSpec(getOwnerId(), this.f19430e);
    }

    protected final void mo4202a(ListingRequestParams listingRequestParams, String str, AsyncCallback<Listing<? extends Listable>> asyncCallback) {
        Intrinsics.b(listingRequestParams, "requestParams");
        Intrinsics.b(asyncCallback, "callback");
        this.d.m8991a(this.f19430e, listingRequestParams, (List) this.f19431f.invoke(), str, asyncCallback);
    }
}
