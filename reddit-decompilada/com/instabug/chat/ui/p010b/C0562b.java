package com.instabug.chat.ui.p010b;

import android.net.Uri;
import android.support.v4.app.Fragment;
import com.instabug.chat.model.Attachment;
import com.instabug.chat.model.C0550a;
import com.instabug.chat.model.Chat;
import com.instabug.chat.model.Message;
import com.instabug.library.core.ui.BaseContract.Presenter;
import com.instabug.library.core.ui.BaseContract.View;
import java.util.List;

/* compiled from: ChatContract */
public class C0562b {

    /* compiled from: ChatContract */
    interface C1319a extends Presenter {
        Attachment mo3646a(Uri uri);

        Message mo3647a(String str, Attachment attachment);

        Message mo3648a(String str, String str2);

        List<C0550a> mo3649a(List<Message> list);

        void mo3650a();

        void mo3651a(Attachment attachment);

        void mo3652a(Message message);

        void mo3653a(String str);

        void mo3654b();

        Chat mo3655c();

        void mo3656d();

        void mo3657e();

        void mo3658f();

        void mo3659g();
    }

    /* compiled from: ChatContract */
    interface C1320b extends View<Fragment> {
        void mo4329a(Uri uri);

        void mo4331a(List<Message> list);

        void mo4336d();

        void mo4338e();

        void mo4339f();

        void mo4340g();

        void mo4341h();

        void mo4342i();
    }
}
