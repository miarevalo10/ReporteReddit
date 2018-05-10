package com.reddit.datalibrary.frontpage.data.feature.comments;

import com.reddit.datalibrary.frontpage.data.feature.common.CommentSortType;
import com.reddit.frontpage.domain.model.Comment;
import io.reactivex.Completable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J(\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001c\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\"\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J*\u0010\u0011\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u0013"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/comments/LocalCommentDataSource;", "", "editComment", "Lio/reactivex/Completable;", "comment", "Lcom/reddit/frontpage/domain/model/Comment;", "getFlattenComments", "Lio/reactivex/Single;", "", "Lcom/reddit/frontpage/domain/model/IComment;", "linkKindWithId", "", "sortType", "Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "insertReply", "saveCommentsTree", "comments", "saveMoreCommentsTree", "moreCommentKindWithId", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LocalCommentDataSource.kt */
public interface LocalCommentDataSource {
    Completable mo2924a(Comment comment, CommentSortType commentSortType);
}
