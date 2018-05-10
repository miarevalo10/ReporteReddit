package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import bolts.Continuation;
import bolts.Task;
import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallback;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentResponse;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;

public final /* synthetic */ class LegacyLinkRepository$$Lambda$15 implements Continuation {
    private final LegacyLinkRepository f16056a;
    private final AsyncCallback f16057b;
    private final Task f16058c;
    private final Task f16059d;

    public LegacyLinkRepository$$Lambda$15(LegacyLinkRepository legacyLinkRepository, AsyncCallback asyncCallback, Task task, Task task2) {
        this.f16056a = legacyLinkRepository;
        this.f16057b = asyncCallback;
        this.f16058c = task;
        this.f16059d = task2;
    }

    public final Object mo769a(Task task) {
        LegacyLinkRepository legacyLinkRepository = this.f16056a;
        AsyncCallback asyncCallback = this.f16057b;
        Task task2 = this.f16058c;
        Task task3 = this.f16059d;
        if (task.m2419d()) {
            asyncCallback.mo3013a(task.m2421f());
        }
        Object obj = (CommentResponse) task2.m2420e();
        ClientLink clientLink = (ClientLink) obj.link;
        Link link = (ClientLink) task3.m2420e();
        if (link != null) {
            link.updateServerProperties(clientLink);
            legacyLinkRepository.m8990a(link);
            obj.link = link;
        }
        asyncCallback.mo3014a(obj);
        return null;
    }
}
