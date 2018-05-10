package com.reddit.datalibrary.frontpage.data.common.converter;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.RemoteSearchResult;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.frontpage.domain.model.AccountSearchResultItem;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.model.SubredditSearchResultItem;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Moshi.Builder;
import com.squareup.moshi.ToJson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u001a\u0010\u0015\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\b8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/RemoteSearchResultJsonAdapter;", "", "()V", "FIELD_SUBSCRIBERS", "", "KEY_DATA", "KEY_KIND", "accountAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "getAccountAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "accountAdapter$delegate", "Lkotlin/Lazy;", "moshi", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "subredditAdapter", "Lcom/reddit/frontpage/domain/model/Subreddit;", "getSubredditAdapter", "subredditAdapter$delegate", "convert", "Lcom/reddit/datalibrary/frontpage/data/model/RemoteSearchResult;", "listing", "Lcom/reddit/datalibrary/frontpage/data/common/converter/RemoteSearchResultJsonAdapter$Listing;", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "model", "Data", "Listing", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteSearchResultJsonAdapter.kt */
public final class RemoteSearchResultJsonAdapter {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(RemoteSearchResultJsonAdapter.class), "subredditAdapter", "getSubredditAdapter()Lcom/squareup/moshi/JsonAdapter;")), Reflection.a(new PropertyReference1Impl(Reflection.a(RemoteSearchResultJsonAdapter.class), "accountAdapter", "getAccountAdapter()Lcom/squareup/moshi/JsonAdapter;"))};
    private static final String FIELD_SUBSCRIBERS = "subscribers";
    public static final RemoteSearchResultJsonAdapter INSTANCE = new RemoteSearchResultJsonAdapter();
    private static final String KEY_DATA = "data";
    private static final String KEY_KIND = "kind";
    private static final Lazy accountAdapter$delegate = LazyKt.a(RemoteSearchResultJsonAdapter$accountAdapter$2.INSTANCE);
    private static final Moshi moshi = new Builder().a();
    private static final Lazy subredditAdapter$delegate = LazyKt.a(RemoteSearchResultJsonAdapter$subredditAdapter$2.INSTANCE);

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003¢\u0006\u0002\u0010\u0006J\u001b\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003HÆ\u0003J%\u0010\n\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/RemoteSearchResultJsonAdapter$Data;", "", "children", "", "", "", "(Ljava/util/List;)V", "getChildren", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RemoteSearchResultJsonAdapter.kt */
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
            Intrinsics.b(list, "children");
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
            Intrinsics.b(list, "children");
            this.children = list;
        }

        public final List<Map<String, Object>> getChildren() {
            return this.children;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/RemoteSearchResultJsonAdapter$Listing;", "", "kind", "", "data", "Lcom/reddit/datalibrary/frontpage/data/common/converter/RemoteSearchResultJsonAdapter$Data;", "(Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/data/common/converter/RemoteSearchResultJsonAdapter$Data;)V", "getData", "()Lcom/reddit/datalibrary/frontpage/data/common/converter/RemoteSearchResultJsonAdapter$Data;", "getKind", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RemoteSearchResultJsonAdapter.kt */
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
            Intrinsics.b(str, RemoteSearchResultJsonAdapter.KEY_KIND);
            Intrinsics.b(data, RemoteSearchResultJsonAdapter.KEY_DATA);
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
            Intrinsics.b(str, RemoteSearchResultJsonAdapter.KEY_KIND);
            Intrinsics.b(data, RemoteSearchResultJsonAdapter.KEY_DATA);
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

    private final JsonAdapter<Subreddit> getSubredditAdapter() {
        return (JsonAdapter) subredditAdapter$delegate.b();
    }

    private RemoteSearchResultJsonAdapter() {
    }

    @FromJson
    public final RemoteSearchResult convert(Listing listing) {
        Intrinsics.b(listing, "listing");
        List arrayList = new ArrayList();
        for (Map map : listing.getData().getChildren()) {
            Map map2;
            Object obj = map2.get(KEY_KIND);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            String str = (String) obj;
            Object obj2 = map2.get(KEY_DATA);
            if (obj2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
            }
            map2 = (Map) obj2;
            int hashCode = str.hashCode();
            if (hashCode != 3646) {
                if (hashCode == 3649) {
                    if (str.equals(Kind.SUBREDDIT)) {
                        if (map2.get(FIELD_SUBSCRIBERS) != null) {
                            obj2 = INSTANCE.getSubredditAdapter().fromJsonValue(map2);
                            if (obj2 == null) {
                                Intrinsics.a();
                            }
                            Subreddit subreddit = (Subreddit) obj2;
                            Intrinsics.a(subreddit, "subreddit");
                            arrayList.add(new SubredditSearchResultItem(subreddit));
                        }
                    }
                }
            } else if (str.equals(Kind.ACCOUNT)) {
                obj2 = INSTANCE.getAccountAdapter().fromJsonValue(map2);
                if (obj2 == null) {
                    Intrinsics.a();
                }
                Account account = (Account) obj2;
                Intrinsics.a(account, "account");
                arrayList.add(new AccountSearchResultItem(account));
            }
            StringBuilder stringBuilder = new StringBuilder("Unsupported kind ");
            stringBuilder.append(str);
            throw ((Throwable) new RuntimeException(stringBuilder.toString()));
        }
        return new RemoteSearchResult(arrayList);
    }

    @ToJson
    public final void convert(JsonWriter jsonWriter, RemoteSearchResult remoteSearchResult) {
        Intrinsics.b(remoteSearchResult, "model");
        throw ((Throwable) new UnsupportedOperationException("Not supported"));
    }
}
