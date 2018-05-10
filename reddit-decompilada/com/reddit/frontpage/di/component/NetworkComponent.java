package com.reddit.frontpage.di.component;

import com.reddit.config.RedditGlideModule;
import com.reddit.datalibrary.frontpage.redditauth.api.RedditAuthClient;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon;
import com.reddit.datalibrary.frontpage.service.api.AwsService;
import com.reddit.frontpage.video.mpdparser.core.mapper.LocalUrlMPDMapper;
import com.reddit.frontpage.video.proxy.DashProxy;
import com.reddit.frontpage.widgets.video.VideoPlayer;
import javax.inject.Singleton;

@Singleton
public interface NetworkComponent {
    void mo4694a(RedditGlideModule redditGlideModule);

    void mo4695a(RedditAuthClient redditAuthClient);

    void mo4696a(RedditClient redditClient);

    void mo4697a(Cannon cannon);

    void mo4698a(LocalUrlMPDMapper localUrlMPDMapper);

    void mo4699a(DashProxy dashProxy);

    void mo4700a(VideoPlayer videoPlayer);

    AwsService mo4701b();
}
