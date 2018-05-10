package com.reddit.frontpage.commons.analytics.output;

import android.net.Uri;
import com.cookpad.puree.outputs.OutputConfiguration;
import com.cookpad.puree.outputs.PureeBufferedOutput;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon.Builder;
import com.reddit.frontpage.FrontpageApplication;

public class BufferedOutput extends PureeBufferedOutput {
    private static final Uri f33489d = Uri.parse("https://events.redditmedia.com/v1");
    private final Cannon f33490e;

    public final String m34442c() {
        return "out_events_v1";
    }

    public BufferedOutput() {
        FrontpageApplication frontpageApplication = FrontpageApplication.f27402a;
        Builder builder = new Builder(f33489d);
        builder.a = Config.b;
        this.f33490e = builder.a();
    }

    public final void m34441a(org.json.JSONArray r9, final com.cookpad.puree.async.AsyncResult r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r9 = r9.toString();
        if (r9 != 0) goto L_0x000a;
    L_0x0006:
        r10.a();
        return;
    L_0x000a:
        r0 = "S31lkhGaiHF7h4NgNROreE5/1GwY16/GbYLXF7/YTGU=";	 Catch:{ UnsupportedEncodingException -> 0x007c }
        r1 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x007c }
        r0 = r0.getBytes(r1);	 Catch:{ UnsupportedEncodingException -> 0x007c }
        r1 = 0;	 Catch:{ UnsupportedEncodingException -> 0x007c }
        r0 = android.util.Base64.decode(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x007c }
        r0 = com.reddit.frontpage.util.CryptoUtil.m23678a(r9, r0);
        r2 = new java.lang.Object[r1];
        timber.log.Timber.b(r9, r2);
        r2 = new com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r3 = r8.f33490e;	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r4 = java.lang.Object.class;	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r2.<init>(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r3 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r2 = r2.a(r3);	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r4 = com.android.volley.Request.Priority.a;	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r2 = r2.a(r4);	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r4 = "Content-Type";	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r5 = "application/json";	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r2 = r2.c(r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r4 = "X-Signature";	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r5 = "key=%s, mac=%s";	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r6 = 2;	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r7 = "RedditAppAndroid1";	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r6[r1] = r7;	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r6[r3] = r0;	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r0 = java.lang.String.format(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r0 = r2.c(r4, r0);	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r2 = "Date";	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r3 = new java.util.Date;	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r3.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r0 = r0.c(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r2 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r9 = r9.getBytes(r2);	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r9 = r0.a(r9);	 Catch:{ UnsupportedEncodingException -> 0x0073 }
        r0 = new com.reddit.frontpage.commons.analytics.output.BufferedOutput$1;
        r0.<init>(r8, r10);
        r9.a(r0);
        return;
    L_0x0073:
        r9 = move-exception;
        r10 = "Unable to emit event";
        r0 = new java.lang.Object[r1];
        timber.log.Timber.c(r9, r10, r0);
        return;
    L_0x007c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.commons.analytics.output.BufferedOutput.a(org.json.JSONArray, com.cookpad.puree.async.AsyncResult):void");
    }

    public final OutputConfiguration m34440a(OutputConfiguration outputConfiguration) {
        outputConfiguration.a = 60000;
        outputConfiguration.b = 50;
        outputConfiguration.c = 3;
        return outputConfiguration;
    }
}
