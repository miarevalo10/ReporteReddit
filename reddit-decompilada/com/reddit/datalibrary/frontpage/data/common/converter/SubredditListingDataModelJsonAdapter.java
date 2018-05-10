package com.reddit.datalibrary.frontpage.data.common.converter;

import com.reddit.datalibrary.frontpage.data.feature.subreddit.AccountSubredditMapper;
import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.Envelope;
import com.reddit.datalibrary.frontpage.data.model.SubredditListingDataModel;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.frontpage.domain.model.Subreddit;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Token;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Moshi.Builder;
import com.squareup.moshi.Types;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000Rb\u0010\u0005\u001aV\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b \n*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00070\u0007 \n**\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b \n*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000Rb\u0010\r\u001aV\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\b \n*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\b\u0018\u00010\u00070\u0007 \n**\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\b \n*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\b\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/SubredditListingDataModelJsonAdapter;", "", "()V", "KEY_KIND", "", "accountAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "Lcom/reddit/datalibrary/frontpage/data/model/Envelope;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "kotlin.jvm.PlatformType", "moshi", "Lcom/squareup/moshi/Moshi;", "subredditAdapter", "Lcom/reddit/frontpage/domain/model/Subreddit;", "fromJson", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditListingDataModel;", "reader", "Lcom/squareup/moshi/JsonReader;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditListingDataModelJsonAdapter.kt */
public final class SubredditListingDataModelJsonAdapter {
    public static final SubredditListingDataModelJsonAdapter INSTANCE = new SubredditListingDataModelJsonAdapter();
    private static final String KEY_KIND = "kind";
    private static final JsonAdapter<List<Envelope<Account>>> accountAdapter;
    private static final Moshi moshi;
    private static final JsonAdapter<List<Envelope<Subreddit>>> subredditAdapter;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Token.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Token.a.ordinal()] = 1;
            $EnumSwitchMapping$0[Token.b.ordinal()] = 2;
            $EnumSwitchMapping$0[Token.c.ordinal()] = 3;
            $EnumSwitchMapping$0[Token.d.ordinal()] = 4;
        }
    }

    static {
        Moshi a = new Builder().a();
        moshi = a;
        Type type = List.class;
        Type[] typeArr = new Type[1];
        typeArr[0] = Types.a(Envelope.class, new Type[]{Subreddit.class});
        subredditAdapter = a.a(Types.a(type, typeArr));
        a = moshi;
        type = List.class;
        typeArr = new Type[1];
        typeArr[0] = Types.a(Envelope.class, new Type[]{Account.class});
        accountAdapter = a.a(Types.a(type, typeArr));
    }

    private SubredditListingDataModelJsonAdapter() {
    }

    @FromJson
    public final SubredditListingDataModel fromJson(JsonReader jsonReader) {
        Intrinsics.b(jsonReader, "reader");
        while (jsonReader.e()) {
            Token f = jsonReader.f();
            if (f != null) {
                switch (WhenMappings.$EnumSwitchMapping$0[f.ordinal()]) {
                    case 1:
                        String o = jsonReader.o();
                        String str = null;
                        List list = (List) (!(o instanceof List) ? null : o);
                        if (list != null) {
                            Map map = (Map) CollectionsKt.e(list);
                            if (map != null) {
                                str = (String) map.get(KEY_KIND);
                            }
                        }
                        if (str != null) {
                            int hashCode = str.hashCode();
                            Collection arrayList;
                            Object data;
                            if (hashCode != 3646) {
                                if (hashCode == 3649) {
                                    if (str.equals(Kind.SUBREDDIT)) {
                                        List list2 = (List) subredditAdapter.fromJsonValue(o);
                                        if (list2 != null) {
                                            Intrinsics.a(list2, "subreddits");
                                            Iterable<Envelope> iterable = list2;
                                            arrayList = new ArrayList(CollectionsKt.b(iterable));
                                            for (Envelope data2 : iterable) {
                                                data = data2.getData();
                                                if (data == null) {
                                                    Intrinsics.a();
                                                }
                                                arrayList.add((Subreddit) data);
                                            }
                                            return new SubredditListingDataModel((List) arrayList);
                                        }
                                        continue;
                                    }
                                }
                            } else if (str.equals(Kind.ACCOUNT) != null) {
                                jsonReader = accountAdapter.fromJsonValue(o);
                                if (jsonReader == null) {
                                    Intrinsics.a();
                                }
                                List list3 = (List) jsonReader;
                                Intrinsics.a(list3, "accounts");
                                Iterable<Envelope> iterable2 = list3;
                                arrayList = new ArrayList(CollectionsKt.b(iterable2));
                                for (Envelope data22 : iterable2) {
                                    AccountSubredditMapper accountSubredditMapper = AccountSubredditMapper.f10773a;
                                    data = data22.getData();
                                    if (data == null) {
                                        Intrinsics.a();
                                    }
                                    arrayList.add(AccountSubredditMapper.m9096a((Account) data));
                                }
                                return new SubredditListingDataModel((List) arrayList);
                            }
                        }
                        StringBuilder stringBuilder = new StringBuilder("SubredditListing kind ");
                        stringBuilder.append(str);
                        stringBuilder.append(" is unsupported");
                        throw ((Throwable) new IllegalStateException(stringBuilder.toString()));
                    case 2:
                        jsonReader.b();
                        continue;
                    case 3:
                        jsonReader.c();
                        continue;
                    case 4:
                        jsonReader.d();
                        continue;
                    default:
                        break;
                }
            }
            jsonReader.n();
        }
        throw ((Throwable) new IllegalStateException("Failed to parse SubredditListingDataModel!"));
    }
}
