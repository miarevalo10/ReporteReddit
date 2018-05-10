package com.reddit.frontpage.ui.listing.newcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.images.ImageProgressLoadListener;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import com.reddit.frontpage.presentation.common.DomainUtil;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.ui.listener.RemoteImageAttachStateListener;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.Util;

public class LinkThumbnailView extends FrameLayout {
    TextView f21357a;
    View f21358b;
    ImageView f21359c;
    Link f21360d;
    private int f21361e;
    private Transformation<Bitmap> f21362f;
    private Drawable f21363g;
    @BindView
    ImageView thumbnailView;

    public LinkThumbnailView(Context context) {
        this(context, null);
    }

    public LinkThumbnailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinkThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23477a(context, attributeSet, i, 0);
    }

    @TargetApi(21)
    public LinkThumbnailView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m23477a(context, attributeSet, i, i2);
    }

    private void m23477a(Context context, AttributeSet attributeSet, int i, int i2) {
        context = context.getTheme().obtainStyledAttributes(attributeSet, C1761R.styleable.LinkThumbnailView, i, i2);
        try {
            this.f21361e = context.getInteger(1, 0);
            i2 = context.getDimensionPixelOffset(0, 0);
            context = this.f21361e;
            int i3 = C1761R.layout.layout_link_thumbnail_view;
            switch (context) {
                case 1:
                    i3 = C1761R.layout.layout_link_thumbnail_view_compact;
                    break;
                case 2:
                    break;
                default:
                    break;
            }
            this.f21362f = new MultiTransformation(new Transformation[]{new CenterCrop(), new RoundedCorners(i2)});
            inflate(getContext(), i3, this);
            ButterKnife.a(this);
            this.f21363g = Util.m24032h((int) C1761R.drawable.placeholder_gradient);
        } finally {
            context.recycle();
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.f21361e == 0) {
            this.f21357a = (TextView) findViewById(C1761R.id.link_thumbnail_domain);
            this.f21358b = findViewById(C1761R.id.domain_background);
        } else {
            this.f21359c = (ImageView) findViewById(C1761R.id.link_thumbnail_indicator);
        }
        this.thumbnailView.addOnAttachStateChangeListener(new RemoteImageAttachStateListener(this, this.thumbnailView) {
            final /* synthetic */ LinkThumbnailView f29126a;

            public void onViewAttachedToWindow(View view) {
                if (this.f29126a.f21360d != null) {
                    this.f29126a.m23478a(this.f29126a.f21360d);
                }
            }
        });
    }

    public final void m23478a(Link link) {
        this.f21360d = link;
        FrontpageSettings a = FrontpageSettings.a();
        int linkType = link.getLinkType();
        if (linkType != 2) {
            if (a.b()) {
                if (linkType != 3) {
                    if (this.f21361e == 1) {
                    }
                }
            }
            setVisibility(0);
            if (a.b()) {
                m23476a(linkType);
            } else {
                ImageResolution a2 = LinkUtil.m23775a(link, a.g(), new Point(this.thumbnailView.getWidth(), this.thumbnailView.getHeight()));
                if (a2 == null) {
                    m23476a(linkType);
                } else {
                    this.thumbnailView.setBackgroundResource(C1761R.drawable.rounded_corners_semi_transparent);
                    Drawable snooProgressDrawable = new SnooProgressDrawable(getContext());
                    GlideApp.a(getContext()).b(a2.getUrl()).transform(this.f21362f).diskCacheStrategy(DiskCacheStrategy.a).placeholder(snooProgressDrawable).listener(ImageProgressLoadListener.a(snooProgressDrawable, a2.getUrl())).into(this.thumbnailView).f();
                    setVisibility(0);
                }
            }
            if (this.f21361e == 0) {
                if (link.getDomain() != null) {
                    CharSequence a3 = DomainUtil.m22714a(link.getDisplayDomain());
                    if (link.getLinkType() == 1 && TextUtils.isEmpty(a3) == null) {
                        this.f21357a.setText(a3);
                        this.f21357a.setVisibility(0);
                        this.f21358b.setVisibility(0);
                        return;
                    }
                }
                this.f21357a.setVisibility(8);
                this.f21358b.setVisibility(8);
                return;
            }
            int i;
            link = link.getLinkType();
            if (link != 5) {
                if (link != 9) {
                    i = link == 1 ? C1761R.drawable.ind_thumbnail_link : null;
                    if (i == null) {
                        this.f21359c.setImageDrawable(ResourcesUtil.m22736g(getContext(), i));
                        this.f21359c.setBackground(ResourcesUtil.m22724b(getContext(), C1761R.drawable.circle_white_inset, C1761R.attr.rdt_tab_unselected_text_color));
                        this.f21359c.setVisibility(0);
                        return;
                    }
                    this.f21359c.setVisibility(8);
                    return;
                }
            }
            i = C1761R.drawable.ind_thumbnail_video;
            if (i == null) {
                this.f21359c.setVisibility(8);
                return;
            }
            this.f21359c.setImageDrawable(ResourcesUtil.m22736g(getContext(), i));
            this.f21359c.setBackground(ResourcesUtil.m22724b(getContext(), C1761R.drawable.circle_white_inset, C1761R.attr.rdt_tab_unselected_text_color));
            this.f21359c.setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void m23476a(int i) {
        if (i != 1) {
            if (i != 9) {
                switch (i) {
                    case 3:
                    case 4:
                        i = C1761R.drawable.ic_icon_image;
                        break;
                    case 5:
                        break;
                    default:
                        i = 0;
                        break;
                }
            }
            i = C1761R.drawable.ic_icon_video_camera;
        } else {
            i = this.f21361e == 0 ? C1761R.drawable.inset_placeholder_thumbnail_link : C1761R.drawable.ic_icon_browser;
        }
        if (i != 0) {
            this.thumbnailView.setBackgroundDrawable(this.f21363g);
            this.thumbnailView.setImageResource(i);
            this.thumbnailView.setScaleType(ScaleType.CENTER);
        }
    }
}
