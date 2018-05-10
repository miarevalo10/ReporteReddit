package com.reddit.frontpage.domain.usecase;

import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import io.reactivex.Maybe;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/DiffListingUseCase;", "Lcom/reddit/frontpage/domain/usecase/MaybeUseCase;", "Lcom/reddit/frontpage/domain/usecase/DiffListingResult;", "Lcom/reddit/frontpage/domain/usecase/DiffListingUseCaseParams;", "linkRepository", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "(Lcom/reddit/frontpage/domain/repository/LinkRepository;)V", "build", "Lio/reactivex/Maybe;", "params", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DiffListingUseCase.kt */
public final class DiffListingUseCase extends MaybeUseCase<DiffListingResult, DiffListingUseCaseParams> {
    private final LinkRepository f27977a;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20278a;

        static {
            int[] iArr = new int[ListingType.values().length];
            f20278a = iArr;
            iArr[ListingType.f20574a.ordinal()] = 1;
            f20278a[ListingType.f20575b.ordinal()] = 2;
            f20278a[ListingType.f20576c.ordinal()] = 3;
            f20278a[ListingType.f20577d.ordinal()] = 4;
        }
    }

    public final /* synthetic */ Maybe mo4761a(Params params) {
        DiffListingUseCase$build$fetch$2 diffListingUseCase$build$fetch$1;
        DiffListingUseCaseParams diffListingUseCaseParams = (DiffListingUseCaseParams) params;
        Intrinsics.m26847b(diffListingUseCaseParams, "params");
        switch (WhenMappings.f20278a[diffListingUseCaseParams.f27979b.ordinal()]) {
            case 1:
                diffListingUseCase$build$fetch$1 = new DiffListingUseCase$build$fetch$1(this.f27977a);
                break;
            case 2:
                diffListingUseCase$build$fetch$1 = new DiffListingUseCase$build$fetch$2(this.f27977a);
                break;
            case 3:
                throw ((Throwable) new UnsupportedOperationException("Diff on submitted posts currently not supported."));
            case 4:
                throw ((Throwable) new UnsupportedOperationException("Diff on history currently not supported."));
            default:
                throw new NoWhenBranchMatchedException();
        }
        Object map = ((Maybe) diffListingUseCase$build$fetch$1.mo6497a(diffListingUseCaseParams.f27980c, diffListingUseCaseParams.f27981d)).map(new DiffListingUseCase$build$1(diffListingUseCaseParams));
        Intrinsics.m26843a(map, "fetch(params.sort, param…lt)\n          )\n        }");
        return map;
    }

    @Inject
    public DiffListingUseCase(LinkRepository linkRepository) {
        Intrinsics.m26847b(linkRepository, "linkRepository");
        this.f27977a = linkRepository;
    }
}
