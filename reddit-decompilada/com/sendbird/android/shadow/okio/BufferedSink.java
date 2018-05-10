package com.sendbird.android.shadow.okio;

import java.io.IOException;

public interface BufferedSink extends Sink {
    long mo6548a(Source source) throws IOException;

    Buffer mo6552b();

    BufferedSink mo6553b(String str) throws IOException;

    BufferedSink mo6556c() throws IOException;

    BufferedSink mo6557c(ByteString byteString) throws IOException;

    BufferedSink mo6558c(byte[] bArr) throws IOException;

    BufferedSink mo6559c(byte[] bArr, int i, int i2) throws IOException;

    BufferedSink mo6564f(int i) throws IOException;

    void flush() throws IOException;

    BufferedSink mo6566g(int i) throws IOException;

    BufferedSink mo6570h(int i) throws IOException;

    BufferedSink mo6574k(long j) throws IOException;

    BufferedSink mo6576l(long j) throws IOException;

    BufferedSink mo6578m(long j) throws IOException;

    BufferedSink mo6581t() throws IOException;
}
