package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int f16535j;
    private int f16536k;
    private LayoutInflater f16537l;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i) {
        super(context);
        this.f16536k = i;
        this.f16535j = i;
        this.f16537l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View mo3158a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f16537l.inflate(this.f16535j, viewGroup, false);
    }

    public final View mo3159b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f16537l.inflate(this.f16536k, viewGroup, false);
    }
}
