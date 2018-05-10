package com.sendbird.android.shadow.okio;

import java.io.IOException;
import java.nio.charset.Charset;

public interface BufferedSource extends Source {
    int mo6547a(byte[] bArr, int i, int i2) throws IOException;

    String mo6549a(Charset charset) throws IOException;

    void mo6550a(long j) throws IOException;

    void mo6551a(byte[] bArr) throws IOException;

    Buffer mo6552b();

    void mo6554b(Buffer buffer, long j) throws IOException;

    boolean mo6555b(ByteString byteString) throws IOException;

    ByteString mo6560c(long j) throws IOException;

    String mo6561d(long j) throws IOException;

    boolean mo6562d() throws IOException;

    byte mo6563f() throws IOException;

    byte[] mo6565f(long j) throws IOException;

    short mo6567g() throws IOException;

    void mo6568g(long j) throws IOException;

    int mo6569h() throws IOException;

    long mo6571i() throws IOException;

    short mo6572j() throws IOException;

    int mo6573k() throws IOException;

    long mo6575l() throws IOException;

    long mo6577m() throws IOException;

    String mo6579p() throws IOException;

    long mo6580s() throws IOException;
}
