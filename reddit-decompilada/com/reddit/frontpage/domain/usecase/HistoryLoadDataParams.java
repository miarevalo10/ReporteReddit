package com.reddit.frontpage.domain.usecase;

import com.reddit.frontpage.presentation.listing.history.HistorySortType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/HistoryLoadDataParams;", "Lcom/reddit/frontpage/domain/usecase/Params;", "username", "", "sort", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "after", "mvpEnabled", "", "(Ljava/lang/String;Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;Ljava/lang/String;Z)V", "getAfter", "()Ljava/lang/String;", "getMvpEnabled", "()Z", "getSort", "()Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "getUsername", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HistoryLoadData.kt */
public final class HistoryLoadDataParams implements Params {
    final String f27993a;
    final HistorySortType f27994b;
    final String f27995c;
    final boolean f27996d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HistoryLoadDataParams) {
            HistoryLoadDataParams historyLoadDataParams = (HistoryLoadDataParams) obj;
            if (Intrinsics.m26845a(this.f27993a, historyLoadDataParams.f27993a) && Intrinsics.m26845a(this.f27994b, historyLoadDataParams.f27994b) && Intrinsics.m26845a(this.f27995c, historyLoadDataParams.f27995c)) {
                if (this.f27996d == historyLoadDataParams.f27996d) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f27993a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        HistorySortType historySortType = this.f27994b;
        hashCode = (hashCode + (historySortType != null ? historySortType.hashCode() : 0)) * 31;
        String str2 = this.f27995c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.f27996d;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("HistoryLoadDataParams(username=");
        stringBuilder.append(this.f27993a);
        stringBuilder.append(", sort=");
        stringBuilder.append(this.f27994b);
        stringBuilder.append(", after=");
        stringBuilder.append(this.f27995c);
        stringBuilder.append(", mvpEnabled=");
        stringBuilder.append(this.f27996d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public HistoryLoadDataParams(String str, HistorySortType historySortType, String str2, boolean z) {
        Intrinsics.m26847b(str, "username");
        Intrinsics.m26847b(historySortType, "sort");
        this.f27993a = str;
        this.f27994b = historySortType;
        this.f27995c = str2;
        this.f27996d = z;
    }
}
