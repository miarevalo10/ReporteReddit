package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.User;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.frontpage.domain.model.Subreddit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\u000fJ\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\r\u0010%\u001a\u00020\u0017H\u0000¢\u0006\u0002\b&J\u0015\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\b*R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/RedditAdLoader;", "", "context", "Landroid/content/Context;", "settings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "adContext", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;", "onSuccess", "Lkotlin/Function1;", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "", "onError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Landroid/content/Context;Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "adLoader", "Lcom/google/android/gms/ads/AdLoader;", "getAdLoader", "()Lcom/google/android/gms/ads/AdLoader;", "adLoader$delegate", "Lkotlin/Lazy;", "nsfw", "", "requestBuilder", "Lcom/google/android/gms/ads/doubleclick/PublisherAdRequest$Builder;", "getRequestBuilder", "()Lcom/google/android/gms/ads/doubleclick/PublisherAdRequest$Builder;", "requestBuilder$delegate", "session", "Lcom/reddit/datalibrary/frontpage/redditauth/account/Session;", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "whitelistStatus", "", "createAdLoader", "createRequestBuilder", "isLoading", "isLoading$app_standardRelease", "loadAd", "placement", "", "loadAd$app_standardRelease", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdMobAdsLoader.kt */
public final class RedditAdLoader {
    static final /* synthetic */ KProperty[] f10346a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(RedditAdLoader.class), "requestBuilder", "getRequestBuilder()Lcom/google/android/gms/ads/doubleclick/PublisherAdRequest$Builder;")), Reflection.a(new PropertyReference1Impl(Reflection.a(RedditAdLoader.class), "adLoader", "getAdLoader()Lcom/google/android/gms/ads/AdLoader;"))};
    @Deprecated
    public static final Companion f10347c = new Companion();
    private static final String f10348n = "all_ads";
    final Lazy f10349b;
    private final Subreddit f10350d = this.f10357k.f10325d;
    private final boolean f10351e;
    private final String f10352f;
    private final Session f10353g;
    private final Lazy f10354h;
    private final Context f10355i;
    private final FrontpageSettings f10356j;
    private final AdContext f10357k;
    private final Function1<NativeAdInfo<?>, Unit> f10358l;
    private final Function1<Exception, Unit> f10359m;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/RedditAdLoader$Companion;", "", "()V", "DEFAULT_WHITELIST_STATUS", "", "getDEFAULT_WHITELIST_STATUS", "()Ljava/lang/String;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AdMobAdsLoader.kt */
    private static final class Companion {
        private Companion() {
        }
    }

    final AdLoader m8816a() {
        return (AdLoader) this.f10354h.b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RedditAdLoader(android.content.Context r2, com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings r3, com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdContext r4, kotlin.jvm.functions.Function1<? super com.reddit.datalibrary.frontpage.data.feature.ads.repo.NativeAdInfo<?>, kotlin.Unit> r5, kotlin.jvm.functions.Function1<? super java.lang.Exception, kotlin.Unit> r6) {
        /*
        r1 = this;
        r0 = "context";
        kotlin.jvm.internal.Intrinsics.b(r2, r0);
        r0 = "settings";
        kotlin.jvm.internal.Intrinsics.b(r3, r0);
        r0 = "adContext";
        kotlin.jvm.internal.Intrinsics.b(r4, r0);
        r0 = "onSuccess";
        kotlin.jvm.internal.Intrinsics.b(r5, r0);
        r0 = "onError";
        kotlin.jvm.internal.Intrinsics.b(r6, r0);
        r1.<init>();
        r1.f10355i = r2;
        r1.f10356j = r3;
        r1.f10357k = r4;
        r1.f10358l = r5;
        r1.f10359m = r6;
        r2 = r1.f10357k;
        r2 = r2.f10325d;
        r1.f10350d = r2;
        r2 = r1.f10350d;
        if (r2 == 0) goto L_0x0035;
    L_0x0030:
        r2 = r2.getOver18();
        goto L_0x0036;
    L_0x0035:
        r2 = 0;
    L_0x0036:
        r1.f10351e = r2;
        r2 = r1.f10350d;
        if (r2 == 0) goto L_0x0042;
    L_0x003c:
        r2 = r2.getWhitelistStatus();
        if (r2 != 0) goto L_0x0046;
    L_0x0042:
        r2 = f10348n;
    L_0x0046:
        r1.f10352f = r2;
        r2 = r1.f10357k;
        r2 = r2.f10322a;
        r1.f10353g = r2;
        r2 = new com.reddit.datalibrary.frontpage.data.feature.ads.repo.RedditAdLoader$requestBuilder$2;
        r2.<init>(r1);
        r2 = (kotlin.jvm.functions.Function0) r2;
        r2 = kotlin.LazyKt.a(r2);
        r1.f10349b = r2;
        r2 = new com.reddit.datalibrary.frontpage.data.feature.ads.repo.RedditAdLoader$adLoader$2;
        r2.<init>(r1);
        r2 = (kotlin.jvm.functions.Function0) r2;
        r2 = kotlin.LazyKt.a(r2);
        r1.f10354h = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.feature.ads.repo.RedditAdLoader.<init>(android.content.Context, com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings, com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdContext, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    public static final /* synthetic */ Builder m8814c(RedditAdLoader redditAdLoader) {
        redditAdLoader = new Builder().m4392a("screen", redditAdLoader.f10357k.f10323b).m4392a("subreddit_screen", String.valueOf(redditAdLoader.f10350d != null)).m4392a("nsfw", String.valueOf(redditAdLoader.f10351e)).m4392a("compact", String.valueOf(redditAdLoader.f10356j.m9030c())).m4392a("whitelist_status", redditAdLoader.f10352f).m4392a(User.VALUE_LOGGED_IN, String.valueOf(redditAdLoader.f10353g.isAnonymous() ^ true)).m4392a("random_number", String.valueOf(redditAdLoader.f10353g.m16309a().hashCode() % 100));
        Intrinsics.a(redditAdLoader, "PublisherAdRequest.Build…Code() % 100).toString())");
        return redditAdLoader;
    }

    public static final /* synthetic */ AdLoader m8815d(RedditAdLoader redditAdLoader) {
        redditAdLoader = new AdLoader.Builder(redditAdLoader.f10355i, redditAdLoader.f10357k.f10324c).m4364a((OnAppInstallAdLoadedListener) new RedditAdLoader$createAdLoader$1(redditAdLoader)).m4365a((OnContentAdLoadedListener) new RedditAdLoader$createAdLoader$2(redditAdLoader)).m4362a((AdListener) new RedditAdLoader$createAdLoader$3(redditAdLoader)).m4363a(new NativeAdOptions.Builder().m4405b().m4403a().m4404a(new VideoOptions.Builder().m4388a().m4389b()).m4406c()).m4367a();
        Intrinsics.a(redditAdLoader, "AdLoader.Builder(context…\n                .build()");
        return redditAdLoader;
    }
}
