package com.reddit.frontpage.presentation.carousel.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.frontpage.domain.model.LinkType;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-Bq\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\t¢\u0006\u0002\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u001a\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0017¨\u0006."}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselItemPresentationModel;", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselItemPresentationModel;", "Lpaperparcel/PaperParcelable;", "id", "", "subredditIconUrl", "subredditName", "subredditMetadata", "isSubredditSubscribed", "", "subredditColor", "title", "bodyText", "metadata", "stableId", "", "linkType", "Lcom/reddit/frontpage/domain/model/LinkType;", "linkPresentationModel", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "showSubredditHeader", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/reddit/frontpage/domain/model/LinkType;Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;Z)V", "getBodyText", "()Ljava/lang/String;", "hasSubreddit", "getHasSubreddit", "()Z", "htmlFormattedSubredditName", "getHtmlFormattedSubredditName", "getId", "setSubredditSubscribed", "(Z)V", "getLinkPresentationModel", "()Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "getLinkType", "()Lcom/reddit/frontpage/domain/model/LinkType;", "getMetadata", "getShowSubredditHeader", "getStableId", "()J", "getSubredditColor", "getSubredditIconUrl", "getSubredditMetadata", "getSubredditName", "getTitle", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: CarouselItemPresentationModel.kt */
public final class LinkCarouselItemPresentationModel extends CarouselItemPresentationModel implements PaperParcelable {
    public static final Creator<LinkCarouselItemPresentationModel> CREATOR = PaperParcelLinkCarouselItemPresentationModel.f20359c;
    public static final Companion f28071n = new Companion();
    public final String f28072a;
    public final String f28073b;
    public final String f28074c;
    public final String f28075d;
    public boolean f28076e;
    public final String f28077f;
    public final String f28078g;
    public final String f28079h;
    public final String f28080i;
    public final long f28081j;
    public final LinkType f28082k;
    public final LinkPresentationModel f28083l;
    public final boolean f28084m;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J.\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselItemPresentationModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselItemPresentationModel;", "kotlin.jvm.PlatformType", "formatMetaData", "", "link", "Lcom/reddit/frontpage/domain/model/Link;", "formatScoreCount", "from", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "showSubredditHeader", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CarouselItemPresentationModel.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public LinkCarouselItemPresentationModel(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, long j, LinkType linkType, LinkPresentationModel linkPresentationModel, boolean z2) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(str3, "subredditName");
        Intrinsics.m26847b(str4, "subredditMetadata");
        Intrinsics.m26847b(str6, "title");
        Intrinsics.m26847b(str7, "bodyText");
        Intrinsics.m26847b(str8, "metadata");
        Intrinsics.m26847b(linkType, "linkType");
        Intrinsics.m26847b(linkPresentationModel, "linkPresentationModel");
        super();
        this.f28072a = str;
        this.f28073b = str2;
        this.f28074c = str3;
        this.f28075d = str4;
        this.f28076e = z;
        this.f28077f = str5;
        this.f28078g = str6;
        this.f28079h = str7;
        this.f28080i = str8;
        this.f28081j = j;
        this.f28082k = linkType;
        this.f28083l = linkPresentationModel;
        this.f28084m = z2;
    }
}
