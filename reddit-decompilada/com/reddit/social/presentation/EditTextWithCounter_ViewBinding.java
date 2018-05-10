package com.reddit.social.presentation;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public final class EditTextWithCounter_ViewBinding implements Unbinder {
    private EditTextWithCounter f29597b;

    public EditTextWithCounter_ViewBinding(EditTextWithCounter editTextWithCounter, View view) {
        this.f29597b = editTextWithCounter;
        editTextWithCounter.editText = (EditText) Utils.b(view, C1761R.id.edit_text, "field 'editText'", EditText.class);
        editTextWithCounter.charCounter = (TextView) Utils.b(view, C1761R.id.edit_text_counter, "field 'charCounter'", TextView.class);
    }

    public final void m30625a() {
        EditTextWithCounter editTextWithCounter = this.f29597b;
        if (editTextWithCounter == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29597b = null;
        editTextWithCounter.editText = null;
        editTextWithCounter.charCounter = null;
    }
}
