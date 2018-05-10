package com.reddit.frontpage.ui.submit;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.evernote.android.state.State;
import com.livefront.bridge.Bridge;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import java.util.UUID;

public abstract class EditFragmentLegacy extends BaseFrontpageFragment {
    protected EditText f39345a;
    AlertDialog f39346b = null;
    @State
    String editIdentifier;

    public abstract String mo7467a();

    public abstract int mo7468b();

    public abstract void mo7469c();

    protected boolean mo7470d() {
        return true;
    }

    public final int mo7160h() {
        return C1761R.layout.fragment_edit;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Toolbar toolbar = (Toolbar) this.e.findViewById(C1761R.id.toolbar);
        this.f39345a = (EditText) this.e.findViewById(C1761R.id.edit_text);
        setHasOptionsMenu(true);
        BaseActivity baseActivity = (BaseActivity) getActivity();
        baseActivity.a(toolbar);
        baseActivity.c().a().c(false);
        baseActivity.c().a().b(true);
        ((TextView) toolbar.findViewById(C1761R.id.toolbar_title)).setText(mo7468b());
        this.f39345a.setText(mo7467a());
        baseActivity.getWindow().setSoftInputMode(4);
        this.f39345a.requestFocus();
        if (bundle != null) {
            Bridge.a(this, bundle);
        } else {
            this.editIdentifier = UUID.randomUUID().toString();
        }
        return this.e;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C1761R.menu.menu_submit, menu);
        menu = menu.findItem(C1761R.id.action_submit);
        ((TextView) menu.getActionView().findViewById(C1761R.id.menu_item_text)).setText(getResources().getString(C1761R.string.action_post));
        menu.getActionView().setOnClickListener(new EditFragmentLegacy$$Lambda$0(this, menu));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            getActivity().setResult(0);
            getActivity().finish();
            return true;
        } else if (itemId != C1761R.id.action_submit) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            if (mo7470d() != null) {
                this.f39346b = RedditAlertDialog.m23309a(getActivity(), (int) C1761R.string.title_updating, false);
                this.f39346b.show();
                mo7469c();
            } else {
                m37509b(getString(C1761R.string.error_message_missing));
            }
            return true;
        }
    }
}
