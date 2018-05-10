package com.reddit.datalibrary.frontpage.data.feature.comments;

import com.reddit.frontpage.domain.model.Comment;
import com.squareup.moshi.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/reddit/frontpage/domain/model/Comment;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseCommentDataSource.kt */
final class DatabaseCommentDataSource$commentAdapter$2 extends Lambda implements Function0<JsonAdapter<Comment>> {
    final /* synthetic */ DatabaseCommentDataSource f19354a;

    DatabaseCommentDataSource$commentAdapter$2(DatabaseCommentDataSource databaseCommentDataSource) {
        this.f19354a = databaseCommentDataSource;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return this.f19354a.f15808c.a(Comment.class);
    }
}
