package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import android.support.v4.util.LongSparseArray;
import bolts.Continuation;
import bolts.Task;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import java.util.List;

final /* synthetic */ class LegacyLinkRepository$$Lambda$19 implements Continuation {
    private final LegacyLinkRepository f16060a;

    LegacyLinkRepository$$Lambda$19(LegacyLinkRepository legacyLinkRepository) {
        this.f16060a = legacyLinkRepository;
    }

    public final Object mo769a(Task task) {
        LegacyLinkRepository legacyLinkRepository = this.f16060a;
        if (task.m2419d()) {
            throw task.m2421f();
        }
        Listing<Listable> listing = (Listing) task.m2420e();
        List<ClientLink> a = legacyLinkRepository.f10705b.mo2931a((Listing) listing);
        if (!a.isEmpty()) {
            ClientLink clientLink;
            LongSparseArray longSparseArray = new LongSparseArray(a.size());
            for (ClientLink clientLink2 : a) {
                longSparseArray.m1017a(clientLink2.getDatabaseId(), clientLink2);
            }
            for (Listable listable : listing) {
                if (listable instanceof ClientLink) {
                    clientLink2 = (ClientLink) listable;
                    ClientLink clientLink3 = (ClientLink) longSparseArray.m1015a(clientLink2.getDatabaseId());
                    if (clientLink3 != null) {
                        clientLink2.updateClientProperties(clientLink3);
                    }
                }
            }
        }
        return listing;
    }
}
