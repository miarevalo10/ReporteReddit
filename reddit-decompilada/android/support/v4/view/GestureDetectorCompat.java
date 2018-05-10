package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class GestureDetectorCompat {
    public final GestureDetectorCompatImpl f1437a;

    interface GestureDetectorCompatImpl {
        boolean mo367a(MotionEvent motionEvent);
    }

    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        private static final int f11448l = ViewConfiguration.getLongPressTimeout();
        private static final int f11449m = ViewConfiguration.getTapTimeout();
        private static final int f11450n = ViewConfiguration.getDoubleTapTimeout();
        final Handler f11451a = new GestureHandler(this);
        final OnGestureListener f11452b;
        OnDoubleTapListener f11453c;
        boolean f11454d;
        boolean f11455e;
        boolean f11456f;
        MotionEvent f11457g;
        private int f11458h;
        private int f11459i;
        private int f11460j;
        private int f11461k;
        private boolean f11462o;
        private boolean f11463p;
        private MotionEvent f11464q;
        private boolean f11465r;
        private float f11466s;
        private float f11467t;
        private float f11468u;
        private float f11469v;
        private boolean f11470w;
        private VelocityTracker f11471x;

        private class GestureHandler extends Handler {
            final /* synthetic */ GestureDetectorCompatImplBase f1436a;

            GestureHandler(GestureDetectorCompatImplBase gestureDetectorCompatImplBase) {
                this.f1436a = gestureDetectorCompatImplBase;
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        this.f1436a.f11452b.onShowPress(this.f1436a.f11457g);
                        return;
                    case 2:
                        message = this.f1436a;
                        message.f11451a.removeMessages(3);
                        message.f11455e = false;
                        message.f11456f = true;
                        message.f11452b.onLongPress(message.f11457g);
                        return;
                    case 3:
                        if (this.f1436a.f11453c == null) {
                            return;
                        }
                        if (this.f1436a.f11454d == null) {
                            this.f1436a.f11453c.onSingleTapConfirmed(this.f1436a.f11457g);
                            return;
                        } else {
                            this.f1436a.f11455e = true;
                            return;
                        }
                    default:
                        StringBuilder stringBuilder = new StringBuilder("Unknown message ");
                        stringBuilder.append(message);
                        throw new RuntimeException(stringBuilder.toString());
                }
            }
        }

        public GestureDetectorCompatImplBase(Context context, OnGestureListener onGestureListener) {
            this.f11452b = onGestureListener;
            if (onGestureListener instanceof OnDoubleTapListener) {
                this.f11453c = (OnDoubleTapListener) onGestureListener;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f11452b == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            } else {
                this.f11470w = true;
                context = ViewConfiguration.get(context);
                onGestureListener = context.getScaledTouchSlop();
                int scaledDoubleTapSlop = context.getScaledDoubleTapSlop();
                this.f11460j = context.getScaledMinimumFlingVelocity();
                this.f11461k = context.getScaledMaximumFlingVelocity();
                this.f11458h = onGestureListener * onGestureListener;
                this.f11459i = scaledDoubleTapSlop * scaledDoubleTapSlop;
            }
        }

        public final boolean mo367a(MotionEvent motionEvent) {
            int i;
            int action = motionEvent.getAction();
            if (this.f11471x == null) {
                this.f11471x = VelocityTracker.obtain();
            }
            this.f11471x.addMovement(motionEvent);
            action &= 255;
            boolean z = action == 6;
            int actionIndex = z ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float f = 0.0f;
            float f2 = f;
            for (i = 0; i < pointerCount; i++) {
                if (actionIndex != i) {
                    f += motionEvent.getX(i);
                    f2 += motionEvent.getY(i);
                }
            }
            float f3 = (float) (z ? pointerCount - 1 : pointerCount);
            f /= f3;
            f2 /= f3;
            MotionEvent motionEvent2;
            int x;
            switch (action) {
                case 0:
                    if (this.f11453c != null) {
                        boolean hasMessages = this.f11451a.hasMessages(3);
                        if (hasMessages) {
                            this.f11451a.removeMessages(3);
                        }
                        if (!(this.f11457g == null || this.f11464q == null || !hasMessages)) {
                            motionEvent2 = this.f11457g;
                            MotionEvent motionEvent3 = this.f11464q;
                            if (this.f11463p && motionEvent.getEventTime() - motionEvent3.getEventTime() <= ((long) f11450n)) {
                                x = ((int) motionEvent2.getX()) - ((int) motionEvent.getX());
                                action = ((int) motionEvent2.getY()) - ((int) motionEvent.getY());
                                if ((x * x) + (action * action) < this.f11459i) {
                                    hasMessages = true;
                                    if (hasMessages) {
                                        this.f11465r = true;
                                        action = (this.f11453c.onDoubleTap(this.f11457g) | 0) | this.f11453c.onDoubleTapEvent(motionEvent);
                                        this.f11466s = f;
                                        this.f11468u = f;
                                        this.f11467t = f2;
                                        this.f11469v = f2;
                                        if (this.f11457g != null) {
                                            this.f11457g.recycle();
                                        }
                                        this.f11457g = MotionEvent.obtain(motionEvent);
                                        this.f11462o = true;
                                        this.f11463p = true;
                                        this.f11454d = true;
                                        this.f11456f = false;
                                        this.f11455e = false;
                                        if (this.f11470w) {
                                            this.f11451a.removeMessages(2);
                                            this.f11451a.sendEmptyMessageAtTime(2, (this.f11457g.getDownTime() + ((long) f11449m)) + ((long) f11448l));
                                        }
                                        this.f11451a.sendEmptyMessageAtTime(1, this.f11457g.getDownTime() + ((long) f11449m));
                                        return action | this.f11452b.onDown(motionEvent);
                                    }
                                }
                            }
                            hasMessages = false;
                            if (hasMessages) {
                                this.f11465r = true;
                                action = (this.f11453c.onDoubleTap(this.f11457g) | 0) | this.f11453c.onDoubleTapEvent(motionEvent);
                                this.f11466s = f;
                                this.f11468u = f;
                                this.f11467t = f2;
                                this.f11469v = f2;
                                if (this.f11457g != null) {
                                    this.f11457g.recycle();
                                }
                                this.f11457g = MotionEvent.obtain(motionEvent);
                                this.f11462o = true;
                                this.f11463p = true;
                                this.f11454d = true;
                                this.f11456f = false;
                                this.f11455e = false;
                                if (this.f11470w) {
                                    this.f11451a.removeMessages(2);
                                    this.f11451a.sendEmptyMessageAtTime(2, (this.f11457g.getDownTime() + ((long) f11449m)) + ((long) f11448l));
                                }
                                this.f11451a.sendEmptyMessageAtTime(1, this.f11457g.getDownTime() + ((long) f11449m));
                                return action | this.f11452b.onDown(motionEvent);
                            }
                        }
                        this.f11451a.sendEmptyMessageDelayed(3, (long) f11450n);
                    }
                    action = 0;
                    this.f11466s = f;
                    this.f11468u = f;
                    this.f11467t = f2;
                    this.f11469v = f2;
                    if (this.f11457g != null) {
                        this.f11457g.recycle();
                    }
                    this.f11457g = MotionEvent.obtain(motionEvent);
                    this.f11462o = true;
                    this.f11463p = true;
                    this.f11454d = true;
                    this.f11456f = false;
                    this.f11455e = false;
                    if (this.f11470w) {
                        this.f11451a.removeMessages(2);
                        this.f11451a.sendEmptyMessageAtTime(2, (this.f11457g.getDownTime() + ((long) f11449m)) + ((long) f11448l));
                    }
                    this.f11451a.sendEmptyMessageAtTime(1, this.f11457g.getDownTime() + ((long) f11449m));
                    return action | this.f11452b.onDown(motionEvent);
                case 1:
                    this.f11454d = false;
                    motionEvent2 = MotionEvent.obtain(motionEvent);
                    if (this.f11465r) {
                        motionEvent = this.f11453c.onDoubleTapEvent(motionEvent) | null;
                    } else {
                        if (this.f11456f) {
                            this.f11451a.removeMessages(3);
                            this.f11456f = false;
                        } else if (this.f11462o) {
                            boolean onSingleTapUp = this.f11452b.onSingleTapUp(motionEvent);
                            if (this.f11455e && this.f11453c != null) {
                                this.f11453c.onSingleTapConfirmed(motionEvent);
                            }
                            motionEvent = onSingleTapUp;
                        } else {
                            VelocityTracker velocityTracker = this.f11471x;
                            int pointerId = motionEvent.getPointerId(0);
                            velocityTracker.computeCurrentVelocity(1000, (float) this.f11461k);
                            float yVelocity = velocityTracker.getYVelocity(pointerId);
                            float xVelocity = velocityTracker.getXVelocity(pointerId);
                            if (Math.abs(yVelocity) <= ((float) this.f11460j)) {
                                if (Math.abs(xVelocity) > ((float) this.f11460j)) {
                                }
                            }
                            motionEvent = this.f11452b.onFling(this.f11457g, motionEvent, xVelocity, yVelocity);
                        }
                        motionEvent = null;
                    }
                    if (this.f11464q != null) {
                        this.f11464q.recycle();
                    }
                    this.f11464q = motionEvent2;
                    if (this.f11471x != null) {
                        this.f11471x.recycle();
                        this.f11471x = null;
                    }
                    this.f11465r = false;
                    this.f11455e = false;
                    this.f11451a.removeMessages(1);
                    this.f11451a.removeMessages(2);
                    break;
                case 2:
                    if (this.f11456f) {
                        return false;
                    }
                    float f4 = this.f11466s - f;
                    f3 = this.f11467t - f2;
                    if (this.f11465r) {
                        return false | this.f11453c.onDoubleTapEvent(motionEvent);
                    }
                    if (this.f11462o) {
                        actionIndex = (int) (f - this.f11468u);
                        pointerCount = (int) (f2 - this.f11469v);
                        actionIndex = (actionIndex * actionIndex) + (pointerCount * pointerCount);
                        if (actionIndex > this.f11458h) {
                            motionEvent = this.f11452b.onScroll(this.f11457g, motionEvent, f4, f3);
                            this.f11466s = f;
                            this.f11467t = f2;
                            this.f11462o = false;
                            this.f11451a.removeMessages(3);
                            this.f11451a.removeMessages(1);
                            this.f11451a.removeMessages(2);
                        } else {
                            motionEvent = null;
                        }
                        if (actionIndex > this.f11458h) {
                            this.f11463p = false;
                            break;
                        }
                    } else if (Math.abs(f4) < 1.0f && Math.abs(f3) < 1.0f) {
                        return false;
                    } else {
                        boolean onScroll = this.f11452b.onScroll(this.f11457g, motionEvent, f4, f3);
                        this.f11466s = f;
                        this.f11467t = f2;
                        return onScroll;
                    }
                    break;
                case 3:
                    this.f11451a.removeMessages(1);
                    this.f11451a.removeMessages(2);
                    this.f11451a.removeMessages(3);
                    this.f11471x.recycle();
                    this.f11471x = null;
                    this.f11465r = false;
                    this.f11454d = false;
                    this.f11462o = false;
                    this.f11463p = false;
                    this.f11455e = false;
                    if (this.f11456f == null) {
                        return false;
                    }
                    this.f11456f = false;
                    return false;
                case 5:
                    this.f11466s = f;
                    this.f11468u = f;
                    this.f11467t = f2;
                    this.f11469v = f2;
                    this.f11451a.removeMessages(1);
                    this.f11451a.removeMessages(2);
                    this.f11451a.removeMessages(3);
                    this.f11465r = false;
                    this.f11462o = false;
                    this.f11463p = false;
                    this.f11455e = false;
                    if (this.f11456f == null) {
                        return false;
                    }
                    this.f11456f = false;
                    return false;
                case 6:
                    this.f11466s = f;
                    this.f11468u = f;
                    this.f11467t = f2;
                    this.f11469v = f2;
                    this.f11471x.computeCurrentVelocity(1000, (float) this.f11461k);
                    action = motionEvent.getActionIndex();
                    x = motionEvent.getPointerId(action);
                    float xVelocity2 = this.f11471x.getXVelocity(x);
                    f3 = this.f11471x.getYVelocity(x);
                    for (actionIndex = 0; actionIndex < pointerCount; actionIndex++) {
                        if (actionIndex != action) {
                            i = motionEvent.getPointerId(actionIndex);
                            if ((this.f11471x.getXVelocity(i) * xVelocity2) + (this.f11471x.getYVelocity(i) * f3) < 0.0f) {
                                this.f11471x.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                default:
                    return false;
            }
            return motionEvent;
        }
    }

    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector f11472a;

        public GestureDetectorCompatImplJellybeanMr2(Context context, OnGestureListener onGestureListener) {
            this.f11472a = new GestureDetector(context, onGestureListener, null);
        }

        public final boolean mo367a(MotionEvent motionEvent) {
            return this.f11472a.onTouchEvent(motionEvent);
        }
    }

    public GestureDetectorCompat(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, (byte) 0);
    }

    private GestureDetectorCompat(Context context, OnGestureListener onGestureListener, byte b) {
        if (VERSION.SDK_INT > (byte) 17) {
            this.f1437a = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener);
        } else {
            this.f1437a = new GestureDetectorCompatImplBase(context, onGestureListener);
        }
    }
}
