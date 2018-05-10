package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;
import paperparcel.TypeAdapter;
import paperparcel.internal.ListAdapter;
import paperparcel.internal.StaticAdapters;
import paperparcel.internal.Utils;

final class PaperParcelComment {
    static final Creator<Comment> CREATOR = new C17871();
    static final TypeAdapter<List<String>> STRING_LIST_ADAPTER = new ListAdapter(StaticAdapters.x);
    static final TypeAdapter<List<List<String>>> STRING_LIST_LIST_ADAPTER = new ListAdapter(Utils.a(STRING_LIST_ADAPTER));

    static class C17871 implements Creator<Comment> {
        C17871() {
        }

        public final Comment createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            return new Comment((String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt(), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (Boolean) Utils.a(parcel2, StaticAdapters.b), parcel.readInt(), parcel.readInt() == 1, (Boolean) Utils.a(parcel2, StaticAdapters.b), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, (Boolean) Utils.a(parcel2, StaticAdapters.b), (Boolean) Utils.a(parcel2, StaticAdapters.b), (Boolean) Utils.a(parcel2, StaticAdapters.b), (String) StaticAdapters.x.a(parcel2), (Integer) Utils.a(parcel2, StaticAdapters.a), (List) PaperParcelComment.STRING_LIST_LIST_ADAPTER.a(parcel2), (List) PaperParcelComment.STRING_LIST_LIST_ADAPTER.a(parcel2), parcel.readInt());
        }

        public final Comment[] newArray(int i) {
            return new Comment[i];
        }
    }

    private PaperParcelComment() {
    }

    static void writeToParcel(Comment comment, Parcel parcel, int i) {
        StaticAdapters.x.a(comment.getId(), parcel, i);
        StaticAdapters.x.a(comment.getKindWithId(), parcel, i);
        StaticAdapters.x.a(comment.getParentKindWithId(), parcel, i);
        StaticAdapters.x.a(comment.getBody(), parcel, i);
        StaticAdapters.x.a(comment.getBodyHtml(), parcel, i);
        parcel.writeInt(comment.getScore());
        StaticAdapters.x.a(comment.getAuthor(), parcel, i);
        StaticAdapters.x.a(comment.getAuthorFlairText(), parcel, i);
        Utils.a(comment.getAuthorCakeDay(), parcel, i, StaticAdapters.b);
        parcel.writeInt(comment.getGilded());
        parcel.writeInt(comment.getArchive());
        Utils.a(comment.getLikes(), parcel, i, StaticAdapters.b);
        StaticAdapters.x.a(comment.getLinkTitle(), parcel, i);
        StaticAdapters.x.a(comment.getDistinguished(), parcel, i);
        parcel.writeInt(comment.getStickied());
        StaticAdapters.x.a(comment.getSubreddit(), parcel, i);
        StaticAdapters.x.a(comment.getSubredditId(), parcel, i);
        StaticAdapters.x.a(comment.getSubredditNamePrefixed(), parcel, i);
        StaticAdapters.x.a(comment.getLinkKindWithId(), parcel, i);
        parcel.writeInt(comment.getScoreHidden());
        StaticAdapters.x.a(comment.getLinkUrl(), parcel, i);
        parcel.writeInt(comment.getSaved());
        Utils.a(comment.getApproved(), parcel, i, StaticAdapters.b);
        Utils.a(comment.getSpam(), parcel, i, StaticAdapters.b);
        Utils.a(comment.getRemoved(), parcel, i, StaticAdapters.b);
        StaticAdapters.x.a(comment.getApprovedBy(), parcel, i);
        Utils.a(comment.getNumReports(), parcel, i, StaticAdapters.a);
        STRING_LIST_LIST_ADAPTER.a(comment.getModReports(), parcel, i);
        STRING_LIST_LIST_ADAPTER.a(comment.getUserReports(), parcel, i);
        parcel.writeInt(comment.getDepth());
    }
}
