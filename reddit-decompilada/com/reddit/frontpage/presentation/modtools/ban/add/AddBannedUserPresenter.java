package com.reddit.frontpage.presentation.modtools.ban.add;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.modtools.ban.add.AddBannedUserContract.View;
import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.BanInfoModel;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/ban/add/AddBannedUserPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/modtools/ban/add/AddBannedUserContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/modtools/ban/add/AddBannedUserContract$View;", "repository", "Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "scheduler", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/modtools/ban/add/AddBannedUserContract$View;Lcom/reddit/frontpage/domain/repository/ModToolsRepository;Lcom/reddit/common/rx/PostExecutionThread;)V", "previouslyAttached", "", "getRepository", "()Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "getScheduler", "()Lcom/reddit/common/rx/PostExecutionThread;", "getView", "()Lcom/reddit/frontpage/presentation/modtools/ban/add/AddBannedUserContract$View;", "attach", "", "banUser", "banModel", "Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanInfoModel;", "getSubredditRules", "sendBanEvent", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AddBannedUserPresenter.kt */
public final class AddBannedUserPresenter extends DisposablePresenter {
    final View f34064a;
    private boolean f34065b;
    private final ModToolsRepository f34066c;
    private final PostExecutionThread f34067d;

    @Inject
    public AddBannedUserPresenter(View view, ModToolsRepository modToolsRepository, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(modToolsRepository, "repository");
        Intrinsics.m26847b(postExecutionThread, "scheduler");
        this.f34064a = view;
        this.f34066c = modToolsRepository;
        this.f34067d = postExecutionThread;
    }

    public final void m34797a(BanInfoModel banInfoModel) {
        Intrinsics.m26847b(banInfoModel, "banModel");
        Object subscribe = SinglesKt.m24094b(this.f34066c.m22441a(this.f34064a.mo7376a(), this.f34064a.mo7379b(), banInfoModel), this.f34067d).subscribe(new AddBannedUserPresenter$banUser$1(this, banInfoModel), (Consumer) new AddBannedUserPresenter$banUser$2(this));
        Intrinsics.m26843a(subscribe, "repository.banUser(view.…edMessage)\n            })");
        handleDispose(subscribe);
    }

    public final void attach() {
        if (!this.f34065b) {
            this.f34065b = true;
            Object subscribe = SinglesKt.m24094b(this.f34066c.m22437a(this.f34064a.mo7379b()), this.f34067d).subscribe(new AddBannedUserPresenter$getSubredditRules$1(this), new AddBannedUserPresenter$getSubredditRules$2(this));
            Intrinsics.m26843a(subscribe, "repository.getSubredditR…edMessage)\n            })");
            handleDispose(subscribe);
        }
    }

    public static final /* synthetic */ void m34796a(AddBannedUserPresenter addBannedUserPresenter) {
        if (addBannedUserPresenter.f34064a.mo7382d() != null) {
            Boolean valueOf;
            ModEventBuilder q;
            ModEventBuilder modEventBuilder;
            Link d;
            String id;
            Link d2;
            String name;
            Link d3;
            Object title;
            String c;
            Link d4 = addBannedUserPresenter.f34064a.mo7382d();
            if (d4 != null) {
                String id2 = d4.getId();
                if (id2 != null) {
                    valueOf = Boolean.valueOf(StringsKt__StringsJVMKt.m41943a((CharSequence) id2));
                    q = AppAnalytics.m21880q();
                    if (!(valueOf == null || valueOf.booleanValue())) {
                        modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) q.m21888a(ModEventBuilder.f27452c)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20039K.f20068M)).m21889a(addBannedUserPresenter.f34064a.mo7376a(), addBannedUserPresenter.f34064a.mo7379b());
                        d = addBannedUserPresenter.f34064a.mo7382d();
                        if (d == null) {
                            Intrinsics.m26842a();
                        }
                        id = d.getId();
                        d2 = addBannedUserPresenter.f34064a.mo7382d();
                        if (d2 == null) {
                            Intrinsics.m26842a();
                        }
                        name = AppAnalytics.m21848a(d2.getListableType()).name();
                        d3 = addBannedUserPresenter.f34064a.mo7382d();
                        if (d3 == null) {
                            Intrinsics.m26842a();
                        }
                        title = d3.getTitle();
                        Intrinsics.m26843a(title, "view.link!!.title");
                        modEventBuilder.m21890a(id, name, title);
                    }
                    if (!StringsKt__StringsJVMKt.m41943a((CharSequence) addBannedUserPresenter.f34064a.mo7381c())) {
                        c = addBannedUserPresenter.f34064a.mo7381c();
                        addBannedUserPresenter = addBannedUserPresenter.f34064a.mo7382d();
                        if (addBannedUserPresenter == null) {
                            Intrinsics.m26842a();
                        }
                        q.m21893b(c, addBannedUserPresenter.getId());
                    }
                    if (valueOf != null && valueOf.booleanValue() == null) {
                        q.m21891a();
                    }
                    q.m21891a();
                }
            }
            valueOf = null;
            q = AppAnalytics.m21880q();
            modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) q.m21888a(ModEventBuilder.f27452c)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20039K.f20068M)).m21889a(addBannedUserPresenter.f34064a.mo7376a(), addBannedUserPresenter.f34064a.mo7379b());
            d = addBannedUserPresenter.f34064a.mo7382d();
            if (d == null) {
                Intrinsics.m26842a();
            }
            id = d.getId();
            d2 = addBannedUserPresenter.f34064a.mo7382d();
            if (d2 == null) {
                Intrinsics.m26842a();
            }
            name = AppAnalytics.m21848a(d2.getListableType()).name();
            d3 = addBannedUserPresenter.f34064a.mo7382d();
            if (d3 == null) {
                Intrinsics.m26842a();
            }
            title = d3.getTitle();
            Intrinsics.m26843a(title, "view.link!!.title");
            modEventBuilder.m21890a(id, name, title);
            if (StringsKt__StringsJVMKt.m41943a((CharSequence) addBannedUserPresenter.f34064a.mo7381c())) {
                c = addBannedUserPresenter.f34064a.mo7381c();
                addBannedUserPresenter = addBannedUserPresenter.f34064a.mo7382d();
                if (addBannedUserPresenter == null) {
                    Intrinsics.m26842a();
                }
                q.m21893b(c, addBannedUserPresenter.getId());
            }
            q.m21891a();
            q.m21891a();
        }
    }
}
