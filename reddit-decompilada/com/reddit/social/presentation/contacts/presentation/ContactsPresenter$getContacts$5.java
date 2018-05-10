package com.reddit.social.presentation.contacts.presentation;

import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.presentation.presentationobjects.ContactData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactsPresenter.kt */
final class ContactsPresenter$getContacts$5 extends Lambda implements Function1<List<? extends ContactData>, Unit> {
    final /* synthetic */ ContactsPresenter f37516a;

    ContactsPresenter$getContacts$5(ContactsPresenter contactsPresenter) {
        this.f37516a = contactsPresenter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        List list = (List) obj;
        ContactsPresenter contactsPresenter = this.f37516a;
        Intrinsics.m26843a((Object) list, "it");
        contactsPresenter.f29720l = list;
        ContactsPresenter.m30713a(this.f37516a).mo7528a(this.f37516a.f29720l);
        this.f37516a.m30749g();
        ChatAnalytics.m24462a();
        return Unit.f25273a;
    }
}
