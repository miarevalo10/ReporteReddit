package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.common.ViewDiffResult;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BU\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000eHÆ\u0003Ja\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020\tHÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006&"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/DiffListingResult;", "", "links", "", "Lcom/reddit/frontpage/domain/model/Link;", "presentationModels", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "linkPositions", "", "", "", "after", "adDistance", "diffResult", "Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;)V", "getAdDistance", "()Ljava/lang/String;", "getAfter", "getDiffResult", "()Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;", "getLinkPositions", "()Ljava/util/Map;", "getLinks", "()Ljava/util/List;", "getPresentationModels", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DiffListingUseCase.kt */
public final class DiffListingResult {
    public final List<Link> f20272a;
    public final List<Listable> f20273b;
    public final Map<String, Integer> f20274c;
    public final String f20275d;
    public final String f20276e;
    public final ViewDiffResult f20277f;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DiffListingResult) {
                DiffListingResult diffListingResult = (DiffListingResult) obj;
                if (Intrinsics.m26845a(this.f20272a, diffListingResult.f20272a) && Intrinsics.m26845a(this.f20273b, diffListingResult.f20273b) && Intrinsics.m26845a(this.f20274c, diffListingResult.f20274c) && Intrinsics.m26845a(this.f20275d, diffListingResult.f20275d) && Intrinsics.m26845a(this.f20276e, diffListingResult.f20276e) && Intrinsics.m26845a(this.f20277f, diffListingResult.f20277f)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List list = this.f20272a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List list2 = this.f20273b;
        hashCode = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        Map map = this.f20274c;
        hashCode = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        String str = this.f20275d;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f20276e;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        ViewDiffResult viewDiffResult = this.f20277f;
        if (viewDiffResult != null) {
            i = viewDiffResult.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DiffListingResult(links=");
        stringBuilder.append(this.f20272a);
        stringBuilder.append(", presentationModels=");
        stringBuilder.append(this.f20273b);
        stringBuilder.append(", linkPositions=");
        stringBuilder.append(this.f20274c);
        stringBuilder.append(", after=");
        stringBuilder.append(this.f20275d);
        stringBuilder.append(", adDistance=");
        stringBuilder.append(this.f20276e);
        stringBuilder.append(", diffResult=");
        stringBuilder.append(this.f20277f);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public DiffListingResult(List<Link> list, List<? extends Listable> list2, Map<String, Integer> map, String str, String str2, ViewDiffResult viewDiffResult) {
        Intrinsics.m26847b(list, "links");
        Intrinsics.m26847b(list2, "presentationModels");
        Intrinsics.m26847b(map, "linkPositions");
        Intrinsics.m26847b(viewDiffResult, "diffResult");
        this.f20272a = list;
        this.f20273b = list2;
        this.f20274c = map;
        this.f20275d = str;
        this.f20276e = str2;
        this.f20277f = viewDiffResult;
    }
}
