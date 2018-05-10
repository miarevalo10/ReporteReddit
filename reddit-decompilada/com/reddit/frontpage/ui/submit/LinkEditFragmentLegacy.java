package com.reddit.frontpage.ui.submit;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.job.EditLinkJob.CancelEvent;
import com.reddit.datalibrary.frontpage.job.EditLinkJob.ResultEvent;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkEditResponse.LinkEditList;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.detail.LinkEditCache;
import com.reddit.frontpage.ui.detail.LinkEditCache.BodyEditCacheEntry;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.ViewUtils;

public class LinkEditFragmentLegacy extends EditFragmentLegacy {
    @State(ParcelerBundler.class)
    Link link;

    public final int mo7468b() {
        return C1761R.string.title_edit_link;
    }

    public static LinkEditFragmentLegacy m41088a(Link link) {
        LinkEditFragmentLegacy linkEditFragmentLegacy = new LinkEditFragmentLegacy();
        linkEditFragmentLegacy.link = link;
        return linkEditFragmentLegacy;
    }

    public final String mo7467a() {
        if (this.link == null) {
            return "";
        }
        String str;
        BodyEditCacheEntry bodyEditCacheEntry = (BodyEditCacheEntry) LinkEditCache.getLinkBodyEditCache().get(this.link.getName());
        if (bodyEditCacheEntry != null) {
            str = bodyEditCacheEntry.f21172a;
        } else {
            str = this.link.getSelfText();
        }
        return str;
    }

    public final void mo7469c() {
        LinkUtil.m23783a(SessionManager.b().c, this.link != null ? this.link.getName() : "", this.a.getText().toString(), this.editIdentifier);
    }

    public void onEventMainThread(ResultEvent resultEvent) {
        if (TextUtils.equals(resultEvent.a, this.editIdentifier)) {
            this.b.dismiss();
            if (resultEvent.b.a()) {
                Snackbar.a(this.e, resultEvent.b.b(), -1).a();
                return;
            }
            BaseActivity baseActivity = (BaseActivity) getActivity();
            if (baseActivity != null) {
                Intent intent = new Intent();
                Link link = (Link) ((LinkWrapper) ((LinkEditList) resultEvent.b.json.data).things.get(0)).getData();
                LinkEditCache.getLinkBodyEditCache().put(link.getName(), new BodyEditCacheEntry(link.getSelfText(), link.getSelfTextHtml()));
                baseActivity.setResult(-1, intent);
                baseActivity.finish();
            }
        }
    }

    public void onEventMainThread(CancelEvent cancelEvent) {
        if (TextUtils.equals(cancelEvent.a, this.editIdentifier) != null) {
            this.b.dismiss();
            ViewUtils.m24059a(this.e, (int) C1761R.string.error_network_error, -1).a();
        }
    }
}
