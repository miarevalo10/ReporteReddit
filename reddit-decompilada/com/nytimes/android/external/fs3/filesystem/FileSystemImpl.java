package com.nytimes.android.external.fs3.filesystem;

import com.nytimes.android.external.cache3.CacheBuilder;
import com.nytimes.android.external.cache3.CacheLoader;
import com.nytimes.android.external.cache3.LoadingCache;
import com.nytimes.android.external.fs3.Util;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

class FileSystemImpl implements FileSystem {
    private final Util f15675a = new Util();
    private final LoadingCache<String, FSFile> f15676b;
    private final File f15677c;

    FileSystemImpl(final File file) throws IOException {
        this.f15677c = file;
        CacheBuilder a = CacheBuilder.m8534a().m8535a(20);
        CacheLoader c14471 = new CacheLoader<String, FSFile>(this) {
            final /* synthetic */ FileSystemImpl f15674b;

            public final /* synthetic */ Object mo2705a(Object obj) throws Exception {
                return new FSFile(file, (String) obj);
            }
        };
        a.m8540e();
        this.f15676b = new LocalLoadingCache(a, c14471);
        Util.m8686a(file);
    }

    public final BufferedSource mo2710a(String str) throws FileNotFoundException {
        str = m15688c(str);
        if (str.f10228b.exists()) {
            return Okio.a(Okio.a(str.f10228b));
        }
        throw new FileNotFoundException(str.f10227a);
    }

    public final void mo2711a(String str, BufferedSource bufferedSource) throws IOException {
        str = m15688c(str);
        File createTempFile = File.createTempFile("new", "tmp", str.f10228b.getParentFile());
        BufferedSink bufferedSink = null;
        try {
            BufferedSink a = Okio.a(Okio.b(createTempFile));
            try {
                a.a(bufferedSource);
                if (createTempFile.renameTo(str.f10228b)) {
                    createTempFile.delete();
                    a.close();
                    bufferedSource.close();
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder("unable to move tmp file to ");
                stringBuilder.append(str.f10228b.getPath());
                throw new IOException(stringBuilder.toString());
            } catch (Exception e) {
                str = e;
                bufferedSink = a;
                try {
                    throw new IOException("unable to write to file", str);
                } catch (Throwable th) {
                    str = th;
                    a = bufferedSink;
                    createTempFile.delete();
                    if (a != null) {
                        a.close();
                    }
                    bufferedSource.close();
                    throw str;
                }
            } catch (Throwable th2) {
                str = th2;
                createTempFile.delete();
                if (a != null) {
                    a.close();
                }
                bufferedSource.close();
                throw str;
            }
        } catch (Exception e2) {
            str = e2;
            throw new IOException("unable to write to file", str);
        }
    }

    public final boolean mo2712b(String str) {
        return m15688c(str).f10228b.exists();
    }

    private FSFile m15688c(String str) {
        Object obj;
        Stack stack;
        Iterator it;
        LoadingCache loadingCache = this.f15676b;
        if (str != null) {
            if (str.length() != 0) {
                obj = null;
                if (obj == null) {
                    str = "";
                } else {
                    str = str.split("[/]+");
                    stack = new Stack();
                    Util.m8687a(str, stack);
                    if (stack.isEmpty() == null) {
                        str = Operation.DIVISION;
                    } else {
                        str = new StringBuilder();
                        it = stack.iterator();
                        while (it.hasNext()) {
                            String str2 = (String) it.next();
                            str.append(Operation.DIVISION);
                            str.append(str2);
                        }
                        str = str.toString();
                    }
                }
                return (FSFile) loadingCache.getUnchecked(str);
            }
        }
        obj = 1;
        if (obj == null) {
            str = str.split("[/]+");
            stack = new Stack();
            Util.m8687a(str, stack);
            if (stack.isEmpty() == null) {
                str = new StringBuilder();
                it = stack.iterator();
                while (it.hasNext()) {
                    String str22 = (String) it.next();
                    str.append(Operation.DIVISION);
                    str.append(str22);
                }
                str = str.toString();
            } else {
                str = Operation.DIVISION;
            }
        } else {
            str = "";
        }
        return (FSFile) loadingCache.getUnchecked(str);
    }
}
