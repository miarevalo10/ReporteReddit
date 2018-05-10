package com.reddit.frontpage.presentation.modtools.mute.add;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public final class AddMutedUserScreen_ViewBinding implements Unbinder {
    private AddMutedUserScreen f28690b;
    private View f28691c;
    private TextWatcher f28692d;

    public AddMutedUserScreen_ViewBinding(final AddMutedUserScreen addMutedUserScreen, View view) {
        this.f28690b = addMutedUserScreen;
        addMutedUserScreen.title = (TextView) Utils.b(view, C1761R.id.title, "field 'title'", TextView.class);
        View a = Utils.a(view, C1761R.id.username, "field 'username' and method 'onUsernameTextChanged'");
        addMutedUserScreen.username = (EditText) Utils.c(a, C1761R.id.username, "field 'username'", EditText.class);
        this.f28691c = a;
        this.f28692d = new TextWatcher(this) {
            final /* synthetic */ AddMutedUserScreen_ViewBinding f20916b;

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                addMutedUserScreen.onUsernameTextChanged(charSequence);
            }
        };
        ((TextView) a).addTextChangedListener(this.f28692d);
        addMutedUserScreen.modNote = (EditText) Utils.b(view, C1761R.id.note, "field 'modNote'", EditText.class);
    }

    public final void m29800a() {
        AddMutedUserScreen addMutedUserScreen = this.f28690b;
        if (addMutedUserScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28690b = null;
        addMutedUserScreen.title = null;
        addMutedUserScreen.username = null;
        addMutedUserScreen.modNote = null;
        ((TextView) this.f28691c).removeTextChangedListener(this.f28692d);
        this.f28692d = null;
        this.f28691c = null;
    }
}
