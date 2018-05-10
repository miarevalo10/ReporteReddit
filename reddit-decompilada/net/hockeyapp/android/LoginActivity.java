package net.hockeyapp.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.instabug.library.model.State;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import net.hockeyapp.android.tasks.LoginTask;
import net.hockeyapp.android.utils.AsyncTaskUtils;
import net.hockeyapp.android.utils.HockeyLog;
import net.hockeyapp.android.utils.Util;

public class LoginActivity extends Activity {
    private String f26521a;
    private String f26522b;
    private int f26523c;
    private LoginTask f26524d;
    private Handler f26525e;

    class C21541 implements OnClickListener {
        final /* synthetic */ LoginActivity f26519a;

        C21541(LoginActivity loginActivity) {
            this.f26519a = loginActivity;
        }

        public void onClick(View view) {
            LoginActivity.m28174a(this.f26519a);
        }
    }

    private static class LoginHandler extends Handler {
        private final WeakReference<Activity> f26520a;

        LoginHandler(Activity activity) {
            this.f26520a = new WeakReference(activity);
        }

        public void handleMessage(Message message) {
            Activity activity = (Activity) this.f26520a.get();
            if (activity != null) {
                if (message.getData().getBoolean("success") != null) {
                    activity.finish();
                    if (LoginManager.f26526a != null) {
                        return;
                    }
                }
                Toast.makeText(activity, "Login failed. Check your credentials.", 1).show();
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2158R.layout.hockeyapp_activity_login);
        bundle = getIntent().getExtras();
        if (bundle != null) {
            this.f26521a = bundle.getString(UpdateFragment.FRAGMENT_URL);
            this.f26522b = bundle.getString("secret");
            this.f26523c = bundle.getInt("mode");
        }
        if (this.f26523c == 1) {
            ((EditText) findViewById(C2158R.id.input_password)).setVisibility(4);
        }
        ((TextView) findViewById(C2158R.id.text_headline)).setText(this.f26523c == 1 ? C2158R.string.hockeyapp_login_headline_text_email_only : C2158R.string.hockeyapp_login_headline_text);
        ((Button) findViewById(C2158R.id.button_login)).setOnClickListener(new C21541(this));
        this.f26525e = new LoginHandler(this);
        bundle = getLastNonConfigurationInstance();
        if (bundle != null) {
            this.f26524d = (LoginTask) bundle;
            bundle = this.f26524d;
            Handler handler = this.f26525e;
            bundle.f33151a = this;
            bundle.f33152b = handler;
        }
    }

    public Object onRetainNonConfigurationInstance() {
        if (this.f26524d != null) {
            LoginTask loginTask = this.f26524d;
            loginTask.f33151a = null;
            loginTask.f33152b = null;
            loginTask.f33153c = null;
        }
        return this.f26524d;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 ? true : super.onKeyDown(i, keyEvent);
    }

    private static String m28173a(String str) {
        try {
            return Util.m28234a(Util.m28238a(str.getBytes(), "MD5"));
        } catch (Throwable e) {
            HockeyLog.m28206a("Failed to create MD5 hash", e);
            return "";
        }
    }

    static /* synthetic */ void m28174a(LoginActivity loginActivity) {
        if (Util.m28239b((Context) loginActivity)) {
            CharSequence obj = ((EditText) loginActivity.findViewById(C2158R.id.input_email)).getText().toString();
            CharSequence obj2 = ((EditText) loginActivity.findViewById(C2158R.id.input_password)).getText().toString();
            Map hashMap = new HashMap();
            int i = 0;
            if (loginActivity.f26523c == 1) {
                i = TextUtils.isEmpty(obj) ^ 1;
                hashMap.put(State.KEY_EMAIL, obj);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(loginActivity.f26522b);
                stringBuilder.append(obj);
                hashMap.put("authcode", m28173a(stringBuilder.toString()));
            } else if (loginActivity.f26523c == 2) {
                if (!(TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2))) {
                    i = 1;
                }
                hashMap.put(State.KEY_EMAIL, obj);
                hashMap.put("password", obj2);
            }
            if (i != 0) {
                loginActivity.f26524d = new LoginTask(loginActivity, loginActivity.f26525e, loginActivity.f26521a, loginActivity.f26523c, hashMap);
                AsyncTaskUtils.m28200a(loginActivity.f26524d);
                return;
            }
            Toast.makeText(loginActivity, loginActivity.getString(C2158R.string.hockeyapp_login_missing_credentials_toast), 1).show();
            return;
        }
        Toast.makeText(loginActivity, C2158R.string.hockeyapp_error_no_network_message, 1).show();
    }
}
