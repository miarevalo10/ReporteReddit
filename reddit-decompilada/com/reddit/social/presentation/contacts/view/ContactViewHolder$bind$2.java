package com.reddit.social.presentation.contacts.view;

import android.view.View;
import com.reddit.social.presentation.presentationobjects.ContactData;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactViewHolder.kt */
final class ContactViewHolder$bind$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ PublishSubject f37517a;
    final /* synthetic */ ContactData f37518b;

    ContactViewHolder$bind$2(PublishSubject publishSubject, ContactData contactData) {
        this.f37517a = publishSubject;
        this.f37518b = contactData;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        this.f37517a.onNext(this.f37518b);
        return Unit.f25273a;
    }
}
