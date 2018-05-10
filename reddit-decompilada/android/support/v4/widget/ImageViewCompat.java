package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;

public class ImageViewCompat {
    static final ImageViewCompatImpl f1652a;

    interface ImageViewCompatImpl {
        ColorStateList mo392a(ImageView imageView);

        void mo393a(ImageView imageView, ColorStateList colorStateList);

        void mo394a(ImageView imageView, Mode mode);

        Mode mo395b(ImageView imageView);
    }

    static class BaseViewCompatImpl implements ImageViewCompatImpl {
        BaseViewCompatImpl() {
        }

        public ColorStateList mo392a(ImageView imageView) {
            return imageView instanceof TintableImageSourceView ? ((TintableImageSourceView) imageView).getSupportImageTintList() : null;
        }

        public void mo393a(ImageView imageView, ColorStateList colorStateList) {
            if (imageView instanceof TintableImageSourceView) {
                ((TintableImageSourceView) imageView).setSupportImageTintList(colorStateList);
            }
        }

        public void mo394a(ImageView imageView, Mode mode) {
            if (imageView instanceof TintableImageSourceView) {
                ((TintableImageSourceView) imageView).setSupportImageTintMode(mode);
            }
        }

        public Mode mo395b(ImageView imageView) {
            return imageView instanceof TintableImageSourceView ? ((TintableImageSourceView) imageView).getSupportImageTintMode() : null;
        }
    }

    @RequiresApi(21)
    static class LollipopViewCompatImpl extends BaseViewCompatImpl {
        LollipopViewCompatImpl() {
        }

        public final ColorStateList mo392a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        public final void mo393a(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                colorStateList = imageView.getDrawable();
                Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
                if (colorStateList != null && obj != null) {
                    if (colorStateList.isStateful()) {
                        colorStateList.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(colorStateList);
                }
            }
        }

        public final void mo394a(ImageView imageView, Mode mode) {
            imageView.setImageTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                mode = imageView.getDrawable();
                Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
                if (mode != null && obj != null) {
                    if (mode.isStateful()) {
                        mode.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(mode);
                }
            }
        }

        public final Mode mo395b(ImageView imageView) {
            return imageView.getImageTintMode();
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1652a = new LollipopViewCompatImpl();
        } else {
            f1652a = new BaseViewCompatImpl();
        }
    }

    public static ColorStateList m1405a(ImageView imageView) {
        return f1652a.mo392a(imageView);
    }

    public static void m1406a(ImageView imageView, ColorStateList colorStateList) {
        f1652a.mo393a(imageView, colorStateList);
    }

    public static Mode m1408b(ImageView imageView) {
        return f1652a.mo395b(imageView);
    }

    public static void m1407a(ImageView imageView, Mode mode) {
        f1652a.mo394a(imageView, mode);
    }
}
