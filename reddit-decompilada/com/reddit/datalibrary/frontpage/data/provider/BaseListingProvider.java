package com.reddit.datalibrary.frontpage.data.provider;

import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.requests.models.v1.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.SerializableBundler;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;

@Deprecated
public abstract class BaseListingProvider<T, L extends Listing> extends BaseOtherProvider {
    boolean f16220a;
    BaseEvent f16221b;
    @State
    public String mAfter;
    @State(SerializableBundler.class)
    public ArrayList<T> mObjects = null;

    public abstract BaseEvent mo3788a();

    public BaseEvent mo3789a(Exception exception) {
        return null;
    }

    public abstract void mo3790b(boolean z, String str);

    public final void m16208a(boolean z, String str) {
        if (this.mObjects != null && !z) {
            m16209b();
        } else if (!this.f16220a) {
            this.f16220a = true;
            mo3790b(z, str);
        }
    }

    public final void m16207a(String str) {
        if (!this.f16220a) {
            this.f16220a = true;
            mo3790b(false, str);
        }
    }

    public void mo3801a(L l, boolean z) {
        if (this.mObjects == null || z) {
            this.mObjects = new ArrayList();
        }
        this.mObjects.addAll(l.mo3815a().mo3049b());
        this.mAfter = l.mo3815a().mo3048a();
        m16209b();
        this.f16220a = null;
    }

    public final void m16209b() {
        if (this.f16221b != null) {
            EventBus.getDefault().removeStickyEvent(this.f16221b);
        }
        this.f16221b = mo3788a();
        EventBus.getDefault().postSticky(this.f16221b);
    }

    public int mo3802c() {
        if (this.mObjects == null) {
            return -1;
        }
        return this.mObjects.size();
    }

    public T mo3800a(int i) {
        return this.mObjects.get(i);
    }

    public boolean mo4205d() {
        return this.mAfter != null;
    }

    public void finish() {
        if (this.f16221b != null) {
            EventBus.getDefault().removeStickyEvent(this.f16221b);
        }
    }
}
