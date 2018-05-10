package com.reddit.frontpage.presentation.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019J*\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f¨\u0006\""}, d2 = {"Lcom/reddit/frontpage/presentation/common/ContentTypeUtil;", "", "()V", "ANIMATED_IMAGE_EXTENSION_REGEX", "Lkotlin/text/Regex;", "VIDEO_EXTENSION_REGEX", "imageContentTypeExceptions", "", "Ljava/util/regex/Pattern;", "getImageContentTypeExceptions", "()Ljava/util/Set;", "setImageContentTypeExceptions", "(Ljava/util/Set;)V", "imageContentTypes", "getImageContentTypes", "setImageContentTypes", "videoContentTypeExceptions", "getVideoContentTypeExceptions", "setVideoContentTypeExceptions", "videoContentTypes", "getVideoContentTypes", "setVideoContentTypes", "extractPatterns", "typeMap", "", "", "isAnimatedImageExtension", "", "src", "isContentTypeMatch", "contentUrl", "contentTypes", "contentTypeExceptions", "isVideoExtension", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ContentTypeUtil.kt */
public final class ContentTypeUtil {
    public static final ContentTypeUtil f20363a = new ContentTypeUtil();
    private static final Regex f20364b = new Regex("([^\\s]+(\\.(?i)(gifv|mp4|webm))$)");
    private static final Regex f20365c = new Regex("([^\\s]+(\\.(?i)(gif))$)");
    private static Set<Pattern> f20366d;
    private static Set<Pattern> f20367e;
    private static Set<Pattern> f20368f;
    private static Set<Pattern> f20369g;

    private ContentTypeUtil() {
    }

    public static Set<Pattern> m22691a() {
        return f20366d;
    }

    public static void m22693a(Set<Pattern> set) {
        f20366d = set;
    }

    public static Set<Pattern> m22696b() {
        return f20367e;
    }

    public static void m22697b(Set<Pattern> set) {
        f20367e = set;
    }

    public static Set<Pattern> m22699c() {
        return f20368f;
    }

    public static void m22700c(Set<Pattern> set) {
        f20368f = set;
    }

    public static Set<Pattern> m22701d() {
        return f20369g;
    }

    public static void m22702d(Set<Pattern> set) {
        f20369g = set;
    }

    public static boolean m22694a(String str) {
        Intrinsics.m26847b(str, "src");
        return f20364b.m28147a(str);
    }

    public static boolean m22698b(String str) {
        Intrinsics.m26847b(str, "src");
        return f20365c.m28147a(str);
    }

    public static boolean m22695a(String str, Set<Pattern> set, Set<Pattern> set2) {
        Intrinsics.m26847b(str, "contentUrl");
        Intrinsics.m26847b(set, "contentTypes");
        Intrinsics.m26847b(set2, "contentTypeExceptions");
        for (Pattern matcher : set2) {
            if (matcher.matcher(str).find()) {
                return false;
            }
        }
        for (Pattern matcher2 : set) {
            if (matcher2.matcher(str).find() != null) {
                return true;
            }
        }
        return false;
    }

    public static Set<Pattern> m22692a(Map<String, String> map) {
        if (map != null) {
            if (!map.isEmpty()) {
                Iterable<String> keySet = map.keySet();
                Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(keySet));
                for (String compile : keySet) {
                    arrayList.add(Pattern.compile(compile));
                }
                return CollectionsKt___CollectionsKt.m41451p((List) arrayList);
            }
        }
        return SetsKt__SetsKt.m26799a();
    }
}
