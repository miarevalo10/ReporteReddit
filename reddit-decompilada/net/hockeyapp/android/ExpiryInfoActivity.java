package net.hockeyapp.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import net.hockeyapp.android.utils.Util;

public class ExpiryInfoActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(C2158R.string.hockeyapp_expiry_info_title);
        setContentView(C2158R.layout.hockeyapp_activity_expiry_info);
        bundle = Util.m28241c(this);
        ((TextView) findViewById(C2158R.id.label_message)).setText(getString(C2158R.string.hockeyapp_expiry_info_text, new Object[]{bundle}));
    }
}
