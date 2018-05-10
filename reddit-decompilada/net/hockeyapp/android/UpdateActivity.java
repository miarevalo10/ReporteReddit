package net.hockeyapp.android;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class UpdateActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getIntent().getExtras();
            if (bundle == null) {
                finish();
                return;
            } else {
                getFragmentManager().beginTransaction().add(16908290, Fragment.instantiate(this, bundle.getString("fragmentClass", UpdateFragment.class.getName()), bundle), UpdateFragment.FRAGMENT_TAG).commit();
            }
        }
        setTitle(C2158R.string.hockeyapp_update_title);
    }
}
