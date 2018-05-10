package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.frontpage.presentation.listing.history.HistorySortType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/repo/HistoryKey;", "", "username", "", "sort", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "after", "(Ljava/lang/String;Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;Ljava/lang/String;)V", "getAfter", "()Ljava/lang/String;", "getSort", "()Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "getUsername", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
final class HistoryKey {
    final String f10667a;
    final HistorySortType f10668b;
    final String f10669c;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof HistoryKey) {
                HistoryKey historyKey = (HistoryKey) obj;
                if (Intrinsics.a(this.f10667a, historyKey.f10667a) && Intrinsics.a(this.f10668b, historyKey.f10668b) && Intrinsics.a(this.f10669c, historyKey.f10669c)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f10667a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        HistorySortType historySortType = this.f10668b;
        hashCode = (hashCode + (historySortType != null ? historySortType.hashCode() : 0)) * 31;
        String str2 = this.f10669c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("HistoryKey(username=");
        stringBuilder.append(this.f10667a);
        stringBuilder.append(", sort=");
        stringBuilder.append(this.f10668b);
        stringBuilder.append(", after=");
        stringBuilder.append(this.f10669c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public HistoryKey(String str, HistorySortType historySortType, String str2) {
        Intrinsics.b(str, "username");
        Intrinsics.b(historySortType, "sort");
        this.f10667a = str;
        this.f10668b = historySortType;
        this.f10669c = str2;
    }
}
