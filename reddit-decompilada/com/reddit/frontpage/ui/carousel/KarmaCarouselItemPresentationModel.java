package com.reddit.frontpage.ui.carousel;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.common.ThingUtil;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Karma;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel.DefaultImpls;
import com.reddit.frontpage.util.CountUtil;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 52\u00020\u0001:\u00015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u001d\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0005HÖ\u0001J\t\u00104\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\nR\u0014\u0010\u0019\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\nR\u0014\u0010\u001e\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\nR\u0014\u0010 \u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\nR$\u0010'\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00128V@VX\u000e¢\u0006\f\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\n¨\u00066"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/KarmaCarouselItemPresentationModel;", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "item", "Lcom/reddit/frontpage/domain/model/Karma;", "color", "", "(Lcom/reddit/frontpage/domain/model/Karma;I)V", "avatarImageUrl", "", "getAvatarImageUrl", "()Ljava/lang/String;", "bannerImageUrl", "getBannerImageUrl", "getColor", "()I", "description", "getDescription", "hasDescription", "", "getHasDescription", "()Z", "hasMetadata", "getHasMetadata", "id", "getId", "isUser", "getItem", "()Lcom/reddit/frontpage/domain/model/Karma;", "metadata", "getMetadata", "name", "getName", "stableId", "", "getStableId", "()J", "stats", "getStats", "value", "subscribed", "getSubscribed", "setSubscribed", "(Z)V", "title", "getTitle", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: KarmaCarouselItemPresentationModel.kt */
public final class KarmaCarouselItemPresentationModel implements ICarouselItemPresentationModel {
    public static final Creator<KarmaCarouselItemPresentationModel> CREATOR = PaperParcelKarmaCarouselItemPresentationModel.f21133b;
    public static final Companion f34222d = new Companion();
    final Karma f34223b;
    final int f34224c;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/KarmaCarouselItemPresentationModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/ui/carousel/KarmaCarouselItemPresentationModel;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: KarmaCarouselItemPresentationModel.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final void mo6434a(boolean z) {
    }

    public final int describeContents() {
        return 0;
    }

    public final String mo6440g() {
        return "";
    }

    public final String mo6441h() {
        return "";
    }

    public final boolean mo6445l() {
        return false;
    }

    public final boolean mo6446m() {
        return true;
    }

    public KarmaCarouselItemPresentationModel(Karma karma, int i) {
        Intrinsics.m26847b(karma, "item");
        this.f34223b = karma;
        this.f34224c = i;
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

    public final int mo6443j() {
        return this.f34224c;
    }

    public final String mo6433a() {
        return this.f34223b.getKindWithId();
    }

    public final String mo6435b() {
        return this.f34223b.getSubreddit();
    }

    public final String mo6436c() {
        return this.f34223b.getBannerUrl();
    }

    public final String mo6437d() {
        return this.f34223b.getIconUrl();
    }

    public final boolean mo6438e() {
        return SubredditUtil.m23920a((CharSequence) this.f34223b.getSubredditPrefixed());
    }

    public final String mo6439f() {
        Object e = SubredditUtil.m23934e(this.f34223b.getSubredditPrefixed());
        Intrinsics.m26843a(e, "SubredditUtil.formatWith…l(item.subredditPrefixed)");
        return e;
    }

    public final String mo6442i() {
        Object a = Util.m23960a((int) C1761R.string.fmt_num_subscribers_simple, CountUtil.m23674a((long) this.f34223b.getSubscriberCount()));
        Intrinsics.m26843a(a, "Util.getString(\n        …iberCount.toLong())\n    )");
        return a;
    }

    public final boolean mo6444k() {
        return this.f34223b.getUserIsSubscriber();
    }

    public final long mo6447n() {
        return Util.m24024f(ThingUtil.b(this.f34223b.getKindWithId()));
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("KarmaCarouselItemPresentationModel(item=");
        stringBuilder.append(this.f34223b);
        stringBuilder.append(", color=");
        stringBuilder.append(this.f34224c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        Karma karma = this.f34223b;
        return ((karma != null ? karma.hashCode() : 0) * 31) + this.f34224c;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof KarmaCarouselItemPresentationModel) {
                KarmaCarouselItemPresentationModel karmaCarouselItemPresentationModel = (KarmaCarouselItemPresentationModel) obj;
                if (Intrinsics.m26845a(this.f34223b, karmaCarouselItemPresentationModel.f34223b)) {
                    if ((this.f34224c == karmaCarouselItemPresentationModel.f34224c ? 1 : null) != null) {
                    }
                }
            }
            return false;
        }
        return true;
    }
}
