package com.reddit.frontpage.presentation.carousel.model;

import android.os.Parcel;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcelable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0010\bf\u0018\u0000 +2\u00020\u0001:\u0001+R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0012\u0010\u0016\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\u0012\u0010\u0017\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0005R\u0012\u0010\u0019\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0005R\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0005R\u0018\u0010!\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0012\u0010'\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0005R\u0014\u0010)\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0005¨\u0006,"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "Lpaperparcel/PaperParcelable;", "avatarImageUrl", "", "getAvatarImageUrl", "()Ljava/lang/String;", "bannerImageUrl", "getBannerImageUrl", "color", "", "getColor", "()I", "description", "getDescription", "hasDescription", "", "getHasDescription", "()Z", "hasMetadata", "getHasMetadata", "id", "getId", "isUser", "metadata", "getMetadata", "name", "getName", "stableId", "", "getStableId", "()J", "stats", "getStats", "subscribed", "getSubscribed", "setSubscribed", "(Z)V", "subscribedText", "getSubscribedText", "title", "getTitle", "unsubscribedText", "getUnsubscribedText", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ICarouselItemPresentationModel.kt */
public interface ICarouselItemPresentationModel extends PaperParcelable {
    public static final Companion f28070a = Companion.f20342a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel$Companion;", "", "()V", "SUBREDDIT_SUBSCRIBED_TEXT", "", "getSUBREDDIT_SUBSCRIBED_TEXT", "()Ljava/lang/String;", "SUBREDDIT_UNSUBSCRIBED_TEXT", "getSUBREDDIT_UNSUBSCRIBED_TEXT", "USER_SUBSCRIBED_TEXT", "getUSER_SUBSCRIBED_TEXT", "USER_UNSUBSCRIBED_TEXT", "getUSER_UNSUBSCRIBED_TEXT", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ICarouselItemPresentationModel.kt */
    public static final class Companion {
        static final /* synthetic */ Companion f20342a = new Companion();
        private static final String f20343b;
        private static final String f20344c;
        private static final String f20345d;
        private static final String f20346e;

        static {
            Object f = Util.m24027f((int) C1761R.string.action_subscribed);
            Intrinsics.m26843a(f, "Util.getString(R.string.action_subscribed)");
            f20343b = f;
            f = Util.m24027f((int) C1761R.string.action_subscribe);
            Intrinsics.m26843a(f, "Util.getString(R.string.action_subscribe)");
            f20344c = f;
            f = Util.m24027f((int) C1761R.string.action_following);
            Intrinsics.m26843a(f, "Util.getString(R.string.action_following)");
            f20345d = f;
            f = Util.m24027f((int) C1761R.string.action_follow);
            Intrinsics.m26843a(f, "Util.getString(R.string.action_follow)");
            f20346e = f;
        }

        private Companion() {
        }

        public static String m22683a() {
            return f20343b;
        }

        public static String m22684b() {
            return f20344c;
        }

        public static String m22685c() {
            return f20345d;
        }

        public static String m22686d() {
            return f20346e;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: ICarouselItemPresentationModel.kt */
    public static final class DefaultImpls {
        public static void m22688a(ICarouselItemPresentationModel iCarouselItemPresentationModel, Parcel parcel, int i) {
            Intrinsics.m26847b(parcel, "dest");
            paperparcel.PaperParcelable.DefaultImpls.writeToParcel(iCarouselItemPresentationModel, parcel, i);
        }

        public static String m22687a(ICarouselItemPresentationModel iCarouselItemPresentationModel) {
            if (iCarouselItemPresentationModel.mo6438e() != null) {
                iCarouselItemPresentationModel = ICarouselItemPresentationModel.f28070a;
                return Companion.m22685c();
            }
            iCarouselItemPresentationModel = ICarouselItemPresentationModel.f28070a;
            return Companion.m22683a();
        }

        public static String m22689b(ICarouselItemPresentationModel iCarouselItemPresentationModel) {
            if (iCarouselItemPresentationModel.mo6438e() != null) {
                iCarouselItemPresentationModel = ICarouselItemPresentationModel.f28070a;
                return Companion.m22686d();
            }
            iCarouselItemPresentationModel = ICarouselItemPresentationModel.f28070a;
            return Companion.m22684b();
        }
    }

    String mo6433a();

    void mo6434a(boolean z);

    String mo6435b();

    String mo6436c();

    String mo6437d();

    boolean mo6438e();

    String mo6439f();

    String mo6440g();

    String mo6441h();

    String mo6442i();

    int mo6443j();

    boolean mo6444k();

    boolean mo6445l();

    boolean mo6446m();

    long mo6447n();

    String mo6448o();

    String mo6449p();
}
