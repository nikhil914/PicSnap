package com.nik.picsnap.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.nik.picsnap.R;
import com.nik.picsnap.databinding.PicItemBinding;
import com.nik.picsnap.retrofit.ResponseModel;
import com.nik.picsnap.ui.FullScreenActivity;

import java.util.List;

public class PicAdapter extends RecyclerView.Adapter<PicAdapter.ViewHolder> {

    List<ResponseModel.Hit> mList;
    Activity context;

    public PicAdapter(List<ResponseModel.Hit> mList, Activity context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.pic_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemBinding.setModel(mList.get(position));

        ViewCompat.setTransitionName(holder.itemView, "hello");

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        PicItemBinding itemBinding;
        public ViewHolder(@NonNull PicItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding =itemView;

            itemBinding.setClickHandler(new ClickHandler(itemBinding));
        }
    }
    public class ClickHandler{
        PicItemBinding itemBinding;
        public ClickHandler(PicItemBinding itemBinding) {
            this.itemBinding =itemBinding;
        }

        public void viewPic(View view, String url){
            Intent intent = new Intent(context, FullScreenActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            String transitionName = context.getString(R.string.transition_string);


            intent.putExtra("url",url);

            ActivityOptionsCompat options =

                    ActivityOptionsCompat.makeSceneTransitionAnimation(context,
                           view,   // Starting view
                            transitionName    // The String
                    );
            //Start the Intent
            context.startActivity( intent, options.toBundle());

//            context.startActivity(intent);

        }
    }
}
