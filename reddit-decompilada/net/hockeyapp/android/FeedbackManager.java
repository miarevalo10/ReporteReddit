package net.hockeyapp.android;

import android.content.BroadcastReceiver;
import net.hockeyapp.android.objects.FeedbackUserDataElement;

public class FeedbackManager {
    private static BroadcastReceiver f26512a = null;
    private static boolean f26513b = false;
    private static String f26514c;
    private static String f26515d;
    private static FeedbackUserDataElement f26516e = FeedbackUserDataElement.REQUIRED;
    private static FeedbackUserDataElement f26517f = FeedbackUserDataElement.REQUIRED;
    private static FeedbackManagerListener f26518g;

    public static FeedbackManagerListener m28168a() {
        return f26518g;
    }

    public static FeedbackUserDataElement m28169b() {
        return f26516e;
    }

    public static FeedbackUserDataElement m28170c() {
        return f26517f;
    }
}
