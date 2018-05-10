package com.reddit.frontpage.presentation.detail.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.frontpage.domain.model.Comment;
import paperparcel.TypeAdapter;
import paperparcel.internal.ParcelableAdapter;

final class PaperParcelComment {
    static final TypeAdapter<Comment> f20505a = new ParcelableAdapter();
    static final Creator<Comment> f20506b = new C18131();

    static class C18131 implements Creator<Comment> {
        C18131() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Comment[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Comment((Comment) PaperParcelComment.f20505a.a(parcel));
        }
    }

    private PaperParcelComment() {
    }

    static void writeToParcel(Comment comment, Parcel parcel, int i) {
        f20505a.a(comment.f33842a, parcel, i);
    }
}
