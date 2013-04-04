package com.leandog.puppies;

import android.os.Bundle;

import com.leandog.puppies.R.layout;

public class PuppyTaleActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_puppy_tale);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
