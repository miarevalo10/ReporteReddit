package com.google.android.exoplayer2.source.chunk;

import android.util.Log;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException;

public final class ChunkedTrackBlacklistUtil {
    public static boolean m3982a(Exception exception) {
        if (!(exception instanceof InvalidResponseCodeException)) {
            return false;
        }
        exception = ((InvalidResponseCodeException) exception).f13676c;
        if (exception != 404) {
            if (exception != 410) {
                return false;
            }
        }
        return true;
    }

    public static boolean m3981a(TrackSelection trackSelection, int i, Exception exception) {
        if (!m3982a(exception)) {
            return null;
        }
        boolean d = trackSelection.mo1460d(i);
        exception = ((InvalidResponseCodeException) exception).f13676c;
        StringBuilder stringBuilder;
        if (d) {
            stringBuilder = new StringBuilder("Blacklisted: duration=60000, responseCode=");
            stringBuilder.append(exception);
            stringBuilder.append(", format=");
            stringBuilder.append(trackSelection.mo1456a(i));
            Log.w("ChunkedTrackBlacklist", stringBuilder.toString());
        } else {
            stringBuilder = new StringBuilder("Blacklisting failed (cannot blacklist last enabled track): responseCode=");
            stringBuilder.append(exception);
            stringBuilder.append(", format=");
            stringBuilder.append(trackSelection.mo1456a(i));
            Log.w("ChunkedTrackBlacklist", stringBuilder.toString());
        }
        return d;
    }
}
