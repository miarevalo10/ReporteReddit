package com.reddit.social.presentation.contacts.view;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactsScreen.kt */
final class ContactsScreen$showInviteToChannelDialog$1 extends Lambda implements Function2<DialogInterface, Integer, Unit> {
    final /* synthetic */ ContactsScreen f37523a;
    final /* synthetic */ String f37524b;

    ContactsScreen$showInviteToChannelDialog$1(ContactsScreen contactsScreen, String str) {
        this.f37523a = contactsScreen;
        this.f37524b = str;
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        DialogInterface dialogInterface = (DialogInterface) obj;
        ((Number) obj2).intValue();
        Intrinsics.m26847b(dialogInterface, "<anonymous parameter 0>");
        this.f37523a.m41266w().mo5149e(this.f37524b);
        return Unit.f25273a;
    }
}
