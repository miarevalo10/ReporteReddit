package com.instabug.chat.ui;

import android.content.Context;
import com.instabug.chat.cache.ChatsCacheManager;
import com.instabug.chat.model.Chat;
import com.instabug.chat.settings.C0554a;
import com.instabug.chat.ui.C0574b.C1317a;
import com.instabug.chat.ui.C0574b.C1318b;
import com.instabug.library.OnSdkDismissedCallback;
import com.instabug.library.OnSdkDismissedCallback.DismissType;
import com.instabug.library.bugreporting.model.Bug.Type;
import com.instabug.library.core.ui.BasePresenter;

/* compiled from: ChatPresenter */
public class C1642c extends BasePresenter<C1318b> implements C1317a {
    public C1642c(C1318b c1318b) {
        super(c1318b);
    }

    public final void mo3668a(String str) {
        m19451b(str);
    }

    public final void mo3669b() {
        OnSdkDismissedCallback k = C0554a.m7956k();
        if (k != null) {
            k.onSdkDismissed(DismissType.CANCEL, Type.NOT_AVAILABLE);
        }
    }

    private void m19451b(String str) {
        C1318b c1318b = this.view != null ? (C1318b) this.view.get() : null;
        if (C1642c.m19452c() && c1318b != null) {
            c1318b.mo4437a();
        }
        if (c1318b != null) {
            c1318b.mo4438a(str);
        }
    }

    private static boolean m19452c() {
        return ChatsCacheManager.getValidChats().size() > 0;
    }

    public final void mo3667a(int i) {
        C1318b c1318b;
        if (i == 160) {
            if (C1642c.m19452c() == 0) {
                mo3666a();
            } else if (this.view != 0) {
                c1318b = (C1318b) this.view.get();
                if (c1318b != null) {
                    c1318b.mo4437a();
                }
                return;
            }
            return;
        }
        if (i == 161) {
            if (this.view != 0) {
                c1318b = (C1318b) this.view.get();
                if (c1318b != null) {
                    m19451b(c1318b.mo4440b());
                }
            }
        } else if (i == 162) {
            mo3666a();
        } else if (i == 164 && this.view != 0) {
            c1318b = (C1318b) this.view.get();
            if (c1318b != null) {
                String b = c1318b.mo4440b();
                i = c1318b.mo4442c();
                C1318b c1318b2 = null;
                if (this.view != null) {
                    c1318b2 = (C1318b) this.view.get();
                }
                if (C1642c.m19452c() && c1318b2 != null) {
                    c1318b2.mo4437a();
                }
                if (c1318b2 != null) {
                    c1318b2.mo4439a(b, i);
                }
            }
        }
    }

    public final void mo3666a() {
        Chat addOfflineChat;
        if (this.view != null) {
            C1318b c1318b = (C1318b) this.view.get();
            if (c1318b != null) {
                addOfflineChat = ChatsCacheManager.addOfflineChat((Context) c1318b.getViewContext());
                m19451b(addOfflineChat.getId());
            }
        }
        addOfflineChat = null;
        m19451b(addOfflineChat.getId());
    }
}
