package com.reddit.frontpage.presentation.geopopular.select;

import com.reddit.frontpage.domain.model.Region;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectContract;", "", "Navigator", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectContract.kt */
public interface GeopopularRegionSelectContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectContract$Navigator;", "", "navigateToSubregionSelect", "", "parent", "Lcom/reddit/frontpage/domain/model/Region;", "parentPreviouslySelected", "", "selectedChildIds", "", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularRegionSelectContract.kt */
    public interface Navigator {
        void mo7344a(Region region, boolean z, List<String> list);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bH&J\u0016\u0010\u0010\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0004H&J\b\u0010\u0016\u001a\u00020\fH&J\b\u0010\u0017\u001a\u00020\fH&J\b\u0010\u0018\u001a\u00020\fH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectContract$View;", "", "searchQuery", "Lio/reactivex/Observable;", "", "getSearchQuery", "()Lio/reactivex/Observable;", "subregionSelectFilter", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "getSubregionSelectFilter", "()Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "hideRegionList", "", "hideUseLocation", "notifyRegionSelect", "select", "setRegions", "regions", "", "Lcom/reddit/frontpage/presentation/geopopular/model/GeopopularRegionPresentationModel;", "showError", "string", "showLocationPermissionRequest", "showRegionList", "showUseLocation", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularRegionSelectContract.kt */
    public interface View {
        void A_();

        void B_();

        void mo7346a(String str);

        void mo7347a(List<GeopopularRegionPresentationModel> list);

        Observable<String> mo7348b();

        void mo7349b(GeopopularRegionSelectFilter geopopularRegionSelectFilter);

        void mo7350c();

        void mo7351d();

        GeopopularRegionSelectFilter y_();

        void z_();
    }
}
