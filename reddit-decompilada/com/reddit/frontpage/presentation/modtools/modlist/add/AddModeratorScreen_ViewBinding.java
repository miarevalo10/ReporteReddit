package com.reddit.frontpage.presentation.modtools.modlist.add;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public final class AddModeratorScreen_ViewBinding implements Unbinder {
    private AddModeratorScreen f28642b;
    private View f28643c;
    private TextWatcher f28644d;
    private View f28645e;
    private View f28646f;
    private View f28647g;
    private View f28648h;
    private View f28649i;
    private View f28650j;
    private View f28651k;

    public AddModeratorScreen_ViewBinding(final AddModeratorScreen addModeratorScreen, View view) {
        this.f28642b = addModeratorScreen;
        addModeratorScreen.title = (TextView) Utils.b(view, C1761R.id.title, "field 'title'", TextView.class);
        View a = Utils.a(view, C1761R.id.username, "field 'username' and method 'onUsernameTextChanged'");
        addModeratorScreen.username = (EditText) Utils.c(a, C1761R.id.username, "field 'username'", EditText.class);
        this.f28643c = a;
        this.f28644d = new TextWatcher(this) {
            final /* synthetic */ AddModeratorScreen_ViewBinding f20909b;

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                addModeratorScreen.onUsernameTextChanged(charSequence);
            }
        };
        ((TextView) a).addTextChangedListener(this.f28644d);
        a = Utils.a(view, C1761R.id.permission_full_button, "field 'fullPermission' and method 'onFullPermissionClicked'");
        addModeratorScreen.fullPermission = (CheckBox) Utils.c(a, C1761R.id.permission_full_button, "field 'fullPermission'", CheckBox.class);
        this.f28645e = a;
        a.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ AddModeratorScreen_ViewBinding f28629c;

            public final void m29776a() {
                addModeratorScreen.onFullPermissionClicked();
            }
        });
        a = Utils.a(view, C1761R.id.permission_access_button, "field 'accessPermission' and method 'onGranularPermissionClicked'");
        addModeratorScreen.accessPermission = (CheckBox) Utils.c(a, C1761R.id.permission_access_button, "field 'accessPermission'", CheckBox.class);
        this.f28646f = a;
        a.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ AddModeratorScreen_ViewBinding f28631c;

            public final void m29777a() {
                addModeratorScreen.onGranularPermissionClicked();
            }
        });
        a = Utils.a(view, C1761R.id.permission_mail_button, "field 'mailPermission' and method 'onGranularPermissionClicked'");
        addModeratorScreen.mailPermission = (CheckBox) Utils.c(a, C1761R.id.permission_mail_button, "field 'mailPermission'", CheckBox.class);
        this.f28647g = a;
        a.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ AddModeratorScreen_ViewBinding f28633c;

            public final void m29778a() {
                addModeratorScreen.onGranularPermissionClicked();
            }
        });
        a = Utils.a(view, C1761R.id.permission_config_button, "field 'configPermission' and method 'onGranularPermissionClicked'");
        addModeratorScreen.configPermission = (CheckBox) Utils.c(a, C1761R.id.permission_config_button, "field 'configPermission'", CheckBox.class);
        this.f28648h = a;
        a.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ AddModeratorScreen_ViewBinding f28635c;

            public final void m29779a() {
                addModeratorScreen.onGranularPermissionClicked();
            }
        });
        a = Utils.a(view, C1761R.id.permission_posts_button, "field 'postsPermission' and method 'onGranularPermissionClicked'");
        addModeratorScreen.postsPermission = (CheckBox) Utils.c(a, C1761R.id.permission_posts_button, "field 'postsPermission'", CheckBox.class);
        this.f28649i = a;
        a.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ AddModeratorScreen_ViewBinding f28637c;

            public final void m29780a() {
                addModeratorScreen.onGranularPermissionClicked();
            }
        });
        a = Utils.a(view, C1761R.id.permission_flair_button, "field 'flairPermission' and method 'onGranularPermissionClicked'");
        addModeratorScreen.flairPermission = (CheckBox) Utils.c(a, C1761R.id.permission_flair_button, "field 'flairPermission'", CheckBox.class);
        this.f28650j = a;
        a.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ AddModeratorScreen_ViewBinding f28639c;

            public final void m29781a() {
                addModeratorScreen.onGranularPermissionClicked();
            }
        });
        view = Utils.a(view, C1761R.id.permission_wiki_button, "field 'wikiPermission' and method 'onGranularPermissionClicked'");
        addModeratorScreen.wikiPermission = (CheckBox) Utils.c(view, C1761R.id.permission_wiki_button, "field 'wikiPermission'", CheckBox.class);
        this.f28651k = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ AddModeratorScreen_ViewBinding f28641c;

            public final void m29782a() {
                addModeratorScreen.onGranularPermissionClicked();
            }
        });
    }

    public final void m29783a() {
        AddModeratorScreen addModeratorScreen = this.f28642b;
        if (addModeratorScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28642b = null;
        addModeratorScreen.title = null;
        addModeratorScreen.username = null;
        addModeratorScreen.fullPermission = null;
        addModeratorScreen.accessPermission = null;
        addModeratorScreen.mailPermission = null;
        addModeratorScreen.configPermission = null;
        addModeratorScreen.postsPermission = null;
        addModeratorScreen.flairPermission = null;
        addModeratorScreen.wikiPermission = null;
        ((TextView) this.f28643c).removeTextChangedListener(this.f28644d);
        this.f28644d = null;
        this.f28643c = null;
        this.f28645e.setOnClickListener(null);
        this.f28645e = null;
        this.f28646f.setOnClickListener(null);
        this.f28646f = null;
        this.f28647g.setOnClickListener(null);
        this.f28647g = null;
        this.f28648h.setOnClickListener(null);
        this.f28648h = null;
        this.f28649i.setOnClickListener(null);
        this.f28649i = null;
        this.f28650j.setOnClickListener(null);
        this.f28650j = null;
        this.f28651k.setOnClickListener(null);
        this.f28651k = null;
    }
}
