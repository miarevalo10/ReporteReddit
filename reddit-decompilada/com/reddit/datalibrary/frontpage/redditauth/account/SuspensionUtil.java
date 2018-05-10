package com.reddit.datalibrary.frontpage.redditauth.account;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;

public class SuspensionUtil {
    public static boolean m9210a(SessionManager sessionManager) {
        sessionManager = sessionManager.m9205d();
        if (sessionManager != null) {
            if (sessionManager.is_suspended) {
                if (sessionManager.suspension_expiration_utc == null || sessionManager.suspension_expiration_utc.intValue() <= null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static int m9211b(SessionManager sessionManager) {
        sessionManager = sessionManager.m9205d();
        if (sessionManager != null && sessionManager.is_suspended) {
            if (sessionManager.suspension_expiration_utc != null) {
                return Math.max((int) TimeUnit.DAYS.convert(((long) sessionManager.suspension_expiration_utc.intValue()) - (new Date().getTime() / 1000), TimeUnit.SECONDS), 1);
            }
        }
        Timber.e(SuspensionUtil.class.toString(), new Object[]{"Account has no suspension expiration date"});
        return 0;
    }
}
