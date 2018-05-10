package com.reddit.frontpage.redditauth_private.account;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.AuthUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.redditauth.api.FrontpageRedditAuth;
import com.reddit.datalibrary.frontpage.redditauth.api.RedditAuthClient;
import com.reddit.datalibrary.frontpage.redditauth.models.AccessTokenResponse;
import com.reddit.datalibrary.frontpage.redditauth.models.Scope;
import com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder;
import com.reddit.frontpage.redditauth_private.account.TokenRetriever.TokenRetrievalError;
import com.reddit.frontpage.redditauth_private.ui.AuthActivity;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;

public class AccountAuthenticator extends AbstractAccountAuthenticator {
    final Context f21005a;

    public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) throws NetworkErrorException {
        return null;
    }

    public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        return null;
    }

    public String getAuthTokenLabel(String str) {
        return str;
    }

    public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) throws NetworkErrorException {
        return null;
    }

    public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) throws NetworkErrorException {
        return null;
    }

    public AccountAuthenticator(Context context) {
        super(context);
        this.f21005a = context;
    }

    public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) throws NetworkErrorException {
        str2 = new Intent(this.f21005a, AuthActivity.class);
        str2.putExtra("accountType", str);
        str2.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        str2.putExtra("com.reddit.is_signup", bundle.getBoolean("com.reddit.is_signup", null));
        accountAuthenticatorResponse = new Bundle();
        accountAuthenticatorResponse.putParcelable("intent", str2);
        return accountAuthenticatorResponse;
    }

    public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account) throws NetworkErrorException {
        accountAuthenticatorResponse = TextUtils.equals(account.name, "Reddit for Android") ^ 1;
        account = new Bundle();
        account.putBoolean("booleanResult", accountAuthenticatorResponse);
        return account;
    }

    private static Bundle m23222a(Account account, String str, long j) {
        Bundle bundle = new Bundle();
        bundle.putString("authAccount", account.name);
        bundle.putString("accountType", account.type);
        bundle.putString("authtoken", str);
        bundle.putLong("com.reddit.expiration", System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(j));
        return bundle;
    }

    public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) throws NetworkErrorException {
        Timber.b("anon check: %s / %s", new Object[]{account.name, "Reddit for Android"});
        if (TextUtils.equals(account.name, "Reddit for Android") != null) {
            Timber.b("trying for anon token", new Object[0]);
            try {
                AccessTokenResponse accessTokenResponse = (AccessTokenResponse) new RequestBuilder(new FrontpageRedditAuth().a, AccessTokenResponse.class).a(1).a("api/v1/access_token").c(HttpRequest.HEADER_AUTHORIZATION, AuthUtil.a(Config.c, "")).b("grant_type", "https://oauth.reddit.com/grants/installed_client").b("device_id", Config.g).b();
                Timber.b("got anon token: %s with expires_in: %d", new Object[]{accessTokenResponse.getAccessToken(), Long.valueOf(accessTokenResponse.getExpiresIn())});
                return m23222a(account, accessTokenResponse.getAccessToken(), accessTokenResponse.getExpiresIn());
            } catch (AccountAuthenticatorResponse accountAuthenticatorResponse2) {
                throw new NetworkErrorException(accountAuthenticatorResponse2);
            }
        }
        accountAuthenticatorResponse2 = AccountManager.get(this.f21005a);
        Object peekAuthToken = accountAuthenticatorResponse2.peekAuthToken(account, str);
        Long a = AccountUtil.a(accountAuthenticatorResponse2, account);
        Timber.b("getAuthToken", new Object[0]);
        if (!TextUtils.isEmpty(peekAuthToken)) {
            return m23222a(account, peekAuthToken, a.longValue());
        }
        Timber.b("Token was not found on peek", new Object[0]);
        RedditAuthClient redditAuthClient = new RedditAuthClient();
        String userData = accountAuthenticatorResponse2.getUserData(account, "com.reddit.refresh_token");
        String userData2 = accountAuthenticatorResponse2.getUserData(account, "com.reddit.cookie");
        String userData3 = accountAuthenticatorResponse2.getUserData(account, "com.reddit.modhash");
        Timber.b("account %s:%s refresh token=%s cookie=%s modhash=%s", new Object[]{account.name, account.type, userData, userData2, userData3});
        if (userData != null) {
            Timber.b("Attempting to get token using refresh token", new Object[0]);
            try {
                bundle = TokenRetriever.m23225a(redditAuthClient, userData);
                if (!TextUtils.isEmpty(bundle.getAccessToken())) {
                    return m23222a(account, bundle.getAccessToken(), bundle.getExpiresIn());
                }
            } catch (AccountAuthenticatorResponse accountAuthenticatorResponse22) {
                m23224a(account, accountAuthenticatorResponse22);
                throw new NetworkErrorException(accountAuthenticatorResponse22);
            }
        }
        if (!(userData2 == null || userData3 == null)) {
            Timber.b("Attempting to get token using cookie and modhash", new Object[0]);
            try {
                accountAuthenticatorResponse22 = TokenRetriever.m23226a(redditAuthClient, userData2, userData3, Scope.fromString(str));
                str = accountAuthenticatorResponse22.getAccessToken();
                if (TextUtils.isEmpty(str) == null) {
                    return m23222a(account, str, accountAuthenticatorResponse22.getExpiresIn());
                }
            } catch (AccountAuthenticatorResponse accountAuthenticatorResponse222) {
                m23224a(account, accountAuthenticatorResponse222);
                throw new NetworkErrorException(accountAuthenticatorResponse222);
            }
        }
        Timber.b("No refresh token or cookie", new Object[0]);
        m23223a(account);
        return new Bundle();
    }

    private void m23223a(Account account) {
        Timber.b("Revoking account: %s", new Object[]{account});
        if (AccountUtil.a(this.f21005a, account, null) && SessionManager.b().b(account) != null) {
            new Handler(Looper.getMainLooper()).post(new AccountAuthenticator$$Lambda$0(this));
        }
    }

    private void m23224a(Account account, TokenRetrievalError tokenRetrievalError) {
        if (tokenRetrievalError.f21012a != null && AccountUtil.a(this.f21005a, account, null) != null) {
            m23223a(account);
        }
    }
}
