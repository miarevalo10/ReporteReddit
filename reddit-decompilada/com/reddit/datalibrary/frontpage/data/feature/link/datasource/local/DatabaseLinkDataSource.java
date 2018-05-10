package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.kotlinextensions.OperatorExtensionsKt;
import com.raizlabs.android.dbflow.kotlinextensions.QueryExtensionsKt;
import com.raizlabs.android.dbflow.sql.language.BaseModelQueriable;
import com.raizlabs.android.dbflow.sql.language.From;
import com.raizlabs.android.dbflow.sql.language.IConditional;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.sql.language.Set;
import com.raizlabs.android.dbflow.sql.language.Update;
import com.raizlabs.android.dbflow.sql.language.Where;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.language.property.WrapperProperty;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.reddit.common.dbflow.DatabaseDefinitionsKt;
import com.reddit.datalibrary.frontpage.data.common.PropertyUtilsKt;
import com.reddit.datalibrary.frontpage.data.common.RxModelQueriablesKt;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.model.LinkDataModel;
import com.reddit.datalibrary.frontpage.data.model.LinkDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.LinkMutationsDataModel;
import com.reddit.datalibrary.frontpage.data.model.LinkMutationsDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.data.model.ListingDataModel;
import com.reddit.datalibrary.frontpage.data.model.ListingDataModel_Table;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016JH\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0010H\u0002J(\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J2\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0016J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00180\u00172\u0006\u0010&\u001a\u00020\u0010H\u0016JF\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0010H\u0002J:\u0010(\u001a\u00020)2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0010H\u0002J2\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0016J\u0014\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00180,H\u0016J8\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00180\u00172\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010.\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010/\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u00100\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J:\u00101\u001a\b\u0012\u0004\u0012\u0002020,2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0016J$\u00104\u001a\b\u0012\u0004\u0012\u0002020,2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010&\u001a\u00020\u0010H\u0016JH\u00105\u001a\u00020\u00122\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0010H\u0002J:\u00106\u001a\b\u0012\u0004\u0012\u0002020,2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0016J@\u00107\u001a\b\u0012\u0004\u0012\u0002020,2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u00108\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u00109\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u0007H\u0016J%\u0010<\u001a\u00020\r*\u00020=2\u0017\u0010>\u001a\u0013\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u00120?¢\u0006\u0002\b@H\u0002R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/DatabaseLinkDataSource;", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LocalLinkDataSource;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/reddit/frontpage/domain/model/Link;", "getAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "clearReadLinks", "Lio/reactivex/Completable;", "linkIds", "", "", "connectLinkWithMutation", "", "linkId", "connectLinksWithMutations", "delete", "getAllFrontpageLinks", "Lio/reactivex/Maybe;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "getAllLinks", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "after", "username", "getAllPopularLinks", "getFrontpageLinks", "getLinkById", "getLinkListing", "path", "getLinks", "getListingDeleteStatement", "Lcom/raizlabs/android/dbflow/sql/language/OperatorGroup;", "getPopularLinks", "getReadLinks", "Lio/reactivex/Single;", "getUserSubmittedPosts", "hide", "markLinkAsRead", "save", "saveFrontpageLinks", "", "links", "saveLinkListing", "saveLinks", "savePopularLinks", "saveUserSubmittedPosts", "unhide", "unsave", "updateLink", "link", "mutate", "Lcom/reddit/datalibrary/frontpage/data/model/LinkMutationsDataModel;", "mutation", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DatabaseLinkDataSource.kt */
public final class DatabaseLinkDataSource implements LocalLinkDataSource {
    static final /* synthetic */ KProperty[] f16028a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(DatabaseLinkDataSource.class), "adapter", "getAdapter()Lcom/squareup/moshi/JsonAdapter;"))};
    private final Lazy f16029b = LazyKt.a((Function0) new DatabaseLinkDataSource$adapter$2(this));
    private final Moshi f16030c;

    private final JsonAdapter<Link> m15966b() {
        return (JsonAdapter) this.f16029b.b();
    }

    public DatabaseLinkDataSource(Moshi moshi) {
        Intrinsics.b(moshi, "moshi");
        this.f16030c = moshi;
    }

    public final Maybe<Listing<Link>> mo2958a(String str, SortType sortType, String str2, SortTimeFrame sortTimeFrame) {
        Intrinsics.b(str, "username");
        Intrinsics.b(sortType, "sort");
        return m15958a(sortType, sortTimeFrame, str2, ListingType.c, null);
    }

    public final Maybe<Listing<Link>> mo2956a(SortType sortType, SortTimeFrame sortTimeFrame, String str) {
        return m15958a(sortType, sortTimeFrame, str, ListingType.a, null);
    }

    public final Maybe<Listing<Link>> mo2965b(SortType sortType, SortTimeFrame sortTimeFrame, String str) {
        return m15958a(sortType, sortTimeFrame, str, ListingType.b, null);
    }

    public final Maybe<Listing<Link>> mo2957a(String str) {
        Intrinsics.b(str, "path");
        throw ((Throwable) new UnsupportedOperationException());
    }

    public final Single<Boolean> mo2961a(Listing<Link> listing, String str) {
        Intrinsics.b(listing, "links");
        Intrinsics.b(str, "path");
        throw ((Throwable) new UnsupportedOperationException());
    }

    public final Maybe<Listing<Link>> mo2955a(SortType sortType, SortTimeFrame sortTimeFrame) {
        return m15957a(sortType, sortTimeFrame, ListingType.a, null, null);
    }

    public final Maybe<Listing<Link>> mo2964b(SortType sortType, SortTimeFrame sortTimeFrame) {
        return m15957a(sortType, sortTimeFrame, ListingType.b, null, null);
    }

    public final Completable mo2963b(String str) {
        Intrinsics.b(str, "linkId");
        return m15956a(new LinkMutationsDataModel(str, false, 0, false, false, 30, null), (Function1) DatabaseLinkDataSource$markLinkAsRead$1.f19371a);
    }

    public final Completable mo2954a(Iterable<String> iterable) {
        Intrinsics.b(iterable, "linkIds");
        iterable = Observable.fromIterable(iterable).flatMapCompletable(new DatabaseLinkDataSource$clearReadLinks$1(this));
        Intrinsics.a(iterable, "Observable.fromIterable(…lse\n          }\n        }");
        return iterable;
    }

    public final Completable mo2967c(String str) {
        Intrinsics.b(str, "linkId");
        return m15956a(new LinkMutationsDataModel(str, false, 0, false, false, 30, null), (Function1) DatabaseLinkDataSource$hide$1.f19370a);
    }

    public final Completable mo2968d(String str) {
        Intrinsics.b(str, "linkId");
        return m15956a(new LinkMutationsDataModel(str, false, 0, false, false, 30, null), (Function1) DatabaseLinkDataSource$unhide$1.f19391a);
    }

    public final Completable mo2970f(String str) {
        Intrinsics.b(str, "linkId");
        str = QueryExtensionsKt.delete(Reflection.a(LinkDataModel.class)).where(LinkDataModel_Table.linkId.eq((Object) str));
        Intrinsics.a(str, "delete(LinkDataModel::cl…_Table.linkId.eq(linkId))");
        str = com.raizlabs.android.dbflow.rx2.kotlinextensions.QueryExtensionsKt.rx((ModelQueriable) str).execute();
        Intrinsics.a(str, "delete(LinkDataModel::cl… .rx()\n        .execute()");
        return str;
    }

    private final Maybe<Listing<Link>> m15957a(SortType sortType, SortTimeFrame sortTimeFrame, ListingType listingType, String str, String str2) {
        SortType sortType2 = sortType;
        SortTimeFrame sortTimeFrame2 = sortTimeFrame;
        ListingType listingType2 = listingType;
        String str3 = str2;
        sortType = ((Maybe) new DatabaseLinkDataSource$getAllLinks$fetch$1(this, sortType2, sortTimeFrame2, listingType2, str3).a(str)).flatMap(new DatabaseLinkDataSource$getAllLinks$1(this, sortType2, sortTimeFrame2, listingType2, str3));
        Intrinsics.a(sortType, "fetch(after).flatMap { l…t(listing))\n      }\n    }");
        return sortType;
    }

    public final Single<Boolean> mo2962a(Listing<Link> listing, String str, SortType sortType, String str2, SortTimeFrame sortTimeFrame) {
        Intrinsics.b(listing, "links");
        Intrinsics.b(str, "username");
        Intrinsics.b(sortType, "sort");
        return DatabaseDefinitionsKt.m8723a(FlowManager.getDatabase(RedditFlowDatabase.class), (Function0) new DatabaseLinkDataSource$saveUserSubmittedPosts$1(this, listing, sortType, sortTimeFrame, str2, str));
    }

    public final Single<Boolean> mo2960a(Listing<Link> listing, SortType sortType, SortTimeFrame sortTimeFrame, String str) {
        Intrinsics.b(listing, "links");
        return DatabaseDefinitionsKt.m8723a(FlowManager.getDatabase(RedditFlowDatabase.class), (Function0) new DatabaseLinkDataSource$saveFrontpageLinks$1(this, listing, sortType, sortTimeFrame, str));
    }

    public final Single<Boolean> mo2966b(Listing<Link> listing, SortType sortType, SortTimeFrame sortTimeFrame, String str) {
        Intrinsics.b(listing, "links");
        return DatabaseDefinitionsKt.m8723a(FlowManager.getDatabase(RedditFlowDatabase.class), (Function0) new DatabaseLinkDataSource$savePopularLinks$1(this, listing, sortType, sortTimeFrame, str));
    }

    public final Single<Listing<Link>> mo2959a() {
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        select = select.distinct();
        Intrinsics.a(select, "select.distinct()");
        Where orderBy = QueryExtensionsKt.innerJoin(QueryExtensionsKt.from(select, Reflection.a(LinkDataModel.class)), Reflection.a(LinkMutationsDataModel.class)).on(LinkDataModel_Table.linkId.withTable().eq((IConditional) LinkMutationsDataModel_Table.linkId.withTable())).where(LinkMutationsDataModel_Table.isRead.eq(Boolean.valueOf(true))).and(LinkMutationsDataModel_Table.isHidden.eq(Boolean.valueOf(false))).orderBy(LinkMutationsDataModel_Table.readTimestampUtc.desc());
        Intrinsics.a(orderBy, "select.distinct().from(L….readTimestampUtc.desc())");
        Single<Listing<Link>> map = com.raizlabs.android.dbflow.rx2.kotlinextensions.QueryExtensionsKt.rx((ModelQueriable) orderBy).queryList().map(new DatabaseLinkDataSource$getReadLinks$1(this)).map(DatabaseLinkDataSource$getReadLinks$2.f16026a);
        Intrinsics.a(map, "select.distinct().from(L…hildren = list)\n        }");
        return map;
    }

    public final Maybe<Link> mo2969e(String str) {
        Intrinsics.b(str, "linkId");
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        str = QueryExtensionsKt.from(select, Reflection.a(LinkDataModel.class)).where(LinkDataModel_Table.linkId.eq((Object) str)).limit(1);
        Intrinsics.a(str, "select.from(LinkDataMode…(linkId))\n      .limit(1)");
        str = RxModelQueriablesKt.m8757b(com.raizlabs.android.dbflow.rx2.kotlinextensions.QueryExtensionsKt.rx((ModelQueriable) str)).map(new DatabaseLinkDataSource$getLinkById$1(this));
        Intrinsics.a(str, "select.from(LinkDataMode…erter.from(it, adapter) }");
        return str;
    }

    public final Completable mo2953a(Link link) {
        Intrinsics.b(link, "link");
        link = SQLite.update(LinkDataModel.class).set(LinkDataModel_Table.linkJson.eq(m15966b().toJson(link))).where(LinkDataModel_Table.linkId.eq(link.getId()));
        Intrinsics.a(link, "update<LinkDataModel>()\n…Table.linkId.eq(link.id))");
        link = com.raizlabs.android.dbflow.rx2.kotlinextensions.QueryExtensionsKt.rx((ModelQueriable) link).execute();
        Intrinsics.a(link, "update<LinkDataModel>()\n…   .rx()\n      .execute()");
        return link;
    }

    private final void m15965a(Listing<Link> listing, SortType sortType, SortTimeFrame sortTimeFrame, String str, ListingType listingType, String str2) {
        String str3 = str;
        From delete = SQLite.delete(ListingDataModel.class);
        SQLOperator[] sQLOperatorArr = new SQLOperator[1];
        WrapperProperty wrapperProperty = ListingDataModel_Table.sort;
        Intrinsics.a(wrapperProperty, "ListingDataModel_Table.sort");
        SortType sortType2 = sortType;
        Operator a = PropertyUtilsKt.m8755a(wrapperProperty, sortType2);
        WrapperProperty wrapperProperty2 = ListingDataModel_Table.sortTimeFrame;
        Intrinsics.a(wrapperProperty2, "ListingDataModel_Table.sortTimeFrame");
        SortTimeFrame sortTimeFrame2 = sortTimeFrame;
        ListingType listingType2 = listingType;
        OperatorGroup and = OperatorExtensionsKt.and(a, (SQLOperator) PropertyUtilsKt.m8755a(wrapperProperty2, sortTimeFrame2)).and(ListingDataModel_Table.listingType.eq((Object) listingType2));
        Property property = ListingDataModel_Table.username;
        Intrinsics.a(property, "ListingDataModel_Table.username");
        and = and.and(PropertyUtilsKt.m8755a(property, str2));
        if (str3 != null) {
            property = ListingDataModel_Table.before;
            Intrinsics.a(property, "ListingDataModel_Table.before");
            and.and(PropertyUtilsKt.m8755a(property, str3));
        }
        Intrinsics.a(and, "operatorGroup");
        sQLOperatorArr[0] = and;
        delete.where(sQLOperatorArr).execute();
        ListingDataModel listingDataModel = new ListingDataModel(0, sortType2, sortTimeFrame2, str3, listing.getAfter(), listing.getAdDistance(), null, listingType2, 65, null);
        Iterable<Link> children = listing.getChildren();
        Collection arrayList = new ArrayList(CollectionsKt.b(children));
        int i = 0;
        for (Link link : children) {
            int i2 = i + 1;
            LinkDataModelConverter linkDataModelConverter = LinkDataModelConverter.f10654a;
            arrayList.add(LinkDataModelConverter.m8951a(i, link, m15966b(), listingDataModel));
            i = i2;
        }
        listingDataModel.setLinks((List) arrayList);
        listingDataModel.save();
        Update update = SQLite.update(LinkDataModel.class);
        sQLOperatorArr = new SQLOperator[1];
        Property property2 = LinkDataModel_Table.mutations_linkId;
        Select select = SQLite.select(LinkMutationsDataModel_Table.linkId);
        Intrinsics.a(select, "SQLite.select(LinkMutationsDataModel_Table.linkId)");
        sQLOperatorArr[0] = property2.eq((BaseModelQueriable) QueryExtensionsKt.from(select, Reflection.a(LinkMutationsDataModel.class)).where(LinkMutationsDataModel_Table.linkId.withTable().eq((IConditional) LinkDataModel_Table.linkId.withTable())));
        Set set = update.set(sQLOperatorArr);
        sQLOperatorArr = new SQLOperator[1];
        property2 = LinkDataModel_Table.linkId.withTable();
        select = SQLite.select(LinkMutationsDataModel_Table.linkId);
        Intrinsics.a(select, "SQLite.select(LinkMutationsDataModel_Table.linkId)");
        sQLOperatorArr[0] = property2.in((BaseModelQueriable) QueryExtensionsKt.from(select, Reflection.a(LinkMutationsDataModel.class)).where(LinkMutationsDataModel_Table.linkId.withTable().eq((IConditional) LinkDataModel_Table.linkId.withTable())), new BaseModelQueriable[0]);
        set.where(sQLOperatorArr).execute();
    }

    private final Maybe<Listing<Link>> m15958a(SortType sortType, SortTimeFrame sortTimeFrame, String str, ListingType listingType, String str2) {
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        From from = QueryExtensionsKt.from(select, Reflection.a(ListingDataModel.class));
        SQLOperator[] sQLOperatorArr = new SQLOperator[1];
        WrapperProperty wrapperProperty = ListingDataModel_Table.sort;
        Intrinsics.a(wrapperProperty, "ListingDataModel_Table.sort");
        sQLOperatorArr[0] = PropertyUtilsKt.m8755a(wrapperProperty, sortType);
        sortType = from.where(sQLOperatorArr);
        WrapperProperty wrapperProperty2 = ListingDataModel_Table.sortTimeFrame;
        Intrinsics.a(wrapperProperty2, "ListingDataModel_Table.sortTimeFrame");
        sortType = sortType.and(PropertyUtilsKt.m8755a(wrapperProperty2, sortTimeFrame));
        sortTimeFrame = ListingDataModel_Table.before;
        Intrinsics.a(sortTimeFrame, "ListingDataModel_Table.before");
        sortType = sortType.and(PropertyUtilsKt.m8755a(sortTimeFrame, str)).and(ListingDataModel_Table.listingType.eq((Object) listingType));
        sortTimeFrame = ListingDataModel_Table.username;
        Intrinsics.a(sortTimeFrame, "ListingDataModel_Table.username");
        sortType = sortType.and(PropertyUtilsKt.m8755a(sortTimeFrame, str2));
        Intrinsics.a(sortType, "select.from(ListingDataM…ame.eqOrIsNull(username))");
        sortType = RxModelQueriablesKt.m8757b(com.raizlabs.android.dbflow.rx2.kotlinextensions.QueryExtensionsKt.rx((ModelQueriable) sortType)).map((Function) new DatabaseLinkDataSource$getLinks$1(this));
        Intrinsics.a(sortType, "select.from(ListingDataM…erter.from(it, adapter) }");
        return sortType;
    }

    private final Completable m15956a(LinkMutationsDataModel linkMutationsDataModel, Function1<? super LinkMutationsDataModel, Unit> function1) {
        linkMutationsDataModel = DatabaseDefinitionsKt.m8723a(FlowManager.getDatabase(RedditFlowDatabase.class), (Function0) new DatabaseLinkDataSource$mutate$1(this, linkMutationsDataModel, function1)).flatMapCompletable((Function) DatabaseLinkDataSource$mutate$2.f16027a);
        Intrinsics.a(linkMutationsDataModel, "database<RedditFlowDatab…lse Completable.never() }");
        return linkMutationsDataModel;
    }
}
