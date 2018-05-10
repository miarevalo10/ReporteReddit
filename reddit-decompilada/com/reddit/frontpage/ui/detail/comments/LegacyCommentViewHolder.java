package com.reddit.frontpage.ui.detail.comments;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.Votable;
import com.reddit.datalibrary.frontpage.requests.models.Votable.AdAnalyticsInfo;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ClickEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.CustomReasonsNoun;
import com.reddit.frontpage.commons.analytics.builders.CustomReportEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v1.ShareEvent;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder.Source;
import com.reddit.frontpage.commons.analytics.outboundlinks.OutboundLinkTracker;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.listing.ui.view.Indicator;
import com.reddit.frontpage.presentation.listing.ui.view.UserIndicatorsView;
import com.reddit.frontpage.presentation.usermodal.UserModalScreen;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.ui.listener.ModQueueCheckListener;
import com.reddit.frontpage.ui.listing.adapter.ListingViewHolder;
import com.reddit.frontpage.ui.modtools.PopupCommentModOptions;
import com.reddit.frontpage.ui.modtools.PopupModReports;
import com.reddit.frontpage.util.CommentUtil;
import com.reddit.frontpage.util.DateUtil;
import com.reddit.frontpage.util.GoldUtil;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.MenuUtil;
import com.reddit.frontpage.util.ModCacheComments;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.RichTextUtil;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.BaseHtmlTextView;
import com.reddit.frontpage.widgets.DrawableTextView;
import com.reddit.frontpage.widgets.IconStatusView;
import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;
import com.reddit.frontpage.widgets.LinkFooterView.OnModerateListener;
import com.reddit.frontpage.widgets.comment.CommentIndentView;
import com.reddit.frontpage.widgets.modtools.modview.ModView;
import com.reddit.frontpage.widgets.modtools.modview.ModViewLeftComment;
import com.reddit.frontpage.widgets.modtools.modview.ModViewRight;
import com.reddit.frontpage.widgets.modtools.modview.rightcomment.ModViewRightComment;
import com.reddit.frontpage.widgets.vote.OnVoteChangeListener;
import com.reddit.frontpage.widgets.vote.VoteView;
import java.util.EnumSet;
import java.util.Set;
import kotlin.Unit;

public class LegacyCommentViewHolder extends ListingViewHolder {
    private static final String f34245w = Util.m24027f((int) C1761R.string.internal_deleted);
    private static final String f34246x = Util.m24027f((int) C1761R.string.unicode_delimiter);
    private static final String f34247y = Util.m24027f((int) C1761R.string.unicode_delimiter_no_left_space);
    private OnModQueueCommentSelectedListener f34248A;
    private final int f34249B;
    private Link f34250C;
    private MenuItem f34251D;
    private MenuItem f34252E;
    private MenuItem f34253F;
    private MenuItem f34254G;
    private MenuItem f34255H;
    private MenuItem f34256I;
    private MenuItem f34257J;
    private MenuItem f34258K;
    private PopupMenu f34259L;
    private boolean f34260M;
    protected Comment f34261a;
    @BindView
    protected TextView author;
    @BindView
    UserIndicatorsView authorIndicators;
    ReplyableTreeNode f34262b;
    @BindView
    public BaseHtmlTextView body;
    @BindView
    TextView collapsedText;
    @BindView
    View commentOptions;
    @BindView
    TextView flair;
    @BindView
    protected TextView gildedCount;
    @BindView
    View header;
    @BindView
    CommentIndentView indentView;
    @BindView
    View menuView;
    @BindView
    ModView modView;
    @BindView
    ModViewLeftComment modViewLeftComment;
    @BindView
    ModViewRightComment modViewRightComment;
    @BindView
    ImageView overFlowIcon;
    public OnReplyListener f34263p;
    public OnDeleteListener f34264q;
    public OnCommentEditListener f34265r;
    @BindView
    DrawableTextView replyView;
    public ModCacheComments f34266s;
    @BindView
    CheckBox selectCheckBox;
    @BindView
    IconStatusView statusView;
    boolean f34267t = true;
    public OnVoteChangeListener f34268u;
    public HolderCallbacks f34269v;
    @BindView
    VoteView voteView;
    @BindView
    TextView when;
    private ModQueueCheckListener<Thing> f34270z;

    public interface HolderCallbacks {
        Link mo4956a();

        void mo4957a(ReplyableTreeNode replyableTreeNode);
    }

    public interface OnCommentEditListener {
        void mo5009a(Comment comment);
    }

    public interface OnDeleteListener {
        void mo4968a(int i, Comment comment);
    }

    public interface OnModQueueCommentSelectedListener {
        void mo4988a(Comment comment);
    }

    public interface OnReplyListener {
        void mo7207a(LegacyCommentViewHolder legacyCommentViewHolder);
    }

    private class CommentMenuItemClickListener implements OnMenuItemClickListener {
        final /* synthetic */ LegacyCommentViewHolder f28962a;

        private CommentMenuItemClickListener(LegacyCommentViewHolder legacyCommentViewHolder) {
            this.f28962a = legacyCommentViewHolder;
        }

        public final boolean m30027a(MenuItem menuItem) {
            SessionManager b = SessionManager.b();
            Session session = b.c;
            Context e = Util.m24019e(this.f28962a.c.getContext());
            String str;
            switch (menuItem.getItemId()) {
                case C1761R.id.action_collapse_thread:
                    if (this.f28962a.f34269v != null) {
                        this.f28962a.f34269v.mo4957a(this.f28962a.f34262b);
                    }
                    return true;
                case C1761R.id.action_copy_text:
                    Util.m23969a(e, "reddit comment", this.f28962a.f34261a.body);
                    return true;
                case C1761R.id.action_delete:
                    RedditAlertDialog.m23320b(e, new LegacyCommentViewHolder$CommentMenuItemClickListener$$Lambda$1(this, session)).m23323a();
                    return true;
                case C1761R.id.action_edit:
                    this.f28962a.f34265r.mo5009a(this.f28962a.f34261a);
                    return true;
                case C1761R.id.action_give_gold:
                    RedditAlertDialog.m23313a(e, GoldUtil.m23705a(), new LegacyCommentViewHolder$CommentMenuItemClickListener$$Lambda$2(this)).m23323a();
                    return true;
                case C1761R.id.action_report:
                    if (Routing.m22617a(this.f28962a.c.getContext()) != null) {
                        RedditAlertDialog.m23310a(this.f28962a.f34261a.c(), Util.m24027f((int) C1761R.string.action_report_comment), e, this.f28962a.f34250C, this.f28962a.f34261a, LegacyCommentViewHolder$CommentMenuItemClickListener$$Lambda$0.f34241a).m29514c();
                        if (this.f28962a.f34250C == null) {
                            CustomReportEventBuilder.m28936a(this.f28962a.f34261a, "comment_overflow", "click", CustomReasonsNoun.f20026k.f20028l);
                        } else {
                            CustomReportEventBuilder.m28935a(this.f28962a.f34261a, this.f28962a.f34250C, "comment_overflow", "click", CustomReasonsNoun.f20026k.f20028l);
                        }
                    }
                    return true;
                case C1761R.id.action_save:
                case C1761R.id.action_unsave:
                    if (session.isAnonymous()) {
                        b.a(e, true);
                    } else {
                        if (menuItem.getItemId() == C1761R.id.action_save) {
                            CommentUtil.m23668a(session, this.f28962a.f34261a);
                            str = CustomReasonsNoun.f20018c.f20028l;
                        } else {
                            CommentUtil.m23670b(session, this.f28962a.f34261a);
                            str = CustomReasonsNoun.f20019d.f20028l;
                        }
                        if (this.f28962a.f34250C == null) {
                            CustomReportEventBuilder.m28936a(this.f28962a.f34261a, "comment_overflow", "click", str);
                        } else {
                            CustomReportEventBuilder.m28935a(this.f28962a.f34261a, this.f28962a.f34250C, "comment_overflow", "click", str);
                        }
                    }
                    return true;
                case C1761R.id.action_share:
                    if (this.f28962a.f34269v != null) {
                        str = CommentUtil.m23666a(this.f28962a.f34250C, this.f28962a.f34261a);
                    } else {
                        str = CommentUtil.m23665a(this.f28962a.f34261a);
                    }
                    ClickEventBuilder a = AppAnalytics.m21858b().m21823a(this.f28962a.c);
                    a.f19955b = "comment_share_overflow";
                    a.f19956c = str;
                    a.m21825a();
                    new ShareEventBuilder().m21941a(Source.CommentOverflow).m21939a(Action.Clicked).m21940a(Noun.Share).m21936a(this.f28962a.f34261a).m21944a();
                    new ShareEventBuilder().m21941a(Source.CommentShareComplete).m21939a(Action.ShareComplete).m21940a(Noun.ShareSuccess).m21936a(this.f28962a.f34261a).m21945b();
                    LegacyCommentViewHolder.m34957a(this.f28962a, str);
                    CommentUtil.m23667a(e, this.f28962a.f34261a, str);
                    return true;
                case C1761R.id.action_view_reports:
                    Context context = this.f28962a.c.getContext();
                    Comment comment = this.f28962a.f34261a;
                    this.f28962a.c.getContext();
                    menuItem = new PopupCommentModOptions(context, comment, LinkUtil.m23776a(), AppAnalytics.m21849a(this.f28962a.c));
                    menuItem.f21458b = new LegacyCommentViewHolder$CommentMenuItemClickListener$$Lambda$3(this);
                    menuItem.f21457a.m23284a();
                    return true;
                default:
                    return null;
            }
        }

        final /* synthetic */ Unit m30025a(Session session) {
            CommentUtil.m23672c(session, this.f28962a.f34261a);
            this.f28962a.f34264q.mo4968a(this.f28962a.d(), this.f28962a.f34261a);
            return Unit.f25273a;
        }

        final /* synthetic */ Unit m30028b() {
            GoldUtil.m23707b(this.f28962a.f34261a.getName(), this.f28962a.f34261a.getGilded());
            this.f28962a.statusView.m24154a(this.f28962a.f34261a, this.f28962a.f34266s);
            return Unit.f25273a;
        }

        final /* synthetic */ void m30026a() {
            this.f28962a.m34968a(this.f28962a.f34261a);
        }
    }

    public final int mo6480Q() {
        return 12;
    }

    public static LegacyCommentViewHolder m34955a(ViewGroup viewGroup, ModQueueCheckListener<Thing> modQueueCheckListener, OnModQueueCommentSelectedListener onModQueueCommentSelectedListener) {
        viewGroup = m34954a(viewGroup);
        viewGroup.f34260M = true;
        viewGroup.f34270z = modQueueCheckListener;
        viewGroup.f34248A = onModQueueCommentSelectedListener;
        return viewGroup;
    }

    public static LegacyCommentViewHolder m34954a(ViewGroup viewGroup) {
        return new LegacyCommentViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.comment_next, viewGroup, false));
    }

    public LegacyCommentViewHolder(View view) {
        super(view);
        ButterKnife.a(this, view);
        this.f34249B = ResourcesUtil.m22740i(view.getContext(), C1761R.attr.rdt_meta_text_color);
        this.author.setOnClickListener(new LegacyCommentViewHolder$$Lambda$0(this));
        this.overFlowIcon.setImageDrawable(ResourcesUtil.m22733e(view.getContext(), this.overFlowIcon.getDrawable()));
        this.menuView.setOnClickListener(new LegacyCommentViewHolder$$Lambda$1(this));
        this.replyView.setCompoundDrawablesRelative(ResourcesUtil.m22732e(view.getContext(), (int) C1761R.drawable.ic_icon_reply), null, null, null);
    }

    final /* synthetic */ void m34966a(View view) {
        if (!this.f34267t) {
            return;
        }
        if (this.f34261a == null || this.f34250C == null || this.f34250C.getSubredditDetail() == null || !this.f34250C.getSubredditDetail().user_is_moderator) {
            if (!(this.f34261a == null || Util.m24041k(this.f34261a.c()))) {
                Routing.m22619a(view.getContext(), Nav.m22594j(this.f34261a.c()));
            }
            return;
        }
        view = Routing.m22617a(view.getContext());
        if (!(Util.m24041k(this.f34250C.getAuthor()) || view == null)) {
            UserModalScreen.m29887a(view, this.f34250C, this.f34261a).m29901f();
        }
    }

    final /* synthetic */ void m34964C() {
        MenuItem menuItem;
        boolean z = false;
        if (this.f34259L == null) {
            PopupMenu popupMenu = new PopupMenu(this.c.getContext(), this.menuView);
            MenuUtil.m23812a(popupMenu.a);
            popupMenu.a(C1761R.menu.menu_comment);
            popupMenu.c = new CommentMenuItemClickListener();
            this.f34251D = popupMenu.a.findItem(C1761R.id.action_report);
            this.f34252E = popupMenu.a.findItem(C1761R.id.action_edit);
            this.f34253F = popupMenu.a.findItem(C1761R.id.action_delete);
            this.f34254G = popupMenu.a.findItem(C1761R.id.action_save);
            this.f34255H = popupMenu.a.findItem(C1761R.id.action_unsave);
            this.f34256I = popupMenu.a.findItem(C1761R.id.action_collapse_thread);
            this.f34257J = popupMenu.a.findItem(C1761R.id.action_give_gold);
            this.f34258K = popupMenu.a.findItem(C1761R.id.action_view_reports);
            this.f34259L = popupMenu;
        }
        Session session = SessionManager.b().c;
        boolean a = SessionUtil.m23895a(session, this.f34261a.c());
        boolean b = CommentUtil.m23671b(this.f34261a);
        if (!session.isAnonymous()) {
            if (!a) {
                this.f34251D.setVisible(true);
                this.f34252E.setVisible(a);
                this.f34253F.setVisible(a);
                this.f34254G.setVisible(b ^ 1);
                this.f34255H.setVisible(b);
                this.f34256I.setVisible(this.f34269v == null);
                this.f34257J.setVisible(GoldUtil.m23705a() <= 0);
                menuItem = this.f34258K;
                if (this.f34261a.num_reports > 0) {
                    z = true;
                }
                menuItem.setVisible(z);
                this.f34259L.b.a();
            }
        }
        this.f34251D.setVisible(false);
        this.f34252E.setVisible(a);
        this.f34253F.setVisible(a);
        this.f34254G.setVisible(b ^ 1);
        this.f34255H.setVisible(b);
        if (this.f34269v == null) {
        }
        this.f34256I.setVisible(this.f34269v == null);
        if (GoldUtil.m23705a() <= 0) {
        }
        this.f34257J.setVisible(GoldUtil.m23705a() <= 0);
        menuItem = this.f34258K;
        if (this.f34261a.num_reports > 0) {
            z = true;
        }
        menuItem.setVisible(z);
        this.f34259L.b.a();
    }

    final /* synthetic */ void m34963B() {
        m34968a(this.f34261a);
    }

    final void m34973v() {
        OnModActionCompletedListener legacyCommentViewHolder$$Lambda$2 = new LegacyCommentViewHolder$$Lambda$2(this);
        this.c.getContext();
        OnModerateListener a = LinkUtil.m23776a();
        if (ModUtil.m23831a(Routing.m22617a(this.modView.getContext()))) {
            ModViewRight modViewRight;
            if (this.f34260M) {
                this.selectCheckBox.setVisibility(0);
                this.selectCheckBox.setChecked(false);
                this.modView.setVisibility(0);
                this.modView.setModerateListener(a);
                this.modView.setActionCompletedListener(legacyCommentViewHolder$$Lambda$2);
                this.modViewRightComment.setVisibility(0);
                this.modViewLeftComment.setVisibility(8);
                modViewRight = this.modView.getModViewRight();
                if (modViewRight != null) {
                    modViewRight.setVisibility(8);
                }
                this.menuView.setVisibility(8);
                this.c.setOnClickListener(new LegacyCommentViewHolder$$Lambda$3(this));
            } else {
                this.modViewLeftComment.setVisibility(0);
                this.modViewLeftComment.setModerateListener(a);
                this.modViewLeftComment.setActionCompletedListener(legacyCommentViewHolder$$Lambda$2);
            }
            modViewRight = this.modView.getModViewRight();
            if (modViewRight != null) {
                ImageView listView = modViewRight.getListView();
                if (listView != null) {
                    listView.setVisibility(8);
                }
            }
            this.replyView.setVisibility(8);
            this.voteView.setVisibility(8);
            this.modViewRightComment.setVisibility(0);
            this.modViewRightComment.setModerateListener(a);
            this.modViewRightComment.f34543f = legacyCommentViewHolder$$Lambda$2;
            this.modViewRightComment.setCommentCache(this.f34266s);
            this.selectCheckBox.setOnCheckedChangeListener(new LegacyCommentViewHolder$$Lambda$4(this));
            return;
        }
        this.voteView.setVisibility(0);
        if (this.f34250C != null) {
            this.replyView.setVisibility(0);
        }
        this.modViewLeftComment.setVisibility(8);
        this.modViewRightComment.setVisibility(8);
        this.replyView.setOnClickListener(new LegacyCommentViewHolder$$Lambda$5(this));
    }

    final /* synthetic */ void m34962A() {
        this.f34248A.mo4988a(this.f34261a);
    }

    final /* synthetic */ void m34972b(boolean z) {
        if (this.f34261a != null) {
            if (this.f34250C != null) {
                String.valueOf(Util.m23952a(this.f34250C));
            }
            if (z) {
                this.f34270z.mo4987a(this.f34261a, String.valueOf(Util.m23952a(this.f34250C)));
                return;
            }
            this.f34270z.mo4986a(this.f34261a);
        }
    }

    final /* synthetic */ void m34977z() {
        if (this.f34263p != null && !this.f34261a.archived) {
            this.f34263p.mo7207a(this);
        }
    }

    public final void m34970a(Link link) {
        this.f34250C = link;
        this.modViewLeftComment.setLink(link);
    }

    public final Comment m34974w() {
        return this.f34261a;
    }

    public final void m34968a(Comment comment) {
        if (comment != null) {
            m34969a(comment, true);
            m34973v();
        }
    }

    public final void m34969a(Comment comment, boolean z) {
        boolean removedState;
        this.f34261a = comment;
        this.f34266s = ModUtil.m23823a(comment.getName());
        boolean z2 = true;
        if (this.f34266s != null) {
            removedState = this.f34266s.getRemovedState(comment.getName(), comment.removed);
            boolean a = this.f34266s.m30451a(comment.getName(), comment.spam);
            boolean approvedState = this.f34266s.getApprovedState(comment.getName(), false);
            if ((removedState || a || comment.num_reports > 0) && !approvedState) {
                this.modViewLeftComment.m35306a(true);
            } else {
                this.modViewLeftComment.m35306a(false);
            }
        }
        if (this.f34250C != null) {
            this.modViewLeftComment.setLink(this.f34250C);
            this.modViewRightComment.setLink(this.f34250C);
            this.modView.setLink(this.f34250C);
        } else {
            Link clientLink = new ClientLink(comment.parent_id, Subreddit.a(comment.subreddit, comment.subreddit_id), comment.link_title);
            this.modViewLeftComment.setLink(clientLink);
            this.modViewRightComment.setLink(clientLink);
            this.modView.setLink(clientLink);
        }
        this.modViewLeftComment.setComment(comment);
        this.modViewRightComment.setComment(comment);
        this.modView.setComment(comment);
        removedState = this.f34261a.body.equals(f34245w) && this.f34261a.c().equals(f34245w);
        float f = 0.5f;
        if (this.f34266s == null || !ModUtil.m23831a(Routing.m22617a(this.modView.getContext()))) {
            this.statusView.m24153a();
        } else {
            this.statusView.m24154a(comment, this.f34266s);
            if (!this.f34266s.getRemovedState(comment.getName(), comment.removed)) {
                if (!this.f34266s.m30451a(comment.getName(), comment.spam)) {
                    this.c.setAlpha(1.0f);
                }
            }
            this.c.setAlpha(0.5f);
        }
        mo7007a(SessionManager.b().c);
        if (z) {
            this.body.setHtmlFromString(this.f34261a.b());
            this.body.setVisibility(0);
            this.body.setPaintFlags(((this.body.getPaintFlags() | 128) | 256) | 1);
            this.statusView.setVisibility(0);
            this.collapsedText.setVisibility(8);
            if (!ModUtil.m23834b(Routing.m22617a(this.modView.getContext()))) {
                this.commentOptions.setVisibility(0);
            }
            if (this.f34250C) {
                if (!this.f34250C.isLocked()) {
                    if (!ModUtil.m23831a(Routing.m22617a(this.modView.getContext()))) {
                        this.replyView.setVisibility(0);
                        z = this.replyView;
                        a = (comment.archived || removedState) ? false : true;
                        z.setEnabled(a);
                        z = this.replyView;
                        if (!(comment.archived || removedState)) {
                            f = 1.0f;
                        }
                        z.setAlpha(f);
                    }
                    this.voteView.m24414a((Votable) comment, AdAnalyticsInfo.a(this.f34250C));
                    z = this.voteView;
                    if (comment.archived == null || removedState) {
                        z2 = false;
                    }
                    z.setEnabled(z2);
                    if (this.f34268u != null) {
                        this.voteView.setOnVoteChangeListener(LinkUtil.m23777a(this.c.getContext()));
                    } else {
                        this.voteView.setOnVoteChangeListener(this.f34268u);
                    }
                    this.statusView.setOnClickListener(new LegacyCommentViewHolder$$Lambda$6(this));
                    return;
                }
            }
            this.replyView.setVisibility(8);
            this.voteView.m24414a((Votable) comment, AdAnalyticsInfo.a(this.f34250C));
            z = this.voteView;
            if (comment.archived == null) {
            }
            z2 = false;
            z.setEnabled(z2);
            if (this.f34268u != null) {
                this.voteView.setOnVoteChangeListener(this.f34268u);
            } else {
                this.voteView.setOnVoteChangeListener(LinkUtil.m23777a(this.c.getContext()));
            }
            this.statusView.setOnClickListener(new LegacyCommentViewHolder$$Lambda$6(this));
            return;
        }
        String substring = this.f34261a.b().substring(0, Math.min(this.f34261a.b().length(), 100));
        z = new StringBuilder();
        z.append(f34246x);
        z.append(Util.m24030g(substring));
        this.collapsedText.setText(z.toString());
        this.collapsedText.setVisibility(0);
        this.statusView.setVisibility(8);
        this.body.setVisibility(8);
        this.commentOptions.setVisibility(8);
    }

    final /* synthetic */ void m34975x() {
        m34968a(this.f34261a);
    }

    public void mo7007a(Session session) {
        CharSequence charSequence;
        if (TextUtils.equals(f34245w, this.f34261a.c())) {
            charSequence = f34245w;
        } else {
            charSequence = this.f34261a.c();
        }
        Set noneOf = EnumSet.noneOf(Indicator.class);
        this.author.setText(charSequence);
        this.author.setTextColor(this.f34249B);
        if (SessionUtil.m23895a(session, this.f34261a.c()) != null) {
            this.author.setTextColor(this.c.getContext().getResources().getColor(C1761R.color.rdt_blue));
            noneOf.add(Indicator.f20734c);
        } else if (!(this.f34269v == null || this.f34269v.mo4956a() == null || Util.m24003b(this.f34269v.mo4956a().getAuthor(), this.f34261a.c()) == null)) {
            this.author.setTextColor(Util.m23950a((int) C1761R.color.rdt_blue));
            noneOf.add(Indicator.f20735d);
        }
        if (this.f34266s.getDistinguishState(this.f34261a.getName(), TextUtils.equals(this.f34261a.distinguished, "moderator")) != null) {
            this.author.setTextColor(Util.m23950a((int) C1761R.color.rdt_green));
            noneOf.add(Indicator.f20733b);
        } else if (ModUtil.m23822a(this.f34250C).getDistinguishAdminState(this.f34261a.getName(), TextUtils.equals(this.f34261a.distinguished, "admin")) != null) {
            this.author.setTextColor(Util.m23950a((int) C1761R.color.rdt_red));
            noneOf.add(Indicator.f20732a);
        }
        if (this.f34261a.author_cakeday != null) {
            noneOf.add(Indicator.f20736e);
        }
        if (this.f34261a.getGilded() > null) {
            noneOf.add(Indicator.f20737f);
            if (this.f34261a.getGilded() > 1) {
                this.gildedCount.setText(this.c.getContext().getString(C1761R.string.fmt_icon_count, new Object[]{Integer.valueOf(this.f34261a.getGilded())}));
                this.gildedCount.setVisibility(0);
            } else {
                this.gildedCount.setVisibility(8);
            }
        } else {
            this.gildedCount.setVisibility(8);
        }
        this.authorIndicators.setActiveIndicators(noneOf);
        session = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        if (noneOf.isEmpty()) {
            if (!TextUtils.isEmpty(this.f34261a.d())) {
                session.append(f34246x);
            }
        } else if (TextUtils.isEmpty(this.f34261a.d())) {
            stringBuilder.append(f34247y);
        } else {
            session.append(f34247y);
        }
        if (TextUtils.isEmpty(this.f34261a.d())) {
            this.flair.setVisibility(8);
        } else {
            session.append(this.f34261a.d());
            RichTextUtil.m23883a(session.toString(), this.flair);
            this.flair.setVisibility(0);
        }
        if (stringBuilder.toString().isEmpty() != null) {
            stringBuilder.append(f34246x);
        }
        stringBuilder.append(DateUtil.m23681a(this.f34261a.getCreatedUtc(), System.currentTimeMillis()));
        this.when.setText(stringBuilder.toString());
    }

    final /* synthetic */ void m34971a(String str) {
        OutboundLinkTracker.m21950a(str, this.f34261a, null);
    }

    final /* synthetic */ void m34976y() {
        if (this.f34261a.num_reports > 0) {
            new PopupModReports(this.modViewLeftComment.getContext(), this.f34261a, AppAnalytics.m21849a(this.c), new LegacyCommentViewHolder$$Lambda$7(this)).m23562b();
        }
    }

    static /* synthetic */ void m34957a(LegacyCommentViewHolder legacyCommentViewHolder, String str) {
        AppAnalytics.ShareEventBuilder a = AppAnalytics.m21868e().m21834a(legacyCommentViewHolder.c);
        a.f19995e = str;
        a.f19996f = legacyCommentViewHolder.f34261a.getName();
        a.f19998h = legacyCommentViewHolder.f34261a.getDomain();
        a.f19997g = "bound";
        a.f19999i = legacyCommentViewHolder.f34261a.link_title;
        a.f20002l = ShareEvent.SOURCE_DETAILS_SCREEN;
        a.f20000j = legacyCommentViewHolder.f34261a.subreddit;
        a.m21837a();
    }
}
