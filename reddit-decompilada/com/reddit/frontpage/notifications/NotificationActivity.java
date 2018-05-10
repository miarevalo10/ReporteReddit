package com.reddit.frontpage.notifications;

import android.accounts.Account;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.social.util.ChatUtilKt;
import java.util.Objects;
import timber.log.Timber;

public class NotificationActivity extends AppCompatActivity {
    protected void onCreate(Bundle bundle) {
        boolean z;
        Account b;
        boolean z2;
        boolean z3;
        Uri parse;
        super.onCreate(bundle);
        bundle = getIntent();
        String stringExtra = bundle.getStringExtra("com.reddit.extra.id");
        String stringExtra2 = bundle.getStringExtra("com.reddit.extra.type");
        String stringExtra3 = bundle.getStringExtra("com.reddit.extra.extras");
        Config.c(stringExtra);
        AppAnalytics.m21866c(stringExtra, stringExtra2, stringExtra3);
        stringExtra = bundle.getStringExtra("account_id");
        if (!stringExtra2.equals("chat_message")) {
            if (!stringExtra2.equals("chat_request")) {
                z = false;
                if (!Objects.equals(SessionUtil.m23893a(stringExtra), SessionUtil.m23898d())) {
                    b = AccountUtil.b(this, stringExtra);
                    if (b != null) {
                        z2 = false;
                        if (!z2) {
                            if (stringExtra != null) {
                                z3 = false;
                                if (z) {
                                    ChatUtilKt.m24754a();
                                }
                                parse = z3 ? Uri.parse(bundle.getStringExtra("com.reddit.extra.uri")) : null;
                                if (IntentUtil.m23758a(parse)) {
                                    Timber.e("NotificationActivity started with non-handleable intent: %s, deeplink: %s", new Object[]{bundle, parse});
                                    startActivity(IntentUtil.m23751a((Context) this, false));
                                } else {
                                    startActivity(IntentUtil.m23763b(parse));
                                }
                                finish();
                            }
                        }
                        z3 = true;
                        if (z) {
                            ChatUtilKt.m24754a();
                        }
                        if (z3) {
                        }
                        if (IntentUtil.m23758a(parse)) {
                            Timber.e("NotificationActivity started with non-handleable intent: %s, deeplink: %s", new Object[]{bundle, parse});
                            startActivity(IntentUtil.m23751a((Context) this, false));
                        } else {
                            startActivity(IntentUtil.m23763b(parse));
                        }
                        finish();
                    }
                    SessionManager.b().a(b.name, b.type, true);
                    Toast.makeText(this, getString(C1761R.string.rdt_account_changed_toast_1, new Object[]{b.name}), 1).show();
                }
                z2 = true;
                if (z2) {
                    if (stringExtra != null) {
                        z3 = false;
                        if (z) {
                            ChatUtilKt.m24754a();
                        }
                        if (z3) {
                        }
                        if (IntentUtil.m23758a(parse)) {
                            startActivity(IntentUtil.m23763b(parse));
                        } else {
                            Timber.e("NotificationActivity started with non-handleable intent: %s, deeplink: %s", new Object[]{bundle, parse});
                            startActivity(IntentUtil.m23751a((Context) this, false));
                        }
                        finish();
                    }
                }
                z3 = true;
                if (z) {
                    ChatUtilKt.m24754a();
                }
                if (z3) {
                }
                if (IntentUtil.m23758a(parse)) {
                    Timber.e("NotificationActivity started with non-handleable intent: %s, deeplink: %s", new Object[]{bundle, parse});
                    startActivity(IntentUtil.m23751a((Context) this, false));
                } else {
                    startActivity(IntentUtil.m23763b(parse));
                }
                finish();
            }
        }
        z = true;
        if (Objects.equals(SessionUtil.m23893a(stringExtra), SessionUtil.m23898d())) {
            b = AccountUtil.b(this, stringExtra);
            if (b != null) {
                SessionManager.b().a(b.name, b.type, true);
                Toast.makeText(this, getString(C1761R.string.rdt_account_changed_toast_1, new Object[]{b.name}), 1).show();
            } else {
                z2 = false;
                if (z2) {
                    if (stringExtra != null) {
                        z3 = false;
                        if (z) {
                            ChatUtilKt.m24754a();
                        }
                        if (z3) {
                        }
                        if (IntentUtil.m23758a(parse)) {
                            startActivity(IntentUtil.m23763b(parse));
                        } else {
                            Timber.e("NotificationActivity started with non-handleable intent: %s, deeplink: %s", new Object[]{bundle, parse});
                            startActivity(IntentUtil.m23751a((Context) this, false));
                        }
                        finish();
                    }
                }
                z3 = true;
                if (z) {
                    ChatUtilKt.m24754a();
                }
                if (z3) {
                }
                if (IntentUtil.m23758a(parse)) {
                    Timber.e("NotificationActivity started with non-handleable intent: %s, deeplink: %s", new Object[]{bundle, parse});
                    startActivity(IntentUtil.m23751a((Context) this, false));
                } else {
                    startActivity(IntentUtil.m23763b(parse));
                }
                finish();
            }
        }
        z2 = true;
        if (z2) {
            if (stringExtra != null) {
                z3 = false;
                if (z) {
                    ChatUtilKt.m24754a();
                }
                if (z3) {
                }
                if (IntentUtil.m23758a(parse)) {
                    startActivity(IntentUtil.m23763b(parse));
                } else {
                    Timber.e("NotificationActivity started with non-handleable intent: %s, deeplink: %s", new Object[]{bundle, parse});
                    startActivity(IntentUtil.m23751a((Context) this, false));
                }
                finish();
            }
        }
        z3 = true;
        if (z) {
            ChatUtilKt.m24754a();
        }
        if (z3) {
        }
        if (IntentUtil.m23758a(parse)) {
            Timber.e("NotificationActivity started with non-handleable intent: %s, deeplink: %s", new Object[]{bundle, parse});
            startActivity(IntentUtil.m23751a((Context) this, false));
        } else {
            startActivity(IntentUtil.m23763b(parse));
        }
        finish();
    }
}
