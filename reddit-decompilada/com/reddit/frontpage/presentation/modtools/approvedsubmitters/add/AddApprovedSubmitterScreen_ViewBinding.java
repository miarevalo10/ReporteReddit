package com.reddit.frontpage.presentation.modtools.approvedsubmitters.add;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public final class AddApprovedSubmitterScreen_ViewBinding implements Unbinder {
    private AddApprovedSubmitterScreen f28557b;
    private View f28558c;
    private TextWatcher f28559d;

    public AddApprovedSubmitterScreen_ViewBinding(final AddApprovedSubmitterScreen addApprovedSubmitterScreen, View view) {
        this.f28557b = addApprovedSubmitterScreen;
        view = Utils.a(view, C1761R.id.username, "field 'username' and method 'onUsernameTextChanged'");
        addApprovedSubmitterScreen.username = (EditText) Utils.c(view, C1761R.id.username, "field 'username'", EditText.class);
        this.f28558c = view;
        this.f28559d = new TextWatcher(this) {
            final /* synthetic */ AddApprovedSubmitterScreen_ViewBinding f20875b;

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                addApprovedSubmitterScreen.onUsernameTextChanged(charSequence);
            }
        };
        ((TextView) view).addTextChangedListener(this.f28559d);
    }

    public final void m29744a() {
        AddApprovedSubmitterScreen addApprovedSubmitterScreen = this.f28557b;
        if (addApprovedSubmitterScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28557b = null;
        addApprovedSubmitterScreen.username = null;
        ((TextView) this.f28558c).removeTextChangedListener(this.f28559d);
        this.f28559d = null;
        this.f28558c = null;
    }
}
