package com.instabug.chat.ui.p011c;

import android.support.v4.app.Fragment;
import com.instabug.chat.cache.ChatsCacheManager;
import com.instabug.chat.model.Chat;
import com.instabug.chat.model.Chat.C0544a;
import com.instabug.chat.model.Message;
import com.instabug.chat.p005a.C0534b;
import com.instabug.chat.p007d.C0539a;
import com.instabug.chat.p007d.C0540b;
import com.instabug.chat.ui.p011c.C0577b.C1328a;
import com.instabug.chat.ui.p011c.C0577b.C1329b;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.internal.storage.cache.CacheChangedListener;
import com.instabug.library.internal.storage.cache.CacheManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;

/* compiled from: ChatsPresenter */
class C1641d extends BasePresenter<C1329b> implements C0540b, C1328a, CacheChangedListener<Chat> {
    private PublishSubject<Long> f18539a;
    private Subscription f18540b;

    /* compiled from: ChatsPresenter */
    class C13301 implements Observer<Long> {
        final /* synthetic */ C1641d f15417a;

        public final void m15324a(Throwable th) {
        }

        public final void m15325b() {
        }

        C13301(C1641d c1641d) {
            this.f15417a = c1641d;
        }

        public final /* synthetic */ void a_(Object obj) {
            this.f15417a.m19448c();
        }
    }

    C1641d(C1329b c1329b) {
        super(c1329b);
    }

    public final void mo3665b() {
        CacheManager.getInstance().unSubscribe(ChatsCacheManager.CHATS_MEMORY_CACHE_KEY, this);
        C0539a.m7900a().m7912b((C0540b) this);
        if (this.f18540b != null && !this.f18540b.d()) {
            this.f18540b.c();
        }
    }

    public List<Message> onNewMessagesReceived(List<Message> list) {
        if (this.view != null) {
            C1329b c1329b = (C1329b) this.view.get();
            if (!(c1329b == null || ((Fragment) c1329b.getViewContext()).getActivity() == null)) {
                if (c1329b.mo4345b()) {
                    C0534b.m7867a().m7874a(((Fragment) c1329b.getViewContext()).getActivity());
                } else {
                    C0534b.m7867a().m7875a(((Fragment) c1329b.getViewContext()).getActivity(), (List) list);
                }
            }
        }
        return null;
    }

    public void onCacheInvalidated() {
        m19446a(System.currentTimeMillis());
    }

    private void m19446a(long j) {
        this.f18539a.a_(Long.valueOf(j));
    }

    public final void mo3664a() {
        this.f18539a = PublishSubject.d();
        this.f18540b = this.f18539a.b(300, TimeUnit.MILLISECONDS).a(AndroidSchedulers.a()).a(new C13301(this));
        CacheManager.getInstance().subscribe(ChatsCacheManager.CHATS_MEMORY_CACHE_KEY, this);
        C0539a.m7900a().m7911a((C0540b) this);
        m19448c();
    }

    private void m19448c() {
        Object arrayList;
        if (ChatsCacheManager.getCache() != null) {
            arrayList = new ArrayList(ChatsCacheManager.getValidChats());
        } else {
            arrayList = new ArrayList();
        }
        Collections.sort(arrayList, Collections.reverseOrder(new C0544a()));
        Collections.sort(arrayList, Collections.reverseOrder(new C0544a()));
        if (this.view != null) {
            C1329b c1329b = (C1329b) this.view.get();
            if (c1329b != null) {
                c1329b.mo4344a(arrayList);
                c1329b.mo4343a();
            }
        }
    }

    public /* synthetic */ void onCachedItemUpdated(Object obj, Object obj2) {
        m19446a(System.currentTimeMillis());
    }

    public /* synthetic */ void onCachedItemAdded(Object obj) {
        m19446a(System.currentTimeMillis());
    }

    public /* synthetic */ void onCachedItemRemoved(Object obj) {
        m19446a(System.currentTimeMillis());
    }
}
