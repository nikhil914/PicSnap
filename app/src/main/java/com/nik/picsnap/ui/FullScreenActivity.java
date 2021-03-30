    package com.nik.picsnap.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.nik.picsnap.R;
import com.nik.picsnap.databinding.ActivityFullScreenBinding;
import com.nik.picsnap.viewmodel.FullScreenViewModel;

    public class FullScreenActivity extends AppCompatActivity {

    ActivityFullScreenBinding mBinding;
    FullScreenViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_full_screen);
        mViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(FullScreenViewModel.class);
        mBinding.setModel(mViewModel);
        mBinding.setClickHandler(new ClickHandler());

        Intent previousIntent = getIntent();
        Log.i("TAG", "onCreate: "+previousIntent.getStringExtra("url"));
        mViewModel.getImageUrlLiveData().setValue(previousIntent.getStringExtra("url"));


    }

    public class ClickHandler{
        public void back(View view){
            onBackPressed();
        }
    }
}