package com.leandog.puppies;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.leandog.puppies.R.layout;
import com.leandog.puppies.data.Puppy;

class PuppyAdapter extends ArrayAdapter<Puppy> {

    public PuppyAdapter(Context context, List<Puppy> puppies) {
        super(context, layout.puppy_item, puppies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View theView = getView(convertView);
        return theView;
    }

    private View getView(View convertView) {
    	return convertView == null ? getInflater().inflate(layout.puppy_item, null) : convertView;
    }


    private LayoutInflater getInflater() {
        return (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

}