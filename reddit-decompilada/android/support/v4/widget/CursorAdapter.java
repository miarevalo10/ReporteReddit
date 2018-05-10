package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class CursorAdapter extends BaseAdapter implements CursorFilterClient, Filterable {
    protected boolean f11481a = false;
    protected boolean f11482b = true;
    protected Cursor f11483c = null;
    protected Context f11484d;
    protected int f11485e;
    protected ChangeObserver f11486f;
    protected DataSetObserver f11487g;
    protected CursorFilter f11488h;
    protected FilterQueryProvider f11489i;

    private class ChangeObserver extends ContentObserver {
        final /* synthetic */ CursorAdapter f1603a;

        public boolean deliverSelfNotifications() {
            return true;
        }

        ChangeObserver(CursorAdapter cursorAdapter) {
            this.f1603a = cursorAdapter;
            super(new Handler());
        }

        public void onChange(boolean z) {
            this.f1603a.m10180b();
        }
    }

    private class MyDataSetObserver extends DataSetObserver {
        final /* synthetic */ CursorAdapter f1604a;

        MyDataSetObserver(CursorAdapter cursorAdapter) {
            this.f1604a = cursorAdapter;
        }

        public void onChanged() {
            this.f1604a.f11481a = true;
            this.f1604a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.f1604a.f11481a = false;
            this.f1604a.notifyDataSetInvalidated();
        }
    }

    public abstract View mo3158a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void mo3852a(View view, Cursor cursor);

    public boolean hasStableIds() {
        return true;
    }

    public CursorAdapter(Context context) {
        this.f11484d = context;
        this.f11485e = -1;
        this.f11486f = new ChangeObserver(this);
        this.f11487g = new MyDataSetObserver(this);
    }

    public final Cursor mo383a() {
        return this.f11483c;
    }

    public int getCount() {
        return (!this.f11481a || this.f11483c == null) ? 0 : this.f11483c.getCount();
    }

    public Object getItem(int i) {
        if (!this.f11481a || this.f11483c == null) {
            return 0;
        }
        this.f11483c.moveToPosition(i);
        return this.f11483c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getItemId(int r4) {
        /*
        r3 = this;
        r0 = r3.f11481a;
        r1 = 0;
        if (r0 == 0) goto L_0x001c;
    L_0x0006:
        r0 = r3.f11483c;
        if (r0 == 0) goto L_0x001c;
    L_0x000a:
        r0 = r3.f11483c;
        r4 = r0.moveToPosition(r4);
        if (r4 == 0) goto L_0x001b;
    L_0x0012:
        r4 = r3.f11483c;
        r0 = r3.f11485e;
        r0 = r4.getLong(r0);
        return r0;
    L_0x001b:
        return r1;
    L_0x001c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.CursorAdapter.getItemId(int):long");
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f11481a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f11483c.moveToPosition(i)) {
            if (view == null) {
                view = mo3158a(this.f11484d, this.f11483c, viewGroup);
            }
            mo3852a(view, this.f11483c);
            return view;
        } else {
            viewGroup = new StringBuilder("couldn't move cursor to position ");
            viewGroup.append(i);
            throw new IllegalStateException(viewGroup.toString());
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f11481a) {
            return 0;
        }
        this.f11483c.moveToPosition(i);
        if (view == null) {
            view = mo3159b(this.f11484d, this.f11483c, viewGroup);
        }
        mo3852a(view, this.f11483c);
        return view;
    }

    public View mo3159b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo3158a(context, cursor, viewGroup);
    }

    public CharSequence mo386b(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor mo384a(CharSequence charSequence) {
        if (this.f11489i != null) {
            return this.f11489i.runQuery(charSequence);
        }
        return this.f11483c;
    }

    public Filter getFilter() {
        if (this.f11488h == null) {
            this.f11488h = new CursorFilter(this);
        }
        return this.f11488h;
    }

    protected final void m10180b() {
        if (this.f11482b && this.f11483c != null && !this.f11483c.isClosed()) {
            this.f11481a = this.f11483c.requery();
        }
    }

    public void mo385a(Cursor cursor) {
        if (cursor == this.f11483c) {
            cursor = null;
        } else {
            Cursor cursor2 = this.f11483c;
            if (cursor2 != null) {
                if (this.f11486f != null) {
                    cursor2.unregisterContentObserver(this.f11486f);
                }
                if (this.f11487g != null) {
                    cursor2.unregisterDataSetObserver(this.f11487g);
                }
            }
            this.f11483c = cursor;
            if (cursor != null) {
                if (this.f11486f != null) {
                    cursor.registerContentObserver(this.f11486f);
                }
                if (this.f11487g != null) {
                    cursor.registerDataSetObserver(this.f11487g);
                }
                this.f11485e = cursor.getColumnIndexOrThrow("_id");
                this.f11481a = true;
                notifyDataSetChanged();
            } else {
                this.f11485e = -1;
                this.f11481a = null;
                notifyDataSetInvalidated();
            }
            cursor = cursor2;
        }
        if (cursor != null) {
            cursor.close();
        }
    }
}
