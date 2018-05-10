package com.reddit.social.presentation.contacts.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.tokenautocomplete.TokenCompleteTextView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, d2 = {"Lcom/reddit/social/presentation/contacts/view/ContactsCompletionView;", "Lcom/reddit/frontpage/ui/tokenautocomplete/TokenCompleteTextView;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultObject", "completionText", "getViewForObject", "Landroid/view/View;", "contact", "performCollapse", "", "hasFocus", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ContactsCompletionView.kt */
public final class ContactsCompletionView extends TokenCompleteTextView<String> {
    public final void mo7031a(boolean z) {
    }

    public final /* synthetic */ View mo7029a(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "contact");
        Object systemService = getContext().getSystemService("layout_inflater");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
        }
        LayoutInflater layoutInflater = (LayoutInflater) systemService;
        ViewParent parent = getParent();
        if (parent == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        View inflate = layoutInflater.inflate(C1761R.layout.contact_token, (ViewGroup) parent, false);
        if (inflate == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        TextView textView = (TextView) inflate;
        textView.setText(str);
        return textView;
    }

    public final /* synthetic */ Object mo7030a(String str) {
        Intrinsics.m26847b(str, "completionText");
        return StringsKt__StringsKt.m42456b((CharSequence) str).toString();
    }

    public ContactsCompletionView(Context context) {
        Intrinsics.m26847b(context, "context");
        super(context);
    }

    public ContactsCompletionView(Context context, AttributeSet attributeSet) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet);
    }

    public ContactsCompletionView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i);
    }
}
