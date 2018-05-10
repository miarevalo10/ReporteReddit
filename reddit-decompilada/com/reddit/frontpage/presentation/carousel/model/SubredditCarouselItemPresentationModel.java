package com.reddit.frontpage.presentation.carousel.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel.DefaultImpls;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\t\u0010-\u001a\u00020\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003JE\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0013\u00104\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\bHÖ\u0001J\t\u00108\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0014\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\f\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010R\u0014\u0010\u001c\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0010R\u0014\u0010\u001f\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0010R\u0014\u0010!\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0010¨\u0006:"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/model/SubredditCarouselItemPresentationModel;", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselItemPresentationModel;", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "stats", "", "color", "", "subscribed", "", "hasDescription", "hasMetadata", "(Lcom/reddit/frontpage/domain/model/Subreddit;Ljava/lang/String;IZZZ)V", "avatarImageUrl", "getAvatarImageUrl", "()Ljava/lang/String;", "bannerImageUrl", "getBannerImageUrl", "getColor", "()I", "description", "getDescription", "getHasDescription", "()Z", "getHasMetadata", "id", "getId", "isUser", "metadata", "getMetadata", "name", "getName", "stableId", "", "getStableId", "()J", "getStats", "getSubreddit", "()Lcom/reddit/frontpage/domain/model/Subreddit;", "getSubscribed", "setSubscribed", "(Z)V", "title", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: CarouselItemPresentationModel.kt */
public final class SubredditCarouselItemPresentationModel extends CarouselItemPresentationModel implements ICarouselItemPresentationModel {
    public static final Creator<SubredditCarouselItemPresentationModel> CREATOR = PaperParcelSubredditCarouselItemPresentationModel.f20361b;
    public static final Companion f33783h = new Companion();
    public final Subreddit f33784b;
    final String f33785c;
    final int f33786d;
    public boolean f33787e;
    final boolean f33788f;
    final boolean f33789g;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/model/SubredditCarouselItemPresentationModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/presentation/carousel/model/SubredditCarouselItemPresentationModel;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CarouselItemPresentationModel.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final String mo6442i() {
        return "";
    }

    public final String mo6448o() {
        return DefaultImpls.m22687a(this);
    }

    public final String mo6449p() {
        return DefaultImpls.m22689b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.m22688a(this, parcel, i);
    }

    public final String mo6440g() {
        return this.f33785c;
    }

    public final int mo6443j() {
        return this.f33786d;
    }

    public final void mo6434a(boolean z) {
        this.f33787e = z;
    }

    public final boolean mo6444k() {
        return this.f33787e;
    }

    public final boolean mo6445l() {
        return this.f33788f;
    }

    public final boolean mo6446m() {
        return this.f33789g;
    }

    public SubredditCarouselItemPresentationModel(Subreddit subreddit, String str, int i, boolean z, boolean z2, boolean z3) {
        Intrinsics.m26847b(subreddit, "subreddit");
        Intrinsics.m26847b(str, "stats");
        super();
        this.f33784b = subreddit;
        this.f33785c = str;
        this.f33786d = i;
        this.f33787e = z;
        this.f33788f = z2;
        this.f33789g = z3;
    }

    public final String mo6433a() {
        return this.f33784b.getKindWithId();
    }

    public final String mo6435b() {
        return this.f33784b.getDisplayNamePrefixed();
    }

    public final String mo6436c() {
        return this.f33784b.getBannerImg();
    }

    public final String mo6437d() {
        return this.f33784b.getIconImg();
    }

    public final boolean mo6438e() {
        return this.f33784b.isUser();
    }

    public final String mo6439f() {
        Object e = SubredditUtil.m23934e(this.f33784b.getDisplayNamePrefixed());
        Intrinsics.m26843a(e, "SubredditUtil.formatWith…ddit.displayNamePrefixed)");
        return e;
    }

    public final String mo6441h() {
        return this.f33784b.getPublicDescription();
    }

    public final long mo6447n() {
        return Util.m24024f(this.f33784b.getId());
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SubredditCarouselItemPresentationModel(subreddit=");
        stringBuilder.append(this.f33784b);
        stringBuilder.append(", stats=");
        stringBuilder.append(this.f33785c);
        stringBuilder.append(", color=");
        stringBuilder.append(this.f33786d);
        stringBuilder.append(", subscribed=");
        stringBuilder.append(this.f33787e);
        stringBuilder.append(", hasDescription=");
        stringBuilder.append(this.f33788f);
        stringBuilder.append(", hasMetadata=");
        stringBuilder.append(this.f33789g);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        Subreddit subreddit = this.f33784b;
        int i = 0;
        int hashCode = (subreddit != null ? subreddit.hashCode() : 0) * 31;
        String str = this.f33785c;
        if (str != null) {
            i = str.hashCode();
        }
        hashCode = (((hashCode + i) * 31) + this.f33786d) * 31;
        i = this.f33787e;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.f33788f;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.f33789g;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SubredditCarouselItemPresentationModel) {
                SubredditCarouselItemPresentationModel subredditCarouselItemPresentationModel = (SubredditCarouselItemPresentationModel) obj;
                if (Intrinsics.m26845a(this.f33784b, subredditCarouselItemPresentationModel.f33784b) && Intrinsics.m26845a(this.f33785c, subredditCarouselItemPresentationModel.f33785c)) {
                    if (this.f33786d == subredditCarouselItemPresentationModel.f33786d) {
                        if (this.f33787e == subredditCarouselItemPresentationModel.f33787e) {
                            if (this.f33788f == subredditCarouselItemPresentationModel.f33788f) {
                                if ((this.f33789g == subredditCarouselItemPresentationModel.f33789g ? 1 : null) != null) {
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
