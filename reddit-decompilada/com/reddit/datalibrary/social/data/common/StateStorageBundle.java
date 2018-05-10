package com.reddit.datalibrary.social.data.common;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\t\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0017H\u0016J\u001d\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00192\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001aJ$\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u001d2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010 J\u001f\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u001fH\u0016¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010$\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020%\u0018\u0001`\u001d2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010(\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020'\u0018\u0001`\u001d2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0017\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010-J\u001f\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020,H\u0016¢\u0006\u0002\u0010.J\u0012\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u00101\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016J$\u00102\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u001d2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u00103\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\u0006\u00105\u001a\u00020\bH\u0016J\u0018\u00106\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\u0006\u00105\u001a\u00020\u000fH\u0016J\u0018\u00107\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\u0006\u00105\u001a\u00020\u0015H\u0016J\u0018\u00108\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\u0006\u00105\u001a\u00020\u0017H\u0016J#\u00109\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019H\u0016¢\u0006\u0002\u0010:J(\u0010;\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u001cj\b\u0012\u0004\u0012\u00020\u0017`\u001dH\u0016J\u0018\u0010<\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\u0006\u00105\u001a\u00020\u001fH\u0016J\u0018\u0010=\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\u0006\u00105\u001a\u00020#H\u0016J(\u0010>\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020%0\u001cj\b\u0012\u0004\u0012\u00020%`\u001dH\u0016J\u0018\u0010?\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\u0006\u00105\u001a\u00020'H\u0016J(\u0010@\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020'0\u001cj\b\u0012\u0004\u0012\u00020'`\u001dH\u0016J\u0018\u0010A\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\u0006\u00105\u001a\u00020*H\u0016J\u0018\u0010B\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\u0006\u00105\u001a\u000200H\u0016J(\u0010C\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\n0\u001cj\b\u0012\u0004\u0012\u00020\n`\u001dH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006D"}, d2 = {"Lcom/reddit/datalibrary/social/data/common/StateStorageBundle;", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "getBundle", "()Landroid/os/Bundle;", "getByte", "", "key", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "defaultValue", "(Ljava/lang/String;B)Ljava/lang/Byte;", "getByteArray", "", "getChar", "", "(Ljava/lang/String;)Ljava/lang/Character;", "(Ljava/lang/String;C)Ljava/lang/Character;", "getCharArray", "", "getCharSequence", "", "getCharSequenceArray", "", "(Ljava/lang/String;)[Ljava/lang/CharSequence;", "getCharSequenceArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "(Ljava/lang/String;F)Ljava/lang/Float;", "getFloatArray", "", "getIntegerArrayList", "", "getParcelable", "Landroid/os/Parcelable;", "getParcelableArrayList", "getSerializable", "Ljava/io/Serializable;", "getShort", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;S)Ljava/lang/Short;", "getShortArray", "", "getString", "getStringArrayList", "putByte", "", "value", "putByteArray", "putCharArray", "putCharSequence", "putCharSequenceArray", "(Ljava/lang/String;[Ljava/lang/CharSequence;)V", "putCharSequenceArrayList", "putFloat", "putFloatArray", "putIntegerArrayList", "putParcelable", "putParcelableArrayList", "putSerializable", "putShortArray", "putStringArrayList", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: StateStorageBundle.kt */
public final class StateStorageBundle implements StateStorageContract {
    private final Bundle f27255a;

    public StateStorageBundle(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        this.f27255a = bundle;
    }

    public final void mo4475a(String str, CharSequence charSequence) {
        Intrinsics.m26847b(str, "key");
        Intrinsics.m26847b(charSequence, "value");
        this.f27255a.putCharSequence(str, charSequence);
    }

    public final void mo4476a(String str, ArrayList<Parcelable> arrayList) {
        Intrinsics.m26847b(str, "key");
        Intrinsics.m26847b(arrayList, "value");
        this.f27255a.putParcelableArrayList(str, arrayList);
    }

    public final CharSequence mo4474a(String str) {
        Intrinsics.m26847b(str, "key");
        return this.f27255a.getCharSequence(str, null);
    }

    public final String mo4477b(String str) {
        Intrinsics.m26847b(str, "key");
        Intrinsics.m26847b(str, "key");
        str = this.f27255a.getCharSequence(str);
        return str == null ? null : str.toString();
    }

    public final ArrayList<Parcelable> mo4478c(String str) {
        Intrinsics.m26847b(str, "key");
        return this.f27255a.getParcelableArrayList(str);
    }
}
