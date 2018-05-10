package com.instabug.library.internal.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.Arrays;

public class AnimatedImageView extends ImageView {
    private C0703a[] f9677a;
    private Drawable f9678b = null;
    private final Handler f9679c = new Handler();
    private boolean f9680d = null;
    private Thread f9681e;
    private final Runnable f9682f = new C07021(this);

    class C07021 implements Runnable {
        final /* synthetic */ AnimatedImageView f9673a;

        C07021(AnimatedImageView animatedImageView) {
            this.f9673a = animatedImageView;
        }

        public void run() {
            if (this.f9673a.f9678b != null) {
                this.f9673a.setImageDrawable(this.f9673a.f9678b);
            }
        }
    }

    public static class C0703a {
        public int f9674a;
        public int f9675b;
    }

    private class C0704b implements Runnable {
        final /* synthetic */ AnimatedImageView f9676a;

        private C0704b(AnimatedImageView animatedImageView) {
            this.f9676a = animatedImageView;
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r6 = this;
            r0 = r6.f9676a;
            r0 = r0.f9677a;
            r0 = r0.length;
        L_0x0007:
            r1 = 0;
        L_0x0008:
            if (r1 >= r0) goto L_0x004f;
        L_0x000a:
            r2 = r6.f9676a;
            r2 = r2.f9678b;
            r3 = r6.f9676a;
            r4 = r6.f9676a;
            r4 = r4.getResources();
            r5 = r6.f9676a;
            r5 = r5.f9677a;
            r5 = r5[r1];
            r5 = r5.f9674a;
            r4 = r4.getDrawable(r5);
            r3.f9678b = r4;
            if (r2 == 0) goto L_0x002f;
        L_0x002b:
            r3 = 0;
            r2.setCallback(r3);
        L_0x002f:
            r2 = r6.f9676a;	 Catch:{ InterruptedException -> 0x004c }
            r2 = r2.f9677a;	 Catch:{ InterruptedException -> 0x004c }
            r2 = r2[r1];	 Catch:{ InterruptedException -> 0x004c }
            r2 = r2.f9675b;	 Catch:{ InterruptedException -> 0x004c }
            r2 = (long) r2;	 Catch:{ InterruptedException -> 0x004c }
            java.lang.Thread.sleep(r2);	 Catch:{ InterruptedException -> 0x004c }
            r2 = r6.f9676a;	 Catch:{ InterruptedException -> 0x004c }
            r2 = r2.f9679c;	 Catch:{ InterruptedException -> 0x004c }
            r3 = r6.f9676a;	 Catch:{ InterruptedException -> 0x004c }
            r3 = r3.f9682f;	 Catch:{ InterruptedException -> 0x004c }
            r2.post(r3);	 Catch:{ InterruptedException -> 0x004c }
        L_0x004c:
            r1 = r1 + 1;
            goto L_0x0008;
        L_0x004f:
            r1 = r6.f9676a;
            r1 = r1.f9680d;
            if (r1 != 0) goto L_0x0007;
        L_0x0057:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.view.AnimatedImageView.b.run():void");
        }
    }

    public AnimatedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnimatedImageView(Context context) {
        super(context);
    }

    public void setFrames(C0703a[] c0703aArr) {
        this.f9677a = (C0703a[]) Arrays.copyOf(c0703aArr, c0703aArr.length);
        try {
            this.f9678b = getResources().getDrawable(c0703aArr[0].f9674a);
            setImageDrawable(this.f9678b);
            c0703aArr = 1;
            this.f9680d = true;
            if (!this.f9680d || this.f9677a == null || this.f9681e != null) {
                c0703aArr = null;
            }
            if (c0703aArr != null) {
                this.f9681e = new Thread(new C0704b());
                this.f9681e.start();
            }
        } catch (C0703a[] c0703aArr2) {
            c0703aArr2.printStackTrace();
            this.f9677a = null;
        }
    }
}
