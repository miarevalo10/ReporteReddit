package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StatusesService {
    @FormUrlEncoded
    @POST(a = "/1.1/statuses/destroy/{id}.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<Tweet> destroy(@Path(a = "id") Long l, @Field(a = "trim_user") Boolean bool);

    @GET(a = "/1.1/statuses/home_timeline.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<List<Tweet>> homeTimeline(@Query(a = "count") Integer num, @Query(a = "since_id") Long l, @Query(a = "max_id") Long l2, @Query(a = "trim_user") Boolean bool, @Query(a = "exclude_replies") Boolean bool2, @Query(a = "contributor_details") Boolean bool3, @Query(a = "include_entities") Boolean bool4);

    @GET(a = "/1.1/statuses/lookup.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<List<Tweet>> lookup(@Query(a = "id") String str, @Query(a = "include_entities") Boolean bool, @Query(a = "trim_user") Boolean bool2, @Query(a = "map") Boolean bool3);

    @GET(a = "/1.1/statuses/mentions_timeline.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<List<Tweet>> mentionsTimeline(@Query(a = "count") Integer num, @Query(a = "since_id") Long l, @Query(a = "max_id") Long l2, @Query(a = "trim_user") Boolean bool, @Query(a = "contributor_details") Boolean bool2, @Query(a = "include_entities") Boolean bool3);

    @FormUrlEncoded
    @POST(a = "/1.1/statuses/retweet/{id}.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<Tweet> retweet(@Path(a = "id") Long l, @Field(a = "trim_user") Boolean bool);

    @GET(a = "/1.1/statuses/retweets_of_me.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<List<Tweet>> retweetsOfMe(@Query(a = "count") Integer num, @Query(a = "since_id") Long l, @Query(a = "max_id") Long l2, @Query(a = "trim_user") Boolean bool, @Query(a = "include_entities") Boolean bool2, @Query(a = "include_user_entities") Boolean bool3);

    @GET(a = "/1.1/statuses/show.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<Tweet> show(@Query(a = "id") Long l, @Query(a = "trim_user") Boolean bool, @Query(a = "include_my_retweet") Boolean bool2, @Query(a = "include_entities") Boolean bool3);

    @FormUrlEncoded
    @POST(a = "/1.1/statuses/unretweet/{id}.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<Tweet> unretweet(@Path(a = "id") Long l, @Field(a = "trim_user") Boolean bool);

    @FormUrlEncoded
    @POST(a = "/1.1/statuses/update.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<Tweet> update(@Field(a = "status") String str, @Field(a = "in_reply_to_status_id") Long l, @Field(a = "possibly_sensitive") Boolean bool, @Field(a = "lat") Double d, @Field(a = "long") Double d2, @Field(a = "place_id") String str2, @Field(a = "display_cooridnates") Boolean bool2, @Field(a = "trim_user") Boolean bool3, @Field(a = "media_ids") String str3);

    @GET(a = "/1.1/statuses/user_timeline.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<List<Tweet>> userTimeline(@Query(a = "user_id") Long l, @Query(a = "screen_name") String str, @Query(a = "count") Integer num, @Query(a = "since_id") Long l2, @Query(a = "max_id") Long l3, @Query(a = "trim_user") Boolean bool, @Query(a = "exclude_replies") Boolean bool2, @Query(a = "contributor_details") Boolean bool3, @Query(a = "include_rts") Boolean bool4);
}
