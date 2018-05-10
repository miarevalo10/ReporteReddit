package com.reddit.frontpage.ui.submit.location;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationViewHolder extends ViewHolder {
    @BindView
    TextView distance;
    @BindView
    TextView location;

    LocationViewHolder(View view) {
        super(view);
        ButterKnife.a(this, view);
    }
}
