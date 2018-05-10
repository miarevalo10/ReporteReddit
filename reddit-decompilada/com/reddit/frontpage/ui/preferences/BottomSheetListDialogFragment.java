package com.reddit.frontpage.ui.preferences;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.preference.DialogPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.PreferenceDialogFragmentCompat;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionAction;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionsDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/reddit/frontpage/ui/preferences/BottomSheetListDialogFragment;", "Landroid/support/v7/preference/PreferenceDialogFragmentCompat;", "()V", "entries", "", "", "getEntries", "()Ljava/util/List;", "entryIcons", "", "getEntryIcons", "entryValues", "getEntryValues", "listPreference", "Landroid/support/v7/preference/ListPreference;", "getListPreference", "()Landroid/support/v7/preference/ListPreference;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDialogClosed", "", "positiveResult", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BottomSheetListDialogFragment.kt */
public final class BottomSheetListDialogFragment extends PreferenceDialogFragmentCompat {
    public static final Companion f39250j = new Companion();
    private HashMap f39251k;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/ui/preferences/BottomSheetListDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/reddit/frontpage/ui/preferences/BottomSheetListDialogFragment;", "key", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BottomSheetListDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public static BottomSheetListDialogFragment m23583a(String str) {
            Intrinsics.m26847b(str, "key");
            BottomSheetListDialogFragment bottomSheetListDialogFragment = new BottomSheetListDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("key", str);
            bottomSheetListDialogFragment.setArguments(bundle);
            return bottomSheetListDialogFragment;
        }
    }

    public static final BottomSheetListDialogFragment m39354a(String str) {
        return Companion.m23583a(str);
    }

    public final void m39360b(boolean z) {
    }

    private final ListPreference m39355e() {
        DialogPreference d = d();
        if (d != null) {
            return (ListPreference) d;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v7.preference.ListPreference");
    }

    private final List<String> m39356f() {
        Object f = m39355e().f();
        Intrinsics.m26843a(f, "listPreference.entries");
        Object[] objArr = (Object[]) f;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(((CharSequence) obj).toString());
        }
        return (List) arrayList;
    }

    private final List<String> m39357g() {
        Object g = m39355e().g();
        Intrinsics.m26843a(g, "listPreference.entryValues");
        Object[] objArr = (Object[]) g;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(((CharSequence) obj).toString());
        }
        return (List) arrayList;
    }

    private final List<Integer> m39358h() {
        ListPreference e = m39355e();
        if (!(e instanceof IconListPreference)) {
            e = null;
        }
        IconListPreference iconListPreference = (IconListPreference) e;
        if (iconListPreference != null) {
            int[] iArr = iconListPreference.f37326C;
            if (iArr != null) {
                List<Integer> e2 = ArraysKt___ArraysKt.m36104e(iArr);
                if (e2 != null) {
                    return e2;
                }
            }
        }
        int size = m39356f().size();
        Integer[] numArr = new Integer[size];
        for (int i = 0; i < size; i++) {
            numArr[i] = null;
        }
        return ArraysKt___ArraysKt.m36109i(numArr);
    }

    public final Dialog m39359a() {
        int i;
        Object d = d();
        Intrinsics.m26843a(d, "preference");
        CharSequence a = d.a();
        Context context = getContext();
        if (context == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a((Object) context, "context!!");
        Iterable<String> f = m39356f();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(f));
        int i2 = 0;
        for (String triple : f) {
            i = i2 + 1;
            arrayList.add(new Triple(triple, m39357g().get(i2), m39358h().get(i2)));
            i2 = i;
        }
        Iterable<Triple> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Triple triple2 : iterable) {
            arrayList2.add(new ListOptionAction((String) triple2.f25269a, (Integer) triple2.f25271c, new C2904xbba9f092((String) triple2.f25270b, this)));
        }
        List list = (List) arrayList2;
        Object obj = 1;
        boolean z = a != null;
        Integer valueOf = Integer.valueOf(m39355e().b(m39355e().i()));
        i = -1;
        if (valueOf.intValue() != -1) {
            obj = null;
        }
        if (obj != null) {
            valueOf = null;
        }
        if (valueOf != null) {
            i = valueOf.intValue();
        }
        ListOptionsDialog listOptionsDialog = new ListOptionsDialog(context, list, i, z);
        d = d();
        Intrinsics.m26843a(d, "preference");
        a = d.a();
        if (a != null) {
            listOptionsDialog.setTitle(a);
        }
        return listOptionsDialog;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        if (this.f39251k != null) {
            this.f39251k.clear();
        }
    }
}
