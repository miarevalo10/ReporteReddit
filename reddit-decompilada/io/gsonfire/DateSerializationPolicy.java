package io.gsonfire;

import com.google.gson.TypeAdapter;
import java.util.Date;
import java.util.TimeZone;

public enum DateSerializationPolicy {
    ;

    abstract TypeAdapter<Date> mo5615a(TimeZone timeZone);
}
