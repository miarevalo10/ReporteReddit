package com.reddit.social.util;

import android.os.Bundle;
import android.os.Parcelable;
import com.evernote.android.state.Bundler;
import com.reddit.social.presentation.contacts.view.ContactsActionType;
import com.reddit.social.presentation.contacts.view.ContactsActionType.ADD;
import com.reddit.social.presentation.contacts.view.ContactsActionType.CREATE;
import com.reddit.social.presentation.presentationobjects.ContactData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Lcom/reddit/social/util/BundlerContactsActionType;", "Lcom/evernote/android/state/Bundler;", "Lcom/reddit/social/presentation/contacts/view/ContactsActionType;", "()V", "get", "key", "", "bundle", "Landroid/os/Bundle;", "put", "", "value", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BundlerContactsActionType.kt */
public final class BundlerContactsActionType implements Bundler<ContactsActionType> {
    public final /* synthetic */ Object get(String str, Bundle bundle) {
        Intrinsics.m26847b(str, "key");
        Intrinsics.m26847b(bundle, "bundle");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("_type");
        if (Intrinsics.m26845a(bundle.getString(stringBuilder.toString()), Reflection.m26850a(CREATE.class).aB_())) {
            str = bundle.getParcelable(str);
            if ((str instanceof ContactData) == null) {
                str = null;
            }
            return new CREATE((ContactData) str);
        }
        Object string = bundle.getString(str);
        Intrinsics.m26843a(string, "bundle.getString(key)");
        return new ADD(string);
    }

    public final /* synthetic */ void put(String str, Object obj, Bundle bundle) {
        ContactsActionType contactsActionType = (ContactsActionType) obj;
        Intrinsics.m26847b(str, "key");
        Intrinsics.m26847b(contactsActionType, "value");
        Intrinsics.m26847b(bundle, "bundle");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("_type");
        bundle.putString(stringBuilder.toString(), Reflection.m26850a(contactsActionType.getClass()).aB_());
        if (contactsActionType instanceof CREATE) {
            bundle.putParcelable(str, (Parcelable) ((CREATE) contactsActionType).f29727a);
            return;
        }
        if (contactsActionType instanceof ADD) {
            bundle.putString(str, ((ADD) contactsActionType).f29726a);
        }
    }
}
