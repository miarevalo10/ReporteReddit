package org.jcodec.common.logging;

import java.util.LinkedList;
import java.util.List;
import org.jcodec.common.logging.Logger.LogSink;
import org.jcodec.common.logging.Logger.Message;

public class BufferLogSink implements LogSink {
    private List<Message> messages = new LinkedList();

    public void postMessage(Message message) {
        this.messages.add(message);
    }

    public List<Message> getMessages() {
        return this.messages;
    }
}
