package com.reddit.frontpage.ui.submit.location;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.foursquare.model.LocationDistance;
import com.reddit.frontpage.util.Util;
import java.util.ArrayList;
import java.util.List;

public class LocationDataAdapter extends Adapter<LocationViewHolder> {
    List<LocationDistance> f29347a = new ArrayList();
    final LocationSearchScreen f29348b;

    public final /* synthetic */ void m30409a(ViewHolder viewHolder, int i) {
        LocationViewHolder locationViewHolder = (LocationViewHolder) viewHolder;
        LocationDistance locationDistance = (LocationDistance) this.f29347a.get(i);
        locationViewHolder.location.setText(locationDistance.f20304a);
        if (locationDistance.f20307d == 1.0d) {
            locationViewHolder.distance.setText(Util.m23960a((int) C1761R.string.fmt_location_distance_one, Double.valueOf(locationDistance.f20307d)));
            locationViewHolder.distance.setVisibility(0);
        } else if (locationDistance.f20307d >= 0.1d) {
            locationViewHolder.distance.setText(Util.m23960a((int) C1761R.string.fmt_location_distance, Double.valueOf(locationDistance.f20307d)));
            locationViewHolder.distance.setVisibility(0);
        } else if (locationDistance.f20307d > 0.0d) {
            locationViewHolder.distance.setText(Util.m23960a((int) C1761R.string.fmt_location_distance_small, Double.valueOf(locationDistance.f20307d)));
            locationViewHolder.distance.setVisibility(0);
        } else {
            locationViewHolder.distance.setVisibility(8);
        }
        locationViewHolder.c.setOnClickListener(new LocationDataAdapter$$Lambda$0(this, locationDistance));
    }

    LocationDataAdapter(LocationSearchScreen locationSearchScreen) {
        this.f29348b = locationSearchScreen;
    }

    public final int m30407a() {
        return this.f29347a.size();
    }

    public final /* synthetic */ ViewHolder m30408a(ViewGroup viewGroup, int i) {
        return new LocationViewHolder(LayoutInflater.from(this.f29348b.am_()).inflate(C1761R.layout.listitem_location, viewGroup, false));
    }
}
