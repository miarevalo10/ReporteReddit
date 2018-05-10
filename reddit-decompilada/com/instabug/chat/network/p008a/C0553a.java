package com.instabug.chat.network.p008a;

import android.content.Context;
import com.facebook.stetho.server.http.HttpStatus;
import com.instabug.chat.model.Attachment;
import com.instabug.chat.model.Chat;
import com.instabug.chat.model.Message;
import com.instabug.library.model.State;
import com.instabug.library.model.State.StateItem;
import com.instabug.library.network.NetworkManager;
import com.instabug.library.network.NetworkManager.RequestType;
import com.instabug.library.network.Request;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.Request.Endpoint;
import com.instabug.library.network.Request.FileToUpload;
import com.instabug.library.network.Request.RequestMethod;
import com.instabug.library.network.RequestResponse;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;

/* compiled from: MessagingService */
public class C0553a {
    private static C0553a f9292b;
    public NetworkManager f9293a = new NetworkManager();

    /* compiled from: MessagingService */
    class C16332 extends Subscriber<RequestResponse> {
        final /* synthetic */ Callbacks f18518a;
        final /* synthetic */ C0553a f18519b;

        public C16332(C0553a c0553a, Callbacks callbacks) {
            this.f18519b = c0553a;
            this.f18518a = callbacks;
        }

        public final /* synthetic */ void a_(Object obj) {
            RequestResponse requestResponse = (RequestResponse) obj;
            StringBuilder stringBuilder = new StringBuilder("sendMessage request onNext, Response code: ");
            stringBuilder.append(requestResponse.getResponseCode());
            stringBuilder.append("Response body: ");
            stringBuilder.append(requestResponse.getResponseBody());
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            if (requestResponse.getResponseCode() == HttpStatus.HTTP_OK) {
                try {
                    this.f18518a.onSucceeded(new JSONObject((String) requestResponse.getResponseBody()).getString("message_id"));
                    return;
                } catch (Object obj2) {
                    InstabugSDKLogger.m8358e(this, "Sending message got error", obj2);
                    return;
                }
            }
            Callbacks callbacks = this.f18518a;
            StringBuilder stringBuilder2 = new StringBuilder("Sending message got error with response code:");
            stringBuilder2.append(requestResponse.getResponseCode());
            callbacks.onFailed(new Throwable(stringBuilder2.toString()));
        }

        public final void aV_() {
            InstabugSDKLogger.m8360v(this, "sendMessage request started");
        }

        public final void m19409b() {
            InstabugSDKLogger.m8360v(this, "sendMessage request completed");
        }

        public final void m19408a(Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("sendMessage request got error: ");
            stringBuilder.append(th.getMessage());
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            this.f18518a.onFailed(th);
        }
    }

    /* compiled from: MessagingService */
    class C16354 extends Subscriber<RequestResponse> {
        final /* synthetic */ Callbacks f18523a;
        final /* synthetic */ C0553a f18524b;

        public C16354(C0553a c0553a, Callbacks callbacks) {
            this.f18524b = c0553a;
            this.f18523a = callbacks;
        }

        public final /* synthetic */ void a_(Object obj) {
            RequestResponse requestResponse = (RequestResponse) obj;
            StringBuilder stringBuilder = new StringBuilder("syncMessages request onNext, Response code: ");
            stringBuilder.append(requestResponse.getResponseCode());
            stringBuilder.append("Response body: ");
            stringBuilder.append(requestResponse.getResponseBody());
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            this.f18523a.onSucceeded(requestResponse);
        }

        public final void aV_() {
            InstabugSDKLogger.m8360v(this, "syncMessages request started");
        }

        public final void m19413b() {
            InstabugSDKLogger.m8360v(this, "syncMessages request completed");
        }

        public final void m19412a(Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("syncMessages request got error: ");
            stringBuilder.append(th.getMessage());
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            this.f18523a.onFailed(th);
        }
    }

    /* compiled from: MessagingService */
    class C16376 extends Subscriber<RequestResponse> {
        final /* synthetic */ Callbacks f18528a;
        final /* synthetic */ C0553a f18529b;

        public C16376(C0553a c0553a, Callbacks callbacks) {
            this.f18529b = c0553a;
            this.f18528a = callbacks;
        }

        public final /* synthetic */ void a_(Object obj) {
            RequestResponse requestResponse = (RequestResponse) obj;
            StringBuilder stringBuilder = new StringBuilder("sending push notification token onNext, Response code: ");
            stringBuilder.append(requestResponse.getResponseCode());
            stringBuilder.append("Response body: ");
            stringBuilder.append(requestResponse.getResponseBody());
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            if (requestResponse.getResponseCode() == HttpStatus.HTTP_OK) {
                try {
                    this.f18528a.onSucceeded(new JSONObject((String) requestResponse.getResponseBody()).getString("status"));
                    return;
                } catch (Object obj2) {
                    obj2.printStackTrace();
                    this.f18528a.onFailed(obj2);
                    return;
                }
            }
            Callbacks callbacks = this.f18528a;
            StringBuilder stringBuilder2 = new StringBuilder("sending push notification token got error with response code: ");
            stringBuilder2.append(requestResponse.getResponseCode());
            callbacks.onFailed(new Throwable(stringBuilder2.toString()));
        }

        public final void aV_() {
            InstabugSDKLogger.m8356d(this, "sending push notification token started");
        }

        public final void m19417b() {
            InstabugSDKLogger.m8356d(this, "sending push notification token completed");
        }

        public final void m19416a(Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("sending push notification token got error: ");
            stringBuilder.append(th.getMessage());
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            this.f18528a.onFailed(th);
        }
    }

    private C0553a() {
    }

    public static C0553a m7928a() {
        if (f9292b == null) {
            f9292b = new C0553a();
        }
        return f9292b;
    }

    public final void m7931a(Context context, State state, final Callbacks<String, Throwable> callbacks) throws JSONException, IOException {
        InstabugSDKLogger.m8360v(this, "trigger chat");
        context = this.f9293a.buildRequest(context, Endpoint.TriggerChat, RequestMethod.Post);
        ArrayList stateItems = state.getStateItems();
        for (int i = 0; i < state.getStateItems().size(); i++) {
            StringBuilder stringBuilder = new StringBuilder("Chat State Key: ");
            stringBuilder.append(((StateItem) stateItems.get(i)).getKey());
            stringBuilder.append(", Chat State value: ");
            stringBuilder.append(((StateItem) stateItems.get(i)).getValue());
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            context.addRequestBodyParameter(((StateItem) state.getStateItems().get(i)).getKey(), ((StateItem) state.getStateItems().get(i)).getValue());
        }
        Observable.a(new Subscriber<RequestResponse>(this) {
            final /* synthetic */ C0553a f18517b;

            public final /* synthetic */ void a_(Object obj) {
                RequestResponse requestResponse = (RequestResponse) obj;
                StringBuilder stringBuilder = new StringBuilder("triggeringChatRequest onNext, Response code: ");
                stringBuilder.append(requestResponse.getResponseCode());
                stringBuilder.append("Response body: ");
                stringBuilder.append(requestResponse.getResponseBody());
                InstabugSDKLogger.m8360v(this, stringBuilder.toString());
                if (requestResponse.getResponseCode() == HttpStatus.HTTP_OK) {
                    try {
                        callbacks.onSucceeded(new JSONObject((String) requestResponse.getResponseBody()).getString("chat_number"));
                        return;
                    } catch (Object obj2) {
                        obj2.printStackTrace();
                        return;
                    }
                }
                Callbacks callbacks = callbacks;
                StringBuilder stringBuilder2 = new StringBuilder("Triggering chat got error with response code:");
                stringBuilder2.append(requestResponse.getResponseCode());
                callbacks.onFailed(new Throwable(stringBuilder2.toString()));
            }

            public final void aV_() {
                InstabugSDKLogger.m8360v(this, "triggeringChatRequest started");
            }

            public final void m19407b() {
                InstabugSDKLogger.m8360v(this, "triggeringChatRequest completed");
            }

            public final void m19406a(Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("triggeringChatRequest got error: ");
                stringBuilder.append(th.getMessage());
                InstabugSDKLogger.m8360v(this, stringBuilder.toString());
                callbacks.onFailed(th);
            }
        }, this.f9293a.doRequest(context));
    }

    public final void m7930a(Context context, final Message message, final Callbacks<Boolean, Message> callbacks) throws JSONException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder("Uploading message attachments, Message: ");
        stringBuilder.append(message.f15379c);
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        Observable[] observableArr = new Observable[message.f15384h.size()];
        for (int i = 0; i < observableArr.length; i++) {
            Attachment attachment = (Attachment) message.f15384h.get(i);
            StringBuilder stringBuilder2 = new StringBuilder("Uploading attachment with type: ");
            stringBuilder2.append(attachment.getType());
            InstabugSDKLogger.m8360v(this, stringBuilder2.toString());
            Request buildRequest = this.f9293a.buildRequest(context, Endpoint.AddMessageAttachment, RequestMethod.Post, RequestType.MULTI_PART);
            buildRequest.setEndpoint(buildRequest.getEndpoint().replaceAll(":chat_number", message.f15378b));
            buildRequest.setEndpoint(buildRequest.getEndpoint().replaceAll(":message_id", String.valueOf(message.f15377a)));
            buildRequest.addParameter("metadata[file_type]", attachment.getType());
            if (attachment.getType().equals(Attachment.TYPE_AUDIO)) {
                buildRequest.addParameter("metadata[duration]", attachment.getDuration());
            }
            buildRequest.setFileToUpload(new FileToUpload("file", attachment.getName(), attachment.getLocalPath(), attachment.getFileType()));
            StringBuilder stringBuilder3 = new StringBuilder("Uploading attachment with name: ");
            stringBuilder3.append(attachment.getName());
            stringBuilder3.append(" path: ");
            stringBuilder3.append(attachment.getLocalPath());
            stringBuilder3.append(" file type: ");
            stringBuilder3.append(attachment.getFileType());
            InstabugSDKLogger.m8360v(this, stringBuilder3.toString());
            observableArr[i] = this.f9293a.doRequest(buildRequest);
        }
        Observable.a(new Subscriber<RequestResponse>(this) {
            final /* synthetic */ C0553a f18522c;

            public final /* synthetic */ void a_(Object obj) {
                RequestResponse requestResponse = (RequestResponse) obj;
                StringBuilder stringBuilder = new StringBuilder("uploadingMessageAttachmentRequest onNext, Response code: ");
                stringBuilder.append(requestResponse.getResponseCode());
                stringBuilder.append(", Response body: ");
                stringBuilder.append(requestResponse.getResponseBody());
                InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            }

            public final void aV_() {
                InstabugSDKLogger.m8360v(this, "uploadingMessageAttachmentRequest started");
            }

            public final void m19411b() {
                InstabugSDKLogger.m8360v(this, "uploadingMessageAttachmentRequest completed");
                callbacks.onSucceeded(Boolean.valueOf(true));
            }

            public final void m19410a(Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("uploadingMessageAttachmentRequest got error: ");
                stringBuilder.append(th.getMessage());
                InstabugSDKLogger.m8360v(this, stringBuilder.toString());
                callbacks.onFailed(message);
            }
        }, Observable.b(observableArr));
    }

    public final void m7929a(Context context, final Chat chat, final Callbacks<Boolean, Chat> callbacks) {
        try {
            context = this.f9293a.buildRequest(context, Endpoint.chatLogs, RequestMethod.Post);
            context.setEndpoint(context.getEndpoint().replaceAll(":chat_token", chat.getId()));
            if (chat.getState() != null) {
                Iterator it = chat.getState().getLogsItems().iterator();
                while (it.hasNext()) {
                    StateItem stateItem = (StateItem) it.next();
                    if (!stateItem.getKey().equals(State.KEY_VISUAL_USER_STEPS)) {
                        context.addRequestBodyParameter(stateItem.getKey(), stateItem.getValue());
                    }
                }
            }
            Observable.a(new Subscriber<RequestResponse>(this) {
                final /* synthetic */ C0553a f18527c;

                public final /* synthetic */ void a_(Object obj) {
                    RequestResponse requestResponse = (RequestResponse) obj;
                    StringBuilder stringBuilder = new StringBuilder("uploading chat logs onNext, Response code: ");
                    stringBuilder.append(requestResponse.getResponseCode());
                    stringBuilder.append("Response body: ");
                    stringBuilder.append(requestResponse.getResponseBody());
                    InstabugSDKLogger.m8360v(this, stringBuilder.toString());
                }

                public final void aV_() {
                    InstabugSDKLogger.m8356d(this, "uploading chat logs started");
                }

                public final void m19415b() {
                    InstabugSDKLogger.m8356d(this, "uploading chat logs completed");
                    callbacks.onSucceeded(Boolean.valueOf(true));
                }

                public final void m19414a(Throwable th) {
                    StringBuilder stringBuilder = new StringBuilder("uploading chat logs got error: ");
                    stringBuilder.append(th.getMessage());
                    InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                    callbacks.onFailed(chat);
                }
            }, this.f9293a.doRequest(context));
        } catch (Context context2) {
            StringBuilder stringBuilder = new StringBuilder("uploading chat logs got Json error: ");
            stringBuilder.append(context2.getMessage());
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            callbacks.onFailed(chat);
        }
    }
}
