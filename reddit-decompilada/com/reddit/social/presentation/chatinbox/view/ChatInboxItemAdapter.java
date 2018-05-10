package com.reddit.social.presentation.chatinbox.view;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.DateUtil;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.AvatarUtilKt;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0014\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/view/ChatInboxItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/social/presentation/chatinbox/view/ChatInboxViewHolder;", "enableShowingDividers", "", "chatInboxItemEvent", "Lcom/reddit/social/presentation/chatinbox/view/ChatInboxItemEvent;", "(ZLcom/reddit/social/presentation/chatinbox/view/ChatInboxItemEvent;)V", "chatInboxItems", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "getItemCount", "", "lastItemIndex", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "chatInboxItemList", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatInboxItemAdapter.kt */
public final class ChatInboxItemAdapter extends Adapter<ChatInboxViewHolder> {
    public List<ChatInboxItem> f29623a = CollectionsKt__CollectionsKt.m26790a();
    private final boolean f29624b;
    private final ChatInboxItemEvent f29625c;

    public final /* synthetic */ ViewHolder m30648a(ViewGroup viewGroup, int i) {
        Intrinsics.m26847b(viewGroup, "parent");
        Object inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.listitem_conversation, viewGroup, false);
        Intrinsics.m26843a(inflate, "view");
        return (ViewHolder) new ChatInboxViewHolder(inflate);
    }

    public final /* synthetic */ void m30649a(ViewHolder viewHolder, int i) {
        boolean z;
        boolean z2;
        ChatInboxItemEvent chatInboxItemEvent;
        TextView textView;
        DateUtil dateUtil;
        CharSequence h;
        boolean z3;
        int i2;
        TextView textView2;
        Object context;
        int i3;
        CharSequence charSequence;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        RelativeLayout relativeLayout;
        TextView textView3;
        CharSequence charSequence2;
        RelativeLayout relativeLayout2;
        String f;
        LinearLayout linearLayout;
        int i4 = i;
        ChatInboxViewHolder chatInboxViewHolder = (ChatInboxViewHolder) viewHolder;
        Intrinsics.m26847b(chatInboxViewHolder, "holder");
        ChatInboxItem chatInboxItem = (ChatInboxItem) this.f29623a.get(i4);
        ChatInboxItem chatInboxItem2 = i4 > 0 ? (ChatInboxItem) r0.f29623a.get(i4 - 1) : null;
        if (r0.f29624b) {
            if (i4 != 0) {
                if (chatInboxItem2 == null || chatInboxItem2.f22315c == chatInboxItem.f22315c) {
                    i4 = 0;
                    if (i4 != 0) {
                        z = true;
                        z2 = chatInboxItem.f22315c && chatInboxItem.f22321i > 0;
                        chatInboxItemEvent = r0.f29625c;
                        Intrinsics.m26847b(chatInboxItem, "conversation");
                        Intrinsics.m26847b(chatInboxItemEvent, "chatInboxItemClick");
                        textView = chatInboxViewHolder.title;
                        if (textView == null) {
                            Intrinsics.m26844a("title");
                        }
                        textView.setText(chatInboxItem.f22313a);
                        textView = chatInboxViewHolder.dateText;
                        if (textView == null) {
                            Intrinsics.m26844a("dateText");
                        }
                        dateUtil = DateUtil.f20370a;
                        if (DateUtil.m22710f(chatInboxItem.f22317e)) {
                            dateUtil = DateUtil.f20370a;
                            h = DateUtil.m22712h(chatInboxItem.f22317e);
                        } else {
                            dateUtil = DateUtil.f20370a;
                            if (DateUtil.m22709e(chatInboxItem.f22317e)) {
                                h = Util.m24027f((int) C1761R.string.label_yesterday);
                            } else {
                                dateUtil = DateUtil.f20370a;
                                h = DateUtil.m22711g(chatInboxItem.f22317e);
                            }
                        }
                        textView.setText(h);
                        z3 = chatInboxItem.f22315c;
                        i2 = chatInboxItem.f22318f > 0 ? 1 : 0;
                        if (z3) {
                            if (i2 != 0) {
                                textView = chatInboxViewHolder.title;
                                if (textView == null) {
                                    Intrinsics.m26844a("title");
                                }
                                textView.setTypeface(null, 0);
                                textView2 = chatInboxViewHolder.title;
                                if (textView2 == null) {
                                    Intrinsics.m26844a("title");
                                }
                                context = textView2.getContext();
                                Intrinsics.m26843a(context, "title.context");
                                i3 = ResourcesUtil.m22740i(context, C1761R.attr.rdt_meta_text_color);
                                textView = chatInboxViewHolder.message;
                                if (textView == null) {
                                    Intrinsics.m26844a("message");
                                }
                                textView.setTextColor(i3);
                                textView = chatInboxViewHolder.dateText;
                                if (textView == null) {
                                    Intrinsics.m26844a("dateText");
                                }
                                textView.setTextColor(i3);
                                textView2 = chatInboxViewHolder.message;
                                if (textView2 == null) {
                                    Intrinsics.m26844a("message");
                                }
                                if (chatInboxItem.f22315c) {
                                    charSequence = chatInboxItem.f22316d;
                                } else if (chatInboxItem.f22322j) {
                                    charSequence = Util.m24027f((int) C1761R.string.rdt_label_group_invite);
                                } else {
                                    charSequence = Util.m24027f((int) C1761R.string.rdt_label_wants_to_chat);
                                }
                                textView2.setText(charSequence);
                                imageView = chatInboxViewHolder.coverImage;
                                if (imageView == null) {
                                    Intrinsics.m26844a("coverImage");
                                }
                                imageView2 = chatInboxViewHolder.iconFront;
                                if (imageView2 == null) {
                                    Intrinsics.m26844a("iconFront");
                                }
                                imageView3 = chatInboxViewHolder.iconBack;
                                if (imageView3 == null) {
                                    Intrinsics.m26844a("iconBack");
                                }
                                relativeLayout = chatInboxViewHolder.iconPairContainer;
                                if (relativeLayout == null) {
                                    Intrinsics.m26844a("iconPairContainer");
                                }
                                AvatarUtilKt.m23657a(imageView, imageView2, imageView3, relativeLayout, chatInboxItem.f22319g, chatInboxItem.f22320h, chatInboxItem.f22322j, chatInboxItem.f22315c);
                                textView2 = chatInboxViewHolder.divider;
                                if (textView2 == null) {
                                    Intrinsics.m26844a("divider");
                                }
                                ViewsKt.m24106b(textView2, z);
                                if (z) {
                                    textView3 = chatInboxViewHolder.divider;
                                    if (textView3 == null) {
                                        Intrinsics.m26844a("divider");
                                    }
                                    if (chatInboxItem.f22315c) {
                                        charSequence2 = "Requests";
                                    } else {
                                        charSequence2 = "Conversations";
                                    }
                                    textView3.setText(charSequence2);
                                }
                                relativeLayout2 = chatInboxViewHolder.seeAllContainer;
                                if (relativeLayout2 == null) {
                                    Intrinsics.m26844a("seeAllContainer");
                                }
                                ViewsKt.m24106b(relativeLayout2, z2);
                                if (z2) {
                                    relativeLayout2 = chatInboxViewHolder.seeAllContainer;
                                    if (relativeLayout2 == null) {
                                        Intrinsics.m26844a("seeAllContainer");
                                    }
                                    relativeLayout2.setOnClickListener(new ChatInboxViewHolder$bind$1(chatInboxItemEvent, chatInboxItem));
                                    i4 = chatInboxItem.f22321i;
                                    if (i4 <= 9) {
                                        f = Util.m24027f((int) C1761R.string.more_than_nine);
                                        Intrinsics.m26843a((Object) f, "Util.getString(R.string.more_than_nine)");
                                    } else {
                                        f = String.valueOf(i4);
                                    }
                                    textView2 = chatInboxViewHolder.seeAllView;
                                    if (textView2 == null) {
                                        Intrinsics.m26844a("seeAllView");
                                    }
                                    textView2.setText(Util.m23960a((int) C1761R.string.fmt_label_see_all_1, f));
                                }
                                relativeLayout2 = chatInboxViewHolder.contentContainer;
                                if (relativeLayout2 == null) {
                                    Intrinsics.m26844a("contentContainer");
                                }
                                relativeLayout2.setOnClickListener(new ChatInboxViewHolder$bind$2(chatInboxItemEvent, chatInboxItem));
                                relativeLayout2 = chatInboxViewHolder.contentContainer;
                                if (relativeLayout2 == null) {
                                    Intrinsics.m26844a("contentContainer");
                                }
                                relativeLayout2.setOnLongClickListener(new ChatInboxViewHolder$bind$3(chatInboxItemEvent, chatInboxItem));
                                linearLayout = chatInboxViewHolder.typingIndicatorContainer;
                                if (linearLayout == null) {
                                    Intrinsics.m26844a("typingIndicatorContainer");
                                }
                                linearLayout.setVisibility(8);
                            }
                        }
                        textView = chatInboxViewHolder.title;
                        if (textView == null) {
                            Intrinsics.m26844a("title");
                        }
                        textView.setTypeface(null, 1);
                        textView2 = chatInboxViewHolder.title;
                        if (textView2 == null) {
                            Intrinsics.m26844a("title");
                        }
                        context = textView2.getContext();
                        Intrinsics.m26843a(context, "title.context");
                        i3 = ResourcesUtil.m22740i(context, C1761R.attr.rdt_body_text_color);
                        textView = chatInboxViewHolder.message;
                        if (textView == null) {
                            Intrinsics.m26844a("message");
                        }
                        textView.setTextColor(i3);
                        textView = chatInboxViewHolder.dateText;
                        if (textView == null) {
                            Intrinsics.m26844a("dateText");
                        }
                        textView.setTextColor(i3);
                        textView2 = chatInboxViewHolder.message;
                        if (textView2 == null) {
                            Intrinsics.m26844a("message");
                        }
                        if (chatInboxItem.f22315c) {
                            charSequence = chatInboxItem.f22316d;
                        } else if (chatInboxItem.f22322j) {
                            charSequence = Util.m24027f((int) C1761R.string.rdt_label_group_invite);
                        } else {
                            charSequence = Util.m24027f((int) C1761R.string.rdt_label_wants_to_chat);
                        }
                        textView2.setText(charSequence);
                        imageView = chatInboxViewHolder.coverImage;
                        if (imageView == null) {
                            Intrinsics.m26844a("coverImage");
                        }
                        imageView2 = chatInboxViewHolder.iconFront;
                        if (imageView2 == null) {
                            Intrinsics.m26844a("iconFront");
                        }
                        imageView3 = chatInboxViewHolder.iconBack;
                        if (imageView3 == null) {
                            Intrinsics.m26844a("iconBack");
                        }
                        relativeLayout = chatInboxViewHolder.iconPairContainer;
                        if (relativeLayout == null) {
                            Intrinsics.m26844a("iconPairContainer");
                        }
                        AvatarUtilKt.m23657a(imageView, imageView2, imageView3, relativeLayout, chatInboxItem.f22319g, chatInboxItem.f22320h, chatInboxItem.f22322j, chatInboxItem.f22315c);
                        textView2 = chatInboxViewHolder.divider;
                        if (textView2 == null) {
                            Intrinsics.m26844a("divider");
                        }
                        ViewsKt.m24106b(textView2, z);
                        if (z) {
                            textView3 = chatInboxViewHolder.divider;
                            if (textView3 == null) {
                                Intrinsics.m26844a("divider");
                            }
                            if (chatInboxItem.f22315c) {
                                charSequence2 = "Requests";
                            } else {
                                charSequence2 = "Conversations";
                            }
                            textView3.setText(charSequence2);
                        }
                        relativeLayout2 = chatInboxViewHolder.seeAllContainer;
                        if (relativeLayout2 == null) {
                            Intrinsics.m26844a("seeAllContainer");
                        }
                        ViewsKt.m24106b(relativeLayout2, z2);
                        if (z2) {
                            relativeLayout2 = chatInboxViewHolder.seeAllContainer;
                            if (relativeLayout2 == null) {
                                Intrinsics.m26844a("seeAllContainer");
                            }
                            relativeLayout2.setOnClickListener(new ChatInboxViewHolder$bind$1(chatInboxItemEvent, chatInboxItem));
                            i4 = chatInboxItem.f22321i;
                            if (i4 <= 9) {
                                f = String.valueOf(i4);
                            } else {
                                f = Util.m24027f((int) C1761R.string.more_than_nine);
                                Intrinsics.m26843a((Object) f, "Util.getString(R.string.more_than_nine)");
                            }
                            textView2 = chatInboxViewHolder.seeAllView;
                            if (textView2 == null) {
                                Intrinsics.m26844a("seeAllView");
                            }
                            textView2.setText(Util.m23960a((int) C1761R.string.fmt_label_see_all_1, f));
                        }
                        relativeLayout2 = chatInboxViewHolder.contentContainer;
                        if (relativeLayout2 == null) {
                            Intrinsics.m26844a("contentContainer");
                        }
                        relativeLayout2.setOnClickListener(new ChatInboxViewHolder$bind$2(chatInboxItemEvent, chatInboxItem));
                        relativeLayout2 = chatInboxViewHolder.contentContainer;
                        if (relativeLayout2 == null) {
                            Intrinsics.m26844a("contentContainer");
                        }
                        relativeLayout2.setOnLongClickListener(new ChatInboxViewHolder$bind$3(chatInboxItemEvent, chatInboxItem));
                        linearLayout = chatInboxViewHolder.typingIndicatorContainer;
                        if (linearLayout == null) {
                            Intrinsics.m26844a("typingIndicatorContainer");
                        }
                        linearLayout.setVisibility(8);
                    }
                }
            }
            i4 = 1;
            if (i4 != 0) {
                z = true;
                if (chatInboxItem.f22315c) {
                }
                chatInboxItemEvent = r0.f29625c;
                Intrinsics.m26847b(chatInboxItem, "conversation");
                Intrinsics.m26847b(chatInboxItemEvent, "chatInboxItemClick");
                textView = chatInboxViewHolder.title;
                if (textView == null) {
                    Intrinsics.m26844a("title");
                }
                textView.setText(chatInboxItem.f22313a);
                textView = chatInboxViewHolder.dateText;
                if (textView == null) {
                    Intrinsics.m26844a("dateText");
                }
                dateUtil = DateUtil.f20370a;
                if (DateUtil.m22710f(chatInboxItem.f22317e)) {
                    dateUtil = DateUtil.f20370a;
                    if (DateUtil.m22709e(chatInboxItem.f22317e)) {
                        dateUtil = DateUtil.f20370a;
                        h = DateUtil.m22711g(chatInboxItem.f22317e);
                    } else {
                        h = Util.m24027f((int) C1761R.string.label_yesterday);
                    }
                } else {
                    dateUtil = DateUtil.f20370a;
                    h = DateUtil.m22712h(chatInboxItem.f22317e);
                }
                textView.setText(h);
                z3 = chatInboxItem.f22315c;
                if (chatInboxItem.f22318f > 0) {
                }
                if (z3) {
                    if (i2 != 0) {
                        textView = chatInboxViewHolder.title;
                        if (textView == null) {
                            Intrinsics.m26844a("title");
                        }
                        textView.setTypeface(null, 0);
                        textView2 = chatInboxViewHolder.title;
                        if (textView2 == null) {
                            Intrinsics.m26844a("title");
                        }
                        context = textView2.getContext();
                        Intrinsics.m26843a(context, "title.context");
                        i3 = ResourcesUtil.m22740i(context, C1761R.attr.rdt_meta_text_color);
                        textView = chatInboxViewHolder.message;
                        if (textView == null) {
                            Intrinsics.m26844a("message");
                        }
                        textView.setTextColor(i3);
                        textView = chatInboxViewHolder.dateText;
                        if (textView == null) {
                            Intrinsics.m26844a("dateText");
                        }
                        textView.setTextColor(i3);
                        textView2 = chatInboxViewHolder.message;
                        if (textView2 == null) {
                            Intrinsics.m26844a("message");
                        }
                        if (chatInboxItem.f22315c) {
                            charSequence = chatInboxItem.f22316d;
                        } else if (chatInboxItem.f22322j) {
                            charSequence = Util.m24027f((int) C1761R.string.rdt_label_wants_to_chat);
                        } else {
                            charSequence = Util.m24027f((int) C1761R.string.rdt_label_group_invite);
                        }
                        textView2.setText(charSequence);
                        imageView = chatInboxViewHolder.coverImage;
                        if (imageView == null) {
                            Intrinsics.m26844a("coverImage");
                        }
                        imageView2 = chatInboxViewHolder.iconFront;
                        if (imageView2 == null) {
                            Intrinsics.m26844a("iconFront");
                        }
                        imageView3 = chatInboxViewHolder.iconBack;
                        if (imageView3 == null) {
                            Intrinsics.m26844a("iconBack");
                        }
                        relativeLayout = chatInboxViewHolder.iconPairContainer;
                        if (relativeLayout == null) {
                            Intrinsics.m26844a("iconPairContainer");
                        }
                        AvatarUtilKt.m23657a(imageView, imageView2, imageView3, relativeLayout, chatInboxItem.f22319g, chatInboxItem.f22320h, chatInboxItem.f22322j, chatInboxItem.f22315c);
                        textView2 = chatInboxViewHolder.divider;
                        if (textView2 == null) {
                            Intrinsics.m26844a("divider");
                        }
                        ViewsKt.m24106b(textView2, z);
                        if (z) {
                            textView3 = chatInboxViewHolder.divider;
                            if (textView3 == null) {
                                Intrinsics.m26844a("divider");
                            }
                            if (chatInboxItem.f22315c) {
                                charSequence2 = "Conversations";
                            } else {
                                charSequence2 = "Requests";
                            }
                            textView3.setText(charSequence2);
                        }
                        relativeLayout2 = chatInboxViewHolder.seeAllContainer;
                        if (relativeLayout2 == null) {
                            Intrinsics.m26844a("seeAllContainer");
                        }
                        ViewsKt.m24106b(relativeLayout2, z2);
                        if (z2) {
                            relativeLayout2 = chatInboxViewHolder.seeAllContainer;
                            if (relativeLayout2 == null) {
                                Intrinsics.m26844a("seeAllContainer");
                            }
                            relativeLayout2.setOnClickListener(new ChatInboxViewHolder$bind$1(chatInboxItemEvent, chatInboxItem));
                            i4 = chatInboxItem.f22321i;
                            if (i4 <= 9) {
                                f = Util.m24027f((int) C1761R.string.more_than_nine);
                                Intrinsics.m26843a((Object) f, "Util.getString(R.string.more_than_nine)");
                            } else {
                                f = String.valueOf(i4);
                            }
                            textView2 = chatInboxViewHolder.seeAllView;
                            if (textView2 == null) {
                                Intrinsics.m26844a("seeAllView");
                            }
                            textView2.setText(Util.m23960a((int) C1761R.string.fmt_label_see_all_1, f));
                        }
                        relativeLayout2 = chatInboxViewHolder.contentContainer;
                        if (relativeLayout2 == null) {
                            Intrinsics.m26844a("contentContainer");
                        }
                        relativeLayout2.setOnClickListener(new ChatInboxViewHolder$bind$2(chatInboxItemEvent, chatInboxItem));
                        relativeLayout2 = chatInboxViewHolder.contentContainer;
                        if (relativeLayout2 == null) {
                            Intrinsics.m26844a("contentContainer");
                        }
                        relativeLayout2.setOnLongClickListener(new ChatInboxViewHolder$bind$3(chatInboxItemEvent, chatInboxItem));
                        linearLayout = chatInboxViewHolder.typingIndicatorContainer;
                        if (linearLayout == null) {
                            Intrinsics.m26844a("typingIndicatorContainer");
                        }
                        linearLayout.setVisibility(8);
                    }
                }
                textView = chatInboxViewHolder.title;
                if (textView == null) {
                    Intrinsics.m26844a("title");
                }
                textView.setTypeface(null, 1);
                textView2 = chatInboxViewHolder.title;
                if (textView2 == null) {
                    Intrinsics.m26844a("title");
                }
                context = textView2.getContext();
                Intrinsics.m26843a(context, "title.context");
                i3 = ResourcesUtil.m22740i(context, C1761R.attr.rdt_body_text_color);
                textView = chatInboxViewHolder.message;
                if (textView == null) {
                    Intrinsics.m26844a("message");
                }
                textView.setTextColor(i3);
                textView = chatInboxViewHolder.dateText;
                if (textView == null) {
                    Intrinsics.m26844a("dateText");
                }
                textView.setTextColor(i3);
                textView2 = chatInboxViewHolder.message;
                if (textView2 == null) {
                    Intrinsics.m26844a("message");
                }
                if (chatInboxItem.f22315c) {
                    charSequence = chatInboxItem.f22316d;
                } else if (chatInboxItem.f22322j) {
                    charSequence = Util.m24027f((int) C1761R.string.rdt_label_group_invite);
                } else {
                    charSequence = Util.m24027f((int) C1761R.string.rdt_label_wants_to_chat);
                }
                textView2.setText(charSequence);
                imageView = chatInboxViewHolder.coverImage;
                if (imageView == null) {
                    Intrinsics.m26844a("coverImage");
                }
                imageView2 = chatInboxViewHolder.iconFront;
                if (imageView2 == null) {
                    Intrinsics.m26844a("iconFront");
                }
                imageView3 = chatInboxViewHolder.iconBack;
                if (imageView3 == null) {
                    Intrinsics.m26844a("iconBack");
                }
                relativeLayout = chatInboxViewHolder.iconPairContainer;
                if (relativeLayout == null) {
                    Intrinsics.m26844a("iconPairContainer");
                }
                AvatarUtilKt.m23657a(imageView, imageView2, imageView3, relativeLayout, chatInboxItem.f22319g, chatInboxItem.f22320h, chatInboxItem.f22322j, chatInboxItem.f22315c);
                textView2 = chatInboxViewHolder.divider;
                if (textView2 == null) {
                    Intrinsics.m26844a("divider");
                }
                ViewsKt.m24106b(textView2, z);
                if (z) {
                    textView3 = chatInboxViewHolder.divider;
                    if (textView3 == null) {
                        Intrinsics.m26844a("divider");
                    }
                    if (chatInboxItem.f22315c) {
                        charSequence2 = "Requests";
                    } else {
                        charSequence2 = "Conversations";
                    }
                    textView3.setText(charSequence2);
                }
                relativeLayout2 = chatInboxViewHolder.seeAllContainer;
                if (relativeLayout2 == null) {
                    Intrinsics.m26844a("seeAllContainer");
                }
                ViewsKt.m24106b(relativeLayout2, z2);
                if (z2) {
                    relativeLayout2 = chatInboxViewHolder.seeAllContainer;
                    if (relativeLayout2 == null) {
                        Intrinsics.m26844a("seeAllContainer");
                    }
                    relativeLayout2.setOnClickListener(new ChatInboxViewHolder$bind$1(chatInboxItemEvent, chatInboxItem));
                    i4 = chatInboxItem.f22321i;
                    if (i4 <= 9) {
                        f = String.valueOf(i4);
                    } else {
                        f = Util.m24027f((int) C1761R.string.more_than_nine);
                        Intrinsics.m26843a((Object) f, "Util.getString(R.string.more_than_nine)");
                    }
                    textView2 = chatInboxViewHolder.seeAllView;
                    if (textView2 == null) {
                        Intrinsics.m26844a("seeAllView");
                    }
                    textView2.setText(Util.m23960a((int) C1761R.string.fmt_label_see_all_1, f));
                }
                relativeLayout2 = chatInboxViewHolder.contentContainer;
                if (relativeLayout2 == null) {
                    Intrinsics.m26844a("contentContainer");
                }
                relativeLayout2.setOnClickListener(new ChatInboxViewHolder$bind$2(chatInboxItemEvent, chatInboxItem));
                relativeLayout2 = chatInboxViewHolder.contentContainer;
                if (relativeLayout2 == null) {
                    Intrinsics.m26844a("contentContainer");
                }
                relativeLayout2.setOnLongClickListener(new ChatInboxViewHolder$bind$3(chatInboxItemEvent, chatInboxItem));
                linearLayout = chatInboxViewHolder.typingIndicatorContainer;
                if (linearLayout == null) {
                    Intrinsics.m26844a("typingIndicatorContainer");
                }
                linearLayout.setVisibility(8);
            }
        }
        z = false;
        if (chatInboxItem.f22315c) {
        }
        chatInboxItemEvent = r0.f29625c;
        Intrinsics.m26847b(chatInboxItem, "conversation");
        Intrinsics.m26847b(chatInboxItemEvent, "chatInboxItemClick");
        textView = chatInboxViewHolder.title;
        if (textView == null) {
            Intrinsics.m26844a("title");
        }
        textView.setText(chatInboxItem.f22313a);
        textView = chatInboxViewHolder.dateText;
        if (textView == null) {
            Intrinsics.m26844a("dateText");
        }
        dateUtil = DateUtil.f20370a;
        if (DateUtil.m22710f(chatInboxItem.f22317e)) {
            dateUtil = DateUtil.f20370a;
            h = DateUtil.m22712h(chatInboxItem.f22317e);
        } else {
            dateUtil = DateUtil.f20370a;
            if (DateUtil.m22709e(chatInboxItem.f22317e)) {
                h = Util.m24027f((int) C1761R.string.label_yesterday);
            } else {
                dateUtil = DateUtil.f20370a;
                h = DateUtil.m22711g(chatInboxItem.f22317e);
            }
        }
        textView.setText(h);
        z3 = chatInboxItem.f22315c;
        if (chatInboxItem.f22318f > 0) {
        }
        if (z3) {
            if (i2 != 0) {
                textView = chatInboxViewHolder.title;
                if (textView == null) {
                    Intrinsics.m26844a("title");
                }
                textView.setTypeface(null, 0);
                textView2 = chatInboxViewHolder.title;
                if (textView2 == null) {
                    Intrinsics.m26844a("title");
                }
                context = textView2.getContext();
                Intrinsics.m26843a(context, "title.context");
                i3 = ResourcesUtil.m22740i(context, C1761R.attr.rdt_meta_text_color);
                textView = chatInboxViewHolder.message;
                if (textView == null) {
                    Intrinsics.m26844a("message");
                }
                textView.setTextColor(i3);
                textView = chatInboxViewHolder.dateText;
                if (textView == null) {
                    Intrinsics.m26844a("dateText");
                }
                textView.setTextColor(i3);
                textView2 = chatInboxViewHolder.message;
                if (textView2 == null) {
                    Intrinsics.m26844a("message");
                }
                if (chatInboxItem.f22315c) {
                    charSequence = chatInboxItem.f22316d;
                } else if (chatInboxItem.f22322j) {
                    charSequence = Util.m24027f((int) C1761R.string.rdt_label_wants_to_chat);
                } else {
                    charSequence = Util.m24027f((int) C1761R.string.rdt_label_group_invite);
                }
                textView2.setText(charSequence);
                imageView = chatInboxViewHolder.coverImage;
                if (imageView == null) {
                    Intrinsics.m26844a("coverImage");
                }
                imageView2 = chatInboxViewHolder.iconFront;
                if (imageView2 == null) {
                    Intrinsics.m26844a("iconFront");
                }
                imageView3 = chatInboxViewHolder.iconBack;
                if (imageView3 == null) {
                    Intrinsics.m26844a("iconBack");
                }
                relativeLayout = chatInboxViewHolder.iconPairContainer;
                if (relativeLayout == null) {
                    Intrinsics.m26844a("iconPairContainer");
                }
                AvatarUtilKt.m23657a(imageView, imageView2, imageView3, relativeLayout, chatInboxItem.f22319g, chatInboxItem.f22320h, chatInboxItem.f22322j, chatInboxItem.f22315c);
                textView2 = chatInboxViewHolder.divider;
                if (textView2 == null) {
                    Intrinsics.m26844a("divider");
                }
                ViewsKt.m24106b(textView2, z);
                if (z) {
                    textView3 = chatInboxViewHolder.divider;
                    if (textView3 == null) {
                        Intrinsics.m26844a("divider");
                    }
                    if (chatInboxItem.f22315c) {
                        charSequence2 = "Conversations";
                    } else {
                        charSequence2 = "Requests";
                    }
                    textView3.setText(charSequence2);
                }
                relativeLayout2 = chatInboxViewHolder.seeAllContainer;
                if (relativeLayout2 == null) {
                    Intrinsics.m26844a("seeAllContainer");
                }
                ViewsKt.m24106b(relativeLayout2, z2);
                if (z2) {
                    relativeLayout2 = chatInboxViewHolder.seeAllContainer;
                    if (relativeLayout2 == null) {
                        Intrinsics.m26844a("seeAllContainer");
                    }
                    relativeLayout2.setOnClickListener(new ChatInboxViewHolder$bind$1(chatInboxItemEvent, chatInboxItem));
                    i4 = chatInboxItem.f22321i;
                    if (i4 <= 9) {
                        f = Util.m24027f((int) C1761R.string.more_than_nine);
                        Intrinsics.m26843a((Object) f, "Util.getString(R.string.more_than_nine)");
                    } else {
                        f = String.valueOf(i4);
                    }
                    textView2 = chatInboxViewHolder.seeAllView;
                    if (textView2 == null) {
                        Intrinsics.m26844a("seeAllView");
                    }
                    textView2.setText(Util.m23960a((int) C1761R.string.fmt_label_see_all_1, f));
                }
                relativeLayout2 = chatInboxViewHolder.contentContainer;
                if (relativeLayout2 == null) {
                    Intrinsics.m26844a("contentContainer");
                }
                relativeLayout2.setOnClickListener(new ChatInboxViewHolder$bind$2(chatInboxItemEvent, chatInboxItem));
                relativeLayout2 = chatInboxViewHolder.contentContainer;
                if (relativeLayout2 == null) {
                    Intrinsics.m26844a("contentContainer");
                }
                relativeLayout2.setOnLongClickListener(new ChatInboxViewHolder$bind$3(chatInboxItemEvent, chatInboxItem));
                linearLayout = chatInboxViewHolder.typingIndicatorContainer;
                if (linearLayout == null) {
                    Intrinsics.m26844a("typingIndicatorContainer");
                }
                linearLayout.setVisibility(8);
            }
        }
        textView = chatInboxViewHolder.title;
        if (textView == null) {
            Intrinsics.m26844a("title");
        }
        textView.setTypeface(null, 1);
        textView2 = chatInboxViewHolder.title;
        if (textView2 == null) {
            Intrinsics.m26844a("title");
        }
        context = textView2.getContext();
        Intrinsics.m26843a(context, "title.context");
        i3 = ResourcesUtil.m22740i(context, C1761R.attr.rdt_body_text_color);
        textView = chatInboxViewHolder.message;
        if (textView == null) {
            Intrinsics.m26844a("message");
        }
        textView.setTextColor(i3);
        textView = chatInboxViewHolder.dateText;
        if (textView == null) {
            Intrinsics.m26844a("dateText");
        }
        textView.setTextColor(i3);
        textView2 = chatInboxViewHolder.message;
        if (textView2 == null) {
            Intrinsics.m26844a("message");
        }
        if (chatInboxItem.f22315c) {
            charSequence = chatInboxItem.f22316d;
        } else if (chatInboxItem.f22322j) {
            charSequence = Util.m24027f((int) C1761R.string.rdt_label_group_invite);
        } else {
            charSequence = Util.m24027f((int) C1761R.string.rdt_label_wants_to_chat);
        }
        textView2.setText(charSequence);
        imageView = chatInboxViewHolder.coverImage;
        if (imageView == null) {
            Intrinsics.m26844a("coverImage");
        }
        imageView2 = chatInboxViewHolder.iconFront;
        if (imageView2 == null) {
            Intrinsics.m26844a("iconFront");
        }
        imageView3 = chatInboxViewHolder.iconBack;
        if (imageView3 == null) {
            Intrinsics.m26844a("iconBack");
        }
        relativeLayout = chatInboxViewHolder.iconPairContainer;
        if (relativeLayout == null) {
            Intrinsics.m26844a("iconPairContainer");
        }
        AvatarUtilKt.m23657a(imageView, imageView2, imageView3, relativeLayout, chatInboxItem.f22319g, chatInboxItem.f22320h, chatInboxItem.f22322j, chatInboxItem.f22315c);
        textView2 = chatInboxViewHolder.divider;
        if (textView2 == null) {
            Intrinsics.m26844a("divider");
        }
        ViewsKt.m24106b(textView2, z);
        if (z) {
            textView3 = chatInboxViewHolder.divider;
            if (textView3 == null) {
                Intrinsics.m26844a("divider");
            }
            if (chatInboxItem.f22315c) {
                charSequence2 = "Requests";
            } else {
                charSequence2 = "Conversations";
            }
            textView3.setText(charSequence2);
        }
        relativeLayout2 = chatInboxViewHolder.seeAllContainer;
        if (relativeLayout2 == null) {
            Intrinsics.m26844a("seeAllContainer");
        }
        ViewsKt.m24106b(relativeLayout2, z2);
        if (z2) {
            relativeLayout2 = chatInboxViewHolder.seeAllContainer;
            if (relativeLayout2 == null) {
                Intrinsics.m26844a("seeAllContainer");
            }
            relativeLayout2.setOnClickListener(new ChatInboxViewHolder$bind$1(chatInboxItemEvent, chatInboxItem));
            i4 = chatInboxItem.f22321i;
            if (i4 <= 9) {
                f = String.valueOf(i4);
            } else {
                f = Util.m24027f((int) C1761R.string.more_than_nine);
                Intrinsics.m26843a((Object) f, "Util.getString(R.string.more_than_nine)");
            }
            textView2 = chatInboxViewHolder.seeAllView;
            if (textView2 == null) {
                Intrinsics.m26844a("seeAllView");
            }
            textView2.setText(Util.m23960a((int) C1761R.string.fmt_label_see_all_1, f));
        }
        relativeLayout2 = chatInboxViewHolder.contentContainer;
        if (relativeLayout2 == null) {
            Intrinsics.m26844a("contentContainer");
        }
        relativeLayout2.setOnClickListener(new ChatInboxViewHolder$bind$2(chatInboxItemEvent, chatInboxItem));
        relativeLayout2 = chatInboxViewHolder.contentContainer;
        if (relativeLayout2 == null) {
            Intrinsics.m26844a("contentContainer");
        }
        relativeLayout2.setOnLongClickListener(new ChatInboxViewHolder$bind$3(chatInboxItemEvent, chatInboxItem));
        linearLayout = chatInboxViewHolder.typingIndicatorContainer;
        if (linearLayout == null) {
            Intrinsics.m26844a("typingIndicatorContainer");
        }
        linearLayout.setVisibility(8);
    }

    public ChatInboxItemAdapter(boolean z, ChatInboxItemEvent chatInboxItemEvent) {
        Intrinsics.m26847b(chatInboxItemEvent, "chatInboxItemEvent");
        this.f29624b = z;
        this.f29625c = chatInboxItemEvent;
    }

    public final void m30650a(List<ChatInboxItem> list) {
        Intrinsics.m26847b(list, "chatInboxItemList");
        this.f29623a = list;
        e();
    }

    public final int m30647a() {
        return this.f29623a.size();
    }
}
