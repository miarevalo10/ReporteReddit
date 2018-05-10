package com.reddit.config;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bumptech.glide.Glide;

public final class GlideApp {
    public static GlideRequests m8727a(Context context) {
        return (GlideRequests) Glide.m2780b(context);
    }

    public static GlideRequests m8726a(Activity activity) {
        return (GlideRequests) Glide.m2776a(activity);
    }

    public static GlideRequests m8728a(View view) {
        return (GlideRequests) Glide.m2777a(view);
    }
}
