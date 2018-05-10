package com.reddit.frontpage.ui.detail;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;

public class BaseDetailScreen_ViewBinding implements Unbinder {
    private BaseDetailScreen f28950b;

    public BaseDetailScreen_ViewBinding(BaseDetailScreen baseDetailScreen, View view) {
        this.f28950b = baseDetailScreen;
        baseDetailScreen.appBarLayout = (AppBarLayout) Utils.b(view, C1761R.id.appbar, "field 'appBarLayout'", AppBarLayout.class);
        baseDetailScreen.collapsingToolbarLayout = (CollapsingToolbarLayout) Utils.b(view, C1761R.id.collapsing_toolbar, "field 'collapsingToolbarLayout'", CollapsingToolbarLayout.class);
        baseDetailScreen.toolbar = (Toolbar) Utils.b(view, C1761R.id.toolbar, "field 'toolbar'", Toolbar.class);
        baseDetailScreen.toolbarImageView = (ImageView) Utils.b(view, C1761R.id.toolbar_image, "field 'toolbarImageView'", ImageView.class);
        baseDetailScreen.toolbarTitle = (TextView) Utils.b(view, C1761R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
        baseDetailScreen.detailList = (RecyclerView) Utils.b(view, C1761R.id.detail_list, "field 'detailList'", RecyclerView.class);
        baseDetailScreen.topStickyContainer = (FrameLayout) Utils.b(view, C1761R.id.top_sticky_container, "field 'topStickyContainer'", FrameLayout.class);
        baseDetailScreen.bottomStickyContainer = (FrameLayout) Utils.b(view, C1761R.id.bottom_sticky_container, "field 'bottomStickyContainer'", FrameLayout.class);
        baseDetailScreen.loadingSnoo = Utils.a(view, C1761R.id.progress_bar, "field 'loadingSnoo'");
        baseDetailScreen.swipeRefreshLayout = (SwipeRefreshLayout) Utils.b(view, C1761R.id.refresh_layout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
        baseDetailScreen.replyView = Utils.a(view, C1761R.id.reply, "field 'replyView'");
        baseDetailScreen.toolbarDivider = Utils.a(view, C1761R.id.toolbar_divider, "field 'toolbarDivider'");
        baseDetailScreen.videoContainer = (FrameLayout) Utils.b(view, C1761R.id.video_container, "field 'videoContainer'", FrameLayout.class);
        baseDetailScreen.simpleExoPlayerView = (SimpleExoPlayerView) Utils.b(view, C1761R.id.exoplayer, "field 'simpleExoPlayerView'", SimpleExoPlayerView.class);
        baseDetailScreen.speedReadView = Utils.a(view, C1761R.id.speed_read, "field 'speedReadView'");
    }

    public final void m30011a() {
        BaseDetailScreen baseDetailScreen = this.f28950b;
        if (baseDetailScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28950b = null;
        baseDetailScreen.appBarLayout = null;
        baseDetailScreen.collapsingToolbarLayout = null;
        baseDetailScreen.toolbar = null;
        baseDetailScreen.toolbarImageView = null;
        baseDetailScreen.toolbarTitle = null;
        baseDetailScreen.detailList = null;
        baseDetailScreen.topStickyContainer = null;
        baseDetailScreen.bottomStickyContainer = null;
        baseDetailScreen.loadingSnoo = null;
        baseDetailScreen.swipeRefreshLayout = null;
        baseDetailScreen.replyView = null;
        baseDetailScreen.toolbarDivider = null;
        baseDetailScreen.videoContainer = null;
        baseDetailScreen.simpleExoPlayerView = null;
        baseDetailScreen.speedReadView = null;
    }
}
