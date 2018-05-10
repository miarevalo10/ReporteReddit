package com.instabug.chat.cache;

import android.content.Context;
import android.net.Uri;
import com.instabug.chat.model.Attachment;
import com.instabug.chat.model.Chat;
import com.instabug.chat.model.Chat.C0545b;
import com.instabug.chat.model.Chat.ChatState;
import com.instabug.chat.model.Message;
import com.instabug.chat.model.Message.C0546a;
import com.instabug.chat.model.Message.MessageState;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.internal.storage.cache.Cache;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.CacheManager.KeyExtractor;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.model.AssetEntity.AssetType;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ChatsCacheManager {
    public static final String CHATS_DISK_CACHE_FILE_NAME = "/chats.cache";
    public static final String CHATS_DISK_CACHE_KEY = "chats_disk_cache";
    public static final String CHATS_MEMORY_CACHE_KEY = "chats_memory_cache";

    static class C13011 extends KeyExtractor<String, Chat> {
        C13011() {
        }

        public final /* synthetic */ Object extractKey(Object obj) {
            return ((Chat) obj).getId();
        }
    }

    static class C13022 extends KeyExtractor<String, Chat> {
        C13022() {
        }

        public final /* synthetic */ Object extractKey(Object obj) {
            return ((Chat) obj).getId();
        }
    }

    public static InMemoryCache<String, Chat> getCache() throws IllegalArgumentException {
        if (!CacheManager.getInstance().cacheExists(CHATS_MEMORY_CACHE_KEY)) {
            StringBuilder stringBuilder = new StringBuilder("In-memory cache not found, loading it from disk ");
            stringBuilder.append(CacheManager.getInstance().getCache(CHATS_MEMORY_CACHE_KEY));
            InstabugSDKLogger.m8356d(ChatsCacheManager.class, stringBuilder.toString());
            CacheManager.getInstance().migrateCache(CHATS_DISK_CACHE_KEY, CHATS_MEMORY_CACHE_KEY, new C13011());
            Cache cache = CacheManager.getInstance().getCache(CHATS_MEMORY_CACHE_KEY);
            if (cache != null) {
                StringBuilder stringBuilder2 = new StringBuilder("In-memory cache restored from disk, ");
                stringBuilder2.append(cache.getValues().size());
                stringBuilder2.append(" elements restored");
                InstabugSDKLogger.m8356d(ChatsCacheManager.class, stringBuilder2.toString());
            }
        }
        InstabugSDKLogger.m8356d(ChatsCacheManager.class, "In-memory cache found");
        return (InMemoryCache) CacheManager.getInstance().getCache(CHATS_MEMORY_CACHE_KEY);
    }

    public static void saveCacheToDisk() throws IllegalArgumentException {
        Cache cache = CacheManager.getInstance().getCache(CHATS_MEMORY_CACHE_KEY);
        Cache cache2 = CacheManager.getInstance().getCache(CHATS_DISK_CACHE_KEY);
        if (!(cache == null || cache2 == null)) {
            CacheManager.getInstance().migrateCache(cache, cache2, new C13022());
        }
        if (cache2 != null) {
            StringBuilder stringBuilder = new StringBuilder("In-memory cache had been persisted on-disk, ");
            stringBuilder.append(cache2.getValues().size());
            stringBuilder.append(" elements saved");
            InstabugSDKLogger.m8356d(ChatsCacheManager.class, stringBuilder.toString());
        }
    }

    public static Chat addOfflineChat(Context context) {
        C0545b c0545b = new C0545b();
        context = C0545b.m7926a(context);
        InMemoryCache cache = getCache();
        if (cache != null) {
            cache.put(context.getId(), context);
        }
        return context;
    }

    public static Chat getChat(String str) {
        InMemoryCache cache = getCache();
        if (cache != null) {
            for (Chat chat : cache.getValues()) {
                if (chat.getId().equals(str)) {
                    return chat;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder("No chat with id: ");
        stringBuilder.append(str);
        stringBuilder.append(" found, returning null");
        InstabugSDKLogger.m8357e(ChatsCacheManager.class, stringBuilder.toString());
        return null;
    }

    public static List<Chat> getValidChats() {
        List<Chat> arrayList = new ArrayList();
        InMemoryCache cache = getCache();
        if (cache != null) {
            for (Chat chat : cache.getValues()) {
                if (chat.f15373a.size() > 0) {
                    arrayList.add(chat);
                }
            }
        }
        return arrayList;
    }

    public static List<Chat> getOfflineChats() {
        List<Chat> arrayList = new ArrayList();
        InMemoryCache cache = getCache();
        if (cache != null) {
            for (Chat chat : cache.getValues()) {
                StringBuilder stringBuilder = new StringBuilder("chat state: ");
                stringBuilder.append(chat.f15374b);
                stringBuilder.append(", messages count: ");
                stringBuilder.append(chat.f15373a.size());
                InstabugSDKLogger.m8360v(ChatsCacheManager.class, stringBuilder.toString());
                if ((chat.f15374b.equals(ChatState.READY_TO_BE_SENT) || chat.f15374b.equals(ChatState.LOGS_READY_TO_BE_UPLOADED)) && chat.f15373a.size() > 0) {
                    arrayList.add(chat);
                }
            }
        }
        return arrayList;
    }

    public static void updateLocalMessageWithSyncedMessage(Context context, Message message) throws IOException {
        InMemoryCache cache = getCache();
        if (cache != null) {
            Chat chat = (Chat) cache.get(message.f15378b);
            List list = chat.f15373a;
            int i = 0;
            while (i < list.size()) {
                if (((Message) list.get(i)).f15377a.equals(message.f15377a) && ((Message) list.get(i)).f15386j.equals(MessageState.READY_TO_BE_SYNCED) && ((Message) list.get(i)).f15384h.size() == message.f15384h.size()) {
                    for (int i2 = 0; i2 < ((Message) list.get(i)).f15384h.size(); i2++) {
                        Object obj;
                        AssetEntity createEmptyEntity;
                        File file;
                        boolean delete;
                        StringBuilder stringBuilder;
                        String type = ((Attachment) message.f15384h.get(i2)).getType();
                        int hashCode = type.hashCode();
                        if (hashCode != 93166550) {
                            if (hashCode != 100313435) {
                                if (hashCode == 112202875) {
                                    if (type.equals(Attachment.TYPE_VIDEO)) {
                                        obj = 2;
                                        switch (obj) {
                                            case null:
                                                createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.IMAGE);
                                                break;
                                            case 1:
                                                createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.AUDIO);
                                                break;
                                            case 2:
                                                createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.VIDEO);
                                                break;
                                            default:
                                                createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.IMAGE);
                                                break;
                                        }
                                        file = new File(((Attachment) ((Message) list.get(i)).f15384h.get(i2)).getLocalPath());
                                        DiskUtils.copyFromUriIntoFile(context, Uri.fromFile(file), createEmptyEntity.getFile());
                                        AssetsCacheManager.addAssetEntity(createEmptyEntity);
                                        delete = file.delete();
                                        stringBuilder = new StringBuilder("local attachment file deleted: ");
                                        stringBuilder.append(delete);
                                        InstabugSDKLogger.m8360v(ChatsCacheManager.class, stringBuilder.toString());
                                    }
                                }
                            } else if (type.equals(Attachment.TYPE_IMAGE)) {
                                obj = null;
                                switch (obj) {
                                    case null:
                                        createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.IMAGE);
                                        break;
                                    case 1:
                                        createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.AUDIO);
                                        break;
                                    case 2:
                                        createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.VIDEO);
                                        break;
                                    default:
                                        createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.IMAGE);
                                        break;
                                }
                                file = new File(((Attachment) ((Message) list.get(i)).f15384h.get(i2)).getLocalPath());
                                DiskUtils.copyFromUriIntoFile(context, Uri.fromFile(file), createEmptyEntity.getFile());
                                AssetsCacheManager.addAssetEntity(createEmptyEntity);
                                delete = file.delete();
                                stringBuilder = new StringBuilder("local attachment file deleted: ");
                                stringBuilder.append(delete);
                                InstabugSDKLogger.m8360v(ChatsCacheManager.class, stringBuilder.toString());
                            }
                        } else if (type.equals(Attachment.TYPE_AUDIO)) {
                            obj = 1;
                            switch (obj) {
                                case null:
                                    createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.IMAGE);
                                    break;
                                case 1:
                                    createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.AUDIO);
                                    break;
                                case 2:
                                    createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.VIDEO);
                                    break;
                                default:
                                    createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.IMAGE);
                                    break;
                            }
                            file = new File(((Attachment) ((Message) list.get(i)).f15384h.get(i2)).getLocalPath());
                            DiskUtils.copyFromUriIntoFile(context, Uri.fromFile(file), createEmptyEntity.getFile());
                            AssetsCacheManager.addAssetEntity(createEmptyEntity);
                            delete = file.delete();
                            stringBuilder = new StringBuilder("local attachment file deleted: ");
                            stringBuilder.append(delete);
                            InstabugSDKLogger.m8360v(ChatsCacheManager.class, stringBuilder.toString());
                        }
                        obj = -1;
                        switch (obj) {
                            case null:
                                createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.IMAGE);
                                break;
                            case 1:
                                createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.AUDIO);
                                break;
                            case 2:
                                createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.VIDEO);
                                break;
                            default:
                                createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, ((Attachment) message.f15384h.get(i2)).getUrl(), AssetType.IMAGE);
                                break;
                        }
                        file = new File(((Attachment) ((Message) list.get(i)).f15384h.get(i2)).getLocalPath());
                        DiskUtils.copyFromUriIntoFile(context, Uri.fromFile(file), createEmptyEntity.getFile());
                        AssetsCacheManager.addAssetEntity(createEmptyEntity);
                        delete = file.delete();
                        stringBuilder = new StringBuilder("local attachment file deleted: ");
                        stringBuilder.append(delete);
                        InstabugSDKLogger.m8360v(ChatsCacheManager.class, stringBuilder.toString());
                    }
                    chat.f15373a.set(i, message);
                    message = new StringBuilder("messages number: ");
                    message.append(chat.f15373a.size());
                    InstabugSDKLogger.m8360v(ChatsCacheManager.class, message.toString());
                    message = new StringBuilder("messages: ");
                    message.append(chat.f15373a.get(i));
                    InstabugSDKLogger.m8360v(ChatsCacheManager.class, message.toString());
                    cache.put(chat.getId(), chat);
                    return;
                }
                i++;
            }
        }
    }

    public static int getTotalMessagesCount() {
        InMemoryCache cache = getCache();
        int i = 0;
        if (cache != null) {
            for (Chat chat : cache.getValues()) {
                Iterator it = chat.f15373a.iterator();
                while (it.hasNext()) {
                    if (((Message) it.next()).f15386j.equals(MessageState.SYNCED)) {
                        i++;
                    }
                }
            }
        }
        return i;
    }

    public static List<Message> getOfflineMessages() {
        List<Message> arrayList = new ArrayList();
        InMemoryCache cache = getCache();
        if (cache != null) {
            for (Chat chat : cache.getValues()) {
                if (chat.f15374b.equals(ChatState.SENT)) {
                    Iterator it = chat.f15373a.iterator();
                    while (it.hasNext()) {
                        Message message = (Message) it.next();
                        if (message.f15386j.equals(MessageState.READY_TO_BE_SENT) || message.f15386j.equals(MessageState.SENT)) {
                            arrayList.add(message);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static long getLastMessageMessagedAt() {
        List arrayList = new ArrayList();
        InMemoryCache cache = getCache();
        if (cache != null) {
            for (Chat chat : cache.getValues()) {
                Iterator it = chat.f15373a.iterator();
                while (it.hasNext()) {
                    Message message = (Message) it.next();
                    if (message.f15386j == MessageState.SYNCED) {
                        arrayList.add(message);
                    }
                }
            }
        }
        Collections.sort(arrayList, new C0546a());
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Message message2 = (Message) arrayList.get(size);
            if (!message2.f15377a.equals("0")) {
                return message2.f15382f;
            }
        }
        return 0;
    }

    public static int getUnreadCount() {
        InMemoryCache cache = getCache();
        int i = 0;
        if (cache != null) {
            for (Chat a : cache.getValues()) {
                i += a.m15270a();
            }
        }
        return i;
    }

    public static List<Message> getNotSentMessages() {
        List<Message> arrayList = new ArrayList();
        InMemoryCache cache = getCache();
        if (cache != null) {
            for (Chat chat : cache.getValues()) {
                Iterator it = chat.f15373a.iterator();
                while (it.hasNext()) {
                    Message message = (Message) it.next();
                    if (message.f15386j == MessageState.SENT || message.f15386j == MessageState.READY_TO_BE_SENT) {
                        arrayList.add(message);
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder("not sent messages count: ");
        stringBuilder.append(arrayList.size());
        InstabugSDKLogger.m8360v(ChatsCacheManager.class, stringBuilder.toString());
        return arrayList;
    }

    public static void cleanupChats() {
        InstabugSDKLogger.m8360v(ChatsCacheManager.class, "cleanupChats");
        InMemoryCache cache = getCache();
        if (cache != null) {
            List<Chat> values = cache.getValues();
            List<Chat> arrayList = new ArrayList();
            for (Chat chat : values) {
                if (chat.f15374b == ChatState.WAITING_ATTACHMENT_MESSAGE) {
                    arrayList.add(chat);
                }
            }
            for (Chat id : arrayList) {
                cache.delete(id.getId());
            }
        }
        saveCacheToDisk();
    }
}
