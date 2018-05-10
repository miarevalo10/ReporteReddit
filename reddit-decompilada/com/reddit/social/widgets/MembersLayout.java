package com.reddit.social.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.instabug.chat.model.Attachment;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.AccountPrefsUtil;
import com.reddit.frontpage.util.AvatarUtilKt;
import com.reddit.social.presentation.presentationobjects.UserData;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.anko.CustomLayoutPropertiesKt;
import org.jetbrains.anko.DimensionsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0002\u0019\u001aB%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0013H\u0016R0\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/reddit/social/widgets/MembersLayout;", "Landroid/widget/RelativeLayout;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "members", "getMembers", "()Ljava/util/List;", "setMembers", "(Ljava/util/List;)V", "readyToDraw", "", "drawMembers", "", "onAttachedToWindow", "onDetachedFromWindow", "onPreDraw", "Companion", "MessagesHeaderMemberView", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MembersLayout.kt */
public final class MembersLayout extends RelativeLayout implements OnPreDrawListener {
    public static final Companion f22487a = new Companion();
    private List<UserData> f22488b;
    private boolean f22489c;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0002XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/social/widgets/MembersLayout$Companion;", "", "()V", "MEMBERS_MARGIN", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: MembersLayout.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0017R\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/reddit/social/widgets/MembersLayout$MessagesHeaderMemberView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "image", "Landroid/widget/ImageView;", "getImage", "()Landroid/widget/ImageView;", "image$delegate", "Lkotlin/Lazy;", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "name$delegate", "getViewWidth", "", "text", "", "setAvatar", "", "username", "iconUrl", "isNsfw", "", "setName", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: MembersLayout.kt */
    private static final class MessagesHeaderMemberView extends LinearLayout {
        static final /* synthetic */ KProperty[] f22483a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(MessagesHeaderMemberView.class), "name", "getName()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(MessagesHeaderMemberView.class), Attachment.TYPE_IMAGE, "getImage()Landroid/widget/ImageView;"))};
        private final Lazy f22484b;
        private final Lazy f22485c;
        private HashMap f22486d;

        public final View m24773a(int i) {
            if (this.f22486d == null) {
                this.f22486d = new HashMap();
            }
            View view = (View) this.f22486d.get(Integer.valueOf(i));
            if (view != null) {
                return view;
            }
            view = findViewById(i);
            this.f22486d.put(Integer.valueOf(i), view);
            return view;
        }

        public final TextView m24774a() {
            return (TextView) this.f22484b.mo5678b();
        }

        public final ImageView m24775b() {
            return (ImageView) this.f22485c.mo5678b();
        }

        private MessagesHeaderMemberView(Context context) {
            Intrinsics.m26847b(context, "context");
            super(context, null, 0);
            this.f22484b = LazyKt.m26777a(new MembersLayout$MessagesHeaderMemberView$name$2(this));
            this.f22485c = LazyKt.m26777a(new MembersLayout$MessagesHeaderMemberView$image$2(this));
            LinearLayout.inflate(context, C1761R.layout.messages_header_member, this);
            setLayoutParams((LayoutParams) new LinearLayout.LayoutParams(CustomLayoutPropertiesKt.m28401b(), CustomLayoutPropertiesKt.m28401b()));
            setOrientation(0);
        }
    }

    public MembersLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public MembersLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MembersLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public MembersLayout(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f22488b = CollectionsKt__CollectionsKt.m26790a();
    }

    public final List<UserData> getMembers() {
        return this.f22488b;
    }

    public final void setMembers(List<UserData> list) {
        Intrinsics.m26847b(list, "value");
        this.f22488b = list;
        m24776a();
    }

    public final boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        this.f22489c = true;
        m24776a();
        return true;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
    }

    private final void m24776a() {
        if (this.f22489c) {
            removeAllViews();
            int i = 0;
            float f = 0.0f;
            int i2 = 1;
            int i3 = i2;
            for (UserData userData : this.f22488b) {
                int i4 = i + 1;
                String str = i == CollectionsKt__CollectionsKt.m26787a(this.f22488b) ? "" : ",";
                Object context = getContext();
                Intrinsics.m26843a(context, "context");
                View messagesHeaderMemberView = new MessagesHeaderMemberView(context);
                messagesHeaderMemberView.setId(i2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(userData.f22465b);
                stringBuilder.append(str);
                str = stringBuilder.toString();
                Intrinsics.m26847b(str, "name");
                messagesHeaderMemberView.m24774a().setText(str);
                String str2 = userData.f22465b;
                String str3 = userData.f22466c;
                boolean a = AccountPrefsUtil.m23630a(userData.f22465b, userData.f22470g);
                Intrinsics.m26847b(str2, "username");
                AvatarUtilKt.m23659a(messagesHeaderMemberView.m24775b(), str3, Boolean.valueOf(AccountPrefsUtil.m23630a(str2, Boolean.valueOf(a))), Integer.valueOf(DimensionsKt.m28408a(messagesHeaderMemberView.getContext(), C1761R.dimen.chat_icon_radius_small)));
                Intrinsics.m26847b(str, "text");
                int i5 = messagesHeaderMemberView.m24775b().getLayoutParams().width;
                LayoutParams layoutParams = messagesHeaderMemberView.m24775b().getLayoutParams();
                if (layoutParams == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                float marginEnd = ((float) (i5 + ((MarginLayoutParams) layoutParams).getMarginEnd())) + messagesHeaderMemberView.m24774a().getPaint().measureText(str);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                int a2 = DimensionsKt.m28408a(getContext(), C1761R.dimen.single_pad);
                float f2 = (float) a2;
                if (((float) getWidth()) <= (f + marginEnd) + f2) {
                    layoutParams2.addRule(3, i3);
                    f = 0.0f;
                    i3 = i2;
                } else {
                    layoutParams2.addRule(6, i3);
                    layoutParams2.addRule(17, i2 - 1);
                    if (i2 > 1) {
                        layoutParams2.setMarginStart(a2);
                        f += f2;
                    }
                }
                f += marginEnd;
                addView(messagesHeaderMemberView, layoutParams2);
                i2++;
                i = i4;
            }
        }
    }
}
