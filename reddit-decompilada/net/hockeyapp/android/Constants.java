package net.hockeyapp.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import net.hockeyapp.android.utils.AsyncTaskUtils;
import net.hockeyapp.android.utils.HockeyLog;

public class Constants {
    public static String f26467a;
    public static String f26468b;
    public static String f26469c;
    public static String f26470d;
    public static String f26471e;
    public static String f26472f;
    public static String f26473g;
    static String f26474h;
    static CountDownLatch f26475i = new CountDownLatch(1);

    public static void m28151a(final Context context) {
        f26470d = VERSION.RELEASE;
        f26471e = Build.DISPLAY;
        f26472f = Build.MODEL;
        f26473g = Build.MANUFACTURER;
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                f26469c = packageInfo.packageName;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(packageInfo.versionCode);
                f26467a = stringBuilder.toString();
                f26468b = packageInfo.versionName;
                int a = m28150a(context, packageManager);
                if (a != 0 && a > packageInfo.versionCode) {
                    f26467a = String.valueOf(a);
                }
            } catch (Throwable e) {
                HockeyLog.m28206a("Exception thrown when accessing the package info", e);
            }
        }
        if (f26474h == null) {
            AsyncTaskUtils.m28200a(new AsyncTask<Void, Object, String>() {
                protected final /* synthetic */ void onPostExecute(Object obj) {
                    Constants.f26474h = (String) obj;
                    Constants.f26475i.countDown();
                }

                protected final /* synthetic */ Object doInBackground(Object[] objArr) {
                    objArr = context.getSharedPreferences("HockeyApp", 0);
                    Object string = objArr.getString("deviceIdentifier", null);
                    if (string != null) {
                        return string;
                    }
                    String uuid = UUID.randomUUID().toString();
                    objArr.edit().putString("deviceIdentifier", uuid).apply();
                    return uuid;
                }
            });
        }
    }

    public static File m28152b(Context context) {
        File file = new File(context.getExternalFilesDir(null), "HockeyApp");
        if (file.exists() == null) {
            if (file.mkdirs() == null) {
                context = null;
                if (context == null) {
                    HockeyLog.m28207b("Couldn't create HockeyApp Storage dir");
                }
                return file;
            }
        }
        context = true;
        if (context == null) {
            HockeyLog.m28207b("Couldn't create HockeyApp Storage dir");
        }
        return file;
    }

    private static int m28150a(Context context, PackageManager packageManager) {
        try {
            context = packageManager.getApplicationInfo(context.getPackageName(), 128).metaData;
            if (context != null) {
                return context.getInt("buildNumber", 0);
            }
        } catch (Throwable e) {
            HockeyLog.m28206a("Exception thrown when accessing the application info", e);
        }
        return 0;
    }
}
