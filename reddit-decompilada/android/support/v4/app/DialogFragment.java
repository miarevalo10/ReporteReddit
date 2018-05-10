package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class DialogFragment extends Fragment implements OnCancelListener, OnDismissListener {
    int f16487a = 0;
    protected int f16488b = 0;
    boolean f16489c = true;
    protected boolean f16490d = true;
    int f16491e = -1;
    public Dialog f16492f;
    boolean f16493g;
    boolean f16494h;
    boolean f16495i;

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void mo3959a(FragmentManager fragmentManager, String str) {
        this.f16494h = false;
        this.f16495i = true;
        fragmentManager = fragmentManager.mo219a();
        fragmentManager.mo197a((Fragment) this, str);
        fragmentManager.mo203c();
    }

    public final void m16612b() {
        m16611a(false);
    }

    public final void m16611a(boolean z) {
        if (!this.f16494h) {
            this.f16494h = true;
            this.f16495i = false;
            if (this.f16492f != null) {
                this.f16492f.dismiss();
                this.f16492f = null;
            }
            this.f16493g = true;
            if (this.f16491e >= 0) {
                getFragmentManager().mo223b(this.f16491e);
                this.f16491e = true;
                return;
            }
            FragmentTransaction a = getFragmentManager().mo219a();
            a.mo196a((Fragment) this);
            if (z) {
                a.mo205d();
            } else {
                a.mo203c();
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.f16495i == null) {
            this.f16494h = null;
        }
    }

    public void onDetach() {
        super.onDetach();
        if (!this.f16495i && !this.f16494h) {
            this.f16494h = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16490d = this.mContainerId == 0;
        if (bundle != null) {
            this.f16487a = bundle.getInt("android:style", 0);
            this.f16488b = bundle.getInt("android:theme", 0);
            this.f16489c = bundle.getBoolean("android:cancelable", true);
            this.f16490d = bundle.getBoolean("android:showsDialog", this.f16490d);
            this.f16491e = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        if (!this.f16490d) {
            return super.onGetLayoutInflater(bundle);
        }
        this.f16492f = mo3846a();
        if (this.f16492f == null) {
            return (LayoutInflater) this.mHost.f11275c.getSystemService("layout_inflater");
        }
        mo3847a(this.f16492f, this.f16487a);
        return (LayoutInflater) this.f16492f.getContext().getSystemService("layout_inflater");
    }

    public void mo3847a(Dialog dialog, int i) {
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public Dialog mo3846a() {
        return new Dialog(getActivity(), this.f16488b);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f16493g == null) {
            m16611a(true);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f16490d) {
            View view = getView();
            if (view != null) {
                if (view.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f16492f.setContentView(view);
            }
            Activity activity = getActivity();
            if (activity != null) {
                this.f16492f.setOwnerActivity(activity);
            }
            this.f16492f.setCancelable(this.f16489c);
            this.f16492f.setOnCancelListener(this);
            this.f16492f.setOnDismissListener(this);
            if (bundle != null) {
                bundle = bundle.getBundle("android:savedDialogState");
                if (bundle != null) {
                    this.f16492f.onRestoreInstanceState(bundle);
                }
            }
        }
    }

    public void onStart() {
        super.onStart();
        if (this.f16492f != null) {
            this.f16493g = false;
            this.f16492f.show();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f16492f != null) {
            Bundle onSaveInstanceState = this.f16492f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.f16487a != 0) {
            bundle.putInt("android:style", this.f16487a);
        }
        if (this.f16488b != 0) {
            bundle.putInt("android:theme", this.f16488b);
        }
        if (!this.f16489c) {
            bundle.putBoolean("android:cancelable", this.f16489c);
        }
        if (!this.f16490d) {
            bundle.putBoolean("android:showsDialog", this.f16490d);
        }
        if (this.f16491e != -1) {
            bundle.putInt("android:backStackId", this.f16491e);
        }
    }

    public void onStop() {
        super.onStop();
        if (this.f16492f != null) {
            this.f16492f.hide();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.f16492f != null) {
            this.f16493g = true;
            this.f16492f.dismiss();
            this.f16492f = null;
        }
    }
}
