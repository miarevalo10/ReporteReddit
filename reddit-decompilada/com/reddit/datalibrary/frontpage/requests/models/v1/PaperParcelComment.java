package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.requests.models.v2.FlairRichTextItem;
import java.util.List;
import paperparcel.TypeAdapter;
import paperparcel.internal.ArrayAdapter;
import paperparcel.internal.ListAdapter;
import paperparcel.internal.SerializableAdapter;
import paperparcel.internal.StaticAdapters;
import paperparcel.internal.Utils;

final class PaperParcelComment {
    static final TypeAdapter<CommentListing> COMMENT_LISTING_SERIALIZABLE_ADAPTER = new SerializableAdapter();
    static final Creator<Comment> CREATOR = new C09591();
    static final TypeAdapter<List<FlairRichTextItem>> FLAIR_RICH_TEXT_ITEM_LIST_ADAPTER = new ListAdapter(Utils.a(FLAIR_RICH_TEXT_ITEM_SERIALIZABLE_ADAPTER));
    static final TypeAdapter<FlairRichTextItem> FLAIR_RICH_TEXT_ITEM_SERIALIZABLE_ADAPTER = new SerializableAdapter();
    static final TypeAdapter<String[]> STRING_ARRAY_ADAPTER = new ArrayAdapter(String.class, StaticAdapters.x);
    static final TypeAdapter<String[][]> STRING_ARRAY_ARRAY_ADAPTER = new ArrayAdapter(String[].class, Utils.a(STRING_ARRAY_ADAPTER));

    static class C09591 implements Creator<Comment> {
        C09591() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Comment[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            String str = (String) StaticAdapters.x.a(parcel2);
            String str2 = (String) StaticAdapters.x.a(parcel2);
            String str3 = (String) StaticAdapters.x.a(parcel2);
            int readInt = parcel.readInt();
            String str4 = (String) StaticAdapters.x.a(parcel2);
            String str5 = (String) StaticAdapters.x.a(parcel2);
            boolean z = parcel.readInt() == 1;
            int readInt2 = parcel.readInt();
            boolean z2 = parcel.readInt() == 1;
            CommentListing commentListing = (CommentListing) Utils.a(parcel2, PaperParcelComment.COMMENT_LISTING_SERIALIZABLE_ADAPTER);
            Boolean bool = (Boolean) Utils.a(parcel2, StaticAdapters.b);
            String str6 = (String) StaticAdapters.x.a(parcel2);
            String str7 = (String) StaticAdapters.x.a(parcel2);
            String str8 = (String) StaticAdapters.x.a(parcel2);
            String str9 = (String) StaticAdapters.x.a(parcel2);
            String str10 = (String) StaticAdapters.x.a(parcel2);
            String str11 = (String) StaticAdapters.x.a(parcel2);
            boolean z3 = parcel.readInt() == 1;
            String str12 = (String) StaticAdapters.x.a(parcel2);
            boolean z4 = parcel.readInt() == 1;
            boolean z5 = true;
            boolean z6 = parcel.readInt() == 1;
            boolean z7 = parcel.readInt() == 1;
            boolean z8 = parcel.readInt() == 1;
            if (parcel.readInt() != 1) {
                z5 = false;
            }
            String str13 = (String) StaticAdapters.x.a(parcel2);
            int readInt3 = parcel.readInt();
            String[][] strArr = (String[][]) Utils.a(parcel2, PaperParcelComment.STRING_ARRAY_ARRAY_ADAPTER);
            String[][] strArr2 = (String[][]) Utils.a(parcel2, PaperParcelComment.STRING_ARRAY_ARRAY_ADAPTER);
            List list = (List) Utils.a(parcel2, PaperParcelComment.FLAIR_RICH_TEXT_ITEM_LIST_ADAPTER);
            String str14 = (String) StaticAdapters.x.a(parcel2);
            String str15 = (String) StaticAdapters.x.a(parcel2);
            boolean z9 = z5;
            long readLong = parcel.readLong();
            BaseThing comment = new Comment();
            comment.parent_id = str;
            comment.body = str2;
            comment.body_html = str3;
            comment.score = readInt;
            comment.author = str4;
            comment.author_flair_text = str5;
            comment.author_cakeday = z;
            comment.gilded = readInt2;
            comment.archived = z2;
            comment.replies = commentListing;
            comment.likes = bool;
            comment.link_title = str6;
            comment.distinguished = str7;
            comment.stickied = z3;
            comment.subreddit = str8;
            comment.subreddit_id = str9;
            comment.subreddit_name_prefixed = str10;
            comment.link_id = str11;
            comment.score_hidden = z4;
            comment.link_url = str12;
            comment.saved = z6;
            comment.approved = z7;
            comment.spam = z8;
            comment.removed = z9;
            comment.approved_by = str13;
            comment.num_reports = readInt3;
            comment.user_reports = strArr;
            comment.mod_reports = strArr2;
            comment.author_flair_richtext = list;
            comment.m16419a(str14);
            comment.m16420b(str15);
            comment.createdUtc = readLong;
            return comment;
        }
    }

    private PaperParcelComment() {
    }

    static void writeToParcel(Comment comment, Parcel parcel, int i) {
        StaticAdapters.x.a(comment.parent_id, parcel, i);
        StaticAdapters.x.a(comment.body, parcel, i);
        StaticAdapters.x.a(comment.body_html, parcel, i);
        parcel.writeInt(comment.score);
        StaticAdapters.x.a(comment.author, parcel, i);
        StaticAdapters.x.a(comment.author_flair_text, parcel, i);
        parcel.writeInt(comment.author_cakeday);
        parcel.writeInt(comment.gilded);
        parcel.writeInt(comment.archived);
        Utils.a(comment.replies, parcel, i, COMMENT_LISTING_SERIALIZABLE_ADAPTER);
        Utils.a(comment.likes, parcel, i, StaticAdapters.b);
        StaticAdapters.x.a(comment.link_title, parcel, i);
        StaticAdapters.x.a(comment.distinguished, parcel, i);
        parcel.writeInt(comment.stickied);
        StaticAdapters.x.a(comment.subreddit, parcel, i);
        StaticAdapters.x.a(comment.subreddit_id, parcel, i);
        StaticAdapters.x.a(comment.subreddit_name_prefixed, parcel, i);
        StaticAdapters.x.a(comment.link_id, parcel, i);
        parcel.writeInt(comment.score_hidden);
        StaticAdapters.x.a(comment.link_url, parcel, i);
        parcel.writeInt(comment.saved);
        parcel.writeInt(comment.approved);
        parcel.writeInt(comment.spam);
        parcel.writeInt(comment.removed);
        StaticAdapters.x.a(comment.approved_by, parcel, i);
        parcel.writeInt(comment.num_reports);
        Utils.a(comment.user_reports, parcel, i, STRING_ARRAY_ARRAY_ADAPTER);
        Utils.a(comment.mod_reports, parcel, i, STRING_ARRAY_ARRAY_ADAPTER);
        Utils.a(comment.author_flair_richtext, parcel, i, FLAIR_RICH_TEXT_ITEM_LIST_ADAPTER);
        StaticAdapters.x.a(comment.getId(), parcel, i);
        StaticAdapters.x.a(comment.getName(), parcel, i);
        parcel.writeLong(comment.getCreatedUtc());
    }
}
