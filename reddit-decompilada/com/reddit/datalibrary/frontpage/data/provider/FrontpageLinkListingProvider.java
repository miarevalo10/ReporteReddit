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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n0\t0\b¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\rH\u0016J2\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0013\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\u0018\u00010\u0014H\u0014R&\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n0\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/FrontpageLinkListingProvider;", "Lcom/reddit/datalibrary/frontpage/data/provider/LinkListingProvider;", "ownerId", "", "initialSort", "", "initalSortTimeframe", "queryParams", "Lkotlin/Function0;", "", "Lkotlin/Pair;", "(Ljava/lang/String;IILkotlin/jvm/functions/Function0;)V", "getSpec", "Lcom/reddit/datalibrary/frontpage/data/provider/ProviderSpec;", "makeRequest", "", "requestParams", "Lcom/reddit/datalibrary/frontpage/data/provider/ListingRequestParams;", "correlationId", "callback", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/AsyncCallback;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listing;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "FrontpageListingProviderSpec", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FrontpageLinkListingProvider.kt */
public final class FrontpageLinkListingProvider extends LinkListingProvider {
    private final Function0<List<Pair<String, String>>> f19433b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\u0002H\u0014R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\r"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/FrontpageLinkListingProvider$FrontpageListingProviderSpec;", "Lcom/reddit/datalibrary/frontpage/data/provider/ProviderSpec;", "Lcom/reddit/datalibrary/frontpage/data/provider/FrontpageLinkListingProvider;", "ownerId", "", "initialSort", "", "initalSortTimeframe", "(Ljava/lang/String;II)V", "getInitalSortTimeframe", "()I", "getInitialSort", "createProvider", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    @Parcel
    /* compiled from: FrontpageLinkListingProvider.kt */
    public static final class FrontpageListingProviderSpec extends ProviderSpec<FrontpageLinkListingProvider> {
        private final int initalSortTimeframe;
        private final int initialSort;

        public final int getInitialSort() {
            return this.initialSort;
        }

        public final int getInitalSortTimeframe() {
            return this.initalSortTimeframe;
        }

        public FrontpageListingProviderSpec(String str, int i, int i2) {
            super(str);
            this.initialSort = i;
            this.initalSortTimeframe = i2;
        }

        protected final FrontpageLinkListingProvider createProvider() {
            String str = this.ownerId;
            Intrinsics.a(str, "ownerId");
            return new FrontpageLinkListingProvider(str, this.initialSort, this.initalSortTimeframe);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 1, 9})
    /* compiled from: FrontpageLinkListingProvider.kt */
    static final class C17271 extends Lambda implements Function0<List<? extends Pair<? extends String, ? extends String>>> {
        public static final C17271 f19432a = new C17271();

        C17271() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            return CollectionsKt.a();
        }
    }

    public FrontpageLinkListingProvider(String str, int i, int i2, Function0<? extends List<Pair<String, String>>> function0) {
        Intrinsics.b(str, "ownerId");
        Intrinsics.b(function0, "queryParams");
        super(str, i, i2);
        this.f19433b = function0;
    }

    public final ProviderSpec<FrontpageLinkListingProvider> mo4201a() {
        return new FrontpageListingProviderSpec(getOwnerId(), this.sortId, this.sortTimeFrame);
    }

    protected final void mo4202a(ListingRequestParams listingRequestParams, String str, AsyncCallback<Listing<? extends Listable>> asyncCallback) {
        Intrinsics.b(listingRequestParams, "requestParams");
        this.d.m8989a(listingRequestParams, str, asyncCallback, (List) this.f19433b.invoke());
    }
}
