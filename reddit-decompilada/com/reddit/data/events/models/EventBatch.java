package com.reddit.data.events.models;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.ListMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EventBatch {
    public static final Adapter<EventBatch, Builder> ADAPTER = new EventBatchAdapter();
    public final List<Event> events;

    public static final class Builder implements StructBuilder<EventBatch> {
        private List<Event> events;

        public Builder(EventBatch eventBatch) {
            this.events = eventBatch.events;
        }

        public final Builder events(List<Event> list) {
            if (list == null) {
                throw new NullPointerException("Required field 'events' cannot be null");
            }
            this.events = list;
            return this;
        }

        public final EventBatch build() {
            if (this.events != null) {
                return new EventBatch();
            }
            throw new IllegalStateException("Required field 'events' is missing");
        }

        public final void reset() {
            this.events = null;
        }
    }

    private static final class EventBatchAdapter implements Adapter<EventBatch, Builder> {
        private EventBatchAdapter() {
        }

        public final void write(Protocol protocol, EventBatch eventBatch) throws IOException {
            protocol.mo2638a(1, (byte) 15);
            protocol.mo2635a((byte) 12, eventBatch.events.size());
            for (Event write : eventBatch.events) {
                Event.ADAPTER.write(protocol, write);
            }
            protocol.mo2634a();
        }

        public final EventBatch read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b == (byte) 0) {
                    return builder.build();
                }
                if (b.f10037c != (short) 1) {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                } else if (b.f10036b == (byte) 15) {
                    ListMetadata d = protocol.mo2644d();
                    List arrayList = new ArrayList(d.f10039b);
                    for (int i = 0; i < d.f10039b; i++) {
                        arrayList.add((Event) Event.ADAPTER.read(protocol));
                    }
                    builder.events(arrayList);
                } else {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                }
            }
        }

        public final EventBatch read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private EventBatch(Builder builder) {
        this.events = Collections.unmodifiableList(builder.events);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EventBatch)) {
            return false;
        }
        EventBatch eventBatch = (EventBatch) obj;
        if (this.events != eventBatch.events) {
            if (this.events.equals(eventBatch.events) == null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return (this.events.hashCode() ^ 16777619) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("EventBatch{events=");
        stringBuilder.append(this.events);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
