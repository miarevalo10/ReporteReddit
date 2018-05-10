package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SubmitVideoResponse extends GenericResponse<WebsocketLinkResult> {

    public static class WebsocketLinkResult {
        Link link;
        @SerializedName(a = "s3_data")
        S3Data s3Data;

        public static class Field {
            String name;
            Object value;
        }

        public static class Link {
            Integer id;
            String name;
            String url;
            @SerializedName(a = "video_filename")
            String videoFilename;
        }

        public static class S3Data {
            String action;
            List<Field> fields = null;
        }
    }
}
