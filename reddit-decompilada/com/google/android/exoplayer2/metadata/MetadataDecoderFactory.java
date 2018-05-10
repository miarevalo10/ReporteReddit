package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.scte35.SpliceInfoDecoder;

public interface MetadataDecoderFactory {
    public static final MetadataDecoderFactory f4667a = new C11401();

    static class C11401 implements MetadataDecoderFactory {
        C11401() {
        }

        public final boolean mo1394a(Format format) {
            format = format.f4018f;
            if (!("application/id3".equals(format) || "application/x-emsg".equals(format))) {
                if ("application/x-scte35".equals(format) == null) {
                    return null;
                }
            }
            return true;
        }

        public final MetadataDecoder mo1395b(Format format) {
            format = format.f4018f;
            int hashCode = format.hashCode();
            if (hashCode != -1248341703) {
                if (hashCode != 1154383568) {
                    if (hashCode == 1652648887) {
                        if (format.equals("application/x-scte35") != null) {
                            format = 2;
                            switch (format) {
                                case null:
                                    return new Id3Decoder();
                                case 1:
                                    return new EventMessageDecoder();
                                case 2:
                                    return new SpliceInfoDecoder();
                                default:
                                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
                            }
                        }
                    }
                } else if (format.equals("application/x-emsg") != null) {
                    format = true;
                    switch (format) {
                        case null:
                            return new Id3Decoder();
                        case 1:
                            return new EventMessageDecoder();
                        case 2:
                            return new SpliceInfoDecoder();
                        default:
                            throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
                    }
                }
            } else if (format.equals("application/id3") != null) {
                format = null;
                switch (format) {
                    case null:
                        return new Id3Decoder();
                    case 1:
                        return new EventMessageDecoder();
                    case 2:
                        return new SpliceInfoDecoder();
                    default:
                        throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
                }
            }
            format = -1;
            switch (format) {
                case null:
                    return new Id3Decoder();
                case 1:
                    return new EventMessageDecoder();
                case 2:
                    return new SpliceInfoDecoder();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }
    }

    boolean mo1394a(Format format);

    MetadataDecoder mo1395b(Format format);
}
