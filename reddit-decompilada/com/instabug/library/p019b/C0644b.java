package com.instabug.library.p019b;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Handler;
import android.text.Html;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.instabug.library.C0593R;

/* compiled from: InstabugSwipeAnimationDialog */
public class C0644b extends Dialog implements OnShowListener {
    private ImageView f9566a;
    private ImageView f9567b;
    private String f9568c;
    private Runnable f9569d;
    private boolean f9570e = null;
    private ObjectAnimator f9571f;
    private ObjectAnimator f9572g;
    private ObjectAnimator f9573h;

    /* compiled from: InstabugSwipeAnimationDialog */
    class C06421 implements Runnable {
        final /* synthetic */ C0644b f9564a;

        C06421(C0644b c0644b) {
            this.f9564a = c0644b;
        }

        public void run() {
            this.f9564a.f9567b.setVisibility(0);
        }
    }

    /* compiled from: InstabugSwipeAnimationDialog */
    class C06432 implements Runnable {
        final /* synthetic */ C0644b f9565a;

        C06432(C0644b c0644b) {
            this.f9565a = c0644b;
        }

        public void run() {
            if (this.f9565a.f9570e) {
                this.f9565a.dismiss();
            }
        }
    }

    public C0644b(Context context, String str) {
        super(context, C0593R.style.InstabugBorderlessDialog);
        this.f9568c = str;
        requestWindowFeature(1);
        setContentView(C0593R.layout.instabug_lyt_dialog_two_fingers_swipe_animation);
        setOnShowListener(this);
        ((TextView) findViewById(C0593R.id.animation_description)).setText(Html.fromHtml(this.f9568c));
        this.f9566a = (ImageView) findViewById(C0593R.id.fingersImageView);
        this.f9566a.setImageResource(C0593R.drawable.instabug_img_two_fingers);
        this.f9567b = (ImageView) findViewById(C0593R.id.touchesImageView);
        this.f9567b.setImageResource(C0593R.drawable.instabug_img_two_fingers_touch);
        FrameLayout frameLayout = (FrameLayout) findViewById(C0593R.id.animation_container);
        this.f9572g = ObjectAnimator.ofFloat(frameLayout, "scaleX", new float[]{1.0f, 0.8f});
        this.f9573h = ObjectAnimator.ofFloat(frameLayout, "scaleY", new float[]{1.0f, 0.8f});
        this.f9572g.setStartDelay(200);
        this.f9572g.setDuration(800);
        this.f9573h.setStartDelay(200);
        this.f9573h.setDuration(800);
        this.f9571f = ObjectAnimator.ofFloat(frameLayout, "translationX", new float[]{0.0f, -120.0f});
        this.f9571f.setStartDelay(1000);
        this.f9571f.setDuration(800);
        new Handler().postDelayed(new C06421(this), 1000);
    }

    public void dismiss() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        super.dismiss();
        r0 = 0;
        r1 = r2.f9571f;	 Catch:{ Exception -> 0x0023 }
        if (r1 == 0) goto L_0x0017;	 Catch:{ Exception -> 0x0023 }
    L_0x0008:
        r1 = r2.f9571f;	 Catch:{ Exception -> 0x0023 }
        r1.cancel();	 Catch:{ Exception -> 0x0023 }
        r1 = r2.f9572g;	 Catch:{ Exception -> 0x0023 }
        r1.cancel();	 Catch:{ Exception -> 0x0023 }
        r1 = r2.f9573h;	 Catch:{ Exception -> 0x0023 }
        r1.cancel();	 Catch:{ Exception -> 0x0023 }
    L_0x0017:
        r1 = r2.f9566a;	 Catch:{ Exception -> 0x0023 }
        r1 = r1.getDrawable();	 Catch:{ Exception -> 0x0023 }
        r1.setCallback(r0);	 Catch:{ Exception -> 0x0023 }
        r2.f9566a = r0;	 Catch:{ Exception -> 0x0023 }
        return;
    L_0x0023:
        r2.f9566a = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.b.b.dismiss():void");
    }

    public void onDetachedFromWindow() {
        this.f9570e = false;
        findViewById(C0593R.id.animation_description).removeCallbacks(this.f9569d);
        super.onDetachedFromWindow();
    }

    public void onAttachedToWindow() {
        this.f9570e = true;
        super.onAttachedToWindow();
    }

    protected void onStop() {
        super.onStop();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void onShow(DialogInterface dialogInterface) {
        if (this.f9566a != null) {
            if (this.f9571f != null) {
                this.f9571f.start();
                this.f9572g.start();
                this.f9573h.start();
            }
            this.f9569d = new C06432(this);
            findViewById(C0593R.id.animation_description).postDelayed(this.f9569d, 1800);
        }
    }
}
