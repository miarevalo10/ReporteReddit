package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import android.content.Context;
import com.reddit.datalibrary.frontpage.data.feature.common.Key;
import com.reddit.datalibrary.frontpage.data.feature.common.PersistDataSourceUtil;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020*H\u0016J(\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J(\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J2\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u00010*H\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\n0.2\u0006\u0010,\u001a\u00020*H\u0016J\u001c\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0.2\u0006\u00108\u001a\u00020*H\u0016J2\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u00010*H\u0016J\u0014\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0;H\u0016J8\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0.2\u0006\u0010=\u001a\u00020*2\u0006\u0010/\u001a\u0002002\b\u00105\u001a\u0004\u0018\u00010*2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010>\u001a\u00020'2\u0006\u0010,\u001a\u00020*H\u0016J\u0010\u0010?\u001a\u00020'2\u0006\u0010,\u001a\u00020*H\u0016J\u0010\u0010@\u001a\u00020'2\u0006\u0010,\u001a\u00020*H\u0016J:\u0010A\u001a\b\u0012\u0004\u0012\u00020B0;2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u00010*H\u0016J$\u0010D\u001a\b\u0012\u0004\u0012\u00020B0;2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u00108\u001a\u00020*H\u0016J:\u0010E\u001a\b\u0012\u0004\u0012\u00020B0;2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u00010*H\u0016J@\u0010F\u001a\b\u0012\u0004\u0012\u00020B0;2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010=\u001a\u00020*2\u0006\u0010/\u001a\u0002002\b\u00105\u001a\u0004\u0018\u00010*2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010G\u001a\u00020'2\u0006\u0010,\u001a\u00020*H\u0016J\u0010\u0010H\u001a\u00020'2\u0006\u0010,\u001a\u00020*H\u0016J\u0010\u0010I\u001a\u00020'2\u0006\u0010J\u001a\u00020\nH\u0016R'\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00158BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001c0\u00158BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001d\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b \u0010\u0012R'\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020#0\u00158BX\u0002¢\u0006\f\n\u0004\b%\u0010\u000e\u001a\u0004\b$\u0010\u0019¨\u0006K"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/FileLinkDataSource;", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LocalLinkDataSource;", "moshi", "Lcom/squareup/moshi/Moshi;", "context", "Landroid/content/Context;", "(Lcom/squareup/moshi/Moshi;Landroid/content/Context;)V", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "getAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "linkDir", "Ljava/io/File;", "getLinkDir", "()Ljava/io/File;", "linkDir$delegate", "linkListingPersister", "Lcom/nytimes/android/external/store3/base/Persister;", "Lokio/BufferedSource;", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LinkListingKey;", "getLinkListingPersister", "()Lcom/nytimes/android/external/store3/base/Persister;", "linkListingPersister$delegate", "linkPersister", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LinkKey;", "getLinkPersister", "linkPersister$delegate", "submittedLinkDir", "getSubmittedLinkDir", "submittedLinkDir$delegate", "submittedPersister", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/UserLinkKey;", "getSubmittedPersister", "submittedPersister$delegate", "clearReadLinks", "Lio/reactivex/Completable;", "linkIds", "", "", "delete", "linkId", "getAllFrontpageLinks", "Lio/reactivex/Maybe;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "getAllPopularLinks", "getFrontpageLinks", "after", "getLinkById", "getLinkListing", "path", "getPopularLinks", "getReadLinks", "Lio/reactivex/Single;", "getUserSubmittedPosts", "username", "hide", "markLinkAsRead", "save", "saveFrontpageLinks", "", "links", "saveLinkListing", "savePopularLinks", "saveUserSubmittedPosts", "unhide", "unsave", "updateLink", "link", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FileLinkDataSource.kt */
public final class FileLinkDataSource implements LocalLinkDataSource {
    static final /* synthetic */ KProperty[] f16034a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(FileLinkDataSource.class), "submittedLinkDir", "getSubmittedLinkDir()Ljava/io/File;")), Reflection.a(new PropertyReference1Impl(Reflection.a(FileLinkDataSource.class), "linkDir", "getLinkDir()Ljava/io/File;")), Reflection.a(new PropertyReference1Impl(Reflection.a(FileLinkDataSource.class), "adapter", "getAdapter()Lcom/squareup/moshi/JsonAdapter;")), Reflection.a(new PropertyReference1Impl(Reflection.a(FileLinkDataSource.class), "submittedPersister", "getSubmittedPersister()Lcom/nytimes/android/external/store3/base/Persister;")), Reflection.a(new PropertyReference1Impl(Reflection.a(FileLinkDataSource.class), "linkPersister", "getLinkPersister()Lcom/nytimes/android/external/store3/base/Persister;")), Reflection.a(new PropertyReference1Impl(Reflection.a(FileLinkDataSource.class), "linkListingPersister", "getLinkListingPersister()Lcom/nytimes/android/external/store3/base/Persister;"))};
    private final Lazy f16035b = LazyKt.a((Function0) new FileLinkDataSource$submittedLinkDir$2(this));
    private final Lazy f16036c = LazyKt.a((Function0) new FileLinkDataSource$linkDir$2(this));
    private final Lazy f16037d = LazyKt.a((Function0) new FileLinkDataSource$adapter$2(this));
    private final Lazy f16038e = LazyKt.a((Function0) new FileLinkDataSource$submittedPersister$2(this));
    private final Lazy f16039f = LazyKt.a((Function0) new FileLinkDataSource$linkPersister$2(this));
    private final Lazy f16040g = LazyKt.a((Function0) new FileLinkDataSource$linkListingPersister$2(this));
    private final Moshi f16041h;
    private final Context f16042i;

    private final JsonAdapter<Listing<Link>> m15992b() {
        return (JsonAdapter) this.f16037d.b();
    }

    @Inject
    public FileLinkDataSource(Moshi moshi, Context context) {
        Intrinsics.b(moshi, "moshi");
        Intrinsics.b(context, "context");
        this.f16041h = moshi;
        this.f16042i = context;
    }

    public final Maybe<Listing<Link>> mo2958a(String str, SortType sortType, String str2, SortTimeFrame sortTimeFrame) {
        Intrinsics.b(str, "username");
        Intrinsics.b(sortType, "sort");
        if ((((CharSequence) str).length() > 0 ? 1 : null) == null) {
            throw ((Throwable) new IllegalArgumentException("Please specify non-empty username".toString()));
        }
        PersistDataSourceUtil persistDataSourceUtil = PersistDataSourceUtil.f10382a;
        return PersistDataSourceUtil.m8821a(new UserLinkKey(str, sortType, str2, sortTimeFrame), LazyKt.a((Function0) new FileLinkDataSource$getUserSubmittedPosts$2(this)), m15992b());
    }

    public final Single<Boolean> mo2962a(Listing<Link> listing, String str, SortType sortType, String str2, SortTimeFrame sortTimeFrame) {
        Intrinsics.b(listing, "links");
        Intrinsics.b(str, "username");
        Intrinsics.b(sortType, "sort");
        if ((((CharSequence) str).length() > 0 ? 1 : null) == null) {
            throw ((Throwable) new IllegalArgumentException("Please specify non-empty username".toString()));
        }
        PersistDataSourceUtil persistDataSourceUtil = PersistDataSourceUtil.f10382a;
        return PersistDataSourceUtil.m8822a((Listing) listing, (Key) new UserLinkKey(str, sortType, str2, sortTimeFrame), LazyKt.a((Function0) new FileLinkDataSource$saveUserSubmittedPosts$2(this)), m15992b());
    }

    public final Single<Boolean> mo2960a(Listing<Link> listing, SortType sortType, SortTimeFrame sortTimeFrame, String str) {
        Intrinsics.b(listing, "links");
        PersistDataSourceUtil persistDataSourceUtil = PersistDataSourceUtil.f10382a;
        return PersistDataSourceUtil.m8822a((Listing) listing, (Key) new LinkKey(LinkKeyType.f10655a, sortType, sortTimeFrame, str), LazyKt.a((Function0) new FileLinkDataSource$saveFrontpageLinks$1(this)), m15992b());
    }

    public final Single<Boolean> mo2966b(Listing<Link> listing, SortType sortType, SortTimeFrame sortTimeFrame, String str) {
        Intrinsics.b(listing, "links");
        PersistDataSourceUtil persistDataSourceUtil = PersistDataSourceUtil.f10382a;
        return PersistDataSourceUtil.m8822a((Listing) listing, (Key) new LinkKey(LinkKeyType.f10656b, sortType, sortTimeFrame, str), LazyKt.a((Function0) new FileLinkDataSource$savePopularLinks$1(this)), m15992b());
    }

    public final Maybe<Listing<Link>> mo2956a(SortType sortType, SortTimeFrame sortTimeFrame, String str) {
        PersistDataSourceUtil persistDataSourceUtil = PersistDataSourceUtil.f10382a;
        return PersistDataSourceUtil.m8821a(new LinkKey(LinkKeyType.f10655a, sortType, sortTimeFrame, str), LazyKt.a((Function0) new FileLinkDataSource$getFrontpageLinks$1(this)), m15992b());
    }

    public final Maybe<Listing<Link>> mo2965b(SortType sortType, SortTimeFrame sortTimeFrame, String str) {
        PersistDataSourceUtil persistDataSourceUtil = PersistDataSourceUtil.f10382a;
        return PersistDataSourceUtil.m8821a(new LinkKey(LinkKeyType.f10656b, sortType, sortTimeFrame, str), LazyKt.a((Function0) new FileLinkDataSource$getPopularLinks$1(this)), m15992b());
    }

    public final Maybe<Listing<Link>> mo2957a(String str) {
        Intrinsics.b(str, "path");
        PersistDataSourceUtil persistDataSourceUtil = PersistDataSourceUtil.f10382a;
        return PersistDataSourceUtil.m8821a(new LinkListingKey(str), LazyKt.a((Function0) new FileLinkDataSource$getLinkListing$1(this)), m15992b());
    }

    public final Single<Boolean> mo2961a(Listing<Link> listing, String str) {
        Intrinsics.b(listing, "links");
        Intrinsics.b(str, "path");
        PersistDataSourceUtil persistDataSourceUtil = PersistDataSourceUtil.f10382a;
        return PersistDataSourceUtil.m8822a((Listing) listing, (Key) new LinkListingKey(str), LazyKt.a((Function0) new FileLinkDataSource$saveLinkListing$1(this)), m15992b());
    }

    public final Maybe<Listing<Link>> mo2955a(SortType sortType, SortTimeFrame sortTimeFrame) {
        throw ((Throwable) new UnsupportedOperationException("Not supported by current implementation"));
    }

    public final Maybe<Listing<Link>> mo2964b(SortType sortType, SortTimeFrame sortTimeFrame) {
        throw ((Throwable) new UnsupportedOperationException("Not supported by current implementation"));
    }

    public final Single<Listing<Link>> mo2959a() {
        throw new UnsupportedOperationException("Not supported by current implementation");
    }

    public final Completable mo2963b(String str) {
        Intrinsics.b(str, "linkId");
        throw ((Throwable) new UnsupportedOperationException("Not supported by current implementation"));
    }

    public final Completable mo2954a(Iterable<String> iterable) {
        Intrinsics.b(iterable, "linkIds");
        throw ((Throwable) new UnsupportedOperationException("Not supported by current implementation"));
    }

    public final Completable mo2967c(String str) {
        Intrinsics.b(str, "linkId");
        throw ((Throwable) new UnsupportedOperationException("Not supported by current implementation"));
    }

    public final Completable mo2968d(String str) {
        Intrinsics.b(str, "linkId");
        throw ((Throwable) new UnsupportedOperationException("Not supported by current implementation"));
    }

    public final Maybe<Link> mo2969e(String str) {
        Intrinsics.b(str, "linkId");
        throw ((Throwable) new UnsupportedOperationException("Not supported by current implementation"));
    }

    public final Completable mo2953a(Link link) {
        Intrinsics.b(link, "link");
        throw ((Throwable) new UnsupportedOperationException("Not supported by current implementation"));
    }

    public final Completable mo2970f(String str) {
        Intrinsics.b(str, "linkId");
        throw ((Throwable) new UnsupportedOperationException("Not supported by current implementation"));
    }
}
