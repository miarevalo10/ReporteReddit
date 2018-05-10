package com.reddit.social.util;

import android.util.Base64;
import com.reddit.frontpage.FrontpageApplication;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.SendBird;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

public class ChatSerializer {
    public static void m24739a(java.lang.String r7, java.lang.String r8, java.util.List<com.sendbird.android.BaseMessage> r9) {
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
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00be }
        r1.<init>();	 Catch:{ Exception -> 0x00be }
        if (r8 == 0) goto L_0x00bd;	 Catch:{ Exception -> 0x00be }
    L_0x0008:
        r1.append(r8);	 Catch:{ Exception -> 0x00be }
        r2 = r0;	 Catch:{ Exception -> 0x00be }
    L_0x000c:
        r3 = r9.size();	 Catch:{ Exception -> 0x00be }
        r4 = 100;	 Catch:{ Exception -> 0x00be }
        r3 = java.lang.Math.min(r3, r4);	 Catch:{ Exception -> 0x00be }
        if (r2 >= r3) goto L_0x0032;	 Catch:{ Exception -> 0x00be }
    L_0x0018:
        r3 = r9.get(r2);	 Catch:{ Exception -> 0x00be }
        r3 = (com.sendbird.android.BaseMessage) r3;	 Catch:{ Exception -> 0x00be }
        r4 = 10;	 Catch:{ Exception -> 0x00be }
        r1.append(r4);	 Catch:{ Exception -> 0x00be }
        r3 = r3.m24877e();	 Catch:{ Exception -> 0x00be }
        r4 = 2;	 Catch:{ Exception -> 0x00be }
        r3 = android.util.Base64.encodeToString(r3, r4);	 Catch:{ Exception -> 0x00be }
        r1.append(r3);	 Catch:{ Exception -> 0x00be }
        r2 = r2 + 1;	 Catch:{ Exception -> 0x00be }
        goto L_0x000c;	 Catch:{ Exception -> 0x00be }
    L_0x0032:
        r9 = r1.toString();	 Catch:{ Exception -> 0x00be }
        r1 = com.reddit.social.util.FileUtils.m24771a(r9);	 Catch:{ Exception -> 0x00be }
        r2 = new java.io.File;	 Catch:{ Exception -> 0x00be }
        r3 = com.reddit.frontpage.FrontpageApplication.f27402a;	 Catch:{ Exception -> 0x00be }
        r3 = r3.getApplicationContext();	 Catch:{ Exception -> 0x00be }
        r3 = r3.getCacheDir();	 Catch:{ Exception -> 0x00be }
        r4 = com.sendbird.android.SendBird.m24986d();	 Catch:{ Exception -> 0x00be }
        r2.<init>(r3, r4);	 Catch:{ Exception -> 0x00be }
        r2.mkdirs();	 Catch:{ Exception -> 0x00be }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x00be }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00be }
        r4.<init>();	 Catch:{ Exception -> 0x00be }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00be }
        r5.<init>();	 Catch:{ Exception -> 0x00be }
        r5.append(r7);	 Catch:{ Exception -> 0x00be }
        r6 = "_";	 Catch:{ Exception -> 0x00be }
        r5.append(r6);	 Catch:{ Exception -> 0x00be }
        r5.append(r8);	 Catch:{ Exception -> 0x00be }
        r5 = r5.toString();	 Catch:{ Exception -> 0x00be }
        r5 = com.reddit.social.util.FileUtils.m24771a(r5);	 Catch:{ Exception -> 0x00be }
        r4.append(r5);	 Catch:{ Exception -> 0x00be }
        r5 = ".data";	 Catch:{ Exception -> 0x00be }
        r4.append(r5);	 Catch:{ Exception -> 0x00be }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00be }
        r3.<init>(r2, r4);	 Catch:{ Exception -> 0x00be }
        r4 = new java.io.File;	 Catch:{ Exception -> 0x00be }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00be }
        r5.<init>();	 Catch:{ Exception -> 0x00be }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00be }
        r6.<init>();	 Catch:{ Exception -> 0x00be }
        r6.append(r7);	 Catch:{ Exception -> 0x00be }
        r7 = "_";	 Catch:{ Exception -> 0x00be }
        r6.append(r7);	 Catch:{ Exception -> 0x00be }
        r6.append(r8);	 Catch:{ Exception -> 0x00be }
        r7 = r6.toString();	 Catch:{ Exception -> 0x00be }
        r7 = com.reddit.social.util.FileUtils.m24771a(r7);	 Catch:{ Exception -> 0x00be }
        r5.append(r7);	 Catch:{ Exception -> 0x00be }
        r7 = ".hash";	 Catch:{ Exception -> 0x00be }
        r5.append(r7);	 Catch:{ Exception -> 0x00be }
        r7 = r5.toString();	 Catch:{ Exception -> 0x00be }
        r4.<init>(r2, r7);	 Catch:{ Exception -> 0x00be }
        r7 = com.reddit.social.util.FileUtils.m24770a(r4);	 Catch:{ IOException -> 0x00b7 }
        r7 = r1.equals(r7);	 Catch:{ IOException -> 0x00b7 }
        if (r7 == 0) goto L_0x00b7;
    L_0x00b6:
        return;
    L_0x00b7:
        com.reddit.social.util.FileUtils.m24772a(r3, r9);	 Catch:{ Exception -> 0x00be }
        com.reddit.social.util.FileUtils.m24772a(r4, r1);	 Catch:{ Exception -> 0x00be }
    L_0x00bd:
        return;
    L_0x00be:
        r7 = move-exception;
        r7 = r7.getMessage();
        r8 = new java.lang.Object[r0];
        timber.log.Timber.e(r7, r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.social.util.ChatSerializer.a(java.lang.String, java.lang.String, java.util.List):void");
    }

    public static List<BaseMessage> m24738a(String str, String str2) {
        List<BaseMessage> arrayList = new ArrayList();
        try {
            File file = new File(FrontpageApplication.f27402a.getApplicationContext().getCacheDir(), SendBird.m24986d());
            file.mkdirs();
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
            stringBuilder2.append(str2);
            stringBuilder.append(FileUtils.m24771a(stringBuilder2.toString()));
            stringBuilder.append(".data");
            str = FileUtils.m24770a(new File(file, stringBuilder.toString())).split("\n");
            for (str2 = true; str2 < str.length; str2++) {
                arrayList.add(BaseMessage.m24875a(Base64.decode(str[str2], 2)));
            }
        } catch (String str3) {
            Timber.e(str3.getMessage(), new Object[null]);
        }
        return arrayList;
    }

    public static void m24740a(java.lang.String r7, java.util.List<com.sendbird.android.GroupChannel> r8, java.lang.String r9) {
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
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c5 }
        r1.<init>();	 Catch:{ Exception -> 0x00c5 }
        if (r8 == 0) goto L_0x00c4;	 Catch:{ Exception -> 0x00c5 }
    L_0x0008:
        r2 = r8.size();	 Catch:{ Exception -> 0x00c5 }
        if (r2 <= 0) goto L_0x00c4;	 Catch:{ Exception -> 0x00c5 }
    L_0x000e:
        r2 = r0;	 Catch:{ Exception -> 0x00c5 }
    L_0x000f:
        r3 = r8.size();	 Catch:{ Exception -> 0x00c5 }
        r4 = 100;	 Catch:{ Exception -> 0x00c5 }
        r3 = java.lang.Math.min(r3, r4);	 Catch:{ Exception -> 0x00c5 }
        if (r2 >= r3) goto L_0x0035;	 Catch:{ Exception -> 0x00c5 }
    L_0x001b:
        r3 = r8.get(r2);	 Catch:{ Exception -> 0x00c5 }
        r3 = (com.sendbird.android.GroupChannel) r3;	 Catch:{ Exception -> 0x00c5 }
        r4 = 10;	 Catch:{ Exception -> 0x00c5 }
        r1.append(r4);	 Catch:{ Exception -> 0x00c5 }
        r3 = r3.m24868b();	 Catch:{ Exception -> 0x00c5 }
        r4 = 2;	 Catch:{ Exception -> 0x00c5 }
        r3 = android.util.Base64.encodeToString(r3, r4);	 Catch:{ Exception -> 0x00c5 }
        r1.append(r3);	 Catch:{ Exception -> 0x00c5 }
        r2 = r2 + 1;	 Catch:{ Exception -> 0x00c5 }
        goto L_0x000f;	 Catch:{ Exception -> 0x00c5 }
    L_0x0035:
        r8 = 1;	 Catch:{ Exception -> 0x00c5 }
        r1.delete(r0, r8);	 Catch:{ Exception -> 0x00c5 }
        r8 = r1.toString();	 Catch:{ Exception -> 0x00c5 }
        r1 = com.reddit.social.util.FileUtils.m24771a(r8);	 Catch:{ Exception -> 0x00c5 }
        r2 = new java.io.File;	 Catch:{ Exception -> 0x00c5 }
        r3 = com.reddit.frontpage.FrontpageApplication.f27402a;	 Catch:{ Exception -> 0x00c5 }
        r3 = r3.getApplicationContext();	 Catch:{ Exception -> 0x00c5 }
        r3 = r3.getCacheDir();	 Catch:{ Exception -> 0x00c5 }
        r4 = com.sendbird.android.SendBird.m24986d();	 Catch:{ Exception -> 0x00c5 }
        r2.<init>(r3, r4);	 Catch:{ Exception -> 0x00c5 }
        r2.mkdirs();	 Catch:{ Exception -> 0x00c5 }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x00c5 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c5 }
        r4.<init>();	 Catch:{ Exception -> 0x00c5 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c5 }
        r5.<init>();	 Catch:{ Exception -> 0x00c5 }
        r5.append(r7);	 Catch:{ Exception -> 0x00c5 }
        r6 = "_channel_list_";	 Catch:{ Exception -> 0x00c5 }
        r5.append(r6);	 Catch:{ Exception -> 0x00c5 }
        r5.append(r9);	 Catch:{ Exception -> 0x00c5 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x00c5 }
        r5 = com.reddit.social.util.FileUtils.m24771a(r5);	 Catch:{ Exception -> 0x00c5 }
        r4.append(r5);	 Catch:{ Exception -> 0x00c5 }
        r5 = ".hash";	 Catch:{ Exception -> 0x00c5 }
        r4.append(r5);	 Catch:{ Exception -> 0x00c5 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00c5 }
        r3.<init>(r2, r4);	 Catch:{ Exception -> 0x00c5 }
        r4 = new java.io.File;	 Catch:{ Exception -> 0x00c5 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c5 }
        r5.<init>();	 Catch:{ Exception -> 0x00c5 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c5 }
        r6.<init>();	 Catch:{ Exception -> 0x00c5 }
        r6.append(r7);	 Catch:{ Exception -> 0x00c5 }
        r7 = "_channel_list_";	 Catch:{ Exception -> 0x00c5 }
        r6.append(r7);	 Catch:{ Exception -> 0x00c5 }
        r6.append(r9);	 Catch:{ Exception -> 0x00c5 }
        r7 = r6.toString();	 Catch:{ Exception -> 0x00c5 }
        r7 = com.reddit.social.util.FileUtils.m24771a(r7);	 Catch:{ Exception -> 0x00c5 }
        r5.append(r7);	 Catch:{ Exception -> 0x00c5 }
        r7 = ".data";	 Catch:{ Exception -> 0x00c5 }
        r5.append(r7);	 Catch:{ Exception -> 0x00c5 }
        r7 = r5.toString();	 Catch:{ Exception -> 0x00c5 }
        r4.<init>(r2, r7);	 Catch:{ Exception -> 0x00c5 }
        r7 = com.reddit.social.util.FileUtils.m24770a(r3);	 Catch:{ IOException -> 0x00be }
        r7 = r1.equals(r7);	 Catch:{ IOException -> 0x00be }
        if (r7 == 0) goto L_0x00be;
    L_0x00bd:
        return;
    L_0x00be:
        com.reddit.social.util.FileUtils.m24772a(r4, r8);	 Catch:{ Exception -> 0x00c5 }
        com.reddit.social.util.FileUtils.m24772a(r3, r1);	 Catch:{ Exception -> 0x00c5 }
    L_0x00c4:
        return;
    L_0x00c5:
        r7 = move-exception;
        r7 = r7.getMessage();
        r8 = new java.lang.Object[r0];
        timber.log.Timber.e(r7, r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.social.util.ChatSerializer.a(java.lang.String, java.util.List, java.lang.String):void");
    }

    public static List<GroupChannel> m24741b(String str, String str2) {
        List<GroupChannel> arrayList = new ArrayList();
        try {
            File file = new File(FrontpageApplication.f27402a.getApplicationContext().getCacheDir(), SendBird.m24986d());
            file.mkdirs();
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("_channel_list_");
            stringBuilder2.append(str2);
            stringBuilder.append(FileUtils.m24771a(stringBuilder2.toString()));
            stringBuilder.append(".data");
            str = FileUtils.m24770a(new File(file, stringBuilder.toString())).split("\n");
            for (String decode : str) {
                arrayList.add((GroupChannel) BaseChannel.m24862a(Base64.decode(decode, 2)));
            }
        } catch (String str3) {
            Timber.e(str3.getMessage(), new Object[0]);
        }
        return arrayList;
    }
}
