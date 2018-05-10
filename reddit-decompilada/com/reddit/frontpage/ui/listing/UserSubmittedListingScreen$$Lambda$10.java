package com.reddit.frontpage.ui.listing;

import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.TranscodingCompleteEvent;
import io.reactivex.functions.Function;

final /* synthetic */ class UserSubmittedListingScreen$$Lambda$10 implements Function {
    static final Function f29077a = new UserSubmittedListingScreen$$Lambda$10();

    private UserSubmittedListingScreen$$Lambda$10() {
    }

    public final Object apply(Object obj) {
        return new TranscodingCompleteEvent((String) obj, true);
    }
}
