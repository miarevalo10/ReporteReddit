package com.reddit.frontpage.presentation.geopopular.select;

import android.location.Address;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressProvider;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Region;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.repository.RegionRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectContract.Navigator;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectContract.View;
import com.reddit.frontpage.util.PermissionRepository;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 72\u00020\u00012\u00020\u0002:\u0006789:;<B?\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J4\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010$\u001a\u00020\u0017H\u0002J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0&H\u0002J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020)0+2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0+H\u0002J\b\u00100\u001a\u00020\u001fH\u0016J\b\u00101\u001a\u00020\u001fH\u0016J\u0010\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u0014H\u0016J\b\u00104\u001a\u00020\u001fH\u0016J\u0010\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u001aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectContract$View;", "geocodedAddressProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressProvider;", "navigator", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectContract$Navigator;", "regionRepository", "Lcom/reddit/frontpage/domain/repository/RegionRepository;", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "permissionRepository", "Lcom/reddit/frontpage/util/PermissionRepository;", "(Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectContract$View;Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressProvider;Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectContract$Navigator;Lcom/reddit/frontpage/domain/repository/RegionRepository;Lcom/reddit/frontpage/domain/repository/PreferenceRepository;Lcom/reddit/common/rx/PostExecutionThread;Lcom/reddit/frontpage/util/PermissionRepository;)V", "initialModelList", "", "Lcom/reddit/frontpage/presentation/geopopular/model/GeopopularRegionPresentationModel;", "selectedChildIds", "", "", "addressToRegion", "Lkotlin/Pair;", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "Lcom/reddit/frontpage/domain/model/Region;", "address", "Landroid/location/Address;", "attach", "", "filterRegions", "query", "models", "filtered", "previouslySelectedGeoFilter", "getFilterableRegionPresentationModels", "Lio/reactivex/Observable;", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeopopularFilteredMappingResult;", "regions", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeopopularMappingResult;", "getPreviouslySelectedRegion", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$PreviousRegionSelection;", "mapToRegionPresentationModels", "regionsLoadResult", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$RegionsLoadResult;", "onLocationPermissionDenied", "onLocationPermissionGranted", "onRegionClicked", "model", "onUseLocationClicked", "saveRegionAndNotifyView", "filter", "Companion", "GeocodeAddressFilterResult", "GeopopularFilteredMappingResult", "GeopopularMappingResult", "PreviousRegionSelection", "RegionsLoadResult", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectPresenter.kt */
public final class GeopopularRegionSelectPresenter extends DisposablePresenter {
    public static final Companion f33863b = new Companion();
    final View f33864a;
    private final List<GeopopularRegionPresentationModel> f33865c = ((List) new ArrayList());
    private List<String> f33866d;
    private final GeocodedAddressProvider f33867e;
    private final Navigator f33868f;
    private final RegionRepository f33869g;
    private final PreferenceRepository f33870h;
    private final PostExecutionThread f33871i;
    private final PermissionRepository f33872j;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$Companion;", "", "()V", "INDEX_OF_SELECTED_REGION", "", "NAME_TOP_ITEM", "", "START_INDEX_SELECTED_CHILD_IDS", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularRegionSelectPresenter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeocodeAddressFilterResult;", "", "()V", "Error", "Success", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeocodeAddressFilterResult$Error;", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeocodeAddressFilterResult$Success;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularRegionSelectPresenter.kt */
    private static abstract class GeocodeAddressFilterResult {

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeocodeAddressFilterResult$Error;", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeocodeAddressFilterResult;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: GeopopularRegionSelectPresenter.kt */
        public static final class Error extends GeocodeAddressFilterResult {
            public static final Error f28240a = new Error();

            private Error() {
                super();
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeocodeAddressFilterResult$Success;", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeocodeAddressFilterResult;", "select", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "(Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;)V", "getSelect", "()Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: GeopopularRegionSelectPresenter.kt */
        public static final class Success extends GeocodeAddressFilterResult {
            final GeopopularRegionSelectFilter f28241a;

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (obj instanceof Success) {
                        if (Intrinsics.m26845a(this.f28241a, ((Success) obj).f28241a)) {
                        }
                    }
                    return false;
                }
                return true;
            }

            public final int hashCode() {
                GeopopularRegionSelectFilter geopopularRegionSelectFilter = this.f28241a;
                return geopopularRegionSelectFilter != null ? geopopularRegionSelectFilter.hashCode() : 0;
            }

            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("Success(select=");
                stringBuilder.append(this.f28241a);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }

            public Success(GeopopularRegionSelectFilter geopopularRegionSelectFilter) {
                Intrinsics.m26847b(geopopularRegionSelectFilter, "select");
                super();
                this.f28241a = geopopularRegionSelectFilter;
            }
        }

        private GeocodeAddressFilterResult() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeopopularFilteredMappingResult;", "", "models", "", "Lcom/reddit/frontpage/presentation/geopopular/model/GeopopularRegionPresentationModel;", "selectedChildIds", "", "", "(Ljava/util/List;Ljava/util/List;)V", "getModels", "()Ljava/util/List;", "getSelectedChildIds", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularRegionSelectPresenter.kt */
    private static final class GeopopularFilteredMappingResult {
        final List<GeopopularRegionPresentationModel> f20546a;
        final List<String> f20547b;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof GeopopularFilteredMappingResult) {
                    GeopopularFilteredMappingResult geopopularFilteredMappingResult = (GeopopularFilteredMappingResult) obj;
                    if (Intrinsics.m26845a(this.f20546a, geopopularFilteredMappingResult.f20546a) && Intrinsics.m26845a(this.f20547b, geopopularFilteredMappingResult.f20547b)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            List list = this.f20546a;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            List list2 = this.f20547b;
            if (list2 != null) {
                i = list2.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("GeopopularFilteredMappingResult(models=");
            stringBuilder.append(this.f20546a);
            stringBuilder.append(", selectedChildIds=");
            stringBuilder.append(this.f20547b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public GeopopularFilteredMappingResult(List<GeopopularRegionPresentationModel> list, List<String> list2) {
            Intrinsics.m26847b(list, "models");
            Intrinsics.m26847b(list2, "selectedChildIds");
            this.f20546a = list;
            this.f20547b = list2;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeopopularMappingResult;", "", "models", "", "Lcom/reddit/frontpage/presentation/geopopular/model/GeopopularRegionPresentationModel;", "previousSelectedGeoFilter", "", "selectedChildIds", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getModels", "()Ljava/util/List;", "getPreviousSelectedGeoFilter", "()Ljava/lang/String;", "getSelectedChildIds", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularRegionSelectPresenter.kt */
    private static final class GeopopularMappingResult {
        final List<GeopopularRegionPresentationModel> f20548a;
        final String f20549b;
        final List<String> f20550c;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof GeopopularMappingResult) {
                    GeopopularMappingResult geopopularMappingResult = (GeopopularMappingResult) obj;
                    if (Intrinsics.m26845a(this.f20548a, geopopularMappingResult.f20548a) && Intrinsics.m26845a(this.f20549b, geopopularMappingResult.f20549b) && Intrinsics.m26845a(this.f20550c, geopopularMappingResult.f20550c)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            List list = this.f20548a;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            String str = this.f20549b;
            hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            List list2 = this.f20550c;
            if (list2 != null) {
                i = list2.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("GeopopularMappingResult(models=");
            stringBuilder.append(this.f20548a);
            stringBuilder.append(", previousSelectedGeoFilter=");
            stringBuilder.append(this.f20549b);
            stringBuilder.append(", selectedChildIds=");
            stringBuilder.append(this.f20550c);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public GeopopularMappingResult(List<GeopopularRegionPresentationModel> list, String str, List<String> list2) {
            Intrinsics.m26847b(list, "models");
            Intrinsics.m26847b(str, "previousSelectedGeoFilter");
            Intrinsics.m26847b(list2, "selectedChildIds");
            this.f20548a = list;
            this.f20549b = str;
            this.f20550c = list2;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$PreviousRegionSelection;", "", "previousSelectedGeoFilter", "", "previousRegionId", "previousChildRegionId", "selectedChildIds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getPreviousChildRegionId", "()Ljava/lang/String;", "getPreviousRegionId", "getPreviousSelectedGeoFilter", "getSelectedChildIds", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularRegionSelectPresenter.kt */
    private static final class PreviousRegionSelection {
        final String f20551a;
        final String f20552b;
        final String f20553c;
        final List<String> f20554d;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof PreviousRegionSelection) {
                    PreviousRegionSelection previousRegionSelection = (PreviousRegionSelection) obj;
                    if (Intrinsics.m26845a(this.f20551a, previousRegionSelection.f20551a) && Intrinsics.m26845a(this.f20552b, previousRegionSelection.f20552b) && Intrinsics.m26845a(this.f20553c, previousRegionSelection.f20553c) && Intrinsics.m26845a(this.f20554d, previousRegionSelection.f20554d)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f20551a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f20552b;
            hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            str2 = this.f20553c;
            hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            List list = this.f20554d;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("PreviousRegionSelection(previousSelectedGeoFilter=");
            stringBuilder.append(this.f20551a);
            stringBuilder.append(", previousRegionId=");
            stringBuilder.append(this.f20552b);
            stringBuilder.append(", previousChildRegionId=");
            stringBuilder.append(this.f20553c);
            stringBuilder.append(", selectedChildIds=");
            stringBuilder.append(this.f20554d);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public PreviousRegionSelection(String str, String str2, String str3, List<String> list) {
            Intrinsics.m26847b(str, "previousSelectedGeoFilter");
            Intrinsics.m26847b(str2, "previousRegionId");
            Intrinsics.m26847b(str3, "previousChildRegionId");
            Intrinsics.m26847b(list, "selectedChildIds");
            this.f20551a = str;
            this.f20552b = str2;
            this.f20553c = str3;
            this.f20554d = list;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$RegionsLoadResult;", "", "previousSelection", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$PreviousRegionSelection;", "regions", "", "Lcom/reddit/frontpage/domain/model/Region;", "(Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$PreviousRegionSelection;Ljava/util/List;)V", "getPreviousSelection", "()Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$PreviousRegionSelection;", "getRegions", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularRegionSelectPresenter.kt */
    private static final class RegionsLoadResult {
        final PreviousRegionSelection f20555a;
        final List<Region> f20556b;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof RegionsLoadResult) {
                    RegionsLoadResult regionsLoadResult = (RegionsLoadResult) obj;
                    if (Intrinsics.m26845a(this.f20555a, regionsLoadResult.f20555a) && Intrinsics.m26845a(this.f20556b, regionsLoadResult.f20556b)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            PreviousRegionSelection previousRegionSelection = this.f20555a;
            int i = 0;
            int hashCode = (previousRegionSelection != null ? previousRegionSelection.hashCode() : 0) * 31;
            List list = this.f20556b;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("RegionsLoadResult(previousSelection=");
            stringBuilder.append(this.f20555a);
            stringBuilder.append(", regions=");
            stringBuilder.append(this.f20556b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public RegionsLoadResult(PreviousRegionSelection previousRegionSelection, List<Region> list) {
            Intrinsics.m26847b(previousRegionSelection, "previousSelection");
            Intrinsics.m26847b(list, "regions");
            this.f20555a = previousRegionSelection;
            this.f20556b = list;
        }
    }

    @Inject
    public GeopopularRegionSelectPresenter(View view, GeocodedAddressProvider geocodedAddressProvider, Navigator navigator, RegionRepository regionRepository, PreferenceRepository preferenceRepository, PostExecutionThread postExecutionThread, PermissionRepository permissionRepository) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(geocodedAddressProvider, "geocodedAddressProvider");
        Intrinsics.m26847b(navigator, "navigator");
        Intrinsics.m26847b(regionRepository, "regionRepository");
        Intrinsics.m26847b(preferenceRepository, "preferenceRepository");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        Intrinsics.m26847b(permissionRepository, "permissionRepository");
        this.f33864a = view;
        this.f33867e = geocodedAddressProvider;
        this.f33868f = navigator;
        this.f33869g = regionRepository;
        this.f33870h = preferenceRepository;
        this.f33871i = postExecutionThread;
        this.f33872j = permissionRepository;
    }

    public final void attach() {
        GeopopularRegionSelectFilter y_ = this.f33864a.y_();
        if (y_ != null) {
            m34682a(y_);
            return;
        }
        Object map = this.f33870h.m22472a().map(GeopopularRegionSelectPresenter$getPreviouslySelectedRegion$1.f28245a);
        Intrinsics.m26843a(map, "preferenceRepository.get…)\n        )\n      }\n    }");
        map = map.zipWith(this.f33869g.m22480a(), GeopopularRegionSelectPresenter$attach$regionsLoadResult$1.f28243a);
        Intrinsics.m26843a(map, "regionsLoadResult");
        map = map.map(GeopopularRegionSelectPresenter$mapToRegionPresentationModels$1.f28246a);
        Intrinsics.m26843a(map, "regionsLoadResult\n      …Ids\n          )\n        }");
        map = map.toObservable();
        Intrinsics.m26843a(map, "presentationModels.toObservable()");
        ObservableSource startWith = this.f33864a.mo7348b().startWith((Object) "");
        ObservableSource observableSource = (ObservableSource) map;
        Function2 function2 = C2824x403d12d9.f36465a;
        if (function2 != null) {
            function2 = new GeopopularRegionSelectPresenterKt$sam$BiFunction$52dc21f8(function2);
        }
        map = Observable.combineLatest(startWith, observableSource, (BiFunction) function2).map(new C2302x403d12da(this));
        Intrinsics.m26843a(map, "Observable.combineLatest…ds\n          )\n\n        }");
        map = ObservablesKt.m24092b(map, this.f33871i).subscribe((Consumer) new GeopopularRegionSelectPresenter$attach$2(this));
        Intrinsics.m26843a(map, "getFilterableRegionPrese…          }\n            }");
        handleDispose(map);
    }

    private final void m34682a(GeopopularRegionSelectFilter geopopularRegionSelectFilter) {
        Object subscribe = CompletablesKt.m24074b(this.f33870h.m22467a(geopopularRegionSelectFilter), this.f33871i).subscribe((Action) new GeopopularRegionSelectPresenter$saveRegionAndNotifyView$1(this, geopopularRegionSelectFilter));
        Intrinsics.m26843a(subscribe, "preferenceRepository\n   …ect(filter)\n            }");
        handleDispose(subscribe);
    }

    public final void m34688a() {
        if (this.f33872j.m23859a()) {
            m34690b();
        } else {
            this.f33864a.B_();
        }
    }

    public final void m34690b() {
        Object subscribe = this.f33867e.a().flatMap(new GeopopularRegionSelectPresenter$onLocationPermissionGranted$1(this)).subscribe((Consumer) new GeopopularRegionSelectPresenter$onLocationPermissionGranted$2(this));
        Intrinsics.m26843a(subscribe, "geocodedAddressProvider.…  }\n          }\n        }");
        handleDispose(subscribe);
    }

    private final void m34685a(String str, List<GeopopularRegionPresentationModel> list, List<GeopopularRegionPresentationModel> list2, String str2) {
        CharSequence charSequence = str;
        if (charSequence.length() == 0) {
            list2.addAll(list);
        } else if (!list.isEmpty()) {
            if (list2.isEmpty()) {
                com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel.Companion companion = GeopopularRegionPresentationModel.f20537f;
                Iterable<GeopopularRegionPresentationModel> iterable = list;
                Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                for (GeopopularRegionPresentationModel geopopularRegionPresentationModel : iterable) {
                    arrayList.add(geopopularRegionPresentationModel.f20538a);
                }
                list = com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel.Companion.m22847a((List) arrayList, null, str2, null, true, 10);
            }
            for (GeopopularRegionPresentationModel geopopularRegionPresentationModel2 : r12) {
                if (StringsKt__StringsKt.m42454a((CharSequence) geopopularRegionPresentationModel2.f20538a.getName(), charSequence, true)) {
                    list2.add(geopopularRegionPresentationModel2);
                }
                com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel.Companion companion2 = GeopopularRegionPresentationModel.f20537f;
                m34685a(str, com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel.Companion.m22847a(geopopularRegionPresentationModel2.f20538a.getSubregions(), null, str2, null, true, 10), list2, str2);
            }
        }
    }

    public final void m34689a(GeopopularRegionPresentationModel geopopularRegionPresentationModel) {
        Intrinsics.m26847b(geopopularRegionPresentationModel, "model");
        Region region = geopopularRegionPresentationModel.f20538a;
        if (!geopopularRegionPresentationModel.f20542e) {
            boolean z = true;
            if ((region.getSubregions().isEmpty() ^ 1) != 0) {
                List list;
                if (geopopularRegionPresentationModel.f20541d) {
                    if ((((CharSequence) geopopularRegionPresentationModel.f20540c).length() == null ? 1 : null) != null) {
                        geopopularRegionPresentationModel = this.f33868f;
                        list = this.f33866d;
                        if (list == null) {
                            Intrinsics.m26844a("selectedChildIds");
                        }
                        geopopularRegionPresentationModel.mo7344a(region, z, list);
                        return;
                    }
                }
                z = false;
                geopopularRegionPresentationModel = this.f33868f;
                list = this.f33866d;
                if (list == null) {
                    Intrinsics.m26844a("selectedChildIds");
                }
                geopopularRegionPresentationModel.mo7344a(region, z, list);
                return;
            }
        }
        m34682a(new GeopopularRegionSelectFilter(region.getGeoFilter(), region.getName()));
    }

    public static final /* synthetic */ Pair m34681a(GeopopularRegionSelectPresenter geopopularRegionSelectPresenter, Address address) {
        Region region;
        for (Object next : geopopularRegionSelectPresenter.f33865c) {
            if (StringsKt__StringsJVMKt.m41946a(((GeopopularRegionPresentationModel) next).f20538a.getId(), address.getCountryCode(), true)) {
                break;
            }
        }
        Object next2 = null;
        GeopopularRegionPresentationModel geopopularRegionPresentationModel = (GeopopularRegionPresentationModel) next2;
        if (geopopularRegionPresentationModel != null) {
            region = geopopularRegionPresentationModel.f20538a;
        } else {
            region = null;
        }
        if (region == null) {
            geopopularRegionSelectPresenter = geopopularRegionSelectPresenter.f33864a;
            String f = Util.m24027f((int) C1761R.string.geopopular_my_location_match_error);
            Intrinsics.m26843a((Object) f, "Util.getString(R.string.…_my_location_match_error)");
            geopopularRegionSelectPresenter.mo7346a(f);
            address = GeopopularRegionSelectFilter.f20532c;
            return new Pair(com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter.Companion.m22843a(), null);
        }
        for (Object next22 : region.getSubregions()) {
            if (StringsKt__StringsJVMKt.m41946a(((Region) next22).getName(), address.getAdminArea(), true)) {
                break;
            }
        }
        next22 = null;
        Region region2 = (Region) next22;
        if (region2 == null) {
            return new Pair(new GeopopularRegionSelectFilter(region.getId(), region.getName()), region);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(region.getId());
        stringBuilder.append('_');
        stringBuilder.append(region2.getId());
        return new Pair(new GeopopularRegionSelectFilter(stringBuilder.toString(), region2.getName()), region2);
    }
}
