package com.nik.picsnap.retrofit;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PicApi {

    @GET("api/")
    Call<ResponseModel> getImages(@Query("key")String key,@Query("q")String q,@Query("image_type")String type);

}


