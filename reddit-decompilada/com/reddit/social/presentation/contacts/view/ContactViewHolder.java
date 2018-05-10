package com.reddit.social.presentation.contacts.view;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.social.presentation.presentationobjects.UserStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0+R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001e\u0010#\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016¨\u0006,"}, d2 = {"Lcom/reddit/social/presentation/contacts/view/ContactViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "karmaAndAge", "Landroid/widget/TextView;", "getKarmaAndAge", "()Landroid/widget/TextView;", "setKarmaAndAge", "(Landroid/widget/TextView;)V", "restOfRedditText", "getRestOfRedditText", "setRestOfRedditText", "row", "Landroid/widget/RelativeLayout;", "getRow", "()Landroid/widget/RelativeLayout;", "setRow", "(Landroid/widget/RelativeLayout;)V", "status", "getStatus", "setStatus", "username", "getUsername", "setUsername", "bind", "", "contactData", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "clickSubject", "Lio/reactivex/subjects/PublishSubject;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ContactViewHolder.kt */
public final class ContactViewHolder extends ViewHolder {
    @BindView
    public CheckBox checkBox;
    @BindView
    public ImageView icon;
    @BindView
    public TextView karmaAndAge;
    @BindView
    public TextView restOfRedditText;
    @BindView
    public RelativeLayout row;
    @BindView
    public TextView status;
    @BindView
    public TextView username;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f22344a;

        static {
            int[] iArr = new int[UserStatus.values().length];
            f22344a = iArr;
            iArr[UserStatus.f22471a.ordinal()] = 1;
            f22344a[UserStatus.f22472b.ordinal()] = 2;
            f22344a[UserStatus.f22473c.ordinal()] = 3;
            f22344a[UserStatus.f22475e.ordinal()] = 4;
            f22344a[UserStatus.f22476f.ordinal()] = 5;
            f22344a[UserStatus.f22474d.ordinal()] = 6;
            f22344a[UserStatus.f22477g.ordinal()] = 7;
        }
    }

    public ContactViewHolder(View view) {
        Intrinsics.m26847b(view, "itemView");
        super(view);
        ButterKnife.a(this, view);
    }
}
