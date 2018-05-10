package com.reddit.frontpage.commons.analytics.builders;

import com.reddit.common.ThingType;
import com.reddit.common.ThingUtil;
import com.reddit.data.events.Analytics;
import com.reddit.data.events.models.AnalyticsSession;
import com.reddit.data.events.models.Event.Builder;
import com.reddit.data.events.models.components.Comment;
import com.reddit.data.events.models.components.Post;
import com.reddit.data.events.models.components.Subreddit;
import com.reddit.data.events.models.components.Timer;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.util.Platform;
import com.reddit.frontpage.util.SubredditUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\b'\u0018\u0000 P*\u0010\b\u0000\u0010\u0001 \u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u0001PB\u0005¢\u0006\u0002\u0010\u0003J\u0013\u00104\u001a\u00028\u00002\u0006\u00104\u001a\u000205¢\u0006\u0002\u00106J\u001b\u00107\u001a\u00028\u00002\u0006\u00108\u001a\u0002052\u0006\u00109\u001a\u000205¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00028\u00002\u0006\u0010;\u001a\u000205¢\u0006\u0002\u00106J\u0013\u0010<\u001a\u00028\u00002\u0006\u0010<\u001a\u000205¢\u0006\u0002\u00106J%\u0010=\u001a\u00028\u00002\u0006\u0010>\u001a\u0002052\u0006\u0010?\u001a\u0002052\u0006\u0010@\u001a\u000205H\u0016¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020CH&J\u0006\u0010D\u001a\u00020CJ\u0013\u0010E\u001a\u00028\u00002\u0006\u0010E\u001a\u000205¢\u0006\u0002\u00106J\u001b\u0010F\u001a\u00028\u00002\u0006\u0010G\u001a\u0002052\u0006\u0010H\u001a\u000205¢\u0006\u0002\u0010:J\u001b\u0010I\u001a\u00028\u00002\u0006\u0010J\u001a\u00020K2\u0006\u0010?\u001a\u000205¢\u0006\u0002\u0010LJ\u0018\u0010M\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u00052\u0006\u0010O\u001a\u000205H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001a\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001a\u0010#\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR\u0014\u0010&\u001a\u00020'X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR\u0014\u0010-\u001a\u00020.X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\t¨\u0006Q"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/builders/BaseEventBuilder;", "T", "", "()V", "actionSet", "", "getActionSet", "()Z", "setActionSet", "(Z)V", "builder", "Lcom/reddit/data/events/models/Event$Builder;", "getBuilder", "()Lcom/reddit/data/events/models/Event$Builder;", "setBuilder", "(Lcom/reddit/data/events/models/Event$Builder;)V", "commentBuilder", "Lcom/reddit/data/events/models/components/Comment$Builder;", "getCommentBuilder", "()Lcom/reddit/data/events/models/components/Comment$Builder;", "commentSet", "getCommentSet", "setCommentSet", "nounSet", "getNounSet", "setNounSet", "postBuilder", "Lcom/reddit/data/events/models/components/Post$Builder;", "getPostBuilder", "()Lcom/reddit/data/events/models/components/Post$Builder;", "setPostBuilder", "(Lcom/reddit/data/events/models/components/Post$Builder;)V", "postSet", "getPostSet", "setPostSet", "sourceSet", "getSourceSet", "setSourceSet", "subredditBuilder", "Lcom/reddit/data/events/models/components/Subreddit$Builder;", "getSubredditBuilder", "()Lcom/reddit/data/events/models/components/Subreddit$Builder;", "subredditSet", "getSubredditSet", "setSubredditSet", "timerBuilder", "Lcom/reddit/data/events/models/components/Timer$Builder;", "getTimerBuilder", "()Lcom/reddit/data/events/models/components/Timer$Builder;", "timerSet", "getTimerSet", "setTimerSet", "action", "", "(Ljava/lang/String;)Lcom/reddit/frontpage/commons/analytics/builders/BaseEventBuilder;", "comment", "commentId", "postId", "(Ljava/lang/String;Ljava/lang/String;)Lcom/reddit/frontpage/commons/analytics/builders/BaseEventBuilder;", "correlationId", "noun", "post", "id", "type", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/reddit/frontpage/commons/analytics/builders/BaseEventBuilder;", "prepareAnalytics", "", "send", "source", "subreddit", "subredditId", "subredditName", "timer", "timeElapsed", "", "(JLjava/lang/String;)Lcom/reddit/frontpage/commons/analytics/builders/BaseEventBuilder;", "validateFields", "isFieldSet", "keyword", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BaseEventBuilder.kt */
public abstract class BaseEventBuilder<T extends BaseEventBuilder<? extends T>> {
    public static final Companion Companion = new Companion();
    private static final String KEYWORD_ACTION = "action";
    private static final String KEYWORD_NOUN = "noun";
    private static final String KEYWORD_SOURCE = "source";
    private boolean actionSet;
    protected Builder builder = new Builder();
    private final Comment.Builder commentBuilder = new Comment.Builder();
    private boolean commentSet;
    private boolean nounSet;
    private Post.Builder postBuilder = new Post.Builder();
    private boolean postSet;
    private boolean sourceSet;
    protected final Subreddit.Builder subredditBuilder = new Subreddit.Builder();
    protected boolean subredditSet;
    public final Timer.Builder timerBuilder = new Timer.Builder();
    public boolean timerSet;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/builders/BaseEventBuilder$Companion;", "", "()V", "KEYWORD_ACTION", "", "KEYWORD_NOUN", "KEYWORD_SOURCE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BaseEventBuilder.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    private static boolean mo4572a(boolean z) {
        return z && z;
    }

    public abstract void mo4573b();

    public final T m21888a(String str) {
        Intrinsics.m26847b(str, KEYWORD_SOURCE);
        this.builder.source(str);
        this.sourceSet = true;
        if (this != null) {
            return this;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    public final T m21892b(String str) {
        Intrinsics.m26847b(str, KEYWORD_ACTION);
        this.builder.action(str);
        this.actionSet = true;
        if (this != null) {
            return this;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    public final T m21895c(String str) {
        Intrinsics.m26847b(str, KEYWORD_NOUN);
        this.builder.noun(str);
        this.nounSet = true;
        if (this != null) {
            return this;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    public final T m21896d(String str) {
        Intrinsics.m26847b(str, "correlationId");
        this.builder.correlation_id(str);
        if (this != null) {
            return this;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    public final T m21889a(String str, String str2) {
        Intrinsics.m26847b(str, "subredditId");
        Intrinsics.m26847b(str2, "subredditName");
        Object c = SubredditUtil.m23930c(str2);
        if (((CharSequence) ThingUtil.b(str)).length() == 0) {
            StringBuilder stringBuilder = new StringBuilder("Analytics: invalid subreddit kindWithId ");
            stringBuilder.append(str);
            stringBuilder.append(',');
            stringBuilder.append(" subredditName: ");
            stringBuilder.append(c);
            Timber.e(stringBuilder.toString(), new Object[0]);
            if (this != null) {
                return this;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        str = this.subredditBuilder.id(ThingUtil.a(str, ThingType.d));
        Intrinsics.m26843a(c, "subreddit");
        if (c == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        c = c.toLowerCase();
        Intrinsics.m26843a(c, "(this as java.lang.String).toLowerCase()");
        str.name(c);
        this.subredditSet = true;
        if (this != null) {
            return this;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    public final T m21893b(String str, String str2) {
        Intrinsics.m26847b(str, "commentId");
        Intrinsics.m26847b(str2, "postId");
        this.commentBuilder.id(str);
        this.commentBuilder.post_id(str2);
        this.commentSet = true;
        if (this != null) {
            return this;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    public final T m21890a(String str, String str2, String str3) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(str2, "type");
        Intrinsics.m26847b(str3, "title");
        this.postBuilder.id(str);
        str = this.postBuilder;
        Object toLowerCase = str2.toLowerCase();
        Intrinsics.m26843a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        str.type(toLowerCase);
        this.postBuilder.title(str3);
        this.postSet = true;
        if (this != null) {
            return this;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    public final void m21891a() {
        boolean a = mo4572a(this.sourceSet);
        boolean a2 = mo4572a(this.actionSet);
        boolean a3 = mo4572a(this.actionSet);
        if (a2 && a) {
            if (a3) {
                if (this.postSet) {
                    this.builder.post(this.postBuilder.build());
                }
                if (this.timerSet) {
                    this.builder.timer(this.timerBuilder.build());
                }
                if (this.commentSet) {
                    this.builder.comment(this.commentBuilder.build());
                }
                if (this.subredditSet) {
                    this.builder.subreddit(this.subredditBuilder.build());
                }
                mo4573b();
                Analytics analytics = Analytics.a;
                Builder builder = this.builder;
                Object b = SessionManager.b();
                Intrinsics.m26843a(b, "SessionManager.getInstance()");
                b = b.c();
                Intrinsics.m26843a(b, "SessionManager.getInstance().activeSession");
                Analytics.a(builder, (AnalyticsSession) b, Platform.f29397a);
            }
        }
    }
}
