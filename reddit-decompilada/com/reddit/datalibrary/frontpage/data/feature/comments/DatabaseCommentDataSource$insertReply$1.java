package com.reddit.datalibrary.frontpage.data.feature.comments;

import com.raizlabs.android.dbflow.sql.language.IConditional;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.reddit.datalibrary.frontpage.data.feature.common.CommentSortType;
import com.reddit.datalibrary.frontpage.data.model.CommentDataModel;
import com.reddit.datalibrary.frontpage.data.model.CommentDataModel_Table;
import com.reddit.frontpage.domain.model.Comment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseCommentDataSource.kt */
final class DatabaseCommentDataSource$insertReply$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DatabaseCommentDataSource f19355a;
    final /* synthetic */ Comment f19356b;
    final /* synthetic */ CommentSortType f19357c;

    DatabaseCommentDataSource$insertReply$1(DatabaseCommentDataSource databaseCommentDataSource, Comment comment, CommentSortType commentSortType) {
        this.f19355a = databaseCommentDataSource;
        this.f19356b = comment;
        this.f19357c = commentSortType;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        SQLite.update(CommentDataModel.class).set(CommentDataModel_Table.listingPosition.eq((IConditional) CommentDataModel_Table.listingPosition.plus(Integer.valueOf(1)))).where(CommentDataModel_Table.parentId.eq(this.f19356b.getParentKindWithId())).execute();
        DatabaseCommentDataSource.m15896a(this.f19355a, this.f19356b, this.f19357c).save();
        return Unit.a;
    }
}
