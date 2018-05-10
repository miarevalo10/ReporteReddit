package com.reddit.frontpage.util;

import com.reddit.datalibrary.frontpage.requests.models.v1.AdEvent;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import io.reactivex.Completable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/util/AdUtil;", "", "()V", "REDDIT_DOMAIN", "", "isAmazonDevice", "", "()Z", "fetchAdId", "", "fetchAmazonAdId", "fetchGoogleAdId", "getUniqueId", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "Lcom/reddit/frontpage/domain/model/Link;", "init", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdUtil.kt */
public final class AdUtil {
    public static final AdUtil f21689a = new AdUtil();

    private AdUtil() {
    }

    public static final void m23635a() {
        Object fromAction = Completable.fromAction(AdUtil$init$1.f29375a);
        Intrinsics.m26843a(fromAction, "Completable.fromAction { fetchAdId() }");
        CompletablesKt.m24074b(CompletablesKt.m24073a(fromAction, FrontpageApplication.m28875k().mo4632t()), FrontpageApplication.m28875k().mo4633u()).subscribe();
    }

    public static final String m23633a(Link link) {
        Intrinsics.m26847b(link, "link");
        if (link.isPromoted()) {
            List adEvents = link.getAdEvents();
            String str = null;
            if (adEvents != null) {
                for (Object next : adEvents) {
                    AdEvent adEvent = (AdEvent) next;
                    Object obj = null;
                    if (adEvent.getType() == 1) {
                        String url = adEvent.getUrl();
                        if (url != null ? StringsKt__StringsKt.m42452a((CharSequence) url, (CharSequence) "reddit.com") : false) {
                            obj = 1;
                            continue;
                        } else {
                            continue;
                        }
                    }
                    if (obj != null) {
                        break;
                    }
                }
                Object next2 = null;
                AdEvent adEvent2 = (AdEvent) next2;
                if (adEvent2 != null) {
                    str = adEvent2.getUrl();
                }
            }
            return str == null ? link.getId() : str;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(link);
            stringBuilder.append(" is not a promoted post");
            throw new IllegalArgumentException(stringBuilder.toString().toString());
        }
    }

    public static final String m23634a(com.reddit.frontpage.domain.model.Link link) {
        Intrinsics.m26847b(link, "link");
        if (link.getPromoted()) {
            List events = link.getEvents();
            String str = null;
            if (events != null) {
                for (Object next : events) {
                    com.reddit.frontpage.domain.model.AdEvent adEvent = (com.reddit.frontpage.domain.model.AdEvent) next;
                    Object obj = null;
                    if (adEvent.getType() == 1) {
                        String url = adEvent.getUrl();
                        if (url != null ? StringsKt__StringsKt.m42452a((CharSequence) url, (CharSequence) "reddit.com") : false) {
                            obj = 1;
                            continue;
                        } else {
                            continue;
                        }
                    }
                    if (obj != null) {
                        break;
                    }
                }
                Object next2 = null;
                com.reddit.frontpage.domain.model.AdEvent adEvent2 = (com.reddit.frontpage.domain.model.AdEvent) next2;
                if (adEvent2 != null) {
                    str = adEvent2.getUrl();
                }
            }
            return str == null ? link.getId() : str;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(link);
            stringBuilder.append(" is not a promoted post");
            throw new IllegalArgumentException(stringBuilder.toString().toString());
        }
    }

    public static final /* synthetic */ void m23636b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = "Amazon";
        r1 = android.os.Build.MANUFACTURER;
        r0 = kotlin.jvm.internal.Intrinsics.m26845a(r0, r1);
        r1 = 0;
        if (r0 == 0) goto L_0x0055;
    L_0x000b:
        r0 = com.reddit.frontpage.FrontpageApplication.f27402a;
        r2 = "FrontpageApplication.instance";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        r0 = r0.getContentResolver();
        r2 = "limit_ad_tracking";
        r3 = 2;
        r2 = android.provider.Settings.Secure.getInt(r0, r2, r3);
        if (r2 == 0) goto L_0x0031;
    L_0x001f:
        if (r2 == r3) goto L_0x0029;
    L_0x0021:
        r0 = "Unable to retrieve the Amazon Ad ID because the user has limited ad tracking.";
        r1 = new java.lang.Object[r1];
        timber.log.Timber.b(r0, r1);
        return;
    L_0x0029:
        r0 = "Unable to retrieve the Amazon Ad ID because this version of Fire OS does not have this setting.";
        r1 = new java.lang.Object[r1];
        timber.log.Timber.b(r0, r1);
        return;
    L_0x0031:
        r2 = new java.lang.StringBuilder;
        r3 = "a-";
        r2.<init>(r3);
        r3 = "advertising_id";
        r0 = android.provider.Settings.Secure.getString(r0, r3);
        r2.append(r0);
        r0 = r2.toString();
        com.reddit.datalibrary.frontpage.redditauth.Config.f(r0);
        r0 = "Retrieved Amazon Ad ID: %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = com.reddit.datalibrary.frontpage.redditauth.Config.l;
        r2[r1] = r3;
        timber.log.Timber.b(r0, r2);
        return;
    L_0x0055:
        r0 = com.reddit.frontpage.FrontpageApplication.f27402a;	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r0 = (android.content.Context) r0;	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r0 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r0);	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        if (r0 == 0) goto L_0x0090;	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
    L_0x005f:
        r2 = r0.isLimitAdTrackingEnabled();	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        if (r2 != 0) goto L_0x0090;	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
    L_0x0065:
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r3 = "g-";	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r0 = r0.getId();	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r2.append(r0);	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r0 = r2.toString();	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        com.reddit.datalibrary.frontpage.redditauth.Config.e(r0);	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r2 = "Retrieved Googld Ad ID: ";	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r0.<init>(r2);	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r2 = com.reddit.datalibrary.frontpage.redditauth.Config.k;	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r0.append(r2);	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r2 = new java.lang.Object[r1];	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        timber.log.Timber.b(r0, r2);	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        return;	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
    L_0x0090:
        r0 = "Unable to retrieve the Google Ad ID because the user has limited ad tracking.";	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        r2 = new java.lang.Object[r1];	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        timber.log.Timber.b(r0, r2);	 Catch:{ IOException -> 0x00a8, GooglePlayServicesNotAvailableException -> 0x00a0, GooglePlayServicesRepairableException -> 0x0098 }
        return;
    L_0x0098:
        r0 = "Unable to retrieve the Google Ad ID because Google Play Services is unavailable.";
        r1 = new java.lang.Object[r1];
        timber.log.Timber.b(r0, r1);
        return;
    L_0x00a0:
        r0 = "Unable to retrieve the Google Ad ID because Google Play Services is unavailable.";
        r1 = new java.lang.Object[r1];
        timber.log.Timber.b(r0, r1);
        return;
    L_0x00a8:
        r0 = "Unable to retrieve the Google Ad ID because Google Play Services is unavailable.";
        r1 = new java.lang.Object[r1];
        timber.log.Timber.b(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.AdUtil.b():void");
    }
}
