package com.instabug.library.annotation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.instabug.library.annotation.p016a.C0622c;
import com.instabug.library.annotation.p016a.C0622c.C0621a;
import com.instabug.library.annotation.p016a.C0625e.C0624a;
import com.instabug.library.annotation.p017b.C0632g;
import com.instabug.library.annotation.p017b.C1350a;
import com.instabug.library.annotation.p017b.C1352f;
import com.instabug.library.annotation.p017b.C1647b;
import com.instabug.library.annotation.p017b.C1648d;
import com.instabug.library.annotation.p017b.C1649e;
import com.instabug.library.annotation.p017b.C1650h;
import com.instabug.library.annotation.p018c.C0635b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class AnnotationView extends ImageView {
    private C0604a f9422A;
    private C0605b f9423B;
    private C0608e f9424C;
    private C0610g f9425D;
    private boolean f9426E;
    C0637d f9427a;
    C0636c f9428b;
    C0609f f9429c;
    C0632g f9430d;
    C0633b f9431e;
    int f9432f;
    private final GestureDetector f9433g;
    private Path f9434h;
    private List<PointF> f9435i;
    private Paint f9436j;
    private int f9437k;
    private LinkedHashMap<Path, Integer> f9438l;
    private float f9439m;
    private float f9440n;
    private boolean f9441o;
    private Drawable f9442p;
    private PointF[] f9443q;
    private Bitmap f9444r;
    private int f9445s;
    private boolean f9446t;
    private Paint f9447u;
    private C0629a f9448v;
    private C0629a f9449w;
    private C0629a f9450x;
    private C0629a f9451y;
    private PointF f9452z;

    private enum C0604a {
        NONE,
        DRAG,
        RESIZE_BY_TOP_LEFT_BUTTON,
        RESIZE_BY_TOP_RIGHT_BUTTON,
        RESIZE_BY_BOTTOM_RIGHT_BUTTON,
        RESIZE_BY_BOTTOM_LEFT_BUTTON,
        DRAW
    }

    public enum C0605b {
        NONE,
        DRAW_PATH,
        DRAW_RECT,
        DRAW_CIRCLE,
        DRAW_BLUR,
        DRAW_ZOOM
    }

    private class C0606c extends SimpleOnGestureListener {
        final /* synthetic */ AnnotationView f9418a;

        private C0606c(AnnotationView annotationView) {
            this.f9418a = annotationView;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (this.f9418a.f9428b != null) {
                this.f9418a.f9427a.m8100c(this.f9418a.f9428b);
                this.f9418a.f9428b.m8089b();
                if ((this.f9418a.f9428b.m8093d() instanceof C1650h) != null) {
                    motionEvent = this.f9418a;
                    motionEvent.f9432f--;
                    this.f9418a.m8031c();
                }
                this.f9418a.f9428b = null;
                this.f9418a.m8029a();
                this.f9418a.invalidate();
            }
            return true;
        }
    }

    enum C0607d {
        HIGH,
        LOW
    }

    public interface C0608e {
        void mo2569a();
    }

    public interface C0609f {
        void mo2571a(boolean z);
    }

    public interface C0610g {
        void mo2570a(Path path, Path path2);
    }

    public AnnotationView(Context context) {
        this(context, null);
    }

    public AnnotationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnnotationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9438l = new LinkedHashMap();
        this.f9443q = new PointF[5];
        this.f9452z = new PointF();
        this.f9422A = C0604a.NONE;
        this.f9423B = C0605b.NONE;
        this.f9427a = new C0637d();
        int i2 = 0;
        this.f9433g = new GestureDetector(context, new C0606c());
        this.f9447u = new Paint(1);
        this.f9447u.setColor(-65281);
        this.f9448v = new C0629a();
        this.f9449w = new C0629a();
        this.f9450x = new C0629a();
        this.f9451y = new C0629a();
        this.f9436j = new Paint();
        this.f9436j.setAntiAlias(true);
        this.f9436j.setDither(true);
        this.f9437k = -65536;
        this.f9436j.setColor(this.f9437k);
        this.f9436j.setStyle(Style.STROKE);
        this.f9436j.setStrokeJoin(Join.ROUND);
        this.f9436j.setStrokeCap(Cap.ROUND);
        this.f9436j.setStrokeWidth(1082130432 * getContext().getResources().getDisplayMetrics().density);
        while (i2 < this.f9443q.length) {
            this.f9443q[i2] = new PointF();
            i2++;
        }
    }

    public void setDrawingColor(int i) {
        this.f9437k = i;
        this.f9436j.setColor(this.f9437k);
    }

    private void m8024a(float f, float f2) {
        for (PointF pointF : this.f9443q) {
            pointF.x = f;
            pointF.y = f2;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f9442p != null) {
            this.f9442p.draw(canvas);
        }
        if (!this.f9446t) {
            this.f9445s = this.f9427a.f9550a.size();
        }
        for (int i = 0; i < this.f9445s; i++) {
            C0636c a = this.f9427a.m8097a(i);
            if (a != null) {
                a.m8084a(canvas);
            }
        }
        if (!(this.f9446t || this.f9428b == null)) {
            if (this.f9426E) {
                this.f9428b.m8090b(canvas);
            }
            this.f9428b.m8085a(canvas, this.f9448v, this.f9451y, this.f9449w, this.f9450x);
        }
        if (!this.f9438l.isEmpty()) {
            Iterator it = this.f9438l.entrySet().iterator();
            do {
                Entry entry = (Entry) it.next();
                this.f9436j.setColor(((Integer) entry.getValue()).intValue());
                canvas.drawPath((Path) entry.getKey(), this.f9436j);
            } while (it.hasNext());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f9433g.onTouchEvent(motionEvent)) {
            return true;
        }
        float x;
        int a = MotionEventCompat.m1120a(motionEvent);
        float x2 = motionEvent.getX();
        float y = motionEvent.getY();
        switch (a) {
            case 0:
                this.f9426E = true;
                getOriginalBitmap();
                if (this.f9424C != null) {
                    this.f9424C.mo2569a();
                }
                this.f9452z.set(x2, y);
                if (this.f9449w.m8055a(this.f9452z) && this.f9428b != null) {
                    this.f9422A = C0604a.RESIZE_BY_BOTTOM_RIGHT_BUTTON;
                } else if (this.f9450x.m8055a(this.f9452z) && this.f9428b != null) {
                    this.f9422A = C0604a.RESIZE_BY_BOTTOM_LEFT_BUTTON;
                } else if (this.f9448v.m8055a(this.f9452z) && this.f9428b != null) {
                    this.f9422A = C0604a.RESIZE_BY_TOP_LEFT_BUTTON;
                } else if (!this.f9451y.m8055a(this.f9452z) || this.f9428b == null) {
                    this.f9428b = getSelectedMarkUpDrawable();
                    if (this.f9428b == null) {
                        switch (this.f9423B) {
                            case DRAW_RECT:
                                this.f9428b = new C0636c(new C1352f(this.f9437k, this.f9436j.getStrokeWidth(), 0));
                                this.f9427a.m8098a(this.f9428b);
                                invalidate();
                                break;
                            case DRAW_CIRCLE:
                                this.f9428b = new C0636c(new C1648d(this.f9437k, this.f9436j.getStrokeWidth(), 0));
                                this.f9427a.m8098a(this.f9428b);
                                invalidate();
                                break;
                            case DRAW_BLUR:
                                this.f9428b = new C0636c(new C1647b(getOriginalBitmap(), getContext()));
                                this.f9427a.m8099b(this.f9428b);
                                invalidate();
                                break;
                            default:
                                break;
                        }
                        this.f9422A = C0604a.DRAW;
                    } else {
                        this.f9422A = C0604a.DRAG;
                    }
                } else {
                    this.f9422A = C0604a.RESIZE_BY_TOP_RIGHT_BUTTON;
                }
                m8029a();
                invalidate();
                break;
            case 1:
                this.f9426E = false;
                if ((this.f9422A == C0604a.DRAG || this.f9422A == C0604a.RESIZE_BY_TOP_LEFT_BUTTON || this.f9422A == C0604a.RESIZE_BY_TOP_RIGHT_BUTTON || this.f9422A == C0604a.RESIZE_BY_BOTTOM_RIGHT_BUTTON || this.f9422A == C0604a.RESIZE_BY_BOTTOM_LEFT_BUTTON) && this.f9428b != null) {
                    this.f9427a.m8100c(this.f9428b);
                    this.f9428b.m8082a();
                }
                this.f9452z.set(x2, y);
                if (this.f9423B != C0605b.DRAW_PATH) {
                    this.f9422A = C0604a.NONE;
                    invalidate();
                    break;
                }
                break;
            case 2:
                x = motionEvent.getX();
                float y2 = motionEvent.getY();
                C0633b c0633b;
                C1352f c1352f;
                C0633b c0633b2;
                C1350a c1350a;
                switch (this.f9422A) {
                    case DRAG:
                        if (this.f9428b != null) {
                            this.f9428b.m8083a((int) (x - this.f9452z.x), (int) (y2 - this.f9452z.y));
                            break;
                        }
                        break;
                    case RESIZE_BY_BOTTOM_RIGHT_BUTTON:
                        if (this.f9428b != null) {
                            c0633b = new C0633b();
                            if (x < this.f9428b.f9548d.left) {
                                c0633b.left = this.f9428b.f9548d.right + ((float) ((int) (x - this.f9452z.x)));
                                c0633b.right = this.f9428b.f9548d.left;
                            } else {
                                c0633b.left = this.f9428b.f9548d.left;
                                c0633b.right = this.f9428b.f9548d.right + ((float) ((int) (x - this.f9452z.x)));
                            }
                            if (y2 < this.f9428b.f9548d.top) {
                                c0633b.top = this.f9428b.f9548d.bottom + ((float) ((int) (y2 - this.f9452z.y)));
                                c0633b.bottom = this.f9428b.f9548d.top;
                            } else {
                                c0633b.top = this.f9428b.f9548d.top;
                                c0633b.bottom = this.f9428b.f9548d.bottom + ((float) ((int) (y2 - this.f9452z.y)));
                            }
                            this.f9428b.m8091b(c0633b);
                            if (this.f9428b.m8093d() instanceof C1352f) {
                                c1352f = (C1352f) this.f9428b.m8093d();
                                c0633b2 = this.f9428b.f9547c;
                                if (c1352f.m15370a()) {
                                    c1352f.m15374c(x, y2, c0633b2, true);
                                    c1352f.m15375c(c0633b2);
                                    break;
                                }
                            }
                        }
                        break;
                    case RESIZE_BY_BOTTOM_LEFT_BUTTON:
                        if (this.f9428b != null) {
                            c0633b = new C0633b();
                            if (x > this.f9428b.f9548d.right) {
                                c0633b.left = this.f9428b.f9548d.right;
                                c0633b.right = this.f9428b.f9548d.left + ((float) ((int) (x - this.f9452z.x)));
                            } else {
                                c0633b.left = this.f9428b.f9548d.left + ((float) ((int) (x - this.f9452z.x)));
                                c0633b.right = this.f9428b.f9548d.right;
                            }
                            if (y2 < this.f9428b.f9548d.top) {
                                c0633b.top = this.f9428b.f9548d.bottom + ((float) ((int) (y2 - this.f9452z.y)));
                                c0633b.bottom = this.f9428b.f9548d.top;
                            } else {
                                c0633b.top = this.f9428b.f9548d.top;
                                c0633b.bottom = this.f9428b.f9548d.bottom + ((float) ((int) (y2 - this.f9452z.y)));
                            }
                            this.f9428b.m8091b(c0633b);
                            if (this.f9428b.m8093d() instanceof C1352f) {
                                c1352f = (C1352f) this.f9428b.m8093d();
                                c0633b2 = this.f9428b.f9547c;
                                if (c1352f.m15370a()) {
                                    c1352f.m15376d(x, y2, c0633b2, true);
                                    c1352f.m15375c(c0633b2);
                                    break;
                                }
                            }
                        }
                        break;
                    case RESIZE_BY_TOP_LEFT_BUTTON:
                        if (this.f9428b != null) {
                            if (!(this.f9428b.m8093d() instanceof C1350a)) {
                                c0633b = new C0633b();
                                if (x > this.f9428b.f9548d.right) {
                                    c0633b.left = this.f9428b.f9548d.right;
                                    c0633b.right = this.f9428b.f9548d.left + ((float) ((int) (x - this.f9452z.x)));
                                } else {
                                    c0633b.left = this.f9428b.f9548d.left + ((float) ((int) (x - this.f9452z.x)));
                                    c0633b.right = this.f9428b.f9548d.right;
                                }
                                if (y2 > this.f9428b.f9548d.bottom) {
                                    c0633b.top = this.f9428b.f9548d.bottom;
                                    c0633b.bottom = this.f9428b.f9548d.top + ((float) ((int) (y2 - this.f9452z.y)));
                                } else {
                                    c0633b.top = this.f9428b.f9548d.top + ((float) ((int) (y2 - this.f9452z.y)));
                                    c0633b.bottom = this.f9428b.f9548d.bottom;
                                }
                                this.f9428b.m8091b(c0633b);
                                if (this.f9428b.m8093d() instanceof C1352f) {
                                    c1352f = (C1352f) this.f9428b.m8093d();
                                    c0633b2 = this.f9428b.f9547c;
                                    if (c1352f.m15370a()) {
                                        c1352f.m15362a(x, y2, c0633b2, true);
                                        c1352f.m15375c(c0633b2);
                                        break;
                                    }
                                }
                            }
                            c1350a = (C1350a) this.f9428b.m8093d();
                            c0633b2 = this.f9428b.f9547c;
                            c1350a.f15451a.set(x, y2);
                            c1350a.m15353a(c0633b2);
                            break;
                        }
                        break;
                    case RESIZE_BY_TOP_RIGHT_BUTTON:
                        if (this.f9428b != null) {
                            if (!(this.f9428b.m8093d() instanceof C1350a)) {
                                c0633b = new C0633b();
                                if (x < this.f9428b.f9548d.left) {
                                    c0633b.left = this.f9428b.f9548d.right + ((float) ((int) (x - this.f9452z.x)));
                                    c0633b.right = this.f9428b.f9548d.left;
                                } else {
                                    c0633b.left = this.f9428b.f9548d.left;
                                    c0633b.right = this.f9428b.f9548d.right + ((float) ((int) (x - this.f9452z.x)));
                                }
                                if (y2 > this.f9428b.f9548d.bottom) {
                                    c0633b.top = this.f9428b.f9548d.bottom;
                                    c0633b.bottom = this.f9428b.f9548d.top + ((float) ((int) (y2 - this.f9452z.y)));
                                } else {
                                    c0633b.top = this.f9428b.f9548d.top + ((float) ((int) (y2 - this.f9452z.y)));
                                    c0633b.bottom = this.f9428b.f9548d.bottom;
                                }
                                this.f9428b.m8091b(c0633b);
                                if (this.f9428b.m8093d() instanceof C1352f) {
                                    c1352f = (C1352f) this.f9428b.m8093d();
                                    c0633b2 = this.f9428b.f9547c;
                                    if (c1352f.m15370a()) {
                                        c1352f.m15373b(x, y2, c0633b2, true);
                                        c1352f.m15375c(c0633b2);
                                        break;
                                    }
                                }
                            }
                            c1350a = (C1350a) this.f9428b.m8093d();
                            c0633b2 = this.f9428b.f9547c;
                            c1350a.f15452b.set(x, y2);
                            c1350a.m15353a(c0633b2);
                            break;
                        }
                        break;
                    case DRAW:
                        if (this.f9428b != null) {
                            c0633b = new C0633b();
                            if (x < this.f9452z.x) {
                                c0633b.left = (float) ((int) x);
                                c0633b.right = (float) ((int) this.f9452z.x);
                            } else {
                                c0633b.left = (float) ((int) this.f9452z.x);
                                c0633b.right = (float) ((int) x);
                            }
                            if (y2 < this.f9452z.y) {
                                c0633b.top = (float) ((int) y2);
                                c0633b.bottom = (float) ((int) this.f9452z.y);
                            } else {
                                c0633b.top = (float) ((int) this.f9452z.y);
                                c0633b.bottom = (float) ((int) y2);
                            }
                            this.f9428b.m8087a(c0633b);
                            break;
                        }
                        break;
                    default:
                        break;
                }
                m8029a();
                invalidate();
                break;
            default:
                break;
        }
        if (!(this.f9422A == C0604a.RESIZE_BY_TOP_LEFT_BUTTON || this.f9422A == C0604a.RESIZE_BY_TOP_RIGHT_BUTTON || this.f9422A == C0604a.RESIZE_BY_BOTTOM_RIGHT_BUTTON || this.f9422A == C0604a.RESIZE_BY_BOTTOM_LEFT_BUTTON || this.f9422A == C0604a.DRAG || this.f9422A != C0604a.DRAW || this.f9423B != C0605b.DRAW_PATH)) {
            float height;
            switch (motionEvent.getAction()) {
                case null:
                    this.f9441o = false;
                    this.f9434h = new Path();
                    this.f9435i = new ArrayList();
                    this.f9438l.put(this.f9434h, Integer.valueOf(this.f9437k));
                    this.f9434h.reset();
                    this.f9434h.moveTo(x2, y);
                    this.f9435i.add(new PointF(x2, y));
                    this.f9439m = x2;
                    this.f9440n = y;
                    m8024a(x2, y);
                    break;
                case 1:
                    this.f9434h.lineTo(this.f9439m, this.f9440n);
                    if (new PathMeasure(this.f9434h, false).getLength() < 20.0f) {
                        this.f9438l.remove(this.f9434h);
                    } else {
                        C0632g c1352f2;
                        Path b;
                        this.f9428b = new C0636c(new C1649e(this.f9434h, this.f9436j.getStrokeWidth(), this.f9436j, this.f9435i));
                        motionEvent = new C0633b();
                        this.f9434h.computeBounds(motionEvent, true);
                        this.f9428b.m8087a(new C0633b(motionEvent));
                        this.f9427a.m8098a(this.f9428b);
                        this.f9438l.remove(this.f9434h);
                        invalidate();
                        C0622c c0622c = new C0622c();
                        C0621a a2 = C0622c.m8049a(this.f9434h);
                        C0632g c0632g = null;
                        if (a2.f9495a != C0624a.ARROW) {
                            if (a2.f9495a != C0624a.LINE) {
                                if (a2.f9495a == C0624a.RECT) {
                                    y = Math.max(motionEvent.width(), motionEvent.height()) / 2.0f;
                                    motionEvent.set(motionEvent.centerX() - y, motionEvent.centerY() - y, motionEvent.centerX() + y, motionEvent.centerY() + y);
                                    x = a2.f9497c * motionEvent.width();
                                    int i = a2.f9496b;
                                    if (i <= 20) {
                                        i = 0;
                                    } else if (i >= 70 && i <= 110) {
                                        i = 90;
                                    } else if (i >= 160) {
                                        i = 180;
                                    }
                                    if (i != 0) {
                                        if (i != 180) {
                                            if (i == 90) {
                                                motionEvent.top += x;
                                                motionEvent.bottom -= x;
                                            } else if (i <= 90 || i >= 180) {
                                                motionEvent.left += x;
                                                motionEvent.right -= x;
                                            } else {
                                                i -= 90;
                                                motionEvent.top += x;
                                                motionEvent.bottom -= x;
                                            }
                                            if ((a2.f9496b >= 20 && a2.f9496b <= 70) || (a2.f9496b >= 110 && a2.f9496b <= 160)) {
                                                x = motionEvent.width() * 0.1f;
                                                height = motionEvent.height() * 0.1f;
                                                motionEvent.left += x;
                                                motionEvent.right -= x;
                                                motionEvent.top += height;
                                                motionEvent.bottom -= height;
                                            }
                                            c1352f2 = new C1352f(this.f9437k, this.f9436j.getStrokeWidth(), i);
                                        }
                                    }
                                    motionEvent.left += x;
                                    motionEvent.right -= x;
                                    x = motionEvent.width() * 0.1f;
                                    height = motionEvent.height() * 0.1f;
                                    motionEvent.left += x;
                                    motionEvent.right -= x;
                                    motionEvent.top += height;
                                    motionEvent.bottom -= height;
                                    c1352f2 = new C1352f(this.f9437k, this.f9436j.getStrokeWidth(), i);
                                    break;
                                }
                                if (a2.f9495a == C0624a.OVAL) {
                                    y = Math.max(motionEvent.width(), motionEvent.height()) / 2.0f;
                                    motionEvent.set(motionEvent.centerX() - y, motionEvent.centerY() - y, motionEvent.centerX() + y, motionEvent.centerY() + y);
                                    x = a2.f9497c * motionEvent.width();
                                    int i2 = a2.f9496b;
                                    if (i2 <= 20) {
                                        i2 = 0;
                                    } else if (i2 >= 70 && i2 <= 110) {
                                        i2 = 90;
                                    }
                                    if (i2 >= 90) {
                                        i2 -= 90;
                                        motionEvent.top += x;
                                        motionEvent.bottom -= x;
                                    } else {
                                        motionEvent.left += x;
                                        motionEvent.right -= x;
                                    }
                                    c0632g = new C1648d(this.f9437k, this.f9436j.getStrokeWidth(), i2);
                                }
                                c1352f2 = c0632g;
                                this.f9430d = c1352f2;
                                this.f9431e = motionEvent;
                                if (c1352f2 != null) {
                                    motionEvent = this.f9434h;
                                    b = c1352f2.mo2580b(this.f9431e);
                                    if (this.f9425D != null) {
                                        this.f9425D.mo2570a(motionEvent, b);
                                    }
                                }
                            }
                        }
                        y = Math.max(motionEvent.width(), motionEvent.height()) / 2.0f;
                        x = motionEvent.centerX() + y;
                        PointF pointF = new PointF(motionEvent.centerX() - y, motionEvent.centerY());
                        PointF pointF2 = new PointF(x, motionEvent.centerY());
                        C0635b.m8075a(motionEvent.centerX(), motionEvent.centerY(), (float) a2.f9496b, pointF);
                        C0635b.m8075a(motionEvent.centerX(), motionEvent.centerY(), (float) a2.f9496b, pointF2);
                        c1352f2 = new C1350a(pointF, pointF2, this.f9437k, this.f9436j.getStrokeWidth());
                        if (a2.f9495a == C0624a.ARROW) {
                            ((C1350a) c1352f2).f15453c = "arrow";
                        }
                        motionEvent.set(Math.min(pointF.x, pointF2.x), Math.min(pointF.y, pointF2.y), Math.max(pointF.x, pointF2.x), Math.max(pointF.y, pointF2.y));
                        this.f9430d = c1352f2;
                        this.f9431e = motionEvent;
                        if (c1352f2 != null) {
                            motionEvent = this.f9434h;
                            b = c1352f2.mo2580b(this.f9431e);
                            if (this.f9425D != null) {
                                this.f9425D.mo2570a(motionEvent, b);
                            }
                        }
                    }
                    if (this.f9441o == null) {
                        performClick();
                    }
                    invalidate();
                    break;
                case 2:
                    this.f9441o = true;
                    motionEvent = Math.abs(x2 - this.f9439m);
                    height = Math.abs(y - this.f9440n);
                    if (motionEvent >= 1090519040 || height >= 8.0f) {
                        this.f9434h.quadTo(this.f9439m, this.f9440n, (this.f9439m + x2) / 2.0f, (this.f9440n + y) / 2.0f);
                        this.f9439m = x2;
                        this.f9440n = y;
                        this.f9435i.add(new PointF(x2, y));
                    }
                    invalidate();
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    final void m8029a() {
        if (this.f9422A != C0604a.DRAW) {
            for (int i = 1; i < this.f9427a.m8096a(); i++) {
                C0636c a = this.f9427a.m8097a(i);
                C0637d c0637d = this.f9427a;
                if (c0637d.f9550a.indexOf(this.f9428b) <= i && (a.m8093d() instanceof C1650h) && a.m8094e()) {
                    ((C1650h) a.m8093d()).m19483a(m8022a(i));
                }
            }
        }
    }

    private C0636c getSelectedMarkUpDrawable() {
        for (int a = this.f9427a.m8096a() - 1; a >= 0; a--) {
            C0636c a2 = this.f9427a.m8097a(a);
            if (a2.m8088a(this.f9452z)) {
                return a2;
            }
        }
        return null;
    }

    Bitmap getOriginalBitmap() {
        if (this.f9444r == null) {
            this.f9444r = m8030b();
        }
        return this.f9444r;
    }

    public void setScreenshot(Drawable drawable) {
        this.f9442p = drawable;
    }

    public final Bitmap m8030b() {
        if (getWidth() > 0) {
            if (getHeight() > 0) {
                return m8022a(this.f9427a.m8096a());
            }
        }
        return null;
    }

    private Bitmap m8022a(int i) {
        this.f9445s = i;
        i = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(i);
        this.f9446t = true;
        invalidate();
        draw(canvas);
        this.f9446t = false;
        invalidate();
        return i;
    }

    public void setDrawingMode(C0605b c0605b) {
        this.f9423B = c0605b;
    }

    public void setOnActionDownListener(C0608e c0608e) {
        this.f9424C = c0608e;
    }

    public void m8032setOnNewMagnifierAddingAbilityChangedListener(C0609f c0609f) {
        this.f9429c = c0609f;
    }

    final void m8031c() {
        if (this.f9429c != null) {
            if (this.f9432f == 5) {
                this.f9429c.mo2571a(false);
            }
            if (this.f9432f == 4) {
                this.f9429c.mo2571a(true);
            }
        }
    }

    public void setOnPathRecognizedListener(C0610g c0610g) {
        this.f9425D = c0610g;
    }
}
