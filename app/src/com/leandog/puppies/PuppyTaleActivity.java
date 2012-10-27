package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.setText;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.leandog.puppies.R.id;
import com.leandog.puppies.R.layout;
import com.leandog.puppies.data.Puppy;

public class PuppyTaleActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_puppy_tale);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        final Puppy thePuppy = thePuppy();
        setText(this, id.name, thePuppy.getName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_puppy_tale, menu);
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

    private Puppy thePuppy() {
        return new Gson().fromJson(getIntent().getExtras().getString("thePuppy"), Puppy.class);
    }

}
