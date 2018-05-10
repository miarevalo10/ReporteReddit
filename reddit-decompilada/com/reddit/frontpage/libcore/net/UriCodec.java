package com.reddit.frontpage.libcore.net;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public abstract class UriCodec {
    public static final Charset f20312a = Charset.forName("UTF-8");

    private static char m22532a(int i) {
        return i < 10 ? (char) (48 + i) : (char) ((65 + i) - 10);
    }

    public abstract boolean mo5045a(char c);

    public final void m22534a(StringBuilder stringBuilder, String str, Charset charset) {
        CharsetEncoder onUnmappableCharacter = charset.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
        CharBuffer allocate = CharBuffer.allocate(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == ' ' && mo5045a(' ')) {
                m22533a(stringBuilder, onUnmappableCharacter, allocate);
                stringBuilder.append('+');
            } else {
                Object obj = 1;
                Object obj2 = (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && ('0' > charAt || charAt > '9'))) ? null : 1;
                if (obj2 == null) {
                    if (!mo5045a(charAt)) {
                        obj = null;
                    }
                }
                if (obj != null) {
                    m22533a(stringBuilder, onUnmappableCharacter, allocate);
                    stringBuilder.append(charAt);
                } else {
                    allocate.put(charAt);
                }
            }
        }
        m22533a(stringBuilder, onUnmappableCharacter, allocate);
    }

    private static void m22533a(StringBuilder stringBuilder, CharsetEncoder charsetEncoder, CharBuffer charBuffer) {
        if (charBuffer.position() != 0) {
            charBuffer.flip();
            ByteBuffer allocate = ByteBuffer.allocate(charBuffer.remaining() * ((int) Math.ceil((double) charsetEncoder.maxBytesPerChar())));
            allocate.position(0);
            CoderResult encode = charsetEncoder.encode(charBuffer, allocate, true);
            if (encode != CoderResult.UNDERFLOW) {
                charBuffer = new StringBuilder("Error encoding, unexpected result [");
                charBuffer.append(encode.toString());
                charBuffer.append("] using encoder for [");
                charBuffer.append(charsetEncoder.charset().name());
                charBuffer.append("]");
                throw new IllegalArgumentException(charBuffer.toString());
            } else if (charBuffer.hasRemaining()) {
                StringBuilder stringBuilder2 = new StringBuilder("Encoder for [");
                stringBuilder2.append(charsetEncoder.charset().name());
                stringBuilder2.append("] failed with underflow with remaining input [");
                stringBuilder2.append(charBuffer);
                stringBuilder2.append("]");
                throw new IllegalArgumentException(stringBuilder2.toString());
            } else {
                charsetEncoder.flush(allocate);
                if (encode != CoderResult.UNDERFLOW) {
                    charBuffer = new StringBuilder("Error encoding, unexpected result [");
                    charBuffer.append(encode.toString());
                    charBuffer.append("] flushing encoder for [");
                    charBuffer.append(charsetEncoder.charset().name());
                    charBuffer.append("]");
                    throw new IllegalArgumentException(charBuffer.toString());
                }
                charsetEncoder.reset();
                allocate.flip();
                while (allocate.hasRemaining() != null) {
                    charsetEncoder = allocate.get();
                    stringBuilder.append('%');
                    stringBuilder.append(m22532a((charsetEncoder & 240) >>> 4));
                    stringBuilder.append(m22532a(charsetEncoder & 15));
                }
                charBuffer.flip();
                charBuffer.limit(charBuffer.capacity());
            }
        }
    }
}
