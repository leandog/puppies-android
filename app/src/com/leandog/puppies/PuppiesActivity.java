package com.leandog.puppies;

import android.app.ActionBar;
import android.os.Bundle;

import com.leandog.puppies.R.layout;

public class PuppiesActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_puppies);
        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getActionBar().setCustomView(layout.happy_banner);
    }
}
