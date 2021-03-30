package com.nik.picsnap.util;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.nik.picsnap.R;

public class DataBinderAdapterUtil {


    @BindingAdapter({"imageUrl"})
    public static void loadImageIntoView(ImageView imageView, String imageURL) {

        Log.i("TAG", "loadImageIntoView: "+imageURL);
        Glide.with(imageView)
                .applyDefaultRequestOptions(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                .load(imageURL)
                .thumbnail(Glide.with(imageView.getContext()).load(R.drawable.loading))
                .into(imageView);

    }

}
