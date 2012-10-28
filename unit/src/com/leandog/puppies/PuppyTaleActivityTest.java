package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.findFor;
import static com.leandog.puppies.view.ViewHelper.textOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import android.content.Intent;
import android.widget.ImageView;

import com.leandog.puppies.R.id;
import com.leandog.puppies.data.Puppy;
import com.leandog.puppies.test.PuppiesTestRunner;
import com.leandog.puppies.view.PuppyImageLoader;

@RunWith(PuppiesTestRunner.class)
public class PuppyTaleActivityTest {
    
    private PuppyTaleActivity activity;
    
    @Mock PuppyImageLoader puppyImageLoader;

    @Before
    public void setUp() {
        activity = new PuppyTaleActivity(puppyImageLoader);
    }

    @Test
    public void itDisplaysTheName() {
        createActivityWith(new Puppy("Sparky"));
        assertThat(textOf(activity, id.name), is("Sparky"));
    }
    
    @Test
    public void itDisplaysTheBreed() {
        createActivityWith(new Puppy("", "Terrier"));
        assertThat(textOf(activity, id.breed), is("Terrier"));
    }
    
    @Test
    public void itDisplaysTheGender() {
        createActivityWith(new Puppy("", "", "Female"));
        assertThat(textOf(activity, id.gender), is("Female"));
    }
    
    @Test
    public void itDisplaysTheDescription() {
        final Puppy thePuppy = new Puppy();
        thePuppy.setDescription("Expected description");
        createActivityWith(thePuppy);
        assertThat(textOf(activity, id.description), is("Expected description"));
    }
    
    @Test
    public void itDisplaysTheirBeautifulFace() {
        final Puppy thePuppy = new Puppy();
        thePuppy.setImageUrl("sparky.png");
        createActivityWith(thePuppy);
        
        final ImageView theHeadshot = findFor(activity, id.headshot);
        verify(puppyImageLoader).bind(theHeadshot, "http://puppies.herokuapp.com/assets/sparky.png");
    }

    private void createActivityWith(final Puppy puppy) {
        activity.setIntent(puppyIntent(puppy));
        activity.onCreate(null);
    }

    private Intent puppyIntent(final Puppy puppy) {
        final Intent intent = new Intent();
        intent.putExtra("thePuppy", puppy.toJson());
        return intent;
    }

}
