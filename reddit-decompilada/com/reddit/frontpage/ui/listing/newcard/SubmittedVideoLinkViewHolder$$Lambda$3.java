package com.reddit.frontpage.ui.listing.newcard;

import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload_Table;
import java.util.concurrent.Callable;

final /* synthetic */ class SubmittedVideoLinkViewHolder$$Lambda$3 implements Callable {
    private final SubmittedVideoLinkViewHolder f21376a;
    private final VideoUpload f21377b;

    SubmittedVideoLinkViewHolder$$Lambda$3(SubmittedVideoLinkViewHolder submittedVideoLinkViewHolder, VideoUpload videoUpload) {
        this.f21376a = submittedVideoLinkViewHolder;
        this.f21377b = videoUpload;
    }

    public final Object call() {
        String requestId = this.f21377b.getRequestId();
        return (VideoUpload) SQLite.select(new IProperty[0]).from(VideoUpload.class).where(new SQLOperator[]{VideoUpload_Table.requestId.eq(requestId)}).querySingle();
    }
}
