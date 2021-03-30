package com.nik.picsnap.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.nik.picsnap.databinding.ActivityMainBinding;
import com.nik.picsnap.retrofit.Repository;
import com.nik.picsnap.retrofit.ResponseModel;

public class MainActivityViewModel extends AndroidViewModel {

    public MutableLiveData<ResponseModel> responseModelMutableLiveData;
    Repository repository;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        init();
    }

    public void init() {

        responseModelMutableLiveData = new MutableLiveData<>();
        repository = new Repository(getApplication());
    }

    public void getImages(){
        repository.getPics("flower",responseModelMutableLiveData);
    }


    //getter and setter

    public MutableLiveData<ResponseModel> getResponseModelMutableLiveData() {
        return responseModelMutableLiveData;
    }

    public void setResponseModelMutableLiveData(MutableLiveData<ResponseModel> responseModelMutableLiveData) {
        this.responseModelMutableLiveData = responseModelMutableLiveData;
    }


}
