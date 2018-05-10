package com.reddit.frontpage.ui.submit.location;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class LocationViewHolder_ViewBinding implements Unbinder {
    private LocationViewHolder f29353b;

    public LocationViewHolder_ViewBinding(LocationViewHolder locationViewHolder, View view) {
        this.f29353b = locationViewHolder;
        locationViewHolder.location = (TextView) Utils.b(view, C1761R.id.location_name, "field 'location'", TextView.class);
        locationViewHolder.distance = (TextView) Utils.b(view, C1761R.id.location_distance, "field 'distance'", TextView.class);
    }

    public final void m30412a() {
        LocationViewHolder locationViewHolder = this.f29353b;
        if (locationViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29353b = null;
        locationViewHolder.location = null;
        locationViewHolder.distance = null;
    }
}
