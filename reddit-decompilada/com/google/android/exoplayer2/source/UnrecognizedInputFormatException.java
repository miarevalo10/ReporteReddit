package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;

public class UnrecognizedInputFormatException extends ParserException {
    public final Uri f13299a;

    public UnrecognizedInputFormatException(String str, Uri uri) {
        super(str);
        this.f13299a = uri;
    }
}
