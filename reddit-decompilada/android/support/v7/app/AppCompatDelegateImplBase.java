package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.Thread.UncaughtExceptionHandler;

@RequiresApi(14)
abstract class AppCompatDelegateImplBase extends AppCompatDelegate {
    private static boolean f11542p = true;
    private static final boolean f11543q;
    private static final int[] f11544r = new int[]{16842836};
    final Context f11545b;
    final Window f11546c;
    final Callback f11547d = this.f11546c.getCallback();
    final Callback f11548e;
    final AppCompatCallback f11549f;
    ActionBar f11550g;
    MenuInflater f11551h;
    boolean f11552i;
    boolean f11553j;
    boolean f11554k;
    boolean f11555l;
    boolean f11556m;
    CharSequence f11557n;
    boolean f11558o;
    private boolean f11559s;

    class AppCompatWindowCallbackBase extends WindowCallbackWrapper {
        final /* synthetic */ AppCompatDelegateImplBase f11541a;

        public void onContentChanged() {
        }

        AppCompatWindowCallbackBase(AppCompatDelegateImplBase appCompatDelegateImplBase, Callback callback) {
            this.f11541a = appCompatDelegateImplBase;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (!this.f11541a.mo3171a(keyEvent)) {
                if (super.dispatchKeyEvent(keyEvent) == null) {
                    return null;
                }
            }
            return true;
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (!super.dispatchKeyShortcutEvent(keyEvent)) {
                if (this.f11541a.mo3170a(keyEvent.getKeyCode(), keyEvent) == null) {
                    return null;
                }
            }
            return true;
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            i = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return i;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            this.f11541a.mo3179f(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            this.f11541a.mo3177e(i);
        }
    }

    abstract boolean mo3170a(int i, KeyEvent keyEvent);

    abstract boolean mo3171a(KeyEvent keyEvent);

    public void mo420b(Bundle bundle) {
    }

    abstract void mo3174b(CharSequence charSequence);

    public void mo422d(int i) {
    }

    abstract void mo3177e(int i);

    abstract boolean mo3179f(int i);

    public boolean mo425j() {
        return false;
    }

    abstract void mo3182l();

    static {
        boolean z = VERSION.SDK_INT < 21;
        f11543q = z;
        if (z && !f11542p) {
            final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                public final void uncaughtException(Thread thread, Throwable th) {
                    Object obj = null;
                    if (th instanceof NotFoundException) {
                        String message = th.getMessage();
                        if (message != null && (message.contains("drawable") || message.contains("Drawable"))) {
                            obj = 1;
                        }
                    }
                    if (obj != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(th.getMessage());
                        stringBuilder.append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        Throwable notFoundException = new NotFoundException(stringBuilder.toString());
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    AppCompatDelegateImplBase(Context context, Window window, AppCompatCallback appCompatCallback) {
        this.f11545b = context;
        this.f11546c = window;
        this.f11549f = appCompatCallback;
        if ((this.f11547d instanceof AppCompatWindowCallbackBase) != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f11548e = mo4224a(this.f11547d);
        this.f11546c.setCallback(this.f11548e);
        context = TintTypedArray.m2307a(context, (AttributeSet) null, f11544r);
        window = context.m2314b(null);
        if (window != null) {
            this.f11546c.setBackgroundDrawable(window);
        }
        context.f2595b.recycle();
    }

    Callback mo4224a(Callback callback) {
        return new AppCompatWindowCallbackBase(this, callback);
    }

    public final ActionBar mo417a() {
        mo3182l();
        return this.f11550g;
    }

    public final MenuInflater mo419b() {
        if (this.f11551h == null) {
            mo3182l();
            this.f11551h = new SupportMenuInflater(this.f11550g != null ? this.f11550g.mo451e() : this.f11545b);
        }
        return this.f11551h;
    }

    final Context m10240m() {
        ActionBar a = mo417a();
        Context e = a != null ? a.mo451e() : null;
        return e == null ? this.f11545b : e;
    }

    public void mo421d() {
        this.f11559s = true;
    }

    public void mo423e() {
        this.f11559s = false;
    }

    public void mo424h() {
        this.f11558o = true;
    }

    public final void mo418a(CharSequence charSequence) {
        this.f11557n = charSequence;
        mo3174b(charSequence);
    }
}
