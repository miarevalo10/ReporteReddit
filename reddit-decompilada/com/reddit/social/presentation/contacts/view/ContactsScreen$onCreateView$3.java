package com.reddit.social.presentation.contacts.view;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.reddit.social.presentation.contacts.ContactsContract.Presenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "action", "", "keyEvent", "Landroid/view/KeyEvent;", "onEditorAction"}, k = 3, mv = {1, 1, 9})
/* compiled from: ContactsScreen.kt */
final class ContactsScreen$onCreateView$3 implements OnEditorActionListener {
    final /* synthetic */ ContactsScreen f22347a;

    ContactsScreen$onCreateView$3(ContactsScreen contactsScreen) {
        this.f22347a = contactsScreen;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            Presenter w = this.f22347a.m41266w();
            Intrinsics.m26843a((Object) textView, "textView");
            CharSequence text = textView.getText();
            Intrinsics.m26843a((Object) text, "textView.text");
            if (w.mo5140a(text, ContactsScreen.m41234a(this.f22347a))) {
                ContactsCompletionView contactsCompletionView = this.f22347a.contactsCompletionView;
                if (contactsCompletionView == null) {
                    Intrinsics.m26844a("contactsCompletionView");
                }
                return contactsCompletionView.onEditorAction(textView, i, keyEvent);
            }
        }
        return true;
    }
}
