package com.student0.www.holder;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.student0.www.Config;
import com.student0.www.adapter.DataForm;
import com.student0.www.skyone.R;
import com.student0.www.util.ImageLoader;
import com.student0.www.util.SkyOneLocalImage;
import com.student0.www.util.Type;

/**
 * Created by willj on 2017/2/23.
 */

public class PhotoHolder extends RecyclerView.ViewHolder{

    public ImageView imageView;
    public Bitmap bitmap;
    public String url;

    public PhotoHolder(View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.id_item_photo);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(url);
            }
        });
    }

    public void bindHolder(DataForm dataForm){
        imageView.setImageDrawable(null);
        ImageLoader.getInstance(Config.THREAD_NUMBER_URL_LOAD, Type.LIFO).loadImages(dataForm.getData(), imageView);
    }
}
