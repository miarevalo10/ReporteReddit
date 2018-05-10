package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.MediaController.MediaPlayerControl;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import pl.droidsonroids.gif.transforms.Transform;

public class GifDrawable extends Drawable implements Animatable, MediaPlayerControl {
    final ScheduledThreadPoolExecutor f41148a;
    volatile boolean f41149b;
    long f41150c;
    protected final Paint f41151d;
    final Bitmap f41152e;
    final GifInfoHandle f41153f;
    final ConcurrentLinkedQueue<Object> f41154g;
    final boolean f41155h;
    final InvalidationHandler f41156i;
    ScheduledFuture<?> f41157j;
    private final Rect f41158k;
    private ColorStateList f41159l;
    private PorterDuffColorFilter f41160m;
    private Mode f41161n;
    private final RenderTask f41162o;
    private final Rect f41163p;
    private int f41164q;
    private int f41165r;
    private Transform f41166s;

    public boolean canPause() {
        return true;
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        return 100;
    }

    public GifDrawable(Resources resources, int i) throws NotFoundException, IOException {
        this(resources.openRawResourceFd(i));
        resources = GifViewUtils.m43273a(resources, i);
        this.f41165r = (int) (((float) this.f41153f.m43267m()) * resources);
        this.f41164q = (int) (((float) this.f41153f.m43266l()) * resources);
    }

    private GifDrawable(AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor));
    }

    public GifDrawable(ContentResolver contentResolver, Uri uri) throws IOException {
        this(GifInfoHandle.m43250a(contentResolver, uri));
    }

    private GifDrawable(GifInfoHandle gifInfoHandle) {
        this.f41149b = true;
        this.f41150c = Long.MIN_VALUE;
        this.f41158k = new Rect();
        this.f41151d = new Paint(6);
        this.f41154g = new ConcurrentLinkedQueue();
        this.f41162o = new RenderTask(this);
        this.f41155h = true;
        this.f41148a = GifRenderingExecutor.m43271a();
        this.f41153f = gifInfoHandle;
        this.f41152e = Bitmap.createBitmap(this.f41153f.m43266l(), this.f41153f.m43267m(), Config.ARGB_8888);
        this.f41152e.setHasAlpha(gifInfoHandle.m43269o() ^ 1);
        this.f41163p = new Rect(0, 0, this.f41153f.m43266l(), this.f41153f.m43267m());
        this.f41156i = new InvalidationHandler(this);
        this.f41162o.mo7874a();
        this.f41164q = this.f41153f.m43266l();
        this.f41165r = this.f41153f.m43267m();
    }

    public int getIntrinsicHeight() {
        return this.f41165r;
    }

    public int getIntrinsicWidth() {
        return this.f41164q;
    }

    public void setAlpha(int i) {
        this.f41151d.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f41151d.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        if (this.f41153f.m43269o()) {
            if (this.f41151d.getAlpha() >= 255) {
                return -1;
            }
        }
        return -2;
    }

    public void start() {
        synchronized (this) {
            if (this.f41149b) {
                return;
            }
            this.f41149b = true;
            m43246a(this.f41153f.m43253a());
        }
    }

    final void m43246a(long j) {
        if (this.f41155h) {
            this.f41150c = 0;
            this.f41156i.sendEmptyMessageAtTime(-1, 0);
            return;
        }
        m43245a();
        this.f41157j = this.f41148a.schedule(this.f41162o, Math.max(j, 0), TimeUnit.MILLISECONDS);
    }

    public void stop() {
        synchronized (this) {
            if (this.f41149b) {
                this.f41149b = false;
                m43245a();
                this.f41153f.m43257c();
                return;
            }
        }
    }

    private void m43245a() {
        if (this.f41157j != null) {
            this.f41157j.cancel(false);
        }
        this.f41156i.removeMessages(-1);
    }

    public boolean isRunning() {
        return this.f41149b;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", new Object[]{Integer.valueOf(this.f41153f.m43266l()), Integer.valueOf(this.f41153f.m43267m()), Integer.valueOf(this.f41153f.m43268n()), Integer.valueOf(this.f41153f.m43259e())});
    }

    public void pause() {
        stop();
    }

    public int getDuration() {
        return this.f41153f.m43260f();
    }

    public int getCurrentPosition() {
        return this.f41153f.m43261g();
    }

    public void seekTo(final int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        this.f41148a.execute(new SafeRunnable(this, this) {
            final /* synthetic */ GifDrawable f41568b;

            public final void mo7874a() {
                this.f41568b.f41153f.m43255a(i, this.f41568b.f41152e);
                this.c.f41156i.sendEmptyMessageAtTime(-1, 0);
            }
        });
    }

    public boolean isPlaying() {
        return this.f41149b;
    }

    protected void onBoundsChange(Rect rect) {
        this.f41158k.set(rect);
    }

    public void draw(Canvas canvas) {
        Object obj;
        if (this.f41160m == null || this.f41151d.getColorFilter() != null) {
            obj = null;
        } else {
            this.f41151d.setColorFilter(this.f41160m);
            obj = 1;
        }
        if (this.f41166s == null) {
            canvas.drawBitmap(this.f41152e, this.f41163p, this.f41158k, this.f41151d);
        }
        if (obj != null) {
            this.f41151d.setColorFilter(null);
        }
        if (this.f41155h != null && this.f41149b != null && this.f41150c != Long.MIN_VALUE) {
            long max = Math.max(0, this.f41150c - SystemClock.uptimeMillis());
            this.f41150c = Long.MIN_VALUE;
            this.f41148a.remove(this.f41162o);
            this.f41157j = this.f41148a.schedule(this.f41162o, max, TimeUnit.MILLISECONDS);
        }
    }

    public int getAlpha() {
        return this.f41151d.getAlpha();
    }

    public void setFilterBitmap(boolean z) {
        this.f41151d.setFilterBitmap(z);
        invalidateSelf();
    }

    @Deprecated
    public void setDither(boolean z) {
        this.f41151d.setDither(z);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.f41151d.getColorFilter();
    }

    private PorterDuffColorFilter m43244a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList != null) {
            if (mode != null) {
                return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            }
        }
        return null;
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f41159l = colorStateList;
        this.f41160m = m43244a(colorStateList, this.f41161n);
        invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        this.f41161n = mode;
        this.f41160m = m43244a(this.f41159l, mode);
        invalidateSelf();
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.f41159l == null || this.f41161n == null) {
            return null;
        }
        this.f41160m = m43244a(this.f41159l, this.f41161n);
        return 1;
    }

    public boolean isStateful() {
        if (!super.isStateful()) {
            if (this.f41159l == null || !this.f41159l.isStateful()) {
                return false;
            }
        }
        return true;
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.f41155h) {
            if (z) {
                if (z2) {
                    this.f41148a.execute(new SafeRunnable(this, this) {
                        final /* synthetic */ GifDrawable f41566a;

                        public final void mo7874a() {
                            if (this.f41566a.f41153f.m43256b()) {
                                this.f41566a.start();
                            }
                        }
                    });
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    public boolean canSeekBackward() {
        return this.f41153f.m43268n() > 1;
    }

    public boolean canSeekForward() {
        return this.f41153f.m43268n() > 1;
    }
}
