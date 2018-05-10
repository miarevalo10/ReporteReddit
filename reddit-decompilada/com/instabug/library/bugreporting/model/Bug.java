package com.instabug.library.bugreporting.model;

import com.instabug.library.model.BaseReport;

public class Bug extends BaseReport {

    public enum Type {
        BUG("bug"),
        FEEDBACK("feedback"),
        NOT_AVAILABLE("not-available");
        
        private final String name;

        private Type(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }
}
