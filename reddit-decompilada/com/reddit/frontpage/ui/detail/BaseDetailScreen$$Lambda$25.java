package com.reddit.frontpage.ui.detail;

import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import timber.log.Timber;

final /* synthetic */ class BaseDetailScreen$$Lambda$25 implements Runnable {
    private final BaseDetailScreen f21146a;
    private final Link f21147b;

    BaseDetailScreen$$Lambda$25(BaseDetailScreen baseDetailScreen, Link link) {
        this.f21146a = baseDetailScreen;
        this.f21147b = link;
    }

    public final void run() {
        BaseDetailScreen baseDetailScreen = this.f21146a;
        Link link = this.f21147b;
        boolean z = link instanceof ClientLink;
        if (!(!z || link.getMedia() == null || link.getMedia().getRedditVideo() == null)) {
            String dashUrl = link.getMedia().getRedditVideo().getDashUrl();
            int lastIndexOf = dashUrl.lastIndexOf(47);
            dashUrl = dashUrl.substring(dashUrl.substring(0, lastIndexOf).lastIndexOf(Operation.DIVISION) + 1, lastIndexOf);
            Timber.b("Deleting video DB entry title [%s] and key [%s]", new Object[]{link.getTitle(), dashUrl});
            SQLite.delete(VideoUpload.class).where(new SQLOperator[]{VideoUpload_Table.videoKey.eq(dashUrl)}).execute();
        }
        if (z && !TextUtils.isEmpty(baseDetailScreen.f39159Q)) {
            Timber.b("Deleting video DB entry title [%s] and uploadRequestId [%s]", new Object[]{link.getTitle(), baseDetailScreen.f39159Q});
            SQLite.delete(VideoUpload.class).where(new SQLOperator[]{VideoUpload_Table.requestId.eq(baseDetailScreen.f39159Q)}).execute();
        }
    }
}
