package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GetRequest {
    private static final Pattern f3723d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern f3724e = Pattern.compile("GET /(.*) HTTP");
    public final String f3725a;
    public final long f3726b;
    public final boolean f3727c;

    private GetRequest(String str) {
        long parseLong;
        Preconditions.m3330a((Object) str);
        Matcher matcher = f3723d.matcher(str);
        if (matcher.find()) {
            parseLong = Long.parseLong(matcher.group(1));
        } else {
            parseLong = -1;
        }
        this.f3726b = Math.max(0, parseLong);
        this.f3727c = parseLong >= 0;
        matcher = f3724e.matcher(str);
        if (matcher.find()) {
            this.f3725a = matcher.group(1);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid request `");
        stringBuilder.append(str);
        stringBuilder.append("`: url not found!");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static GetRequest m3311a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        inputStream = new StringBuilder();
        while (true) {
            Object readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new GetRequest(inputStream.toString());
            }
            inputStream.append(readLine);
            inputStream.append('\n');
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GetRequest{rangeOffset=");
        stringBuilder.append(this.f3726b);
        stringBuilder.append(", partial=");
        stringBuilder.append(this.f3727c);
        stringBuilder.append(", uri='");
        stringBuilder.append(this.f3725a);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
