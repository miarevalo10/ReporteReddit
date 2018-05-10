package com.reddit.social.presentation.contacts.view;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.DateUtil;
import com.reddit.frontpage.util.AccountPrefsUtil;
import com.reddit.frontpage.util.AvatarUtilKt;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.CharSequencesKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.social.presentation.contacts.view.ContactViewHolder.WhenMappings;
import com.reddit.social.presentation.presentationobjects.ContactData;
import com.reddit.social.presentation.presentationobjects.UserStatus;
import com.reddit.social.util.NotifyingList;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0016\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ\u0016\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R7\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lcom/reddit/social/presentation/contacts/view/ContactsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/social/presentation/contacts/view/ContactViewHolder;", "clickSubject", "Lio/reactivex/subjects/PublishSubject;", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "(Lio/reactivex/subjects/PublishSubject;)V", "<set-?>", "", "contacts", "getContacts", "()Ljava/util/List;", "setContacts", "(Ljava/util/List;)V", "contacts$delegate", "Lcom/reddit/social/util/NotifyingList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setUnknownUserExistentStatus", "name", "", "id", "setUnknownUserStatus", "status", "Lcom/reddit/social/presentation/presentationobjects/UserStatus;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ContactsAdapter.kt */
public final class ContactsAdapter extends Adapter<ContactViewHolder> {
    static final /* synthetic */ KProperty[] f29728a = new KProperty[]{Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(ContactsAdapter.class), "contacts", "getContacts()Ljava/util/List;"))};
    final NotifyingList f29729b = new NotifyingList(CollectionsKt__CollectionsKt.m26790a(), ContactsAdapter$contacts$2.f37519a);
    private final PublishSubject<ContactData> f29730c;

    public final List<ContactData> m30757b() {
        return this.f29729b.m30901a(this, f29728a[0]);
    }

    public ContactsAdapter(PublishSubject<ContactData> publishSubject) {
        Intrinsics.m26847b(publishSubject, "clickSubject");
        this.f29730c = publishSubject;
    }

    public final /* synthetic */ ViewHolder m30755a(ViewGroup viewGroup, int i) {
        Intrinsics.m26847b(viewGroup, "parent");
        Object inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.listitem_contact, viewGroup, false);
        Intrinsics.m26843a(inflate, "view");
        return (ViewHolder) new ContactViewHolder(inflate);
    }

    public final /* synthetic */ void m30756a(ViewHolder viewHolder, int i) {
        boolean z;
        ImageView imageView;
        Object f;
        TextView textView;
        CheckBox checkBox;
        CheckBox checkBox2;
        ContactViewHolder contactViewHolder = (ContactViewHolder) viewHolder;
        Intrinsics.m26847b(contactViewHolder, "holder");
        ContactData contactData = (ContactData) m30757b().get(i);
        PublishSubject publishSubject = this.f29730c;
        Intrinsics.m26847b(contactData, "contactData");
        Intrinsics.m26847b(publishSubject, "clickSubject");
        TextView textView2 = contactViewHolder.username;
        if (textView2 == null) {
            Intrinsics.m26844a("username");
        }
        textView2.setText(contactData.f29927a);
        boolean a = Intrinsics.m26845a(contactData.f29931e, UserStatus.f22472b);
        TextView textView3 = contactViewHolder.restOfRedditText;
        if (textView3 == null) {
            Intrinsics.m26844a("restOfRedditText");
        }
        ViewsKt.m24106b(textView3, a ^ 1);
        RelativeLayout relativeLayout = contactViewHolder.row;
        if (relativeLayout == null) {
            Intrinsics.m26844a("row");
        }
        if (!(a || Intrinsics.m26845a(contactData.f29931e, UserStatus.f22474d))) {
            if (!Intrinsics.m26845a(contactData.f29931e, UserStatus.f22477g)) {
                z = false;
                relativeLayout.setEnabled(z);
                imageView = contactViewHolder.icon;
                if (imageView == null) {
                    Intrinsics.m26844a("icon");
                }
                ViewsKt.m24106b(imageView, a);
                textView3 = contactViewHolder.karmaAndAge;
                if (textView3 == null) {
                    Intrinsics.m26844a("karmaAndAge");
                }
                ViewsKt.m24109d(textView3);
                textView3 = contactViewHolder.status;
                if (textView3 == null) {
                    Intrinsics.m26844a("status");
                }
                ViewsKt.m24109d(textView3);
                switch (WhenMappings.f22344a[contactData.f29931e.ordinal()]) {
                    case 1:
                        textView3 = contactViewHolder.status;
                        if (textView3 == null) {
                            Intrinsics.m26844a("status");
                        }
                        ViewsKt.m24107c(textView3);
                        textView3 = contactViewHolder.status;
                        if (textView3 == null) {
                            Intrinsics.m26844a("status");
                        }
                        f = Util.m24027f((int) C1761R.string.chat_error_chat_with_yourself);
                        Intrinsics.m26843a(f, "Util.getString(R.string.…error_chat_with_yourself)");
                        textView3.setText(CharSequencesKt.m24071a((CharSequence) f));
                        break;
                    case 2:
                        imageView = contactViewHolder.icon;
                        if (imageView == null) {
                            Intrinsics.m26844a("icon");
                        }
                        AvatarUtilKt.m23659a(imageView, contactData.f29928b, Boolean.valueOf(AccountPrefsUtil.m23630a(contactData.f29927a, contactData.f29932f)), null);
                        if (!(contactData.f29933g == null || contactData.f29934h == null)) {
                            String a2 = DateUtil.m22704a(contactData.f29934h.longValue() * 1000, 2);
                            textView = contactViewHolder.karmaAndAge;
                            if (textView == null) {
                                Intrinsics.m26844a("karmaAndAge");
                            }
                            ViewsKt.m24107c(textView);
                            textView = contactViewHolder.karmaAndAge;
                            if (textView == null) {
                                Intrinsics.m26844a("karmaAndAge");
                            }
                            textView.setText(Util.m23960a((int) C1761R.string.fmt_num_karma_and_age_2, contactData.f29933g, a2));
                            break;
                        }
                    case 3:
                        textView3 = contactViewHolder.status;
                        if (textView3 == null) {
                            Intrinsics.m26844a("status");
                        }
                        ViewsKt.m24107c(textView3);
                        textView3 = contactViewHolder.status;
                        if (textView3 == null) {
                            Intrinsics.m26844a("status");
                        }
                        f = Util.m24027f((int) C1761R.string.user_already_in_channel);
                        Intrinsics.m26843a(f, "Util.getString(R.string.user_already_in_channel)");
                        textView3.setText(CharSequencesKt.m24071a((CharSequence) f));
                        break;
                    case 4:
                        textView3 = contactViewHolder.status;
                        if (textView3 == null) {
                            Intrinsics.m26844a("status");
                        }
                        ViewsKt.m24107c(textView3);
                        textView3 = contactViewHolder.status;
                        if (textView3 == null) {
                            Intrinsics.m26844a("status");
                        }
                        textView3.setText(Util.m24027f((int) C1761R.string.chat_verifying_user));
                        break;
                    case 5:
                        textView3 = contactViewHolder.status;
                        if (textView3 == null) {
                            Intrinsics.m26844a("status");
                        }
                        ViewsKt.m24107c(textView3);
                        textView3 = contactViewHolder.status;
                        if (textView3 == null) {
                            Intrinsics.m26844a("status");
                        }
                        f = Util.m24027f((int) C1761R.string.chat_error_verifying_user);
                        Intrinsics.m26843a(f, "Util.getString(R.string.chat_error_verifying_user)");
                        textView3.setText(CharSequencesKt.m24071a((CharSequence) f));
                        break;
                    default:
                        break;
                }
                checkBox = contactViewHolder.checkBox;
                if (checkBox == null) {
                    Intrinsics.m26844a("checkBox");
                }
                ViewsKt.m24106b(checkBox, a);
                checkBox2 = contactViewHolder.checkBox;
                if (checkBox2 == null) {
                    Intrinsics.m26844a("checkBox");
                }
                checkBox2.setChecked(contactData.f29930d);
                viewHolder = contactViewHolder.row;
                if (viewHolder == null) {
                    Intrinsics.m26844a("row");
                }
                ((View) viewHolder).setOnClickListener((OnClickListener) new ContactViewHolder$inlined$sam$OnClickListener$i$7f478c20(new ContactViewHolder$bind$2(publishSubject, contactData)));
            }
        }
        z = true;
        relativeLayout.setEnabled(z);
        imageView = contactViewHolder.icon;
        if (imageView == null) {
            Intrinsics.m26844a("icon");
        }
        ViewsKt.m24106b(imageView, a);
        textView3 = contactViewHolder.karmaAndAge;
        if (textView3 == null) {
            Intrinsics.m26844a("karmaAndAge");
        }
        ViewsKt.m24109d(textView3);
        textView3 = contactViewHolder.status;
        if (textView3 == null) {
            Intrinsics.m26844a("status");
        }
        ViewsKt.m24109d(textView3);
        switch (WhenMappings.f22344a[contactData.f29931e.ordinal()]) {
            case 1:
                textView3 = contactViewHolder.status;
                if (textView3 == null) {
                    Intrinsics.m26844a("status");
                }
                ViewsKt.m24107c(textView3);
                textView3 = contactViewHolder.status;
                if (textView3 == null) {
                    Intrinsics.m26844a("status");
                }
                f = Util.m24027f((int) C1761R.string.chat_error_chat_with_yourself);
                Intrinsics.m26843a(f, "Util.getString(R.string.…error_chat_with_yourself)");
                textView3.setText(CharSequencesKt.m24071a((CharSequence) f));
                break;
            case 2:
                imageView = contactViewHolder.icon;
                if (imageView == null) {
                    Intrinsics.m26844a("icon");
                }
                AvatarUtilKt.m23659a(imageView, contactData.f29928b, Boolean.valueOf(AccountPrefsUtil.m23630a(contactData.f29927a, contactData.f29932f)), null);
                String a22 = DateUtil.m22704a(contactData.f29934h.longValue() * 1000, 2);
                textView = contactViewHolder.karmaAndAge;
                if (textView == null) {
                    Intrinsics.m26844a("karmaAndAge");
                }
                ViewsKt.m24107c(textView);
                textView = contactViewHolder.karmaAndAge;
                if (textView == null) {
                    Intrinsics.m26844a("karmaAndAge");
                }
                textView.setText(Util.m23960a((int) C1761R.string.fmt_num_karma_and_age_2, contactData.f29933g, a22));
                break;
            case 3:
                textView3 = contactViewHolder.status;
                if (textView3 == null) {
                    Intrinsics.m26844a("status");
                }
                ViewsKt.m24107c(textView3);
                textView3 = contactViewHolder.status;
                if (textView3 == null) {
                    Intrinsics.m26844a("status");
                }
                f = Util.m24027f((int) C1761R.string.user_already_in_channel);
                Intrinsics.m26843a(f, "Util.getString(R.string.user_already_in_channel)");
                textView3.setText(CharSequencesKt.m24071a((CharSequence) f));
                break;
            case 4:
                textView3 = contactViewHolder.status;
                if (textView3 == null) {
                    Intrinsics.m26844a("status");
                }
                ViewsKt.m24107c(textView3);
                textView3 = contactViewHolder.status;
                if (textView3 == null) {
                    Intrinsics.m26844a("status");
                }
                textView3.setText(Util.m24027f((int) C1761R.string.chat_verifying_user));
                break;
            case 5:
                textView3 = contactViewHolder.status;
                if (textView3 == null) {
                    Intrinsics.m26844a("status");
                }
                ViewsKt.m24107c(textView3);
                textView3 = contactViewHolder.status;
                if (textView3 == null) {
                    Intrinsics.m26844a("status");
                }
                f = Util.m24027f((int) C1761R.string.chat_error_verifying_user);
                Intrinsics.m26843a(f, "Util.getString(R.string.chat_error_verifying_user)");
                textView3.setText(CharSequencesKt.m24071a((CharSequence) f));
                break;
            default:
                break;
        }
        checkBox = contactViewHolder.checkBox;
        if (checkBox == null) {
            Intrinsics.m26844a("checkBox");
        }
        ViewsKt.m24106b(checkBox, a);
        checkBox2 = contactViewHolder.checkBox;
        if (checkBox2 == null) {
            Intrinsics.m26844a("checkBox");
        }
        checkBox2.setChecked(contactData.f29930d);
        viewHolder = contactViewHolder.row;
        if (viewHolder == null) {
            Intrinsics.m26844a("row");
        }
        ((View) viewHolder).setOnClickListener((OnClickListener) new ContactViewHolder$inlined$sam$OnClickListener$i$7f478c20(new ContactViewHolder$bind$2(publishSubject, contactData)));
    }

    public final int m30754a() {
        return m30757b().size();
    }
}
