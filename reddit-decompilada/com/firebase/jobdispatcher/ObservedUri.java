package com.firebase.jobdispatcher;

import android.net.Uri;

public final class ObservedUri {
    final Uri f3875a;
    final int f3876b;

    public ObservedUri(Uri uri, int i) {
        if (uri == null) {
            throw new IllegalArgumentException("URI must not be null.");
        }
        this.f3875a = uri;
        this.f3876b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ObservedUri)) {
            return false;
        }
        ObservedUri observedUri = (ObservedUri) obj;
        return this.f3876b == observedUri.f3876b && this.f3875a.equals(observedUri.f3875a) != null;
    }

    public final int hashCode() {
        return this.f3875a.hashCode() ^ this.f3876b;
    }
}
