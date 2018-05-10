package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface FavoriteService {
    @FormUrlEncoded
    @POST(a = "/1.1/favorites/create.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<Tweet> create(@Field(a = "id") Long l, @Field(a = "include_entities") Boolean bool);

    @FormUrlEncoded
    @POST(a = "/1.1/favorites/destroy.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<Tweet> destroy(@Field(a = "id") Long l, @Field(a = "include_entities") Boolean bool);

    @GET(a = "/1.1/favorites/list.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<List<Tweet>> list(@Query(a = "user_id") Long l, @Query(a = "screen_name") String str, @Query(a = "count") Integer num, @Query(a = "since_id") String str2, @Query(a = "max_id") String str3, @Query(a = "include_entities") Boolean bool);
}
