package com.reddit.social.presentation.contacts.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.anko.sdk21.listeners.__TextWatcher;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lorg/jetbrains/anko/sdk21/listeners/__TextWatcher;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactsScreen.kt */
final class ContactsScreen$onCreateView$6 extends Lambda implements Function1<__TextWatcher, Unit> {
    final /* synthetic */ ContactsScreen f37522a;

    ContactsScreen$onCreateView$6(ContactsScreen contactsScreen) {
        this.f37522a = contactsScreen;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        __TextWatcher org_jetbrains_anko_sdk21_listeners___TextWatcher = (__TextWatcher) obj;
        Intrinsics.m26847b(org_jetbrains_anko_sdk21_listeners___TextWatcher, "$receiver");
        org_jetbrains_anko_sdk21_listeners___TextWatcher.m28426a(new Function4<CharSequence, Integer, Integer, Integer, Unit>() {
            public final /* synthetic */ Object mo6942a(Object obj, Object obj2, Object obj3, Object obj4) {
                CharSequence charSequence = (CharSequence) obj;
                ((Number) obj2).intValue();
                ((Number) obj3).intValue();
                ((Number) obj4).intValue();
                this.f37522a.m41266w().mo5147d(String.valueOf(charSequence));
                return Unit.f25273a;
            }
        });
        return Unit.f25273a;
    }
}
