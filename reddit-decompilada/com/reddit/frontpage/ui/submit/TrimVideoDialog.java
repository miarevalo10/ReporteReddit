package com.reddit.frontpage.ui.submit;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.ImageView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.AnimUtil;

public class TrimVideoDialog extends DialogFragment {
    public static TrimVideoDialog m37832c() {
        return new TrimVideoDialog();
    }

    public final Dialog m37833a() {
        Builder builder = new Builder(getActivity());
        View inflate = View.inflate(getActivity(), C1761R.layout.dialog_fragment_trim_video, null);
        ((ImageView) inflate.findViewById(C1761R.id.image)).setImageDrawable(AnimUtil.m23637a(getActivity()));
        builder.setView(inflate);
        Dialog create = builder.create();
        create.setCancelable(false);
        create.setCanceledOnTouchOutside(false);
        return create;
    }
}
