package com.reddit.datalibrary.frontpage.requests.models.v2;

import java.util.List;

public class FileUploadLease {
    public String action;
    public List<Field> fields;

    public static class Field {
        public String name;
        public String value;
    }

    public final String m21637a() {
        return this.action;
    }

    public final List<Field> m21638b() {
        return this.fields;
    }
}
