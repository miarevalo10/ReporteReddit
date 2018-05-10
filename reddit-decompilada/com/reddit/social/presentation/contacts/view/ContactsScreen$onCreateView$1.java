package com.reddit.social.presentation.contacts.view;

import com.reddit.social.presentation.contacts.ContactsContract.Presenter;
import com.reddit.social.presentation.presentationobjects.ContactData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactsScreen.kt */
final class ContactsScreen$onCreateView$1 extends Lambda implements Function1<ContactData, Unit> {
    final /* synthetic */ ContactsScreen f37520a;

    ContactsScreen$onCreateView$1(ContactsScreen contactsScreen) {
        this.f37520a = contactsScreen;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ContactData contactData = (ContactData) obj;
        Presenter w = this.f37520a.m41266w();
        Intrinsics.m26843a((Object) contactData, "it");
        w.mo5136a(contactData);
        return Unit.f25273a;
    }
}
