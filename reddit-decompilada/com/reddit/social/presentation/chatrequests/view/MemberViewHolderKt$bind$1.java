package com.reddit.social.presentation.chatrequests.view;

import android.view.View;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: MemberViewHolder.kt */
final class MemberViewHolderKt$bind$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ PublishSubject f37513a;
    final /* synthetic */ UserData f37514b;

    MemberViewHolderKt$bind$1(PublishSubject publishSubject, UserData userData) {
        this.f37513a = publishSubject;
        this.f37514b = userData;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        this.f37513a.onNext(this.f37514b);
        return Unit.f25273a;
    }
}
