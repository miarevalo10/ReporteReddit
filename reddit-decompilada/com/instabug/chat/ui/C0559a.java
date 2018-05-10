package com.instabug.chat.ui;

import android.content.Context;
import android.content.Intent;
import com.instabug.chat.model.Attachment;

/* compiled from: ChatActivityLauncher */
public class C0559a {
    public static Intent m7964a(Context context) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra("chat_process", 160);
        intent.addFlags(65536);
        intent.addFlags(268435456);
        return intent;
    }

    public static Intent m7965a(Context context, String str) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra("chat_process", 161);
        intent.putExtra("chat_number", str);
        intent.addFlags(65536);
        intent.addFlags(268435456);
        return intent;
    }

    public static Intent m7967b(Context context) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra("chat_process", 162);
        intent.addFlags(65536);
        intent.addFlags(268435456);
        return intent;
    }

    public static Intent m7966a(Context context, String str, Attachment attachment) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra("chat_process", 164);
        intent.putExtra("chat_number", str);
        intent.putExtra("attachment", attachment);
        intent.addFlags(65536);
        intent.addFlags(268435456);
        return intent;
    }
}
