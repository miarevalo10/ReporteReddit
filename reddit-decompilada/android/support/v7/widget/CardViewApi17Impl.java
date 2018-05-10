package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.RequiresApi;

@RequiresApi(17)
class CardViewApi17Impl extends CardViewBaseImpl {

    class C10251 implements RoundRectHelper {
        final /* synthetic */ CardViewApi17Impl f11924a;

        C10251(CardViewApi17Impl cardViewApi17Impl) {
            this.f11924a = cardViewApi17Impl;
        }

        public final void mo599a(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    CardViewApi17Impl() {
    }

    public final void mo601a() {
        RoundRectDrawableWithShadow.f2453b = new C10251(this);
    }
}
