package com.reddit.frontpage.ui.live;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.instabug.chat.model.Attachment;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.requests.images.ImageProgressLoadListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveUpdate.MobileEmbed;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import com.reddit.frontpage.presentation.common.DomainUtil;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.ImgurUtil;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.TopCrop;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.VideoUtil;
import com.reddit.frontpage.widgets.BaseHtmlTextView;
import com.reddit.frontpage.widgets.UpdatingWhenView;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;
import com.reddit.frontpage.widgets.video.VideoPlayerOld;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TweetView;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import timber.log.Timber;

public class LiveUpdateViewHolder extends ViewHolder {
    static final Pattern f29160a = Pattern.compile("<a .*?href=\"(.*?)\".*?</a>");
    static final List<String> f29161b = Arrays.asList(new String[]{"photo", "link", Attachment.TYPE_VIDEO, "rich"});
    @BindView
    UpdatingWhenView ageView;
    @BindView
    TextView authorView;
    @BindView
    ViewGroup container;
    @BindView
    TextView domainView;
    private TweetSource f29162p;
    private int f29163q;

    interface OnTweetLoadedCallback {
        void mo5002a(Tweet tweet);
    }

    interface TweetSource {
        void mo7223a(long j, OnTweetLoadedCallback onTweetLoadedCallback);
    }

    class C23532 implements OnTweetLoadedCallback {
        final /* synthetic */ LiveUpdateViewHolder f29159a;

        C23532(LiveUpdateViewHolder liveUpdateViewHolder) {
            this.f29159a = liveUpdateViewHolder;
        }

        public final void mo5002a(Tweet tweet) {
            TweetView tweetView = (TweetView) LayoutInflater.from(this.f29159a.c.getContext()).inflate(C1761R.layout.item_live_update_embed_tweet, this.f29159a.container, false);
            tweetView.findViewById(C1761R.id.tw__tweet_view).setBackgroundDrawable(ResourcesUtil.m22723b(tweetView.getContext(), (int) C1761R.attr.rdt_live_embed_link_background));
            tweetView.setTweet(tweet);
            this.f29159a.container.addView(tweetView);
        }
    }

    public static LiveUpdateViewHolder m30266a(ViewGroup viewGroup, TweetSource tweetSource) {
        return new LiveUpdateViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_live_update, viewGroup, false), tweetSource);
    }

    private LiveUpdateViewHolder(View view, TweetSource tweetSource) {
        super(view);
        this.f29162p = tweetSource;
        ButterKnife.a(this, view);
        this.f29163q = Util.m24014d(view.getContext()).getWindow().getDecorView().getWidth();
    }

    final void m30269a(final MobileEmbed mobileEmbed) {
        if (!TextUtils.isEmpty(mobileEmbed.getType())) {
            if (!TextUtils.equals("Twitter", mobileEmbed.getProviderName())) {
                boolean z;
                ImageView imageView;
                int width;
                Drawable snooProgressDrawable;
                View inflate;
                ImageView imageView2;
                TextView textView;
                TextView textView2;
                TextView textView3;
                int thumbnailHeight;
                int thumbnailWidth;
                Drawable snooProgressDrawable2;
                View inflate2;
                int thumbnailHeight2;
                String type = mobileEmbed.getType();
                int hashCode = type.hashCode();
                if (hashCode == 3321850) {
                    if (type.equals("link")) {
                        z = true;
                        switch (z) {
                            case false:
                                imageView = (ImageView) LayoutInflater.from(this.c.getContext()).inflate(C1761R.layout.item_live_update_embed_photo, this.container, false);
                                imageView.setOnClickListener(new OnClickListener(this) {
                                    final /* synthetic */ LiveUpdateViewHolder f21449b;

                                    public void onClick(View view) {
                                        view.getContext();
                                        int width = mobileEmbed.getWidth() != 0 ? mobileEmbed.getWidth() : mobileEmbed.getThumbnailWidth();
                                        int height = mobileEmbed.getHeight() != 0 ? mobileEmbed.getHeight() : mobileEmbed.getThumbnailHeight();
                                        String originalUrl = mobileEmbed.getOriginalUrl();
                                        if (originalUrl.contains("imgur.com/gallery")) {
                                            Util.m23968a(Util.m24014d(view.getContext()), Uri.parse(originalUrl), "live_thread");
                                        } else {
                                            view.getContext().startActivity(IntentUtil.m23750a(view.getContext(), mobileEmbed.getOriginalUrl(), "live_thread", width, height));
                                        }
                                    }
                                });
                                if (mobileEmbed.getWidth() == 0) {
                                }
                                if (mobileEmbed.getHeight() == 0) {
                                }
                                if (hashCode < width) {
                                    imageView.getLayoutParams().height = (int) (((float) this.f29163q) * 0.75f);
                                } else {
                                    imageView.getLayoutParams().height = (int) ((((float) this.f29163q) / ((float) width)) * ((float) hashCode));
                                }
                                this.c.requestLayout();
                                snooProgressDrawable = new SnooProgressDrawable(this.c.getContext());
                                GlideApp.a(this.c.getContext()).b(mobileEmbed.getUrl()).override(this.f29163q, imageView.getLayoutParams().height).centerCrop().placeholder(snooProgressDrawable).listener(ImageProgressLoadListener.a(snooProgressDrawable, mobileEmbed.getUrl())).into(imageView);
                                this.container.addView(imageView);
                                return;
                            case true:
                                inflate = LayoutInflater.from(this.c.getContext()).inflate(C1761R.layout.item_live_update_embed_link, this.container, false);
                                imageView2 = (ImageView) inflate.findViewById(C1761R.id.link_thumbnail_image);
                                textView = (TextView) inflate.findViewById(C1761R.id.link_thumbnail_domain);
                                textView2 = (TextView) inflate.findViewById(C1761R.id.link_title);
                                textView3 = (TextView) inflate.findViewById(C1761R.id.link_description);
                                inflate.setOnClickListener(new LiveUpdateViewHolder$$Lambda$0(mobileEmbed));
                                thumbnailHeight = mobileEmbed.getThumbnailHeight();
                                thumbnailWidth = mobileEmbed.getThumbnailWidth();
                                if (thumbnailHeight < thumbnailWidth) {
                                    imageView2.getLayoutParams().height = (int) (((float) this.f29163q) * 0.75f);
                                } else {
                                    imageView2.getLayoutParams().height = (int) ((((float) this.f29163q) / ((float) thumbnailWidth)) * ((float) thumbnailHeight));
                                }
                                snooProgressDrawable2 = new SnooProgressDrawable(this.c.getContext());
                                GlideApp.a(this.c.getContext()).b(mobileEmbed.getThumbnailUrl()).diskCacheStrategy(DiskCacheStrategy.a).transform(new TopCrop()).override(this.f29163q, imageView2.getLayoutParams().height).placeholder(snooProgressDrawable2).listener(ImageProgressLoadListener.a(snooProgressDrawable2, mobileEmbed.getThumbnailUrl())).into(imageView2);
                                this.c.requestLayout();
                                textView.setText(DomainUtil.m22714a(Uri.parse(mobileEmbed.getProviderUrl()).getHost()));
                                textView2.setText(mobileEmbed.getTitle());
                                textView3.setText(mobileEmbed.getDescription());
                                this.container.addView(inflate);
                                return;
                            case true:
                                z = InternalSettings.a().q();
                                if (z) {
                                }
                                inflate2 = LayoutInflater.from(this.c.getContext()).inflate(z ? C1761R.layout.item_live_update_embed_video_legacy : C1761R.layout.item_live_update_embed_video, this.container, false);
                                inflate2.setOnClickListener(new LiveUpdateViewHolder$$Lambda$1(mobileEmbed));
                                hashCode = mobileEmbed.getThumbnailWidth();
                                thumbnailHeight2 = mobileEmbed.getThumbnailHeight();
                                if (thumbnailHeight2 < hashCode) {
                                    inflate2.getLayoutParams().height = (int) (((float) this.f29163q) * 0.75f);
                                } else {
                                    inflate2.getLayoutParams().height = (int) ((((float) this.f29163q) / ((float) hashCode)) * ((float) thumbnailHeight2));
                                }
                                this.c.requestLayout();
                                snooProgressDrawable2 = new SnooProgressDrawable(this.c.getContext());
                                if (z) {
                                    ((SimpleExoPlayerView) inflate2).m24330a(mobileEmbed.getThumbnailUrl(), this.f29163q, inflate2.getLayoutParams().height);
                                } else {
                                    GlideApp.a(this.c.getContext()).b(mobileEmbed.getThumbnailUrl()).centerCrop().override(this.f29163q, inflate2.getLayoutParams().height).placeholder(snooProgressDrawable2).listener(ImageProgressLoadListener.a(snooProgressDrawable2, mobileEmbed.getThumbnailUrl())).into(((VideoPlayerOld) inflate2).getPreviewImage());
                                }
                                this.container.addView(inflate2);
                                break;
                            default:
                                break;
                        }
                    }
                } else if (hashCode == 106642994) {
                    if (type.equals("photo")) {
                        z = false;
                        switch (z) {
                            case false:
                                imageView = (ImageView) LayoutInflater.from(this.c.getContext()).inflate(C1761R.layout.item_live_update_embed_photo, this.container, false);
                                imageView.setOnClickListener(/* anonymous class already generated */);
                                if (mobileEmbed.getWidth() == 0) {
                                }
                                if (mobileEmbed.getHeight() == 0) {
                                }
                                if (hashCode < width) {
                                    imageView.getLayoutParams().height = (int) ((((float) this.f29163q) / ((float) width)) * ((float) hashCode));
                                } else {
                                    imageView.getLayoutParams().height = (int) (((float) this.f29163q) * 0.75f);
                                }
                                this.c.requestLayout();
                                snooProgressDrawable = new SnooProgressDrawable(this.c.getContext());
                                GlideApp.a(this.c.getContext()).b(mobileEmbed.getUrl()).override(this.f29163q, imageView.getLayoutParams().height).centerCrop().placeholder(snooProgressDrawable).listener(ImageProgressLoadListener.a(snooProgressDrawable, mobileEmbed.getUrl())).into(imageView);
                                this.container.addView(imageView);
                                return;
                            case true:
                                inflate = LayoutInflater.from(this.c.getContext()).inflate(C1761R.layout.item_live_update_embed_link, this.container, false);
                                imageView2 = (ImageView) inflate.findViewById(C1761R.id.link_thumbnail_image);
                                textView = (TextView) inflate.findViewById(C1761R.id.link_thumbnail_domain);
                                textView2 = (TextView) inflate.findViewById(C1761R.id.link_title);
                                textView3 = (TextView) inflate.findViewById(C1761R.id.link_description);
                                inflate.setOnClickListener(new LiveUpdateViewHolder$$Lambda$0(mobileEmbed));
                                thumbnailHeight = mobileEmbed.getThumbnailHeight();
                                thumbnailWidth = mobileEmbed.getThumbnailWidth();
                                if (thumbnailHeight < thumbnailWidth) {
                                    imageView2.getLayoutParams().height = (int) ((((float) this.f29163q) / ((float) thumbnailWidth)) * ((float) thumbnailHeight));
                                } else {
                                    imageView2.getLayoutParams().height = (int) (((float) this.f29163q) * 0.75f);
                                }
                                snooProgressDrawable2 = new SnooProgressDrawable(this.c.getContext());
                                GlideApp.a(this.c.getContext()).b(mobileEmbed.getThumbnailUrl()).diskCacheStrategy(DiskCacheStrategy.a).transform(new TopCrop()).override(this.f29163q, imageView2.getLayoutParams().height).placeholder(snooProgressDrawable2).listener(ImageProgressLoadListener.a(snooProgressDrawable2, mobileEmbed.getThumbnailUrl())).into(imageView2);
                                this.c.requestLayout();
                                textView.setText(DomainUtil.m22714a(Uri.parse(mobileEmbed.getProviderUrl()).getHost()));
                                textView2.setText(mobileEmbed.getTitle());
                                textView3.setText(mobileEmbed.getDescription());
                                this.container.addView(inflate);
                                return;
                            case true:
                                z = InternalSettings.a().q();
                                if (z) {
                                }
                                inflate2 = LayoutInflater.from(this.c.getContext()).inflate(z ? C1761R.layout.item_live_update_embed_video_legacy : C1761R.layout.item_live_update_embed_video, this.container, false);
                                inflate2.setOnClickListener(new LiveUpdateViewHolder$$Lambda$1(mobileEmbed));
                                hashCode = mobileEmbed.getThumbnailWidth();
                                thumbnailHeight2 = mobileEmbed.getThumbnailHeight();
                                if (thumbnailHeight2 < hashCode) {
                                    inflate2.getLayoutParams().height = (int) ((((float) this.f29163q) / ((float) hashCode)) * ((float) thumbnailHeight2));
                                } else {
                                    inflate2.getLayoutParams().height = (int) (((float) this.f29163q) * 0.75f);
                                }
                                this.c.requestLayout();
                                snooProgressDrawable2 = new SnooProgressDrawable(this.c.getContext());
                                if (z) {
                                    ((SimpleExoPlayerView) inflate2).m24330a(mobileEmbed.getThumbnailUrl(), this.f29163q, inflate2.getLayoutParams().height);
                                } else {
                                    GlideApp.a(this.c.getContext()).b(mobileEmbed.getThumbnailUrl()).centerCrop().override(this.f29163q, inflate2.getLayoutParams().height).placeholder(snooProgressDrawable2).listener(ImageProgressLoadListener.a(snooProgressDrawable2, mobileEmbed.getThumbnailUrl())).into(((VideoPlayerOld) inflate2).getPreviewImage());
                                }
                                this.container.addView(inflate2);
                                break;
                            default:
                                break;
                        }
                    }
                } else if (hashCode == 112202875) {
                    if (type.equals(Attachment.TYPE_VIDEO)) {
                        z = true;
                        switch (z) {
                            case false:
                                imageView = (ImageView) LayoutInflater.from(this.c.getContext()).inflate(C1761R.layout.item_live_update_embed_photo, this.container, false);
                                imageView.setOnClickListener(/* anonymous class already generated */);
                                width = mobileEmbed.getWidth() == 0 ? mobileEmbed.getWidth() : mobileEmbed.getThumbnailWidth();
                                hashCode = mobileEmbed.getHeight() == 0 ? mobileEmbed.getHeight() : mobileEmbed.getThumbnailHeight();
                                if (hashCode < width) {
                                    imageView.getLayoutParams().height = (int) (((float) this.f29163q) * 0.75f);
                                } else {
                                    imageView.getLayoutParams().height = (int) ((((float) this.f29163q) / ((float) width)) * ((float) hashCode));
                                }
                                this.c.requestLayout();
                                snooProgressDrawable = new SnooProgressDrawable(this.c.getContext());
                                GlideApp.a(this.c.getContext()).b(mobileEmbed.getUrl()).override(this.f29163q, imageView.getLayoutParams().height).centerCrop().placeholder(snooProgressDrawable).listener(ImageProgressLoadListener.a(snooProgressDrawable, mobileEmbed.getUrl())).into(imageView);
                                this.container.addView(imageView);
                                return;
                            case true:
                                inflate = LayoutInflater.from(this.c.getContext()).inflate(C1761R.layout.item_live_update_embed_link, this.container, false);
                                imageView2 = (ImageView) inflate.findViewById(C1761R.id.link_thumbnail_image);
                                textView = (TextView) inflate.findViewById(C1761R.id.link_thumbnail_domain);
                                textView2 = (TextView) inflate.findViewById(C1761R.id.link_title);
                                textView3 = (TextView) inflate.findViewById(C1761R.id.link_description);
                                inflate.setOnClickListener(new LiveUpdateViewHolder$$Lambda$0(mobileEmbed));
                                thumbnailHeight = mobileEmbed.getThumbnailHeight();
                                thumbnailWidth = mobileEmbed.getThumbnailWidth();
                                if (thumbnailHeight < thumbnailWidth) {
                                    imageView2.getLayoutParams().height = (int) (((float) this.f29163q) * 0.75f);
                                } else {
                                    imageView2.getLayoutParams().height = (int) ((((float) this.f29163q) / ((float) thumbnailWidth)) * ((float) thumbnailHeight));
                                }
                                snooProgressDrawable2 = new SnooProgressDrawable(this.c.getContext());
                                GlideApp.a(this.c.getContext()).b(mobileEmbed.getThumbnailUrl()).diskCacheStrategy(DiskCacheStrategy.a).transform(new TopCrop()).override(this.f29163q, imageView2.getLayoutParams().height).placeholder(snooProgressDrawable2).listener(ImageProgressLoadListener.a(snooProgressDrawable2, mobileEmbed.getThumbnailUrl())).into(imageView2);
                                this.c.requestLayout();
                                textView.setText(DomainUtil.m22714a(Uri.parse(mobileEmbed.getProviderUrl()).getHost()));
                                textView2.setText(mobileEmbed.getTitle());
                                textView3.setText(mobileEmbed.getDescription());
                                this.container.addView(inflate);
                                return;
                            case true:
                                z = InternalSettings.a().q();
                                inflate2 = LayoutInflater.from(this.c.getContext()).inflate(z ? C1761R.layout.item_live_update_embed_video_legacy : C1761R.layout.item_live_update_embed_video, this.container, false);
                                inflate2.setOnClickListener(new LiveUpdateViewHolder$$Lambda$1(mobileEmbed));
                                hashCode = mobileEmbed.getThumbnailWidth();
                                thumbnailHeight2 = mobileEmbed.getThumbnailHeight();
                                if (thumbnailHeight2 < hashCode) {
                                    inflate2.getLayoutParams().height = (int) (((float) this.f29163q) * 0.75f);
                                } else {
                                    inflate2.getLayoutParams().height = (int) ((((float) this.f29163q) / ((float) hashCode)) * ((float) thumbnailHeight2));
                                }
                                this.c.requestLayout();
                                snooProgressDrawable2 = new SnooProgressDrawable(this.c.getContext());
                                if (z) {
                                    GlideApp.a(this.c.getContext()).b(mobileEmbed.getThumbnailUrl()).centerCrop().override(this.f29163q, inflate2.getLayoutParams().height).placeholder(snooProgressDrawable2).listener(ImageProgressLoadListener.a(snooProgressDrawable2, mobileEmbed.getThumbnailUrl())).into(((VideoPlayerOld) inflate2).getPreviewImage());
                                } else {
                                    ((SimpleExoPlayerView) inflate2).m24330a(mobileEmbed.getThumbnailUrl(), this.f29163q, inflate2.getLayoutParams().height);
                                }
                                this.container.addView(inflate2);
                                break;
                            default:
                                break;
                        }
                    }
                }
                z = true;
                switch (z) {
                    case false:
                        imageView = (ImageView) LayoutInflater.from(this.c.getContext()).inflate(C1761R.layout.item_live_update_embed_photo, this.container, false);
                        imageView.setOnClickListener(/* anonymous class already generated */);
                        if (mobileEmbed.getWidth() == 0) {
                        }
                        if (mobileEmbed.getHeight() == 0) {
                        }
                        if (hashCode < width) {
                            imageView.getLayoutParams().height = (int) ((((float) this.f29163q) / ((float) width)) * ((float) hashCode));
                        } else {
                            imageView.getLayoutParams().height = (int) (((float) this.f29163q) * 0.75f);
                        }
                        this.c.requestLayout();
                        snooProgressDrawable = new SnooProgressDrawable(this.c.getContext());
                        GlideApp.a(this.c.getContext()).b(mobileEmbed.getUrl()).override(this.f29163q, imageView.getLayoutParams().height).centerCrop().placeholder(snooProgressDrawable).listener(ImageProgressLoadListener.a(snooProgressDrawable, mobileEmbed.getUrl())).into(imageView);
                        this.container.addView(imageView);
                        return;
                    case true:
                        inflate = LayoutInflater.from(this.c.getContext()).inflate(C1761R.layout.item_live_update_embed_link, this.container, false);
                        imageView2 = (ImageView) inflate.findViewById(C1761R.id.link_thumbnail_image);
                        textView = (TextView) inflate.findViewById(C1761R.id.link_thumbnail_domain);
                        textView2 = (TextView) inflate.findViewById(C1761R.id.link_title);
                        textView3 = (TextView) inflate.findViewById(C1761R.id.link_description);
                        inflate.setOnClickListener(new LiveUpdateViewHolder$$Lambda$0(mobileEmbed));
                        thumbnailHeight = mobileEmbed.getThumbnailHeight();
                        thumbnailWidth = mobileEmbed.getThumbnailWidth();
                        if (thumbnailHeight < thumbnailWidth) {
                            imageView2.getLayoutParams().height = (int) ((((float) this.f29163q) / ((float) thumbnailWidth)) * ((float) thumbnailHeight));
                        } else {
                            imageView2.getLayoutParams().height = (int) (((float) this.f29163q) * 0.75f);
                        }
                        snooProgressDrawable2 = new SnooProgressDrawable(this.c.getContext());
                        GlideApp.a(this.c.getContext()).b(mobileEmbed.getThumbnailUrl()).diskCacheStrategy(DiskCacheStrategy.a).transform(new TopCrop()).override(this.f29163q, imageView2.getLayoutParams().height).placeholder(snooProgressDrawable2).listener(ImageProgressLoadListener.a(snooProgressDrawable2, mobileEmbed.getThumbnailUrl())).into(imageView2);
                        this.c.requestLayout();
                        textView.setText(DomainUtil.m22714a(Uri.parse(mobileEmbed.getProviderUrl()).getHost()));
                        textView2.setText(mobileEmbed.getTitle());
                        textView3.setText(mobileEmbed.getDescription());
                        this.container.addView(inflate);
                        return;
                    case true:
                        z = InternalSettings.a().q();
                        if (z) {
                        }
                        inflate2 = LayoutInflater.from(this.c.getContext()).inflate(z ? C1761R.layout.item_live_update_embed_video_legacy : C1761R.layout.item_live_update_embed_video, this.container, false);
                        inflate2.setOnClickListener(new LiveUpdateViewHolder$$Lambda$1(mobileEmbed));
                        hashCode = mobileEmbed.getThumbnailWidth();
                        thumbnailHeight2 = mobileEmbed.getThumbnailHeight();
                        if (thumbnailHeight2 < hashCode) {
                            inflate2.getLayoutParams().height = (int) ((((float) this.f29163q) / ((float) hashCode)) * ((float) thumbnailHeight2));
                        } else {
                            inflate2.getLayoutParams().height = (int) (((float) this.f29163q) * 0.75f);
                        }
                        this.c.requestLayout();
                        snooProgressDrawable2 = new SnooProgressDrawable(this.c.getContext());
                        if (z) {
                            ((SimpleExoPlayerView) inflate2).m24330a(mobileEmbed.getThumbnailUrl(), this.f29163q, inflate2.getLayoutParams().height);
                        } else {
                            GlideApp.a(this.c.getContext()).b(mobileEmbed.getThumbnailUrl()).centerCrop().override(this.f29163q, inflate2.getLayoutParams().height).placeholder(snooProgressDrawable2).listener(ImageProgressLoadListener.a(snooProgressDrawable2, mobileEmbed.getThumbnailUrl())).into(((VideoPlayerOld) inflate2).getPreviewImage());
                        }
                        this.container.addView(inflate2);
                        break;
                    default:
                        break;
                }
            }
            try {
                this.f29162p.mo7223a(Long.valueOf(Long.parseLong(Uri.parse(mobileEmbed.getOriginalUrl()).getLastPathSegment())).longValue(), new C23532(this));
            } catch (MobileEmbed mobileEmbed2) {
                Timber.c(mobileEmbed2, "Failed to render tweet", new Object[0]);
            }
        }
    }

    final void m30270a(String str) {
        BaseHtmlTextView baseHtmlTextView = (BaseHtmlTextView) LayoutInflater.from(this.c.getContext()).inflate(C1761R.layout.item_live_update_html, this.container, false);
        baseHtmlTextView.setHtmlFromString(str);
        if (baseHtmlTextView.length() > null) {
            this.container.addView(baseHtmlTextView);
        }
    }

    static final /* synthetic */ void m30267a(MobileEmbed mobileEmbed, View view) {
        Context context = view.getContext();
        String originalUrl = mobileEmbed.getOriginalUrl();
        Uri parse = Uri.parse(originalUrl);
        if (ImgurUtil.m23727a(parse)) {
            parse = Uri.parse(ImgurUtil.m23729b(originalUrl));
        }
        if (VideoUtil.m24055a(parse)) {
            IntentUtil.m23756a(context, parse);
        } else {
            view.getContext().startActivity(IntentUtil.m23739a(view.getContext(), parse, Uri.parse(mobileEmbed.getThumbnailUrl()), "live_thread"));
        }
    }
}
