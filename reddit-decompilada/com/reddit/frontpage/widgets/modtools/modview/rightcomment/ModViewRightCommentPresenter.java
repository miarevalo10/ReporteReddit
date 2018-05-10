package com.reddit.frontpage.widgets.modtools.modview.rightcomment;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.DistinguishType;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.util.ModCacheComments;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import com.reddit.frontpage.widgets.modtools.modview.rightcomment.ModQueueRightCommentContract.View;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/widgets/modtools/modview/rightcomment/ModViewRightCommentPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/widgets/modtools/modview/rightcomment/ModQueueRightCommentContract$Presenter;", "repository", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "view", "Lcom/reddit/frontpage/widgets/modtools/modview/rightcomment/ModQueueRightCommentContract$View;", "scheduler", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/domain/repository/LinkRepository;Lcom/reddit/frontpage/widgets/modtools/modview/rightcomment/ModQueueRightCommentContract$View;Lcom/reddit/common/rx/PostExecutionThread;)V", "modCache", "Lcom/reddit/frontpage/util/ModCacheComments;", "getModCache", "()Lcom/reddit/frontpage/util/ModCacheComments;", "setModCache", "(Lcom/reddit/frontpage/util/ModCacheComments;)V", "getRepository", "()Lcom/reddit/frontpage/domain/repository/LinkRepository;", "getScheduler", "()Lcom/reddit/common/rx/PostExecutionThread;", "getView", "()Lcom/reddit/frontpage/widgets/modtools/modview/rightcomment/ModQueueRightCommentContract$View;", "attach", "", "distinguish", "id", "", "how", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/remote/DistinguishType;", "sticky", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModViewRightCommentPresenter.kt */
public final class ModViewRightCommentPresenter extends DisposablePresenter {
    public ModCacheComments f34547a;
    final View f34548b;
    private final LinkRepository f34549c;
    private final PostExecutionThread f34550d;

    public final void attach() {
    }

    @Inject
    public ModViewRightCommentPresenter(LinkRepository linkRepository, View view, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(linkRepository, "repository");
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(postExecutionThread, "scheduler");
        this.f34549c = linkRepository;
        this.f34548b = view;
        this.f34550d = postExecutionThread;
    }

    public final ModCacheComments m35323a() {
        ModCacheComments modCacheComments = this.f34547a;
        if (modCacheComments == null) {
            Intrinsics.m26844a("modCache");
        }
        return modCacheComments;
    }

    public final void m35324a(String str, DistinguishType distinguishType, boolean z) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(distinguishType, "how");
        CompletablesKt.m24074b(this.f34549c.m22411a(str, distinguishType, z), this.f34550d).subscribe(new ModViewRightCommentPresenter$distinguish$1(this, distinguishType, str, z), (Consumer) new ModViewRightCommentPresenter$distinguish$2(this));
    }
}
