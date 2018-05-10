package com.reddit.frontpage.presentation.usermodal;

import android.content.Context;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.presentation.usermodal.UserModalPresenter.UserModalInfo;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/frontpage/presentation/usermodal/UserModalContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserModalContract.kt */
public interface UserModalContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0011H&J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020\u0015H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/reddit/frontpage/presentation/usermodal/UserModalContract$View;", "", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "getComment", "()Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "setComment", "(Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "getLink", "()Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "username", "", "getUsername", "()Ljava/lang/String;", "onComplete", "", "action", "Lcom/reddit/frontpage/presentation/usermodal/UserModalAction;", "stringRes", "", "onError", "message", "onProfileDataReady", "data", "Lcom/reddit/frontpage/presentation/usermodal/UserModalPresenter$UserModalInfo;", "show", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserModalContract.kt */
    public interface View {
        String mo4933a();

        void mo4934a(UserModalAction userModalAction, int i);

        void mo4935a(UserModalInfo userModalInfo);

        void mo4936a(String str);

        Link mo4937b();

        Context mo4938c();
    }
}
