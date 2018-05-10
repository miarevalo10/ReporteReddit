package android.support.v7.view;

import android.support.annotation.RequiresApi;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class WindowCallbackWrapper implements Callback {
    final Callback f2016e;

    public WindowCallbackWrapper(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f2016e = callback;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f2016e.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f2016e.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f2016e.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f2016e.dispatchTrackballEvent(motionEvent);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f2016e.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f2016e.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public View onCreatePanelView(int i) {
        return this.f2016e.onCreatePanelView(i);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f2016e.onCreatePanelMenu(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f2016e.onPreparePanel(i, view, menu);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.f2016e.onMenuOpened(i, menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f2016e.onMenuItemSelected(i, menuItem);
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        this.f2016e.onWindowAttributesChanged(layoutParams);
    }

    public void onContentChanged() {
        this.f2016e.onContentChanged();
    }

    public void onWindowFocusChanged(boolean z) {
        this.f2016e.onWindowFocusChanged(z);
    }

    public void onAttachedToWindow() {
        this.f2016e.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.f2016e.onDetachedFromWindow();
    }

    public void onPanelClosed(int i, Menu menu) {
        this.f2016e.onPanelClosed(i, menu);
    }

    @RequiresApi(23)
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f2016e.onSearchRequested(searchEvent);
    }

    public boolean onSearchRequested() {
        return this.f2016e.onSearchRequested();
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f2016e.onWindowStartingActionMode(callback);
    }

    @RequiresApi(23)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.f2016e.onWindowStartingActionMode(callback, i);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f2016e.onActionModeStarted(actionMode);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f2016e.onActionModeFinished(actionMode);
    }

    @RequiresApi(24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
        this.f2016e.onProvideKeyboardShortcuts(list, menu, i);
    }

    @RequiresApi(26)
    public void onPointerCaptureChanged(boolean z) {
        this.f2016e.onPointerCaptureChanged(z);
    }
}
