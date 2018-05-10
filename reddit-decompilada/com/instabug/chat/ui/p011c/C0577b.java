package com.instabug.chat.ui.p011c;

import android.support.v4.app.Fragment;
import com.instabug.chat.model.Chat;
import com.instabug.library.core.ui.BaseContract.Presenter;
import com.instabug.library.core.ui.BaseContract.View;
import java.util.ArrayList;

/* compiled from: ChatsContract */
public class C0577b {

    /* compiled from: ChatsContract */
    interface C1328a extends Presenter {
        void mo3664a();

        void mo3665b();
    }

    /* compiled from: ChatsContract */
    interface C1329b extends View<Fragment> {
        void mo4343a();

        void mo4344a(ArrayList<Chat> arrayList);

        boolean mo4345b();
    }
}
