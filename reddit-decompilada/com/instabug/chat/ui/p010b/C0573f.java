package com.instabug.chat.ui.p010b;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.instabug.chat.C0520R;
import com.instabug.chat.model.C0550a;
import com.instabug.chat.model.C1308b;
import com.instabug.chat.ui.view.CircularImageView;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.media.AudioPlayer;
import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.internal.storage.cache.AssetsCacheManager.OnDownloadFinished;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.model.AssetEntity.AssetType;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.FileInputStream;
import java.util.List;

/* compiled from: MessagesListAdapter */
public class C0573f extends BaseAdapter {
    List<C0550a> f9330a;
    private final AudioPlayer f9331b;
    private ColorFilter f9332c;
    private Context f9333d;
    private ListView f9334e;
    private C0571a f9335f;
    private boolean f9336g = true;

    /* compiled from: MessagesListAdapter */
    public interface C0571a {
        void mo4333b(String str);

        void mo4335c(String str);

        void mo4337d(String str);
    }

    /* compiled from: MessagesListAdapter */
    public static class C0572b {
        public CircularImageView f9318a;
        public TextView f9319b;
        public TextView f9320c;
        public ImageView f9321d;
        public FrameLayout f9322e;
        public ImageView f9323f;
        public ProgressBar f9324g;
        public ImageView f9325h;
        public ImageView f9326i;
        public FrameLayout f9327j;
        public ProgressBar f9328k;
        public LinearLayout f9329l;

        public C0572b(View view) {
            this.f9318a = (CircularImageView) view.findViewById(C0520R.id.instabug_img_message_sender);
            this.f9319b = (TextView) view.findViewById(C0520R.id.instabug_txt_message_time);
            this.f9320c = (TextView) view.findViewById(C0520R.id.instabug_txt_message_body);
            this.f9321d = (ImageView) view.findViewById(C0520R.id.instabug_img_attachment);
            this.f9323f = (ImageView) view.findViewById(C0520R.id.instabug_btn_play_audio);
            this.f9322e = (FrameLayout) view.findViewById(C0520R.id.instabug_audio_attachment);
            this.f9324g = (ProgressBar) view.findViewById(C0520R.id.instabug_audio_attachment_progress_bar);
            this.f9326i = (ImageView) view.findViewById(C0520R.id.instabug_img_video_attachment);
            this.f9325h = (ImageView) view.findViewById(C0520R.id.instabug_btn_play_video);
            this.f9327j = (FrameLayout) view.findViewById(C0520R.id.instabug_video_attachment);
            this.f9328k = (ProgressBar) view.findViewById(C0520R.id.instabug_video_attachment_progress_bar);
            this.f9329l = (LinearLayout) view.findViewById(C0520R.id.instabug_message_actions_container);
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getViewTypeCount() {
        return 8;
    }

    public /* synthetic */ Object getItem(int i) {
        return m7974a(i);
    }

    public C0573f(List<C0550a> list, Context context, ListView listView, C0571a c0571a) {
        this.f9330a = list;
        this.f9334e = listView;
        this.f9333d = context;
        this.f9335f = c0571a;
        this.f9331b = new AudioPlayer();
        this.f9332c = new PorterDuffColorFilter(InstabugCore.getPrimaryColor(), Mode.SRC_IN);
    }

    public int getCount() {
        return this.f9330a.size();
    }

    public int getItemViewType(int i) {
        i = m7974a(i);
        switch (i.f9280f) {
            case MESSAGE:
                return i.f9282h != 0 ? 0 : 1;
            case IMAGE:
                return i.f9282h != 0 ? 2 : 3;
            case AUDIO:
                return i.f9282h != 0 ? 4 : 5;
            case VIDEO:
                return i.f9282h != 0 ? 6 : 7;
            default:
                return -1;
        }
    }

    private C0550a m7974a(int i) {
        return (C0550a) this.f9330a.get(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r7, android.view.View r8, android.view.ViewGroup r9) {
        /*
        r6 = this;
        r0 = r6.getItemViewType(r7);
        r1 = 0;
        if (r8 != 0) goto L_0x009a;
    L_0x0007:
        switch(r0) {
            case 0: goto L_0x0083;
            case 1: goto L_0x0074;
            case 2: goto L_0x0065;
            case 3: goto L_0x0056;
            case 4: goto L_0x0047;
            case 5: goto L_0x0038;
            case 6: goto L_0x0029;
            case 7: goto L_0x001a;
            default: goto L_0x000a;
        };
    L_0x000a:
        r8 = r9.getContext();
        r8 = android.view.LayoutInflater.from(r8);
        r0 = com.instabug.chat.C0520R.layout.instabug_message_list_item_me;
        r8 = r8.inflate(r0, r9, r1);
        goto L_0x0091;
    L_0x001a:
        r8 = r9.getContext();
        r8 = android.view.LayoutInflater.from(r8);
        r0 = com.instabug.chat.C0520R.layout.instabug_message_list_item_video;
        r8 = r8.inflate(r0, r9, r1);
        goto L_0x0091;
    L_0x0029:
        r8 = r9.getContext();
        r8 = android.view.LayoutInflater.from(r8);
        r0 = com.instabug.chat.C0520R.layout.instabug_message_list_item_video_me;
        r8 = r8.inflate(r0, r9, r1);
        goto L_0x0091;
    L_0x0038:
        r8 = r9.getContext();
        r8 = android.view.LayoutInflater.from(r8);
        r0 = com.instabug.chat.C0520R.layout.instabug_message_list_item_voice;
        r8 = r8.inflate(r0, r9, r1);
        goto L_0x0091;
    L_0x0047:
        r8 = r9.getContext();
        r8 = android.view.LayoutInflater.from(r8);
        r0 = com.instabug.chat.C0520R.layout.instabug_message_list_item_voice_me;
        r8 = r8.inflate(r0, r9, r1);
        goto L_0x0091;
    L_0x0056:
        r8 = r9.getContext();
        r8 = android.view.LayoutInflater.from(r8);
        r0 = com.instabug.chat.C0520R.layout.instabug_message_list_item_img;
        r8 = r8.inflate(r0, r9, r1);
        goto L_0x0091;
    L_0x0065:
        r8 = r9.getContext();
        r8 = android.view.LayoutInflater.from(r8);
        r0 = com.instabug.chat.C0520R.layout.instabug_message_list_item_img_me;
        r8 = r8.inflate(r0, r9, r1);
        goto L_0x0091;
    L_0x0074:
        r8 = r9.getContext();
        r8 = android.view.LayoutInflater.from(r8);
        r0 = com.instabug.chat.C0520R.layout.instabug_message_list_item;
        r8 = r8.inflate(r0, r9, r1);
        goto L_0x0091;
    L_0x0083:
        r8 = r9.getContext();
        r8 = android.view.LayoutInflater.from(r8);
        r0 = com.instabug.chat.C0520R.layout.instabug_message_list_item_me;
        r8 = r8.inflate(r0, r9, r1);
    L_0x0091:
        r9 = new com.instabug.chat.ui.b.f$b;
        r9.<init>(r8);
        r8.setTag(r9);
        goto L_0x00a0;
    L_0x009a:
        r9 = r8.getTag();
        r9 = (com.instabug.chat.ui.p010b.C0573f.C0572b) r9;
    L_0x00a0:
        r7 = r6.m7974a(r7);	 Catch:{ ParseException -> 0x0288 }
        if (r9 == 0) goto L_0x028c;
    L_0x00a6:
        r0 = new java.lang.StringBuilder;	 Catch:{ ParseException -> 0x0288 }
        r2 = "viewholder: ";
        r0.<init>(r2);	 Catch:{ ParseException -> 0x0288 }
        r2 = 1;
        if (r9 != 0) goto L_0x00b2;
    L_0x00b0:
        r3 = r2;
        goto L_0x00b3;
    L_0x00b2:
        r3 = r1;
    L_0x00b3:
        r0.append(r3);	 Catch:{ ParseException -> 0x0288 }
        r3 = ", type:";
        r0.append(r3);	 Catch:{ ParseException -> 0x0288 }
        r3 = r7.f9280f;	 Catch:{ ParseException -> 0x0288 }
        r0.append(r3);	 Catch:{ ParseException -> 0x0288 }
        r0 = r0.toString();	 Catch:{ ParseException -> 0x0288 }
        com.instabug.library.util.InstabugSDKLogger.m8360v(r6, r0);	 Catch:{ ParseException -> 0x0288 }
        r0 = com.instabug.chat.ui.p010b.C0573f.C05708.f9317a;	 Catch:{ ParseException -> 0x0288 }
        r3 = r7.f9280f;	 Catch:{ ParseException -> 0x0288 }
        r3 = r3.ordinal();	 Catch:{ ParseException -> 0x0288 }
        r0 = r0[r3];	 Catch:{ ParseException -> 0x0288 }
        r3 = 8;
        switch(r0) {
            case 1: goto L_0x0248;
            case 2: goto L_0x01fd;
            case 3: goto L_0x016d;
            case 4: goto L_0x00d8;
            default: goto L_0x00d6;
        };	 Catch:{ ParseException -> 0x0288 }
    L_0x00d6:
        goto L_0x028c;
    L_0x00d8:
        r0 = r7.f9282h;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x00f2;
    L_0x00dc:
        r0 = r9.f9326i;	 Catch:{ ParseException -> 0x0288 }
        r0 = r0.getBackground();	 Catch:{ ParseException -> 0x0288 }
        r0 = com.instabug.library.util.Colorizer.getPrimaryColorTintedDrawable(r0);	 Catch:{ ParseException -> 0x0288 }
        r2 = r9.f9326i;	 Catch:{ ParseException -> 0x0288 }
        r2.setBackgroundDrawable(r0);	 Catch:{ ParseException -> 0x0288 }
        r0 = r9.f9325h;	 Catch:{ ParseException -> 0x0288 }
        r2 = r6.f9332c;	 Catch:{ ParseException -> 0x0288 }
        r0.setColorFilter(r2);	 Catch:{ ParseException -> 0x0288 }
    L_0x00f2:
        r0 = r9.f9319b;	 Catch:{ ParseException -> 0x0288 }
        r4 = r7.f9277c;	 Catch:{ ParseException -> 0x0288 }
        r2 = com.instabug.library.util.InstabugDateFormatter.formatMessageDate(r4);	 Catch:{ ParseException -> 0x0288 }
        r0.setText(r2);	 Catch:{ ParseException -> 0x0288 }
        r0 = r7.f9279e;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x0148;
    L_0x0101:
        r0 = "Video path not found but main screenshot found, using it";
        com.instabug.library.util.InstabugSDKLogger.m8356d(r6, r0);	 Catch:{ ParseException -> 0x0288 }
        r0 = new java.lang.StringBuilder;	 Catch:{ ParseException -> 0x0288 }
        r2 = "Video Encoded: ";
        r0.<init>(r2);	 Catch:{ ParseException -> 0x0288 }
        r2 = r7.f9283i;	 Catch:{ ParseException -> 0x0288 }
        r0.append(r2);	 Catch:{ ParseException -> 0x0288 }
        r0 = r0.toString();	 Catch:{ ParseException -> 0x0288 }
        com.instabug.library.util.InstabugSDKLogger.m8356d(r6, r0);	 Catch:{ ParseException -> 0x0288 }
        r0 = r7.f9283i;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x0131;
    L_0x011d:
        r0 = r9.f9328k;	 Catch:{ ParseException -> 0x0288 }
        r0.setVisibility(r3);	 Catch:{ ParseException -> 0x0288 }
        r0 = r9.f9325h;	 Catch:{ ParseException -> 0x0288 }
        r0.setVisibility(r1);	 Catch:{ ParseException -> 0x0288 }
        r0 = r9.f9327j;	 Catch:{ ParseException -> 0x0288 }
        r2 = new com.instabug.chat.ui.b.f$5;	 Catch:{ ParseException -> 0x0288 }
        r2.<init>(r6, r7);	 Catch:{ ParseException -> 0x0288 }
        r0.setOnClickListener(r2);	 Catch:{ ParseException -> 0x0288 }
    L_0x0131:
        r0 = r7.f9279e;	 Catch:{ RuntimeException -> 0x013f }
        r0 = com.instabug.library.util.VideoManipulationUtils.extractFirstVideoFrame(r0);	 Catch:{ RuntimeException -> 0x013f }
        if (r0 == 0) goto L_0x015c;
    L_0x0139:
        r2 = r9.f9326i;	 Catch:{ RuntimeException -> 0x013f }
        r2.setImageBitmap(r0);	 Catch:{ RuntimeException -> 0x013f }
        goto L_0x015c;
    L_0x013f:
        r0 = move-exception;
        r2 = r0.getMessage();	 Catch:{ ParseException -> 0x0288 }
        com.instabug.library.util.InstabugSDKLogger.m8358e(r6, r2, r0);	 Catch:{ ParseException -> 0x0288 }
        goto L_0x015c;
    L_0x0148:
        r0 = r6.f9333d;	 Catch:{ ParseException -> 0x0288 }
        r2 = r7.f9278d;	 Catch:{ ParseException -> 0x0288 }
        r3 = com.instabug.library.model.AssetEntity.AssetType.VIDEO;	 Catch:{ ParseException -> 0x0288 }
        r0 = com.instabug.library.internal.storage.cache.AssetsCacheManager.createEmptyEntity(r0, r2, r3);	 Catch:{ ParseException -> 0x0288 }
        r2 = r6.f9333d;	 Catch:{ ParseException -> 0x0288 }
        r3 = new com.instabug.chat.ui.b.f$6;	 Catch:{ ParseException -> 0x0288 }
        r3.<init>(r6, r9);	 Catch:{ ParseException -> 0x0288 }
        com.instabug.library.internal.storage.cache.AssetsCacheManager.getAssetEntity(r2, r0, r3);	 Catch:{ ParseException -> 0x0288 }
    L_0x015c:
        r0 = r9.f9318a;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x028c;
    L_0x0160:
        r0 = r7.f9278d;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x028c;
    L_0x0164:
        r7 = r7.f9278d;	 Catch:{ ParseException -> 0x0288 }
        r9 = r9.f9318a;	 Catch:{ ParseException -> 0x0288 }
        r6.m7977a(r7, r9, r1);	 Catch:{ ParseException -> 0x0288 }
        goto L_0x028c;
    L_0x016d:
        r0 = new java.lang.StringBuilder;	 Catch:{ ParseException -> 0x0288 }
        r4 = "viewholder: ";
        r0.<init>(r4);	 Catch:{ ParseException -> 0x0288 }
        if (r9 != 0) goto L_0x0177;
    L_0x0176:
        goto L_0x0178;
    L_0x0177:
        r2 = r1;
    L_0x0178:
        r0.append(r2);	 Catch:{ ParseException -> 0x0288 }
        r2 = ", type:";
        r0.append(r2);	 Catch:{ ParseException -> 0x0288 }
        r2 = r7.f9280f;	 Catch:{ ParseException -> 0x0288 }
        r0.append(r2);	 Catch:{ ParseException -> 0x0288 }
        r0 = r0.toString();	 Catch:{ ParseException -> 0x0288 }
        com.instabug.library.util.InstabugSDKLogger.m8357e(r6, r0);	 Catch:{ ParseException -> 0x0288 }
        r0 = r7.f9282h;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x01a6;
    L_0x0190:
        r0 = r9.f9322e;	 Catch:{ ParseException -> 0x0288 }
        r0 = r0.getBackground();	 Catch:{ ParseException -> 0x0288 }
        r0 = com.instabug.library.util.Colorizer.getPrimaryColorTintedDrawable(r0);	 Catch:{ ParseException -> 0x0288 }
        r2 = r9.f9322e;	 Catch:{ ParseException -> 0x0288 }
        r2.setBackgroundDrawable(r0);	 Catch:{ ParseException -> 0x0288 }
        r0 = r9.f9323f;	 Catch:{ ParseException -> 0x0288 }
        r2 = r6.f9332c;	 Catch:{ ParseException -> 0x0288 }
        r0.setColorFilter(r2);	 Catch:{ ParseException -> 0x0288 }
    L_0x01a6:
        r0 = r9.f9319b;	 Catch:{ ParseException -> 0x0288 }
        r4 = r7.f9277c;	 Catch:{ ParseException -> 0x0288 }
        r2 = com.instabug.library.util.InstabugDateFormatter.formatMessageDate(r4);	 Catch:{ ParseException -> 0x0288 }
        r0.setText(r2);	 Catch:{ ParseException -> 0x0288 }
        r0 = r7.f9278d;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x01b8;
    L_0x01b5:
        r0 = r7.f9278d;	 Catch:{ ParseException -> 0x0288 }
        goto L_0x01ba;
    L_0x01b8:
        r0 = r7.f9279e;	 Catch:{ ParseException -> 0x0288 }
    L_0x01ba:
        r2 = r9.f9324g;	 Catch:{ ParseException -> 0x0288 }
        if (r2 == 0) goto L_0x01cb;
    L_0x01be:
        r2 = r9.f9324g;	 Catch:{ ParseException -> 0x0288 }
        r2 = r2.getVisibility();	 Catch:{ ParseException -> 0x0288 }
        if (r2 != 0) goto L_0x01cb;
    L_0x01c6:
        r2 = r9.f9324g;	 Catch:{ ParseException -> 0x0288 }
        r2.setVisibility(r3);	 Catch:{ ParseException -> 0x0288 }
    L_0x01cb:
        r2 = r9.f9323f;	 Catch:{ ParseException -> 0x0288 }
        r2 = r2.getVisibility();	 Catch:{ ParseException -> 0x0288 }
        if (r2 != r3) goto L_0x01d8;
    L_0x01d3:
        r2 = r9.f9323f;	 Catch:{ ParseException -> 0x0288 }
        r2.setVisibility(r1);	 Catch:{ ParseException -> 0x0288 }
    L_0x01d8:
        r2 = r9.f9322e;	 Catch:{ ParseException -> 0x0288 }
        r3 = new com.instabug.chat.ui.b.f$3;	 Catch:{ ParseException -> 0x0288 }
        r3.<init>(r6, r7, r0, r9);	 Catch:{ ParseException -> 0x0288 }
        r2.setOnClickListener(r3);	 Catch:{ ParseException -> 0x0288 }
        r2 = r6.f9331b;	 Catch:{ ParseException -> 0x0288 }
        r3 = new com.instabug.chat.ui.b.f$4;	 Catch:{ ParseException -> 0x0288 }
        r3.<init>(r6, r0, r7, r9);	 Catch:{ ParseException -> 0x0288 }
        r2.addOnStopListener(r3);	 Catch:{ ParseException -> 0x0288 }
        r0 = r9.f9318a;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x028c;
    L_0x01f0:
        r0 = r7.f9276b;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x028c;
    L_0x01f4:
        r7 = r7.f9276b;	 Catch:{ ParseException -> 0x0288 }
        r9 = r9.f9318a;	 Catch:{ ParseException -> 0x0288 }
        r6.m7977a(r7, r9, r1);	 Catch:{ ParseException -> 0x0288 }
        goto L_0x028c;
    L_0x01fd:
        r0 = r7.f9282h;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x0210;
    L_0x0201:
        r0 = r9.f9321d;	 Catch:{ ParseException -> 0x0288 }
        r0 = r0.getBackground();	 Catch:{ ParseException -> 0x0288 }
        r0 = com.instabug.library.util.Colorizer.getPrimaryColorTintedDrawable(r0);	 Catch:{ ParseException -> 0x0288 }
        r3 = r9.f9321d;	 Catch:{ ParseException -> 0x0288 }
        r3.setBackgroundDrawable(r0);	 Catch:{ ParseException -> 0x0288 }
    L_0x0210:
        r0 = r9.f9319b;	 Catch:{ ParseException -> 0x0288 }
        r3 = r7.f9277c;	 Catch:{ ParseException -> 0x0288 }
        r3 = com.instabug.library.util.InstabugDateFormatter.formatMessageDate(r3);	 Catch:{ ParseException -> 0x0288 }
        r0.setText(r3);	 Catch:{ ParseException -> 0x0288 }
        r0 = r7.f9279e;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x0227;
    L_0x021f:
        r0 = r7.f9279e;	 Catch:{ ParseException -> 0x0288 }
        r2 = r9.f9321d;	 Catch:{ ParseException -> 0x0288 }
        com.instabug.library.util.BitmapUtils.loadBitmap(r0, r2);	 Catch:{ ParseException -> 0x0288 }
        goto L_0x022e;
    L_0x0227:
        r0 = r7.f9278d;	 Catch:{ ParseException -> 0x0288 }
        r3 = r9.f9321d;	 Catch:{ ParseException -> 0x0288 }
        r6.m7977a(r0, r3, r2);	 Catch:{ ParseException -> 0x0288 }
    L_0x022e:
        r0 = r9.f9321d;	 Catch:{ ParseException -> 0x0288 }
        r2 = new com.instabug.chat.ui.b.f$2;	 Catch:{ ParseException -> 0x0288 }
        r2.<init>(r6, r7);	 Catch:{ ParseException -> 0x0288 }
        r0.setOnClickListener(r2);	 Catch:{ ParseException -> 0x0288 }
        r0 = r9.f9318a;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x028c;
    L_0x023c:
        r0 = r7.f9276b;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x028c;
    L_0x0240:
        r7 = r7.f9276b;	 Catch:{ ParseException -> 0x0288 }
        r9 = r9.f9318a;	 Catch:{ ParseException -> 0x0288 }
        r6.m7977a(r7, r9, r1);	 Catch:{ ParseException -> 0x0288 }
        goto L_0x028c;
    L_0x0248:
        r0 = r7.f9282h;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x025c;
    L_0x024c:
        r0 = r9.f9320c;	 Catch:{ ParseException -> 0x0288 }
        r0 = r0.getBackground();	 Catch:{ ParseException -> 0x0288 }
        r0 = com.instabug.library.util.Colorizer.getPrimaryColorTintedDrawable(r0);	 Catch:{ ParseException -> 0x0288 }
        r2 = r9.f9320c;	 Catch:{ ParseException -> 0x0288 }
        r2.setBackgroundDrawable(r0);	 Catch:{ ParseException -> 0x0288 }
        goto L_0x026a;
    L_0x025c:
        r0 = r9.f9329l;	 Catch:{ ParseException -> 0x0288 }
        r0.removeAllViews();	 Catch:{ ParseException -> 0x0288 }
        r0 = r7.m7927a();	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x026a;
    L_0x0267:
        r6.m7976a(r7, r9);	 Catch:{ ParseException -> 0x0288 }
    L_0x026a:
        r0 = r9.f9319b;	 Catch:{ ParseException -> 0x0288 }
        r2 = r7.f9277c;	 Catch:{ ParseException -> 0x0288 }
        r2 = com.instabug.library.util.InstabugDateFormatter.formatMessageDate(r2);	 Catch:{ ParseException -> 0x0288 }
        r0.setText(r2);	 Catch:{ ParseException -> 0x0288 }
        r0 = r9.f9320c;	 Catch:{ ParseException -> 0x0288 }
        r2 = r7.f9275a;	 Catch:{ ParseException -> 0x0288 }
        r0.setText(r2);	 Catch:{ ParseException -> 0x0288 }
        r0 = r9.f9318a;	 Catch:{ ParseException -> 0x0288 }
        if (r0 == 0) goto L_0x028c;
    L_0x0280:
        r7 = r7.f9276b;	 Catch:{ ParseException -> 0x0288 }
        r9 = r9.f9318a;	 Catch:{ ParseException -> 0x0288 }
        r6.m7977a(r7, r9, r1);	 Catch:{ ParseException -> 0x0288 }
        goto L_0x028c;
    L_0x0288:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x028c:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.chat.ui.b.f.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    private void m7976a(C0550a c0550a, C0572b c0572b) {
        StringBuilder stringBuilder = new StringBuilder("Binding MessageActions view  FlatMessage = ");
        stringBuilder.append(c0550a.toString());
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        c0550a = c0550a.f9284j;
        if (c0550a != null && c0550a.size() > 0) {
            for (int i = 0; i < c0550a.size(); i++) {
                final C1308b c1308b = (C1308b) c0550a.get(i);
                View button = new Button(this.f9333d);
                button.setLayoutParams(new LayoutParams(-2, -2));
                button.setText(c1308b.f15389a);
                button.setTextColor(ContextCompat.m719c(this.f9333d, 17170443));
                button.setBackgroundColor(InstabugCore.getPrimaryColor());
                button.setMaxEms(30);
                button.setMaxLines(1);
                button.setId(i);
                button.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ C0573f f9306b;

                    public void onClick(View view) {
                        this.f9306b.f9335f.mo4337d(c1308b.f15390b);
                    }
                });
                c0572b.f9329l.addView(button);
            }
        }
    }

    private void m7977a(String str, final ImageView imageView, final boolean z) {
        AssetsCacheManager.getAssetEntity(this.f9333d, AssetsCacheManager.createEmptyEntity(this.f9333d, str, AssetType.IMAGE), new OnDownloadFinished(this) {
            final /* synthetic */ C0573f f15414c;

            public void onSuccess(AssetEntity assetEntity) {
                StringBuilder stringBuilder = new StringBuilder("Asset Entity downloaded: ");
                stringBuilder.append(assetEntity.getFile().getPath());
                InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                try {
                    imageView.setImageBitmap(BitmapFactory.decodeStream(new FileInputStream(assetEntity.getFile())));
                    if (!(z == null || this.f15414c.f9336g == null)) {
                        this.f15414c.f9334e.setSelection(this.f15414c.getCount() - 1);
                        this.f15414c.f9336g = false;
                    }
                } catch (AssetEntity assetEntity2) {
                    InstabugSDKLogger.m8358e(this, "Asset Entity downloading got FileNotFoundException error", assetEntity2);
                }
            }

            public void onFailed(Throwable th) {
                InstabugSDKLogger.m8358e(this, "Asset Entity downloading got error", th);
            }
        });
    }
}
