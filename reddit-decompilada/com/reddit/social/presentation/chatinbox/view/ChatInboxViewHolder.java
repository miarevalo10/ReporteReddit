package com.reddit.social.presentation.chatinbox.view;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u0002062\u0006\u0010?\u001a\u000208H\u0002R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001a\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001e\u0010\u001d\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001e\u0010 \u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\nR\u001e\u0010#\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001e\u0010&\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\nR\u001e\u0010)\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001e\u0010,\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001e\u0010/\u001a\u0002008\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006@"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/view/ChatInboxViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "contentContainer", "Landroid/widget/RelativeLayout;", "getContentContainer", "()Landroid/widget/RelativeLayout;", "setContentContainer", "(Landroid/widget/RelativeLayout;)V", "coverImage", "Landroid/widget/ImageView;", "getCoverImage", "()Landroid/widget/ImageView;", "setCoverImage", "(Landroid/widget/ImageView;)V", "dateText", "Landroid/widget/TextView;", "getDateText", "()Landroid/widget/TextView;", "setDateText", "(Landroid/widget/TextView;)V", "divider", "getDivider", "setDivider", "iconBack", "getIconBack", "setIconBack", "iconFront", "getIconFront", "setIconFront", "iconPairContainer", "getIconPairContainer", "setIconPairContainer", "message", "getMessage", "setMessage", "seeAllContainer", "getSeeAllContainer", "setSeeAllContainer", "seeAllView", "getSeeAllView", "setSeeAllView", "title", "getTitle", "setTitle", "typingIndicatorContainer", "Landroid/widget/LinearLayout;", "getTypingIndicatorContainer", "()Landroid/widget/LinearLayout;", "setTypingIndicatorContainer", "(Landroid/widget/LinearLayout;)V", "bind", "", "conversation", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "showDivider", "", "showSeeAll", "chatInboxItemClick", "Lcom/reddit/social/presentation/chatinbox/view/ChatInboxItemEvent;", "styleText", "chatInboxItem", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatInboxViewHolder.kt */
public final class ChatInboxViewHolder extends ViewHolder {
    @BindView
    public RelativeLayout contentContainer;
    @BindView
    public ImageView coverImage;
    @BindView
    public TextView dateText;
    @BindView
    public TextView divider;
    @BindView
    public ImageView iconBack;
    @BindView
    public ImageView iconFront;
    @BindView
    public RelativeLayout iconPairContainer;
    @BindView
    public TextView message;
    @BindView
    public RelativeLayout seeAllContainer;
    @BindView
    public TextView seeAllView;
    @BindView
    public TextView title;
    @BindView
    public LinearLayout typingIndicatorContainer;

    public ChatInboxViewHolder(View view) {
        Intrinsics.m26847b(view, "itemView");
        super(view);
        ButterKnife.a(this, view);
    }
}
