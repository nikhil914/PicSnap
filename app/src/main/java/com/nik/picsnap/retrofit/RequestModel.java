package com.nik.picsnap.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestModel {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("q")
    @Expose
    private String q;
    @SerializedName("image_type")
    @Expose
    private String image_type;

    public RequestModel(String key, String q, String image_type) {
        this.key = key;
        this.q = q;
        this.image_type = image_type;
    }
}
