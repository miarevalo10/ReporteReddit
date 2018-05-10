package org.apache.commons.io;

import java.io.IOException;

public class TaggedIOException extends IOExceptionWithCause {
    public /* bridge */ /* synthetic */ Throwable getCause() {
        return (IOException) super.getCause();
    }
}
