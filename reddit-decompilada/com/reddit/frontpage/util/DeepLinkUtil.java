package com.reddit.frontpage.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.DetailHolderScreen;
import com.reddit.frontpage.LiveThreadActivity;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.modtools.modlist.ModListPagerScreen;
import com.reddit.frontpage.ui.BottomNavScreen;
import com.reddit.frontpage.ui.inbox.ComposeScreen;
import com.reddit.frontpage.ui.inbox.MessageThreadScreen;
import com.reddit.frontpage.ui.listing.AllListingScreen;
import com.reddit.frontpage.ui.listing.LegacySubredditListingScreen;
import com.reddit.frontpage.ui.profile.ProfilePagerScreen;
import com.reddit.frontpage.ui.subreddit.SubredditInfoScreen;
import com.reddit.social.presentation.chatinbox.view.ChatInboxScreen;
import com.reddit.social.presentation.chatinbox.view.ChatInboxScreen.ChatNavType;
import com.reddit.social.presentation.chatrequests.view.ChatRequestScreen;
import com.reddit.social.presentation.groupchat.view.GroupMessagingScreen;
import com.reddit.social.presentation.groupchat.view.GroupMessagingScreen.Companion;

public class DeepLinkUtil {
    private static final String INTERNAL_SCHEME = "reddit";

    public interface ScreenDeepLinker {
        Screen createScreen();
    }

    public static Intent frontpage(Context context) {
        return IntentUtil.m23745a(context, BottomNavScreen.m38998w());
    }

    public static Intent popular(Context context) {
        return IntentUtil.m23745a(context, BottomNavScreen.m38999x());
    }

    public static Intent all(Context context) {
        return IntentUtil.m23745a(context, AllListingScreen.m42509S());
    }

    public static Intent userProfile(Context context, Bundle bundle) {
        bundle = bundle.getString("username");
        Session session = SessionManager.b().c;
        if (TextUtils.equals(bundle, "me") && session.isAnonymous()) {
            return IntentUtil.m23751a(context, false);
        }
        return IntentUtil.m23745a(context, ProfilePagerScreen.m39372b(bundle, 0));
    }

    public static Intent userProfileComments(Context context, Bundle bundle) {
        bundle = bundle.getString("username");
        Session session = SessionManager.b().c;
        if (TextUtils.equals(bundle, "me") && session.isAnonymous()) {
            return IntentUtil.m23751a(context, (boolean) null);
        }
        return IntentUtil.m23745a(context, ProfilePagerScreen.m39372b(bundle, 1));
    }

    public static Intent subreddit(Context context, Bundle bundle) {
        return IntentUtil.m23745a(context, LegacySubredditListingScreen.m42264b(bundle.getString("subreddit_name")));
    }

    public static Intent helpSubreddit(Context context) {
        return IntentUtil.m23745a(context, LegacySubredditListingScreen.m42264b("redditmobile"));
    }

    public static Intent detail(Context context, Bundle bundle) {
        return IntentUtil.m23745a(context, DetailHolderScreen.m38887b(bundle.getString("link_id"), bundle.getString("comment"), bundle.getString("context")));
    }

    public static Intent subredditInfo(Context context, Bundle bundle) {
        return IntentUtil.m23745a(context, SubredditInfoScreen.m41149b(bundle.getString("subreddit_name")));
    }

    public static Intent contactMods(Context context, Bundle bundle) {
        return IntentUtil.m23745a(context, ComposeScreen.m39155b(bundle.getString("to"), Boolean.valueOf(false)));
    }

    public static Intent liveThread(Context context) {
        return new Intent(context, LiveThreadActivity.class);
    }

    public static Intent messageThread(Context context, Bundle bundle) {
        return IntentUtil.m23745a(context, MessageThreadScreen.m39208a(bundle.getString("message_id")));
    }

    public static Intent chatMessage(Context context, Bundle bundle) {
        ScreenDeepLinker b;
        String string = bundle.getString("channel_url");
        if (FrontpageSettings.a().l()) {
            Companion companion = GroupMessagingScreen.f40214w;
            b = Companion.m24698b(string);
        } else {
            b = ChatInboxScreen.m41159a(string, ChatNavType.f22325c);
        }
        return IntentUtil.m23745a(context, b);
    }

    public static Intent chatInvite(Context context, Bundle bundle) {
        ScreenDeepLinker f;
        String string = bundle.getString("channel_url");
        if (FrontpageSettings.a().l()) {
            f = ChatRequestScreen.m41207f(string);
        } else {
            f = ChatInboxScreen.m41159a(string, ChatNavType.f22324b);
        }
        return IntentUtil.m23745a(context, f);
    }

    public static Intent modInvite(Context context, Bundle bundle) {
        return IntentUtil.m23745a(context, ModListPagerScreen.m40784a(bundle.getString("subreddit_name")));
    }

    public static boolean isInternal(Intent intent) {
        return TextUtils.equals(INTERNAL_SCHEME, intent.getDataString());
    }
}
