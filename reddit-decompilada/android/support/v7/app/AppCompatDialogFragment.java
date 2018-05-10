package android.support.v7.app;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;

public class AppCompatDialogFragment extends DialogFragment {
    public Dialog mo3846a() {
        return new AppCompatDialog(getContext(), this.f16488b);
    }

    public final void mo3847a(Dialog dialog, int i) {
        if (dialog instanceof AppCompatDialog) {
            AppCompatDialog appCompatDialog = (AppCompatDialog) dialog;
            switch (i) {
                case 1:
                case 2:
                    break;
                case 3:
                    dialog.getWindow().addFlags(24);
                    break;
                default:
                    break;
            }
            appCompatDialog.x_();
            return;
        }
        super.mo3847a(dialog, i);
    }
}
