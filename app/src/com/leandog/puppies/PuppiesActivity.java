package com.leandog.puppies;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.leandog.puppies.R.layout;
import com.leandog.puppies.data.PuppiesLoader;

public class PuppiesActivity extends Activity {

    private final PuppiesLoader puppiesLoader;
    
    public PuppiesActivity() {
        this(new PuppiesLoader());
    }

    public PuppiesActivity(final PuppiesLoader puppiesLoader) {
        this.puppiesLoader = puppiesLoader;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_puppies);

        initializeActionBar();
        puppiesLoader.load();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_puppies, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeActionBar() {
        final ActionBar theActionBar = getActionBar();
        theActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        theActionBar.setCustomView(layout.happy_banner);
    }

}
