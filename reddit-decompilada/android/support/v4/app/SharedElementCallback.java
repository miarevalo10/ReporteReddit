package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public abstract class SharedElementCallback {
    static int f1175b = 1048576;
    Matrix f1176a;

    public interface OnSharedElementsReadyListener {
        void mo190a();
    }

    static Bitmap m703a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0) {
            if (intrinsicHeight > 0) {
                float min = Math.min(1.0f, ((float) f1175b) / ((float) (intrinsicWidth * intrinsicHeight)));
                if ((drawable instanceof BitmapDrawable) && min == 1.0f) {
                    return ((BitmapDrawable) drawable).getBitmap();
                }
                intrinsicWidth = (int) (((float) intrinsicWidth) * min);
                intrinsicHeight = (int) (((float) intrinsicHeight) * min);
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                Rect bounds = drawable.getBounds();
                int i = bounds.left;
                int i2 = bounds.top;
                int i3 = bounds.right;
                int i4 = bounds.bottom;
                drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                drawable.draw(canvas);
                drawable.setBounds(i, i2, i3, i4);
                return createBitmap;
            }
        }
        return null;
    }

    public static View m704a(Context context, Parcelable parcelable) {
        View view = null;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            Bitmap bitmap = (Bitmap) bundle.getParcelable("sharedElement:snapshot:bitmap");
            if (bitmap == null) {
                return null;
            }
            view = new ImageView(context);
            view.setImageBitmap(bitmap);
            view.setScaleType(ScaleType.valueOf(bundle.getString("sharedElement:snapshot:imageScaleType")));
            if (view.getScaleType() == ScaleType.MATRIX) {
                context = bundle.getFloatArray("sharedElement:snapshot:imageMatrix");
                parcelable = new Matrix();
                parcelable.setValues(context);
                view.setImageMatrix(parcelable);
            }
        } else if (parcelable instanceof Bitmap) {
            Bitmap bitmap2 = (Bitmap) parcelable;
            view = new ImageView(context);
            view.setImageBitmap(bitmap2);
        }
        return view;
    }

    public static void m705a(OnSharedElementsReadyListener onSharedElementsReadyListener) {
        onSharedElementsReadyListener.mo190a();
    }
}
