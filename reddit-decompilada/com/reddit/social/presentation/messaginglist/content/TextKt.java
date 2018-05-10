package com.reddit.social.presentation.messaginglist.content;

import android.text.method.TransformationMethod;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.reddit.android.view.WrappedWidthTextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.TextViewsKt;
import com.reddit.social.presentation.messaginglist.MessageContentClickListener;
import com.reddit.social.presentation.messaginglist.MessageContentKt;
import com.reddit.social.presentation.presentationobjects.TextMessageData;
import com.reddit.social.util.textview.LinkTransformationMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import org.jetbrains.anko.CustomLayoutPropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u0018\u0010\u0007\u001a\u00020\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u001a\n\u0010\u000b\u001a\u00020\u0002*\u00020\f¨\u0006\r"}, d2 = {"bind", "", "Lcom/reddit/social/presentation/messaginglist/content/TextMessageContent;", "textMessage", "Lcom/reddit/social/presentation/presentationobjects/TextMessageData;", "listener", "Lcom/reddit/social/presentation/messaginglist/MessageContentClickListener;", "bindOnLongClick", "Landroid/widget/TextView;", "body", "Lkotlin/Function0;", "textMessageContent", "Landroid/view/ViewGroup;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: Text.kt */
public final class TextKt {
    public static final TextMessageContent m24734a(ViewGroup viewGroup) {
        Intrinsics.m26847b(viewGroup, "$receiver");
        Object context = viewGroup.getContext();
        Intrinsics.m26843a(context, "context");
        WrappedWidthTextView wrappedWidthTextView = new WrappedWidthTextView(context, null, 0, 6, null);
        wrappedWidthTextView.setLayoutParams(new LayoutParams(CustomLayoutPropertiesKt.m28401b(), CustomLayoutPropertiesKt.m28401b()));
        wrappedWidthTextView.setTransformationMethod((TransformationMethod) new LinkTransformationMethod());
        TextView textView = wrappedWidthTextView;
        TextViewsKt.m24095a(textView, (int) C1761R.style.TextAppearance.RedditBase.Body);
        return new TextMessageContent(textView);
    }

    public static final void m24735a(TextView textView, Function0<Unit> function0) {
        Intrinsics.m26847b(textView, "$receiver");
        Intrinsics.m26847b(function0, "body");
        BooleanRef booleanRef = new BooleanRef();
        booleanRef.f25288a = false;
        textView.setOnLongClickListener((OnLongClickListener) new TextKt$inlined$sam$OnLongClickListener$i$e2258e04(new TextKt$bindOnLongClick$1(function0, booleanRef)));
        textView.setOnTouchListener((OnTouchListener) new TextKt$bindOnLongClick$2(booleanRef));
    }

    public static final void m24736a(TextMessageContent textMessageContent, TextMessageData textMessageData, MessageContentClickListener messageContentClickListener) {
        Intrinsics.m26847b(textMessageContent, "$receiver");
        Intrinsics.m26847b(textMessageData, "textMessage");
        textMessageContent.f29923b.setText(textMessageData.f29964a);
        MessageContentKt.m24710a((View) textMessageContent.f29923b, textMessageData.f29965b.f22437j);
        textMessageContent.f29923b.setOnClickListener(new TextKt$inlined$sam$OnClickListener$i$7f478c20(new TextKt$bind$1(messageContentClickListener, textMessageData)));
        m24735a(textMessageContent.f29923b, new TextKt$bind$2(messageContentClickListener, textMessageData));
    }
}
