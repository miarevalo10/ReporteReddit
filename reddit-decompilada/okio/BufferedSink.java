package okio;

import java.io.IOException;
import java.io.OutputStream;

public interface BufferedSink extends Sink {
    long mo6752a(Source source) throws IOException;

    Buffer mo6754a();

    OutputStream mo6759b();

    BufferedSink mo6760b(String str) throws IOException;

    BufferedSink mo6761b(String str, int i, int i2) throws IOException;

    BufferedSink mo6763c() throws IOException;

    BufferedSink mo6764c(byte[] bArr) throws IOException;

    BufferedSink mo6765c(byte[] bArr, int i, int i2) throws IOException;

    BufferedSink mo6767d(ByteString byteString) throws IOException;

    BufferedSink mo6772f(int i) throws IOException;

    void flush() throws IOException;

    BufferedSink mo6774g(int i) throws IOException;

    BufferedSink mo6775h(int i) throws IOException;

    BufferedSink mo6784m(long j) throws IOException;

    BufferedSink mo6786n(long j) throws IOException;

    BufferedSink mo6787o(long j) throws IOException;

    BufferedSink mo6791w() throws IOException;
}
