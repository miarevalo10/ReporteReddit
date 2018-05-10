package com.reddit.datalibrary.frontpage.data.feature.karma.datasource.local;

import android.content.Context;
import com.nytimes.android.external.store3.base.Persister;
import com.reddit.frontpage.domain.model.Karma;
import com.squareup.moshi.Moshi;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okio.BufferedSource;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u001d\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R'\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00158BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/karma/datasource/local/FileKarmaDataSource;", "Lcom/reddit/datalibrary/frontpage/data/feature/karma/datasource/local/LocalKarmaDataSource;", "moshi", "Lcom/squareup/moshi/Moshi;", "context", "Landroid/content/Context;", "(Lcom/squareup/moshi/Moshi;Landroid/content/Context;)V", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "", "Lcom/reddit/frontpage/domain/model/Karma;", "getAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "karmaDir", "Ljava/io/File;", "getKarmaDir", "()Ljava/io/File;", "karmaDir$delegate", "persister", "Lcom/nytimes/android/external/store3/base/Persister;", "Lokio/BufferedSource;", "", "getPersister", "()Lcom/nytimes/android/external/store3/base/Persister;", "persister$delegate", "getTopKarma", "Lio/reactivex/Maybe;", "username", "getTopKarmaFileName", "saveTopKarma", "Lio/reactivex/Single;", "", "karma", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FileKarmaDataSource.kt */
public final class FileKarmaDataSource implements LocalKarmaDataSource {
    static final /* synthetic */ KProperty[] f15843a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(FileKarmaDataSource.class), "karmaDir", "getKarmaDir()Ljava/io/File;")), Reflection.a(new PropertyReference1Impl(Reflection.a(FileKarmaDataSource.class), "adapter", "getAdapter()Lcom/squareup/moshi/JsonAdapter;")), Reflection.a(new PropertyReference1Impl(Reflection.a(FileKarmaDataSource.class), "persister", "getPersister()Lcom/nytimes/android/external/store3/base/Persister;"))};
    public static final Companion f15844b = new Companion();
    private final Lazy f15845c = LazyKt.a((Function0) new FileKarmaDataSource$karmaDir$2(this));
    private final Lazy f15846d = LazyKt.a((Function0) new FileKarmaDataSource$adapter$2(this));
    private final Lazy f15847e = LazyKt.a((Function0) new FileKarmaDataSource$persister$2(this));
    private final Moshi f15848f;
    private final Context f15849g;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/karma/datasource/local/FileKarmaDataSource$Companion;", "", "()V", "TOP_KARMA_FILE_PREFIX", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: FileKarmaDataSource.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    private final Persister<BufferedSource, String> m15903a() {
        return (Persister) this.f15847e.b();
    }

    @Inject
    public FileKarmaDataSource(Moshi moshi, Context context) {
        Intrinsics.b(moshi, "moshi");
        Intrinsics.b(context, "context");
        this.f15848f = moshi;
        this.f15849g = context;
    }

    public final Single<Boolean> mo2928a(String str, List<Karma> list) {
        Intrinsics.b(str, "username");
        Intrinsics.b(list, "karma");
        if ((((CharSequence) str).length() > 0 ? 1 : null) == null) {
            throw ((Throwable) new IllegalArgumentException("Please specify non-empty username".toString()));
        }
        str = Single.fromCallable(new FileKarmaDataSource$saveTopKarma$2(this, list)).flatMap(new FileKarmaDataSource$saveTopKarma$3(this, str)).onErrorReturn((Function) FileKarmaDataSource$saveTopKarma$4.f15842a);
        Intrinsics.a(str, "Single.fromCallable {\n  …          false\n        }");
        return str;
    }

    public final Maybe<List<Karma>> mo2927a(String str) {
        Intrinsics.b(str, "username");
        if ((((CharSequence) str).length() > 0 ? 1 : null) == null) {
            throw new IllegalArgumentException("Please specify non-empty username".toString());
        }
        str = m15903a().mo2708a(m15908c(str)).map(new FileKarmaDataSource$getTopKarma$2(this)).onErrorComplete();
        Intrinsics.a(str, "persister.read(getTopKar…       .onErrorComplete()");
        return str;
    }

    private static String m15908c(String str) {
        StringBuilder stringBuilder = new StringBuilder("top_karma_");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
