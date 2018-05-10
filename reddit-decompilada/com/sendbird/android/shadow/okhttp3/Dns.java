package com.sendbird.android.shadow.okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface Dns {
    public static final Dns f23190a = new C24641();

    class C24641 implements Dns {
        C24641() {
        }

        public final List<InetAddress> mo5301a(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder("Broken system behaviour for dns lookup of ");
                stringBuilder.append(str);
                UnknownHostException unknownHostException = new UnknownHostException(stringBuilder.toString());
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
        }
    }

    List<InetAddress> mo5301a(String str) throws UnknownHostException;
}
