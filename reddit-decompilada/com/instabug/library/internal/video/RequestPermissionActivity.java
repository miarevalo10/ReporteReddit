package com.instabug.library.internal.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.instabug.library._InstabugActivity;
import com.instabug.library.broadcast.C0648a;
import com.instabug.library.broadcast.C0648a.C0647a;
import com.instabug.library.settings.SettingsManager;

@TargetApi(21)
public class RequestPermissionActivity extends Activity implements _InstabugActivity, C0647a {
    private C0648a f15473a = new C0648a(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            startActivityForResult(((MediaProjectionManager) getSystemService("media_projection")).createScreenCaptureIntent(), 2020);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2020) {
            if (i2 == -1) {
                try {
                    startService(AutoScreenRecordingService.m8200a(this, i2, intent));
                } catch (int i3) {
                    i3.printStackTrace();
                    return;
                } finally {
                    finish();
                }
            } else if (i2 == 0) {
                SettingsManager.getInstance().setAutoScreenRecordingDenied(1);
            }
        }
        finish();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public final void mo2567a(boolean z) {
        if (z) {
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.m744a(getApplicationContext()).m747a(this.f15473a, new IntentFilter("SDK invoked"));
    }

    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.m744a(getApplicationContext()).m746a(this.f15473a);
    }

    protected void onStart() {
        super.onStart();
        SettingsManager.getInstance().setRequestPermissionScreenShown(true);
    }

    protected void onStop() {
        super.onStop();
        SettingsManager.getInstance().setRequestPermissionScreenShown(false);
        finish();
    }
}
