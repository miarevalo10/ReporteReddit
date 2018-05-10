package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ListService {
    @GET(a = "/1.1/lists/statuses.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    Call<List<Tweet>> statuses(@Query(a = "list_id") Long l, @Query(a = "slug") String str, @Query(a = "owner_screen_name") String str2, @Query(a = "owner_id") Long l2, @Query(a = "since_id") Long l3, @Query(a = "max_id") Long l4, @Query(a = "count") Integer num, @Query(a = "include_entities") Boolean bool, @Query(a = "include_rts") Boolean bool2);
}
