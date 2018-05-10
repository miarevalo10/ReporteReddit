package com.bumptech.glide.manager;

import com.bumptech.glide.request.Request;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker {
    public final Set<Request> f3595a = Collections.newSetFromMap(new WeakHashMap());
    public final List<Request> f3596b = new ArrayList();
    public boolean f3597c;

    public final boolean m3102a(Request request, boolean z) {
        boolean z2 = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.f3595a.remove(request);
        if (!this.f3596b.remove(request)) {
            if (!remove) {
                z2 = false;
            }
        }
        if (z2) {
            request.clear();
            if (z) {
                request.recycle();
            }
        }
        return z2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("{numRequests=");
        stringBuilder.append(this.f3595a.size());
        stringBuilder.append(", isPaused=");
        stringBuilder.append(this.f3597c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
