package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class CardViewApi21Impl implements CardViewImpl {
    public final void mo601a() {
    }

    CardViewApi21Impl() {
    }

    public final void mo603a(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        cardViewDelegate.mo594a(new RoundRectDrawable(colorStateList, f));
        context = cardViewDelegate.mo598d();
        context.setClipToOutline(true);
        context.setElevation(f2);
        mo606b(cardViewDelegate, f3);
    }

    public final void mo602a(CardViewDelegate cardViewDelegate, float f) {
        cardViewDelegate = m10595i(cardViewDelegate);
        if (f != cardViewDelegate.f2442a) {
            cardViewDelegate.f2442a = f;
            cardViewDelegate.m2247a((Rect) 0.0f);
            cardViewDelegate.invalidateSelf();
        }
    }

    public final void mo606b(CardViewDelegate cardViewDelegate, float f) {
        RoundRectDrawable i = m10595i(cardViewDelegate);
        boolean a = cardViewDelegate.mo595a();
        boolean b = cardViewDelegate.mo596b();
        if (!(f == i.f2443b && i.f2444c == a && i.f2445d == b)) {
            i.f2443b = f;
            i.f2444c = a;
            i.f2445d = b;
            i.m2247a((Rect) 0.0f);
            i.invalidateSelf();
        }
        if (cardViewDelegate.mo595a() == null) {
            cardViewDelegate.mo593a(0, 0, 0, 0);
            return;
        }
        f = m10595i(cardViewDelegate).f2443b;
        float f2 = m10595i(cardViewDelegate).f2442a;
        int ceil = (int) Math.ceil((double) RoundRectDrawableWithShadow.m2251b(f, f2, cardViewDelegate.mo596b()));
        f = (int) Math.ceil((double) RoundRectDrawableWithShadow.m2249a(f, f2, cardViewDelegate.mo596b()));
        cardViewDelegate.mo593a(ceil, f, ceil, f);
    }

    public final float mo600a(CardViewDelegate cardViewDelegate) {
        return m10595i(cardViewDelegate).f2443b;
    }

    public final float mo609d(CardViewDelegate cardViewDelegate) {
        return m10595i(cardViewDelegate).f2442a;
    }

    public final void mo608c(CardViewDelegate cardViewDelegate, float f) {
        cardViewDelegate.mo598d().setElevation(f);
    }

    public final float mo610e(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.mo598d().getElevation();
    }

    public final void mo604a(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        cardViewDelegate = m10595i(cardViewDelegate);
        cardViewDelegate.m2246a(colorStateList);
        cardViewDelegate.invalidateSelf();
    }

    public final ColorStateList mo613h(CardViewDelegate cardViewDelegate) {
        return m10595i(cardViewDelegate).f2446e;
    }

    private static RoundRectDrawable m10595i(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable) cardViewDelegate.mo597c();
    }

    public final float mo605b(CardViewDelegate cardViewDelegate) {
        return m10595i(cardViewDelegate).f2442a * 2.0f;
    }

    public final float mo607c(CardViewDelegate cardViewDelegate) {
        return m10595i(cardViewDelegate).f2442a * 2.0f;
    }

    public final void mo611f(CardViewDelegate cardViewDelegate) {
        mo606b(cardViewDelegate, m10595i(cardViewDelegate).f2443b);
    }

    public final void mo612g(CardViewDelegate cardViewDelegate) {
        mo606b(cardViewDelegate, m10595i(cardViewDelegate).f2443b);
    }
}
