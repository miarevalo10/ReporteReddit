package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class CardViewBaseImpl implements CardViewImpl {
    private final RectF f11926a = new RectF();

    class C10261 implements RoundRectHelper {
        final /* synthetic */ CardViewBaseImpl f11925a;

        C10261(CardViewBaseImpl cardViewBaseImpl) {
            this.f11925a = cardViewBaseImpl;
        }

        public final void mo599a(Canvas canvas, RectF rectF, float f, Paint paint) {
            C10261 c10261 = this;
            Canvas canvas2 = canvas;
            RectF rectF2 = rectF;
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                float f3 = f + 0.5f;
                float f4 = -f3;
                c10261.f11925a.f11926a.set(f4, f4, f3, f3);
                int save = canvas.save();
                canvas2.translate(rectF2.left + f3, rectF2.top + f3);
                canvas2.drawArc(c10261.f11925a.f11926a, 180.0f, 90.0f, true, paint);
                canvas2.translate(width, 0.0f);
                canvas2.rotate(90.0f);
                float f5 = 90.0f;
                Paint paint2 = paint;
                canvas2.drawArc(c10261.f11925a.f11926a, 180.0f, 90.0f, true, paint2);
                canvas2.translate(height, 0.0f);
                canvas2.rotate(f5);
                canvas2.drawArc(c10261.f11925a.f11926a, 180.0f, 90.0f, true, paint2);
                canvas2.translate(width, 0.0f);
                canvas2.rotate(f5);
                canvas2.drawArc(c10261.f11925a.f11926a, 180.0f, 90.0f, true, paint2);
                canvas2.restoreToCount(save);
                canvas2.drawRect((rectF2.left + f3) - 1.0f, rectF2.top, (rectF2.right - f3) + 1.0f, rectF2.top + f3, paint);
                canvas2.drawRect((rectF2.left + f3) - 1.0f, rectF2.bottom - f3, (rectF2.right - f3) + 1.0f, rectF2.bottom, paint);
            }
            canvas2.drawRect(rectF2.left, rectF2.top + f, rectF2.right, rectF2.bottom - f, paint);
        }
    }

    public final void mo611f(CardViewDelegate cardViewDelegate) {
    }

    CardViewBaseImpl() {
    }

    public void mo601a() {
        RoundRectDrawableWithShadow.f2453b = new C10261(this);
    }

    private void m10612i(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        m10613j(cardViewDelegate).getPadding(rect);
        cardViewDelegate.mo592a((int) Math.ceil((double) mo605b(cardViewDelegate)), (int) Math.ceil((double) mo607c(cardViewDelegate)));
        cardViewDelegate.mo593a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void mo612g(CardViewDelegate cardViewDelegate) {
        m10613j(cardViewDelegate).m2254a(cardViewDelegate.mo596b());
        m10612i(cardViewDelegate);
    }

    public final void mo604a(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        cardViewDelegate = m10613j(cardViewDelegate);
        cardViewDelegate.m2253a(colorStateList);
        cardViewDelegate.invalidateSelf();
    }

    public final ColorStateList mo613h(CardViewDelegate cardViewDelegate) {
        return m10613j(cardViewDelegate).f2459f;
    }

    public final void mo602a(CardViewDelegate cardViewDelegate, float f) {
        RoundRectDrawableWithShadow j = m10613j(cardViewDelegate);
        if (f < 0.0f) {
            StringBuilder stringBuilder = new StringBuilder("Invalid radius ");
            stringBuilder.append(f);
            stringBuilder.append(". Must be >= 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        f = (float) ((int) (f + 0.5f));
        if (j.f2456c != f) {
            j.f2456c = f;
            j.f2460g = true;
            j.invalidateSelf();
        }
        m10612i(cardViewDelegate);
    }

    public final float mo609d(CardViewDelegate cardViewDelegate) {
        return m10613j(cardViewDelegate).f2456c;
    }

    public final void mo608c(CardViewDelegate cardViewDelegate, float f) {
        cardViewDelegate = m10613j(cardViewDelegate);
        cardViewDelegate.m2252a(f, cardViewDelegate.f2457d);
    }

    public final float mo610e(CardViewDelegate cardViewDelegate) {
        return m10613j(cardViewDelegate).f2458e;
    }

    public final void mo606b(CardViewDelegate cardViewDelegate, float f) {
        RoundRectDrawableWithShadow j = m10613j(cardViewDelegate);
        j.m2252a(j.f2458e, f);
        m10612i(cardViewDelegate);
    }

    public final float mo600a(CardViewDelegate cardViewDelegate) {
        return m10613j(cardViewDelegate).f2457d;
    }

    public final float mo605b(CardViewDelegate cardViewDelegate) {
        cardViewDelegate = m10613j(cardViewDelegate);
        return (Math.max(cardViewDelegate.f2457d, (cardViewDelegate.f2456c + ((float) cardViewDelegate.f2455a)) + (cardViewDelegate.f2457d / 2.0f)) * 2.0f) + ((cardViewDelegate.f2457d + ((float) cardViewDelegate.f2455a)) * 2.0f);
    }

    public final float mo607c(CardViewDelegate cardViewDelegate) {
        cardViewDelegate = m10613j(cardViewDelegate);
        return (Math.max(cardViewDelegate.f2457d, (cardViewDelegate.f2456c + ((float) cardViewDelegate.f2455a)) + ((cardViewDelegate.f2457d * 1.5f) / 2.0f)) * 2.0f) + (((cardViewDelegate.f2457d * 1.5f) + ((float) cardViewDelegate.f2455a)) * 2.0f);
    }

    private static RoundRectDrawableWithShadow m10613j(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.mo597c();
    }

    public final void mo603a(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        Drawable roundRectDrawableWithShadow = new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f, f2, f3);
        roundRectDrawableWithShadow.m2254a(cardViewDelegate.mo596b());
        cardViewDelegate.mo594a(roundRectDrawableWithShadow);
        m10612i(cardViewDelegate);
    }
}
