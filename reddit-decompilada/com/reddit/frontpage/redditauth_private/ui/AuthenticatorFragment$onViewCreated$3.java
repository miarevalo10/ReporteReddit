package com.reddit.frontpage.redditauth_private.ui;

import android.widget.Button;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import com.reddit.frontpage.C1761R;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "textViewAfterTextChangeEvent", "Lcom/jakewharton/rxbinding2/widget/TextViewAfterTextChangeEvent;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: AuthenticatorFragment.kt */
final class AuthenticatorFragment$onViewCreated$3<T> implements Consumer<TextViewAfterTextChangeEvent> {
    final /* synthetic */ AuthenticatorFragment f28841a;

    AuthenticatorFragment$onViewCreated$3(AuthenticatorFragment authenticatorFragment) {
        this.f28841a = authenticatorFragment;
    }

    public final /* synthetic */ void accept(Object obj) {
        Object obj2;
        obj = ((TextViewAfterTextChangeEvent) obj).b();
        if (obj != null) {
            obj = new Regex("\\s").m28146a((CharSequence) obj, "");
            if (obj != null && obj.length() == 6) {
                obj = true;
                obj2 = (Button) this.f28841a.m37492a(C1761R.id.confirm);
                Intrinsics.m26843a(obj2, "confirm");
                obj2.setEnabled(obj);
            }
        }
        obj = null;
        obj2 = (Button) this.f28841a.m37492a(C1761R.id.confirm);
        Intrinsics.m26843a(obj2, "confirm");
        obj2.setEnabled(obj);
    }
}
