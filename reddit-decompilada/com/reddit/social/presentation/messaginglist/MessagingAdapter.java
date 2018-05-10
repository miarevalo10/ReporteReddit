package com.reddit.social.presentation.messaginglist;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.reddit.frontpage.util.DateUtil;
import com.reddit.frontpage.util.kotlin.CollectionsKt;
import com.reddit.social.domain.functions.HasMore;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.HeaderMessageData;
import com.reddit.social.presentation.presentationobjects.LinkEmbedState;
import com.reddit.social.presentation.presentationobjects.MessageData;
import com.reddit.social.presentation.presentationobjects.MessageType;
import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.reddit.social.presentation.presentationobjects.TypingIndicator;
import com.reddit.social.util.NotifyingList;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.anko.CustomLayoutPropertiesKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004¢\u0006\u0002\u0010\bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011J\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 J\b\u0010\"\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0016J\u0018\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\nH\u0016J\u0018\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\nH\u0016J\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u0006J\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001aJ\u0014\u0010.\u001a\u00020\u001c2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u0010J\u000e\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u000eJ\u0010\u00103\u001a\u00020\u001c2\b\u00104\u001a\u0004\u0018\u00010\u001aJ\u0016\u00105\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0007J\u0016\u00107\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u0006J\u0016\u00108\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001a2\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J \u0010=\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R7\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108B@BX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/reddit/social/presentation/messaginglist/MessagingAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/social/presentation/messaginglist/BaseMessageViewHolder;", "linkEmbedLoaded", "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Pair;", "", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;", "(Lio/reactivex/subjects/PublishSubject;)V", "FIVE_MINUTES", "", "headerMessagedata", "Lcom/reddit/social/presentation/presentationobjects/HeaderMessageData;", "messageItemOnClickListener", "Lcom/reddit/social/presentation/messaginglist/MessageItemOnClickListener;", "<set-?>", "", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "messages", "getMessages", "()Ljava/util/List;", "setMessages", "(Ljava/util/List;)V", "messages$delegate", "Lcom/reddit/social/util/NotifyingList;", "typingIndicatorTitle", "", "addNewMessage", "", "message", "addNewMessages", "batch", "Lcom/reddit/social/domain/functions/MessagesBatch;", "addOldMessages", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeMessage", "messageId", "requestId", "setMembers", "members", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "setMessageItemOnClickListener", "listener", "setTypingIndicatorTitle", "title", "updateLinkEmbed", "linkEmbedState", "updateMessageId", "updateMessageStatus", "status", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "updateMessages", "addFooter", "addHeaderIf", "hasMore", "Lcom/reddit/social/domain/functions/HasMore;", "removeFooter", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MessagingAdapter.kt */
public final class MessagingAdapter extends Adapter<BaseMessageViewHolder> {
    static final /* synthetic */ KProperty[] f29885a = new KProperty[]{Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(MessagingAdapter.class), "messages", "getMessages()Ljava/util/List;"))};
    public MessageItemOnClickListener f29886b;
    public final HeaderMessageData f29887c = new HeaderMessageData();
    public String f29888f;
    private final int f29889g = 300000;
    private final NotifyingList f29890h = new NotifyingList(CollectionsKt__CollectionsKt.m26790a(), MessagingAdapter$messages$2.f37569a);
    private final PublishSubject<Pair<Long, LinkEmbedState>> f29891i;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f22411a;
        public static final /* synthetic */ int[] f22412b;

        static {
            int[] iArr = new int[HasMore.values().length];
            f22411a = iArr;
            iArr[HasMore.f22299b.ordinal()] = 1;
            iArr = new int[MessageType.values().length];
            f22412b = iArr;
            iArr[MessageType.f22455l.ordinal()] = 1;
            f22412b[MessageType.f22456m.ordinal()] = 2;
        }
    }

    public final void m30873a(List<? extends HasMessageData> list) {
        this.f29890h.m30902a(this, f29885a[0], list);
    }

    public final List<HasMessageData> m30875b() {
        return this.f29890h.m30901a(this, f29885a[0]);
    }

    public MessagingAdapter(PublishSubject<Pair<Long, LinkEmbedState>> publishSubject) {
        Intrinsics.m26847b(publishSubject, "linkEmbedLoaded");
        this.f29891i = publishSubject;
    }

    public final /* synthetic */ ViewHolder m30869a(ViewGroup viewGroup, int i) {
        BaseMessageViewHolder a;
        ViewGroup viewGroup2 = viewGroup;
        Intrinsics.m26847b(viewGroup2, "parent");
        MessageType messageType = MessageType.values()[i];
        Object context;
        switch (WhenMappings.f22412b[messageType.ordinal()]) {
            case 1:
                context = viewGroup.getContext();
                Intrinsics.m26843a(context, "parent.context");
                a = HeaderMessageViewHolderKt.m24703a(context);
                break;
            case 2:
                context = viewGroup.getContext();
                Intrinsics.m26843a(context, "parent.context");
                a = TypingIndicatorViewHolderKt.m24718a(context);
                break;
            default:
                Object context2 = viewGroup.getContext();
                Intrinsics.m26843a(context2, "parent.context");
                MessageContentViewHolder a2 = MessageContentKt.m24709a(viewGroup2, messageType);
                MessageView messageView = new MessageView(context2);
                messageView.setLayoutParams(new LayoutParams(CustomLayoutPropertiesKt.m28400a(), CustomLayoutPropertiesKt.m28401b()));
                messageView.setContent(a2);
                a = new MessageViewHolder(messageView, messageView.getDateContainer(), messageView.getMessageContainer(), messageView.getDateText(), messageView.getTimeText(), messageView.getProfileIcon(), messageView.getProfileIconContainer(), messageView.getName(), messageView.getContentContainer(), a2, messageView.getSentStatusText());
                break;
        }
        return a;
    }

    public final /* synthetic */ void m30871a(ViewHolder viewHolder, int i) {
        BaseMessageViewHolder baseMessageViewHolder = (BaseMessageViewHolder) viewHolder;
        Intrinsics.m26847b(baseMessageViewHolder, "holder");
        HasMessageData hasMessageData = (HasMessageData) m30875b().get(i);
        MessageData a = hasMessageData.mo5204a();
        if (baseMessageViewHolder instanceof HeaderMessageViewHolder) {
            HeaderMessageViewHolder headerMessageViewHolder = (HeaderMessageViewHolder) baseMessageViewHolder;
            if (hasMessageData == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.social.presentation.presentationobjects.HeaderMessageData");
            }
            HeaderMessageViewHolderKt.m24704a(headerMessageViewHolder, (HeaderMessageData) hasMessageData);
        } else if (baseMessageViewHolder instanceof TypingIndicatorViewHolder) {
            TypingIndicatorViewHolder typingIndicatorViewHolder = (TypingIndicatorViewHolder) baseMessageViewHolder;
            if (hasMessageData == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.social.presentation.presentationobjects.TypingIndicator");
            }
            TypingIndicatorViewHolderKt.m24719a(typingIndicatorViewHolder, (TypingIndicator) hasMessageData);
        } else {
            if (baseMessageViewHolder instanceof MessageViewHolder) {
                boolean z;
                boolean z2 = true;
                if (i < CollectionsKt__CollectionsKt.m26787a(m30875b())) {
                    i = ((HasMessageData) m30875b().get(i + 1)).mo5204a();
                    boolean e = DateUtil.m23687e(a.f22430c, i.f22430c) ^ 1;
                    z = a.f22430c - i.f22430c > ((long) this.f29889g);
                    i = Intrinsics.m26845a(a.f22432e, i.f22432e) ^ 1;
                    if (!z) {
                        if (i == 0) {
                            z2 = false;
                        }
                    }
                    z = z2;
                    z2 = e;
                } else {
                    z = true;
                }
                MessageViewHolderKt.m24717a((MessageViewHolder) baseMessageViewHolder, hasMessageData, z2, z, this.f29886b, this.f29891i);
            }
        }
    }

    public final List<HasMessageData> m30870a(List<? extends HasMessageData> list, HasMore hasMore) {
        if (WhenMappings.f22411a[hasMore.ordinal()] != 1) {
            return list;
        }
        return CollectionsKt___CollectionsKt.m41419a((Collection) list, (Object) this.f29887c);
    }

    public final List<HasMessageData> m30876b(List<? extends HasMessageData> list) {
        return CollectionsKt.m24072a(list, new TypingIndicator(this.f29888f, null, 2));
    }

    public static List<HasMessageData> m30867c(List<? extends HasMessageData> list) {
        return CollectionsKt___CollectionsKt.m41422b((Iterable) list, (Object) CollectionsKt___CollectionsKt.m41430d((List) list));
    }

    public final void m30872a(String str, SentStatus sentStatus) {
        Intrinsics.m26847b(str, "requestId");
        Intrinsics.m26847b(sentStatus, "status");
        int i = 0;
        for (HasMessageData a : m30875b()) {
            if (Intrinsics.m26845a(a.mo5204a().f22428a, (Object) str)) {
                break;
            }
            i++;
        }
        i = -1;
        if (i == -1) {
            Timber.e("Error adding group message. No index", new Object[0]);
            return;
        }
        ((HasMessageData) m30875b().get(i)).mo5204a().f22436i = sentStatus;
        if (Intrinsics.m26845a((Object) sentStatus, SentStatus.f22462c) != null) {
            d(i);
        }
    }

    public final int m30874b(int i) {
        return ((HasMessageData) m30875b().get(i)).mo5204a().f22435h.ordinal();
    }

    public final int m30868a() {
        return m30875b().size();
    }
}
