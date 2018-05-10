package com.reddit.social.presentation.contacts.presentation;

import com.reddit.datalibrary.social.model.User;
import com.reddit.social.presentation.presentationobjects.ContactData;
import com.reddit.social.presentation.presentationobjects.UserStatus;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "contactDatas", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactsPresenter.kt */
final class ContactsPresenter$getContacts$4<T, R> implements Function<T, R> {
    final /* synthetic */ ContactsPresenter f29700a;

    ContactsPresenter$getContacts$4(ContactsPresenter contactsPresenter) {
        this.f29700a = contactsPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        List<ContactData> list = (List) obj;
        Intrinsics.m26847b(list, "contactDatas");
        Iterable<User> c = this.f29700a.f29717i;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(c));
        for (User user_id : c) {
            arrayList.add(user_id.getUser_id());
        }
        List list2 = (List) arrayList;
        for (ContactData contactData : list) {
            contactData.f29930d = list2.contains(contactData.f29929c);
            contactData.m30886a(UserStatus.f22472b);
        }
        return list;
    }
}
