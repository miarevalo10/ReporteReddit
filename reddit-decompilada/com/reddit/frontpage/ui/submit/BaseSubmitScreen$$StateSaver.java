package com.reddit.frontpage.ui.submit;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import com.reddit.frontpage.ui.submit.search.SubredditSelectEvent;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public class BaseSubmitScreen$$StateSaver<T extends BaseSubmitScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.submit.BaseSubmitScreen$$StateSaver", BUNDLERS);

    static {
        BUNDLERS.put("Flair", new ParcelerBundler());
        BUNDLERS.put("SelectedSubredditData", new ParcelerBundler());
        BUNDLERS.put("FlairList", new ParcelerBundler());
    }

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putWithBundler(bundle, "Flair", t.flair);
        HELPER.putParcelable(bundle, "OriginSubreddit", t.originSubreddit);
        HELPER.putWithBundler(bundle, "SelectedSubredditData", t.selectedSubredditData);
        HELPER.putDouble(bundle, "Latitude", t.latitude);
        HELPER.putDouble(bundle, "Longitude", t.longitude);
        HELPER.putString(bundle, "FlairTextEdit", t.flairTextEdit);
        HELPER.putString(bundle, "RequestId", t.requestId);
        HELPER.putString(bundle, "SubredditSelectRequestId", t.subredditSelectRequestId);
        HELPER.putString(bundle, "SubmitRequestId", t.submitRequestId);
        HELPER.putString(bundle, "LocationKeyColor", t.locationKeyColor);
        HELPER.putString(bundle, "LocationName", t.locationName);
        HELPER.putWithBundler(bundle, "FlairList", t.flairList);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.flair = (LinkFlair) HELPER.getWithBundler(bundle, "Flair");
        t.originSubreddit = (Subreddit) HELPER.getParcelable(bundle, "OriginSubreddit");
        t.selectedSubredditData = (SubredditSelectEvent) HELPER.getWithBundler(bundle, "SelectedSubredditData");
        t.latitude = HELPER.getDouble(bundle, "Latitude");
        t.longitude = HELPER.getDouble(bundle, "Longitude");
        t.flairTextEdit = HELPER.getString(bundle, "FlairTextEdit");
        String string = HELPER.getString(bundle, "RequestId");
        Intrinsics.m26847b(string, "<set-?>");
        t.requestId = string;
        t.subredditSelectRequestId = HELPER.getString(bundle, "SubredditSelectRequestId");
        t.m39537a(HELPER.getString(bundle, "SubmitRequestId"));
        t.locationKeyColor = HELPER.getString(bundle, "LocationKeyColor");
        t.locationName = HELPER.getString(bundle, "LocationName");
        t.flairList = (List) HELPER.getWithBundler(bundle, "FlairList");
    }
}
