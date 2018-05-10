package com.reddit.frontpage.ui.listing;

import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsScreen;
import com.reddit.frontpage.ui.listener.ModQueueCheckListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/reddit/frontpage/ui/listing/ModQueueListingScreen$onCreateView$2", "Lcom/reddit/frontpage/ui/listener/ModQueueCheckListener;", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "(Lcom/reddit/frontpage/ui/listing/ModQueueListingScreen;)V", "onChecked", "", "thing", "linkType", "", "onUncheck", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModQueueListingScreen.kt */
public final class ModQueueListingScreen$onCreateView$2 implements ModQueueCheckListener<Thing> {
    final /* synthetic */ ModQueueListingScreen f29061a;

    ModQueueListingScreen$onCreateView$2(ModQueueListingScreen modQueueListingScreen) {
        this.f29061a = modQueueListingScreen;
    }

    public final /* synthetic */ void mo4986a(Object obj) {
        Thing thing = (Thing) obj;
        Intrinsics.m26847b(thing, "thing");
        ModQueueOptionsScreen b = this.f29061a.as();
        if (b != null) {
            Intrinsics.m26847b(thing, "thing");
            b.f28614b.remove(thing);
            b.f28615c.remove(thing);
            if (b.f28614b.size() == null) {
                b.f28618f.onNext(Integer.valueOf(0));
            }
            b.m29770a();
        }
    }

    public final /* synthetic */ void mo4987a(Object obj, String str) {
        Thing thing = (Thing) obj;
        Intrinsics.m26847b(thing, "thing");
        Intrinsics.m26847b(str, "linkType");
        ModQueueOptionsScreen b = this.f29061a.as();
        if (b != null) {
            Intrinsics.m26847b(thing, "thing");
            Intrinsics.m26847b(str, "linkType");
            b.f28614b.add(thing);
            b.f28615c.put(thing, str);
            if (b.f28614b.size() == 1) {
                b.f28618f.onNext(Integer.valueOf(1));
            }
            b.m29770a();
        }
    }
}
