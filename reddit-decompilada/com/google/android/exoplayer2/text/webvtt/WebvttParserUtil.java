package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttParserUtil {
    private static final Pattern f5121a = Pattern.compile("^NOTE(( |\t).*)?$");
    private static final Pattern f5122b = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");

    public static void m4115a(ParsableByteArray parsableByteArray) throws SubtitleDecoderException {
        parsableByteArray = parsableByteArray.m4267r();
        if (parsableByteArray != null) {
            if (f5122b.matcher(parsableByteArray).matches()) {
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Expected WEBVTT. Got ");
        stringBuilder.append(parsableByteArray);
        throw new SubtitleDecoderException(stringBuilder.toString());
    }

    public static long m4114a(String str) throws NumberFormatException {
        str = str.split("\\.", 2);
        int i = 0;
        String[] split = str[0].split(":");
        long j = 0;
        while (i < split.length) {
            j = (j * 60) + Long.parseLong(split[i]);
            i++;
        }
        return ((j * 1000) + Long.parseLong(str[1])) * 1000;
    }

    public static float m4116b(String str) throws NumberFormatException {
        if (str.endsWith(Operation.MOD)) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static Matcher m4117b(ParsableByteArray parsableByteArray) {
        while (true) {
            CharSequence r = parsableByteArray.m4267r();
            if (r == null) {
                return null;
            }
            if (f5121a.matcher(r).matches()) {
                while (true) {
                    String r2 = parsableByteArray.m4267r();
                    if (r2 == null || r2.isEmpty()) {
                        break;
                    }
                }
            } else {
                Matcher matcher = WebvttCueParser.f5118a.matcher(r);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }
}
