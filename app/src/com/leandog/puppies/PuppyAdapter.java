package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.findFor;
import static com.leandog.puppies.view.ViewHelper.setText;

import java.util.List;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.leandog.puppies.R.id;
import com.leandog.puppies.R.layout;
import com.leandog.puppies.data.Puppy;
import com.leandog.puppies.view.PuppyImageLoader;

class PuppyAdapter extends ArrayAdapter<Puppy> {

    private final List<Puppy> puppies;
	private final PuppyImageLoader puppyImageLoader;

    public PuppyAdapter(PuppyImageLoader puppyImageLoader, Context context, List<Puppy> puppies) {
        super(context, layout.puppy_item, puppies);
		this.puppyImageLoader = puppyImageLoader;
        this.puppies = puppies;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View theView = getView(convertView);
        displayPuppy(theView, puppies.get(position));
        return theView;
    }

    private View getView(View convertView) {
    	return convertView == null ? getInflater().inflate(layout.puppy_item, null) : convertView;
    }

    private void displayPuppy(View theView, Puppy thePuppy) {
        setText(theView, id.name, thePuppy.getName());
        setText(theView, id.breed, thePuppy.getBreed());
        setText(theView, id.gender, thePuppy.getGender());
        setText(theView, id.summary, Html.fromHtml(thePuppy.getDescription()));
        
        loadImage(theView, thePuppy.getImageUrl());
    }

    private void loadImage(View theView, String imageUrl) {
        ImageView theHeadshot = findFor(theView, id.headshot);
        this.puppyImageLoader.bind(theHeadshot, imageUrl);
    }

    private LayoutInflater getInflater() {
        return (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

}