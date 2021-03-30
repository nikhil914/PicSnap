package com.nik.picsnap.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class FullScreenViewModel extends AndroidViewModel {

    MutableLiveData<String> imageUrlLiveData;

    public FullScreenViewModel(@NonNull Application application) {
        super(application);

        init();
    }

    public void init() {

        imageUrlLiveData = new MutableLiveData<>("");
    }




    //getter And Setter

    public MutableLiveData<String> getImageUrlLiveData() {
        return imageUrlLiveData;
    }

    public void setImageUrlLiveData(MutableLiveData<String> imageUrlLiveData) {
        this.imageUrlLiveData = imageUrlLiveData;
    }
}
