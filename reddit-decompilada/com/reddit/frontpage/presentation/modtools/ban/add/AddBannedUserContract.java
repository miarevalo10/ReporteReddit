package com.reddit.frontpage.presentation.modtools.ban.add;

import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/ban/add/AddBannedUserContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AddBannedUserContract.kt */
public interface AddBannedUserContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH&J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\tH&J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH&J\u0016\u0010 \u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\"H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u0018\u0010\u0017\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\r¨\u0006#"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/ban/add/AddBannedUserContract$View;", "", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "getComment", "()Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "setComment", "(Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;)V", "commentId", "", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "getLink", "()Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "setLink", "(Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;)V", "subredditId", "getSubredditId", "setSubredditId", "subredditName", "getSubredditName", "setSubredditName", "onBanUserError", "", "errorMessage", "onBanUserSuccess", "username", "onReasonsError", "populateReasons", "rules", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AddBannedUserContract.kt */
    public interface View {
        String mo7376a();

        void mo7377a(String str);

        void mo7378a(List<String> list);

        String mo7379b();

        void mo7380b(String str);

        String mo7381c();

        void mo7241c(String str);

        Link mo7382d();
    }
}
