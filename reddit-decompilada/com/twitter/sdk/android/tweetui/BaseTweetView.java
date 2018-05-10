package com.twitter.sdk.android.tweetui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.twitter.sdk.android.core.IntentUtils;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.UserUtils;
import com.twitter.sdk.android.core.internal.UserUtils.AvatarSize;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.core.models.ImageValue;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetBuilder;
import com.twitter.sdk.android.tweetui.PlayerActivity.PlayerItem;
import com.twitter.sdk.android.tweetui.TweetRepository.C20761;
import com.twitter.sdk.android.tweetui.internal.AspectRatioFrameLayout;
import com.twitter.sdk.android.tweetui.internal.MediaBadgeView;
import com.twitter.sdk.android.tweetui.internal.SpanClickHandler;
import com.twitter.sdk.android.tweetui.internal.TweetImageView;
import com.twitter.sdk.android.tweetui.internal.TweetMediaUtils;
import com.twitter.sdk.android.tweetui.internal.TweetMediaView;
import io.fabric.sdk.android.Fabric;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public abstract class BaseTweetView extends LinearLayout {
    private static final int f24132G = C2075R.style.tw__TweetLightStyle;
    int f24133A;
    int f24134B;
    int f24135C;
    boolean f24136D;
    ColorDrawable f24137E;
    ColorDrawable f24138F;
    private LinkClickListener f24139H;
    private Uri f24140I;
    final DependencyProvider f24141a;
    TweetLinkClickListener f24142b;
    TweetMediaClickListener f24143c;
    Tweet f24144d;
    int f24145e;
    RelativeLayout f24146f;
    ImageView f24147g;
    TextView f24148h;
    TextView f24149i;
    ImageView f24150j;
    TweetImageView f24151k;
    AspectRatioFrameLayout f24152l;
    TweetMediaView f24153m;
    TextView f24154n;
    TextView f24155o;
    ImageView f24156p;
    TextView f24157q;
    TweetActionBarView f24158r;
    MediaBadgeView f24159s;
    View f24160t;
    int f24161u;
    int f24162v;
    int f24163w;
    int f24164x;
    int f24165y;
    int f24166z;

    static class DependencyProvider {
        TweetScribeClient f24129a;
        VideoScribeClient f24130b;

        DependencyProvider() {
        }

        static TweetUi m25895a() {
            return TweetUi.m31786a();
        }

        final TweetScribeClient m25897b() {
            if (this.f24129a == null) {
                this.f24129a = new TweetScribeClientImpl(TweetUi.m31786a());
            }
            return this.f24129a;
        }

        final VideoScribeClient m25898c() {
            if (this.f24130b == null) {
                this.f24130b = new VideoScribeClientImpl(TweetUi.m31786a());
            }
            return this.f24130b;
        }

        static Picasso m25896d() {
            return TweetUi.m31786a().f30784e;
        }
    }

    class PermalinkClickListener implements OnClickListener {
        final /* synthetic */ BaseTweetView f24131a;

        PermalinkClickListener(BaseTweetView baseTweetView) {
            this.f24131a = baseTweetView;
        }

        public void onClick(View view) {
            if (this.f24131a.getPermalinkUri() != null) {
                view = this.f24131a;
                if (view.f24144d != null) {
                    view.f24141a.m25897b().mo5499a(view.f24144d, view.getViewTypeName());
                }
                view = this.f24131a;
                if (IntentUtils.m25838a(view.getContext(), new Intent("android.intent.action.VIEW", view.getPermalinkUri())) == null) {
                    Fabric.m26243b().mo5570e("TweetUi", "Activity cannot be found to open permalink URI");
                }
            }
        }
    }

    class C25304 implements LinkClickListener {
        final /* synthetic */ BaseTweetView f30763a;

        C25304(BaseTweetView baseTweetView) {
            this.f30763a = baseTweetView;
        }

        public final void mo5491a(String str) {
            if (!TextUtils.isEmpty(str) && this.f30763a.f24142b == null) {
                if (IntentUtils.m25838a(this.f30763a.getContext(), new Intent("android.intent.action.VIEW", Uri.parse(str))) == null) {
                    Fabric.m26243b().mo5570e("TweetUi", "Activity cannot be found to open URL");
                }
            }
        }
    }

    static class PicassoCallback implements Callback {
        final WeakReference<ImageView> f30764a;

        PicassoCallback(ImageView imageView) {
            this.f30764a = new WeakReference(imageView);
        }

        public final void mo5492a() {
            ImageView imageView = (ImageView) this.f30764a.get();
            if (imageView != null) {
                imageView.setBackgroundResource(17170445);
            }
        }
    }

    protected abstract double mo5503a(int i);

    abstract int getLayout();

    abstract String getViewTypeName();

    BaseTweetView(Context context, Tweet tweet) {
        this(context, tweet, f24132G);
    }

    BaseTweetView(Context context, Tweet tweet, int i) {
        this(context, tweet, i, new DependencyProvider());
    }

    BaseTweetView(Context context, Tweet tweet, int i, DependencyProvider dependencyProvider) {
        super(context, null);
        this.f24141a = dependencyProvider;
        this.f24145e = i;
        i = getContext().getTheme().obtainStyledAttributes(i, C2075R.styleable.tw__TweetView);
        try {
            setStyleAttributes(i);
            m25899a(context);
            m25905d();
            m25906e();
            if (m25904c() != null) {
                m25903b();
                setTweet(tweet);
            }
        } finally {
            i.recycle();
        }
    }

    public BaseTweetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new DependencyProvider());
    }

    BaseTweetView(Context context, AttributeSet attributeSet, DependencyProvider dependencyProvider) {
        super(context, attributeSet);
        this.f24141a = dependencyProvider;
        m25900a(context, attributeSet);
        m25899a(context);
    }

    public BaseTweetView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, new DependencyProvider());
    }

    BaseTweetView(Context context, AttributeSet attributeSet, int i, DependencyProvider dependencyProvider) {
        super(context, attributeSet, i);
        this.f24141a = dependencyProvider;
        m25900a(context, attributeSet);
        m25899a(context);
    }

    private void m25900a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            context = context.getTheme().obtainStyledAttributes(attributeSet, C2075R.styleable.tw__TweetView, 0, 0);
            try {
                setXmlDataAttributes(context);
                setStyleAttributes(context);
            } finally {
                context.recycle();
            }
        }
    }

    private void setXmlDataAttributes(TypedArray typedArray) {
        long longValue = Utils.m25945a(typedArray.getString(C2075R.styleable.tw__TweetView_tw__tweet_id)).longValue();
        if (longValue <= 0) {
            throw new IllegalArgumentException("Invalid tw__tweet_id");
        }
        m25902a((String) null, Long.valueOf(longValue));
        typedArray = new TweetBuilder();
        typedArray.f24078b = longValue;
        this.f24144d = typedArray.m25892a();
    }

    private void setStyleAttributes(TypedArray typedArray) {
        this.f24161u = typedArray.getColor(C2075R.styleable.tw__TweetView_tw__container_bg_color, getResources().getColor(C2075R.color.tw__tweet_light_container_bg_color));
        this.f24162v = typedArray.getColor(C2075R.styleable.tw__TweetView_tw__primary_text_color, getResources().getColor(C2075R.color.tw__tweet_light_primary_text_color));
        this.f24164x = typedArray.getColor(C2075R.styleable.tw__TweetView_tw__action_color, getResources().getColor(C2075R.color.tw__tweet_action_color));
        this.f24165y = typedArray.getColor(C2075R.styleable.tw__TweetView_tw__action_highlight_color, getResources().getColor(C2075R.color.tw__tweet_action_light_highlight_color));
        this.f24136D = typedArray.getBoolean(C2075R.styleable.tw__TweetView_tw__tweet_actions_enabled, false);
        typedArray = ColorUtils.m25911a(this.f24161u);
        if (typedArray != null) {
            this.f24133A = C2075R.drawable.tw__ic_tweet_photo_error_light;
            this.f24134B = C2075R.drawable.tw__ic_logo_blue;
            this.f24135C = C2075R.drawable.tw__ic_retweet_light;
        } else {
            this.f24133A = C2075R.drawable.tw__ic_tweet_photo_error_dark;
            this.f24134B = C2075R.drawable.tw__ic_logo_white;
            this.f24135C = C2075R.drawable.tw__ic_retweet_dark;
        }
        int i = -16777216;
        this.f24163w = ColorUtils.m25910a(typedArray != null ? 0.4d : 0.35d, typedArray != null ? -1 : -16777216, this.f24162v);
        double d = typedArray != null ? 0.08d : 0.12d;
        if (typedArray == null) {
            i = -1;
        }
        this.f24166z = ColorUtils.m25910a(d, i, this.f24161u);
        this.f24137E = new ColorDrawable(this.f24166z);
        this.f24138F = new ColorDrawable(this.f24166z);
    }

    private void m25899a(Context context) {
        context = LayoutInflater.from(context).inflate(getLayout(), null, false);
        context.setLayoutParams(new LayoutParams(-1, -2));
        addView(context);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (m25904c()) {
            m25905d();
            m25906e();
            m25903b();
            final long tweetId = getTweetId();
            com.twitter.sdk.android.core.Callback c27261 = new com.twitter.sdk.android.core.Callback<Tweet>(this) {
                final /* synthetic */ BaseTweetView f34653b;

                public final void mo6518a(Result<Tweet> result) {
                    this.f34653b.setTweet((Tweet) result.f23920a);
                }

                public final void mo6519a(TwitterException twitterException) {
                    Fabric.m26243b().mo5562a("TweetUi", String.format(Locale.ENGLISH, "loadTweet failure for Tweet Id %d.", new Object[]{Long.valueOf(tweetId)}));
                }
            };
            TweetRepository tweetRepository = DependencyProvider.m25895a().f30783d;
            long tweetId2 = getTweetId();
            Tweet tweet = (Tweet) tweetRepository.f24218c.get(Long.valueOf(tweetId2));
            if (tweet != null) {
                tweetRepository.f24217b.post(new C20761(tweetRepository, c27261, tweet));
            } else {
                tweetRepository.f24216a.m31727e().m25847c().show(Long.valueOf(tweetId2), null, null, null).a(new SingleTweetCallback(tweetRepository, c27261));
            }
        }
    }

    private void m25903b() {
        setTweetActionsEnabled(this.f24136D);
        this.f24158r.setOnActionCallback(new ResetTweetCallback(this, DependencyProvider.m25895a().f30783d, null));
    }

    private boolean m25904c() {
        if (isInEditMode()) {
            return false;
        }
        try {
            DependencyProvider.m25895a();
            return true;
        } catch (IllegalStateException e) {
            Fabric.m26243b().mo5570e("TweetUi", e.getMessage());
            setEnabled(false);
            return false;
        }
    }

    private void m25905d() {
        this.f24146f = (RelativeLayout) findViewById(C2075R.id.tw__tweet_view);
        this.f24147g = (ImageView) findViewById(C2075R.id.tw__tweet_author_avatar);
        this.f24148h = (TextView) findViewById(C2075R.id.tw__tweet_author_full_name);
        this.f24149i = (TextView) findViewById(C2075R.id.tw__tweet_author_screen_name);
        this.f24150j = (ImageView) findViewById(C2075R.id.tw__tweet_author_verified);
        this.f24151k = (TweetImageView) findViewById(C2075R.id.tw__tweet_image);
        this.f24152l = (AspectRatioFrameLayout) findViewById(C2075R.id.tw__aspect_ratio_media_container);
        this.f24153m = (TweetMediaView) findViewById(C2075R.id.tweet_media_view);
        this.f24154n = (TextView) findViewById(C2075R.id.tw__tweet_text);
        this.f24155o = (TextView) findViewById(C2075R.id.tw__tweet_timestamp);
        this.f24156p = (ImageView) findViewById(C2075R.id.tw__twitter_logo);
        this.f24157q = (TextView) findViewById(C2075R.id.tw__tweet_retweeted_by);
        this.f24158r = (TweetActionBarView) findViewById(C2075R.id.tw__tweet_action_bar);
        this.f24159s = (MediaBadgeView) findViewById(C2075R.id.tw__tweet_media_badge);
        this.f24160t = findViewById(C2075R.id.bottom_separator);
    }

    public long getTweetId() {
        if (this.f24144d == null) {
            return -1;
        }
        return this.f24144d.f24051i;
    }

    public void setTweet(Tweet tweet) {
        this.f24144d = tweet;
        mo5504a();
    }

    public Tweet getTweet() {
        return this.f24144d;
    }

    public void setOnActionCallback(com.twitter.sdk.android.core.Callback<Tweet> callback) {
        this.f24158r.setOnActionCallback(new ResetTweetCallback(this, DependencyProvider.m25895a().f30783d, callback));
        this.f24158r.setTweet(this.f24144d);
    }

    public void setTweetMediaClickListener(TweetMediaClickListener tweetMediaClickListener) {
        this.f24143c = tweetMediaClickListener;
    }

    public void setTweetLinkClickListener(TweetLinkClickListener tweetLinkClickListener) {
        this.f24142b = tweetLinkClickListener;
    }

    void mo5504a() {
        Tweet b = TweetUtils.m25943b(this.f24144d);
        setProfilePhotoView(b);
        setName(b);
        setScreenName(b);
        setTimestamp(b);
        setTweetMedia(b);
        setText(b);
        setContentDescription(b);
        setTweetActions(this.f24144d);
        b = this.f24144d;
        if (b != null) {
            if (b.f24067y != null) {
                this.f24157q.setText(getResources().getString(C2075R.string.tw__retweeted_by_format, new Object[]{b.f24038D.f24106b}));
                this.f24157q.setVisibility(0);
                if (TweetUtils.m25942a(this.f24144d)) {
                    this.f24140I = null;
                } else {
                    m25902a(this.f24144d.f24038D.f24108d, Long.valueOf(getTweetId()));
                }
                setOnClickListener(new PermalinkClickListener(this));
                if (this.f24144d != null) {
                    this.f24141a.m25897b().mo5500a(this.f24144d, getViewTypeName(), this.f24136D);
                }
            }
        }
        this.f24157q.setVisibility(8);
        if (TweetUtils.m25942a(this.f24144d)) {
            this.f24140I = null;
        } else {
            m25902a(this.f24144d.f24038D.f24108d, Long.valueOf(getTweetId()));
        }
        setOnClickListener(new PermalinkClickListener(this));
        if (this.f24144d != null) {
            this.f24141a.m25897b().mo5500a(this.f24144d, getViewTypeName(), this.f24136D);
        }
    }

    Uri getPermalinkUri() {
        return this.f24140I;
    }

    private void m25902a(String str, Long l) {
        if (l.longValue() > 0) {
            this.f24140I = TweetUtils.m25940a(str, l.longValue());
        }
    }

    private void m25906e() {
        this.f24146f.setBackgroundColor(this.f24161u);
        this.f24147g.setImageDrawable(this.f24137E);
        this.f24148h.setTextColor(this.f24162v);
        this.f24149i.setTextColor(this.f24163w);
        this.f24154n.setTextColor(this.f24162v);
        this.f24155o.setTextColor(this.f24163w);
        this.f24156p.setImageResource(this.f24134B);
        this.f24157q.setTextColor(this.f24163w);
        this.f24153m.setMediaBgColor(this.f24166z);
        this.f24153m.setPhotoErrorResId(this.f24133A);
    }

    private void setName(Tweet tweet) {
        if (tweet == null || tweet.f24038D == null) {
            this.f24148h.setText("");
        } else {
            this.f24148h.setText(Utils.m25947b(tweet.f24038D.f24106b));
        }
    }

    private void setScreenName(Tweet tweet) {
        if (tweet == null || tweet.f24038D == null) {
            this.f24149i.setText("");
        } else {
            this.f24149i.setText(UserUtils.m25862a(Utils.m25947b(tweet.f24038D.f24108d)));
        }
    }

    @TargetApi(16)
    private void setText(Tweet tweet) {
        CharSequence charSequence;
        if (VERSION.SDK_INT >= 16) {
            this.f24154n.setImportantForAccessibility(2);
        }
        FormattedTweetText a = DependencyProvider.m25895a().f30783d.m25925a(tweet);
        if (a == null) {
            charSequence = null;
        } else {
            charSequence = TweetTextLinkifier.m25934a(a, getLinkClickListener(), TweetMediaUtils.m25972b(tweet), this.f24164x, this.f24165y);
        }
        tweet = Utils.m25944a(charSequence);
        SpanClickHandler.m25958a(this.f24154n);
        if (TextUtils.isEmpty(tweet)) {
            this.f24154n.setText("");
            this.f24154n.setVisibility(8);
            return;
        }
        this.f24154n.setText(tweet);
        this.f24154n.setVisibility(0);
    }

    private void setTimestamp(Tweet tweet) {
        if (tweet == null || tweet.f24044b == null || !TweetDateUtils.m25922b(tweet.f24044b)) {
            tweet = "";
        } else {
            tweet = TweetDateUtils.m25923c(TweetDateUtils.m25921a(getResources(), System.currentTimeMillis(), Long.valueOf(TweetDateUtils.m25920a(tweet.f24044b)).longValue()));
        }
        this.f24155o.setText(tweet);
    }

    void setProfilePhotoView(Tweet tweet) {
        Picasso d = DependencyProvider.m25896d();
        if (d != null) {
            String a;
            Drawable drawable;
            if (tweet != null) {
                if (tweet.f24038D != null) {
                    a = UserUtils.m25863a(tweet.f24038D, AvatarSize.REASONABLY_SMALL);
                    tweet = d.m25776a(a);
                    drawable = this.f24137E;
                    if (!tweet.f23872d) {
                        throw new IllegalStateException("Already explicitly declared as no placeholder.");
                    } else if (tweet.f23873e == 0) {
                        throw new IllegalStateException("Placeholder image already set.");
                    } else {
                        tweet.f23877i = drawable;
                        tweet.m25790a(this.f24147g, null);
                    }
                }
            }
            a = null;
            tweet = d.m25776a(a);
            drawable = this.f24137E;
            if (!tweet.f23872d) {
                throw new IllegalStateException("Already explicitly declared as no placeholder.");
            } else if (tweet.f23873e == 0) {
                tweet.f23877i = drawable;
                tweet.m25790a(this.f24147g, null);
            } else {
                throw new IllegalStateException("Placeholder image already set.");
            }
        }
    }

    private void m25907f() {
        this.f24152l.setVisibility(0);
        this.f24151k.setVisibility(0);
        this.f24159s.setVisibility(0);
        this.f24153m.setVisibility(8);
    }

    void setViewsForPhotoEntity(int i) {
        this.f24152l.setVisibility(0);
        this.f24152l.setAspectRatio(mo5503a(i));
        this.f24153m.setVisibility(0);
        this.f24151k.setVisibility(8);
        this.f24159s.setVisibility(8);
    }

    void setAltText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f24151k.setContentDescription(str);
        }
    }

    private void setVideoMediaLauncher(final MediaEntity mediaEntity) {
        this.f24151k.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BaseTweetView f24125b;

            public void onClick(View view) {
                if (this.f24125b.f24143c == null && TweetMediaUtils.m25969a(mediaEntity) != null) {
                    view = new Intent(this.f24125b.getContext(), PlayerActivity.class);
                    view.putExtra("PLAYER_ITEM", new PlayerItem(TweetMediaUtils.m25969a(mediaEntity).f24112b, TweetMediaUtils.m25971b(mediaEntity)));
                    IntentUtils.m25838a(this.f24125b.getContext(), view);
                }
            }
        });
    }

    private void m25901a(String str, double d) {
        Picasso d2 = DependencyProvider.m25896d();
        if (d2 != null) {
            AspectRatioFrameLayout aspectRatioFrameLayout = this.f24152l;
            if (!(aspectRatioFrameLayout.getMeasuredWidth() == 0 && aspectRatioFrameLayout.getMeasuredHeight() == 0)) {
                aspectRatioFrameLayout.measure(MeasureSpec.makeMeasureSpec(0, 1073741824), MeasureSpec.makeMeasureSpec(0, 1073741824));
                aspectRatioFrameLayout.layout(0, 0, 0, 0);
            }
            this.f24152l.setAspectRatio(d);
            str = d2.m25776a(str).m25789a(this.f24133A);
            str.f23871c = Double.MIN_VALUE;
            str.m25788a().m25790a(this.f24151k, new PicassoCallback(this.f24151k));
        }
    }

    void setContentDescription(Tweet tweet) {
        if (TweetUtils.m25942a(tweet)) {
            FormattedTweetText a = DependencyProvider.m25895a().f30783d.m25925a(tweet);
            String str = null;
            String str2 = a != null ? a.f24167a : null;
            long a2 = TweetDateUtils.m25920a(tweet.f24044b);
            if (a2 != -1) {
                str = DateFormat.getDateInstance().format(new Date(a2));
            }
            setContentDescription(getResources().getString(C2075R.string.tw__tweet_content_description, new Object[]{Utils.m25947b(tweet.f24038D.f24106b), Utils.m25947b(str2), Utils.m25947b(str)}));
            return;
        }
        setContentDescription(getResources().getString(C2075R.string.tw__loading_tweet));
    }

    void setTweetActions(Tweet tweet) {
        this.f24158r.setTweet(tweet);
    }

    public void setTweetActionsEnabled(boolean z) {
        this.f24136D = z;
        if (this.f24136D) {
            this.f24158r.setVisibility(0);
            this.f24160t.setVisibility(8);
            return;
        }
        this.f24158r.setVisibility(8);
        this.f24160t.setVisibility(0);
    }

    protected LinkClickListener getLinkClickListener() {
        if (this.f24139H == null) {
            this.f24139H = new C25304(this);
        }
        return this.f24139H;
    }

    final void setTweetMedia(Tweet tweet) {
        if (VERSION.SDK_INT >= 16) {
            this.f24151k.setBackground(this.f24138F);
        } else {
            this.f24151k.setBackgroundDrawable(this.f24138F);
        }
        this.f24151k.setOverlayDrawable(null);
        this.f24151k.setOnClickListener(null);
        int i = 0;
        this.f24151k.setClickable(false);
        this.f24151k.setContentDescription(getResources().getString(C2075R.string.tw__tweet_media));
        this.f24152l.setVisibility(8);
        if (tweet != null) {
            double d = 1.7777777777777777d;
            if (tweet.f24042H != null && VineCardUtils.m25864a(tweet.f24042H)) {
                m25907f();
                final Card card = tweet.f24042H;
                this.f24151k.setOverlayDrawable(getContext().getResources().getDrawable(C2075R.drawable.tw__player_overlay));
                this.f24159s.setCard(card);
                final Long valueOf = Long.valueOf(tweet.f24051i);
                this.f24151k.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ BaseTweetView f24128c;

                    public void onClick(View view) {
                        view = new Intent(this.f24128c.getContext(), PlayerActivity.class);
                        view.putExtra("PLAYER_ITEM", new PlayerItem(VineCardUtils.m25866c(card), this.f24128c.getContext().getResources().getString(C2075R.string.tw__cta_text), VineCardUtils.m25867d(card)));
                        view.putExtra("SCRIBE_ITEM", ScribeItem.m25884a(valueOf.longValue(), card));
                        IntentUtils.m25838a(this.f24128c.getContext(), view);
                    }
                });
                ImageValue e = VineCardUtils.m25868e(card);
                if (e != null) {
                    String str = e.f24031c;
                    if (!(e == null || e.f24030b == 0)) {
                        if (e.f24029a != 0) {
                            d = ((double) e.f24030b) / ((double) e.f24029a);
                        }
                    }
                    m25901a(str, d);
                }
                this.f24141a.m25898c().mo5507a(ScribeItem.m25884a(Long.valueOf(tweet.f24051i).longValue(), card));
            } else if (TweetMediaUtils.m25975d(tweet)) {
                r0 = TweetMediaUtils.m25973c(tweet);
                m25907f();
                this.f24151k.setOverlayDrawable(getContext().getResources().getDrawable(C2075R.drawable.tw__player_overlay));
                this.f24159s.setMediaEntity(r0);
                setAltText(r0.f34651g);
                setVideoMediaLauncher(r0);
                String str2 = r0.f34647c;
                if (!(r0 == null || r0.f34648d == null || r0.f34648d.f24034a == null || r0.f34648d.f24034a.f24032a == 0)) {
                    if (r0.f34648d.f24034a.f24033b != 0) {
                        d = ((double) r0.f34648d.f24034a.f24032a) / ((double) r0.f34648d.f24034a.f24033b);
                    }
                }
                m25901a(str2, d);
                this.f24141a.m25898c().mo5507a(ScribeItem.m25885a(tweet.f24051i, r0));
            } else {
                if (TweetMediaUtils.m25972b(tweet)) {
                    List<MediaEntity> a = TweetMediaUtils.m25970a(tweet);
                    setViewsForPhotoEntity(a.size());
                    TweetMediaView tweetMediaView = this.f24153m;
                    if (!(tweet == null || a.isEmpty())) {
                        if (!tweetMediaView.f24253b.equals(a)) {
                            int min = Math.min(4, a.size());
                            tweetMediaView.requestLayout();
                            tweetMediaView.f24253b = Collections.EMPTY_LIST;
                            tweetMediaView.f24259h = null;
                            int i2 = tweetMediaView.f24254c;
                            for (int i3 = 0; i3 < i2; i3++) {
                                ImageView imageView = tweetMediaView.f24252a[i3];
                                imageView.setVisibility(8);
                                imageView.setOnClickListener(null);
                                imageView.setTag(C2075R.id.tw__entity_index, null);
                                imageView.setContentDescription(tweetMediaView.getResources().getString(C2075R.string.tw__tweet_media));
                            }
                            tweetMediaView.f24254c = 0;
                            tweetMediaView.m25982a(min);
                            tweetMediaView.f24259h = tweet;
                            tweetMediaView.f24253b = a;
                            for (MediaEntity mediaEntity : a) {
                                String stringBuilder;
                                ImageView imageView2 = tweetMediaView.f24252a[i];
                                imageView2.setTag(C2075R.id.tw__entity_index, Integer.valueOf(i));
                                if (tweetMediaView.f24254c > 1) {
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append(mediaEntity.f34647c);
                                    stringBuilder2.append(":small");
                                    stringBuilder = stringBuilder2.toString();
                                } else {
                                    stringBuilder = mediaEntity.f34647c;
                                }
                                Picasso a2 = DependencyProvider.m25977a();
                                if (a2 != null) {
                                    RequestCreator a3 = a2.m25776a(stringBuilder);
                                    a3.f23871c = true;
                                    a3.m25788a().m25789a(tweetMediaView.f24255d).m25790a(imageView2, new PicassoCallback(imageView2));
                                }
                                TweetMediaView.m25981a(imageView2, mediaEntity.f34651g);
                                i++;
                            }
                        }
                    }
                    if (this.f24143c != null) {
                        this.f24153m.setTweetMediaClickListener(this.f24143c);
                    }
                }
            }
        }
    }
}
