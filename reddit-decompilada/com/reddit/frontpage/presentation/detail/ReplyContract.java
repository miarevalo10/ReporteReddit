package com.reddit.frontpage.presentation.detail;

import com.reddit.datalibrary.frontpage.data.feature.common.CommentSortType;
import com.reddit.frontpage.domain.model.Comment;
import com.reddit.frontpage.presentation.common.BasePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/ReplyContract;", "", "Parameters", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ReplyContract.kt */
public interface ReplyContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/ReplyContract$Parameters;", "", "kindWithId", "", "sortType", "Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "(Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;)V", "getKindWithId", "()Ljava/lang/String;", "getSortType", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ReplyContract.kt */
    public static final class Parameters {
        final String f20498a;
        final CommentSortType f20499b;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    Parameters parameters = (Parameters) obj;
                    if (Intrinsics.m26845a(this.f20498a, parameters.f20498a) && Intrinsics.m26845a(this.f20499b, parameters.f20499b)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f20498a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            CommentSortType commentSortType = this.f20499b;
            if (commentSortType != null) {
                i = commentSortType.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Parameters(kindWithId=");
            stringBuilder.append(this.f20498a);
            stringBuilder.append(", sortType=");
            stringBuilder.append(this.f20499b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Parameters(String str, CommentSortType commentSortType) {
            Intrinsics.m26847b(str, "kindWithId");
            this.f20498a = str;
            this.f20499b = commentSortType;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/ReplyContract$View;", "", "replyText", "", "getReplyText", "()Ljava/lang/String;", "hideProgressDialog", "", "navigateAway", "comment", "Lcom/reddit/frontpage/domain/model/Comment;", "showDiscardWarningDialog", "showErrorMessage", "message", "showFallbackErrorMessage", "showGenericErrorMessage", "showProgressDialog", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ReplyContract.kt */
    public interface View {
        void mo7340a(Comment comment);

        void mo7164a(String str);

        void mo7165b(String str);

        String mo7166c();

        void mo7167d();

        void mo7168e();

        void mo7169f();

        void mo7170g();

        void mo7171i();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/ReplyContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "onLeaveSelected", "", "onSubmitSelected", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ReplyContract.kt */
    public interface Presenter extends BasePresenter {
        void mo6455a();

        void mo6456b();
    }
}
