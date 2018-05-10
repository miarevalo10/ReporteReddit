package com.reddit.datalibrary.frontpage.data.feature.comments;

import android.annotation.TargetApi;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.reddit.common.dbflow.DatabaseDefinitionsKt;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase;
import com.reddit.datalibrary.frontpage.data.feature.common.CommentSortType;
import com.reddit.datalibrary.frontpage.data.model.CommentDataModel;
import com.reddit.datalibrary.frontpage.data.model.CommentDataModelType;
import com.reddit.frontpage.domain.model.Comment;
import com.reddit.frontpage.domain.model.IComment;
import com.reddit.frontpage.domain.model.MoreComment;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Moshi.Builder;
import io.reactivex.Completable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J(\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aH\u0002J&\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001a0\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0016\u0010!\u001a\u00020\u001e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\"H\u0002J\u001a\u0010#\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J \u0010$\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J(\u0010%\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a2\u0006\u0010&\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\f\u0010'\u001a\u00020\u0018*\u00020(H\u0002J*\u0010)\u001a\u00020(*\u00020\u00182\u0006\u0010*\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048BX\u0002¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\f\u0010\u0007R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/comments/DatabaseCommentDataSource;", "Lcom/reddit/datalibrary/frontpage/data/feature/comments/LocalCommentDataSource;", "()V", "commentAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/reddit/frontpage/domain/model/Comment;", "getCommentAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "commentAdapter$delegate", "Lkotlin/Lazy;", "moreCommentAdapter", "Lcom/reddit/frontpage/domain/model/MoreComment;", "getMoreCommentAdapter", "moreCommentAdapter$delegate", "moshi", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "editComment", "Lio/reactivex/Completable;", "comment", "getCommentsIterator", "", "Lkotlin/Pair;", "", "Lcom/reddit/frontpage/domain/model/IComment;", "comments", "", "getFlattenComments", "Lio/reactivex/Single;", "linkKindWithId", "", "sortType", "Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "getLinkKindWithId", "", "insertReply", "saveCommentsTree", "saveMoreCommentsTree", "moreCommentKindWithId", "fromDataModel", "Lcom/reddit/datalibrary/frontpage/data/model/CommentDataModel;", "toDataModel", "listingPosition", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@TargetApi(21)
/* compiled from: DatabaseCommentDataSource.kt */
public final class DatabaseCommentDataSource implements LocalCommentDataSource {
    static final /* synthetic */ KProperty[] f15806a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(DatabaseCommentDataSource.class), "commentAdapter", "getCommentAdapter()Lcom/squareup/moshi/JsonAdapter;")), Reflection.a(new PropertyReference1Impl(Reflection.a(DatabaseCommentDataSource.class), "moreCommentAdapter", "getMoreCommentAdapter()Lcom/squareup/moshi/JsonAdapter;"))};
    public static final Companion f15807b = new Companion();
    private final Moshi f15808c = new Builder().a();
    private final Lazy f15809d = LazyKt.a(new DatabaseCommentDataSource$commentAdapter$2(this));
    private final Lazy f15810e = LazyKt.a(new DatabaseCommentDataSource$moreCommentAdapter$2(this));

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/comments/DatabaseCommentDataSource$Companion;", "", "()V", "ROOT_NODE_COUNT", "", "SELECT_COMMENTS_QUERY", "", "TOP_NODE_POSITION", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DatabaseCommentDataSource.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final Completable mo2924a(Comment comment, CommentSortType commentSortType) {
        Intrinsics.b(comment, "comment");
        return DatabaseDefinitionsKt.m8724b(FlowManager.getDatabase(RedditFlowDatabase.class), new DatabaseCommentDataSource$insertReply$1(this, comment, commentSortType));
    }

    static /* synthetic */ CommentDataModel m15896a(DatabaseCommentDataSource databaseCommentDataSource, IComment iComment, CommentSortType commentSortType) {
        String kindWithId;
        String parentKindWithId;
        String toJson;
        if (iComment instanceof Comment) {
            kindWithId = iComment.getKindWithId();
            Comment comment = (Comment) iComment;
            parentKindWithId = comment.getParentKindWithId();
            String linkKindWithId = comment.getLinkKindWithId();
            toJson = ((JsonAdapter) databaseCommentDataSource.f15809d.b()).toJson(iComment);
            Intrinsics.a(toJson, "commentAdapter.toJson(this)");
            return new CommentDataModel(kindWithId, parentKindWithId, linkKindWithId, 0, toJson, null, commentSortType, 32, null);
        } else if (iComment instanceof MoreComment) {
            kindWithId = iComment.getKindWithId();
            parentKindWithId = ((MoreComment) iComment).getParentKindWithId();
            toJson = ((JsonAdapter) databaseCommentDataSource.f15810e.b()).toJson(iComment);
            Intrinsics.a(toJson, "moreCommentAdapter.toJson(this)");
            return new CommentDataModel(kindWithId, parentKindWithId, null, 0, toJson, CommentDataModelType.MORE, commentSortType);
        } else {
            throw ((Throwable) new RuntimeException("Unsupported comment type."));
        }
    }
}
