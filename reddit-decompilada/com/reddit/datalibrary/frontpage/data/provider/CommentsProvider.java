package com.reddit.datalibrary.frontpage.data.provider;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.TagConstraint;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteWebSocketDataSource;
import com.reddit.datalibrary.frontpage.job.BaseRedditJob;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.WebSocketClient.WebSocketConnection;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.datalibrary.frontpage.requests.models.v1.More;
import com.reddit.datalibrary.frontpage.requests.models.v1.MoreCommentResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.ReplyableWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveCommentsUpdate.LiveComment;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveCommentsUpdater;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.events.v2.CommentPerformanceEventBuilder.Source;
import com.reddit.frontpage.commons.analytics.performance.CommentsPerformanceTracker;
import com.reddit.frontpage.ui.detail.comments.ReplyableTreeNode;
import com.reddit.frontpage.ui.detail.comments.collapsetree.CollapseTree;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import timber.log.Timber;

public class CommentsProvider extends BaseOtherProvider {
    private static final Map<String, WeakReference<CollapseTree>> f16227e = new HashMap();
    public CollapseTree f16228a;
    @Inject
    RemoteRedditApiDataSource f16229b;
    @Inject
    RemoteWebSocketDataSource f16230c;
    @State
    String comment;
    @State
    String commentContext;
    public Callbacks f16231d;
    private WebSocketConnection f16232f;
    private final Link f16233g;
    private final Handler f16234h = new Handler(Looper.getMainLooper());
    @State
    @SuppressLint({"WrongConstant"})
    public int sortId = -1;

    public interface Callbacks {
        void m9127a();

        void m9128a(int i, int i2);

        void m9129a(int i, int i2, int i3);

        void m9130b(int i, int i2);
    }

    private class LoadCommentsJob extends BaseRedditJob {
        final Session f18726m = SessionManager.m9191b().f10840c;
        final String f18727n;
        final /* synthetic */ CommentsProvider f18728o;

        class C09352 implements Runnable {
            final /* synthetic */ LoadCommentsJob f10786a;

            C09352(LoadCommentsJob loadCommentsJob) {
                this.f10786a = loadCommentsJob;
            }

            public void run() {
                if (this.f10786a.f18728o.f16231d != null) {
                    this.f10786a.f18728o.f16231d;
                }
            }
        }

        class C15381 implements LiveCommentsUpdater {
            final /* synthetic */ LoadCommentsJob f16226a;

            C15381(LoadCommentsJob loadCommentsJob) {
                this.f16226a = loadCommentsJob;
            }

            public final void m16218a(LiveComment liveComment) {
                CollapseTree collapseTree = this.f16226a.f18728o.f16228a;
                ReplyableWrapper commentWrapper = new CommentWrapper();
                commentWrapper.setData(liveComment);
                commentWrapper.setKind(Kind.COMMENT);
                ReplyableTreeNode replyableTreeNode = new ReplyableTreeNode(commentWrapper, 1);
                int i = 0;
                if (liveComment.parent_id != null) {
                    if (liveComment.parent_id.startsWith("t3_") == null) {
                        liveComment = collapseTree.b(replyableTreeNode);
                        if (liveComment == null) {
                            i = -1;
                        } else {
                            i = collapseTree.a(liveComment) + 1;
                            replyableTreeNode.b = liveComment.b + 1;
                        }
                        if (i >= 0) {
                            collapseTree.a(i, commentWrapper);
                        }
                        if (i >= 0 && this.f16226a.f18728o.f16231d != null) {
                            this.f16226a.f18728o.f16231d.m9128a(i, 1);
                            return;
                        }
                    }
                }
                replyableTreeNode.b = 0;
                if (i >= 0) {
                    collapseTree.a(i, commentWrapper);
                }
                if (i >= 0) {
                }
            }

            public final void m16219a(Throwable th, String str) {
                Timber.c(th, str, new Object[0]);
                if (this.f16226a.f18728o.f16231d != null) {
                    this.f16226a.f18728o.f16231d;
                }
            }
        }

        LoadCommentsJob(CommentsProvider commentsProvider, String str) {
            this.f18728o = commentsProvider;
            Params params = new Params(RedditJobManager.f10810d);
            params.f2940b = CommentsProvider.m16221a(commentsProvider);
            super(params.m2536a(commentsProvider.providerId));
            this.f18727n = str;
        }

        @SuppressLint({"WrongConstant"})
        public final void mo3019b() throws Throwable {
            boolean z = false;
            int size = this.f18728o.f16228a != null ? this.f18728o.f16228a.b.size() : 0;
            if (size == 0) {
                z = true;
            }
            RemoteRedditApiDataSource remoteRedditApiDataSource = this.f18728o.f16229b;
            CommentResponse commentResponse = (CommentResponse) RemoteRedditApiDataSource.m8886a(this.f18728o.f16233g.getId(), this.f18728o.sortId, z, this.f18728o.comment, this.f18728o.commentContext, this.f18727n).blockingGet();
            CommentListing commentListing = commentResponse.commentListing;
            if (!this.f2889j) {
                if (z) {
                    ModUtil.a(this.f18728o.f16233g).clearCache();
                }
                this.f18728o.f16234h.post(new CommentsProvider$LoadCommentsJob$$Lambda$0(this, commentListing.mo3815a().mo3049b(), size, z));
                this.f18728o.m16239c();
                if (this.f18728o.sortId == 9) {
                    Uri parse = Uri.parse(commentResponse.link.getWebsocketUrl());
                    CommentsProvider commentsProvider = this.f18728o;
                    RemoteWebSocketDataSource remoteWebSocketDataSource = this.f18728o.f16230c;
                    commentsProvider.f16232f = RemoteWebSocketDataSource.m8948a(parse, new C15381(this));
                }
                super.mo3019b();
            }
        }

        protected final void mo3018a(int i, Throwable th) {
            super.mo3018a(i, th);
            this.f18728o.f16234h.post(new C09352(this));
        }
    }

    private class LoadMoreCommentsJob extends BaseRedditJob {
        Session f18729m = SessionManager.m9191b().f10840c;
        List<String> f18730n;
        ReplyableTreeNode f18731o;
        CollapseTree f18732p;
        String f18733q;
        final /* synthetic */ CommentsProvider f18734r;

        class C09361 implements Runnable {
            final /* synthetic */ LoadMoreCommentsJob f10789a;

            C09361(LoadMoreCommentsJob loadMoreCommentsJob) {
                this.f10789a = loadMoreCommentsJob;
            }

            public void run() {
                if (this.f10789a.f18734r.f16231d != null) {
                    this.f10789a.f18734r.f16231d;
                }
            }
        }

        LoadMoreCommentsJob(CommentsProvider commentsProvider, ReplyableTreeNode replyableTreeNode, List<String> list, String str) {
            this.f18734r = commentsProvider;
            Params a = new Params(RedditJobManager.f10810d).m2535a();
            a.f2940b = CommentsProvider.m16221a(commentsProvider);
            super(a.m2536a(commentsProvider.providerId));
            this.f18731o = replyableTreeNode;
            this.f18730n = list;
            this.f18733q = str;
            this.f18732p = commentsProvider.f16228a;
        }

        @SuppressLint({"WrongConstant"})
        public final void mo3019b() throws Throwable {
            RemoteRedditApiDataSource remoteRedditApiDataSource = this.f18734r.f16229b;
            MoreCommentResponse moreCommentResponse = (MoreCommentResponse) RemoteRedditApiDataSource.m8898a(String.format("%s_%s", new Object[]{Kind.LINK, this.f18734r.f16233g.getId()}), this.f18730n, this.f18734r.sortId, this.f18733q).blockingGet();
            if (!this.f2889j) {
                this.f18734r.f16234h.post(new CommentsProvider$LoadMoreCommentsJob$$Lambda$0(this, moreCommentResponse.json.data.things));
                super.mo3019b();
            }
        }

        protected final void mo3018a(int i, Throwable th) {
            super.mo3018a(i, th);
            this.f18734r.f16234h.post(new C09361(this));
        }
    }

    public CommentsProvider(Link link, int i) {
        FrontpageApplication.m().a(this);
        this.f16233g = link;
        this.sortId = i;
        m16228d();
    }

    public final int m16231a(String str) {
        CollapseTree collapseTree = this.f16228a;
        for (int i = 0; i < collapseTree.b.size(); i++) {
            if (TextUtils.equals(((ReplyableTreeNode) collapseTree.b.get(i)).a.m16425b(), str)) {
                return i;
            }
        }
        return -1;
    }

    public final void m16235a(String str, String str2) {
        this.comment = str;
        this.commentContext = str2;
    }

    public final void m16233a() {
        RedditJobManager.m9150a().m2522a(TagConstraint.ANY, this.providerId);
        m16228d();
        this.f16228a = null;
        m16236a(true, CommentsPerformanceTracker.a(Source.PostDetail));
    }

    public void finish() {
        super.finish();
        this.f16231d = null;
        RedditJobManager.m9150a().m2522a(TagConstraint.ANY, this.providerId);
    }

    public final void m16236a(boolean z, String str) {
        Util.c();
        if (!z && this.f16228a && this.f16231d) {
            this.f16231d.m9127a();
        } else {
            RedditJobManager.m9150a().m2521a(new LoadCommentsJob(this, str));
        }
    }

    public final int m16237b() {
        return this.f16228a == null ? 0 : this.f16228a.b.size();
    }

    public final ReplyableTreeNode m16232a(int i) {
        return this.f16228a.a(i);
    }

    public final int m16230a(ReplyableTreeNode replyableTreeNode) {
        return this.f16228a.f(replyableTreeNode);
    }

    public final void m16238b(ReplyableTreeNode replyableTreeNode) {
        Util.c();
        if (m16229d(replyableTreeNode)) {
            m16223a(replyableTreeNode, CommentsPerformanceTracker.a(Source.PostDetail));
            return;
        }
        int a = this.f16228a.a(replyableTreeNode);
        replyableTreeNode = this.f16228a.d(replyableTreeNode);
        if (this.f16231d != null) {
            this.f16231d.m9129a(a, 1, 1);
            this.f16231d.m9128a(a + 1, replyableTreeNode);
        }
    }

    public final void m16234a(int i, int i2) {
        Util.c();
        if (this.f16231d != null) {
            this.f16231d.m9129a(i, 1, 1);
            this.f16231d.m9130b(i + 1, i2);
        }
    }

    private void m16228d() {
        this.providerId = UUID.randomUUID().toString();
    }

    public final void m16239c() {
        if (this.f16232f != null) {
            this.f16232f.m9301a();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f16228a != null) {
            f16227e.put(getProviderId(), new WeakReference(this.f16228a));
        } else {
            f16227e.remove(getProviderId());
        }
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        WeakReference weakReference = (WeakReference) f16227e.remove(getProviderId());
        if (weakReference != null && weakReference.get() != null) {
            this.f16228a = (CollapseTree) weakReference.get();
        }
    }

    private void m16223a(ReplyableTreeNode replyableTreeNode, String str) {
        List list = ((More) replyableTreeNode.a.getData()).children;
        CommentsPerformanceTracker.c(str);
        RedditJobManager.m9150a().m2521a(new LoadMoreCommentsJob(this, replyableTreeNode, list, str));
    }

    private static boolean m16229d(ReplyableTreeNode replyableTreeNode) {
        return TextUtils.equals(replyableTreeNode.a.getKind(), Kind.MORE);
    }

    static /* synthetic */ String m16221a(CommentsProvider commentsProvider) {
        StringBuilder stringBuilder = new StringBuilder("get_comments:");
        stringBuilder.append(commentsProvider.f16233g.getId());
        return stringBuilder.toString();
    }
}
