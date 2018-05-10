package com.reddit.frontpage.ui.inbox;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.android.volley.NetworkError;
import com.android.volley.ServerError;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.feature.inboxcount.InboxCountRepository;
import com.reddit.datalibrary.frontpage.data.provider.MessageListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.MessageListingProvider.MessageErrorEvent;
import com.reddit.datalibrary.frontpage.data.provider.MessageListingProvider.MessagesEvent;
import com.reddit.datalibrary.frontpage.data.provider.MessageThreadProvider.MessageThreadEvent;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.Message;
import com.reddit.datalibrary.frontpage.requests.models.v1.Notification;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerThingReportComponent;
import com.reddit.frontpage.di.module.ThingReportModule;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.dialogs.customreports.ThingReportContract.View;
import com.reddit.frontpage.presentation.dialogs.customreports.ThingReportContract.View.DefaultImpls;
import com.reddit.frontpage.presentation.dialogs.customreports.ThingReportPresenter;
import com.reddit.frontpage.presentation.dialogs.messagereport.MessageReportDialog;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.adapter.RecyclerHeaderFooterAdapter;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.DateUtil;
import com.reddit.frontpage.util.ListUtil;
import com.reddit.frontpage.util.MessageUtil;
import com.reddit.frontpage.util.Util;
import de.greenrobot.event.EventBus;
import javax.inject.Inject;
import kotlin.Unit;
import timber.log.Timber;

public abstract class InboxListingScreen extends BaseScreen implements View {
    OnThreadClickedListener f39177A;
    private final DefaultOnThreadClickListener f39178B = new DefaultOnThreadClickListener();
    @BindView
    ViewStub authContainer;
    @BindView
    ViewStub emptyContainer;
    @BindView
    FrameLayout mContentContainer;
    @BindView
    LinearLayout mErrorContainer;
    @BindView
    TextView mErrorMessage;
    @BindView
    RecyclerView mListView;
    @BindView
    TextView mRetryButton;
    @BindView
    SwipeRefreshLayout mSwipeRefreshLayout;
    private android.view.View f39179v;
    @Inject
    protected ThingReportPresenter f39180w;
    protected android.view.View f39181x;
    protected RecyclerHeaderFooterAdapter f39182y;
    protected MessageListingProvider f39183z;

    public interface OnThreadClickedListener {
        void mo4977a(MessageThread messageThread);
    }

    private class DefaultOnThreadClickListener implements OnThreadClickedListener {
        final /* synthetic */ InboxListingScreen f28994a;

        private DefaultOnThreadClickListener(InboxListingScreen inboxListingScreen) {
            this.f28994a = inboxListingScreen;
        }

        public final void mo4977a(MessageThread messageThread) {
            Message message = (Message) messageThread.f21245c.m23360a(0).f21182a.getData();
            Routing.m22623a((Screen) this.f28994a, Nav.m22567b(message.getId(), MessageUtil.m23814a(message)));
        }
    }

    private class InboxAdapter extends Adapter<InboxMessageViewHolder> {
        final /* synthetic */ InboxListingScreen f28995a;

        private InboxAdapter(InboxListingScreen inboxListingScreen) {
            this.f28995a = inboxListingScreen;
        }

        public final /* synthetic */ void m30053a(ViewHolder viewHolder, int i) {
            InboxMessageViewHolder inboxMessageViewHolder = (InboxMessageViewHolder) viewHolder;
            MessageThread b = this.f28995a.f39183z.b(i);
            Context context = inboxMessageViewHolder.overflowMenu.getContext();
            int a = MessageUtil.m23813a(b);
            int i2 = 1;
            if (a == 4) {
                Notification notification = (Notification) b.f21245c.m23360a(0).f21182a.getData();
                inboxMessageViewHolder.m30056a(notification);
                InboxListingScreen inboxListingScreen = inboxMessageViewHolder.f28996a;
                inboxMessageViewHolder.m30058b(InboxListingScreen.m39175b(notification));
                inboxMessageViewHolder.preview.setText(notification.body);
            } else {
                Message b2 = MessageUtil.m23819b(b);
                InboxListingScreen inboxListingScreen2 = inboxMessageViewHolder.f28996a;
                boolean a2 = InboxListingScreen.m39174b(b2);
                if (a == 0) {
                    inboxMessageViewHolder.m30054a(b2);
                } else if (a == 1) {
                    inboxMessageViewHolder.m30059c(b2, a2);
                } else if (a == 2) {
                    inboxMessageViewHolder.m30057b(b2, a2);
                } else if (a == 3) {
                    inboxMessageViewHolder.m30055a(b2, a2);
                } else {
                    StringBuilder stringBuilder = new StringBuilder("Could not identify message type: ");
                    stringBuilder.append(a);
                    Timber.e(stringBuilder.toString(), new Object[0]);
                    inboxMessageViewHolder.m30054a(b2);
                }
                inboxMessageViewHolder.m30058b(a2);
                inboxMessageViewHolder.preview.setText(Util.m24030g(b2.body_html));
            }
            String charSequence = inboxMessageViewHolder.metadata.getText().toString();
            if (!(charSequence.contains(context.getString(C1761R.string.inbox_message_post_reply)) || charSequence.contains(context.getString(C1761R.string.inbox_message_comment_reply)))) {
                if (!charSequence.contains(context.getString(C1761R.string.inbox_message_mention))) {
                    i2 = 0;
                }
            }
            if (i2 != 0) {
                charSequence = m30048a(inboxMessageViewHolder.subject.getText().toString().split("\\s+")[0]);
            } else {
                charSequence = m30048a(inboxMessageViewHolder.metadata.getText().toString());
            }
            if (!charSequence.contains("reddit")) {
                Account d = SessionManager.b().d();
                if (!(d != null ? charSequence.equals(d.getName()) : false)) {
                    if (this.f28995a.getClass() != ModeratorInboxListingScreen.class) {
                        inboxMessageViewHolder.overflowMenu.setVisibility(0);
                        inboxMessageViewHolder.overflowMenu.setOnClickListener(new InboxListingScreen$InboxAdapter$$Lambda$0(this, context, charSequence, b));
                        inboxMessageViewHolder.c.setOnClickListener(new InboxListingScreen$InboxAdapter$$Lambda$1(this, b));
                    }
                }
            }
            inboxMessageViewHolder.overflowMenu.setVisibility(8);
            inboxMessageViewHolder.overflowMenu.setOnClickListener(new InboxListingScreen$InboxAdapter$$Lambda$0(this, context, charSequence, b));
            inboxMessageViewHolder.c.setOnClickListener(new InboxListingScreen$InboxAdapter$$Lambda$1(this, b));
        }

        private static String m30048a(String str) {
            if (str != null) {
                if (str.length() != 0) {
                    if (str.contains(Operation.DIVISION)) {
                        str = str.split(Operation.DIVISION)[1].split("\\s+")[0];
                    }
                    return str;
                }
            }
            return "";
        }

        static final /* synthetic */ Unit m30049a(Context context, String str, MessageThread messageThread, DialogInterface dialogInterface) {
            MessageReportDialog.m34668a(context, str, context.getString(C1761R.string.action_report_message), messageThread.f21245c.m23360a(0).f21182a.getData()).m29514c();
            dialogInterface.dismiss();
            return null;
        }

        final /* synthetic */ Unit m30052a(String str, DialogInterface dialogInterface) {
            this.f28995a.f39180w.m34667a(str);
            dialogInterface.dismiss();
            return Unit.f25273a;
        }

        public final int m30050a() {
            return this.f28995a.f39183z.c();
        }

        public final /* synthetic */ ViewHolder m30051a(ViewGroup viewGroup, int i) {
            return new InboxMessageViewHolder(this.f28995a, LayoutInflater.from(this.f28995a.am_()).inflate(C1761R.layout.listitem_notification_thread, viewGroup, false));
        }
    }

    protected class InboxMessageViewHolder extends ViewHolder {
        final /* synthetic */ InboxListingScreen f28996a;
        @BindView
        TextView metadata;
        @BindView
        ImageView notificationIcon;
        @BindView
        ImageView overflowMenu;
        @BindView
        TextView preview;
        @BindView
        TextView subject;

        InboxMessageViewHolder(InboxListingScreen inboxListingScreen, android.view.View view) {
            this.f28996a = inboxListingScreen;
            super(view);
            ButterKnife.a(this, view);
        }

        final void m30055a(Message message, boolean z) {
            this.metadata.setText(InboxListingScreen.m39168a(Util.m24027f((int) C1761R.string.inbox_message_mention), message.getCreatedUtc()));
            message = Html.fromHtml(InboxListingScreen.m39169a(String.format(Util.m24027f((int) C1761R.string.fmt_u_name_no_split), new Object[]{message.author}), Util.m24027f((int) C1761R.string.inbox_message_mention_text), String.format(Util.m24027f((int) C1761R.string.fmt_r_name_no_split), new Object[]{message.subreddit})));
            if (!z) {
                message = message.toString();
            }
            this.subject.setText(message);
            this.notificationIcon.setImageResource(true);
        }

        final void m30057b(Message message, boolean z) {
            this.metadata.setText(InboxListingScreen.m39168a(Util.m24027f((int) C1761R.string.inbox_message_post_reply), message.getCreatedUtc()));
            message = Html.fromHtml(InboxListingScreen.m39169a(String.format(Util.m24027f((int) C1761R.string.fmt_u_name_no_split), new Object[]{message.author}), Util.m24027f((int) C1761R.string.inbox_message_comment_text), String.format(Util.m24027f((int) C1761R.string.fmt_r_name_no_split), new Object[]{message.subreddit})));
            if (!z) {
                message = message.toString();
            }
            this.subject.setText(message);
            this.notificationIcon.setImageResource(true);
        }

        final void m30059c(Message message, boolean z) {
            this.metadata.setText(InboxListingScreen.m39168a(Util.m24027f((int) C1761R.string.inbox_message_comment_reply), message.getCreatedUtc()));
            message = Html.fromHtml(InboxListingScreen.m39169a(String.format(Util.m24027f((int) C1761R.string.fmt_u_name_no_split), new Object[]{message.author}), Util.m24027f((int) C1761R.string.inbox_message_reply_text), String.format(Util.m24027f((int) C1761R.string.fmt_r_name_no_split), new Object[]{message.subreddit})));
            if (!z) {
                message = message.toString();
            }
            this.subject.setText(message);
            this.notificationIcon.setImageResource(true);
        }

        final void m30054a(Message message) {
            this.metadata.setText(InboxListingScreen.m39168a(MessageUtil.m23814a(message), message.getCreatedUtc()));
            CharSequence charSequence = message.link_title;
            message = message.subject;
            TextView textView = this.subject;
            if (!TextUtils.isEmpty(charSequence)) {
                message = charSequence;
            }
            textView.setText(message);
        }

        final void m30056a(Notification notification) {
            this.subject.setText(String.format(Util.m24027f((int) C1761R.string.fmt_trending_in_subreddit), new Object[]{notification.subreddit}));
            this.metadata.setText(InboxListingScreen.m39168a(Util.m24027f((int) C1761R.string.rdt_notification_recommendataion), notification.getCreatedUtc()));
            this.notificationIcon.setImageResource(C1761R.drawable.ic_icon_notify);
        }

        final void m30058b(boolean z) {
            Context context = this.f28996a.K.getContext();
            if (z) {
                z = ResourcesUtil.m22740i(context, true);
                this.notificationIcon.setColorFilter(z);
                this.overflowMenu.setColorFilter(z);
                this.subject.setTextAppearance(this.subject.getContext(), C1761R.style.TextAppearance.RedditBase.Body.Medium);
                return;
            }
            z = ResourcesUtil.m22740i(context, true);
            this.notificationIcon.setColorFilter(z);
            this.overflowMenu.setColorFilter(z);
            this.subject.setTextAppearance(this.subject.getContext(), C1761R.style.TextAppearance.RedditBase.Body);
        }
    }

    public class InboxMessageViewHolder_ViewBinding implements Unbinder {
        private InboxMessageViewHolder f28997b;

        public InboxMessageViewHolder_ViewBinding(InboxMessageViewHolder inboxMessageViewHolder, android.view.View view) {
            this.f28997b = inboxMessageViewHolder;
            inboxMessageViewHolder.notificationIcon = (ImageView) Utils.b(view, C1761R.id.notification_icon, "field 'notificationIcon'", ImageView.class);
            inboxMessageViewHolder.metadata = (TextView) Utils.b(view, C1761R.id.metadata, "field 'metadata'", TextView.class);
            inboxMessageViewHolder.subject = (TextView) Utils.b(view, C1761R.id.subject, "field 'subject'", TextView.class);
            inboxMessageViewHolder.preview = (TextView) Utils.b(view, C1761R.id.preview, "field 'preview'", TextView.class);
            inboxMessageViewHolder.overflowMenu = (ImageView) Utils.b(view, C1761R.id.overflowMenu, "field 'overflowMenu'", ImageView.class);
        }

        public final void m30060a() {
            InboxMessageViewHolder inboxMessageViewHolder = this.f28997b;
            if (inboxMessageViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f28997b = null;
            inboxMessageViewHolder.notificationIcon = null;
            inboxMessageViewHolder.metadata = null;
            inboxMessageViewHolder.subject = null;
            inboxMessageViewHolder.preview = null;
            inboxMessageViewHolder.overflowMenu = null;
        }
    }

    final /* synthetic */ void m39179P() {
        m39166Q();
    }

    protected final boolean af_() {
        return true;
    }

    public final Screen mo6458e() {
        return this;
    }

    public int mo7141s() {
        return C1761R.layout.fragment_inbox_listing;
    }

    public abstract String mo7443w();

    public final Context aa_() {
        return am_();
    }

    public InboxListingScreen() {
        DaggerThingReportComponent.m29281a().m22161a(FrontpageApplication.m28875k()).m22162a(new ThingReportModule(this)).m22163a().mo4743a(this);
    }

    protected void mo7144v() {
        this.f39183z = new MessageListingProvider(mo7443w());
        m37523a(this.f39183z);
    }

    public void onEvent(MessagesEvent messagesEvent) {
        if (TextUtils.equals(messagesEvent.a, mo7443w()) != null) {
            if (this.f39183z.mAfter == null) {
                this.f39182y.f34365c = null;
            }
            if (this.mSwipeRefreshLayout.b != null) {
                this.mListView.stopScroll();
                this.mSwipeRefreshLayout.setRefreshing(false);
            }
            this.mErrorContainer.setVisibility(8);
            this.mContentContainer.setVisibility(0);
            this.mSwipeRefreshLayout.setVisibility(0);
            this.f39179v.setVisibility(8);
            if (this.f39182y == null || this.f39182y.mo6510a() != null) {
                this.emptyContainer.setVisibility(8);
            } else {
                this.emptyContainer.setVisibility(0);
            }
            this.f39182y.a_.b();
        }
    }

    public void onEvent(ErrorEvent errorEvent) {
        if (TextUtils.equals(errorEvent.requestId, mo7443w())) {
            if (errorEvent instanceof MessageErrorEvent) {
                m39184b(errorEvent.exception);
                return;
            }
            super.onEvent(errorEvent);
        }
    }

    public android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.mRetryButton.setOnClickListener(new InboxListingScreen$$Lambda$0(this));
        ItemDecoration dividerItemDecoration = new DividerItemDecoration(am_());
        viewGroup = ResourcesUtil.m22723b(viewGroup.getContext(), (int) C1761R.attr.rdt_horizontal_divider_drawable);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        dividerItemDecoration.a = viewGroup;
        this.mListView.addItemDecoration(dividerItemDecoration);
        viewGroup = new LinearLayoutManager(am_(), 1, false);
        this.mListView.setLayoutManager(viewGroup);
        this.mListView.addOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ InboxListingScreen f28993b;

            public final void m30046a(RecyclerView recyclerView, int i, int i2) {
                super.a(recyclerView, i, i2);
                if (viewGroup.m() >= this.f28993b.f39183z.c() - 5 && this.f28993b.f39183z.d() != null) {
                    this.f28993b.f39183z.a(0);
                }
            }
        });
        Util.m23970a(this.mSwipeRefreshLayout);
        this.mSwipeRefreshLayout.setOnRefreshListener(new InboxListingScreen$$Lambda$1(this));
        this.f39179v = this.K.findViewById(C1761R.id.progress_bar);
        this.f39181x = layoutInflater.inflate(C1761R.layout.list_loading_footer, this.mListView, false);
        this.f39179v.setBackground(AnimUtil.m23637a(am_()));
        m39192y();
        this.f39182y = new RecyclerHeaderFooterAdapter(new InboxAdapter());
        this.f39182y.f34365c = this.f39181x;
        this.mListView.setAdapter(this.f39182y);
        if (SessionManager.b().c.isAnonymous() != null) {
            layoutInflater = this.authContainer.inflate();
            Button button = (Button) layoutInflater.findViewById(C1761R.id.login_button);
            Button button2 = (Button) layoutInflater.findViewById(C1761R.id.signup_button);
            button.setOnClickListener(new InboxListingScreen$$Lambda$2(this));
            button2.setOnClickListener(new InboxListingScreen$$Lambda$3(this));
        }
        return this.K;
    }

    final /* synthetic */ void m39178O() {
        m39192y();
        m39166Q();
    }

    private void m39166Q() {
        this.f39183z.a(true, null);
        InboxCountRepository inboxCountRepository = InboxCountRepository.a;
        InboxCountRepository.e();
    }

    public final void m39191x() {
        int c = this.f39183z.c();
        for (int i = 0; i < c; i++) {
            boolean b;
            Object id;
            MessageThread b2 = this.f39183z.b(i);
            if (MessageUtil.m23813a(b2) == 4) {
                Notification notification = (Notification) b2.f21245c.m23360a(0).f21182a.getData();
                b = m39175b(notification);
                id = notification.getId();
            } else {
                Message b3 = MessageUtil.m23819b(b2);
                b = m39174b(b3);
                id = b3.getName();
            }
            if (b) {
                MessageThreadScreen.f39192y.put(id, Boolean.valueOf(false));
            }
        }
        this.f39182y.a_.b();
    }

    protected void mo6992b(android.view.View view) {
        super.mo6992b(view);
        this.f39183z.a(false, null);
    }

    public final void mo6987a(android.view.View view) {
        super.mo6987a(view);
        this.f39181x = null;
        this.f39182y = null;
        this.f39177A = null;
    }

    public final void m39192y() {
        this.mErrorContainer.setVisibility(8);
        this.mContentContainer.setVisibility(0);
        this.mSwipeRefreshLayout.setVisibility(8);
        this.f39179v.setVisibility(0);
    }

    public final void m39184b(Exception exception) {
        this.f39179v.setVisibility(8);
        this.mContentContainer.setVisibility(8);
        this.mSwipeRefreshLayout.setVisibility(8);
        this.mErrorContainer.setVisibility(0);
        this.emptyContainer.setVisibility(8);
        if (exception instanceof NetworkError) {
            this.mErrorMessage.setText(C1761R.string.error_network_error);
        } else if (exception instanceof ServerError) {
            this.mErrorMessage.setText(C1761R.string.error_server_error);
        } else {
            m37526a(exception);
        }
    }

    private static boolean m39175b(Notification notification) {
        Boolean bool = (Boolean) MessageThreadScreen.f39192y.get(notification.getId());
        if (bool == null) {
            bool = Boolean.valueOf(notification._new);
        }
        return bool.booleanValue();
    }

    private static boolean m39174b(Message message) {
        Boolean bool = (Boolean) MessageThreadScreen.f39192y.get(message.getName());
        if (bool == null) {
            bool = Boolean.valueOf(message._new);
        }
        return bool.booleanValue();
    }

    protected static String m39168a(String str, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        j = DateUtil.m23684b(j);
        String string = FrontpageApplication.f27402a.getString(C1761R.string.unicode_bullet);
        String string2 = FrontpageApplication.f27402a.getString(C1761R.string.unicode_space);
        stringBuilder.append(str);
        stringBuilder.append(string2);
        stringBuilder.append(string);
        stringBuilder.append(string2);
        stringBuilder.append(j);
        return stringBuilder.toString();
    }

    public void onEvent(MessageThreadEvent messageThreadEvent) {
        EventBus.getDefault().removeStickyEvent((Object) messageThreadEvent);
        this.f39183z.a(true, null);
    }

    public final boolean mo7200K() {
        if (this.mListView == null) {
            return false;
        }
        if (!ListUtil.m23810a((LinearLayoutManager) this.mListView.getLayoutManager())) {
            this.mListView.smoothScrollToPosition(0);
        }
        return true;
    }

    public final void mo4815b(String str) {
        DefaultImpls.m22822a((View) this, str);
    }

    public final void mo4814a(Throwable th) {
        DefaultImpls.m22823a((View) this, th);
    }

    public final void mo4816b(Throwable th) {
        DefaultImpls.m22825b(this, th);
    }

    static /* synthetic */ String m39169a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder("<b>");
        stringBuilder.append(str);
        stringBuilder.append("</b> ");
        stringBuilder.append(str2);
        stringBuilder.append(" <b>");
        stringBuilder.append(str3);
        stringBuilder.append("</b>");
        return stringBuilder.toString();
    }
}
