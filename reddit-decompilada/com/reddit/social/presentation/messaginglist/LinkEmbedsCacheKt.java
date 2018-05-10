package com.reddit.social.presentation.messaginglist;

import com.coremedia.iso.boxes.MetaBox;
import java.net.URI;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import net.hockeyapp.android.UpdateFragment;
import org.jsoup.nodes.Element;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, d2 = {"createLinkEmbed", "Lcom/reddit/social/presentation/messaginglist/LinkEmbed;", "head", "Lorg/jsoup/nodes/Element;", "url", "", "reformatUrl", "baseUri", "Ljava/net/URI;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: LinkEmbedsCache.kt */
public final class LinkEmbedsCacheKt {
    public static final LinkEmbed m24705a(Element element, String str) {
        String b;
        String b2;
        Element element2 = element;
        String str2 = str;
        Intrinsics.m26847b(element2, "head");
        Intrinsics.m26847b(str2, UpdateFragment.FRAGMENT_URL);
        URI uri = new URI(str2);
        Object a = element2.m33925a(MetaBox.TYPE);
        Intrinsics.m26843a(a, "head.getElementsByTag(\"meta\")");
        Iterator it = a.iterator();
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        Object obj = null;
        String str10 = null;
        while (it.hasNext()) {
            Element element3 = (Element) it.next();
            String b3 = element3.mo6341b("property");
            b = element3.mo6341b("content");
            if (b3 != null) {
                switch (b3.hashCode()) {
                    case -1137178311:
                        if (!b3.equals("og:image")) {
                            break;
                        }
                        if (str3 != null) {
                            b = str3;
                        }
                        str3 = b;
                        break;
                    case -1127120330:
                        if (b3.equals("og:title") && str4 == null) {
                            str4 = b;
                            break;
                        }
                    case -1020164915:
                        if (b3.equals("og:url") && str5 == null) {
                            str5 = b;
                            break;
                        }
                    case 1029113178:
                        if (b3.equals("og:description") && str6 == null) {
                            str6 = b;
                            break;
                        }
                    case 1994525025:
                        if (b3.equals("og:site_name") && str7 == null) {
                            str7 = b;
                            break;
                        }
                    default:
                        break;
                }
            }
            b2 = element3.mo6341b("name");
            if (b2 != null) {
                switch (b2.hashCode()) {
                    case -1940224620:
                        if (!b2.equals("twitter:image")) {
                            break;
                        }
                        if (str8 != null) {
                            b = str8;
                        }
                        str8 = b;
                        break;
                    case -1930166639:
                        if (b2.equals("twitter:title") && str9 == null) {
                            str9 = b;
                            break;
                        }
                    case -1724546052:
                        boolean equals = b2.equals("description");
                        break;
                    case -893577234:
                        if (b2.equals("twitter:site") && r12 == null) {
                            obj = b;
                            break;
                        }
                    case 1048809845:
                        if (b2.equals("twitter:description") && r13 == null) {
                            str10 = b;
                            break;
                        }
                    default:
                        break;
                }
            }
        }
        a = element2.m33925a("title");
        Intrinsics.m26843a(a, "head.getElementsByTag(\"title\")");
        Element a2 = a.m28625a();
        b = a2 != null ? a2.m33938i() : null;
        Object a3 = element2.m33925a("link");
        Intrinsics.m26843a(a3, "head.getElementsByTag(\"link\")");
        Iterator it2 = a3.iterator();
        String str11 = null;
        b2 = null;
        while (it2.hasNext()) {
            Element element4 = (Element) it2.next();
            Iterator it3 = it2;
            a3 = element4.mo6341b("rel");
            if (str11 == null && (Intrinsics.m26845a(a3, (Object) "shortcut icon") || Intrinsics.m26845a(a3, (Object) "icon"))) {
                str11 = element4.mo6341b("href");
            } else if (b2 == null && (Intrinsics.m26845a(a3, (Object) "apple-touch-icon") || Intrinsics.m26845a(a3, (Object) "apple-touch-icon-precomposed"))) {
                b2 = element4.mo6341b("href");
            }
            it2 = it3;
            str2 = str;
        }
        if (str5 == null) {
            str5 = null;
        }
        String str12 = str5 == null ? str : str5;
        if (str7 != null) {
            obj = str7;
        }
        if (obj == null) {
            obj = uri.getHost();
        }
        Intrinsics.m26843a(obj, "(ogSiteName ?: twtSiteName ?: baseUri.host)");
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        String str13;
        String str14;
        String obj2 = StringsKt__StringsKt.m42456b((CharSequence) obj).toString();
        if (str4 == null) {
            str4 = str9;
        }
        if (str4 != null) {
            b = str4;
        }
        if (b == null) {
            str13 = null;
        } else if (b == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        } else {
            str13 = StringsKt__StringsKt.m42456b((CharSequence) b).toString();
        }
        if (str6 != null) {
            str10 = str6;
        }
        if (str10 == null) {
            str14 = null;
        } else if (str10 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        } else {
            str14 = StringsKt__StringsKt.m42456b((CharSequence) str10).toString();
        }
        if (b2 == null) {
            b2 = str11;
        }
        if (b2 == null) {
            b2 = "/favicon.ico";
        }
        String a4 = m24706a(b2, uri);
        if (str3 == null) {
            str3 = str8;
        }
        return new LinkEmbed(str12, obj2, str13, str14, a4, m24706a(str3, uri));
    }

    private static final java.lang.String m24706a(java.lang.String r9, java.net.URI r10) {
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
        r0 = new java.net.URI;	 Catch:{ Exception -> 0x004e }
        r0.<init>(r9);	 Catch:{ Exception -> 0x004e }
        r9 = r0.getHost();	 Catch:{ Exception -> 0x004e }
        if (r9 != 0) goto L_0x000f;	 Catch:{ Exception -> 0x004e }
    L_0x000b:
        r9 = r10.getHost();	 Catch:{ Exception -> 0x004e }
    L_0x000f:
        r4 = r9;	 Catch:{ Exception -> 0x004e }
        r9 = r0.getScheme();	 Catch:{ Exception -> 0x004e }
        if (r9 == 0) goto L_0x002a;	 Catch:{ Exception -> 0x004e }
    L_0x0016:
        r1 = "http";	 Catch:{ Exception -> 0x004e }
        r1 = kotlin.jvm.internal.Intrinsics.m26845a(r9, r1);	 Catch:{ Exception -> 0x004e }
        r1 = r1 ^ 1;	 Catch:{ Exception -> 0x004e }
        if (r1 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x004e }
    L_0x0020:
        r1 = "https";	 Catch:{ Exception -> 0x004e }
        r1 = kotlin.jvm.internal.Intrinsics.m26845a(r9, r1);	 Catch:{ Exception -> 0x004e }
        r1 = r1 ^ 1;	 Catch:{ Exception -> 0x004e }
        if (r1 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x004e }
    L_0x002a:
        r9 = r10.getScheme();	 Catch:{ Exception -> 0x004e }
    L_0x002e:
        r2 = r9;	 Catch:{ Exception -> 0x004e }
        r9 = new java.net.URI;	 Catch:{ Exception -> 0x004e }
        r3 = r0.getUserInfo();	 Catch:{ Exception -> 0x004e }
        r5 = r0.getPort();	 Catch:{ Exception -> 0x004e }
        r6 = r0.getPath();	 Catch:{ Exception -> 0x004e }
        r7 = r0.getQuery();	 Catch:{ Exception -> 0x004e }
        r8 = r0.getFragment();	 Catch:{ Exception -> 0x004e }
        r1 = r9;	 Catch:{ Exception -> 0x004e }
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x004e }
        r9 = r9.toString();	 Catch:{ Exception -> 0x004e }
        goto L_0x004f;
    L_0x004e:
        r9 = 0;
    L_0x004f:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.social.presentation.messaginglist.LinkEmbedsCacheKt.a(java.lang.String, java.net.URI):java.lang.String");
    }
}
