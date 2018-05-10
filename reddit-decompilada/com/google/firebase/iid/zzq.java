package com.google.firebase.iid;

import android.os.Bundle;

public final class zzq extends zzr<Void> {
    public zzq(int i, Bundle bundle) {
        super(i, 2, bundle);
    }

    final void mo2453a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            m7398a(null);
        } else {
            m7397a(new zzs(4, "Invalid response to one way request"));
        }
    }

    final boolean mo2454a() {
        return true;
    }
}
