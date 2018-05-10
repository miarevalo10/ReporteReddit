package com.reddit.datalibrary.frontpage.redditauth.redditclient;

import android.net.Uri;
import com.reddit.frontpage.util.Preconditions;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Named;
import net.hockeyapp.android.UpdateFragment;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class WebSocketClient {
    private final OkHttpClient f10884a;
    private final Set<WebSocket> f10885b = new HashSet();

    public interface WebSocketClientListener {
        void mo3036a(String str);

        void mo3037a(Throwable th, Response response);
    }

    public static class WebSocketConnection {
        private final WebSocket f10883a;

        WebSocketConnection(WebSocket webSocket) {
            this.f10883a = webSocket;
        }

        public final void m9301a() {
            this.f10883a.cancel();
        }
    }

    public WebSocketClient(@Named("web_socket") OkHttpClient okHttpClient) {
        this.f10884a = okHttpClient;
    }

    public final WebSocketConnection m9303a(Uri uri, final WebSocketClientListener webSocketClientListener) {
        Preconditions.a(webSocketClientListener, UpdateFragment.FRAGMENT_URL);
        Preconditions.a(webSocketClientListener, "listener");
        Builder builder = new Builder();
        builder.url(uri.toString());
        return new WebSocketConnection(this.f10884a.newWebSocket(builder.build(), new WebSocketListener(this) {
            final /* synthetic */ WebSocketClient f16326b;

            public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                super.onFailure(webSocket, th, response);
                webSocketClientListener.mo3037a(th, response);
            }

            public void onMessage(WebSocket webSocket, String str) {
                webSocketClientListener.mo3036a(str);
            }

            public void onClosed(WebSocket webSocket, int i, String str) {
                super.onClosed(webSocket, i, str);
                this.f16326b.f10885b.remove(webSocket);
            }
        }));
    }
}
