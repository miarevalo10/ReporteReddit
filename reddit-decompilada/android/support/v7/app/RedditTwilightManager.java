package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

public class RedditTwilightManager {
    private static RedditTwilightManager f1828c;
    public final Context f1829a;
    public final TwilightState f1830b = new TwilightState();
    private final LocationManager f1831d;

    private static class TwilightState {
        public boolean isNight;
        public long nextUpdate;
        public long todaySunrise;
        public long todaySunset;
        public long tomorrowSunrise;
        public long yesterdaySunset;

        TwilightState() {
        }
    }

    public static RedditTwilightManager m1555a(Context context) {
        if (f1828c == null) {
            context = context.getApplicationContext();
            f1828c = new RedditTwilightManager(context, (LocationManager) context.getSystemService("location"));
        }
        return f1828c;
    }

    private RedditTwilightManager(Context context, LocationManager locationManager) {
        this.f1829a = context;
        this.f1831d = locationManager;
    }

    @SuppressLint({"MissingPermission"})
    public final Location m1556a(String str) {
        try {
            if (this.f1831d.isProviderEnabled(str)) {
                return this.f1831d.getLastKnownLocation(str);
            }
        } catch (String str2) {
            Log.d("RedditTwilightManager", "Failed to get last known location", str2);
        }
        return null;
    }
}
