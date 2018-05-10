package com.instabug.library.core.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.instabug.library.core.ui.BaseContract.Presenter;
import com.instabug.library.core.ui.BaseContract.View;
import com.instabug.library.util.InstabugSDKLogger;

public abstract class BaseFragment<P extends Presenter> extends Fragment implements View<Fragment> {
    protected P presenter;
    protected android.view.View rootView;

    public abstract int getLayout();

    public Fragment getViewContext() {
        return this;
    }

    public abstract void initViews(android.view.View view, Bundle bundle);

    public void onCreate(Bundle bundle) {
        InstabugSDKLogger.m8356d(this, "onCreate called");
        super.onCreate(bundle);
    }

    public android.view.View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InstabugSDKLogger.m8356d(this, "onCreateView called");
        this.rootView = layoutInflater.inflate(getLayout(), viewGroup, false);
        initViews(this.rootView, bundle);
        return this.rootView;
    }

    public void onViewCreated(android.view.View view, Bundle bundle) {
        InstabugSDKLogger.m8356d(this, "onViewCreated called");
        super.onViewCreated(view, bundle);
    }

    public void onStart() {
        InstabugSDKLogger.m8356d(this, "onStart called");
        super.onStart();
    }

    public void onStop() {
        InstabugSDKLogger.m8356d(this, "onStop called");
        super.onStop();
    }

    public void onDestroyView() {
        InstabugSDKLogger.m8356d(this, "onDestroyView called");
        super.onDestroyView();
    }

    public void finishActivity() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    protected android.view.View findViewById(int i) {
        return this.rootView.findViewById(i);
    }
}
