package com.instabug.bug.view;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Editable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.instabug.bug.C0465R;
import com.instabug.bug.C0474d;
import com.instabug.bug.extendedbugreport.ExtendedBugReport;
import com.instabug.bug.model.C0478b;
import com.instabug.bug.p000a.C0466a;
import com.instabug.bug.p001b.C0468b;
import com.instabug.bug.settings.C0485a;
import com.instabug.bug.view.C0498a.C0492a;
import com.instabug.bug.view.C0514d.C1289a;
import com.instabug.bug.view.C0514d.C1290b;
import com.instabug.bug.view.p002a.C1728b;
import com.instabug.bug.view.p004c.C1729b;
import com.instabug.library.C0593R;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.FragmentVisibilityChangedListener;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.ScreenRecordingEventBus;
import com.instabug.library.core.ui.ToolbarFragment;
import com.instabug.library.internal.media.AudioPlayer;
import com.instabug.library.internal.media.AudioPlayer.OnStopListener;
import com.instabug.library.internal.video.ScreenRecordEvent;
import com.instabug.library.internal.video.VideoPlayerFragment;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.Attachment.Type;
import com.instabug.library.util.AttrResolver;
import com.instabug.library.util.Colorizer;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.PlaceHolderUtils;
import com.instabug.library.util.SystemServiceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: BugReportingFragment */
public class C1730c extends ToolbarFragment<C1289a> implements OnClickListener, C0492a, C1290b {
    private EditText f19735a;
    private EditText f19736b;
    private TextView f19737c;
    private GridView f19738d;
    private ImageView f19739e;
    private AudioPlayer f19740f;
    private String f19741g;
    private String f19742h;
    private C0478b f19743i;
    private boolean f19744j;
    private BroadcastReceiver f19745k;
    private List<View> f19746l;
    private ProgressDialog f19747m;
    private C0498a f19748n;
    private Subscription f19749o;
    private C0510a f19750p;

    /* compiled from: BugReportingFragment */
    class C05073 implements DialogInterface.OnClickListener {
        final /* synthetic */ C1730c f9190a;

        public void onClick(DialogInterface dialogInterface, int i) {
        }

        C05073(C1730c c1730c) {
            this.f9190a = c1730c;
        }
    }

    /* compiled from: BugReportingFragment */
    class C05085 extends BroadcastReceiver {
        final /* synthetic */ C1730c f9191a;

        C05085(C1730c c1730c) {
            this.f9191a = c1730c;
        }

        public void onReceive(Context context, Intent intent) {
            InstabugSDKLogger.m8359i(this, "Refreshing Attachments");
            if (this.f9191a.getActivity() != null) {
                ((C1289a) this.f9191a.presenter).mo3640c();
            }
        }
    }

    /* compiled from: BugReportingFragment */
    public interface C0510a {
        void mo4432e();
    }

    /* compiled from: BugReportingFragment */
    class C12821 extends C0466a {
        final /* synthetic */ C1730c f15341a;

        C12821(C1730c c1730c) {
            this.f15341a = c1730c;
        }

        public void afterTextChanged(Editable editable) {
            ((C1289a) this.f15341a.presenter).mo3635a(this.f15341a.f19735a.getText().toString());
        }
    }

    /* compiled from: BugReportingFragment */
    class C12832 extends C0466a {
        final /* synthetic */ C1730c f15342a;

        C12832(C1730c c1730c) {
            this.f15342a = c1730c;
        }

        public void afterTextChanged(Editable editable) {
            if (this.f15342a.getActivity() != null) {
                ((C1289a) this.f15342a.presenter).mo3638b(this.f15342a.f19736b.getText().toString());
            }
        }
    }

    /* compiled from: BugReportingFragment */
    class C12856 implements Action1<ScreenRecordEvent> {
        final /* synthetic */ C1730c f15344a;

        C12856(C1730c c1730c) {
            this.f15344a = c1730c;
        }

        public final /* synthetic */ void m15229a(Object obj) {
            final ScreenRecordEvent screenRecordEvent = (ScreenRecordEvent) obj;
            this.f15344a.getActivity().runOnUiThread(new Runnable(this) {
                final /* synthetic */ C12856 f9193b;

                public void run() {
                    if (screenRecordEvent.getStatus() == 1) {
                        C1730c.m21295a(this.f9193b.f15344a, screenRecordEvent);
                        return;
                    }
                    if (screenRecordEvent.getStatus() == 2) {
                        this.f9193b.f15344a.m21310k();
                    }
                }
            });
        }
    }

    protected void onCloseButtonClicked() {
    }

    public static Fragment m21292a(C0478b c0478b, String str, String str2) {
        Fragment c1730c = new C1730c();
        Bundle bundle = new Bundle();
        bundle.putSerializable("bug_type", c0478b);
        bundle.putString("bug_message", str);
        bundle.putString("bug_message_hint", str2);
        c1730c.setArguments(bundle);
        return c1730c;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19745k = new C05085(this);
        if (this.f19749o == null) {
            this.f19749o = ScreenRecordingEventBus.getInstance().subscribe(new C12856(this));
        }
        this.f19743i = (C0478b) getArguments().getSerializable("bug_type");
        this.f19741g = getArguments().getString("bug_message");
        this.f19742h = getArguments().getString("bug_message_hint");
        if (this.presenter == null) {
            this.presenter = new C1630e(this);
        }
    }

    public void onAttach(android.content.Context r3) {
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
        super.onAttach(r3);
        r3 = (com.instabug.bug.view.C1730c.C0510a) r3;	 Catch:{ ClassCastException -> 0x0008 }
        r2.f19750p = r3;	 Catch:{ ClassCastException -> 0x0008 }
        return;
    L_0x0008:
        r3 = new java.lang.ClassCastException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r2.getActivity();
        r1 = r1.toString();
        r0.append(r1);
        r1 = " must implement InstabugSuccessFragment.OnImageEditingListener";
        r0.append(r1);
        r0 = r0.toString();
        r3.<init>(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.view.c.onAttach(android.content.Context):void");
    }

    public void onDetach() {
        super.onDetach();
        this.f19750p = null;
    }

    protected int getContentLayout() {
        return C0465R.layout.instabug_lyt_feedback;
    }

    private void m21294a(View view) {
        for (View view2 : this.f19746l) {
            ViewGroup viewGroup = (ViewGroup) view2;
            viewGroup.getChildAt(1).setVisibility(8);
            ((TextView) viewGroup.getChildAt(0)).setTextColor(AttrResolver.getTintingColor(getContext()));
            view2.setTag(Boolean.valueOf(false));
        }
        ViewGroup viewGroup2 = (ViewGroup) view;
        View view22 = viewGroup2.getChildAt(1);
        View childAt = viewGroup2.getChildAt(0);
        view22.setVisibility(0);
        ((TextView) view22).setTextColor(Instabug.getPrimaryColor());
        ((TextView) childAt).setTextColor(Instabug.getPrimaryColor());
        view.setTag(Boolean.valueOf(true));
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getActivity().getWindow().setSoftInputMode(16);
    }

    public void onStart() {
        super.onStart();
        ((C1289a) this.presenter).mo3632a();
        LocalBroadcastManager.m744a(getActivity()).m747a(this.f19745k, new IntentFilter("refresh.attachments"));
        ((C1289a) this.presenter).mo3640c();
    }

    public void onStop() {
        super.onStop();
        ((C1289a) this.presenter).mo3637b();
        LocalBroadcastManager.m744a(getActivity()).m746a(this.f19745k);
        if (!this.f19749o.d()) {
            this.f19749o.c();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        if (this.f19740f != null) {
            this.f19740f.release();
        }
        super.onPause();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ((C1289a) this.presenter).mo3633a(i, i2, intent);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    protected String getTitle() {
        if (this.f19743i == C0478b.BUG) {
            return PlaceHolderUtils.getPlaceHolder(Key.BUG_REPORT_HEADER, getString(C0465R.string.instabug_str_bug_header));
        }
        return PlaceHolderUtils.getPlaceHolder(Key.FEEDBACK_REPORT_HEADER, getString(C0465R.string.instabug_str_feedback_header));
    }

    protected void onDoneButtonClicked() {
        ((C1289a) this.presenter).mo3644g();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == C0465R.id.instabug_attach_screenshot) {
            if (view.getTag() != null) {
                if (!view.getTag().equals(Boolean.valueOf(false))) {
                    if (C0474d.m7762a().f9100a.m15213a() < 4) {
                        ((C1289a) this.presenter).mo3642e();
                        return;
                    } else {
                        m21305g();
                        return;
                    }
                }
            }
            m21294a(view);
        } else if (id == C0465R.id.instabug_attach_gallery_image) {
            if (view.getTag() != null) {
                if (!view.getTag().equals(Boolean.valueOf(false))) {
                    if (C0474d.m7762a().f9100a.m15213a() < 4) {
                        ((C1289a) this.presenter).mo3643f();
                        return;
                    } else {
                        m21305g();
                        return;
                    }
                }
            }
            m21294a(view);
        } else {
            if (id == C0465R.id.instabug_attach_video) {
                if (view.getTag() != null) {
                    if (!view.getTag().equals(Boolean.valueOf(false))) {
                        if (C0474d.m7762a().f9100a.m15213a() < 4) {
                            C0468b.m7745a();
                            if (C0468b.m7751b() != null) {
                                Toast.makeText(getContext(), C0465R.string.instabug_str_video_encoder_busy, 0).show();
                                return;
                            } else if (ContextCompat.m713a(getActivity(), "android.permission.RECORD_AUDIO") != null) {
                                requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 177);
                                return;
                            } else {
                                ((C1289a) this.presenter).mo3641d();
                                return;
                            }
                        }
                        m21305g();
                    }
                }
                m21294a(view);
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr.length <= 0 || iArr[0] != 0) {
            if (i == 177) {
                ((C1289a) this.presenter).mo3641d();
            }
        } else if (i == 177) {
            ((C1289a) this.presenter).mo3641d();
        } else if (i != 3873) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        } else {
            mo4324d();
            C0474d.m7762a().m7769b();
        }
    }

    private void m21305g() {
        Builder builder = new Builder(getContext());
        builder.setTitle(C0465R.string.instabug_str_alert_title_max_attachments);
        builder.setMessage(C0465R.string.instabug_str_alert_message_max_attachments);
        builder.setPositiveButton(C0465R.string.instabug_str_ok, new C05073(this));
        builder.show();
    }

    private void m21298b(View view, Attachment attachment) {
        StringBuilder stringBuilder = new StringBuilder("start audio player ");
        stringBuilder.append(attachment.getLocalPath());
        stringBuilder.append(" view = ");
        stringBuilder.append(view.getId());
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        this.f19739e = (ImageView) view.findViewById(C0465R.id.instabug_btn_audio_play_attachment);
        this.f19739e.setImageResource(C0465R.drawable.instabug_ic_stop);
        this.f19740f = new AudioPlayer();
        this.f19740f.start(attachment.getLocalPath());
        this.f19740f.addOnStopListener(new OnStopListener(this, attachment.getLocalPath()) {
            final /* synthetic */ C1730c f15343a;

            public void onStop() {
                this.f15343a.m21307h();
            }
        });
    }

    private void m21307h() {
        this.f19739e.setImageResource(C0465R.drawable.instabug_ic_play);
        this.f19740f.release();
        this.f19740f = null;
    }

    public final void mo4320a(List<Attachment> list) {
        this.f19748n.f9172a.clear();
        for (Attachment attachment : list) {
            if (attachment.getType().equals(Type.MAIN_SCREENSHOT) || attachment.getType().equals(Type.IMAGE) || attachment.getType().equals(Type.AUDIO) || attachment.getType().equals(Type.VIDEO)) {
                this.f19748n.f9172a.add(attachment);
            }
            if (attachment.getType().equals(Type.VIDEO)) {
                C0474d.m7762a().f9100a.setHasVideo(true);
            }
        }
        this.f19738d.setAdapter(this.f19748n);
        this.f19748n.notifyDataSetChanged();
        if (InstabugCore.getFeatureState(Feature.MULTIPLE_ATTACHMENTS) == State.ENABLED) {
            C0485a.m7793a();
            if (C0485a.m7814e() != null) {
                findViewById(C0465R.id.HorizontalScrollActionBar).setVisibility(0);
                return;
            }
        }
        findViewById(C0465R.id.HorizontalScrollActionBar).setVisibility(8);
    }

    private boolean m21308i() {
        return this.f19748n.f9173b != null && this.f19748n.f9173b.getVisibility() == 0;
    }

    private boolean m21309j() {
        return this.f19748n.f9174c != null && this.f19748n.f9174c.getVisibility() == 0;
    }

    private void m21296a(boolean z) {
        if (z) {
            this.f19748n.f9173b.setVisibility(0);
        } else {
            this.f19748n.f9173b.setVisibility(8);
        }
    }

    private void m21299b(boolean z) {
        if (z) {
            this.f19748n.f9174c.setVisibility(0);
        } else {
            this.f19748n.f9174c.setVisibility(8);
        }
    }

    public final void mo4316a() {
        if (getFragmentManager().mo216a(C0465R.id.instabug_fragment_container) instanceof FragmentVisibilityChangedListener) {
            ((FragmentVisibilityChangedListener) getFragmentManager().mo216a(C0465R.id.instabug_fragment_container)).onVisibilityChanged(false);
        }
    }

    private void m21301c(String str) {
        if (str != null) {
            getFragmentManager().mo219a().mo195a(C0465R.id.instabug_fragment_container, VideoPlayerFragment.newInstance(str), "video_player").mo198a("play video").mo203c();
            return;
        }
        if (m21308i() == null) {
            m21296a(true);
        }
        if (m21309j() != null) {
            m21299b((boolean) null);
        }
    }

    public final void mo4321b() {
        C0485a.m7793a();
        if (C0485a.m7822m()) {
            finishActivity();
            getActivity().startActivity(SuccessActivity.m21610a(getContext()));
            return;
        }
        if (this.f19750p != null) {
            this.f19750p.mo4432e();
        }
    }

    public final void mo4323c() {
        getFragmentManager().mo219a().mo194a(C0465R.id.instabug_fragment_container, C1729b.m21289a(getTitle())).mo198a("ExtraFieldsFragment").mo203c();
    }

    public final void mo4324d() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.putExtra("android.intent.extra.LOCAL_ONLY", true);
        intent.setType("image/*");
        startActivityForResult(intent, 3862);
    }

    public final void mo4325e() {
        if (this.f19747m == null) {
            this.f19747m = new ProgressDialog(getActivity());
            this.f19747m.setCancelable(false);
            this.f19747m.setMessage(getResources().getString(C0465R.string.instabug_str_dialog_message_preparing));
            this.f19747m.show();
        } else if (!this.f19747m.isShowing()) {
            this.f19747m.show();
        }
    }

    public final void mo4326f() {
        if (this.f19747m != null && this.f19747m.isShowing()) {
            this.f19747m.dismiss();
        }
    }

    public final void mo4318a(Attachment attachment) {
        this.f19748n.f9172a.remove(attachment);
        this.f19748n.notifyDataSetChanged();
    }

    public final void mo4319a(String str) {
        this.f19735a.requestFocus();
        this.f19735a.setError(str);
    }

    public final void mo4322b(String str) {
        this.f19736b.requestFocus();
        this.f19736b.setError(str);
    }

    private void m21310k() {
        Attachment a = ((C1289a) this.presenter).mo3631a(C0474d.m7762a().f9100a.f15314e);
        if (a != null) {
            ((C1289a) this.presenter).mo3634a(a);
        }
        ((C1289a) this.presenter).mo3640c();
    }

    public void onDestroy() {
        super.onDestroy();
        if (!this.f19749o.d()) {
            this.f19749o.c();
        }
    }

    protected void initContentViews(View view, Bundle bundle) {
        this.f19746l = new ArrayList();
        ((TextView) findViewById(C0465R.id.instabug_attach_gallery_image_label)).setText(PlaceHolderUtils.getPlaceHolder(Key.ADD_IMAGE_FROM_GALLERY, getString(C0465R.string.instabug_str_add_photo)));
        ((TextView) findViewById(C0465R.id.instabug_attach_screenshot_label)).setText(PlaceHolderUtils.getPlaceHolder(Key.ADD_EXTRA_SCREENSHOT, getString(C0465R.string.instabug_str_take_screenshot)));
        ((TextView) findViewById(C0465R.id.instabug_attach_video_label)).setText(PlaceHolderUtils.getPlaceHolder(Key.ADD_VIDEO, getString(C0465R.string.instabug_str_record_video)));
        C0485a.m7793a();
        if (C0485a.m7811d().isAllowScreenRecording() != null) {
            findViewById(C0465R.id.instabug_attach_video).setOnClickListener(this);
            this.f19746l.add(findViewById(C0465R.id.instabug_attach_video));
        } else {
            findViewById(C0465R.id.instabug_attach_video).setVisibility(8);
        }
        C0485a.m7793a();
        if (C0485a.m7811d().isAllowTakeExtraScreenshot() != null) {
            findViewById(C0465R.id.instabug_attach_screenshot).setOnClickListener(this);
            this.f19746l.add(findViewById(C0465R.id.instabug_attach_screenshot));
        } else {
            findViewById(C0465R.id.instabug_attach_screenshot).setVisibility(8);
        }
        C0485a.m7793a();
        if (C0485a.m7811d().isAllowAttachImageFromGallery() != null) {
            findViewById(C0465R.id.instabug_attach_gallery_image).setOnClickListener(this);
            this.f19746l.add(findViewById(C0465R.id.instabug_attach_gallery_image));
        } else {
            findViewById(C0465R.id.instabug_attach_gallery_image).setVisibility(8);
        }
        if (this.f19746l.size() > null) {
            m21294a((View) this.f19746l.get(0));
        }
        C0485a.m7793a();
        if (C0485a.m7825p().isEmpty() != null) {
            C0485a.m7793a();
            if (C0485a.m7826q() == ExtendedBugReport.State.DISABLED) {
                view = null;
                if (view != null) {
                    this.toolbarImageButtonDone.setImageDrawable(ContextCompat.m714a(getContext(), C0593R.drawable.instabug_ic_send));
                    this.toolbarImageButtonDone.setColorFilter(Colorizer.getPrimaryColorFilter());
                } else {
                    this.toolbarImageButtonDone.setImageDrawable(ContextCompat.m714a(getContext(), C0465R.drawable.instabug_ic_next));
                }
                this.f19738d = (GridView) findViewById(C0465R.id.instabug_lyt_attachments_grid);
                this.f19748n = new C0498a(getActivity(), this);
                this.f19735a = (EditText) findViewById(C0465R.id.instabug_edit_text_email);
                this.f19735a.setHint(PlaceHolderUtils.getPlaceHolder(Key.EMAIL_FIELD_HINT, getString(C0465R.string.instabug_str_email_hint)));
                this.f19735a.addTextChangedListener(new C12821(this));
                this.f19736b = (EditText) findViewById(C0465R.id.instabug_edit_text_message);
                this.f19736b.addTextChangedListener(new C12832(this));
                this.f19737c = (TextView) findViewById(C0465R.id.instabug_text_view_disclaimer);
                if (VERSION.SDK_INT < 11) {
                    this.f19736b.setBackgroundResource(C0465R.drawable.instabug_bg_edit_text);
                    this.f19735a.setBackgroundResource(C0465R.drawable.instabug_bg_edit_text);
                }
                C0485a.m7793a();
                if (C0485a.m7818i() == null) {
                    this.f19735a.setVisibility(8);
                    this.f19736b.setGravity(16);
                }
                if (this.f19742h != null) {
                    this.f19736b.setHint(this.f19742h);
                }
                if (this.f19741g != null) {
                    this.f19736b.setText(this.f19741g);
                }
                view = C0474d.m7762a().f9100a.getState();
                if (view != null) {
                    view = view.getUserEmail();
                    if (!(view == null || view.isEmpty())) {
                        this.f19735a.setText(view);
                    }
                }
                C0485a.m7793a();
                view = C0485a.m7823n();
                if (view == null && !view.isEmpty() && InstabugCore.getFeatureState(Feature.DISCLAIMER) == State.ENABLED) {
                    view = ((C1289a) this.presenter).mo3639c(view);
                    if (VERSION.SDK_INT >= 24) {
                        view = Html.fromHtml(view, 0);
                    } else {
                        view = Html.fromHtml(view);
                    }
                    this.f19737c.setText(view);
                    this.f19737c.setMovementMethod(LinkMovementMethod.getInstance());
                    return;
                }
                this.f19737c.setVisibility(8);
            }
        }
        view = true;
        if (view != null) {
            this.toolbarImageButtonDone.setImageDrawable(ContextCompat.m714a(getContext(), C0465R.drawable.instabug_ic_next));
        } else {
            this.toolbarImageButtonDone.setImageDrawable(ContextCompat.m714a(getContext(), C0593R.drawable.instabug_ic_send));
            this.toolbarImageButtonDone.setColorFilter(Colorizer.getPrimaryColorFilter());
        }
        this.f19738d = (GridView) findViewById(C0465R.id.instabug_lyt_attachments_grid);
        this.f19748n = new C0498a(getActivity(), this);
        this.f19735a = (EditText) findViewById(C0465R.id.instabug_edit_text_email);
        this.f19735a.setHint(PlaceHolderUtils.getPlaceHolder(Key.EMAIL_FIELD_HINT, getString(C0465R.string.instabug_str_email_hint)));
        this.f19735a.addTextChangedListener(new C12821(this));
        this.f19736b = (EditText) findViewById(C0465R.id.instabug_edit_text_message);
        this.f19736b.addTextChangedListener(new C12832(this));
        this.f19737c = (TextView) findViewById(C0465R.id.instabug_text_view_disclaimer);
        if (VERSION.SDK_INT < 11) {
            this.f19736b.setBackgroundResource(C0465R.drawable.instabug_bg_edit_text);
            this.f19735a.setBackgroundResource(C0465R.drawable.instabug_bg_edit_text);
        }
        C0485a.m7793a();
        if (C0485a.m7818i() == null) {
            this.f19735a.setVisibility(8);
            this.f19736b.setGravity(16);
        }
        if (this.f19742h != null) {
            this.f19736b.setHint(this.f19742h);
        }
        if (this.f19741g != null) {
            this.f19736b.setText(this.f19741g);
        }
        view = C0474d.m7762a().f9100a.getState();
        if (view != null) {
            view = view.getUserEmail();
            this.f19735a.setText(view);
        }
        C0485a.m7793a();
        view = C0485a.m7823n();
        if (view == null) {
        }
        this.f19737c.setVisibility(8);
    }

    public final void mo4317a(View view, Attachment attachment) {
        this.f19735a.clearFocus();
        this.f19735a.setError(null);
        this.f19736b.clearFocus();
        this.f19736b.setError(null);
        int id = view.getId();
        if (id == C0465R.id.instabug_grid_img_item) {
            SystemServiceUtils.hideInputMethod(getActivity());
            view = getTitle();
            mo4316a();
            getFragmentManager().mo219a().mo195a(C0465R.id.instabug_fragment_container, C1728b.m21285a(view, Uri.fromFile(new File(attachment.getLocalPath())), 1), "annotation").mo198a("annotation").mo203c();
            return;
        }
        if (id == C0465R.id.instabug_grid_audio_item) {
            if (this.f19740f != null) {
                m21307h();
                if (this.f19739e != view.findViewById(C0465R.id.instabug_btn_audio_play_attachment)) {
                    m21298b(view, attachment);
                    return;
                }
            }
            m21298b(view, attachment);
        } else if (id == C0465R.id.instabug_btn_remove_attachment) {
            if (this.f19740f != null) {
                m21307h();
            }
            ((C1289a) this.presenter).mo3634a(attachment);
        } else if (id == C0465R.id.instabug_grid_video_item) {
            SystemServiceUtils.hideInputMethod(getActivity());
            this.f19744j = true;
            m21301c(attachment.getLocalPath());
        }
    }

    static /* synthetic */ void m21295a(C1730c c1730c, ScreenRecordEvent screenRecordEvent) {
        String path = screenRecordEvent.getVideoUri().getPath();
        if (path == null) {
            c1730c.m21310k();
        } else if (new File(path).exists()) {
            ((C1289a) c1730c.presenter).mo3636a(C0474d.m7762a().f9100a.f15314e, path);
            C0474d.m7762a().f9100a.setVideoEncoded(true);
            if (c1730c.f19744j) {
                if (c1730c.m21308i()) {
                    c1730c.m21296a(false);
                }
                if (!c1730c.m21309j()) {
                    c1730c.m21299b(true);
                }
                ((C1289a) c1730c.presenter).mo3640c();
                c1730c.m21301c(path);
                return;
            }
            ((C1289a) c1730c.presenter).mo3640c();
        } else {
            c1730c.m21310k();
        }
    }
}
