package com.reddit.frontpage.video.mpdparser.core.mapper;

import com.danikula.videocache.HttpProxyCacheServer;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.video.mpdparser.data.model.AdaptationSet;
import com.reddit.frontpage.video.mpdparser.data.model.DashManifest;
import com.reddit.frontpage.video.mpdparser.data.model.Representation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Regex;
import net.hockeyapp.android.UpdateFragment;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/video/mpdparser/core/mapper/LocalUrlMPDMapper;", "Lcom/reddit/frontpage/video/mpdparser/core/mapper/MPDMapper;", "()V", "videoCache", "Lcom/danikula/videocache/HttpProxyCacheServer;", "getVideoCache", "()Lcom/danikula/videocache/HttpProxyCacheServer;", "setVideoCache", "(Lcom/danikula/videocache/HttpProxyCacheServer;)V", "createLocalUrl", "", "url", "format", "increment", "", "map", "", "dashManifest", "Lcom/reddit/frontpage/video/mpdparser/data/model/DashManifest;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LocalUrlMPDMapper.kt */
public final class LocalUrlMPDMapper {
    @Inject
    public HttpProxyCacheServer f21840a;

    public LocalUrlMPDMapper() {
        FrontpageApplication.m28870f().mo4698a(this);
    }

    public final Map<String, String> m24116a(DashManifest dashManifest) {
        Intrinsics.m26847b(dashManifest, "dashManifest");
        Map<String, String> linkedHashMap = new LinkedHashMap();
        Iterable b = RangesKt___RangesKt.m32854b(0, dashManifest.mo5048a());
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b));
        Iterator it = b.iterator();
        while (it.hasNext()) {
            arrayList.add(dashManifest.mo5049a(((IntIterator) it).mo6663a()).mo5050a());
        }
        for (List<AdaptationSet> list : (List) arrayList) {
            if (list != null) {
                for (AdaptationSet a : list) {
                    List<Representation> a2 = a.mo5047a();
                    if (a2 != null) {
                        for (Representation representation : a2) {
                            LocalUrlMPDMapper localUrlMPDMapper = this;
                            List b2 = new Regex(Operation.DIVISION).m28149b(representation.mo5051a().mo5046a());
                            Object obj = b2.size() == 2 ? (String) b2.get(1) : "";
                            String b3 = representation.mo5052b();
                            String b4 = representation.mo5052b();
                            Intrinsics.m26847b(b4, UpdateFragment.FRAGMENT_URL);
                            Intrinsics.m26847b(obj, "format");
                            HttpProxyCacheServer httpProxyCacheServer = localUrlMPDMapper.f21840a;
                            if (httpProxyCacheServer == null) {
                                Intrinsics.m26844a("videoCache");
                            }
                            Object a3 = httpProxyCacheServer.a(b4, false);
                            if (a3 == null) {
                                a3 = "";
                            }
                            linkedHashMap.put(b3, a3);
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }
}
