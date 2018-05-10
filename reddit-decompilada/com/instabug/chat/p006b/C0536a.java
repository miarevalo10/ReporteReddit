package com.instabug.chat.p006b;

import android.content.Intent;
import android.net.Uri;
import com.instabug.chat.cache.ChatsCacheManager;
import com.instabug.chat.eventbus.C0543a;
import com.instabug.chat.model.Attachment;
import com.instabug.chat.model.Chat;
import com.instabug.chat.model.Message;
import com.instabug.chat.model.Message.C0547b;
import com.instabug.chat.model.Message.MessageState;
import com.instabug.chat.network.InstabugMessageUploaderService;
import com.instabug.chat.ui.C0559a;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.internal.video.InternalScreenRecordHelper;
import com.instabug.library.internal.video.ScreenRecordEvent;
import com.instabug.library.internal.video.VideoProcessingService.Action;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.List;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: ExternalScreenRecordHelper */
public class C0536a {
    private static C0536a f9242d;
    public String f9243a;
    public Subscription f9244b;
    public Subscription f9245c;
    private String f9246e;

    /* compiled from: ExternalScreenRecordHelper */
    class C12971 implements Action1<ScreenRecordEvent> {
        final /* synthetic */ C0536a f15359a;

        public C12971(C0536a c0536a) {
            this.f15359a = c0536a;
        }

        public final /* synthetic */ void m15261a(Object obj) {
            ScreenRecordEvent screenRecordEvent = (ScreenRecordEvent) obj;
            if (screenRecordEvent.getStatus() == 1) {
                C0536a.m7888a(this.f15359a, screenRecordEvent.getVideoUri());
                C0536a.m7887a(this.f15359a);
            } else if (screenRecordEvent.getStatus() == 0) {
                C0536a.m7889a(this.f15359a, screenRecordEvent);
            } else {
                if (screenRecordEvent.getStatus() == 2) {
                    C0536a.m7892b(this.f15359a);
                    C0536a.m7887a(this.f15359a);
                }
            }
        }
    }

    /* compiled from: ExternalScreenRecordHelper */
    class C12982 implements Action1<Action> {
        final /* synthetic */ C0536a f15360a;

        public C12982(C0536a c0536a) {
            this.f15360a = c0536a;
        }

        public final /* synthetic */ void m15262a(Object obj) {
            if (this.f15360a.f9244b != null) {
                C0536a.m7887a(this.f15360a);
            }
        }
    }

    /* compiled from: ExternalScreenRecordHelper */
    class C12993 implements Action1<C0543a> {
        final /* synthetic */ String f15361a;
        final /* synthetic */ C0536a f15362b;

        public C12993(C0536a c0536a, String str) {
            this.f15362b = c0536a;
            this.f15361a = str;
        }

        public final /* synthetic */ void m15263a(Object obj) {
            C0543a c0543a = (C0543a) obj;
            if (this.f15361a.equalsIgnoreCase(c0543a.f9259a)) {
                this.f15362b.f9243a = c0543a.f9260b;
            }
        }
    }

    public static C0536a m7886a() {
        if (f9242d == null) {
            f9242d = new C0536a();
        }
        return f9242d;
    }

    public static boolean m7893b() {
        return InternalScreenRecordHelper.getInstance().isRecording();
    }

    private void m7891a(Message message, Uri uri) {
        for (Attachment attachment : message.f15384h) {
            if (attachment.getType().equals(Attachment.TYPE_VIDEO)) {
                InstabugSDKLogger.m8356d(this, "Setting attachment type to Video");
                attachment.setName(uri.getLastPathSegment());
                attachment.setLocalPath(uri.getPath());
                attachment.setVideoEncoded(true);
                return;
            }
        }
    }

    static /* synthetic */ void m7888a(C0536a c0536a, Uri uri) {
        Chat chat = ChatsCacheManager.getChat(c0536a.f9243a);
        if (chat != null) {
            List list = chat.f15373a;
            String str = c0536a.f9246e;
            for (int i = 0; i < list.size(); i++) {
                Message message = (Message) list.get(i);
                StringBuilder stringBuilder = new StringBuilder("getting message with ID: ");
                stringBuilder.append(message.f15377a);
                InstabugSDKLogger.m8356d(c0536a, stringBuilder.toString());
                if (message.f15377a.equals(str)) {
                    c0536a.m7891a(message, uri);
                    message.f15386j = MessageState.READY_TO_BE_SENT;
                }
            }
            uri = ChatsCacheManager.getCache();
            if (uri != null) {
                uri.put(chat.getId(), chat);
            }
            InstabugSDKLogger.m8356d(c0536a, "video is encoded and updated in its message");
            c0536a = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
            if (c0536a != null) {
                c0536a.startService(new Intent(c0536a, InstabugMessageUploaderService.class));
            }
            return;
        }
        InstabugSDKLogger.m8357e(c0536a, "Hanging Chat is null and can't be updated");
    }

    static /* synthetic */ void m7887a(C0536a c0536a) {
        if (!c0536a.f9244b.d()) {
            c0536a.f9244b.c();
        }
        if (!c0536a.f9245c.d()) {
            c0536a.f9245c.c();
        }
    }

    static /* synthetic */ void m7889a(C0536a c0536a, ScreenRecordEvent screenRecordEvent) {
        screenRecordEvent = screenRecordEvent.getVideoUri();
        String str = c0536a.f9243a;
        Message message = new Message();
        message.f15378b = str;
        message.f15379c = "";
        message.f15382f = InstabugDateFormatter.getCurrentUTCTimeStampInSeconds();
        message = message.m15279a(InstabugDateFormatter.getCurrentUTCTimeStampInSeconds()).m15280a(C0547b.INBOUND);
        if (screenRecordEvent != null) {
            Attachment attachment = new Attachment();
            attachment.setName(screenRecordEvent.getLastPathSegment());
            attachment.setLocalPath(screenRecordEvent.getPath());
            attachment.setType(Attachment.TYPE_VIDEO);
            attachment.setState(Attachment.STATE_OFFLINE);
            attachment.setVideoEncoded(null);
            screenRecordEvent = new StringBuilder("Adding hanging message with ID: ");
            screenRecordEvent.append(message.f15377a);
            InstabugSDKLogger.m8359i(c0536a, screenRecordEvent.toString());
            c0536a.f9246e = message.f15377a;
            message.f15386j = MessageState.STAY_OFFLINE;
            message.f15384h.add(attachment);
        }
        screenRecordEvent = ChatsCacheManager.getChat(str);
        if (!(screenRecordEvent == null || screenRecordEvent.f15373a == null)) {
            screenRecordEvent.f15373a.add(message);
            InMemoryCache cache = ChatsCacheManager.getCache();
            if (cache != null) {
                cache.put(screenRecordEvent.getId(), screenRecordEvent);
            }
        }
        screenRecordEvent = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (screenRecordEvent != null) {
            screenRecordEvent.startActivity(C0559a.m7965a(screenRecordEvent, c0536a.f9243a));
        }
    }

    static /* synthetic */ void m7892b(C0536a c0536a) {
        Chat chat = ChatsCacheManager.getChat(c0536a.f9243a);
        if (chat != null) {
            List list = chat.f15373a;
            for (int i = 0; i < list.size(); i++) {
                Message message = (Message) list.get(i);
                StringBuilder stringBuilder = new StringBuilder("getting message with ID: ");
                stringBuilder.append(message.f15377a);
                InstabugSDKLogger.m8356d(c0536a, stringBuilder.toString());
                if (message.f15377a.equals(c0536a.f9246e)) {
                    list.remove(message);
                    break;
                }
            }
            InMemoryCache cache = ChatsCacheManager.getCache();
            if (cache != null) {
                cache.put(chat.getId(), chat);
            }
            InstabugSDKLogger.m8356d(c0536a, "video message is removed from this chat");
            return;
        }
        InstabugSDKLogger.m8357e(c0536a, "Hanging Chat is null and can't remove video message");
    }
}
