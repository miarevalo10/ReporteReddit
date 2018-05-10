package com.reddit.frontpage.presentation.flair;

import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/frontpage/presentation/flair/LinkFlairSelectContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkFlairSelectContract.kt */
public interface LinkFlairSelectContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H&J\b\u0010\u0012\u001a\u00020\u000fH&J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0003H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/flair/LinkFlairSelectContract$View;", "", "selectedFlair", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "getSelectedFlair", "()Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "setSelectedFlair", "(Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;)V", "subredditName", "", "getSubredditName", "()Ljava/lang/String;", "setSubredditName", "(Ljava/lang/String;)V", "addFlairs", "", "flairs", "", "onError", "showCustomFlairDialog", "editableFlair", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkFlairSelectContract.kt */
    public interface View {
        String mo7244a();

        void mo7245a(List<? extends LinkFlair> list);

        void mo7246b();
    }
}
