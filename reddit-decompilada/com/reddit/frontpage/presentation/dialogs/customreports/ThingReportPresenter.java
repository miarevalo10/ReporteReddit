package com.reddit.frontpage.presentation.dialogs.customreports;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.dialogs.customreports.ThingReportContract.Presenter;
import com.reddit.frontpage.presentation.dialogs.customreports.ThingReportContract.View;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J0\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00182\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010!H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/reddit/frontpage/presentation/dialogs/customreports/ThingReportPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/dialogs/customreports/ThingReportContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/dialogs/customreports/ThingReportContract$View;", "scheduler", "Lcom/reddit/common/rx/PostExecutionThread;", "repository", "Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "accountRepository", "Lcom/reddit/frontpage/domain/repository/AccountRepository;", "(Lcom/reddit/frontpage/presentation/dialogs/customreports/ThingReportContract$View;Lcom/reddit/common/rx/PostExecutionThread;Lcom/reddit/frontpage/domain/repository/ModToolsRepository;Lcom/reddit/frontpage/domain/repository/AccountRepository;)V", "getAccountRepository", "()Lcom/reddit/frontpage/domain/repository/AccountRepository;", "getRepository", "()Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "getScheduler", "()Lcom/reddit/common/rx/PostExecutionThread;", "getView", "()Lcom/reddit/frontpage/presentation/dialogs/customreports/ThingReportContract$View;", "attach", "", "blockUser", "userId", "", "username", "findAndBlockUser", "reportLink", "thing", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "reason", "siteReason", "onLinkReported", "Lkotlin/Function0;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ThingReportPresenter.kt */
public final class ThingReportPresenter extends DisposablePresenter implements Presenter {
    final View f33848a;
    public final PostExecutionThread f33849b;
    public final ModToolsRepository f33850c;
    private final AccountRepository f33851d;

    public final void attach() {
    }

    @Inject
    public ThingReportPresenter(View view, PostExecutionThread postExecutionThread, ModToolsRepository modToolsRepository, AccountRepository accountRepository) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(postExecutionThread, "scheduler");
        Intrinsics.m26847b(modToolsRepository, "repository");
        Intrinsics.m26847b(accountRepository, "accountRepository");
        this.f33848a = view;
        this.f33849b = postExecutionThread;
        this.f33850c = modToolsRepository;
        this.f33851d = accountRepository;
    }

    public final void m34667a(String str) {
        Intrinsics.m26847b(str, "username");
        SinglesKt.m24094b(this.f33851d.m22394a(str), this.f33849b).subscribe(new ThingReportPresenter$findAndBlockUser$1(this, str), (Consumer) new ThingReportPresenter$findAndBlockUser$2(this));
    }
}
