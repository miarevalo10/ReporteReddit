package com.reddit.social.presentation.contacts.presentation;

import com.reddit.social.presentation.presentationobjects.ContactData;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactsPresenter.kt */
final class ContactsPresenter$getContacts$3<T, R> implements Function<T, R> {
    final /* synthetic */ ContactsPresenter f29699a;

    ContactsPresenter$getContacts$3(ContactsPresenter contactsPresenter) {
        this.f29699a = contactsPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.m26847b(list, "it");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            ContactData contactData = (ContactData) next;
            Iterable<UserData> b = this.f29699a.f29718j;
            Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(b));
            for (UserData userData : b) {
                arrayList2.add(userData.f22464a);
            }
            if ((CollectionsKt___CollectionsKt.m41420a((Iterable) (List) arrayList2, (Object) contactData.f29929c) ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }
}
