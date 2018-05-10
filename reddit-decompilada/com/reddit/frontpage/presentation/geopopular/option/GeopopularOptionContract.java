package com.reddit.frontpage.presentation.geopopular.option;

import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract;", "", "Navigator", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularOptionContract.kt */
public interface GeopopularOptionContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$Navigator;", "", "navigateToGeopopularRegionSelect", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularOptionContract.kt */
    public interface Navigator {
        void mo7173a();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$View;", "", "clearSelections", "", "notifyRegionSelect", "select", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "setGlobalOption", "setOtherOption", "name", "", "showError", "message", "showLocationPermissionRequest", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularOptionContract.kt */
    public interface View {
        void mo7174a(GeopopularRegionSelectFilter geopopularRegionSelectFilter);

        void a_(String str);

        void mo7176b();

        void mo7177b(String str);

        void mo7178c();

        void mo7179d();
    }
}
