package com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local;

import android.content.Context;
import com.google.common.base.Converter;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.kotlinextensions.OperatorExtensionsKt;
import com.raizlabs.android.dbflow.rx2.kotlinextensions.QueryExtensionsKt;
import com.raizlabs.android.dbflow.sql.language.From;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.sql.language.Where;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.reddit.common.dbflow.DatabaseDefinitionsKt;
import com.reddit.datalibrary.frontpage.data.common.RxModelQueriablesKt;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase;
import com.reddit.datalibrary.frontpage.data.feature.common.Key;
import com.reddit.datalibrary.frontpage.data.feature.common.PersistDataSourceUtil;
import com.reddit.datalibrary.frontpage.data.model.MultiredditDataModel;
import com.reddit.datalibrary.frontpage.data.model.RecentSubredditDataModel;
import com.reddit.datalibrary.frontpage.data.model.RecentSubredditDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.SubredditDataModel;
import com.reddit.datalibrary.frontpage.data.model.SubredditDataModel_Table;
import com.reddit.frontpage.domain.model.Multireddit;
import com.reddit.frontpage.domain.model.Subreddit;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0004<=>?B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0!H\u0016J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0!H\u0016J\u0014\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0!H\u0016J\u0014\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0!H\u0016J\u0014\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\t0!H\u0016J\u001c\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0!2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0)2\u0006\u0010*\u001a\u00020\u001eH\u0016J\u001c\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0)2\u0006\u0010,\u001a\u00020\u001eH\u0016J\u0014\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0!H\u0016J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020/0!2\u0006\u00100\u001a\u00020\nH\u0016J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020/0!2\u0006\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020/H\u0016J\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020/0!2\f\u00104\u001a\b\u0012\u0004\u0012\u00020&05H\u0016J\u001e\u00106\u001a\b\u0012\u0004\u0012\u00020/0!2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\nH\u0016J$\u00107\u001a\b\u0012\u0004\u0012\u00020/0!2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010,\u001a\u00020\u001eH\u0016J\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020/0!2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\n05H\u0016J\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020/0!2\u0006\u0010*\u001a\u00020\u001eH\u0016J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020/0!2\u0006\u0010*\u001a\u00020\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R'\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00158BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019¨\u0006@"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/local/RedditLocalSubredditDataSource;", "Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/local/LocalSubredditDataSource;", "moshi", "Lcom/squareup/moshi/Moshi;", "context", "Landroid/content/Context;", "(Lcom/squareup/moshi/Moshi;Landroid/content/Context;)V", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "getJsonAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "jsonAdapter$delegate", "Lkotlin/Lazy;", "subredditListingDir", "Ljava/io/File;", "getSubredditListingDir", "()Ljava/io/File;", "subredditListingDir$delegate", "subredditListingPersister", "Lcom/nytimes/android/external/store3/base/Persister;", "Lokio/BufferedSource;", "Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/local/RedditLocalSubredditDataSource$SubredditListingKey;", "getSubredditListingPersister", "()Lcom/nytimes/android/external/store3/base/Persister;", "subredditListingPersister$delegate", "deleteRecentSubreddit", "Lio/reactivex/Completable;", "username", "", "kindWithId", "getDefaultSubreddits", "Lio/reactivex/Single;", "getFavoriteSubreddits", "getFollowingSubreddits", "getModeratingSubreddits", "getMultireddits", "Lcom/reddit/frontpage/domain/model/Multireddit;", "getRecentSubreddits", "getSubreddit", "Lio/reactivex/Maybe;", "subredditName", "getSubredditListing", "path", "getSubscribedSubreddits", "saveFavorite", "", "subreddit", "subredditId", "favorite", "saveMultireddits", "multireddits", "", "saveOrUpdateRecentSubreddit", "saveSubredditListing", "subreddits", "saveSubreddits", "subscribeSubreddit", "unsubscribeSubreddit", "MultiredditConverter", "RecentSubredditConverter", "SubredditConverter", "SubredditListingKey", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditLocalSubredditDataSource.kt */
public final class RedditLocalSubredditDataSource implements LocalSubredditDataSource {
    static final /* synthetic */ KProperty[] f16163a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(RedditLocalSubredditDataSource.class), "subredditListingDir", "getSubredditListingDir()Ljava/io/File;")), Reflection.a(new PropertyReference1Impl(Reflection.a(RedditLocalSubredditDataSource.class), "jsonAdapter", "getJsonAdapter()Lcom/squareup/moshi/JsonAdapter;")), Reflection.a(new PropertyReference1Impl(Reflection.a(RedditLocalSubredditDataSource.class), "subredditListingPersister", "getSubredditListingPersister()Lcom/nytimes/android/external/store3/base/Persister;"))};
    private final Lazy f16164b = LazyKt.a((Function0) new RedditLocalSubredditDataSource$subredditListingDir$2(this));
    private final Lazy f16165c = LazyKt.a((Function0) new RedditLocalSubredditDataSource$jsonAdapter$2(this));
    private final Lazy f16166d = LazyKt.a((Function0) new RedditLocalSubredditDataSource$subredditListingPersister$2(this));
    private final Moshi f16167e;
    private final Context f16168f;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/local/RedditLocalSubredditDataSource$SubredditListingKey;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/Key;", "path", "", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditLocalSubredditDataSource.kt */
    private static final class SubredditListingKey implements Key {
        private final String f16150a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof SubredditListingKey) {
                    if (Intrinsics.a(this.f16150a, ((SubredditListingKey) obj).f16150a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f16150a;
            return str != null ? str.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("SubredditListingKey(path=");
            stringBuilder.append(this.f16150a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public SubredditListingKey(String str) {
            Intrinsics.b(str, "path");
            this.f16150a = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0014J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/local/RedditLocalSubredditDataSource$MultiredditConverter;", "Lcom/google/common/base/Converter;", "Lcom/reddit/frontpage/domain/model/Multireddit;", "Lcom/reddit/datalibrary/frontpage/data/model/MultiredditDataModel;", "()V", "doBackward", "dataModel", "doForward", "multireddit", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditLocalSubredditDataSource.kt */
    private static final class MultiredditConverter extends Converter<Multireddit, MultiredditDataModel> {
        public static final MultiredditConverter f18708a = new MultiredditConverter();

        private MultiredditConverter() {
        }

        public final /* synthetic */ Object mo3583a(Object obj) {
            Multireddit multireddit = (Multireddit) obj;
            Intrinsics.b(multireddit, "multireddit");
            return new MultiredditDataModel(0, multireddit.getName(), multireddit.isEditable(), multireddit.getPath(), multireddit.getIconUrl(), multireddit.getKeyColor(), 1, null);
        }

        public final /* synthetic */ Object mo3584b(Object obj) {
            MultiredditDataModel multiredditDataModel = (MultiredditDataModel) obj;
            Intrinsics.b(multiredditDataModel, "dataModel");
            return new Multireddit(multiredditDataModel.getName(), multiredditDataModel.getEditable(), multiredditDataModel.getPath(), multiredditDataModel.getIconUrl(), multiredditDataModel.getKeyColor());
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0014J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/local/RedditLocalSubredditDataSource$RecentSubredditConverter;", "Lcom/google/common/base/Converter;", "Lcom/reddit/frontpage/domain/model/Subreddit;", "Lcom/reddit/datalibrary/frontpage/data/model/RecentSubredditDataModel;", "username", "", "(Ljava/lang/String;)V", "doBackward", "dataModel", "doForward", "subreddit", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditLocalSubredditDataSource.kt */
    private static final class RecentSubredditConverter extends Converter<Subreddit, RecentSubredditDataModel> {
        private final String f18709a;

        public final /* synthetic */ Object mo3583a(Object obj) {
            Subreddit subreddit = (Subreddit) obj;
            Intrinsics.b(subreddit, "subreddit");
            String id = subreddit.getId();
            String kindWithId = subreddit.getKindWithId();
            String str = this.f18709a;
            String displayName = subreddit.getDisplayName();
            String displayNamePrefixed = subreddit.getDisplayNamePrefixed();
            String iconImg = subreddit.getIconImg();
            String keyColor = subreddit.getKeyColor();
            String url = subreddit.getUrl();
            String description = subreddit.getDescription();
            if (description == null) {
                description = "";
            }
            String str2 = description;
            String descriptionHtml = subreddit.getDescriptionHtml();
            return new RecentSubredditDataModel(0, id, kindWithId, str, displayName, displayNamePrefixed, iconImg, keyColor, str2, subreddit.getPublicDescription(), descriptionHtml, url, subreddit.getSubscribers(), 0, subreddit.getBannerImg(), subreddit.getOver18(), subreddit.getSubredditType(), System.currentTimeMillis(), subreddit.getCreatedUtc(), 8193, null);
        }

        public final /* synthetic */ Object mo3584b(Object obj) {
            RecentSubredditDataModel recentSubredditDataModel = (RecentSubredditDataModel) obj;
            Intrinsics.b(recentSubredditDataModel, "dataModel");
            String subredditId = recentSubredditDataModel.getSubredditId();
            String name = recentSubredditDataModel.getName();
            String displayName = recentSubredditDataModel.getDisplayName();
            String displayNamePrefixed = recentSubredditDataModel.getDisplayNamePrefixed();
            String iconImg = recentSubredditDataModel.getIconImg();
            String keyColor = recentSubredditDataModel.getKeyColor();
            String url = recentSubredditDataModel.getUrl();
            String description = recentSubredditDataModel.getDescription();
            String descriptionHtml = recentSubredditDataModel.getDescriptionHtml();
            String publicDescription = recentSubredditDataModel.getPublicDescription();
            long subscribers = recentSubredditDataModel.getSubscribers();
            String bannerImg = recentSubredditDataModel.getBannerImg();
            boolean over18 = recentSubredditDataModel.getOver18();
            return new Subreddit(subredditId, name, displayName, displayNamePrefixed, iconImg, keyColor, bannerImg, null, null, description, descriptionHtml, publicDescription, null, subscribers, null, recentSubredditDataModel.getCreatedUtc(), recentSubredditDataModel.getSubredditType(), url, over18, null, null, null, null, null, null, null, null, null, null, 536367488, null);
        }

        public RecentSubredditConverter(String str) {
            Intrinsics.b(str, "username");
            this.f18709a = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0014J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/local/RedditLocalSubredditDataSource$SubredditConverter;", "Lcom/google/common/base/Converter;", "Lcom/reddit/frontpage/domain/model/Subreddit;", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditDataModel;", "()V", "doBackward", "dataModel", "doForward", "subreddit", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditLocalSubredditDataSource.kt */
    private static final class SubredditConverter extends Converter<Subreddit, SubredditDataModel> {
        public static final SubredditConverter f18710a = new SubredditConverter();

        private SubredditConverter() {
        }

        public final /* synthetic */ Object mo3583a(Object obj) {
            Subreddit subreddit = (Subreddit) obj;
            Intrinsics.b(subreddit, "subreddit");
            String id = subreddit.getId();
            String kindWithId = subreddit.getKindWithId();
            String displayName = subreddit.getDisplayName();
            String displayNamePrefixed = subreddit.getDisplayNamePrefixed();
            String iconImg = subreddit.getIconImg();
            String keyColor = subreddit.getKeyColor();
            String bannerImg = subreddit.getBannerImg();
            String headerImg = subreddit.getHeaderImg();
            String title = subreddit.getTitle();
            String description = subreddit.getDescription();
            if (description == null) {
                description = "";
            }
            String str = description;
            String descriptionHtml = subreddit.getDescriptionHtml();
            return new SubredditDataModel(0, id, kindWithId, displayName, displayNamePrefixed, iconImg, keyColor, bannerImg, headerImg, title, str, subreddit.getPublicDescription(), descriptionHtml, subreddit.getPublicDescriptionHtml(), subreddit.getSubscribers(), subreddit.getAccountsActive(), subreddit.getCreatedUtc(), subreddit.getSubredditType(), subreddit.getUrl(), subreddit.getOver18(), subreddit.getWikiEnabled(), subreddit.getWhitelistStatus(), subreddit.getNewModMailEnabled(), subreddit.getSubmitType(), subreddit.getAllowImages(), subreddit.getAllowVideos(), subreddit.getSpoilersEnabled(), subreddit.getUserIsSubscriber(), subreddit.getUserIsModerator(), subreddit.getUserHasFavorited(), 0, 1073741825, null);
        }

        public final /* synthetic */ Object mo3584b(Object obj) {
            SubredditDataModel subredditDataModel = (SubredditDataModel) obj;
            Intrinsics.b(subredditDataModel, "dataModel");
            String subredditId = subredditDataModel.getSubredditId();
            String name = subredditDataModel.getName();
            String displayName = subredditDataModel.getDisplayName();
            String displayNamePrefixed = subredditDataModel.getDisplayNamePrefixed();
            String iconImg = subredditDataModel.getIconImg();
            String keyColor = subredditDataModel.getKeyColor();
            String bannerImg = subredditDataModel.getBannerImg();
            String headerImg = subredditDataModel.getHeaderImg();
            String title = subredditDataModel.getTitle();
            String description = subredditDataModel.getDescription();
            String descriptionHtml = subredditDataModel.getDescriptionHtml();
            String publicDescription = subredditDataModel.getPublicDescription();
            String publicDescriptionHtml = subredditDataModel.getPublicDescriptionHtml();
            long subscribers = subredditDataModel.getSubscribers();
            Long accountsActive = subredditDataModel.getAccountsActive();
            long createdUtc = subredditDataModel.getCreatedUtc();
            String subredditType = subredditDataModel.getSubredditType();
            String url = subredditDataModel.getUrl();
            boolean over18 = subredditDataModel.getOver18();
            Boolean wikiEnabled = subredditDataModel.getWikiEnabled();
            String whitelistStatus = subredditDataModel.getWhitelistStatus();
            Boolean newModMailEnabled = subredditDataModel.getNewModMailEnabled();
            Boolean userIsSubscriber = subredditDataModel.getUserIsSubscriber();
            return new Subreddit(subredditId, name, displayName, displayNamePrefixed, iconImg, keyColor, bannerImg, headerImg, title, description, descriptionHtml, publicDescription, publicDescriptionHtml, subscribers, accountsActive, createdUtc, subredditType, url, over18, wikiEnabled, whitelistStatus, newModMailEnabled, subredditDataModel.getSubmitType(), subredditDataModel.getAllowImages(), subredditDataModel.getAllowVideos(), subredditDataModel.getSpoilersEnabled(), subredditDataModel.getUserIsModerator(), userIsSubscriber, subredditDataModel.getUserHasFavorited());
        }
    }

    private final JsonAdapter<List<Subreddit>> m16144g() {
        return (JsonAdapter) this.f16165c.b();
    }

    @Inject
    public RedditLocalSubredditDataSource(Moshi moshi, Context context) {
        Intrinsics.b(moshi, "moshi");
        Intrinsics.b(context, "context");
        this.f16167e = moshi;
        this.f16168f = context;
    }

    public final Single<Boolean> mo2986a(Collection<Multireddit> collection) {
        Intrinsics.b(collection, "multireddits");
        collection = MultiredditConverter.f18708a.m14541a((Iterable) collection);
        Intrinsics.a(collection, "MultiredditConverter.convertAll(multireddits)");
        collection = FastStoreModelTransaction.saveBuilder(FlowManager.getModelAdapter(MultiredditDataModel.class)).addAll((Collection) CollectionsKt.n(collection)).build();
        DatabaseDefinition database = FlowManager.getDatabase(RedditFlowDatabase.class);
        Intrinsics.a(collection, "fastStoreModelTransaction");
        return DatabaseDefinitionsKt.m8722a(database, (ITransaction) collection);
    }

    public final Single<Boolean> mo2990b(Collection<Subreddit> collection) {
        Intrinsics.b(collection, "subreddits");
        collection = SubredditConverter.f18710a.m14541a((Iterable) collection);
        Intrinsics.a(collection, "SubredditConverter.convertAll(subreddits)");
        collection = FastStoreModelTransaction.saveBuilder(FlowManager.getModelAdapter(SubredditDataModel.class)).addAll((Collection) CollectionsKt.n(collection)).build();
        DatabaseDefinition database = FlowManager.getDatabase(RedditFlowDatabase.class);
        Intrinsics.a(collection, "fastStoreModelTransaction");
        return DatabaseDefinitionsKt.m8722a(database, (ITransaction) collection);
    }

    public final Maybe<List<Subreddit>> mo2993d(String str) {
        Intrinsics.b(str, "path");
        PersistDataSourceUtil persistDataSourceUtil = PersistDataSourceUtil.f10382a;
        return PersistDataSourceUtil.m8824b(new SubredditListingKey(str), LazyKt.a((Function0) new RedditLocalSubredditDataSource$getSubredditListing$1(this)), m16144g());
    }

    public final Single<Boolean> mo2987a(List<Subreddit> list, String str) {
        Intrinsics.b(list, "subreddits");
        Intrinsics.b(str, "path");
        PersistDataSourceUtil persistDataSourceUtil = PersistDataSourceUtil.f10382a;
        return PersistDataSourceUtil.m8823a((List) list, (Key) new SubredditListingKey(str), LazyKt.a((Function0) new RedditLocalSubredditDataSource$saveSubredditListing$1(this)), m16144g());
    }

    public final Single<Boolean> mo2984a(String str, Subreddit subreddit) {
        Intrinsics.b(str, "username");
        Intrinsics.b(subreddit, "subreddit");
        str = new RecentSubredditConverter(str).m14544c(subreddit);
        if (str == null) {
            Intrinsics.a();
        }
        str = ((RecentSubredditDataModel) str).save();
        Intrinsics.a(str, "RecentSubredditConverter…nvert(subreddit)!!.save()");
        return str;
    }

    public final Single<List<Subreddit>> mo2996e(String str) {
        Intrinsics.b(str, "username");
        RecentSubredditConverter recentSubredditConverter = new RecentSubredditConverter(str);
        str = SQLite.select(new IProperty[null]);
        Intrinsics.a(str, "SQLite.select()");
        str = str.from(RecentSubredditDataModel.class);
        Intrinsics.a(str, "select.from(RecentSubredditDataModel::class.java)");
        str = QueryExtensionsKt.rx((ModelQueriable) str).queryList().map(new RedditLocalSubredditDataSource$getRecentSubreddits$1(recentSubredditConverter));
        Intrinsics.a(str, "select.from(RecentSubred…convert(it)!! }\n        }");
        return str;
    }

    public final Maybe<Subreddit> mo2982a(String str) {
        Intrinsics.b(str, "subredditName");
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        str = com.raizlabs.android.dbflow.kotlinextensions.QueryExtensionsKt.from(select, Reflection.a(SubredditDataModel.class)).where(SubredditDataModel_Table.displayName.is((Object) str));
        Intrinsics.a(str, "select.from(SubredditDat…Name.`is`(subredditName))");
        str = RxModelQueriablesKt.m8757b(QueryExtensionsKt.rx((ModelQueriable) str)).flatMap(RedditLocalSubredditDataSource$getSubreddit$1.f16157a);
        Intrinsics.a(str, "select.from(SubredditDat…!!)\n          }\n        }");
        return str;
    }

    public final Single<Boolean> mo2989b(String str) {
        Intrinsics.b(str, "subredditName");
        str = SQLite.update(SubredditDataModel.class).set(SubredditDataModel_Table.userIsSubscriber.eq((Object) Boolean.valueOf(true))).where(SubredditDataModel_Table.displayName.is((Object) str));
        Intrinsics.a(str, "update<SubredditDataMode…Name.`is`(subredditName))");
        str = QueryExtensionsKt.rx((ModelQueriable) str).count().map(RedditLocalSubredditDataSource$subscribeSubreddit$1.f16161a);
        Intrinsics.a(str, "update<SubredditDataMode…().count().map { it > 0 }");
        return str;
    }

    public final Single<Boolean> mo2992c(String str) {
        Intrinsics.b(str, "subredditName");
        str = SQLite.update(SubredditDataModel.class).set(SubredditDataModel_Table.userIsSubscriber.eq((Object) Boolean.valueOf(false))).where(SubredditDataModel_Table.displayName.is((Object) str));
        Intrinsics.a(str, "update<SubredditDataMode…Name.`is`(subredditName))");
        str = QueryExtensionsKt.rx((ModelQueriable) str).count().map(RedditLocalSubredditDataSource$unsubscribeSubreddit$1.f16162a);
        Intrinsics.a(str, "update<SubredditDataMode…().count().map { it > 0 }");
        return str;
    }

    public final Single<Boolean> mo2985a(String str, boolean z) {
        Intrinsics.b(str, "subredditId");
        str = SQLite.update(SubredditDataModel.class).set(SubredditDataModel_Table.userHasFavorited.eq((Object) Boolean.valueOf(z))).where(SubredditDataModel_Table.subredditId.is((Object) str));
        Intrinsics.a(str, "update<SubredditDataMode…dditId.`is`(subredditId))");
        str = QueryExtensionsKt.rx((ModelQueriable) str).count().map((Function) RedditLocalSubredditDataSource$saveFavorite$1.f16159a);
        Intrinsics.a(str, "update<SubredditDataMode…().count().map { it > 0 }");
        return str;
    }

    public final Single<List<Subreddit>> mo2983a() {
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        Single<List<Subreddit>> map = QueryExtensionsKt.rx((ModelQueriable) com.raizlabs.android.dbflow.kotlinextensions.QueryExtensionsKt.from(select, Reflection.a(SubredditDataModel.class))).queryList().map(RedditLocalSubredditDataSource$getDefaultSubreddits$1.f16151a);
        Intrinsics.a(map, "select.from(SubredditDat…verse().convert(it)!! } }");
        return map;
    }

    public final Single<List<Multireddit>> mo2988b() {
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        Single<List<Multireddit>> map = QueryExtensionsKt.rx((ModelQueriable) com.raizlabs.android.dbflow.kotlinextensions.QueryExtensionsKt.from(select, Reflection.a(MultiredditDataModel.class))).queryList().map(RedditLocalSubredditDataSource$getMultireddits$1.f16155a);
        Intrinsics.a(map, "select.from(MultiredditD…verse().convert(it)!! } }");
        return map;
    }

    public final Single<List<Subreddit>> mo2991c() {
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        Where and = com.raizlabs.android.dbflow.kotlinextensions.QueryExtensionsKt.from(select, Reflection.a(SubredditDataModel.class)).where(SubredditDataModel_Table.userIsSubscriber.eq((Object) Boolean.valueOf(true))).and(SubredditDataModel_Table.subredditType.eq((Object) "user"));
        Intrinsics.a(and, "select.from(SubredditDat…dit.SUBREDDIT_TYPE_USER))");
        Single<List<Subreddit>> map = QueryExtensionsKt.rx((ModelQueriable) and).queryList().map(RedditLocalSubredditDataSource$getFollowingSubreddits$1.f16153a);
        Intrinsics.a(map, "select.from(SubredditDat…verse().convert(it)!! } }");
        return map;
    }

    public final Single<List<Subreddit>> mo2994d() {
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        Where where = com.raizlabs.android.dbflow.kotlinextensions.QueryExtensionsKt.from(select, Reflection.a(SubredditDataModel.class)).where(SubredditDataModel_Table.userHasFavorited.eq((Object) Boolean.valueOf(true)));
        Intrinsics.a(where, "select.from(SubredditDat…serHasFavorited.eq(true))");
        Single<List<Subreddit>> map = QueryExtensionsKt.rx((ModelQueriable) where).queryList().map(RedditLocalSubredditDataSource$getFavoriteSubreddits$1.f16152a);
        Intrinsics.a(map, "select.from(SubredditDat…verse().convert(it)!! } }");
        return map;
    }

    public final Single<List<Subreddit>> mo2995e() {
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        Where and = com.raizlabs.android.dbflow.kotlinextensions.QueryExtensionsKt.from(select, Reflection.a(SubredditDataModel.class)).where(SubredditDataModel_Table.userIsSubscriber.eq((Object) Boolean.valueOf(true))).and(SubredditDataModel_Table.subredditType.notEq((Object) "user"));
        Intrinsics.a(and, "select.from(SubredditDat…dit.SUBREDDIT_TYPE_USER))");
        Single<List<Subreddit>> map = QueryExtensionsKt.rx((ModelQueriable) and).queryList().map(RedditLocalSubredditDataSource$getSubscribedSubreddits$1.f16158a);
        Intrinsics.a(map, "select.from(SubredditDat…verse().convert(it)!! } }");
        return map;
    }

    public final Single<List<Subreddit>> mo2997f() {
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        Where where = com.raizlabs.android.dbflow.kotlinextensions.QueryExtensionsKt.from(select, Reflection.a(SubredditDataModel.class)).where(SubredditDataModel_Table.userIsModerator.eq((Object) Boolean.valueOf(true)));
        Intrinsics.a(where, "select.from(SubredditDat…userIsModerator.eq(true))");
        Single<List<Subreddit>> map = QueryExtensionsKt.rx((ModelQueriable) where).queryList().map(RedditLocalSubredditDataSource$getModeratingSubreddits$1.f16154a);
        Intrinsics.a(map, "select.from(SubredditDat…verse().convert(it)!! } }");
        return map;
    }

    public final Completable mo2981a(String str, String str2) {
        Intrinsics.b(str, "username");
        Intrinsics.b(str2, "kindWithId");
        From delete = SQLite.delete(RecentSubredditDataModel.class);
        SQLOperator[] sQLOperatorArr = new SQLOperator[1];
        Operator eq = RecentSubredditDataModel_Table.username.eq((Object) str);
        Intrinsics.a(eq, "RecentSubredditDataModel…ble.username.eq(username)");
        str2 = RecentSubredditDataModel_Table.name.eq((Object) str2);
        Intrinsics.a(str2, "RecentSubredditDataModel_Table.name.eq(kindWithId)");
        sQLOperatorArr[null] = OperatorExtensionsKt.and(eq, (SQLOperator) str2);
        str = delete.where(sQLOperatorArr);
        Intrinsics.a(str, "com.raizlabs.android.dbf…ble.name.eq(kindWithId)))");
        str = QueryExtensionsKt.rx((ModelQueriable) str).execute();
        Intrinsics.a(str, "com.raizlabs.android.dbf… .rx()\n        .execute()");
        return str;
    }
}
