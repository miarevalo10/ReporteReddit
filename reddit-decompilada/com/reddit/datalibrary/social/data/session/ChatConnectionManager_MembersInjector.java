package com.reddit.datalibrary.social.data.session;

import com.reddit.datalibrary.social.data.repo.ChatCredentialsRepository;
import dagger.MembersInjector;

public final class ChatConnectionManager_MembersInjector implements MembersInjector<ChatConnectionManager> {
    public static void m28842a(ChatConnectionManager chatConnectionManager, ChatCredentialsRepository chatCredentialsRepository) {
        chatConnectionManager.f19860a = chatCredentialsRepository;
    }
}
