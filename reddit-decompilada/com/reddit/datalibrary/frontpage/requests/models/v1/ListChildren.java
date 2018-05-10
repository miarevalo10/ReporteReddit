package com.reddit.datalibrary.frontpage.requests.models.v1;

import java.util.List;

public class ListChildren<T> {
    private String after;
    private String before;
    private List<T> children;
    private String modhash;
    private Pagination pagination;

    public static class Pagination {
        public PaginationData after;
        private PaginationData before;
    }

    public static class PaginationData {
        public String inbox;
        public String trending;
    }

    public List<T> mo3049b() {
        return this.children;
    }

    public String mo3048a() {
        return this.after;
    }

    public Pagination mo3050c() {
        return this.pagination;
    }
}
