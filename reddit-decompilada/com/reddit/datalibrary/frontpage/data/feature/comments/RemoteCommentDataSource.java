package com.reddit.datalibrary.frontpage.data.feature.comments;

import com.reddit.datalibrary.frontpage.data.common.converter.CommentsList;
import com.reddit.datalibrary.frontpage.data.feature.common.CommentSortType;
import com.reddit.frontpage.domain.model.CommentResponse;
import com.reddit.frontpage.domain.model.CreateEditCommentResponse;
import com.reddit.frontpage.domain.model.IComment;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006H'JK\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0003\u0010\f\u001a\u00020\u00062\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0010H'¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u0006H'J,\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006H'J(\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010\u001b\u001a\u00020\u0006H'J\u0012\u0010\u001c\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u0006H'J\u0012\u0010\u001d\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u0006H'¨\u0006\u001e"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/comments/RemoteCommentDataSource;", "", "comment", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/domain/model/CreateEditCommentResponse;", "kindWithId", "", "text", "apiType", "comments", "Lcom/reddit/frontpage/domain/model/CommentResponse;", "linkId", "commentId", "sortType", "Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "limit", "", "context", "(Ljava/lang/String;Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;Ljava/lang/Integer;Ljava/lang/Integer;)Lio/reactivex/Single;", "delete", "Lio/reactivex/Completable;", "commentKindWithId", "edit", "moreComments", "", "Lcom/reddit/frontpage/domain/model/IComment;", "linkKindWithId", "children", "save", "unSave", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteCommentDataSource.kt */
public interface RemoteCommentDataSource {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: RemoteCommentDataSource.kt */
    public static final class DefaultImpls {
        @GET(a = "comments/{linkId}/{commentId}/")
        public static /* synthetic */ Single comments$default(RemoteCommentDataSource remoteCommentDataSource, String str, String str2, CommentSortType commentSortType, Integer num, Integer num2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: comments");
            }
            if ((i & 2) != null) {
                str2 = "";
            }
            return remoteCommentDataSource.comments(str, str2, (i & 4) != null ? null : commentSortType, (i & 8) != null ? null : num, (i & 16) != null ? null : num2);
        }

        @FormUrlEncoded
        @POST(a = "api/editusertext")
        public static /* synthetic */ Single edit$default(RemoteCommentDataSource remoteCommentDataSource, String str, String str2, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: edit");
            }
            if ((i & 4) != 0) {
                str3 = "json";
            }
            return remoteCommentDataSource.edit(str, str2, str3);
        }

        @FormUrlEncoded
        @POST(a = "api/comment")
        public static /* synthetic */ Single comment$default(RemoteCommentDataSource remoteCommentDataSource, String str, String str2, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: comment");
            }
            if ((i & 4) != 0) {
                str3 = "json";
            }
            return remoteCommentDataSource.comment(str, str2, str3);
        }
    }

    @FormUrlEncoded
    @POST(a = "api/comment")
    Single<CreateEditCommentResponse> comment(@Field(a = "thing_id") String str, @Field(a = "text") String str2, @Field(a = "api_type") String str3);

    @GET(a = "comments/{linkId}/{commentId}/")
    Single<CommentResponse> comments(@Path(a = "linkId") String str, @Path(a = "commentId") String str2, @Query(a = "sort") CommentSortType commentSortType, @Query(a = "limit") Integer num, @Query(a = "context") Integer num2);

    @FormUrlEncoded
    @POST(a = "api/del")
    Completable delete(@Field(a = "id") String str);

    @FormUrlEncoded
    @POST(a = "api/editusertext")
    Single<CreateEditCommentResponse> edit(@Field(a = "thing_id") String str, @Field(a = "text") String str2, @Field(a = "api_type") String str3);

    @CommentsList
    @FormUrlEncoded
    @POST(a = "api/morechildren")
    Single<List<IComment>> moreComments(@Field(a = "link_id") String str, @Field(a = "children") String str2);

    @FormUrlEncoded
    @POST(a = "api/save")
    Completable save(@Field(a = "id") String str);

    @FormUrlEncoded
    @POST(a = "api/unsave")
    Completable unSave(@Field(a = "id") String str);
}
