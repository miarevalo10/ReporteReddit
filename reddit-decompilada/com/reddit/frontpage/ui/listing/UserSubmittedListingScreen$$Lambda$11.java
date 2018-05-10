package com.reddit.frontpage.ui.listing;

import com.reddit.datalibrary.frontpage.service.api.VideoUploadService;
import com.reddit.frontpage.FrontpageApplication;
import io.reactivex.functions.Function;
import java.util.List;

final /* synthetic */ class UserSubmittedListingScreen$$Lambda$11 implements Function {
    static final Function f29078a = new UserSubmittedListingScreen$$Lambda$11();

    private UserSubmittedListingScreen$$Lambda$11() {
    }

    public final Object apply(Object obj) {
        return FrontpageApplication.f27402a.startService(VideoUploadService.getVideoTranscodingFinishedIntent(FrontpageApplication.f27402a, (List) obj));
    }
}
