package com.reddit.datalibrary.frontpage.requests.models;

import com.reddit.datalibrary.frontpage.requests.models.v1.AdEvent;
import com.reddit.datalibrary.frontpage.requests.models.v1.AdEventKt;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\bf\u0018\u0000 \u00162\u00020\u0001:\u0003\u0015\u0016\u0017R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005R\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005R\u0014\u0010\u0013\u001a\u00020\u000e8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/Votable;", "", "domain", "", "getDomain", "()Ljava/lang/String;", "instanceId", "getInstanceId", "isScoreHidden", "", "()Z", "name", "getName", "score", "", "getScore", "()I", "votableType", "getVotableType", "voteDirection", "getVoteDirection", "AdAnalyticsInfo", "Companion", "VoteDirection", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Votable.kt */
public interface Votable {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int VOTE_DIRECTION_DOWN = -1;
    public static final int VOTE_DIRECTION_NONE = 0;
    public static final int VOTE_DIRECTION_UP = 1;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/Votable$AdAnalyticsInfo;", "", "linkId", "", "adEvents", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/AdEvent;", "isComment", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "getAdEvents", "()Ljava/util/List;", "()Z", "getLinkId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Votable.kt */
    public static final class AdAnalyticsInfo {
        public static final Companion Companion = new Companion();
        public final List<AdEvent> adEvents;
        public final boolean isComment;
        public final String linkId;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/Votable$AdAnalyticsInfo$Companion;", "", "()V", "fromLink", "Lcom/reddit/datalibrary/frontpage/requests/models/Votable$AdAnalyticsInfo;", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "isComment", "", "fromLinkPresentationModel", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: Votable.kt */
        public static final class Companion {
            private Companion() {
            }

            public static AdAnalyticsInfo m9347a(Link link, boolean z) {
                return (link == null || !link.isPromoted()) ? null : new AdAnalyticsInfo(link.getId(), link.getAdEvents(), z);
            }

            public static AdAnalyticsInfo m9348a(LinkPresentationModel linkPresentationModel) {
                Intrinsics.b(linkPresentationModel, "link");
                return linkPresentationModel.O ? new AdAnalyticsInfo(linkPresentationModel.d, AdEventKt.m9383a(linkPresentationModel.N), false) : null;
            }
        }

        public static final AdAnalyticsInfo m9349a(Link link) {
            return Companion.m9347a(link, true);
        }

        public static final AdAnalyticsInfo m9350b(Link link) {
            return Companion.m9347a(link, false);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AdAnalyticsInfo) {
                AdAnalyticsInfo adAnalyticsInfo = (AdAnalyticsInfo) obj;
                if (Intrinsics.a(this.linkId, adAnalyticsInfo.linkId) && Intrinsics.a(this.adEvents, adAnalyticsInfo.adEvents)) {
                    if (this.isComment == adAnalyticsInfo.isComment) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.linkId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List list = this.adEvents;
            if (list != null) {
                i = list.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            i = this.isComment;
            if (i != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("AdAnalyticsInfo(linkId=");
            stringBuilder.append(this.linkId);
            stringBuilder.append(", adEvents=");
            stringBuilder.append(this.adEvents);
            stringBuilder.append(", isComment=");
            stringBuilder.append(this.isComment);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public AdAnalyticsInfo(String str, List<AdEvent> list, boolean z) {
            Intrinsics.b(str, "linkId");
            this.linkId = str;
            this.adEvents = list;
            this.isComment = z;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/Votable$Companion;", "", "()V", "VOTE_DIRECTION_DOWN", "", "VOTE_DIRECTION_NONE", "VOTE_DIRECTION_UP", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Votable.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int VOTE_DIRECTION_DOWN = -1;
        public static final int VOTE_DIRECTION_NONE = 0;
        public static final int VOTE_DIRECTION_UP = 1;

        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/Votable$VoteDirection;", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Votable.kt */
    public @interface VoteDirection {
    }

    String getDomain();

    String getInstanceId();

    String getName();

    int getScore();

    String getVotableType();

    int getVoteDirection();

    boolean isScoreHidden();
}
