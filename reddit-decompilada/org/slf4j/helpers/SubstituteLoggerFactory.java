package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.event.SubstituteLoggingEvent;

public class SubstituteLoggerFactory implements ILoggerFactory {
    public boolean f33451a = false;
    public final Map<String, SubstituteLogger> f33452b = new HashMap();
    public final LinkedBlockingQueue<SubstituteLoggingEvent> f33453c = new LinkedBlockingQueue();

    public final synchronized Logger mo6375a(String str) {
        Logger logger;
        logger = (SubstituteLogger) this.f33452b.get(str);
        if (logger == null) {
            logger = new SubstituteLogger(str, this.f33453c, this.f33451a);
            this.f33452b.put(str, logger);
        }
        return logger;
    }
}
