package com.leandog.puppies.view;

import com.google.android.imageloader.ImageLoader;

import android.widget.ImageView;

public class PuppyImageLoader {
    
    private ImageLoader imageLoader;

    public PuppyImageLoader() {
        imageLoader = new ImageLoader();
    }

    public void bind(ImageView theHeadshot, String imageUrl) {
        imageLoader.bind(theHeadshot, imageUrl, null);
    }

}
