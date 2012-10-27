package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.findFor;
import static com.leandog.puppies.view.ViewHelper.textOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.leandog.puppies.R.id;
import com.leandog.puppies.data.PuppiesLoader;
import com.leandog.puppies.data.Puppy;
import com.leandog.puppies.test.PuppiesTestRunner;
import com.leandog.puppies.view.PuppyImageLoader;
import com.xtremelabs.robolectric.matchers.StartedMatcher;

@RunWith(PuppiesTestRunner.class)
public class PuppiesActivityTest {
    private PuppiesActivity activity;
    
    @Mock
    private PuppiesLoader puppiesLoader;
    
    @Mock
    private PuppyImageLoader puppyImageLoader;
    
    @Before
    public void setUp() {
        activity = new PuppiesActivity(puppiesLoader, puppyImageLoader);
    }
    
    @Test
    public void itRetrievesThePuppies() {
        createActivity();
        verify(puppiesLoader).load();
    }
    
    @Test
    public void itKnowsWhenTheyHaveLoaded() {
        createActivity();
        
        final ProgressBar theProgress = findFor(activity, id.loading);
        assertThat(theProgress.getVisibility(), is(View.GONE));
    }
    
    @Test
    public void itListsThePuppies() {
        thePuppiesAre(new Puppy(), new Puppy());
        createActivity();
        
        assertThat(thePuppies().getChildCount(), is(2));
    }
    
    @Test
    public void itDisplaysTheName() {
        thePuppiesAre(new Puppy("Sparky"));
        createActivity();
        
        final View thePuppy = thePuppies().getChildAt(0);
        assertThat(textOf(thePuppy, id.name), is("Sparky"));
    }
    
    @Test
    public void itDisplaysTheBreed() {
        thePuppiesAre(new Puppy("", "Terrier"));
        createActivity();
        
        final View thePuppy = thePuppies().getChildAt(0);
        assertThat(textOf(thePuppy, id.breed), is("Terrier"));
    }
    
    @Test
    public void itDisplaysTheGender() {
        thePuppiesAre(new Puppy("", "", "Female"));
        createActivity();
        
        final View thePuppy = thePuppies().getChildAt(0);
        assertThat(textOf(thePuppy, id.gender), is("Female"));
    }
    
    @Test
    public void itDisplaysTheSummary() {
        thePuppiesAre(new Puppy() {{ setDescription("the description"); }});
        createActivity();
        
        final View thePuppy = thePuppies().getChildAt(0);
        assertThat(textOf(thePuppy, id.summary), is("the description"));
    }

    @Test
    public void itDisplaysTheirBeautifulFace() {
        thePuppiesAre(new Puppy() {{ setImageUrl("sparky.png"); }});
        createActivity();
        
        final ImageView theHeadshot = findFor(activity, id.headshot);
        verify(puppyImageLoader).bind(theHeadshot, "http://puppies.herokuapp.com/assets/sparky.png");
    }
    
    @Test
    public void itCanShowThePuppyTale() {
        Puppy puppy = new Puppy("Sparky");
        thePuppiesAre(puppy);
        createActivity();
        
        int whichPuppy = 0;
        thePuppies().getOnItemClickListener().onItemClick(null, null, whichPuppy, 0);
        
        final Intent theDetails = StartedMatcher.createIntent(PuppyTaleActivity.class, "thePuppy", new Gson().toJson(puppy));
        StartedMatcher startedDetails = new StartedMatcher(theDetails);
        assertThat(activity, startedDetails);
    }
    
    private void thePuppiesAre(final Puppy...puppies) {
        when(puppiesLoader.load())
            .thenReturn(Arrays.asList(puppies));
    }

    private void createActivity() {
        activity.onCreate(null);
    }

    private ListView thePuppies() {
        final ListView thePuppies = findFor(activity, id.the_puppies_list);
        return thePuppies;
    }

}
