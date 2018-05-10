package com.reddit.frontpage.ui.alert;

import android.content.Context;
import android.support.v7.app.AlertDialog.Builder;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/SingleEmitter;", "", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAlertDialog.kt */
final class RedditAlertDialog$Companion$selector$1<T> implements SingleOnSubscribe<T> {
    final /* synthetic */ Context f28891a;
    final /* synthetic */ Collection f28892b;
    final /* synthetic */ int f28893c;

    RedditAlertDialog$Companion$selector$1(Context context, Collection collection, int i) {
        this.f28891a = context;
        this.f28892b = collection;
        this.f28893c = i;
    }

    public final void mo4947a(SingleEmitter<Integer> singleEmitter) {
        Intrinsics.m26847b(singleEmitter, "emitter");
        RedditAlertDialog redditAlertDialog = new RedditAlertDialog(this.f28891a);
        Builder builder = redditAlertDialog.f21113a;
        Collection collection = this.f28892b;
        if (collection == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        Object[] toArray = collection.toArray(new String[0]);
        if (toArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        singleEmitter = builder.a((CharSequence[]) toArray, new RedditAlertDialog$Companion$selector$1$dialogBuilder$1(singleEmitter));
        if (this.f28893c != 0) {
            singleEmitter.a(this.f28893c);
        }
        redditAlertDialog.m23323a();
    }
}
