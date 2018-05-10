package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.services.params.Geocode;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchService {
    @GET(a = "/1.1/search/tweets.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<Object> tweets(@Query(a = "q") String str, @Query(a = "geocode", b = true) Geocode geocode, @Query(a = "lang") String str2, @Query(a = "locale") String str3, @Query(a = "result_type") String str4, @Query(a = "count") Integer num, @Query(a = "until") String str5, @Query(a = "since_id") Long l, @Query(a = "max_id") Long l2, @Query(a = "include_entities") Boolean bool);
}
