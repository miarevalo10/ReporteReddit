package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class CompoundButtonCompat {
    private static final CompoundButtonCompatBaseImpl f1602a;

    static class CompoundButtonCompatBaseImpl {
        private static Field f1600a;
        private static boolean f1601b;

        CompoundButtonCompatBaseImpl() {
        }

        public void mo381a(CompoundButton compoundButton, ColorStateList colorStateList) {
            if (compoundButton instanceof TintableCompoundButton) {
                ((TintableCompoundButton) compoundButton).setSupportButtonTintList(colorStateList);
            }
        }

        public void mo382a(CompoundButton compoundButton, Mode mode) {
            if (compoundButton instanceof TintableCompoundButton) {
                ((TintableCompoundButton) compoundButton).setSupportButtonTintMode(mode);
            }
        }

        public Drawable mo3156a(CompoundButton compoundButton) {
            if (!f1601b) {
                try {
                    Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    f1600a = declaredField;
                    declaredField.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
                }
                f1601b = true;
            }
            if (f1600a != null) {
                try {
                    return (Drawable) f1600a.get(compoundButton);
                } catch (CompoundButton compoundButton2) {
                    Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", compoundButton2);
                    f1600a = null;
                }
            }
            return null;
        }
    }

    @RequiresApi(21)
    static class CompoundButtonCompatApi21Impl extends CompoundButtonCompatBaseImpl {
        CompoundButtonCompatApi21Impl() {
        }

        public final void mo381a(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        public final void mo382a(CompoundButton compoundButton, Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    @RequiresApi(23)
    static class CompoundButtonCompatApi23Impl extends CompoundButtonCompatApi21Impl {
        CompoundButtonCompatApi23Impl() {
        }

        public final Drawable mo3156a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f1602a = new CompoundButtonCompatApi23Impl();
        } else if (VERSION.SDK_INT >= 21) {
            f1602a = new CompoundButtonCompatApi21Impl();
        } else {
            f1602a = new CompoundButtonCompatBaseImpl();
        }
    }

    public static void m1373a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f1602a.mo381a(compoundButton, colorStateList);
    }

    public static void m1374a(CompoundButton compoundButton, Mode mode) {
        f1602a.mo382a(compoundButton, mode);
    }

    public static Drawable m1372a(CompoundButton compoundButton) {
        return f1602a.mo3156a(compoundButton);
    }
}
