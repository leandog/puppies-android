package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.textOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Intent;

import com.leandog.puppies.R.id;
import com.leandog.puppies.data.Puppy;
import com.leandog.puppies.test.PuppiesTestRunner;

@RunWith(PuppiesTestRunner.class)
public class PuppyTaleActivityTest {
    
    @Test
    public void itDisplaysTheName() {
        PuppyTaleActivity activity = new PuppyTaleActivity();
        final Puppy sparky = new Puppy("Sparky");
        final Intent intent = new Intent();
        intent.putExtra("thePuppy", sparky.toJson());
        activity.setIntent(intent);
        activity.onCreate(null);
        
        assertThat(textOf(activity, id.name), is("Sparky"));
    }

}
