package com.reddit.datalibrary.frontpage.data.feature.common;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0007J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH\u0007J\u0014\u0010\r\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007J\u0012\u0010\u000e\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u000f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/common/SortingsLegacyMapper;", "", "()V", "toLegacyCommentType", "", "type", "Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "toLegacySearchType", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SearchSortType;", "toLegacyTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "toLegacyType", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "toTimeFrame", "toType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Sortings.kt */
public final class SortingsLegacyMapper {
    public static final SortingsLegacyMapper f10404a = new SortingsLegacyMapper();

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f10400a;
        public static final /* synthetic */ int[] f10401b;
        public static final /* synthetic */ int[] f10402c;
        public static final /* synthetic */ int[] f10403d;

        static {
            int[] iArr = new int[SortType.values().length];
            f10400a = iArr;
            iArr[SortType.f15828a.ordinal()] = 1;
            f10400a[SortType.f15829b.ordinal()] = 2;
            f10400a[SortType.f15830c.ordinal()] = 3;
            f10400a[SortType.f15831d.ordinal()] = 4;
            f10400a[SortType.f15832e.ordinal()] = 5;
            iArr = new int[SortTimeFrame.values().length];
            f10401b = iArr;
            iArr[SortTimeFrame.f10391a.ordinal()] = 1;
            f10401b[SortTimeFrame.f10392b.ordinal()] = 2;
            f10401b[SortTimeFrame.f10393c.ordinal()] = 3;
            f10401b[SortTimeFrame.f10394d.ordinal()] = 4;
            f10401b[SortTimeFrame.f10395e.ordinal()] = 5;
            f10401b[SortTimeFrame.f10396f.ordinal()] = 6;
            iArr = new int[CommentSortType.values().length];
            f10402c = iArr;
            iArr[CommentSortType.f10360a.ordinal()] = 1;
            f10402c[CommentSortType.f10361b.ordinal()] = 2;
            f10402c[CommentSortType.f10362c.ordinal()] = 3;
            f10402c[CommentSortType.f10363d.ordinal()] = 4;
            f10402c[CommentSortType.f10364e.ordinal()] = 5;
            f10402c[CommentSortType.f10365f.ordinal()] = 6;
            f10402c[CommentSortType.f10366g.ordinal()] = 7;
            iArr = new int[SearchSortType.values().length];
            f10403d = iArr;
            iArr[SearchSortType.f10383a.ordinal()] = 1;
            f10403d[SearchSortType.f10384b.ordinal()] = 2;
            f10403d[SearchSortType.f10385c.ordinal()] = 3;
            f10403d[SearchSortType.f10386d.ordinal()] = 4;
        }
    }

    private SortingsLegacyMapper() {
    }

    public static final int m8830a(SortType sortType) {
        Intrinsics.b(sortType, "type");
        switch (WhenMappings.f10400a[sortType.ordinal()]) {
            case 1:
                return 16;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 6;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported ");
                stringBuilder.append(sortType);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static final int m8829a(SortTimeFrame sortTimeFrame) {
        if (sortTimeFrame == null) {
            return -1;
        }
        switch (WhenMappings.f10401b[sortTimeFrame.ordinal()]) {
            case 1:
                return null;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final int m8827a(CommentSortType commentSortType) {
        Intrinsics.b(commentSortType, "type");
        switch (WhenMappings.f10402c[commentSortType.ordinal()]) {
            case 1:
                return 8;
            case 2:
                return 3;
            case 3:
                return 1;
            case 4:
                return 6;
            case 5:
                return 7;
            case 6:
                return 5;
            case 7:
                return 9;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final int m8828a(SearchSortType searchSortType) {
        Intrinsics.b(searchSortType, "type");
        switch (WhenMappings.f10403d[searchSortType.ordinal()]) {
            case 1:
                return null;
            case 2:
                return 3;
            case 3:
                return 1;
            case 4:
                return 4;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final SortType m8831a(int i) {
        if (i == 6) {
            return SortType.f15832e;
        }
        if (i == 16) {
            return SortType.f15828a;
        }
        switch (i) {
            case 1:
                return SortType.f15829b;
            case 2:
                return SortType.f15830c;
            case 3:
                return SortType.f15831d;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static final SortTimeFrame m8832b(int i) {
        switch (i) {
            case -1:
                return 0;
            case 0:
                return SortTimeFrame.f10391a;
            case 1:
                return SortTimeFrame.f10392b;
            case 2:
                return SortTimeFrame.f10393c;
            case 3:
                return SortTimeFrame.f10394d;
            case 4:
                return SortTimeFrame.f10395e;
            case 5:
                return SortTimeFrame.f10396f;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
