package com.reddit.frontpage.service.sync;

import android.app.IntentService;
import android.content.Intent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.feature.settings.UserSettingsStorage;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.AccountPrefs;
import com.reddit.frontpage.FrontpageApplication;
import javax.inject.Inject;
import timber.log.Timber;

public class PreferencesSyncService extends IntentService {
    private static final String f21039b = "PreferencesSyncService";
    @Inject
    RemoteRedditApiDataSource f21040a;

    public PreferencesSyncService() {
        super(f21039b);
        FrontpageApplication.m28877m().mo4604a(this);
        setIntentRedelivery(true);
    }

    protected void onHandleIntent(Intent intent) {
        intent = intent.getStringExtra("action");
        int hashCode = intent.hashCode();
        if (hashCode != 113762) {
            if (hashCode == 97322682) {
                if (intent.equals("fetch") != null) {
                    intent = null;
                    switch (intent) {
                        case null:
                            intent = SessionManager.b();
                            if (!intent.c.isAnonymous()) {
                                try {
                                    UserSettingsStorage.a().a(intent.c).a((AccountPrefs) RemoteRedditApiDataSource.d().blockingGet());
                                } catch (Intent intent2) {
                                    Timber.c(intent2, "Unable to retrieve account prefs", new Object[0]);
                                    return;
                                }
                            }
                            return;
                        case 1:
                            intent2 = SessionManager.b();
                            if (!intent2.c.isAnonymous()) {
                                try {
                                    RemoteRedditApiDataSource.a(UserSettingsStorage.a().a(intent2.c).a).blockingGet();
                                    return;
                                } catch (Intent intent22) {
                                    Timber.c(intent22, f21039b, new Object[0]);
                                    break;
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        } else if (intent22.equals("set") != null) {
            intent22 = true;
            switch (intent22) {
                case null:
                    intent22 = SessionManager.b();
                    if (intent22.c.isAnonymous()) {
                        UserSettingsStorage.a().a(intent22.c).a((AccountPrefs) RemoteRedditApiDataSource.d().blockingGet());
                    }
                    return;
                case 1:
                    intent22 = SessionManager.b();
                    if (intent22.c.isAnonymous()) {
                        RemoteRedditApiDataSource.a(UserSettingsStorage.a().a(intent22.c).a).blockingGet();
                        return;
                    }
                    break;
                default:
                    break;
            }
        }
        intent22 = -1;
        switch (intent22) {
            case null:
                intent22 = SessionManager.b();
                if (intent22.c.isAnonymous()) {
                    UserSettingsStorage.a().a(intent22.c).a((AccountPrefs) RemoteRedditApiDataSource.d().blockingGet());
                }
                return;
            case 1:
                intent22 = SessionManager.b();
                if (intent22.c.isAnonymous()) {
                    RemoteRedditApiDataSource.a(UserSettingsStorage.a().a(intent22.c).a).blockingGet();
                    return;
                }
                break;
            default:
                break;
        }
    }
}
