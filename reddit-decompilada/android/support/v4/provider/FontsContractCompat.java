package android.support.v4.provider;

import android.content.Context;
import android.content.pm.Signature;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.ResourcesCompat.FontCallback;
import android.support.v4.graphics.TypefaceCompatUtil;
import android.support.v4.provider.SelfDestructiveThread.ReplyCallback;
import android.support.v4.util.LruCache;
import android.support.v4.util.Preconditions;
import android.support.v4.util.SimpleArrayMap;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FontsContractCompat {
    private static final LruCache<String, Typeface> f1339a = new LruCache(16);
    private static final SelfDestructiveThread f1340b = new SelfDestructiveThread("fonts");
    private static final Object f1341c = new Object();
    private static final SimpleArrayMap<String, ArrayList<ReplyCallback<TypefaceResult>>> f1342d = new SimpleArrayMap();
    private static final Comparator<byte[]> f1343e = new C01195();

    static class C01195 implements Comparator<byte[]> {
        C01195() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = (byte[]) obj2;
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }
    }

    public static class FontFamilyResult {
        final int f1330a;
        final FontInfo[] f1331b;

        public FontFamilyResult(int i, FontInfo[] fontInfoArr) {
            this.f1330a = i;
            this.f1331b = fontInfoArr;
        }
    }

    public static class FontInfo {
        public final Uri f1332a;
        public final int f1333b;
        public final int f1334c;
        public final boolean f1335d;
        final int f1336e;

        public FontInfo(Uri uri, int i, int i2, boolean z, int i3) {
            this.f1332a = (Uri) Preconditions.m1042a((Object) uri);
            this.f1333b = i;
            this.f1334c = i2;
            this.f1335d = z;
            this.f1336e = i3;
        }
    }

    private static final class TypefaceResult {
        final Typeface f1337a;
        final int f1338b;

        TypefaceResult(Typeface typeface, int i) {
            this.f1337a = typeface;
            this.f1338b = i;
        }
    }

    static class C10042 implements ReplyCallback<TypefaceResult> {
        final /* synthetic */ FontCallback f11435a;
        final /* synthetic */ Handler f11436b = null;

        C10042(FontCallback fontCallback, Handler handler) {
            this.f11435a = fontCallback;
        }

        public final /* bridge */ /* synthetic */ void mo350a(Object obj) {
            TypefaceResult typefaceResult = (TypefaceResult) obj;
            if (typefaceResult.f1338b == 0) {
                this.f11435a.m769a(typefaceResult.f1337a, this.f11436b);
            } else {
                this.f11435a.m767a(typefaceResult.f1338b, this.f11436b);
            }
        }
    }

    private static android.support.v4.provider.FontsContractCompat.FontInfo[] m982a(android.content.Context r21, android.support.v4.provider.FontRequest r22, java.lang.String r23) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0113 in list [B:8:0x008e]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r1 = r23;
        r2 = new java.util.ArrayList;
        r2.<init>();
        r3 = new android.net.Uri$Builder;
        r3.<init>();
        r4 = "content";
        r3 = r3.scheme(r4);
        r3 = r3.authority(r1);
        r3 = r3.build();
        r4 = new android.net.Uri$Builder;
        r4.<init>();
        r5 = "content";
        r4 = r4.scheme(r5);
        r1 = r4.authority(r1);
        r4 = "file";
        r1 = r1.appendPath(r4);
        r1 = r1.build();
        r11 = 0;
        r4 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0121 }
        r5 = 16;	 Catch:{ all -> 0x0121 }
        r12 = 1;	 Catch:{ all -> 0x0121 }
        r13 = 0;	 Catch:{ all -> 0x0121 }
        if (r4 <= r5) goto L_0x0065;	 Catch:{ all -> 0x0121 }
    L_0x003c:
        r4 = r21.getContentResolver();	 Catch:{ all -> 0x0121 }
        r14 = "_id";	 Catch:{ all -> 0x0121 }
        r15 = "file_id";	 Catch:{ all -> 0x0121 }
        r16 = "font_ttc_index";	 Catch:{ all -> 0x0121 }
        r17 = "font_variation_settings";	 Catch:{ all -> 0x0121 }
        r18 = "font_weight";	 Catch:{ all -> 0x0121 }
        r19 = "font_italic";	 Catch:{ all -> 0x0121 }
        r20 = "result_code";	 Catch:{ all -> 0x0121 }
        r6 = new java.lang.String[]{r14, r15, r16, r17, r18, r19, r20};	 Catch:{ all -> 0x0121 }
        r7 = "query = ?";	 Catch:{ all -> 0x0121 }
        r8 = new java.lang.String[r12];	 Catch:{ all -> 0x0121 }
        r5 = r22.getQuery();	 Catch:{ all -> 0x0121 }
        r8[r13] = r5;	 Catch:{ all -> 0x0121 }
        r9 = 0;	 Catch:{ all -> 0x0121 }
        r10 = 0;	 Catch:{ all -> 0x0121 }
        r5 = r3;	 Catch:{ all -> 0x0121 }
        r4 = r4.query(r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x0121 }
    L_0x0063:
        r11 = r4;	 Catch:{ all -> 0x0121 }
        goto L_0x008c;	 Catch:{ all -> 0x0121 }
    L_0x0065:
        r4 = r21.getContentResolver();	 Catch:{ all -> 0x0121 }
        r14 = "_id";	 Catch:{ all -> 0x0121 }
        r15 = "file_id";	 Catch:{ all -> 0x0121 }
        r16 = "font_ttc_index";	 Catch:{ all -> 0x0121 }
        r17 = "font_variation_settings";	 Catch:{ all -> 0x0121 }
        r18 = "font_weight";	 Catch:{ all -> 0x0121 }
        r19 = "font_italic";	 Catch:{ all -> 0x0121 }
        r20 = "result_code";	 Catch:{ all -> 0x0121 }
        r6 = new java.lang.String[]{r14, r15, r16, r17, r18, r19, r20};	 Catch:{ all -> 0x0121 }
        r7 = "query = ?";	 Catch:{ all -> 0x0121 }
        r8 = new java.lang.String[r12];	 Catch:{ all -> 0x0121 }
        r5 = r22.getQuery();	 Catch:{ all -> 0x0121 }
        r8[r13] = r5;	 Catch:{ all -> 0x0121 }
        r9 = 0;	 Catch:{ all -> 0x0121 }
        r5 = r3;	 Catch:{ all -> 0x0121 }
        r4 = r4.query(r5, r6, r7, r8, r9);	 Catch:{ all -> 0x0121 }
        goto L_0x0063;	 Catch:{ all -> 0x0121 }
    L_0x008c:
        if (r11 == 0) goto L_0x0113;	 Catch:{ all -> 0x0121 }
    L_0x008e:
        r4 = r11.getCount();	 Catch:{ all -> 0x0121 }
        if (r4 <= 0) goto L_0x0113;	 Catch:{ all -> 0x0121 }
    L_0x0094:
        r2 = "result_code";	 Catch:{ all -> 0x0121 }
        r2 = r11.getColumnIndex(r2);	 Catch:{ all -> 0x0121 }
        r4 = new java.util.ArrayList;	 Catch:{ all -> 0x0121 }
        r4.<init>();	 Catch:{ all -> 0x0121 }
        r5 = "_id";	 Catch:{ all -> 0x0121 }
        r5 = r11.getColumnIndex(r5);	 Catch:{ all -> 0x0121 }
        r6 = "file_id";	 Catch:{ all -> 0x0121 }
        r6 = r11.getColumnIndex(r6);	 Catch:{ all -> 0x0121 }
        r7 = "font_ttc_index";	 Catch:{ all -> 0x0121 }
        r7 = r11.getColumnIndex(r7);	 Catch:{ all -> 0x0121 }
        r8 = "font_weight";	 Catch:{ all -> 0x0121 }
        r8 = r11.getColumnIndex(r8);	 Catch:{ all -> 0x0121 }
        r9 = "font_italic";	 Catch:{ all -> 0x0121 }
        r9 = r11.getColumnIndex(r9);	 Catch:{ all -> 0x0121 }
    L_0x00bd:
        r10 = r11.moveToNext();	 Catch:{ all -> 0x0121 }
        if (r10 == 0) goto L_0x0112;	 Catch:{ all -> 0x0121 }
    L_0x00c3:
        r10 = -1;	 Catch:{ all -> 0x0121 }
        if (r2 == r10) goto L_0x00cd;	 Catch:{ all -> 0x0121 }
    L_0x00c6:
        r14 = r11.getInt(r2);	 Catch:{ all -> 0x0121 }
        r20 = r14;	 Catch:{ all -> 0x0121 }
        goto L_0x00cf;	 Catch:{ all -> 0x0121 }
    L_0x00cd:
        r20 = r13;	 Catch:{ all -> 0x0121 }
    L_0x00cf:
        if (r7 == r10) goto L_0x00d8;	 Catch:{ all -> 0x0121 }
    L_0x00d1:
        r14 = r11.getInt(r7);	 Catch:{ all -> 0x0121 }
        r17 = r14;	 Catch:{ all -> 0x0121 }
        goto L_0x00da;	 Catch:{ all -> 0x0121 }
    L_0x00d8:
        r17 = r13;	 Catch:{ all -> 0x0121 }
    L_0x00da:
        if (r6 != r10) goto L_0x00e7;	 Catch:{ all -> 0x0121 }
    L_0x00dc:
        r14 = r11.getLong(r5);	 Catch:{ all -> 0x0121 }
        r14 = android.content.ContentUris.withAppendedId(r3, r14);	 Catch:{ all -> 0x0121 }
    L_0x00e4:
        r16 = r14;	 Catch:{ all -> 0x0121 }
        goto L_0x00f0;	 Catch:{ all -> 0x0121 }
    L_0x00e7:
        r14 = r11.getLong(r6);	 Catch:{ all -> 0x0121 }
        r14 = android.content.ContentUris.withAppendedId(r1, r14);	 Catch:{ all -> 0x0121 }
        goto L_0x00e4;	 Catch:{ all -> 0x0121 }
    L_0x00f0:
        if (r8 == r10) goto L_0x00f7;	 Catch:{ all -> 0x0121 }
    L_0x00f2:
        r14 = r11.getInt(r8);	 Catch:{ all -> 0x0121 }
        goto L_0x00f9;	 Catch:{ all -> 0x0121 }
    L_0x00f7:
        r14 = 400; // 0x190 float:5.6E-43 double:1.976E-321;	 Catch:{ all -> 0x0121 }
    L_0x00f9:
        r18 = r14;	 Catch:{ all -> 0x0121 }
        if (r9 == r10) goto L_0x0106;	 Catch:{ all -> 0x0121 }
    L_0x00fd:
        r10 = r11.getInt(r9);	 Catch:{ all -> 0x0121 }
        if (r10 != r12) goto L_0x0106;	 Catch:{ all -> 0x0121 }
    L_0x0103:
        r19 = r12;	 Catch:{ all -> 0x0121 }
        goto L_0x0108;	 Catch:{ all -> 0x0121 }
    L_0x0106:
        r19 = r13;	 Catch:{ all -> 0x0121 }
    L_0x0108:
        r10 = new android.support.v4.provider.FontsContractCompat$FontInfo;	 Catch:{ all -> 0x0121 }
        r15 = r10;	 Catch:{ all -> 0x0121 }
        r15.<init>(r16, r17, r18, r19, r20);	 Catch:{ all -> 0x0121 }
        r4.add(r10);	 Catch:{ all -> 0x0121 }
        goto L_0x00bd;
    L_0x0112:
        r2 = r4;
    L_0x0113:
        if (r11 == 0) goto L_0x0118;
    L_0x0115:
        r11.close();
    L_0x0118:
        r1 = new android.support.v4.provider.FontsContractCompat.FontInfo[r13];
        r1 = r2.toArray(r1);
        r1 = (android.support.v4.provider.FontsContractCompat.FontInfo[]) r1;
        return r1;
    L_0x0121:
        r0 = move-exception;
        r1 = r0;
        if (r11 == 0) goto L_0x0128;
    L_0x0125:
        r11.close();
    L_0x0128:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.FontsContractCompat.a(android.content.Context, android.support.v4.provider.FontRequest, java.lang.String):android.support.v4.provider.FontsContractCompat$FontInfo[]");
    }

    public static android.graphics.Typeface m976a(final android.content.Context r3, final android.support.v4.provider.FontRequest r4, android.support.v4.content.res.ResourcesCompat.FontCallback r5, boolean r6, int r7, final int r8) {
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
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r4.getIdentifier();
        r0.append(r1);
        r1 = "-";
        r0.append(r1);
        r0.append(r8);
        r0 = r0.toString();
        r1 = f1339a;
        r1 = r1.get(r0);
        r1 = (android.graphics.Typeface) r1;
        if (r1 == 0) goto L_0x0028;
    L_0x0022:
        if (r5 == 0) goto L_0x0027;
    L_0x0024:
        r5.mo589a(r1);
    L_0x0027:
        return r1;
    L_0x0028:
        r1 = 0;
        if (r6 == 0) goto L_0x0046;
    L_0x002b:
        r2 = -1;
        if (r7 != r2) goto L_0x0046;
    L_0x002e:
        r3 = m983b(r3, r4, r8);
        if (r5 == 0) goto L_0x0043;
    L_0x0034:
        r4 = r3.f1338b;
        if (r4 != 0) goto L_0x003e;
    L_0x0038:
        r4 = r3.f1337a;
        r5.m769a(r4, r1);
        goto L_0x0043;
    L_0x003e:
        r4 = r3.f1338b;
        r5.m767a(r4, r1);
    L_0x0043:
        r3 = r3.f1337a;
        return r3;
    L_0x0046:
        r2 = new android.support.v4.provider.FontsContractCompat$1;
        r2.<init>(r3, r4, r8, r0);
        if (r6 == 0) goto L_0x0059;
    L_0x004d:
        r3 = f1340b;	 Catch:{ InterruptedException -> 0x0058 }
        r3 = r3.m989a(r2, r7);	 Catch:{ InterruptedException -> 0x0058 }
        r3 = (android.support.v4.provider.FontsContractCompat.TypefaceResult) r3;	 Catch:{ InterruptedException -> 0x0058 }
        r3 = r3.f1337a;	 Catch:{ InterruptedException -> 0x0058 }
        return r3;
    L_0x0058:
        return r1;
    L_0x0059:
        if (r5 != 0) goto L_0x005d;
    L_0x005b:
        r3 = r1;
        goto L_0x0062;
    L_0x005d:
        r3 = new android.support.v4.provider.FontsContractCompat$2;
        r3.<init>(r5, r1);
    L_0x0062:
        r4 = f1341c;
        monitor-enter(r4);
        r5 = f1342d;	 Catch:{ all -> 0x00a1 }
        r5 = r5.containsKey(r0);	 Catch:{ all -> 0x00a1 }
        if (r5 == 0) goto L_0x007c;	 Catch:{ all -> 0x00a1 }
    L_0x006d:
        if (r3 == 0) goto L_0x007a;	 Catch:{ all -> 0x00a1 }
    L_0x006f:
        r5 = f1342d;	 Catch:{ all -> 0x00a1 }
        r5 = r5.get(r0);	 Catch:{ all -> 0x00a1 }
        r5 = (java.util.ArrayList) r5;	 Catch:{ all -> 0x00a1 }
        r5.add(r3);	 Catch:{ all -> 0x00a1 }
    L_0x007a:
        monitor-exit(r4);	 Catch:{ all -> 0x00a1 }
        return r1;	 Catch:{ all -> 0x00a1 }
    L_0x007c:
        if (r3 == 0) goto L_0x008b;	 Catch:{ all -> 0x00a1 }
    L_0x007e:
        r5 = new java.util.ArrayList;	 Catch:{ all -> 0x00a1 }
        r5.<init>();	 Catch:{ all -> 0x00a1 }
        r5.add(r3);	 Catch:{ all -> 0x00a1 }
        r3 = f1342d;	 Catch:{ all -> 0x00a1 }
        r3.put(r0, r5);	 Catch:{ all -> 0x00a1 }
    L_0x008b:
        monitor-exit(r4);	 Catch:{ all -> 0x00a1 }
        r3 = f1340b;
        r4 = new android.support.v4.provider.FontsContractCompat$3;
        r4.<init>(r0);
        r5 = new android.os.Handler;
        r5.<init>();
        r6 = new android.support.v4.provider.SelfDestructiveThread$2;
        r6.<init>(r3, r2, r5, r4);
        r3.m990a(r6);
        return r1;
    L_0x00a1:
        r3 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00a1 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.FontsContractCompat.a(android.content.Context, android.support.v4.provider.FontRequest, android.support.v4.content.res.ResourcesCompat$FontCallback, boolean, int, int):android.graphics.Typeface");
    }

    @RequiresApi(19)
    public static Map<Uri, ByteBuffer> m980a(Context context, FontInfo[] fontInfoArr) {
        Map hashMap = new HashMap();
        for (FontInfo fontInfo : fontInfoArr) {
            if (fontInfo.f1336e == 0) {
                Uri uri = fontInfo.f1332a;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, TypefaceCompatUtil.m824a(context, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private static boolean m981a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> m979a(Signature[] signatureArr) {
        List<byte[]> arrayList = new ArrayList();
        for (Signature toByteArray : signatureArr) {
            arrayList.add(toByteArray.toByteArray());
        }
        return arrayList;
    }

    private static android.support.v4.provider.FontsContractCompat.TypefaceResult m983b(android.content.Context r8, android.support.v4.provider.FontRequest r9, int r10) {
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
        r0 = 0;
        r1 = r8.getPackageManager();	 Catch:{ NameNotFoundException -> 0x00d0 }
        r2 = r8.getResources();	 Catch:{ NameNotFoundException -> 0x00d0 }
        r3 = r9.getProviderAuthority();	 Catch:{ NameNotFoundException -> 0x00d0 }
        r4 = 0;	 Catch:{ NameNotFoundException -> 0x00d0 }
        r5 = r1.resolveContentProvider(r3, r4);	 Catch:{ NameNotFoundException -> 0x00d0 }
        if (r5 != 0) goto L_0x0028;	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x0014:
        r8 = new android.content.pm.PackageManager$NameNotFoundException;	 Catch:{ NameNotFoundException -> 0x00d0 }
        r9 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x00d0 }
        r10 = "No package found for authority: ";	 Catch:{ NameNotFoundException -> 0x00d0 }
        r9.<init>(r10);	 Catch:{ NameNotFoundException -> 0x00d0 }
        r9.append(r3);	 Catch:{ NameNotFoundException -> 0x00d0 }
        r9 = r9.toString();	 Catch:{ NameNotFoundException -> 0x00d0 }
        r8.<init>(r9);	 Catch:{ NameNotFoundException -> 0x00d0 }
        throw r8;	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x0028:
        r6 = r5.packageName;	 Catch:{ NameNotFoundException -> 0x00d0 }
        r7 = r9.getProviderPackage();	 Catch:{ NameNotFoundException -> 0x00d0 }
        r6 = r6.equals(r7);	 Catch:{ NameNotFoundException -> 0x00d0 }
        if (r6 != 0) goto L_0x0054;	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x0034:
        r8 = new android.content.pm.PackageManager$NameNotFoundException;	 Catch:{ NameNotFoundException -> 0x00d0 }
        r10 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x00d0 }
        r1 = "Found content provider ";	 Catch:{ NameNotFoundException -> 0x00d0 }
        r10.<init>(r1);	 Catch:{ NameNotFoundException -> 0x00d0 }
        r10.append(r3);	 Catch:{ NameNotFoundException -> 0x00d0 }
        r1 = ", but package was not ";	 Catch:{ NameNotFoundException -> 0x00d0 }
        r10.append(r1);	 Catch:{ NameNotFoundException -> 0x00d0 }
        r9 = r9.getProviderPackage();	 Catch:{ NameNotFoundException -> 0x00d0 }
        r10.append(r9);	 Catch:{ NameNotFoundException -> 0x00d0 }
        r9 = r10.toString();	 Catch:{ NameNotFoundException -> 0x00d0 }
        r8.<init>(r9);	 Catch:{ NameNotFoundException -> 0x00d0 }
        throw r8;	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x0054:
        r3 = r5.packageName;	 Catch:{ NameNotFoundException -> 0x00d0 }
        r6 = 64;	 Catch:{ NameNotFoundException -> 0x00d0 }
        r1 = r1.getPackageInfo(r3, r6);	 Catch:{ NameNotFoundException -> 0x00d0 }
        r1 = r1.signatures;	 Catch:{ NameNotFoundException -> 0x00d0 }
        r1 = m979a(r1);	 Catch:{ NameNotFoundException -> 0x00d0 }
        r3 = f1343e;	 Catch:{ NameNotFoundException -> 0x00d0 }
        java.util.Collections.sort(r1, r3);	 Catch:{ NameNotFoundException -> 0x00d0 }
        r3 = r9.getCertificates();	 Catch:{ NameNotFoundException -> 0x00d0 }
        if (r3 == 0) goto L_0x0072;	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x006d:
        r2 = r9.getCertificates();	 Catch:{ NameNotFoundException -> 0x00d0 }
        goto L_0x007a;	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x0072:
        r3 = r9.getCertificatesArrayResId();	 Catch:{ NameNotFoundException -> 0x00d0 }
        r2 = android.support.v4.content.res.FontResourcesParserCompat.m762a(r2, r3);	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x007a:
        r3 = r4;	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x007b:
        r6 = r2.size();	 Catch:{ NameNotFoundException -> 0x00d0 }
        if (r3 >= r6) goto L_0x009b;	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x0081:
        r6 = new java.util.ArrayList;	 Catch:{ NameNotFoundException -> 0x00d0 }
        r7 = r2.get(r3);	 Catch:{ NameNotFoundException -> 0x00d0 }
        r7 = (java.util.Collection) r7;	 Catch:{ NameNotFoundException -> 0x00d0 }
        r6.<init>(r7);	 Catch:{ NameNotFoundException -> 0x00d0 }
        r7 = f1343e;	 Catch:{ NameNotFoundException -> 0x00d0 }
        java.util.Collections.sort(r6, r7);	 Catch:{ NameNotFoundException -> 0x00d0 }
        r6 = m981a(r1, r6);	 Catch:{ NameNotFoundException -> 0x00d0 }
        if (r6 == 0) goto L_0x0098;	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x0097:
        goto L_0x009c;	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x0098:
        r3 = r3 + 1;	 Catch:{ NameNotFoundException -> 0x00d0 }
        goto L_0x007b;	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x009b:
        r5 = r0;	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x009c:
        r1 = 1;	 Catch:{ NameNotFoundException -> 0x00d0 }
        if (r5 != 0) goto L_0x00a5;	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x009f:
        r9 = new android.support.v4.provider.FontsContractCompat$FontFamilyResult;	 Catch:{ NameNotFoundException -> 0x00d0 }
        r9.<init>(r1, r0);	 Catch:{ NameNotFoundException -> 0x00d0 }
        goto L_0x00b1;	 Catch:{ NameNotFoundException -> 0x00d0 }
    L_0x00a5:
        r2 = r5.authority;	 Catch:{ NameNotFoundException -> 0x00d0 }
        r9 = m982a(r8, r9, r2);	 Catch:{ NameNotFoundException -> 0x00d0 }
        r2 = new android.support.v4.provider.FontsContractCompat$FontFamilyResult;	 Catch:{ NameNotFoundException -> 0x00d0 }
        r2.<init>(r4, r9);	 Catch:{ NameNotFoundException -> 0x00d0 }
        r9 = r2;
    L_0x00b1:
        r2 = r9.f1330a;
        r3 = -3;
        if (r2 != 0) goto L_0x00c5;
    L_0x00b6:
        r9 = r9.f1331b;
        r8 = android.support.v4.graphics.TypefaceCompat.m817a(r8, r9, r10);
        r9 = new android.support.v4.provider.FontsContractCompat$TypefaceResult;
        if (r8 == 0) goto L_0x00c1;
    L_0x00c0:
        r3 = r4;
    L_0x00c1:
        r9.<init>(r8, r3);
        return r9;
    L_0x00c5:
        r8 = r9.f1330a;
        if (r8 != r1) goto L_0x00ca;
    L_0x00c9:
        r3 = -2;
    L_0x00ca:
        r8 = new android.support.v4.provider.FontsContractCompat$TypefaceResult;
        r8.<init>(r0, r3);
        return r8;
    L_0x00d0:
        r8 = new android.support.v4.provider.FontsContractCompat$TypefaceResult;
        r9 = -1;
        r8.<init>(r0, r9);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.FontsContractCompat.b(android.content.Context, android.support.v4.provider.FontRequest, int):android.support.v4.provider.FontsContractCompat$TypefaceResult");
    }
}
