package net.hockeyapp.android.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import net.hockeyapp.android.C2158R;
import net.hockeyapp.android.objects.FeedbackAttachment;
import net.hockeyapp.android.utils.AsyncTaskUtils;
import net.hockeyapp.android.utils.Util;

@SuppressLint({"ViewConstructor"})
public class AttachmentView extends FrameLayout {
    final Context f26635a;
    final ViewGroup f26636b;
    public final String f26637c;
    public TextView f26638d;
    public int f26639e;
    private final FeedbackAttachment f26640f;
    private final Uri f26641g;
    private ImageView f26642h;
    private int f26643i;
    private int f26644j;
    private int f26645k;
    private int f26646l;
    private int f26647m;

    class C21651 extends AsyncTask<Void, Void, Bitmap> {
        final /* synthetic */ AttachmentView f26628a;

        C21651(AttachmentView attachmentView) {
            this.f26628a = attachmentView;
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            if (bitmap != null) {
                this.f26628a.m28260a(bitmap, false);
            } else {
                this.f26628a.m28261a(false);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return this.f26628a.m28250a();
        }
    }

    class C21662 implements OnClickListener {
        final /* synthetic */ AttachmentView f26629a;

        C21662(AttachmentView attachmentView) {
            this.f26629a = attachmentView;
        }

        public void onClick(View view) {
            view = this.f26629a;
            Util.m28237a(view.f26636b, view.f26635a.getString(C2158R.string.hockeyapp_feedback_attachment_removed));
            view.f26636b.removeView(view);
        }
    }

    class C21673 implements OnFocusChangeListener {
        final /* synthetic */ AttachmentView f26630a;

        C21673(AttachmentView attachmentView) {
            this.f26630a = attachmentView;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                Util.m28237a(this.f26630a.f26638d, this.f26630a.f26638d.getText());
            }
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    public AttachmentView(Context context, ViewGroup viewGroup, Uri uri) {
        super(context);
        this.f26635a = context;
        this.f26636b = viewGroup;
        this.f26640f = null;
        this.f26641g = uri;
        this.f26637c = uri.getLastPathSegment();
        m28253a(10);
        m28254a(context, true);
        this.f26638d.setText(this.f26637c);
        this.f26638d.setContentDescription(this.f26638d.getText());
        AsyncTaskUtils.m28200a(new C21651(this));
    }

    public AttachmentView(Context context, ViewGroup viewGroup, FeedbackAttachment feedbackAttachment) {
        super(context);
        this.f26635a = context;
        this.f26636b = viewGroup;
        this.f26640f = feedbackAttachment;
        this.f26641g = null;
        this.f26637c = feedbackAttachment.getFilename();
        m28253a(40);
        m28254a(context, false);
        this.f26639e = 1;
        this.f26638d.setText(C2158R.string.hockeyapp_feedback_attachment_loading);
        this.f26638d.setContentDescription(this.f26638d.getText());
        m28261a(false);
    }

    public FeedbackAttachment getAttachment() {
        return this.f26640f;
    }

    public Uri getAttachmentUri() {
        return this.f26641g;
    }

    public int getWidthPortrait() {
        return this.f26643i;
    }

    public int getMaxHeightPortrait() {
        return this.f26644j;
    }

    public int getWidthLandscape() {
        return this.f26645k;
    }

    public int getMaxHeightLandscape() {
        return this.f26646l;
    }

    public int getGap() {
        return this.f26647m;
    }

    public int getEffectiveMaxHeight() {
        return this.f26639e == 0 ? this.f26646l : this.f26644j;
    }

    private void m28253a(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f26647m = Math.round(TypedValue.applyDimension(1, 10.0f, displayMetrics));
        int round = displayMetrics.widthPixels - (Math.round(TypedValue.applyDimension(1, (float) i, displayMetrics)) * 2);
        i = round - (this.f26647m * 2);
        round -= this.f26647m;
        this.f26643i = i / 3;
        this.f26645k = round / 2;
        this.f26644j = this.f26643i * 2;
        this.f26646l = this.f26645k;
    }

    private void m28254a(Context context, boolean z) {
        setLayoutParams(new LayoutParams(-2, -2, 80));
        setPadding(0, this.f26647m, 0, 0);
        Util.m28237a(this.f26636b, this.f26635a.getString(C2158R.string.hockeyapp_feedback_attachment_added));
        this.f26642h = new ImageView(context);
        View linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LayoutParams(-1, -2, 80));
        linearLayout.setGravity(8388611);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor("#80262626"));
        this.f26638d = new TextView(context);
        this.f26638d.setLayoutParams(new LayoutParams(-1, -2, 17));
        this.f26638d.setGravity(17);
        this.f26638d.setTextColor(context.getResources().getColor(C2158R.color.hockeyapp_text_white));
        this.f26638d.setSingleLine();
        this.f26638d.setEllipsize(TruncateAt.MIDDLE);
        if (z) {
            z = new ImageButton(context);
            z.setLayoutParams(new LayoutParams(-1, -2, 80));
            z.setAdjustViewBounds(true);
            z.setImageDrawable(m28252a("ic_menu_delete"));
            z.setBackgroundResource(0);
            z.setContentDescription(context.getString(C2158R.string.hockeyapp_feedback_attachment_remove_description));
            z.setOnClickListener(new C21662(this));
            z.setOnFocusChangeListener(new C21673(this));
            linearLayout.addView(z);
        }
        linearLayout.addView(this.f26638d);
        addView(this.f26642h);
        addView(linearLayout);
    }

    public final void m28260a(Bitmap bitmap, final boolean z) {
        int i = this.f26639e == 0 ? this.f26645k : this.f26643i;
        int i2 = this.f26639e == 0 ? this.f26646l : this.f26644j;
        this.f26638d.setMaxWidth(i);
        this.f26638d.setMinWidth(i);
        this.f26642h.setLayoutParams(new LayoutParams(-2, -2));
        this.f26642h.setAdjustViewBounds(true);
        this.f26642h.setMinimumWidth(i);
        this.f26642h.setMaxWidth(i);
        this.f26642h.setMaxHeight(i2);
        this.f26642h.setScaleType(ScaleType.CENTER_INSIDE);
        this.f26642h.setImageBitmap(bitmap);
        this.f26642h.setContentDescription(this.f26638d.getText());
        this.f26642h.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AttachmentView f26632b;

            public void onClick(View view) {
                if (z != null) {
                    view = new Intent();
                    view.setAction("android.intent.action.VIEW");
                    view.setDataAndType(this.f26632b.f26641g, "image/*");
                    this.f26632b.f26635a.startActivity(view);
                }
            }
        });
    }

    public final void m28261a(final boolean z) {
        this.f26638d.setMaxWidth(this.f26643i);
        this.f26638d.setMinWidth(this.f26643i);
        this.f26642h.setLayoutParams(new LayoutParams(-2, -2));
        this.f26642h.setAdjustViewBounds(false);
        this.f26642h.setBackgroundColor(Color.parseColor("#eeeeee"));
        this.f26642h.setMinimumHeight((int) (((float) this.f26643i) * 1.2f));
        this.f26642h.setMinimumWidth(this.f26643i);
        this.f26642h.setScaleType(ScaleType.FIT_CENTER);
        this.f26642h.setImageDrawable(m28252a("ic_menu_attachment"));
        this.f26642h.setContentDescription(this.f26638d.getText());
        this.f26642h.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AttachmentView f26634b;

            public void onClick(View view) {
                if (z != null) {
                    view = new Intent();
                    view.setAction("android.intent.action.VIEW");
                    view.setDataAndType(this.f26634b.f26641g, "*/*");
                    this.f26634b.f26635a.startActivity(view);
                }
            }
        });
    }

    private android.graphics.Bitmap m28250a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.f26635a;	 Catch:{ Throwable -> 0x0025 }
        r1 = r4.f26641g;	 Catch:{ Throwable -> 0x0025 }
        r0 = net.hockeyapp.android.utils.ImageUtils.m28216a(r0, r1);	 Catch:{ Throwable -> 0x0025 }
        r4.f26639e = r0;	 Catch:{ Throwable -> 0x0025 }
        r0 = r4.f26639e;	 Catch:{ Throwable -> 0x0025 }
        if (r0 != 0) goto L_0x0011;	 Catch:{ Throwable -> 0x0025 }
    L_0x000e:
        r0 = r4.f26645k;	 Catch:{ Throwable -> 0x0025 }
        goto L_0x0013;	 Catch:{ Throwable -> 0x0025 }
    L_0x0011:
        r0 = r4.f26643i;	 Catch:{ Throwable -> 0x0025 }
    L_0x0013:
        r1 = r4.f26639e;	 Catch:{ Throwable -> 0x0025 }
        if (r1 != 0) goto L_0x001a;	 Catch:{ Throwable -> 0x0025 }
    L_0x0017:
        r1 = r4.f26646l;	 Catch:{ Throwable -> 0x0025 }
        goto L_0x001c;	 Catch:{ Throwable -> 0x0025 }
    L_0x001a:
        r1 = r4.f26644j;	 Catch:{ Throwable -> 0x0025 }
    L_0x001c:
        r2 = r4.f26635a;	 Catch:{ Throwable -> 0x0025 }
        r3 = r4.f26641g;	 Catch:{ Throwable -> 0x0025 }
        r0 = net.hockeyapp.android.utils.ImageUtils.m28220a(r2, r3, r0, r1);	 Catch:{ Throwable -> 0x0025 }
        return r0;
    L_0x0025:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.views.AttachmentView.a():android.graphics.Bitmap");
    }

    private Drawable m28252a(String str) {
        if (VERSION.SDK_INT >= 21) {
            return getResources().getDrawable(getResources().getIdentifier(str, "drawable", "android"), this.f26635a.getTheme());
        }
        return getResources().getDrawable(getResources().getIdentifier(str, "drawable", "android"));
    }
}
