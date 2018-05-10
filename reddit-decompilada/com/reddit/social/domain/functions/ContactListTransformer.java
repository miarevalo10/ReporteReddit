package com.reddit.social.domain.functions;

import com.reddit.datalibrary.social.model.Contact;
import com.reddit.social.presentation.presentationobjects.ContactData;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002:\u0012*\u0012(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u0001B\u0005¢\u0006\u0002\u0010\u000bJ<\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u00032,\u0010\u000f\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t0\u0002H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/reddit/social/domain/functions/ContactListTransformer;", "Lio/reactivex/functions/Function;", "Lkotlin/Pair;", "", "Lcom/reddit/datalibrary/social/model/Contact;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "()V", "contactTransformer", "Lcom/reddit/social/domain/functions/ContactTransformer;", "apply", "contactsInfo", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ContactListTransformer.kt */
public final class ContactListTransformer implements Function<Pair<? extends List<? extends Contact>, ? extends Map<String, ? extends UserData>>, List<? extends ContactData>> {
    private final ContactTransformer f29578a = new ContactTransformer();

    public final /* synthetic */ Object apply(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.m26847b(pair, "contactsInfo");
        List list = (List) pair.f25267a;
        Map map = (Map) pair.f25268b;
        Iterable<Contact> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Contact contact : iterable) {
            Object obj2;
            UserData userData = (UserData) map.get(contact.getUserId());
            Object obj3 = null;
            if (userData != null) {
                obj2 = userData.f22470g;
            } else {
                obj2 = null;
            }
            if (userData != null) {
                obj3 = userData.f22466c;
            }
            arrayList.add(ContactTransformer.m30617a(new Triple(contact, obj2, obj3)));
        }
        return (List) arrayList;
    }
}
