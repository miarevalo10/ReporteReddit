package com.reddit.frontpage.presentation.detail;

import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.common.BasePresenter;
import com.reddit.frontpage.presentation.detail.common.Editable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/EditContract;", "", "CommentParameters", "LinkParameters", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: EditContract.kt */
public interface EditContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/EditContract$LinkParameters;", "", "link", "Lcom/reddit/frontpage/domain/model/Link;", "(Lcom/reddit/frontpage/domain/model/Link;)V", "getLink", "()Lcom/reddit/frontpage/domain/model/Link;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: EditContract.kt */
    public static final class LinkParameters {
        final Link f20495a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof LinkParameters) {
                    if (Intrinsics.m26845a(this.f20495a, ((LinkParameters) obj).f20495a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            Link link = this.f20495a;
            return link != null ? link.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("LinkParameters(link=");
            stringBuilder.append(this.f20495a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public LinkParameters(Link link) {
            Intrinsics.m26847b(link, "link");
            this.f20495a = link;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u0014\u0010\b\u001a\u00020\u00072\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/EditContract$View;", "", "editedText", "", "getEditedText", "()Ljava/lang/String;", "hideProgressDialog", "", "navigateAway", "editable", "Lcom/reddit/frontpage/presentation/detail/common/Editable;", "showErrorMessage", "message", "showFallbackErrorMessage", "showProgressDialog", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: EditContract.kt */
    public interface View {
        String mo7153a();

        void mo7154a(Editable<?> editable);

        void mo7155a(String str);

        void mo7156b();

        void mo7157c();

        void mo7158d();

        void mo7159e();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/EditContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "onLeaveSelected", "", "onSubmitSelected", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: EditContract.kt */
    public interface Presenter extends BasePresenter {
        void mo6453a();

        void mo6454b();
    }
}
