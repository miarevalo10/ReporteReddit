package com.reddit.frontpage.ui.inbox;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.provider.MessageThreadProvider;
import com.reddit.datalibrary.frontpage.data.provider.MessageThreadProvider.1;
import com.reddit.datalibrary.frontpage.data.provider.MessageThreadProvider.MessageThreadEvent;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Message;
import com.reddit.datalibrary.frontpage.requests.models.v1.MessageWrapper;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.detail.comments.collapsetree.CollapseTree;
import com.reddit.frontpage.ui.listing.adapter.RecyclerHeaderFooterAdapter;
import com.reddit.frontpage.util.DateUtil;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import com.reddit.frontpage.util.MessageUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.BaseHtmlTextView;
import java.util.UUID;
import org.parceler.Parcel;

public class MessageThreadScreen extends BaseScreen {
    public static final LruCache<String, Boolean> f39192y = new LruCache(100);
    @State
    String correspondent;
    @BindView
    RecyclerView messageList;
    @BindView
    TextView replyButton;
    @State
    String requestId = UUID.randomUUID().toString();
    @State
    String threadId;
    TextView f39193v;
    MessageThreadProvider f39194w;
    RecyclerHeaderFooterAdapter f39195x;

    @Parcel
    static class DeepLinker implements ScreenDeepLinker {
        String messageId;

        DeepLinker() {
        }

        public Screen createScreen() {
            return MessageThreadScreen.m39207a(this.messageId, null);
        }
    }

    private class MessageThreadAdapter extends Adapter<MessageViewHolder> {
        final /* synthetic */ MessageThreadScreen f29000a;

        private MessageThreadAdapter(MessageThreadScreen messageThreadScreen) {
            this.f29000a = messageThreadScreen;
        }

        public final /* synthetic */ void m30068a(ViewHolder viewHolder, int i) {
            MessageViewHolder messageViewHolder = (MessageViewHolder) viewHolder;
            MessageWrapper messageWrapper = (MessageWrapper) this.f29000a.f39194w.a(i);
            Message message = (Message) messageWrapper.getData();
            StringBuilder stringBuilder = new StringBuilder(MessageUtil.m23820b(message));
            CharSequence b = DateUtil.m23684b(message.getCreatedUtc());
            String f = Util.m24027f((int) C1761R.string.unicode_bullet);
            String f2 = Util.m24027f((int) C1761R.string.unicode_space);
            stringBuilder.append(f2);
            stringBuilder.append(f);
            stringBuilder.append(f2);
            stringBuilder.append(b);
            messageViewHolder.f29001a.setText(stringBuilder.toString());
            messageViewHolder.f29002b.setHtmlFromString(message.body_html);
            if (MessageThreadScreen.f39192y.get(((Message) messageWrapper.getData()).getName()) == null) {
                MessageUtil.m23817a(SessionManager.b().c, (Message) messageWrapper.getData(), 0);
            }
            MessageThreadScreen.f39192y.put(((Message) messageWrapper.getData()).getName(), Boolean.valueOf(false));
        }

        public final int m30066a() {
            return this.f29000a.f39194w.a();
        }

        public final /* synthetic */ ViewHolder m30067a(ViewGroup viewGroup, int i) {
            return new MessageViewHolder(this.f29000a, LayoutInflater.from(this.f29000a.am_()).inflate(C1761R.layout.listitem_message, viewGroup, false));
        }
    }

    private class MessageViewHolder extends ViewHolder {
        final TextView f29001a;
        final BaseHtmlTextView f29002b;
        final /* synthetic */ MessageThreadScreen f29003p;

        MessageViewHolder(MessageThreadScreen messageThreadScreen, View view) {
            this.f29003p = messageThreadScreen;
            super(view);
            this.f29001a = (TextView) view.findViewById(C1761R.id.metadata);
            this.f29002b = (BaseHtmlTextView) view.findViewById(C1761R.id.body);
        }
    }

    public final int mo7141s() {
        return C1761R.layout.fragment_message_thread;
    }

    public final int mo7143u() {
        return 2;
    }

    public static MessageThreadScreen m39207a(String str, String str2) {
        MessageThreadScreen messageThreadScreen = new MessageThreadScreen();
        messageThreadScreen.threadId = str;
        messageThreadScreen.correspondent = str2;
        return messageThreadScreen;
    }

    public static ScreenDeepLinker m39208a(String str) {
        ScreenDeepLinker deepLinker = new DeepLinker();
        deepLinker.messageId = str;
        return deepLinker;
    }

    protected final void mo7144v() {
        this.f39194w = new MessageThreadProvider(this.threadId);
        m37523a(this.f39194w);
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        n();
        this.messageList.setLayoutManager(new LinearLayoutManager(am_(), 1, false));
        this.f39195x = new RecyclerHeaderFooterAdapter(new MessageThreadAdapter());
        this.f39193v = (TextView) layoutInflater.inflate(C1761R.layout.listheader_message_thread_title, this.messageList, false);
        this.f39195x.f34364b = this.f39193v;
        this.messageList.setAdapter(this.f39195x);
        return this.K;
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        view = this.f39194w;
        String str = this.requestId;
        view.mMessageTree = new CollapseTree();
        RemoteRedditApiDataSource.e(view.threadId).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new 1(view, str));
    }

    protected final void mo7185a(ActionBar actionBar) {
        actionBar.a(this.correspondent);
    }

    public void onEvent(MessageThreadEvent messageThreadEvent) {
        messageThreadEvent = this.f39194w.a();
        if (messageThreadEvent > null) {
            Message message = (Message) this.f39194w.a(0).getData();
            this.correspondent = MessageUtil.m23814a(message);
            this.f39193v.setText(message.subject);
            String username = SessionManager.b().c.getUsername();
            int i = messageThreadEvent - 1;
            while (i >= 0) {
                Message message2 = (Message) this.f39194w.a(i).getData();
                if (Util.m24017d(message2.author, username)) {
                    i--;
                } else {
                    if (am_() != null) {
                        this.replyButton.setVisibility(0);
                        this.replyButton.setOnClickListener(new MessageThreadScreen$$Lambda$0(this, message2));
                    }
                    this.f39195x.a_.b();
                    m37537h(this.correspondent);
                    ((LinearLayoutManager) this.messageList.getLayoutManager()).c(messageThreadEvent);
                }
            }
            this.f39195x.a_.b();
            m37537h(this.correspondent);
            ((LinearLayoutManager) this.messageList.getLayoutManager()).c(messageThreadEvent);
        }
    }
}
