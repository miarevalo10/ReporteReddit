package com.reddit.social.domain.functions;

import com.reddit.datalibrary.social.model.Contact;
import com.reddit.social.presentation.presentationobjects.ContactData;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002$\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012\u0004\u0012\u00020\u00060\u0001B\u0005¢\u0006\u0002\u0010\u0007J&\u0010\b\u001a\u00020\u00062\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/reddit/social/domain/functions/ContactTransformer;", "Lio/reactivex/functions/Function;", "Lkotlin/Triple;", "Lcom/reddit/datalibrary/social/model/Contact;", "", "", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "()V", "apply", "contactUserData", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ContactTransformer.kt */
public final class ContactTransformer implements Function<Triple<? extends Contact, ? extends Boolean, ? extends String>, ContactData> {
    public final /* synthetic */ Object apply(Object obj) {
        return m30617a((Triple) obj);
    }

    public static ContactData m30617a(Triple<Contact, Boolean, String> triple) {
        Intrinsics.m26847b(triple, "contactUserData");
        Contact contact = (Contact) triple.f25269a;
        return new ContactData(contact.getName(), (String) triple.f25271c, contact.getUserId(), null, (Boolean) triple.f25270b, Integer.valueOf(contact.getCommentKarma() + contact.getLinkKarma()), Long.valueOf(contact.getCreatedUtc()), 24);
    }
}
