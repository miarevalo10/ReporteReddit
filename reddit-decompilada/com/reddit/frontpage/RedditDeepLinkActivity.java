package com.reddit.frontpage;

import android.app.Activity;
import android.os.Bundle;
import com.reddit.frontpage.util.DeepLinkUtilLoader;

public class RedditDeepLinkActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = new DeepLinkDelegate(new DeepLinkUtilLoader());
        if (this == null) {
            throw new NullPointerException("activity == null");
        }
        bundle.m21778a(this, getIntent());
        finish();
    }
}
