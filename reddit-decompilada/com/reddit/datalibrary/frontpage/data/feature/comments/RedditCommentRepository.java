package com.reddit.datalibrary.frontpage.data.feature.comments;

import android.os.Build.VERSION;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.Thread;
import com.reddit.datalibrary.frontpage.data.common.websocket.ObservableWebSocketClient;
import com.reddit.datalibrary.frontpage.data.feature.comments.RemoteCommentDataSource.DefaultImpls;
import com.reddit.datalibrary.frontpage.data.feature.common.CommentSortType;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.LocalLinkDataSource;
import com.reddit.frontpage.domain.model.Comment;
import com.reddit.frontpage.domain.model.Result;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u00016B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ.\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J$\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J_\u0010\u001a\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001c0\u001bj\u0002` 0\u000e2\u0006\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0002\u0010&J<\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u000e2\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120+2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0-2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u0010\u00103\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u0016\u00104\u001a\u00020\u0017*\u00020\u00172\b\b\u0002\u00105\u001a\u00020$H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/comments/RedditCommentRepository;", "Lcom/reddit/datalibrary/frontpage/data/feature/comments/CommentRepository;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/comments/RemoteCommentDataSource;", "local", "Lcom/reddit/datalibrary/frontpage/data/feature/comments/LocalCommentDataSource;", "localLinkDatSource", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LocalLinkDataSource;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "webSocketClient", "Lcom/reddit/datalibrary/frontpage/data/common/websocket/ObservableWebSocketClient;", "(Lcom/reddit/datalibrary/frontpage/data/feature/comments/RemoteCommentDataSource;Lcom/reddit/datalibrary/frontpage/data/feature/comments/LocalCommentDataSource;Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LocalLinkDataSource;Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/datalibrary/frontpage/data/common/websocket/ObservableWebSocketClient;)V", "comment", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/domain/model/Result;", "Lcom/reddit/frontpage/domain/model/Comment;", "kindWithId", "", "text", "sortType", "Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "delete", "Lio/reactivex/Completable;", "commentKindWithId", "edit", "getCommentsFlatList", "Lcom/reddit/datalibrary/frontpage/data/feature/comments/CommentRepository$StatefulResult;", "Lkotlin/Pair;", "Lcom/reddit/frontpage/domain/model/Link;", "", "Lcom/reddit/frontpage/domain/model/IComment;", "Lcom/reddit/datalibrary/frontpage/data/feature/comments/CommentsResult;", "linkId", "commentId", "limit", "", "context", "(Ljava/lang/String;Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;Ljava/lang/Integer;Ljava/lang/Integer;)Lio/reactivex/Single;", "getMoreCommentsFlatList", "linkKindWithId", "moreCommentKindWithId", "children", "", "liveThread", "Lio/reactivex/Flowable;", "Lio/reactivex/Notification;", "Lcom/reddit/frontpage/domain/model/LiveComment;", "uri", "Ljava/net/URI;", "save", "unSave", "runWithMinSdk", "minSdk", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditCommentRepository.kt */
public final class RedditCommentRepository implements CommentRepository {
    public static final Companion f15814a = new Companion();
    private final RemoteCommentDataSource f15815b;
    private final LocalCommentDataSource f15816c;
    private final LocalLinkDataSource f15817d;
    private final BackgroundThread f15818e;
    private final ObservableWebSocketClient f15819f;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/comments/RedditCommentRepository$Companion;", "", "()V", "COMMENTS_SEPARATOR", "", "COMMENT_LIMIT", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditCommentRepository.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public RedditCommentRepository(RemoteCommentDataSource remoteCommentDataSource, LocalCommentDataSource localCommentDataSource, LocalLinkDataSource localLinkDataSource, BackgroundThread backgroundThread, ObservableWebSocketClient observableWebSocketClient) {
        Intrinsics.b(remoteCommentDataSource, "remote");
        Intrinsics.b(localCommentDataSource, "local");
        Intrinsics.b(localLinkDataSource, "localLinkDatSource");
        Intrinsics.b(backgroundThread, "backgroundThread");
        Intrinsics.b(observableWebSocketClient, "webSocketClient");
        this.f15815b = remoteCommentDataSource;
        this.f15816c = localCommentDataSource;
        this.f15817d = localLinkDataSource;
        this.f15818e = backgroundThread;
        this.f15819f = observableWebSocketClient;
    }

    public final Single<Result<Comment>> mo2925a(String str, String str2, CommentSortType commentSortType) {
        Intrinsics.b(str, "kindWithId");
        Intrinsics.b(str2, "text");
        str = DefaultImpls.comment$default(this.f15815b, str, str2, null, 4, null).flatMap((Function) new RedditCommentRepository$comment$1(this, commentSortType));
        Intrinsics.a(str, "remote.comment(kindWithI…mment))\n        }\n      }");
        return SinglesKt.a(str, (Thread) this.f15818e);
    }

    static /* synthetic */ Completable m15900a(Completable completable) {
        if (VERSION.SDK_INT >= 21) {
            return completable;
        }
        completable = Completable.complete();
        Intrinsics.a(completable, "Completable.complete()");
        return completable;
    }
}
