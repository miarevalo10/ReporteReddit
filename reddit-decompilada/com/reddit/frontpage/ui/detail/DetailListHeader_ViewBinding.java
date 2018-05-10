package com.reddit.frontpage.ui.detail;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.listing.newcard.LinkFlairView;
import com.reddit.frontpage.widgets.BaseHtmlTextView;
import com.reddit.frontpage.widgets.LinkFooterView;

public class DetailListHeader_ViewBinding implements Unbinder {
    private DetailListHeader f28951b;

    public DetailListHeader_ViewBinding(DetailListHeader detailListHeader, View view) {
        this.f28951b = detailListHeader;
        detailListHeader.headerMetadataStub = (ViewStub) Utils.b(view, C1761R.id.detail_header_meta_stub, "field 'headerMetadataStub'", ViewStub.class);
        detailListHeader.linkTitle = (TextView) Utils.b(view, C1761R.id.link_title, "field 'linkTitle'", TextView.class);
        detailListHeader.flairView = (LinkFlairView) Utils.b(view, C1761R.id.link_flair, "field 'flairView'", LinkFlairView.class);
        detailListHeader.contentPreviewContainer = (FrameLayout) Utils.b(view, C1761R.id.content_preview_container, "field 'contentPreviewContainer'", FrameLayout.class);
        detailListHeader.selfTextView = (BaseHtmlTextView) Utils.b(view, C1761R.id.self_text, "field 'selfTextView'", BaseHtmlTextView.class);
        detailListHeader.viewCount = (TextView) Utils.b(view, C1761R.id.link_view_count, "field 'viewCount'", TextView.class);
        detailListHeader.commentStackContainer = (ViewGroup) Utils.b(view, C1761R.id.comment_stack_container, "field 'commentStackContainer'", ViewGroup.class);
        detailListHeader.commentBar = (LinkFooterView) Utils.b(view, C1761R.id.comment_bar, "field 'commentBar'", LinkFooterView.class);
        detailListHeader.sortBar = (TextView) Utils.b(view, C1761R.id.sort_listing, "field 'sortBar'", TextView.class);
        detailListHeader.sortBarContainer = (FrameLayout) Utils.b(view, C1761R.id.sort_bar_container, "field 'sortBarContainer'", FrameLayout.class);
        detailListHeader.singleCommentThreadContainer = (RelativeLayout) Utils.b(view, C1761R.id.single_comment_thread_container, "field 'singleCommentThreadContainer'", RelativeLayout.class);
        detailListHeader.viewAll = (TextView) Utils.b(view, C1761R.id.view_all_title, "field 'viewAll'", TextView.class);
        detailListHeader.modMode = (ImageView) Utils.b(view, C1761R.id.mod_mode, "field 'modMode'", ImageView.class);
        detailListHeader.clickContainer = (LinearLayout) Utils.b(view, C1761R.id.click_container, "field 'clickContainer'", LinearLayout.class);
    }

    public final void m30012a() {
        DetailListHeader detailListHeader = this.f28951b;
        if (detailListHeader == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28951b = null;
        detailListHeader.headerMetadataStub = null;
        detailListHeader.linkTitle = null;
        detailListHeader.flairView = null;
        detailListHeader.contentPreviewContainer = null;
        detailListHeader.selfTextView = null;
        detailListHeader.viewCount = null;
        detailListHeader.commentStackContainer = null;
        detailListHeader.commentBar = null;
        detailListHeader.sortBar = null;
        detailListHeader.sortBarContainer = null;
        detailListHeader.singleCommentThreadContainer = null;
        detailListHeader.viewAll = null;
        detailListHeader.modMode = null;
        detailListHeader.clickContainer = null;
    }
}
