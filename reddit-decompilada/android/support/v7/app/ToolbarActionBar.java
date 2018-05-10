package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window.Callback;
import java.util.ArrayList;

class ToolbarActionBar extends ActionBar {
    DecorToolbar f11574a;
    boolean f11575b;
    Callback f11576c;
    private boolean f11577d;
    private boolean f11578e;
    private ArrayList<Object> f11579f = new ArrayList();
    private final Runnable f11580g = new C01631(this);
    private final OnMenuItemClickListener f11581h = new C10142(this);

    class C01631 implements Runnable {
        final /* synthetic */ ToolbarActionBar f1840a;

        public void run() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0032 in list [B:13:0x002e]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r6 = this;
            r0 = r6.f1840a;
            r1 = r0.m10283l();
            r2 = r1 instanceof android.support.v7.view.menu.MenuBuilder;
            r3 = 0;
            if (r2 == 0) goto L_0x000f;
        L_0x000b:
            r2 = r1;
            r2 = (android.support.v7.view.menu.MenuBuilder) r2;
            goto L_0x0010;
        L_0x000f:
            r2 = r3;
        L_0x0010:
            if (r2 == 0) goto L_0x0015;
        L_0x0012:
            r2.stopDispatchingItemsChanged();
        L_0x0015:
            r1.clear();	 Catch:{ all -> 0x0033 }
            r4 = r0.f11576c;	 Catch:{ all -> 0x0033 }
            r5 = 0;	 Catch:{ all -> 0x0033 }
            r4 = r4.onCreatePanelMenu(r5, r1);	 Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x0029;	 Catch:{ all -> 0x0033 }
        L_0x0021:
            r0 = r0.f11576c;	 Catch:{ all -> 0x0033 }
            r0 = r0.onPreparePanel(r5, r3, r1);	 Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x002c;	 Catch:{ all -> 0x0033 }
        L_0x0029:
            r1.clear();	 Catch:{ all -> 0x0033 }
        L_0x002c:
            if (r2 == 0) goto L_0x0032;
        L_0x002e:
            r2.startDispatchingItemsChanged();
            return;
        L_0x0032:
            return;
        L_0x0033:
            r0 = move-exception;
            if (r2 == 0) goto L_0x0039;
        L_0x0036:
            r2.startDispatchingItemsChanged();
        L_0x0039:
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.ToolbarActionBar.1.run():void");
        }

        C01631(ToolbarActionBar toolbarActionBar) {
            this.f1840a = toolbarActionBar;
        }
    }

    class C10142 implements OnMenuItemClickListener {
        final /* synthetic */ ToolbarActionBar f11569a;

        C10142(ToolbarActionBar toolbarActionBar) {
            this.f11569a = toolbarActionBar;
        }

        public final boolean mo434a(MenuItem menuItem) {
            return this.f11569a.f11576c.onMenuItemSelected(0, menuItem);
        }
    }

    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ ToolbarActionBar f11570a;
        private boolean f11571b;

        ActionMenuPresenterCallback(ToolbarActionBar toolbarActionBar) {
            this.f11570a = toolbarActionBar;
        }

        public final boolean mo429a(MenuBuilder menuBuilder) {
            if (this.f11570a.f11576c == null) {
                return null;
            }
            this.f11570a.f11576c.onMenuOpened(108, menuBuilder);
            return true;
        }

        public final void mo428a(MenuBuilder menuBuilder, boolean z) {
            if (!this.f11571b) {
                this.f11571b = true;
                this.f11570a.f11574a.mo762n();
                if (this.f11570a.f11576c) {
                    this.f11570a.f11576c.onPanelClosed(108, menuBuilder);
                }
                this.f11571b = null;
            }
        }
    }

    private final class MenuBuilderCallback implements MenuBuilder.Callback {
        final /* synthetic */ ToolbarActionBar f11572a;

        public final boolean mo108a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        MenuBuilderCallback(ToolbarActionBar toolbarActionBar) {
            this.f11572a = toolbarActionBar;
        }

        public final void mo107a(MenuBuilder menuBuilder) {
            if (this.f11572a.f11576c != null) {
                if (this.f11572a.f11574a.mo757i()) {
                    this.f11572a.f11576c.onPanelClosed(108, menuBuilder);
                } else if (this.f11572a.f11576c.onPreparePanel(0, null, menuBuilder)) {
                    this.f11572a.f11576c.onMenuOpened(108, menuBuilder);
                }
            }
        }
    }

    private class ToolbarCallbackWrapper extends WindowCallbackWrapper {
        final /* synthetic */ ToolbarActionBar f11573a;

        public ToolbarCallbackWrapper(ToolbarActionBar toolbarActionBar, Callback callback) {
            this.f11573a = toolbarActionBar;
            super(callback);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            i = super.onPreparePanel(i, view, menu);
            if (i != 0 && this.f11573a.f11575b == null) {
                this.f11573a.f11574a.mo761m();
                this.f11573a.f11575b = true;
            }
            return i;
        }

        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(this.f11573a.f11574a.mo745b());
            }
            return super.onCreatePanelView(i);
        }
    }

    private void m10258a(int r1, int r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v7.app.ToolbarActionBar.a(int, int):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.ToolbarActionBar.a(int, int):void");
    }

    public final void mo449d(boolean z) {
    }

    public final void mo452e(boolean z) {
    }

    ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.f11574a = new ToolbarWidgetWrapper(toolbar, false);
        this.f11576c = new ToolbarCallbackWrapper(this, callback);
        this.f11574a.mo742a(this.f11576c);
        toolbar.setOnMenuItemClickListener(this.f11581h);
        this.f11574a.mo743a(charSequence);
    }

    public final Context mo451e() {
        return this.f11574a.mo745b();
    }

    public final void mo439a(Drawable drawable) {
        this.f11574a.mo747b(drawable);
    }

    public final void mo453f() {
        this.f11574a.mo765q();
    }

    public final void mo438a(Configuration configuration) {
        super.mo438a(configuration);
    }

    public final void mo440a(CharSequence charSequence) {
        this.f11574a.mo748b(charSequence);
    }

    public final void mo437a(int i) {
        this.f11574a.mo748b(i != 0 ? this.f11574a.mo745b().getText(i) : 0);
    }

    public final void mo445b(CharSequence charSequence) {
        this.f11574a.mo743a(charSequence);
    }

    public final void mo441a(boolean z) {
        m10258a(z ? true : false, 2);
    }

    public final void mo446b(boolean z) {
        m10258a(z ? true : false, 4);
    }

    public final void mo448c(boolean z) {
        m10258a(z ? true : false, 8);
    }

    public final int mo436a() {
        return this.f11574a.mo763o();
    }

    public final void mo444b() {
        this.f11574a.mo752d(0);
    }

    public final void mo447c() {
        this.f11574a.mo752d(8);
    }

    public final boolean mo450d() {
        return this.f11574a.mo766r() == 0;
    }

    public final boolean mo455g() {
        return this.f11574a.mo759k();
    }

    public final boolean mo456h() {
        return this.f11574a.mo760l();
    }

    public final boolean mo457i() {
        this.f11574a.mo736a().removeCallbacks(this.f11580g);
        ViewCompat.m1224a(this.f11574a.mo736a(), this.f11580g);
        return true;
    }

    public final boolean mo458j() {
        if (!this.f11574a.mo750c()) {
            return false;
        }
        this.f11574a.mo751d();
        return true;
    }

    public final boolean mo443a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            mo455g();
        }
        return true;
    }

    public final boolean mo442a(int i, KeyEvent keyEvent) {
        Menu l = m10283l();
        if (l == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        l.setQwertyMode(z);
        return l.performShortcut(i, keyEvent, 0);
    }

    final void mo459k() {
        this.f11574a.mo736a().removeCallbacks(this.f11580g);
    }

    public final void mo454f(boolean z) {
        if (z != this.f11578e) {
            this.f11578e = z;
            z = this.f11579f.size();
            for (boolean z2 = false; z2 < z; z2++) {
                this.f11579f.get(z2);
            }
        }
    }

    final Menu m10283l() {
        if (!this.f11577d) {
            this.f11574a.mo739a(new ActionMenuPresenterCallback(this), new MenuBuilderCallback(this));
            this.f11577d = true;
        }
        return this.f11574a.mo767s();
    }
}
