package com.reddit.frontpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import com.reddit.frontpage.ui.submit.VideoPreviewFragment;

public class VideoPreviewActivity extends BaseActivity {
    public final int mo7724d() {
        return C1761R.layout.activity_single_container_toolbar;
    }

    protected final boolean mo7780i() {
        return true;
    }

    public static Intent m42720a(Context context, String str) {
        Intent intent = new Intent(context, VideoPreviewActivity.class);
        intent.putExtra("path", str);
        return intent;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar a = c().a();
        if (a != null) {
            a.c(false);
            a.b(true);
        }
        this.f40726a.setTitle(C1761R.string.preview_screen_edit);
        if (bundle == null) {
            getSupportFragmentManager().a().a(C1761R.id.container, VideoPreviewFragment.m39570a(getIntent().getStringExtra("path")), "VideoPreviewFragment").c();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
