package com.reddit.frontpage.ui.sorting;

import android.support.v4.app.DialogFragment;
import android.view.View;

public class SnoomojiPreviewDialog extends DialogFragment {
    final OnSendListener f37384j;
    final String f37385k;
    private View f37386l;
    private final Integer f37387m;

    public interface OnSendListener {
        void mo5201a(String str);
    }

    private SnoomojiPreviewDialog(OnSendListener onSendListener, Integer num, String str) {
        this.f37384j = onSendListener;
        this.f37387m = num;
        this.f37385k = str;
    }

    public android.view.View onCreateView(android.view.LayoutInflater r4, android.view.ViewGroup r5, android.os.Bundle r6) {
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
        r3 = this;
        r6 = 0;
        r0 = 2131558453; // 0x7f0d0035 float:1.8742222E38 double:1.0531298037E-314;
        r4 = r4.inflate(r0, r5, r6);
        r3.f37386l = r4;
        r4 = r3.f37386l;
        r5 = 2131428346; // 0x7f0b03fa float:1.8478334E38 double:1.0530655223E-314;
        r4 = r4.findViewById(r5);
        r4 = (android.widget.Button) r4;
        r5 = r3.f37387m;
        r5 = r5.intValue();
        r5 = com.reddit.social.util.ChatUtilKt.m24763b(r5);
        if (r5 == 0) goto L_0x0051;
    L_0x0021:
        r5 = r3.f37386l;
        r0 = 2131427785; // 0x7f0b01c9 float:1.8477196E38 double:1.053065245E-314;
        r5 = r5.findViewById(r0);
        r5 = (pl.droidsonroids.gif.GifImageView) r5;
        r0 = new pl.droidsonroids.gif.GifDrawable;	 Catch:{ IOException -> 0x0040 }
        r1 = r3.getContext();	 Catch:{ IOException -> 0x0040 }
        r1 = r1.getResources();	 Catch:{ IOException -> 0x0040 }
        r2 = r3.f37387m;	 Catch:{ IOException -> 0x0040 }
        r2 = r2.intValue();	 Catch:{ IOException -> 0x0040 }
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x0040 }
        goto L_0x004a;
    L_0x0040:
        r0 = r3.f37387m;
        r0 = r0.intValue();
        r0 = com.reddit.frontpage.util.Util.m24032h(r0);
    L_0x004a:
        r5.setImageDrawable(r0);
        r5.setVisibility(r6);
        goto L_0x006c;
    L_0x0051:
        r5 = r3.f37386l;
        r0 = 2131427842; // 0x7f0b0202 float:1.8477312E38 double:1.0530652733E-314;
        r5 = r5.findViewById(r0);
        r5 = (android.widget.ImageView) r5;
        r0 = r3.f37387m;
        r0 = r0.intValue();
        r0 = com.reddit.frontpage.util.Util.m24032h(r0);
        r5.setImageDrawable(r0);
        r5.setVisibility(r6);
    L_0x006c:
        r5 = new com.reddit.frontpage.ui.sorting.SnoomojiPreviewDialog$$Lambda$0;
        r5.<init>(r3);
        r4.setOnClickListener(r5);
        r4 = r3.f37386l;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.sorting.SnoomojiPreviewDialog.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public static SnoomojiPreviewDialog m37824a(OnSendListener onSendListener, Integer num, String str) {
        return new SnoomojiPreviewDialog(onSendListener, num, str);
    }
}
