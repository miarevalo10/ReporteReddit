package com.reddit.frontpage.nav;

import android.net.Uri;
import com.google.common.base.Preconditions;
import com.reddit.datalibrary.frontpage.data.feature.common.LinkSortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.data.model.BannedUser;
import com.reddit.datalibrary.frontpage.data.model.Moderator;
import com.reddit.datalibrary.frontpage.data.model.MutedUser;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.DetailHolderScreen;
import com.reddit.frontpage.domain.model.Region;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.presentation.communities.CommunitiesScreen;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectScreen;
import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularSubregionSelectScreen;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import com.reddit.frontpage.presentation.listing.history.HistoryListingScreen;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerScreen;
import com.reddit.frontpage.presentation.modtools.actions.ModToolsActionsScreen;
import com.reddit.frontpage.presentation.modtools.approvedsubmitters.ApprovedSubmittersScreen;
import com.reddit.frontpage.presentation.modtools.approvedsubmitters.add.AddApprovedSubmitterScreen;
import com.reddit.frontpage.presentation.modtools.ban.BannedUsersScreen;
import com.reddit.frontpage.presentation.modtools.ban.add.AddBannedUserScreen;
import com.reddit.frontpage.presentation.modtools.modlist.ModListPagerScreen;
import com.reddit.frontpage.presentation.modtools.modlist.add.AddModeratorScreen;
import com.reddit.frontpage.presentation.modtools.modqueue.modcommunities.ModCommunitiesScreen;
import com.reddit.frontpage.presentation.modtools.mute.MutedUsersScreen;
import com.reddit.frontpage.presentation.modtools.mute.add.AddMutedUserScreen;
import com.reddit.frontpage.presentation.modtools.util.ModToolsAction;
import com.reddit.frontpage.presentation.onboarding.OnboardingScreen;
import com.reddit.frontpage.presentation.profile.user.UserAccountScreen;
import com.reddit.frontpage.presentation.search.CommunitySearchScreen;
import com.reddit.frontpage.presentation.subreddit.rules.view.SubredditRulesScreen;
import com.reddit.frontpage.ui.HomeScreen;
import com.reddit.frontpage.ui.LoggedOutScreen;
import com.reddit.frontpage.ui.ModMailScreenLegacy;
import com.reddit.frontpage.ui.detail.image.LightboxScreen;
import com.reddit.frontpage.ui.detail.video.VideoPlayerScreen;
import com.reddit.frontpage.ui.detail.video.VideoPlayerScreenLegacy;
import com.reddit.frontpage.ui.inbox.ComposeScreen;
import com.reddit.frontpage.ui.inbox.InboxPagerScreen;
import com.reddit.frontpage.ui.inbox.MessageThreadScreen;
import com.reddit.frontpage.ui.listing.AllListingScreen;
import com.reddit.frontpage.ui.listing.LegacySubredditListingScreen;
import com.reddit.frontpage.ui.listing.ModQueueListingScreen;
import com.reddit.frontpage.ui.listing.MultiredditCommunitiesScreen;
import com.reddit.frontpage.ui.listing.MultiredditListingScreen;
import com.reddit.frontpage.ui.listing.UserCommentsListingScreen;
import com.reddit.frontpage.ui.listing.UserSubmittedListingScreen;
import com.reddit.frontpage.ui.profile.MeAccountScreen;
import com.reddit.frontpage.ui.profile.ProfilePagerScreen;
import com.reddit.frontpage.ui.profile.SavedPagerScreen;
import com.reddit.frontpage.ui.profile.profilesettings.view.ProfileSettingsScreen;
import com.reddit.frontpage.ui.search.CombinedSearchResultScreen;
import com.reddit.frontpage.ui.search.LinkSearchResultScreen;
import com.reddit.frontpage.ui.search.SubredditSearchResultScreen;
import com.reddit.frontpage.ui.submit.LinkFlairSelectScreen;
import com.reddit.frontpage.ui.submit.LinkSubmitScreen;
import com.reddit.frontpage.ui.submit.MediaSubmitScreen;
import com.reddit.frontpage.ui.submit.SelfSubmitScreen;
import com.reddit.frontpage.ui.submit.location.LocationSearchScreen;
import com.reddit.frontpage.ui.submit.search.SubredditSelectScreen;
import com.reddit.frontpage.ui.subreddit.SubredditInfoScreen;
import com.reddit.social.presentation.chatinbox.view.ChatInboxScreen;
import com.reddit.social.presentation.chatinbox.view.ChatInboxScreen.ChatNavType;
import com.reddit.social.presentation.chatinbox.view.ChatInboxScreen.Companion;
import com.reddit.social.presentation.chatrequests.view.ChatRequestListScreen;
import com.reddit.social.presentation.chatrequests.view.ChatRequestScreen;
import com.reddit.social.presentation.contacts.view.ContactsActionType;
import com.reddit.social.presentation.contacts.view.ContactsActionType.CREATE;
import com.reddit.social.presentation.contacts.view.ContactsScreen;
import com.reddit.social.presentation.groupchat.view.GroupMembersScreen;
import com.reddit.social.presentation.groupchat.view.GroupMessagingScreen;
import com.reddit.social.presentation.groupchat.view.MessagingSettingsScreen;
import com.reddit.social.presentation.presentationobjects.UserData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

public class Nav {
    public static Screen m22536a() {
        return HomeScreen.m39019w();
    }

    public static Screen m22563b() {
        return AllListingScreen.m42510w();
    }

    public static Screen m22547a(String str) {
        return CommunitiesScreen.m40559c(str);
    }

    public static Screen m22566b(String str) {
        return LegacySubredditListingScreen.m42256a(str);
    }

    public static Screen m22544a(Subreddit subreddit) {
        return LegacySubredditListingScreen.m42267c(subreddit);
    }

    public static Screen m22571c(String str) {
        return ModQueueListingScreen.m42545d(str);
    }

    public static Screen m22575d(String str) {
        return ModQueueListingScreen.m42546e(str);
    }

    public static Screen m22568c() {
        return ModCommunitiesScreen.m40814x();
    }

    public static Screen m22565b(Subreddit subreddit) {
        return SubredditInfoScreen.m41148a(subreddit);
    }

    public static Screen m22579e(String str) {
        return SubredditRulesScreen.m38963b(str);
    }

    public static Screen m22582f(String str) {
        return MultiredditListingScreen.m41013a(str);
    }

    public static Screen m22585g(String str) {
        return MultiredditCommunitiesScreen.m39305a(str);
    }

    public static Screen m22542a(Link link, String str) {
        return DetailHolderScreen.m38884a(link, str);
    }

    public static Screen m22557a(String str, String str2, String str3) {
        return DetailHolderScreen.m38885a(str, str2, str3);
    }

    public static Screen m22588h(String str) {
        return ComposeScreen.m39153a(str, Boolean.valueOf(false));
    }

    public static Screen m22591i(String str) {
        return ComposeScreen.m39153a(str, Boolean.valueOf(true));
    }

    public static Screen m22594j(String str) {
        return ProfilePagerScreen.m39369a(str);
    }

    public static Screen m22597k(String str) {
        return ProfileSettingsScreen.m39429c(str);
    }

    public static Screen m22551a(String str, String str2) {
        return UserAccountScreen.m40890a(str, str2);
    }

    public static Screen m22573d() {
        return MeAccountScreen.m41054y();
    }

    public static Screen m22577e() {
        return SavedPagerScreen.m39404w();
    }

    public static Screen m22581f() {
        return HistoryListingScreen.N_();
    }

    public static Screen m22600l(String str) {
        return UserSubmittedListingScreen.m41025a(str);
    }

    public static Screen m22602m(String str) {
        return UserCommentsListingScreen.m39314a(str);
    }

    public static Screen m22584g() {
        return InboxPagerScreen.m39195w();
    }

    public static Screen m22587h() {
        Companion companion = ChatInboxScreen.f40185y;
        return Companion.m24516a("", ChatNavType.f22323a);
    }

    public static Screen m22567b(String str, String str2) {
        return MessageThreadScreen.m39207a(str, str2);
    }

    public static Screen m22590i() {
        return LoggedOutScreen.m39031a((int) C1761R.string.label_join_reddit, (int) C1761R.string.label_logged_out_profile, null);
    }

    public static Screen m22537a(int i, int i2, Boolean bool) {
        return LoggedOutScreen.m39031a(i, i2, bool);
    }

    public static Screen m22603n(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                return CombinedSearchResultScreen.m39457a(str);
            }
        }
        return CommunitySearchScreen.m40902b("");
    }

    public static Screen m22604o(String str) {
        return CommunitySearchScreen.m40902b(str);
    }

    public static Screen m22570c(Subreddit subreddit) {
        return ModToolsActionsScreen.m40719b(subreddit);
    }

    public static Screen m22545a(Subreddit subreddit, List<ModToolsAction> list) {
        return ModToolsActionsScreen.m40715a(subreddit, (List) list);
    }

    public static Screen m22572c(String str, String str2) {
        return BannedUsersScreen.m42099a(str, str2);
    }

    public static Screen m22576d(String str, String str2) {
        return ApprovedSubmittersScreen.m42093a(str, str2);
    }

    public static Screen m22580e(String str, String str2) {
        return MutedUsersScreen.m42118a(str, str2);
    }

    public static Screen m22583f(String str, String str2) {
        return AddMutedUserScreen.m40824a(str, str2);
    }

    public static Screen m22555a(String str, String str2, MutedUser mutedUser) {
        return AddMutedUserScreen.m40825a(str, str2, mutedUser);
    }

    public static Screen m22559a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return AddMutedUserScreen.m40826a(str, str2, str3, str4, str5, str6, str7);
    }

    public static Screen m22586g(String str, String str2) {
        return AddApprovedSubmitterScreen.m40727a(str, str2);
    }

    public static Screen m22589h(String str, String str2) {
        return AddBannedUserScreen.m40737a(str, str2);
    }

    public static Screen m22556a(String str, String str2, Link link) {
        return AddBannedUserScreen.m40739a(str, str2, link);
    }

    public static Screen m22549a(String str, Comment comment) {
        return AddBannedUserScreen.m40736a(str, comment);
    }

    public static Screen m22553a(String str, String str2, BannedUser bannedUser) {
        return AddBannedUserScreen.m40738a(str, str2, bannedUser);
    }

    public static Screen m22592i(String str, String str2) {
        return ModListPagerScreen.m40783a(str, str2);
    }

    public static Screen m22605p(String str) {
        return ModMailScreenLegacy.m42151a(str);
    }

    public static Screen m22595j(String str, String str2) {
        return AddModeratorScreen.m40796a(str, str2);
    }

    public static Screen m22554a(String str, String str2, Moderator moderator) {
        return AddModeratorScreen.m40797a(str, str2, moderator);
    }

    public static Screen m22562a(String str, boolean z) {
        return LinkSearchResultScreen.m39483a(str, z);
    }

    public static Screen m22560a(String str, ArrayList<ThingWrapper> arrayList, String str2) {
        return SubredditSearchResultScreen.m39502a(str, arrayList, str2);
    }

    public static Screen m22574d(Subreddit subreddit) {
        return SelfSubmitScreen.m41139a(subreddit, null);
    }

    public static Screen m22606q(String str) {
        return SelfSubmitScreen.m41139a(null, str);
    }

    public static Screen m22578e(Subreddit subreddit) {
        return LinkSubmitScreen.m41098a(subreddit, null);
    }

    public static Screen m22607r(String str) {
        return LinkSubmitScreen.m41098a(null, str);
    }

    public static Screen m22608s(String str) {
        return SubredditSelectScreen.m39598a(str);
    }

    public static Screen m22558a(String str, String str2, String str3, Link link) {
        GroupMessagingScreen.Companion companion = GroupMessagingScreen.f40214w;
        return GroupMessagingScreen.Companion.m24696a(str, str2, str3, link);
    }

    public static Screen m22593j() {
        return ChatRequestListScreen.m41187x();
    }

    public static Screen m22609t(String str) {
        return ChatRequestScreen.m41206e(str);
    }

    public static Screen m22598k(String str, String str2) {
        GroupMessagingScreen.Companion companion = GroupMessagingScreen.f40214w;
        return GroupMessagingScreen.Companion.m24695a(str, str2);
    }

    public static Screen m22596k() {
        return m22546a(new CREATE((byte) 0), Collections.emptySet());
    }

    public static Screen m22546a(ContactsActionType contactsActionType, Set<UserData> set) {
        ContactsScreen.Companion companion = ContactsScreen.f40201w;
        Intrinsics.m26847b(contactsActionType, "contactsActionType");
        Intrinsics.m26847b(set, "members");
        return ContactsScreen.Companion.m24597a(contactsActionType, set);
    }

    public static Screen m22610u(String str) {
        MessagingSettingsScreen.Companion companion = MessagingSettingsScreen.f40221w;
        return MessagingSettingsScreen.Companion.m24702a(str);
    }

    public static Screen m22561a(String str, List<UserData> list) {
        GroupMembersScreen.Companion companion = GroupMembersScreen.f40207y;
        return GroupMembersScreen.Companion.m24692a(str, list);
    }

    public static Screen m22552a(String str, String str2, int i, int i2) {
        return LightboxScreen.m40922a(str, str2, i, i2);
    }

    public static Screen m22564b(Link link, String str) {
        return LightboxScreen.m40921a(link, str);
    }

    public static Screen m22540a(Uri uri, Uri uri2, String str) {
        if (InternalSettings.a().q()) {
            return VideoPlayerScreenLegacy.m40970a(uri2.toString(), uri.toString(), str);
        }
        return VideoPlayerScreen.m40932a(uri2.toString(), uri.toString(), str);
    }

    public static Screen m22569c(Link link, String str) {
        if (link.isVideo()) {
            if (!InternalSettings.a().q()) {
                return VideoPlayerScreen.m40931a(link, str);
            }
        }
        return VideoPlayerScreenLegacy.m40969a(link, str);
    }

    public static Screen m22539a(int i, Subreddit subreddit) {
        return MediaSubmitScreen.m41106a(i, subreddit, null);
    }

    public static Screen m22538a(int i, Uri uri) {
        return MediaSubmitScreen.m41106a(i, null, uri);
    }

    public static Screen m22611v(String str) {
        return MediaSubmitScreen.m41113d(str);
    }

    public static Screen m22612w(String str) {
        return LocationSearchScreen.m39577a(str);
    }

    public static Screen m22599l() {
        return new GeopopularRegionSelectScreen();
    }

    public static Screen m22543a(Region region, boolean z, List<String> list) {
        return GeopopularSubregionSelectScreen.m40605a(region, list, z);
    }

    public static Screen m22550a(String str, Thing thing, LinkFlair linkFlair, String str2) {
        return LinkFlairSelectScreen.m39550a(str, thing, linkFlair, str2);
    }

    public static Screen m22601m() {
        return OnboardingScreen.m40868x();
    }

    public static Screen m22548a(String str, int i, ListingType listingType, LinkSortType linkSortType, SortTimeFrame sortTimeFrame) {
        return LinkPagerScreen.m40639a(str, i, (ListingType) Preconditions.a(listingType), (LinkSortType) Preconditions.a(linkSortType), sortTimeFrame);
    }

    public static Screen m22541a(Link link) {
        return DetailHolderScreen.m38884a(link, null);
    }
}
