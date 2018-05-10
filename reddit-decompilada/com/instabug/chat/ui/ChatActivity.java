package com.instabug.chat.ui;

import android.content.Intent;
import android.os.Bundle;
import com.instabug.chat.C0520R;
import com.instabug.chat.ChatPlugin;
import com.instabug.chat.model.Attachment;
import com.instabug.chat.ui.C0574b.C1317a;
import com.instabug.chat.ui.C0574b.C1318b;
import com.instabug.chat.ui.p010b.C1732c;
import com.instabug.chat.ui.p011c.C1733c;
import com.instabug.chat.ui.p011c.C1733c.C0578a;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseFragmentActivity;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.OrientationUtils;

public class ChatActivity extends BaseFragmentActivity<C1317a> implements C1318b, C0578a, _InstabugActivity {
    protected void initViews() {
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (m21611a(intent) == 161) {
            mo4441b(intent.getExtras().getString("chat_number"));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        OrientationUtils.handelOrientation(this);
        this.presenter = new C1642c(this);
        ((C1317a) this.presenter).mo3667a(m21611a(getIntent()));
    }

    protected int getLayout() {
        return C0520R.layout.instabug_activity;
    }

    public void onStart() {
        super.onStart();
        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
        if (chatPlugin != null) {
            chatPlugin.setState(1);
        }
    }

    public void onStop() {
        super.onStop();
        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
        if (chatPlugin != null && chatPlugin.getState() != 2) {
            chatPlugin.setState(0);
        }
    }

    protected void onDestroy() {
        OrientationUtils.unlockOrientation(this);
        super.onDestroy();
    }

    public final void mo4437a() {
        getSupportFragmentManager().mo219a().mo195a(C0520R.id.instabug_fragment_container, C1733c.m21341c(), "chats_fragment").mo203c();
    }

    public final void mo4438a(String str) {
        getSupportFragmentManager().mo225b();
        str = getSupportFragmentManager().mo219a().mo195a(C0520R.id.instabug_fragment_container, C1732c.m21323a(str), "chat_fragment");
        if (getSupportFragmentManager().mo216a(C0520R.id.instabug_fragment_container) != null) {
            str.mo198a("chat_fragment");
        }
        str.mo203c();
    }

    public final void mo4439a(String str, Attachment attachment) {
        getSupportFragmentManager().mo225b();
        str = getSupportFragmentManager().mo219a().mo195a(C0520R.id.instabug_fragment_container, C1732c.m21324a(str, attachment), "chat_fragment");
        if (getSupportFragmentManager().mo216a(C0520R.id.instabug_fragment_container) != null) {
            str.mo198a("chat_fragment");
        }
        str.mo203c();
    }

    private static int m21611a(Intent intent) {
        switch (intent.getExtras().getInt("chat_process")) {
            case 160:
                return 160;
            case 161:
                return 161;
            case 162:
                return 162;
            case 164:
                return 164;
            default:
                return 160;
        }
    }

    public final String mo4440b() {
        return getIntent().getExtras().getString("chat_number");
    }

    public final Attachment mo4442c() {
        return (Attachment) getIntent().getExtras().getSerializable("attachment");
    }

    public final void mo4441b(String str) {
        StringBuilder stringBuilder = new StringBuilder("Chat id: ");
        stringBuilder.append(str);
        InstabugSDKLogger.m8360v(C1733c.class, stringBuilder.toString());
        ((C1317a) this.presenter).mo3668a(str);
    }

    public final void mo4443d() {
        ((C1317a) this.presenter).mo3666a();
    }

    public void finish() {
        super.finish();
        ((C1317a) this.presenter).mo3669b();
    }
}
