package com.instabug.bug.view.p004c;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.instabug.bug.C0474d;
import com.instabug.bug.extendedbugreport.ExtendedBugReport.State;
import com.instabug.bug.model.C0477a;
import com.instabug.bug.settings.C0485a;
import com.instabug.bug.view.SuccessActivity;
import com.instabug.bug.view.p004c.C0511a.C1287b;
import com.instabug.library.C0593R;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.ToolbarFragment;
import com.instabug.library.util.LocaleUtils;
import java.util.List;

/* compiled from: ExtraFieldsFragment */
public class C1729b extends ToolbarFragment<C1629c> implements C1287b {
    List<C0477a> f19733a;
    private String f19734b;

    /* compiled from: ExtraFieldsFragment */
    public static class C0512a implements TextWatcher {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    protected void onCloseButtonClicked() {
    }

    public static C1729b m21289a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        str = new C1729b();
        str.setArguments(bundle);
        return str;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            getActivity().getWindow().setSoftInputMode(2);
        }
        this.f19734b = getArguments().getString("title");
        this.presenter = new C1629c(this);
    }

    protected int getContentLayout() {
        return C0593R.layout.instabug_lyt_extra_fields;
    }

    protected void initContentViews(View view, Bundle bundle) {
        this.toolbarImageButtonClose.setImageDrawable(ContextCompat.m714a(getContext(), C0593R.drawable.instabug_ic_back));
        if (LocaleUtils.isRTL(Instabug.getLocale(getContext())) != null) {
            this.toolbarImageButtonClose.setRotation(180.0f);
        }
        this.toolbarImageButtonDone.setImageDrawable(ContextCompat.m714a(getContext(), C0593R.drawable.instabug_ic_send));
        this.toolbarImageButtonDone.setColorFilter(new PorterDuffColorFilter(InstabugCore.getPrimaryColor(), Mode.SRC_IN));
        m21290a();
    }

    protected String getTitle() {
        return this.f19734b;
    }

    protected void onDoneButtonClicked() {
        if (((C1629c) this.presenter).m19381c()) {
            List<C0477a> list = this.f19733a;
            C0485a.m7793a();
            State q = C0485a.m7826q();
            if (q != State.ENABLED_WITH_OPTIONAL_FIELDS) {
                if (q != State.ENABLED_WITH_REQUIRED_FIELDS) {
                    String str = C0474d.m7762a().f9100a.f15313d;
                    StringBuilder stringBuilder = new StringBuilder();
                    if (str != null) {
                        stringBuilder.append(str);
                    }
                    for (C0477a c0477a : list) {
                        if (stringBuilder.length() > 0) {
                            stringBuilder.append("\n");
                        }
                        stringBuilder.append(c0477a.f9105b);
                        stringBuilder.append(":");
                        stringBuilder.append("\n");
                        stringBuilder.append(c0477a.f9107d);
                    }
                    C0474d.m7762a().f9100a.f15313d = stringBuilder.toString();
                    C1629c.m19379b();
                    C0474d.m7762a().m7770b(getContext());
                    C0485a.m7793a();
                    if (C0485a.m7822m()) {
                        finishActivity();
                        return;
                    }
                    finishActivity();
                    getActivity().startActivity(SuccessActivity.m21610a(getContext()));
                }
            }
            C1629c.m19378a(list);
            C0474d.m7762a().m7770b(getContext());
            C0485a.m7793a();
            if (C0485a.m7822m()) {
                finishActivity();
                return;
            }
            finishActivity();
            getActivity().startActivity(SuccessActivity.m21610a(getContext()));
        }
    }

    private void m21290a() {
        this.f19733a = ((C1629c) this.presenter).m19380a();
        LinearLayout linearLayout = (LinearLayout) findViewById(C0593R.id.linearLayout);
        for (int i = 0; i < this.f19733a.size(); i++) {
            CharSequence valueOf;
            EditText editText = (EditText) LayoutInflater.from(getContext()).inflate(C0593R.layout.instabug_lyt_extra_field, linearLayout, false);
            editText.setId(i);
            if (((C0477a) this.f19733a.get(i)).f9108e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(((C0477a) this.f19733a.get(i)).f9105b);
                stringBuilder.append(" *");
                valueOf = String.valueOf(stringBuilder.toString());
            } else {
                valueOf = ((C0477a) this.f19733a.get(i)).f9105b;
            }
            editText.setHint(valueOf);
            editText.setText(((C0477a) this.f19733a.get(i)).f9107d);
            editText.addTextChangedListener(new C0512a(this) {
                final /* synthetic */ C1729b f15346b;

                public void afterTextChanged(Editable editable) {
                    ((C0477a) this.f15346b.f19733a.get(i)).f9107d = editable.toString();
                }
            });
            linearLayout.addView(editText);
        }
    }

    public final void mo4315a(int i) {
        C0477a c0477a = (C0477a) this.f19733a.get(i);
        CharSequence string = getString(C0593R.string.instabug_err_invalid_extra_field, c0477a.f9105b);
        EditText editText = (EditText) findViewById(i);
        editText.requestFocus();
        editText.setError(string);
    }
}
