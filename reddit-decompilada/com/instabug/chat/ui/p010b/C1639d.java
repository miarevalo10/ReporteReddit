package com.instabug.chat.ui.p010b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.instabug.chat.ChatPlugin;
import com.instabug.chat.cache.ChatsCacheManager;
import com.instabug.chat.cache.ReadQueueCacheManager;
import com.instabug.chat.eventbus.C0543a;
import com.instabug.chat.eventbus.ChatTriggeringEventBus;
import com.instabug.chat.model.Attachment;
import com.instabug.chat.model.C0550a;
import com.instabug.chat.model.C0550a.C0548a;
import com.instabug.chat.model.C0550a.C0549b;
import com.instabug.chat.model.C1309d;
import com.instabug.chat.model.Chat;
import com.instabug.chat.model.Chat.ChatState;
import com.instabug.chat.model.Message;
import com.instabug.chat.model.Message.C0546a;
import com.instabug.chat.model.Message.C0547b;
import com.instabug.chat.model.Message.MessageState;
import com.instabug.chat.network.InstabugMessageUploaderService;
import com.instabug.chat.p005a.C0534b;
import com.instabug.chat.p006b.C0536a;
import com.instabug.chat.p006b.C0536a.C12971;
import com.instabug.chat.p006b.C0536a.C12982;
import com.instabug.chat.p006b.C0536a.C12993;
import com.instabug.chat.p007d.C0539a;
import com.instabug.chat.p007d.C0540b;
import com.instabug.chat.p036c.C1300a;
import com.instabug.chat.settings.C0554a;
import com.instabug.chat.ui.p010b.C0562b.C1319a;
import com.instabug.chat.ui.p010b.C0562b.C1320b;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.ScreenRecordingEventBus;
import com.instabug.library.core.eventbus.VideoProcessingServiceEventBus;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.internal.storage.cache.CacheChangedListener;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.internal.video.InternalScreenRecordHelper;
import com.instabug.library.screenshot.ExtraScreenshotHelper.OnCaptureListener;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* compiled from: ChatPresenter */
class C1639d extends BasePresenter<C1320b> implements C0540b, C1319a, CacheChangedListener<Chat> {
    private PublishSubject<String> f18530a;
    private Subscription f18531b;
    private Subscription f18532c;
    private Chat f18533d;

    /* compiled from: ChatPresenter */
    class C13211 implements Observer<String> {
        final /* synthetic */ C1639d f15404a;

        public final void m15316a(Throwable th) {
        }

        public final void m15317b() {
        }

        C13211(C1639d c1639d) {
            this.f15404a = c1639d;
        }

        public final /* synthetic */ void a_(Object obj) {
            C1639d.m19421a(this.f15404a, (String) obj);
        }
    }

    /* compiled from: ChatPresenter */
    class C13222 implements Action1<C0543a> {
        final /* synthetic */ C1639d f15405a;

        C13222(C1639d c1639d) {
            this.f15405a = c1639d;
        }

        public final /* synthetic */ void m15318a(Object obj) {
            C0543a c0543a = (C0543a) obj;
            if (this.f15405a.f18533d.getId().equals(c0543a.f9259a)) {
                this.f15405a.f18533d.m15271a(c0543a.f9260b);
            }
        }
    }

    public /* synthetic */ void onCachedItemAdded(Object obj) {
        m19424b(((Chat) obj).getId());
    }

    public /* synthetic */ void onCachedItemRemoved(Object obj) {
        m19424b(((Chat) obj).getId());
    }

    public /* synthetic */ void onCachedItemUpdated(Object obj, Object obj2) {
        m19424b(((Chat) obj2).getId());
    }

    C1639d(C1320b c1320b) {
        super(c1320b);
    }

    public final void mo3653a(String str) {
        C1320b c1320b;
        this.f18533d = C1639d.m19425c(str);
        if (this.view != null) {
            c1320b = (C1320b) this.view.get();
            if (c1320b != null) {
                if (ChatsCacheManager.getValidChats().size() > 0) {
                    c1320b.mo4338e();
                } else {
                    c1320b.mo4336d();
                }
            }
        }
        if (this.view != null) {
            c1320b = (C1320b) this.view.get();
            if (c1320b != null) {
                if (C0554a.m7945c()) {
                    c1320b.mo4339f();
                } else {
                    c1320b.mo4340g();
                }
            }
        }
        m19423b(this.f18533d);
        C1639d.m19420a(this.f18533d);
    }

    public final void mo3654b() {
        CacheManager.getInstance().unSubscribe(ChatsCacheManager.CHATS_MEMORY_CACHE_KEY, this);
        if (C1639d.m19422a(this.f18531b)) {
            this.f18531b.c();
        }
        C0539a.m7900a().m7912b((C0540b) this);
        if (C1639d.m19422a(this.f18532c)) {
            this.f18532c.c();
        }
    }

    public final List<C0550a> mo3649a(List<Message> list) {
        List<C0550a> arrayList = new ArrayList();
        for (Message message : list) {
            if (message.f15384h != null && message.f15384h.size() > 0) {
                Iterator it = message.f15384h.iterator();
                while (it.hasNext()) {
                    Attachment attachment = (Attachment) it.next();
                    C0550a c0550a = new C0550a();
                    c0550a.f9275a = message.f15379c;
                    c0550a.f9276b = message.f15381e;
                    c0550a.f9277c = message.f15382f;
                    c0550a.f9278d = attachment.getUrl();
                    c0550a.f9279e = attachment.getLocalPath();
                    c0550a.f9282h = message.m15281a();
                    StringBuilder stringBuilder = new StringBuilder("type");
                    stringBuilder.append(attachment.getFileType());
                    InstabugSDKLogger.m8359i(this, stringBuilder.toString());
                    String type = attachment.getType();
                    boolean z = true;
                    int hashCode = type.hashCode();
                    if (hashCode != 93166550) {
                        if (hashCode != 100313435) {
                            if (hashCode == 112202875) {
                                if (type.equals(Attachment.TYPE_VIDEO)) {
                                    z = true;
                                }
                            }
                        } else if (type.equals(Attachment.TYPE_IMAGE)) {
                            z = false;
                        }
                    } else if (type.equals(Attachment.TYPE_AUDIO)) {
                        z = true;
                    }
                    switch (z) {
                        case false:
                            c0550a.f9280f = C0549b.IMAGE;
                            break;
                        case true:
                            c0550a.f9280f = C0549b.AUDIO;
                            c0550a.f9281g = C0548a.NONE;
                            break;
                        case true:
                            c0550a.f9280f = C0549b.VIDEO;
                            if (!attachment.isVideoEncoded()) {
                                c0550a.f9283i = false;
                                break;
                            }
                            c0550a.f9283i = true;
                            break;
                        default:
                            break;
                    }
                    arrayList.add(c0550a);
                }
            }
            C0550a c0550a2;
            if (!TextUtils.isEmpty(message.f15379c)) {
                c0550a2 = new C0550a();
                c0550a2.f9275a = message.f15379c;
                c0550a2.f9276b = message.f15381e;
                c0550a2.f9277c = message.f15382f;
                c0550a2.f9282h = message.m15281a();
                c0550a2.f9280f = C0549b.MESSAGE;
                if (message.f15385i != null && message.f15385i.size() > 0) {
                    c0550a2.f9284j = message.f15385i;
                }
                arrayList.add(c0550a2);
            } else if (!(message.m15281a() || message.f15385i == null || message.f15385i.size() <= 0)) {
                c0550a2 = new C0550a();
                c0550a2.f9275a = message.f15379c;
                c0550a2.f9276b = message.f15381e;
                c0550a2.f9277c = message.f15382f;
                c0550a2.f9282h = message.m15281a();
                c0550a2.f9280f = C0549b.MESSAGE;
                c0550a2.f9284j = message.f15385i;
                arrayList.add(c0550a2);
            }
        }
        return arrayList;
    }

    public final void mo3652a(Message message) {
        StringBuilder stringBuilder = new StringBuilder("chat id: ");
        stringBuilder.append(message.f15378b);
        InstabugSDKLogger.m8360v(C1639d.class, stringBuilder.toString());
        this.f18533d.f15373a.add(message);
        message = ChatsCacheManager.getCache();
        if (message != null) {
            message.put(this.f18533d.getId(), this.f18533d);
        }
        if (this.view != null) {
            C1320b c1320b = (C1320b) this.view.get();
            if (c1320b != null) {
                ((Fragment) c1320b.getViewContext()).getActivity().startService(new Intent(((Fragment) c1320b.getViewContext()).getActivity(), InstabugMessageUploaderService.class));
            }
        }
    }

    public final void mo3651a(Attachment attachment) {
        Object obj;
        C1320b c1320b;
        String type = attachment.getType();
        int hashCode = type.hashCode();
        if (hashCode != 93166550) {
            if (hashCode != 100313435) {
                if (hashCode == 112202875) {
                    if (type.equals(Attachment.TYPE_VIDEO)) {
                        obj = 2;
                        if (obj == null) {
                            if (this.view != null) {
                                c1320b = (C1320b) this.view.get();
                                if (!C0554a.m7955j()) {
                                    if (c1320b != null) {
                                        c1320b.mo4329a(Uri.fromFile(new File(attachment.getLocalPath())));
                                    }
                                    return;
                                }
                            }
                        }
                        mo3652a(mo3647a(this.f18533d.getId(), attachment));
                    }
                }
            } else if (type.equals(Attachment.TYPE_IMAGE)) {
                obj = null;
                if (obj == null) {
                    if (this.view != null) {
                        c1320b = (C1320b) this.view.get();
                        if (C0554a.m7955j()) {
                            if (c1320b != null) {
                                c1320b.mo4329a(Uri.fromFile(new File(attachment.getLocalPath())));
                            }
                            return;
                        }
                    }
                }
                mo3652a(mo3647a(this.f18533d.getId(), attachment));
            }
        } else if (type.equals(Attachment.TYPE_AUDIO)) {
            obj = 1;
            if (obj == null) {
                if (this.view != null) {
                    c1320b = (C1320b) this.view.get();
                    if (C0554a.m7955j()) {
                        if (c1320b != null) {
                            c1320b.mo4329a(Uri.fromFile(new File(attachment.getLocalPath())));
                        }
                        return;
                    }
                }
            }
            mo3652a(mo3647a(this.f18533d.getId(), attachment));
        }
        obj = -1;
        if (obj == null) {
            if (this.view != null) {
                c1320b = (C1320b) this.view.get();
                if (C0554a.m7955j()) {
                    if (c1320b != null) {
                        c1320b.mo4329a(Uri.fromFile(new File(attachment.getLocalPath())));
                    }
                    return;
                }
            }
        }
        mo3652a(mo3647a(this.f18533d.getId(), attachment));
    }

    public final Message mo3648a(String str, String str2) {
        Message message = new Message();
        message.f15378b = str;
        message.f15379c = str2;
        message.f15382f = InstabugDateFormatter.getCurrentUTCTimeStampInSeconds();
        str = message.m15279a(InstabugDateFormatter.getCurrentUTCTimeStampInSeconds()).m15280a(C0547b.INBOUND);
        str.f15380d = InstabugCore.getUsername();
        str.f15386j = MessageState.READY_TO_BE_SENT;
        return message;
    }

    public final Message mo3647a(String str, Attachment attachment) {
        str = mo3648a(str, "");
        str.f15384h.add(attachment);
        return str;
    }

    public final Chat mo3655c() {
        return this.f18533d;
    }

    public final void mo3656d() {
        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
        if (chatPlugin != null && chatPlugin.getAppContext() != null && this.f18533d != null) {
            InstabugSDKLogger.m8360v(C1732c.class, "take extra screenshot");
            chatPlugin.setState(2);
            this.f18533d.f15374b = ChatState.WAITING_ATTACHMENT_MESSAGE;
            OnCaptureListener a = C1300a.m15264a();
            Context appContext = chatPlugin.getAppContext();
            String id = this.f18533d.getId();
            a.f15364a = new WeakReference(appContext);
            a.f15366c = id;
            a.f15365b.init(a);
            if (this.view != null) {
                C1320b c1320b = (C1320b) this.view.get();
                if (c1320b != null) {
                    c1320b.finishActivity();
                }
            }
        }
    }

    public final void mo3657e() {
        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
        if (chatPlugin != null && chatPlugin.getAppContext() != null && this.f18533d != null) {
            InstabugSDKLogger.m8360v(C1732c.class, "start record screen");
            chatPlugin.setState(2);
            this.f18533d.f15374b = ChatState.WAITING_ATTACHMENT_MESSAGE;
            C0536a a = C0536a.m7886a();
            String id = this.f18533d.getId();
            a.f9243a = id;
            InternalScreenRecordHelper.getInstance().init();
            if (a.f9244b == null || a.f9244b.d()) {
                a.f9244b = ScreenRecordingEventBus.getInstance().subscribe(new C12971(a));
            }
            VideoProcessingServiceEventBus.getInstance().subscribe(new C12982(a));
            a.f9245c = ChatTriggeringEventBus.getInstance().subscribe(new C12993(a, id));
            if (this.view != null) {
                C1320b c1320b = (C1320b) this.view.get();
                if (c1320b != null) {
                    c1320b.finishActivity();
                }
            }
        }
    }

    public final void mo3658f() {
        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
        if (chatPlugin != null && chatPlugin.getAppContext() != null && this.f18533d != null) {
            InstabugSDKLogger.m8360v(C1732c.class, "pick image from gallery");
            chatPlugin.setState(2);
            this.f18533d.f15374b = ChatState.WAITING_ATTACHMENT_MESSAGE;
            C1320b c1320b = (C1320b) this.view.get();
            if (c1320b != null) {
                c1320b.mo4342i();
            }
        }
    }

    public final void mo3659g() {
        if (this.f18533d != null && this.f18533d.f15373a.size() == 0 && this.f18533d.f15374b != ChatState.WAITING_ATTACHMENT_MESSAGE) {
            InMemoryCache cache = ChatsCacheManager.getCache();
            if (cache != null) {
                cache.delete(this.f18533d.getId());
            }
        }
    }

    public List<Message> onNewMessagesReceived(List<Message> list) {
        if (this.view != null) {
            C1320b c1320b = (C1320b) this.view.get();
            if (!(c1320b == null || ((Fragment) c1320b.getViewContext()).getActivity() == null)) {
                for (Message message : list) {
                    if (message.f15378b.equals(this.f18533d.getId())) {
                        list.remove(message);
                        C0534b.m7867a().m7874a(((Fragment) c1320b.getViewContext()).getActivity());
                        C1639d.m19420a(this.f18533d);
                    }
                }
                return list;
            }
        }
        return list;
    }

    public void onCacheInvalidated() {
        StringBuilder stringBuilder = new StringBuilder("Chats cache was invalidated, Time: ");
        stringBuilder.append(System.currentTimeMillis());
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
    }

    private void m19424b(String str) {
        if (str.equals(this.f18533d.getId())) {
            this.f18530a.a_(str);
        }
    }

    private static boolean m19422a(Subscription subscription) {
        return (subscription == null || subscription.d() != null) ? null : true;
    }

    private static Chat m19425c(String str) {
        if (ChatsCacheManager.getCache() == null || ChatsCacheManager.getChat(str) == null) {
            return new Chat();
        }
        return ChatsCacheManager.getChat(str);
    }

    public final void mo3650a() {
        if (this.f18533d.f15374b == ChatState.WAITING_ATTACHMENT_MESSAGE) {
            this.f18533d.f15374b = ChatState.READY_TO_BE_SENT;
        }
        if (!C1639d.m19422a(this.f18531b)) {
            this.f18530a = PublishSubject.d();
            this.f18531b = this.f18530a.b(300, TimeUnit.MILLISECONDS).a(AndroidSchedulers.a()).a(new C13211(this));
        }
        CacheManager.getInstance().subscribe(ChatsCacheManager.CHATS_MEMORY_CACHE_KEY, this);
        C0539a.m7900a().m7911a((C0540b) this);
        if (!C1639d.m19422a(this.f18532c)) {
            this.f18532c = ChatTriggeringEventBus.getInstance().subscribe(new C13222(this));
        }
    }

    public final Attachment mo3646a(Uri uri) {
        Attachment attachment = new Attachment();
        attachment.setState(Attachment.STATE_OFFLINE);
        attachment.setType(Attachment.TYPE_IMAGE).setLocalPath(uri.getPath()).setName(uri.getLastPathSegment());
        return attachment;
    }

    private static void m19420a(Chat chat) {
        for (int size = chat.f15373a.size() - 1; size >= 0; size--) {
            ((Message) chat.f15373a.get(size)).f15383g = true;
        }
        if (ChatsCacheManager.getCache() != null) {
            ChatsCacheManager.getCache().put(chat.getId(), chat);
        }
    }

    private void m19423b(Chat chat) {
        List list = chat.f15373a;
        int size = list.size() - 1;
        while (size >= 0) {
            if (!((Message) list.get(size)).m15281a() && !((Message) list.get(size)).f15383g) {
                C1309d c1309d = new C1309d();
                c1309d.f15392a = ((Message) list.get(size)).f15378b;
                c1309d.f15394c = ((Message) list.get(size)).f15377a;
                c1309d.f15393b = InstabugDateFormatter.getCurrentUTCTimeStampInSeconds();
                ReadQueueCacheManager.getInstance().add(c1309d);
                break;
            }
            size--;
        }
        Collections.sort(chat.f15373a, new C0546a());
        if (this.view != null) {
            C1320b c1320b = (C1320b) this.view.get();
            if (c1320b != null) {
                c1320b.mo4331a(chat.f15373a);
                c1320b.mo4341h();
            }
        }
    }

    static /* synthetic */ void m19421a(C1639d c1639d, String str) {
        c1639d.f18533d = C1639d.m19425c(str);
        if (c1639d.f18533d != null) {
            c1639d.m19423b(c1639d.f18533d);
        }
    }
}
