package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.findFor;
import static com.leandog.puppies.view.ViewHelper.setText;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.leandog.puppies.R.id;
import com.leandog.puppies.R.layout;
import com.leandog.puppies.data.Puppy;
import com.leandog.puppies.view.PuppyImageLoader;

public class PuppyTaleActivity extends Activity {

    private final PuppyImageLoader puppyImageLoader;
    
    public PuppyTaleActivity() {
        this(new PuppyImageLoader());
    }

    public PuppyTaleActivity(final PuppyImageLoader puppyImageLoader) {
        this.puppyImageLoader = puppyImageLoader;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_puppy_tale);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        final Puppy thePuppy = getPuppy();
        setText(this, id.name, thePuppy.getName());
        setText(this, id.breed, thePuppy.getBreed());
        setText(this, id.gender, thePuppy.getGender());
        setText(this, id.description, Html.fromHtml(thePuppy.getDescription()));
        setText(this, id.adoption_fee, String.format("$%.2f", thePuppy.getFee()));
        
        final ImageView theHeadshot = findFor(this, id.headshot);
        puppyImageLoader.bind(theHeadshot, thePuppy.getImageUrl());
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

    private Puppy getPuppy() {
        return Puppy.fromJson(getIntent().getStringExtra("thePuppy"));
    }

}
