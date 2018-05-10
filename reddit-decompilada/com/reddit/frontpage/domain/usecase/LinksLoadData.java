package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.util.AccountPrefsUtil;
import com.reddit.frontpage.util.SessionUtil;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0014J$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/LinksLoadData;", "Lcom/reddit/frontpage/domain/usecase/SingleUseCase;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "Lcom/reddit/frontpage/domain/usecase/LinksLoadDataParams;", "linkRepository", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "(Lcom/reddit/frontpage/domain/repository/LinkRepository;)V", "areLinksOfCurrentUser", "", "username", "", "build", "Lio/reactivex/Single;", "params", "filterLinks", "", "links", "showNsfwLinks", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinksLoadData.kt */
public final class LinksLoadData extends SingleUseCase<Listing<? extends Link>, LinksLoadDataParams> {
    private final LinkRepository f28016a;

    public final /* synthetic */ Single mo4760a(Params params) {
        LinksLoadDataParams linksLoadDataParams = (LinksLoadDataParams) params;
        Intrinsics.m26847b(linksLoadDataParams, "params");
        Object map = this.f28016a.m22417a(linksLoadDataParams.f28017a, linksLoadDataParams.f28018b).map(new LinksLoadData$build$1(this, linksLoadDataParams));
        Intrinsics.m26843a(map, "linkRepository.getSubmit…nce\n          )\n        }");
        return map;
    }

    @Inject
    public LinksLoadData(LinkRepository linkRepository) {
        Intrinsics.m26847b(linkRepository, "linkRepository");
        this.f28016a = linkRepository;
    }

    public static final /* synthetic */ List m29330a(List list, String str) {
        Collection collection;
        Intrinsics.m26847b(str, "username");
        if (Intrinsics.m26845a(SessionUtil.m23899e(), (Object) str) == null) {
            if (AccountPrefsUtil.m23628a() == null) {
                str = null;
                if (str != null) {
                    return list;
                }
                collection = (Collection) new ArrayList();
                for (Object next : list) {
                    if ((((Link) next).getOver18() ^ 1) != 0) {
                        collection.add(next);
                    }
                }
                return (List) collection;
            }
        }
        str = 1;
        if (str != null) {
            return list;
        }
        collection = (Collection) new ArrayList();
        for (Object next2 : list) {
            if ((((Link) next2).getOver18() ^ 1) != 0) {
                collection.add(next2);
            }
        }
        return (List) collection;
    }
}
