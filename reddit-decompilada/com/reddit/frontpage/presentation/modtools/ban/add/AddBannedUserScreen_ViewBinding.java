package com.reddit.frontpage.presentation.modtools.ban.add;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public final class AddBannedUserScreen_ViewBinding implements Unbinder {
    private AddBannedUserScreen f28573b;
    private View f28574c;
    private TextWatcher f28575d;
    private View f28576e;
    private TextWatcher f28577f;
    private View f28578g;

    public AddBannedUserScreen_ViewBinding(final AddBannedUserScreen addBannedUserScreen, View view) {
        this.f28573b = addBannedUserScreen;
        addBannedUserScreen.title = (TextView) Utils.b(view, C1761R.id.title, "field 'title'", TextView.class);
        View a = Utils.a(view, C1761R.id.username, "field 'username' and method 'onUsernameTextChanged'");
        addBannedUserScreen.username = (EditText) Utils.c(a, C1761R.id.username, "field 'username'", EditText.class);
        this.f28574c = a;
        this.f28575d = new TextWatcher(this) {
            final /* synthetic */ AddBannedUserScreen_ViewBinding f20888b;

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                addBannedUserScreen.onUsernameTextChanged(charSequence);
            }
        };
        ((TextView) a).addTextChangedListener(this.f28575d);
        addBannedUserScreen.reason = (EditText) Utils.b(view, C1761R.id.reason_edittext, "field 'reason'", EditText.class);
        addBannedUserScreen.modNote = (EditText) Utils.b(view, C1761R.id.modnote_edittext, "field 'modNote'", EditText.class);
        a = Utils.a(view, C1761R.id.duration_edittext, "field 'durationEditText' and method 'onDurationTextChanged'");
        addBannedUserScreen.durationEditText = (EditText) Utils.c(a, C1761R.id.duration_edittext, "field 'durationEditText'", EditText.class);
        this.f28576e = a;
        this.f28577f = new TextWatcher(this) {
            final /* synthetic */ AddBannedUserScreen_ViewBinding f20890b;

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                addBannedUserScreen.onDurationTextChanged(charSequence);
            }
        };
        ((TextView) a).addTextChangedListener(this.f28577f);
        a = Utils.a(view, C1761R.id.permanent_radio_button, "field 'permanentRadioButon' and method 'onClick'");
        addBannedUserScreen.permanentRadioButon = (CheckBox) Utils.c(a, C1761R.id.permanent_radio_button, "field 'permanentRadioButon'", CheckBox.class);
        this.f28578g = a;
        a.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ AddBannedUserScreen_ViewBinding f28572c;

            public final void m29747a() {
                addBannedUserScreen.onClick();
            }
        });
        addBannedUserScreen.banMessage = (EditText) Utils.b(view, C1761R.id.ban_message_edittext, "field 'banMessage'", EditText.class);
        addBannedUserScreen.bannedForTitle = (TextView) Utils.b(view, C1761R.id.banned_for_title, "field 'bannedForTitle'", TextView.class);
        addBannedUserScreen.bannedForStub = (ViewStub) Utils.b(view, C1761R.id.banned_for_stub, "field 'bannedForStub'", ViewStub.class);
        addBannedUserScreen.commentView = (BannedForCommentView) Utils.a(view, C1761R.id.banned_for_comment, "field 'commentView'", BannedForCommentView.class);
    }

    public final void m29748a() {
        AddBannedUserScreen addBannedUserScreen = this.f28573b;
        if (addBannedUserScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28573b = null;
        addBannedUserScreen.title = null;
        addBannedUserScreen.username = null;
        addBannedUserScreen.reason = null;
        addBannedUserScreen.modNote = null;
        addBannedUserScreen.durationEditText = null;
        addBannedUserScreen.permanentRadioButon = null;
        addBannedUserScreen.banMessage = null;
        addBannedUserScreen.bannedForTitle = null;
        addBannedUserScreen.bannedForStub = null;
        addBannedUserScreen.commentView = null;
        ((TextView) this.f28574c).removeTextChangedListener(this.f28575d);
        this.f28575d = null;
        this.f28574c = null;
        ((TextView) this.f28576e).removeTextChangedListener(this.f28577f);
        this.f28577f = null;
        this.f28576e = null;
        this.f28578g.setOnClickListener(null);
        this.f28578g = null;
    }
}
