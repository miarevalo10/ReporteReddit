package com.instabug.library.ui.custom;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.RequiresApi;
import android.util.Property;
import android.util.TypedValue;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

@RequiresApi(api = 14)
public class MaterialMenuDrawable extends Drawable implements Animatable, MaterialMenu {
    private static final float ARROW_BOT_LINE_ANGLE = 225.0f;
    private static final float ARROW_MID_LINE_ANGLE = 180.0f;
    private static final float ARROW_TOP_LINE_ANGLE = 135.0f;
    private static final int BASE_CIRCLE_RADIUS = 18;
    private static final int BASE_DRAWABLE_HEIGHT = 40;
    private static final int BASE_DRAWABLE_WIDTH = 40;
    private static final int BASE_ICON_WIDTH = 20;
    private static final float CHECK_BOTTOM_ANGLE = -90.0f;
    private static final float CHECK_MIDDLE_ANGLE = 135.0f;
    private static final int DEFAULT_CIRCLE_ALPHA = 200;
    public static final int DEFAULT_COLOR = -1;
    public static final int DEFAULT_SCALE = 1;
    public static final int DEFAULT_TRANSFORM_DURATION = 800;
    public static final boolean DEFAULT_VISIBLE = true;
    private static final float TRANSFORMATION_END = 2.0f;
    private static final float TRANSFORMATION_MID = 1.0f;
    private static final float TRANSFORMATION_START = 0.0f;
    private static final float X_BOT_LINE_ANGLE = -44.0f;
    private static final float X_ROTATION_ANGLE = 90.0f;
    private static final float X_TOP_LINE_ANGLE = 44.0f;
    private IconState animatingIconState;
    private AnimationState animationState;
    private AnimatorListener animatorListener;
    private final Paint circlePaint;
    private final float circleRadius;
    private IconState currentIconState;
    private final float dip1;
    private final float dip2;
    private final float dip3;
    private final float dip4;
    private final float dip8;
    private final float diph;
    private final int height;
    private final Paint iconPaint;
    private final float iconWidth;
    private final Object lock;
    private MaterialMenuState materialMenuState;
    private boolean rtlEnabled;
    private final float sidePadding;
    private final Stroke stroke;
    private final float strokeWidth;
    private final float topPadding;
    private ObjectAnimator transformation;
    private Property<MaterialMenuDrawable, Float> transformationProperty;
    private boolean transformationRunning;
    private float transformationValue;
    private boolean visible;
    private final int width;

    class C07632 extends AnimatorListenerAdapter {
        C07632() {
        }

        public void onAnimationEnd(Animator animator) {
            MaterialMenuDrawable.this.transformationRunning = false;
            MaterialMenuDrawable.this.setIconState(MaterialMenuDrawable.this.animatingIconState);
        }
    }

    public enum AnimationState {
        BURGER_ARROW,
        BURGER_X,
        ARROW_X,
        ARROW_CHECK,
        BURGER_CHECK,
        X_CHECK;

        public final IconState getFirstState() {
            switch (this) {
                case BURGER_ARROW:
                    return IconState.BURGER;
                case BURGER_X:
                    return IconState.BURGER;
                case ARROW_X:
                    return IconState.ARROW;
                case ARROW_CHECK:
                    return IconState.ARROW;
                case BURGER_CHECK:
                    return IconState.BURGER;
                case X_CHECK:
                    return IconState.X;
                default:
                    return null;
            }
        }

        public final IconState getSecondState() {
            switch (this) {
                case BURGER_ARROW:
                    return IconState.ARROW;
                case BURGER_X:
                    return IconState.X;
                case ARROW_X:
                    return IconState.X;
                case ARROW_CHECK:
                    return IconState.CHECK;
                case BURGER_CHECK:
                    return IconState.CHECK;
                case X_CHECK:
                    return IconState.CHECK;
                default:
                    return null;
            }
        }
    }

    public enum IconState {
        BURGER,
        ARROW,
        X,
        CHECK
    }

    private final class MaterialMenuState extends ConstantState {
        private int changingConfigurations;

        private MaterialMenuState() {
        }

        public final Drawable newDrawable() {
            Drawable materialMenuDrawable = new MaterialMenuDrawable(MaterialMenuDrawable.this.circlePaint.getColor(), MaterialMenuDrawable.this.stroke, MaterialMenuDrawable.this.transformation.getDuration(), MaterialMenuDrawable.this.width, MaterialMenuDrawable.this.height, MaterialMenuDrawable.this.iconWidth, MaterialMenuDrawable.this.circleRadius, MaterialMenuDrawable.this.strokeWidth, MaterialMenuDrawable.this.dip1);
            materialMenuDrawable.setIconState(MaterialMenuDrawable.this.animatingIconState != null ? MaterialMenuDrawable.this.animatingIconState : MaterialMenuDrawable.this.currentIconState);
            materialMenuDrawable.setVisible(MaterialMenuDrawable.this.visible);
            materialMenuDrawable.setRTLEnabled(MaterialMenuDrawable.this.rtlEnabled);
            return materialMenuDrawable;
        }

        public final int getChangingConfigurations() {
            return this.changingConfigurations;
        }
    }

    public enum Stroke {
        REGULAR(3),
        THIN(2),
        EXTRA_THIN(1);
        
        private final int strokeWidth;

        private Stroke(int i) {
            this.strokeWidth = i;
        }

        protected static Stroke valueOf(int i) {
            switch (i) {
                case 1:
                    return EXTRA_THIN;
                case 2:
                    return THIN;
                case 3:
                    return REGULAR;
                default:
                    return THIN;
            }
        }
    }

    public int getOpacity() {
        return -2;
    }

    public MaterialMenuDrawable(Context context, int i, Stroke stroke) {
        this(context, i, stroke, 1, DEFAULT_TRANSFORM_DURATION);
    }

    public MaterialMenuDrawable(Context context, int i, Stroke stroke, int i2) {
        this(context, i, stroke, 1, i2);
    }

    public MaterialMenuDrawable(Context context, int i, Stroke stroke, int i2, int i3) {
        this.lock = new Object();
        this.iconPaint = new Paint();
        this.circlePaint = new Paint();
        this.transformationValue = TRANSFORMATION_START;
        this.transformationRunning = false;
        this.currentIconState = IconState.BURGER;
        this.animationState = AnimationState.BURGER_ARROW;
        this.transformationProperty = new Property<MaterialMenuDrawable, Float>(Float.class, "transformation") {
            public Float get(MaterialMenuDrawable materialMenuDrawable) {
                return materialMenuDrawable.getTransformationValue();
            }

            public void set(MaterialMenuDrawable materialMenuDrawable, Float f) {
                materialMenuDrawable.setTransformationValue(f);
            }
        };
        context = context.getResources();
        i2 = (float) i2;
        this.dip1 = dpToPx(context, TRANSFORMATION_MID) * i2;
        this.dip2 = dpToPx(context, TRANSFORMATION_END) * i2;
        this.dip3 = dpToPx(context, 3.0f) * i2;
        this.dip4 = dpToPx(context, 4.0f) * i2;
        this.dip8 = dpToPx(context, 8.0f) * i2;
        this.diph = this.dip1 / TRANSFORMATION_END;
        this.stroke = stroke;
        this.visible = true;
        this.width = (int) (dpToPx(context, 40.0f) * i2);
        this.height = (int) (dpToPx(context, 40.0f) * i2);
        this.iconWidth = dpToPx(context, 20.0f) * i2;
        this.circleRadius = dpToPx(context, 18.0f) * i2;
        this.strokeWidth = dpToPx(context, (float) stroke.strokeWidth) * i2;
        this.sidePadding = (((float) this.width) - this.iconWidth) / 1073741824;
        this.topPadding = (((float) this.height) - (1084227584 * this.dip3)) / 1073741824;
        initPaint(i);
        initAnimations(i3);
        this.materialMenuState = new MaterialMenuState();
    }

    private MaterialMenuDrawable(int i, Stroke stroke, long j, int i2, int i3, float f, float f2, float f3, float f4) {
        this.lock = new Object();
        this.iconPaint = new Paint();
        this.circlePaint = new Paint();
        this.transformationValue = TRANSFORMATION_START;
        this.transformationRunning = false;
        this.currentIconState = IconState.BURGER;
        this.animationState = AnimationState.BURGER_ARROW;
        this.transformationProperty = /* anonymous class already generated */;
        this.dip1 = f4;
        this.dip2 = f4 * TRANSFORMATION_END;
        this.dip3 = 3.0f * f4;
        this.dip4 = 4.0f * f4;
        this.dip8 = 8.0f * f4;
        this.diph = f4 / TRANSFORMATION_END;
        this.stroke = stroke;
        this.width = i2;
        this.height = i3;
        this.iconWidth = f;
        this.circleRadius = f2;
        this.strokeWidth = f3;
        this.sidePadding = (((float) i2) - f) / 1073741824;
        this.topPadding = (((float) i3) - (1084227584 * this.dip3)) / 1073741824;
        initPaint(i);
        initAnimations((int) j);
        this.materialMenuState = new MaterialMenuState();
    }

    private void initPaint(int i) {
        this.iconPaint.setAntiAlias(true);
        this.iconPaint.setStyle(Style.STROKE);
        this.iconPaint.setStrokeWidth(this.strokeWidth);
        this.iconPaint.setColor(i);
        this.circlePaint.setAntiAlias(true);
        this.circlePaint.setStyle(Style.FILL);
        this.circlePaint.setColor(i);
        this.circlePaint.setAlpha(200);
        setBounds(0, 0, this.width, this.height);
    }

    public void draw(Canvas canvas) {
        if (this.visible) {
            float f = this.transformationValue <= TRANSFORMATION_MID ? this.transformationValue : TRANSFORMATION_END - this.transformationValue;
            if (this.rtlEnabled) {
                canvas.save();
                canvas.scale(-1.0f, TRANSFORMATION_MID, TRANSFORMATION_START, TRANSFORMATION_START);
                canvas.translate((float) (-getIntrinsicWidth()), TRANSFORMATION_START);
            }
            drawTopLine(canvas, f);
            drawMiddleLine(canvas, f);
            drawBottomLine(canvas, f);
            if (this.rtlEnabled) {
                canvas.restore();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void drawMiddleLine(android.graphics.Canvas r17, float r18) {
        /*
        r16 = this;
        r0 = r16;
        r1 = r18;
        r17.restore();
        r17.save();
        r2 = r0.width;
        r2 = r2 / 2;
        r2 = (float) r2;
        r3 = r0.width;
        r3 = r3 / 2;
        r3 = (float) r3;
        r4 = r0.sidePadding;
        r5 = r0.topPadding;
        r6 = r0.dip3;
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r6 / r7;
        r8 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        r6 = r6 * r8;
        r11 = r5 + r6;
        r5 = r0.width;
        r5 = (float) r5;
        r6 = r0.sidePadding;
        r5 = r5 - r6;
        r6 = r0.topPadding;
        r9 = r0.dip3;
        r9 = r9 / r7;
        r9 = r9 * r8;
        r13 = r6 + r9;
        r6 = com.instabug.library.ui.custom.MaterialMenuDrawable.C07643.f9886xec836c19;
        r8 = r0.animationState;
        r8 = r8.ordinal();
        r6 = r6[r8];
        r8 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r9 = 1132396544; // 0x437f0000 float:255.0 double:5.5947823E-315;
        r10 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r12 = 1124532224; // 0x43070000 float:135.0 double:5.555927395E-315;
        r14 = 0;
        switch(r6) {
            case 1: goto L_0x00c1;
            case 2: goto L_0x00bb;
            case 3: goto L_0x00b3;
            case 4: goto L_0x0088;
            case 5: goto L_0x006e;
            case 6: goto L_0x004b;
            default: goto L_0x0046;
        };
    L_0x0046:
        r10 = r4;
        r12 = r5;
        r1 = r8;
        goto L_0x00da;
    L_0x004b:
        r2 = r1 * r9;
        r2 = (int) r2;
        r14 = r1 * r12;
        r6 = r0.dip4;
        r9 = r0.dip3;
        r9 = r9 / r7;
        r6 = r6 + r9;
        r6 = r6 * r1;
        r4 = r4 + r6;
        r6 = r0.dip1;
        r1 = r1 * r6;
        r5 = r5 + r1;
        r1 = r0.width;
        r1 = r1 / 2;
        r1 = (float) r1;
        r6 = r0.dip3;
        r1 = r1 + r6;
        r6 = r0.diph;
        r1 = r1 + r6;
        r10 = r4;
        r12 = r5;
        r15 = r2;
        r2 = r1;
        r1 = r15;
        goto L_0x00da;
    L_0x006e:
        r14 = r1 * r12;
        r2 = r0.dip4;
        r6 = r0.dip3;
        r6 = r6 / r7;
        r2 = r2 + r6;
        r2 = r2 * r1;
        r4 = r4 + r2;
        r2 = r0.dip1;
        r1 = r1 * r2;
        r5 = r5 + r1;
        r1 = r0.width;
        r1 = r1 / 2;
        r1 = (float) r1;
        r2 = r0.dip3;
        r1 = r1 + r2;
        r2 = r0.diph;
        r2 = r2 + r1;
        goto L_0x0046;
    L_0x0088:
        r2 = r16.isMorphingForward();
        if (r2 == 0) goto L_0x0092;
    L_0x008e:
        r2 = r1 * r12;
        r14 = r2;
        goto L_0x0097;
    L_0x0092:
        r2 = r10 - r1;
        r2 = r2 * r12;
        r12 = r12 - r2;
        r14 = r12;
    L_0x0097:
        r2 = r0.dip3;
        r2 = r2 / r7;
        r6 = r0.dip4;
        r2 = r2 + r6;
        r10 = r10 - r1;
        r6 = r0.dip2;
        r10 = r10 * r6;
        r2 = r2 - r10;
        r4 = r4 + r2;
        r2 = r0.dip1;
        r1 = r1 * r2;
        r5 = r5 + r1;
        r1 = r0.width;
        r1 = r1 / 2;
        r1 = (float) r1;
        r2 = r0.dip3;
        r1 = r1 + r2;
        r2 = r0.diph;
        r2 = r2 + r1;
        goto L_0x0046;
    L_0x00b3:
        r10 = r10 - r1;
        r9 = r9 * r10;
        r1 = (int) r9;
        r6 = r0.dip2;
        r10 = r10 * r6;
        r4 = r4 + r10;
        goto L_0x00be;
    L_0x00bb:
        r10 = r10 - r1;
        r10 = r10 * r9;
        r1 = (int) r10;
    L_0x00be:
        r10 = r4;
        r12 = r5;
        goto L_0x00da;
    L_0x00c1:
        r6 = r16.isMorphingForward();
        r9 = 1127481344; // 0x43340000 float:180.0 double:5.570497984E-315;
        if (r6 == 0) goto L_0x00cd;
    L_0x00c9:
        r6 = r1 * r9;
        r14 = r6;
        goto L_0x00d1;
    L_0x00cd:
        r10 = r10 - r1;
        r10 = r10 * r9;
        r9 = r9 + r10;
        r14 = r9;
    L_0x00d1:
        r6 = r0.resolveStrokeModifier(r1);
        r1 = r1 * r6;
        r1 = r1 / r7;
        r5 = r5 - r1;
        goto L_0x0046;
    L_0x00da:
        r4 = r0.iconPaint;
        r4.setAlpha(r1);
        r1 = r17;
        r1.rotate(r14, r2, r3);
        r14 = r0.iconPaint;
        r9 = r1;
        r9.drawLine(r10, r11, r12, r13, r14);
        r1 = r0.iconPaint;
        r1.setAlpha(r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.ui.custom.MaterialMenuDrawable.drawMiddleLine(android.graphics.Canvas, float):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void drawTopLine(android.graphics.Canvas r18, float r19) {
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r2 = r19;
        r18.save();
        r3 = r0.width;
        r3 = r3 / 2;
        r3 = (float) r3;
        r4 = r0.dip3;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = r4 / r5;
        r3 = r3 + r4;
        r4 = r0.topPadding;
        r5 = r0.dip2;
        r4 = r4 + r5;
        r5 = r0.sidePadding;
        r6 = r0.topPadding;
        r7 = r0.dip2;
        r6 = r6 + r7;
        r7 = r0.width;
        r7 = (float) r7;
        r8 = r0.sidePadding;
        r7 = r7 - r8;
        r8 = r0.topPadding;
        r9 = r0.dip2;
        r8 = r8 + r9;
        r9 = com.instabug.library.ui.custom.MaterialMenuDrawable.C07643.f9886xec836c19;
        r10 = r0.animationState;
        r10 = r10.ordinal();
        r9 = r9[r10];
        r12 = 1132396544; // 0x437f0000 float:255.0 double:5.5947823E-315;
        r13 = 1119092736; // 0x42b40000 float:90.0 double:5.529052754E-315;
        r14 = 1130430464; // 0x43610000 float:225.0 double:5.585068573E-315;
        r15 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        switch(r9) {
            case 1: goto L_0x00d7;
            case 2: goto L_0x00bf;
            case 3: goto L_0x008b;
            case 4: goto L_0x006f;
            case 5: goto L_0x0068;
            case 6: goto L_0x0049;
            default: goto L_0x0040;
        };
    L_0x0040:
        r2 = r5;
        r9 = 0;
        r10 = 0;
        r11 = 255; // 0xff float:3.57E-43 double:1.26E-321;
    L_0x0045:
        r13 = 0;
        r15 = 0;
        goto L_0x00fe;
    L_0x0049:
        r9 = r0.sidePadding;
        r14 = r0.dip4;
        r9 = r9 + r14;
        r14 = r0.topPadding;
        r11 = r0.dip3;
        r11 = r11 + r14;
        r14 = r0.dip3;
        r10 = r0.dip3;
        r15 = r15 - r2;
        r10 = r10 * r15;
        r14 = r14 - r10;
        r7 = r7 + r14;
        r2 = r0.dip3;
        r5 = r5 + r2;
        r15 = r15 * r12;
        r2 = (int) r15;
        r15 = r9;
        r9 = r11;
        r10 = 1110441984; // 0x42300000 float:44.0 double:5.48631236E-315;
        r11 = r2;
        r2 = r5;
        goto L_0x00fe;
    L_0x0068:
        r15 = r15 - r2;
        r15 = r15 * r12;
        r11 = (int) r15;
        r2 = r5;
        r9 = 0;
        r10 = 0;
        goto L_0x0045;
    L_0x006f:
        r2 = r15 - r2;
        r2 = r2 * r12;
        r11 = (int) r2;
        r2 = r0.width;
        r2 = r2 / 2;
        r2 = (float) r2;
        r9 = r0.height;
        r9 = r9 / 2;
        r9 = (float) r9;
        r10 = r0.resolveStrokeModifier(r15);
        r7 = r7 - r10;
        r10 = r0.dip3;
        r5 = r5 + r10;
        r15 = r2;
        r2 = r5;
        r10 = r14;
    L_0x0088:
        r13 = 0;
        goto L_0x00fe;
    L_0x008b:
        r9 = -1019936768; // 0xffffffffc3350000 float:-181.0 double:NaN;
        r9 = r9 * r2;
        r10 = r14 + r9;
        r13 = r13 * r2;
        r9 = r0.width;
        r9 = r9 / 2;
        r9 = (float) r9;
        r11 = r0.sidePadding;
        r12 = r0.dip4;
        r11 = r11 + r12;
        r12 = r0.width;
        r12 = r12 / 2;
        r12 = (float) r12;
        r11 = r11 - r12;
        r11 = r11 * r2;
        r15 = r9 + r11;
        r9 = r0.height;
        r9 = r9 / 2;
        r9 = (float) r9;
        r11 = r0.topPadding;
        r12 = r0.dip3;
        r11 = r11 + r12;
        r12 = r0.height;
        r12 = r12 / 2;
        r12 = (float) r12;
        r11 = r11 - r12;
        r11 = r11 * r2;
        r9 = r9 + r11;
        r2 = r0.resolveStrokeModifier(r2);
        r7 = r7 - r2;
        r2 = r0.dip3;
        r5 = r5 + r2;
        goto L_0x00d3;
    L_0x00bf:
        r9 = 1110441984; // 0x42300000 float:44.0 double:5.48631236E-315;
        r10 = r9 * r2;
        r13 = r13 * r2;
        r9 = r0.sidePadding;
        r11 = r0.dip4;
        r15 = r9 + r11;
        r9 = r0.topPadding;
        r11 = r0.dip3;
        r9 = r9 + r11;
        r11 = r0.dip3;
        r11 = r11 * r2;
        r5 = r5 + r11;
    L_0x00d3:
        r2 = r5;
        r11 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        goto L_0x00fe;
    L_0x00d7:
        r9 = r17.isMorphingForward();
        if (r9 == 0) goto L_0x00e1;
    L_0x00dd:
        r9 = r2 * r14;
        r10 = r9;
        goto L_0x00e7;
    L_0x00e1:
        r15 = r15 - r2;
        r9 = 1124532224; // 0x43070000 float:135.0 double:5.555927395E-315;
        r15 = r15 * r9;
        r14 = r14 + r15;
        r10 = r14;
    L_0x00e7:
        r9 = r0.width;
        r9 = r9 / 2;
        r15 = (float) r9;
        r9 = r0.height;
        r9 = r9 / 2;
        r9 = (float) r9;
        r11 = r0.resolveStrokeModifier(r2);
        r7 = r7 - r11;
        r11 = r0.dip3;
        r11 = r11 * r2;
        r5 = r5 + r11;
        r2 = r5;
        r11 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        goto L_0x0088;
    L_0x00fe:
        r5 = r0.iconPaint;
        r5.setAlpha(r11);
        r1.rotate(r10, r15, r9);
        r1.rotate(r13, r3, r4);
        r9 = r0.iconPaint;
        r3 = r6;
        r4 = r7;
        r5 = r8;
        r6 = r9;
        r1.drawLine(r2, r3, r4, r5, r6);
        r1 = r0.iconPaint;
        r2 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r1.setAlpha(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.ui.custom.MaterialMenuDrawable.drawTopLine(android.graphics.Canvas, float):void");
    }

    private void drawBottomLine(Canvas canvas, float f) {
        float f2;
        float f3;
        float f4;
        Canvas canvas2 = canvas;
        float f5 = f;
        canvas.restore();
        canvas.save();
        float f6 = ((float) (this.width / 2)) + (this.dip3 / TRANSFORMATION_END);
        float f7 = (((float) this.height) - this.topPadding) - this.dip2;
        float f8 = this.sidePadding;
        float f9 = (((float) this.height) - this.topPadding) - this.dip2;
        float f10 = ((float) this.width) - this.sidePadding;
        float f11 = (((float) this.height) - this.topPadding) - this.dip2;
        int i = C07643.f9886xec836c19[this.animationState.ordinal()];
        float f12 = TRANSFORMATION_START;
        float f13;
        switch (i) {
            case 1:
                f13 = isMorphingForward() ? 135.0f * f5 : 135.0f + ((TRANSFORMATION_MID - f5) * ARROW_BOT_LINE_ANGLE);
                f2 = (float) (r0.height / 2);
                f10 = (((float) r0.width) - r0.sidePadding) - resolveStrokeModifier(f5);
                f5 = r0.sidePadding + (r0.dip3 * f5);
                f3 = f13;
                f4 = (float) (r0.width / 2);
                break;
            case 2:
                f12 = isMorphingForward() ? CHECK_BOTTOM_ANGLE * f5 : X_ROTATION_ANGLE * f5;
                f3 = X_BOT_LINE_ANGLE * f5;
                f4 = r0.sidePadding + r0.dip4;
                f2 = (((float) r0.height) - r0.topPadding) - r0.dip3;
                f8 += r0.dip3 * f5;
                break;
            case 3:
                f12 = 135.0f + (181.0f * f5);
                f3 = CHECK_BOTTOM_ANGLE * f5;
                f4 = ((float) (r0.width / 2)) + (((r0.sidePadding + r0.dip4) - ((float) (r0.width / 2))) * f5);
                f2 = ((float) (r0.height / 2)) + (((((float) (r0.height / 2)) - r0.topPadding) - r0.dip3) * f5);
                f10 -= resolveStrokeModifier(f5);
                f5 = f8 + r0.dip3;
                float f14 = f12;
                f12 = f3;
                f3 = f14;
                break;
            case 4:
                f3 = (f5 * CHECK_BOTTOM_ANGLE) + 135.0f;
                f4 = ((float) (r0.width / 2)) + (r0.dip3 * f5);
                f13 = ((float) (r0.height / 2)) - (r0.dip3 * f5);
                f10 -= resolveStrokeModifier(TRANSFORMATION_MID);
                f5 = f8 + (r0.dip3 + ((r0.dip4 + r0.dip1) * f5));
                f2 = f13;
                break;
            case 5:
                f3 = 45.0f * f5;
                f4 = ((float) (r0.width / 2)) + (r0.dip3 * f5);
                f2 = ((float) (r0.height / 2)) - (r0.dip3 * f5);
                f8 += r0.dip8 * f5;
                f10 -= resolveStrokeModifier(f5);
                break;
            case 6:
                f2 = TRANSFORMATION_MID - f5;
                f12 = CHECK_BOTTOM_ANGLE * f2;
                f3 = (89.0f * f5) + X_BOT_LINE_ANGLE;
                f4 = (r0.sidePadding + r0.dip4) + ((((((float) (r0.width / 2)) + r0.dip3) - r0.sidePadding) - r0.dip4) * f5);
                f8 += r0.dip8 - ((r0.dip4 + r0.dip1) * f2);
                f10 -= resolveStrokeModifier(f2);
                f2 = ((((float) r0.height) - r0.topPadding) - r0.dip3) + (((r0.topPadding + ((float) (r0.height / 2))) - ((float) r0.height)) * f5);
                break;
            default:
                f5 = f8;
                f3 = TRANSFORMATION_START;
                f4 = f3;
                f2 = f4;
                break;
        }
        f5 = f8;
        canvas2.rotate(f3, f4, f2);
        canvas2.rotate(f12, f6, f7);
        canvas2.drawLine(f5, f9, f10, f11, r0.iconPaint);
    }

    private boolean isMorphingForward() {
        return this.transformationValue <= TRANSFORMATION_MID;
    }

    private float resolveStrokeModifier(float f) {
        switch (this.stroke) {
            case REGULAR:
                if (this.animationState != AnimationState.ARROW_X) {
                    if (this.animationState != AnimationState.X_CHECK) {
                        return f * this.dip3;
                    }
                }
                return this.dip3 - (this.dip3 * f);
            case THIN:
                if (this.animationState != AnimationState.ARROW_X) {
                    if (this.animationState != AnimationState.X_CHECK) {
                        return f * (this.dip3 + this.diph);
                    }
                }
                return (this.dip3 + this.diph) - ((this.dip3 + this.diph) * f);
            case EXTRA_THIN:
                if (this.animationState != AnimationState.ARROW_X) {
                    if (this.animationState != AnimationState.X_CHECK) {
                        return f * this.dip4;
                    }
                }
                return this.dip4 - ((this.dip3 + this.dip1) * f);
            default:
                return TRANSFORMATION_START;
        }
    }

    public void setAlpha(int i) {
        this.iconPaint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.iconPaint.setColorFilter(colorFilter);
    }

    public void setColor(int i) {
        this.iconPaint.setColor(i);
        this.circlePaint.setColor(i);
        invalidateSelf();
    }

    @RequiresApi(api = 11)
    public void setTransformationDuration(int i) {
        this.transformation.setDuration((long) i);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.transformation.setInterpolator(interpolator);
    }

    public void setAnimationListener(AnimatorListener animatorListener) {
        if (this.animatorListener != null) {
            this.transformation.removeListener(this.animatorListener);
        }
        if (animatorListener != null) {
            this.transformation.addListener(animatorListener);
        }
        this.animatorListener = animatorListener;
    }

    public void setIconState(IconState iconState) {
        synchronized (this.lock) {
            if (this.transformationRunning) {
                this.transformation.cancel();
                this.transformationRunning = false;
            }
            if (this.currentIconState == iconState) {
                return;
            }
            switch (iconState) {
                case BURGER:
                    this.animationState = AnimationState.BURGER_ARROW;
                    this.transformationValue = TRANSFORMATION_START;
                    break;
                case ARROW:
                    this.animationState = AnimationState.BURGER_ARROW;
                    this.transformationValue = TRANSFORMATION_MID;
                    break;
                case X:
                    this.animationState = AnimationState.BURGER_X;
                    this.transformationValue = TRANSFORMATION_MID;
                    break;
                case CHECK:
                    this.animationState = AnimationState.BURGER_CHECK;
                    this.transformationValue = TRANSFORMATION_MID;
                    break;
                default:
                    break;
            }
            this.currentIconState = iconState;
            invalidateSelf();
        }
    }

    public void animateIconState(IconState iconState) {
        synchronized (this.lock) {
            if (this.transformationRunning) {
                this.transformation.end();
            }
            this.animatingIconState = iconState;
            start();
        }
    }

    public IconState setTransformationOffset(AnimationState animationState, float f) {
        int i = 1;
        if (f >= TRANSFORMATION_START) {
            int i2 = (f > TRANSFORMATION_END ? 1 : (f == TRANSFORMATION_END ? 0 : -1));
            if (i2 <= 0) {
                this.animationState = animationState;
                if (f >= TRANSFORMATION_MID) {
                    if (i2 != 0) {
                        i = 0;
                    }
                }
                this.currentIconState = i != 0 ? animationState.getFirstState() : animationState.getSecondState();
                this.animatingIconState = i != 0 ? animationState.getSecondState() : animationState.getFirstState();
                setTransformationValue(Float.valueOf(f));
                return this.currentIconState;
            }
        }
        throw new IllegalArgumentException(String.format("Value must be between %s and %s", new Object[]{Float.valueOf(TRANSFORMATION_START), Float.valueOf(TRANSFORMATION_END)}));
    }

    public void setVisible(boolean z) {
        this.visible = z;
        invalidateSelf();
    }

    public void setRTLEnabled(boolean z) {
        this.rtlEnabled = z;
        invalidateSelf();
    }

    public IconState getIconState() {
        return this.currentIconState;
    }

    public boolean isDrawableVisible() {
        return this.visible;
    }

    public Float getTransformationValue() {
        return Float.valueOf(this.transformationValue);
    }

    public void setTransformationValue(Float f) {
        this.transformationValue = f.floatValue();
        invalidateSelf();
    }

    private void initAnimations(int i) {
        this.transformation = ObjectAnimator.ofFloat(this, this.transformationProperty, new float[]{TRANSFORMATION_START});
        this.transformation.setInterpolator(new DecelerateInterpolator(3.0f));
        this.transformation.setDuration((long) i);
        this.transformation.addListener(new C07632());
    }

    private boolean resolveTransformation() {
        boolean z = this.currentIconState == IconState.BURGER;
        boolean z2 = this.currentIconState == IconState.ARROW;
        boolean z3 = this.currentIconState == IconState.X;
        int i = this.currentIconState == IconState.CHECK ? 1 : 0;
        int i2 = this.animatingIconState == IconState.BURGER ? 1 : 0;
        int i3 = this.animatingIconState == IconState.ARROW ? 1 : 0;
        int i4 = this.animatingIconState == IconState.X ? 1 : 0;
        int i5 = this.animatingIconState == IconState.CHECK ? 1 : 0;
        if ((z && i3 != 0) || (z2 && i2 != 0)) {
            this.animationState = AnimationState.BURGER_ARROW;
            return z;
        } else if ((z2 && i4 != 0) || (z3 && i3 != 0)) {
            this.animationState = AnimationState.ARROW_X;
            return z2;
        } else if ((z && i4 != 0) || (z3 && i2 != 0)) {
            this.animationState = AnimationState.BURGER_X;
            return z;
        } else if ((z2 && i5 != 0) || (i != 0 && i3 != 0)) {
            this.animationState = AnimationState.ARROW_CHECK;
            return z2;
        } else if ((z && i5 != 0) || (i != 0 && i2 != 0)) {
            this.animationState = AnimationState.BURGER_CHECK;
            return z;
        } else if ((!z3 || i5 == 0) && (i == 0 || i4 == 0)) {
            throw new IllegalStateException(String.format("Animating from %s to %s is not supported", new Object[]{this.currentIconState, this.animatingIconState}));
        } else {
            this.animationState = AnimationState.X_CHECK;
            return z3;
        }
    }

    public void start() {
        if (!this.transformationRunning) {
            if (!(this.animatingIconState == null || this.animatingIconState == this.currentIconState)) {
                this.transformationRunning = true;
                boolean resolveTransformation = resolveTransformation();
                ObjectAnimator objectAnimator = this.transformation;
                float[] fArr = new float[2];
                float f = TRANSFORMATION_MID;
                fArr[0] = resolveTransformation ? TRANSFORMATION_START : 1.0f;
                if (!resolveTransformation) {
                    f = TRANSFORMATION_END;
                }
                fArr[1] = f;
                objectAnimator.setFloatValues(fArr);
                this.transformation.start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (isRunning() && this.transformation.isRunning()) {
            this.transformation.end();
            return;
        }
        this.transformationRunning = false;
        invalidateSelf();
    }

    public boolean isRunning() {
        return this.transformationRunning;
    }

    public int getIntrinsicWidth() {
        return this.width;
    }

    public int getIntrinsicHeight() {
        return this.height;
    }

    public ConstantState getConstantState() {
        this.materialMenuState.changingConfigurations = getChangingConfigurations();
        return this.materialMenuState;
    }

    public Drawable mutate() {
        this.materialMenuState = new MaterialMenuState();
        return this;
    }

    static float dpToPx(Resources resources, float f) {
        return TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }
}
