package com.leandog.puppies;

import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

public class Activity extends android.app.Activity {
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_default, menu);
        return true;
    }
}
