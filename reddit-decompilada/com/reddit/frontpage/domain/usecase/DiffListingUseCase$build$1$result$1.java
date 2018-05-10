package com.reddit.frontpage.domain.usecase;

import android.support.v7.util.DiffUtil.Callback;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"com/reddit/frontpage/domain/usecase/DiffListingUseCase$build$1$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "(Lcom/reddit/frontpage/domain/usecase/DiffListingUseCase$build$1;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DiffListingUseCase.kt */
public final class DiffListingUseCase$build$1$result$1 extends Callback {
    final /* synthetic */ DiffListingUseCase$build$1 f27974a;
    final /* synthetic */ List f27975b;

    DiffListingUseCase$build$1$result$1(DiffListingUseCase$build$1 diffListingUseCase$build$1, List list) {
        this.f27974a = diffListingUseCase$build$1;
        this.f27975b = list;
    }

    public final boolean m29316a(int i, int i2) {
        return ((Listable) this.f27974a.f27976a.f27978a.get(i)).getUniqueID() == ((Listable) this.f27975b.get(i2)).getUniqueID();
    }

    public final int m29315a() {
        return this.f27974a.f27976a.f27978a.size();
    }

    public final int m29317b() {
        return this.f27975b.size();
    }

    public final boolean m29318b(int i, int i2) {
        return Intrinsics.m26845a((Listable) this.f27974a.f27976a.f27978a.get(i), (Listable) this.f27975b.get(i2));
    }
}
