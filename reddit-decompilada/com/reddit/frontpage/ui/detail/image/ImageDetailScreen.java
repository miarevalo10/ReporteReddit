package com.reddit.frontpage.ui.detail.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.requests.images.ImageProgressLoadListener;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import com.reddit.frontpage.ui.detail.FlexContainerDetailScreen;
import com.reddit.frontpage.ui.listing.adapter.ads.LegacyAdsNavigator;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.LinkUtil;
import org.parceler.Parcels;
import timber.log.Timber;

public class ImageDetailScreen extends FlexContainerDetailScreen {
    public static ImageDetailScreen m42154a(Link link, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("com.reddit.arg.link", Parcels.m28672a((Object) link));
        bundle2.putBundle("com.reddit.arg.context", bundle);
        return new ImageDetailScreen(bundle2);
    }

    public ImageDetailScreen(Bundle bundle) {
        super(bundle);
    }

    final /* synthetic */ void m42156a(Link link, View view) {
        Context context = view.getContext();
        String str = m39101W() ? "onboarding_post_detail" : "post_detail";
        if (!LegacyAdsNavigator.m23457a(context, link, str)) {
            context.startActivity(IntentUtil.m23760b(context, link, str));
        }
    }

    public final View mo7682T() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f39167y.getContext()).inflate(C1761R.layout.detail_content_image, this.f39167y, false);
        Link link = this.f39153F;
        ImageResolution a = LinkUtil.m23774a(link);
        ImageView imageView = (ImageView) frameLayout.findViewById(C1761R.id.detail_image);
        Timber.b("loading url = %s", new Object[]{a.getUrl()});
        Drawable snooProgressDrawable = new SnooProgressDrawable(frameLayout.getContext());
        GlideApp.a(am_()).b(a.getUrl()).centerInside().placeholder(snooProgressDrawable).transition(DrawableTransitionOptions.b()).listener(ImageProgressLoadListener.a(snooProgressDrawable, a.getUrl())).into(imageView);
        imageView.setOnClickListener(new ImageDetailScreen$$Lambda$0(this, link));
        return frameLayout;
    }

    public final int ag() {
        int height;
        if (this.f39153F.getPreview() != null) {
            ImageResolution source = this.f39153F.getPreview().getSource();
            float width = (float) am_().getWindow().getDecorView().getWidth();
            StringBuilder stringBuilder = new StringBuilder("list width is ");
            stringBuilder.append(width);
            Timber.b(stringBuilder.toString(), new Object[0]);
            height = ((int) ((width * ((float) source.getHeight())) / ((float) source.getWidth()))) + 1;
            StringBuilder stringBuilder2 = new StringBuilder("preview container height ");
            stringBuilder2.append(this.f39153F.getId());
            stringBuilder2.append(": ");
            stringBuilder2.append(height);
            Timber.b(stringBuilder2.toString(), new Object[0]);
        } else {
            height = 0;
        }
        return Math.max(height, ao_().getDimensionPixelSize(C1761R.dimen.link_image_min_height));
    }
}
