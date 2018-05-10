package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Internal;

public final class ConnectionSpecSelector {
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex = 0;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.connectionSpecs = list;
    }

    public final ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        int size = this.connectionSpecs.size();
        for (int i = this.nextModeIndex; i < size; i++) {
            connectionSpec = (ConnectionSpec) this.connectionSpecs.get(i);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.nextModeIndex = i + 1;
                break;
            }
        }
        connectionSpec = null;
        if (connectionSpec == null) {
            StringBuilder stringBuilder = new StringBuilder("Unable to find acceptable protocols. isFallback=");
            stringBuilder.append(this.isFallback);
            stringBuilder.append(", modes=");
            stringBuilder.append(this.connectionSpecs);
            stringBuilder.append(", supported protocols=");
            stringBuilder.append(Arrays.toString(sSLSocket.getEnabledProtocols()));
            throw new UnknownServiceException(stringBuilder.toString());
        }
        this.isFallbackPossible = isFallbackPossible(sSLSocket);
        Internal.instance.apply(connectionSpec, sSLSocket, this.isFallback);
        return connectionSpec;
    }

    public final boolean connectionFailed(IOException iOException) {
        this.isFallback = true;
        if (!this.isFallbackPossible || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (!z) {
            if ((iOException instanceof SSLProtocolException) == null) {
                return false;
            }
        }
        return true;
    }

    private boolean isFallbackPossible(SSLSocket sSLSocket) {
        for (int i = this.nextModeIndex; i < this.connectionSpecs.size(); i++) {
            if (((ConnectionSpec) this.connectionSpecs.get(i)).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return null;
    }
}
