package com.instabug.chat.ui;

import android.support.v4.app.FragmentActivity;
import com.instabug.chat.model.Attachment;
import com.instabug.library.core.ui.BaseContract.Presenter;
import com.instabug.library.core.ui.BaseContract.View;

/* compiled from: ChatContract */
public class C0574b {

    /* compiled from: ChatContract */
    interface C1317a extends Presenter {
        void mo3666a();

        void mo3667a(int i);

        void mo3668a(String str);

        void mo3669b();
    }

    /* compiled from: ChatContract */
    interface C1318b extends View<FragmentActivity> {
        void mo4437a();

        void mo4438a(String str);

        void mo4439a(String str, Attachment attachment);

        String mo4440b();

        Attachment mo4442c();
    }
}
