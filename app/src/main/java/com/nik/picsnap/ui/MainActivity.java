package com.nik.picsnap.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.nik.picsnap.R;
import com.nik.picsnap.databinding.ActivityMainBinding;
import com.nik.picsnap.retrofit.ResponseModel;
import com.nik.picsnap.util.PicAdapter;
import com.nik.picsnap.viewmodel.MainActivityViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    public MainActivityViewModel mViewModel;

    RecyclerView recyclerView;
    PicAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(MainActivityViewModel.class);

        mBinding.setLifecycleOwner(this);
        mBinding.setModel(mViewModel);

        recyclerView = mBinding.recyclerView;


        mViewModel.getImages();

        observeLiveData();


    }

    private void observeLiveData() {
        mViewModel.getResponseModelMutableLiveData().observe(this, new Observer<ResponseModel>() {
            @Override
            public void onChanged(ResponseModel responseModel) {
                if (responseModel!=null){

                    Log.i("TAG", "onChanged: "+responseModel.getHits().size());

                    mAdapter = new PicAdapter(responseModel.getHits(),MainActivity.this);
                    recyclerView.setAdapter(mAdapter);

                }
            }
        });
    }
}