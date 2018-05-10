package com.reddit.social.presentation.contacts.presentation;

import com.reddit.social.presentation.contacts.ContactsContract.View;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactsPresenter.kt */
final class ContactsPresenter$verifyUser$1<T> implements Consumer<String> {
    final /* synthetic */ ContactsPresenter f29705a;
    final /* synthetic */ String f29706b;

    ContactsPresenter$verifyUser$1(ContactsPresenter contactsPresenter, String str) {
        this.f29705a = contactsPresenter;
        this.f29706b = str;
    }

    public final /* synthetic */ void accept(Object obj) {
        String str = (String) obj;
        View a = ContactsPresenter.m30713a(this.f29705a);
        String str2 = this.f29706b;
        Intrinsics.m26843a((Object) str, "it");
        a.mo7526a(str2, str);
    }
}
