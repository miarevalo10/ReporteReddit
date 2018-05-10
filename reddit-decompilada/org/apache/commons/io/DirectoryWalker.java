package org.apache.commons.io;

import java.io.IOException;

public abstract class DirectoryWalker<T> {

    public static class CancelException extends IOException {
    }
}
