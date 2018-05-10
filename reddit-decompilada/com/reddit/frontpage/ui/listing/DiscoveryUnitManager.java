package com.reddit.frontpage.ui.listing;

import android.os.Bundle;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.OrderBy;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.OrderType;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.debug.RedditLogger;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.presentation.carousel.IndexTracker;
import com.reddit.frontpage.presentation.carousel.SubredditMapper;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import com.reddit.frontpage.presentation.listing.carousel.CarouselCollectionState;
import com.reddit.frontpage.presentation.template.StringFormatter;
import com.reddit.frontpage.ui.carousel.CarouselItemLayout;
import com.reddit.frontpage.util.kotlin.MutableListsKt;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 u2\u00020\u0001:\u0003uvwB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u00104\u001a\u0002052\u0006\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020/H\u0002J\u0016\u00104\u001a\u0002052\u0006\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020/J\u0006\u00109\u001a\u000205J\u0006\u0010:\u001a\u000205J\u001a\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0=0<2\u0006\u0010?\u001a\u00020/J,\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020D0B0A2\u0006\u0010E\u001a\u00020C2\b\b\u0002\u0010F\u001a\u00020CH\u0007J:\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020>0B0A2\u0006\u0010E\u001a\u00020C2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002030A2\b\b\u0002\u0010F\u001a\u00020CH\u0003J2\u0010H\u001a\b\u0012\u0004\u0012\u0002030=2\u0006\u00106\u001a\u00020 2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0J2\u0006\u0010K\u001a\u00020LH\u0002J@\u0010M\u001a\b\u0012\u0004\u0012\u0002030=2\u0006\u00106\u001a\u00020 2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0J2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020O0=2\u0006\u0010K\u001a\u00020LH\u0002J \u0010P\u001a\f\u0012\u0006\b\u0001\u0012\u000203\u0018\u00010=2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020 0RH\u0002J\u0018\u0010S\u001a\u00020C2\u0006\u00106\u001a\u00020 2\u0006\u0010T\u001a\u00020\nH\u0002J\u0010\u0010U\u001a\u00020\n2\u0006\u00106\u001a\u00020 H\u0002J.\u0010V\u001a\u0002052\f\u0010W\u001a\b\u0012\u0004\u0012\u00020D0X2\u0018\u0010Y\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020D0B0AJ\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020C0A2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020D0\u001fH\u0007J \u0010[\u001a\u0002032\u0006\u00106\u001a\u00020 2\u0006\u0010\\\u001a\u00020]2\u0006\u0010K\u001a\u00020LH\u0002J.\u0010^\u001a\u0002032\u0006\u00106\u001a\u00020 2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020`0<2\u0006\u0010N\u001a\u00020O2\u0006\u0010K\u001a\u00020LH\u0002JB\u0010a\u001a\u00020\u000e2\u0006\u0010b\u001a\u00020C2\u0006\u0010E\u001a\u00020C2\u0006\u0010T\u001a\u00020\n2\u0006\u0010c\u001a\u00020d2\u0018\u0010e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020>0B02H\u0002J\u0010\u0010f\u001a\u0002052\u0006\u0010c\u001a\u000203H\u0002J\u001e\u0010g\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/\u0018\u00010J2\u0006\u00106\u001a\u00020 H\u0002J\b\u0010h\u001a\u000205H\u0002J$\u0010i\u001a\u0002052\f\u0010j\u001a\b\u0012\u0004\u0012\u00020>0A2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020302H\u0002J\u0006\u0010l\u001a\u000205J\u000e\u0010m\u001a\u0002052\u0006\u0010n\u001a\u00020oJ\u000e\u0010p\u001a\u0002052\u0006\u0010n\u001a\u00020oJ\f\u0010q\u001a\u000205*\u00020/H\u0002J\u000e\u0010r\u001a\u0004\u0018\u00010/*\u00020 H\u0002J\f\u0010s\u001a\u00020/*\u00020 H\u0002J\u000e\u0010t\u001a\u0004\u0018\u00010/*\u00020 H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"8BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*8BX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0.X\u0004¢\u0006\u0002\n\u0000R&\u00100\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0.0.X\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020302X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006x"}, d2 = {"Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager;", "", "view", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitListingView;", "(Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitListingView;)V", "colorGenerator", "Lcom/reddit/frontpage/presentation/carousel/ColorGenerator;", "getColorGenerator", "()Lcom/reddit/frontpage/presentation/carousel/ColorGenerator;", "discoveryUnitIndexTracker", "Lcom/reddit/frontpage/presentation/carousel/IndexTracker;", "discoveryUnitStableId", "", "discoveryUnitsFetched", "", "discoveryUnitsFetchedAndInserted", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "formatter", "Lcom/reddit/frontpage/presentation/formatter/NumberFormatter;", "getFormatter", "()Lcom/reddit/frontpage/presentation/formatter/NumberFormatter;", "frontpageSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "getFrontpageSettings", "()Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "linkRepository", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "getLinkRepository", "()Lcom/reddit/frontpage/domain/repository/LinkRepository;", "orderedDiscoveryUnits", "", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "getPostExecutionThread", "()Lcom/reddit/common/rx/PostExecutionThread;", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "getPreferenceRepository", "()Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "subredditRepository", "Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "getSubredditRepository", "()Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "templateMappings", "", "", "unitTemplateMappings", "unplacedLoadResults", "", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult;", "addTemplateMapping", "", "discoveryUnit", "template", "value", "cancelFetch", "fetchAndInsertDiscoveryUnits", "fetchDiscoveryUnits", "", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "surfaceName", "getDiscoveryUnitInserts", "", "Lkotlin/Pair;", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "numItems", "lastCarouselIndex", "discoveryUnitLoadResults", "getDiscoveryUnitListingItems", "parameters", "", "key", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;", "getDiscoveryUnitSubredditItems", "carouselState", "Lcom/reddit/frontpage/presentation/listing/carousel/CarouselCollectionState;", "getFetchUnit", "discoveryUnits", "", "getNextValidInsertPosition", "indexTracker", "initIndexTracker", "insertDiscoveryUnits", "list", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listing;", "discoveryUnitCarouselInserts", "insertUnplacedDiscoveryUnits", "mapListingToDiscoveryUnitResult", "listing", "Lcom/reddit/datalibrary/frontpage/data/model/DiscoveryUnitListingDataModel;", "mapSubredditsToDiscoveryUnitResult", "subreddits", "Lcom/reddit/frontpage/domain/model/Subreddit;", "processInsertion", "nextInsertPosition", "result", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult$Success;", "positionsInserted", "processLoadResult", "processQueryParameters", "processUnplacedLoadResults", "removeProcessed", "processedLoadResults", "loadResults", "reset", "restore", "bundle", "Landroid/os/Bundle;", "save", "log", "resolveCustomHideKey", "resolveTitle", "resolveUrl", "Companion", "DiscoveryUnitListingView", "DiscoveryUnitLoadResult", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DiscoveryUnitManager.kt */
public final class DiscoveryUnitManager {
    public static final Companion f21277b = new Companion();
    public final CompositeDisposable f21278a = new CompositeDisposable();
    private final Map<String, String> f21279c = ((Map) new LinkedHashMap());
    private final Map<DiscoveryUnit, Map<String, String>> f21280d = ((Map) new LinkedHashMap());
    private boolean f21281e;
    private boolean f21282f;
    private IndexTracker f21283g;
    private long f21284h = -6000;
    private final Set<DiscoveryUnitLoadResult> f21285i = ((Set) new LinkedHashSet());
    private final List<DiscoveryUnit> f21286j = ((List) new ArrayList());
    private final DiscoveryUnitListingView f21287k;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$Companion;", "", "()V", "INITIAL_DISCOVERY_UNIT_ID", "", "MAX_DISCOVERY_UNITS", "", "MIN_DISCOVERY_UNITS", "STATE_FETCHED_INSERTED_UNITS", "", "STATE_FETCHED_UNITS", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DiscoveryUnitManager.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH&R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitListingView;", "", "isSurfaceSubscribed", "", "()Ljava/lang/Boolean;", "isViewAttached", "()Z", "numListItems", "", "getNumListItems", "()I", "surfaceName", "", "getSurfaceName", "()Ljava/lang/String;", "addItemToListing", "", "position", "item", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "getIndexOfLastDiscoveryUnit", "notifyDiscoveryUnitInsertedAtPosition", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DiscoveryUnitManager.kt */
    public interface DiscoveryUnitListingView {
        public static final Companion f21275b = Companion.f21274a;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitListingView$Companion;", "", "()V", "CAROUSEL_NOT_FOUND_INDEX", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: DiscoveryUnitManager.kt */
        public static final class Companion {
            static final /* synthetic */ Companion f21274a = new Companion();

            private Companion() {
            }
        }

        int mo4796a();

        void mo4797a(int i);

        void mo4798a(int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel);

        boolean mo4799b();

        String mo4800c();

        int mo4801d();

        Boolean mo4802e();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult;", "", "()V", "unit", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "getUnit", "()Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "Error", "Success", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult$Error;", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult$Success;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DiscoveryUnitManager.kt */
    private static abstract class DiscoveryUnitLoadResult {

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult$Error;", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult;", "unit", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "(Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;)V", "getUnit", "()Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: DiscoveryUnitManager.kt */
        public static final class Error extends DiscoveryUnitLoadResult {
            private final DiscoveryUnit f29022a;

            public final DiscoveryUnit mo4981a() {
                return this.f29022a;
            }

            public Error(DiscoveryUnit discoveryUnit) {
                Intrinsics.m26847b(discoveryUnit, "unit");
                super();
                this.f29022a = discoveryUnit;
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult$Success;", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult;", "unit", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "model", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "links", "", "Lcom/reddit/frontpage/domain/model/Link;", "subreddits", "Lcom/reddit/frontpage/domain/model/Subreddit;", "(Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;Ljava/util/List;Ljava/util/List;)V", "getLinks", "()Ljava/util/List;", "getModel", "()Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "getSubreddits", "getUnit", "()Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: DiscoveryUnitManager.kt */
        public static final class Success extends DiscoveryUnitLoadResult {
            final CarouselCollectionPresentationModel f29023a;
            private final DiscoveryUnit f29024b;
            private final List<Link> f29025c;
            private final List<Subreddit> f29026d;

            public final DiscoveryUnit mo4981a() {
                return this.f29024b;
            }

            public /* synthetic */ Success(DiscoveryUnit discoveryUnit, CarouselCollectionPresentationModel carouselCollectionPresentationModel, List list, List list2, int i) {
                if ((i & 4) != 0) {
                    list = null;
                }
                if ((i & 8) != 0) {
                    list2 = null;
                }
                this(discoveryUnit, carouselCollectionPresentationModel, list, list2);
            }

            private Success(DiscoveryUnit discoveryUnit, CarouselCollectionPresentationModel carouselCollectionPresentationModel, List<Link> list, List<Subreddit> list2) {
                Intrinsics.m26847b(discoveryUnit, "unit");
                Intrinsics.m26847b(carouselCollectionPresentationModel, "model");
                super();
                this.f29024b = discoveryUnit;
                this.f29023a = carouselCollectionPresentationModel;
                this.f29025c = list;
                this.f29026d = list2;
            }

            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("Success(unit=");
                stringBuilder.append(this.f29024b);
                stringBuilder.append(", model=");
                stringBuilder.append(this.f29023a);
                stringBuilder.append(", links=");
                stringBuilder.append(this.f29025c);
                stringBuilder.append(", subreddits=");
                stringBuilder.append(this.f29026d);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }

            public final int hashCode() {
                DiscoveryUnit discoveryUnit = this.f29024b;
                int i = 0;
                int hashCode = (discoveryUnit != null ? discoveryUnit.hashCode() : 0) * 31;
                CarouselCollectionPresentationModel carouselCollectionPresentationModel = this.f29023a;
                hashCode = (hashCode + (carouselCollectionPresentationModel != null ? carouselCollectionPresentationModel.hashCode() : 0)) * 31;
                List list = this.f29025c;
                hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
                list = this.f29026d;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode + i;
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (obj instanceof Success) {
                        Success success = (Success) obj;
                        if (Intrinsics.m26845a(this.f29024b, success.f29024b) && Intrinsics.m26845a(this.f29023a, success.f29023a) && Intrinsics.m26845a(this.f29025c, success.f29025c) && Intrinsics.m26845a(this.f29026d, success.f29026d) != null) {
                        }
                    }
                    return null;
                }
                return true;
            }
        }

        public abstract DiscoveryUnit mo4981a();

        private DiscoveryUnitLoadResult() {
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f21276a;

        static {
            int[] iArr = new int[CarouselItemLayout.values().length];
            f21276a = iArr;
            iArr[CarouselItemLayout.LARGE.ordinal()] = 1;
            f21276a[CarouselItemLayout.SMALL.ordinal()] = 2;
        }
    }

    public DiscoveryUnitManager(DiscoveryUnitListingView discoveryUnitListingView) {
        Intrinsics.m26847b(discoveryUnitListingView, "view");
        this.f21287k = discoveryUnitListingView;
    }

    private static FrontpageSettings m23409c() {
        Object a = FrontpageSettings.a();
        Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
        return a;
    }

    private static SubredditRepository m23411d() {
        return FrontpageApplication.m28875k().mo4635w();
    }

    private static NumberFormatter m23412e() {
        return FrontpageApplication.m28875k().mo4625m();
    }

    public final void m23420a(String str, String str2) {
        Intrinsics.m26847b(str, "template");
        Intrinsics.m26847b(str2, "value");
        this.f21279c.put(str, str2);
    }

    public final void m23418a(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        bundle.putBoolean("FetchedUnits", this.f21281e);
        bundle.putBoolean("FetchedAndInsertedUnits", this.f21282f);
    }

    public final void m23422b(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        this.f21281e = bundle.getBoolean("FetchedUnits", false);
        this.f21282f = bundle.getBoolean("FetchedAndInsertedUnits", false);
    }

    public final void m23417a() {
        this.f21284h = -6000;
        this.f21281e = false;
        this.f21282f = false;
        IndexTracker indexTracker = this.f21283g;
        if (indexTracker != null) {
            indexTracker.f20328b = indexTracker.f20329c;
        }
        this.f21285i.clear();
        this.f21278a.m32077c();
        this.f21280d.clear();
        this.f21286j.clear();
    }

    public final List<Single<CarouselCollectionPresentationModel>> m23414a(String str) {
        Intrinsics.m26847b(str, "surfaceName");
        if (this.f21281e) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        this.f21281e = true;
        StringBuilder stringBuilder = new StringBuilder("fetchDiscoveryUnits() for surface '");
        stringBuilder.append(str);
        stringBuilder.append('\'');
        RedditLogger.m21982a(stringBuilder.toString());
        str = m23409c().h(str);
        if (str == null) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        Iterator it = str.iterator();
        List<Single<CarouselCollectionPresentationModel>> arrayList = new ArrayList();
        while (it.hasNext()) {
            Single a = m23400a(it);
            if (a != null) {
                Object toSingle = a.filter(DiscoveryUnitManager$fetchDiscoveryUnits$1$1.f29027a).map(DiscoveryUnitManager$fetchDiscoveryUnits$1$2.f29028a).toSingle();
                Intrinsics.m26843a(toSingle, "fetchUnit\n              …              .toSingle()");
                arrayList.add(toSingle);
            }
        }
        return arrayList;
    }

    public final void m23421b() {
        Collection arrayList;
        if (this.f21282f) {
            StringBuilder stringBuilder = new StringBuilder("already fetched units, processing unplaced units ");
            Iterable<DiscoveryUnitLoadResult> iterable = this.f21285i;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (DiscoveryUnitLoadResult a : iterable) {
                arrayList.add(a.mo4981a().unique_id);
            }
            stringBuilder.append((List) arrayList);
            RedditLogger.m21982a(stringBuilder.toString());
            m23413f();
            return;
        }
        this.f21282f = true;
        stringBuilder = new StringBuilder("fetchAndInsertDiscoveryUnits() for surface '");
        stringBuilder.append(this.f21287k.mo4800c());
        RedditLogger.m21982a(stringBuilder.toString());
        Object h = m23409c().h(this.f21287k.mo4800c());
        if (h != null) {
            List list = this.f21286j;
            Intrinsics.m26843a(h, "it");
            Collections.shuffle(MutableListsKt.m24089a(list, h));
            stringBuilder = new StringBuilder("fetchAndInsertDiscoveryUnits() discovery units shuffled: ");
            Iterable<DiscoveryUnit> iterable2 = this.f21286j;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable2));
            for (DiscoveryUnit discoveryUnit : iterable2) {
                arrayList.add(discoveryUnit.unique_id);
            }
            stringBuilder.append((List) arrayList);
            RedditLogger.m21982a(stringBuilder.toString());
            Iterator it = this.f21286j.iterator();
            while (it.hasNext()) {
                Single a2 = m23400a(it);
                if (a2 != null) {
                    CompositeDisposable compositeDisposable = this.f21278a;
                    Object subscribe = SinglesKt.m24094b(a2, FrontpageApplication.m28875k().mo4633u()).subscribe((Consumer) new DiscoveryUnitManagerKt$sam$Consumer$dc0c8c91(new DiscoveryUnitManager$fetchAndInsertDiscoveryUnits$4$1(this)));
                    Intrinsics.m26843a(subscribe, "fetchUnit.observeOn(post…ribe(::processLoadResult)");
                    DisposableKt.m26766a(compositeDisposable, subscribe);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final io.reactivex.Single<? extends com.reddit.frontpage.ui.listing.DiscoveryUnitManager.DiscoveryUnitLoadResult> m23400a(java.util.Iterator<com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit> r8) {
        /*
        r7 = this;
        r0 = r8.next();
        r0 = (com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit) r0;
        r1 = new java.util.LinkedHashMap;
        r1.<init>();
        r1 = (java.util.Map) r1;
        r2 = new com.reddit.frontpage.presentation.template.StringFormatter;
        r3 = r7.f21279c;
        r2.<init>(r3);
        r3 = r0.parameters;
        r4 = 0;
        if (r3 == 0) goto L_0x0047;
    L_0x0019:
        r3 = r3.entrySet();
        r3 = r3.iterator();
    L_0x0021:
        r5 = r3.hasNext();
        if (r5 == 0) goto L_0x0047;
    L_0x0027:
        r5 = r3.next();
        r5 = (java.util.Map.Entry) r5;
        r6 = r5.getKey();
        r6 = (java.lang.String) r6;
        r5 = r5.getValue();
        r5 = (java.lang.String) r5;
        r5 = r2.m23202a(r5);
        if (r5 != 0) goto L_0x0041;
    L_0x003f:
        r1 = r4;
        goto L_0x0021;
    L_0x0041:
        if (r1 == 0) goto L_0x0021;
    L_0x0043:
        r1.put(r6, r5);
        goto L_0x0021;
    L_0x0047:
        if (r1 == 0) goto L_0x0050;
    L_0x0049:
        r2 = "sr_detail";
        r3 = "true";
        r1.put(r2, r3);
    L_0x0050:
        if (r1 != 0) goto L_0x0053;
    L_0x0052:
        return r4;
    L_0x0053:
        r2 = r7.f21287k;
        r2 = r2.mo4802e();
        if (r2 == 0) goto L_0x0074;
    L_0x005b:
        r2 = r0.g();
        if (r2 == 0) goto L_0x0074;
    L_0x0061:
        r2 = r0.g();
        r3 = r7.f21287k;
        r3 = r3.mo4802e();
        r2 = kotlin.jvm.internal.Intrinsics.m26845a(r2, r3);
        r2 = r2 ^ 1;
        if (r2 == 0) goto L_0x0074;
    L_0x0073:
        return r4;
    L_0x0074:
        r2 = com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey.f27953d;
        r2 = com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey.Companion.m22464a(r0);
        r3 = com.reddit.frontpage.FrontpageApplication.m28875k();
        r3 = r3.mo4613a();
        r3 = r3.m22473a(r2);
        r4 = r0.a();
        r5 = com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit.ModelType.SUBREDDIT;
        r4 = kotlin.jvm.internal.Intrinsics.m26845a(r4, r5);
        if (r4 == 0) goto L_0x0138;
    L_0x0092:
        r8 = r7.m23401a(r0);
        r4 = com.reddit.datalibrary.frontpage.redditauth.account.SessionManager.b();
        r5 = "SessionManager.getInstance()";
        kotlin.jvm.internal.Intrinsics.m26843a(r4, r5);
        r4 = r4.c();
        r4 = r4.getUsername();
        r5 = new java.lang.StringBuilder;
        r6 = "getDiscoveryUnitSubredditItems(...) ";
        r5.<init>(r6);
        r6 = r0.unique_id;
        r5.append(r6);
        r6 = ", ";
        r5.append(r6);
        r5.append(r1);
        r6 = ", ";
        r5.append(r6);
        r5.append(r2);
        r6 = ", ";
        r5.append(r6);
        r5.append(r8);
        r5 = r5.toString();
        com.reddit.frontpage.debug.RedditLogger.m21982a(r5);
        r5 = r0.b();
        if (r5 == 0) goto L_0x00f2;
    L_0x00d8:
        if (r4 == 0) goto L_0x00e4;
    L_0x00da:
        r8 = m23411d();
        r8 = r8.m22505f(r4);
        if (r8 != 0) goto L_0x0116;
    L_0x00e4:
        r8 = kotlin.collections.CollectionsKt__CollectionsKt.m26790a();
        r8 = io.reactivex.Single.just(r8);
        r1 = "Single.just(emptyList())";
        kotlin.jvm.internal.Intrinsics.m26843a(r8, r1);
        goto L_0x0116;
    L_0x00f2:
        if (r8 == 0) goto L_0x00fd;
    L_0x00f4:
        r4 = m23411d();
        r8 = r4.m22496a(r8, r1);
        goto L_0x0116;
    L_0x00fd:
        if (r4 == 0) goto L_0x0109;
    L_0x00ff:
        r8 = m23411d();
        r8 = r8.m22508i(r4);
        if (r8 != 0) goto L_0x0116;
    L_0x0109:
        r8 = kotlin.collections.CollectionsKt__CollectionsKt.m26790a();
        r8 = io.reactivex.Single.just(r8);
        r1 = "Single.just(emptyList())";
        kotlin.jvm.internal.Intrinsics.m26843a(r8, r1);
    L_0x0116:
        r3 = (io.reactivex.SingleSource) r3;
        r8 = io.reactivex.rxkotlin.SinglesKt.m26767a(r8, r3);
        r1 = new com.reddit.frontpage.ui.listing.DiscoveryUnitManager$getDiscoveryUnitSubredditItems$1;
        r1.<init>(r7, r0, r2);
        r1 = (io.reactivex.functions.Function) r1;
        r8 = r8.map(r1);
        r1 = new com.reddit.frontpage.ui.listing.DiscoveryUnitManager$getDiscoveryUnitSubredditItems$2;
        r1.<init>(r7, r0);
        r1 = (io.reactivex.functions.Function) r1;
        r8 = r8.onErrorReturn(r1);
        r0 = "subreddits\n        .zipW…(discoveryUnit)\n        }";
        kotlin.jvm.internal.Intrinsics.m26843a(r8, r0);
        goto L_0x01a4;
    L_0x0138:
        r3 = r0.a();
        r4 = com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit.ModelType.LINK;
        r3 = kotlin.jvm.internal.Intrinsics.m26845a(r3, r4);
        if (r3 == 0) goto L_0x0198;
    L_0x0144:
        r8 = new java.lang.StringBuilder;
        r3 = "getDiscoveryUnitListingItems(...) ";
        r8.<init>(r3);
        r3 = r0.unique_id;
        r8.append(r3);
        r3 = ", ";
        r8.append(r3);
        r8.append(r1);
        r3 = ", ";
        r8.append(r3);
        r8.append(r2);
        r8 = r8.toString();
        com.reddit.frontpage.debug.RedditLogger.m21982a(r8);
        r8 = com.reddit.frontpage.FrontpageApplication.m28875k();
        r8 = r8.mo4628p();
        r3 = r7.m23401a(r0);
        if (r3 != 0) goto L_0x0178;
    L_0x0175:
        kotlin.jvm.internal.Intrinsics.m26842a();
    L_0x0178:
        r8 = r8.m22419a(r3, r1);
        r1 = new com.reddit.frontpage.ui.listing.DiscoveryUnitManager$getDiscoveryUnitListingItems$1;
        r1.<init>(r7, r0, r2);
        r1 = (io.reactivex.functions.Function) r1;
        r8 = r8.map(r1);
        r1 = new com.reddit.frontpage.ui.listing.DiscoveryUnitManager$getDiscoveryUnitListingItems$2;
        r1.<init>(r7, r0);
        r1 = (io.reactivex.functions.Function) r1;
        r8 = r8.onErrorReturn(r1);
        r0 = "listing\n        .map {\n …(discoveryUnit)\n        }";
        kotlin.jvm.internal.Intrinsics.m26843a(r8, r0);
        goto L_0x01a4;
    L_0x0198:
        r8.remove();
        r8 = new com.reddit.frontpage.ui.listing.DiscoveryUnitManager$DiscoveryUnitLoadResult$Error;
        r8.<init>(r0);
        r8 = io.reactivex.Single.just(r8);
    L_0x01a4:
        r0 = "when {\n      discoveryUn…overyUnit))\n      }\n    }";
        kotlin.jvm.internal.Intrinsics.m26843a(r8, r0);
        r0 = com.reddit.frontpage.FrontpageApplication.m28875k();
        r0 = r0.mo4632t();
        r0 = (com.reddit.common.rx.Thread) r0;
        r8 = com.reddit.frontpage.util.kotlin.SinglesKt.m24093a(r8, r0);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.listing.DiscoveryUnitManager.a(java.util.Iterator):io.reactivex.Single<? extends com.reddit.frontpage.ui.listing.DiscoveryUnitManager$DiscoveryUnitLoadResult>");
    }

    public final Set<Pair<Integer, Listable>> m23415a(int i, int i2) {
        i = m23402a(i, this.f21285i, i2);
        Iterable<Pair> iterable = (Iterable) i;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Pair pair : iterable) {
            arrayList.add((CarouselCollectionPresentationModel) pair.f25268b);
        }
        m23406a(CollectionsKt___CollectionsKt.m41451p((List) arrayList), this.f21285i);
        return i;
    }

    private final Set<Pair<Integer, CarouselCollectionPresentationModel>> m23402a(int i, Set<? extends DiscoveryUnitLoadResult> set, int i2) {
        StringBuilder stringBuilder = new StringBuilder("getDiscoveryUnitInserts(...) discoveryUnitLoadResults: ");
        Iterable<DiscoveryUnitLoadResult> iterable = set;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (DiscoveryUnitLoadResult a : iterable) {
            DiscoveryUnitLoadResult a2;
            arrayList.add(a2.mo4981a().unique_id);
        }
        stringBuilder.append((List) arrayList);
        RedditLogger.m21982a(stringBuilder.toString());
        Set<Pair<Integer, CarouselCollectionPresentationModel>> linkedHashSet = new LinkedHashSet();
        if (i == 0) {
            return linkedHashSet;
        }
        if (i2 != -1) {
            IndexTracker indexTracker = this.f21283g;
            if (indexTracker != null) {
                indexTracker.f20328b = i2 + indexTracker.f20327a;
            }
        }
        i2 = this.f21286j.iterator();
        while (i2.hasNext()) {
            DiscoveryUnit discoveryUnit = (DiscoveryUnit) i2.next();
            for (Object next : iterable) {
                if (Intrinsics.m26845a(((DiscoveryUnitLoadResult) next).mo4981a().unique_id, discoveryUnit.unique_id)) {
                    break;
                }
            }
            Object next2 = null;
            a2 = (DiscoveryUnitLoadResult) next2;
            if (a2 == null) {
                return linkedHashSet;
            }
            if (a2 instanceof Success) {
                Success success = (Success) a2;
                if (success.f29023a.mo6935b() >= 3) {
                    int i3;
                    Object obj;
                    DiscoveryUnit a3 = a2.mo4981a();
                    if (this.f21283g == null) {
                        OrderBy orderBy = a3.orderBy;
                        this.f21283g = new IndexTracker(orderBy.distance, orderBy.start);
                    }
                    IndexTracker indexTracker2 = this.f21283g;
                    if (indexTracker2 == null) {
                        Intrinsics.m26842a();
                    }
                    if (Intrinsics.m26845a(a3.orderBy.orderType, OrderType.INDEX)) {
                        i3 = a3.index;
                    } else {
                        i3 = indexTracker2.f20328b;
                    }
                    if (i3 >= 0) {
                        if (i >= i3) {
                            indexTracker2.f20328b += indexTracker2.f20327a;
                            linkedHashSet.add(TuplesKt.m26780a(Integer.valueOf(i3), success.f29023a));
                            obj = 1;
                            if (obj == null) {
                                return linkedHashSet;
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        return linkedHashSet;
                    }
                } else {
                    continue;
                }
            }
            i2.remove();
        }
        return linkedHashSet;
    }

    public final Set<Integer> m23416a(List<Listable> list) {
        Intrinsics.m26847b(list, "list");
        Iterable<Pair> a = m23402a(list.size(), this.f21285i, this.f21287k.mo4801d());
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(a));
        for (Pair pair : a) {
            arrayList.add(Integer.valueOf(((Number) pair.f25267a).intValue()));
        }
        Set<Integer> p = CollectionsKt___CollectionsKt.m41451p((List) arrayList);
        Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(a));
        for (Pair pair2 : a) {
            arrayList2.add((CarouselCollectionPresentationModel) pair2.f25268b);
        }
        m23406a(CollectionsKt___CollectionsKt.m41451p((List) arrayList2), this.f21285i);
        for (Pair pair3 : a) {
            list.add(((Number) pair3.f25267a).intValue(), (CarouselCollectionPresentationModel) pair3.f25268b);
        }
        return p;
    }

    public final void m23419a(Listing<Listable> listing, Set<? extends Pair<Integer, ? extends Listable>> set) {
        Intrinsics.m26847b(listing, "list");
        Intrinsics.m26847b(set, "discoveryUnitCarouselInserts");
        StringBuilder stringBuilder = new StringBuilder("insertDiscoveryUnits(...) ");
        Iterable<Pair> iterable = set;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Pair pair : iterable) {
            arrayList.add(Integer.valueOf(((Number) pair.f25267a).intValue()));
        }
        stringBuilder.append((List) arrayList);
        RedditLogger.m21982a(stringBuilder.toString());
        for (Pair pair2 : iterable) {
            int intValue = ((Number) pair2.f25267a).intValue();
            Listable listable = (Listable) pair2.f25268b;
            if (intValue >= 0) {
                if (intValue <= listing.size() - 1) {
                    listing.insert(intValue, listable);
                    this.f21287k.mo4797a(intValue);
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder("invalid index ");
            stringBuilder2.append(intValue);
            stringBuilder2.append(" for ");
            stringBuilder2.append(listable);
            String stringBuilder3 = stringBuilder2.toString();
            RedditLogger.m21982a(stringBuilder3);
            RedditLogger.m21983a(new IllegalStateException(), stringBuilder3);
        }
    }

    private final void m23413f() {
        if (this.f21287k.mo4799b() && !this.f21285i.isEmpty()) {
            Iterable<Pair> a = m23402a(this.f21287k.mo4796a(), this.f21285i, this.f21287k.mo4801d());
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(a));
            for (Pair pair : a) {
                arrayList.add(Integer.valueOf(((Number) pair.f25267a).intValue()));
            }
            Set p = CollectionsKt___CollectionsKt.m41451p((List) arrayList);
            Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(a));
            for (Pair pair2 : a) {
                arrayList2.add((CarouselCollectionPresentationModel) pair2.f25268b);
            }
            m23406a(CollectionsKt___CollectionsKt.m41451p(CollectionsKt___CollectionsKt.m41451p((List) arrayList2)), this.f21285i);
            StringBuilder stringBuilder = new StringBuilder("DU inserts = ");
            stringBuilder.append(p);
            RedditLogger.m21982a(stringBuilder.toString());
            for (Pair pair3 : a) {
                int intValue = ((Number) pair3.f25267a).intValue();
                CarouselCollectionPresentationModel carouselCollectionPresentationModel = (CarouselCollectionPresentationModel) pair3.f25268b;
                if (intValue < 0) {
                    StringBuilder stringBuilder2 = new StringBuilder("invalid index ");
                    stringBuilder2.append(intValue);
                    stringBuilder2.append(" for ");
                    stringBuilder2.append(carouselCollectionPresentationModel);
                    String stringBuilder3 = stringBuilder2.toString();
                    RedditLogger.m21982a(stringBuilder3);
                    RedditLogger.m21983a(new IllegalStateException(), stringBuilder3);
                } else {
                    DiscoveryUnitListingView discoveryUnitListingView = this.f21287k;
                    discoveryUnitListingView.mo4798a(intValue, carouselCollectionPresentationModel);
                    discoveryUnitListingView.mo4797a(intValue);
                }
            }
        }
    }

    private static void m23406a(Set<? extends CarouselCollectionPresentationModel> set, Set<DiscoveryUnitLoadResult> set2) {
        for (CarouselCollectionPresentationModel discoveryUnitManager$removeProcessed$1$1 : set) {
            CollectionsKt__MutableCollectionsKt.m38192a((Iterable) set2, (Function1) new DiscoveryUnitManager$removeProcessed$1$1(discoveryUnitManager$removeProcessed$1$1));
        }
    }

    private final void m23404a(DiscoveryUnit discoveryUnit, String str, String str2) {
        Map map = this.f21280d;
        Object obj = map.get(discoveryUnit);
        if (obj == null) {
            obj = new LinkedHashMap();
            map.put(discoveryUnit, obj);
        }
        ((Map) obj).put(str, str2);
    }

    private final String m23407b(DiscoveryUnit discoveryUnit) {
        synchronized (this.f21280d) {
            Map map = (Map) this.f21280d.get(discoveryUnit);
            if (map == null) {
                map = new LinkedHashMap();
            }
            String a = new StringFormatter(map).m23202a(discoveryUnit.title);
            if (a == null) {
                synchronized (this.f21279c) {
                    discoveryUnit = new StringFormatter(this.f21279c).m23202a(discoveryUnit.title);
                    if (discoveryUnit == null) {
                        Intrinsics.m26842a();
                    }
                }
                return discoveryUnit;
            }
            return a;
        }
    }

    private final String m23401a(DiscoveryUnit discoveryUnit) {
        discoveryUnit = discoveryUnit.url;
        if (discoveryUnit == null) {
            return null;
        }
        synchronized (this.f21279c) {
            discoveryUnit = new StringFormatter(this.f21279c).m23202a(discoveryUnit);
        }
        return discoveryUnit;
    }

    private final String m23410c(DiscoveryUnit discoveryUnit) {
        discoveryUnit = discoveryUnit.custom_hide_key;
        if (discoveryUnit == null) {
            return null;
        }
        synchronized (this.f21279c) {
            discoveryUnit = new StringFormatter(this.f21279c).m23202a(discoveryUnit);
        }
        return discoveryUnit;
    }

    public static final /* synthetic */ void m23405a(DiscoveryUnitManager discoveryUnitManager, DiscoveryUnitLoadResult discoveryUnitLoadResult) {
        StringBuilder stringBuilder = new StringBuilder("processLoadResult(...) ");
        stringBuilder.append(discoveryUnitLoadResult.mo4981a().unique_id);
        RedditLogger.m21982a(stringBuilder.toString());
        discoveryUnitManager.f21285i.add(discoveryUnitLoadResult);
        discoveryUnitManager.m23413f();
    }

    public static final /* synthetic */ DiscoveryUnitLoadResult m23399a(DiscoveryUnitManager discoveryUnitManager, DiscoveryUnit discoveryUnit, List list, CarouselCollectionState carouselCollectionState, CarouselCollectionStateKey carouselCollectionStateKey) {
        int i;
        DiscoveryUnitManager discoveryUnitManager2 = discoveryUnitManager;
        DiscoveryUnit discoveryUnit2 = discoveryUnit;
        boolean contains = discoveryUnit2.options.contains("description");
        switch (WhenMappings.f21276a[discoveryUnit2.layout.ordinal()]) {
            case 1:
                i = 14;
                break;
            case 2:
                if (!discoveryUnit2.f()) {
                    i = 12;
                    break;
                }
                i = 13;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        int i2 = i;
        Collection arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z = false;
            Object next;
            Subreddit subreddit;
            if (it.hasNext()) {
                next = it.next();
                subreddit = (Subreddit) next;
                if (discoveryUnit2.b()) {
                    Boolean userHasFavorited = subreddit.getUserHasFavorited();
                    if (userHasFavorited != null) {
                        z = userHasFavorited.booleanValue();
                    }
                } else {
                    z = true;
                }
                if (z) {
                    arrayList.add(next);
                }
            } else {
                Collection arrayList2 = new ArrayList();
                for (Object next2 : (List) arrayList) {
                    boolean z2;
                    subreddit = (Subreddit) next2;
                    boolean z3 = (Intrinsics.m26845a(discoveryUnit2.unique_id, (Object) "xd_21") || discoveryUnit2.options.contains("dont_filter_dismissals")) ? false : true;
                    if (z3) {
                        if (carouselCollectionState.isItemDismissed(subreddit.getKindWithId())) {
                            z2 = false;
                            if (z2) {
                                arrayList2.add(next2);
                            }
                        }
                    } else {
                        CarouselCollectionState carouselCollectionState2 = carouselCollectionState;
                    }
                    z2 = true;
                    if (z2) {
                        arrayList2.add(next2);
                    }
                }
                List a = CollectionsKt___CollectionsKt.m41415a((Iterable) (List) arrayList2, 10);
                SubredditMapper subredditMapper = SubredditMapper.f20341a;
                List a2 = SubredditMapper.m22681a(a, contains, m23412e(), FrontpageApplication.m28875k().mo4627o());
                String b = discoveryUnitManager2.m23407b(discoveryUnit2);
                long j = discoveryUnitManager2.f21284h;
                discoveryUnitManager2.f21284h = 1 + j;
                GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel = new GeneralCarouselCollectionPresentationModel(b, contains, false, a2, discoveryUnit2.unique_id, j, discoveryUnit2.options.contains("hide_title") ^ 1, i2, discoveryUnit2, carouselCollectionStateKey);
                StringBuilder stringBuilder = new StringBuilder("mapSubredditsToDiscoveryUnitResult(...) ");
                stringBuilder.append(generalCarouselCollectionPresentationModel.f36359g);
                RedditLogger.m21982a(stringBuilder.toString());
                return new Success(discoveryUnit2, generalCarouselCollectionPresentationModel, null, list, 4);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ com.reddit.frontpage.ui.listing.DiscoveryUnitManager.DiscoveryUnitLoadResult m23398a(com.reddit.frontpage.ui.listing.DiscoveryUnitManager r44, com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit r45, com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel r46, com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey r47) {
        /*
        r0 = r44;
        r15 = r45;
        r1 = r46.component1();
        r2 = r46.component2();
        r3 = r46.component3();
        r4 = 0;
        if (r3 == 0) goto L_0x0018;
    L_0x0013:
        r5 = r3.getSubreddit();
        goto L_0x0019;
    L_0x0018:
        r5 = r4;
    L_0x0019:
        r6 = kotlin.collections.CollectionsKt___CollectionsKt.m41434e(r1);
        r6 = (kotlin.Pair) r6;
        if (r6 == 0) goto L_0x004f;
    L_0x0021:
        r7 = r6.f25267a;
        r7 = (com.reddit.frontpage.domain.model.Link) r7;
        r6 = r6.f25268b;
        r6 = (com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel.LinkCause) r6;
        r6 = r6.getCause();
        if (r6 == 0) goto L_0x0034;
    L_0x002f:
        r8 = "first_item.cause";
        r0.m23404a(r15, r8, r6);
    L_0x0034:
        r6 = "first_item.subreddit.visual_name";
        r8 = r7.getSubredditNamePrefixed();
        r8 = com.reddit.frontpage.util.SubredditUtil.m23934e(r8);
        r9 = "SubredditUtil.formatWith…nk.subredditNamePrefixed)";
        kotlin.jvm.internal.Intrinsics.m26843a(r8, r9);
        r0.m23404a(r15, r6, r8);
        r6 = "first_item.subreddit.id";
        r7 = r7.getSubredditId();
        r0.m23420a(r6, r7);
    L_0x004f:
        r14 = r1;
        r14 = (java.lang.Iterable) r14;
        r6 = 10;
        r6 = kotlin.collections.CollectionsKt___CollectionsKt.m41415a(r14, r6);
        r7 = com.reddit.frontpage.presentation.listing.model.LinkMapper.f20611a;
        r7 = r15.options;
        r8 = "post_show_subreddit_header";
        r7 = r7.contains(r8);
        r25 = com.reddit.frontpage.presentation.listing.model.LinkMapper.m22971a(r6, r2, r3, r7);
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.m41430d(r1);
        r1 = (kotlin.Pair) r1;
        r1 = r1.f25267a;
        r1 = (com.reddit.frontpage.domain.model.Link) r1;
        if (r2 == 0) goto L_0x0078;
    L_0x0072:
        r3 = r2.getPublicDescription();
        if (r3 != 0) goto L_0x0080;
    L_0x0078:
        if (r5 == 0) goto L_0x007f;
    L_0x007a:
        r3 = r5.getPublicDescription();
        goto L_0x0080;
    L_0x007f:
        r3 = r4;
    L_0x0080:
        if (r3 != 0) goto L_0x0089;
    L_0x0082:
        r1 = r1.getSubreddit();
        r21 = r1;
        goto L_0x008b;
    L_0x0089:
        r21 = r3;
    L_0x008b:
        if (r2 == 0) goto L_0x0097;
    L_0x008d:
        r1 = r2.getIconImg();
        if (r1 != 0) goto L_0x0094;
    L_0x0093:
        goto L_0x0097;
    L_0x0094:
        r22 = r1;
        goto L_0x00a0;
    L_0x0097:
        if (r5 == 0) goto L_0x009e;
    L_0x0099:
        r1 = r5.getIconImg();
        goto L_0x0094;
    L_0x009e:
        r22 = r4;
    L_0x00a0:
        if (r2 == 0) goto L_0x00a8;
    L_0x00a2:
        r1 = r2.getUserIsSubscriber();
        if (r1 != 0) goto L_0x00b0;
    L_0x00a8:
        if (r5 == 0) goto L_0x00af;
    L_0x00aa:
        r1 = r5.getUserIsSubscriber();
        goto L_0x00b0;
    L_0x00af:
        r1 = r4;
    L_0x00b0:
        r3 = 0;
        if (r1 == 0) goto L_0x00ba;
    L_0x00b3:
        r1 = r1.booleanValue();
        r23 = r1;
        goto L_0x00bc;
    L_0x00ba:
        r23 = r3;
    L_0x00bc:
        r1 = 2131886496; // 0x7f1201a0 float:1.9407572E38 double:1.0532918785E-314;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = m23412e();
        if (r2 == 0) goto L_0x00d1;
    L_0x00c8:
        r8 = r2.getSubscribers();
    L_0x00cc:
        r8 = java.lang.Long.valueOf(r8);
        goto L_0x00da;
    L_0x00d1:
        if (r5 == 0) goto L_0x00d9;
    L_0x00d3:
        r8 = r5.getSubscribers();
        r8 = (long) r8;
        goto L_0x00cc;
    L_0x00d9:
        r8 = r4;
    L_0x00da:
        if (r8 == 0) goto L_0x00e1;
    L_0x00dc:
        r8 = r8.longValue();
        goto L_0x00e3;
    L_0x00e1:
        r8 = 0;
    L_0x00e3:
        r7 = r7.mo4823a(r8);
        r6[r3] = r7;
        r13 = com.reddit.frontpage.util.Util.m23960a(r1, r6);
        if (r2 == 0) goto L_0x00f5;
    L_0x00ef:
        r1 = r2.getDisplayNamePrefixed();
        if (r1 != 0) goto L_0x00fd;
    L_0x00f5:
        if (r5 == 0) goto L_0x00fc;
    L_0x00f7:
        r1 = r5.getDisplayNamePrefixed();
        goto L_0x00fd;
    L_0x00fc:
        r1 = r4;
    L_0x00fd:
        if (r1 != 0) goto L_0x0101;
    L_0x00ff:
        r1 = "";
    L_0x0101:
        r12 = r1;
        if (r2 == 0) goto L_0x010a;
    L_0x0104:
        r1 = r2.getUserIsSubscriber();
        if (r1 != 0) goto L_0x0112;
    L_0x010a:
        if (r5 == 0) goto L_0x0111;
    L_0x010c:
        r1 = r5.getUserIsSubscriber();
        goto L_0x0112;
    L_0x0111:
        r1 = r4;
    L_0x0112:
        if (r1 == 0) goto L_0x011b;
    L_0x0114:
        r1 = r1.booleanValue();
        r24 = r1;
        goto L_0x011d;
    L_0x011b:
        r24 = r3;
    L_0x011d:
        r11 = new com.reddit.frontpage.presentation.carousel.model.LinkCarouselCollectionPresentationModel;
        r26 = r44.m23407b(r45);
        r1 = r15.subtitle;
        if (r1 != 0) goto L_0x0129;
    L_0x0127:
        r1 = "";
    L_0x0129:
        r27 = r1;
        r1 = r15.subtitle_icon;
        if (r1 == 0) goto L_0x0137;
    L_0x012f:
        r1 = r1.getDrawable();
        r4 = java.lang.Integer.valueOf(r1);
    L_0x0137:
        r28 = r4;
        r9 = r0.f21284h;
        r1 = 1;
        r1 = r1 + r9;
        r0.f21284h = r1;
        r8 = r15.unique_id;
        r1 = r15.custom_hide_key;
        if (r1 != 0) goto L_0x0155;
    L_0x0146:
        r37 = r8;
        r38 = r9;
        r40 = r11;
        r41 = r12;
        r42 = r13;
        r43 = r14;
        r30 = r15;
        goto L_0x01a6;
    L_0x0155:
        r1 = 0;
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r16 = 0;
        r17 = 0;
        r18 = 0;
        r19 = 0;
        r20 = 0;
        r29 = 0;
        r30 = 0;
        r31 = 0;
        r32 = r44.m23410c(r45);
        r33 = 0;
        r34 = 0;
        r35 = 0;
        r36 = 491519; // 0x77fff float:6.88765E-40 double:2.428427E-318;
        r0 = r15;
        r37 = r8;
        r8 = r16;
        r38 = r9;
        r9 = r17;
        r10 = r18;
        r40 = r11;
        r11 = r19;
        r41 = r12;
        r12 = r20;
        r42 = r13;
        r13 = r29;
        r43 = r14;
        r14 = r30;
        r15 = r31;
        r16 = r32;
        r17 = r33;
        r18 = r34;
        r19 = r35;
        r20 = r36;
        r0 = com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
        r30 = r0;
    L_0x01a6:
        r0 = "subredditMetadata";
        r1 = r42;
        kotlin.jvm.internal.Intrinsics.m26843a(r1, r0);
        r0 = r41;
        r0 = com.reddit.frontpage.util.SubredditUtil.m23934e(r0);
        r2 = "SubredditUtil.formatWithBoldHtml(subredditName)";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        r29 = 15;
        r15 = r40;
        r16 = r26;
        r17 = r27;
        r18 = r28;
        r19 = r0;
        r20 = r1;
        r26 = r37;
        r27 = r38;
        r31 = r47;
        r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r30, r31);
        r0 = new java.lang.StringBuilder;
        r1 = "mapListingToDiscoveryUnitResult(...) ";
        r0.<init>(r1);
        r1 = r40;
        r2 = r1.f36376m;
        r0.append(r2);
        r0 = r0.toString();
        com.reddit.frontpage.debug.RedditLogger.m21982a(r0);
        r6 = new com.reddit.frontpage.ui.listing.DiscoveryUnitManager$DiscoveryUnitLoadResult$Success;
        r0 = new java.util.ArrayList;
        r2 = r43;
        r3 = kotlin.collections.CollectionsKt__IterablesKt.m32812b(r2);
        r0.<init>(r3);
        r0 = (java.util.Collection) r0;
        r2 = r2.iterator();
    L_0x01f7:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x020b;
    L_0x01fd:
        r3 = r2.next();
        r3 = (kotlin.Pair) r3;
        r3 = r3.f25267a;
        r3 = (com.reddit.frontpage.domain.model.Link) r3;
        r0.add(r3);
        goto L_0x01f7;
    L_0x020b:
        r3 = r0;
        r3 = (java.util.List) r3;
        r2 = r1;
        r2 = (com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel) r2;
        r4 = 0;
        r5 = 8;
        r0 = r6;
        r1 = r45;
        r0.<init>(r1, r2, r3, r4, r5);
        r6 = (com.reddit.frontpage.ui.listing.DiscoveryUnitManager.DiscoveryUnitLoadResult) r6;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.listing.DiscoveryUnitManager.a(com.reddit.frontpage.ui.listing.DiscoveryUnitManager, com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit, com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel, com.reddit.frontpage.domain.repository.PreferenceRepository$CarouselCollectionStateKey):com.reddit.frontpage.ui.listing.DiscoveryUnitManager$DiscoveryUnitLoadResult");
    }
}
