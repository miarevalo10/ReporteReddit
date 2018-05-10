package android.support.v7.preference;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.View;

public class PreferenceViewHolder extends ViewHolder {
    boolean f11653a;
    boolean f11654b;
    private final SparseArray<View> f11655p = new SparseArray(4);

    PreferenceViewHolder(View view) {
        super(view);
        this.f11655p.put(16908310, view.findViewById(16908310));
        this.f11655p.put(16908304, view.findViewById(16908304));
        this.f11655p.put(16908294, view.findViewById(16908294));
        this.f11655p.put(C0177R.id.icon_frame, view.findViewById(C0177R.id.icon_frame));
        this.f11655p.put(16908350, view.findViewById(16908350));
    }

    public final View m10369a(int i) {
        View view = (View) this.f11655p.get(i);
        if (view != null) {
            return view;
        }
        view = this.c.findViewById(i);
        if (view != null) {
            this.f11655p.put(i, view);
        }
        return view;
    }
}
