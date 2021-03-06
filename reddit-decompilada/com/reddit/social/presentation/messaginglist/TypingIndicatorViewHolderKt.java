package com.reddit.social.presentation.messaginglist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.social.presentation.presentationobjects.TypingIndicator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.CustomLayoutPropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0006¨\u0006\u0007"}, d2 = {"bind", "", "Lcom/reddit/social/presentation/messaginglist/TypingIndicatorViewHolder;", "data", "Lcom/reddit/social/presentation/presentationobjects/TypingIndicator;", "typingIndicator", "Landroid/content/Context;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: TypingIndicatorViewHolder.kt */
public final class TypingIndicatorViewHolderKt {
    public static final TypingIndicatorViewHolder m24718a(Context context) {
        Intrinsics.m26847b(context, "$receiver");
        context = context.getSystemService("layout_inflater");
        if (context == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
        }
        Object inflate = ((LayoutInflater) context).inflate(C1761R.layout.chat_typing_indicator, null);
        Object obj = (TextView) inflate.findViewById(C1761R.id.chat_typing_indicator_title);
        Intrinsics.m26843a(inflate, "view");
        Intrinsics.m26843a(obj, "textView");
        return new TypingIndicatorViewHolder(inflate, obj);
    }

    public static final void m24719a(TypingIndicatorViewHolder typingIndicatorViewHolder, TypingIndicator typingIndicator) {
        Intrinsics.m26847b(typingIndicatorViewHolder, "$receiver");
        Intrinsics.m26847b(typingIndicator, "data");
        typingIndicator = typingIndicator.f29966a;
        typingIndicatorViewHolder.f34598a.setText((CharSequence) typingIndicator);
        if (typingIndicator == null) {
            typingIndicatorViewHolder.f34598a.setLayoutParams(new LayoutParams(CustomLayoutPropertiesKt.m28400a(), 0));
        } else {
            typingIndicatorViewHolder.f34598a.setLayoutParams(new LayoutParams(CustomLayoutPropertiesKt.m28400a(), CustomLayoutPropertiesKt.m28401b()));
        }
    }
}
