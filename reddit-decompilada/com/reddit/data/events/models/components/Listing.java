package com.reddit.data.events.models.components;

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

public final class Listing {
    public static final Adapter<Listing, Builder> ADAPTER = new ListingAdapter();
    public final String geo_filter;
    public final Long length;
    public final List<String> links;
    public final Long max_rank;
    public final Long min_rank;
    public final String sort;
    public final String sort_time_filter;
    public final String source;

    public static final class Builder implements StructBuilder<Listing> {
        private String geo_filter;
        private Long length;
        private List<String> links;
        private Long max_rank;
        private Long min_rank;
        private String sort;
        private String sort_time_filter;
        private String source;

        public Builder(Listing listing) {
            this.length = listing.length;
            this.links = listing.links;
            this.sort = listing.sort;
            this.sort_time_filter = listing.sort_time_filter;
            this.min_rank = listing.min_rank;
            this.max_rank = listing.max_rank;
            this.geo_filter = listing.geo_filter;
            this.source = listing.source;
        }

        public final Builder length(Long l) {
            if (l == null) {
                throw new NullPointerException("Required field 'length' cannot be null");
            }
            this.length = l;
            return this;
        }

        public final Builder links(List<String> list) {
            if (list == null) {
                throw new NullPointerException("Required field 'links' cannot be null");
            }
            this.links = list;
            return this;
        }

        public final Builder sort(String str) {
            this.sort = str;
            return this;
        }

        public final Builder sort_time_filter(String str) {
            this.sort_time_filter = str;
            return this;
        }

        public final Builder min_rank(Long l) {
            this.min_rank = l;
            return this;
        }

        public final Builder max_rank(Long l) {
            this.max_rank = l;
            return this;
        }

        public final Builder geo_filter(String str) {
            this.geo_filter = str;
            return this;
        }

        public final Builder source(String str) {
            this.source = str;
            return this;
        }

        public final Listing build() {
            if (this.length == null) {
                throw new IllegalStateException("Required field 'length' is missing");
            } else if (this.links != null) {
                return new Listing();
            } else {
                throw new IllegalStateException("Required field 'links' is missing");
            }
        }

        public final void reset() {
            this.length = null;
            this.links = null;
            this.sort = null;
            this.sort_time_filter = null;
            this.min_rank = null;
            this.max_rank = null;
            this.geo_filter = null;
            this.source = null;
        }
    }

    private static final class ListingAdapter implements Adapter<Listing, Builder> {
        private ListingAdapter() {
        }

        public final void write(Protocol protocol, Listing listing) throws IOException {
            protocol.mo2638a(1, (byte) 10);
            protocol.mo2639a(listing.length.longValue());
            protocol.mo2638a(2, (byte) 15);
            protocol.mo2635a((byte) 11, listing.links.size());
            for (String a : listing.links) {
                protocol.mo2640a(a);
            }
            if (listing.sort != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(listing.sort);
            }
            if (listing.sort_time_filter != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(listing.sort_time_filter);
            }
            if (listing.min_rank != null) {
                protocol.mo2638a(5, (byte) 10);
                protocol.mo2639a(listing.min_rank.longValue());
            }
            if (listing.max_rank != null) {
                protocol.mo2638a(6, (byte) 10);
                protocol.mo2639a(listing.max_rank.longValue());
            }
            if (listing.geo_filter != null) {
                protocol.mo2638a(7, (byte) 11);
                protocol.mo2640a(listing.geo_filter);
            }
            if (listing.source != null) {
                protocol.mo2638a(8, (byte) 11);
                protocol.mo2640a(listing.source);
            }
            protocol.mo2634a();
        }

        public final Listing read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.length(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 15) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            ListMetadata d = protocol.mo2644d();
                            List arrayList = new ArrayList(d.f10039b);
                            for (int i = 0; i < d.f10039b; i++) {
                                arrayList.add(protocol.mo2652l());
                            }
                            builder.links(arrayList);
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.sort(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.sort_time_filter(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.min_rank(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.max_rank(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.geo_filter(protocol.mo2652l());
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.source(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Listing read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Listing(Builder builder) {
        this.length = builder.length;
        this.links = Collections.unmodifiableList(builder.links);
        this.sort = builder.sort;
        this.sort_time_filter = builder.sort_time_filter;
        this.min_rank = builder.min_rank;
        this.max_rank = builder.max_rank;
        this.geo_filter = builder.geo_filter;
        this.source = builder.source;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Listing)) {
            return false;
        }
        Listing listing = (Listing) obj;
        if ((this.length == listing.length || this.length.equals(listing.length)) && ((this.links == listing.links || this.links.equals(listing.links)) && ((this.sort == listing.sort || (this.sort != null && this.sort.equals(listing.sort))) && ((this.sort_time_filter == listing.sort_time_filter || (this.sort_time_filter != null && this.sort_time_filter.equals(listing.sort_time_filter))) && ((this.min_rank == listing.min_rank || (this.min_rank != null && this.min_rank.equals(listing.min_rank))) && ((this.max_rank == listing.max_rank || (this.max_rank != null && this.max_rank.equals(listing.max_rank))) && (this.geo_filter == listing.geo_filter || (this.geo_filter != null && this.geo_filter.equals(listing.geo_filter))))))))) {
            if (this.source != listing.source) {
                if (!(this.source == null || this.source.equals(listing.source) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((this.length.hashCode() ^ 16777619) * -2128831035) ^ this.links.hashCode()) * -2128831035) ^ (this.sort == null ? 0 : this.sort.hashCode())) * -2128831035) ^ (this.sort_time_filter == null ? 0 : this.sort_time_filter.hashCode())) * -2128831035) ^ (this.min_rank == null ? 0 : this.min_rank.hashCode())) * -2128831035) ^ (this.max_rank == null ? 0 : this.max_rank.hashCode())) * -2128831035) ^ (this.geo_filter == null ? 0 : this.geo_filter.hashCode())) * -2128831035;
        if (this.source != null) {
            i = this.source.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Listing{length=");
        stringBuilder.append(this.length);
        stringBuilder.append(", links=");
        stringBuilder.append(this.links);
        stringBuilder.append(", sort=");
        stringBuilder.append(this.sort);
        stringBuilder.append(", sort_time_filter=");
        stringBuilder.append(this.sort_time_filter);
        stringBuilder.append(", min_rank=");
        stringBuilder.append(this.min_rank);
        stringBuilder.append(", max_rank=");
        stringBuilder.append(this.max_rank);
        stringBuilder.append(", geo_filter=");
        stringBuilder.append(this.geo_filter);
        stringBuilder.append(", source=");
        stringBuilder.append(this.source);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
