package com.nik.picsnap.retrofit;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.nik.picsnap.util.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class Repository {

    Context context;
    PicApi picApi;

    public Repository(Context context) {
        this.context = context;
        picApi = RetrofitService.createService(PicApi.class);
    }

    public void getPics(String searchQuery, MutableLiveData<ResponseModel> responseModelMutableLiveData){
        picApi.getImages("20933266-8fd19fa9cf0ec83ece2ede9e2",searchQuery,"photo").enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Log.i(TAG, "onResponse: "+response.message());
                Log.i(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()){
                    responseModelMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}


