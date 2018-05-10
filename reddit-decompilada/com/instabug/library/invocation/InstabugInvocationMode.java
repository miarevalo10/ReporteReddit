package com.instabug.library.invocation;

import java.io.Serializable;

public enum InstabugInvocationMode implements Serializable {
    PROMPT_OPTION,
    NEW_BUG,
    NEW_FEEDBACK,
    NEW_CHAT,
    CHATS_LIST
}
