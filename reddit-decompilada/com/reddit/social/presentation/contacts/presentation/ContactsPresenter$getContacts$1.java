package com.reddit.social.presentation.contacts.presentation;

import com.reddit.frontpage.util.SessionUtil;
import com.reddit.social.presentation.presentationobjects.ContactData;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactsPresenter.kt */
final class ContactsPresenter$getContacts$1<T, R> implements Function<T, R> {
    public static final ContactsPresenter$getContacts$1 f29697a = new ContactsPresenter$getContacts$1();

    ContactsPresenter$getContacts$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.m26847b(list, "it");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if ((Intrinsics.m26845a(((ContactData) next).f29929c, SessionUtil.m23898d()) ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }
}
