package com.reddit.frontpage.presentation.subreddit.rules.presenter;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.subreddit.rules.SubredditRulesContract.Parameters;
import com.reddit.frontpage.presentation.subreddit.rules.SubredditRulesContract.View;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/presentation/subreddit/rules/presenter/SubredditRulesPresenter;", "Lcom/reddit/frontpage/presentation/subreddit/rules/SubredditRulesContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "view", "Lcom/reddit/frontpage/presentation/subreddit/rules/SubredditRulesContract$View;", "parameters", "Lcom/reddit/frontpage/presentation/subreddit/rules/SubredditRulesContract$Parameters;", "subredditRepository", "Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "modToolsRepository", "Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/subreddit/rules/SubredditRulesContract$View;Lcom/reddit/frontpage/presentation/subreddit/rules/SubredditRulesContract$Parameters;Lcom/reddit/frontpage/domain/repository/SubredditRepository;Lcom/reddit/frontpage/domain/repository/ModToolsRepository;Lcom/reddit/common/rx/PostExecutionThread;)V", "attach", "", "loadSubredditDescription", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditRulesPresenter.kt */
public final class SubredditRulesPresenter extends DisposablePresenter {
    private final View f34173a;
    private final Parameters f34174b;
    private final SubredditRepository f34175c;
    private final ModToolsRepository f34176d;
    private final PostExecutionThread f34177e;

    @Inject
    public SubredditRulesPresenter(View view, Parameters parameters, SubredditRepository subredditRepository, ModToolsRepository modToolsRepository, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(parameters, "parameters");
        Intrinsics.m26847b(subredditRepository, "subredditRepository");
        Intrinsics.m26847b(modToolsRepository, "modToolsRepository");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        this.f34173a = view;
        this.f34174b = parameters;
        this.f34175c = subredditRepository;
        this.f34176d = modToolsRepository;
        this.f34177e = postExecutionThread;
    }

    public final void attach() {
        this.f34173a.mo7189c();
        Object subscribe = SinglesKt.m24094b(this.f34176d.m22437a(this.f34174b.f20974a), this.f34177e).map(SubredditRulesPresenter$attach$1.f28791a).subscribe(new SubredditRulesPresenter$attach$2(this), new SubredditRulesPresenter$attach$3(this));
        Intrinsics.m26843a(subscribe, "modToolsRepository.getSu…LoadRules()\n            }");
        handleDispose(subscribe);
    }

    public final void m34877a() {
        Object map = this.f34175c.m22493a(this.f34174b.f20974a).map(SubredditRulesPresenter$loadSubredditDescription$1.f28794a);
        Intrinsics.m26843a(map, "subredditRepository.getS…ap { it.descriptionHtml }");
        map = SinglesKt.m24094b(map, this.f34177e).doAfterTerminate(new SubredditRulesPresenter$loadSubredditDescription$2(this)).subscribe(new SubredditRulesPresenter$loadSubredditDescription$3(this), new SubredditRulesPresenter$loadSubredditDescription$4(this));
        Intrinsics.m26843a(map, "subredditRepository.getS…notifyUnableLoadRules() }");
        handleDispose(map);
    }
}
