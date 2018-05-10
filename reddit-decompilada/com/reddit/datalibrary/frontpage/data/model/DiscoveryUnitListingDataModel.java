package com.reddit.datalibrary.frontpage.data.model;

import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.Subreddit;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB3\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u001b\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/DiscoveryUnitListingDataModel;", "", "links", "", "Lkotlin/Pair;", "Lcom/reddit/frontpage/domain/model/Link;", "Lcom/reddit/datalibrary/frontpage/data/model/DiscoveryUnitListingDataModel$LinkCause;", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "(Ljava/util/List;Lcom/reddit/frontpage/domain/model/Subreddit;Lcom/reddit/datalibrary/frontpage/data/model/Account;)V", "getAccount", "()Lcom/reddit/datalibrary/frontpage/data/model/Account;", "getLinks", "()Ljava/util/List;", "getSubreddit", "()Lcom/reddit/frontpage/domain/model/Subreddit;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "LinkCause", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DiscoveryUnitListingDataModel.kt */
public final class DiscoveryUnitListingDataModel {
    private final Account account;
    private final List<Pair<Link, LinkCause>> links;
    private final Subreddit subreddit;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/DiscoveryUnitListingDataModel$LinkCause;", "", "cause", "", "(Ljava/lang/String;)V", "getCause", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DiscoveryUnitListingDataModel.kt */
    public static final class LinkCause {
        public static final Companion Companion = new Companion();
        private final String cause;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/DiscoveryUnitListingDataModel$LinkCause$Companion;", "", "()V", "none", "Lcom/reddit/datalibrary/frontpage/data/model/DiscoveryUnitListingDataModel$LinkCause;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: DiscoveryUnitListingDataModel.kt */
        public static final class Companion {
            private Companion() {
            }

            public final LinkCause none() {
                return new LinkCause(null, 1, null);
            }
        }

        public LinkCause() {
            this(null, 1, null);
        }

        public static /* synthetic */ LinkCause copy$default(LinkCause linkCause, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = linkCause.cause;
            }
            return linkCause.copy(str);
        }

        public final String component1() {
            return this.cause;
        }

        public final LinkCause copy(String str) {
            return new LinkCause(str);
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof LinkCause) {
                    if (Intrinsics.a(this.cause, ((LinkCause) obj).cause)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.cause;
            return str != null ? str.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("LinkCause(cause=");
            stringBuilder.append(this.cause);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public LinkCause(String str) {
            this.cause = str;
        }

        public /* synthetic */ LinkCause(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                str = null;
            }
            this(str);
        }

        public final String getCause() {
            return this.cause;
        }
    }

    public static /* synthetic */ DiscoveryUnitListingDataModel copy$default(DiscoveryUnitListingDataModel discoveryUnitListingDataModel, List list, Subreddit subreddit, Account account, int i, Object obj) {
        if ((i & 1) != 0) {
            list = discoveryUnitListingDataModel.links;
        }
        if ((i & 2) != 0) {
            subreddit = discoveryUnitListingDataModel.subreddit;
        }
        if ((i & 4) != 0) {
            account = discoveryUnitListingDataModel.account;
        }
        return discoveryUnitListingDataModel.copy(list, subreddit, account);
    }

    public final List<Pair<Link, LinkCause>> component1() {
        return this.links;
    }

    public final Subreddit component2() {
        return this.subreddit;
    }

    public final Account component3() {
        return this.account;
    }

    public final DiscoveryUnitListingDataModel copy(List<Pair<Link, LinkCause>> list, Subreddit subreddit, Account account) {
        Intrinsics.b(list, "links");
        return new DiscoveryUnitListingDataModel(list, subreddit, account);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DiscoveryUnitListingDataModel) {
                DiscoveryUnitListingDataModel discoveryUnitListingDataModel = (DiscoveryUnitListingDataModel) obj;
                if (Intrinsics.a(this.links, discoveryUnitListingDataModel.links) && Intrinsics.a(this.subreddit, discoveryUnitListingDataModel.subreddit) && Intrinsics.a(this.account, discoveryUnitListingDataModel.account)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List list = this.links;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Subreddit subreddit = this.subreddit;
        hashCode = (hashCode + (subreddit != null ? subreddit.hashCode() : 0)) * 31;
        Account account = this.account;
        if (account != null) {
            i = account.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DiscoveryUnitListingDataModel(links=");
        stringBuilder.append(this.links);
        stringBuilder.append(", subreddit=");
        stringBuilder.append(this.subreddit);
        stringBuilder.append(", account=");
        stringBuilder.append(this.account);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public DiscoveryUnitListingDataModel(List<Pair<Link, LinkCause>> list, Subreddit subreddit, Account account) {
        Intrinsics.b(list, "links");
        this.links = list;
        this.subreddit = subreddit;
        this.account = account;
    }

    public final List<Pair<Link, LinkCause>> getLinks() {
        return this.links;
    }

    public final Subreddit getSubreddit() {
        return this.subreddit;
    }

    public final Account getAccount() {
        return this.account;
    }
}
