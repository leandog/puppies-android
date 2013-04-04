package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.findFor;
import static com.leandog.puppies.view.ViewHelper.setText;
import android.os.Bundle;
import android.text.Html;
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

    public PuppyTaleActivity(PuppyImageLoader puppyImageLoader) {
        this.puppyImageLoader = puppyImageLoader;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_puppy_tale);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        Puppy thePuppy = getPuppy();
        setText(this, id.name, thePuppy.getName());
        setText(this, id.breed, thePuppy.getBreed());
        setText(this, id.gender, thePuppy.getGender());
        setText(this, id.description, Html.fromHtml(thePuppy.getDescription()));
        setText(this, id.adoption_fee, String.format("$%.2f", thePuppy.getFee()));
        
        ImageView theHeadshot = findFor(this, id.headshot);
        puppyImageLoader.bind(theHeadshot, thePuppy.getImageUrl());
    }

    private Puppy getPuppy() {
        return Puppy.fromJson(getIntent().getStringExtra("thePuppy"));
    }

}
