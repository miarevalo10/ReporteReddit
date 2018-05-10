package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.IntentUtils;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.C2075R;
import com.twitter.sdk.android.tweetui.GalleryActivity;
import com.twitter.sdk.android.tweetui.GalleryActivity.GalleryItem;
import com.twitter.sdk.android.tweetui.TweetMediaClickListener;
import com.twitter.sdk.android.tweetui.TweetUi;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class TweetMediaView extends ViewGroup implements OnClickListener {
    public final ImageView[] f24252a;
    public List<MediaEntity> f24253b;
    public int f24254c;
    public int f24255d;
    final DependencyProvider f24256e;
    boolean f24257f;
    TweetMediaClickListener f24258g;
    public Tweet f24259h;
    private final Path f24260i;
    private final RectF f24261j;
    private int f24262k;
    private final int f24263l;

    static class DependencyProvider {
        DependencyProvider() {
        }

        public static Picasso m25977a() {
            return TweetUi.m31786a().f30784e;
        }
    }

    static class Size {
        static final Size f24249a = new Size();
        final int f24250b;
        final int f24251c;

        private Size() {
            this(0, 0);
        }

        private Size(int i, int i2) {
            this.f24250b = i;
            this.f24251c = i2;
        }

        static Size m25978a(int i, int i2) {
            i = Math.max(i, 0);
            i2 = Math.max(i2, 0);
            if (i == 0) {
                if (i2 == 0) {
                    return f24249a;
                }
            }
            return new Size(i, i2);
        }
    }

    static class PicassoCallback implements Callback {
        final WeakReference<ImageView> f30802a;

        public PicassoCallback(ImageView imageView) {
            this.f30802a = new WeakReference(imageView);
        }

        public final void mo5492a() {
            ImageView imageView = (ImageView) this.f30802a.get();
            if (imageView != null) {
                imageView.setBackgroundResource(17170445);
            }
        }
    }

    public TweetMediaView(Context context) {
        this(context, null);
    }

    public TweetMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24252a = new ImageView[4];
        this.f24253b = Collections.emptyList();
        this.f24260i = new Path();
        this.f24261j = new RectF();
        this.f24262k = -16777216;
        this.f24256e = new DependencyProvider();
        this.f24263l = getResources().getDimensionPixelSize(C2075R.dimen.tw__media_view_divider_size);
        this.f24255d = C2075R.drawable.tw__ic_tweet_photo_error_dark;
    }

    public void setRoundedCorners(boolean z) {
        this.f24257f = z;
    }

    public void setMediaBgColor(int i) {
        this.f24262k = i;
    }

    public void setTweetMediaClickListener(TweetMediaClickListener tweetMediaClickListener) {
        this.f24258g = tweetMediaClickListener;
    }

    public void setPhotoErrorResId(int i) {
        this.f24255d = i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f24254c <= false) {
            z = getMeasuredWidth();
            i = getMeasuredHeight();
            i2 = (z - this.f24263l) / 2;
            i3 = (i - this.f24263l) / 2;
            i4 = this.f24263l + i2;
            int i5;
            boolean z2;
            switch (this.f24254c) {
                case 1:
                    m25980a(0, 0, 0, z, i);
                    return;
                case 2:
                    int i6 = i;
                    m25980a(0, 0, 0, i2, i6);
                    m25980a(1, i2 + this.f24263l, 0, z, i6);
                    return;
                case 3:
                    m25980a(0, 0, 0, i2, i);
                    i5 = i4;
                    z2 = z;
                    m25980a(1, i5, 0, z2, i3);
                    m25980a(2, i5, i3 + this.f24263l, z2, i);
                    return;
                case 4:
                    int i7 = i2;
                    m25980a(0, 0, 0, i7, i3);
                    m25980a(2, 0, i3 + this.f24263l, i7, i);
                    i5 = i4;
                    z2 = z;
                    m25980a(1, i5, 0, z2, i3);
                    m25980a(3, i5, i3 + this.f24263l, z2, i);
                    break;
                default:
                    break;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f24254c > 0) {
            i = MeasureSpec.getSize(i);
            i2 = MeasureSpec.getSize(i2);
            int i3 = (i - this.f24263l) / 2;
            int i4 = (i2 - this.f24263l) / 2;
            switch (this.f24254c) {
                case 1:
                    m25979a(0, i, i2);
                    break;
                case 2:
                    m25979a(0, i3, i2);
                    m25979a(1, i3, i2);
                    break;
                case 3:
                    m25979a(0, i3, i2);
                    m25979a(1, i3, i4);
                    m25979a(2, i3, i4);
                    break;
                case 4:
                    m25979a(0, i3, i4);
                    m25979a(1, i3, i4);
                    m25979a(2, i3, i4);
                    m25979a(3, i3, i4);
                    break;
                default:
                    break;
            }
            i = Size.m25978a(i, i2);
        } else {
            i = Size.f24249a;
        }
        setMeasuredDimension(i.f24250b, i.f24251c);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f24260i.reset();
        this.f24261j.set(0.0f, 0.0f, (float) i, (float) i2);
        i = (float) getResources().getDimensionPixelSize(C2075R.dimen.tw__media_view_radius);
        this.f24260i.addRoundRect(this.f24261j, i, i, Direction.CW);
        this.f24260i.close();
    }

    protected void dispatchDraw(Canvas canvas) {
        if (!this.f24257f || VERSION.SDK_INT < 18) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.f24260i);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public void onClick(View view) {
        Integer num = (Integer) view.getTag(C2075R.id.tw__entity_index);
        if (this.f24258g != null) {
            this.f24253b.get(num.intValue());
            return;
        }
        Intent intent = new Intent(getContext(), GalleryActivity.class);
        intent.putExtra("GALLERY_ITEM", new GalleryItem(this.f24259h.f24051i, num.intValue(), this.f24253b));
        IntentUtils.m25838a(getContext(), intent);
    }

    private void m25979a(int i, int i2, int i3) {
        this.f24252a[i].measure(MeasureSpec.makeMeasureSpec(i2, 1073741824), MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    private void m25980a(int i, int i2, int i3, int i4, int i5) {
        i = this.f24252a[i];
        if (i.getLeft() != i2 || i.getTop() != i3 || i.getRight() != i4 || i.getBottom() != i5) {
            i.layout(i2, i3, i4, i5);
        }
    }

    public final void m25982a(int i) {
        this.f24254c = i;
        if (i != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                ImageView imageView = this.f24252a[i2];
                if (this.f24252a[i2] == null) {
                    imageView = new ImageView(getContext());
                    imageView.setLayoutParams(generateDefaultLayoutParams());
                    this.f24252a[i2] = imageView;
                    addView(imageView, i2);
                } else {
                    m25979a(i2, 0, 0);
                    imageView.layout(0, 0, 0, 0);
                }
                imageView.setBackgroundColor(this.f24262k);
                imageView.setOnClickListener(this);
                imageView.setVisibility(0);
            }
        }
    }

    public static void m25981a(ImageView imageView, String str) {
        if (!TextUtils.isEmpty(str)) {
            imageView.setContentDescription(str);
        }
    }
}
