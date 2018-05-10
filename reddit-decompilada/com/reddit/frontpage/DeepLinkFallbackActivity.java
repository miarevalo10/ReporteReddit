package com.reddit.frontpage;

import android.content.Intent;
import android.net.Uri;
import com.reddit.frontpage.util.Util;

public class DeepLinkFallbackActivity extends RedditThemedActivity {
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("com.reddit.extra.uri");
        if (uri == null) {
            uri = Uri.parse(intent.getDataString());
        }
        Util.m23973a((RedditThemedActivity) this, uri, null);
        finish();
    }
}
