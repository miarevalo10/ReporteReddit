package com.reddit.frontpage.presentation.geopopular.subregion;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel;
import com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel.Companion;
import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularSubregionSelectContract.Navigator;
import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularSubregionSelectContract.View;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000fH\u0016R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectContract$View;", "navigator", "Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectContract$Navigator;", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectContract$View;Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectContract$Navigator;Lcom/reddit/frontpage/domain/repository/PreferenceRepository;Lcom/reddit/common/rx/PostExecutionThread;)V", "currentViewRegionStack", "", "", "Lcom/reddit/frontpage/presentation/geopopular/model/GeopopularRegionPresentationModel;", "attach", "", "onAllRegionsClicked", "onNavigateBack", "onRegionClicked", "model", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularSubregionSelectPresenter.kt */
public final class GeopopularSubregionSelectPresenter extends DisposablePresenter {
    final List<List<GeopopularRegionPresentationModel>> f33874a = ((List) new ArrayList());
    final View f33875b;
    final Navigator f33876c;
    private final PreferenceRepository f33877d;
    private final PostExecutionThread f33878e;

    @Inject
    public GeopopularSubregionSelectPresenter(View view, Navigator navigator, PreferenceRepository preferenceRepository, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(navigator, "navigator");
        Intrinsics.m26847b(preferenceRepository, "preferenceRepository");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        this.f33875b = view;
        this.f33876c = navigator;
        this.f33877d = preferenceRepository;
        this.f33878e = postExecutionThread;
    }

    public final void attach() {
        if (this.f33874a.isEmpty()) {
            String str = (String) CollectionsKt___CollectionsKt.m41434e(this.f33875b.mo7358b());
            if (str == null) {
                str = "";
            }
            String str2 = str;
            List list = this.f33874a;
            Companion companion = GeopopularRegionPresentationModel.f20537f;
            list.add(CollectionsKt___CollectionsKt.m41418a((Iterable) Companion.m22847a(this.f33875b.mo7354a().getSubregions(), str2, null, null, false, 28), (Comparator) new GeopopularSubregionSelectPresenter$attach$$inlined$sortedBy$1()));
        }
        this.f33875b.mo7356a((List) CollectionsKt___CollectionsKt.m41437f(this.f33874a));
    }

    public final void m34693a(GeopopularRegionPresentationModel geopopularRegionPresentationModel) {
        Intrinsics.m26847b(geopopularRegionPresentationModel, "model");
        geopopularRegionPresentationModel = geopopularRegionPresentationModel.f20538a;
        Companion companion = GeopopularRegionPresentationModel.f20537f;
        List a = Companion.m22847a(geopopularRegionPresentationModel.getSubregions(), null, null, null, false, 30);
        if (a.isEmpty()) {
            GeopopularRegionSelectFilter geopopularRegionSelectFilter = new GeopopularRegionSelectFilter(geopopularRegionPresentationModel.getGeoFilter(), geopopularRegionPresentationModel.getName());
            Object subscribe = CompletablesKt.m24074b(this.f33877d.m22467a(geopopularRegionSelectFilter), this.f33878e).subscribe((Action) new GeopopularSubregionSelectPresenter$onRegionClicked$1(this, geopopularRegionSelectFilter));
            Intrinsics.m26843a(subscribe, "preferenceRepository\n   …                        }");
            handleDispose(subscribe);
            return;
        }
        this.f33874a.add(a);
        this.f33875b.mo7356a(a);
    }
}
