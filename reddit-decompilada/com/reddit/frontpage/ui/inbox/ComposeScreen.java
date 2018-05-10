package com.reddit.frontpage.ui.inbox;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.android.volley.VolleyError;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.service.api.ComposeService.ComposeErrorEvent;
import com.reddit.datalibrary.frontpage.service.api.ComposeService.ComposeResultEvent;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import com.reddit.frontpage.util.MessageUtil;
import com.reddit.frontpage.util.Util;
import de.greenrobot.event.EventBus;
import java.util.List;
import java.util.UUID;
import kotlin.Unit;
import org.parceler.Parcel;

public class ComposeScreen extends BaseScreen {
    @State
    boolean isContactingMods;
    @BindView
    TextView prefix;
    @State
    String recipient;
    @BindView
    EditText subject;
    @BindView
    EditText text;
    @BindView
    EditText to;
    AlertDialog f39173v;
    String f39174w;
    MenuItem f39175x;
    TextWatcher f39176y = new C18851(this);

    class C18851 implements TextWatcher {
        final /* synthetic */ ComposeScreen f21233a;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        C18851(ComposeScreen composeScreen) {
            this.f21233a = composeScreen;
        }

        public void afterTextChanged(Editable editable) {
            if (ComposeScreen.m39154a(this.f21233a) != null) {
                this.f21233a.f39175x.setEnabled(true);
            } else {
                this.f21233a.f39175x.setEnabled(false);
            }
        }
    }

    @Parcel
    static class DeepLinker implements ScreenDeepLinker {
        boolean isContactingMods;
        String recipient;

        DeepLinker() {
        }

        public Screen createScreen() {
            return ComposeScreen.m39153a(this.recipient, Boolean.valueOf(this.isContactingMods));
        }
    }

    public String getAnalyticsScreenName() {
        return "inbox_compose";
    }

    public final int mo7141s() {
        return C1761R.layout.fragment_compose;
    }

    public static ComposeScreen m39153a(String str, Boolean bool) {
        if (str != null) {
            str = str.replaceFirst("^/?r/", "");
        }
        ComposeScreen composeScreen = new ComposeScreen();
        composeScreen.recipient = str;
        composeScreen.isContactingMods = bool.booleanValue();
        return composeScreen;
    }

    public static ScreenDeepLinker m39155b(String str, Boolean bool) {
        ScreenDeepLinker deepLinker = new DeepLinker();
        deepLinker.recipient = str;
        deepLinker.isContactingMods = bool.booleanValue();
        return deepLinker;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        n();
        this.f39174w = UUID.randomUUID().toString();
        this.prefix.setText(this.isContactingMods != null ? C1761R.string.hint_subreddit_prefix : C1761R.string.hint_username_prefix);
        this.to.setHint(this.isContactingMods != null ? C1761R.string.hint_subreddit : C1761R.string.hint_username);
        this.to.setText(this.recipient);
        if (TextUtils.isEmpty(this.recipient) != null) {
            this.to.requestFocus();
        } else {
            this.subject.requestFocus();
        }
        this.to.addTextChangedListener(this.f39176y);
        this.subject.addTextChangedListener(this.f39176y);
        this.text.addTextChangedListener(this.f39176y);
        return this.K;
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        if (TextUtils.isEmpty(this.subject.getText()) != null) {
            Util.m23999b(this.subject);
        } else {
            Util.m23999b(this.text);
        }
    }

    protected final void mo7185a(ActionBar actionBar) {
        super.mo7185a(actionBar);
        actionBar.a(C1761R.string.title_compose);
    }

    public final void m39160a(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C1761R.menu.menu_compose, menu);
        this.f39175x = menu.findItem(C1761R.id.action_send);
        this.f39175x.setEnabled(null);
    }

    public final boolean mo7201a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            m39156x();
            return true;
        } else if (itemId != C1761R.id.action_send) {
            return super.mo7201a(menuItem);
        } else {
            if (this.isContactingMods != null) {
                menuItem = Util.m23960a((int) C1761R.string.fmt_contact_mods, this.to.getText().toString());
            } else {
                menuItem = this.to.getText().toString();
            }
            String obj = this.subject.getText().toString();
            String obj2 = this.text.getText().toString();
            this.f39173v = RedditAlertDialog.m23309a(am_(), (int) C1761R.string.title_sending_message, false);
            this.f39173v.setOnDismissListener(new ComposeScreen$$Lambda$1(this));
            this.f39173v.show();
            MessageUtil.m23816a(am_(), this.f39174w, menuItem, obj, obj2);
            return true;
        }
    }

    public final boolean m39163m() {
        m39156x();
        return true;
    }

    private void m39156x() {
        if (TextUtils.isEmpty(this.subject.getText().toString().trim()) && TextUtils.isEmpty(this.text.getText().toString().trim())) {
            m39157y();
        } else {
            RedditAlertDialog.m23322c(am_(), new ComposeScreen$$Lambda$0(this));
        }
    }

    final /* synthetic */ Unit m39165w() {
        m39157y();
        return Unit.f25273a;
    }

    private void m39157y() {
        Util.m23972a(this.K);
        m29351F();
    }

    public void onEventMainThread(ComposeResultEvent composeResultEvent) {
        if (TextUtils.equals(composeResultEvent.requestId, this.f39174w)) {
            if (this.f39173v != null) {
                this.f39173v.dismiss();
            }
            if (composeResultEvent.response.json.errors.size() == 0) {
                ai_();
                return;
            }
            List list = (List) composeResultEvent.response.json.errors.get(0);
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(am_(), (byte) 0);
            redditAlertDialog.f21113a.a(C1761R.string.title_error).b((CharSequence) list.get(1)).a(C1761R.string.action_okay, null);
            redditAlertDialog.m23323a();
        }
    }

    public void onEventMainThread(ComposeErrorEvent composeErrorEvent) {
        if (TextUtils.equals(composeErrorEvent.requestId, this.f39174w)) {
            if (this.f39173v != null) {
                this.f39173v.dismiss();
            }
            Throwable th = composeErrorEvent.exception;
            if (th.getCause() != null && (th.getCause() instanceof VolleyError)) {
                th = th.getCause();
            }
            if (th instanceof VolleyError) {
                composeErrorEvent = Screens.m22629a(this, Util.m24027f((int) C1761R.string.error_send_message), -1);
                if (composeErrorEvent != null) {
                    composeErrorEvent.a();
                }
                return;
            }
            EventBus.getDefault().post(new ErrorEvent(composeErrorEvent.exception));
        }
    }

    static /* synthetic */ boolean m39154a(ComposeScreen composeScreen) {
        CharSequence a;
        if (composeScreen.isContactingMods) {
            a = Util.m23960a((int) C1761R.string.fmt_contact_mods, composeScreen.to.getText().toString());
        } else {
            a = composeScreen.to.getText().toString();
        }
        return (TextUtils.isEmpty(a) || TextUtils.isEmpty(composeScreen.subject.getText().toString()) || TextUtils.isEmpty(composeScreen.text.getText().toString()) != null) ? false : true;
    }
}
