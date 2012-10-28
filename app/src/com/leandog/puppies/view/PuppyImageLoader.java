package com.leandog.puppies.view;

import com.google.android.imageloader.ImageLoader;

import android.widget.ImageView;

public class PuppyImageLoader {
    
    private ImageLoader imageLoader;

    public PuppyImageLoader() {
        imageLoader = new ImageLoader();
    }

    public void bind(final ImageView imageView, final String imageUrl) {
        imageLoader.bind(imageView, imageUrl, null);
    }

}
