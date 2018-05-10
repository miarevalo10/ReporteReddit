package com.instabug.library;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.instabug.library.util.InstabugSDKLogger;

public abstract class InstabugBaseFragment extends Fragment {
    private Activity activity;
    private boolean isStateRestored;
    private View view;

    public abstract void consumeNewInstanceSavedArguments();

    public abstract int getLayout();

    public abstract String getTitle();

    public abstract void restoreState(Bundle bundle);

    public abstract void saveState(Bundle bundle);

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        InstabugSDKLogger.m8360v(this, "onCreateView called");
        if (getArguments() != null) {
            bundle = new StringBuilder("Arguments found, calling consumeNewInstanceSavedArguments with ");
            bundle.append(getArguments());
            InstabugSDKLogger.m8360v(this, bundle.toString());
            consumeNewInstanceSavedArguments();
        }
        this.isStateRestored = null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InstabugSDKLogger.m8360v(this, "onCreateView called");
        this.view = layoutInflater.inflate(getLayout(), viewGroup, false);
        setTitle(getTitle());
        return this.view;
    }

    public void onViewCreated(View view, Bundle bundle) {
        InstabugSDKLogger.m8360v(this, "onViewCreated called");
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            InstabugSDKLogger.m8360v(this, "savedInstanceState found, calling restoreState");
            restoreState(bundle);
            this.isStateRestored = true;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        InstabugSDKLogger.m8360v(this, "onSaveInstanceState called, calling saveState");
        saveState(bundle);
    }

    public void onPause() {
        super.onPause();
        InstabugSDKLogger.m8360v(this, "onPause called, calling saveState");
    }

    public void onResume() {
        super.onResume();
        InstabugSDKLogger.m8360v(this, "onResume called, calling saveState");
    }

    public boolean isStateRestored() {
        return this.isStateRestored;
    }

    public Activity getPreservedActivity() {
        StringBuilder stringBuilder = new StringBuilder("Returning preserved activity ");
        stringBuilder.append(this.activity);
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        return this.activity;
    }

    public void setTitle(String str) {
        if (this.view == null) {
            InstabugSDKLogger.m8360v(this, "Calling setTitle before inflating the view! Ignoring call");
            return;
        }
        TextView textView = (TextView) this.view.findViewById(C0593R.id.instabug_fragment_title);
        if (textView != null) {
            StringBuilder stringBuilder = new StringBuilder("Setting fragment title to \"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            textView.setText(str);
            return;
        }
        InstabugSDKLogger.m8360v(this, "instabug_fragment_title wasn't found, make sure your layout.xml contains it");
    }
}
