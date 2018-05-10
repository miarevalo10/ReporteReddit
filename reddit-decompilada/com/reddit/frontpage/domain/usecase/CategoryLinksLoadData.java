package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.repository.CategoryRepository;
import com.reddit.frontpage.domain.repository.LinkRepository;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002&\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0002\u0012\u0004\u0012\u00020\u00070\u0001B\u0017\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ.\u0010\r\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/CategoryLinksLoadData;", "Lcom/reddit/frontpage/domain/usecase/SingleUseCase;", "Lkotlin/Pair;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "Lcom/reddit/frontpage/domain/usecase/CategoryLinksLoadDataParams;", "categoryRepository", "Lcom/reddit/frontpage/domain/repository/CategoryRepository;", "linkRepository", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "(Lcom/reddit/frontpage/domain/repository/CategoryRepository;Lcom/reddit/frontpage/domain/repository/LinkRepository;)V", "build", "Lio/reactivex/Single;", "params", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CategoryLinksLoadData.kt */
public final class CategoryLinksLoadData extends SingleUseCase<Pair<? extends List<? extends Subreddit>, ? extends Listing<? extends Link>>, CategoryLinksLoadDataParams> {
    private final CategoryRepository f27970a;
    private final LinkRepository f27971b;

    public final /* synthetic */ Single mo4760a(Params params) {
        CategoryLinksLoadDataParams categoryLinksLoadDataParams = (CategoryLinksLoadDataParams) params;
        Intrinsics.m26847b(categoryLinksLoadDataParams, "params");
        Object flatMap = this.f27970a.m22405a(categoryLinksLoadDataParams.f27972a).flatMap(new CategoryLinksLoadData$build$1(this, categoryLinksLoadDataParams));
        Intrinsics.m26843a(flatMap, "categoryRepository.getSu… to listing }\n          }");
        return flatMap;
    }

    @Inject
    public CategoryLinksLoadData(CategoryRepository categoryRepository, LinkRepository linkRepository) {
        Intrinsics.m26847b(categoryRepository, "categoryRepository");
        Intrinsics.m26847b(linkRepository, "linkRepository");
        this.f27970a = categoryRepository;
        this.f27971b = linkRepository;
    }
}
