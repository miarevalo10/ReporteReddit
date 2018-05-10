package com.reddit.social.presentation.contacts.view;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.social.presentation.EditTextWithCounter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactsScreen.kt */
final class ContactsScreen$onCreateView$2 implements OnClickListener {
    final /* synthetic */ ContactsScreen f22346a;

    ContactsScreen$onCreateView$2(ContactsScreen contactsScreen) {
        this.f22346a = contactsScreen;
    }

    public final void onClick(View view) {
        view = this.f22346a.m41266w();
        EditTextWithCounter editTextWithCounter = this.f22346a.groupNameEditText;
        if (editTextWithCounter == null) {
            Intrinsics.m26844a("groupNameEditText");
        }
        Editable text = editTextWithCounter.getEditText().getText();
        view.mo5145c(text != null ? text.toString() : null);
    }
}
