package com.reddit.frontpage.ui.submit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.livefront.bridge.Bridge;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.requests.models.Replyable;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentReplyResponse.CommentReplyList;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.ReplyableWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.service.api.ReplyService;
import com.reddit.datalibrary.frontpage.service.api.ReplyService.ReplyErrorEvent;
import com.reddit.datalibrary.frontpage.service.api.ReplyService.ReplyResultEvent;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.widgets.submit.ReplyablePreview;
import de.greenrobot.event.EventBus;
import java.util.List;
import java.util.UUID;
import timber.log.Timber;

public abstract class ReplyFragmentLegacy extends BaseFrontpageFragment {
    AlertDialog f39353a = null;
    private Thing f39354b;
    @State
    String mReplyIdentifier;
    @BindView
    FrameLayout mTargetContainer;
    @BindView
    EditText replyText;
    @BindView
    Toolbar toolbar;

    public static class ReplyEvent extends BaseEvent {
        public final ReplyableWrapper f29328a;

        public ReplyEvent(ReplyableWrapper replyableWrapper) {
            this.f29328a = replyableWrapper;
        }
    }

    public abstract View mo7471a();

    public abstract Replyable mo7472b();

    public abstract int mo7473c();

    protected abstract int mo7474d();

    protected abstract int mo7475e();

    protected int mo7486f() {
        return C1761R.string.action_post;
    }

    public final int mo7160h() {
        return C1761R.layout.fragment_reply;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        setHasOptionsMenu(true);
        BaseActivity baseActivity = (BaseActivity) getActivity();
        baseActivity.a(this.toolbar);
        baseActivity.c().a().c(false);
        baseActivity.c().a().b(true);
        baseActivity.c().a().f();
        ((TextView) this.toolbar.findViewById(C1761R.id.toolbar_title)).setText(mo7473c());
        baseActivity.getWindow().setSoftInputMode(4);
        this.replyText.requestFocus();
        layoutInflater = mo7471a();
        ((ReplyablePreview) layoutInflater).getQuoteActionModeCallback().f22027a = new ReplyFragmentLegacy$$Lambda$0(this);
        this.mTargetContainer.addView(layoutInflater);
        this.f39354b = (Thing) mo7472b();
        if (bundle != null) {
            Bridge.a(this, bundle);
        } else {
            this.mReplyIdentifier = UUID.randomUUID().toString();
        }
        this.replyText.setHint(mo7474d());
        return this.e;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C1761R.menu.menu_submit, menu);
        menu = menu.findItem(C1761R.id.action_submit);
        ((TextView) menu.getActionView().findViewById(C1761R.id.menu_item_text)).setText(getResources().getString(mo7486f()));
        menu.getActionView().setOnClickListener(new ReplyFragmentLegacy$$Lambda$1(this, menu));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            m39560g();
            return true;
        } else if (itemId != C1761R.id.action_submit) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            if (TextUtils.isEmpty(this.replyText.getText().toString().trim()) != null) {
                m37509b(getString(C1761R.string.error_message_missing));
                menuItem = null;
            } else {
                menuItem = 1;
            }
            if (menuItem != null) {
                menuItem = new Intent(getContext(), ReplyService.class);
                menuItem.putExtra("thing_name", this.f39354b.getName());
                menuItem.putExtra("reply_text", this.replyText.getText().toString());
                menuItem.putExtra("reply_identifier", this.mReplyIdentifier);
                this.f39353a = RedditAlertDialog.m23309a(getActivity(), (int) C1761R.string.title_replying, false);
                this.f39353a.setOnDismissListener(new ReplyFragmentLegacy$$Lambda$3(this));
                this.f39353a.setOnCancelListener(new ReplyFragmentLegacy$$Lambda$4(this));
                this.f39353a.show();
                getActivity().startService(menuItem);
            }
            return true;
        }
    }

    private void m39560g() {
        if (this.replyText.getText().toString().trim().length() > 0) {
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(getContext(), true);
            redditAlertDialog.f21113a.a(mo7475e()).a(C1761R.string.action_discard, new ReplyFragmentLegacy$$Lambda$2(this)).b(C1761R.string.action_edit, null);
            redditAlertDialog.m23323a();
            return;
        }
        getActivity().finish();
    }

    public void onEventMainThread(ReplyResultEvent replyResultEvent) {
        if (TextUtils.equals(replyResultEvent.replyIdentifier, this.mReplyIdentifier)) {
            this.f39353a.dismiss();
            if (replyResultEvent.response.a()) {
                List list = (List) replyResultEvent.response.json.errors.get(0);
                if (TextUtils.equals((CharSequence) list.get(2), "text")) {
                    this.replyText.setError((CharSequence) list.get(1));
                    return;
                } else {
                    Snackbar.a(this.e, (CharSequence) list.get(1), -1).a();
                    return;
                }
            }
            EventBus.getDefault().postSticky(new ReplyEvent((CommentWrapper) ((CommentReplyList) replyResultEvent.response.json.data).things.get(0)));
            BaseActivity baseActivity = (BaseActivity) getActivity();
            if (baseActivity != null) {
                baseActivity.setResult(-1);
                baseActivity.finish();
            }
        }
    }

    public final void mo7249a(ErrorEvent errorEvent) {
        if ((errorEvent instanceof ReplyErrorEvent) && TextUtils.equals(((ReplyErrorEvent) errorEvent).replyIdentifier, this.mReplyIdentifier)) {
            if (this.f39353a != null) {
                this.f39353a.dismiss();
            }
            Snackbar.a(this.e, getString(C1761R.string.error_fallback_message), -1).a();
            Timber.c(errorEvent.exception, "Reply error. Showing fallback error message", new Object[0]);
            return;
        }
        super.mo7249a(errorEvent);
    }

    public final boolean mo7172k() {
        m39560g();
        return true;
    }
}
