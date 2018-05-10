package com.instabug.bug.view;

import android.app.Activity;
import android.graphics.ColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.instabug.library.model.Attachment;
import com.instabug.library.view.IconView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AttachmentsAdapter */
public class C0498a extends BaseAdapter {
    List<Attachment> f9172a;
    ProgressBar f9173b;
    ImageView f9174c;
    private final LayoutInflater f9175d;
    private ColorFilter f9176e = null;
    private C0492a f9177f;
    private int f9178g;
    private final int f9179h;

    /* compiled from: AttachmentsAdapter */
    public interface C0492a {
        void mo4317a(View view, Attachment attachment);
    }

    /* compiled from: AttachmentsAdapter */
    private static class C0493b {
        RelativeLayout f9159a;
        ImageView f9160b;
        IconView f9161c;
        ImageView f9162d;
        TextView f9163e;

        private C0493b() {
        }
    }

    /* compiled from: AttachmentsAdapter */
    private static class C0494c {
        RelativeLayout f9164a;
        ImageView f9165b;
        IconView f9166c;

        private C0494c() {
        }
    }

    /* compiled from: AttachmentsAdapter */
    private static class C0495d {
        RelativeLayout f9167a;
        ProgressBar f9168b;
        IconView f9169c;
        ImageView f9170d;
        ImageView f9171e;

        private C0495d() {
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getViewTypeCount() {
        return 3;
    }

    public /* synthetic */ Object getItem(int i) {
        return m7836a(i);
    }

    public C0498a(Activity activity, C0492a c0492a) {
        this.f9175d = LayoutInflater.from(activity);
        this.f9177f = c0492a;
        this.f9172a = new ArrayList();
        this.f9178g = activity.getWindowManager().getDefaultDisplay().getHeight();
        if (activity.getResources().getConfiguration().orientation == 1) {
            this.f9179h = 5;
        } else {
            this.f9179h = 3;
        }
    }

    public int getCount() {
        return this.f9172a != null ? this.f9172a.size() : 0;
    }

    private Attachment m7836a(int i) {
        return (Attachment) this.f9172a.get(i);
    }

    public int getItemViewType(int i) {
        if (this.f9172a != null) {
            if (this.f9172a.size() != 0) {
                switch (((Attachment) this.f9172a.get(i)).getType()) {
                    case AUDIO:
                        return 2;
                    case VIDEO:
                        return 1;
                    default:
                        return 0;
                }
            }
        }
        return super.getItemViewType(i);
    }

    public android.view.View getView(int r7, android.view.View r8, android.view.ViewGroup r9) {
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
        r6 = this;
        r9 = r6.getItemViewType(r7);
        r0 = -1;
        r1 = 0;
        r2 = 0;
        switch(r9) {
            case 0: goto L_0x01c0;
            case 1: goto L_0x00b5;
            case 2: goto L_0x000b;
            default: goto L_0x000a;
        };
    L_0x000a:
        return r2;
    L_0x000b:
        if (r8 != 0) goto L_0x005d;
    L_0x000d:
        r8 = new com.instabug.bug.view.a$b;
        r8.<init>();
        r9 = r6.f9175d;
        r1 = com.instabug.bug.C0465R.layout.instabug_lyt_attachment_audio;
        r9 = r9.inflate(r1, r2);
        r1 = new android.widget.AbsListView$LayoutParams;
        r2 = r6.f9178g;
        r3 = r6.f9179h;
        r2 = r2 / r3;
        r1.<init>(r0, r2);
        r9.setLayoutParams(r1);
        r0 = com.instabug.bug.C0465R.id.instabug_grid_audio_item;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.RelativeLayout) r0;
        r8.f9159a = r0;
        r0 = com.instabug.bug.C0465R.id.instabug_img_audio_attachment;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r8.f9160b = r0;
        r0 = com.instabug.bug.C0465R.id.instabug_btn_remove_attachment;
        r0 = r9.findViewById(r0);
        r0 = (com.instabug.library.view.IconView) r0;
        r8.f9161c = r0;
        r0 = com.instabug.bug.C0465R.id.instabug_txt_attachment_length;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r8.f9163e = r0;
        r0 = com.instabug.bug.C0465R.id.instabug_btn_audio_play_attachment;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r8.f9162d = r0;
        r9.setTag(r8);
        goto L_0x0066;
    L_0x005d:
        r9 = r8.getTag();
        r9 = (com.instabug.bug.view.C0498a.C0493b) r9;
        r5 = r9;
        r9 = r8;
        r8 = r5;
    L_0x0066:
        r7 = r6.m7836a(r7);
        r0 = r8.f9160b;
        r0.setTag(r7);
        r0 = r8.f9159a;
        r1 = r6.m7834a(r7);
        r0.setOnClickListener(r1);
        r0 = r8.f9161c;
        r0.setTag(r7);
        r0 = r8.f9161c;
        r1 = r6.m7834a(r7);
        r0.setOnClickListener(r1);
        r0 = r8.f9162d;
        r1 = r6.f9176e;
        r0.setColorFilter(r1);
        r0 = r8.f9163e;
        r1 = com.instabug.library.core.InstabugCore.getPrimaryColor();
        r0.setTextColor(r1);
        r0 = new java.lang.StringBuilder;
        r1 = "Audio length is ";
        r0.<init>(r1);
        r1 = r7.getDuration();
        r0.append(r1);
        r0 = r0.toString();
        com.instabug.library.util.InstabugSDKLogger.m8356d(r6, r0);
        r8 = r8.f9163e;
        r7 = r7.getDuration();
        r8.setText(r7);
        return r9;
    L_0x00b5:
        if (r8 != 0) goto L_0x0107;
    L_0x00b7:
        r8 = new com.instabug.bug.view.a$d;
        r8.<init>();
        r9 = r6.f9175d;
        r3 = com.instabug.bug.C0465R.layout.instabug_lyt_attachment_video;
        r9 = r9.inflate(r3, r2);
        r2 = new android.widget.AbsListView$LayoutParams;
        r3 = r6.f9178g;
        r4 = r6.f9179h;
        r3 = r3 / r4;
        r2.<init>(r0, r3);
        r9.setLayoutParams(r2);
        r0 = com.instabug.bug.C0465R.id.instabug_grid_video_item;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.RelativeLayout) r0;
        r8.f9167a = r0;
        r0 = com.instabug.bug.C0465R.id.instabug_img_video_attachment;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r8.f9171e = r0;
        r0 = com.instabug.bug.C0465R.id.instabug_btn_remove_attachment;
        r0 = r9.findViewById(r0);
        r0 = (com.instabug.library.view.IconView) r0;
        r8.f9169c = r0;
        r0 = com.instabug.bug.C0465R.id.instabug_attachment_progress_bar;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.ProgressBar) r0;
        r8.f9168b = r0;
        r0 = com.instabug.bug.C0465R.id.instabug_btn_video_play_attachment;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r8.f9170d = r0;
        r9.setTag(r8);
        goto L_0x0110;
    L_0x0107:
        r9 = r8.getTag();
        r9 = (com.instabug.bug.view.C0498a.C0495d) r9;
        r5 = r9;
        r9 = r8;
        r8 = r5;
    L_0x0110:
        r7 = r6.m7836a(r7);
        r0 = r8.f9169c;
        r2 = com.instabug.bug.C0465R.id.instabug_btn_remove_attachment;
        r0 = r0.findViewById(r2);
        r0.setTag(r7);
        r0 = r8.f9169c;
        r2 = com.instabug.bug.C0465R.id.instabug_btn_remove_attachment;
        r0 = r0.findViewById(r2);
        r2 = r6.m7834a(r7);
        r0.setOnClickListener(r2);
        r0 = r8.f9170d;
        r2 = r6.f9176e;
        r0.setColorFilter(r2);
        r0 = r8.f9171e;
        r0.setTag(r7);
        r0 = r8.f9167a;
        r2 = r6.m7834a(r7);
        r0.setOnClickListener(r2);
        r0 = r8.f9170d;
        r6.f9174c = r0;
        r0 = r8.f9168b;
        r6.f9173b = r0;
        r0 = new java.lang.StringBuilder;
        r2 = "encoded: ";
        r0.<init>(r2);
        r2 = r7.isVideoEncoded();
        r0.append(r2);
        r0 = r0.toString();
        com.instabug.library.util.InstabugSDKLogger.m8356d(r6, r0);
        r0 = r7.getLocalPath();
        if (r0 == 0) goto L_0x018f;
    L_0x0166:
        r0 = r7.isVideoEncoded();
        if (r0 == 0) goto L_0x018f;
    L_0x016c:
        r0 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x01bf }
        r1 = "Video path found, extracting it's first frame ";	 Catch:{ IllegalArgumentException -> 0x01bf }
        r0.<init>(r1);	 Catch:{ IllegalArgumentException -> 0x01bf }
        r1 = r7.getLocalPath();	 Catch:{ IllegalArgumentException -> 0x01bf }
        r0.append(r1);	 Catch:{ IllegalArgumentException -> 0x01bf }
        r0 = r0.toString();	 Catch:{ IllegalArgumentException -> 0x01bf }
        com.instabug.library.util.InstabugSDKLogger.m8356d(r6, r0);	 Catch:{ IllegalArgumentException -> 0x01bf }
        r7 = r7.getLocalPath();	 Catch:{ IllegalArgumentException -> 0x01bf }
        r7 = com.instabug.library.util.VideoManipulationUtils.extractFirstVideoFrame(r7);	 Catch:{ IllegalArgumentException -> 0x01bf }
        r8 = r8.f9171e;	 Catch:{ IllegalArgumentException -> 0x01bf }
        r8.setImageBitmap(r7);	 Catch:{ IllegalArgumentException -> 0x01bf }
        goto L_0x01bf;
    L_0x018f:
        r7 = "Neither video path nor main screenshot found, using white background";
        com.instabug.library.util.InstabugSDKLogger.m8356d(r6, r7);
        r7 = r8.f9171e;
        r8 = com.instabug.bug.C0465R.drawable.instabug_bg_card;
        r7.setImageResource(r8);
        r7 = r6.f9173b;
        r8 = 8;
        if (r7 == 0) goto L_0x01ae;
    L_0x01a1:
        r7 = r6.f9173b;
        r7 = r7.getVisibility();
        if (r7 != r8) goto L_0x01ae;
    L_0x01a9:
        r7 = r6.f9173b;
        r7.setVisibility(r1);
    L_0x01ae:
        r7 = r6.f9174c;
        if (r7 == 0) goto L_0x01bf;
    L_0x01b2:
        r7 = r6.f9174c;
        r7 = r7.getVisibility();
        if (r7 != 0) goto L_0x01bf;
    L_0x01ba:
        r7 = r6.f9174c;
        r7.setVisibility(r8);
    L_0x01bf:
        return r9;
    L_0x01c0:
        if (r8 != 0) goto L_0x01fe;
    L_0x01c2:
        r8 = new com.instabug.bug.view.a$c;
        r8.<init>();
        r9 = r6.f9175d;
        r1 = com.instabug.bug.C0465R.layout.instabug_lyt_attachment_image;
        r9 = r9.inflate(r1, r2);
        r1 = new android.widget.AbsListView$LayoutParams;
        r2 = r6.f9178g;
        r3 = r6.f9179h;
        r2 = r2 / r3;
        r1.<init>(r0, r2);
        r9.setLayoutParams(r1);
        r0 = com.instabug.bug.C0465R.id.instabug_img_attachment;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r8.f9165b = r0;
        r0 = com.instabug.bug.C0465R.id.instabug_grid_img_item;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.RelativeLayout) r0;
        r8.f9164a = r0;
        r0 = com.instabug.bug.C0465R.id.instabug_btn_remove_attachment;
        r0 = r9.findViewById(r0);
        r0 = (com.instabug.library.view.IconView) r0;
        r8.f9166c = r0;
        r9.setTag(r8);
        goto L_0x0207;
    L_0x01fe:
        r9 = r8.getTag();
        r9 = (com.instabug.bug.view.C0498a.C0494c) r9;
        r5 = r9;
        r9 = r8;
        r8 = r5;
    L_0x0207:
        r7 = r6.m7836a(r7);
        r0 = r7.getLocalPath();
        r1 = r8.f9165b;
        com.instabug.library.util.BitmapUtils.loadBitmap(r0, r1);
        r0 = r8.f9165b;
        r0.setTag(r7);
        r0 = r8.f9164a;
        r1 = r6.m7834a(r7);
        r0.setOnClickListener(r1);
        r0 = r8.f9166c;
        r0.setTag(r7);
        r8 = r8.f9166c;
        r7 = r6.m7834a(r7);
        r8.setOnClickListener(r7);
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.view.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    private OnClickListener m7834a(final Attachment attachment) {
        return new OnClickListener(this) {
            final /* synthetic */ C0498a f9157b;

            public void onClick(View view) {
                this.f9157b.f9177f.mo4317a(view, attachment);
            }
        };
    }
}
