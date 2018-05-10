package com.reddit.datalibrary.frontpage.service.api;

import java.io.Serializable;

public class ImgDeleteResponse implements Serializable {
    public Data data;
    public int status;
    public boolean success;

    public class Data implements Serializable {
        public long datetime;
        public String deletehash;
        public String link;
    }
}
