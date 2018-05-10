package com.reddit.frontpage.presentation.detail;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Comment;
import com.reddit.frontpage.presentation.listing.ui.view.Indicator;
import com.reddit.frontpage.util.Util;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 l2\u00020\u0001:\u0001lBÉ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\b\b\u0003\u0010\u001a\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u000e\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010)J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u000eHÆ\u0003J\t\u0010G\u001a\u00020\u000eHÆ\u0003J\t\u0010H\u001a\u00020\u000eHÆ\u0003J\t\u0010I\u001a\u00020\u000eHÆ\u0003J\t\u0010J\u001a\u00020\u000eHÆ\u0003J\t\u0010K\u001a\u00020\u000eHÆ\u0003J\t\u0010L\u001a\u00020\u000eHÆ\u0003J\t\u0010M\u001a\u00020\u000eHÆ\u0003J\t\u0010N\u001a\u00020\u000eHÆ\u0003J\t\u0010O\u001a\u00020\u000eHÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u000eHÆ\u0003J\t\u0010R\u001a\u00020\u000eHÆ\u0003J\t\u0010S\u001a\u00020\u0007HÆ\u0003J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cHÆ\u0003J\t\u0010U\u001a\u00020\u000eHÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u000eHÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010(HÆ\u0003J\t\u0010`\u001a\u00020\u0007HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0007HÆ\u0003J\t\u0010d\u001a\u00020\u0007HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003JÛ\u0002\u0010f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0003\u0010\u001a\u001a\u00020\u00072\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(HÆ\u0001J\u0013\u0010g\u001a\u00020\u000e2\b\u0010h\u001a\u0004\u0018\u00010iHÖ\u0003J\t\u0010j\u001a\u00020\u0007HÖ\u0001J\t\u0010k\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u001a\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010+R\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010+R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010-R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010+R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010#\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u00107R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010+R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u00107R\u0011\u0010\u0017\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00107R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u00107R\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u00107R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u00107R\u0011\u0010\u0014\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u00107R\u0011\u0010\u0018\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u00107R\u0011\u0010\u0019\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u00107R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u00107R\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u00107R\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u00107R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0011\u0010&\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b?\u0010-R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010+R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010-R\u0011\u0010\u001e\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u00107R\u0011\u0010%\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010+R\u0011\u0010$\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+¨\u0006m"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/CommentPresentationModel;", "Lcom/reddit/frontpage/presentation/detail/PresentationModel;", "id", "", "kindWithId", "parentKindWithId", "depth", "", "bodyHtml", "author", "score", "nextCommentDepth", "linkKindWithId", "isCollapsed", "", "isDeleted", "isArchived", "hasReports", "isSaved", "isReportable", "isEditable", "isDeletable", "isSavable", "isCollapsable", "isGildable", "isReplyable", "authorTextColor", "indicators", "", "Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator;", "showGildDescription", "gildDescription", "dateDescription", "flairDescription", "collapsedDescription", "htmlLinksClickable", "subredditKindWithId", "subredditDisplayName", "linkTitle", "comment", "Lcom/reddit/frontpage/domain/model/Comment;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;ZZZZZZZZZZZZILjava/util/Set;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/reddit/frontpage/domain/model/Comment;)V", "getAuthor", "()Ljava/lang/String;", "getAuthorTextColor", "()I", "getBodyHtml", "getCollapsedDescription", "getComment", "()Lcom/reddit/frontpage/domain/model/Comment;", "getDateDescription", "getDepth", "getFlairDescription", "getGildDescription", "getHasReports", "()Z", "getHtmlLinksClickable", "getId", "getIndicators", "()Ljava/util/Set;", "getKindWithId", "getLinkKindWithId", "getLinkTitle", "getNextCommentDepth", "getParentKindWithId", "getScore", "getShowGildDescription", "getSubredditDisplayName", "getSubredditKindWithId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PresentationModel.kt */
public final class CommentPresentationModel extends PresentationModel {
    private static final String f28136I = Util.m24027f((int) C1761R.string.internal_deleted);
    private static final String f28137J = Util.m24027f((int) C1761R.string.unicode_delimiter);
    private static final String f28138K = Util.m24027f((int) C1761R.string.unicode_delimiter_no_left_space);
    public static final Companion f28139d = new Companion();
    private final String f28140A;
    private final String f28141B;
    private final String f28142C;
    private final boolean f28143D;
    private final String f28144E;
    private final String f28145F;
    private final String f28146G;
    private final Comment f28147H;
    public final String f28148a;
    public final String f28149b;
    public final String f28150c;
    private final String f28151e;
    private final int f28152f;
    private final String f28153g;
    private final String f28154h;
    private final int f28155i;
    private final int f28156j;
    private final boolean f28157k;
    private final boolean f28158l;
    private final boolean f28159m;
    private final boolean f28160n;
    private final boolean f28161o;
    private final boolean f28162p;
    private final boolean f28163q;
    private final boolean f28164r;
    private final boolean f28165s;
    private final boolean f28166t;
    private final boolean f28167u;
    private final boolean f28168v;
    private final int f28169w;
    private final Set<Indicator> f28170x;
    private final boolean f28171y;
    private final String f28172z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/CommentPresentationModel$Companion;", "", "()V", "DELETED", "", "getDELETED", "()Ljava/lang/String;", "DELIMITER", "getDELIMITER", "DELIMITER_NO_LEFT_SPACE", "getDELIMITER_NO_LEFT_SPACE", "DISTINGUISH_ADMIN", "DISTINGUISH_MODERATOR", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: PresentationModel.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CommentPresentationModel(id=");
        stringBuilder.append(this.f28151e);
        stringBuilder.append(", kindWithId=");
        stringBuilder.append(this.f28148a);
        stringBuilder.append(", parentKindWithId=");
        stringBuilder.append(this.f28149b);
        stringBuilder.append(", depth=");
        stringBuilder.append(this.f28152f);
        stringBuilder.append(", bodyHtml=");
        stringBuilder.append(this.f28153g);
        stringBuilder.append(", author=");
        stringBuilder.append(this.f28154h);
        stringBuilder.append(", score=");
        stringBuilder.append(this.f28155i);
        stringBuilder.append(", nextCommentDepth=");
        stringBuilder.append(this.f28156j);
        stringBuilder.append(", linkKindWithId=");
        stringBuilder.append(this.f28150c);
        stringBuilder.append(", isCollapsed=");
        stringBuilder.append(this.f28157k);
        stringBuilder.append(", isDeleted=");
        stringBuilder.append(this.f28158l);
        stringBuilder.append(", isArchived=");
        stringBuilder.append(this.f28159m);
        stringBuilder.append(", hasReports=");
        stringBuilder.append(this.f28160n);
        stringBuilder.append(", isSaved=");
        stringBuilder.append(this.f28161o);
        stringBuilder.append(", isReportable=");
        stringBuilder.append(this.f28162p);
        stringBuilder.append(", isEditable=");
        stringBuilder.append(this.f28163q);
        stringBuilder.append(", isDeletable=");
        stringBuilder.append(this.f28164r);
        stringBuilder.append(", isSavable=");
        stringBuilder.append(this.f28165s);
        stringBuilder.append(", isCollapsable=");
        stringBuilder.append(this.f28166t);
        stringBuilder.append(", isGildable=");
        stringBuilder.append(this.f28167u);
        stringBuilder.append(", isReplyable=");
        stringBuilder.append(this.f28168v);
        stringBuilder.append(", authorTextColor=");
        stringBuilder.append(this.f28169w);
        stringBuilder.append(", indicators=");
        stringBuilder.append(this.f28170x);
        stringBuilder.append(", showGildDescription=");
        stringBuilder.append(this.f28171y);
        stringBuilder.append(", gildDescription=");
        stringBuilder.append(this.f28172z);
        stringBuilder.append(", dateDescription=");
        stringBuilder.append(this.f28140A);
        stringBuilder.append(", flairDescription=");
        stringBuilder.append(this.f28141B);
        stringBuilder.append(", collapsedDescription=");
        stringBuilder.append(this.f28142C);
        stringBuilder.append(", htmlLinksClickable=");
        stringBuilder.append(this.f28143D);
        stringBuilder.append(", subredditKindWithId=");
        stringBuilder.append(this.f28144E);
        stringBuilder.append(", subredditDisplayName=");
        stringBuilder.append(this.f28145F);
        stringBuilder.append(", linkTitle=");
        stringBuilder.append(this.f28146G);
        stringBuilder.append(", comment=");
        stringBuilder.append(this.f28147H);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        String str = this.f28151e;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f28148a;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f28149b;
        hashCode = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f28152f) * 31;
        str2 = this.f28153g;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f28154h;
        hashCode = (((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f28155i) * 31) + this.f28156j) * 31;
        str2 = this.f28150c;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        int i2 = this.f28157k;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f28158l;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f28159m;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f28160n;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f28161o;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f28162p;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f28163q;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f28164r;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f28165s;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f28166t;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f28167u;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f28168v;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (((hashCode + i2) * 31) + this.f28169w) * 31;
        Set set = this.f28170x;
        hashCode = (hashCode + (set != null ? set.hashCode() : 0)) * 31;
        i2 = this.f28171y;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str2 = this.f28172z;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f28140A;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f28141B;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f28142C;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        i2 = this.f28143D;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str2 = this.f28144E;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f28145F;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f28146G;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Comment comment = this.f28147H;
        if (comment != null) {
            i = comment.hashCode();
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CommentPresentationModel) {
                CommentPresentationModel commentPresentationModel = (CommentPresentationModel) obj;
                if (Intrinsics.m26845a(this.f28151e, commentPresentationModel.f28151e) && Intrinsics.m26845a(this.f28148a, commentPresentationModel.f28148a) && Intrinsics.m26845a(this.f28149b, commentPresentationModel.f28149b)) {
                    if ((this.f28152f == commentPresentationModel.f28152f) && Intrinsics.m26845a(this.f28153g, commentPresentationModel.f28153g) && Intrinsics.m26845a(this.f28154h, commentPresentationModel.f28154h)) {
                        if (this.f28155i == commentPresentationModel.f28155i) {
                            if ((this.f28156j == commentPresentationModel.f28156j) && Intrinsics.m26845a(this.f28150c, commentPresentationModel.f28150c)) {
                                if (this.f28157k == commentPresentationModel.f28157k) {
                                    if (this.f28158l == commentPresentationModel.f28158l) {
                                        if (this.f28159m == commentPresentationModel.f28159m) {
                                            if (this.f28160n == commentPresentationModel.f28160n) {
                                                if (this.f28161o == commentPresentationModel.f28161o) {
                                                    if (this.f28162p == commentPresentationModel.f28162p) {
                                                        if (this.f28163q == commentPresentationModel.f28163q) {
                                                            if (this.f28164r == commentPresentationModel.f28164r) {
                                                                if (this.f28165s == commentPresentationModel.f28165s) {
                                                                    if (this.f28166t == commentPresentationModel.f28166t) {
                                                                        if (this.f28167u == commentPresentationModel.f28167u) {
                                                                            if (this.f28168v == commentPresentationModel.f28168v) {
                                                                                if ((this.f28169w == commentPresentationModel.f28169w) && Intrinsics.m26845a(this.f28170x, commentPresentationModel.f28170x)) {
                                                                                    if ((this.f28171y == commentPresentationModel.f28171y) && Intrinsics.m26845a(this.f28172z, commentPresentationModel.f28172z) && Intrinsics.m26845a(this.f28140A, commentPresentationModel.f28140A) && Intrinsics.m26845a(this.f28141B, commentPresentationModel.f28141B) && Intrinsics.m26845a(this.f28142C, commentPresentationModel.f28142C)) {
                                                                                        if ((this.f28143D == commentPresentationModel.f28143D) && Intrinsics.m26845a(this.f28144E, commentPresentationModel.f28144E) && Intrinsics.m26845a(this.f28145F, commentPresentationModel.f28145F) && Intrinsics.m26845a(this.f28146G, commentPresentationModel.f28146G) && Intrinsics.m26845a(this.f28147H, commentPresentationModel.f28147H) != null) {
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }
}
