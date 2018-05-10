package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.internal.zzbq;

public class SupportErrorDialogFragment extends DialogFragment {
    private Dialog f19105j = null;
    private OnCancelListener f19106k = null;

    public static SupportErrorDialogFragment m20193a(Dialog dialog, OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        dialog = (Dialog) zzbq.m4809a((Object) dialog, (Object) "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        supportErrorDialogFragment.f19105j = dialog;
        if (onCancelListener != null) {
            supportErrorDialogFragment.f19106k = onCancelListener;
        }
        return supportErrorDialogFragment;
    }

    public final void mo3959a(FragmentManager fragmentManager, String str) {
        super.mo3959a(fragmentManager, str);
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f19106k != null) {
            this.f19106k.onCancel(dialogInterface);
        }
    }

    public final Dialog mo3846a() {
        if (this.f19105j == null) {
            this.f16490d = false;
        }
        return this.f19105j;
    }
}
