package com.reddit.datalibrary.frontpage.requests.models.v2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bR\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Identifiable;", "listableType", "", "listableType$annotations", "()V", "getListableType", "()I", "minAndroidVersion", "getMinAndroidVersion", "Companion", "ListableType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Listable.kt */
public interface Listable extends Identifiable {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int LISTABLE_TYPE_APP_INSTALL_AD = 9;
    public static final int LISTABLE_TYPE_CAROUSEL_LARGE_SUBREDDIT_LISTING = 14;
    public static final int LISTABLE_TYPE_CAROUSEL_LINK_LISTING = 15;
    public static final int LISTABLE_TYPE_CAROUSEL_MEDIUM_SUBREDDIT_LISTING = 13;
    public static final int LISTABLE_TYPE_CAROUSEL_SMALL_SUBREDDIT_LISTING = 12;
    public static final int LISTABLE_TYPE_COMMENT = 17;
    public static final int LISTABLE_TYPE_COMMUNITY_ITEM_FAVORITABLE = 20;
    public static final int LISTABLE_TYPE_COMMUNITY_ITEM_NONFAVORITABLE = 21;
    public static final int LISTABLE_TYPE_COMMUNITY_SECTION = 19;
    public static final int LISTABLE_TYPE_CONTENT_AD = 10;
    public static final int LISTABLE_TYPE_FOOTER = 8;
    public static final int LISTABLE_TYPE_GENERIC_BANNER = 4;
    public static final int LISTABLE_TYPE_HEADER = 7;
    public static final int LISTABLE_TYPE_HISTORY_HEADER = 22;
    public static final int LISTABLE_TYPE_KARMA_CAROUSEL = 16;
    public static final int LISTABLE_TYPE_LINK = 1;
    public static final int LISTABLE_TYPE_LINK_PRESENTATION = 11;
    public static final int LISTABLE_TYPE_LIVE_BANNER = 3;
    public static final int LISTABLE_TYPE_ONBOARDING_LINK = 18;
    public static final int LISTABLE_TYPE_SUBMITTED_VIDEO = 6;
    public static final int LISTABLE_TYPE_UNKNOWN = 0;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable$Companion;", "", "()V", "CAROUSEL_TYPES", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getCAROUSEL_TYPES", "()Ljava/util/HashSet;", "LISTABLE_TYPE_APP_INSTALL_AD", "LISTABLE_TYPE_CAROUSEL_LARGE_SUBREDDIT_LISTING", "LISTABLE_TYPE_CAROUSEL_LINK_LISTING", "LISTABLE_TYPE_CAROUSEL_MEDIUM_SUBREDDIT_LISTING", "LISTABLE_TYPE_CAROUSEL_SMALL_SUBREDDIT_LISTING", "LISTABLE_TYPE_COMMENT", "LISTABLE_TYPE_COMMUNITY_ITEM_FAVORITABLE", "LISTABLE_TYPE_COMMUNITY_ITEM_NONFAVORITABLE", "LISTABLE_TYPE_COMMUNITY_SECTION", "LISTABLE_TYPE_CONTENT_AD", "LISTABLE_TYPE_FOOTER", "LISTABLE_TYPE_GENERIC_BANNER", "LISTABLE_TYPE_HEADER", "LISTABLE_TYPE_HISTORY_HEADER", "LISTABLE_TYPE_KARMA_CAROUSEL", "LISTABLE_TYPE_LINK", "LISTABLE_TYPE_LINK_PRESENTATION", "LISTABLE_TYPE_LIVE_BANNER", "LISTABLE_TYPE_ONBOARDING_LINK", "LISTABLE_TYPE_SUBMITTED_VIDEO", "LISTABLE_TYPE_UNKNOWN", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Listable.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final HashSet<Integer> CAROUSEL_TYPES = SetsKt__SetsKt.m26803b(Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(15));
        public static final int LISTABLE_TYPE_APP_INSTALL_AD = 9;
        public static final int LISTABLE_TYPE_CAROUSEL_LARGE_SUBREDDIT_LISTING = 14;
        public static final int LISTABLE_TYPE_CAROUSEL_LINK_LISTING = 15;
        public static final int LISTABLE_TYPE_CAROUSEL_MEDIUM_SUBREDDIT_LISTING = 13;
        public static final int LISTABLE_TYPE_CAROUSEL_SMALL_SUBREDDIT_LISTING = 12;
        public static final int LISTABLE_TYPE_COMMENT = 17;
        public static final int LISTABLE_TYPE_COMMUNITY_ITEM_FAVORITABLE = 20;
        public static final int LISTABLE_TYPE_COMMUNITY_ITEM_NONFAVORITABLE = 21;
        public static final int LISTABLE_TYPE_COMMUNITY_SECTION = 19;
        public static final int LISTABLE_TYPE_CONTENT_AD = 10;
        public static final int LISTABLE_TYPE_FOOTER = 8;
        public static final int LISTABLE_TYPE_GENERIC_BANNER = 4;
        public static final int LISTABLE_TYPE_HEADER = 7;
        public static final int LISTABLE_TYPE_HISTORY_HEADER = 22;
        public static final int LISTABLE_TYPE_KARMA_CAROUSEL = 16;
        public static final int LISTABLE_TYPE_LINK = 1;
        public static final int LISTABLE_TYPE_LINK_PRESENTATION = 11;
        public static final int LISTABLE_TYPE_LIVE_BANNER = 3;
        public static final int LISTABLE_TYPE_ONBOARDING_LINK = 18;
        public static final int LISTABLE_TYPE_SUBMITTED_VIDEO = 6;
        public static final int LISTABLE_TYPE_UNKNOWN = 0;

        private Companion() {
        }

        public static HashSet<Integer> m21639a() {
            return CAROUSEL_TYPES;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: Listable.kt */
    public static final class DefaultImpls {
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable$ListableType;", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Listable.kt */
    public @interface ListableType {
    }

    int getListableType();

    int getMinAndroidVersion();
}
