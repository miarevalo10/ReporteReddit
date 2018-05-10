package com.instabug.library.p019b;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import com.instabug.library.C0593R;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.internal.view.AnimatedImageView;

/* compiled from: InstabugShakeAnimationDialog */
public class C0641a extends Dialog implements OnShowListener {
    private ImageView f9559a;
    private String f9560b;
    private Runnable f9561c;
    private boolean f9562d = null;
    private ObjectAnimator f9563e;

    /* compiled from: InstabugShakeAnimationDialog */
    class C06401 implements Runnable {
        final /* synthetic */ C0641a f9558a;

        C06401(C0641a c0641a) {
            this.f9558a = c0641a;
        }

        public void run() {
            if (this.f9558a.f9562d) {
                this.f9558a.dismiss();
            }
        }
    }

    public C0641a(Context context, String str) {
        super(context, C0593R.style.InstabugBorderlessDialog);
        this.f9560b = str;
        requestWindowFeature(1);
        setContentView(C0593R.layout.instabug_lyt_dialog_shake_animation);
        setOnShowListener(this);
        TextView textView = (TextView) findViewById(C0593R.id.animation_description);
        textView.setText(Html.fromHtml(this.f9560b));
        this.f9559a = (AnimatedImageView) findViewById(C0593R.id.animation_frame);
        this.f9559a.setImageResource(C0593R.drawable.instabug_img_shake);
        if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeDark) {
            findViewById(C0593R.id.instabug_intro_dialog).setBackgroundColor(ContextCompat.m719c(getContext(), C0593R.color.instabug_dialog_dark_bg_color));
            textView.setTextColor(ContextCompat.m719c(getContext(), 17170443));
            textView.setBackgroundColor(ContextCompat.m719c(getContext(), C0593R.color.instabug_dialog_dark_bg_color));
        }
        this.f9563e = ObjectAnimator.ofFloat(this.f9559a, "rotation", new float[]{0.0f, 8.0f, 16.0f, 25.0f, 0.0f, -12.0f, -25.0f, -12.0f, 0.0f, 4.0f, 0.0f});
        this.f9563e.setDuration(1000);
        this.f9563e.setRepeatCount(3);
        this.f9563e.setStartDelay(200);
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
        r1 = r2.f9563e;	 Catch:{ Exception -> 0x0019 }
        if (r1 == 0) goto L_0x000d;	 Catch:{ Exception -> 0x0019 }
    L_0x0008:
        r1 = r2.f9563e;	 Catch:{ Exception -> 0x0019 }
        r1.cancel();	 Catch:{ Exception -> 0x0019 }
    L_0x000d:
        r1 = r2.f9559a;	 Catch:{ Exception -> 0x0019 }
        r1 = r1.getDrawable();	 Catch:{ Exception -> 0x0019 }
        r1.setCallback(r0);	 Catch:{ Exception -> 0x0019 }
        r2.f9559a = r0;	 Catch:{ Exception -> 0x0019 }
        return;
    L_0x0019:
        r2.f9559a = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.b.a.dismiss():void");
    }

    public void onDetachedFromWindow() {
        this.f9562d = false;
        findViewById(C0593R.id.animation_description).removeCallbacks(this.f9561c);
        super.onDetachedFromWindow();
    }

    public void onAttachedToWindow() {
        this.f9562d = true;
        super.onAttachedToWindow();
    }

    protected void onStop() {
        super.onStop();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void onShow(DialogInterface dialogInterface) {
        if (this.f9559a != null) {
            if (this.f9563e != null) {
                this.f9563e.start();
            }
            this.f9561c = new C06401(this);
            findViewById(C0593R.id.animation_description).postDelayed(this.f9561c, 3000);
        }
    }
}
