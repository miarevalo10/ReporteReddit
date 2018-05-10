package com.reddit.social.presentation.contacts.presentation;

import com.reddit.social.presentation.presentationobjects.ContactData;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactsPresenter.kt */
final class ContactsPresenter$getContacts$2<T> implements Consumer<List<? extends ContactData>> {
    final /* synthetic */ ContactsPresenter f29698a;

    ContactsPresenter$getContacts$2(ContactsPresenter contactsPresenter) {
        this.f29698a = contactsPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        List list = (List) obj;
        ContactsPresenter contactsPresenter = this.f29698a;
        Intrinsics.m26843a((Object) list, "it");
        contactsPresenter.f29719k = list;
    }
}
