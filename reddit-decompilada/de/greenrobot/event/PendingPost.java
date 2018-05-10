package de.greenrobot.event;

import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.util.ArrayList;
import java.util.List;

final class PendingPost {
    private static final List<PendingPost> f24351d = new ArrayList();
    Object f24352a;
    Subscription f24353b;
    PendingPost f24354c;

    private PendingPost(Object obj, Subscription subscription) {
        this.f24352a = obj;
        this.f24353b = subscription;
    }

    static PendingPost m26014a(Subscription subscription, Object obj) {
        synchronized (f24351d) {
            int size = f24351d.size();
            if (size > 0) {
                PendingPost pendingPost = (PendingPost) f24351d.remove(size - 1);
                pendingPost.f24352a = obj;
                pendingPost.f24353b = subscription;
                pendingPost.f24354c = null;
                return pendingPost;
            }
            return new PendingPost(obj, subscription);
        }
    }

    static void m26015a(PendingPost pendingPost) {
        pendingPost.f24352a = null;
        pendingPost.f24353b = null;
        pendingPost.f24354c = null;
        synchronized (f24351d) {
            if (f24351d.size() < AbstractSpiCall.DEFAULT_TIMEOUT) {
                f24351d.add(pendingPost);
            }
        }
    }
}
