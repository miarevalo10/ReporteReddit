package com.reddit.datalibrary.frontpage.service.api;

import java.util.Map;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Url;

public interface AwsService {
    @POST
    @Multipart
    Call<String> uploadFile(@Url String str, @PartMap Map<String, String> map, @Part MultipartBody.Part part);
}
