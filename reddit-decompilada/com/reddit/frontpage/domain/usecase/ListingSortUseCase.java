package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortingsLegacyMapper;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.rxkotlin.SinglesKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0004\u000f\u0010\u0011\u0012B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase;", "", "repository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "(Lcom/reddit/frontpage/domain/repository/PreferenceRepository;)V", "buildSortTimeFrameKey", "", "params", "Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase$ListingSortParams;", "buildSortTypeKey", "get", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase$LegacyListingSort;", "save", "Lio/reactivex/Completable;", "Companion", "LegacyListingSort", "ListingSort", "ListingSortParams", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingSortUseCase.kt */
public final class ListingSortUseCase {
    public static final Companion f20285a = new Companion();
    private static final String f20286c = "ListingSortUseCase";
    private static final String f20287d;
    private static final String f20288e;
    private final PreferenceRepository f20289b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase$Companion;", "", "()V", "KEY_SORT_TIMEFRAME", "", "getKEY_SORT_TIMEFRAME", "()Ljava/lang/String;", "KEY_SORT_TYPE", "getKEY_SORT_TYPE", "TAG", "getTAG", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ListingSortUseCase.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase$LegacyListingSort;", "", "sortType", "", "sortTimeFrame", "(II)V", "getSortTimeFrame", "()I", "getSortType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ListingSortUseCase.kt */
    public static final class LegacyListingSort {
        public final int f20280a;
        public final int f20281b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LegacyListingSort) {
                LegacyListingSort legacyListingSort = (LegacyListingSort) obj;
                if (this.f20280a == legacyListingSort.f20280a) {
                    if (this.f20281b == legacyListingSort.f20281b) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            return (this.f20280a * 31) + this.f20281b;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("LegacyListingSort(sortType=");
            stringBuilder.append(this.f20280a);
            stringBuilder.append(", sortTimeFrame=");
            stringBuilder.append(this.f20281b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public LegacyListingSort(int i, int i2) {
            this.f20280a = i;
            this.f20281b = i2;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase$ListingSortParams;", "", "listingName", "", "sort", "Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase$LegacyListingSort;", "(Ljava/lang/String;Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase$LegacyListingSort;)V", "getListingName", "()Ljava/lang/String;", "getSort", "()Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase$LegacyListingSort;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ListingSortUseCase.kt */
    public static final class ListingSortParams {
        public static final Companion f20282c = new Companion();
        final String f20283a;
        final LegacyListingSort f20284b;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase$ListingSortParams$Companion;", "", "()V", "from", "Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase$ListingSortParams;", "listingName", "", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: ListingSortUseCase.kt */
        public static final class Companion {
            private Companion() {
            }

            public static ListingSortParams m22517a(String str, SortType sortType, SortTimeFrame sortTimeFrame) {
                Intrinsics.m26847b(str, "listingName");
                Intrinsics.m26847b(sortType, "sort");
                return new ListingSortParams(str, new LegacyListingSort(SortingsLegacyMapper.a(sortType), SortingsLegacyMapper.a(sortTimeFrame)));
            }
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof ListingSortParams) {
                    ListingSortParams listingSortParams = (ListingSortParams) obj;
                    if (Intrinsics.m26845a(this.f20283a, listingSortParams.f20283a) && Intrinsics.m26845a(this.f20284b, listingSortParams.f20284b)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f20283a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            LegacyListingSort legacyListingSort = this.f20284b;
            if (legacyListingSort != null) {
                i = legacyListingSort.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("ListingSortParams(listingName=");
            stringBuilder.append(this.f20283a);
            stringBuilder.append(", sort=");
            stringBuilder.append(this.f20284b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public ListingSortParams(String str, LegacyListingSort legacyListingSort) {
            Intrinsics.m26847b(str, "listingName");
            Intrinsics.m26847b(legacyListingSort, "sort");
            this.f20283a = str;
            this.f20284b = legacyListingSort;
        }
    }

    @Inject
    public ListingSortUseCase(PreferenceRepository preferenceRepository) {
        Intrinsics.m26847b(preferenceRepository, "repository");
        this.f20289b = preferenceRepository;
    }

    public final Completable m22523a(ListingSortParams listingSortParams) {
        Intrinsics.m26847b(listingSortParams, "params");
        Object andThen = this.f20289b.m22469a(m22521c(listingSortParams), listingSortParams.f20284b.f20280a).andThen((CompletableSource) this.f20289b.m22469a(m22522d(listingSortParams), listingSortParams.f20284b.f20281b));
        Intrinsics.m26843a(andThen, "repository.save(buildSor…rams.sort.sortTimeFrame))");
        return andThen;
    }

    public final Single<LegacyListingSort> m22524b(ListingSortParams listingSortParams) {
        Intrinsics.m26847b(listingSortParams, "params");
        Object map = SinglesKt.m26767a(this.f20289b.m22476b(m22521c(listingSortParams), listingSortParams.f20284b.f20280a), this.f20289b.m22476b(m22522d(listingSortParams), listingSortParams.f20284b.f20281b)).map(ListingSortUseCase$get$1.f28019a);
        Intrinsics.m26843a(map, "repository.get(buildSort…ortType, sortTimeFrame) }");
        return map;
    }

    private static String m22521c(ListingSortParams listingSortParams) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f20287d);
        stringBuilder.append(listingSortParams.f20283a);
        return stringBuilder.toString();
    }

    private static String m22522d(ListingSortParams listingSortParams) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f20288e);
        stringBuilder.append(listingSortParams.f20283a);
        return stringBuilder.toString();
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f20286c);
        stringBuilder.append(":SortType");
        f20287d = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(f20286c);
        stringBuilder.append(":SortTimeFrame");
        f20288e = stringBuilder.toString();
    }
}
