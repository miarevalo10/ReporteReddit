package com.reddit.datalibrary.frontpage.data.model;

import com.raizlabs.android.dbflow.structure.BaseModel;
import com.reddit.datalibrary.frontpage.data.feature.common.CommentSortType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003JU\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0007HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00062"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/CommentDataModel;", "Lcom/raizlabs/android/dbflow/structure/BaseModel;", "commentId", "", "parentId", "linkId", "listingPosition", "", "commentJson", "type", "Lcom/reddit/datalibrary/frontpage/data/model/CommentDataModelType;", "sortType", "Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/reddit/datalibrary/frontpage/data/model/CommentDataModelType;Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;)V", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "getCommentJson", "setCommentJson", "getLinkId", "setLinkId", "getListingPosition", "()I", "setListingPosition", "(I)V", "getParentId", "setParentId", "getSortType", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "setSortType", "(Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;)V", "getType", "()Lcom/reddit/datalibrary/frontpage/data/model/CommentDataModelType;", "setType", "(Lcom/reddit/datalibrary/frontpage/data/model/CommentDataModelType;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommentDataModel.kt */
public final class CommentDataModel extends BaseModel {
    private String commentId;
    private String commentJson;
    private String linkId;
    private int listingPosition;
    private String parentId;
    private CommentSortType sortType;
    private CommentDataModelType type;

    public CommentDataModel() {
        this(null, null, null, 0, null, null, null, 127, null);
    }

    public static /* synthetic */ CommentDataModel copy$default(CommentDataModel commentDataModel, String str, String str2, String str3, int i, String str4, CommentDataModelType commentDataModelType, CommentSortType commentSortType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = commentDataModel.commentId;
        }
        if ((i2 & 2) != 0) {
            str2 = commentDataModel.parentId;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = commentDataModel.linkId;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            i = commentDataModel.listingPosition;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str4 = commentDataModel.commentJson;
        }
        String str7 = str4;
        if ((i2 & 32) != 0) {
            commentDataModelType = commentDataModel.type;
        }
        CommentDataModelType commentDataModelType2 = commentDataModelType;
        if ((i2 & 64) != 0) {
            commentSortType = commentDataModel.sortType;
        }
        return commentDataModel.copy(str, str5, str6, i3, str7, commentDataModelType2, commentSortType);
    }

    public final String component1() {
        return this.commentId;
    }

    public final String component2() {
        return this.parentId;
    }

    public final String component3() {
        return this.linkId;
    }

    public final int component4() {
        return this.listingPosition;
    }

    public final String component5() {
        return this.commentJson;
    }

    public final CommentDataModelType component6() {
        return this.type;
    }

    public final CommentSortType component7() {
        return this.sortType;
    }

    public final CommentDataModel copy(String str, String str2, String str3, int i, String str4, CommentDataModelType commentDataModelType, CommentSortType commentSortType) {
        String str5 = str;
        Intrinsics.b(str5, "commentId");
        String str6 = str4;
        Intrinsics.b(str6, "commentJson");
        CommentDataModelType commentDataModelType2 = commentDataModelType;
        Intrinsics.b(commentDataModelType2, "type");
        return new CommentDataModel(str5, str2, str3, i, str6, commentDataModelType2, commentSortType);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CommentDataModel) {
            CommentDataModel commentDataModel = (CommentDataModel) obj;
            if (Intrinsics.a(this.commentId, commentDataModel.commentId) && Intrinsics.a(this.parentId, commentDataModel.parentId) && Intrinsics.a(this.linkId, commentDataModel.linkId)) {
                return (this.listingPosition == commentDataModel.listingPosition) && Intrinsics.a(this.commentJson, commentDataModel.commentJson) && Intrinsics.a(this.type, commentDataModel.type) && Intrinsics.a(this.sortType, commentDataModel.sortType);
            }
        }
    }

    public final int hashCode() {
        String str = this.commentId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.parentId;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.linkId;
        hashCode = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.listingPosition) * 31;
        str2 = this.commentJson;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        CommentDataModelType commentDataModelType = this.type;
        hashCode = (hashCode + (commentDataModelType != null ? commentDataModelType.hashCode() : 0)) * 31;
        CommentSortType commentSortType = this.sortType;
        if (commentSortType != null) {
            i = commentSortType.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CommentDataModel(commentId=");
        stringBuilder.append(this.commentId);
        stringBuilder.append(", parentId=");
        stringBuilder.append(this.parentId);
        stringBuilder.append(", linkId=");
        stringBuilder.append(this.linkId);
        stringBuilder.append(", listingPosition=");
        stringBuilder.append(this.listingPosition);
        stringBuilder.append(", commentJson=");
        stringBuilder.append(this.commentJson);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", sortType=");
        stringBuilder.append(this.sortType);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final void setCommentId(String str) {
        Intrinsics.b(str, "<set-?>");
        this.commentId = str;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final void setParentId(String str) {
        this.parentId = str;
    }

    public final String getLinkId() {
        return this.linkId;
    }

    public final void setLinkId(String str) {
        this.linkId = str;
    }

    public final int getListingPosition() {
        return this.listingPosition;
    }

    public final void setListingPosition(int i) {
        this.listingPosition = i;
    }

    public final String getCommentJson() {
        return this.commentJson;
    }

    public final void setCommentJson(String str) {
        Intrinsics.b(str, "<set-?>");
        this.commentJson = str;
    }

    public /* synthetic */ CommentDataModel(String str, String str2, String str3, int i, String str4, CommentDataModelType commentDataModelType, CommentSortType commentSortType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 1) != null) {
            str = "";
        }
        CommentSortType commentSortType2 = null;
        defaultConstructorMarker = (i2 & 2) != null ? null : str2;
        String str5 = (i2 & 4) != null ? null : str3;
        if ((i2 & 8) != null) {
            i = 0;
        }
        int i3 = i;
        if ((i2 & 16) != null) {
            str4 = "";
        }
        String str6 = str4;
        if ((i2 & 32) != null) {
            commentDataModelType = CommentDataModelType.COMMENT;
        }
        CommentDataModelType commentDataModelType2 = commentDataModelType;
        if ((i2 & 64) == null) {
            commentSortType2 = commentSortType;
        }
        this(str, defaultConstructorMarker, str5, i3, str6, commentDataModelType2, commentSortType2);
    }

    public final CommentDataModelType getType() {
        return this.type;
    }

    public final void setType(CommentDataModelType commentDataModelType) {
        Intrinsics.b(commentDataModelType, "<set-?>");
        this.type = commentDataModelType;
    }

    public final CommentSortType getSortType() {
        return this.sortType;
    }

    public final void setSortType(CommentSortType commentSortType) {
        this.sortType = commentSortType;
    }

    public CommentDataModel(String str, String str2, String str3, int i, String str4, CommentDataModelType commentDataModelType, CommentSortType commentSortType) {
        Intrinsics.b(str, "commentId");
        Intrinsics.b(str4, "commentJson");
        Intrinsics.b(commentDataModelType, "type");
        this.commentId = str;
        this.parentId = str2;
        this.linkId = str3;
        this.listingPosition = i;
        this.commentJson = str4;
        this.type = commentDataModelType;
        this.sortType = commentSortType;
    }
}
