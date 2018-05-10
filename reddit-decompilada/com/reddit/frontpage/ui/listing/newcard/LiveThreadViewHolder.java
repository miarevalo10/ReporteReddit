package com.reddit.frontpage.ui.listing.newcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.listing.adapter.ListingViewHolder;

public class LiveThreadViewHolder extends ListingViewHolder {
    @BindView
    public TextView title;
    @BindView
    public TextView viewers;

    public final int mo6480Q() {
        return 1;
    }

    public static LiveThreadViewHolder m35128a(ViewGroup viewGroup) {
        return new LiveThreadViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_live_link, viewGroup, false));
    }

    private LiveThreadViewHolder(View view) {
        super(view);
        ButterKnife.a(this, view);
    }
}
