package com.reddit.frontpage.presentation.geopopular.subregion;

import com.reddit.frontpage.domain.model.Region;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectContract;", "", "Navigator", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularSubregionSelectContract.kt */
public interface GeopopularSubregionSelectContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectContract$Navigator;", "", "navigateAway", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularSubregionSelectContract.kt */
    public interface Navigator {
        void ai_();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0016\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectContract$View;", "", "parent", "Lcom/reddit/frontpage/domain/model/Region;", "getParent", "()Lcom/reddit/frontpage/domain/model/Region;", "parentIsPreviouslySelected", "", "getParentIsPreviouslySelected", "()Z", "selectedChildIds", "", "", "getSelectedChildIds", "()Ljava/util/List;", "notifyRegionSelect", "", "select", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "setRegions", "models", "Lcom/reddit/frontpage/presentation/geopopular/model/GeopopularRegionPresentationModel;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularSubregionSelectContract.kt */
    public interface View {
        Region mo7354a();

        void mo7355a(GeopopularRegionSelectFilter geopopularRegionSelectFilter);

        void mo7356a(List<GeopopularRegionPresentationModel> list);

        List<String> mo7358b();
    }
}
