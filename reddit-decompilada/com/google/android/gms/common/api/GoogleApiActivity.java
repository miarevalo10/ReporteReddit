package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.zzbm;
import org.jcodec.codecs.common.biari.MQEncoder;

public class GoogleApiActivity extends Activity implements OnCancelListener {
    private int f5742a = 0;

    public static PendingIntent m4634a(Context context, PendingIntent pendingIntent, int i) {
        return PendingIntent.getActivity(context, 0, m4635a(context, pendingIntent, i, true), MQEncoder.CARRY_MASK);
    }

    public static Intent m4635a(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f5742a = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                zzbm a = zzbm.m4711a((Context) this);
                switch (i2) {
                    case -1:
                        a.m4731c();
                        break;
                    case 0:
                        a.m4730b(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                        break;
                    default:
                        break;
                }
            }
        } else if (i == 2) {
            this.f5742a = 0;
            setResult(i2, intent);
        }
        finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f5742a = 0;
        setResult(0);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f5742a = bundle.getInt("resolution");
        }
        if (this.f5742a != 1) {
            String str;
            String str2;
            bundle = getIntent().getExtras();
            if (bundle == null) {
                str = "GoogleApiActivity";
                str2 = "Activity started without extras";
            } else {
                PendingIntent pendingIntent = (PendingIntent) bundle.get("pending_intent");
                Integer num = (Integer) bundle.get("error_code");
                if (pendingIntent == null && num == null) {
                    str = "GoogleApiActivity";
                    str2 = "Activity started without resolution";
                } else if (pendingIntent != null) {
                    try {
                        startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                        this.f5742a = 1;
                        return;
                    } catch (Throwable e) {
                        Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                    }
                } else {
                    GoogleApiAvailability.m12790a();
                    GoogleApiAvailability.m12795b(this, num.intValue(), 2, this);
                    this.f5742a = 1;
                }
            }
            Log.e(str, str2);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f5742a);
        super.onSaveInstanceState(bundle);
    }
}
