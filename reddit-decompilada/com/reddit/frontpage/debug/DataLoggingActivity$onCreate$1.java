package com.reddit.frontpage.debug;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.debug.DataLoggingActivity.Data;
import com.reddit.frontpage.util.SchedulerProvider;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "mergedData", "", "Lcom/reddit/frontpage/debug/DataLoggingActivity$Data;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: DataLoggingActivity.kt */
final class DataLoggingActivity$onCreate$1<T> implements Consumer<List<? extends Data>> {
    final /* synthetic */ DataLoggingActivity f27484a;

    DataLoggingActivity$onCreate$1(DataLoggingActivity dataLoggingActivity) {
        this.f27484a = dataLoggingActivity;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (List) obj;
        List a = this.f27484a.f40736i;
        Intrinsics.m26843a(obj, "mergedData");
        a.addAll((Collection) obj);
        final DataLoggingAdapter dataLoggingAdapter = new DataLoggingAdapter(this.f27484a, obj);
        obj = (RecyclerView) this.f27484a.mo7727a(C1761R.id.list);
        Intrinsics.m26843a(obj, "list");
        obj.setAdapter(dataLoggingAdapter);
        obj = (RecyclerView) this.f27484a.mo7727a(C1761R.id.list);
        Intrinsics.m26843a(obj, "list");
        obj.setLayoutManager(new LinearLayoutManager(this.f27484a, 1, false));
        EditText editText = (EditText) this.f27484a.mo7727a(C1761R.id.filter);
        if (editText == null) {
            Intrinsics.m26842a();
        }
        RxTextView.b(editText).observeOn(SchedulerProvider.m23887c()).subscribe((Consumer) new Consumer<TextViewAfterTextChangeEvent>() {
            public final /* synthetic */ void accept(Object obj) {
                dataLoggingAdapter.getFilter().filter(((TextViewAfterTextChangeEvent) obj).b());
            }
        });
    }
}
