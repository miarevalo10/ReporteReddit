package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {
    final Callback f16458a;
    private AnimatedVectorDrawableCompatState f16459c;
    private Context f16460d;
    private ArgbEvaluator f16461e;
    private AnimatorListener f16462f;
    private ArrayList<Object> f16463g;

    class C00551 implements Callback {
        final /* synthetic */ AnimatedVectorDrawableCompat f740a;

        C00551(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            this.f740a = animatedVectorDrawableCompat;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.f740a.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.f740a.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f740a.unscheduleSelf(runnable);
        }
    }

    private static class AnimatedVectorDrawableCompatState extends ConstantState {
        int f741a;
        VectorDrawableCompat f742b;
        AnimatorSet f743c;
        ArrayList<Animator> f744d;
        ArrayMap<Animator, String> f745e;

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public int getChangingConfigurations() {
            return this.f741a;
        }
    }

    @RequiresApi(24)
    private static class AnimatedVectorDrawableDelegateState extends ConstantState {
        private final ConstantState f746a;

        public AnimatedVectorDrawableDelegateState(ConstantState constantState) {
            this.f746a = constantState;
        }

        public Drawable newDrawable() {
            Drawable animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.b = this.f746a.newDrawable();
            animatedVectorDrawableCompat.b.setCallback(animatedVectorDrawableCompat.f16458a);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.b = this.f746a.newDrawable(resources);
            animatedVectorDrawableCompat.b.setCallback(animatedVectorDrawableCompat.f16458a);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.b = this.f746a.newDrawable(resources, theme);
            animatedVectorDrawableCompat.b.setCallback(animatedVectorDrawableCompat.f16458a);
            return animatedVectorDrawableCompat;
        }

        public boolean canApplyTheme() {
            return this.f746a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f746a.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    AnimatedVectorDrawableCompat() {
        this(null, (byte) 0);
    }

    private AnimatedVectorDrawableCompat(Context context) {
        this(context, (byte) 0);
    }

    private AnimatedVectorDrawableCompat(Context context, byte b) {
        this.f16461e = null;
        this.f16462f = null;
        this.f16463g = null;
        this.f16458a = new C00551(this);
        this.f16460d = context;
        this.f16459c = new AnimatedVectorDrawableCompatState();
    }

    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
        }
        return this;
    }

    public static AnimatedVectorDrawableCompat m16577a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    public ConstantState getConstantState() {
        return (this.b == null || VERSION.SDK_INT < 24) ? null : new AnimatedVectorDrawableDelegateState(this.b.getConstantState());
    }

    public int getChangingConfigurations() {
        if (this.b != null) {
            return this.b.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f16459c.f741a;
    }

    public void draw(Canvas canvas) {
        if (this.b != null) {
            this.b.draw(canvas);
            return;
        }
        this.f16459c.f742b.draw(canvas);
        if (this.f16459c.f743c.isStarted() != null) {
            invalidateSelf();
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        } else {
            this.f16459c.f742b.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.b != null) {
            return this.b.setState(iArr);
        }
        return this.f16459c.f742b.setState(iArr);
    }

    protected boolean onLevelChange(int i) {
        if (this.b != null) {
            return this.b.setLevel(i);
        }
        return this.f16459c.f742b.setLevel(i);
    }

    public int getAlpha() {
        if (this.b != null) {
            return DrawableCompat.m840c(this.b);
        }
        return this.f16459c.f742b.getAlpha();
    }

    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
        } else {
            this.f16459c.f742b.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b != null) {
            this.b.setColorFilter(colorFilter);
        } else {
            this.f16459c.f742b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i) {
        if (this.b != null) {
            DrawableCompat.m831a(this.b, i);
        } else {
            this.f16459c.f742b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            DrawableCompat.m833a(this.b, colorStateList);
        } else {
            this.f16459c.f742b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.b != null) {
            DrawableCompat.m836a(this.b, mode);
        } else {
            this.f16459c.f742b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.b != null) {
            return this.b.setVisible(z, z2);
        }
        this.f16459c.f742b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public boolean isStateful() {
        if (this.b != null) {
            return this.b.isStateful();
        }
        return this.f16459c.f742b.isStateful();
    }

    public int getOpacity() {
        if (this.b != null) {
            return this.b.getOpacity();
        }
        return this.f16459c.f742b.getOpacity();
    }

    public int getIntrinsicWidth() {
        if (this.b != null) {
            return this.b.getIntrinsicWidth();
        }
        return this.f16459c.f742b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.b != null) {
            return this.b.getIntrinsicHeight();
        }
        return this.f16459c.f742b.getIntrinsicHeight();
    }

    public boolean isAutoMirrored() {
        if (this.b != null) {
            return DrawableCompat.m838b(this.b);
        }
        return this.f16459c.f742b.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            DrawableCompat.m837a(this.b, z);
        } else {
            this.f16459c.f742b.setAutoMirrored(z);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        if (this.b != null) {
            DrawableCompat.m835a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray a;
                if ("animated-vector".equals(name)) {
                    a = TypedArrayUtils.m780a(resources, theme, attributeSet, AndroidResources.f732e);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat a2 = VectorDrawableCompat.m16581a(resources, resourceId, theme);
                        a2.f16466d = false;
                        a2.setCallback(this.f16458a);
                        if (this.f16459c.f742b != null) {
                            this.f16459c.f742b.setCallback(null);
                        }
                        this.f16459c.f742b = a2;
                    }
                    a.recycle();
                } else if ("target".equals(name)) {
                    a = resources.obtainAttributes(attributeSet, AndroidResources.f733f);
                    String string = a.getString(0);
                    int resourceId2 = a.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f16460d != null) {
                            Animator a3 = AnimatorInflaterCompat.m365a(this.f16460d, resourceId2);
                            a3.setTarget(this.f16459c.f742b.f16465c.f784b.f775h.get(string));
                            if (VERSION.SDK_INT < 21) {
                                m16578a(a3);
                            }
                            if (this.f16459c.f744d == null) {
                                this.f16459c.f744d = new ArrayList();
                                this.f16459c.f745e = new ArrayMap();
                            }
                            this.f16459c.f744d.add(a3);
                            this.f16459c.f745e.put(a3, string);
                        } else {
                            a.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        resources = this.f16459c;
        if (resources.f743c == null) {
            resources.f743c = new AnimatorSet();
        }
        resources.f743c.playTogether(resources.f744d);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void applyTheme(Theme theme) {
        if (this.b != null) {
            DrawableCompat.m834a(this.b, theme);
        }
    }

    public boolean canApplyTheme() {
        return this.b != null ? DrawableCompat.m841d(this.b) : false;
    }

    private void m16578a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    m16578a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f16461e == null) {
                    this.f16461e = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f16461e);
            }
        }
    }

    public boolean isRunning() {
        if (this.b != null) {
            return ((AnimatedVectorDrawable) this.b).isRunning();
        }
        return this.f16459c.f743c.isRunning();
    }

    public void start() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).start();
        } else if (!this.f16459c.f743c.isStarted()) {
            this.f16459c.f743c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).stop();
        } else {
            this.f16459c.f743c.end();
        }
    }
}
