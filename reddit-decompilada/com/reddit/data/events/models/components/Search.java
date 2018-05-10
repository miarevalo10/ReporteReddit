package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Search {
    public static final Adapter<Search, Builder> ADAPTER = new SearchAdapter();
    public final String query;

    public static final class Builder implements StructBuilder<Search> {
        private String query;

        public Builder(Search search) {
            this.query = search.query;
        }

        public final Builder query(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'query' cannot be null");
            }
            this.query = str;
            return this;
        }

        public final Search build() {
            if (this.query != null) {
                return new Search();
            }
            throw new IllegalStateException("Required field 'query' is missing");
        }

        public final void reset() {
            this.query = null;
        }
    }

    private static final class SearchAdapter implements Adapter<Search, Builder> {
        private SearchAdapter() {
        }

        public final void write(Protocol protocol, Search search) throws IOException {
            protocol.mo2638a(1, (byte) 11);
            protocol.mo2640a(search.query);
            protocol.mo2634a();
        }

        public final Search read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b == (byte) 0) {
                    return builder.build();
                }
                if (b.f10037c != (short) 1) {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                } else if (b.f10036b == (byte) 11) {
                    builder.query(protocol.mo2652l());
                } else {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                }
            }
        }

        public final Search read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Search(Builder builder) {
        this.query = builder.query;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Search)) {
            return false;
        }
        Search search = (Search) obj;
        if (this.query != search.query) {
            if (this.query.equals(search.query) == null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return (this.query.hashCode() ^ 16777619) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Search{query=");
        stringBuilder.append(this.query);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
