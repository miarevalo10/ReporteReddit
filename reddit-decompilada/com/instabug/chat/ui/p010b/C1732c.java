package com.instabug.chat.ui.p010b;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.instabug.chat.C0520R;
import com.instabug.chat.ChatPlugin;
import com.instabug.chat.cache.ChatsCacheManager;
import com.instabug.chat.model.Attachment;
import com.instabug.chat.model.Message;
import com.instabug.chat.p006b.C0536a;
import com.instabug.chat.ui.p009a.C1731b;
import com.instabug.chat.ui.p009a.C1731b.C0558a;
import com.instabug.chat.ui.p010b.C0562b.C1319a;
import com.instabug.chat.ui.p010b.C0562b.C1320b;
import com.instabug.chat.ui.p010b.C0573f.C0571a;
import com.instabug.chat.ui.p010b.C1709a.C0561a;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.ToolbarFragment;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.video.VideoPlayerFragment;
import com.instabug.library.util.Colorizer;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.PermissionsUtils;
import com.instabug.library.util.PlaceHolderUtils;
import com.instabug.library.util.SystemServiceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChatFragment */
public class C1732c extends ToolbarFragment<C1319a> implements OnClickListener, C0558a, C0561a, C1320b, C0571a {
    private String f19756a;
    private C0573f f19757b;
    private EditText f19758c;

    /* compiled from: ChatFragment */
    class C05631 implements Runnable {
        final /* synthetic */ C1732c f9303a;

        public void run() {
        }

        C05631(C1732c c1732c) {
            this.f9303a = c1732c;
        }
    }

    /* compiled from: ChatFragment */
    class C05642 implements Runnable {
        final /* synthetic */ C1732c f9304a;

        C05642(C1732c c1732c) {
            this.f9304a = c1732c;
        }

        public void run() {
            ((C1319a) this.f9304a.presenter).mo3658f();
        }
    }

    protected void onDoneButtonClicked() {
    }

    public static C1732c m21323a(String str) {
        C1732c c1732c = new C1732c();
        Bundle bundle = new Bundle();
        bundle.putString("chat_number", str);
        c1732c.setArguments(bundle);
        return c1732c;
    }

    public static C1732c m21324a(String str, Attachment attachment) {
        C1732c c1732c = new C1732c();
        Bundle bundle = new Bundle();
        bundle.putString("chat_number", str);
        bundle.putSerializable("attachment", attachment);
        c1732c.setArguments(bundle);
        return c1732c;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19756a = getArguments().getString("chat_number");
        this.presenter = new C1639d(this);
    }

    protected int getContentLayout() {
        return C0520R.layout.instabug_fragment_chat;
    }

    protected void initContentViews(View view, Bundle bundle) {
        view.findViewById(C0520R.id.instabug_btn_toolbar_right).setVisibility(8);
        ListView listView = (ListView) view.findViewById(C0520R.id.instabug_lst_messages);
        this.f19758c = (EditText) view.findViewById(C0520R.id.instabug_edit_text_new_message);
        this.f19758c.setHint(PlaceHolderUtils.getPlaceHolder(Key.CONVERSATION_TEXT_FIELD_HINT, getString(C0520R.string.instabug_str_sending_message_hint)));
        ImageView imageView = (ImageView) view.findViewById(C0520R.id.instabug_btn_send);
        imageView.setImageDrawable(Colorizer.getPrimaryColorTintedDrawable(ContextCompat.m714a(getContext(), C0520R.drawable.instabug_ic_send)));
        imageView.setOnClickListener(this);
        this.f19757b = new C0573f(new ArrayList(), getActivity(), listView, this);
        listView.setAdapter(this.f19757b);
    }

    protected String getTitle() {
        if (ChatsCacheManager.getChat(this.f19756a) != null) {
            return ChatsCacheManager.getChat(this.f19756a).m15272a(getContext());
        }
        return getString(C0520R.string.instabug_str_empty);
    }

    protected void onCloseButtonClicked() {
        SystemServiceUtils.hideInputMethod(getActivity());
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((C1319a) this.presenter).mo3653a(this.f19756a);
    }

    public void onStart() {
        super.onStart();
        ((C1319a) this.presenter).mo3650a();
        Attachment attachment = (Attachment) getArguments().getSerializable("attachment");
        if (attachment != null) {
            ((C1319a) this.presenter).mo3651a(attachment);
        }
        if (getArguments() != null) {
            getArguments().clear();
        }
    }

    public void onStop() {
        super.onStop();
        ((C1319a) this.presenter).mo3654b();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((C1319a) this.presenter).mo3659g();
    }

    public void onClick(View view) {
        if (view.getId() == C0520R.id.instabug_btn_send) {
            String obj = this.f19758c.getText().toString();
            if (!TextUtils.isEmpty(obj.trim())) {
                ((C1319a) this.presenter).mo3652a(((C1319a) this.presenter).mo3648a(((C1319a) this.presenter).mo3655c().getId(), obj));
                this.f19758c.setText("");
                return;
            }
            return;
        }
        if (view.getId() == C0520R.id.instabug_btn_attach) {
            SystemServiceUtils.hideInputMethod(getActivity());
            getActivity().getSupportFragmentManager().mo219a().mo195a(C0520R.id.instabug_fragment_container, C1709a.m20528a(this), "attachments_bottom_sheet_fragment").mo198a("attachments_bottom_sheet_fragment").mo203c();
        }
    }

    public final void mo4333b(String str) {
        SystemServiceUtils.hideInputMethod(getActivity());
        getActivity().getSupportFragmentManager().mo219a().mo195a(C0520R.id.instabug_fragment_container, VideoPlayerFragment.newInstance(str), VideoPlayerFragment.TAG).mo198a(VideoPlayerFragment.TAG).mo203c();
    }

    public final void mo4335c(String str) {
        SystemServiceUtils.hideInputMethod(getActivity());
        getActivity().getSupportFragmentManager().mo219a().mo195a(C0520R.id.instabug_fragment_container, C1640e.m19442a(str), "image_attachment_viewer_fragment").mo198a("image_attachment_viewer_fragment").mo203c();
    }

    public final void mo4337d(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            startActivity(intent);
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("Unable to view this url ");
            stringBuilder.append(str);
            stringBuilder.append("\nError message: ");
            stringBuilder.append(e.getMessage());
            InstabugSDKLogger.m8357e(this, stringBuilder.toString());
        }
    }

    public final void mo4328a() {
        ((C1319a) this.presenter).mo3656d();
    }

    public final void mo4330a(String str, Uri uri) {
        if (str != null && str.equals(((C1319a) this.presenter).mo3655c().getId()) != null) {
            ((C1319a) this.presenter).mo3652a(((C1319a) this.presenter).mo3647a(((C1319a) this.presenter).mo3655c().getId(), ((C1319a) this.presenter).mo3646a(uri)));
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr.length <= 0 || iArr[0] != 0) {
            if (i == 163) {
                ((C1319a) this.presenter).mo3657e();
            }
            return;
        }
        switch (i) {
            case 162:
                ((C1319a) this.presenter).mo3658f();
                return;
            case 163:
                ((C1319a) this.presenter).mo3657e();
                return;
            default:
                super.onRequestPermissionsResult(i, strArr, iArr);
                return;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 161) {
            if (i2 == -1 && intent != null) {
                i = AttachmentsUtility.getGalleryImagePath(getActivity(), intent.getData());
                if (i == 0) {
                    i = intent.getData().getPath();
                }
                if (i != 0) {
                    Uri newFileAttachmentUri = AttachmentsUtility.getNewFileAttachmentUri(getActivity(), Uri.fromFile(new File(i)));
                    InstabugSDKLogger.m8356d(this, "onActivityResult");
                    ((C1319a) this.presenter).mo3650a();
                    ((C1319a) this.presenter).mo3651a(((C1319a) this.presenter).mo3646a(newFileAttachmentUri));
                }
            }
        }
    }

    public final void mo4336d() {
        ((ImageButton) this.rootView.findViewById(C0520R.id.instabug_btn_toolbar_left)).setImageResource(C0520R.drawable.instabug_ic_close);
    }

    public final void mo4338e() {
        ((ImageButton) this.rootView.findViewById(C0520R.id.instabug_btn_toolbar_left)).setImageResource(C0520R.drawable.instabug_ic_back);
        if (VERSION.SDK_INT >= 11) {
            this.rootView.findViewById(C0520R.id.instabug_btn_toolbar_left).setRotation((float) getResources().getInteger(C0520R.integer.instabug_icon_lang_rotation));
        }
    }

    public final void mo4339f() {
        ImageView imageView = (ImageView) this.rootView.findViewById(C0520R.id.instabug_btn_attach);
        Colorizer.applyPrimaryColorTint(imageView);
        imageView.setOnClickListener(this);
    }

    public final void mo4340g() {
        this.rootView.findViewById(C0520R.id.instabug_btn_attach).setVisibility(8);
    }

    public final void mo4331a(List<Message> list) {
        this.f19757b.f9330a = ((C1319a) this.presenter).mo3649a((List) list);
    }

    public final void mo4341h() {
        this.f19757b.notifyDataSetChanged();
    }

    public final void mo4329a(Uri uri) {
        getActivity().getSupportFragmentManager().mo219a().mo195a(C0520R.id.instabug_fragment_container, C1731b.m21322a(((C1319a) this.presenter).mo3655c().m15272a(getActivity()), ((C1319a) this.presenter).mo3655c().getId(), uri), "annotation_fragment_for_chat").mo198a("annotation_fragment_for_chat").mo203c();
    }

    public final void mo4332b() {
        PermissionsUtils.requestPermission((Fragment) this, "android.permission.WRITE_EXTERNAL_STORAGE", 162, new C05631(this), new C05642(this));
        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
        if (chatPlugin != null) {
            chatPlugin.setState(2);
        }
    }

    public final void mo4334c() {
        C0536a.m7886a();
        if (C0536a.m7893b()) {
            Toast.makeText(getContext(), C0520R.string.instabug_str_video_encoder_busy, 0).show();
        } else if (ContextCompat.m713a(getActivity(), "android.permission.RECORD_AUDIO") != 0) {
            requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 163);
        } else {
            ((C1319a) this.presenter).mo3657e();
        }
    }

    public final void mo4342i() {
        Intent intent = new Intent("android.intent.action.PICK");
        if (VERSION.SDK_INT >= 11) {
            intent.putExtra("android.intent.extra.LOCAL_ONLY", true);
        }
        intent.setType("image/*");
        startActivityForResult(intent, 161);
    }
}
