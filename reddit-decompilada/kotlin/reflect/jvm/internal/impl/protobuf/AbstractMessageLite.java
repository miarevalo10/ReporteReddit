package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractMessageLite implements MessageLite {
    protected int f36129a = 0;

    public static abstract class Builder<BuilderType extends Builder> implements kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder {

        static final class LimitedInputStream extends FilterInputStream {
            private int f25884a;

            LimitedInputStream(InputStream inputStream, int i) {
                super(inputStream);
                this.f25884a = i;
            }

            public final int available() throws IOException {
                return Math.min(super.available(), this.f25884a);
            }

            public final int read() throws IOException {
                if (this.f25884a <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f25884a--;
                }
                return read;
            }

            public final int read(byte[] bArr, int i, int i2) throws IOException {
                if (this.f25884a <= 0) {
                    return -1;
                }
                bArr = super.read(bArr, i, Math.min(i2, this.f25884a));
                if (bArr >= null) {
                    this.f25884a -= bArr;
                }
                return bArr;
            }

            public final long skip(long j) throws IOException {
                j = super.skip(Math.min(j, (long) this.f25884a));
                if (j >= 0) {
                    this.f25884a = (int) (((long) this.f25884a) - j);
                }
                return j;
            }
        }

        public abstract BuilderType mo7109a();

        public abstract BuilderType mo7299a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        public /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mo7299a(codedInputStream, extensionRegistryLite);
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return mo7109a();
        }
    }
}
