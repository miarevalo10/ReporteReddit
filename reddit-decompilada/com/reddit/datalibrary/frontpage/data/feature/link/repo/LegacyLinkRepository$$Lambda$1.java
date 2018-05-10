package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import bolts.Continuation;
import bolts.Task;
import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallback;

final /* synthetic */ class LegacyLinkRepository$$Lambda$1 implements Continuation {
    private final Task f16061a;
    private final AsyncCallback f16062b;

    LegacyLinkRepository$$Lambda$1(Task task, AsyncCallback asyncCallback) {
        this.f16061a = task;
        this.f16062b = asyncCallback;
    }

    public final Object mo769a(Task task) {
        return LegacyLinkRepository.m8986a(this.f16061a, this.f16062b, task);
    }
}
