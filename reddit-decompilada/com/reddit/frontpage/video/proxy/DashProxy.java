package com.reddit.frontpage.video.proxy;

import com.instabug.library.model.NetworkLog;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.video.mpdparser.core.external.SimpleManifestLocalizer;
import com.reddit.frontpage.video.mpdparser.core.mapper.LocalUrlMPDMapper;
import com.reddit.frontpage.video.mpdparser.core.parser.ExoPlayerManifestParser;
import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.OkHttpClient;
import timber.log.Timber;

public class DashProxy extends NanoHTTPD {
    private static final Object f29438d = new Object();
    private static DashProxy f29439e;
    private static boolean f29440f;
    @Inject
    @Named("default")
    OkHttpClient f29441a;
    private final AtomicInteger f29442g = new AtomicInteger();
    private final SimpleManifestLocalizer f29443h = new SimpleManifestLocalizer(new ExoPlayerManifestParser(), new LocalUrlMPDMapper());
    private Hashtable<String, Integer> f29444i = new Hashtable();
    private Hashtable<Integer, String> f29445j = new Hashtable();
    private Hashtable<Integer, String> f29446k = new Hashtable();

    private DashProxy() {
        super("localhost");
        FrontpageApplication.m28870f().mo4699a(this);
        try {
            m26064a();
            f29440f = true;
        } catch (Throwable e) {
            Timber.c(e, "IOException on initialization", new Object[0]);
        } catch (Throwable e2) {
            Timber.c(e2, "Exception on initialization", new Object[0]);
        }
    }

    private String m30476c(String str) {
        Integer num;
        synchronized (f29438d) {
            if (this.f29444i.containsKey(str)) {
                num = (Integer) this.f29444i.get(str);
            } else {
                num = Integer.valueOf(this.f29442g.incrementAndGet());
                this.f29444i.put(str, num);
                this.f29445j.put(num, str);
            }
        }
        str = new StringBuilder("http://localhost:");
        str.append(this.f24429b == null ? -1 : this.f24429b.getLocalPort());
        str.append("/dashvideo-");
        str.append(num.toString());
        return str.toString();
    }

    private static int m30477d(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = "/dashvideo-(\\d+)";
        r0 = java.util.regex.Pattern.compile(r0);
        r2 = r0.matcher(r2);
        r0 = r2.matches();
        r1 = -1;
        if (r0 == 0) goto L_0x001f;
    L_0x0011:
        r0 = 1;
        r2 = r2.group(r0);
        if (r2 != 0) goto L_0x0019;
    L_0x0018:
        return r1;
    L_0x0019:
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x001e }
        return r2;
    L_0x001e:
        return r1;
    L_0x001f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.video.proxy.DashProxy.d(java.lang.String):int");
    }

    public final fi.iki.elonen.NanoHTTPD.Response mo5053a(fi.iki.elonen.NanoHTTPD.IHTTPSession r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r5 = r5.mo5538e();	 Catch:{ Exception -> 0x008a }
        r5 = m30477d(r5);	 Catch:{ Exception -> 0x008a }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x008a }
        r0 = r5.intValue();	 Catch:{ Exception -> 0x008a }
        r1 = -1;	 Catch:{ Exception -> 0x008a }
        if (r0 == r1) goto L_0x0085;	 Catch:{ Exception -> 0x008a }
    L_0x0013:
        r0 = r4.f29445j;	 Catch:{ Exception -> 0x008a }
        r0 = r0.containsKey(r5);	 Catch:{ Exception -> 0x008a }
        if (r0 != 0) goto L_0x001c;	 Catch:{ Exception -> 0x008a }
    L_0x001b:
        goto L_0x0085;	 Catch:{ Exception -> 0x008a }
    L_0x001c:
        r0 = r4.f29445j;	 Catch:{ Exception -> 0x008a }
        r0 = r0.get(r5);	 Catch:{ Exception -> 0x008a }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x008a }
        r1 = r4.f29446k;	 Catch:{ Exception -> 0x008a }
        r1 = r1.containsKey(r5);	 Catch:{ Exception -> 0x008a }
        if (r1 != 0) goto L_0x0067;	 Catch:{ Exception -> 0x008a }
    L_0x002c:
        r1 = new okhttp3.Request$Builder;	 Catch:{ Exception -> 0x008a }
        r1.<init>();	 Catch:{ Exception -> 0x008a }
        r1 = r1.url(r0);	 Catch:{ Exception -> 0x008a }
        r1 = r1.build();	 Catch:{ Exception -> 0x008a }
        r2 = r4.f29441a;	 Catch:{ IOException -> 0x0062 }
        r1 = r2.newCall(r1);	 Catch:{ IOException -> 0x0062 }
        r1 = r1.execute();	 Catch:{ IOException -> 0x0062 }
        r2 = r4.f29443h;	 Catch:{ IOException -> 0x0062 }
        r0 = android.net.Uri.parse(r0);	 Catch:{ IOException -> 0x0062 }
        r3 = r1.body();	 Catch:{ IOException -> 0x0062 }
        r3 = r3.byteStream();	 Catch:{ IOException -> 0x0062 }
        r0 = r2.m24115a(r0, r3);	 Catch:{ IOException -> 0x0062 }
        r1 = r1.body();	 Catch:{ IOException -> 0x0062 }
        r1.close();	 Catch:{ IOException -> 0x0062 }
        r1 = r4.f29446k;	 Catch:{ IOException -> 0x0062 }
        r1.put(r5, r0);	 Catch:{ IOException -> 0x0062 }
        goto L_0x0067;
    L_0x0062:
        r5 = m30478f();	 Catch:{ Exception -> 0x008a }
        return r5;	 Catch:{ Exception -> 0x008a }
    L_0x0067:
        r0 = r4.f29446k;	 Catch:{ Exception -> 0x008a }
        r0 = r0.containsKey(r5);	 Catch:{ Exception -> 0x008a }
        if (r0 != 0) goto L_0x0074;	 Catch:{ Exception -> 0x008a }
    L_0x006f:
        r5 = m30478f();	 Catch:{ Exception -> 0x008a }
        return r5;	 Catch:{ Exception -> 0x008a }
    L_0x0074:
        r0 = r4.f29446k;	 Catch:{ Exception -> 0x008a }
        r5 = r0.get(r5);	 Catch:{ Exception -> 0x008a }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x008a }
        r0 = fi.iki.elonen.NanoHTTPD.Response.Status.OK;	 Catch:{ Exception -> 0x008a }
        r1 = "text/html";	 Catch:{ Exception -> 0x008a }
        r5 = fi.iki.elonen.NanoHTTPD.m26051a(r0, r1, r5);	 Catch:{ Exception -> 0x008a }
        return r5;	 Catch:{ Exception -> 0x008a }
    L_0x0085:
        r5 = m30478f();	 Catch:{ Exception -> 0x008a }
        return r5;
    L_0x008a:
        r5 = m30478f();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.video.proxy.DashProxy.a(fi.iki.elonen.NanoHTTPD$IHTTPSession):fi.iki.elonen.NanoHTTPD$Response");
    }

    private static Response m30478f() {
        return NanoHTTPD.m26051a(Status.BAD_REQUEST, NetworkLog.HTML, "<html><head></head><body>Error</body></html>");
    }

    public static String m30475a(String str) {
        synchronized (f29438d) {
            if (f29439e == null) {
                f29439e = new DashProxy();
            }
        }
        return f29440f ? f29439e.m30476c(str) : str;
    }
}
