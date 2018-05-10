package com.reddit.datalibrary.frontpage.data.common.converter;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel;
import com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel.LinkCause;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.Subreddit;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Moshi.Builder;
import com.squareup.moshi.ToJson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002*+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u001a\u0010\u001b\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u001cH\u0007J6\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020&0%0$2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010(2\u0006\u0010)\u001a\u00020&H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n8BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u0019\u0010\r¨\u0006,"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/DiscoveryUnitListingDataModelJsonAdapter;", "", "()V", "KEY_CAUSE", "", "KEY_CHILDREN", "KEY_DATA", "KEY_KIND", "KEY_POSTS", "accountAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "getAccountAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "accountAdapter$delegate", "Lkotlin/Lazy;", "linkAdapter", "Lcom/reddit/frontpage/domain/model/Link;", "getLinkAdapter", "linkAdapter$delegate", "moshi", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "subredditAdapter", "Lcom/reddit/frontpage/domain/model/Subreddit;", "getSubredditAdapter", "subredditAdapter$delegate", "convert", "Lcom/reddit/datalibrary/frontpage/data/model/DiscoveryUnitListingDataModel;", "listing", "Lcom/reddit/datalibrary/frontpage/data/common/converter/DiscoveryUnitListingDataModelJsonAdapter$Listing;", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "model", "parseLinks", "", "Lkotlin/Pair;", "Lcom/reddit/datalibrary/frontpage/data/model/DiscoveryUnitListingDataModel$LinkCause;", "data", "", "cause", "Data", "Listing", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DiscoveryUnitListingDataModelJsonAdapter.kt */
public final class DiscoveryUnitListingDataModelJsonAdapter {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(DiscoveryUnitListingDataModelJsonAdapter.class), "subredditAdapter", "getSubredditAdapter()Lcom/squareup/moshi/JsonAdapter;")), Reflection.a(new PropertyReference1Impl(Reflection.a(DiscoveryUnitListingDataModelJsonAdapter.class), "accountAdapter", "getAccountAdapter()Lcom/squareup/moshi/JsonAdapter;")), Reflection.a(new PropertyReference1Impl(Reflection.a(DiscoveryUnitListingDataModelJsonAdapter.class), "linkAdapter", "getLinkAdapter()Lcom/squareup/moshi/JsonAdapter;"))};
    public static final DiscoveryUnitListingDataModelJsonAdapter INSTANCE = new DiscoveryUnitListingDataModelJsonAdapter();
    private static final String KEY_CAUSE = "cause";
    private static final String KEY_CHILDREN = "children";
    private static final String KEY_DATA = "data";
    private static final String KEY_KIND = "kind";
    private static final String KEY_POSTS = "posts";
    private static final Lazy accountAdapter$delegate = LazyKt.a(DiscoveryUnitListingDataModelJsonAdapter$accountAdapter$2.INSTANCE);
    private static final Lazy linkAdapter$delegate = LazyKt.a(DiscoveryUnitListingDataModelJsonAdapter$linkAdapter$2.INSTANCE);
    private static final Moshi moshi = new Builder().a();
    private static final Lazy subredditAdapter$delegate = LazyKt.a(DiscoveryUnitListingDataModelJsonAdapter$subredditAdapter$2.INSTANCE);

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003¢\u0006\u0002\u0010\u0006J\u001b\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003HÆ\u0003J%\u0010\n\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/DiscoveryUnitListingDataModelJsonAdapter$Data;", "", "children", "", "", "", "(Ljava/util/List;)V", "getChildren", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DiscoveryUnitListingDataModelJsonAdapter.kt */
    public static final class Data {
        private final List<Map<String, Object>> children;

        public static /* synthetic */ Data copy$default(Data data, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = data.children;
            }
            return data.copy(list);
        }

        public final List<Map<String, Object>> component1() {
            return this.children;
        }

        public final Data copy(List<? extends Map<String, ? extends Object>> list) {
            Intrinsics.b(list, DiscoveryUnitListingDataModelJsonAdapter.KEY_CHILDREN);
            return new Data(list);
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Data) {
                    if (Intrinsics.a(this.children, ((Data) obj).children)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            List list = this.children;
            return list != null ? list.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Data(children=");
            stringBuilder.append(this.children);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Data(List<? extends Map<String, ? extends Object>> list) {
            Intrinsics.b(list, DiscoveryUnitListingDataModelJsonAdapter.KEY_CHILDREN);
            this.children = list;
        }

        public final List<Map<String, Object>> getChildren() {
            return this.children;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/DiscoveryUnitListingDataModelJsonAdapter$Listing;", "", "kind", "", "data", "Lcom/reddit/datalibrary/frontpage/data/common/converter/DiscoveryUnitListingDataModelJsonAdapter$Data;", "(Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/data/common/converter/DiscoveryUnitListingDataModelJsonAdapter$Data;)V", "getData", "()Lcom/reddit/datalibrary/frontpage/data/common/converter/DiscoveryUnitListingDataModelJsonAdapter$Data;", "getKind", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DiscoveryUnitListingDataModelJsonAdapter.kt */
    public static final class Listing {
        private final Data data;
        private final String kind;

        public static /* synthetic */ Listing copy$default(Listing listing, String str, Data data, int i, Object obj) {
            if ((i & 1) != 0) {
                str = listing.kind;
            }
            if ((i & 2) != 0) {
                data = listing.data;
            }
            return listing.copy(str, data);
        }

        public final String component1() {
            return this.kind;
        }

        public final Data component2() {
            return this.data;
        }

        public final Listing copy(String str, Data data) {
            Intrinsics.b(str, DiscoveryUnitListingDataModelJsonAdapter.KEY_KIND);
            Intrinsics.b(data, DiscoveryUnitListingDataModelJsonAdapter.KEY_DATA);
            return new Listing(str, data);
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Listing) {
                    Listing listing = (Listing) obj;
                    if (Intrinsics.a(this.kind, listing.kind) && Intrinsics.a(this.data, listing.data)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.kind;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Data data = this.data;
            if (data != null) {
                i = data.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Listing(kind=");
            stringBuilder.append(this.kind);
            stringBuilder.append(", data=");
            stringBuilder.append(this.data);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Listing(String str, Data data) {
            Intrinsics.b(str, DiscoveryUnitListingDataModelJsonAdapter.KEY_KIND);
            Intrinsics.b(data, DiscoveryUnitListingDataModelJsonAdapter.KEY_DATA);
            this.kind = str;
            this.data = data;
        }

        public final Data getData() {
            return this.data;
        }

        public final String getKind() {
            return this.kind;
        }
    }

    private final JsonAdapter<Account> getAccountAdapter() {
        return (JsonAdapter) accountAdapter$delegate.b();
    }

    private final JsonAdapter<Link> getLinkAdapter() {
        return (JsonAdapter) linkAdapter$delegate.b();
    }

    private final JsonAdapter<Subreddit> getSubredditAdapter() {
        return (JsonAdapter) subredditAdapter$delegate.b();
    }

    private DiscoveryUnitListingDataModelJsonAdapter() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.squareup.moshi.FromJson
    public final com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel convert(com.reddit.datalibrary.frontpage.data.common.converter.DiscoveryUnitListingDataModelJsonAdapter.Listing r10) {
        /*
        r9 = this;
        r0 = "listing";
        kotlin.jvm.internal.Intrinsics.b(r10, r0);
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0 = (java.util.List) r0;
        r10 = r10.getData();
        r10 = r10.getChildren();
        r10 = (java.lang.Iterable) r10;
        r1 = new java.util.ArrayList;
        r2 = kotlin.collections.CollectionsKt.b(r10);
        r1.<init>(r2);
        r1 = (java.util.Collection) r1;
        r10 = r10.iterator();
        r2 = 0;
        r3 = r2;
        r4 = r3;
    L_0x0028:
        r5 = r10.hasNext();
        if (r5 == 0) goto L_0x00f8;
    L_0x002e:
        r5 = r10.next();
        r5 = (java.util.Map) r5;
        r6 = new com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel$LinkCause;
        r7 = "cause";
        r7 = r5.get(r7);
        r8 = r7 instanceof java.lang.String;
        if (r8 != 0) goto L_0x0041;
    L_0x0040:
        r7 = r2;
    L_0x0041:
        r7 = (java.lang.String) r7;
        r6.<init>(r7);
        r7 = "kind";
        r7 = r5.get(r7);
        if (r7 != 0) goto L_0x0056;
    L_0x004e:
        r10 = new kotlin.TypeCastException;
        r0 = "null cannot be cast to non-null type kotlin.String";
        r10.<init>(r0);
        throw r10;
    L_0x0056:
        r7 = (java.lang.String) r7;
        r8 = "data";
        r5 = r5.get(r8);
        if (r5 != 0) goto L_0x0068;
    L_0x0060:
        r10 = new kotlin.TypeCastException;
        r0 = "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>";
        r10.<init>(r0);
        throw r10;
    L_0x0068:
        r5 = (java.util.Map) r5;
        r8 = r7.hashCode();
        switch(r8) {
            case 3646: goto L_0x00b9;
            case 3647: goto L_0x0093;
            case 3648: goto L_0x0071;
            case 3649: goto L_0x0072;
            default: goto L_0x0071;
        };
    L_0x0071:
        goto L_0x00e2;
    L_0x0072:
        r3 = "t5";
        r3 = r7.equals(r3);
        if (r3 == 0) goto L_0x00e2;
    L_0x007a:
        r3 = INSTANCE;
        r3 = r3.getSubredditAdapter();
        r3 = r3.fromJsonValue(r5);
        r3 = (com.reddit.frontpage.domain.model.Subreddit) r3;
        r7 = INSTANCE;
        r5 = r7.parseLinks(r5, r6);
        r5 = (java.util.Collection) r5;
        r5 = r0.addAll(r5);
        goto L_0x00d9;
    L_0x0093:
        r6 = "t3";
        r6 = r7.equals(r6);
        if (r6 == 0) goto L_0x00e2;
    L_0x009b:
        r6 = INSTANCE;
        r6 = r6.getLinkAdapter();
        r5 = r6.fromJsonValue(r5);
        if (r5 != 0) goto L_0x00aa;
    L_0x00a7:
        kotlin.jvm.internal.Intrinsics.a();
    L_0x00aa:
        r6 = com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel.LinkCause.Companion;
        r6 = r6.none();
        r5 = kotlin.TuplesKt.a(r5, r6);
        r5 = r0.add(r5);
        goto L_0x00d9;
    L_0x00b9:
        r4 = "t2";
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x00e2;
    L_0x00c1:
        r4 = INSTANCE;
        r4 = r4.getAccountAdapter();
        r4 = r4.fromJsonValue(r5);
        r4 = (com.reddit.datalibrary.frontpage.data.model.Account) r4;
        r7 = INSTANCE;
        r5 = r7.parseLinks(r5, r6);
        r5 = (java.util.Collection) r5;
        r5 = r0.addAll(r5);
    L_0x00d9:
        r5 = java.lang.Boolean.valueOf(r5);
        r1.add(r5);
        goto L_0x0028;
    L_0x00e2:
        r10 = new java.lang.RuntimeException;
        r0 = new java.lang.StringBuilder;
        r1 = "Unsupported kind ";
        r0.<init>(r1);
        r0.append(r7);
        r0 = r0.toString();
        r10.<init>(r0);
        r10 = (java.lang.Throwable) r10;
        throw r10;
    L_0x00f8:
        r10 = new com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel;
        r10.<init>(r0, r3, r4);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.common.converter.DiscoveryUnitListingDataModelJsonAdapter.convert(com.reddit.datalibrary.frontpage.data.common.converter.DiscoveryUnitListingDataModelJsonAdapter$Listing):com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel");
    }

    @ToJson
    public final void convert(JsonWriter jsonWriter, DiscoveryUnitListingDataModel discoveryUnitListingDataModel) {
        Intrinsics.b(discoveryUnitListingDataModel, "model");
        throw ((Throwable) new UnsupportedOperationException("Not supported"));
    }

    private final List<Pair<Link, LinkCause>> parseLinks(Map<String, ? extends Object> map, LinkCause linkCause) {
        JsonAdapter a = new Builder().a().a(Link.class);
        map = map.get(KEY_POSTS);
        if (map == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        }
        map = map.get(KEY_DATA);
        if (map == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        }
        map = map.get(KEY_CHILDREN);
        if (map == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.Any>>");
        }
        Iterable<Map> iterable = (List) map;
        Collection arrayList = new ArrayList(CollectionsKt.b(iterable));
        for (Map map2 : iterable) {
            Object fromJsonValue = a.fromJsonValue(map2.get(KEY_DATA));
            if (fromJsonValue == null) {
                Intrinsics.a();
            }
            arrayList.add(TuplesKt.a(fromJsonValue, linkCause));
        }
        return (List) arrayList;
    }
}
