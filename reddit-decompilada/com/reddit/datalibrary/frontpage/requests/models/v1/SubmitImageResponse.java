package com.reddit.datalibrary.frontpage.requests.models.v1;

public class SubmitImageResponse extends GenericResponse<WebsocketLinkResult> {

    public static class WebsocketLinkResult {
        public String websocket_url;
    }
}
