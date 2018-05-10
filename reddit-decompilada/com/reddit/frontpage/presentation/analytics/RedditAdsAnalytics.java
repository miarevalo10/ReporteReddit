package com.reddit.frontpage.presentation.analytics;

import android.content.Context;
import com.reddit.datalibrary.frontpage.requests.models.Votable.AdAnalyticsInfo;
import com.reddit.datalibrary.frontpage.requests.models.v1.AdEventKt;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0007J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\f\u001a\u00020\rH\u0003J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0014H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/presentation/analytics/RedditAdsAnalytics;", "", "()V", "alreadySentUrls", "", "", "fireAdPixel", "", "context", "Landroid/content/Context;", "adInfo", "Lcom/reddit/datalibrary/frontpage/requests/models/Votable$AdAnalyticsInfo;", "eventType", "", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "Lcom/reddit/frontpage/domain/model/Link;", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "adEvents", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/AdEvent;", "sendAdEvent", "event", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditAdsAnalytics.kt */
public final class RedditAdsAnalytics {
    public static final RedditAdsAnalytics f20323a = new RedditAdsAnalytics();
    private static final Set<String> f20324b = new LinkedHashSet();

    private RedditAdsAnalytics() {
    }

    public static final void m22653a(Context context, LinkPresentationModel linkPresentationModel, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(linkPresentationModel, "link");
        StringBuilder stringBuilder = new StringBuilder("Firing event (");
        stringBuilder.append(i);
        stringBuilder.append(") pixels for ad ");
        stringBuilder.append(linkPresentationModel.f33977d);
        Timber.a(stringBuilder.toString(), new Object[0]);
        m22654a(context, AdEventKt.a(linkPresentationModel.f33961N), i);
    }

    public static final void m22651a(Context context, Link link, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(link, "link");
        StringBuilder stringBuilder = new StringBuilder("Firing event (");
        stringBuilder.append(i);
        stringBuilder.append(") pixels for ad ");
        stringBuilder.append(link.getId());
        Timber.a(stringBuilder.toString(), new Object[0]);
        List adEvents = link.getAdEvents();
        Intrinsics.m26843a((Object) adEvents, "link.adEvents");
        m22654a(context, adEvents, i);
    }

    public static final void m22652a(Context context, com.reddit.frontpage.domain.model.Link link) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(link, "link");
        StringBuilder stringBuilder = new StringBuilder("Firing event (2) pixels for ad ");
        stringBuilder.append(link.getId());
        Timber.a(stringBuilder.toString(), new Object[0]);
        link = link.getEvents();
        m22654a(context, link != null ? AdEventKt.a(link) : CollectionsKt__CollectionsKt.m26790a(), 2);
    }

    public static final void m22650a(Context context, AdAnalyticsInfo adAnalyticsInfo, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(adAnalyticsInfo, "adInfo");
        StringBuilder stringBuilder = new StringBuilder("Firing event (");
        stringBuilder.append(i);
        stringBuilder.append(") pixels for ad ");
        stringBuilder.append(adAnalyticsInfo.linkId);
        Timber.a(stringBuilder.toString(), new Object[0]);
        List list = adAnalyticsInfo.adEvents;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.m26790a();
        }
        m22654a(context, list, i);
    }

    private static final void m22654a(android.content.Context r6, java.util.List<com.reddit.datalibrary.frontpage.requests.models.v1.AdEvent> r7, int r8) {
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
        r7 = (java.lang.Iterable) r7;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0 = (java.util.Collection) r0;
        r7 = r7.iterator();
    L_0x000d:
        r1 = r7.hasNext();
        r2 = 1;
        r3 = 0;
        if (r1 == 0) goto L_0x002a;
    L_0x0015:
        r1 = r7.next();
        r4 = r1;
        r4 = (com.reddit.datalibrary.frontpage.requests.models.v1.AdEvent) r4;
        r4 = r4.getType();
        if (r4 != r8) goto L_0x0023;
    L_0x0022:
        goto L_0x0024;
    L_0x0023:
        r2 = r3;
    L_0x0024:
        if (r2 == 0) goto L_0x000d;
    L_0x0026:
        r0.add(r1);
        goto L_0x000d;
    L_0x002a:
        r0 = (java.util.List) r0;
        r0 = (java.lang.Iterable) r0;
        r7 = new java.util.ArrayList;
        r7.<init>();
        r7 = (java.util.Collection) r7;
        r8 = r0.iterator();
    L_0x0039:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x0058;
    L_0x003f:
        r0 = r8.next();
        r1 = r0;
        r1 = (com.reddit.datalibrary.frontpage.requests.models.v1.AdEvent) r1;
        r4 = f20324b;
        r4 = (java.lang.Iterable) r4;
        r1 = r1.getUrl();
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.m41420a(r4, r1);
        if (r1 != 0) goto L_0x0039;
    L_0x0054:
        r7.add(r0);
        goto L_0x0039;
    L_0x0058:
        r7 = (java.util.List) r7;
        r7 = (java.lang.Iterable) r7;
        r7 = r7.iterator();
    L_0x0060:
        r8 = r7.hasNext();
        if (r8 == 0) goto L_0x00f8;
    L_0x0066:
        r8 = r7.next();
        r8 = (com.reddit.datalibrary.frontpage.requests.models.v1.AdEvent) r8;
        r0 = r8.getUrl();
        if (r0 == 0) goto L_0x0060;
    L_0x0072:
        r0 = com.reddit.frontpage.util.ActivityUtil.f21688a;
        r0 = com.reddit.frontpage.util.ActivityUtil.m23632a(r6);
        if (r0 == 0) goto L_0x007b;
    L_0x007a:
        goto L_0x0060;
    L_0x007b:
        r0 = new java.lang.StringBuilder;
        r1 = "Firing pixel. Type: ";
        r0.<init>(r1);
        r1 = r8.getType();
        r0.append(r1);
        r1 = " URL: {";
        r0.append(r1);
        r0.append(r8);
        r1 = ".url}";
        r0.append(r1);
        r0 = r0.toString();
        r1 = new java.lang.Object[r3];
        timber.log.Timber.a(r0, r1);
        r0 = f20324b;
        r1 = r8.getUrl();
        if (r1 != 0) goto L_0x00aa;
    L_0x00a7:
        kotlin.jvm.internal.Intrinsics.m26842a();
    L_0x00aa:
        r0.add(r1);
        r0 = new com.reddit.frontpage.domain.usecase.AdsFirePixel;
        r0.<init>(r6);
        r1 = new com.reddit.frontpage.presentation.analytics.RedditAdsAnalytics$sendAdEvent$1;
        r1.<init>(r8);
        r1 = (com.reddit.frontpage.domain.usecase.AdsPixelParams) r1;
        r8 = "params";
        kotlin.jvm.internal.Intrinsics.m26847b(r1, r8);
        r8 = r0.f20267a;	 Catch:{ IllegalArgumentException -> 0x00ef }
        r8 = com.reddit.config.GlideApp.a(r8);	 Catch:{ IllegalArgumentException -> 0x00ef }
        r8 = r8.i();	 Catch:{ IllegalArgumentException -> 0x00ef }
        r0 = new com.bumptech.glide.load.model.GlideUrl;	 Catch:{ IllegalArgumentException -> 0x00ef }
        r4 = r1.mo6432a();	 Catch:{ IllegalArgumentException -> 0x00ef }
        r5 = com.reddit.frontpage.domain.usecase.AdsFirePixel$execute$1.f27964c;	 Catch:{ IllegalArgumentException -> 0x00ef }
        r5 = (com.bumptech.glide.load.model.Headers) r5;	 Catch:{ IllegalArgumentException -> 0x00ef }
        r0.<init>(r4, r5);	 Catch:{ IllegalArgumentException -> 0x00ef }
        r8 = r8.load(r0);	 Catch:{ IllegalArgumentException -> 0x00ef }
        r0 = com.bumptech.glide.load.engine.DiskCacheStrategy.b;	 Catch:{ IllegalArgumentException -> 0x00ef }
        r8 = r8.diskCacheStrategy(r0);	 Catch:{ IllegalArgumentException -> 0x00ef }
        r8 = r8.skipMemoryCache(r2);	 Catch:{ IllegalArgumentException -> 0x00ef }
        r0 = new com.reddit.frontpage.domain.usecase.AdsFirePixel$execute$2;	 Catch:{ IllegalArgumentException -> 0x00ef }
        r0.<init>(r1);	 Catch:{ IllegalArgumentException -> 0x00ef }
        r0 = (com.bumptech.glide.request.target.Target) r0;	 Catch:{ IllegalArgumentException -> 0x00ef }
        r8.into(r0);	 Catch:{ IllegalArgumentException -> 0x00ef }
        goto L_0x0060;
    L_0x00ef:
        r8 = "Cannot fire pixel event if context is a destroyed activity";
        r0 = new java.lang.Object[r3];
        timber.log.Timber.e(r8, r0);
        goto L_0x0060;
    L_0x00f8:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.presentation.analytics.RedditAdsAnalytics.a(android.content.Context, java.util.List, int):void");
    }
}
