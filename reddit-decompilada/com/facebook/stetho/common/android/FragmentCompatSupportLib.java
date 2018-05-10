package com.facebook.stetho.common.android;

import android.app.Dialog;
import android.content.res.Resources;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;

final class FragmentCompatSupportLib extends FragmentCompat<Fragment, DialogFragment, FragmentManager, FragmentActivity> {
    private static final DialogFragmentAccessorSupportLib sDialogFragmentAccessor = new DialogFragmentAccessorSupportLib();
    private static final FragmentAccessorSupportLib sFragmentAccessor = new FragmentAccessorSupportLib();
    private static final FragmentActivityAccessorSupportLib sFragmentActivityAccessor = new FragmentActivityAccessorSupportLib();
    private static final FragmentManagerAccessorViaReflection<FragmentManager, Fragment> sFragmentManagerAccessor = new FragmentManagerAccessorViaReflection();

    private static class FragmentAccessorSupportLib implements FragmentAccessor<Fragment, FragmentManager> {
        private FragmentAccessorSupportLib() {
        }

        public FragmentManager getFragmentManager(Fragment fragment) {
            return fragment.getFragmentManager();
        }

        public Resources getResources(Fragment fragment) {
            return fragment.getResources();
        }

        public int getId(Fragment fragment) {
            return fragment.getId();
        }

        public String getTag(Fragment fragment) {
            return fragment.getTag();
        }

        public View getView(Fragment fragment) {
            return fragment.getView();
        }

        public FragmentManager getChildFragmentManager(Fragment fragment) {
            return fragment.getChildFragmentManager();
        }
    }

    private static class FragmentActivityAccessorSupportLib implements FragmentActivityAccessor<FragmentActivity, FragmentManager> {
        private FragmentActivityAccessorSupportLib() {
        }

        public FragmentManager getFragmentManager(FragmentActivity fragmentActivity) {
            return fragmentActivity.getSupportFragmentManager();
        }
    }

    private static class DialogFragmentAccessorSupportLib extends FragmentAccessorSupportLib implements DialogFragmentAccessor<DialogFragment, Fragment, FragmentManager> {
        private DialogFragmentAccessorSupportLib() {
            super();
        }

        public Dialog getDialog(DialogFragment dialogFragment) {
            return dialogFragment.f16492f;
        }
    }

    FragmentCompatSupportLib() {
    }

    public final Class<Fragment> getFragmentClass() {
        return Fragment.class;
    }

    public final Class<DialogFragment> getDialogFragmentClass() {
        return DialogFragment.class;
    }

    public final Class<FragmentActivity> getFragmentActivityClass() {
        return FragmentActivity.class;
    }

    public final FragmentAccessorSupportLib forFragment() {
        return sFragmentAccessor;
    }

    public final DialogFragmentAccessorSupportLib forDialogFragment() {
        return sDialogFragmentAccessor;
    }

    public final FragmentManagerAccessor<FragmentManager, Fragment> forFragmentManager() {
        return sFragmentManagerAccessor;
    }

    public final FragmentActivityAccessorSupportLib forFragmentActivity() {
        return sFragmentActivityAccessor;
    }
}
