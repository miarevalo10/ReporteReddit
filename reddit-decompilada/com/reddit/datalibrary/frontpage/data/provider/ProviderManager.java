package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import android.os.Parcel;
import com.reddit.frontpage.FrontpageApplication;
import com.vincentbrison.openlibraries.android.dualcache.Builder;
import com.vincentbrison.openlibraries.android.dualcache.DiskCacheSerializer;
import com.vincentbrison.openlibraries.android.dualcache.DualCache;
import java.io.InputStream;
import java.io.OutputStr
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001BB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\"\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0017J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004J<\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u001f\u001a\u00020\b2 \b\u0002\u0010 \u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0#0\"0!H\u0007JD\u0010$\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010&\u001a\u00020\u00042\b\b\u0001\u0010'\u001a\u00020\u00042 \b\u0002\u0010 \u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0#0\"0!J\u0016\u0010(\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bJ!\u0010+\u001a\u0004\u0018\u0001H,\"\b\b\u0000\u0010,*\u00020\t2\u0006\u0010\u000f\u001a\u00020\bH\u0003¢\u0006\u0002\u0010-J.\u0010+\u001a\u0002H,\"\b\b\u0000\u0010,*\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H,0!H\b¢\u0006\u0002\u0010/J+\u0010+\u001a\u0002H,\"\b\b\u0000\u0010,*\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\n\u00100\u001a\u0006\u0012\u0002\b\u000301H\u0007¢\u0006\u0002\u00102J\u0010\u00103\u001a\u0004\u0018\u0001042\u0006\u0010\u000f\u001a\u00020\bJ\u0016\u00105\u001a\u0002062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u00107\u001a\u00020\bJ \u00108\u001a\u0002092\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\b\u0010;\u001a\u0004\u0018\u00010<J\u000e\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u0004J\u000e\u0010?\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\bJ\"\u0010@\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0017J\"\u0010A\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/ProviderManager;", "", "()V", "MAX_NAME_LENGTH", "", "MAX_STATE_DISK_SIZE", "providerCache", "Ljava/util/HashMap;", "", "Lcom/reddit/datalibrary/frontpage/data/provider/BaseOtherProvider;", "Lkotlin/collections/HashMap;", "stateCache", "Lcom/vincentbrison/openlibraries/android/dualcache/DualCache;", "Landroid/os/Bundle;", "cacheKey", "ownerId", "name", "provider", "checkName", "", "clearCache", "clearState", "providers", "", "getCommentsProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/CommentsProvider;", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "sortId", "getDefaultsLinkListingProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/DefaultsLinkProvider;", "defaultSub", "queryParameters", "Lkotlin/Function0;", "", "Lkotlin/Pair;", "getFrontpageLinkListingProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/FrontpageLinkListingProvider;", "sortType", "sortTimeFrame", "getMultiredditLinkListingProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/MultiredditLinkListingProvider;", "multireddit", "getProvider", "T", "(Ljava/lang/String;)Lcom/reddit/datalibrary/frontpage/data/provider/BaseOtherProvider;", "create", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lcom/reddit/datalibrary/frontpage/data/provider/BaseOtherProvider;", "spec", "Lcom/reddit/datalibrary/frontpage/data/provider/ProviderSpec;", "(Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/data/provider/ProviderSpec;)Lcom/reddit/datalibrary/frontpage/data/provider/BaseOtherProvider;", "getProviderByOwnerId", "Lcom/reddit/datalibrary/frontpage/data/provider/LinkListingProvider;", "getSubredditLinkListingProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/SubredditLinkListingProvider;", "subreddit", "getUserSubmittedLinkListingProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/UserSubmittedListingProvider;", "username", "filter", "Lcom/reddit/datalibrary/frontpage/data/provider/UserSubmittedListingProvider$Filter;", "onTrimMemory", "level", "releaseProviders", "restoreInstanceState", "saveInstanceState", "BundleSerializer", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ProviderManager.kt */
public final class ProviderManager {
    public static final DualCache<Bundle> f10795a;
    public static final ProviderManager f10796b = new ProviderManager();
    private static final HashMap<String, BaseOtherProvider> f10797c = new HashMap();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/ProviderManager$BundleSerializer;", "Lcom/vincentbrison/openlibraries/android/dualcache/DiskCacheSerializer;", "Landroid/os/Bundle;", "()V", "fromStream", "stream", "Ljava/io/InputStream;", "writeToStream", "", "Ljava/io/OutputStream;", "bundle", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ProviderManager.kt */
    public static final class BundleSerializer implements DiskCacheSerializer<Bundle> {
        public final /* synthetic */ Object m16289a(InputStream inputStream) {
            return m16288b(inputStream);
        }

        public final /* synthetic */ void m16290a(OutputStream outputStream, Object obj) {
            Bundle bundle = (Bundle) obj;
            Intrinsics.b(outputStream, "stream");
            Intrinsics.b(bundle, "bundle");
            Parcel obtain = Parcel.obtain();
            try {
                bundle.writeToParcel(obtain, 0);
                outputStream.write(obtain.marshall());
            } finally {
                obtain.recycle();
            }
        }

        private static Bundle m16288b(InputStream inputStream) {
            Intrinsics.b(inputStream, "stream");
            Parcel obtain = Parcel.obtain();
            try {
                inputStream = ByteStreamsKt.a(inputStream);
                obtain.unmarshall(inputStream, 0, inputStream.length);
                obtain.setDataPosition(0);
                inputStream = obtain.readBundle(BundleSerializer.class.getClassLoader());
                Intrinsics.a(inputStream, "parcel.readBundle(Bundle…::class.java.classLoader)");
                return inputStream;
            } finally {
                obtain.recycle();
            }
        }
    }

    static {
        DualCache b = new Builder("ProviderStateCache").a(ProviderManager$stateCache$1.f16272a).a(new BundleSerializer(), FrontpageApplication.a).a().b();
        Intrinsics.a(b, "Builder<Bundle>(\"Provide…og()\n            .build()");
        f10795a = b;
    }

    private ProviderManager() {
    }

    public static void m9142a(int i) {
        if (i >= 60) {
            f10795a.invalidateRAM();
        }
    }

    public static void m9141a() {
        f10795a.invalidate();
    }

    public static void m9144a(String str, Map<String, ? extends BaseOtherProvider> map) {
        Intrinsics.b(str, "ownerId");
        Intrinsics.b(map, "providers");
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            f10795a.delete(m9140a(str, (String) entry.getKey(), (BaseOtherProvider) entry.getValue()));
        }
    }

    public static String m9140a(String str, String str2, BaseOtherProvider baseOtherProvider) {
        StringBuilder stringBuilder = new StringBuilder();
        baseOtherProvider = baseOtherProvider.ownerId;
        if (baseOtherProvider != null) {
            str = baseOtherProvider;
        }
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public static /* synthetic */ FrontpageLinkListingProvider m9139a(String str, int i, int i2) {
        Function0 function0 = ProviderManager$getFrontpageLinkListingProvider$1.f19440a;
        Intrinsics.b(str, "ownerId");
        Intrinsics.b(function0, "queryParameters");
        BaseOtherProvider baseOtherProvider = (BaseOtherProvider) f10797c.get(str);
        if (baseOtherProvider == null) {
            baseOtherProvider = new FrontpageLinkListingProvider(str, i, i2, function0);
            f10797c.put(str, baseOtherProvider);
        }
        return (FrontpageLinkListingProvider) baseOtherProvider;
    }

    public static void m9143a(String str) {
        Intrinsics.b(str, "ownerId");
        f10797c.remove(str);
    }

    public static <T extends BaseOtherProvider> T m9136a(String str, ProviderSpec<?> providerSpec) {
        Intrinsics.b(str, "ownerId");
        Intrinsics.b(providerSpec, "spec");
        T t = (BaseOtherProvider) f10797c.get(str);
        if (t == null) {
            t = providerSpec.createProvider();
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            f10797c.put(str, t);
        }
        return t;
    }

    public static final DefaultsLinkProvider m9138a(String str, String str2, Function0<? extends List<Pair<String, String>>> function0) {
        Intrinsics.b(str, "ownerId");
        Intrinsics.b(str2, "defaultSub");
        Intrinsics.b(function0, "queryParameters");
        BaseOtherProvider baseOtherProvider = (BaseOtherProvider) f10797c.get(str);
        if (baseOtherProvider == null) {
            baseOtherProvider = new DefaultsLinkProvider(str, str2, function0);
            f10797c.put(str, baseOtherProvider);
        }
        return (DefaultsLinkProvider) baseOtherProvider;
    }

    public static final DefaultsLinkProvider m9137a(String str, String str2) {
        return m9138a(str, str2, (Function0) ProviderManager$getDefaultsLinkListingProvider$1.f19439a);
    }
}
