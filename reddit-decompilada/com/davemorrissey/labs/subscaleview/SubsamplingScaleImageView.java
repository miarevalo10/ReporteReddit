package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executor;

public class SubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    private static final String TAG = "SubsamplingScaleImageView";
    private static final List<Integer> VALID_EASING_STYLES = Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(1)});
    private static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(new Integer[]{Integer.valueOf(0), Integer.valueOf(90), Integer.valueOf(180), Integer.valueOf(ORIENTATION_270), Integer.valueOf(-1)});
    private static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)});
    private static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3)});
    private static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)});
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private Anim anim;
    private Bitmap bitmap;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugPaint;
    private ImageRegionDecoder decoder;
    private final Object decoderLock;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private float[] dstArray;
    private int fullImageSampleSize;
    private Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    private boolean isQuickScaling;
    private boolean isZooming;
    private Matrix matrix;
    private float maxScale;
    private int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    private OnImageEventListener onImageEventListener;
    private OnLongClickListener onLongClickListener;
    private int orientation;
    private Rect pRegion;
    private boolean panEnabled;
    private int panLimit;
    private boolean parallelLoadingEnabled;
    private Float pendingScale;
    private PointF quickScaleCenter;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private PointF quickScaleLastPoint;
    private boolean quickScaleMoved;
    private final float quickScaleThreshold;
    private boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    private Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    private float scale;
    private float scaleStart;
    private float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    private PointF vCenterStart;
    private float vDistStart;
    private PointF vTranslate;
    private PointF vTranslateStart;
    private boolean zoomEnabled;

    class C03301 implements Callback {
        final /* synthetic */ SubsamplingScaleImageView f3786a;

        C03301(SubsamplingScaleImageView subsamplingScaleImageView) {
            this.f3786a = subsamplingScaleImageView;
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1 && this.f3786a.onLongClickListener != null) {
                this.f3786a.maxTouchCount = 0;
                super.setOnLongClickListener(this.f3786a.onLongClickListener);
                this.f3786a.performLongClick();
                super.setOnLongClickListener(null);
            }
            return true;
        }
    }

    private static class Anim {
        private float f3789a;
        private float f3790b;
        private PointF f3791c;
        private PointF f3792d;
        private PointF f3793e;
        private PointF f3794f;
        private PointF f3795g;
        private long f3796h;
        private boolean f3797i;
        private int f3798j;
        private long f3799k;
        private OnAnimationEventListener f3800l;

        private Anim() {
            this.f3796h = 500;
            this.f3797i = true;
            this.f3798j = 2;
            this.f3799k = System.currentTimeMillis();
        }
    }

    public final class AnimationBuilder {
        long f3801a;
        int f3802b;
        boolean f3803c;
        final /* synthetic */ SubsamplingScaleImageView f3804d;
        private final float f3805e;
        private final PointF f3806f;
        private final PointF f3807g;
        private boolean f3808h;
        private OnAnimationEventListener f3809i;

        private AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
            this.f3804d = subsamplingScaleImageView;
            this.f3801a = 500;
            this.f3802b = 2;
            this.f3803c = true;
            this.f3808h = true;
            this.f3805e = subsamplingScaleImageView.scale;
            this.f3806f = pointF;
            this.f3807g = null;
        }

        private AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f) {
            this.f3804d = subsamplingScaleImageView;
            this.f3801a = 500;
            this.f3802b = 2;
            this.f3803c = true;
            this.f3808h = true;
            this.f3805e = f;
            this.f3806f = subsamplingScaleImageView.getCenter();
            this.f3807g = null;
        }

        private AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF) {
            this.f3804d = subsamplingScaleImageView;
            this.f3801a = 500;
            this.f3802b = 2;
            this.f3803c = true;
            this.f3808h = true;
            this.f3805e = f;
            this.f3806f = pointF;
            this.f3807g = null;
        }

        private AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, PointF pointF2) {
            this.f3804d = subsamplingScaleImageView;
            this.f3801a = 500;
            this.f3802b = 2;
            this.f3803c = true;
            this.f3808h = true;
            this.f3805e = f;
            this.f3806f = pointF;
            this.f3807g = pointF2;
        }

        public final void m3394a() {
            if (!(this.f3804d.anim == null || this.f3804d.anim.f3800l == null)) {
                try {
                    this.f3804d.anim;
                } catch (Throwable e) {
                    Log.w(SubsamplingScaleImageView.TAG, "Error thrown by animation listener", e);
                }
            }
            int paddingLeft = this.f3804d.getPaddingLeft() + (((this.f3804d.getWidth() - this.f3804d.getPaddingRight()) - this.f3804d.getPaddingLeft()) / 2);
            int paddingTop = this.f3804d.getPaddingTop() + (((this.f3804d.getHeight() - this.f3804d.getPaddingBottom()) - this.f3804d.getPaddingTop()) / 2);
            float access$6100 = this.f3804d.limitedScale(this.f3805e);
            PointF access$6200 = this.f3808h ? this.f3804d.limitedSCenter(this.f3806f.x, this.f3806f.y, access$6100, new PointF()) : this.f3806f;
            this.f3804d.anim = new Anim();
            this.f3804d.anim.f3789a = this.f3804d.scale;
            this.f3804d.anim.f3790b = access$6100;
            this.f3804d.anim.f3799k = System.currentTimeMillis();
            this.f3804d.anim.f3793e = access$6200;
            this.f3804d.anim.f3791c = this.f3804d.getCenter();
            this.f3804d.anim.f3792d = access$6200;
            this.f3804d.anim.f3794f = this.f3804d.sourceToViewCoord(access$6200);
            this.f3804d.anim.f3795g = new PointF((float) paddingLeft, (float) paddingTop);
            this.f3804d.anim.f3796h = this.f3801a;
            this.f3804d.anim.f3797i = this.f3803c;
            this.f3804d.anim.f3798j = this.f3802b;
            this.f3804d.anim.f3799k = System.currentTimeMillis();
            this.f3804d.anim.f3800l = this.f3809i;
            if (this.f3807g != null) {
                float f = this.f3807g.x - (this.f3804d.anim.f3791c.x * access$6100);
                float f2 = this.f3807g.y - (this.f3804d.anim.f3791c.y * access$6100);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(access$6100, new PointF(f, f2));
                this.f3804d.fitToBounds(true, scaleAndTranslate);
                this.f3804d.anim.f3795g = new PointF(this.f3807g.x + (scaleAndTranslate.f3818b.x - f), this.f3807g.y + (scaleAndTranslate.f3818b.y - f2));
            }
            this.f3804d.invalidate();
        }
    }

    private static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {
        private final WeakReference<SubsamplingScaleImageView> f3810a;
        private final WeakReference<Context> f3811b;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> f3812c;
        private final Uri f3813d;
        private final boolean f3814e;
        private Bitmap f3815f;
        private Exception f3816g;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m3395a();
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            Integer num = (Integer) obj;
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f3810a.get();
            if (subsamplingScaleImageView != null) {
                if (this.f3815f == null || num == null) {
                    if (!(this.f3816g == null || subsamplingScaleImageView.onImageEventListener == null)) {
                        if (this.f3814e != null) {
                            subsamplingScaleImageView.onImageEventListener;
                            return;
                        }
                        subsamplingScaleImageView.onImageEventListener;
                    }
                } else if (this.f3814e) {
                    subsamplingScaleImageView.onPreviewLoaded(this.f3815f);
                } else {
                    subsamplingScaleImageView.onImageLoaded(this.f3815f, num.intValue(), false);
                }
            }
        }

        public BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z) {
            this.f3810a = new WeakReference(subsamplingScaleImageView);
            this.f3811b = new WeakReference(context);
            this.f3812c = new WeakReference(decoderFactory);
            this.f3813d = uri;
            this.f3814e = z;
        }

        private Integer m3395a() {
            try {
                String uri = this.f3813d.toString();
                Context context = (Context) this.f3811b.get();
                DecoderFactory decoderFactory = (DecoderFactory) this.f3812c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f3810a.get();
                if (!(context == null || decoderFactory == null || subsamplingScaleImageView == null)) {
                    this.f3815f = ((ImageDecoder) decoderFactory.mo1107a()).mo1108a(context, this.f3813d);
                    return Integer.valueOf(subsamplingScaleImageView.getExifOrientation(uri));
                }
            } catch (Throwable e) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap", e);
                this.f3816g = e;
            } catch (Throwable e2) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap - OutOfMemoryError", e2);
                this.f3816g = new RuntimeException(e2);
            }
            return null;
        }
    }

    public interface OnAnimationEventListener {
    }

    public interface OnImageEventListener {
    }

    private static class ScaleAndTranslate {
        private float f3817a;
        private PointF f3818b;

        private ScaleAndTranslate(float f, PointF pointF) {
            this.f3817a = f;
            this.f3818b = pointF;
        }
    }

    private static class Tile {
        private Rect f3819a;
        private int f3820b;
        private Bitmap f3821c;
        private boolean f3822d;
        private boolean f3823e;
        private Rect f3824f;
        private Rect f3825g;

        private Tile() {
        }
    }

    private static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<SubsamplingScaleImageView> f3826a;
        private final WeakReference<ImageRegionDecoder> f3827b;
        private final WeakReference<Tile> f3828c;
        private Exception f3829d;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m3413a();
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f3826a.get();
            Tile tile = (Tile) this.f3828c.get();
            if (!(subsamplingScaleImageView == null || tile == null)) {
                if (bitmap != null) {
                    tile.f3821c = bitmap;
                    tile.f3822d = null;
                    subsamplingScaleImageView.onTileLoaded();
                } else if (!(this.f3829d == null || subsamplingScaleImageView.onImageEventListener == null)) {
                    subsamplingScaleImageView.onImageEventListener;
                }
            }
        }

        public TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.f3826a = new WeakReference(subsamplingScaleImageView);
            this.f3827b = new WeakReference(imageRegionDecoder);
            this.f3828c = new WeakReference(tile);
            tile.f3822d = true;
        }

        private Bitmap m3413a() {
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f3826a.get();
                ImageRegionDecoder imageRegionDecoder = (ImageRegionDecoder) this.f3827b.get();
                Tile tile = (Tile) this.f3828c.get();
                if (imageRegionDecoder == null || tile == null || subsamplingScaleImageView == null || !imageRegionDecoder.mo1111a() || !tile.f3823e) {
                    if (tile != null) {
                        tile.f3822d = false;
                    }
                    return null;
                }
                Bitmap a;
                synchronized (subsamplingScaleImageView.decoderLock) {
                    subsamplingScaleImageView.fileSRect(tile.f3819a, tile.f3825g);
                    if (subsamplingScaleImageView.sRegion != null) {
                        tile.f3825g.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                    }
                    a = imageRegionDecoder.mo1109a(tile.f3825g, tile.f3820b);
                }
                return a;
            } catch (Throwable e) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile", e);
                this.f3829d = e;
            } catch (Throwable e2) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile - OutOfMemoryError", e2);
                this.f3829d = new RuntimeException(e2);
            }
        }
    }

    private static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<SubsamplingScaleImageView> f3830a;
        private final WeakReference<Context> f3831b;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> f3832c;
        private final Uri f3833d;
        private ImageRegionDecoder f3834e;
        private Exception f3835f;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m3414a();
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            int[] iArr = (int[]) obj;
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f3830a.get();
            if (subsamplingScaleImageView != null) {
                if (this.f3834e != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.onTilesInited(this.f3834e, iArr[0], iArr[1], iArr[2]);
                } else if (!(this.f3835f == null || subsamplingScaleImageView.onImageEventListener == null)) {
                    subsamplingScaleImageView.onImageEventListener;
                }
            }
        }

        public TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            this.f3830a = new WeakReference(subsamplingScaleImageView);
            this.f3831b = new WeakReference(context);
            this.f3832c = new WeakReference(decoderFactory);
            this.f3833d = uri;
        }

        private int[] m3414a() {
            try {
                String uri = this.f3833d.toString();
                Context context = (Context) this.f3831b.get();
                DecoderFactory decoderFactory = (DecoderFactory) this.f3832c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f3830a.get();
                if (!(context == null || decoderFactory == null || subsamplingScaleImageView == null)) {
                    this.f3834e = (ImageRegionDecoder) decoderFactory.mo1107a();
                    Point a = this.f3834e.mo1110a(context, this.f3833d);
                    int i = a.x;
                    int i2 = a.y;
                    int access$4800 = subsamplingScaleImageView.getExifOrientation(uri);
                    if (subsamplingScaleImageView.sRegion != null) {
                        i = subsamplingScaleImageView.sRegion.width();
                        i2 = subsamplingScaleImageView.sRegion.height();
                    }
                    return new int[]{i, i2, access$4800};
                }
            } catch (Throwable e) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e);
                this.f3835f = e;
            }
            return null;
        }
    }

    private float easeInOutQuad(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / (((float) j2) / 2.0f);
        if (f3 < 1.0f) {
            return (((f2 / 2.0f) * f3) * f3) + f;
        }
        f3 -= 1.0f;
        return (((-f2) / 2.0f) * ((f3 * (f3 - 2.0f)) - 1.0f)) + f;
    }

    private float easeOutQuad(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / ((float) j2);
        return (((-f2) * f3) * (f3 - 2.0f)) + f;
    }

    protected void onImageLoaded() {
    }

    protected void onReady() {
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = new Object();
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setGestureDetector(context);
        this.handler = new Handler(new C03301(this));
        if (attributeSet != null) {
            attributeSet = getContext().obtainStyledAttributes(attributeSet, C0329R.styleable.SubsamplingScaleImageView);
            if (attributeSet.hasValue(1)) {
                String string = attributeSet.getString(1);
                if (string != null && string.length() > 0) {
                    setImage(ImageSource.m3366a(string).m3368a());
                }
            }
            if (attributeSet.hasValue(0)) {
                int resourceId = attributeSet.getResourceId(0, 0);
                if (resourceId > 0) {
                    setImage(ImageSource.m3364a(resourceId).m3368a());
                }
            }
            if (attributeSet.hasValue(2)) {
                setPanEnabled(attributeSet.getBoolean(2, true));
            }
            if (attributeSet.hasValue(3)) {
                setZoomEnabled(attributeSet.getBoolean(3, true));
            }
            if (attributeSet.hasValue(4)) {
                setQuickScaleEnabled(attributeSet.getBoolean(4, true));
            }
            if (attributeSet.hasValue(5)) {
                setTileBackgroundColor(attributeSet.getColor(5, Color.argb(0, 0, 0, 0)));
            }
            attributeSet.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }

    public final void setOrientation(int i) {
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(i))) {
            this.orientation = i;
            reset(0);
            invalidate();
            requestLayout();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid orientation: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final void setImage(ImageSource imageSource) {
        setImage(imageSource, null, null);
    }

    public final void setImage(ImageSource imageSource, ImageViewState imageViewState) {
        setImage(imageSource, null, imageViewState);
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2) {
        setImage(imageSource, imageSource2, null);
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2, ImageViewState imageViewState) {
        if (imageSource == null) {
            throw new NullPointerException("imageSource must not be null");
        }
        reset(true);
        if (imageViewState != null) {
            restoreState(imageViewState);
        }
        if (imageSource2 != null) {
            if (imageSource.f3779b != null) {
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            }
            if (imageSource.f3782e > null) {
                if (imageSource.f3783f > null) {
                    this.sWidth = imageSource.f3782e;
                    this.sHeight = imageSource.f3783f;
                    this.pRegion = imageSource2.f3784g;
                    if (imageSource2.f3779b != null) {
                        this.bitmapIsCached = imageSource2.f3785h;
                        onPreviewLoaded(imageSource2.f3779b);
                    } else {
                        imageViewState = imageSource2.f3778a;
                        if (imageViewState == null && imageSource2.f3780c != null) {
                            imageViewState = new StringBuilder("android.resource://");
                            imageViewState.append(getContext().getPackageName());
                            imageViewState.append(Operation.DIVISION);
                            imageViewState.append(imageSource2.f3780c);
                            imageViewState = Uri.parse(imageViewState.toString());
                        }
                        execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, imageViewState, true));
                    }
                }
            }
            throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
        }
        if (imageSource.f3779b != null && imageSource.f3784g != null) {
            onImageLoaded(Bitmap.createBitmap(imageSource.f3779b, imageSource.f3784g.left, imageSource.f3784g.top, imageSource.f3784g.width(), imageSource.f3784g.height()), 0, false);
        } else if (imageSource.f3779b != null) {
            onImageLoaded(imageSource.f3779b, 0, imageSource.f3785h);
        } else {
            this.sRegion = imageSource.f3784g;
            this.uri = imageSource.f3778a;
            if (this.uri == null && imageSource.f3780c != null) {
                imageSource2 = new StringBuilder("android.resource://");
                imageSource2.append(getContext().getPackageName());
                imageSource2.append(Operation.DIVISION);
                imageSource2.append(imageSource.f3780c);
                this.uri = Uri.parse(imageSource2.toString());
            }
            if (imageSource.f3781d == null) {
                if (this.sRegion == null) {
                    execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
                    return;
                }
            }
            execute(new TilesInitTask(this, getContext(), this.regionDecoderFactory, this.uri));
        }
    }

    private void reset(boolean z) {
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleCenter = null;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleLastPoint = null;
        this.quickScaleMoved = false;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z) {
            this.uri = null;
            if (this.decoder) {
                synchronized (this.decoderLock) {
                    this.decoder.mo1112b();
                    this.decoder = null;
                }
            }
            if (this.bitmap && !this.bitmapIsCached) {
                this.bitmap.recycle();
            }
            this.sWidth = 0;
            this.sHeight = 0;
            this.sOrientation = 0;
            this.sRegion = null;
            this.pRegion = null;
            this.readySent = false;
            this.imageLoadedSent = false;
            this.bitmap = null;
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        if (this.tileMap) {
            for (Entry value : this.tileMap.entrySet()) {
                for (Tile tile : (List) value.getValue()) {
                    tile.f3823e = false;
                    if (tile.f3821c != null) {
                        tile.f3821c.recycle();
                        tile.f3821c = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    private void setGestureDetector(final Context context) {
        this.detector = new GestureDetector(context, new SimpleOnGestureListener(this) {
            final /* synthetic */ SubsamplingScaleImageView f3788b;

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!this.f3788b.panEnabled || !this.f3788b.readySent || this.f3788b.vTranslate == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f) <= 500.0f && Math.abs(f2) <= 500.0f) || this.f3788b.isZooming))) {
                    return super.onFling(motionEvent, motionEvent2, f, f2);
                }
                motionEvent = new PointF(this.f3788b.vTranslate.x + (f * 0.25f), this.f3788b.vTranslate.y + (f2 * 0.25f));
                motionEvent = new AnimationBuilder(new PointF((((float) (this.f3788b.getWidth() / 2)) - motionEvent.x) / this.f3788b.scale, (((float) (this.f3788b.getHeight() / 2)) - motionEvent.y) / this.f3788b.scale));
                if (SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(1)) == null) {
                    throw new IllegalArgumentException("Unknown easing type: 1");
                }
                motionEvent.f3802b = 1;
                motionEvent.f3808h = false.m3394a();
                return true;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                this.f3788b.performClick();
                return true;
            }

            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (!this.f3788b.zoomEnabled || !this.f3788b.readySent || this.f3788b.vTranslate == null) {
                    return super.onDoubleTapEvent(motionEvent);
                }
                this.f3788b.setGestureDetector(context);
                if (this.f3788b.quickScaleEnabled) {
                    this.f3788b.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                    this.f3788b.vTranslateStart = new PointF(this.f3788b.vTranslate.x, this.f3788b.vTranslate.y);
                    this.f3788b.scaleStart = this.f3788b.scale;
                    this.f3788b.isQuickScaling = true;
                    this.f3788b.isZooming = true;
                    this.f3788b.quickScaleCenter = this.f3788b.viewToSourceCoord(this.f3788b.vCenterStart);
                    this.f3788b.quickScaleLastDistance = -1.0f;
                    this.f3788b.quickScaleLastPoint = new PointF(this.f3788b.quickScaleCenter.x, this.f3788b.quickScaleCenter.y);
                    this.f3788b.quickScaleMoved = false;
                    return false;
                }
                this.f3788b.doubleTapZoom(this.f3788b.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }
        });
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        i = getCenter();
        if (this.readySent != 0 && i != 0) {
            this.anim = 0;
            this.pendingScale = Float.valueOf(this.scale);
            this.sPendingCenter = i;
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        i = MeasureSpec.getSize(i);
        i2 = MeasureSpec.getSize(i2);
        Object obj = null;
        Object obj2 = mode != 1073741824 ? 1 : null;
        if (mode2 != 1073741824) {
            obj = 1;
        }
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (obj2 != null && obj != null) {
                i = sWidth();
                i2 = sHeight();
            } else if (obj != null) {
                i2 = (int) ((((double) sHeight()) / ((double) sWidth())) * ((double) i));
            } else if (obj2 != null) {
                i = (int) ((((double) sWidth()) / ((double) sHeight())) * ((double) i2));
            }
        }
        setMeasuredDimension(Math.max(i, getSuggestedMinimumWidth()), Math.max(i2, getSuggestedMinimumHeight()));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.anim == null || this.anim.f3797i) {
            this.anim = null;
            if (this.vTranslate == null) {
                return true;
            }
            boolean z = false;
            if (this.isQuickScaling || !(this.detector == null || this.detector.onTouchEvent(motionEvent))) {
                if (this.vTranslateStart == null) {
                    this.vTranslateStart = new PointF(0.0f, 0.0f);
                }
                if (this.vCenterStart == null) {
                    this.vCenterStart = new PointF(0.0f, 0.0f);
                }
                int pointerCount = motionEvent.getPointerCount();
                float distance;
                switch (motionEvent.getAction()) {
                    case 0:
                    case 5:
                    case 261:
                        this.anim = null;
                        getParent().requestDisallowInterceptTouchEvent(true);
                        this.maxTouchCount = Math.max(this.maxTouchCount, pointerCount);
                        if (pointerCount >= 2) {
                            if (this.zoomEnabled) {
                                distance = distance(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                                this.scaleStart = this.scale;
                                this.vDistStart = distance;
                                this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
                                this.vCenterStart.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
                            } else {
                                this.maxTouchCount = 0;
                            }
                            this.handler.removeMessages(1);
                        } else if (!this.isQuickScaling) {
                            this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
                            this.vCenterStart.set(motionEvent.getX(), motionEvent.getY());
                            this.handler.sendEmptyMessageDelayed(1, 600);
                        }
                        return true;
                    case 1:
                    case 6:
                    case 262:
                        this.handler.removeMessages(1);
                        if (this.isQuickScaling) {
                            this.isQuickScaling = false;
                            if (!this.quickScaleMoved) {
                                doubleTapZoom(this.quickScaleCenter, this.vCenterStart);
                            }
                        }
                        if (this.maxTouchCount <= 0 || !(this.isZooming || this.isPanning)) {
                            if (pointerCount == 1) {
                                this.isZooming = false;
                                this.isPanning = false;
                                this.maxTouchCount = 0;
                            }
                            return true;
                        }
                        if (this.isZooming && pointerCount == 2) {
                            this.isPanning = true;
                            this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
                            if (motionEvent.getActionIndex() == 1) {
                                this.vCenterStart.set(motionEvent.getX(0), motionEvent.getY(0));
                            } else {
                                this.vCenterStart.set(motionEvent.getX(1), motionEvent.getY(1));
                            }
                        }
                        if (pointerCount < 3) {
                            this.isZooming = false;
                        }
                        if (pointerCount < 2) {
                            this.isPanning = false;
                            this.maxTouchCount = 0;
                        }
                        refreshRequiredTiles(true);
                        return true;
                    case 2:
                        if (this.maxTouchCount > 0) {
                            float distance2;
                            float x;
                            float y;
                            if (pointerCount >= 2) {
                                distance2 = distance(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                                x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                                y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                                if (this.zoomEnabled && (distance(this.vCenterStart.x, x, this.vCenterStart.y, y) > 5.0f || Math.abs(distance2 - this.vDistStart) > 5.0f || this.isPanning)) {
                                    this.isZooming = true;
                                    this.isPanning = true;
                                    this.scale = Math.min(this.maxScale, (distance2 / this.vDistStart) * this.scaleStart);
                                    if (this.scale <= minScale()) {
                                        this.vDistStart = distance2;
                                        this.scaleStart = minScale();
                                        this.vCenterStart.set(x, y);
                                        this.vTranslateStart.set(this.vTranslate);
                                    } else if (this.panEnabled) {
                                        distance2 = (this.vCenterStart.y - this.vTranslateStart.y) * (this.scale / this.scaleStart);
                                        this.vTranslate.x = x - ((this.vCenterStart.x - this.vTranslateStart.x) * (this.scale / this.scaleStart));
                                        this.vTranslate.y = y - distance2;
                                    } else if (this.sRequestedCenter != null) {
                                        this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * this.sRequestedCenter.x);
                                        this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * this.sRequestedCenter.y);
                                    } else {
                                        this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (sWidth() / 2)));
                                        this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (sHeight() / 2)));
                                    }
                                    fitToBounds(true);
                                    refreshRequiredTiles(false);
                                }
                            } else if (this.isQuickScaling) {
                                distance = (Math.abs(this.vCenterStart.y - motionEvent.getY()) * 2.0f) + this.quickScaleThreshold;
                                if (this.quickScaleLastDistance == -1.0f) {
                                    this.quickScaleLastDistance = distance;
                                }
                                r2 = motionEvent.getY() > this.quickScaleLastPoint.y;
                                this.quickScaleLastPoint.set(0.0f, motionEvent.getY());
                                r6 = 1.0f;
                                y = Math.abs(1.0f - (distance / this.quickScaleLastDistance)) * 0.5f;
                                if (y > 0.03f || this.quickScaleMoved) {
                                    this.quickScaleMoved = true;
                                    if (this.quickScaleLastDistance > 0.0f) {
                                        r6 = r2 ? 1.0f + y : 1.0f - y;
                                    }
                                    this.scale = Math.max(minScale(), Math.min(this.maxScale, this.scale * r6));
                                    if (this.panEnabled) {
                                        x = (this.vCenterStart.y - this.vTranslateStart.y) * (this.scale / this.scaleStart);
                                        this.vTranslate.x = this.vCenterStart.x - ((this.vCenterStart.x - this.vTranslateStart.x) * (this.scale / this.scaleStart));
                                        this.vTranslate.y = this.vCenterStart.y - x;
                                    } else if (this.sRequestedCenter != null) {
                                        this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * this.sRequestedCenter.x);
                                        this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * this.sRequestedCenter.y);
                                    } else {
                                        this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (sWidth() / 2)));
                                        this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (sHeight() / 2)));
                                    }
                                }
                                this.quickScaleLastDistance = distance;
                                fitToBounds(true);
                                refreshRequiredTiles(false);
                            } else if (!this.isZooming) {
                                distance2 = Math.abs(motionEvent.getX() - this.vCenterStart.x);
                                x = Math.abs(motionEvent.getY() - this.vCenterStart.y);
                                int i = (distance2 > 5.0f ? 1 : (distance2 == 5.0f ? 0 : -1));
                                if (i > 0 || x > 5.0f || this.isPanning) {
                                    this.vTranslate.x = this.vTranslateStart.x + (motionEvent.getX() - this.vCenterStart.x);
                                    this.vTranslate.y = this.vTranslateStart.y + (motionEvent.getY() - this.vCenterStart.y);
                                    distance = this.vTranslate.x;
                                    r6 = this.vTranslate.y;
                                    fitToBounds(true);
                                    boolean z2 = distance != this.vTranslate.x;
                                    r2 = z2 && distance2 > x && !this.isPanning;
                                    boolean z3 = r6 == this.vTranslate.y && x > 15.0f;
                                    if (!r2 && (!z2 || z3 || this.isPanning)) {
                                        this.isPanning = true;
                                    } else if (i > 0) {
                                        this.maxTouchCount = 0;
                                        this.handler.removeMessages(1);
                                        getParent().requestDisallowInterceptTouchEvent(false);
                                    }
                                    if (!this.panEnabled) {
                                        this.vTranslate.x = this.vTranslateStart.x;
                                        this.vTranslate.y = this.vTranslateStart.y;
                                        getParent().requestDisallowInterceptTouchEvent(false);
                                    }
                                    refreshRequiredTiles(false);
                                }
                            }
                            z = true;
                        }
                        if (z) {
                            this.handler.removeMessages(1);
                            invalidate();
                            return true;
                        }
                        break;
                    default:
                        break;
                }
                return super.onTouchEvent(motionEvent);
            }
            this.isZooming = false;
            this.isPanning = false;
            this.maxTouchCount = 0;
            return true;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    private void doubleTapZoom(PointF pointF, PointF pointF2) {
        float f;
        if (!this.panEnabled) {
            if (this.sRequestedCenter != null) {
                pointF.x = this.sRequestedCenter.x;
                pointF.y = this.sRequestedCenter.y;
            } else {
                pointF.x = (float) (sWidth() / 2);
                pointF.y = (float) (sHeight() / 2);
            }
        }
        float min = Math.min(this.maxScale, this.doubleTapZoomScale);
        boolean z = ((double) this.scale) <= ((double) min) * 0.9d;
        if (z) {
            f = min;
        } else {
            f = minScale();
        }
        if (this.doubleTapZoomStyle == 3) {
            setScaleAndCenter(f, pointF);
        } else {
            if (this.doubleTapZoomStyle != 2 && z) {
                if (this.panEnabled) {
                    if (this.doubleTapZoomStyle == 1) {
                        AnimationBuilder animationBuilder = new AnimationBuilder(min, pointF, pointF2);
                        animationBuilder.f3803c = false;
                        animationBuilder.f3801a = (long) this.doubleTapZoomDuration;
                        animationBuilder.m3394a();
                    }
                }
            }
            pointF2 = new AnimationBuilder(f, pointF);
            pointF2.f3803c = false;
            pointF2.f3801a = (long) this.doubleTapZoomDuration;
            pointF2.m3394a();
        }
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        createPaints();
        if (!(this.sWidth == 0 || r10.sHeight == 0 || getWidth() == 0)) {
            if (getHeight() != 0) {
                if (r10.tileMap == null && r10.decoder != null) {
                    initialiseBaseLayer(getMaxBitmapDimensions(canvas));
                }
                if (checkReady()) {
                    float ease;
                    PointF pointF;
                    preDraw();
                    if (r10.anim != null) {
                        boolean z;
                        long currentTimeMillis = System.currentTimeMillis() - r10.anim.f3799k;
                        boolean z2 = currentTimeMillis > r10.anim.f3796h;
                        long min = Math.min(currentTimeMillis, r10.anim.f3796h);
                        r10.scale = ease(r10.anim.f3798j, min, r10.anim.f3789a, r10.anim.f3790b - r10.anim.f3789a, r10.anim.f3796h);
                        float ease2 = ease(r10.anim.f3798j, min, r10.anim.f3794f.x, r10.anim.f3795g.x - r10.anim.f3794f.x, r10.anim.f3796h);
                        ease = ease(r10.anim.f3798j, min, r10.anim.f3794f.y, r10.anim.f3795g.y - r10.anim.f3794f.y, r10.anim.f3796h);
                        pointF = r10.vTranslate;
                        pointF.x -= sourceToViewX(r10.anim.f3792d.x) - ease2;
                        pointF = r10.vTranslate;
                        pointF.y -= sourceToViewY(r10.anim.f3792d.y) - ease;
                        if (!z2) {
                            if (r10.anim.f3789a != r10.anim.f3790b) {
                                z = false;
                                fitToBounds(z);
                                refreshRequiredTiles(z2);
                                if (z2) {
                                    r10.anim = null;
                                }
                                invalidate();
                            }
                        }
                        z = true;
                        fitToBounds(z);
                        refreshRequiredTiles(z2);
                        if (z2) {
                            r10.anim = null;
                        }
                        invalidate();
                    }
                    if (r10.tileMap == null || !isBaseLayerReady()) {
                        if (r10.bitmap != null) {
                            ease = r10.scale;
                            float f = r10.scale;
                            if (r10.bitmapIsPreview) {
                                ease = r10.scale * (((float) r10.sWidth) / ((float) r10.bitmap.getWidth()));
                                f = r10.scale * (((float) r10.sHeight) / ((float) r10.bitmap.getHeight()));
                            }
                            if (r10.matrix == null) {
                                r10.matrix = new Matrix();
                            }
                            r10.matrix.reset();
                            r10.matrix.postScale(ease, f);
                            r10.matrix.postRotate((float) getRequiredRotation());
                            r10.matrix.postTranslate(r10.vTranslate.x, r10.vTranslate.y);
                            if (getRequiredRotation() == 180) {
                                r10.matrix.postTranslate(r10.scale * ((float) r10.sWidth), r10.scale * ((float) r10.sHeight));
                            } else if (getRequiredRotation() == 90) {
                                r10.matrix.postTranslate(r10.scale * ((float) r10.sHeight), 0.0f);
                            } else if (getRequiredRotation() == ORIENTATION_270) {
                                r10.matrix.postTranslate(0.0f, r10.scale * ((float) r10.sWidth));
                            }
                            if (r10.tileBgPaint != null) {
                                if (r10.sRect == null) {
                                    r10.sRect = new RectF();
                                }
                                r10.sRect.set(0.0f, 0.0f, (float) r10.sWidth, (float) r10.sHeight);
                                r10.matrix.mapRect(r10.sRect);
                                canvas2.drawRect(r10.sRect, r10.tileBgPaint);
                            }
                            canvas2.drawBitmap(r10.bitmap, r10.matrix, r10.bitmapPaint);
                        }
                        return;
                    }
                    StringBuilder stringBuilder;
                    int min2 = Math.min(r10.fullImageSampleSize, calculateInSampleSize(r10.scale));
                    Object obj = null;
                    for (Entry entry : r10.tileMap.entrySet()) {
                        if (((Integer) entry.getKey()).intValue() == min2) {
                            for (Tile tile : (List) entry.getValue()) {
                                if (tile.f3823e && (tile.f3822d || tile.f3821c == null)) {
                                    obj = 1;
                                }
                            }
                        }
                    }
                    Iterator it = r10.tileMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Entry entry2 = (Entry) it.next();
                        if (((Integer) entry2.getKey()).intValue() != min2) {
                            if (obj != null) {
                            }
                            it = it;
                            min2 = min2;
                        }
                        Iterator it2 = ((List) entry2.getValue()).iterator();
                        while (it2.hasNext()) {
                            Tile tile2;
                            Iterator it3;
                            Iterator it4;
                            int i;
                            Tile tile3 = (Tile) it2.next();
                            sourceToViewRect(tile3.f3819a, tile3.f3824f);
                            if (tile3.f3822d || tile3.f3821c == null) {
                                tile2 = tile3;
                                it3 = it2;
                                it4 = it;
                                i = min2;
                                if (tile2.f3822d && r10.debug) {
                                    canvas2.drawText("LOADING", (float) (tile2.f3824f.left + 5), (float) (tile2.f3824f.top + 35), r10.debugPaint);
                                }
                            } else {
                                if (r10.tileBgPaint != null) {
                                    canvas2.drawRect(tile3.f3824f, r10.tileBgPaint);
                                }
                                if (r10.matrix == null) {
                                    r10.matrix = new Matrix();
                                }
                                r10.matrix.reset();
                                tile2 = tile3;
                                it3 = it2;
                                it4 = it;
                                i = min2;
                                setMatrixArray(r10.srcArray, 0.0f, 0.0f, (float) tile3.f3821c.getWidth(), 0.0f, (float) tile3.f3821c.getWidth(), (float) tile3.f3821c.getHeight(), 0.0f, (float) tile3.f3821c.getHeight());
                                if (getRequiredRotation() == 0) {
                                    setMatrixArray(r10.dstArray, (float) tile2.f3824f.left, (float) tile2.f3824f.top, (float) tile2.f3824f.right, (float) tile2.f3824f.top, (float) tile2.f3824f.right, (float) tile2.f3824f.bottom, (float) tile2.f3824f.left, (float) tile2.f3824f.bottom);
                                } else if (getRequiredRotation() == 90) {
                                    setMatrixArray(r10.dstArray, (float) tile2.f3824f.right, (float) tile2.f3824f.top, (float) tile2.f3824f.right, (float) tile2.f3824f.bottom, (float) tile2.f3824f.left, (float) tile2.f3824f.bottom, (float) tile2.f3824f.left, (float) tile2.f3824f.top);
                                } else if (getRequiredRotation() == 180) {
                                    setMatrixArray(r10.dstArray, (float) tile2.f3824f.right, (float) tile2.f3824f.bottom, (float) tile2.f3824f.left, (float) tile2.f3824f.bottom, (float) tile2.f3824f.left, (float) tile2.f3824f.top, (float) tile2.f3824f.right, (float) tile2.f3824f.top);
                                } else if (getRequiredRotation() == ORIENTATION_270) {
                                    setMatrixArray(r10.dstArray, (float) tile2.f3824f.left, (float) tile2.f3824f.bottom, (float) tile2.f3824f.left, (float) tile2.f3824f.top, (float) tile2.f3824f.right, (float) tile2.f3824f.top, (float) tile2.f3824f.right, (float) tile2.f3824f.bottom);
                                }
                                r10.matrix.setPolyToPoly(r10.srcArray, 0, r10.dstArray, 0, 4);
                                canvas2.drawBitmap(tile2.f3821c, r10.matrix, r10.bitmapPaint);
                                if (r10.debug) {
                                    canvas2.drawRect(tile2.f3824f, r10.debugPaint);
                                }
                            }
                            if (tile2.f3823e && r10.debug) {
                                stringBuilder = new StringBuilder("ISS ");
                                stringBuilder.append(tile2.f3820b);
                                stringBuilder.append(" RECT ");
                                stringBuilder.append(tile2.f3819a.top);
                                stringBuilder.append(",");
                                stringBuilder.append(tile2.f3819a.left);
                                stringBuilder.append(",");
                                stringBuilder.append(tile2.f3819a.bottom);
                                stringBuilder.append(",");
                                stringBuilder.append(tile2.f3819a.right);
                                canvas2.drawText(stringBuilder.toString(), (float) (tile2.f3824f.left + 5), (float) (tile2.f3824f.top + 15), r10.debugPaint);
                            }
                            it2 = it3;
                            it = it4;
                            min2 = i;
                        }
                        it = it;
                        min2 = min2;
                    }
                    if (r10.debug) {
                        stringBuilder = new StringBuilder("Scale: ");
                        stringBuilder.append(String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(r10.scale)}));
                        canvas2.drawText(stringBuilder.toString(), 5.0f, 15.0f, r10.debugPaint);
                        stringBuilder = new StringBuilder("Translate: ");
                        stringBuilder.append(String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(r10.vTranslate.x)}));
                        stringBuilder.append(":");
                        stringBuilder.append(String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(r10.vTranslate.y)}));
                        canvas2.drawText(stringBuilder.toString(), 5.0f, 35.0f, r10.debugPaint);
                        PointF center = getCenter();
                        StringBuilder stringBuilder2 = new StringBuilder("Source center: ");
                        stringBuilder2.append(String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(center.x)}));
                        stringBuilder2.append(":");
                        stringBuilder2.append(String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(center.y)}));
                        canvas2.drawText(stringBuilder2.toString(), 5.0f, 55.0f, r10.debugPaint);
                        if (r10.anim != null) {
                            center = sourceToViewCoord(r10.anim.f3791c);
                            pointF = sourceToViewCoord(r10.anim.f3793e);
                            PointF sourceToViewCoord = sourceToViewCoord(r10.anim.f3792d);
                            canvas2.drawCircle(center.x, center.y, 10.0f, r10.debugPaint);
                            canvas2.drawCircle(pointF.x, pointF.y, 20.0f, r10.debugPaint);
                            canvas2.drawCircle(sourceToViewCoord.x, sourceToViewCoord.y, 25.0f, r10.debugPaint);
                            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), 30.0f, r10.debugPaint);
                        }
                    }
                }
            }
        }
    }

    private void setMatrixArray(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        fArr[6] = f7;
        fArr[7] = f8;
    }

    private boolean isBaseLayerReady() {
        boolean z = true;
        if (this.bitmap != null && !this.bitmapIsPreview) {
            return true;
        }
        if (this.tileMap == null) {
            return false;
        }
        for (Entry entry : this.tileMap.entrySet()) {
            if (((Integer) entry.getKey()).intValue() == this.fullImageSampleSize) {
                for (Tile tile : (List) entry.getValue()) {
                    if (tile.f3822d || tile.f3821c == null) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    private boolean checkReady() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady());
        if (!this.readySent && z) {
            preDraw();
            this.readySent = true;
            onReady();
        }
        return z;
    }

    private boolean checkImageLoaded() {
        boolean isBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && isBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
        }
        return isBaseLayerReady;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            this.bitmapPaint = new Paint();
            this.bitmapPaint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if (this.debugPaint == null && this.debug) {
            this.debugPaint = new Paint();
            this.debugPaint.setTextSize(18.0f);
            this.debugPaint.setColor(-65281);
            this.debugPaint.setStyle(Style.STROKE);
        }
    }

    private synchronized void initialiseBaseLayer(Point point) {
        this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        fitToBounds(true, this.satTemp);
        this.fullImageSampleSize = calculateInSampleSize(this.satTemp.f3817a);
        if (this.fullImageSampleSize > 1) {
            this.fullImageSampleSize /= 2;
        }
        if (this.fullImageSampleSize != 1 || this.sRegion != null || sWidth() >= point.x || sHeight() >= point.y) {
            initialiseTileMap(point);
            for (Tile tileLoadTask : (List) this.tileMap.get(Integer.valueOf(this.fullImageSampleSize))) {
                execute(new TileLoadTask(this, this.decoder, tileLoadTask));
            }
            refreshRequiredTiles(true);
            return;
        }
        this.decoder.mo1112b();
        this.decoder = null;
        execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
    }

    private void refreshRequiredTiles(boolean z) {
        if (this.decoder != null) {
            if (this.tileMap != null) {
                int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
                for (Entry value : this.tileMap.entrySet()) {
                    for (Tile tile : (List) value.getValue()) {
                        if (tile.f3820b < min || (tile.f3820b > min && tile.f3820b != this.fullImageSampleSize)) {
                            tile.f3823e = false;
                            if (tile.f3821c != null) {
                                tile.f3821c.recycle();
                                tile.f3821c = null;
                            }
                        }
                        if (tile.f3820b == min) {
                            if (tileVisible(tile)) {
                                tile.f3823e = true;
                                if (!tile.f3822d && tile.f3821c == null && z) {
                                    execute(new TileLoadTask(this, this.decoder, tile));
                                }
                            } else if (tile.f3820b != this.fullImageSampleSize) {
                                tile.f3823e = false;
                                if (tile.f3821c != null) {
                                    tile.f3821c.recycle();
                                    tile.f3821c = null;
                                }
                            }
                        } else if (tile.f3820b == this.fullImageSampleSize) {
                            tile.f3823e = true;
                        }
                    }
                }
            }
        }
    }

    private boolean tileVisible(Tile tile) {
        return (viewToSourceX(0.0f) > ((float) tile.f3819a.right) || ((float) tile.f3819a.left) > viewToSourceX((float) getWidth()) || viewToSourceY(0.0f) > ((float) tile.f3819a.bottom) || ((float) tile.f3819a.top) > viewToSourceY((float) getHeight())) ? null : true;
    }

    private void preDraw() {
        if (!(getWidth() == 0 || getHeight() == 0 || this.sWidth <= 0)) {
            if (this.sHeight > 0) {
                if (!(this.sPendingCenter == null || this.pendingScale == null)) {
                    this.scale = this.pendingScale.floatValue();
                    if (this.vTranslate == null) {
                        this.vTranslate = new PointF();
                    }
                    this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * this.sPendingCenter.x);
                    this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * this.sPendingCenter.y);
                    this.sPendingCenter = null;
                    this.pendingScale = null;
                    fitToBounds(true);
                    refreshRequiredTiles(true);
                }
                fitToBounds(false);
            }
        }
    }

    private int calculateInSampleSize(float f) {
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f *= ((float) this.minimumTileDpi) / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int sWidth = (int) (((float) sWidth()) * f);
        int sHeight = (int) (((float) sHeight()) * f);
        if (sWidth != 0) {
            if (sHeight != 0) {
                int i = 1;
                if (sHeight() <= sHeight) {
                    if (sWidth() <= sWidth) {
                        sHeight = 1;
                        while (true) {
                            sWidth = i * 2;
                            if (sWidth < sHeight) {
                                return i;
                            }
                            i = sWidth;
                        }
                    }
                }
                sHeight = Math.round(((float) sHeight()) / ((float) sHeight));
                sWidth = Math.round(((float) sWidth()) / ((float) sWidth));
                if (sHeight >= sWidth) {
                    sHeight = sWidth;
                }
                while (true) {
                    sWidth = i * 2;
                    if (sWidth < sHeight) {
                        return i;
                    }
                    i = sWidth;
                }
            }
        }
        return 32;
    }

    private void fitToBounds(boolean z, ScaleAndTranslate scaleAndTranslate) {
        float f;
        float max;
        if (this.panLimit == 2 && isReady()) {
            z = false;
        }
        PointF b = scaleAndTranslate.f3818b;
        float limitedScale = limitedScale(scaleAndTranslate.f3817a);
        float sWidth = ((float) sWidth()) * limitedScale;
        float sHeight = ((float) sHeight()) * limitedScale;
        if (this.panLimit == 3 && isReady()) {
            b.x = Math.max(b.x, ((float) (getWidth() / 2)) - sWidth);
            b.y = Math.max(b.y, ((float) (getHeight() / 2)) - sHeight);
        } else if (z) {
            b.x = Math.max(b.x, ((float) getWidth()) - sWidth);
            b.y = Math.max(b.y, ((float) getHeight()) - sHeight);
        } else {
            b.x = Math.max(b.x, -sWidth);
            b.y = Math.max(b.y, -sHeight);
        }
        float f2 = 0.5f;
        if (getPaddingLeft() <= 0) {
            if (getPaddingRight() <= 0) {
                f = 0.5f;
                if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
                    f2 = ((float) getPaddingTop()) / ((float) (getPaddingTop() + getPaddingBottom()));
                }
                if (this.panLimit != 3 && isReady()) {
                    z = (float) Math.max(0, getWidth() / true);
                    max = (float) Math.max(0, getHeight() / 2);
                } else if (z) {
                    z = (float) Math.max(0, getWidth());
                    max = (float) Math.max(0, getHeight());
                } else {
                    z = Math.max(0.0f, (((float) getWidth()) - sWidth) * f);
                    max = Math.max(0.0f, (((float) getHeight()) - sHeight) * f2);
                }
                b.x = Math.min(b.x, z);
                b.y = Math.min(b.y, max);
                scaleAndTranslate.f3817a = limitedScale;
            }
        }
        f = ((float) getPaddingLeft()) / ((float) (getPaddingLeft() + getPaddingRight()));
        f2 = ((float) getPaddingTop()) / ((float) (getPaddingTop() + getPaddingBottom()));
        if (this.panLimit != 3) {
        }
        if (z) {
            z = (float) Math.max(0, getWidth());
            max = (float) Math.max(0, getHeight());
        } else {
            z = Math.max(0.0f, (((float) getWidth()) - sWidth) * f);
            max = Math.max(0.0f, (((float) getHeight()) - sHeight) * f2);
        }
        b.x = Math.min(b.x, z);
        b.y = Math.min(b.y, max);
        scaleAndTranslate.f3817a = limitedScale;
    }

    private void fitToBounds(boolean z) {
        byte b;
        if (this.vTranslate == null) {
            b = (byte) 1;
            this.vTranslate = new PointF(0.0f, 0.0f);
        } else {
            b = (byte) 0;
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        this.satTemp.f3817a = this.scale;
        this.satTemp.f3818b.set(this.vTranslate);
        fitToBounds(z, this.satTemp);
        this.scale = this.satTemp.f3817a;
        this.vTranslate.set(this.satTemp.f3818b);
        if (b != (byte) 0) {
            this.vTranslate.set(vTranslateForSCenter((float) (sWidth() / 2), (float) (sHeight() / 2), this.scale));
        }
    }

    private void initialiseTileMap(Point point) {
        Point point2 = point;
        this.tileMap = new LinkedHashMap();
        boolean z = true;
        int i = this.fullImageSampleSize;
        int i2 = 1;
        int i3 = i2;
        while (true) {
            List arrayList;
            byte b;
            int i4;
            int sWidth = sWidth() / i2;
            int sHeight = sHeight() / i3;
            int i5 = sWidth / i;
            int i6 = sHeight / i;
            while (true) {
                if ((i5 + i2) + z <= point2.x) {
                    if (((double) i5) <= ((double) getWidth()) * 1.25d || i >= r0.fullImageSampleSize) {
                        while (true) {
                            i3++;
                            sHeight = sHeight() / i3;
                            i6 = sHeight / i;
                        }
                    }
                }
                i2++;
                sWidth = sWidth() / i2;
                i5 = sWidth / i;
            }
            while (true) {
                if ((i6 + i3) + z <= point2.y) {
                    if (((double) i6) <= ((double) getHeight()) * 1.25d || i >= r0.fullImageSampleSize) {
                        arrayList = new ArrayList(i2 * i3);
                        b = (byte) 0;
                        i4 = 0;
                    }
                }
                i3++;
                sHeight = sHeight() / i3;
                i6 = sHeight / i;
            }
            arrayList = new ArrayList(i2 * i3);
            b = (byte) 0;
            i4 = 0;
            while (i4 < i2) {
                int i7 = b;
                while (i7 < i3) {
                    Tile tile = new Tile();
                    tile.f3820b = i;
                    tile.f3823e = i == r0.fullImageSampleSize ? z : r9;
                    tile.f3819a = new Rect(i4 * sWidth, i7 * sHeight, i4 == i2 + -1 ? sWidth() : (i4 + 1) * sWidth, i7 == i3 + -1 ? sHeight() : (i7 + 1) * sHeight);
                    b = (byte) 0;
                    tile.f3824f = new Rect(0, 0, 0, 0);
                    tile.f3825g = new Rect(tile.f3819a);
                    arrayList.add(tile);
                    i7++;
                    z = true;
                }
                i4++;
                z = true;
            }
            r0.tileMap.put(Integer.valueOf(i), arrayList);
            z = true;
            if (i != 1) {
                i /= 2;
            } else {
                return;
            }
        }
    }

    private synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i, int i2, int i3) {
        if (this.sWidth > 0 && this.sHeight > 0 && !(this.sWidth == i && this.sHeight == i2)) {
            reset(false);
            if (this.bitmap != null) {
                if (!this.bitmapIsCached) {
                    this.bitmap.recycle();
                }
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
        }
        this.decoder = imageRegionDecoder;
        this.sWidth = i;
        this.sHeight = i2;
        this.sOrientation = i3;
        checkReady();
        checkImageLoaded();
        invalidate();
        requestLayout();
    }

    private synchronized void onTileLoaded() {
        checkReady();
        checkImageLoaded();
        if (isBaseLayerReady() && this.bitmap != null) {
            if (!this.bitmapIsCached) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        invalidate();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void onPreviewLoaded(android.graphics.Bitmap r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.bitmap;	 Catch:{ all -> 0x0041 }
        if (r0 != 0) goto L_0x003c;
    L_0x0005:
        r0 = r4.imageLoadedSent;	 Catch:{ all -> 0x0041 }
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        goto L_0x003c;
    L_0x000a:
        r0 = r4.pRegion;	 Catch:{ all -> 0x0041 }
        if (r0 == 0) goto L_0x0029;
    L_0x000e:
        r0 = r4.pRegion;	 Catch:{ all -> 0x0041 }
        r0 = r0.left;	 Catch:{ all -> 0x0041 }
        r1 = r4.pRegion;	 Catch:{ all -> 0x0041 }
        r1 = r1.top;	 Catch:{ all -> 0x0041 }
        r2 = r4.pRegion;	 Catch:{ all -> 0x0041 }
        r2 = r2.width();	 Catch:{ all -> 0x0041 }
        r3 = r4.pRegion;	 Catch:{ all -> 0x0041 }
        r3 = r3.height();	 Catch:{ all -> 0x0041 }
        r5 = android.graphics.Bitmap.createBitmap(r5, r0, r1, r2, r3);	 Catch:{ all -> 0x0041 }
        r4.bitmap = r5;	 Catch:{ all -> 0x0041 }
        goto L_0x002b;
    L_0x0029:
        r4.bitmap = r5;	 Catch:{ all -> 0x0041 }
    L_0x002b:
        r5 = 1;
        r4.bitmapIsPreview = r5;	 Catch:{ all -> 0x0041 }
        r5 = r4.checkReady();	 Catch:{ all -> 0x0041 }
        if (r5 == 0) goto L_0x003a;
    L_0x0034:
        r4.invalidate();	 Catch:{ all -> 0x0041 }
        r4.requestLayout();	 Catch:{ all -> 0x0041 }
    L_0x003a:
        monitor-exit(r4);
        return;
    L_0x003c:
        r5.recycle();	 Catch:{ all -> 0x0041 }
        monitor-exit(r4);
        return;
    L_0x0041:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onPreviewLoaded(android.graphics.Bitmap):void");
    }

    private synchronized void onImageLoaded(Bitmap bitmap, int i, boolean z) {
        if (this.sWidth > 0 && this.sHeight > 0 && !(this.sWidth == bitmap.getWidth() && this.sHeight == bitmap.getHeight())) {
            reset(false);
        }
        if (!(this.bitmap == null || this.bitmapIsCached)) {
            this.bitmap.recycle();
        }
        this.bitmapIsPreview = false;
        this.bitmapIsCached = z;
        this.bitmap = bitmap;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.sOrientation = i;
        bitmap = checkReady();
        i = checkImageLoaded();
        if (!(bitmap == null && i == 0)) {
            invalidate();
            requestLayout();
        }
    }

    private int getExifOrientation(java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = "content";
        r0 = r9.startsWith(r0);
        r1 = 0;
        if (r0 == 0) goto L_0x005e;
    L_0x0009:
        r0 = "orientation";	 Catch:{ Exception -> 0x0056 }
        r4 = new java.lang.String[]{r0};	 Catch:{ Exception -> 0x0056 }
        r0 = r8.getContext();	 Catch:{ Exception -> 0x0056 }
        r2 = r0.getContentResolver();	 Catch:{ Exception -> 0x0056 }
        r3 = android.net.Uri.parse(r9);	 Catch:{ Exception -> 0x0056 }
        r5 = 0;	 Catch:{ Exception -> 0x0056 }
        r6 = 0;	 Catch:{ Exception -> 0x0056 }
        r7 = 0;	 Catch:{ Exception -> 0x0056 }
        r9 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0056 }
        if (r9 == 0) goto L_0x00b2;	 Catch:{ Exception -> 0x0056 }
    L_0x0024:
        r0 = r9.moveToFirst();	 Catch:{ Exception -> 0x0056 }
        if (r0 == 0) goto L_0x0052;	 Catch:{ Exception -> 0x0056 }
    L_0x002a:
        r0 = r9.getInt(r1);	 Catch:{ Exception -> 0x0056 }
        r2 = VALID_ORIENTATIONS;	 Catch:{ Exception -> 0x0056 }
        r3 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0056 }
        r2 = r2.contains(r3);	 Catch:{ Exception -> 0x0056 }
        if (r2 == 0) goto L_0x003f;	 Catch:{ Exception -> 0x0056 }
    L_0x003a:
        r2 = -1;	 Catch:{ Exception -> 0x0056 }
        if (r0 == r2) goto L_0x003f;	 Catch:{ Exception -> 0x0056 }
    L_0x003d:
        r1 = r0;	 Catch:{ Exception -> 0x0056 }
        goto L_0x0052;	 Catch:{ Exception -> 0x0056 }
    L_0x003f:
        r2 = TAG;	 Catch:{ Exception -> 0x0056 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0056 }
        r4 = "Unsupported orientation: ";	 Catch:{ Exception -> 0x0056 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0056 }
        r3.append(r0);	 Catch:{ Exception -> 0x0056 }
        r0 = r3.toString();	 Catch:{ Exception -> 0x0056 }
        android.util.Log.w(r2, r0);	 Catch:{ Exception -> 0x0056 }
    L_0x0052:
        r9.close();	 Catch:{ Exception -> 0x0056 }
        goto L_0x00b2;
    L_0x0056:
        r9 = TAG;
        r0 = "Could not get orientation of image from media store";
        android.util.Log.w(r9, r0);
        goto L_0x00b2;
    L_0x005e:
        r0 = "file:///";
        r0 = r9.startsWith(r0);
        if (r0 == 0) goto L_0x00b2;
    L_0x0066:
        r0 = "file:///android_asset/";
        r0 = r9.startsWith(r0);
        if (r0 != 0) goto L_0x00b2;
    L_0x006e:
        r0 = new android.media.ExifInterface;	 Catch:{ Exception -> 0x00ab }
        r2 = 7;	 Catch:{ Exception -> 0x00ab }
        r9 = r9.substring(r2);	 Catch:{ Exception -> 0x00ab }
        r0.<init>(r9);	 Catch:{ Exception -> 0x00ab }
        r9 = "Orientation";	 Catch:{ Exception -> 0x00ab }
        r2 = 1;	 Catch:{ Exception -> 0x00ab }
        r9 = r0.getAttributeInt(r9, r2);	 Catch:{ Exception -> 0x00ab }
        if (r9 == r2) goto L_0x00b2;	 Catch:{ Exception -> 0x00ab }
    L_0x0081:
        if (r9 != 0) goto L_0x0084;	 Catch:{ Exception -> 0x00ab }
    L_0x0083:
        goto L_0x00b2;	 Catch:{ Exception -> 0x00ab }
    L_0x0084:
        r0 = 6;	 Catch:{ Exception -> 0x00ab }
        if (r9 != r0) goto L_0x008a;	 Catch:{ Exception -> 0x00ab }
    L_0x0087:
        r1 = 90;	 Catch:{ Exception -> 0x00ab }
        goto L_0x00b2;	 Catch:{ Exception -> 0x00ab }
    L_0x008a:
        r0 = 3;	 Catch:{ Exception -> 0x00ab }
        if (r9 != r0) goto L_0x0090;	 Catch:{ Exception -> 0x00ab }
    L_0x008d:
        r1 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;	 Catch:{ Exception -> 0x00ab }
        goto L_0x00b2;	 Catch:{ Exception -> 0x00ab }
    L_0x0090:
        r0 = 8;	 Catch:{ Exception -> 0x00ab }
        if (r9 != r0) goto L_0x0097;	 Catch:{ Exception -> 0x00ab }
    L_0x0094:
        r1 = 270; // 0x10e float:3.78E-43 double:1.334E-321;	 Catch:{ Exception -> 0x00ab }
        goto L_0x00b2;	 Catch:{ Exception -> 0x00ab }
    L_0x0097:
        r0 = TAG;	 Catch:{ Exception -> 0x00ab }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ab }
        r3 = "Unsupported EXIF orientation: ";	 Catch:{ Exception -> 0x00ab }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00ab }
        r2.append(r9);	 Catch:{ Exception -> 0x00ab }
        r9 = r2.toString();	 Catch:{ Exception -> 0x00ab }
        android.util.Log.w(r0, r9);	 Catch:{ Exception -> 0x00ab }
        goto L_0x00b2;
    L_0x00ab:
        r9 = TAG;
        r0 = "Could not get EXIF orientation of image";
        android.util.Log.w(r9, r0);
    L_0x00b2:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.getExifOrientation(java.lang.String):int");
    }

    private void execute(AsyncTask<Void, Void, ?> asyncTask) {
        if (this.parallelLoadingEnabled && VERSION.SDK_INT >= 11) {
            try {
                Executor executor = (Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null);
                AsyncTask.class.getMethod("executeOnExecutor", new Class[]{Executor.class, Object[].class}).invoke(asyncTask, new Object[]{executor, null});
                return;
            } catch (Throwable e) {
                Log.i(TAG, "Failed to execute AsyncTask on thread pool executor, falling back to single threaded executor", e);
            }
        }
        asyncTask.execute(new Void[0]);
    }

    private void restoreState(ImageViewState imageViewState) {
        if (imageViewState != null && imageViewState.getCenter() != null && VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.orientation = imageViewState.getOrientation();
            this.pendingScale = Float.valueOf(imageViewState.getScale());
            this.sPendingCenter = imageViewState.getCenter();
            invalidate();
        }
    }

    private android.graphics.Point getMaxBitmapDimensions(android.graphics.Canvas r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 14;
        if (r0 < r1) goto L_0x0039;
    L_0x0006:
        r0 = android.graphics.Canvas.class;	 Catch:{ Exception -> 0x0039 }
        r1 = "getMaximumBitmapWidth";	 Catch:{ Exception -> 0x0039 }
        r2 = 0;	 Catch:{ Exception -> 0x0039 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0039 }
        r0 = r0.getMethod(r1, r3);	 Catch:{ Exception -> 0x0039 }
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0039 }
        r0 = r0.invoke(r6, r1);	 Catch:{ Exception -> 0x0039 }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x0039 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0039 }
        r1 = android.graphics.Canvas.class;	 Catch:{ Exception -> 0x0039 }
        r3 = "getMaximumBitmapHeight";	 Catch:{ Exception -> 0x0039 }
        r4 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0039 }
        r1 = r1.getMethod(r3, r4);	 Catch:{ Exception -> 0x0039 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0039 }
        r6 = r1.invoke(r6, r2);	 Catch:{ Exception -> 0x0039 }
        r6 = (java.lang.Integer) r6;	 Catch:{ Exception -> 0x0039 }
        r6 = r6.intValue();	 Catch:{ Exception -> 0x0039 }
        r1 = new android.graphics.Point;	 Catch:{ Exception -> 0x0039 }
        r1.<init>(r0, r6);	 Catch:{ Exception -> 0x0039 }
        return r1;
    L_0x0039:
        r6 = new android.graphics.Point;
        r0 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r6.<init>(r0, r0);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.getMaxBitmapDimensions(android.graphics.Canvas):android.graphics.Point");
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90) {
            if (requiredRotation != ORIENTATION_270) {
                return this.sWidth;
            }
        }
        return this.sHeight;
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90) {
            if (requiredRotation != ORIENTATION_270) {
                return this.sHeight;
            }
        }
        return this.sWidth;
    }

    private void fileSRect(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (getRequiredRotation() == 90) {
            rect2.set(rect.top, this.sHeight - rect.right, rect.bottom, this.sHeight - rect.left);
        } else if (getRequiredRotation() == 180) {
            rect2.set(this.sWidth - rect.right, this.sHeight - rect.bottom, this.sWidth - rect.left, this.sHeight - rect.top);
        } else {
            rect2.set(this.sWidth - rect.bottom, rect.left, this.sWidth - rect.top, rect.right);
        }
    }

    private int getRequiredRotation() {
        if (this.orientation == -1) {
            return this.sOrientation;
        }
        return this.orientation;
    }

    private float distance(float f, float f2, float f3, float f4) {
        f -= f2;
        f3 -= f4;
        return (float) Math.sqrt((double) ((f * f) + (f3 * f3)));
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugPaint = null;
        this.tileBgPaint = null;
    }

    private float viewToSourceX(float f) {
        if (this.vTranslate == null) {
            return Float.NaN;
        }
        return (f - this.vTranslate.x) / this.scale;
    }

    private float viewToSourceY(float f) {
        if (this.vTranslate == null) {
            return Float.NaN;
        }
        return (f - this.vTranslate.y) / this.scale;
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF viewToSourceCoord(float f, float f2) {
        return viewToSourceCoord(f, f2, new PointF());
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF viewToSourceCoord(float f, float f2, PointF pointF) {
        if (this.vTranslate == null) {
            return 0.0f;
        }
        pointF.set(viewToSourceX(f), viewToSourceY(f2));
        return pointF;
    }

    private float sourceToViewX(float f) {
        if (this.vTranslate == null) {
            return Float.NaN;
        }
        return (f * this.scale) + this.vTranslate.x;
    }

    private float sourceToViewY(float f) {
        if (this.vTranslate == null) {
            return Float.NaN;
        }
        return (f * this.scale) + this.vTranslate.y;
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF sourceToViewCoord(float f, float f2) {
        return sourceToViewCoord(f, f2, new PointF());
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF sourceToViewCoord(float f, float f2, PointF pointF) {
        if (this.vTranslate == null) {
            return 0.0f;
        }
        pointF.set(sourceToViewX(f), sourceToViewY(f2));
        return pointF;
    }

    private Rect sourceToViewRect(Rect rect, Rect rect2) {
        rect2.set((int) sourceToViewX((float) rect.left), (int) sourceToViewY((float) rect.top), (int) sourceToViewX((float) rect.right), (int) sourceToViewY((float) rect.bottom));
        return rect2;
    }

    private PointF vTranslateForSCenter(float f, float f2, float f3) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        this.satTemp.f3817a = f3;
        this.satTemp.f3818b.set(((float) paddingLeft) - (f * f3), ((float) paddingTop) - (f2 * f3));
        fitToBounds(Float.MIN_VALUE, this.satTemp);
        return this.satTemp.f3818b;
    }

    private PointF limitedSCenter(float f, float f2, float f3, PointF pointF) {
        f = vTranslateForSCenter(f, f2, f3);
        pointF.set((((float) (getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2))) - f.x) / f3, (((float) (getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2))) - f.y) / f3);
        return pointF;
    }

    private float minScale() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        if (this.minimumScaleType == 2) {
            return Math.max(((float) (getWidth() - paddingLeft)) / ((float) sWidth()), ((float) (getHeight() - paddingBottom)) / ((float) sHeight()));
        }
        if (this.minimumScaleType != 3 || this.minScale <= 0.0f) {
            return Math.min(((float) (getWidth() - paddingLeft)) / ((float) sWidth()), ((float) (getHeight() - paddingBottom)) / ((float) sHeight()));
        }
        return this.minScale;
    }

    private float limitedScale(float f) {
        return Math.min(this.maxScale, Math.max(minScale(), f));
    }

    private float ease(int i, long j, float f, float f2, long j2) {
        switch (i) {
            case 1:
                return easeOutQuad(j, f, f2, j2);
            case 2:
                return easeInOutQuad(j, f, f2, j2);
            default:
                StringBuilder stringBuilder = new StringBuilder("Unexpected easing type: ");
                stringBuilder.append(i);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.regionDecoderFactory = new CompatDecoderFactory(cls);
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.regionDecoderFactory = decoderFactory;
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.bitmapDecoderFactory = decoderFactory;
    }

    public final void setPanLimit(int i) {
        if (VALID_PAN_LIMITS.contains(Integer.valueOf(i))) {
            this.panLimit = i;
            if (isReady() != 0) {
                fitToBounds(1);
                invalidate();
                return;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid pan limit: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final void setMinimumScaleType(int i) {
        if (VALID_SCALE_TYPES.contains(Integer.valueOf(i))) {
            this.minimumScaleType = i;
            if (isReady() != 0) {
                fitToBounds(1);
                invalidate();
                return;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid scale type: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final void setMaxScale(float f) {
        this.maxScale = f;
    }

    public final void setMinScale(float f) {
        this.minScale = f;
    }

    public final void setMinimumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i));
    }

    public final void setMaximumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i));
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public void setMinimumTileDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, (float) i);
        if (isReady() != 0) {
            reset(0);
            invalidate();
        }
    }

    public final PointF getCenter() {
        return viewToSourceCoord((float) (getWidth() / 2), (float) (getHeight() / 2));
    }

    public final float getScale() {
        return this.scale;
    }

    public final void setScaleAndCenter(float f, PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new PointF((float) (sWidth() / 2), (float) (sHeight() / 2));
        } else {
            this.sPendingCenter = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final ImageViewState getState() {
        return (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) ? null : new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    public final void setZoomEnabled(boolean z) {
        this.zoomEnabled = z;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.quickScaleEnabled = z;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final void setPanEnabled(boolean z) {
        this.panEnabled = z;
        if (!z && this.vTranslate) {
            this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (sWidth() / 2)));
            this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (sHeight() / 2)));
            if (isReady()) {
                refreshRequiredTiles(true);
                invalidate();
            }
        }
    }

    public final void setTileBackgroundColor(int i) {
        if (Color.alpha(i) == 0) {
            this.tileBgPaint = 0;
        } else {
            this.tileBgPaint = new Paint();
            this.tileBgPaint.setStyle(Style.FILL);
            this.tileBgPaint.setColor(i);
        }
        invalidate();
    }

    public final void setDoubleTapZoomScale(float f) {
        this.doubleTapZoomScale = f;
    }

    public final void setDoubleTapZoomDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i));
    }

    public final void setDoubleTapZoomStyle(int i) {
        if (VALID_ZOOM_STYLES.contains(Integer.valueOf(i))) {
            this.doubleTapZoomStyle = i;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid zoom style: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final void setDoubleTapZoomDuration(int i) {
        this.doubleTapZoomDuration = Math.max(0, i);
    }

    public void setParallelLoadingEnabled(boolean z) {
        this.parallelLoadingEnabled = z;
    }

    public final void setDebug(boolean z) {
        this.debug = z;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener) {
        this.onImageEventListener = onImageEventListener;
    }

    public AnimationBuilder animateCenter(PointF pointF) {
        if (isReady()) {
            return new AnimationBuilder(pointF);
        }
        return null;
    }

    public AnimationBuilder animateScale(float f) {
        if (isReady()) {
            return new AnimationBuilder(f);
        }
        return 0.0f;
    }

    public AnimationBuilder animateScaleAndCenter(float f, PointF pointF) {
        if (isReady()) {
            return new AnimationBuilder(f, pointF);
        }
        return 0.0f;
    }
}
