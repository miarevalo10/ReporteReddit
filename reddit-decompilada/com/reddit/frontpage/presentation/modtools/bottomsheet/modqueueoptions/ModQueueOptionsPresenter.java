package com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsContract.View;
import com.reddit.frontpage.presentation.modtools.util.ModQueueAction;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J2\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00160\"H\u0016J \u0010#\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u000bR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006)"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modqueueoptions/ModQueueOptionsPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modqueueoptions/ModQueueOptionsContract$Presenter;", "repository", "Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "view", "Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modqueueoptions/ModQueueOptionsContract$View;", "scheduler", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/domain/repository/ModToolsRepository;Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modqueueoptions/ModQueueOptionsContract$View;Lcom/reddit/common/rx/PostExecutionThread;)V", "moderateListener", "Lcom/reddit/frontpage/widgets/LinkFooterView$OnModActionCompletedListener;", "getRepository", "()Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "getScheduler", "()Lcom/reddit/common/rx/PostExecutionThread;", "getView", "()Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modqueueoptions/ModQueueOptionsContract$View;", "attach", "", "commentAnalytics", "noun", "", "uniqueId", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "linkType", "onActon", "action", "Lcom/reddit/frontpage/presentation/modtools/util/ModQueueAction;", "items", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "linkTypes", "", "postAnalytics", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/ClientLink;", "setOnOnModerateListener", "listener", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModQueueOptionsPresenter.kt */
public final class ModQueueOptionsPresenter extends DisposablePresenter {
    public static final String ACTION_APPROVE = "approve";
    public static final String ACTION_REMOVE = "remove";
    public static final String ACTION_SPAM = "spam";
    public static final Companion Companion = new Companion();
    private OnModActionCompletedListener moderateListener;
    private final ModToolsRepository repository;
    private final PostExecutionThread scheduler;
    private final View view;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modqueueoptions/ModQueueOptionsPresenter$Companion;", "", "()V", "ACTION_APPROVE", "", "ACTION_REMOVE", "ACTION_SPAM", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModQueueOptionsPresenter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20899a;

        static {
            int[] iArr = new int[ModQueueAction.values().length];
            f20899a = iArr;
            iArr[ModQueueAction.f20917a.ordinal()] = 1;
            f20899a[ModQueueAction.f20918b.ordinal()] = 2;
            f20899a[ModQueueAction.f20919c.ordinal()] = 3;
        }
    }

    public final void attach() {
    }

    public static final /* synthetic */ OnModActionCompletedListener access$getModerateListener$p(ModQueueOptionsPresenter modQueueOptionsPresenter) {
        modQueueOptionsPresenter = modQueueOptionsPresenter.moderateListener;
        if (modQueueOptionsPresenter == null) {
            Intrinsics.m26844a("moderateListener");
        }
        return modQueueOptionsPresenter;
    }

    public final ModToolsRepository getRepository() {
        return this.repository;
    }

    public final View getView() {
        return this.view;
    }

    public final PostExecutionThread getScheduler() {
        return this.scheduler;
    }

    @Inject
    public ModQueueOptionsPresenter(ModToolsRepository modToolsRepository, View view, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(modToolsRepository, "repository");
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(postExecutionThread, "scheduler");
        this.repository = modToolsRepository;
        this.view = view;
        this.scheduler = postExecutionThread;
    }

    public final void setOnOnModerateListener(OnModActionCompletedListener onModActionCompletedListener) {
        Intrinsics.m26847b(onModActionCompletedListener, "listener");
        this.moderateListener = onModActionCompletedListener;
    }

    public final void onActon(ModQueueAction modQueueAction, List<? extends Thing> list, Map<Thing, String> map) {
        Intrinsics.m26847b(modQueueAction, "action");
        Intrinsics.m26847b(list, "items");
        Intrinsics.m26847b(map, "linkTypes");
        Iterable<Thing> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Thing name : iterable) {
            arrayList.add(name.getName());
        }
        List list2 = (List) arrayList;
        String uuid = UUID.randomUUID().toString();
        switch (WhenMappings.f20899a[modQueueAction.ordinal()]) {
            case 1:
                SinglesKt.m24094b(this.repository.m22443a(ACTION_APPROVE, list2), this.scheduler).subscribe(new ModQueueOptionsPresenter$onActon$1(this, list, uuid, map), (Consumer) new ModQueueOptionsPresenter$onActon$2(this));
                return;
            case 2:
                SinglesKt.m24094b(this.repository.m22443a(ACTION_REMOVE, list2), this.scheduler).subscribe(new ModQueueOptionsPresenter$onActon$3(this, list, uuid, map), (Consumer) new ModQueueOptionsPresenter$onActon$4(this));
                return;
            case 3:
                SinglesKt.m24094b(this.repository.m22443a(ACTION_SPAM, list2), this.scheduler).subscribe(new ModQueueOptionsPresenter$onActon$5(this, list, uuid, map), (Consumer) new ModQueueOptionsPresenter$onActon$6(this));
                break;
            default:
                break;
        }
    }

    private final void postAnalytics(String str, String str2, ClientLink clientLink) {
        if (clientLink.getSubredditId() != null && clientLink.getSubreddit() != null) {
            ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a(ModEventBuilder.f27456g)).m21892b(ModEventBuilder.f27450a)).m21895c(str)).m21896d(str2);
            Object subredditId = clientLink.getSubredditId();
            Intrinsics.m26843a(subredditId, "link.subredditId");
            Object subreddit = clientLink.getSubreddit();
            if (subreddit == null) {
                Intrinsics.m26842a();
            }
            Intrinsics.m26843a(subreddit, "link.subreddit!!");
            modEventBuilder = (ModEventBuilder) modEventBuilder.m21889a(subredditId, subreddit);
            subredditId = clientLink.getName();
            Intrinsics.m26843a(subredditId, "link.name");
            String valueOf = String.valueOf(Util.m23952a((Link) clientLink));
            Object title = clientLink.getTitle();
            Intrinsics.m26843a(title, "link.title");
            ((ModEventBuilder) modEventBuilder.m21890a(subredditId, valueOf, title)).m21891a();
        }
    }

    private final void commentAnalytics(String str, String str2, Comment comment, String str3) {
        if (comment.i() != null && comment.h() != null) {
            ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a(ModEventBuilder.f27456g)).m21892b(ModEventBuilder.f27450a)).m21895c(str)).m21896d(str2);
            str2 = comment.getName();
            Object j = comment.j();
            Intrinsics.m26843a(j, "comment.linkId");
            modEventBuilder = (ModEventBuilder) modEventBuilder.m21893b(str2, j);
            Object i = comment.i();
            Intrinsics.m26843a(i, "comment.subredditId");
            j = comment.h();
            Intrinsics.m26843a(j, "comment.subreddit");
            modEventBuilder = (ModEventBuilder) modEventBuilder.m21889a(i, j);
            i = comment.j();
            Intrinsics.m26843a(i, "comment.linkId");
            Object f = comment.f();
            Intrinsics.m26843a(f, "comment.linkTitle");
            ((ModEventBuilder) modEventBuilder.m21890a(i, str3, f)).m21891a();
        }
    }
}
