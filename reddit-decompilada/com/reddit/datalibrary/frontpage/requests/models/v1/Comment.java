package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.requests.models.Gildable;
import com.reddit.datalibrary.frontpage.requests.models.Replyable;
import com.reddit.datalibrary.frontpage.requests.models.Reportable;
import com.reddit.datalibrary.frontpage.requests.models.Votable;
import com.reddit.datalibrary.frontpage.requests.models.v2.FlairRichTextItem;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.CommentUtil;
import com.reddit.frontpage.util.GoldUtil;
import com.reddit.frontpage.util.RichTextUtil;
import com.reddit.frontpage.util.Util;
import java.util.List;
import paperparcel.PaperParcel;

@PaperParcel
public class Comment extends BaseThing implements Parcelable, Gildable, Replyable, Reportable, Votable, Listable {
    public static final Creator<Comment> CREATOR = PaperParcelComment.CREATOR;
    public boolean approved;
    public String approved_by;
    public boolean archived;
    String author;
    public boolean author_cakeday;
    List<FlairRichTextItem> author_flair_richtext;
    public String author_flair_text;
    public String body;
    String body_html;
    public String distinguished;
    int gilded;
    Boolean likes;
    public String link_id;
    public String link_title;
    public String link_url;
    String[][] mod_reports;
    public int num_reports;
    public String parent_id;
    public boolean removed;
    public CommentListing replies;
    public boolean saved;
    int score;
    boolean score_hidden;
    public boolean spam;
    public boolean stickied;
    public String subreddit;
    public String subreddit_id;
    public String subreddit_name_prefixed;
    String[][] user_reports;

    public int describeContents() {
        return 0;
    }

    public String getDomain() {
        return null;
    }

    public String getInstanceId() {
        return "";
    }

    public int getListableType() {
        return 17;
    }

    public int getMinAndroidVersion() {
        return 0;
    }

    public String getVotableType() {
        return "comment";
    }

    public Comment() {
        super((byte) 0);
    }

    public final String m19789a() {
        return this.parent_id;
    }

    public final String m19790b() {
        if (CommentUtil.a(getId()).booleanValue()) {
            return Util.f(C1761R.string.deleted_body_content_html);
        }
        return this.body_html;
    }

    public int getVoteDirection() {
        if (this.likes == null) {
            return 0;
        }
        return this.likes.booleanValue() ? 1 : -1;
    }

    public int getScore() {
        return this.score;
    }

    public boolean isScoreHidden() {
        return this.score_hidden;
    }

    public final String m19791c() {
        return !CommentUtil.a(getId()).booleanValue() ? this.author : Util.f(C1761R.string.deleted_author);
    }

    public final String m19792d() {
        if (this.author_flair_richtext != null) {
            return RichTextUtil.a(this.author_flair_richtext);
        }
        return this.author_flair_text;
    }

    public final boolean m19793e() {
        return this.author_cakeday;
    }

    public int getGilded() {
        return GoldUtil.a(getName(), this.gilded);
    }

    public void setReplies(Listing<ReplyableWrapper> listing) {
        this.replies = (CommentListing) listing;
    }

    public final String m19794f() {
        return this.link_title;
    }

    public final String m19795g() {
        return this.distinguished;
    }

    public final String m19796h() {
        return this.subreddit;
    }

    public final String m19797i() {
        return this.subreddit_id;
    }

    public final String m19798j() {
        return this.link_id;
    }

    public final boolean m19799k() {
        return this.stickied;
    }

    public String[][] getUserReports() {
        return this.user_reports;
    }

    public String[][] getModReports() {
        return this.mod_reports;
    }

    private int m19788n() {
        if (!TextUtils.isEmpty(this.distinguished)) {
            String str = this.distinguished;
            int i = -1;
            int hashCode = str.hashCode();
            if (hashCode != -2004703995) {
                if (hashCode == 92668751) {
                    if (str.equals("admin")) {
                        i = 0;
                    }
                }
            } else if (str.equals("moderator")) {
                i = 1;
            }
            switch (i) {
                case 0:
                    return 1;
                case 1:
                    return 2;
                default:
                    break;
            }
        }
        return 0;
    }

    public final boolean m19800l() {
        return m19788n() != 0;
    }

    public final boolean m19801m() {
        return m19788n() == 1;
    }

    public long getUniqueID() {
        return Util.f(getId());
    }

    public void writeToParcel(Parcel parcel, int i) {
        PaperParcelComment.writeToParcel(this, parcel, i);
    }

    public /* bridge */ /* synthetic */ Listing getReplies() {
        return this.replies;
    }
}
