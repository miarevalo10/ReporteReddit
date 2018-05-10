package com.instabug.chat.network;

import android.content.Context;
import com.instabug.chat.cache.ChatsCacheManager;
import com.instabug.chat.eventbus.C0543a;
import com.instabug.chat.eventbus.ChatTimeUpdatedEventBus;
import com.instabug.chat.eventbus.ChatTriggeringEventBus;
import com.instabug.chat.model.Attachment;
import com.instabug.chat.model.Chat;
import com.instabug.chat.model.Chat.ChatState;
import com.instabug.chat.model.Message;
import com.instabug.chat.model.Message.MessageState;
import com.instabug.chat.network.p008a.C0553a;
import com.instabug.chat.network.p008a.C0553a.C16332;
import com.instabug.chat.settings.C0554a;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.model.State;
import com.instabug.library.network.InstabugNetworkBasedBackgroundService;
import com.instabug.library.network.Request;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.Request.Endpoint;
import com.instabug.library.network.Request.RequestMethod;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;

public class InstabugMessageUploaderService extends InstabugNetworkBasedBackgroundService {
    private void m19405a(List<Message> list) throws IOException, JSONException {
        StringBuilder stringBuilder = new StringBuilder("Found ");
        stringBuilder.append(list.size());
        stringBuilder.append(" offline messages in cache");
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        for (int i = 0; i < list.size(); i++) {
            final Message message = (Message) list.get(i);
            StringBuilder stringBuilder2;
            if (message.f15386j == MessageState.READY_TO_BE_SENT) {
                stringBuilder2 = new StringBuilder("Uploading message: ");
                stringBuilder2.append(list.get(i));
                InstabugSDKLogger.m8360v(this, stringBuilder2.toString());
                C0553a a = C0553a.m7928a();
                Callbacks c13112 = new Callbacks<String, Throwable>(this) {
                    final /* synthetic */ InstabugMessageUploaderService f15398b;

                    public /* synthetic */ void onFailed(Object obj) {
                        InstabugSDKLogger.m8358e(this.f15398b, "Something went wrong while uploading cached message", (Throwable) obj);
                    }

                    public /* synthetic */ void onSucceeded(Object obj) {
                        String str = (String) obj;
                        InstabugMessageUploaderService instabugMessageUploaderService = this.f15398b;
                        StringBuilder stringBuilder = new StringBuilder("Send message response: ");
                        stringBuilder.append(str);
                        InstabugSDKLogger.m8360v(instabugMessageUploaderService, stringBuilder.toString());
                        if (!(str == null || str.equals("") || str.equals("null"))) {
                            Chat chat = ChatsCacheManager.getChat(message.f15378b);
                            if (chat != null) {
                                chat.f15373a.remove(message);
                                message.f15377a = str;
                                if (message.f15384h.size() == null) {
                                    message.f15386j = MessageState.READY_TO_BE_SYNCED;
                                } else {
                                    message.f15386j = MessageState.SENT;
                                }
                                obj = this.f15398b;
                                stringBuilder = new StringBuilder("Caching sent message:");
                                stringBuilder.append(message.toString());
                                InstabugSDKLogger.m8360v(obj, stringBuilder.toString());
                                chat.f15373a.add(message);
                                obj = ChatsCacheManager.getCache();
                                if (obj != null) {
                                    obj.put(chat.getId(), chat);
                                }
                                ChatsCacheManager.saveCacheToDisk();
                                if (message.f15384h.size() == null) {
                                    C0554a.m7934a(Calendar.getInstance(Locale.ENGLISH).getTime().getTime());
                                    ChatTimeUpdatedEventBus.getInstance().post(Long.valueOf(InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds()));
                                    return;
                                }
                                try {
                                    this.f15398b.m19402a(message);
                                    return;
                                } catch (Object obj2) {
                                    instabugMessageUploaderService = this.f15398b;
                                    stringBuilder = new StringBuilder("Something went wrong while uploading messageattach attachments ");
                                    stringBuilder.append(obj2.getMessage());
                                    InstabugSDKLogger.m8360v(instabugMessageUploaderService, stringBuilder.toString());
                                    return;
                                }
                            }
                            InstabugSDKLogger.m8357e(this, "Chat is null so can't remove message from it");
                        }
                    }
                };
                InstabugSDKLogger.m8360v(a, "Sending message");
                Request buildRequest = a.f9293a.buildRequest((Context) this, Endpoint.SendMessage, RequestMethod.Post);
                buildRequest.setEndpoint(buildRequest.getEndpoint().replaceAll(":chat_number", message.f15378b));
                buildRequest.addParameter("message", new JSONObject().put("body", message.f15379c).put("messaged_at", message.f15382f).put(State.KEY_EMAIL, InstabugCore.getUserEmail()).put("name", InstabugCore.getUsername()));
                Observable.a(new C16332(a, c13112), a.f9293a.doRequest(buildRequest));
            } else if (message.f15386j == MessageState.SENT) {
                stringBuilder2 = new StringBuilder("Uploading message's attachments : ");
                stringBuilder2.append(list.get(i));
                InstabugSDKLogger.m8360v(this, stringBuilder2.toString());
                try {
                    m19402a(message);
                } catch (Exception e) {
                    stringBuilder2 = new StringBuilder("Something went wrong while uploading message attachments ");
                    stringBuilder2.append(e.getMessage());
                    InstabugSDKLogger.m8360v(this, stringBuilder2.toString());
                }
            }
        }
    }

    private void m19402a(final Message message) throws JSONException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder("Found ");
        stringBuilder.append(message.f15384h.size());
        stringBuilder.append(" attachments related to message: ");
        stringBuilder.append(message.f15379c);
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        C0553a.m7928a().m7930a((Context) this, message, new Callbacks<Boolean, Message>(this) {
            final /* synthetic */ InstabugMessageUploaderService f15400b;

            public /* synthetic */ void onFailed(Object obj) {
                obj = this.f15400b;
                StringBuilder stringBuilder = new StringBuilder("Something went wrong while uploading message attachments, Message: ");
                stringBuilder.append(message);
                InstabugSDKLogger.m8357e(obj, stringBuilder.toString());
            }

            public /* synthetic */ void onSucceeded(Object obj) {
                InstabugSDKLogger.m8360v(this.f15400b, "Message attachments uploaded successfully");
                obj = ChatsCacheManager.getChat(message.f15378b);
                if (obj != null) {
                    obj.f15373a.remove(message);
                    message.f15386j = MessageState.READY_TO_BE_SYNCED;
                    for (int i = 0; i < message.f15384h.size(); i++) {
                        ((Attachment) message.f15384h.get(i)).setState(Attachment.STATE_SYNCED);
                    }
                    InstabugMessageUploaderService instabugMessageUploaderService = this.f15400b;
                    StringBuilder stringBuilder = new StringBuilder("Caching sent message:");
                    stringBuilder.append(message.toString());
                    InstabugSDKLogger.m8360v(instabugMessageUploaderService, stringBuilder.toString());
                    obj.f15373a.add(message);
                    InMemoryCache cache = ChatsCacheManager.getCache();
                    if (cache != null) {
                        cache.put(obj.getId(), obj);
                    }
                    ChatsCacheManager.saveCacheToDisk();
                    C0554a.m7934a(Calendar.getInstance(Locale.ENGLISH).getTime().getTime());
                    ChatTimeUpdatedEventBus.getInstance().post(Long.valueOf(InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds()));
                    return;
                }
                InstabugSDKLogger.m8357e(this, "Chat is null so can't remove message from it");
            }
        });
    }

    private void m19401a(final Chat chat) {
        StringBuilder stringBuilder = new StringBuilder("START uploading all logs related to this chat id = ");
        stringBuilder.append(chat.getId());
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        C0553a.m7928a().m7929a((Context) this, chat, new Callbacks<Boolean, Chat>(this) {
            final /* synthetic */ InstabugMessageUploaderService f15402b;

            public /* synthetic */ void onFailed(Object obj) {
                InstabugSDKLogger.m8356d(this.f15402b, "Something went wrong while uploading chat logs");
            }

            public /* synthetic */ void onSucceeded(Object obj) {
                InstabugSDKLogger.m8356d(this.f15402b, "chat logs uploaded successfully, change its state");
                chat.f15374b = ChatState.SENT;
                ChatsCacheManager.saveCacheToDisk();
            }
        });
    }

    protected void runBackgroundTask() throws Exception {
        List offlineChats = ChatsCacheManager.getOfflineChats();
        StringBuilder stringBuilder = new StringBuilder("Found ");
        stringBuilder.append(offlineChats.size());
        stringBuilder.append(" offline chats in cache");
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        for (final Chat chat : ChatsCacheManager.getOfflineChats()) {
            StringBuilder stringBuilder2;
            if (chat.f15374b.equals(ChatState.READY_TO_BE_SENT) && chat.f15373a.size() > 0) {
                stringBuilder2 = new StringBuilder("Uploading offline Chat: ");
                stringBuilder2.append(chat);
                InstabugSDKLogger.m8360v(this, stringBuilder2.toString());
                C0553a.m7928a().m7931a((Context) this, chat.getState(), new Callbacks<String, Throwable>(this) {
                    final /* synthetic */ InstabugMessageUploaderService f15396b;

                    public /* synthetic */ void onFailed(Object obj) {
                        Throwable th = (Throwable) obj;
                        InstabugMessageUploaderService instabugMessageUploaderService = this.f15396b;
                        StringBuilder stringBuilder = new StringBuilder("Something went wrong while triggering offline chat with id: ");
                        stringBuilder.append(chat.getId());
                        InstabugSDKLogger.m8358e(instabugMessageUploaderService, stringBuilder.toString(), th);
                    }

                    public /* synthetic */ void onSucceeded(Object obj) {
                        String str = (String) obj;
                        InstabugMessageUploaderService instabugMessageUploaderService = this.f15396b;
                        StringBuilder stringBuilder = new StringBuilder("triggering chat ");
                        stringBuilder.append(chat.toString());
                        stringBuilder.append(" triggeredChatId: ");
                        stringBuilder.append(str);
                        InstabugSDKLogger.m8360v(instabugMessageUploaderService, stringBuilder.toString());
                        String id = chat.getId();
                        ChatTriggeringEventBus.getInstance().post(new C0543a(id, str));
                        InstabugMessageUploaderService instabugMessageUploaderService2 = this.f15396b;
                        StringBuilder stringBuilder2 = new StringBuilder("Updating local chat with id: ");
                        stringBuilder2.append(id);
                        stringBuilder2.append(", with synced chat with id: ");
                        stringBuilder2.append(str);
                        InstabugSDKLogger.m8360v(instabugMessageUploaderService2, stringBuilder2.toString());
                        chat.m15271a(str);
                        chat.f15374b = ChatState.LOGS_READY_TO_BE_UPLOADED;
                        obj = ChatsCacheManager.getCache();
                        if (obj != null) {
                            obj.delete(id);
                            obj.put(chat.getId(), chat);
                        }
                        ChatsCacheManager.saveCacheToDisk();
                        this.f15396b.m19401a(chat);
                    }
                });
            } else if (chat.f15374b.equals(ChatState.LOGS_READY_TO_BE_UPLOADED)) {
                stringBuilder2 = new StringBuilder("chat: ");
                stringBuilder2.append(chat.toString());
                stringBuilder2.append(" already uploaded but has unsent logs, uploading now");
                InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                m19401a(chat);
            }
        }
        m19405a(ChatsCacheManager.getOfflineMessages());
    }
}
