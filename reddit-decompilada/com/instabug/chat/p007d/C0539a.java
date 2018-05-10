package com.instabug.chat.p007d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.instabug.chat.cache.ChatsCacheManager;
import com.instabug.chat.model.Attachment;
import com.instabug.chat.model.C1308b;
import com.instabug.chat.model.Chat;
import com.instabug.chat.model.Message;
import com.instabug.chat.model.Message.C0547b;
import com.instabug.chat.model.Message.MessageState;
import com.instabug.chat.settings.C0554a;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.List;
import net.hockeyapp.android.UpdateFragment;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: NewMessagesHandler */
public class C0539a {
    private static C0539a f9247a;
    private List<C0540b> f9248b = new ArrayList();

    public static C0539a m7900a() {
        if (f9247a == null) {
            f9247a = new C0539a();
        }
        return f9247a;
    }

    public final void m7910a(Context context, boolean z, JSONObject... jSONObjectArr) {
        List<Message> a = m7903a(jSONObjectArr);
        List arrayList = new ArrayList(a);
        for (Message message : a) {
            Message b = m7907b(message);
            Object obj = null;
            Object obj2 = (b != null && b.f15377a.equals(message.f15377a) && b.f15386j.equals(MessageState.SYNCED) && b.f15384h.size() == message.f15384h.size()) ? 1 : null;
            if (obj2 == null && !m7909c(message)) {
                b = m7907b(message);
                if (b != null && b.f15377a.equals(message.f15377a) && b.f15386j.equals(MessageState.SENT) && b.f15384h.size() != message.f15384h.size()) {
                    obj = 1;
                }
                if (!(obj != null || message.m15281a() || message.f15383g)) {
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Message ");
            stringBuilder.append(message.toString());
            stringBuilder.append(" removed from list to be notified");
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            arrayList.remove(message);
        }
        if (z) {
            InstabugSDKLogger.m8360v(this, "START Invalidate Cache");
            List notSentMessages = ChatsCacheManager.getNotSentMessages();
            InMemoryCache cache = ChatsCacheManager.getCache();
            if (cache != null) {
                cache.invalidate();
            }
            InstabugSDKLogger.m8360v(this, "finish Invalidate Cache");
            m7904a(context, C0539a.m7902a((List) a, notSentMessages));
        } else {
            m7904a(context, (List) a);
        }
        if (arrayList.size() > null && C0554a.m7932a() != null) {
            try {
                new Handler(Looper.getMainLooper()).post(C0554a.m7932a());
            } catch (Context context2) {
                InstabugSDKLogger.m8358e(this, "new message runnable failed to run.", context2);
            }
        }
        if (this.f9248b.size() > null) {
            m7905a(arrayList);
            return;
        }
        throw new IllegalStateException("No one is listening for unread messages");
    }

    private void m7904a(Context context, List<Message> list) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder("new messages count: ");
        stringBuilder2.append(list.size());
        InstabugSDKLogger.m8360v(this, stringBuilder2.toString());
        for (Message message : list) {
            StringBuilder stringBuilder3 = new StringBuilder("new message to updating: ");
            stringBuilder3.append(message.toString());
            InstabugSDKLogger.m8360v(this, stringBuilder3.toString());
            if ((m7907b(message) == null ? 1 : null) != null) {
                Chat a = m7901a(message);
                if (a == null) {
                    stringBuilder3 = new StringBuilder("Chat with id ");
                    stringBuilder3.append(message.f15378b);
                    stringBuilder3.append(" doesn't exist, creating new one");
                    InstabugSDKLogger.m8360v(this, stringBuilder3.toString());
                    a = new Chat(message.f15378b);
                }
                a.f15373a.add(message);
                stringBuilder = new StringBuilder("Message ");
                stringBuilder.append(message);
                stringBuilder.append(" added to cached chat: ");
                stringBuilder.append(a);
                InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                InMemoryCache cache = ChatsCacheManager.getCache();
                if (cache != null) {
                    cache.put(a.getId(), a);
                }
            } else if (m7909c(message)) {
                stringBuilder3 = new StringBuilder("Message:");
                stringBuilder3.append(message);
                stringBuilder3.append(" is ready to be synced");
                InstabugSDKLogger.m8360v(this, stringBuilder3.toString());
                try {
                    ChatsCacheManager.updateLocalMessageWithSyncedMessage(context, message);
                } catch (Throwable e) {
                    stringBuilder = new StringBuilder("Failed to update local message: ");
                    stringBuilder.append(m7907b(message));
                    stringBuilder.append(" with synced message: ");
                    stringBuilder.append(message);
                    InstabugSDKLogger.m8358e(this, stringBuilder.toString(), e);
                }
            }
        }
    }

    private static List<Message> m7902a(List<Message> list, List<Message> list2) {
        List<Message> arrayList = new ArrayList(list);
        for (Message message : list2) {
            if (C0539a.m7906a(message, (List) list)) {
                arrayList.add(message);
            }
            if (message.f15386j == MessageState.SENT && C0539a.m7908b(message, list) != null) {
                arrayList.remove(C0539a.m7908b(message, list));
            }
        }
        return arrayList;
    }

    private static boolean m7906a(Message message, List<Message> list) {
        for (Message message2 : list) {
            if (message.f15378b.equals(message2.f15378b)) {
                return true;
            }
        }
        return null;
    }

    private static Message m7908b(Message message, List<Message> list) {
        for (Message message2 : list) {
            if (message.f15377a.equals(message2.f15377a)) {
                return message2;
            }
        }
        return null;
    }

    private Chat m7901a(Message message) {
        InMemoryCache cache = ChatsCacheManager.getCache();
        if (cache != null) {
            Chat chat = (Chat) cache.get(message.f15378b);
            if (chat != null) {
                return chat;
            }
        }
        InstabugSDKLogger.m8360v(this, "No local chats match messages's chat");
        return null;
    }

    private boolean m7909c(Message message) {
        Message b = m7907b(message);
        return (b != null && b.f15377a.equals(message.f15377a) && b.f15386j.equals(MessageState.READY_TO_BE_SYNCED) && b.f15384h.size() == message.f15384h.size()) ? true : null;
    }

    private void m7905a(List<Message> list) {
        if (C0554a.m7951f()) {
            StringBuilder stringBuilder = new StringBuilder("Number of listeners to notify ");
            stringBuilder.append(this.f9248b.size());
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            for (int size = this.f9248b.size() - 1; size >= 0; size--) {
                C0540b c0540b = (C0540b) this.f9248b.get(size);
                StringBuilder stringBuilder2 = new StringBuilder("Notifying listener ");
                stringBuilder2.append(c0540b);
                InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                if (list == null || list.size() <= 0) {
                    break;
                }
                stringBuilder2 = new StringBuilder("Notifying listener with ");
                stringBuilder2.append(list.size());
                stringBuilder2.append(" message(s)");
                InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                list = c0540b.onNewMessagesReceived(list);
                StringBuilder stringBuilder3 = new StringBuilder("Notified listener remained ");
                stringBuilder3.append(list != null ? Integer.valueOf(list.size()) : null);
                stringBuilder3.append(" message(s) to be sent to next listener");
                InstabugSDKLogger.m8356d(this, stringBuilder3.toString());
            }
            return;
        }
        stringBuilder = new StringBuilder("Chat notification disabled, messages that would not be notified ");
        stringBuilder.append(list);
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
    }

    public final void m7911a(C0540b c0540b) {
        if (!this.f9248b.contains(c0540b)) {
            this.f9248b.add(c0540b);
        }
    }

    public final void m7912b(C0540b c0540b) {
        this.f9248b.remove(c0540b);
    }

    private List<Message> m7903a(JSONObject[] jSONObjectArr) {
        List<Message> arrayList = new ArrayList();
        for (int i = 0; i < jSONObjectArr.length; i++) {
            try {
                int i2;
                JSONObject jSONObject;
                JSONObject jSONObject2;
                Attachment attachment;
                String string;
                int hashCode;
                JSONObject jSONObject3;
                C1308b c1308b;
                JSONObject jSONObject4 = jSONObjectArr[i];
                JSONArray jSONArray = jSONObject4.getJSONArray("attachments");
                JSONArray jSONArray2 = jSONObject4.getJSONArray("actions");
                Message message = new Message(jSONObject4.getString("id"));
                message.f15378b = jSONObject4.getString("chat_number");
                message.f15379c = jSONObject4.getString("body");
                message.f15380d = jSONObject4.getJSONObject("from").getString("name");
                message.f15381e = jSONObject4.getString("avatar");
                message.f15386j = MessageState.SYNCED;
                if (!(jSONObject4.getString("messaged_at") == null || jSONObject4.getString("messaged_at").equals("") || jSONObject4.getString("messaged_at").equals("null") || InstabugDateFormatter.getDate(jSONObject4.getString("messaged_at")) == null)) {
                    message.f15382f = InstabugDateFormatter.getDate(jSONObject4.getString("messaged_at")).getTime() / 1000;
                }
                if (!(jSONObject4.getString("read_at") == null || jSONObject4.getString("read_at").equals("") || jSONObject4.getString("read_at").equals("null") || InstabugDateFormatter.getDate(jSONObject4.getString("read_at")) == null)) {
                    message.m15279a(InstabugDateFormatter.getDate(jSONObject4.getString("read_at")).getTime() / 1000);
                }
                String string2 = jSONObject4.getString("direction");
                int hashCode2 = string2.hashCode();
                if (hashCode2 != 57076464) {
                    if (hashCode2 == 1941740409) {
                        if (string2.equals("inbound")) {
                            i2 = 0;
                            switch (i2) {
                                case 0:
                                    message.m15280a(C0547b.INBOUND);
                                    break;
                                case 1:
                                    message.m15280a(C0547b.OUTBOUND);
                                    break;
                                default:
                                    break;
                            }
                            for (i2 = jSONArray.length() - 1; i2 >= 0; i2--) {
                                jSONObject = jSONArray.getJSONObject(i2);
                                jSONObject2 = jSONObject.getJSONObject("metadata");
                                attachment = new Attachment();
                                attachment.setUrl(jSONObject.getString(UpdateFragment.FRAGMENT_URL));
                                attachment.setState(Attachment.STATE_SYNCED);
                                string = jSONObject2.getString("file_type");
                                hashCode = string.hashCode();
                                if (hashCode != 93166550) {
                                    if (hashCode != 100313435) {
                                        if (hashCode != 112202875) {
                                            if (hashCode != 216616442) {
                                                if (string.equals("main-screenshot")) {
                                                    hashCode2 = 3;
                                                    switch (hashCode2) {
                                                        case 0:
                                                            attachment.setType(Attachment.TYPE_AUDIO);
                                                            attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                                                            break;
                                                        case 1:
                                                            attachment.setType(Attachment.TYPE_VIDEO);
                                                            break;
                                                        case 2:
                                                            attachment.setType(Attachment.TYPE_IMAGE);
                                                            break;
                                                        case 3:
                                                            attachment.setType(Attachment.TYPE_IMAGE);
                                                            break;
                                                        default:
                                                            break;
                                                    }
                                                    message.f15384h.add(attachment);
                                                }
                                            }
                                        } else if (string.equals(Attachment.TYPE_VIDEO)) {
                                            hashCode2 = 1;
                                            switch (hashCode2) {
                                                case 0:
                                                    attachment.setType(Attachment.TYPE_AUDIO);
                                                    attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                                                    break;
                                                case 1:
                                                    attachment.setType(Attachment.TYPE_VIDEO);
                                                    break;
                                                case 2:
                                                    attachment.setType(Attachment.TYPE_IMAGE);
                                                    break;
                                                case 3:
                                                    attachment.setType(Attachment.TYPE_IMAGE);
                                                    break;
                                                default:
                                                    break;
                                            }
                                            message.f15384h.add(attachment);
                                        }
                                    } else if (string.equals(Attachment.TYPE_IMAGE)) {
                                        hashCode2 = 2;
                                        switch (hashCode2) {
                                            case 0:
                                                attachment.setType(Attachment.TYPE_AUDIO);
                                                attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                                                break;
                                            case 1:
                                                attachment.setType(Attachment.TYPE_VIDEO);
                                                break;
                                            case 2:
                                                attachment.setType(Attachment.TYPE_IMAGE);
                                                break;
                                            case 3:
                                                attachment.setType(Attachment.TYPE_IMAGE);
                                                break;
                                            default:
                                                break;
                                        }
                                        message.f15384h.add(attachment);
                                    }
                                } else if (string.equals(Attachment.TYPE_AUDIO)) {
                                    hashCode2 = 0;
                                    switch (hashCode2) {
                                        case 0:
                                            attachment.setType(Attachment.TYPE_AUDIO);
                                            attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                                            break;
                                        case 1:
                                            attachment.setType(Attachment.TYPE_VIDEO);
                                            break;
                                        case 2:
                                            attachment.setType(Attachment.TYPE_IMAGE);
                                            break;
                                        case 3:
                                            attachment.setType(Attachment.TYPE_IMAGE);
                                            break;
                                        default:
                                            break;
                                    }
                                    message.f15384h.add(attachment);
                                }
                                hashCode2 = -1;
                                switch (hashCode2) {
                                    case 0:
                                        attachment.setType(Attachment.TYPE_AUDIO);
                                        attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                                        break;
                                    case 1:
                                        attachment.setType(Attachment.TYPE_VIDEO);
                                        break;
                                    case 2:
                                        attachment.setType(Attachment.TYPE_IMAGE);
                                        break;
                                    case 3:
                                        attachment.setType(Attachment.TYPE_IMAGE);
                                        break;
                                    default:
                                        break;
                                }
                                message.f15384h.add(attachment);
                            }
                            for (i2 = jSONArray2.length() - 1; i2 >= 0; i2--) {
                                jSONObject3 = jSONArray2.getJSONObject(i2);
                                c1308b = new C1308b();
                                c1308b.fromJson(jSONObject3.toString());
                                message.f15385i.add(c1308b);
                            }
                            arrayList.add(message);
                        }
                    }
                } else if (string2.equals("outbound")) {
                    i2 = 1;
                    switch (i2) {
                        case 0:
                            message.m15280a(C0547b.INBOUND);
                            break;
                        case 1:
                            message.m15280a(C0547b.OUTBOUND);
                            break;
                        default:
                            break;
                    }
                    for (i2 = jSONArray.length() - 1; i2 >= 0; i2--) {
                        jSONObject = jSONArray.getJSONObject(i2);
                        jSONObject2 = jSONObject.getJSONObject("metadata");
                        attachment = new Attachment();
                        attachment.setUrl(jSONObject.getString(UpdateFragment.FRAGMENT_URL));
                        attachment.setState(Attachment.STATE_SYNCED);
                        string = jSONObject2.getString("file_type");
                        hashCode = string.hashCode();
                        if (hashCode != 93166550) {
                            if (string.equals(Attachment.TYPE_AUDIO)) {
                                hashCode2 = 0;
                                switch (hashCode2) {
                                    case 0:
                                        attachment.setType(Attachment.TYPE_AUDIO);
                                        attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                                        break;
                                    case 1:
                                        attachment.setType(Attachment.TYPE_VIDEO);
                                        break;
                                    case 2:
                                        attachment.setType(Attachment.TYPE_IMAGE);
                                        break;
                                    case 3:
                                        attachment.setType(Attachment.TYPE_IMAGE);
                                        break;
                                    default:
                                        break;
                                }
                                message.f15384h.add(attachment);
                            }
                        } else if (hashCode != 100313435) {
                            if (string.equals(Attachment.TYPE_IMAGE)) {
                                hashCode2 = 2;
                                switch (hashCode2) {
                                    case 0:
                                        attachment.setType(Attachment.TYPE_AUDIO);
                                        attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                                        break;
                                    case 1:
                                        attachment.setType(Attachment.TYPE_VIDEO);
                                        break;
                                    case 2:
                                        attachment.setType(Attachment.TYPE_IMAGE);
                                        break;
                                    case 3:
                                        attachment.setType(Attachment.TYPE_IMAGE);
                                        break;
                                    default:
                                        break;
                                }
                                message.f15384h.add(attachment);
                            }
                        } else if (hashCode != 112202875) {
                            if (string.equals(Attachment.TYPE_VIDEO)) {
                                hashCode2 = 1;
                                switch (hashCode2) {
                                    case 0:
                                        attachment.setType(Attachment.TYPE_AUDIO);
                                        attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                                        break;
                                    case 1:
                                        attachment.setType(Attachment.TYPE_VIDEO);
                                        break;
                                    case 2:
                                        attachment.setType(Attachment.TYPE_IMAGE);
                                        break;
                                    case 3:
                                        attachment.setType(Attachment.TYPE_IMAGE);
                                        break;
                                    default:
                                        break;
                                }
                                message.f15384h.add(attachment);
                            }
                        } else if (hashCode != 216616442) {
                            if (string.equals("main-screenshot")) {
                                hashCode2 = 3;
                                switch (hashCode2) {
                                    case 0:
                                        attachment.setType(Attachment.TYPE_AUDIO);
                                        attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                                        break;
                                    case 1:
                                        attachment.setType(Attachment.TYPE_VIDEO);
                                        break;
                                    case 2:
                                        attachment.setType(Attachment.TYPE_IMAGE);
                                        break;
                                    case 3:
                                        attachment.setType(Attachment.TYPE_IMAGE);
                                        break;
                                    default:
                                        break;
                                }
                                message.f15384h.add(attachment);
                            }
                        }
                        hashCode2 = -1;
                        switch (hashCode2) {
                            case 0:
                                attachment.setType(Attachment.TYPE_AUDIO);
                                attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                                break;
                            case 1:
                                attachment.setType(Attachment.TYPE_VIDEO);
                                break;
                            case 2:
                                attachment.setType(Attachment.TYPE_IMAGE);
                                break;
                            case 3:
                                attachment.setType(Attachment.TYPE_IMAGE);
                                break;
                            default:
                                break;
                        }
                        message.f15384h.add(attachment);
                    }
                    for (i2 = jSONArray2.length() - 1; i2 >= 0; i2--) {
                        jSONObject3 = jSONArray2.getJSONObject(i2);
                        c1308b = new C1308b();
                        c1308b.fromJson(jSONObject3.toString());
                        message.f15385i.add(c1308b);
                    }
                    arrayList.add(message);
                }
                i2 = -1;
                switch (i2) {
                    case 0:
                        message.m15280a(C0547b.INBOUND);
                        break;
                    case 1:
                        message.m15280a(C0547b.OUTBOUND);
                        break;
                    default:
                        break;
                }
                for (i2 = jSONArray.length() - 1; i2 >= 0; i2--) {
                    jSONObject = jSONArray.getJSONObject(i2);
                    jSONObject2 = jSONObject.getJSONObject("metadata");
                    attachment = new Attachment();
                    attachment.setUrl(jSONObject.getString(UpdateFragment.FRAGMENT_URL));
                    attachment.setState(Attachment.STATE_SYNCED);
                    string = jSONObject2.getString("file_type");
                    hashCode = string.hashCode();
                    if (hashCode != 93166550) {
                        if (hashCode != 100313435) {
                            if (hashCode != 112202875) {
                                if (hashCode != 216616442) {
                                    if (string.equals("main-screenshot")) {
                                        hashCode2 = 3;
                                        switch (hashCode2) {
                                            case 0:
                                                attachment.setType(Attachment.TYPE_AUDIO);
                                                attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                                                break;
                                            case 1:
                                                attachment.setType(Attachment.TYPE_VIDEO);
                                                break;
                                            case 2:
                                                attachment.setType(Attachment.TYPE_IMAGE);
                                                break;
                                            case 3:
                                                attachment.setType(Attachment.TYPE_IMAGE);
                                                break;
                                            default:
                                                break;
                                        }
                                        message.f15384h.add(attachment);
                                    }
                                }
                            } else if (string.equals(Attachment.TYPE_VIDEO)) {
                                hashCode2 = 1;
                                switch (hashCode2) {
                                    case 0:
                                        attachment.setType(Attachment.TYPE_AUDIO);
                                        attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                                        break;
                                    case 1:
                                        attachment.setType(Attachment.TYPE_VIDEO);
                                        break;
                                    case 2:
                                        attachment.setType(Attachment.TYPE_IMAGE);
                                        break;
                                    case 3:
                                        attachment.setType(Attachment.TYPE_IMAGE);
                                        break;
                                    default:
                                        break;
                                }
                                message.f15384h.add(attachment);
                            }
                        } else if (string.equals(Attachment.TYPE_IMAGE)) {
                            hashCode2 = 2;
                            switch (hashCode2) {
                                case 0:
                                    attachment.setType(Attachment.TYPE_AUDIO);
                                    attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                                    break;
                                case 1:
                                    attachment.setType(Attachment.TYPE_VIDEO);
                                    break;
                                case 2:
                                    attachment.setType(Attachment.TYPE_IMAGE);
                                    break;
                                case 3:
                                    attachment.setType(Attachment.TYPE_IMAGE);
                                    break;
                                default:
                                    break;
                            }
                            message.f15384h.add(attachment);
                        }
                    } else if (string.equals(Attachment.TYPE_AUDIO)) {
                        hashCode2 = 0;
                        switch (hashCode2) {
                            case 0:
                                attachment.setType(Attachment.TYPE_AUDIO);
                                attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                                break;
                            case 1:
                                attachment.setType(Attachment.TYPE_VIDEO);
                                break;
                            case 2:
                                attachment.setType(Attachment.TYPE_IMAGE);
                                break;
                            case 3:
                                attachment.setType(Attachment.TYPE_IMAGE);
                                break;
                            default:
                                break;
                        }
                        message.f15384h.add(attachment);
                    }
                    hashCode2 = -1;
                    switch (hashCode2) {
                        case 0:
                            attachment.setType(Attachment.TYPE_AUDIO);
                            attachment.setDuration(jSONObject2.getString(State.KEY_DURATION));
                            break;
                        case 1:
                            attachment.setType(Attachment.TYPE_VIDEO);
                            break;
                        case 2:
                            attachment.setType(Attachment.TYPE_IMAGE);
                            break;
                        case 3:
                            attachment.setType(Attachment.TYPE_IMAGE);
                            break;
                        default:
                            break;
                    }
                    message.f15384h.add(attachment);
                }
                for (i2 = jSONArray2.length() - 1; i2 >= 0; i2--) {
                    jSONObject3 = jSONArray2.getJSONObject(i2);
                    c1308b = new C1308b();
                    c1308b.fromJson(jSONObject3.toString());
                    message.f15385i.add(c1308b);
                }
                arrayList.add(message);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder("Failed to parse message number ");
                stringBuilder.append(i);
                InstabugSDKLogger.m8358e(this, stringBuilder.toString(), e);
            }
        }
        return arrayList;
    }

    private Message m7907b(Message message) {
        Chat a = m7901a(message);
        List<Message> list = a == null ? null : a.f15373a;
        if (list != null) {
            for (Message message2 : list) {
                if (message2.f15377a.equals(message.f15377a)) {
                    return message2;
                }
            }
        }
        return null;
    }
}
