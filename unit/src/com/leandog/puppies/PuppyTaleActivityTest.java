package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.textOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Intent;

import com.google.gson.Gson;
import com.leandog.puppies.R.id;
import com.leandog.puppies.data.Puppy;
import com.leandog.puppies.test.PuppiesTestRunner;

@RunWith(PuppiesTestRunner.class)
public class PuppyTaleActivityTest {
    
    private PuppyTaleActivity activity;

    @Before
    public void setUp() {
        activity = new PuppyTaleActivity();
    }
    
    @Test
    public void itDisplaysTheName() {
        createPuppyTaleFor(new Puppy("Sparky"));
        assertThat(textOf(activity, id.name), is("Sparky"));
    }

    private void createPuppyTaleFor(Puppy puppy) {
        activity.setIntent(theBundledPuppy(puppy));
        activity.onCreate(null);
    }

    private Intent theBundledPuppy(Puppy puppy) {
        Intent intent = new Intent();
        intent.putExtra("thePuppy", new Gson().toJson(puppy));
        return intent;
    }

}
