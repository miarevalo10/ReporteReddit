package com.reddit.datalibrary.frontpage.data.provider;

import com.android.volley.VolleyError;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.ListingModel;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.frontpage.util.ModUtil;
import de.greenrobot.event.EventBus;

public abstract class BaseListingProvider2<T> extends BaseOtherProvider {
    boolean f16219a;
    @State(ParcelerBundler.class)
    public Listing<T> listing;

    @Deprecated
    public BaseEvent mo3795a(Exception exception) {
        return null;
    }

    @Deprecated
    public abstract BaseEvent mo3796a(boolean z);

    public abstract void mo3798c(boolean z, String str);

    public void mo3799d(boolean z, String str) {
    }

    protected BaseListingProvider2() {
    }

    protected BaseListingProvider2(String str) {
        super(str);
    }

    public final void m16197a(boolean z, String str) {
        m16190b(z);
        mo3798c(z, str);
    }

    public final void m16199b(boolean z, String str) {
        m16190b(z);
        mo3799d(z, str);
    }

    private void m16190b(boolean z) {
        if (this.listing != null && !z) {
            m16191c(z);
        } else if (!this.f16219a) {
            if (!(this.listing && this.listing.size())) {
                ModUtil.d();
            }
            this.f16219a = true;
        }
    }

    public final void m16196a(String str) {
        m16199b(true, str);
    }

    public final void m16198b(String str) {
        if (!this.f16219a) {
            this.f16219a = true;
            mo3798c(false, str);
        }
    }

    public final void m16200c(String str) {
        if (!this.f16219a) {
            this.f16219a = true;
            mo3799d(false, str);
        }
    }

    public final void m16195a(Listing<? extends T> listing, boolean z) {
        if (this.listing != null) {
            if (!z) {
                Listing<? extends T> copy = this.listing.copy();
                copy.add(listing);
                if (!((this.listing instanceof ListingModel) == null || (copy instanceof ListingModel) == null)) {
                    ((ListingModel) copy).setVideoLinks(((ListingModel) this.listing).getVideoLinks());
                }
                this.listing = copy;
                m16191c(z);
                this.f16219a = null;
            }
        }
        this.listing = listing;
        m16191c(z);
        this.f16219a = null;
    }

    public void mo3797a(VolleyError volleyError) {
        this.f16219a = false;
        volleyError = mo3795a((Exception) volleyError);
        if (volleyError != null) {
            EventBus.getDefault().post(volleyError);
        }
    }

    private void m16191c(boolean z) {
        EventBus.getDefault().post(mo3796a(z));
    }
}
