package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public interface BufferedSource extends Source {
    int mo6749a(Options options) throws IOException;

    int mo6750a(byte[] bArr, int i, int i2) throws IOException;

    long mo6751a(Sink sink) throws IOException;

    String mo6753a(Charset charset) throws IOException;

    Buffer mo6754a();

    void mo6755a(long j) throws IOException;

    void mo6756a(Buffer buffer, long j) throws IOException;

    void mo6757a(byte[] bArr) throws IOException;

    long mo6758b(ByteString byteString) throws IOException;

    boolean mo6762b(long j) throws IOException;

    boolean mo6766c(ByteString byteString) throws IOException;

    ByteString mo6768d(long j) throws IOException;

    boolean mo6769d() throws IOException;

    InputStream mo6770e();

    String mo6771f(long j) throws IOException;

    byte mo6773g() throws IOException;

    short mo6776h() throws IOException;

    byte[] mo6777h(long j) throws IOException;

    int mo6778i() throws IOException;

    void mo6779i(long j) throws IOException;

    long mo6780j() throws IOException;

    short mo6781k() throws IOException;

    int mo6782l() throws IOException;

    long mo6783m() throws IOException;

    long mo6785n() throws IOException;

    String mo6788q() throws IOException;

    byte[] mo6789s() throws IOException;

    long mo6790u() throws IOException;
}
